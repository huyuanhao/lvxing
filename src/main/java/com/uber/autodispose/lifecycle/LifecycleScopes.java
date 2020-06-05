package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;
import java.util.Comparator;
import p655io.reactivex.CompletableSource;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.C8084j;

/* renamed from: com.uber.autodispose.lifecycle.c */
public final class LifecycleScopes {
    /* renamed from: a */
    private static final Comparator<Comparable<Object>> f26000a = C7708$$Lambda$rF8UpyPO5WNLy_kM5ijr_r552c.INSTANCE;

    /* renamed from: a */
    public static <E> CompletableSource m33102a(LifecycleScopeProvider<E> bVar) throws OutsideScopeException {
        return m33103a(bVar, true);
    }

    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    public static <E> p655io.reactivex.CompletableSource m33103a(com.uber.autodispose.lifecycle.LifecycleScopeProvider<E> r2, boolean r3) throws com.uber.autodispose.OutsideScopeException {
        /*
        java.lang.Object r0 = r2.mo37370d()
        com.uber.autodispose.lifecycle.a r1 = r2.mo37368b()
        if (r0 == 0) goto L_0x003a
        java.lang.Object r3 = r1.apply(r0)     // Catch:{ Exception -> 0x0017 }
        io.reactivex.i r2 = r2.mo37367a()
        io.reactivex.c r2 = m33104a(r2, (E) r3)
        return r2
    L_0x0017:
        r2 = move-exception
        if (r3 == 0) goto L_0x0035
        boolean r3 = r2 instanceof com.uber.autodispose.lifecycle.LifecycleEndedException
        if (r3 == 0) goto L_0x0035
        io.reactivex.d.g r3 = com.uber.autodispose.AutoDisposePlugins.m33086b()
        if (r3 == 0) goto L_0x0034
        com.uber.autodispose.lifecycle.LifecycleEndedException r2 = (com.uber.autodispose.lifecycle.LifecycleEndedException) r2     // Catch:{ Exception -> 0x002e }
        r3.accept(r2)     // Catch:{ Exception -> 0x002e }
        io.reactivex.a r2 = p655io.reactivex.Completable.m34906a()     // Catch:{ Exception -> 0x002e }
        return r2
    L_0x002e:
        r2 = move-exception
        io.reactivex.a r2 = p655io.reactivex.Completable.m34907a(r2)
        return r2
    L_0x0034:
        throw r2
    L_0x0035:
        io.reactivex.a r2 = p655io.reactivex.Completable.m34907a(r2)
        return r2
    L_0x003a:
        com.uber.autodispose.lifecycle.LifecycleNotStartedException r2 = new com.uber.autodispose.lifecycle.LifecycleNotStartedException
        r2.m53872init()
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uber.autodispose.lifecycle.LifecycleScopes.m33103a(com.uber.autodispose.lifecycle.b, boolean):io.reactivex.c");
    }

    /* renamed from: a */
    public static <E> CompletableSource m33104a(Observable<E> iVar, E e) {
        return m33105a(iVar, e, e instanceof Comparable ? f26000a : null);
    }

    /* renamed from: a */
    public static <E> CompletableSource m33105a(Observable<E> iVar, E e, Comparator<E> comparator) {
        C8084j jVar;
        if (comparator != null) {
            jVar = new C8084j(comparator, e) {
                private final /* synthetic */ Comparator f$0;
                private final /* synthetic */ Object f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final boolean test(Object obj) {
                    return LifecycleScopes.m33107a(this.f$0, this.f$1, obj);
                }
            };
        } else {
            jVar = new C8084j(e) {
                private final /* synthetic */ Object f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean test(Object obj) {
                    return obj.equals(this.f$0);
                }
            };
        }
        return iVar.mo38881a(1).mo38901b(jVar).mo38907f();
    }

    /* access modifiers changed from: private|static|synthetic */
    /* renamed from: a */
    public static /* synthetic */ boolean m33107a(Comparator comparator, Object obj, Object obj2) throws Exception {
        return comparator.compare(obj2, obj) >= 0;
    }
}
