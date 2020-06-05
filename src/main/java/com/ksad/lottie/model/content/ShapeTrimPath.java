package com.ksad.lottie.model.content;

import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.p298a.p299a.C3627b;
import com.ksad.lottie.p298a.p299a.C3645r;

public class ShapeTrimPath implements C3761b {
    /* renamed from: a */
    private final String f12764a;
    /* renamed from: b */
    private final Type f12765b;
    /* renamed from: c */
    private final C3744b f12766c;
    /* renamed from: d */
    private final C3744b f12767d;
    /* renamed from: e */
    private final C3744b f12768e;

    /* renamed from: com.ksad.lottie.model.content.ShapeTrimPath$Type */
    public enum Type {
        Simultaneously,
        Individually;

        public static Type forId(int i) {
            if (i == 1) {
                return Simultaneously;
            }
            if (i == 2) {
                return Individually;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown trim path type ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public ShapeTrimPath(String str, Type type, C3744b bVar, C3744b bVar2, C3744b bVar3) {
        this.f12764a = str;
        this.f12765b = type;
        this.f12766c = bVar;
        this.f12767d = bVar2;
        this.f12768e = bVar3;
    }

    /* renamed from: a */
    public C3627b mo23039a(C3721f fVar, C3774a aVar) {
        return new C3645r(aVar, this);
    }

    /* renamed from: a */
    public String mo23078a() {
        return this.f12764a;
    }

    /* renamed from: b */
    public Type mo23079b() {
        return this.f12765b;
    }

    /* renamed from: c */
    public C3744b mo23080c() {
        return this.f12767d;
    }

    /* renamed from: d */
    public C3744b mo23081d() {
        return this.f12766c;
    }

    /* renamed from: e */
    public C3744b mo23082e() {
        return this.f12768e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trim Path: {start: ");
        sb.append(this.f12766c);
        sb.append(", end: ");
        sb.append(this.f12767d);
        sb.append(", offset: ");
        sb.append(this.f12768e);
        sb.append("}");
        return sb.toString();
    }
}
