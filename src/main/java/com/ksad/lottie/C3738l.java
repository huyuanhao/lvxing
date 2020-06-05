package com.ksad.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.ksad.lottie.p303d.C3707d;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.ksad.lottie.l */
public class C3738l {
    /* renamed from: a */
    private boolean f12699a = false;
    /* renamed from: b */
    private final Set<C3740a> f12700b = new ArraySet();
    /* renamed from: c */
    private final Map<String, C3707d> f12701c = new HashMap();
    /* renamed from: d */
    private final Comparator<Pair<String, Float>> f12702d = new Comparator<Pair<String, Float>>() {
        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    /* renamed from: com.ksad.lottie.l$a */
    public interface C3740a {
        /* renamed from: a */
        void mo23028a(float f);
    }

    /* renamed from: a */
    public void mo23024a(String str, float f) {
        if (this.f12699a) {
            C3707d dVar = (C3707d) this.f12701c.get(str);
            if (dVar == null) {
                dVar = new C3707d();
                this.f12701c.put(str, dVar);
            }
            dVar.mo22930a(f);
            if (str.equals("__container")) {
                for (C3740a a : this.f12700b) {
                    a.mo23028a(f);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23025a(boolean z) {
        this.f12699a = z;
    }
}
