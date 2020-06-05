package com.tencent.p605ep.commonbase.utils;

import java.lang.reflect.Field;

/* renamed from: com.tencent.ep.commonbase.utils.ReflecterHelper */
public final class ReflecterHelper {
    public static Class<?> mCurrentClass;

    private static final Field getField(String str) {
        Field field;
        Class<?> cls = mCurrentClass;
        Field field2 = null;
        if (cls == null) {
            return null;
        }
        try {
            field2 = cls.getDeclaredField(str);
            field2.setAccessible(true);
            return field2;
        } catch (SecurityException e) {
            e.printStackTrace();
            return field;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return field2;
        }
    }

    public static final int getIntValue(Object obj, String str, int i) {
        int i2;
        setClass(obj.getClass().getName());
        Field field = getField(str);
        if (field == null) {
            return i;
        }
        try {
            i = field.getInt(obj);
            return i;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return i2;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return i;
        }
    }

    public static Object getProperty(Object obj, String str) {
        return obj.getClass().getField(str).get(obj);
    }

    public static final int getStaticIntValue(String str, int i) {
        int i2;
        Field field = getField(str);
        if (field == null) {
            return i;
        }
        try {
            i = field.getInt(null);
            return i;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return i2;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return i;
        }
    }

    public static Object getStaticProperty(String str, String str2) {
        setClass(str);
        Field field = getField(str2);
        Object obj = null;
        if (field == null) {
            return null;
        }
        try {
            obj = field.get(null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        return obj;
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr) {
        Class cls = obj.getClass();
        Class<Boolean>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            } else if (clsArr[i] == Boolean.class) {
                clsArr[i] = Boolean.TYPE;
            }
        }
        return cls.getMethod(str, clsArr).invoke(obj, objArr);
    }

    public static Object invokeStaticMethod(String str, Object[] objArr) {
        Class<Boolean>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            } else if (clsArr[i] == Boolean.class) {
                clsArr[i] = Boolean.TYPE;
            }
        }
        return mCurrentClass.getMethod(str, clsArr).invoke(null, objArr);
    }

    public static Object newInstance(String str, Object[] objArr) {
        Class[] clsArr;
        Class cls = Class.forName(str);
        if (objArr == null) {
            clsArr = null;
        } else {
            clsArr = new Class[objArr.length];
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
        }
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static final boolean setClass(String str) {
        Class<?> cls;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            cls = null;
        }
        mCurrentClass = cls;
        return mCurrentClass != null;
    }
}
