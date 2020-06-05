package com.bytedance.sdk.adnet.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.bytedance.sdk.adnet.core.e */
class ByteArrayPoolOutputStream extends ByteArrayOutputStream {
    /* renamed from: a */
    private final ByteArrayPool f6228a;

    public ByteArrayPoolOutputStream(ByteArrayPool dVar, int i) {
        this.f6228a = dVar;
        this.buf = this.f6228a.mo14318a(Math.max(i, 256));
    }

    public void close() throws IOException {
        this.f6228a.mo14317a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f6228a.mo14317a(this.buf);
    }

    /* renamed from: a */
    private void m7827a(int i) {
        if (this.count + i > this.buf.length) {
            byte[] a = this.f6228a.mo14318a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f6228a.mo14317a(this.buf);
            this.buf = a;
        }
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m7827a(i2);
        super.write(bArr, i, i2);
    }

    public synchronized void write(int i) {
        m7827a(1);
        super.write(i);
    }
}
