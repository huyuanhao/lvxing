package p655io.reactivex.internal.disposables;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.internal.util.C8162d;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.disposables.b */
public final class ListCompositeDisposable implements Disposable, DisposableContainer {
    /* renamed from: a */
    List<Disposable> f27484a;
    /* renamed from: b */
    volatile boolean f27485b;

    public void dispose() {
        if (!this.f27485b) {
            synchronized (this) {
                if (!this.f27485b) {
                    this.f27485b = true;
                    List<Disposable> list = this.f27484a;
                    this.f27484a = null;
                    mo38934a(list);
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.f27485b;
    }

    /* renamed from: a */
    public boolean mo38830a(Disposable bVar) {
        ObjectHelper.m35048a(bVar, "d is null");
        if (!this.f27485b) {
            synchronized (this) {
                if (!this.f27485b) {
                    List list = this.f27484a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f27484a = list;
                    }
                    list.add(bVar);
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
        boolean r0 = r2.f27485b
        r1 = 0
        if (r0 == 0) goto L_0x000b
        return r1
    L_0x000b:
        monitor-enter(r2)
        boolean r0 = r2.f27485b     // Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0012
        monitor-exit(r2)     // Catch:{ all -> 0x0022 }
        return r1
    L_0x0012:
        java.util.List<io.reactivex.b.b> r0 = r2.f27484a     // Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0020
        boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: p655io.reactivex.internal.disposables.ListCompositeDisposable.mo38832c(io.reactivex.b.b):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38934a(List<Disposable> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (Disposable dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th) {
                    Exceptions.m34944b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw C8162d.m35182a((Throwable) arrayList.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) arrayList);
        }
    }
}
