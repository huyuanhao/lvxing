package com.airbnb.lottie.p008a.p009a;

import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.model.content.MergePaths.MergePathsMode;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.airbnb.lottie.a.a.k */
public class MergePathsContent implements GreedyContent, PathContent {
    /* renamed from: a */
    private final Path f1341a = new Path();
    /* renamed from: b */
    private final Path f1342b = new Path();
    /* renamed from: c */
    private final Path f1343c = new Path();
    /* renamed from: d */
    private final String f1344d;
    /* renamed from: e */
    private final List<PathContent> f1345e = new ArrayList();
    /* renamed from: f */
    private final MergePaths f1346f;

    /* compiled from: MergePathsContent */
    /* renamed from: com.airbnb.lottie.a.a.k$1 */
    static /* synthetic */ class C09231 {
        /* renamed from: a */
        static final /* synthetic */ int[] f1347a = new int[MergePathsMode.values().length];

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
            com.airbnb.lottie.model.content.MergePaths$MergePathsMode[] r0 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f1347a = r0
            int[] r0 = f1347a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.Merge     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f1347a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.Add     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f1347a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.Subtract     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f1347a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.Intersect     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f1347a     // Catch:{ NoSuchFieldError -> 0x0040 }
            com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.ExcludeIntersections     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p008a.p009a.MergePathsContent.C09231.m40908clinit():void");
        }
    }

    public MergePathsContent(MergePaths mergePaths) {
        if (VERSION.SDK_INT >= 19) {
            this.f1344d = mergePaths.mo10036a();
            this.f1346f = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    /* renamed from: a */
    public void mo9856a(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content bVar = (Content) listIterator.previous();
            if (bVar instanceof PathContent) {
                this.f1345e.add((PathContent) bVar);
                listIterator.remove();
            }
        }
    }

    /* renamed from: a */
    public void mo9851a(List<Content> list, List<Content> list2) {
        for (int i = 0; i < this.f1345e.size(); i++) {
            ((PathContent) this.f1345e.get(i)).mo9851a(list, list2);
        }
    }

    /* renamed from: e */
    public Path mo9855e() {
        this.f1343c.reset();
        int i = C09231.f1347a[this.f1346f.mo10037b().ordinal()];
        if (i == 1) {
            m1201a();
        } else if (i == 2) {
            m1202a(Op.UNION);
        } else if (i == 3) {
            m1202a(Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            m1202a(Op.INTERSECT);
        } else if (i == 5) {
            m1202a(Op.XOR);
        }
        return this.f1343c;
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1344d;
    }

    /* renamed from: a */
    private void m1201a() {
        for (int i = 0; i < this.f1345e.size(); i++) {
            this.f1343c.addPath(((PathContent) this.f1345e.get(i)).mo9855e());
        }
    }

    /* renamed from: a */
    private void m1202a(Op op) {
        this.f1342b.reset();
        this.f1341a.reset();
        for (int size = this.f1345e.size() - 1; size >= 1; size--) {
            PathContent lVar = (PathContent) this.f1345e.get(size);
            if (lVar instanceof ContentGroup) {
                ContentGroup cVar = (ContentGroup) lVar;
                List c = cVar.mo9853c();
                for (int size2 = c.size() - 1; size2 >= 0; size2--) {
                    Path e = ((PathContent) c.get(size2)).mo9855e();
                    e.transform(cVar.mo9854d());
                    this.f1342b.addPath(e);
                }
            } else {
                this.f1342b.addPath(lVar.mo9855e());
            }
        }
        PathContent lVar2 = (PathContent) this.f1345e.get(0);
        if (lVar2 instanceof ContentGroup) {
            ContentGroup cVar2 = (ContentGroup) lVar2;
            List c2 = cVar2.mo9853c();
            for (int i = 0; i < c2.size(); i++) {
                Path e2 = ((PathContent) c2.get(i)).mo9855e();
                e2.transform(cVar2.mo9854d());
                this.f1341a.addPath(e2);
            }
        } else {
            this.f1341a.set(lVar2.mo9855e());
        }
        this.f1343c.op(this.f1341a, this.f1342b, op);
    }
}
