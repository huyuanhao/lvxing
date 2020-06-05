package com.alibaba.baichuan.android.trade.miniapp.handler;

import java.util.AbstractList;
import java.util.LinkedList;

/* renamed from: com.alibaba.baichuan.android.trade.miniapp.handler.c */
public class C1119c<T> extends AbstractList {
    /* renamed from: a */
    private final LinkedList<C1120a<T>> f2310a;
    /* renamed from: b */
    private final int f2311b;

    /* renamed from: com.alibaba.baichuan.android.trade.miniapp.handler.c$a */
    public static class C1120a<T> {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public T f2312a;
    }

    public C1119c() {
        this(0);
    }

    public C1119c(int i) {
        this.f2310a = new LinkedList<>();
        this.f2311b = i;
    }

    public T get(int i) {
        return ((C1120a) this.f2310a.get(i)).f2312a;
    }

    public int size() {
        return this.f2310a.size();
    }
}
