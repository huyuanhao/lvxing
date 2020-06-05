package com.alipay.p109b.p110a.p111a.p114b;

import android.os.Environment;
import java.io.File;

/* renamed from: com.alipay.b.a.a.b.c */
public final class C1467c {
    /* renamed from: a */
    public static String m4283a(String str) {
        try {
            if (m4284a()) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), str);
                if (file.exists()) {
                    file.delete();
                    return "";
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m4284a() {
        String externalStorageState = Environment.getExternalStorageState();
        return externalStorageState != null && externalStorageState.length() > 0 && (externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) && Environment.getExternalStorageDirectory() != null;
    }
}
