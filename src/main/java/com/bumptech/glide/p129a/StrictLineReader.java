package com.bumptech.glide.p129a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.bumptech.glide.a.b */
class StrictLineReader implements Closeable {
    /* renamed from: a */
    private final InputStream f4136a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final Charset f4137b;
    /* renamed from: c */
    private byte[] f4138c;
    /* renamed from: d */
    private int f4139d;
    /* renamed from: e */
    private int f4140e;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public StrictLineReader(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(Util.f4142a)) {
            this.f4136a = inputStream;
            this.f4137b = charset;
            this.f4138c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f4136a) {
            if (this.f4138c != null) {
                this.f4138c = null;
                this.f4136a.close();
            }
        }
    }

    /* renamed from: a */
    public String mo12378a() throws IOException {
        int i;
        int i2;
        synchronized (this.f4136a) {
            if (this.f4138c != null) {
                if (this.f4139d >= this.f4140e) {
                    m4924c();
                }
                for (int i3 = this.f4139d; i3 != this.f4140e; i3++) {
                    if (this.f4138c[i3] == 10) {
                        if (i3 != this.f4139d) {
                            i2 = i3 - 1;
                            if (this.f4138c[i2] == 13) {
                                String str = new String(this.f4138c, this.f4139d, i2 - this.f4139d, this.f4137b.name());
                                this.f4139d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f4138c, this.f4139d, i2 - this.f4139d, this.f4137b.name());
                        this.f4139d = i3 + 1;
                        return str2;
                    }
                }
                C16021 r1 = new ByteArrayOutputStream((this.f4140e - this.f4139d) + 80) {
                    public String toString() {
                        int i = (this.count <= 0 || this.buf[this.count - 1] != 13) ? this.count : this.count - 1;
                        try {
                            return new String(this.buf, 0, i, StrictLineReader.this.f4137b.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1:
                while (true) {
                    r1.write(this.f4138c, this.f4139d, this.f4140e - this.f4139d);
                    this.f4140e = -1;
                    m4924c();
                    i = this.f4139d;
                    while (true) {
                        if (i != this.f4140e) {
                            if (this.f4138c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f4139d) {
                    r1.write(this.f4138c, this.f4139d, i - this.f4139d);
                }
                this.f4139d = i + 1;
                String byteArrayOutputStream = r1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    /* renamed from: b */
    public boolean mo12379b() {
        return this.f4140e == -1;
    }

    /* renamed from: c */
    private void m4924c() throws IOException {
        InputStream inputStream = this.f4136a;
        byte[] bArr = this.f4138c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f4139d = 0;
            this.f4140e = read;
            return;
        }
        throw new EOFException();
    }
}
