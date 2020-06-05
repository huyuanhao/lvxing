package com.qiyukf.nimlib.p453d.p465e;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.qiyukf.nimlib.p453d.C5744a;
import com.qiyukf.nimlib.p453d.p454a.p456b.C5753a;
import com.qiyukf.nimlib.p453d.p454a.p457c.C5754a;
import com.qiyukf.nimlib.p453d.p462c.C5773a;
import com.qiyukf.nimlib.p453d.p462c.C5773a.C5776a;
import com.qiyukf.nimlib.p453d.p462c.C5777b;
import com.qiyukf.nimlib.p453d.p463d.p464a.C5778a;
import com.qiyukf.nimlib.p453d.p465e.p466a.C5786b;
import com.qiyukf.nimlib.p453d.p465e.p466a.C5786b.C5787a;
import com.qiyukf.nimlib.p453d.p465e.p467b.C5794a;
import com.qiyukf.nimlib.p453d.p465e.p467b.C5794a.C5796a;
import com.qiyukf.nimlib.p453d.p465e.p467b.C5797b.C5798a;
import com.qiyukf.nimlib.p453d.p465e.p467b.C5799c;
import com.qiyukf.nimlib.p453d.p465e.p468c.C5802a;
import com.qiyukf.nimlib.p453d.p465e.p468c.C5802a.C5804a;

/* renamed from: com.qiyukf.nimlib.d.e.b */
abstract class C5788b {
    /* access modifiers changed from: private|static|final */
    /* renamed from: d */
    public static final SparseArray<String> f18423d;
    /* renamed from: a */
    Context f18424a;
    /* renamed from: b */
    C5777b f18425b;
    /* renamed from: c */
    C5778a f18426c;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public Handler f18427e;
    /* renamed from: f */
    private boolean f18428f = false;
    /* renamed from: g */
    private C5794a f18429g;
    /* renamed from: h */
    private C5802a f18430h;
    /* renamed from: i */
    private C5796a f18431i = new C5796a() {
        /* renamed from: a */
        public final void mo28074a(int i) {
            if (C5788b.this.m23257d()) {
                if ((i == C5798a.f18450e || i == C5798a.f18451f) && C5799c.m23280a(C5788b.this.f18424a)) {
                    C5788b.this.m23253b(3);
                }
            }
        }
    };
    /* renamed from: j */
    private C5804a f18432j = new C5804a() {
        /* renamed from: a */
        public final void mo28075a() {
            C5788b.this.m23253b(4);
        }
    };
    /* renamed from: k */
    private C5787a f18433k = new C5787a() {
        /* renamed from: a */
        public final void mo28071a() {
            if (!C5788b.m23258d(C5788b.this)) {
                C5788b.this.m23253b(2);
            }
        }

        /* renamed from: b */
        public final void mo28072b() {
            if (!C5788b.m23258d(C5788b.this)) {
                C5788b.this.m23253b(2);
            }
        }
    };

    static {
        SparseArray<String> sparseArray = new SparseArray<>(10);
        f18423d = sparseArray;
        sparseArray.put(0, "SDK_START");
        f18423d.put(1, "APP_LOGIN");
        f18423d.put(2, "APP_FOREGROUND_BACKGROUND");
        f18423d.put(3, "WIFI_CONNECTED");
        f18423d.put(4, "WIFI_LIST_SCAN_RESULT");
        f18423d.put(5, "GPS_COLLECTED");
        f18423d.put(11, "TIMER_WIFI");
        f18423d.put(12, "TIMER_GPS");
        f18423d.put(13, "TIMER_CELL");
    }

