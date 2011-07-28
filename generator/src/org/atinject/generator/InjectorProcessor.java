// Copyright 2010 Square, Inc.
package org.atinject.generator;

import org.atinject.Injector;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Bob Lee (bob@squareup.com)
 */
public class InjectorProcessor extends ProcessorSupport {

  /*
   * TODO:
   *   - Support incremental compilation.
   *     - When module changes, re-generate all dependent injectors.
   *   - Support completions?
   */

  @Override public boolean process(Set<? extends TypeElement> annotations,
      RoundEnvironment environment) {
    TypeMirror injectorType = getTypeElement(Injector.class).asType();

    for (Element element : environment.getRootElements()) {
      if (isSubtype(element.asType(), injectorType)) {
        getModuleTypes(element);
      }
    }

    return false;
  }

  private List getModuleTypes(Element element) {
    for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
      // TODO
    }
    throw new UnsupportedOperationException();
  }

  @Override public Set<String> getSupportedAnnotationTypes() {
    return Collections.singleton("*");
  }

  @Override public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latest();
  }
}
