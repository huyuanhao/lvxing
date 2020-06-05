package com.ksad.lottie.p298a.p300b;

import android.graphics.Path;
import com.ksad.lottie.model.content.C3767h;
import com.ksad.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ksad.lottie.a.b.g */
public class C3653g {
    /* renamed from: a */
    private final List<C3646a<C3767h, Path>> f12536a;
    /* renamed from: b */
    private final List<C3646a<Integer, Integer>> f12537b;
    /* renamed from: c */
    private final List<Mask> f12538c;

    public C3653g(List<Mask> list) {
        this.f12538c = list;
        this.f12536a = new ArrayList(list.size());
        this.f12537b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f12536a.add(((Mask) list.get(i)).mo23053b().mo23036a());
            this.f12537b.add(((Mask) list.get(i)).mo23054c().mo23036a());
        }
    }

    /* renamed from: a */
    public List<Mask> mo22837a() {
        return this.f12538c;
    }

    /* renamed from: b */
    public List<C3646a<C3767h, Path>> mo22838b() {
        return this.f12536a;
    }

    /* renamed from: c */
    public List<C3646a<Integer, Integer>> mo22839c() {
        return this.f12537b;
    }
}
