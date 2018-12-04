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
public class User implements Parcelable {

    private String name;
    private int age;
    private VipUser mVipUser;

    /**
     *从序列化后的对象中创建原始对象
     * @param in 内部包装了可序列化的数据，可以在Binder中自由传输。
     */
    protected User(Parcel in) {
        name = in.readString();
        age = in.readInt();
        //VipUser是一个可序列化的对象，因此需要传上下文的类加载器
        mVipUser = in.readParcelable(VipUser.class.getClassLoader());
    }

    /**
     * 序列化功能
     * 将当前对象写入序列化中，
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeParcelable(mVipUser, flags);
    }

    /**
     * 内容描述功能
     * 返回当前对象的内容描述，如果含有文件描述符，返回1，否则返回0，几乎所有都返回0.
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 反序列化功能
     */
    public static final Creator<User> CREATOR = new Creator<User>() {
        /**
         * 从序列化后的对象中创建原始对象
         * @param in
         * @return
         */
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        /**
         * 创建指定对象的原始对象数组
         * @param size
         * @return
         */
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
