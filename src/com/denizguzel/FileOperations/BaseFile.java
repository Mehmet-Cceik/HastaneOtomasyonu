package com.denizguzel.FileOperations;

public interface BaseFile<T> {
  void Add (T user);

  void Update (T currentOne, T newOne);

  void List ();

  void Delete (T user);
}
