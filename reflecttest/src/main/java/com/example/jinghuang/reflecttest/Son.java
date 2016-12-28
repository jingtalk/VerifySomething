package com.example.jinghuang.reflecttest;

import android.util.Log;

/**
 * Created by hakimhuang on 2016/12/28.
 */

public class Son extends Father {

    public static final String TAG = "Son";

    public String mName;
    protected int mBirthday;
    private String mStory;

    public Son() {

    }

    private Son(String name, int birthday) {
        mName = name;
        mBirthday = birthday;
    }

    public Son(String name, int birthday, String story) {
        mName = name;
        mBirthday = birthday;
        mStory = story;
    }

    public void doCoolSomething() {

    }

    public void doCoolSomething(String something) {
        Log.d(TAG, "doSomething=" + something);
    }

    private String getCoolSomething() {
        return "Cool Something";
    }

    public String getCoolSomethingWhat(String what) {
        return "Cool Something:" + what;
    }

    protected void doCrazy(String thing) {
        Log.d(TAG, "doCrazy=" + thing);
    }

    @Override
    public String toString() {
        return mName + ":" + mBirthday + ":" + mStory;
    }
}
