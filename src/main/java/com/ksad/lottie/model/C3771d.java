package com.ksad.lottie.model;

import com.ksad.lottie.model.content.C3769j;
import java.util.List;

/* renamed from: com.ksad.lottie.model.d */
public class C3771d {
    /* renamed from: a */
    private final List<C3769j> f12817a;
    /* renamed from: b */
    private final char f12818b;
    /* renamed from: c */
    private final double f12819c;
    /* renamed from: d */
    private final double f12820d;
    /* renamed from: e */
    private final String f12821e;
    /* renamed from: f */
    private final String f12822f;

    public C3771d(List<C3769j> list, char c, double d, double d2, String str, String str2) {
        this.f12817a = list;
        this.f12818b = c;
        this.f12819c = d;
        this.f12820d = d2;
        this.f12821e = str;
        this.f12822f = str2;
    }

    /* renamed from: a */
    public static int m15634a(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    /* renamed from: a */
    public List<C3769j> mo23136a() {
        return this.f12817a;
    }

    /* renamed from: b */
    public double mo23137b() {
        return this.f12820d;
    }

    public int hashCode() {
        return m15634a(this.f12818b, this.f12822f, this.f12821e);
    }
}
