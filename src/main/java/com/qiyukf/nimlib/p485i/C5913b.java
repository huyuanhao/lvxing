package com.qiyukf.nimlib.p485i;

import com.qiyukf.basesdk.p394b.p395a.p396a.C5287f;
import com.qiyukf.basesdk.p394b.p395a.p397b.C5290a;
import com.qiyukf.nimlib.p472g.C5843b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.qiyukf.nimlib.i.b */
public final class C5913b {
    /* renamed from: d */
    private static C5913b f18698d = new C5913b();
    /* renamed from: a */
    private Set<String> f18699a = Collections.synchronizedSet(new HashSet());
    /* renamed from: b */
    private Set<String> f18700b = Collections.synchronizedSet(new HashSet());
    /* renamed from: c */
    private C5920e f18701c = new C5920e();

    private C5913b() {
    }

    /* renamed from: a */
    public static C5913b m23694a() {
        return f18698d;
    }

    /* renamed from: a */
    public final void mo28325a(String str) {
        this.f18699a.add(str);
    }

    /* renamed from: b */
    public final void mo28326b() {
        C5287f.m21710a().mo27151b();
        C5290a.m21719a().mo27157b();
        C5843b.m23414a();
        this.f18699a.clear();
        this.f18700b.clear();
    }

    /* renamed from: b */
    public final void mo28327b(String str) {
        this.f18699a.remove(str);
    }

    /* renamed from: c */
    public final C5920e mo28328c() {
        return this.f18701c;
    }

    /* renamed from: c */
    public final boolean mo28329c(String str) {
        return this.f18699a.contains(str);
    }

    /* renamed from: d */
    public final void mo28330d(String str) {
        this.f18700b.add(str);
    }

    /* renamed from: e */
    public final void mo28331e(String str) {
        this.f18700b.remove(str);
    }

    /* renamed from: f */
    public final boolean mo28332f(String str) {
        return this.f18700b.contains(str);
    }
}
