package com.qiyukf.basesdk.p394b.p406b.p409c;

import android.os.SystemClock;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5337i;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qiyukf.basesdk.b.b.c.h */
public abstract class C5355h implements Executor {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final String f17285a = C5355h.class.getSimpleName();
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final AtomicInteger f17286b = new AtomicInteger(1);
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final Queue<Runnable> f17287c;
    /* renamed from: d */
    private final Queue<C5337i> f17288d;
    /* renamed from: e */
    private final Thread f17289e = new Thread(new Runnable() {
        /* JADX WARNING: CFG modification limit reached, blocks count: 200 */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0181  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x018c A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0296  */
        public final void run() {
            /*
            r7 = this;
            java.lang.String r0 = "An event executor terminated with non-empty task queue ("
            r1 = 3
            r2 = 41
            r3 = 5
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this     // Catch:{ all -> 0x0134 }
            r4.mo27290b()     // Catch:{ all -> 0x0134 }
        L_0x000b:
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r4 = r4.f17286b
            int r4 = r4.get()
            if (r4 >= r1) goto L_0x0023
            com.qiyukf.basesdk.b.b.c.h r5 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r5 = r5.f17286b
            boolean r4 = r5.compareAndSet(r4, r1)
            if (r4 == 0) goto L_0x000b
        L_0x0023:
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this     // Catch:{ all -> 0x00af }
            boolean r1 = r1.mo27302k()     // Catch:{ all -> 0x00af }
            if (r1 == 0) goto L_0x0023
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this     // Catch:{ all -> 0x006f }
            r1.mo27291c()     // Catch:{ all -> 0x006f }
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r1 = r1.f17286b
            r1.set(r3)
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.Semaphore r1 = r1.f17290f
            r1.release()
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r1 = r1.f17287c
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x006e
            java.lang.String r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
        L_0x0057:
            com.qiyukf.basesdk.b.b.c.h r0 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r0 = r0.f17287c
            int r0 = r0.size()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            com.qiyukf.basesdk.p393a.C5264a.m21626e(r1, r0)
        L_0x006e:
            return
        L_0x006f:
            r1 = move-exception
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r4 = r4.f17286b
            r4.set(r3)
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.Semaphore r3 = r3.f17290f
            r3.release()
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r3 = r3.f17287c
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x00ae
            java.lang.String r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            com.qiyukf.basesdk.b.b.c.h r0 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r0 = r0.f17287c
            int r0 = r0.size()
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            com.qiyukf.basesdk.p393a.C5264a.m21626e(r3, r0)
        L_0x00ae:
            throw r1
        L_0x00af:
            r1 = move-exception
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this     // Catch:{ all -> 0x00f4 }
            r4.mo27291c()     // Catch:{ all -> 0x00f4 }
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r4 = r4.f17286b
            r4.set(r3)
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.Semaphore r3 = r3.f17290f
            r3.release()
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r3 = r3.f17287c
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x00f3
            java.lang.String r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            com.qiyukf.basesdk.b.b.c.h r0 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r0 = r0.f17287c
            int r0 = r0.size()
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            com.qiyukf.basesdk.p393a.C5264a.m21626e(r3, r0)
        L_0x00f3:
            throw r1
        L_0x00f4:
            r1 = move-exception
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r4 = r4.f17286b
            r4.set(r3)
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.Semaphore r3 = r3.f17290f
            r3.release()
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r3 = r3.f17287c
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0133
            java.lang.String r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            com.qiyukf.basesdk.b.b.c.h r0 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r0 = r0.f17287c
            int r0 = r0.size()
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            com.qiyukf.basesdk.p393a.C5264a.m21626e(r3, r0)
        L_0x0133:
            throw r1
        L_0x0134:
            r4 = move-exception
            java.lang.String r5 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a     // Catch:{ all -> 0x0252 }
            java.lang.String r6 = "Unexpected exception from an event executor: "
            com.qiyukf.basesdk.p393a.C5264a.m21621b(r5, r6, r4)     // Catch:{ all -> 0x0252 }
        L_0x013e:
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r4 = r4.f17286b
            int r4 = r4.get()
            if (r4 >= r1) goto L_0x0156
            com.qiyukf.basesdk.b.b.c.h r5 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r5 = r5.f17286b
            boolean r4 = r5.compareAndSet(r4, r1)
            if (r4 == 0) goto L_0x013e
        L_0x0156:
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this     // Catch:{ all -> 0x01cd }
            boolean r1 = r1.mo27302k()     // Catch:{ all -> 0x01cd }
            if (r1 == 0) goto L_0x0156
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this     // Catch:{ all -> 0x018d }
            r1.mo27291c()     // Catch:{ all -> 0x018d }
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r1 = r1.f17286b
            r1.set(r3)
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.Semaphore r1 = r1.f17290f
            r1.release()
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r1 = r1.f17287c
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x018c
            java.lang.String r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            goto L_0x0057
        L_0x018c:
            return
        L_0x018d:
            r1 = move-exception
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r4 = r4.f17286b
            r4.set(r3)
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.Semaphore r3 = r3.f17290f
            r3.release()
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r3 = r3.f17287c
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x01cc
            java.lang.String r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            com.qiyukf.basesdk.b.b.c.h r0 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r0 = r0.f17287c
            int r0 = r0.size()
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            com.qiyukf.basesdk.p393a.C5264a.m21626e(r3, r0)
        L_0x01cc:
            throw r1
        L_0x01cd:
            r1 = move-exception
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this     // Catch:{ all -> 0x0212 }
            r4.mo27291c()     // Catch:{ all -> 0x0212 }
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r4 = r4.f17286b
            r4.set(r3)
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.Semaphore r3 = r3.f17290f
            r3.release()
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r3 = r3.f17287c
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0211
            java.lang.String r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            com.qiyukf.basesdk.b.b.c.h r0 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r0 = r0.f17287c
            int r0 = r0.size()
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            com.qiyukf.basesdk.p393a.C5264a.m21626e(r3, r0)
        L_0x0211:
            throw r1
        L_0x0212:
            r1 = move-exception
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r4 = r4.f17286b
            r4.set(r3)
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.Semaphore r3 = r3.f17290f
            r3.release()
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r3 = r3.f17287c
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0251
            java.lang.String r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            com.qiyukf.basesdk.b.b.c.h r0 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r0 = r0.f17287c
            int r0 = r0.size()
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            com.qiyukf.basesdk.p393a.C5264a.m21626e(r3, r0)
        L_0x0251:
            throw r1
        L_0x0252:
            r4 = move-exception
        L_0x0253:
            com.qiyukf.basesdk.b.b.c.h r5 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r5 = r5.f17286b
            int r5 = r5.get()
            if (r5 >= r1) goto L_0x026b
            com.qiyukf.basesdk.b.b.c.h r6 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r6 = r6.f17286b
            boolean r5 = r6.compareAndSet(r5, r1)
            if (r5 == 0) goto L_0x0253
        L_0x026b:
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this     // Catch:{ all -> 0x02f7 }
            boolean r1 = r1.mo27302k()     // Catch:{ all -> 0x02f7 }
            if (r1 == 0) goto L_0x026b
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this     // Catch:{ all -> 0x02b7 }
            r1.mo27291c()     // Catch:{ all -> 0x02b7 }
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r1 = r1.f17286b
            r1.set(r3)
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.Semaphore r1 = r1.f17290f
            r1.release()
            com.qiyukf.basesdk.b.b.c.h r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r1 = r1.f17287c
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x02b6
            java.lang.String r1 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            com.qiyukf.basesdk.b.b.c.h r0 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r0 = r0.f17287c
            int r0 = r0.size()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            com.qiyukf.basesdk.p393a.C5264a.m21626e(r1, r0)
        L_0x02b6:
            throw r4
        L_0x02b7:
            r1 = move-exception
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r4 = r4.f17286b
            r4.set(r3)
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.Semaphore r3 = r3.f17290f
            r3.release()
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r3 = r3.f17287c
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x02f6
            java.lang.String r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            com.qiyukf.basesdk.b.b.c.h r0 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r0 = r0.f17287c
            int r0 = r0.size()
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            com.qiyukf.basesdk.p393a.C5264a.m21626e(r3, r0)
        L_0x02f6:
            throw r1
        L_0x02f7:
            r1 = move-exception
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this     // Catch:{ all -> 0x033c }
            r4.mo27291c()     // Catch:{ all -> 0x033c }
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r4 = r4.f17286b
            r4.set(r3)
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.Semaphore r3 = r3.f17290f
            r3.release()
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r3 = r3.f17287c
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x033b
            java.lang.String r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            com.qiyukf.basesdk.b.b.c.h r0 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r0 = r0.f17287c
            int r0 = r0.size()
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            com.qiyukf.basesdk.p393a.C5264a.m21626e(r3, r0)
        L_0x033b:
            throw r1
        L_0x033c:
            r1 = move-exception
            com.qiyukf.basesdk.b.b.c.h r4 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.atomic.AtomicInteger r4 = r4.f17286b
            r4.set(r3)
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.concurrent.Semaphore r3 = r3.f17290f
            r3.release()
            com.qiyukf.basesdk.b.b.c.h r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r3 = r3.f17287c
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x037b
            java.lang.String r3 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.f17285a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            com.qiyukf.basesdk.b.b.c.h r0 = com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.this
            java.util.Queue r0 = r0.f17287c
            int r0 = r0.size()
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            com.qiyukf.basesdk.p393a.C5264a.m21626e(r3, r0)
        L_0x037b:
            throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p394b.p406b.p409c.C5355h.C53561.run():void");
        }
    });
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final Semaphore f17290f = new Semaphore(0);

    protected C5355h() {
        this.f17289e.setName("Socket-Thread");
        this.f17289e.setPriority(10);
        this.f17287c = new LinkedBlockingQueue();
        this.f17288d = new PriorityBlockingQueue();
    }

    /* renamed from: a */
    private Runnable mo27288a() {
        return (Runnable) this.f17287c.poll();
    }

    /* renamed from: a */
    private void m21981a(Runnable runnable) {
        if (runnable != null) {
            if (mo27292d()) {
                m21986m();
            }
            this.f17287c.add(runnable);
            return;
        }
        throw new NullPointerException("task");
    }

    /* renamed from: d */
    private boolean mo27292d() {
        return this.f17286b.get() >= 4;
    }

    /* renamed from: m */
    private static void m21986m() {
        throw new RejectedExecutionException("event executor terminated");
    }

    /* renamed from: a */
    public final void mo27294a(C5337i iVar) {
        this.f17288d.add(iVar);
        mo27289a(mo27299h());
    }

    /* renamed from: a */
    public abstract void mo27289a(boolean z);

    /* renamed from: b */
    public abstract void mo27290b();

    /* renamed from: c */
    public abstract void mo27291c();

    /* access modifiers changed from: protected|final */
    /* renamed from: e */
    public final boolean mo27295e() {
        return !this.f17287c.isEmpty();
    }

    public void execute(Runnable runnable) {
        String str = "task";
        if (runnable != null) {
            boolean h = mo27299h();
            if (h) {
                m21981a(runnable);
            } else {
                if (this.f17286b.get() == 1 && this.f17286b.compareAndSet(1, 2)) {
                    this.f17289e.start();
                }
                m21981a(runnable);
                if (mo27292d()) {
                    if (runnable == null) {
                        throw new NullPointerException(str);
                    } else if (this.f17287c.remove(runnable)) {
                        m21986m();
                    }
                }
            }
            mo27289a(h);
            return;
        }
        throw new NullPointerException(str);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: f */
    public final boolean mo27297f() {
        while (true) {
            C5337i iVar = (C5337i) this.f17288d.peek();
            if (iVar == null) {
                break;
            }
            if (iVar.mo27270a() > SystemClock.elapsedRealtime()) {
                break;
            }
            this.f17288d.remove();
            if (!iVar.mo27272c()) {
                this.f17287c.add(iVar);
            }
        }
        Runnable a = mo27288a();
        if (a == null) {
            return false;
        }
        do {
            try {
                a.run();
            } catch (Throwable th) {
                C5264a.m21625d(f17285a, "A task raised an exception.", th);
            }
            a = mo27288a();
        } while (a != null);
        return true;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: g */
    public final long mo27298g() {
        C5337i iVar;
        loop0:
        while (true) {
            iVar = null;
            while (iVar == null && this.f17288d.size() > 0) {
                iVar = (C5337i) this.f17288d.peek();
                if (iVar.mo27272c()) {
                    this.f17288d.remove();
                }
            }
        }
        if (iVar != null) {
            return iVar.mo27270a() - SystemClock.elapsedRealtime();
        }
        return 15000;
    }

    /* renamed from: h */
    public final boolean mo27299h() {
        return Thread.currentThread() == this.f17289e;
    }

    /* renamed from: i */
    public final void mo27300i() {
        boolean z;
        if (!mo27292d()) {
            boolean h = mo27299h();
            while (!mo27301j()) {
                int i = this.f17286b.get();
                int i2 = 4;
                if (h || i == 1 || i == 2 || i == 3) {
                    z = true;
                } else {
                    i2 = i;
                    z = false;
                }
                if (this.f17286b.compareAndSet(i, i2)) {
                    if (i == 1) {
                        this.f17289e.start();
                    }
                    if (z) {
                        mo27289a(h);
                    }
                    return;
                }
            }
        }
    }

    /* renamed from: j */
    public final boolean mo27301j() {
        return this.f17286b.get() >= 3;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: k */
    public final boolean mo27302k() {
        if (!mo27301j()) {
            return false;
        }
        if (!mo27299h()) {
            throw new IllegalStateException("must be invoked from an event loop");
        } else if (!mo27297f()) {
            boolean d = mo27292d();
            return true;
        } else if (mo27292d()) {
            return true;
        } else {
            mo27289a(true);
            return false;
        }
    }
}
