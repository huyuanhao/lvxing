package com.bytedance.sdk.openadsdk.p165c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bytedance.sdk.openadsdk.c.k */
public class OpenAppSuccEvent {
    /* renamed from: a */
    private static volatile OpenAppSuccEvent f6798a;
    /* renamed from: b */
    private C2092c f6799b = C2092c.m8504a();
    /* renamed from: c */
    private Map<String, Object> f6800c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C2091b f6801d;

    /* compiled from: OpenAppSuccEvent */
    /* renamed from: com.bytedance.sdk.openadsdk.c.k$a */
    private class C2090a implements Runnable {
        /* renamed from: b */
        private int f6803b;

        public C2090a(int i) {
            this.f6803b = i;
        }

        public void run() {
            if (this.f6803b == 100 && OpenAppSuccEvent.this.f6801d != null) {
                OpenAppSuccEvent kVar = OpenAppSuccEvent.this;
                kVar.m8497b(kVar.f6801d);
            }
        }
    }

    /* compiled from: OpenAppSuccEvent */
    /* renamed from: com.bytedance.sdk.openadsdk.c.k$b */
    private static class C2091b implements Serializable, Runnable {
        /* renamed from: a */
        public final AtomicInteger f6804a = new AtomicInteger(0);
        /* renamed from: b */
        public final AtomicBoolean f6805b = new AtomicBoolean(false);
        /* renamed from: c */
        public MaterialMeta f6806c;
        /* renamed from: d */
        public String f6807d;
        /* renamed from: e */
        public Map<String, Object> f6808e;

        /* renamed from: a */
        public static C2091b m8500a(MaterialMeta kVar, String str, Map<String, Object> map) {
            return new C2091b(kVar, str, map);
        }

        public C2091b() {
        }

        public C2091b(MaterialMeta kVar, String str, Map<String, Object> map) {
            this.f6806c = kVar;
            this.f6807d = str;
            this.f6808e = map;
        }

        /* renamed from: a */
        public C2091b mo15035a(boolean z) {
            this.f6805b.set(z);
            return this;
        }

        /* renamed from: a */
        public int mo15034a() {
            return this.f6804a.get();
        }

        /* renamed from: b */
        public void mo15036b() {
            this.f6804a.incrementAndGet();
        }

        public void run() {
            if (this.f6806c == null || TextUtils.isEmpty(this.f6807d)) {
                C2564t.m12214a("materialMeta or eventTag is null, pls check");
            } else {
                AdEventManager.m8417p(InternalContainer.m10059a(), this.f6806c, this.f6807d, this.f6805b.get() ? "dpl_success" : "dpl_failed", this.f6808e);
            }
        }
    }

    /* compiled from: OpenAppSuccEvent */
    /* renamed from: com.bytedance.sdk.openadsdk.c.k$c */
    private static class C2092c {
        /* renamed from: a */
        public int f6809a = 500;
        /* renamed from: b */
        public int f6810b = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;

        /* renamed from: a */
        public static C2092c m8504a() {
            return new C2092c();
        }
    }

    /* renamed from: a */
    public static OpenAppSuccEvent m8494a() {
        if (f6798a == null) {
            synchronized (OpenAppSuccEvent.class) {
                if (f6798a == null) {
                    f6798a = new OpenAppSuccEvent();
                }
            }
        }
        return f6798a;
    }

    private OpenAppSuccEvent() {
    }

    /* renamed from: a */
    public void mo15032a(MaterialMeta kVar, String str) {
        this.f6801d = C2091b.m8500a(kVar, str, this.f6800c);
        TTExecutor.m11692a().mo16802a((Runnable) new C2090a(100), 0);
    }

    /* renamed from: a */
    private void m8495a(C2091b bVar) {
        if (bVar != null) {
            bVar.mo15036b();
            if (bVar.mo15034a() * this.f6799b.f6809a > this.f6799b.f6810b) {
                m8498c(bVar.mo15035a(false));
            } else {
                TTExecutor.m11692a().mo16802a((Runnable) new C2090a(100), (long) this.f6799b.f6809a);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8497b(C2091b bVar) {
        if (bVar != null) {
            Context a = InternalContainer.m10059a();
            if (ToolUtils.m12020d(a, a.getPackageName())) {
                m8495a(bVar);
            } else {
                m8498c(bVar.mo15035a(true));
            }
        }
    }

    /* renamed from: c */
    private void m8498c(C2091b bVar) {
        if (bVar != null) {
            TTExecutor.m11692a().mo16809d(bVar, 5);
        }
    }
}
