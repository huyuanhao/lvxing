package com.bumptech.glide.load.engine.p137a;

import com.bumptech.glide.load.engine.p137a.Poolable;
import com.bumptech.glide.util.C1772j;
import java.util.Queue;

/* renamed from: com.bumptech.glide.load.engine.a.d */
abstract class BaseKeyPool<T extends Poolable> {
    /* renamed from: a */
    private final Queue<T> f4454a = C1772j.m6153a(20);

    /* renamed from: b */
    public abstract T mo12721b();

    BaseKeyPool() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public T mo12723c() {
        T t = (Poolable) this.f4454a.poll();
        return t == null ? mo12721b() : t;
    }

    /* renamed from: a */
    public void mo12722a(T t) {
        if (this.f4454a.size() < 20) {
            this.f4454a.offer(t);
        }
    }
}
