/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.faiss.plus.core;

public class ConcatenatedInvertedLists extends InvertedLists {
  private transient long swigCPtr;

  protected ConcatenatedInvertedLists(long cPtr, boolean cMemoryOwn) {
    super(swigfaissJNI.ConcatenatedInvertedLists_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ConcatenatedInvertedLists obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_ConcatenatedInvertedLists(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public void setIls(SWIGTYPE_p_std__vectorT_faiss__InvertedLists_const_p_t value) {
    swigfaissJNI.ConcatenatedInvertedLists_ils_set(swigCPtr, this, SWIGTYPE_p_std__vectorT_faiss__InvertedLists_const_p_t.getCPtr(value));
  }

  public SWIGTYPE_p_std__vectorT_faiss__InvertedLists_const_p_t getIls() {
    long cPtr = swigfaissJNI.ConcatenatedInvertedLists_ils_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_std__vectorT_faiss__InvertedLists_const_p_t(cPtr, false);
  }

  public ConcatenatedInvertedLists(int nil, SWIGTYPE_p_p_faiss__InvertedLists ils) {
    this(swigfaissJNI.new_ConcatenatedInvertedLists(nil, SWIGTYPE_p_p_faiss__InvertedLists.getCPtr(ils)), true);
  }

  public long list_size(long list_no) {
    return swigfaissJNI.ConcatenatedInvertedLists_list_size(swigCPtr, this, list_no);
  }

  public SWIGTYPE_p_unsigned_char get_codes(long list_no) {
    long cPtr = swigfaissJNI.ConcatenatedInvertedLists_get_codes(swigCPtr, this, list_no);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public SWIGTYPE_p_long get_ids(long list_no) {
    long cPtr = swigfaissJNI.ConcatenatedInvertedLists_get_ids(swigCPtr, this, list_no);
    return (cPtr == 0) ? null : new SWIGTYPE_p_long(cPtr, false);
  }

  public void release_codes(SWIGTYPE_p_unsigned_char codes) {
    swigfaissJNI.ConcatenatedInvertedLists_release_codes(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(codes));
  }

  public void release_ids(SWIGTYPE_p_long ids) {
    swigfaissJNI.ConcatenatedInvertedLists_release_ids(swigCPtr, this, SWIGTYPE_p_long.getCPtr(ids));
  }

  public int get_single_id(long list_no, long offset) {
    return swigfaissJNI.ConcatenatedInvertedLists_get_single_id(swigCPtr, this, list_no, offset);
  }

  public SWIGTYPE_p_unsigned_char get_single_code(long list_no, long offset) {
    long cPtr = swigfaissJNI.ConcatenatedInvertedLists_get_single_code(swigCPtr, this, list_no, offset);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public long add_entries(long list_no, long n_entry, SWIGTYPE_p_long ids, SWIGTYPE_p_unsigned_char code) {
    return swigfaissJNI.ConcatenatedInvertedLists_add_entries(swigCPtr, this, list_no, n_entry, SWIGTYPE_p_long.getCPtr(ids), SWIGTYPE_p_unsigned_char.getCPtr(code));
  }

  public void update_entries(long list_no, long offset, long n_entry, SWIGTYPE_p_long ids, SWIGTYPE_p_unsigned_char code) {
    swigfaissJNI.ConcatenatedInvertedLists_update_entries(swigCPtr, this, list_no, offset, n_entry, SWIGTYPE_p_long.getCPtr(ids), SWIGTYPE_p_unsigned_char.getCPtr(code));
  }

  public void resize(long list_no, long new_size) {
    swigfaissJNI.ConcatenatedInvertedLists_resize(swigCPtr, this, list_no, new_size);
  }

}
