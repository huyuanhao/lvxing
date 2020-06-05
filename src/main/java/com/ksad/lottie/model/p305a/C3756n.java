package com.ksad.lottie.model.p305a;

import com.ksad.lottie.p304e.C3717a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.ksad.lottie.model.a.n */
abstract class C3756n<V, O> implements C3755m<V, O> {
    /* renamed from: a */
    final List<C3717a<V>> f12723a;

    C3756n(V v) {
        this(Collections.singletonList(new C3717a(v)));
    }

    C3756n(List<C3717a<V>> list) {
        this.f12723a = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f12723a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f12723a.toArray()));
        }
        return sb.toString();
    }
}
