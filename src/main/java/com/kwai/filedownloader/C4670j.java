package com.kwai.filedownloader;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.kwai.filedownloader.p358f.C4652b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.kwai.filedownloader.j */
public class C4670j {
    /* renamed from: a */
    static int f15196a = 10;
    /* renamed from: b */
    static int f15197b = 5;
    /* renamed from: c */
    private final Executor f15198c;
    /* renamed from: d */
    private final Handler f15199d;
    /* renamed from: e */
    private final LinkedBlockingQueue<C4728s> f15200e;
    /* renamed from: f */
    private final Object f15201f;
    /* renamed from: g */
    private final ArrayList<C4728s> f15202g;

    /* renamed from: com.kwai.filedownloader.j$a */
    private static final class C4672a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C4670j f15205a = new C4670j();
    }

    /* renamed from: com.kwai.filedownloader.j$b */
    private static class C4673b implements Callback {
        private C4673b() {
        }

        /* renamed from: a */
        private void m19202a(ArrayList<C4728s> arrayList) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((C4728s) it.next()).mo25243b();
            }
            arrayList.clear();
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((C4728s) message.obj).mo25243b();
            } else if (message.what == 2) {
                m19202a((ArrayList) message.obj);
                C4670j.m19193a().m19197c();
            }
            return true;
        }
    }

    private C4670j() {
        this.f15198c = C4652b.m19102a(5, "BlockCompleted");
        this.f15201f = new Object();
        this.f15202g = new ArrayList<>();
        this.f15199d = new Handler(Looper.getMainLooper(), new C4673b());
        this.f15200e = new LinkedBlockingQueue<>();
    }

    /* renamed from: a */
    public static C4670j m19193a() {
        return C4672a.f15205a;
    }

    /* renamed from: b */
    private void m19195b(C4728s sVar) {
        Handler handler = this.f15199d;
        handler.sendMessage(handler.obtainMessage(1, sVar));
    }

    /* renamed from: b */
    public static boolean m19196b() {
        return f15196a > 0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0046, code lost:
            r0 = r6.f15199d;
            r0.sendMessageDelayed(r0.obtainMessage(2, r6.f15202g), (long) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
            return;
     */
    /* renamed from: c */
    public void m19197c() {
        /*
        r6 = this;
        java.lang.Object r0 = r6.f15201f
        monitor-enter(r0)
        java.util.ArrayList<com.kwai.filedownloader.s> r1 = r6.f15202g     // Catch:{ all -> 0x0054 }
        boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0054 }
        if (r1 != 0) goto L_0x000d
        monitor-exit(r0)     // Catch:{ all -> 0x0054 }
        return
    L_0x000d:
        java.util.concurrent.LinkedBlockingQueue<com.kwai.filedownloader.s> r1 = r6.f15200e     // Catch:{ all -> 0x0054 }
        boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0054 }
        if (r1 == 0) goto L_0x0017
        monitor-exit(r0)     // Catch:{ all -> 0x0054 }
        return
    L_0x0017:
        boolean r1 = m19196b()     // Catch:{ all -> 0x0054 }
        r2 = 0
        if (r1 != 0) goto L_0x0027
        java.util.concurrent.LinkedBlockingQueue<com.kwai.filedownloader.s> r1 = r6.f15200e     // Catch:{ all -> 0x0054 }
        java.util.ArrayList<com.kwai.filedownloader.s> r3 = r6.f15202g     // Catch:{ all -> 0x0054 }
        r1.drainTo(r3)     // Catch:{ all -> 0x0054 }
        r1 = 0
        goto L_0x0045
    L_0x0027:
        int r1 = f15196a     // Catch:{ all -> 0x0054 }
        java.util.concurrent.LinkedBlockingQueue<com.kwai.filedownloader.s> r3 = r6.f15200e     // Catch:{ all -> 0x0054 }
        int r3 = r3.size()     // Catch:{ all -> 0x0054 }
        int r4 = f15197b     // Catch:{ all -> 0x0054 }
        int r3 = java.lang.Math.min(r3, r4)     // Catch:{ all -> 0x0054 }
    L_0x0035:
        if (r2 >= r3) goto L_0x0045
        java.util.ArrayList<com.kwai.filedownloader.s> r4 = r6.f15202g     // Catch:{ all -> 0x0054 }
        java.util.concurrent.LinkedBlockingQueue<com.kwai.filedownloader.s> r5 = r6.f15200e     // Catch:{ all -> 0x0054 }
        java.lang.Object r5 = r5.remove()     // Catch:{ all -> 0x0054 }
        r4.add(r5)     // Catch:{ all -> 0x0054 }
        int r2 = r2 + 1
        goto L_0x0035
    L_0x0045:
        monitor-exit(r0)     // Catch:{ all -> 0x0054 }
        android.os.Handler r0 = r6.f15199d
        r2 = 2
        java.util.ArrayList<com.kwai.filedownloader.s> r3 = r6.f15202g
        android.os.Message r2 = r0.obtainMessage(r2, r3)
        long r3 = (long) r1
        r0.sendMessageDelayed(r2, r3)
        return
    L_0x0054:
        r1 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x0054 }
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.C4670j.m19197c():void");
    }

    /* renamed from: c */
    private void m19198c(C4728s sVar) {
        synchronized (this.f15201f) {
            this.f15200e.offer(sVar);
        }
        m19197c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25236a(C4728s sVar) {
        mo25237a(sVar, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25237a(final C4728s sVar, boolean z) {
        if (sVar.mo25246c()) {
            sVar.mo25243b();
        } else if (sVar.mo25248d()) {
            this.f15198c.execute(new Runnable() {
                public void run() {
                    sVar.mo25243b();
                }
            });
        } else {
            if (!m19196b() && !this.f15200e.isEmpty()) {
                synchronized (this.f15201f) {
                    if (!this.f15200e.isEmpty()) {
                        Iterator it = this.f15200e.iterator();
                        while (it.hasNext()) {
                            m19195b((C4728s) it.next());
                        }
                    }
                    this.f15200e.clear();
                }
            }
            if (!m19196b() || z) {
                m19195b(sVar);
            } else {
                m19198c(sVar);
            }
        }
    }
}
