package com.ksad.download;

import android.content.Context;
import java.io.File;

/* renamed from: com.ksad.download.b */
public final class C3603b {
    /* renamed from: a */
    private static Context f12362a;
    /* renamed from: b */
    private static File f12363b;
    /* renamed from: c */
    private static C3601a f12364c;

    /* renamed from: a */
    public static Context m15023a() {
        return f12362a;
    }

    /* renamed from: a */
    public static void m15024a(Context context) {
        f12362a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static void m15025a(C3601a aVar) {
        f12364c = aVar;
    }

    /* renamed from: a */
    public static void m15026a(File file) {
        f12363b = file;
    }

    /* renamed from: a */
    public static void m15027a(String str) {
        f12364c.installApp(m15023a(), str);
    }

    /* renamed from: b */
    public static File m15028b() {
        return f12363b;
    }
}
