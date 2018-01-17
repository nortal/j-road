package com.nortal.jroad.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;

import com.nortal.jroad.model.XmlBeansXRoadMetadata;

/**
 * XMLBeans related utilities.
 * 
 * @author Roman Tekhov
 * @author Dmitri Danilkin
 */
public class XmlBeansUtil {

  /**
   * Builds a new {@link XmlString} instance holding the given <code>String</code> value. The instance will also have an
   * attribute with <code>xsi:type</code> name (where <code>xsi</code> represent a prefix for
   * <code>http://www.w3.org/2001/XMLSchema-instance</code> namespace) and a <code>xsd:string</code> value (where
   * <code>xsd</code> represents a prefix for <code>http://www.w3.org/2001/XMLSchema</code> namespace).
   * 
   * @param value content value
   * @return constructed {@link XmlString} instance
   */
  public static XmlString getAttributedXmlString(String value) {
    XmlString xmlString = XmlString.Factory.newInstance();
    xmlString.setStringValue(value);

    XmlCursor cursor = xmlString.newCursor();
    cursor.toNextToken();
    cursor.insertNamespace("xsd", "http://www.w3.org/2001/XMLSchema");
    cursor.insertAttributeWithValue(new QName("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi"),
                                    "xsd:string");

    return xmlString;
  }

  @SuppressWarnings("unchecked")
  public static HashMap<String, XmlBeansXRoadMetadata> loadMetadata() throws IOException, ClassNotFoundException {
    HashMap<String, XmlBeansXRoadMetadata> metaMap = new HashMap<String, XmlBeansXRoadMetadata>();

    for (Enumeration<URL> metaUrls =
        Thread.currentThread().getContextClassLoader().getResources("xroad.metadata"); metaUrls.hasMoreElements();) {
      URL metaUrl = metaUrls.nextElement();
      InputStream is = metaUrl.openStream();
      ObjectInputStream ois = new ObjectInputStream(is);
      metaMap.putAll((HashMap<String, XmlBeansXRoadMetadata>) ois.readObject());
      ois.close();
      is.close();
    }

    return metaMap;
  }

  public static XmlObject getResponseObject(XmlObject obj)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    if (obj.schemaType().isDocumentType()) {
      for (Method method : obj.getClass().getDeclaredMethods()) {
        if (XmlObject.class.isAssignableFrom(method.getReturnType()) && method.getName().startsWith("get")
            && method.getParameterTypes().length == 0) {
          obj = (XmlObject) method.invoke(obj, new Object[] {});
          break;
        }
      }
    }
    return obj;
  }

  public static Set<XmlObject> getAllObjects(XmlObject obj)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    Set<XmlObject> objs = new HashSet<XmlObject>();
    if (obj != null) {
      objs.add(obj);
      for (Method method : obj.getClass().getDeclaredMethods()) {
        if (XmlObject.class.isAssignableFrom(method.getReturnType()) && method.getName().startsWith("get")
            && method.getParameterTypes().length == 0) {
          objs.addAll(getAllObjects((XmlObject) method.invoke(obj, new Object[] {})));
        }
      }
    }
    return objs;
  }

  public static List<Method> getSwaRefGetters(XmlObject obj) {
    List<Method> methods = new ArrayList<Method>();
    for (Method method : obj.getClass().getDeclaredMethods()) {
      if (DataHandler.class.equals(method.getReturnType()) && method.getName().startsWith("get")
          && method.getName().endsWith("Handler")) {
        methods.add(method);
      }
    }
    return methods;
  }

  public static List<Method> getSwaRefSetters(XmlObject obj) {
    List<Method> methods = new ArrayList<Method>();
    for (Method method : obj.getClass().getDeclaredMethods()) {
      if (method.getParameterTypes().length > 0 && DataHandler.class.equals(method.getParameterTypes()[0])
          && method.getName().startsWith("set") && method.getName().endsWith("Handler")) {
        methods.add(method);
      }
    }
    return methods;
  }

  public static String getFieldName(Method handlerMethod) {
    return handlerMethod.getName().substring(3, handlerMethod.getName().length() - 7);
  }

  public static String getCid(XmlObject obj, String field) throws Exception {
    return (String) obj.getClass().getMethod("get" + field).invoke(obj);
  }

  public static void setCid(XmlObject obj, String field, String cid) throws Exception {
    obj.getClass().getMethod("set" + field, String.class).invoke(obj, cid);
  }
}
