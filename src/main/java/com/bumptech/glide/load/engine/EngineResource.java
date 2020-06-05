package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.load.engine.p */
class EngineResource<Z> implements Resource<Z> {
    /* renamed from: a */
    private final boolean f4699a;
    /* renamed from: b */
    private final boolean f4700b;
    /* renamed from: c */
    private final Resource<Z> f4701c;
    /* renamed from: d */
    private C1694a f4702d;
    /* renamed from: e */
    private Key f4703e;
    /* renamed from: f */
    private int f4704f;
    /* renamed from: g */
    private boolean f4705g;

    /* compiled from: EngineResource */
    /* renamed from: com.bumptech.glide.load.engine.p$a */
    interface C1694a {
        /* renamed from: a */
        void mo12861a(Key cVar, EngineResource<?> pVar);
    }

    EngineResource(Resource<Z> uVar, boolean z, boolean z2) {
        this.f4701c = (Resource) Preconditions.m6138a(uVar);
        this.f4699a = z;
        this.f4700b = z2;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo12898a(Key cVar, C1694a aVar) {
        this.f4703e = cVar;
        this.f4702d = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Resource<Z> mo12897a() {
        return this.f4701c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo12899b() {
        return this.f4699a;
    }

    public Class<Z> getResourceClass() {
        return this.f4701c.getResourceClass();
    }

    public Z get() {
        return this.f4701c.get();
    }

    public int getSize() {
        return this.f4701c.getSize();
    }

    public synchronized void recycle() {
        if (this.f4704f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f4705g) {
            this.f4705g = true;
            if (this.f4700b) {
                this.f4701c.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: c */
    public synchronized void mo12900c() {
        if (!this.f4705g) {
            this.f4704f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo12901d() {
        synchronized (this.f4702d) {
            synchronized (this) {
                if (this.f4704f > 0) {
                    int i = this.f4704f - 1;
                    this.f4704f = i;
                    if (i == 0) {
                        this.f4702d.mo12861a(this.f4703e, this);
                    }
                } else {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
            }
        }
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("EngineResource{isCacheable=");
        sb.append(this.f4699a);
        sb.append(", listener=");
        sb.append(this.f4702d);
        sb.append(", key=");
        sb.append(this.f4703e);
        sb.append(", acquired=");
        sb.append(this.f4704f);
        sb.append(", isRecycled=");
        sb.append(this.f4705g);
        sb.append(", resource=");
        sb.append(this.f4701c);
        sb.append('}');
        return sb.toString();
    }
}
