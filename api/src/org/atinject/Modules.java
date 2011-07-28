// Copyright 2010 Square, Inc.
package org.atinject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Specifies provider methods that configure an injector.
 *
 * @author Bob Lee (bob@squareup.com)
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Modules {
  
  /**
   * Array of types containing provider methods.
   */
  Class<?>[] value();
}
