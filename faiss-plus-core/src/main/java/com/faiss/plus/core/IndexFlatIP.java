/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.faiss.plus.core;

public class IndexFlatIP extends IndexFlat {
  private transient long swigCPtr;

  protected IndexFlatIP(long cPtr, boolean cMemoryOwn) {
    super(swigfaissJNI.IndexFlatIP_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IndexFlatIP obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_IndexFlatIP(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public IndexFlatIP(int d) {
    this(swigfaissJNI.new_IndexFlatIP__SWIG_0(d), true);
  }

  public IndexFlatIP() {
    this(swigfaissJNI.new_IndexFlatIP__SWIG_1(), true);
  }

}
