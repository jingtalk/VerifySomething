package com.example.jinghuang.proxytest.hook_activity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * Created by hakimhuang on 2016/12/29.
 */

/**
 * 由于jdk的动态代理只支持接口 而 Instrumentation 是个类
 * 所以这里的做法是静态代理
 * 覆盖之前的方法即可
 */
public class MyInstrumentation extends Instrumentation {

    public final static String TAG = "MyInstrumentation";

    // ActivityThread中原始的对象
    Instrumentation mRealInstrument;

    public MyInstrumentation(Instrumentation instrument) {
        mRealInstrument = instrument;
    }

    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode, Bundle options) {

        // 做hook想做的事情 此处是打印一条日志
        Log.d(TAG, "Hook happend by jingtalk, who=" + who + ", target=" + target + ", intent=" + intent);

        try {
            // 反射找到想要调用的方法
            Method execStartActivityMethod = Instrumentation.class.getDeclaredMethod("execStartActivity",
                    Context.class,
                    IBinder.class,
                    IBinder.class,
                    Activity.class,
                    Intent.class,
                    int.class,
                    Bundle.class);
            execStartActivityMethod.setAccessible(true);
            return (ActivityResult) execStartActivityMethod.invoke(mRealInstrument, who, contextThread,
                    token, target, intent, requestCode, options);


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error happen");
        }
    }
}
