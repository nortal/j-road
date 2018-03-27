/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for X-Tee service endpoints, allows setting name and version of the service. Service <code>name</code> is
 * arbitrary, <code>version</code> number must be given in the form <code>vN</code> where
 * <code>N</code> is the version number.
 * <code>value</code> is provided for convenience and is equal to setting <code>name</code>.
 * 
 * @author Dmitri Danilkin
 * @author Taimo Peelo
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface XTeeService {
  String value() default "";

  String name() default "";

  String title() default "";

  String version() default "v1";
}
