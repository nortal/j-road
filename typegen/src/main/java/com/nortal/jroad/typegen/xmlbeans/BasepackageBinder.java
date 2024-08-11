package com.nortal.jroad.typegen.xmlbeans;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
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
    //Capitalisation is needed, as namespace->package algorithm
    //changes lowercase letters to uppercase if number preceeds it
    String hyphenPlaceholder = StringUtils.capitalize(RandomStringUtils.randomAlphabetic(5));

    uri = uri.replace("-", hyphenPlaceholder);

    String subPackage = NameUtil.getPackageFromNamespace(uri).replace(hyphenPlaceholder, "_");

    return basePackage == null ? subPackage : basePackage + "." + subPackage;
  }

}
