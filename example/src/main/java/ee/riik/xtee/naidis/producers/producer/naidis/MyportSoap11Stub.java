/**
 * MyportSoap11Stub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ee.riik.xtee.naidis.producers.producer.naidis;

public class MyportSoap11Stub extends org.apache.axis.client.Stub implements ee.riik.xtee.naidis.producers.producer.naidis.Myport {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[2];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AttachmentEcho");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "keha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "AttachmentEchoRequest"), ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoRequest.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "paring"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "AttachmentEchoRequest"), ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoRequest.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "keha"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "AttachmentEchoResponse"), ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoResponse.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Echo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "keha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "EchoRequest"), ee.riik.xtee.naidis.producers.producer.naidis.EchoRequest.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "paring"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "EchoRequest"), ee.riik.xtee.naidis.producers.producer.naidis.EchoRequest.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "keha"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "EchoResponse"), ee.riik.xtee.naidis.producers.producer.naidis.EchoResponse.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

    }

    public MyportSoap11Stub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public MyportSoap11Stub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public MyportSoap11Stub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "AttachmentEchoNest");
            cachedSerQNames.add(qName);
            cls = ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoNest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "AttachmentEchoRequest");
            cachedSerQNames.add(qName);
            cls = ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "AttachmentEchoResponse");
            cachedSerQNames.add(qName);
            cls = ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "EchoRequest");
            cachedSerQNames.add(qName);
            cls = ee.riik.xtee.naidis.producers.producer.naidis.EchoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "EchoResponse");
            cachedSerQNames.add(qName);
            cls = ee.riik.xtee.naidis.producers.producer.naidis.EchoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws-i.org/profiles/basic/1.1/xsd", "swaRef");
            cachedSerQNames.add(qName);
            cls = org.apache.axis.types.URI.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public void attachmentEcho(ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoRequest keha, ee.riik.xtee.naidis.producers.producer.naidis.holders.AttachmentEchoRequestHolder paring, ee.riik.xtee.naidis.producers.producer.naidis.holders.AttachmentEchoResponseHolder keha2) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "AttachmentEcho"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {keha});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                paring.value = (ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoRequest) _output.get(new javax.xml.namespace.QName("", "paring"));
            } catch (java.lang.Exception _exception) {
                paring.value = (ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoRequest) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "paring")), ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoRequest.class);
            }
            try {
                keha2.value = (ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoResponse) _output.get(new javax.xml.namespace.QName("", "keha"));
            } catch (java.lang.Exception _exception) {
                keha2.value = (ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoResponse) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "keha")), ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void echo(ee.riik.xtee.naidis.producers.producer.naidis.EchoRequest keha, ee.riik.xtee.naidis.producers.producer.naidis.holders.EchoRequestHolder paring, ee.riik.xtee.naidis.producers.producer.naidis.holders.EchoResponseHolder keha2) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "Echo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {keha});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                paring.value = (ee.riik.xtee.naidis.producers.producer.naidis.EchoRequest) _output.get(new javax.xml.namespace.QName("", "paring"));
            } catch (java.lang.Exception _exception) {
                paring.value = (ee.riik.xtee.naidis.producers.producer.naidis.EchoRequest) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "paring")), ee.riik.xtee.naidis.producers.producer.naidis.EchoRequest.class);
            }
            try {
                keha2.value = (ee.riik.xtee.naidis.producers.producer.naidis.EchoResponse) _output.get(new javax.xml.namespace.QName("", "keha"));
            } catch (java.lang.Exception _exception) {
                keha2.value = (ee.riik.xtee.naidis.producers.producer.naidis.EchoResponse) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "keha")), ee.riik.xtee.naidis.producers.producer.naidis.EchoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
