package com.nortal.jroad.typegen;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.System.lineSeparator;
import static java.util.regex.Pattern.quote;

/**
 * Adds fields for swaref attachments.
 *
 * @author Dmitri Danilkin
 */
public class AttachmentPostProcessor {
  private static final Expression IMPLEMENTATION_TEMPLATE = precompileTemplate("""
          private jakarta.activation.DataHandler #{#field};
          public jakarta.activation.DataHandler get#{#propertyName}Handler() {
            return this.#{#field};
          }
          public void set#{#propertyName}Handler(jakarta.activation.DataHandler handler) {
            this.#{#field} = handler;
          }
          """
  );
  private static final Expression DECLARATION_TEMPLATE = precompileTemplate("""
        jakarta.activation.DataHandler get#{#propertyName}Handler();
        void set#{#propertyName}Handler(jakarta.activation.DataHandler handler);
        """
  );
  private static final String OPTIONAL_PUBLIC_MODIFIER = "(?:public)?";
  private static final String SPACE = " +";
  private static final String SWAREF_TYPE = quote("org.ws_i.profiles.basic.x11.xsd.SwaRef");
  private static final String X_GET_PATTERN = "xget(.+?)";
  private static final String PARAMETER_LIST = quote("()");

  private final String pck;
  private final Pattern attachmentTemplate;

  public static void process(String basePackageName, Path basePackage) throws IOException {
    new AttachmentPostProcessor(basePackageName).process(basePackage);
  }

  private AttachmentPostProcessor(String basepackage) {
    this.pck = basepackage == null ? "" : basepackage + ".";
    String packagePrefix = quote(pck);
    this.attachmentTemplate = Pattern.compile(
      OPTIONAL_PUBLIC_MODIFIER + SPACE + packagePrefix + SWAREF_TYPE + SPACE + X_GET_PATTERN + PARAMETER_LIST
    );
  }

  private void process(Path basePackage) throws IOException {
    try (Stream<Path> paths = Files.find(
      basePackage, Integer.MAX_VALUE,
      (path, attributes) -> attributes.isRegularFile() && path.toString().endsWith(".java"))
    ) {
      for (Path path : paths.toList()) {
        annotate(path);
      }
    }
  }

  private void annotate(Path path) throws IOException {
    String source = Files.readString(path);
    if (!source.contains(pck + "org.ws_i.profiles.basic.x11.xsd.SwaRef xget")) {
      return;
    }
    StringBuilder sb = new StringBuilder();
    Matcher m = attachmentTemplate.matcher(source);
    int lastPos = 0;
    while (m.find()) {
      sb.append(source, lastPos, m.start());
      lastPos = m.start();
      sb.append(lineSeparator());
      String propertyName = m.group(1);
      if (path.toString().endsWith("Impl.java")) {
        String field = decapitalise(propertyName) + "Handler";
        EvaluationContext context = createEvaluationContext(Map.of(
          "propertyName", propertyName,
          "field", field
        ));
        sb.append(IMPLEMENTATION_TEMPLATE.getValue(context));
      } else {
        EvaluationContext context = createEvaluationContext(Map.of("propertyName", propertyName));
        sb.append(DECLARATION_TEMPLATE.getValue(context));
      }
    }
    sb.append(source.substring(lastPos));
    System.out.printf("Instrumented %s with attachment support.%n", path.getFileName());
    Files.writeString(path.toAbsolutePath(), sb.toString());
  }

  private static String decapitalise(String str) {
    if (Character.isLowerCase(str.charAt(0))) {
      return str;
    }
    return str.substring(0, 1).toLowerCase() + str.substring(1);
  }

  private static Expression precompileTemplate(String template) {
    SpelParserConfiguration spelParserConfiguration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, AttachmentPostProcessor.class.getClassLoader());
    return new SpelExpressionParser(spelParserConfiguration).parseExpression(template, new TemplateParserContext());
  }

  private static EvaluationContext createEvaluationContext(Map<String, String> templateVariables) {
    EvaluationContext ctx = SimpleEvaluationContext.forReadOnlyDataBinding().build();
    templateVariables.forEach(ctx::setVariable);
    return ctx;
  }
}
