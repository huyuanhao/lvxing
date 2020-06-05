package com.ksad.lottie.p298a.p299a;

import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import com.ksad.lottie.model.content.MergePaths;
import com.ksad.lottie.model.content.MergePaths.MergePathsMode;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.ksad.lottie.a.a.k */
public class C3636k implements C3634i, C3638l {
    /* renamed from: a */
    private final Path f12474a = new Path();
    /* renamed from: b */
    private final Path f12475b = new Path();
    /* renamed from: c */
    private final Path f12476c = new Path();
    /* renamed from: d */
    private final String f12477d;
    /* renamed from: e */
    private final List<C3638l> f12478e = new ArrayList();
    /* renamed from: f */
    private final MergePaths f12479f;

    /* renamed from: com.ksad.lottie.a.a.k$1 */
    static /* synthetic */ class C36371 {
        /* renamed from: a */
        static final /* synthetic */ int[] f12480a = new int[MergePathsMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            com.ksad.lottie.model.content.MergePaths$MergePathsMode[] r0 = com.ksad.lottie.model.content.MergePaths.MergePathsMode.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f12480a = r0
            int[] r0 = f12480a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.ksad.lottie.model.content.MergePaths$MergePathsMode r1 = com.ksad.lottie.model.content.MergePaths.MergePathsMode.Merge     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f12480a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.ksad.lottie.model.content.MergePaths$MergePathsMode r1 = com.ksad.lottie.model.content.MergePaths.MergePathsMode.Add     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f12480a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.ksad.lottie.model.content.MergePaths$MergePathsMode r1 = com.ksad.lottie.model.content.MergePaths.MergePathsMode.Subtract     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f12480a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.ksad.lottie.model.content.MergePaths$MergePathsMode r1 = com.ksad.lottie.model.content.MergePaths.MergePathsMode.Intersect     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f12480a     // Catch:{ NoSuchFieldError -> 0x0040 }
            com.ksad.lottie.model.content.MergePaths$MergePathsMode r1 = com.ksad.lottie.model.content.MergePaths.MergePathsMode.ExcludeIntersections     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ksad.lottie.p298a.p299a.C3636k.C36371.m47406clinit():void");
        }
    }

    public C3636k(MergePaths mergePaths) {
        if (VERSION.SDK_INT >= 19) {
            this.f12477d = mergePaths.mo23055a();
            this.f12479f = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    /* renamed from: a */
    private void m15158a() {
        for (int i = 0; i < this.f12478e.size(); i++) {
            this.f12476c.addPath(((C3638l) this.f12478e.get(i)).mo22817d());
        }
    }

    /* renamed from: a */
    private void m15159a(Op op) {
        this.f12475b.reset();
        this.f12474a.reset();
        for (int size = this.f12478e.size() - 1; size >= 1; size--) {
            C3638l lVar = (C3638l) this.f12478e.get(size);
            if (lVar instanceof C3628c) {
                C3628c cVar = (C3628c) lVar;
                List b = cVar.mo22815b();
                for (int size2 = b.size() - 1; size2 >= 0; size2--) {
                    Path d = ((C3638l) b.get(size2)).mo22817d();
                    d.transform(cVar.mo22816c());
                    this.f12475b.addPath(d);
                }
            } else {
                this.f12475b.addPath(lVar.mo22817d());
            }
        }
        C3638l lVar2 = (C3638l) this.f12478e.get(0);
        if (lVar2 instanceof C3628c) {
            C3628c cVar2 = (C3628c) lVar2;
            List b2 = cVar2.mo22815b();
            for (int i = 0; i < b2.size(); i++) {
                Path d2 = ((C3638l) b2.get(i)).mo22817d();
                d2.transform(cVar2.mo22816c());
                this.f12474a.addPath(d2);
            }
        } else {
            this.f12474a.set(lVar2.mo22817d());
        }
        this.f12476c.op(this.f12474a, this.f12475b, op);
    }

    /* renamed from: a */
    public void mo22814a(List<C3627b> list, List<C3627b> list2) {
        for (int i = 0; i < this.f12478e.size(); i++) {
            ((C3638l) this.f12478e.get(i)).mo22814a(list, list2);
        }
    }

    /* renamed from: a */
    public void mo22818a(ListIterator<C3627b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            C3627b bVar = (C3627b) listIterator.previous();
            if (bVar instanceof C3638l) {
                this.f12478e.add((C3638l) bVar);
                listIterator.remove();
            }
        }
    }

    /* renamed from: d */
    public Path mo22817d() {
        Op op;
        this.f12476c.reset();
        int i = C36371.f12480a[this.f12479f.mo23056b().ordinal()];
        if (i != 1) {
            if (i == 2) {
                op = Op.UNION;
            } else if (i == 3) {
                op = Op.REVERSE_DIFFERENCE;
            } else if (i == 4) {
                op = Op.INTERSECT;
            } else if (i == 5) {
                op = Op.XOR;
            }
            m15159a(op);
        } else {
            m15158a();
        }
        return this.f12476c;
    }
}
