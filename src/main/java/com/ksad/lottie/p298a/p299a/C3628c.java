package com.ksad.lottie.p298a.p299a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.C3761b;
import com.ksad.lottie.model.content.C3769j;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.model.p305a.C3754l;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p298a.p300b.C3661o;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ksad.lottie.a.a.c */
public class C3628c implements C3629d, C3638l, C3647a {
    /* renamed from: a */
    private final Matrix f12423a;
    /* renamed from: b */
    private final Path f12424b;
    /* renamed from: c */
    private final RectF f12425c;
    /* renamed from: d */
    private final String f12426d;
    /* renamed from: e */
    private final List<C3627b> f12427e;
    /* renamed from: f */
    private final C3721f f12428f;
    /* renamed from: g */
    private List<C3638l> f12429g;
    /* renamed from: h */
    private C3661o f12430h;

    public C3628c(C3721f fVar, C3774a aVar, C3769j jVar) {
        this(fVar, aVar, jVar.mo23130a(), m15128a(fVar, aVar, jVar.mo23131b()), m15127a(jVar.mo23131b()));
    }

    C3628c(C3721f fVar, C3774a aVar, String str, List<C3627b> list, C3754l lVar) {
        this.f12423a = new Matrix();
        this.f12424b = new Path();
        this.f12425c = new RectF();
        this.f12426d = str;
        this.f12428f = fVar;
        this.f12427e = list;
        if (lVar != null) {
            this.f12430h = lVar.mo23047h();
            this.f12430h.mo22851a(aVar);
            this.f12430h.mo22850a((C3647a) this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            C3627b bVar = (C3627b) list.get(size);
            if (bVar instanceof C3634i) {
                arrayList.add((C3634i) bVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((C3634i) arrayList.get(size2)).mo22818a(list.listIterator(list.size()));
        }
    }

    /* renamed from: a */
    static C3754l m15127a(List<C3761b> list) {
        for (int i = 0; i < list.size(); i++) {
            C3761b bVar = (C3761b) list.get(i);
            if (bVar instanceof C3754l) {
                return (C3754l) bVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static List<C3627b> m15128a(C3721f fVar, C3774a aVar, List<C3761b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            C3627b a = ((C3761b) list.get(i)).mo23039a(fVar, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo22811a() {
        this.f12428f.invalidateSelf();
    }

    /* renamed from: a */
    public void mo22812a(Canvas canvas, Matrix matrix, int i) {
        this.f12423a.set(matrix);
        C3661o oVar = this.f12430h;
        if (oVar != null) {
            this.f12423a.preConcat(oVar.mo22855d());
            i = (int) ((((((float) ((Integer) this.f12430h.mo22848a().mo22831e()).intValue()) / 100.0f) * ((float) i)) / 255.0f) * 255.0f);
        }
        for (int size = this.f12427e.size() - 1; size >= 0; size--) {
            Object obj = this.f12427e.get(size);
            if (obj instanceof C3629d) {
                ((C3629d) obj).mo22812a(canvas, this.f12423a, i);
            }
        }
    }

    /* renamed from: a */
    public void mo22813a(RectF rectF, Matrix matrix) {
        this.f12423a.set(matrix);
        C3661o oVar = this.f12430h;
        if (oVar != null) {
            this.f12423a.preConcat(oVar.mo22855d());
        }
        this.f12425c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f12427e.size() - 1; size >= 0; size--) {
            C3627b bVar = (C3627b) this.f12427e.get(size);
            if (bVar instanceof C3629d) {
                ((C3629d) bVar).mo22813a(this.f12425c, this.f12423a);
                if (rectF.isEmpty()) {
                    rectF.set(this.f12425c);
                } else {
                    rectF.set(Math.min(rectF.left, this.f12425c.left), Math.min(rectF.top, this.f12425c.top), Math.max(rectF.right, this.f12425c.right), Math.max(rectF.bottom, this.f12425c.bottom));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo22814a(List<C3627b> list, List<C3627b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f12427e.size());
        arrayList.addAll(list);
        for (int size = this.f12427e.size() - 1; size >= 0; size--) {
            C3627b bVar = (C3627b) this.f12427e.get(size);
            bVar.mo22814a(arrayList, this.f12427e.subList(0, size));
            arrayList.add(bVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public List<C3638l> mo22815b() {
        if (this.f12429g == null) {
            this.f12429g = new ArrayList();
            for (int i = 0; i < this.f12427e.size(); i++) {
                C3627b bVar = (C3627b) this.f12427e.get(i);
                if (bVar instanceof C3638l) {
                    this.f12429g.add((C3638l) bVar);
                }
            }
        }
        return this.f12429g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Matrix mo22816c() {
        C3661o oVar = this.f12430h;
        if (oVar != null) {
            return oVar.mo22855d();
        }
        this.f12423a.reset();
        return this.f12423a;
    }

    /* renamed from: d */
    public Path mo22817d() {
        this.f12423a.reset();
        C3661o oVar = this.f12430h;
        if (oVar != null) {
            this.f12423a.set(oVar.mo22855d());
        }
        this.f12424b.reset();
        for (int size = this.f12427e.size() - 1; size >= 0; size--) {
            C3627b bVar = (C3627b) this.f12427e.get(size);
            if (bVar instanceof C3638l) {
                this.f12424b.addPath(((C3638l) bVar).mo22817d(), this.f12423a);
            }
        }
        return this.f12424b;
    }
}
