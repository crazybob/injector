// Copyright 2010 Square, Inc.
package org.atinject;

/**
 * A dependency injector.
 *
 * @author Bob Lee (bob@squareup.com)
 */
public interface Injector {

  /*
   * Ideas for child injectors:
   *
   *   1. The child injector type could extend the parent type.
   *   2. You could create a child injector by injecting it.
   */

  /**
   * Creates Injector instances at run time.
   */
  public static final class Factory {

    /*
     * TODO: Make impl public and instantiate directly instead?
     */

    private Factory() {}

    /*
     * TODO:
     *   - Support both lazy and eager module instantiation.
     *   - Let user pass in module instances at run time.
     */

    /**
     * Constructs a new injector of the given type.
     *
     * <p>If the caller doesn't provide a module instance that implements a module type specified
     * using {@link Modules}, the injector will construct a module instance by calling the module
     * type's default constructor.</p>
     *
     * @param injectorType
     * @param modules Optional implementations of modules
     * @param <I>
     * @throws IllegalArgumentException if a module doesn't implement one
     *  of the specified types.
     */
    public static <I extends Injector> I create(Class<I> injectorType,
        Object... modules) {
      try {
        Class<?> impl = Class.forName(injectorType.getName() + "$Impl", true,
            injectorType.getClassLoader());
        return injectorType.cast(impl.newInstance());
      } catch (InstantiationException e) {
        throw new RuntimeException(e);
      } catch (IllegalAccessException e) {
        throw new AssertionError(e);
      } catch (ClassNotFoundException e) {
        throw new AssertionError(e);
      }
    }
  }
}
