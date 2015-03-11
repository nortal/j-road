package com.nortal.jroad.typegen.xmlbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

import org.apache.xmlbeans.Filer;

import com.nortal.jroad.typegen.FileUtil;

/**
 * Filer implementation for the type generator
 *
 * @author Dmitri.Danilkin
 */
public class SimpleFiler implements Filer {
  private final String outputPath;
  private final String xsbPath;

  public SimpleFiler(String outputPath, String xsbPath) {
    this.outputPath = outputPath;
    this.xsbPath = xsbPath;
  }

  public OutputStream createBinaryFile(String typename) throws IOException {
    File file = new File(xsbPath, typename);
    file.getParentFile().mkdirs();
    file.createNewFile();
    return new FileOutputStream(file);
  }

  public Writer createSourceFile(String typename) throws IOException {
    return FileUtil.createAndGetOutputStream(typename, outputPath);
  }

}
