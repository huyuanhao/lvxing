package com.bytedance.sdk.openadsdk.p190h;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: com.bytedance.sdk.openadsdk.h.l */
public class Urls {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final Set<String> f8940a = new HashSet();
    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final Set<String> f8941b = new HashSet();
    /* renamed from: c */
    private final ArrayList<C2488a> f8942c;
    /* renamed from: d */
    private final int f8943d;
    /* renamed from: e */
    private int f8944e;
    /* renamed from: f */
    private int f8945f;
    /* renamed from: g */
    private final int f8946g;

    /* compiled from: Urls */
    /* renamed from: com.bytedance.sdk.openadsdk.h.l$a */
    public class C2488a {
        /* renamed from: a */
        final String f8947a;
        /* renamed from: b */
        int f8948b;

        C2488a(String str) {
            this.f8947a = str;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo16799a() {
            Urls.f8940a.add(this.f8947a);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo16800b() {
            Urls.f8941b.add(this.f8947a);
        }

        public String toString() {
            return this.f8947a;
        }
    }

    Urls(List<String> list) {
        this.f8944e = -1;
        if (!list.isEmpty()) {
            this.f8943d = list.size();
            this.f8942c = new ArrayList<>(this.f8943d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                C2488a aVar = new C2488a(str);
                if (f8940a.contains(str)) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(aVar);
                } else if (f8941b.contains(str)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                } else {
                    this.f8942c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f8942c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f8942c.addAll(arrayList2);
            }
            Integer num = Proxy.f8842i;
            int i = (num == null || num.intValue() <= 0) ? this.f8943d >= 2 ? 1 : 2 : num.intValue();
            this.f8946g = i;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    Urls(String str) {
        this.f8944e = -1;
        this.f8942c = new ArrayList<>(1);
        this.f8942c.add(new C2488a(str));
        this.f8943d = 1;
        this.f8946g = 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo16797a() {
        return this.f8945f < this.f8946g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C2488a mo16798b() {
        if (mo16797a()) {
            int i = this.f8944e + 1;
            if (i >= this.f8943d - 1) {
                this.f8944e = -1;
                this.f8945f++;
            } else {
                this.f8944e = i;
            }
            C2488a aVar = (C2488a) this.f8942c.get(i);
            aVar.f8948b = (this.f8945f * this.f8943d) + this.f8944e;
            return aVar;
        }
        throw new NoSuchElementException();
    }
}
