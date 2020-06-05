package p655io.reactivex.p662b;

import java.util.ArrayList;
import java.util.List;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.DisposableContainer;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.internal.util.C8162d;
import p655io.reactivex.internal.util.OpenHashSet;

/* renamed from: io.reactivex.b.a */
public final class CompositeDisposable implements Disposable, DisposableContainer {
    /* renamed from: a */
    OpenHashSet<Disposable> f27409a;
    /* renamed from: b */
    volatile boolean f27410b;

    public void dispose() {
        if (!this.f27410b) {
            synchronized (this) {
                if (!this.f27410b) {
                    this.f27410b = true;
                    OpenHashSet<Disposable> fVar = this.f27409a;
                    this.f27409a = null;
                    mo38829a(fVar);
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.f27410b;
    }

    /* renamed from: a */
    public boolean mo38830a(Disposable bVar) {
        ObjectHelper.m35048a(bVar, "d is null");
        if (!this.f27410b) {
            synchronized (this) {
                if (!this.f27410b) {
                    OpenHashSet<Disposable> fVar = this.f27409a;
                    if (fVar == null) {
                        fVar = new OpenHashSet<>();
                        this.f27409a = fVar;
                    }
                    fVar.mo39152a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    /* renamed from: b */
    public boolean mo38831b(Disposable bVar) {
        if (!mo38832c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
            return false;
     */
    /* renamed from: c */
    public boolean mo38832c(p655io.reactivex.p662b.Disposable r3) {
        /*
        r2 = this;
        java.lang.String r0 = "Disposable item is null"
        p655io.reactivex.internal.p669a.ObjectHelper.m35048a(r3, r0)
        boolean r0 = r2.f27410b
        r1 = 0
        if (r0 == 0) goto L_0x000b
        return r1
    L_0x000b:
        monitor-enter(r2)
        boolean r0 = r2.f27410b     // Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0012
        monitor-exit(r2)     // Catch:{ all -> 0x0022 }
        return r1
    L_0x0012:
        io.reactivex.internal.util.f<io.reactivex.b.b> r0 = r2.f27409a     // Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0020
        boolean r3 = r0.mo39153b(r3)     // Catch:{ all -> 0x0022 }
        if (r3 != 0) goto L_0x001d
        goto L_0x0020
    L_0x001d:
        monitor-exit(r2)     // Catch:{ all -> 0x0022 }
        r3 = 1
        return r3
    L_0x0020:
        monitor-exit(r2)     // Catch:{ all -> 0x0022 }
        return r1
    L_0x0022:
        r3 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x0022 }
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p655io.reactivex.p662b.CompositeDisposable.mo38832c(io.reactivex.b.b):boolean");
    }

    /* renamed from: a */
    public void mo38828a() {
        if (!this.f27410b) {
            synchronized (this) {
                if (!this.f27410b) {
                    OpenHashSet<Disposable> fVar = this.f27409a;
                    this.f27409a = null;
                    mo38829a(fVar);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38829a(OpenHashSet<Disposable> fVar) {
        Object[] b;
        if (fVar != null) {
            List list = null;
            for (Object obj : fVar.mo39154b()) {
                if (obj instanceof Disposable) {
                    try {
                        ((Disposable) obj).dispose();
                    } catch (Throwable th) {
                        Exceptions.m34944b(th);
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(th);
                    }
                }
            }
            if (list == null) {
                return;
            }
            if (list.size() == 1) {
                throw C8162d.m35182a((Throwable) list.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) list);
        }
    }
}
