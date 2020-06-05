package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.util.g */
public class MarkEnforcingInputStream extends FilterInputStream {
    /* renamed from: a */
    private int f4918a = Integer.MIN_VALUE;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public synchronized void mark(int i) {
        super.mark(i);
        this.f4918a = i;
    }

    public int read() throws IOException {
        if (m6135a(1) == -1) {
            return -1;
        }
        int read = super.read();
        m6136b(1);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int a = (int) m6135a((long) i2);
        if (a == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a);
        m6136b((long) read);
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.f4918a = Integer.MIN_VALUE;
    }

    public long skip(long j) throws IOException {
        long a = m6135a(j);
        if (a == -1) {
            return 0;
        }
        long skip = super.skip(a);
        m6136b(skip);
        return skip;
    }

    public int available() throws IOException {
        int i = this.f4918a;
        if (i == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i, super.available());
    }

    /* renamed from: a */
    private long m6135a(long j) {
        int i = this.f4918a;
        if (i == 0) {
            return -1;
        }
        if (i != Integer.MIN_VALUE && j > ((long) i)) {
            j = (long) i;
        }
        return j;
    }

    /* renamed from: b */
    private void m6136b(long j) {
        int i = this.f4918a;
        if (i != Integer.MIN_VALUE && j != -1) {
            this.f4918a = (int) (((long) i) - j);
        }
    }
}
