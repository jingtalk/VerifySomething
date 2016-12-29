package com.example.jinghuang.proxytest.hook_activity;

import android.app.Instrumentation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by hakimhuang on 2016/12/29.
 */

public class HookHelper {

    public static void attachContext() {

        // 我们的目的是要将 ActivityThread 的成员变量 mInstrumentation 替换成我们自己的 Instrumentation
        // 使用反射

        try {
            // 1. 获取Class 通过包名
            Class<?> activityThreadClass = Class.forName("android.app.ActivityThread");

            // 2. 创建一个ActivityThread对象 通过 函数 currentActivityThread 实现
            Method currentActivityThreadMethod = activityThreadClass.getDeclaredMethod("currentActivityThread");
            currentActivityThreadMethod.setAccessible(true);
            //currentActivityThread是一个static函数所以可以直接invoke，不需要带实例参数
            Object currentActivityThreadObj;
            currentActivityThreadObj = currentActivityThreadMethod.invoke(null);

            // 2.x 通过构造函数获取 default权限 类、包可用
            Constructor<?> constructor = activityThreadClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            currentActivityThreadObj = constructor.newInstance();

            // 3. 拿到原始的 mInstrumentation字段
            Field mInstrumentationField = activityThreadClass.getDeclaredField("mInstrumentation");
            mInstrumentationField.setAccessible(true);
            Instrumentation mInstrumentation = (Instrumentation) mInstrumentationField.get(currentActivityThreadObj);

            // 4. 创建代理对象
            Instrumentation evilInstrumentation = new MyInstrumentation(mInstrumentation);

            // 5. 偷梁换柱
            mInstrumentationField.set(currentActivityThreadObj, evilInstrumentation);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
