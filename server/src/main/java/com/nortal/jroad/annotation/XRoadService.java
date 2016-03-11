package com.nortal.jroad.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * /** Annotation for XRoad service endpoints, allows setting name and version of the service. Service <code>name</code>
 * is arbitrary, <code>version</code> number must be given in the form <code>vN</code> where
 * <code>N<code> is the version number.
 * <code>value</code> is provided for convenience and is equal to setting <code>name</code>.
 * 
 * @author Dmitri Danilkin
 * @author Taimo Peelo
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface XRoadService {
  String value() default "";

  String name() default "";

  String title() default "";

  String version() default "v1";
}
