package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.p013d.MeanCalculator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.airbnb.lottie.k */
public class PerformanceTracker {
    /* renamed from: a */
    private boolean f1560a = false;
    /* renamed from: b */
    private final Set<C0935a> f1561b = new ArraySet();
    /* renamed from: c */
    private final Map<String, MeanCalculator> f1562c = new HashMap();
    /* renamed from: d */
    private final Comparator<Pair<String, Float>> f1563d = new Comparator<Pair<String, Float>>() {
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

    /* compiled from: PerformanceTracker */
    /* renamed from: com.airbnb.lottie.k$a */
    public interface C0935a {
        /* renamed from: a */
        void mo10009a(float f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo10006a(boolean z) {
        this.f1560a = z;
    }

    /* renamed from: a */
    public void mo10005a(String str, float f) {
        if (this.f1560a) {
            MeanCalculator dVar = (MeanCalculator) this.f1562c.get(str);
            if (dVar == null) {
                dVar = new MeanCalculator();
                this.f1562c.put(str, dVar);
            }
            dVar.mo9970a(f);
            if (str.equals("__container")) {
                for (C0935a a : this.f1561b) {
                    a.mo10009a(f);
                }
            }
        }
    }
}
