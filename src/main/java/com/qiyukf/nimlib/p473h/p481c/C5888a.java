package com.qiyukf.nimlib.p473h.p481c;

import com.qiyukf.basesdk.sdk.ResponseCode;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5891a;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5894b;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5898f;

/* renamed from: com.qiyukf.nimlib.h.c.a */
public final class C5888a implements C5891a {
    /* renamed from: a */
    private byte f18641a;
    /* renamed from: b */
    private byte f18642b;
    /* renamed from: c */
    private short f18643c;
    /* renamed from: d */
    private byte f18644d;
    /* renamed from: e */
    private int f18645e = 0;
    /* renamed from: f */
    private short f18646f = ResponseCode.RES_SUCCESS;

    public C5888a() {
    }

    public C5888a(byte b, byte b2) {
        this.f18641a = b;
        this.f18642b = b2;
    }

    /* renamed from: a */
    public final C5888a mo28221a() {
        C5888a aVar = new C5888a();
        aVar.f18641a = this.f18641a;
        aVar.f18642b = this.f18642b;
        aVar.f18643c = this.f18643c;
        aVar.f18644d = this.f18644d;
        aVar.f18645e = this.f18645e;
        aVar.f18646f = this.f18646f;
        return aVar;
    }

    /* renamed from: a */
    public final void mo28222a(int i) {
        this.f18645e = i;
    }

    /* renamed from: a */
    public final void mo28223a(C5894b bVar) {
        bVar.mo28255b(this.f18645e);
        bVar.mo28246a(this.f18641a);
        bVar.mo28246a(this.f18642b);
        bVar.mo28252a(this.f18643c);
        bVar.mo28246a(this.f18644d);
        if (mo28229d()) {
            bVar.mo28252a(this.f18646f);
        }
    }

    /* renamed from: a */
    public final void mo28224a(C5898f fVar) {
        this.f18645e = fVar.mo28267f();
        this.f18641a = fVar.mo28264c();
        this.f18642b = fVar.mo28264c();
        this.f18643c = fVar.mo28269h();
        this.f18644d = fVar.mo28264c();
        if (mo28229d()) {
            this.f18646f = fVar.mo28269h();
        }
    }

    /* renamed from: a */
    public final void mo28225a(short s) {
        this.f18643c = s;
    }

    /* renamed from: b */
    public final void mo28226b() {
        this.f18646f = ResponseCode.RES_SUCCESS;
        this.f18644d = 0;
        this.f18645e = 0;
    }

    /* renamed from: b */
    public final void mo28227b(short s) {
        this.f18644d = (byte) (this.f18644d | 2);
        this.f18646f = s;
    }

    /* renamed from: c */
    public final boolean mo28228c() {
        return (this.f18644d & 1) != 0;
    }

    /* renamed from: d */
    public final boolean mo28229d() {
        return (this.f18644d & 2) != 0;
    }

    /* renamed from: e */
    public final void mo28230e() {
        this.f18644d = (byte) (this.f18644d | 1);
    }

    /* renamed from: f */
    public final void mo28231f() {
        this.f18644d = (byte) (this.f18644d & -2);
    }

    /* renamed from: g */
    public final byte mo28232g() {
        return this.f18641a;
    }

    /* renamed from: h */
    public final byte mo28233h() {
        return this.f18642b;
    }

    /* renamed from: i */
    public final short mo28234i() {
        return this.f18643c;
    }

    /* renamed from: j */
    public final short mo28235j() {
        return this.f18646f;
    }

    /* renamed from: k */
    public final byte mo28236k() {
        return this.f18644d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PacketHeader [SID ");
        sb.append(this.f18641a);
        sb.append(" , CID ");
        sb.append(this.f18642b);
        sb.append(" , SER ");
        sb.append(this.f18643c);
        sb.append(" , RES ");
        sb.append(this.f18646f);
        sb.append(" , TAG ");
        sb.append(this.f18644d);
        sb.append(" , LEN ");
        sb.append(this.f18645e);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append("]");
        return sb3.toString();
    }
}
