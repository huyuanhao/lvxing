package com.qiyukf.nimlib.p473h.p481c.p484c;

import java.nio.ByteBuffer;
import java.util.zip.Inflater;

/* renamed from: com.qiyukf.nimlib.h.c.c.e */
public final class C5897e {
    /* renamed from: a */
    public static ByteBuffer m23619a(C5898f fVar) {
        int e = fVar.mo28266e();
        if (e < 0 || e >= 10485760) {
            StringBuilder sb = new StringBuilder("invalid uncompress len:");
            sb.append(e);
            throw new C5899g(sb.toString());
        }
        try {
            ByteBuffer allocate = ByteBuffer.allocate(e);
            Inflater inflater = new Inflater();
            ByteBuffer b = fVar.mo28263b();
            inflater.setInput(b.array(), b.position(), b.limit() - b.position());
            allocate.position(inflater.inflate(allocate.array()));
            inflater.end();
            allocate.flip();
            return allocate;
        } catch (Exception unused) {
            throw new C5899g("uncompress error");
        }
    }
}
