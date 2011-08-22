package ee.webmedia.xtee.client.teavituskalender;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

/**
 * @author Aleksandr.Koltakov
 */
public class Parser {

  private Parser() {
  }

  public static String parseDateTime(Calendar calendar) {
    return calendar == null ? StringUtils.EMPTY : new SimpleDateFormat("yyyy-MM-dd HH:mm").format(calendar.getTime());
  }

  public static String parseDate(Calendar calendar) {
    return calendar == null ? StringUtils.EMPTY : new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
  }

}
