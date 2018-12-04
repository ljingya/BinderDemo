package com.lijingya.binder.manualbinder;

import android.os.IInterface;
import android.os.RemoteException;
import com.lijingya.binder.aidl.Book;
import java.util.List;

/**
 * @author lijingya
 * @description 添加描述
 * @email lijingya@91118.com
 * @createDate 2018/11/28
 * @company 杭州天音
 */
public interface IBookManager extends IInterface{

    /**
     * Binder的唯一标识。一般是当前类名
     */
    static final java.lang.String DESCRIPTOR = "com.example.lijingya.androidipc.manualbinder.IBookManager";

    /**
     * 客户端发起请求时，这两个Id用于标识在transact过程中客户端请求的方法。
     */
    static final int TRANSACTION_getBookList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);

    static final int TRANSACTION_addBook = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);

    void addBook(Book book) throws RemoteException;

    List<Book> getBookList() throws RemoteException;
}
