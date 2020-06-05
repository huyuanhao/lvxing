package com.qiyukf.unicorn.widget.flowlayout;

import android.view.View;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.widget.flowlayout.a */
public abstract class C6369a<T> {
    /* renamed from: a */
    private List<T> f19867a;
    /* renamed from: b */
    private C6370a f19868b;
    @Deprecated
    /* renamed from: c */
    private HashSet<Integer> f19869c = new HashSet<>();

    /* renamed from: com.qiyukf.unicorn.widget.flowlayout.a$a */
    interface C6370a {
        /* renamed from: a */
        void mo29593a();
    }

    public C6369a(List<T> list) {
        this.f19867a = list;
    }

    /* renamed from: a */
    public abstract View mo29530a(FlowLayout flowLayout, int i, T t);

    /* renamed from: a */
    public final T mo29603a(int i) {
        return this.f19867a.get(i);
    }

    /* access modifiers changed from: final */
    @Deprecated
    /* renamed from: a */
    public final HashSet<Integer> mo29604a() {
        return this.f19869c;
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo29605a(C6370a aVar) {
        this.f19868b = aVar;
    }

    /* renamed from: b */
    public final int mo29606b() {
        List<T> list = this.f19867a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: c */
    public final void mo29607c() {
        C6370a aVar = this.f19868b;
        if (aVar != null) {
            aVar.mo29593a();
        }
    }
}
