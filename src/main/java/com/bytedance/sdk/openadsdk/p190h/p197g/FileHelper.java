package com.bytedance.sdk.openadsdk.p190h.p197g;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* renamed from: com.bytedance.sdk.openadsdk.h.g.a */
public class FileHelper {
    /* renamed from: a */
    static Context f8908a;

    /* renamed from: a */
    public static void m11640a(Context context) {
        if (context != null) {
            f8908a = context;
            return;
        }
        throw new NullPointerException();
    }

    @Deprecated
    /* renamed from: a */
    public static File m11638a() {
        return m11643b(f8908a);
    }

    /* renamed from: b */
    public static File m11643b(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        return externalCacheDir == null ? context.getCacheDir() : externalCacheDir;
    }

    /* renamed from: b */
    public static File m11642b() {
        if (!m11644c() || !m11645d()) {
            return null;
        }
        File file = new File(m11638a(), "video");
        m11641a(file);
        return file;
    }

    /* renamed from: a */
    public static File m11639a(File file, String str) {
        if (!m11644c() || !m11645d() || TextUtils.isEmpty(str)) {
            return null;
        }
        if (file == null) {
            file = m11638a();
        }
        File file2 = new File(file, str);
        m11641a(file2);
        return file2;
    }

    /* renamed from: a */
    public static void m11641a(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /* renamed from: c */
    public static boolean m11644c() {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        } catch (Exception unused) {
            return StorageList.m11649a().mo16785b();
        }
    }

    /* renamed from: d */
    public static boolean m11645d() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }
}
