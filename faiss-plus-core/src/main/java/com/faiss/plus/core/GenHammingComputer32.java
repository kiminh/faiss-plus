/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.faiss.plus.core;

public class GenHammingComputer32 {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected GenHammingComputer32(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GenHammingComputer32 obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_GenHammingComputer32(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setA0(long value) {
    swigfaissJNI.GenHammingComputer32_a0_set(swigCPtr, this, value);
  }

  public long getA0() {
    return swigfaissJNI.GenHammingComputer32_a0_get(swigCPtr, this);
  }

  public void setA1(long value) {
    swigfaissJNI.GenHammingComputer32_a1_set(swigCPtr, this, value);
  }

  public long getA1() {
    return swigfaissJNI.GenHammingComputer32_a1_get(swigCPtr, this);
  }

  public void setA2(long value) {
    swigfaissJNI.GenHammingComputer32_a2_set(swigCPtr, this, value);
  }

  public long getA2() {
    return swigfaissJNI.GenHammingComputer32_a2_get(swigCPtr, this);
  }

  public void setA3(long value) {
    swigfaissJNI.GenHammingComputer32_a3_set(swigCPtr, this, value);
  }

  public long getA3() {
    return swigfaissJNI.GenHammingComputer32_a3_get(swigCPtr, this);
  }

  public GenHammingComputer32(SWIGTYPE_p_unsigned_char a8, int code_size) {
    this(swigfaissJNI.new_GenHammingComputer32(SWIGTYPE_p_unsigned_char.getCPtr(a8), code_size), true);
  }

  public int hamming(SWIGTYPE_p_unsigned_char b8) {
    return swigfaissJNI.GenHammingComputer32_hamming(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(b8));
  }

}
