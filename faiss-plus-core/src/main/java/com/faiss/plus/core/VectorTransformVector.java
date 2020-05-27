/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.faiss.plus.core;

public class VectorTransformVector {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected VectorTransformVector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(VectorTransformVector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_VectorTransformVector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public VectorTransformVector() {
    this(swigfaissJNI.new_VectorTransformVector(), true);
  }

  public void push_back(VectorTransform arg0) {
    swigfaissJNI.VectorTransformVector_push_back(swigCPtr, this, VectorTransform.getCPtr(arg0), arg0);
  }

  public void clear() {
    swigfaissJNI.VectorTransformVector_clear(swigCPtr, this);
  }

  public SWIGTYPE_p_p_faiss__VectorTransform data() {
    long cPtr = swigfaissJNI.VectorTransformVector_data(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_faiss__VectorTransform(cPtr, false);
  }

  public long size() {
    return swigfaissJNI.VectorTransformVector_size(swigCPtr, this);
  }

  public VectorTransform at(long n) {
    long cPtr = swigfaissJNI.VectorTransformVector_at(swigCPtr, this, n);
    return (cPtr == 0) ? null : new VectorTransform(cPtr, false);
  }

  public void resize(long n) {
    swigfaissJNI.VectorTransformVector_resize(swigCPtr, this, n);
  }

  public void swap(VectorTransformVector other) {
    swigfaissJNI.VectorTransformVector_swap(swigCPtr, this, VectorTransformVector.getCPtr(other), other);
  }

}
