package com.tencent.dynamicbundle.reflect;

import android.util.Log;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.stat.common.StatConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class RefClass {
    private static HashMap<Class<?>, Constructor<?>> REF_TYPES = new HashMap<>();

    static {
        try {
            REF_TYPES.put(RefObject.class, RefObject.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefMethod.class, RefMethod.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefInt.class, RefInt.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefLong.class, RefLong.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefFloat.class, RefFloat.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefDouble.class, RefDouble.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefBoolean.class, RefBoolean.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefStaticObject.class, RefStaticObject.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefStaticInt.class, RefStaticInt.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefStaticFloat.class, RefStaticFloat.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefStaticMethod.class, RefStaticMethod.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefConstructor.class, RefConstructor.class.getConstructor(new Class[]{Class.class, Field.class}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Class<?> load(Class<?> cls, String str) {
        try {
            return load((Class) cls, Class.forName(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Class<?> load(Class<?> cls, String str, ClassLoader classLoader) {
        String str2 = StatConstants.LOG_TAG;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("load mappingClass:");
            sb.append(cls);
            sb.append(",className:");
            sb.append(str);
            sb.append(",classLoader:");
            sb.append(classLoader);
            Log.e(str2, sb.toString());
            return load((Class) cls, Class.forName(str, false, classLoader));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Class load(Class cls, Class<?> cls2) {
        Field[] declaredFields;
        String str = "newInstance field:";
        String str2 = StatConstants.LOG_TAG;
        for (Field field : cls.getDeclaredFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(field.getType());
                    sb.append(StorageInterface.KEY_SPLITER);
                    sb.append(field.getName());
                    Log.e(str2, sb.toString());
                    Constructor constructor = (Constructor) REF_TYPES.get(field.getType());
                    if (constructor != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(field);
                        Log.e(str2, sb2.toString());
                        field.set(null, constructor.newInstance(new Object[]{cls2, field}));
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append(field);
                        sb3.append(" end.");
                        Log.e(str2, sb3.toString());
                    }
                }
            } catch (Exception e) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("load mappingClass error:");
                sb4.append(cls);
                sb4.append(",realClass:");
                sb4.append(cls2);
                Log.e(str2, sb4.toString(), e);
            }
        }
        return cls2;
    }
}
