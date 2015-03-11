package com.nortal.jroad.typegen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @author Roman Tekhov
 */
public class FileUtil {
  public static Writer createAndGetOutputStream(String typename, String outputPath) throws IOException {
    if (typename.indexOf('$') > 0) {
      System.out.println(typename);
      typename = typename.substring(0, typename.lastIndexOf('.')) + "." + typename.substring(typename.indexOf('$') + 1);
    }
    File file = new File(outputPath, typename.replace('.', File.separatorChar) + ".java");
    file.getParentFile().mkdirs();
    file.createNewFile();
    OutputStream os = new FileOutputStream(file);
    return new OutputStreamWriter(os, Charset.forName("UTF-8"));
  }
  
  public static byte[] getBytes(File file) throws FileNotFoundException, IOException {
    ByteBuffer buf = ByteBuffer.allocate((int) file.length());
    FileInputStream fis = new FileInputStream(file);
    fis.getChannel().read(buf);
    fis.close();
    return buf.array();
  }
}
