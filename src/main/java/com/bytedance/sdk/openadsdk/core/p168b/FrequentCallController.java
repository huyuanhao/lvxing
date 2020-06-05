package com.bytedance.sdk.openadsdk.core.p168b;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p174h.TTSdkSettings;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.bytedance.sdk.openadsdk.core.b.a */
public class FrequentCallController {
    /* renamed from: a */
    private static volatile FrequentCallController f7240a;
    /* renamed from: b */
    private static volatile boolean f7241b;
    /* renamed from: c */
    private static volatile long f7242c;
    /* renamed from: d */
    private final Queue<C2206a> f7243d = new LinkedList();
    /* renamed from: e */
    private Handler f7244e;
    /* renamed from: f */
    private final TTSdkSettings f7245f = InternalContainer.m10069h();

    /* compiled from: FrequentCallController */
    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a */
    private static class C2206a {
        /* access modifiers changed from: private|final */
        /* renamed from: a */
        public final long f7247a;
        /* access modifiers changed from: private|final */
        /* renamed from: b */
        public final String f7248b;

        private C2206a(long j, String str) {
            this.f7247a = j;
            this.f7248b = str;
        }
    }

    private FrequentCallController() {
    }

    /* renamed from: a */
    public static FrequentCallController m9090a() {
        if (f7240a == null) {
            synchronized (FrequentCallController.class) {
                if (f7240a == null) {
                    f7240a = new FrequentCallController();
                }
            }
        }
        return f7240a;
    }

    /* renamed from: b */
    private synchronized boolean m9095b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int l = this.f7245f.mo15799l();
        long k = this.f7245f.mo15798k();
        if (this.f7243d.size() <= 0 || this.f7243d.size() < l) {
            this.f7243d.offer(new C2206a(currentTimeMillis, str));
        } else {
            long abs = Math.abs(currentTimeMillis - ((C2206a) this.f7243d.peek()).f7247a);
            if (abs <= k) {
                m9094b(k - abs);
                return true;
            }
            this.f7243d.poll();
            this.f7243d.offer(new C2206a(currentTimeMillis, str));
        }
        return false;
    }

    /* renamed from: a */
    public synchronized boolean mo15290a(String str) {
        if (m9095b(str)) {
            m9093a(true);
            m9091a(f7242c);
        } else {
            m9093a(false);
        }
        return f7241b;
    }

    /* renamed from: a */
    private synchronized void m9091a(long j) {
        if (this.f7244e == null) {
            this.f7244e = new Handler(Looper.getMainLooper());
        }
        this.f7244e.postDelayed(new Runnable() {
            public void run() {
                FrequentCallController.this.m9093a(false);
            }
        }, j);
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: a */
    public synchronized void m9093a(boolean z) {
        f7241b = z;
    }

    /* renamed from: b */
    public synchronized boolean mo15291b() {
        return f7241b;
    }

    /* renamed from: b */
    private synchronized void m9094b(long j) {
        f7242c = j;
    }

    /* renamed from: c */
    public synchronized String mo15292c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C2206a aVar : this.f7243d) {
            if (hashMap.containsKey(aVar.f7248b)) {
                hashMap.put(aVar.f7248b, Integer.valueOf(((Integer) hashMap.get(aVar.f7248b)).intValue() + 1));
            } else {
                hashMap.put(aVar.f7248b, Integer.valueOf(1));
            }
        }
        int i = Integer.MIN_VALUE;
        str = "";
        for (String str2 : hashMap.keySet()) {
            int intValue = ((Integer) hashMap.get(str2)).intValue();
            if (i < intValue) {
                str = str2;
                i = intValue;
            }
        }
        return str;
    }
}
