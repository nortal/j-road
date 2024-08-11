package com.nortal.jroad.client.lkf;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @author Tatjana Kulikova (tatjana.kulikova@nortal.com)
 * @date 17.02.2011
 */
public class Parser {
	
  private Parser() {  
  }

  public static String parseDateTime(Calendar date) {
    return date == null ? StringUtils.EMPTY : getFormatString(date.getTime());
  }
  
  private static String extractDateTime(String formatString){
    return StringUtils.substringBefore(formatString, "+");
  }
  
  private static String getFormatString(Date date){
    String formatString= DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(date);
    return extractDateTime(formatString);
  }

}
