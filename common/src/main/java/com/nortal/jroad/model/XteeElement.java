/**
 * 
 */
package com.nortal.jroad.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author margush
 */
// Should switch to X-road implementation
@Deprecated
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XteeElement {

  String title();

  long sequence();
}
