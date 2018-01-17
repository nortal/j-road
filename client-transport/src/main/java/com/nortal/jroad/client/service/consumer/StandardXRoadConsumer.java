/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.client.service.consumer;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import javax.activation.DataHandler;

import org.apache.commons.lang.exception.NestableRuntimeException;
import org.apache.xmlbeans.XmlObject;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceMessageExtractor;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.client.SoapFaultClientException;

import com.nortal.jroad.client.exception.NonTechnicalFaultException;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.callback.StandardXRoadConsumerCallback;
import com.nortal.jroad.client.service.callback.XRoadMessageCallback;
import com.nortal.jroad.client.service.configuration.XRoadServiceConfiguration;
import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.client.service.extractor.StandardXRoadConsumerMessageExtractor;
import com.nortal.jroad.client.util.WSConsumptionLoggingInterceptor;
import com.nortal.jroad.client.util.XmlBeansUtil;
import com.nortal.jroad.model.XRoadAttachment;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMetadata;
import com.nortal.jroad.util.AttachmentUtil;

/**
 * Standard {@link XRoadConsumer} implementation.
 *
 * @author Dmitri Danilkin
 * @author Roman Tekhov
 * @author Rando Mihkelsaar
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
@Service("xRoadConsumer")
public class StandardXRoadConsumer extends WebServiceGatewaySupport implements XRoadConsumer {
  private Map<String, XmlBeansXRoadMetadata> metadata;
  public static final String ROOT_NS = "ns5";

  @Override
  protected void initGateway() throws Exception {
    metadata = XmlBeansUtil.loadMetadata();

    Collection<ClientInterceptor> interceptors = createInterceptors();
    if (interceptors != null && !interceptors.isEmpty()) {
      setInterceptors(interceptors.toArray(new ClientInterceptor[0]));
    }
    getWebServiceTemplate().setCheckConnectionForFault(false);
  }

  protected Collection<ClientInterceptor> createInterceptors() {
    return Arrays.asList(new ClientInterceptor[] { new WSConsumptionLoggingInterceptor() });
  }

  @Override
  public <I, O> XRoadMessage<O> sendRequest(XRoadMessage<I> input, XRoadServiceConfiguration xroadServiceConfiguration)
      throws XRoadServiceConsumptionException {
    return sendRealRequest(input, xroadServiceConfiguration, null, null);
  }

  @Override
  public <I, O> XRoadMessage<O> sendRequest(XRoadMessage<I> input,
                                            XRoadServiceConfiguration xroadServiceConfiguration,
                                            CustomCallback callback,
                                            CustomExtractor extractor)
      throws XRoadServiceConsumptionException {
    return sendRealRequest(input, xroadServiceConfiguration, callback, extractor);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  private <I, O> XRoadMessage<O> sendRealRequest(XRoadMessage<I> input,
                                                 XRoadServiceConfiguration xroadServiceConfiguration,
                                                 CustomCallback callback,
                                                 CustomExtractor extractor)
      throws XRoadServiceConsumptionException {
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
            input.getAttachments().add(new XRoadAttachment(cid, handler));
          }
        }
      }

      XmlBeansXRoadMetadata curdata = metadata.get(xroadServiceConfiguration.getWsdlDatabase().toLowerCase()
          + xroadServiceConfiguration.getMethod().toLowerCase());

      if (curdata == null) {
        throw new IllegalStateException(String.format("Could not find metadata for %s.%s! Most likely the method name has been specified incorrectly.",
                                                      xroadServiceConfiguration.getWsdlDatabase().toLowerCase(),
                                                      xroadServiceConfiguration.getMethod().toLowerCase()));
      }

      WebServiceMessageCallback originalCallback = getNewConsumerCallback(input, xroadServiceConfiguration, curdata);
      WebServiceMessageExtractor originalExtractor = new StandardXRoadConsumerMessageExtractor(curdata);

      if (callback != null) {
        callback.setOriginalCallback(originalCallback);
      }

      WebServiceMessageCallback finalCallback = callback == null ? originalCallback : callback;

      if (extractor != null) {
        extractor.setOriginalExtractor(originalExtractor);
      }

      WebServiceMessageExtractor finalExtractor = extractor == null ? originalExtractor : extractor;

      return (XRoadMessage<O>) getWebServiceTemplate().sendAndReceive(xroadServiceConfiguration.getSecurityServer(),
                                                                      finalCallback,
                                                                      finalExtractor);
    } catch (Exception e) {
      XRoadServiceConsumptionException consumptionException = resolveException(e, xroadServiceConfiguration);

      if (consumptionException != null) {
        throw consumptionException;
      }
      throw new NestableRuntimeException(e);
    }

  }

  protected <I> StandardXRoadConsumerCallback getNewConsumerCallback(XRoadMessage<I> input,
                                                                     XRoadServiceConfiguration xteeServiceConfiguration,
                                                                     XmlBeansXRoadMetadata curdata) {
    return new StandardXRoadConsumerCallback(input.getContent(),
                                             getNewMessageCallback(input, xteeServiceConfiguration),
                                             curdata);
  }

  protected <I> XRoadMessageCallback getNewMessageCallback(XRoadMessage<I> input,
                                                           XRoadServiceConfiguration xroadServiceConfiguration) {
    return new XRoadMessageCallback(xroadServiceConfiguration, input.getAttachments());
  }

  private XRoadServiceConsumptionException resolveException(Exception e,
                                                            XRoadServiceConfiguration xroadServiceConfiguration) {

    WebServiceIOException ioException = null;
    SoapFaultClientException faultException = null;

    if (e instanceof WebServiceIOException) {
      ioException = (WebServiceIOException) e;
    } else if (e instanceof SoapFaultClientException) {
      faultException = (SoapFaultClientException) e;
    }

    if (ioException != null || faultException != null) {
      String database = xroadServiceConfiguration.getDatabase();
      String method = xroadServiceConfiguration.getMethod();
      String version = xroadServiceConfiguration.getVersion();

      if (ioException != null) {
        if (ioException.getCause() instanceof NonTechnicalFaultException) {
          return new XRoadServiceConsumptionException((NonTechnicalFaultException) ioException.getCause(),
                                                      database,
                                                      method,
                                                      version);
        }

        return new XRoadServiceConsumptionException(ioException, database, method, version);
      }

      if (faultException != null) {
        return new XRoadServiceConsumptionException(faultException, database, method, version);
      }
    }

    return null;
  }
}
