package com.lijingya.binder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author lijingya
 * @description 添加描述
 * @email lijingya@91118.com
 * @createDate 2018/11/27
 * @company 杭州天音
 */
public class VipUser implements Parcelable {

    protected VipUser(Parcel in) {
    }

    public static final Creator<VipUser> CREATOR = new Creator<VipUser>() {
        @Override
        public VipUser createFromParcel(Parcel in) {
            return new VipUser(in);
        }

        @Override
        public VipUser[] newArray(int size) {
            return new VipUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
