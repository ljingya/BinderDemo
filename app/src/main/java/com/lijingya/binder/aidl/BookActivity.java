package com.lijingya.binder.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.lijingya.binder.R;
import com.lijingya.binder.aidl.IBookManager.Stub;
import java.util.List;


/**
 * @author lijingya
 * @description 添加描述
 * @email lijingya@91118.com
 * @createDate 2018/11/28
 * @company 杭州天音
 */
public class BookActivity extends AppCompatActivity implements OnClickListener {

    private static final String TAG = "BookActivity";
    private IBookManager iBookManager;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: 服务已连接");
            iBookManager = Stub.asInterface(service);
            try {
                iBookManager.asBinder().linkToDeath(mDeathRecipient, 0);
                List<Book> bookList = iBookManager.getBookList();
                Log.d(TAG, "查询 书籍 ：" + bookList.toString());
                iBookManager.addBook(new Book(3, "lijingya3"));
                bookList = iBookManager.getBookList();
                Log.d(TAG, "新增 书籍 ：" + bookList.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iBookManager = null;
            Log.d(TAG, "onServiceConnected: 服务已断开");
        }
    };
    /**
     * 监听远程服务端意外死亡，重连
     */
    private IBinder.DeathRecipient mDeathRecipient = new DeathRecipient() {
        @Override
        public void binderDied() {
            if (iBookManager == null) {
                return;
            }
            Log.d(TAG, "Service Dead");
            iBookManager.asBinder().unlinkToDeath(mDeathRecipient, 0);
            iBookManager = null;

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Button btnStartRemoteService = findViewById(R.id.btn_start_remote_service);
        btnStartRemoteService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_remote_service:
                Intent intent = new Intent(this, BookService.class);
                bindService(intent, mConnection, Context.BIND_AUTO_CREATE);

                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        super.onDestroy();
    }
}
