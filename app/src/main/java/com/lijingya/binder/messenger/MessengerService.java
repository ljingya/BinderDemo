package com.lijingya.binder.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * @author lijingya
 * @description 添加描述
 * @email lijingya@91118.com
 * @createDate 2018/11/29
 * @company 杭州天音
 */
public class MessengerService extends Service {

    /**
     * 创建一个Messenger,需要通过handler创建
     */
    private final Messenger mMessenger = new Messenger(new MessengerHandler());


    private static class MessengerHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MessengerConstants.MESSAGE_FROM_CLIENT:
                    Log.d("MessengerService", "收到 客户端消息：" + msg.getData().getString("msg"));
                    Messenger replyTo = msg.replyTo;
                    Message message = Message.obtain(null, MessengerConstants.MESSAGE_FROM_SERVER);
                    Bundle bundle=new Bundle();
                    bundle.putString("reply","已收到，稍后回复");
                    message.setData(bundle);
                    try {
                        replyTo.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 通过Messenger获取Binder
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }
}
