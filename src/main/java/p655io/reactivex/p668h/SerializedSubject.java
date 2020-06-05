package p655io.reactivex.p668h;

import p655io.reactivex.Observer;
import p655io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p655io.reactivex.internal.util.AppendOnlyLinkedArrayList.C8161a;
import p655io.reactivex.internal.util.NotificationLite;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.h.c */
final class SerializedSubject<T> extends Subject<T> implements C8161a<Object> {
    /* renamed from: a */
    final Subject<T> f27463a;
    /* renamed from: b */
    boolean f27464b;
    /* renamed from: c */
    AppendOnlyLinkedArrayList<Object> f27465c;
    /* renamed from: d */
    volatile boolean f27466d;

    SerializedSubject(Subject<T> dVar) {
        this.f27463a = dVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        this.f27463a.subscribe(lVar);
    }

    public void onSubscribe(Disposable bVar) {
        boolean z = true;
        if (!this.f27466d) {
            synchronized (this) {
                if (!this.f27466d) {
                    if (this.f27464b) {
                        AppendOnlyLinkedArrayList<Object> aVar = this.f27465c;
                        if (aVar == null) {
                            aVar = new AppendOnlyLinkedArrayList<>(4);
                            this.f27465c = aVar;
                        }
                        aVar.mo39146a(NotificationLite.disposable(bVar));
                        return;
                    }
                    this.f27464b = true;
                    z = false;
                }
            }
        }
        if (z) {
            bVar.dispose();
        } else {
            this.f27463a.onSubscribe(bVar);
            mo38877a();
        }
    }

    public void onNext(T t) {
        if (!this.f27466d) {
            synchronized (this) {
                if (!this.f27466d) {
                    if (this.f27464b) {
                        AppendOnlyLinkedArrayList<Object> aVar = this.f27465c;
                        if (aVar == null) {
                            aVar = new AppendOnlyLinkedArrayList<>(4);
                            this.f27465c = aVar;
                        }
                        aVar.mo39146a(NotificationLite.next(t));
                        return;
                    }
                    this.f27464b = true;
                    this.f27463a.onNext(t);
                    mo38877a();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
            if (r0 == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
            p655io.reactivex.p666f.RxJavaPlugins.m34959a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
            r2.f27463a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
            return;
     */
    public void onError(java.lang.Throwable r3) {
        /*
        r2 = this;
        boolean r0 = r2.f27466d
        if (r0 == 0) goto L_0x0008
        p655io.reactivex.p666f.RxJavaPlugins.m34959a(r3)
        return
    L_0x0008:
        monitor-enter(r2)
        boolean r0 = r2.f27466d     // Catch:{ all -> 0x003b }
        r1 = 1
        if (r0 == 0) goto L_0x0010
        r0 = 1
        goto L_0x002e
    L_0x0010:
        r2.f27466d = r1     // Catch:{ all -> 0x003b }
        boolean r0 = r2.f27464b     // Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x002b
        io.reactivex.internal.util.a<java.lang.Object> r0 = r2.f27465c     // Catch:{ all -> 0x003b }
        if (r0 != 0) goto L_0x0022
        io.reactivex.internal.util.a r0 = new io.reactivex.internal.util.a     // Catch:{ all -> 0x003b }
        r1 = 4
        r0.m54897init(r1)     // Catch:{ all -> 0x003b }
        r2.f27465c = r0     // Catch:{ all -> 0x003b }
    L_0x0022:
        java.lang.Object r3 = p655io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x003b }
        r0.mo39148b(r3)     // Catch:{ all -> 0x003b }
        monitor-exit(r2)     // Catch:{ all -> 0x003b }
        return
    L_0x002b:
        r0 = 0
        r2.f27464b = r1     // Catch:{ all -> 0x003b }
    L_0x002e:
        monitor-exit(r2)     // Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x0035
        p655io.reactivex.p666f.RxJavaPlugins.m34959a(r3)
        return
    L_0x0035:
        io.reactivex.h.d<T> r0 = r2.f27463a
        r0.onError(r3)
        return
    L_0x003b:
        r3 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x003b }
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p655io.reactivex.p668h.SerializedSubject.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f27466d) {
            synchronized (this) {
                if (!this.f27466d) {
                    this.f27466d = true;
                    if (this.f27464b) {
                        AppendOnlyLinkedArrayList<Object> aVar = this.f27465c;
                        if (aVar == null) {
                            aVar = new AppendOnlyLinkedArrayList<>(4);
                            this.f27465c = aVar;
                        }
                        aVar.mo39146a(NotificationLite.complete());
                        return;
                    }
                    this.f27464b = true;
                    this.f27463a.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38877a() {
        AppendOnlyLinkedArrayList<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f27465c;
                if (aVar == null) {
                    this.f27464b = false;
                    return;
                }
                this.f27465c = null;
            }
            aVar.mo39145a((C8161a<? super T>) this);
        }
        while (true) {
        }
    }

    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, (Observer<? super T>) this.f27463a);
    }
}
