package okhttp3.internal.http2;

import okhttp3.internal.C8417c;
import okio.ByteString;

/* compiled from: Header */
/* renamed from: okhttp3.internal.http2.a */
public final class C8453a {
    /* renamed from: a */
    public static final ByteString f28652a = ByteString.encodeUtf8(":");
    /* renamed from: b */
    public static final ByteString f28653b = ByteString.encodeUtf8(":status");
    /* renamed from: c */
    public static final ByteString f28654c = ByteString.encodeUtf8(":method");
    /* renamed from: d */
    public static final ByteString f28655d = ByteString.encodeUtf8(":path");
    /* renamed from: e */
    public static final ByteString f28656e = ByteString.encodeUtf8(":scheme");
    /* renamed from: f */
    public static final ByteString f28657f = ByteString.encodeUtf8(":authority");
    /* renamed from: g */
    public final ByteString f28658g;
    /* renamed from: h */
    public final ByteString f28659h;
    /* renamed from: i */
    final int f28660i;

    public C8453a(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public C8453a(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public C8453a(ByteString byteString, ByteString byteString2) {
        this.f28658g = byteString;
        this.f28659h = byteString2;
        this.f28660i = byteString.size() + 32 + byteString2.size();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C8453a)) {
            return false;
        }
        C8453a aVar = (C8453a) obj;
        if (!this.f28658g.equals(aVar.f28658g) || !this.f28659h.equals(aVar.f28659h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f28658g.hashCode()) * 31) + this.f28659h.hashCode();
    }

    public String toString() {
        return C8417c.m36030a("%s: %s", this.f28658g.utf8(), this.f28659h.utf8());
    }
}
