package org.apache.thrift;

import java.io.ByteArrayOutputStream;

/* renamed from: org.apache.thrift.d */
public class TByteArrayOutputStream extends ByteArrayOutputStream {
    /* renamed from: a */
    private final int f29067a;

    public TByteArrayOutputStream(int i) {
        super(i);
        this.f29067a = i;
    }

    public TByteArrayOutputStream() {
        this(32);
    }

    /* renamed from: a */
    public byte[] mo40877a() {
        return this.buf;
    }

    public void reset() {
        super.reset();
        int length = this.buf.length;
        int i = this.f29067a;
        if (length > i) {
            this.buf = new byte[i];
        }
    }

    /* renamed from: b */
    public int mo40878b() {
        return this.count;
    }
}
