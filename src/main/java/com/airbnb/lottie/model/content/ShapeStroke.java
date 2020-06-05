package com.airbnb.lottie.model.content;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatableColorValue;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatableIntegerValue;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.StrokeContent;
import java.util.List;

public class ShapeStroke implements ContentModel {
    /* renamed from: a */
    private final String f1614a;
    /* renamed from: b */
    private final AnimatableFloatValue f1615b;
    /* renamed from: c */
    private final List<AnimatableFloatValue> f1616c;
    /* renamed from: d */
    private final AnimatableColorValue f1617d;
    /* renamed from: e */
    private final AnimatableIntegerValue f1618e;
    /* renamed from: f */
    private final AnimatableFloatValue f1619f;
    /* renamed from: g */
    private final LineCapType f1620g;
    /* renamed from: h */
    private final LineJoinType f1621h;
    /* renamed from: i */
    private final float f1622i;

    /* renamed from: com.airbnb.lottie.model.content.ShapeStroke$1 */
    static /* synthetic */ class C09361 {
        /* renamed from: a */
        static final /* synthetic */ int[] f1623a = new int[LineCapType.values().length];
        /* renamed from: b */
        static final /* synthetic */ int[] f1624b = new int[LineJoinType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        static {
            /*
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r0 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f1624b = r0
            r0 = 1
            int[] r1 = f1624b     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r2 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.Bevel     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2
            int[] r2 = f1624b     // Catch:{ NoSuchFieldError -> 0x001f }
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r3 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.Miter     // Catch:{ NoSuchFieldError -> 0x001f }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3
            int[] r3 = f1624b     // Catch:{ NoSuchFieldError -> 0x002a }
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r4 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.Round     // Catch:{ NoSuchFieldError -> 0x002a }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r3 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
            int r3 = r3.length
            int[] r3 = new int[r3]
            f1623a = r3
            int[] r3 = f1623a     // Catch:{ NoSuchFieldError -> 0x003d }
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType r4 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.Butt     // Catch:{ NoSuchFieldError -> 0x003d }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
            r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
        L_0x003d:
            int[] r0 = f1623a     // Catch:{ NoSuchFieldError -> 0x0047 }
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType r3 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.Round     // Catch:{ NoSuchFieldError -> 0x0047 }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
            r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
        L_0x0047:
            int[] r0 = f1623a     // Catch:{ NoSuchFieldError -> 0x0051 }
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType r1 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.Unknown     // Catch:{ NoSuchFieldError -> 0x0051 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
        L_0x0051:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.content.ShapeStroke.C09361.m41021clinit():void");
        }
    }

    /* renamed from: com.airbnb.lottie.model.content.ShapeStroke$LineCapType */
    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Cap toPaintCap() {
            int i = C09361.f1623a[ordinal()];
            if (i == 1) {
                return Cap.BUTT;
            }
            if (i != 2) {
                return Cap.SQUARE;
            }
            return Cap.ROUND;
        }
    }

    /* renamed from: com.airbnb.lottie.model.content.ShapeStroke$LineJoinType */
    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Join toPaintJoin() {
            int i = C09361.f1624b[ordinal()];
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

    public ShapeStroke(String str, AnimatableFloatValue bVar, List<AnimatableFloatValue> list, AnimatableColorValue aVar, AnimatableIntegerValue dVar, AnimatableFloatValue bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.f1614a = str;
        this.f1615b = bVar;
        this.f1616c = list;
        this.f1617d = aVar;
        this.f1618e = dVar;
        this.f1619f = bVar2;
        this.f1620g = lineCapType;
        this.f1621h = lineJoinType;
        this.f1622i = f;
    }

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        return new StrokeContent(lottieDrawable, aVar, this);
    }

    /* renamed from: a */
    public String mo10048a() {
        return this.f1614a;
    }

    /* renamed from: b */
    public AnimatableColorValue mo10049b() {
        return this.f1617d;
    }

    /* renamed from: c */
    public AnimatableIntegerValue mo10050c() {
        return this.f1618e;
    }

    /* renamed from: d */
    public AnimatableFloatValue mo10051d() {
        return this.f1619f;
    }

    /* renamed from: e */
    public List<AnimatableFloatValue> mo10052e() {
        return this.f1616c;
    }

    /* renamed from: f */
    public AnimatableFloatValue mo10053f() {
        return this.f1615b;
    }

    /* renamed from: g */
    public LineCapType mo10054g() {
        return this.f1620g;
    }

    /* renamed from: h */
    public LineJoinType mo10055h() {
        return this.f1621h;
    }

    /* renamed from: i */
    public float mo10056i() {
        return this.f1622i;
    }
}
