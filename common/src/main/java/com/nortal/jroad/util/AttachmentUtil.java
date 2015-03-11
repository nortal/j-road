package com.nortal.jroad.util;

import java.util.UUID;

/**
 * Utility class for attachments
 * 
 * @author Dmitri Danilkin
 */
public class AttachmentUtil {
  private static long salt = 0;

  public static String getUniqueCid() {
    salt++;
    return UUID.randomUUID().toString() + String.valueOf(salt);
  }

}
