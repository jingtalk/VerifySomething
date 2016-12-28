package com.example.jinghuang.reflecttest;

import android.util.Log;

import java.lang.reflect.Constructor;

/**
 * Created by hakimhuang on 2016/12/28.
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

    public void testReflect() {

        vertifyConstructor();




    }

    /**
     * 该对象Public属性的构造函数
     * Constructor<T> getConstructor (Class...<?> parameterTypes) // 指定构造函数参数
     * Constructor[]<?> getConstructors ()
     *
     * 该对象所有属性的构造函数(包含默认的构造函数)
     * Constructor<T> getDeclaredConstructor (Class...<?> parameterTypes) // 指定构造函数参数
     * Constructor[]<?> getDeclaredConstructors ()
     *
     * Constructor<?> getEnclosingConstructor ()
     */
    private void vertifyConstructor() {
        try {
            // 包名获取class
            Class<?> myClz = Class.forName("com.example.jinghuang.reflecttest.Son");

            // 实例化对象从获取class
            Son mySon = new Son("jingtalk", 1990, "student");
//            Class<?> myClz = mySon.getClass();

            // 获取Public构造函数列表
            Constructor<?>[] pubicConstructorArray = myClz.getConstructors();
            for (int i = 0; i < pubicConstructorArray.length; i++) {
                Constructor<?> co = pubicConstructorArray[i];
                Log.d(TAG, "pubicConstructorArray.toString:" + co.toString());
            }

            // 获取所有构造函数列表 下面数组大小为4
            Constructor<?>[] allConstructorArray = myClz.getDeclaredConstructors();
            for (int i = 0; i < allConstructorArray.length; i++) {
                Constructor<?> co = allConstructorArray[i];
                Log.d(TAG, "allConstructorArray.toString:" + allConstructorArray.toString());
            }


            // 通过Class对象构造目标类型的对象
            Constructor<?> constructor = myClz.getConstructor(String.class, int.class, String.class);
            constructor.setAccessible(false);
            Object objectSon = constructor.newInstance("newson", 1983, "new constructor");
            Log.d(TAG, "objectSon:" + objectSon.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void vertifyMethod() {
        try {

            Son mySon = new Son("jingtalk", 1990, "student");
            Class<?> myClz = mySon.getClass();

            // 获取Public构造函数列表
            Constructor<?>[] pubicConstructorArray = myClz.getConstructors();
            for (int i = 0; i < pubicConstructorArray.length; i++) {
                Constructor<?> co = pubicConstructorArray[i];
                Log.d(TAG, "pubicConstructorArray.toString:" + co.toString());
            }

            // 获取所有构造函数列表 下面数组大小为4
            Constructor<?>[] allConstructorArray = myClz.getDeclaredConstructors();
            for (int i = 0; i < allConstructorArray.length; i++) {
                Constructor<?> co = allConstructorArray[i];
                Log.d(TAG, "allConstructorArray.toString:" + allConstructorArray.toString());
            }


            // 通过Class对象构造目标类型的对象
            Constructor<?> constructor = myClz.getConstructor(String.class, int.class, String.class);
            constructor.setAccessible(false);
            Object objectSon = constructor.newInstance("newson", 1983, "new constructor");
            Log.d(TAG, "objectSon:" + objectSon.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void vertifyField() {
        try {
            // 包名获取class
            Class<?> myClz = Class.forName("com.example.jinghuang.reflecttest.Son");

            // 实例化对象从获取class
            Son mySon = new Son("jingtalk", 1990, "student");
//            Class<?> myClz = mySon.getClass();

            // 获取Public构造函数列表
            Constructor<?>[] pubicConstructorArray = myClz.getConstructors();
            for (int i = 0; i < pubicConstructorArray.length; i++) {
                Constructor<?> co = pubicConstructorArray[i];
                Log.d(TAG, "pubicConstructorArray.toString:" + co.toString());
            }

            // 获取所有构造函数列表 下面数组大小为4
            Constructor<?>[] allConstructorArray = myClz.getDeclaredConstructors();
            for (int i = 0; i < allConstructorArray.length; i++) {
                Constructor<?> co = allConstructorArray[i];
                Log.d(TAG, "allConstructorArray.toString:" + allConstructorArray.toString());
            }


            // 通过Class对象构造目标类型的对象
            Constructor<?> constructor = myClz.getConstructor(String.class, int.class, String.class);
            constructor.setAccessible(false);
            Object objectSon = constructor.newInstance("newson", 1983, "new constructor");
            Log.d(TAG, "objectSon:" + objectSon.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void vertifyConstructor() {
        try {
            // 包名获取class
            Class<?> myClz = Class.forName("com.example.jinghuang.reflecttest.Son");

            // 实例化对象从获取class
            Son mySon = new Son("jingtalk", 1990, "student");
//            Class<?> myClz = mySon.getClass();

            // 获取Public构造函数列表
            Constructor<?>[] pubicConstructorArray = myClz.getConstructors();
            for (int i = 0; i < pubicConstructorArray.length; i++) {
                Constructor<?> co = pubicConstructorArray[i];
                Log.d(TAG, "pubicConstructorArray.toString:" + co.toString());
            }

            // 获取所有构造函数列表 下面数组大小为4
            Constructor<?>[] allConstructorArray = myClz.getDeclaredConstructors();
            for (int i = 0; i < allConstructorArray.length; i++) {
                Constructor<?> co = allConstructorArray[i];
                Log.d(TAG, "allConstructorArray.toString:" + allConstructorArray.toString());
            }


            // 通过Class对象构造目标类型的对象
            Constructor<?> constructor = myClz.getConstructor(String.class, int.class, String.class);
            constructor.setAccessible(false);
            Object objectSon = constructor.newInstance("newson", 1983, "new constructor");
            Log.d(TAG, "objectSon:" + objectSon.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void vertifyConstructor() {
        try {
            // 包名获取class
            Class<?> myClz = Class.forName("com.example.jinghuang.reflecttest.Son");

            // 实例化对象从获取class
            Son mySon = new Son("jingtalk", 1990, "student");
//            Class<?> myClz = mySon.getClass();

            // 获取Public构造函数列表
            Constructor<?>[] pubicConstructorArray = myClz.getConstructors();
            for (int i = 0; i < pubicConstructorArray.length; i++) {
                Constructor<?> co = pubicConstructorArray[i];
                Log.d(TAG, "pubicConstructorArray.toString:" + co.toString());
            }

            // 获取所有构造函数列表 下面数组大小为4
            Constructor<?>[] allConstructorArray = myClz.getDeclaredConstructors();
            for (int i = 0; i < allConstructorArray.length; i++) {
                Constructor<?> co = allConstructorArray[i];
                Log.d(TAG, "allConstructorArray.toString:" + allConstructorArray.toString());
            }


            // 通过Class对象构造目标类型的对象
            Constructor<?> constructor = myClz.getConstructor(String.class, int.class, String.class);
            constructor.setAccessible(false);
            Object objectSon = constructor.newInstance("newson", 1983, "new constructor");
            Log.d(TAG, "objectSon:" + objectSon.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
