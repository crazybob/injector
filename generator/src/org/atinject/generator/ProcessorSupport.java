// Copyright 2010 Square, Inc.
package org.atinject.generator;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * Provides convenience methods.
 *
 * @author Bob Lee (bob@squareup.com)
 */
public abstract class ProcessorSupport extends AbstractProcessor
    implements Elements {

  /* Elements */

  private Elements getElements() {
    return processingEnv.getElementUtils();
  }

  public PackageElement getPackageElement(CharSequence name) {
    return getElements().getPackageElement(name);
  }

  public TypeElement getTypeElement(CharSequence name) {
    return getElements().getTypeElement(name);
  }

  public TypeElement getTypeElement(Class clazz) {
    return getTypeElement(clazz.getName());
  }

  public Map<? extends ExecutableElement, ? extends AnnotationValue>
      getElementValuesWithDefaults(AnnotationMirror a) {
    return getElements().getElementValuesWithDefaults(a);
  }

  public String getDocComment(Element e) {
    return getElements().getDocComment(e);
  }

  public boolean isDeprecated(Element e) {
    return getElements().isDeprecated(e);
  }

  public Name getBinaryName(TypeElement type) {
    return getElements().getBinaryName(type);
  }

  public PackageElement getPackageOf(Element type) {
    return getElements().getPackageOf(type);
  }

  public List<? extends Element> getAllMembers(TypeElement type) {
    return getElements().getAllMembers(type);
  }

  public List<? extends AnnotationMirror> getAllAnnotationMirrors(Element e) {
    return getElements().getAllAnnotationMirrors(e);
  }

  public boolean hides(Element hider, Element hidden) {
    return getElements().hides(hider, hidden);
  }

  public boolean overrides(ExecutableElement overrider,
      ExecutableElement overridden, TypeElement type) {
    return getElements().overrides(overrider, overridden, type);
  }

  public String getConstantExpression(Object value) {
    return getElements().getConstantExpression(value);
  }

  public void printElements(Writer w, Element... elements) {
    getElements().printElements(w, elements);
  }

  public Name getName(CharSequence cs) {
    return getElements().getName(cs);
  }

  /* Types */

  private Types getTypeUtils() {
    return processingEnv.getTypeUtils();
  }

  public Element asElement(TypeMirror t) {
    return getTypeUtils().asElement(t);
  }

  public boolean isSameType(TypeMirror t1, TypeMirror t2) {
    return getTypeUtils().isSameType(t1, t2);
  }

  public boolean isSubtype(TypeMirror t1, TypeMirror t2) {
    return getTypeUtils().isSubtype(t1, t2);
  }

  public boolean isAssignable(TypeMirror t1, TypeMirror t2) {
    return getTypeUtils().isAssignable(t1, t2);
  }

  public boolean contains(TypeMirror t1, TypeMirror t2) {
    return getTypeUtils().contains(t1, t2);
  }

  public boolean isSubsignature(ExecutableType m1, ExecutableType m2) {
    return getTypeUtils().isSubsignature(m1, m2);
  }

  public List<? extends TypeMirror> directSupertypes(TypeMirror t) {
    return getTypeUtils().directSupertypes(t);
  }

  public TypeMirror erasure(TypeMirror t) {
    return getTypeUtils().erasure(t);
  }

  public TypeElement boxedClass(PrimitiveType p) {
    return getTypeUtils().boxedClass(p);
  }

  public PrimitiveType unboxedType(TypeMirror t) {
    return getTypeUtils().unboxedType(t);
  }

  public TypeMirror capture(TypeMirror t) {
    return getTypeUtils().capture(t);
  }

  public PrimitiveType getPrimitiveType(TypeKind kind) {
    return getTypeUtils().getPrimitiveType(kind);
  }

  public NullType getNullType() {
    return getTypeUtils().getNullType();
  }

  public NoType getNoType(TypeKind kind) {
    return getTypeUtils().getNoType(kind);
  }

  public ArrayType getArrayType(TypeMirror componentType) {
    return getTypeUtils().getArrayType(componentType);
  }

  public WildcardType getWildcardType(TypeMirror extendsBound,
      TypeMirror superBound) {
    return getTypeUtils().getWildcardType(extendsBound, superBound);
  }

  public DeclaredType getDeclaredType(TypeElement typeElem,
      TypeMirror... typeArgs) {
    return getTypeUtils().getDeclaredType(typeElem, typeArgs);
  }

  public DeclaredType getDeclaredType(DeclaredType containing,
      TypeElement typeElem, TypeMirror... typeArgs) {
    return getTypeUtils().getDeclaredType(containing, typeElem, typeArgs);
  }

  public TypeMirror asMemberOf(DeclaredType containing, Element element) {
    return getTypeUtils().asMemberOf(containing, element);
  }

  /* Messager */

  private Messager getMessager() {
    return processingEnv.getMessager();
  }

  public void printMessage(Diagnostic.Kind kind, CharSequence msg) {
    getMessager().printMessage(kind, msg);
  }

  public void printMessage(Diagnostic.Kind kind, CharSequence msg, Element e) {
    getMessager().printMessage(kind, msg, e);
  }

  public void printMessage(Diagnostic.Kind kind, CharSequence msg, Element e,
      AnnotationMirror a) {
    getMessager().printMessage(kind, msg, e, a);
  }

  public void printMessage(Diagnostic.Kind kind, CharSequence msg, Element e,
      AnnotationMirror a, AnnotationValue v) {
    getMessager().printMessage(kind, msg, e, a, v);
  }
}
