package com.example.jinghuang.reflecttest;

import android.util.Log;

/**
 * Created by hakimhuang on 2016/12/28.
 */

public class Father {
    public static final String TAG = "Father";
    public String mFatherName = "father";
    protected int mFatherBirthday = 1944;
    private String mFatherStory = "no story";

    public Father() {

    }

    public Father(String name) {
        mFatherName = name;
    }

    public void doSomething() {

    }

    public void doSomething(String something) {
        Log.d(TAG, "doSomething=" + something);
    }

}
