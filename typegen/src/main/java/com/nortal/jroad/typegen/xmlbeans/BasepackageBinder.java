package com.nortal.jroad.typegen.xmlbeans;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.xmlbeans.BindingConfig;
import org.apache.xmlbeans.impl.common.NameUtil;

/**
 * @author Dmitri Danilkin
 * @author Roman Tekhov
 */
public class BasepackageBinder extends BindingConfig {
  private final String basePackage;

  public BasepackageBinder(String basePackage) {
    this.basePackage = basePackage;
  }

  @Override
  public String lookupPackageForNamespace(String uri) {
    String random = RandomStringUtils.randomAlphabetic(5);

    uri = uri.replace("-", random);

    String pck = NameUtil.getPackageFromNamespace(uri).replace(random, "_");

    return basePackage == null ? pck : basePackage + "." + pck;
  }

}
