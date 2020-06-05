package com.p235fm.openinstall;

import android.content.Intent;
import com.p235fm.openinstall.p238c.C2618b;
import com.p235fm.openinstall.p239d.C2621b;
import p655io.openinstall.C8069a;

/* renamed from: com.fm.openinstall.a */
public class C2611a {
    /* renamed from: a */
    private static C8069a f9466a = null;
    /* renamed from: b */
    private static volatile boolean f9467b = false;

    /* renamed from: a */
    private static boolean m12711a() {
        if (f9467b) {
            return true;
        }
        if (C2618b.f9489a) {
            C2618b.m12721b("请先调用 init(Context) 初始化", new Object[0]);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m12712a(Intent intent) {
        return f9466a.mo38814a(intent);
    }

    /* renamed from: a */
    public static boolean m12713a(Intent intent, C2621b bVar) {
        if (!m12711a() || !m12712a(intent)) {
            return false;
        }
        f9466a.mo38813a(bVar);
        return true;
    }
}
