package com.airbnb.lottie.model.p015a;

import com.airbnb.lottie.p014e.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.a.n */
abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    /* renamed from: a */
    final List<Keyframe<V>> f1584a;

    BaseAnimatableValue(V v) {
        this(Collections.singletonList(new Keyframe(v)));
    }

    BaseAnimatableValue(List<Keyframe<V>> list) {
        this.f1584a = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f1584a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f1584a.toArray()));
        }
        return sb.toString();
    }
}