    C5788b() {
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: a */
    public synchronized boolean m23251a() {
        if (!(this.f18425b == null || this.f18427e == null)) {
            if (this.f18424a != null) {
                if (this.f18428f) {
                    C5753a.m23149f("watcher has already started!");
                    return false;
                }
                this.f18429g = new C5794a(this.f18424a.getApplicationContext(), this.f18431i);
                this.f18429g.mo28076a();
                this.f18430h = new C5802a(this.f18424a.getApplicationContext(), this.f18432j);
                this.f18430h.mo28099a();
                if (C5744a.m23125d().mo28022c().f18410b) {
                    C5786b.m23242a(this.f18424a);
                    C5786b.m23243a(this.f18433k);
                } else {
                    C5753a.m23149f("SDKOptions watchAppForegroundBackgroundStatus=false");
                }
                this.f18428f = true;
                C5753a.m23149f("watcher started!");
                return true;
            }
        }
        C5753a.m23149f("unable to start watcher, as context was not prepared");
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23253b(final int i) {
        if (m23257d()) {
            this.f18427e.post(new Runnable() {
                public final void run() {
                    StringBuilder sb = new StringBuilder("onEvent ");
                    sb.append((String) C5788b.f18423d.get(i));
                    C5753a.m23149f(sb.toString());
                    C5788b.this.mo28060a(i);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder("reject event as watcher is not running, event=");
        sb.append(i);
        C5753a.m23149f(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m23257d() {
        if (this.f18428f) {
            C5777b bVar = this.f18425b;
            if (!(bVar == null || !bVar.mo28053i() || this.f18427e == null)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    static /* synthetic */ boolean m23258d(C5788b bVar) {
        if (System.currentTimeMillis() < C5801a.f18456a.mo28079a() + 21600000) {
            return false;
        }
        bVar.m23259e();
        return true;
    }

    /* renamed from: e */
    private synchronized void m23259e() {
        C5753a.m23149f("on strategy timeout, refreshing strategy...");
        mo28062b();
        mo28061a(this.f18424a);
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: f */
    public synchronized void m23260f() {
        m23253b(0);
    }

    /* renamed from: a */
    public abstract void mo28060a(int i);

    /* renamed from: a */
    public void mo28061a(Context context) {
        if (context != null) {
            this.f18424a = context;
            C5773a.m23195a().mo28041a(new C5776a<C5777b>() {
                /* renamed from: a */
                public final void mo28043a(int i, String str) {
                    C5753a.m23149f("unable to start watcher, as fetch strategy from DCServer failed!");
                }

                /* renamed from: a */
                public final /* synthetic */ void mo28044a(Object obj) {
                    C5777b bVar = (C5777b) obj;
                    StringBuilder sb = new StringBuilder("fetch dc strategy=");
                    sb.append(bVar);
                    C5753a.m23149f(sb.toString());
                    C5801a.f18456a.mo28080a(System.currentTimeMillis());
                    if (bVar.mo28053i()) {
                        C5788b bVar2 = C5788b.this;
                        bVar2.f18425b = bVar;
                        bVar2.f18427e = C5754a.m23151a().mo28030a("DC_EVENT");
                        C5753a.m23149f("watcher inited!");
                        if (C5788b.this.m23251a()) {
                            C5788b.this.m23260f();
                        }
                    } else {
                        C5753a.m23149f("DCServer disable client dc!");
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public synchronized void mo28062b() {
        if (!(this.f18425b == null || this.f18427e == null)) {
            if (this.f18424a != null) {
                if (!this.f18428f) {
                    C5753a.m23149f("watcher has already stopped!");
                    return;
                }
                if (this.f18429g != null) {
                    this.f18429g.mo28077b();
                    this.f18429g = null;
                }
                if (this.f18430h != null) {
                    this.f18430h.mo28100b();
                    this.f18430h = null;
                }
                if (C5744a.m23125d().mo28022c().f18410b) {
                    C5786b.m23246b(this.f18433k);
                    C5786b.m23245b(this.f18424a);
                }
                this.f18427e.removeCallbacksAndMessages(null);
                this.f18428f = false;
                this.f18425b = null;
                C5753a.m23149f("watcher stopped!");
                return;
            }
        }
        C5753a.m23149f("unable to stop watcher, as context was not prepared");
    }
}
