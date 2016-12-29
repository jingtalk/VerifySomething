package com.example.jinghuang.proxytest;

/**
 * Created by hakimhuang on 2016/12/29.
 */

public class TestManagerCopy {

    public static final String TAG = "TestManager";
    private static TestManagerCopy mInstance;

    public static TestManagerCopy getInstance() {
        if (mInstance == null) {
            mInstance = new TestManagerCopy();
        }
        return mInstance;
    }

    private void test() {

    }

}
