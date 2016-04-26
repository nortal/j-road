package com.nortal.jroad.endpoint.v4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import org.apache.axis.Message;
import org.springframework.xml.transform.StringResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.nortal.jroad.endpoint.helper.AxisContextHelper;
import com.nortal.jroad.model.BeanXTeeMessage;
import com.nortal.jroad.model.XTeeAttachment;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.util.AxisUtil;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public abstract class AbstractXRoadAxisEndpoint<P, V> extends AbstractXRoadBaseEndpoint {

  private Class<P> requestClass;

  @Resource(name = "axisContextHelper")
  private AxisContextHelper contextHelper;

  @Override
  @SuppressWarnings("unchecked")
  protected void invokeInternalEx(XTeeMessage<Document> request,
                                  XTeeMessage<Element> response,
                                  SOAPMessage requestMessage,
                                  SOAPMessage responseMessage) throws Exception {
    requestMessage.getSOAPHeader().detachNode();
    Node bodyNode = requestMessage.getSOAPBody();
    Node reqNode = bodyNode.getParentNode();
    NodeList nl = bodyNode.getChildNodes();
    for (int i = 0; i < nl.getLength(); i++) {
      Node curNode = nl.item(i);
      reqNode.appendChild(curNode.cloneNode(true));
    }
    reqNode.removeChild(bodyNode);

    // Since Axis needs the XML as a String a transformation is required.
    StringResult result = new StringResult();
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    transformer.transform(new DOMSource(requestMessage.getSOAPPart().getEnvelope()), result);

    Message axisMessage = new Message(result.toString());
    // The context is very important, as the binding stub creates all the type bindings for proper unmarshalling.
    axisMessage.setMessageContext(getContextHelper().getMessageContext());

    // Adding the attachments is needed to handle "href" attributes where the data is in an attachment.
    for (Iterator<AttachmentPart> i = requestMessage.getAttachments(); i.hasNext();) {
      axisMessage.addAttachmentPart(i.next());
    }

    XTeeMessage<P> axisRequestMessage = new BeanXTeeMessage<P>(request.getHeader(),
                                                               (P) axisMessage.getSOAPEnvelope().getFirstBody().getObjectValue(getRequestClass()),
                                                               request.getAttachments());
    XTeeMessage<V> axisResponseMessage =
        new BeanXTeeMessage<V>(response.getHeader(), null, new ArrayList<XTeeAttachment>());

    invoke(axisRequestMessage, axisResponseMessage);

    V responseBean = axisResponseMessage.getContent();
    // If response is null we return <keha/>, otherwise some marshalling needs to be done.
    if (responseBean != null) {
      String responseXml = AxisUtil.serialize(responseBean);
      Document doc =
          DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(responseXml.getBytes("UTF-8")));
      Node parent = response.getContent().getParentNode();
      parent.removeChild(response.getContent());
      parent.appendChild(parent.getOwnerDocument().importNode(doc.getFirstChild(), true));
    }
  }

  /**
   * Overridde this method if you require access to the header or attachments
   * 
   * @param request
   * @param response
   * @throws Exception
   */
  protected void invoke(XTeeMessage<P> request, XTeeMessage<V> response) throws Exception {
    response.setContent(invokeBean(request.getContent()));
  }

  /**
   * Override this method if you only require access to the message contents
   * 
   * @param requestBean
   * @return an object, which can be serialized by Axis
   * @throws IOException
   */
  protected V invokeBean(P requestBean) throws IOException {
    throw new IllegalStateException("You must override either the 'invokeBean' or the 'invoke' method!");
  }

  public AxisContextHelper getContextHelper() {
    return contextHelper;
  }

  public void setContextHelper(AxisContextHelper contextHelper) {
    this.contextHelper = contextHelper;
  }

  public Class<P> getRequestClass() {
    return requestClass;
  }

  public void setRequestClass(Class<P> requestClass) {
    this.requestClass = requestClass;
  }
}
