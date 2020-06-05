package com.kwai.filedownloader.p354b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.kwai.filedownloader.p354b.C4596a.C4597a;
import com.kwai.filedownloader.p356d.C4618a;
import com.kwai.filedownloader.p356d.C4621c;
import com.kwai.filedownloader.p358f.C4661e;
import com.kwai.filedownloader.p358f.C4664f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* renamed from: com.kwai.filedownloader.b.c */
public class C4601c implements C4596a {
    /* renamed from: a */
    private final C4598b f14972a = new C4598b();
    /* renamed from: b */
    private final C4603d f14973b = new C4603d();
    /* renamed from: c */
    private Handler f14974c;
    /* renamed from: d */
    private final long f14975d = C4661e.m19127a().f15181b;
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final List<Integer> f14976e = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: f */
    public AtomicInteger f14977f = new AtomicInteger();
    /* access modifiers changed from: private|volatile */
    /* renamed from: g */
    public volatile Thread f14978g;

    public C4601c() {
        HandlerThread handlerThread = new HandlerThread(C4664f.m19160i("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.f14974c = new Handler(handlerThread.getLooper(), new Callback() {
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    if (C4601c.this.f14978g != null) {
                        LockSupport.unpark(C4601c.this.f14978g);
                        C4601c.this.f14978g = null;
                    }
                    return false;
                }
                try {
                    C4601c.this.f14977f.set(i);
                    C4601c.this.m18722g(i);
                    C4601c.this.f14976e.add(Integer.valueOf(i));
                    return false;
                } finally {
                    C4601c.this.f14977f.set(0);
                    if (C4601c.this.f14978g != null) {
                        LockSupport.unpark(C4601c.this.f14978g);
                        C4601c.this.f14978g = null;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18722g(int i) {
        this.f14973b.mo24970a(this.f14972a.mo24972b(i));
        List<C4618a> c = this.f14972a.mo24974c(i);
        this.f14973b.mo24976d(i);
        for (C4618a a : c) {
            this.f14973b.mo24969a(a);
        }
    }

    /* renamed from: h */
    private boolean m18723h(int i) {
        return !this.f14976e.contains(Integer.valueOf(i));
    }

    /* renamed from: i */
    private void m18724i(int i) {
        this.f14974c.removeMessages(i);
        if (this.f14977f.get() == i) {
            this.f14978g = Thread.currentThread();
            this.f14974c.sendEmptyMessage(0);
            LockSupport.park();
            return;
        }
        m18722g(i);
    }

    /* renamed from: a */
    public void mo24960a() {
        this.f14972a.mo24960a();
        this.f14973b.mo24960a();
    }

    /* renamed from: a */
    public void mo24961a(int i) {
        this.f14974c.sendEmptyMessageDelayed(i, this.f14975d);
    }

    /* renamed from: a */
    public void mo24962a(int i, int i2) {
        this.f14972a.mo24962a(i, i2);
        if (!m18723h(i)) {
            this.f14973b.mo24962a(i, i2);
        }
    }

    /* renamed from: a */
    public void mo24963a(int i, int i2, long j) {
        this.f14972a.mo24963a(i, i2, j);
        if (!m18723h(i)) {
            this.f14973b.mo24963a(i, i2, j);
        }
    }

    /* renamed from: a */
    public void mo24964a(int i, long j) {
        this.f14972a.mo24964a(i, j);
        if (!m18723h(i)) {
            this.f14973b.mo24964a(i, j);
        }
    }

    /* renamed from: a */
    public void mo24965a(int i, long j, String str, String str2) {
        this.f14972a.mo24965a(i, j, str, str2);
        if (!m18723h(i)) {
            this.f14973b.mo24965a(i, j, str, str2);
        }
    }

    /* renamed from: a */
    public void mo24966a(int i, String str, long j, long j2, int i2) {
        this.f14972a.mo24966a(i, str, j, j2, i2);
        if (!m18723h(i)) {
            this.f14973b.mo24966a(i, str, j, j2, i2);
        }
    }

    /* renamed from: a */
    public void mo24967a(int i, Throwable th) {
        this.f14972a.mo24967a(i, th);
        if (!m18723h(i)) {
            this.f14973b.mo24967a(i, th);
        }
    }

    /* renamed from: a */
    public void mo24968a(int i, Throwable th, long j) {
        this.f14972a.mo24968a(i, th, j);
        if (m18723h(i)) {
            m18724i(i);
        }
        this.f14973b.mo24968a(i, th, j);
        this.f14976e.remove(Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo24969a(C4618a aVar) {
        this.f14972a.mo24969a(aVar);
        if (!m18723h(aVar.mo25049a())) {
            this.f14973b.mo24969a(aVar);
        }
    }

    /* renamed from: a */
    public void mo24970a(C4621c cVar) {
        this.f14972a.mo24970a(cVar);
        if (!m18723h(cVar.mo25071a())) {
            this.f14973b.mo24970a(cVar);
        }
    }

    /* renamed from: b */
    public C4597a mo24971b() {
        return this.f14973b.mo24990a(this.f14972a.f14968a, this.f14972a.f14969b);
    }

    /* renamed from: b */
    public C4621c mo24972b(int i) {
        return this.f14972a.mo24972b(i);
    }

    /* renamed from: b */
    public void mo24973b(int i, long j) {
        this.f14972a.mo24973b(i, j);
        if (m18723h(i)) {
            this.f14974c.removeMessages(i);
            if (this.f14977f.get() == i) {
                this.f14978g = Thread.currentThread();
                this.f14974c.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.f14976e.remove(Integer.valueOf(i));
        }
        this.f14973b.mo24973b(i, j);
        this.f14976e.remove(Integer.valueOf(i));
    }

    /* renamed from: c */
    public List<C4618a> mo24974c(int i) {
        return this.f14972a.mo24974c(i);
    }

    /* renamed from: c */
    public void mo24975c(int i, long j) {
        this.f14972a.mo24975c(i, j);
        if (m18723h(i)) {
            m18724i(i);
        }
        this.f14973b.mo24975c(i, j);
        this.f14976e.remove(Integer.valueOf(i));
    }

    /* renamed from: d */
    public void mo24976d(int i) {
        this.f14972a.mo24976d(i);
        if (!m18723h(i)) {
            this.f14973b.mo24976d(i);
        }
    }

    /* renamed from: e */
    public boolean mo24977e(int i) {
        this.f14973b.mo24977e(i);
        return this.f14972a.mo24977e(i);
    }

    /* renamed from: f */
    public void mo24978f(int i) {
        this.f14972a.mo24978f(i);
        if (!m18723h(i)) {
            this.f14973b.mo24978f(i);
        }
    }
}
