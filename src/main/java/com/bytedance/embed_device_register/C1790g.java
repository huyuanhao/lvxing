package com.bytedance.embed_device_register;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.embedapplog.IOaidObserver;
import com.bytedance.embedapplog.IOaidObserver.Oaid;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.embed_device_register.g */
final class C1790g {
    /* renamed from: a */
    private static final String f4965a;
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static Map<String, String> f4966b = null;
    /* renamed from: c */
    private static IOaidObserver f4967c;
    /* renamed from: d */
    private static final C1789f f4968d = new C1789f() {
        /* renamed from: a */
        public void mo13270a(Map<String, String> map) {
            C1790g.f4966b = map;
            C1790g.m6219b(new Oaid((String) map.get("id")));
        }
    };

    /* renamed from: com.bytedance.embed_device_register.g$a */
    private static class C1792a implements C1793b<C1787a> {
        /* renamed from: a */
        private final C1795h<C1787a> f4969a;
        /* renamed from: b */
        private final CountDownLatch f4970b;
        /* renamed from: c */
        private final C1789f f4971c;

        C1792a(C1795h<C1787a> hVar, CountDownLatch countDownLatch, C1789f fVar) {
            this.f4969a = hVar;
            this.f4970b = countDownLatch;
            this.f4971c = fVar;
        }

        /* renamed from: a */
        public void mo13272a(C1787a aVar) {
            this.f4969a.f4975a = aVar;
            if (aVar != null) {
                Map a = aVar.mo13258a();
                if (a != null) {
                    this.f4971c.mo13270a(a);
                }
            }
            this.f4970b.countDown();
        }
    }

    /* renamed from: com.bytedance.embed_device_register.g$b */
    interface C1793b<T> {
        /* renamed from: a */
        void mo13272a(T t);
    }

    /* renamed from: com.bytedance.embed_device_register.g$c */
    private static class C1794c implements C1793b<C1800b> {
        /* renamed from: a */
        private final C1795h<C1800b> f4972a;
        /* renamed from: b */
        private final CountDownLatch f4973b;
        /* renamed from: c */
        private final C1789f f4974c;

        C1794c(C1795h<C1800b> hVar, CountDownLatch countDownLatch, C1789f fVar) {
            this.f4972a = hVar;
            this.f4973b = countDownLatch;
            this.f4974c = fVar;
        }

        /* renamed from: a */
        public void mo13272a(C1800b bVar) {
            this.f4972a.f4975a = bVar;
            if (bVar != null) {
                Map b = bVar.mo13279b();
                if (b != null) {
                    this.f4974c.mo13270a(b);
                }
            }
            this.f4973b.countDown();
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(C1790g.class.getSimpleName());
        sb.append("#");
        f4965a = sb.toString();
    }

    /* renamed from: a */
    static void m6215a(Context context, SharedPreferences sharedPreferences) {
        C1783e.m6188a(context, sharedPreferences);
        C1796i.m6230a(context, sharedPreferences);
    }

    /* renamed from: b */
    static Map<String, String> m6218b(Context context, SharedPreferences sharedPreferences) {
        Map<String, String> map;
        C1800b d = m6221d(context, sharedPreferences);
        if (d != null) {
            map = d.mo13279b();
        } else {
            C1787a c = m6220c(context, sharedPreferences);
            map = c != null ? c.mo13258a() : null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Oaid#getOaid result=");
        sb.append(map);
        C1780c.m6176a("TrackerDr", sb.toString());
        f4966b = map;
        return map;
    }

    /* renamed from: a */
    static void m6217a(IOaidObserver iOaidObserver) {
        f4967c = iOaidObserver;
        Map<String, String> map = f4966b;
        if (map != null) {
            m6219b(new Oaid((String) map.get("id")));
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m6219b(Oaid oaid) {
        if (oaid != null) {
            IOaidObserver iOaidObserver = f4967c;
            if (iOaidObserver != null) {
                iOaidObserver.onOaidLoaded(oaid);
            }
        }
    }

    private C1790g() {
    }

    /* renamed from: c */
    private static C1787a m6220c(Context context, SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(f4965a);
        sb.append("getHuaweiOaid: ");
        String str = "TrackerDr";
        C1780c.m6176a(str, sb.toString());
        String str2 = null;
        if (context == null || sharedPreferences == null || !C1783e.m6189a(context)) {
            return null;
        }
        C1783e b = C1783e.m6192b(context, sharedPreferences);
        C1787a a = b.mo13252a();
        if (a != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f4965a);
            sb2.append("getHuaweiOaid: return cache=");
            sb2.append(a.mo13259b());
            C1780c.m6176a(str, sb2.toString());
            return a;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C1795h hVar = new C1795h();
        b.mo13253a((C1793b) new C1792a(hVar, countDownLatch, f4968d));
        try {
            countDownLatch.await(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(f4965a);
        sb3.append("getHuaweiOaid: return waited=");
        if (hVar.f4975a != null) {
            str2 = ((C1787a) hVar.f4975a).mo13259b();
        }
        sb3.append(str2);
        C1780c.m6176a(str, sb3.toString());
        return (C1787a) hVar.f4975a;
    }

    /* renamed from: d */
    private static C1800b m6221d(Context context, SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(f4965a);
        sb.append("getXmOaid: ");
        String str = "TrackerDr";
        C1780c.m6176a(str, sb.toString());
        String str2 = null;
        if (context == null || sharedPreferences == null || !C1799a.m6238a()) {
            return null;
        }
        C1796i b = C1796i.m6232b(context, sharedPreferences);
        C1800b a = b.mo13274a();
        if (a != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f4965a);
            sb2.append("getXmOaid: return cache=");
            sb2.append(a.mo13278a());
            C1780c.m6176a(str, sb2.toString());
            return a;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C1795h hVar = new C1795h();
        b.mo13275a((C1793b) new C1794c(hVar, countDownLatch, f4968d));
        try {
            countDownLatch.await(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(f4965a);
        sb3.append("getHuaweiOaid: return waited=");
        if (hVar.f4975a != null) {
            str2 = ((C1800b) hVar.f4975a).mo13278a();
        }
        sb3.append(str2);
        C1780c.m6176a(str, sb3.toString());
        return (C1800b) hVar.f4975a;
    }
}
