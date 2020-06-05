package retrofit2.adapter.rxjava2;

import java.lang.reflect.Type;
import javax.annotation.Nullable;
import p655io.reactivex.Scheduler;
import retrofit2.CallAdapter;

/* renamed from: retrofit2.adapter.rxjava2.f */
final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {
    /* renamed from: a */
    private final Type f29327a;
    @Nullable
    /* renamed from: b */
    private final Scheduler f29328b;
    /* renamed from: c */
    private final boolean f29329c;
    /* renamed from: d */
    private final boolean f29330d;
    /* renamed from: e */
    private final boolean f29331e;
    /* renamed from: f */
    private final boolean f29332f;
    /* renamed from: g */
    private final boolean f29333g;
    /* renamed from: h */
    private final boolean f29334h;
    /* renamed from: i */
    private final boolean f29335i;

    RxJava2CallAdapter(Type type, @Nullable Scheduler mVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f29327a = type;
        this.f29328b = mVar;
        this.f29329c = z;
        this.f29330d = z2;
        this.f29331e = z3;
        this.f29332f = z4;
        this.f29333g = z5;
        this.f29334h = z6;
        this.f29335i = z7;
    }

    /* renamed from: a */
    public Type mo41287a() {
        return this.f29327a;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [io.reactivex.i] */
    /* JADX WARNING: type inference failed for: r2v2, types: [io.reactivex.i] */
    /* JADX WARNING: type inference failed for: r2v3, types: [io.reactivex.i] */
    /* JADX WARNING: type inference failed for: r2v5, types: [io.reactivex.a] */
    /* JADX WARNING: type inference failed for: r2v9, types: [io.reactivex.i] */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12, types: [retrofit2.adapter.rxjava2.a] */
    /* JADX WARNING: type inference failed for: r2v13, types: [retrofit2.adapter.rxjava2.e] */
    /* JADX WARNING: type inference failed for: r0v8, types: [retrofit2.adapter.rxjava2.c] */
    /* JADX WARNING: type inference failed for: r0v9, types: [retrofit2.adapter.rxjava2.b] */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* renamed from: a */
    public java.lang.Object mo41286a(retrofit2.C8623b<R> r2) {
        /*
        r1 = this;
        boolean r0 = r1.f29329c
        if (r0 == 0) goto L_0x000a
        retrofit2.adapter.rxjava2.b r0 = new retrofit2.adapter.rxjava2.b
        r0.m55889init(r2)
        goto L_0x000f
    L_0x000a:
        retrofit2.adapter.rxjava2.c r0 = new retrofit2.adapter.rxjava2.c
        r0.m55891init(r2)
    L_0x000f:
        boolean r2 = r1.f29330d
        if (r2 == 0) goto L_0x0019
        retrofit2.adapter.rxjava2.e r2 = new retrofit2.adapter.rxjava2.e
        r2.m55894init(r0)
        goto L_0x0024
    L_0x0019:
        boolean r2 = r1.f29331e
        if (r2 == 0) goto L_0x0023
        retrofit2.adapter.rxjava2.a r2 = new retrofit2.adapter.rxjava2.a
        r2.m55887init(r0)
        goto L_0x0024
    L_0x0023:
        r2 = r0
    L_0x0024:
        io.reactivex.m r0 = r1.f29328b
        if (r0 == 0) goto L_0x002c
        io.reactivex.i r2 = r2.mo38902b(r0)
    L_0x002c:
        boolean r0 = r1.f29332f
        if (r0 == 0) goto L_0x0037
        io.reactivex.BackpressureStrategy r0 = p655io.reactivex.BackpressureStrategy.LATEST
        io.reactivex.d r2 = r2.mo38880a(r0)
        return r2
    L_0x0037:
        boolean r0 = r1.f29333g
        if (r0 == 0) goto L_0x0040
        io.reactivex.n r2 = r2.mo38909h()
        return r2
    L_0x0040:
        boolean r0 = r1.f29334h
        if (r0 == 0) goto L_0x0049
        io.reactivex.f r2 = r2.mo38908g()
        return r2
    L_0x0049:
        boolean r0 = r1.f29335i
        if (r0 == 0) goto L_0x0051
        io.reactivex.a r2 = r2.mo38907f()
    L_0x0051:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.adapter.rxjava2.RxJava2CallAdapter.mo41286a(retrofit2.b):java.lang.Object");
    }
}
