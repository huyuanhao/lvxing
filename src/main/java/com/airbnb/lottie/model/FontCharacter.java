package com.airbnb.lottie.model;

import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.d */
public class FontCharacter {
    /* renamed from: a */
    private final List<ShapeGroup> f1678a;
    /* renamed from: b */
    private final char f1679b;
    /* renamed from: c */
    private final double f1680c;
    /* renamed from: d */
    private final double f1681d;
    /* renamed from: e */
    private final String f1682e;
    /* renamed from: f */
    private final String f1683f;

    /* renamed from: a */
    public static int m1640a(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public FontCharacter(List<ShapeGroup> list, char c, double d, double d2, String str, String str2) {
        this.f1678a = list;
        this.f1679b = c;
        this.f1680c = d;
        this.f1681d = d2;
        this.f1682e = str;
        this.f1683f = str2;
    }

    /* renamed from: a */
    public List<ShapeGroup> mo10117a() {
        return this.f1678a;
    }

    /* renamed from: b */
    public double mo10118b() {
        return this.f1681d;
    }

    public int hashCode() {
        return m1640a(this.f1679b, this.f1683f, this.f1682e);
    }
}
