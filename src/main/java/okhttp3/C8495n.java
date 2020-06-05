package okhttp3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.C8417c;

/* compiled from: Dispatcher */
/* renamed from: okhttp3.n */
public final class C8495n {
    /* renamed from: a */
    private int f28865a = 64;
    /* renamed from: b */
    private int f28866b = 5;
    @Nullable
    /* renamed from: c */
    private Runnable f28867c;
    @Nullable
    /* renamed from: d */
    private ExecutorService f28868d;
    /* renamed from: e */
    private final Deque<C8517a> f28869e = new ArrayDeque();
    /* renamed from: f */
    private final Deque<C8517a> f28870f = new ArrayDeque();
    /* renamed from: g */
    private final Deque<C8516y> f28871g = new ArrayDeque();

    public C8495n(ExecutorService executorService) {
        this.f28868d = executorService;
    }

    public C8495n() {
    }

    /* renamed from: a */
    public synchronized ExecutorService mo40489a() {
        if (this.f28868d == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), C8417c.m36037a("OkHttp Dispatcher", false));
            this.f28868d = threadPoolExecutor;
        }
        return this.f28868d;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo40490a(C8517a aVar) {
        if (this.f28870f.size() >= this.f28865a || m36464c(aVar) >= this.f28866b) {
            this.f28869e.add(aVar);
        } else {
            this.f28870f.add(aVar);
            mo40489a().execute(aVar);
        }
    }

    /* renamed from: c */
    private void m36465c() {
        if (this.f28870f.size() < this.f28865a && !this.f28869e.isEmpty()) {
            Iterator it = this.f28869e.iterator();
            while (it.hasNext()) {
                C8517a aVar = (C8517a) it.next();
                if (m36464c(aVar) < this.f28866b) {
                    it.remove();
                    this.f28870f.add(aVar);
                    mo40489a().execute(aVar);
                }
                if (this.f28870f.size() >= this.f28865a) {
                    break;
                }
            }
        }
    }

    /* renamed from: c */
    private int m36464c(C8517a aVar) {
        int i = 0;
        for (C8517a aVar2 : this.f28870f) {
            if (!aVar2.mo40643b().f28988d) {
                if (aVar2.mo40642a().equals(aVar.mo40642a())) {
                    i++;
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo40491a(C8516y yVar) {
        this.f28871g.add(yVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo40493b(C8517a aVar) {
        m36463a(this.f28870f, aVar, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo40494b(C8516y yVar) {
        m36463a(this.f28871g, yVar, false);
    }

    /* renamed from: a */
    private <T> void m36463a(Deque<T> deque, T t, boolean z) {
        int b;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    m36465c();
                }
                b = mo40492b();
                runnable = this.f28867c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (b == 0 && runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: b */
    public synchronized int mo40492b() {
        return this.f28870f.size() + this.f28871g.size();
    }
}
