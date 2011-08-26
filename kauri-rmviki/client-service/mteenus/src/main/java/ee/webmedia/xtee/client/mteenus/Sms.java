package ee.webmedia.xtee.client.mteenus;

/**
 * Dataholder for SMS message
 * 
 * @author Aleksandr.Koltakov
 */
public class Sms {

  private String teenusId;
  private String isikukood;
  private String saatjaNumber;
  private String sisu;
  private boolean kinnitus;
  private boolean saadaWap;

  public String getTeenusId() {
    return teenusId;
  }

  public void setTeenusId(String teenusId) {
    this.teenusId = teenusId;
  }

  public String getIsikukood() {
    return isikukood;
  }

  public void setIsikukood(String isikukood) {
    this.isikukood = isikukood;
  }

  public String getSaatjaNumber() {
    return saatjaNumber;
  }

  public void setSaatjaNumber(String saatjaNumber) {
    this.saatjaNumber = saatjaNumber;
  }

  public String getSisu() {
    return sisu;
  }

  public void setSisu(String sisu) {
    this.sisu = sisu;
  }

  public boolean isKinnitus() {
    return kinnitus;
  }

  public void setKinnitus(boolean kinnitus) {
    this.kinnitus = kinnitus;
  }

  public boolean isSaadaWap() {
    return saadaWap;
  }

  public void setSaadaWap(boolean saadaWap) {
    this.saadaWap = saadaWap;
  }

}
