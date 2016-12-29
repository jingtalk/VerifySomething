package com.example.jinghuang.proxytest;

import android.util.Log;

import com.example.jinghuang.proxytest.dynamic_proxy.CodingInvocationHandler;
import com.example.jinghuang.proxytest.static_proxy.StaticProxyCoding;

import java.lang.reflect.Array;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by hakimhuang on 2016/12/29.
 */

public class TestManager {

    public static final String TAG = "TestManager";
    private static TestManager mInstance;

    public static TestManager getInstance() {
        if (mInstance == null) {
            mInstance = new TestManager();
        }
        return mInstance;
    }

    public void test() {
        // 自己coding
        Coding code = new CodingMyself();
        Log.d(TAG, "coding myself:" + Arrays.toString(code.doCoding(100)));

        // 静态代理coding
        Coding staticCode = new StaticProxyCoding(code);
        Log.d(TAG, "coding static:" + Arrays.toString(staticCode.doCoding(100)));

        // 动态代理coding
        /**
         Proxy.newProxyInstance()方法有三个参数：

         1. 类加载器(Class Loader)

         2. 需要实现的接口数组

         3. InvocationHandler接口。所有动态代理类的方法调用，都会交由InvocationHandler接口实现类里的invoke()方法去处理。这是动态代理的关键所在。

         */

        Class<?>[] interfaces = code.getClass().getInterfaces();
        // 或者
        interfaces = new Class[] {code.getClass()}; //这样是错误的，因为CodingMyself不是接口
        interfaces = new Class[] {Coding.class};

        Coding dynamicCode = (Coding) Proxy.newProxyInstance(Coding.class.getClassLoader(),
                interfaces,
                new CodingInvocationHandler(code));
        Log.d(TAG, "coding dynamic:" + Arrays.toString(dynamicCode.doCoding(100)));
    }

}
