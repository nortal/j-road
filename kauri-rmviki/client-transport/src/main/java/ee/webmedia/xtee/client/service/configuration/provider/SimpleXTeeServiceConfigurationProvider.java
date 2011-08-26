package ee.webmedia.xtee.client.service.configuration.provider;

/**
 * Simple Javabean style configuration provider implementation.
 * 
 * @author Dmitri Danilkin
 */
public class SimpleXTeeServiceConfigurationProvider extends AbstractXTeeServiceConfigurationProvider {

  private String securityServer;
  private String idCode;
  private String institution;
  private String file;
  private boolean useDeprecatedApi = true;

  public void setSecurityServer(String securityServer) {
    this.securityServer = securityServer;
  }

  public void setIdCode(String idCode) {
    this.idCode = idCode;
  }

  public void setInstitution(String institution) {
    this.institution = institution;
  }

  public void setFile(String file) {
    this.file = file;
  }

  @Override
  protected String getSecurityServer(String database, String method, String version) {
    return securityServer;
  }

  @Override
  protected String getIdCode(String database, String method, String version) {
    return idCode;
  }

  @Override
  protected String getInstitution(String database, String method, String version) {
    return institution;
  }

  @Override
  protected String getFile(String database, String method, String version) {
    return file;
  }

  @Override
  protected boolean useDeprecatedApi(String database, String method, String version) {
    return useDeprecatedApi;
  }

  public void setUseDeprecatedApi(boolean useDeprecatedApi) {
    this.useDeprecatedApi = useDeprecatedApi;
  }

}
