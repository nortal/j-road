package ee.webmedia.xtee.util;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.namespace.QName;

import org.apache.axis.AxisEngine;
import org.apache.axis.MessageContext;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.SerializationContext;
import org.apache.axis.encoding.TypeMappingRegistryImpl;
import org.apache.axis.encoding.ser.BeanSerializer;
import org.xml.sax.helpers.AttributesImpl;

/**
 * Axis utility class used for serialization of Axis objects.
 * 
 * @author Dmitri Danilkin
 */
public class AxisUtil {
  public static String serialize(Object obj) throws IOException {
    TypeDesc desc = TypeDesc.getTypeDescForClass(obj.getClass());
    BeanSerializer serializer = new BeanSerializer(obj.getClass(), desc.getXmlType(), desc);

    MessageContext mctx = new MessageContext(null);
    mctx.setProperty(AxisEngine.PROP_ENABLE_NAMESPACE_PREFIX_OPTIMIZATION, true);
    mctx.setProperty(AxisEngine.PROP_SEND_XSI, true);
    mctx.setTypeMappingRegistry(new TypeMappingRegistryImpl());

    StringWriter writer = new StringWriter();

    SerializationContext ctx = new SerializationContext(writer, mctx);
    ctx.setPretty(false);
    ctx.setSendDecl(true);
    ctx.setDoMultiRefs(false);

    serializer.serialize(new QName("keha"), new AttributesImpl(), obj, ctx);
    return writer.getBuffer().toString();
  }

}
