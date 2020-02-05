# xtee-client-rr

## notes
* rr.RR81KMAisikkontroll.v1 operations and types have manually been removed from this module's WSDL because of an anomalous ClassCastException that would otherwise be thrown when calling rr.RR81KMAisikkontroll.v2 from the rrv5 module. 
* rr.RR436InnerResponseType has to be manually added to rr.wsdl when updating it along with definition and import of SOAP-ENC namespace (http://schemas.xmlsoap.org/soap/encoding/)