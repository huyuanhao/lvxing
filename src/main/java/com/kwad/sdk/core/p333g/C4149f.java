package com.kwad.sdk.core.p333g;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.core.p317a.C4057a;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4146d.C4147a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kwad.sdk.core.g.f */
public class C4149f {
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: a */
    public static volatile long f13831a = 120000;
    /* renamed from: b */
    private static HandlerThread f13832b = null;
    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static Handler f13833c = null;
    /* renamed from: d */
    private static volatile boolean f13834d = false;
    /* access modifiers changed from: private|static */
    /* renamed from: e */
    public static C4154g f13835e = new C4155h();
    /* renamed from: f */
    private static ExecutorService f13836f = null;
    /* access modifiers changed from: private|static */
    /* renamed from: g */
    public static Context f13837g;

    /* renamed from: com.kwad.sdk.core.g.f$a */
    private static class C4153a implements Runnable {
        C4153a() {
        }

        /* renamed from: a */
        private List<List<C4156i>> m17198a(List<C4156i> list, int i) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < list.size()) {
                int i3 = i2 + i;
                arrayList.add(list.subList(i2, i3 > list.size() ? list.size() : i3));
                i2 = i3;
            }
            return arrayList;
        }

        /* renamed from: a */
        private void m17199a(List<C4156i> list) {
            List a = m17198a(list, 200);
            int size = a.size();
            for (int i = 0; i < size; i++) {
                List list2 = (List) a.get(i);
                if (!list2.isEmpty()) {
                    C4149f.m17187b(list2);
                }
            }
        }

        public void run() {
            if (C3607b.m15045a(C4149f.f13837g)) {
                List b = C4149f.f13835e.mo23856b();
                if (b != null && !b.isEmpty()) {
                    m17199a(b);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m17180a() {
        f13833c.removeMessages(16843025);
        m17189c(0);
    }

    /* renamed from: a */
    static void m17181a(long j) {
        f13831a = j < 60 ? 60000 : j * 1000;
    }

    /* renamed from: a */
    public static void m17182a(Context context) {
        if (!f13834d) {
            f13837g = context;
            C4160k.m17224a(context);
            C4160k.m17223a();
            if (C4057a.m16822b(context) == 1) {
                f13835e = C4159j.m17216a(context);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            f13836f = threadPoolExecutor;
            f13832b = new HandlerThread("batch-report");
            f13832b.start();
            f13833c = new Handler(f13832b.getLooper());
            f13834d = true;
        }
    }

    /* renamed from: a */
    public static void m17183a(final C4142a aVar) {
        if (aVar != null) {
            f13836f.execute(new Runnable() {
                public void run() {
                    C4065b.m16863a("BatchReporter", "AddActionTask run");
                    if (!C4149f.f13833c.hasMessages(16843025)) {
                        C4149f.m17189c(C4149f.f13831a);
                    }
                    C4149f.f13835e.mo23854a(C4156i.m17208a(aVar));
                    if (C4149f.m17193g()) {
                        C4149f.m17180a();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m17187b(final List<C4156i> list) {
        if (list != null && list.size() > 0) {
            new C4146d(new C4147a() {
                /* renamed from: a */
                public void mo23847a(long j) {
                    C4149f.m17181a(j);
                    C4149f.m17189c(C4149f.f13831a);
                }

                /* renamed from: a */
                public void mo23848a(long j, String str) {
                    C4149f.f13835e.mo23855a(list);
                    C4149f.m17189c(C4149f.f13831a);
                }
            }) {
                /* access modifiers changed from: protected */
                /* renamed from: d */
                public C4148e mo23795a() {
                    return new C4148e(list);
                }
            }.mo23797b();
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static void m17189c(long j) {
        Message obtain = Message.obtain(f13833c, new C4153a());
        obtain.what = 16843025;
        f13833c.sendMessageDelayed(obtain, j);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: g */
    public static boolean m17193g() {
        return f13835e.mo23853a() >= ((long) C4057a.m16835l());
    }
}
