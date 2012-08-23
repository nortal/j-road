package ee.webmedia.xtee.client.tosjuht;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.client.service.configuration.DelegatingXTeeServiceConfiguration;
import ee.webmedia.xtee.client.service.configuration.XTeeServiceConfiguration;
import ee.webmedia.xtee.model.XTeeMessage;

/**
 * @author Lauri Lättemäe (lauri.lattemaw@webmedia.ee)
 * @date 13.08.2012
 */
public class EpriaXTeeDatabaseService extends XTeeDatabaseService {
  
  protected <I, O> XTeeMessage<O> send(XTeeMessage<I> input, String method, String version, final String idCode, final String securityServer) throws XTeeServiceConsumptionException {
    final XTeeServiceConfiguration xteeConfiguration = xTeeServiceConfigurationProvider.createConfiguration(getDatabase(), getDatabase(), method, version);
    
    DelegatingXTeeServiceConfiguration configuration = new DelegatingXTeeServiceConfiguration(xteeConfiguration) {
      @Override
      public String getIdCode() {
        return idCode != null ? idCode : super.getIdCode();
      }
      @Override
      public String getSecurityServer(){
        return securityServer != null ? securityServer : super.getSecurityServer();
      }
    };
    
    XTeeMessage<O> result = xTeeConsumer.sendRequest(input, configuration);
    return result;
  }
}
