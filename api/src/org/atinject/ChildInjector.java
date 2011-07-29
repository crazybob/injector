// Copyright 2011 Square, Inc.
package org.atinject;

/**
 *
 *
 * @param <P> parent injector type
 * @author Bob Lee (bob@squareup.com)
 */
public interface ChildInjector<P extends Injector> extends Injector {

  P parent();
}
