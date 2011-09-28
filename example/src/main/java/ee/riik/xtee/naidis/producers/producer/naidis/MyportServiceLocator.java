/**
 * MyportServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ee.riik.xtee.naidis.producers.producer.naidis;

public class MyportServiceLocator extends org.apache.axis.client.Service implements ee.riik.xtee.naidis.producers.producer.naidis.MyportService {

    public MyportServiceLocator() {
    }


    public MyportServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MyportServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for myportSoap11
    private java.lang.String myportSoap11_address = "http://TURVASERVER/cgi-bin/consumer_proxy";

    public java.lang.String getmyportSoap11Address() {
        return myportSoap11_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String myportSoap11WSDDServiceName = "myportSoap11";

    public java.lang.String getmyportSoap11WSDDServiceName() {
        return myportSoap11WSDDServiceName;
    }

    public void setmyportSoap11WSDDServiceName(java.lang.String name) {
        myportSoap11WSDDServiceName = name;
    }

    public ee.riik.xtee.naidis.producers.producer.naidis.Myport getmyportSoap11() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(myportSoap11_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getmyportSoap11(endpoint);
    }

    public ee.riik.xtee.naidis.producers.producer.naidis.Myport getmyportSoap11(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ee.riik.xtee.naidis.producers.producer.naidis.MyportSoap11Stub _stub = new ee.riik.xtee.naidis.producers.producer.naidis.MyportSoap11Stub(portAddress, this);
            _stub.setPortName(getmyportSoap11WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setmyportSoap11EndpointAddress(java.lang.String address) {
        myportSoap11_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ee.riik.xtee.naidis.producers.producer.naidis.Myport.class.isAssignableFrom(serviceEndpointInterface)) {
                ee.riik.xtee.naidis.producers.producer.naidis.MyportSoap11Stub _stub = new ee.riik.xtee.naidis.producers.producer.naidis.MyportSoap11Stub(new java.net.URL(myportSoap11_address), this);
                _stub.setPortName(getmyportSoap11WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("myportSoap11".equals(inputPortName)) {
            return getmyportSoap11();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "myportService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis", "myportSoap11"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("myportSoap11".equals(portName)) {
            setmyportSoap11EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
