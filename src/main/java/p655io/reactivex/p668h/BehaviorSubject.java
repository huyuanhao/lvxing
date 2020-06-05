package p655io.reactivex.p668h;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p655io.reactivex.Observer;
import p655io.reactivex.annotations.CheckReturnValue;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p655io.reactivex.internal.util.AppendOnlyLinkedArrayList.C8161a;
import p655io.reactivex.internal.util.C8162d;
import p655io.reactivex.internal.util.NotificationLite;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.h.a */
public final class BehaviorSubject<T> extends Subject<T> {
    /* renamed from: c */
    static final C8098a[] f27441c = new C8098a[0];
    /* renamed from: d */
    static final C8098a[] f27442d = new C8098a[0];
    /* renamed from: j */
    private static final Object[] f27443j = new Object[0];
    /* renamed from: a */
    final AtomicReference<Object> f27444a = new AtomicReference<>();
    /* renamed from: b */
    final AtomicReference<C8098a<T>[]> f27445b = new AtomicReference<>(f27441c);
    /* renamed from: e */
    final ReadWriteLock f27446e = new ReentrantReadWriteLock();
    /* renamed from: f */
    final Lock f27447f = this.f27446e.readLock();
    /* renamed from: g */
    final Lock f27448g = this.f27446e.writeLock();
    /* renamed from: h */
    final AtomicReference<Throwable> f27449h = new AtomicReference<>();
    /* renamed from: i */
    long f27450i;

    /* compiled from: BehaviorSubject */
    /* renamed from: io.reactivex.h.a$a */
    static final class C8098a<T> implements Disposable, C8161a<Object> {
        /* renamed from: a */
        final Observer<? super T> f27451a;
        /* renamed from: b */
        final BehaviorSubject<T> f27452b;
        /* renamed from: c */
        boolean f27453c;
        /* renamed from: d */
        boolean f27454d;
        /* renamed from: e */
        AppendOnlyLinkedArrayList<Object> f27455e;
        /* renamed from: f */
        boolean f27456f;
        /* renamed from: g */
        volatile boolean f27457g;
        /* renamed from: h */
        long f27458h;

        C8098a(Observer<? super T> lVar, BehaviorSubject<T> aVar) {
            this.f27451a = lVar;
            this.f27452b = aVar;
        }

        public void dispose() {
            if (!this.f27457g) {
                this.f27457g = true;
                this.f27452b.mo38866b(this);
            }
        }

