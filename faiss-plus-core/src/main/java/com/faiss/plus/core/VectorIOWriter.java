/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.faiss.plus.core;

public class VectorIOWriter extends IOWriter {
  private transient long swigCPtr;

  protected VectorIOWriter(long cPtr, boolean cMemoryOwn) {
    super(swigfaissJNI.VectorIOWriter_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(VectorIOWriter obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_VectorIOWriter(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public void setData(ByteVector value) {
    swigfaissJNI.VectorIOWriter_data_set(swigCPtr, this, ByteVector.getCPtr(value), value);
  }

  public ByteVector getData() {
    long cPtr = swigfaissJNI.VectorIOWriter_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ByteVector(cPtr, false);
  }

  public VectorIOWriter() {
    this(swigfaissJNI.new_VectorIOWriter(), true);
  }

}
