package com.bumptech.glide.load.p135a;

import com.bumptech.glide.load.engine.p137a.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.bumptech.glide.load.a.c */
public final class BufferedOutputStream extends OutputStream {
    /* renamed from: a */
    private final OutputStream f4401a;
    /* renamed from: b */
    private byte[] f4402b;
    /* renamed from: c */
    private ArrayPool f4403c;
    /* renamed from: d */
    private int f4404d;

    public BufferedOutputStream(OutputStream outputStream, ArrayPool bVar) {
        this(outputStream, bVar, 65536);
    }

    BufferedOutputStream(OutputStream outputStream, ArrayPool bVar, int i) {
        this.f4401a = outputStream;
        this.f4403c = bVar;
        this.f4402b = (byte[]) bVar.mo12702a(i, byte[].class);
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.f4402b;
        int i2 = this.f4404d;
        this.f4404d = i2 + 1;
        bArr[i2] = (byte) i;
        m5328b();
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.f4404d != 0 || i4 < this.f4402b.length) {
                int min = Math.min(i4, this.f4402b.length - this.f4404d);
                System.arraycopy(bArr, i5, this.f4402b, this.f4404d, min);
                this.f4404d += min;
                i3 += min;
                m5328b();
            } else {
                this.f4401a.write(bArr, i5, i4);
                return;
            }
        } while (i3 < i2);
    }

    public void flush() throws IOException {
        m5327a();
        this.f4401a.flush();
    }

    /* renamed from: a */
    private void m5327a() throws IOException {
        int i = this.f4404d;
        if (i > 0) {
            this.f4401a.write(this.f4402b, 0, i);
            this.f4404d = 0;
        }
    }

    /* renamed from: b */
    private void m5328b() throws IOException {
        if (this.f4404d == this.f4402b.length) {
            m5327a();
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.f4401a.close();
            m5329c();
        } catch (Throwable th) {
            this.f4401a.close();
            throw th;
        }
    }

    /* renamed from: c */
    private void m5329c() {
        byte[] bArr = this.f4402b;
        if (bArr != null) {
            this.f4403c.mo12705a(bArr);
            this.f4402b = null;
        }
    }
}