        public boolean isDisposed() {
            return this.f27457g;
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r0 == null) goto L_0x003d;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            if (test(r0) == false) goto L_0x003a;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            return;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
            mo38871b();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
            return;
     */
        /* renamed from: a */
        public void mo38869a() {
            /*
            r4 = this;
            boolean r0 = r4.f27457g
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r4)
            boolean r0 = r4.f27457g     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            return
        L_0x000c:
            boolean r0 = r4.f27453c     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            return
        L_0x0012:
            io.reactivex.h.a<T> r0 = r4.f27452b     // Catch:{ all -> 0x003e }
            java.util.concurrent.locks.Lock r1 = r0.f27447f     // Catch:{ all -> 0x003e }
            r1.lock()     // Catch:{ all -> 0x003e }
            long r2 = r0.f27450i     // Catch:{ all -> 0x003e }
            r4.f27458h = r2     // Catch:{ all -> 0x003e }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r0.f27444a     // Catch:{ all -> 0x003e }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003e }
            r1.unlock()     // Catch:{ all -> 0x003e }
            r1 = 1
            if (r0 == 0) goto L_0x002b
            r2 = 1
            goto L_0x002c
        L_0x002b:
            r2 = 0
        L_0x002c:
            r4.f27454d = r2     // Catch:{ all -> 0x003e }
            r4.f27453c = r1     // Catch:{ all -> 0x003e }
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d
            boolean r0 = r4.test(r0)
            if (r0 == 0) goto L_0x003a
            return
        L_0x003a:
            r4.mo38871b()
        L_0x003d:
            return
        L_0x003e:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p655io.reactivex.p668h.BehaviorSubject.C8098a.mo38869a():void");
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r3.f27456f = true;
     */
        /* renamed from: a */
        public void mo38870a(java.lang.Object r4, long r5) {
            /*
            r3 = this;
            boolean r0 = r3.f27457g
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r3.f27456f
            if (r0 != 0) goto L_0x0037
            monitor-enter(r3)
            boolean r0 = r3.f27457g     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0010
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x0010:
            long r0 = r3.f27458h     // Catch:{ all -> 0x0034 }
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0018
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x0018:
            boolean r5 = r3.f27454d     // Catch:{ all -> 0x0034 }
            if (r5 == 0) goto L_0x002d
            io.reactivex.internal.util.a<java.lang.Object> r5 = r3.f27455e     // Catch:{ all -> 0x0034 }
            if (r5 != 0) goto L_0x0028
            io.reactivex.internal.util.a r5 = new io.reactivex.internal.util.a     // Catch:{ all -> 0x0034 }
            r6 = 4
            r5.m54897init(r6)     // Catch:{ all -> 0x0034 }
            r3.f27455e = r5     // Catch:{ all -> 0x0034 }
        L_0x0028:
            r5.mo39146a(r4)     // Catch:{ all -> 0x0034 }
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x002d:
            r5 = 1
            r3.f27453c = r5     // Catch:{ all -> 0x0034 }
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            r3.f27456f = r5
            goto L_0x0037
        L_0x0034:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r4
        L_0x0037:
            r3.test(r4)
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: p655io.reactivex.p668h.BehaviorSubject.C8098a.mo38870a(java.lang.Object, long):void");
        }

        public boolean test(Object obj) {
            return this.f27457g || NotificationLite.accept(obj, this.f27451a);
        }

        /* JADX INFO: used method not loaded: io.reactivex.internal.util.a.a(io.reactivex.internal.util.a$a):null, types can be incorrect */
        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0.mo39145a((p655io.reactivex.internal.util.AppendOnlyLinkedArrayList.C8161a) r2);
     */
        /* renamed from: b */
        public void mo38871b() {
            /*
            r2 = this;
        L_0x0000:
            boolean r0 = r2.f27457g
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r2)
            io.reactivex.internal.util.a<java.lang.Object> r0 = r2.f27455e     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x000f
            r0 = 0
            r2.f27454d = r0     // Catch:{ all -> 0x0017 }
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return
        L_0x000f:
            r1 = 0
            r2.f27455e = r1     // Catch:{ all -> 0x0017 }
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            r0.mo39145a(r2)
            goto L_0x0000
        L_0x0017:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p655io.reactivex.p668h.BehaviorSubject.C8098a.mo38871b():void");
        }
    }

    @CheckReturnValue
    /* renamed from: a */
    public static <T> BehaviorSubject<T> m34973a() {
        return new BehaviorSubject<>();
    }

    BehaviorSubject() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        C8098a aVar = new C8098a(lVar, this);
        lVar.onSubscribe(aVar);
        if (!mo38864a(aVar)) {
            Throwable th = (Throwable) this.f27449h.get();
            if (th == C8162d.f27691a) {
                lVar.onComplete();
            } else {
                lVar.onError(th);
            }
        } else if (aVar.f27457g) {
            mo38866b(aVar);
        } else {
            aVar.mo38869a();
        }
    }

    public void onSubscribe(Disposable bVar) {
        if (this.f27449h.get() != null) {
            bVar.dispose();
        }
    }

    public void onNext(T t) {
        ObjectHelper.m35048a(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f27449h.get() == null) {
            Object next = NotificationLite.next(t);
            mo38868c(next);
            for (C8098a a : (C8098a[]) this.f27445b.get()) {
                a.mo38870a(next, this.f27450i);
            }
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.m35048a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f27449h.compareAndSet(null, th)) {
            RxJavaPlugins.m34959a(th);
            return;
        }
        Object error = NotificationLite.error(th);
        for (C8098a a : mo38867b(error)) {
            a.mo38870a(error, this.f27450i);
        }
    }

    public void onComplete() {
        if (this.f27449h.compareAndSet(null, C8162d.f27691a)) {
            Object complete = NotificationLite.complete();
            for (C8098a a : mo38867b(complete)) {
                a.mo38870a(complete, this.f27450i);
            }
        }
    }

    /* renamed from: b */
    public T mo38865b() {
        Object obj = this.f27444a.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return NotificationLite.getValue(obj);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo38864a(C8098a<T> aVar) {
        C8098a[] aVarArr;
        C8098a[] aVarArr2;
        do {
            aVarArr = (C8098a[]) this.f27445b.get();
            if (aVarArr == f27442d) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new C8098a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f27445b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo38866b(C8098a<T> aVar) {
        C8098a<T>[] aVarArr;
        Object obj;
        do {
            aVarArr = (C8098a[]) this.f27445b.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (aVarArr[i2] == aVar) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = f27441c;
                    } else {
                        C8098a[] aVarArr2 = new C8098a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, i);
                        System.arraycopy(aVarArr, i + 1, aVarArr2, i, (length - i) - 1);
                        obj = aVarArr2;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f27445b.compareAndSet(aVarArr, obj));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C8098a<T>[] mo38867b(Object obj) {
        C8098a<T>[] aVarArr = (C8098a[]) this.f27445b.getAndSet(f27442d);
        if (aVarArr != f27442d) {
            mo38868c(obj);
        }
        return aVarArr;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo38868c(Object obj) {
        this.f27448g.lock();
        this.f27450i++;
        this.f27444a.lazySet(obj);
        this.f27448g.unlock();
    }
}
