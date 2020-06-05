package com.bytedance.tea.crash.p221g;

import android.util.Log;
import com.bytedance.tea.crash.NpthBus;

/* renamed from: com.bytedance.tea.crash.g.j */
public final class NpthLog {
    /* renamed from: a */
    public static void m12548a(String str) {
        if (NpthBus.m12596e().mo17045d()) {
            Log.i("npth", str);
        }
    }

    /* renamed from: a */
    public static void m12549a(Throwable th) {
        if (NpthBus.m12596e().mo17045d()) {
            Log.e("npth", "NPTH Catch Error", th);
        }
    }

    /* renamed from: b */
    public static void m12550b(Throwable th) {
        if (NpthBus.m12596e().mo17045d()) {
            Log.w("npth", "NPTH Catch Error", th);
        }
    }
}
