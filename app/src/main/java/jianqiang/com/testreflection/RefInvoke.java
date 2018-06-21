package jianqiang.com.testreflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefInvoke {

    public static Object createObject(String className, Class[] pareTyples, Object[] pareVaules) {
        try {
            Class r = Class.forName(className);
            Constructor ctor = r.getDeclaredConstructor(pareTyples);
            ctor.setAccessible(true);
            return ctor.newInstance(pareVaules);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Object invokeInstanceMethod(Object obj, String methodName, Class[] pareTyples, Object[] pareVaules) {
        if(obj == null)
            return null;

        try {
            //调用一个private方法
            Method method = obj.getClass().getDeclaredMethod(methodName, pareTyples); //在指定类中获取指定的方法
            method.setAccessible(true);
            return method.invoke(obj, pareVaules);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Object invokeStaticMethod(String className, String method_name, Class[] pareTyples, Object[] pareVaules) {
        try {
            Class obj_class = Class.forName(className);
            Method method = obj_class.getDeclaredMethod(method_name, pareTyples);
            method.setAccessible(true);
            return method.invoke(null, pareVaules);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Object getFieldObject(String className, Object obj, String filedName) {
        try {
            Class obj_class = Class.forName(className);
            Field field = obj_class.getDeclaredField(filedName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void setFieldObject(String classname, Object obj, String filedName, Object filedVaule) {
        try {
            Class obj_class = Class.forName(classname);
            Field field = obj_class.getDeclaredField(filedName);
            field.setAccessible(true);
            field.set(obj, filedVaule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}