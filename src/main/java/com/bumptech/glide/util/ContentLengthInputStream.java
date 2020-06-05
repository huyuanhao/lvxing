package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.util.b */
public final class ContentLengthInputStream extends FilterInputStream {
    /* renamed from: a */
    private final long f4905a;
    /* renamed from: b */
    private int f4906b;

    /* renamed from: a */
    public static InputStream m6117a(InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    private ContentLengthInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.f4905a = j;
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.f4905a - ((long) this.f4906b), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        m6116a(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return m6116a(super.read(bArr, i, i2));
    }

    /* renamed from: a */
    private int m6116a(int i) throws IOException {
        if (i >= 0) {
            this.f4906b += i;
        } else if (this.f4905a - ((long) this.f4906b) > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to read all expected data, expected: ");
            sb.append(this.f4905a);
            sb.append(", but read: ");
            sb.append(this.f4906b);
            throw new IOException(sb.toString());
        }
        return i;
    }
}
