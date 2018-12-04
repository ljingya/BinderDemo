package com.lijingya.binder;

import android.app.Application;
import android.os.Process;
import android.util.Log;
import com.lijingya.util.app.AppUtil;

/**
 * @author lijingya
 * @description 添加描述
 * @email lijingya@91118.com
 * @createDate 2018/11/27
 * @company 杭州天音
 */
public class App extends Application {

    private static final String TAG = "Application";

    @Override
    public void onCreate() {
        super.onCreate();
        String proccessName = AppUtil.getProccessName(this, Process.myPid());
        Log.d(TAG, " app start:" + proccessName);
    }
}
