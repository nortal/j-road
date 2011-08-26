/**
 * Copyright 2009 Webmedia Group Ltd. Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package ee.webmedia.xtee.client.service.consumer;

import java.lang.reflect.Method;
import java.util.Map;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;

import org.apache.commons.lang.exception.NestableRuntimeException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceMessageExtractor;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.client.SoapFaultClientException;

import ee.webmedia.xtee.client.exception.NonTechnicalFaultException;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.callback.CustomCallback;
import ee.webmedia.xtee.client.service.callback.StandardXTeeConsumerCallback;
import ee.webmedia.xtee.client.service.callback.XTeeMessageCallback;
import ee.webmedia.xtee.client.service.configuration.XTeeServiceConfiguration;
import ee.webmedia.xtee.client.service.extractor.CustomExtractor;
import ee.webmedia.xtee.client.service.extractor.StandardXTeeConsumerMessageExtractor;
import ee.webmedia.xtee.client.util.WSConsumptionLoggingInterceptor;
import ee.webmedia.xtee.client.util.XmlBeansUtil;
import ee.webmedia.xtee.model.XTeeAttachment;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMetadata;
import ee.webmedia.xtee.util.AttachmentUtil;

/**
 * Standard {@link XTeeConsumer} implementation.
 * 
 * @author Dmitri Danilkin
 * @author Roman Tekhov
 * @author Rando Mihkelsaar
 */
@Service("xTeeConsumer")
public class StandardXTeeConsumer extends WebServiceGatewaySupport implements XTeeConsumer {
  private Map<String, XmlBeansXTeeMetadata> metadata;
  public static final String ROOT_NS = "ns5";

  @Override
  protected void initGateway() throws Exception {
    XmlBeansMarshaller marshaller = new XmlBeansMarshaller();
    metadata = XmlBeansUtil.loadMetadata();

    setMarshaller(marshaller);
    setUnmarshaller(marshaller);

    ClientInterceptor[] interceptors = new ClientInterceptor[] { new WSConsumptionLoggingInterceptor() };
    setInterceptors(interceptors);

    getWebServiceTemplate().setCheckConnectionForFault(false);
  }

  public <I, O> XTeeMessage<O> sendRequest(XTeeMessage<I> input, XTeeServiceConfiguration xTeeServiceConfiguration)
      throws XTeeServiceConsumptionException {
    return sendRealRequest(input, xTeeServiceConfiguration, null, null);
  }

  public <I, O> XTeeMessage<O> sendRequest(XTeeMessage<I> input,
                                           XTeeServiceConfiguration xTeeServiceConfiguration,
                                           CustomCallback callback,
                                           CustomExtractor extractor) throws XTeeServiceConsumptionException {
    return sendRealRequest(input, xTeeServiceConfiguration, callback, extractor);
  }

  @SuppressWarnings("unchecked")
  private <I, O> XTeeMessage<O> sendRealRequest(XTeeMessage<I> input,
                                                XTeeServiceConfiguration xteeServiceConfiguration,
                                                CustomCallback callback,
                                                CustomExtractor extractor) throws XTeeServiceConsumptionException {

    XmlOptions options =
        ((XmlBeansMarshaller) getMarshaller()).getXmlOptions() == null
                                                                      ? new XmlOptions()
                                                                      : ((XmlBeansMarshaller) getMarshaller()).getXmlOptions();
    options.setSaveSyntheticDocumentElement(new QName("keha"));
    ((XmlBeansMarshaller) getMarshaller()).setXmlOptions(options);

    try {
      // Add any swaref attachments...
      // First find all Objects.
      for (XmlObject attachmentObj : XmlBeansUtil.getAllObjects((XmlObject) input.getContent())) {

        // Introspect all methods, and find the ones that were generated during instrumentation
        for (Method method : XmlBeansUtil.getSwaRefGetters(attachmentObj)) {
          // Get the datahandler for the attachment
          DataHandler handler = (DataHandler) method.invoke(attachmentObj);

          if (handler != null) {
            String field = XmlBeansUtil.getFieldName(method);
            // Check whether the user has set a custom CID, if not, generate a random one and set it
            String cid = XmlBeansUtil.getCid(attachmentObj, field);
            if (cid == null) {
              cid = AttachmentUtil.getUniqueCid();
            } else {
              cid = cid.startsWith("cid:") ? cid.substring(4) : cid;
            }
            XmlBeansUtil.setCid(attachmentObj, field, "cid:" + cid);

            // Add a new attachment to the list
            input.getAttachments().add(new XTeeAttachment(cid, handler));
          }
        }
      }

      XmlBeansXTeeMetadata curdata =
          metadata.get(xteeServiceConfiguration.getWsdlDatabase().toLowerCase()
              + xteeServiceConfiguration.getMethod().toLowerCase());
      
      if (curdata == null) {
        throw new IllegalStateException(String.format("Could not find metadata for %s.%s! Most likely the method name has been specified incorrectly.",
                                                      xteeServiceConfiguration.getWsdlDatabase().toLowerCase(),
                                                      xteeServiceConfiguration.getMethod().toLowerCase()));
      }
      
      WebServiceMessageCallback originalCallback =
          new StandardXTeeConsumerCallback(input.getContent(),
                                           new XTeeMessageCallback(xteeServiceConfiguration, input.getAttachments()),
                                           getMarshaller(),
                                           curdata);
      WebServiceMessageExtractor originalExtractor = new StandardXTeeConsumerMessageExtractor(curdata);

      if (callback != null) {
        callback.setOriginalCallback(originalCallback);
      }

      WebServiceMessageCallback finalCallback = callback == null ? originalCallback : callback;

      if (extractor != null) {
        extractor.setOriginalExtractor(originalExtractor);
      }

      WebServiceMessageExtractor finalExtractor = extractor == null ? originalExtractor : extractor;

      return (XTeeMessage<O>) getWebServiceTemplate().sendAndReceive(xteeServiceConfiguration.getSecurityServer(),
                                                                     finalCallback,
                                                                     finalExtractor);
    } catch (Exception e) {
      XTeeServiceConsumptionException consumptionException = resolveException(e, xteeServiceConfiguration);

      if (consumptionException != null) {
        throw consumptionException;
      }
      throw new NestableRuntimeException(e);
    }

  }

  private XTeeServiceConsumptionException resolveException(Exception e,
                                                           XTeeServiceConfiguration xteeServiceConfiguration) {

    WebServiceIOException ioException = null;
    SoapFaultClientException faultException = null;

    if (e instanceof WebServiceIOException) {
      ioException = (WebServiceIOException) e;
    } else if (e instanceof SoapFaultClientException) {
      faultException = (SoapFaultClientException) e;
    }

    if (ioException != null || faultException != null) {
      String database = xteeServiceConfiguration.getDatabase();
      String method = xteeServiceConfiguration.getMethod();
      String version = xteeServiceConfiguration.getVersion();

      if (ioException != null) {
        if (ioException.getCause() instanceof NonTechnicalFaultException) {
          return new XTeeServiceConsumptionException((NonTechnicalFaultException) ioException.getCause(),
                                                     database,
                                                     method,
                                                     version);
        }

        return new XTeeServiceConsumptionException(ioException, database, method, version);
      }

      if (faultException != null) {
        return new XTeeServiceConsumptionException(faultException, database, method, version);
      }
    }

    return null;
  }
}
