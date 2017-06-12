package com.nortal.jroad.client.lkfv6;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.FastDateFormat;


public class Parser {

  private static final FastDateFormat DATETIME_WITHOUT_SECONDS_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd\'T\'HH:mm");
	
  private Parser() {  
  }

  public static String parseDateTime(Calendar date) {
    return date == null ? StringUtils.EMPTY : getFormatString(date.getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT);
  }

  public static String parseDateTimeWithouthSeconds(Calendar date) {
    return date == null ? StringUtils.EMPTY : getFormatString(date.getTime(), DATETIME_WITHOUT_SECONDS_FORMAT);
  }
  
  private static String extractDateTime(String formatString){
    return StringUtils.substringBefore(formatString, "+");
  }
  
  private static String getFormatString(Date date, FastDateFormat format){
    String formatString = format.format(date);
    return extractDateTime(formatString);
  }

}
