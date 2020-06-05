package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3755m;
import com.ksad.lottie.p298a.p299a.C3627b;
import com.ksad.lottie.p298a.p299a.C3639m;

public class PolystarShape implements C3761b {
    /* renamed from: a */
    private final String f12744a;
    /* renamed from: b */
    private final Type f12745b;
    /* renamed from: c */
    private final C3744b f12746c;
    /* renamed from: d */
    private final C3755m<PointF, PointF> f12747d;
    /* renamed from: e */
    private final C3744b f12748e;
    /* renamed from: f */
    private final C3744b f12749f;
    /* renamed from: g */
    private final C3744b f12750g;
    /* renamed from: h */
    private final C3744b f12751h;
    /* renamed from: i */
    private final C3744b f12752i;

    /* renamed from: com.ksad.lottie.model.content.PolystarShape$Type */
    public enum Type {
        Star(1),
        Polygon(2);
        
        private final int value;

        private Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, C3744b bVar, C3755m<PointF, PointF> mVar, C3744b bVar2, C3744b bVar3, C3744b bVar4, C3744b bVar5, C3744b bVar6) {
        this.f12744a = str;
        this.f12745b = type;
        this.f12746c = bVar;
        this.f12747d = mVar;
        this.f12748e = bVar2;
        this.f12749f = bVar3;
        this.f12750g = bVar4;
        this.f12751h = bVar5;
        this.f12752i = bVar6;
    }

    /* renamed from: a */
    public C3627b mo23039a(C3721f fVar, C3774a aVar) {
        return new C3639m(fVar, aVar, this);
    }

    /* renamed from: a */
    public String mo23058a() {
        return this.f12744a;
    }

    /* renamed from: b */
    public Type mo23059b() {
        return this.f12745b;
    }

    /* renamed from: c */
    public C3744b mo23060c() {
        return this.f12746c;
    }

    /* renamed from: d */
    public C3755m<PointF, PointF> mo23061d() {
        return this.f12747d;
    }

    /* renamed from: e */
    public C3744b mo23062e() {
        return this.f12748e;
    }

    /* renamed from: f */
    public C3744b mo23063f() {
        return this.f12749f;
    }

    /* renamed from: g */
    public C3744b mo23064g() {
        return this.f12750g;
    }

    /* renamed from: h */
    public C3744b mo23065h() {
        return this.f12751h;
    }

    /* renamed from: i */
    public C3744b mo23066i() {
        return this.f12752i;
    }
}
