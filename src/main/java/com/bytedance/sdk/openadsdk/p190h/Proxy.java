package com.bytedance.sdk.openadsdk.p190h;

import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.p190h.p191a.C2441b;
import com.bytedance.sdk.openadsdk.p190h.p191a.C2443c;
import com.bytedance.sdk.openadsdk.p190h.p191a.C2443c.C2450a;
import com.bytedance.sdk.openadsdk.p190h.p192b.VideoProxyDB;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.util.Collection;
import java.util.Set;

/* renamed from: com.bytedance.sdk.openadsdk.h.e */
public class Proxy {
    /* renamed from: a */
    static volatile C2441b f8834a;
    /* renamed from: b */
    static volatile C2443c f8835b;
    /* renamed from: c */
    public static final boolean f8836c = C2564t.m12224c();
    /* renamed from: d */
    public static volatile boolean f8837d;
    /* renamed from: e */
    static volatile boolean f8838e = true;
    /* renamed from: f */
    static volatile boolean f8839f;
    /* renamed from: g */
    static volatile int f8840g = 0;
    /* renamed from: h */
    public static volatile int f8841h = 3;
    /* renamed from: i */
    public static volatile Integer f8842i;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: j */
    public static volatile VideoProxyDB f8843j;
    /* renamed from: k */
    private static volatile Context f8844k;

    /* renamed from: a */
    public static Context m11537a() {
        return f8844k;
    }

    /* renamed from: a */
    public static void m11540a(boolean z) {
        f8838e = z;
    }

    /* renamed from: b */
    public static void m11542b(boolean z) {
        f8839f = z;
    }

    /* renamed from: a */
    public static void m11538a(int i) {
        f8840g = i;
    }

    /* renamed from: a */
    public static void m11539a(C2443c cVar, Context context) {
        if (cVar == null || context == null) {
            throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
        }
        f8844k = context.getApplicationContext();
        if (f8835b == null) {
            C2441b bVar = f8834a;
            if (bVar == null || !bVar.f8750a.getAbsolutePath().equals(cVar.f8752a.getAbsolutePath())) {
                f8835b = cVar;
                f8843j = VideoProxyDB.m11510a(context);
                f8835b.mo16682a((C2450a) new C2450a() {
                    /* renamed from: a */
                    public void mo16690a(String str) {
                        if (Proxy.f8836c) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("new cache created: ");
                            sb.append(str);
                            Log.i("TAG_PROXY_DiskLruCache", sb.toString());
                        }
                    }

                    /* renamed from: a */
                    public void mo16691a(Set<String> set) {
                        Proxy.f8843j.mo16713a((Collection<String>) set, 0);
                        if (Proxy.f8836c) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("cache file removed, ");
                            sb.append(set);
                            Log.i("TAG_PROXY_DiskLruCache", sb.toString());
                        }
                    }
                });
                ProxyServer a = ProxyServer.m11573a();
                a.mo16754a(cVar);
                a.mo16755a(f8843j);
                Preloader c = Preloader.m11521c();
                c.mo16722a(cVar);
                c.mo16723a(f8843j);
                return;
            }
            throw new IllegalArgumentException("DiskLruCache 和 DiskCache 不能使用相同的目录");
        }
    }

    /* renamed from: b */
    public static C2443c m11541b() {
        return f8835b;
    }

    /* renamed from: c */
    public static C2441b m11543c() {
        return f8834a;
    }
}
