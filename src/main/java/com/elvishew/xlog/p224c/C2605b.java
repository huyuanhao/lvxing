package com.elvishew.xlog.p224c;

import android.os.Build.VERSION;
import android.util.Log;
import com.elvishew.xlog.p226d.AndroidPrinter;
import com.elvishew.xlog.p226d.ConsolePrinter;
import com.elvishew.xlog.p226d.Printer;

/* compiled from: Platform */
/* renamed from: com.elvishew.xlog.c.b */
public class C2605b {
    /* renamed from: a */
    private static final C2605b f9455a = m12671d();

    /* compiled from: Platform */
    /* renamed from: com.elvishew.xlog.c.b$a */
    static class C2606a extends C2605b {
        C2606a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public String mo17092b() {
            if (VERSION.SDK_INT < 19) {
                return "\n";
            }
            return System.lineSeparator();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public Printer mo17093c() {
            return new AndroidPrinter();
        }

        /* renamed from: a */
        public void mo17091a(String str) {
            Log.w("XLog", str);
        }
    }

    /* renamed from: a */
    public static C2605b m12670a() {
        return f9455a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo17092b() {
        return System.lineSeparator();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Printer mo17093c() {
        return new ConsolePrinter();
    }

    /* renamed from: a */
    public void mo17091a(String str) {
        System.out.println(str);
    }

    /* renamed from: d */
    private static C2605b m12671d() {
        try {
            Class.forName("android.os.Build");
            if (VERSION.SDK_INT != 0) {
                return new C2606a();
            }
        } catch (ClassNotFoundException unused) {
        }
        return new C2605b();
    }
}
