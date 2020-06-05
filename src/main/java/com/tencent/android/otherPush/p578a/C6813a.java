package com.tencent.android.otherPush.p578a;

import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.otherPush.a.a */
public class C6813a extends ClassLoader {
    /* renamed from: a */
    private final C6815a f22617a;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.otherPush.a.a$a */
    private static class C6815a extends BaseDexClassLoader {
        private C6815a(String str, File file, String str2, ClassLoader classLoader) {
            super(str, file, str2, classLoader);
        }

        public Class<?> findClass(String str) {
            return super.findClass(str);
        }
    }

    public C6813a(ClassLoader classLoader, String str, File file, String str2, List<String> list) {
        super(classLoader.getParent());
        this.f22617a = m29180a(file, str2, list, classLoader);
    }

    public Class<?> findClass(String str) {
        return this.f22617a.findClass(str);
    }

    /* renamed from: a */
    private static C6815a m29180a(File file, String str, List<String> list, ClassLoader classLoader) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str2 : list) {
            if (z) {
                z = false;
            } else {
                sb.append(File.pathSeparator);
            }
            sb.append(str2);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Incremental dex path is ");
        sb2.append(sb);
        String str3 = "IncrementalClassLoader";
        Log.v(str3, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Native lib dir is ");
        sb3.append(str);
        Log.v(str3, sb3.toString());
        C6815a aVar = new C6815a(sb.toString(), file, str, classLoader);
        return aVar;
    }

    /* renamed from: a */
    private static void m29181a(ClassLoader classLoader, ClassLoader classLoader2) {
        try {
            Field declaredField = ClassLoader.class.getDeclaredField("parent");
            declaredField.setAccessible(true);
            declaredField.set(classLoader, classLoader2);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static void m29182a(ClassLoader classLoader, String str, File file, String str2, List<String> list) {
        C6813a aVar = new C6813a(classLoader, str, file, str2, list);
        m29181a(classLoader, aVar);
    }
}
