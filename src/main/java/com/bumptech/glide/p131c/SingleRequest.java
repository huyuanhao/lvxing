package com.bumptech.glide.p131c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.Engine.C1688d;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.p131c.p132a.SizeReadyCallback;
import com.bumptech.glide.p131c.p132a.Target;
import com.bumptech.glide.p131c.p133b.TransitionFactory;
import com.bumptech.glide.util.C1772j;
import com.bumptech.glide.util.p140a.FactoryPools;
import com.bumptech.glide.util.p140a.FactoryPools.C1764a;
import com.bumptech.glide.util.p140a.FactoryPools.C1766c;
import com.bumptech.glide.util.p140a.StateVerifier;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.bumptech.glide.c.h */
public final class SingleRequest<R> implements SizeReadyCallback, Request, ResourceCallback, C1766c {
    /* renamed from: a */
    private static final Pool<SingleRequest<?>> f4224a = FactoryPools.m6095a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, (C1764a<T>) new C1764a<SingleRequest<?>>() {
        /* renamed from: a */
        public SingleRequest<?> mo12521b() {
            return new SingleRequest<>();
        }
    });
    /* renamed from: c */
    private static final boolean f4225c = Log.isLoggable("Request", 2);
    /* renamed from: A */
    private Drawable f4226A;
    /* renamed from: B */
    private int f4227B;
    /* renamed from: C */
    private int f4228C;
    /* renamed from: D */
    private RuntimeException f4229D;
    /* renamed from: b */
    private boolean f4230b;
    /* renamed from: d */
    private final String f4231d;
    /* renamed from: e */
    private final StateVerifier f4232e;
    /* renamed from: f */
    private RequestListener<R> f4233f;
    /* renamed from: g */
    private RequestCoordinator f4234g;
    /* renamed from: h */
    private Context f4235h;
    /* renamed from: i */
    private GlideContext f4236i;
    /* renamed from: j */
    private Object f4237j;
    /* renamed from: k */
    private Class<R> f4238k;
    /* renamed from: l */
    private BaseRequestOptions<?> f4239l;
    /* renamed from: m */
    private int f4240m;
    /* renamed from: n */
    private int f4241n;
    /* renamed from: o */
    private Priority f4242o;
    /* renamed from: p */
    private Target<R> f4243p;
    /* renamed from: q */
    private List<RequestListener<R>> f4244q;
    /* renamed from: r */
    private Engine f4245r;
    /* renamed from: s */
    private TransitionFactory<? super R> f4246s;
    /* renamed from: t */
    private Executor f4247t;
    /* renamed from: u */
    private Resource<R> f4248u;
    /* renamed from: v */
    private C1688d f4249v;
    /* renamed from: w */
    private long f4250w;
    /* renamed from: x */
    private C1616a f4251x;
    /* renamed from: y */
    private Drawable f4252y;
    /* renamed from: z */
    private Drawable f4253z;

    /* compiled from: SingleRequest */
    /* renamed from: com.bumptech.glide.c.h$a */
    private enum C1616a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    /* renamed from: a */
    public static <R> SingleRequest<R> m5110a(Context context, GlideContext gVar, Object obj, Class<R> cls, BaseRequestOptions<?> aVar, int i, int i2, Priority priority, Target<R> hVar, RequestListener<R> eVar, List<RequestListener<R>> list, RequestCoordinator dVar, Engine kVar, TransitionFactory<? super R> gVar2, Executor executor) {
        SingleRequest<R> hVar2 = (SingleRequest) f4224a.acquire();
        if (hVar2 == null) {
            hVar2 = new SingleRequest<>();
        }
        hVar2.m5116b(context, gVar, obj, cls, aVar, i, i2, priority, hVar, eVar, list, dVar, kVar, gVar2, executor);
        return hVar2;
    }

    SingleRequest() {
        this.f4231d = f4225c ? String.valueOf(super.hashCode()) : null;
        this.f4232e = StateVerifier.m6111a();
    }

    /* renamed from: b */
    private synchronized void m5116b(Context context, GlideContext gVar, Object obj, Class<R> cls, BaseRequestOptions<?> aVar, int i, int i2, Priority priority, Target<R> hVar, RequestListener<R> eVar, List<RequestListener<R>> list, RequestCoordinator dVar, Engine kVar, TransitionFactory<? super R> gVar2, Executor executor) {
        this.f4235h = context;
        this.f4236i = gVar;
        this.f4237j = obj;
        this.f4238k = cls;
        this.f4239l = aVar;
        this.f4240m = i;
        this.f4241n = i2;
        this.f4242o = priority;
        this.f4243p = hVar;
        this.f4233f = eVar;
        this.f4244q = list;
        this.f4234g = dVar;
        this.f4245r = kVar;
        this.f4246s = gVar2;
        this.f4247t = executor;
        this.f4251x = C1616a.PENDING;
        if (this.f4229D == null && gVar.mo12553g()) {
            this.f4229D = new RuntimeException("Glide request origin trace");
        }
    }

    /* renamed from: d */
    public StateVerifier mo12519d() {
        return this.f4232e;
    }

    /* renamed from: h */
    public synchronized void mo12503h() {
        m5118j();
        this.f4235h = null;
        this.f4236i = null;
        this.f4237j = null;
        this.f4238k = null;
        this.f4239l = null;
        this.f4240m = -1;
        this.f4241n = -1;
        this.f4243p = null;
        this.f4244q = null;
        this.f4233f = null;
        this.f4234g = null;
        this.f4246s = null;
        this.f4249v = null;
        this.f4252y = null;
        this.f4253z = null;
        this.f4226A = null;
        this.f4227B = -1;
        this.f4228C = -1;
        this.f4229D = null;
        f4224a.release(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a4, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo12490a() {
        /*
        r3 = this;
        monitor-enter(r3)
        r3.m5118j()     // Catch:{ all -> 0x00ad }
        com.bumptech.glide.util.a.c r0 = r3.f4232e     // Catch:{ all -> 0x00ad }
        r0.mo13207b()     // Catch:{ all -> 0x00ad }
        long r0 = com.bumptech.glide.util.LogTime.m6125a()     // Catch:{ all -> 0x00ad }
        r3.f4250w = r0     // Catch:{ all -> 0x00ad }
        java.lang.Object r0 = r3.f4237j     // Catch:{ all -> 0x00ad }
        if (r0 != 0) goto L_0x003a
        int r0 = r3.f4240m     // Catch:{ all -> 0x00ad }
        int r1 = r3.f4241n     // Catch:{ all -> 0x00ad }
        boolean r0 = com.bumptech.glide.util.C1772j.m6155a(r0, r1)     // Catch:{ all -> 0x00ad }
        if (r0 == 0) goto L_0x0025
        int r0 = r3.f4240m     // Catch:{ all -> 0x00ad }
        r3.f4227B = r0     // Catch:{ all -> 0x00ad }
        int r0 = r3.f4241n     // Catch:{ all -> 0x00ad }
        r3.f4228C = r0     // Catch:{ all -> 0x00ad }
    L_0x0025:
        android.graphics.drawable.Drawable r0 = r3.m5121m()     // Catch:{ all -> 0x00ad }
        if (r0 != 0) goto L_0x002d
        r0 = 5
        goto L_0x002e
    L_0x002d:
        r0 = 3
    L_0x002e:
        com.bumptech.glide.load.engine.GlideException r1 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00ad }
        java.lang.String r2 = "Received null model"
        r1.m42396init(r2)     // Catch:{ all -> 0x00ad }
        r3.m5111a(r1, r0)     // Catch:{ all -> 0x00ad }
        monitor-exit(r3)
        return
    L_0x003a:
        com.bumptech.glide.c.h$a r0 = r3.f4251x     // Catch:{ all -> 0x00ad }
        com.bumptech.glide.c.h$a r1 = com.bumptech.glide.p131c.SingleRequest.C1616a.RUNNING     // Catch:{ all -> 0x00ad }
        if (r0 == r1) goto L_0x00a5
        com.bumptech.glide.c.h$a r0 = r3.f4251x     // Catch:{ all -> 0x00ad }
        com.bumptech.glide.c.h$a r1 = com.bumptech.glide.p131c.SingleRequest.C1616a.COMPLETE     // Catch:{ all -> 0x00ad }
        if (r0 != r1) goto L_0x004f
        com.bumptech.glide.load.engine.u<R> r0 = r3.f4248u     // Catch:{ all -> 0x00ad }
        com.bumptech.glide.load.DataSource r1 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00ad }
        r3.mo12518a(r0, r1)     // Catch:{ all -> 0x00ad }
        monitor-exit(r3)
        return
    L_0x004f:
        com.bumptech.glide.c.h$a r0 = com.bumptech.glide.p131c.SingleRequest.C1616a.WAITING_FOR_SIZE     // Catch:{ all -> 0x00ad }
        r3.f4251x = r0     // Catch:{ all -> 0x00ad }
        int r0 = r3.f4240m     // Catch:{ all -> 0x00ad }
        int r1 = r3.f4241n     // Catch:{ all -> 0x00ad }
        boolean r0 = com.bumptech.glide.util.C1772j.m6155a(r0, r1)     // Catch:{ all -> 0x00ad }
        if (r0 == 0) goto L_0x0065
        int r0 = r3.f4240m     // Catch:{ all -> 0x00ad }
        int r1 = r3.f4241n     // Catch:{ all -> 0x00ad }
        r3.mo12482a(r0, r1)     // Catch:{ all -> 0x00ad }
        goto L_0x006a
    L_0x0065:
        com.bumptech.glide.c.a.h<R> r0 = r3.f4243p     // Catch:{ all -> 0x00ad }
        r0.getSize(r3)     // Catch:{ all -> 0x00ad }
    L_0x006a:
        com.bumptech.glide.c.h$a r0 = r3.f4251x     // Catch:{ all -> 0x00ad }
        com.bumptech.glide.c.h$a r1 = com.bumptech.glide.p131c.SingleRequest.C1616a.RUNNING     // Catch:{ all -> 0x00ad }
        if (r0 == r1) goto L_0x0076
        com.bumptech.glide.c.h$a r0 = r3.f4251x     // Catch:{ all -> 0x00ad }
        com.bumptech.glide.c.h$a r1 = com.bumptech.glide.p131c.SingleRequest.C1616a.WAITING_FOR_SIZE     // Catch:{ all -> 0x00ad }
        if (r0 != r1) goto L_0x0085
    L_0x0076:
        boolean r0 = r3.m5125q()     // Catch:{ all -> 0x00ad }
        if (r0 == 0) goto L_0x0085
        com.bumptech.glide.c.a.h<R> r0 = r3.f4243p     // Catch:{ all -> 0x00ad }
        android.graphics.drawable.Drawable r1 = r3.m5120l()     // Catch:{ all -> 0x00ad }
        r0.onLoadStarted(r1)     // Catch:{ all -> 0x00ad }
    L_0x0085:
        boolean r0 = f4225c     // Catch:{ all -> 0x00ad }
        if (r0 == 0) goto L_0x00a3
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
        r0.<init>()     // Catch:{ all -> 0x00ad }
        java.lang.String r1 = "finished run method in "
        r0.append(r1)     // Catch:{ all -> 0x00ad }
        long r1 = r3.f4250w     // Catch:{ all -> 0x00ad }
        double r1 = com.bumptech.glide.util.LogTime.m6124a(r1)     // Catch:{ all -> 0x00ad }
        r0.append(r1)     // Catch:{ all -> 0x00ad }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ad }
        r3.m5114a(r0)     // Catch:{ all -> 0x00ad }
    L_0x00a3:
        monitor-exit(r3)
        return
    L_0x00a5:
        java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00ad }
        java.lang.String r1 = "Cannot restart a running request"
        r0.<init>(r1)     // Catch:{ all -> 0x00ad }
        throw r0     // Catch:{ all -> 0x00ad }
    L_0x00ad:
        r0 = move-exception
        monitor-exit(r3)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p131c.SingleRequest.mo12490a():void");
    }

    /* renamed from: i */
    private void m5117i() {
        m5118j();
        this.f4232e.mo13207b();
        this.f4243p.removeCallback(this);
        C1688d dVar = this.f4249v;
        if (dVar != null) {
            dVar.mo12869a();
            this.f4249v = null;
        }
    }

    /* renamed from: j */
    private void m5118j() {
        if (this.f4230b) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    /* renamed from: b */
    public synchronized void mo12493b() {
        m5118j();
        this.f4232e.mo13207b();
        if (this.f4251x != C1616a.CLEARED) {
            m5117i();
            if (this.f4248u != null) {
                m5112a(this.f4248u);
            }
            if (m5124p()) {
                this.f4243p.onLoadCleared(m5120l());
            }
            this.f4251x = C1616a.CLEARED;
        }
    }

    /* renamed from: a */
    private void m5112a(Resource<?> uVar) {
        this.f4245r.mo12864a(uVar);
        this.f4248u = null;
    }

    /* renamed from: c */
    public synchronized boolean mo12495c() {
        boolean z;
        z = this.f4251x == C1616a.RUNNING || this.f4251x == C1616a.WAITING_FOR_SIZE;
        return z;
    }

    /* renamed from: h_ */
    public synchronized boolean mo12504h_() {
        return this.f4251x == C1616a.COMPLETE;
    }

    /* renamed from: e */
    public synchronized boolean mo12499e() {
        return mo12504h_();
    }

    /* renamed from: f */
    public synchronized boolean mo12501f() {
        return this.f4251x == C1616a.CLEARED;
    }

    /* renamed from: g */
    public synchronized boolean mo12502g() {
        return this.f4251x == C1616a.FAILED;
    }

    /* renamed from: k */
    private Drawable m5119k() {
        if (this.f4252y == null) {
            this.f4252y = this.f4239l.mo12454p();
            if (this.f4252y == null && this.f4239l.mo12455q() > 0) {
                this.f4252y = m5109a(this.f4239l.mo12455q());
            }
        }
        return this.f4252y;
    }

    /* renamed from: l */
    private Drawable m5120l() {
        if (this.f4253z == null) {
            this.f4253z = this.f4239l.mo12457s();
            if (this.f4253z == null && this.f4239l.mo12456r() > 0) {
                this.f4253z = m5109a(this.f4239l.mo12456r());
            }
        }
        return this.f4253z;
    }

    /* renamed from: m */
    private Drawable m5121m() {
        if (this.f4226A == null) {
            this.f4226A = this.f4239l.mo12459u();
            if (this.f4226A == null && this.f4239l.mo12458t() > 0) {
                this.f4226A = m5109a(this.f4239l.mo12458t());
            }
        }
        return this.f4226A;
    }

    /* renamed from: a */
    private Drawable m5109a(int i) {
        return DrawableDecoderCompat.getDrawable((Context) this.f4236i, i, this.f4239l.mo12460v() != null ? this.f4239l.mo12460v() : this.f4235h.getTheme());
    }

    /* renamed from: n */
    private synchronized void m5122n() {
        if (m5125q()) {
            Drawable drawable = null;
            if (this.f4237j == null) {
                drawable = m5121m();
            }
            if (drawable == null) {
                drawable = m5119k();
            }
            if (drawable == null) {
                drawable = m5120l();
            }
            this.f4243p.onLoadFailed(drawable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f0, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo12482a(int r22, int r23) {
        /*
        r21 = this;
        r15 = r21
        monitor-enter(r21)
        com.bumptech.glide.util.a.c r0 = r15.f4232e     // Catch:{ all -> 0x00f7 }
        r0.mo13207b()     // Catch:{ all -> 0x00f7 }
        boolean r0 = f4225c     // Catch:{ all -> 0x00f7 }
        if (r0 == 0) goto L_0x0026
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
        r0.<init>()     // Catch:{ all -> 0x00f7 }
        java.lang.String r1 = "Got onSizeReady in "
        r0.append(r1)     // Catch:{ all -> 0x00f7 }
        long r1 = r15.f4250w     // Catch:{ all -> 0x00f7 }
        double r1 = com.bumptech.glide.util.LogTime.m6124a(r1)     // Catch:{ all -> 0x00f7 }
        r0.append(r1)     // Catch:{ all -> 0x00f7 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f7 }
        r15.m5114a(r0)     // Catch:{ all -> 0x00f7 }
    L_0x0026:
        com.bumptech.glide.c.h$a r0 = r15.f4251x     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.c.h$a r1 = com.bumptech.glide.p131c.SingleRequest.C1616a.WAITING_FOR_SIZE     // Catch:{ all -> 0x00f7 }
        if (r0 == r1) goto L_0x002e
        monitor-exit(r21)
        return
    L_0x002e:
        com.bumptech.glide.c.h$a r0 = com.bumptech.glide.p131c.SingleRequest.C1616a.RUNNING     // Catch:{ all -> 0x00f7 }
        r15.f4251x = r0     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.c.a<?> r0 = r15.f4239l     // Catch:{ all -> 0x00f7 }
        float r0 = r0.mo12415D()     // Catch:{ all -> 0x00f7 }
        r1 = r22
        int r1 = m5108a(r1, r0)     // Catch:{ all -> 0x00f7 }
        r15.f4227B = r1     // Catch:{ all -> 0x00f7 }
        r1 = r23
        int r0 = m5108a(r1, r0)     // Catch:{ all -> 0x00f7 }
        r15.f4228C = r0     // Catch:{ all -> 0x00f7 }
        boolean r0 = f4225c     // Catch:{ all -> 0x00f7 }
        if (r0 == 0) goto L_0x0066
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
        r0.<init>()     // Catch:{ all -> 0x00f7 }
        java.lang.String r1 = "finished setup for calling load in "
        r0.append(r1)     // Catch:{ all -> 0x00f7 }
        long r1 = r15.f4250w     // Catch:{ all -> 0x00f7 }
        double r1 = com.bumptech.glide.util.LogTime.m6124a(r1)     // Catch:{ all -> 0x00f7 }
        r0.append(r1)     // Catch:{ all -> 0x00f7 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f7 }
        r15.m5114a(r0)     // Catch:{ all -> 0x00f7 }
    L_0x0066:
        com.bumptech.glide.load.engine.k r1 = r15.f4245r     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.g r2 = r15.f4236i     // Catch:{ all -> 0x00f7 }
        java.lang.Object r3 = r15.f4237j     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.c.a<?> r0 = r15.f4239l     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.load.c r4 = r0.mo12462x()     // Catch:{ all -> 0x00f7 }
        int r5 = r15.f4227B     // Catch:{ all -> 0x00f7 }
        int r6 = r15.f4228C     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.c.a<?> r0 = r15.f4239l     // Catch:{ all -> 0x00f7 }
        java.lang.Class r7 = r0.mo12452n()     // Catch:{ all -> 0x00f7 }
        java.lang.Class<R> r8 = r15.f4238k     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.Priority r9 = r15.f4242o     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.c.a<?> r0 = r15.f4239l     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.load.engine.j r10 = r0.mo12453o()     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.c.a<?> r0 = r15.f4239l     // Catch:{ all -> 0x00f7 }
        java.util.Map r11 = r0.mo12449k()     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.c.a<?> r0 = r15.f4239l     // Catch:{ all -> 0x00f7 }
        boolean r12 = r0.mo12450l()     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.c.a<?> r0 = r15.f4239l     // Catch:{ all -> 0x00f7 }
        boolean r13 = r0.mo12416E()     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.c.a<?> r0 = r15.f4239l     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.load.f r14 = r0.mo12451m()     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.c.a<?> r0 = r15.f4239l     // Catch:{ all -> 0x00f7 }
        boolean r0 = r0.mo12461w()     // Catch:{ all -> 0x00f7 }
        r22 = r0
        com.bumptech.glide.c.a<?> r0 = r15.f4239l     // Catch:{ all -> 0x00f7 }
        boolean r16 = r0.mo12417F()     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.c.a<?> r0 = r15.f4239l     // Catch:{ all -> 0x00f7 }
        boolean r17 = r0.mo12418G()     // Catch:{ all -> 0x00f7 }
        com.bumptech.glide.c.a<?> r0 = r15.f4239l     // Catch:{ all -> 0x00f7 }
        boolean r18 = r0.mo12419H()     // Catch:{ all -> 0x00f7 }
        java.util.concurrent.Executor r0 = r15.f4247t     // Catch:{ all -> 0x00f7 }
        r15 = r22
        r19 = r21
        r20 = r0
        com.bumptech.glide.load.engine.k$d r0 = r1.mo12860a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x00f3 }
        r1 = r21
        r1.f4249v = r0     // Catch:{ all -> 0x00f1 }
        com.bumptech.glide.c.h$a r0 = r1.f4251x     // Catch:{ all -> 0x00f1 }
        com.bumptech.glide.c.h$a r2 = com.bumptech.glide.p131c.SingleRequest.C1616a.RUNNING     // Catch:{ all -> 0x00f1 }
        if (r0 == r2) goto L_0x00d1
        r0 = 0
        r1.f4249v = r0     // Catch:{ all -> 0x00f1 }
    L_0x00d1:
        boolean r0 = f4225c     // Catch:{ all -> 0x00f1 }
        if (r0 == 0) goto L_0x00ef
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
        r0.<init>()     // Catch:{ all -> 0x00f1 }
        java.lang.String r2 = "finished onSizeReady in "
        r0.append(r2)     // Catch:{ all -> 0x00f1 }
        long r2 = r1.f4250w     // Catch:{ all -> 0x00f1 }
        double r2 = com.bumptech.glide.util.LogTime.m6124a(r2)     // Catch:{ all -> 0x00f1 }
        r0.append(r2)     // Catch:{ all -> 0x00f1 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f1 }
        r1.m5114a(r0)     // Catch:{ all -> 0x00f1 }
    L_0x00ef:
        monitor-exit(r21)
        return
    L_0x00f1:
        r0 = move-exception
        goto L_0x00f9
    L_0x00f3:
        r0 = move-exception
        r1 = r21
        goto L_0x00f9
    L_0x00f7:
        r0 = move-exception
        r1 = r15
    L_0x00f9:
        monitor-exit(r21)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p131c.SingleRequest.mo12482a(int, int):void");
    }

    /* renamed from: a */
    private static int m5108a(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * ((float) i));
    }

    /* renamed from: o */
    private boolean m5123o() {
        RequestCoordinator dVar = this.f4234g;
        return dVar == null || dVar.mo12494b(this);
    }

    /* renamed from: p */
    private boolean m5124p() {
        RequestCoordinator dVar = this.f4234g;
        return dVar == null || dVar.mo12497d(this);
    }

    /* renamed from: q */
    private boolean m5125q() {
        RequestCoordinator dVar = this.f4234g;
        return dVar == null || dVar.mo12496c(this);
    }

    /* renamed from: r */
    private boolean m5126r() {
        RequestCoordinator dVar = this.f4234g;
        return dVar == null || !dVar.mo12505i();
    }

    /* renamed from: s */
    private void m5127s() {
        RequestCoordinator dVar = this.f4234g;
        if (dVar != null) {
            dVar.mo12498e(this);
        }
    }

    /* renamed from: t */
    private void m5128t() {
        RequestCoordinator dVar = this.f4234g;
        if (dVar != null) {
            dVar.mo12500f(this);
        }
    }

    /* renamed from: a */
    public synchronized void mo12518a(Resource<?> uVar, DataSource dataSource) {
        this.f4232e.mo13207b();
        this.f4249v = null;
        if (uVar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive a Resource<R> with an object of ");
            sb.append(this.f4238k);
            sb.append(" inside, but instead got null.");
            mo12517a(new GlideException(sb.toString()));
            return;
        }
        Object obj = uVar.get();
        if (obj != null) {
            if (this.f4238k.isAssignableFrom(obj.getClass())) {
                if (!m5123o()) {
                    m5112a(uVar);
                    this.f4251x = C1616a.COMPLETE;
                    return;
                }
                m5113a(uVar, obj, dataSource);
                return;
            }
        }
        m5112a(uVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected to receive an object of ");
        sb2.append(this.f4238k);
        sb2.append(" but instead got ");
        sb2.append(obj != null ? obj.getClass() : "");
        sb2.append("{");
        sb2.append(obj);
        sb2.append("} inside Resource{");
        sb2.append(uVar);
        sb2.append("}.");
        sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
        mo12517a(new GlideException(sb2.toString()));
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ac A[Catch:{ all -> 0x00be }] */
    /* renamed from: a */
    private synchronized void m5113a(com.bumptech.glide.load.engine.Resource<R> r11, R r12, com.bumptech.glide.load.DataSource r13) {
        /*
        r10 = this;
        monitor-enter(r10)
        boolean r6 = r10.m5126r()     // Catch:{ all -> 0x00c2 }
        com.bumptech.glide.c.h$a r0 = com.bumptech.glide.p131c.SingleRequest.C1616a.COMPLETE     // Catch:{ all -> 0x00c2 }
        r10.f4251x = r0     // Catch:{ all -> 0x00c2 }
        r10.f4248u = r11     // Catch:{ all -> 0x00c2 }
        com.bumptech.glide.g r11 = r10.f4236i     // Catch:{ all -> 0x00c2 }
        int r11 = r11.mo12551e()     // Catch:{ all -> 0x00c2 }
        r0 = 3
        if (r11 > r0) goto L_0x006b
        java.lang.String r11 = "Glide"
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c2 }
        r0.<init>()     // Catch:{ all -> 0x00c2 }
        java.lang.String r1 = "Finished loading "
        r0.append(r1)     // Catch:{ all -> 0x00c2 }
        java.lang.Class r1 = r12.getClass()     // Catch:{ all -> 0x00c2 }
        java.lang.String r1 = r1.getSimpleName()     // Catch:{ all -> 0x00c2 }
        r0.append(r1)     // Catch:{ all -> 0x00c2 }
        java.lang.String r1 = " from "
        r0.append(r1)     // Catch:{ all -> 0x00c2 }
        r0.append(r13)     // Catch:{ all -> 0x00c2 }
        java.lang.String r1 = " for "
        r0.append(r1)     // Catch:{ all -> 0x00c2 }
        java.lang.Object r1 = r10.f4237j     // Catch:{ all -> 0x00c2 }
        r0.append(r1)     // Catch:{ all -> 0x00c2 }
        java.lang.String r1 = " with size ["
        r0.append(r1)     // Catch:{ all -> 0x00c2 }
        int r1 = r10.f4227B     // Catch:{ all -> 0x00c2 }
        r0.append(r1)     // Catch:{ all -> 0x00c2 }
        java.lang.String r1 = "x"
        r0.append(r1)     // Catch:{ all -> 0x00c2 }
        int r1 = r10.f4228C     // Catch:{ all -> 0x00c2 }
        r0.append(r1)     // Catch:{ all -> 0x00c2 }
        java.lang.String r1 = "] in "
        r0.append(r1)     // Catch:{ all -> 0x00c2 }
        long r1 = r10.f4250w     // Catch:{ all -> 0x00c2 }
        double r1 = com.bumptech.glide.util.LogTime.m6124a(r1)     // Catch:{ all -> 0x00c2 }
        r0.append(r1)     // Catch:{ all -> 0x00c2 }
        java.lang.String r1 = " ms"
        r0.append(r1)     // Catch:{ all -> 0x00c2 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c2 }
        android.util.Log.d(r11, r0)     // Catch:{ all -> 0x00c2 }
    L_0x006b:
        r11 = 1
        r10.f4230b = r11     // Catch:{ all -> 0x00c2 }
        r7 = 0
        java.util.List<com.bumptech.glide.c.e<R>> r0 = r10.f4244q     // Catch:{ all -> 0x00be }
        if (r0 == 0) goto L_0x0093
        java.util.List<com.bumptech.glide.c.e<R>> r0 = r10.f4244q     // Catch:{ all -> 0x00be }
        java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x00be }
        r9 = 0
    L_0x007a:
        boolean r0 = r8.hasNext()     // Catch:{ all -> 0x00be }
        if (r0 == 0) goto L_0x0094
        java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x00be }
        com.bumptech.glide.c.e r0 = (com.bumptech.glide.p131c.RequestListener) r0     // Catch:{ all -> 0x00be }
        java.lang.Object r2 = r10.f4237j     // Catch:{ all -> 0x00be }
        com.bumptech.glide.c.a.h<R> r3 = r10.f4243p     // Catch:{ all -> 0x00be }
        r1 = r12
        r4 = r13
        r5 = r6
        boolean r0 = r0.mo12516a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00be }
        r9 = r9 | r0
        goto L_0x007a
    L_0x0093:
        r9 = 0
    L_0x0094:
        com.bumptech.glide.c.e<R> r0 = r10.f4233f     // Catch:{ all -> 0x00be }
        if (r0 == 0) goto L_0x00a8
        com.bumptech.glide.c.e<R> r0 = r10.f4233f     // Catch:{ all -> 0x00be }
        java.lang.Object r2 = r10.f4237j     // Catch:{ all -> 0x00be }
        com.bumptech.glide.c.a.h<R> r3 = r10.f4243p     // Catch:{ all -> 0x00be }
        r1 = r12
        r4 = r13
        r5 = r6
        boolean r0 = r0.mo12516a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00be }
        if (r0 == 0) goto L_0x00a8
        goto L_0x00a9
    L_0x00a8:
        r11 = 0
    L_0x00a9:
        r11 = r11 | r9
        if (r11 != 0) goto L_0x00b7
        com.bumptech.glide.c.b.g<? super R> r11 = r10.f4246s     // Catch:{ all -> 0x00be }
        com.bumptech.glide.c.b.f r11 = r11.mo12507a(r13, r6)     // Catch:{ all -> 0x00be }
        com.bumptech.glide.c.a.h<R> r13 = r10.f4243p     // Catch:{ all -> 0x00be }
        r13.onResourceReady(r12, r11)     // Catch:{ all -> 0x00be }
    L_0x00b7:
        r10.f4230b = r7     // Catch:{ all -> 0x00c2 }
        r10.m5127s()     // Catch:{ all -> 0x00c2 }
        monitor-exit(r10)
        return
    L_0x00be:
        r11 = move-exception
        r10.f4230b = r7     // Catch:{ all -> 0x00c2 }
        throw r11     // Catch:{ all -> 0x00c2 }
    L_0x00c2:
        r11 = move-exception
        monitor-exit(r10)
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p131c.SingleRequest.m5113a(com.bumptech.glide.load.engine.u, java.lang.Object, com.bumptech.glide.load.DataSource):void");
    }

    /* renamed from: a */
    public synchronized void mo12517a(GlideException glideException) {
        m5111a(glideException, 5);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private synchronized void m5111a(GlideException glideException, int i) {
        boolean z;
        this.f4232e.mo13207b();
        glideException.setOrigin(this.f4229D);
        int e = this.f4236i.mo12551e();
        if (e <= i) {
            StringBuilder sb = new StringBuilder();
            sb.append("Load failed for ");
            sb.append(this.f4237j);
            sb.append(" with size [");
            sb.append(this.f4227B);
            sb.append("x");
            sb.append(this.f4228C);
            sb.append("]");
            Log.w("Glide", sb.toString(), glideException);
            if (e <= 4) {
                glideException.logRootCauses("Glide");
            }
        }
        this.f4249v = null;
        this.f4251x = C1616a.FAILED;
        boolean z2 = true;
        this.f4230b = true;
        try {
            if (this.f4244q != null) {
                z = false;
                for (RequestListener a : this.f4244q) {
                    z |= a.mo12515a(glideException, this.f4237j, this.f4243p, m5126r());
                }
            } else {
                z = false;
            }
            if (this.f4233f == null || !this.f4233f.mo12515a(glideException, this.f4237j, this.f4243p, m5126r())) {
                z2 = false;
            }
            if (!z && !z2) {
                m5122n();
            }
            this.f4230b = false;
            m5128t();
        } catch (Throwable th) {
            this.f4230b = false;
            throw th;
        }
    }

    /* renamed from: a */
    public synchronized boolean mo12492a(Request cVar) {
        boolean z = false;
        if (!(cVar instanceof SingleRequest)) {
            return false;
        }
        SingleRequest hVar = (SingleRequest) cVar;
        synchronized (hVar) {
            if (this.f4240m == hVar.f4240m && this.f4241n == hVar.f4241n && C1772j.m6160b(this.f4237j, hVar.f4237j) && this.f4238k.equals(hVar.f4238k) && this.f4239l.equals(hVar.f4239l) && this.f4242o == hVar.f4242o && m5115a(hVar)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    private synchronized boolean m5115a(SingleRequest<?> hVar) {
        boolean z;
        synchronized (hVar) {
            z = false;
            if ((this.f4244q == null ? 0 : this.f4244q.size()) == (hVar.f4244q == null ? 0 : hVar.f4244q.size())) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    private void m5114a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" this: ");
        sb.append(this.f4231d);
        Log.v("Request", sb.toString());
    }
}
