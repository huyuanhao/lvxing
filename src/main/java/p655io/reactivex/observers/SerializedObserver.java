package p655io.reactivex.observers;

import p655io.reactivex.Observer;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p655io.reactivex.internal.util.NotificationLite;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.observers.b */
public final class SerializedObserver<T> implements Disposable, Observer<T> {
    /* renamed from: a */
    final Observer<? super T> f27712a;
    /* renamed from: b */
    final boolean f27713b;
    /* renamed from: c */
    Disposable f27714c;
    /* renamed from: d */
    boolean f27715d;
    /* renamed from: e */
    AppendOnlyLinkedArrayList<Object> f27716e;
    /* renamed from: f */
    volatile boolean f27717f;

    public SerializedObserver(Observer<? super T> lVar) {
        this(lVar, false);
    }

    public SerializedObserver(Observer<? super T> lVar, boolean z) {
        this.f27712a = lVar;
        this.f27713b = z;
    }

    public void onSubscribe(Disposable bVar) {
        if (DisposableHelper.validate(this.f27714c, bVar)) {
            this.f27714c = bVar;
            this.f27712a.onSubscribe(this);
        }
    }

    public void dispose() {
        this.f27714c.dispose();
    }

    public boolean isDisposed() {
        return this.f27714c.isDisposed();
    }

    public void onNext(T t) {
        if (!this.f27717f) {
            if (t == null) {
                this.f27714c.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f27717f) {
                    if (this.f27715d) {
                        AppendOnlyLinkedArrayList<Object> aVar = this.f27716e;
                        if (aVar == null) {
                            aVar = new AppendOnlyLinkedArrayList<>(4);
                            this.f27716e = aVar;
                        }
                        aVar.mo39146a(NotificationLite.next(t));
                        return;
                    }
                    this.f27715d = true;
                    this.f27712a.onNext(t);
                    mo39162a();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
            if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
            p655io.reactivex.p666f.RxJavaPlugins.m34959a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
            r2.f27712a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
            return;
     */
    public void onError(java.lang.Throwable r3) {
        /*
        r2 = this;
        boolean r0 = r2.f27717f
        if (r0 == 0) goto L_0x0008
        p655io.reactivex.p666f.RxJavaPlugins.m34959a(r3)
        return
    L_0x0008:
        monitor-enter(r2)
        boolean r0 = r2.f27717f     // Catch:{ all -> 0x0044 }
        r1 = 1
        if (r0 == 0) goto L_0x000f
        goto L_0x0037
    L_0x000f:
        boolean r0 = r2.f27715d     // Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x0032
        r2.f27717f = r1     // Catch:{ all -> 0x0044 }
        io.reactivex.internal.util.a<java.lang.Object> r0 = r2.f27716e     // Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0021
        io.reactivex.internal.util.a r0 = new io.reactivex.internal.util.a     // Catch:{ all -> 0x0044 }
        r1 = 4
        r0.m54897init(r1)     // Catch:{ all -> 0x0044 }
        r2.f27716e = r0     // Catch:{ all -> 0x0044 }
    L_0x0021:
        java.lang.Object r3 = p655io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x0044 }
        boolean r1 = r2.f27713b     // Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x002d
        r0.mo39146a(r3)     // Catch:{ all -> 0x0044 }
        goto L_0x0030
    L_0x002d:
        r0.mo39148b(r3)     // Catch:{ all -> 0x0044 }
    L_0x0030:
        monitor-exit(r2)     // Catch:{ all -> 0x0044 }
        return
    L_0x0032:
        r2.f27717f = r1     // Catch:{ all -> 0x0044 }
        r2.f27715d = r1     // Catch:{ all -> 0x0044 }
        r1 = 0
    L_0x0037:
        monitor-exit(r2)     // Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x003e
        p655io.reactivex.p666f.RxJavaPlugins.m34959a(r3)
        return
    L_0x003e:
        io.reactivex.l<? super T> r0 = r2.f27712a
        r0.onError(r3)
        return
    L_0x0044:
        r3 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x0044 }
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p655io.reactivex.observers.SerializedObserver.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f27717f) {
            synchronized (this) {
                if (!this.f27717f) {
                    if (this.f27715d) {
                        AppendOnlyLinkedArrayList<Object> aVar = this.f27716e;
                        if (aVar == null) {
                            aVar = new AppendOnlyLinkedArrayList<>(4);
                            this.f27716e = aVar;
                        }
                        aVar.mo39146a(NotificationLite.complete());
                        return;
                    }
                    this.f27717f = true;
                    this.f27715d = true;
                    this.f27712a.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39162a() {
        AppendOnlyLinkedArrayList<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f27716e;
                if (aVar == null) {
                    this.f27715d = false;
                    return;
                }
                this.f27716e = null;
            }
        } while (!aVar.mo39147a(this.f27712a));
    }
}
