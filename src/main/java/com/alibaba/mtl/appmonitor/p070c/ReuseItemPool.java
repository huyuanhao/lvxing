package com.alibaba.mtl.appmonitor.p070c;

import com.alibaba.mtl.appmonitor.p070c.Reusable;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.alibaba.mtl.appmonitor.c.c */
public class ReuseItemPool<T extends Reusable> {
    /* renamed from: c */
    private static AtomicLong f3193c = new AtomicLong(0);
    /* renamed from: d */
    private static AtomicLong f3194d = new AtomicLong(0);
    /* renamed from: a */
    private AtomicLong f3195a = new AtomicLong(0);
    /* renamed from: b */
    private AtomicLong f3196b = new AtomicLong(0);
    /* renamed from: e */
    private Integer f3197e = null;
    /* renamed from: f */
    private final int f3198f = 20;
    /* renamed from: g */
    private ConcurrentLinkedQueue<T> f3199g = new ConcurrentLinkedQueue<>();
    /* renamed from: h */
    private Set<Integer> f3200h = new HashSet();

    /* renamed from: a */
    public T mo11629a() {
        f3193c.getAndIncrement();
        this.f3195a.getAndIncrement();
        T t = (Reusable) this.f3199g.poll();
        if (t != null) {
            this.f3200h.remove(Integer.valueOf(System.identityHashCode(t)));
            this.f3196b.getAndIncrement();
            f3194d.getAndIncrement();
        }
        return t;
    }

    /* renamed from: a */
    public void mo11630a(T t) {
        t.mo11546d();
        if (this.f3199g.size() < 20) {
            synchronized (this.f3200h) {
                int identityHashCode = System.identityHashCode(t);
                if (!this.f3200h.contains(Integer.valueOf(identityHashCode))) {
                    this.f3200h.add(Integer.valueOf(identityHashCode));
                    this.f3199g.offer(t);
                }
            }
        }
    }
}
