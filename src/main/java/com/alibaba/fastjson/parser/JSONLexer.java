package com.alibaba.fastjson.parser;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.alibaba.fastjson.parser.b */
public interface JSONLexer {
    /* renamed from: a */
    int mo11205a();

    /* renamed from: a */
    int mo11206a(char c);

    /* renamed from: a */
    Enum<?> mo11207a(Class<?> cls, SymbolTable iVar, char c);

    /* renamed from: a */
    Number mo11208a(boolean z);

    /* renamed from: a */
    String mo11209a(SymbolTable iVar);

    /* renamed from: a */
    String mo11210a(SymbolTable iVar, char c);

    /* renamed from: a */
    void mo11211a(int i);

    /* renamed from: a */
    boolean mo11212a(Feature feature);

    /* renamed from: b */
    long mo11213b(char c);

    /* renamed from: b */
    String mo11214b();

    /* renamed from: b */
    String mo11215b(SymbolTable iVar);

    /* renamed from: b */
    boolean mo11216b(int i);

    /* renamed from: c */
    float mo11217c(char c);

    /* renamed from: c */
    void mo11218c();

    /* renamed from: c */
    void mo11219c(int i);

    void close();

    /* renamed from: d */
    double mo11221d(char c);

    /* renamed from: d */
    void mo11222d();

    /* renamed from: e */
    char mo11223e();

    /* renamed from: e */
    boolean mo11224e(char c);

    /* renamed from: f */
    char mo11225f();

    /* renamed from: f */
    BigDecimal mo11226f(char c);

    /* renamed from: g */
    String mo11227g(char c);

    /* renamed from: g */
    void mo11228g();

    /* renamed from: h */
    void mo11229h();

    /* renamed from: i */
    int mo11230i();

    /* renamed from: j */
    Number mo11231j();

    /* renamed from: k */
    BigDecimal mo11232k();

    /* renamed from: l */
    String mo11233l();

    /* renamed from: m */
    void mo11234m();

    /* renamed from: n */
    int mo11235n();

    /* renamed from: o */
    void mo11236o();

    /* renamed from: p */
    boolean mo11237p();

    /* renamed from: q */
    long mo11238q();

    /* renamed from: r */
    boolean mo11239r();

    /* renamed from: s */
    String mo11240s();

    /* renamed from: t */
    byte[] mo11241t();

    /* renamed from: u */
    float mo11242u();

    /* renamed from: v */
    TimeZone mo11243v();

    /* renamed from: w */
    Locale mo11244w();

    /* renamed from: x */
    String mo11245x();

    /* renamed from: y */
    int mo11246y();
}
