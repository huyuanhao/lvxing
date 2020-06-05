package com.bytedance.sdk.openadsdk.p198i;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: com.bytedance.sdk.openadsdk.i.b */
public class TTFutureTask<V> extends FutureTask<V> implements Comparable<TTFutureTask<V>> {
    /* renamed from: a */
    private int f8969a;
    /* renamed from: b */
    private int f8970b;

    public TTFutureTask(Callable<V> callable, int i, int i2) {
        super(callable);
        if (i == -1) {
            i = 5;
        }
        this.f8969a = i;
        this.f8970b = i2;
    }

    public TTFutureTask(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        if (i == -1) {
            i = 5;
        }
        this.f8969a = i;
        this.f8970b = i2;
    }

    /* renamed from: a */
    public int compareTo(TTFutureTask bVar) {
        if (mo16814a() < bVar.mo16814a()) {
            return 1;
        }
        return mo16814a() > bVar.mo16814a() ? -1 : 0;
    }

    /* renamed from: a */
    public int mo16814a() {
        return this.f8969a;
    }
}
