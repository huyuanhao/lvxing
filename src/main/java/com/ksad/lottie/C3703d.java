package com.ksad.lottie;

import android.graphics.Rect;
import android.util.Log;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.ksad.lottie.model.C3758c;
import com.ksad.lottie.model.C3771d;
import com.ksad.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* renamed from: com.ksad.lottie.d */
public class C3703d {
    /* renamed from: a */
    private final C3738l f12588a = new C3738l();
    /* renamed from: b */
    private final HashSet<String> f12589b = new HashSet<>();
    /* renamed from: c */
    private Map<String, List<Layer>> f12590c;
    /* renamed from: d */
    private Map<String, C3731g> f12591d;
    /* renamed from: e */
    private Map<String, C3758c> f12592e;
    /* renamed from: f */
    private SparseArrayCompat<C3771d> f12593f;
    /* renamed from: g */
    private LongSparseArray<Layer> f12594g;
    /* renamed from: h */
    private List<Layer> f12595h;
    /* renamed from: i */
    private Rect f12596i;
    /* renamed from: j */
    private float f12597j;
    /* renamed from: k */
    private float f12598k;
    /* renamed from: l */
    private float f12599l;

    /* renamed from: a */
    public C3738l mo22873a() {
        return this.f12588a;
    }

    /* renamed from: a */
    public Layer mo22874a(long j) {
        return (Layer) this.f12594g.get(j);
    }

    /* renamed from: a */
    public void mo22875a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, C3731g> map2, SparseArrayCompat<C3771d> sparseArrayCompat, Map<String, C3758c> map3) {
        this.f12596i = rect;
        this.f12597j = f;
        this.f12598k = f2;
        this.f12599l = f3;
        this.f12595h = list;
        this.f12594g = longSparseArray;
        this.f12590c = map;
        this.f12591d = map2;
        this.f12593f = sparseArrayCompat;
        this.f12592e = map3;
    }

    /* renamed from: a */
    public void mo22876a(String str) {
        Log.w("LOTTIE", str);
        this.f12589b.add(str);
    }

    /* renamed from: a */
    public void mo22877a(boolean z) {
        this.f12588a.mo23025a(z);
    }

    /* renamed from: b */
    public Rect mo22878b() {
        return this.f12596i;
    }

    /* renamed from: b */
    public List<Layer> mo22879b(String str) {
        return (List) this.f12590c.get(str);
    }

    /* renamed from: c */
    public float mo22880c() {
        return (float) ((long) ((mo22888k() / this.f12599l) * 1000.0f));
    }

    /* renamed from: d */
    public float mo22881d() {
        return this.f12597j;
    }

    /* renamed from: e */
    public float mo22882e() {
        return this.f12598k;
    }

    /* renamed from: f */
    public float mo22883f() {
        return this.f12599l;
    }

    /* renamed from: g */
    public List<Layer> mo22884g() {
        return this.f12595h;
    }

    /* renamed from: h */
    public SparseArrayCompat<C3771d> mo22885h() {
        return this.f12593f;
    }

    /* renamed from: i */
    public Map<String, C3758c> mo22886i() {
        return this.f12592e;
    }

    /* renamed from: j */
    public Map<String, C3731g> mo22887j() {
        return this.f12591d;
    }

    /* renamed from: k */
    public float mo22888k() {
        return this.f12598k - this.f12597j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer a : this.f12595h) {
            sb.append(a.mo23146a("\t"));
        }
        return sb.toString();
    }
}
