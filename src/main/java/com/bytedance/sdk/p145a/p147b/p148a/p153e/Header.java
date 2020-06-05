package com.bytedance.sdk.p145a.p147b.p148a.p153e;

import com.bytedance.sdk.p145a.p146a.ByteString;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;

/* renamed from: com.bytedance.sdk.a.b.a.e.c */
public final class Header {
    /* renamed from: a */
    public static final ByteString f5481a = ByteString.m6702a(":");
    /* renamed from: b */
    public static final ByteString f5482b = ByteString.m6702a(":status");
    /* renamed from: c */
    public static final ByteString f5483c = ByteString.m6702a(":method");
    /* renamed from: d */
    public static final ByteString f5484d = ByteString.m6702a(":path");
    /* renamed from: e */
    public static final ByteString f5485e = ByteString.m6702a(":scheme");
    /* renamed from: f */
    public static final ByteString f5486f = ByteString.m6702a(":authority");
    /* renamed from: g */
    public final ByteString f5487g;
    /* renamed from: h */
    public final ByteString f5488h;
    /* renamed from: i */
    final int f5489i;

    public Header(String str, String str2) {
        this(ByteString.m6702a(str), ByteString.m6702a(str2));
    }

    public Header(ByteString fVar, String str) {
        this(fVar, ByteString.m6702a(str));
    }

    public Header(ByteString fVar, ByteString fVar2) {
        this.f5487g = fVar;
        this.f5488h = fVar2;
        this.f5489i = fVar.mo13600g() + 32 + fVar2.mo13600g();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header cVar = (Header) obj;
        if (!this.f5487g.equals(cVar.f5487g) || !this.f5488h.equals(cVar.f5488h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f5487g.hashCode()) * 31) + this.f5488h.hashCode();
    }

    public String toString() {
        return C1876c.m6955a("%s: %s", this.f5487g.mo13587a(), this.f5488h.mo13587a());
    }
}
