package com.nortal.jroad.typegen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

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

  public static void wrapAroundResource(FileAction action, String typename, String outputPath) throws IOException {
    if (typename.indexOf('$') > 0) {
      System.out.println(typename);
      typename = typename.substring(0, typename.lastIndexOf('.')) + "." + typename.substring(typename.indexOf('$') + 1);
    }
    Path path = Path.of(outputPath, typename.replace('.', File.separatorChar) + ".java");
    Files.createDirectories(path.getParent());
    try (var writer = Files.newBufferedWriter(path)) {
      action.run(writer);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @FunctionalInterface
  public interface FileAction {
    void run(Writer writer) throws Exception;
  }
}
