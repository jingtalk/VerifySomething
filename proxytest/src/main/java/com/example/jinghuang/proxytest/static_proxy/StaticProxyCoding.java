package com.example.jinghuang.proxytest.static_proxy;

import android.util.Log;

import com.example.jinghuang.proxytest.Coding;

/**
 * Created by hakimhuang on 2016/12/29.
 */

public class StaticProxyCoding implements Coding {

    public final static String TAG = "StaticProxyCoding";

    Coding base;
    public StaticProxyCoding(Coding base) {
        this.base = base;
    }

    @Override
    public Object[] doCoding(int time) {

        int allTime = time * 20;
        Log.d(TAG, "set coding time=" + allTime);

        // do coding
        Object[] results = base.doCoding(allTime);

        // 修改一些东西
        if (results != null && results.length > 1) {
            results[0] = "static";
        }

        return results;
    }
}
