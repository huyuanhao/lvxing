package com.bytedance.sdk.openadsdk.p190h.p191a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.p190h.Preloader;
import com.bytedance.sdk.openadsdk.p190h.Proxy;
import com.bytedance.sdk.openadsdk.p190h.p192b.VideoProxyDB;
import com.bytedance.sdk.openadsdk.p190h.p197g.C2479d;
import java.io.File;

/* compiled from: DiskCache */
/* renamed from: com.bytedance.sdk.openadsdk.h.a.b */
public class C2441b extends C2440a {
    /* renamed from: a */
    public final File f8750a;

    /* renamed from: a */
    public void mo16676a() {
        C2479d.m11664a((Runnable) new Runnable() {
            public void run() {
                C2441b.this.mo16677b();
            }
        });
    }

    /* renamed from: b */
    public void mo16677b() {
        Preloader.m11521c().mo16730d();
        Context a = Proxy.m11537a();
        if (a != null) {
            VideoProxyDB.m11510a(a).mo16711a(1);
        }
        for (File delete : this.f8750a.listFiles()) {
            try {
                delete.delete();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: c */
    public File mo16674c(String str) {
        return mo16678e(str);
    }

    /* renamed from: d */
    public File mo16675d(String str) {
        return mo16678e(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public File mo16678e(String str) {
        return new File(this.f8750a, str);
    }
}
