package com.pgl.sys.ces;

import android.content.Context;

/* renamed from: com.pgl.sys.ces.a */
public final class C4795a {
    static {
        try {
            System.loadLibrary("nms");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static native Object meta(int i, Context context, Object obj);

    public static Object njss(int i, Object obj) {
        try {
            return C4804b.m19658a().mo25741a(i, obj);
        } catch (Throwable unused) {
            return null;
        }
    }
}
