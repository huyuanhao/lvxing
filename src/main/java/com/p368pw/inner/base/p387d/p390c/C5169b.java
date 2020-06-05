package com.p368pw.inner.base.p387d.p390c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.p368pw.inner.base.p387d.C5205o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.pw.inner.base.d.c.b */
public class C5169b<T> {
    /* renamed from: m */
    private static SparseIntArray f16849m = new SparseIntArray();
    /* renamed from: a */
    private final ArrayList<View> f16850a = new ArrayList<>(50);
    /* renamed from: b */
    private long f16851b = 0;
    /* renamed from: c */
    private boolean f16852c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public int f16853d = 5;
    /* renamed from: e */
    private final OnPreDrawListener f16854e = new OnPreDrawListener() {
        public boolean onPreDraw() {
            C5169b.this.mo26782c();
            return true;
        }
    };
    /* renamed from: f */
    private final OnGlobalLayoutListener f16855f = new OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            C5169b.this.mo26782c();
        }
    };
    /* renamed from: g */
    private WeakReference<ViewTreeObserver> f16856g = new WeakReference<>(null);
    /* access modifiers changed from: private */
    /* renamed from: h */
    public Map<View, C5172a<T>> f16857h = new HashMap(6);
    /* access modifiers changed from: private */
    /* renamed from: i */
    public C5174c<T> f16858i;
    /* renamed from: j */
    private final C5173b f16859j = new C5173b<>();
    /* renamed from: k */
    private final Handler f16860k = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean f16861l;

    /* renamed from: com.pw.inner.base.d.c.b$a */
    private static class C5172a<B> {
        /* renamed from: a */
        public B f16864a;
        /* renamed from: b */
        public long f16865b;

        private C5172a() {
        }
    }

    /* renamed from: com.pw.inner.base.d.c.b$b */
    class C5173b implements Runnable {
        /* renamed from: a */
        public final Map<View, T> f16866a = new HashMap();
        /* renamed from: b */
        public final Map<View, T> f16867b = new HashMap();

        C5173b() {
        }

        public void run() {
            C5169b.this.f16861l = false;
            this.f16866a.clear();
            this.f16867b.clear();
            for (Entry entry : C5169b.this.f16857h.entrySet()) {
                View view = (View) entry.getKey();
                B b = null;
                if (C5168a.m21330a(view, C5169b.this.f16853d)) {
                    C5205o.m21462a("view is visible!");
                    Map<View, T> map = this.f16866a;
                    if (entry.getValue() != null) {
                        b = ((C5172a) entry.getValue()).f16864a;
                    }
                    map.put(view, b);
                } else {
                    Map<View, T> map2 = this.f16867b;
                    if (entry.getValue() != null) {
                        b = ((C5172a) entry.getValue()).f16864a;
                    }
                    map2.put(view, b);
                    C5205o.m21462a("visible:false");
                }
            }
            if (C5169b.this.f16858i != null) {
                C5169b.this.f16858i.mo26035a(this.f16866a, this.f16867b);
            }
        }
    }

    /* renamed from: com.pw.inner.base.d.c.b$c */
    public interface C5174c<A> {
        /* renamed from: a */
        void mo26035a(Map<View, A> map, Map<View, A> map2);
    }

    public C5169b(Context context) {
        m21341a(context, (View) null);
    }

    /* renamed from: a */
    private void m21340a(long j) {
        try {
            for (Entry entry : this.f16857h.entrySet()) {
                if (((C5172a) entry.getValue()).f16865b < j) {
                    this.f16850a.add(entry.getKey());
                }
            }
            Iterator it = this.f16850a.iterator();
            while (it.hasNext()) {
                mo26778a((View) it.next());
            }
            this.f16850a.clear();
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
        }
    }

    /* renamed from: a */
    private void m21341a(Context context, View view) {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f16856g.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            View a = C5168a.m21327a(context, view);
            if (a != null) {
                ViewTreeObserver viewTreeObserver2 = a.getViewTreeObserver();
                if (viewTreeObserver2.isAlive()) {
                    this.f16856g = new WeakReference<>(viewTreeObserver2);
                    viewTreeObserver2.addOnPreDrawListener(this.f16854e);
                    viewTreeObserver2.addOnGlobalLayoutListener(this.f16855f);
                }
            }
        }
    }

    /* renamed from: b */
    private void m21344b(View view) {
        m21341a(view.getContext(), view);
        C5172a aVar = (C5172a) this.f16857h.get(view);
        if (aVar == null) {
            aVar = new C5172a();
            this.f16857h.put(view, aVar);
            mo26782c();
        }
        long j = this.f16851b;
        aVar.f16865b = j;
        this.f16851b = j + 1;
        long j2 = this.f16851b;
        if (j2 % 50 == 0) {
            m21340a(j2 - 50);
        }
    }

    /* renamed from: a */
    public void mo26777a() {
        this.f16857h.clear();
        this.f16860k.removeMessages(0);
        this.f16861l = false;
    }

    /* renamed from: a */
    public void mo26778a(View view) {
        Map<View, C5172a<T>> map = this.f16857h;
        if (map != null) {
            map.remove(view);
        }
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [B, T] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=T, code=null, for r9v0, types: [B, T] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    public void mo26779a(android.view.View r8, ? r9) {
        /*
        r7 = this;
        if (r9 != 0) goto L_0x0006
        r7.m21344b(r8)
        return
    L_0x0006:
        android.util.SparseIntArray r0 = f16849m
        if (r0 == 0) goto L_0x0017
        int r1 = java.lang.System.identityHashCode(r8)
        com.pw.inner.base.d.c.b$c<T> r2 = r7.f16858i
        int r2 = java.lang.System.identityHashCode(r2)
        r0.put(r1, r2)
    L_0x0017:
        java.util.Map<android.view.View, com.pw.inner.base.d.c.b$a<T>> r0 = r7.f16857h
        java.lang.Object r0 = r0.get(r8)
        com.pw.inner.base.d.c.b$a r0 = (com.p368pw.inner.base.p387d.p390c.C5169b.C5172a) r0
        if (r0 != 0) goto L_0x0032
        com.pw.inner.base.d.c.b$a r0 = new com.pw.inner.base.d.c.b$a
        r1 = 0
        r0.m49267init()
        r0.f16864a = r9
        java.util.Map<android.view.View, com.pw.inner.base.d.c.b$a<T>> r9 = r7.f16857h
        r9.put(r8, r0)
        r7.mo26782c()
        goto L_0x0034
    L_0x0032:
        r0.f16864a = r9
    L_0x0034:
        long r1 = r7.f16851b
        r0.f16865b = r1
        android.content.Context r9 = r8.getContext()
        r7.m21341a(r9, r8)
        long r8 = r7.f16851b
        r0 = 1
        long r8 = r8 + r0
        r7.f16851b = r8
        long r8 = r7.f16851b
        r0 = 50
        long r2 = r8 % r0
        r4 = 0
        int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r6 != 0) goto L_0x0056
        long r8 = r8 - r0
        r7.m21340a(r8)
    L_0x0056:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.base.p387d.p390c.C5169b.mo26779a(android.view.View, java.lang.Object):void");
    }

    /* renamed from: a */
    public void mo26780a(C5174c<T> cVar) {
        this.f16858i = cVar;
    }

    /* renamed from: b */
    public void mo26781b() {
        try {
            mo26777a();
            this.f16852c = true;
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f16856g.get();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f16854e);
            }
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f16855f);
            }
            this.f16856g.clear();
            this.f16858i = null;
            if (this.f16859j != null) {
                if (this.f16859j.f16867b != null) {
                    this.f16859j.f16867b.clear();
                }
                if (this.f16860k != null) {
                    this.f16860k.removeCallbacks(this.f16859j);
                }
            }
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
        }
    }

    /* renamed from: c */
    public void mo26782c() {
        if (!this.f16861l) {
            this.f16861l = true;
            this.f16860k.postDelayed(this.f16859j, 250);
        }
    }
}
