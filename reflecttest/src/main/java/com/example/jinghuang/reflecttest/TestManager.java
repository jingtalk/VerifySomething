package com.example.jinghuang.reflecttest;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
        vertifyMethod();
        vertifyField();

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

    /**
     * 该对象Public的方法数
     * Method getMethod (String name, Class...<?> parameterTypes)
     * Method[] getMethods ()
     *
     * 该对象所有属性的方法数
     * Method getDeclaredMethod (String name, Class...<?> parameterTypes)
     * Method[] getDeclaredMethods ()
     *
     * Method getEnclosingMethod ()
     */
    private void vertifyMethod() {
        try {

            Son mySon = new Son("jingtalk", 1990, "student");
            Class<?> myClz = mySon.getClass();

            Method[] pubicMethodArray = myClz.getMethods();
            for (int i = 0; i < pubicMethodArray.length; i++) {
                Method co = pubicMethodArray[i];
                Log.d(TAG, "pubicMethodArray.toString:" + co.toString());
            }

            Method[] allMethodArray = myClz.getDeclaredMethods();
            for (int i = 0; i < allMethodArray.length; i++) {
                Method co = allMethodArray[i];
                Log.d(TAG, "allMethodArray.toString:" + allMethodArray.toString());
            }

            // 获取指定函数并调用
            Method doCoolSomethingMethod = myClz.getDeclaredMethod("doCoolSomething", String.class, int.class);
            // 获取该方法的参数类型
            Class<?>[] paramMethod = doCoolSomethingMethod.getParameterTypes();
            for (Class<?> para: paramMethod
                 ) {
                Log.d(TAG, "doCoolSomething的参数类型:" + para.getName());
            }
            // 判断该方法属性
            Log.d(TAG, "doCoolSomethingMethod is private:" + Modifier.isPrivate(doCoolSomethingMethod.getModifiers()));
            Log.d(TAG, "doCoolSomethingMethod is public:" + Modifier.isPublic(doCoolSomethingMethod.getModifiers()));

            // 调用该方法
            doCoolSomethingMethod.invoke(mySon, "huangjing", 1996);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 该对象Public的属性
     * Field getField (String name)
     * Field[] getFields ()
     *
     * 该对象所有属性的属性
     * Field[] getDeclaredFields ()
     * Field getDeclaredField (String name)
     *
     */
    private void vertifyField() {
        try {
            // 包名获取class
            Class<?> myClz = Class.forName("com.example.jinghuang.reflecttest.Son");

            Field[] pubicFieldArray = myClz.getFields();
            for (int i = 0; i < pubicFieldArray.length; i++) {
                Field co = pubicFieldArray[i];
                Log.d(TAG, "pubicFieldArray.toString:" + co.toString());
            }

            Field[] allFieldArray = myClz.getDeclaredFields();
            for (int i = 0; i < allFieldArray.length; i++) {
                Field co = allFieldArray[i];
                Log.d(TAG, "allFieldArray.toString:" + allFieldArray.toString());
            }


            // 通过Class对象构造目标类型的对象
            Constructor<?> constructor = myClz.getConstructor(String.class, int.class, String.class);
            constructor.setAccessible(false);
            Object objectSon = constructor.newInstance("newson", 1983, "new constructor");
            Log.d(TAG, "objectSon:" + objectSon.toString());

            // 获取String
            Field nameField = objectSon.getClass().getField("mName");
            Log.d(TAG, "my name is :" + nameField.get(objectSon));

            // 获取int
            Field birthdayField = objectSon.getClass().getField("mBirthday");
            Log.d(TAG, "my birthday is :" + birthdayField.getInt(objectSon));

            // 设置String
            nameField.set(objectSon, "new new son");
            Log.d(TAG, "my name is :" + nameField.get(objectSon));
            // 设置int
            birthdayField.set(objectSon, 1986);
            Log.d(TAG, "my birthday is :" + birthdayField.getInt(objectSon));
            birthdayField.setInt(objectSon, 2005);
            Log.d(TAG, "my birthday is :" + birthdayField.getInt(objectSon));



            // 获取父类
            Class<?> superClass = myClz.getSuperclass();
            while (superClass != null) {
                Log.d(TAG, "Son's super class is:" + superClass.getName());
                superClass = superClass.getSuperclass();
            }

            // 获取接口
            Class<?>[] interfaces = myClz.getInterfaces();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
