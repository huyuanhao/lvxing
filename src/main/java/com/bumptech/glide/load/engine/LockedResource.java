package com.bumptech.glide.load.engine;

import androidx.core.util.Pools.Pool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.p140a.FactoryPools;
import com.bumptech.glide.util.p140a.FactoryPools.C1764a;
import com.bumptech.glide.util.p140a.FactoryPools.C1766c;
import com.bumptech.glide.util.p140a.StateVerifier;

/* renamed from: com.bumptech.glide.load.engine.t */
final class LockedResource<Z> implements Resource<Z>, C1766c {
    /* renamed from: a */
    private static final Pool<LockedResource<?>> f4712a = FactoryPools.m6095a(20, (C1764a<T>) new C1764a<LockedResource<?>>() {
        /* renamed from: a */
        public LockedResource<?> mo12521b() {
            return new LockedResource<>();
        }
    });
    /* renamed from: b */
    private final StateVerifier f4713b = StateVerifier.m6111a();
    /* renamed from: c */
    private Resource<Z> f4714c;
    /* renamed from: d */
    private boolean f4715d;
    /* renamed from: e */
    private boolean f4716e;

    /* renamed from: a */
    static <Z> LockedResource<Z> m5737a(Resource<Z> uVar) {
        LockedResource<Z> tVar = (LockedResource) Preconditions.m6138a((LockedResource) f4712a.acquire());
        tVar.m5739b(uVar);
        return tVar;
    }

    LockedResource() {
    }

    /* renamed from: b */
    private void m5739b(Resource<Z> uVar) {
        this.f4716e = false;
        this.f4715d = true;
        this.f4714c = uVar;
    }

    /* renamed from: b */
    private void m5738b() {
        this.f4714c = null;
        f4712a.release(this);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo12913a() {
        this.f4713b.mo13207b();
        if (this.f4715d) {
            this.f4715d = false;
            if (this.f4716e) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public Class<Z> getResourceClass() {
        return this.f4714c.getResourceClass();
    }

    public Z get() {
        return this.f4714c.get();
    }

    public int getSize() {
        return this.f4714c.getSize();
    }

    public synchronized void recycle() {
        this.f4713b.mo13207b();
        this.f4716e = true;
        if (!this.f4715d) {
            this.f4714c.recycle();
            m5738b();
        }
    }

    /* renamed from: d */
    public StateVerifier mo12519d() {
        return this.f4713b;
    }
}
