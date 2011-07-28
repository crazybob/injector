// Copyright 2010 Square, Inc.
package org.atinject.example;

import org.atinject.Injector;
import org.atinject.Modules;

/**
 * @author Bob Lee (bob@squareup.com)
 */
@Modules(CarModule.class)
public interface CarInjector extends Injector {
  /** Injects an instance of Car. */
  Car injectCar();
}
