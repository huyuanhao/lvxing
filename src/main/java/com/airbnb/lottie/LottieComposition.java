package com.airbnb.lottie;

import android.graphics.Rect;
import android.util.Log;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* renamed from: com.airbnb.lottie.d */
public class LottieComposition {
    /* renamed from: a */
    private final PerformanceTracker f1456a = new PerformanceTracker();
    /* renamed from: b */
    private final HashSet<String> f1457b = new HashSet<>();
    /* renamed from: c */
    private Map<String, List<Layer>> f1458c;
    /* renamed from: d */
    private Map<String, LottieImageAsset> f1459d;
    /* renamed from: e */
    private Map<String, Font> f1460e;
    /* renamed from: f */
    private SparseArrayCompat<FontCharacter> f1461f;
    /* renamed from: g */
    private LongSparseArray<Layer> f1462g;
    /* renamed from: h */
    private List<Layer> f1463h;
    /* renamed from: i */
    private Rect f1464i;
    /* renamed from: j */
    private float f1465j;
    /* renamed from: k */
    private float f1466k;
    /* renamed from: l */
    private float f1467l;

    /* renamed from: a */
    public void mo9915a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2, SparseArrayCompat<FontCharacter> sparseArrayCompat, Map<String, Font> map3) {
        this.f1464i = rect;
        this.f1465j = f;
        this.f1466k = f2;
        this.f1467l = f3;
        this.f1463h = list;
        this.f1462g = longSparseArray;
        this.f1458c = map;
        this.f1459d = map2;
        this.f1461f = sparseArrayCompat;
        this.f1460e = map3;
    }

    /* renamed from: a */
    public void mo9916a(String str) {
        Log.w("LOTTIE", str);
        this.f1457b.add(str);
    }

    /* renamed from: a */
    public void mo9917a(boolean z) {
        this.f1456a.mo10006a(z);
    }

    /* renamed from: a */
    public PerformanceTracker mo9913a() {
        return this.f1456a;
    }

    /* renamed from: a */
    public Layer mo9914a(long j) {
        return (Layer) this.f1462g.get(j);
    }

    /* renamed from: b */
    public Rect mo9918b() {
        return this.f1464i;
    }

    /* renamed from: c */
    public float mo9920c() {
        return (float) ((long) ((mo9928k() / this.f1467l) * 1000.0f));
    }

    /* renamed from: d */
    public float mo9921d() {
        return this.f1465j;
    }

    /* renamed from: e */
    public float mo9922e() {
        return this.f1466k;
    }

    /* renamed from: f */
    public float mo9923f() {
        return this.f1467l;
    }

    /* renamed from: g */
    public List<Layer> mo9924g() {
        return this.f1463h;
    }

    /* renamed from: b */
    public List<Layer> mo9919b(String str) {
        return (List) this.f1458c.get(str);
    }

    /* renamed from: h */
    public SparseArrayCompat<FontCharacter> mo9925h() {
        return this.f1461f;
    }

    /* renamed from: i */
    public Map<String, Font> mo9926i() {
        return this.f1460e;
    }

    /* renamed from: j */
    public Map<String, LottieImageAsset> mo9927j() {
        return this.f1459d;
    }

    /* renamed from: k */
    public float mo9928k() {
        return this.f1466k - this.f1465j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer a : this.f1463h) {
            sb.append(a.mo10137a("\t"));
        }
        return sb.toString();
    }
}
