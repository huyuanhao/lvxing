package com.ksad.lottie.model.content;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.model.p305a.C3743a;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3746d;
import com.ksad.lottie.p298a.p299a.C3627b;
import com.ksad.lottie.p298a.p299a.C3644q;
import java.util.List;

public class ShapeStroke implements C3761b {
    /* renamed from: a */
    private final String f12753a;
    /* renamed from: b */
    private final C3744b f12754b;
    /* renamed from: c */
    private final List<C3744b> f12755c;
    /* renamed from: d */
    private final C3743a f12756d;
    /* renamed from: e */
    private final C3746d f12757e;
    /* renamed from: f */
    private final C3744b f12758f;
    /* renamed from: g */
    private final LineCapType f12759g;
    /* renamed from: h */
    private final LineJoinType f12760h;
    /* renamed from: i */
    private final float f12761i;

    /* renamed from: com.ksad.lottie.model.content.ShapeStroke$1 */
    static /* synthetic */ class C37591 {
        /* renamed from: a */
        static final /* synthetic */ int[] f12762a = new int[LineCapType.values().length];
        /* renamed from: b */
        static final /* synthetic */ int[] f12763b = new int[LineJoinType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        static {
            /*
            com.ksad.lottie.model.content.ShapeStroke$LineJoinType[] r0 = com.ksad.lottie.model.content.ShapeStroke.LineJoinType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f12763b = r0
            r0 = 1
            int[] r1 = f12763b     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.ksad.lottie.model.content.ShapeStroke$LineJoinType r2 = com.ksad.lottie.model.content.ShapeStroke.LineJoinType.Bevel     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2
            int[] r2 = f12763b     // Catch:{ NoSuchFieldError -> 0x001f }
            com.ksad.lottie.model.content.ShapeStroke$LineJoinType r3 = com.ksad.lottie.model.content.ShapeStroke.LineJoinType.Miter     // Catch:{ NoSuchFieldError -> 0x001f }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3
            int[] r3 = f12763b     // Catch:{ NoSuchFieldError -> 0x002a }
            com.ksad.lottie.model.content.ShapeStroke$LineJoinType r4 = com.ksad.lottie.model.content.ShapeStroke.LineJoinType.Round     // Catch:{ NoSuchFieldError -> 0x002a }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            com.ksad.lottie.model.content.ShapeStroke$LineCapType[] r3 = com.ksad.lottie.model.content.ShapeStroke.LineCapType.values()
            int r3 = r3.length
            int[] r3 = new int[r3]
            f12762a = r3
            int[] r3 = f12762a     // Catch:{ NoSuchFieldError -> 0x003d }
            com.ksad.lottie.model.content.ShapeStroke$LineCapType r4 = com.ksad.lottie.model.content.ShapeStroke.LineCapType.Butt     // Catch:{ NoSuchFieldError -> 0x003d }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
            r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
        L_0x003d:
            int[] r0 = f12762a     // Catch:{ NoSuchFieldError -> 0x0047 }
            com.ksad.lottie.model.content.ShapeStroke$LineCapType r3 = com.ksad.lottie.model.content.ShapeStroke.LineCapType.Round     // Catch:{ NoSuchFieldError -> 0x0047 }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
            r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
        L_0x0047:
            int[] r0 = f12762a     // Catch:{ NoSuchFieldError -> 0x0051 }
            com.ksad.lottie.model.content.ShapeStroke$LineCapType r1 = com.ksad.lottie.model.content.ShapeStroke.LineCapType.Unknown     // Catch:{ NoSuchFieldError -> 0x0051 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
        L_0x0051:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ksad.lottie.model.content.ShapeStroke.C37591.m47525clinit():void");
        }
    }

    /* renamed from: com.ksad.lottie.model.content.ShapeStroke$LineCapType */
    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Cap toPaintCap() {
            int i = C37591.f12762a[ordinal()];
            return i != 1 ? i != 2 ? Cap.SQUARE : Cap.ROUND : Cap.BUTT;
        }
    }

    /* renamed from: com.ksad.lottie.model.content.ShapeStroke$LineJoinType */
    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Join toPaintJoin() {
            int i = C37591.f12763b[ordinal()];
            if (i == 1) {
                return Join.BEVEL;
            }
            if (i == 2) {
                return Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Join.ROUND;
        }
    }

    public ShapeStroke(String str, C3744b bVar, List<C3744b> list, C3743a aVar, C3746d dVar, C3744b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.f12753a = str;
        this.f12754b = bVar;
        this.f12755c = list;
        this.f12756d = aVar;
        this.f12757e = dVar;
        this.f12758f = bVar2;
        this.f12759g = lineCapType;
        this.f12760h = lineJoinType;
        this.f12761i = f;
    }

    /* renamed from: a */
    public C3627b mo23039a(C3721f fVar, C3774a aVar) {
        return new C3644q(fVar, aVar, this);
    }

    /* renamed from: a */
    public String mo23067a() {
        return this.f12753a;
    }

    /* renamed from: b */
    public C3743a mo23068b() {
        return this.f12756d;
    }

    /* renamed from: c */
    public C3746d mo23069c() {
        return this.f12757e;
    }

    /* renamed from: d */
    public C3744b mo23070d() {
        return this.f12758f;
    }

    /* renamed from: e */
    public List<C3744b> mo23071e() {
        return this.f12755c;
    }

    /* renamed from: f */
    public C3744b mo23072f() {
        return this.f12754b;
    }

    /* renamed from: g */
    public LineCapType mo23073g() {
        return this.f12759g;
    }

    /* renamed from: h */
    public LineJoinType mo23074h() {
        return this.f12760h;
    }

    /* renamed from: i */
    public float mo23075i() {
        return this.f12761i;
    }
}
