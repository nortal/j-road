package com.nortal.jroad.typegen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Adds fields for swaref attachments.
 * 
 * @author Dmitri Danilkin
 */
public class AttachmentPostprocessor {
  private static String pck;

  public static void process(String basepackage, File... files) throws Exception {
    pck = basepackage == null ? "" : basepackage + ".";
    process(files);
  }

  private static void process(File... files) throws Exception {
    for (File file : files) {
      if (file.isDirectory()) {
        process(file.listFiles());
      } else if (file.getAbsolutePath().endsWith(".java")) {
        annotate(file);
      }
    }
  }

  private static String readFile(File file) throws Exception {
    FileChannel chan = new FileInputStream(file).getChannel();
    ByteBuffer buf = ByteBuffer.allocate((int) chan.size());
    chan.read(buf);
    chan.close();
    buf.rewind();
    return Charset.forName("UTF-8").newDecoder().decode(buf).toString();
  }

  private static void writeFile(File file, String data) throws Exception {
    if (file.exists()) {
      file.delete();
    }
    file.createNewFile();
    FileChannel chan = new FileOutputStream(file).getChannel();
    CharBuffer cbuf = CharBuffer.allocate(data.length()).put(data);
    cbuf.rewind();
    ByteBuffer buf = Charset.forName("UTF-8").newEncoder().encode(cbuf);
    buf.rewind();
    chan.write(buf);
    chan.close();
  }

  private static void annotate(File file) throws Exception {
    String source = readFile(file);

    if (source.contains(pck + "org.ws_i.profiles.basic.x11.xsd.SwaRef xget")) {
      StringBuilder sb = new StringBuilder();
      Matcher m =
          Pattern.compile("(?:public)? " + pck.replace(".", "\\.")
              + "org\\.ws_i\\.profiles\\.basic\\.x11\\.xsd\\.SwaRef xget(.+?)\\(\\)").matcher(source);
      int lastPos = 0;
      while (m.find()) {
        sb.append(source.substring(lastPos, m.start()));
        lastPos = m.start();
        sb.append("\n");
        if (file.getName().endsWith("Impl.java")) {
          String varname = m.group(1).substring(0, 1).toLowerCase() + m.group(1).substring(1) + "Handler";
          sb.append("private javax.activation.DataHandler ");
          sb.append(varname);
          sb.append(";\n");
          sb.append("public javax.activation.DataHandler get");
          sb.append(m.group(1));
          sb.append("Handler() {return this.");
          sb.append(varname);
          sb.append(";}\n");
          sb.append("public void set");
          sb.append(m.group(1));
          sb.append("Handler(javax.activation.DataHandler handler) {this.");
          sb.append(varname);
          sb.append("= handler;}\n");
        } else {
          sb.append("javax.activation.DataHandler get");
          sb.append(m.group(1));
          sb.append("Handler();\n");
          sb.append("void set");
          sb.append(m.group(1));
          sb.append("Handler(javax.activation.DataHandler handler);\n");
        }
      }
      sb.append(source.substring(lastPos));
      System.out.println("Instrumented " + file.getName() + " with attachment support.");
      writeFile(new File(file.getAbsolutePath()), sb.toString());
    }
  }
}
