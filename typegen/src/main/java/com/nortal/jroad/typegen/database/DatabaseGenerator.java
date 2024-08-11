package com.nortal.jroad.typegen.database;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.nortal.jroad.typegen.FileUtil;
import com.nortal.jroad.typegen.TypeGen;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author Roman Tekhov
 */
public class DatabaseGenerator {

  private static final String DATABASE_TEMPLATE_FILE = "DatabaseTemplate.txt";
  private static final String DATABASE_IMPL_TEMPLATE_FILE = "DatabaseImplTemplate.txt";


  public static void generate(DatabaseClasses classes, String outputdir) throws IOException {
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_19);
    cfg.setClassForTemplateLoading(TypeGen.class, "/");
    cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_19));

    Template interfaceTemp = cfg.getTemplate(DATABASE_TEMPLATE_FILE);
    Template implTemp = cfg.getTemplate(DATABASE_IMPL_TEMPLATE_FILE);

    for (DatabaseClass databaseClass : classes.getClasses().values()) {
      Map<String, DatabaseClass> root = new HashMap<>();
      root.put("databaseClass", databaseClass);

      FileUtil.wrapAroundResource(
        writer -> interfaceTemp.process(root, writer),
        databaseClass.getQualifiedInterfaceName(),
        outputdir
      );
      FileUtil.wrapAroundResource(
        writer -> implTemp.process(root, writer),
        databaseClass.getQualifiedImplementationName(),
        outputdir
      );
    }
  }

}
