/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.faiss.plus.core;

public class IOWriter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected IOWriter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IOWriter obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_IOWriter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setName(String value) {
    swigfaissJNI.IOWriter_name_set(swigCPtr, this, value);
  }

  public String getName() {
    return swigfaissJNI.IOWriter_name_get(swigCPtr, this);
  }

  public int fileno() {
    return swigfaissJNI.IOWriter_fileno(swigCPtr, this);
  }

}
