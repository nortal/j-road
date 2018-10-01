package com.nortal.jroad.util;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XRoadSchemaUtil {
  private XRoadSchemaUtil() {
  }

  public static Schema getSchemaFromContext(Class clazz) throws JAXBException, IOException, SAXException {
    JAXBContext jc = JAXBContext.newInstance(clazz);
    final List<ByteArrayOutputStream> outs = new ArrayList<ByteArrayOutputStream>();
    jc.generateSchema(new SchemaOutputResolver() {
      @Override
      public Result createOutput(String namespaceUri,
                                 String suggestedFileName) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        outs.add(out);
        StreamResult streamResult = new StreamResult(out);
        streamResult.setSystemId("");
        return streamResult;
      }
    });
    StreamSource[] sources = new StreamSource[outs.size()];
    for (int i = 0; i < outs.size(); i++) {
      ByteArrayOutputStream out = outs.get(i);
      sources[i] = new StreamSource(new ByteArrayInputStream(out.toByteArray()), "");
    }
    SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    return sf.newSchema(sources);
  }
}
