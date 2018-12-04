// IBookManager.aidl
package com.lijingya.binder.aidl;

import com.lijingya.binder.aidl.Book;
interface IBookManager {
  List<Book> getBookList();
  void addBook(in Book book);
}
