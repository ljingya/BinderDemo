package com.lijingya.binder.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lijingya
 * @description 添加描述
 * @email lijingya@91118.com
 * @createDate 2018/11/28
 * @company 杭州天音
 */
public class BookService extends Service {

    private CopyOnWriteArrayList<Book> mBooks = new CopyOnWriteArrayList<>();

//    private IBinder mIBinder = new Stub() {
//        @Override
//        public List<Book> getBookList() throws RemoteException {
//
//            return mBooks;
//        }
//
//        @Override
//        public void addBook(Book book) throws RemoteException {
//            mBooks.add(book);
//        }
//    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("BookService","onCreate:");
        mBooks.add(new Book(1, "lijingya1"));
        mBooks.add(new Book(2, "lijingya2"));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("BookService","onUnbind:");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("BookService","onStartCommand:"+flags);
        return super.onStartCommand(intent, flags, startId);
    }
}
