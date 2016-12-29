package com.example.jinghuang.proxytest.dynamic_proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hakimhuang on 2016/12/29.
 */

public class CodingInvocationHandler implements InvocationHandler {

    public final static String TAG = "CodingInvocationHandler";

    // 定义一个被代理的对象
    Object target;

    public CodingInvocationHandler(Object obj) {
        target = obj;
    }

    /**
     *
     *
     invoke()方法同样有三个参数：

     1. 动态代理类的引用，通常情况下不需要它。但可以使用getClass()方法，得到proxy的Class类从而取得实例的类信息，如方法列表，annotation等。

     2. 方法对象的引用，代表被动态代理类调用的方法。从中可得到方法名，参数类型，返回类型等等

     3. args对象数组，代表被调用方法的参数。注意基本类型(int,long)会被装箱成对象类型(Interger, Long)
     *
     *
     *
     * @param o
     * @param method
     * @param objects
     * @return
     * @throws Throwable
     */

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        if ("doCoding".equals(method.getName())) {

            int time = (int) objects[0];
            int allTime = time * 100;
            Log.d(TAG, "set coding time=" + allTime);

            // do coding
            Object[] results = (Object[]) method.invoke(target, allTime);

            // 修改一些东西
            if (results != null && results.length > 1) {
                results[0] = "dynamic";
            }

            return results;
        }

        // 可以通过代理做些其它的事情
        if ("checkError".equals(method.getName())) {
            return null;
        }

        if ("checkBug".equals(method.getName())) {
            return null;
        }

        return null;
    }
}
