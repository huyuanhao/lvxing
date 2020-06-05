package com.qiyukf.nimlib.p473h.p481c.p484c;

import com.qiyukf.nimlib.p473h.p481c.p483b.C5891a;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.qiyukf.nimlib.h.c.c.f */
public final class C5898f {
    /* renamed from: a */
    protected ByteBuffer f18654a;

    public C5898f() {
        this.f18654a = null;
    }

    public C5898f(ByteBuffer byteBuffer) {
        this(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit() - byteBuffer.position());
    }

    public C5898f(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    private C5898f(byte[] bArr, int i, int i2) {
        this.f18654a = ByteBuffer.wrap(bArr, i, i2);
        this.f18654a.order(ByteOrder.LITTLE_ENDIAN);
    }

    /* renamed from: a */
    private byte[] m23620a(int i) {
        try {
            byte[] bArr = new byte[i];
            this.f18654a.get(bArr);
            return bArr;
        } catch (BufferUnderflowException unused) {
            throw new C5899g();
        }
    }

    /* renamed from: a */
    public final int mo28260a() {
        return this.f18654a.limit() - this.f18654a.position();
    }

    /* renamed from: a */
    public final C5891a mo28261a(C5891a aVar) {
        aVar.mo28224a(this);
        return aVar;
    }

    /* renamed from: a */
    public final String mo28262a(String str) {
        try {
            return new String(mo28265d(), str);
        } catch (UnsupportedEncodingException unused) {
            throw new C5899g();
        }
    }

    /* renamed from: b */
    public final ByteBuffer mo28263b() {
        return this.f18654a.duplicate();
    }

    /* renamed from: c */
    public final byte mo28264c() {
        try {
            return this.f18654a.get();
        } catch (BufferUnderflowException unused) {
            throw new C5899g();
        }
    }

    /* renamed from: d */
    public final byte[] mo28265d() {
        return m23620a(mo28267f());
    }

    /* renamed from: e */
    public final int mo28266e() {
        try {
            return this.f18654a.getInt();
        } catch (BufferUnderflowException unused) {
            throw new C5899g();
        }
    }

    /* renamed from: f */
    public final int mo28267f() {
        byte c;
        int i = 1;
        int i2 = 0;
        do {
            c = mo28264c();
            i2 += (c & Byte.MAX_VALUE) * i;
            i <<= 7;
        } while ((c & Byte.MIN_VALUE) != 0);
        return i2;
    }

    /* renamed from: g */
    public final long mo28268g() {
        try {
            return this.f18654a.getLong();
        } catch (BufferUnderflowException unused) {
            throw new C5899g();
        }
    }

    /* renamed from: h */
    public final short mo28269h() {
        try {
            return this.f18654a.getShort();
        } catch (BufferUnderflowException unused) {
            throw new C5899g();
        }
    }

    public final String toString() {
        return this.f18654a.toString();
    }
}
