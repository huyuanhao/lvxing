package com.qiyukf.nim.uikit.session.emoji;

import android.util.Log;
import com.qiyukf.unicorn.p502e.C6044c;
import com.qiyukf.unicorn.p502e.C6045d;
import com.qiyukf.unicorn.p503f.C6168c;
import com.qiyukf.unicorn.p516j.C6207a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.qiyukf.nim.uikit.session.emoji.i */
public final class C5548i {
    /* renamed from: a */
    private static C5548i f17873a;
    /* renamed from: b */
    private boolean f17874b = true;
    /* renamed from: c */
    private List<C5547h> f17875c = new ArrayList();
    /* renamed from: d */
    private Map<String, C5547h> f17876d = new HashMap();
    /* renamed from: e */
    private boolean f17877e = true;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public List<C6044c> f17878f = new ArrayList();

    private C5548i() {
    }

    /* renamed from: a */
    public static C5548i m22560a() {
        if (f17873a == null) {
            f17873a = new C5548i();
        }
        return f17873a;
    }

    /* renamed from: a */
    public final String mo27671a(String str) {
        if (str != null && str.startsWith("[:") && str.endsWith("]")) {
            for (C6044c cVar : this.f17878f) {
                if (cVar.mo28888a().contains(str)) {
                    return cVar.mo28889b();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo27672a(List<C6045d> list) {
        this.f17875c.clear();
        this.f17876d.clear();
        this.f17874b = true;
        for (C6045d dVar : list) {
            if (dVar.mo28890a() != -1) {
                C5547h hVar = new C5547h(dVar.mo28891b(), dVar.mo28892c(), dVar.mo28895f(), dVar.mo28893d());
                this.f17875c.add(hVar);
                this.f17876d.put(dVar.mo28891b(), hVar);
            } else if (dVar.mo28894e() == 0) {
                this.f17877e = false;
            } else {
                this.f17877e = true;
            }
        }
    }

    /* renamed from: b */
    public final void mo27673b() {
        Log.i("StickerManager", "Sticker Manager init...");
        new C6207a<Void, List<C6044c>>("Unicorn-HTTP") {
            /* access modifiers changed from: protected|final|synthetic */
            /* renamed from: a */
            public final /* synthetic */ Object mo27678a() {
                return C6168c.m24480c();
            }

            /* access modifiers changed from: protected|final|synthetic */
            /* renamed from: a */
            public final /* synthetic */ void mo27679a(Object obj) {
                List list = (List) obj;
                if (list != null) {
                    C5548i.this.f17878f.clear();
                    C5548i.this.f17878f.addAll(list);
                }
            }
        }.mo29406a((Param[]) new Void[0]);
    }

    /* renamed from: c */
    public final synchronized List<C5547h> mo27674c() {
        return this.f17875c;
    }

    /* renamed from: d */
    public final boolean mo27675d() {
        return this.f17877e;
    }

    /* renamed from: e */
    public final boolean mo27676e() {
        return this.f17874b;
    }

    /* renamed from: f */
    public final void mo27677f() {
        this.f17874b = false;
    }
}
