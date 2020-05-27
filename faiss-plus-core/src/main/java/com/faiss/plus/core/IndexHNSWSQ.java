/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.faiss.plus.core;

public class IndexHNSWSQ extends IndexHNSW {
  private transient long swigCPtr;

  protected IndexHNSWSQ(long cPtr, boolean cMemoryOwn) {
    super(swigfaissJNI.IndexHNSWSQ_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IndexHNSWSQ obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_IndexHNSWSQ(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public IndexHNSWSQ() {
    this(swigfaissJNI.new_IndexHNSWSQ__SWIG_0(), true);
  }

  public IndexHNSWSQ(int d, ScalarQuantizer.QuantizerType qtype, int M) {
    this(swigfaissJNI.new_IndexHNSWSQ__SWIG_1(d, qtype.swigValue(), M), true);
  }

  public HNSW.DistanceComputer get_distance_computer() {
    long cPtr = swigfaissJNI.IndexHNSWSQ_get_distance_computer(swigCPtr, this);
    return (cPtr == 0) ? null : new HNSW.DistanceComputer(cPtr, false);
  }

}
