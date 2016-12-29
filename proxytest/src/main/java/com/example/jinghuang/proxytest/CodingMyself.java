package com.example.jinghuang.proxytest;

import android.util.Log;

/**
 * Created by hakimhuang on 2016/12/29.
 */

public class CodingMyself implements Coding {

    public final static String TAG = "CodingMyself";
    @Override
    public Object[] doCoding(int time) {
        Log.d(TAG, "coding myself, coding time=" + time);
        return new Object[] {"android", "ios"};
    }
}
