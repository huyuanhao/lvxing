package com.qiyukf.nimlib.p453d.p465e.p467b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: com.qiyukf.nimlib.d.e.b.c */
public final class C5799c {
    /* renamed from: a */
    public static boolean m23280a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception unused) {
        }
    }
}
