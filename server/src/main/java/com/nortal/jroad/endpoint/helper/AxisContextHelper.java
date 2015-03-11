package com.nortal.jroad.endpoint.helper;

import java.lang.reflect.Method;

import javax.xml.rpc.Service;

import org.apache.axis.MessageContext;
import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;
import org.springframework.beans.factory.InitializingBean;

/**
 * Plumbing to make axis marshalling work.
 * 
 * @author Dmitri Danilkin
 */
public class AxisContextHelper implements InitializingBean {
  private final Class<? extends Stub> stubClass;
  private MessageContext messageContext;

  public AxisContextHelper(Class<? extends Stub> stubClass) {
    this.stubClass = stubClass;
  }

  public void afterPropertiesSet() throws Exception {
    Stub stub = stubClass.getConstructor(Service.class).newInstance(new Object[] { null });
    for (Method m : stub.getClass().getDeclaredMethods()) {
      if (m.getName().equals("createCall")) {
        m.setAccessible(true);
        messageContext = ((Call) m.invoke(stub)).getMessageContext();
        break;
      }
    }
    if (messageContext == null) {
      throw new IllegalStateException("Could not find the createCall() method in the stub supplied!");
    }
  }

  public MessageContext getMessageContext() {
    return messageContext;
  }
}