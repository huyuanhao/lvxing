package com.kwad.sdk.core.diskcache.p321a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.kwad.sdk.core.diskcache.a.b */
class C4076b implements Closeable {
    /* renamed from: a */
    private final InputStream f13712a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final Charset f13713b;
    /* renamed from: c */
    private byte[] f13714c;
    /* renamed from: d */
    private int f13715d;
    /* renamed from: e */
    private int f13716e;

    public C4076b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(C4078c.f13718a)) {
            this.f13712a = inputStream;
            this.f13713b = charset;
            this.f13714c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public C4076b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    /* renamed from: c */
    private void m16942c() {
        InputStream inputStream = this.f13712a;
        byte[] bArr = this.f13714c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f13715d = 0;
            this.f13716e = read;
            return;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    public String mo23754a() {
        int i;
        int i2;
        synchronized (this.f13712a) {
            if (this.f13714c != null) {
                if (this.f13715d >= this.f13716e) {
                    m16942c();
                }
                for (int i3 = this.f13715d; i3 != this.f13716e; i3++) {
                    if (this.f13714c[i3] == 10) {
                        if (i3 != this.f13715d) {
                            i2 = i3 - 1;
                            if (this.f13714c[i2] == 13) {
                                String str = new String(this.f13714c, this.f13715d, i2 - this.f13715d, this.f13713b.name());
                                this.f13715d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f13714c, this.f13715d, i2 - this.f13715d, this.f13713b.name());
                        this.f13715d = i3 + 1;
                        return str2;
                    }
                }
                C40771 r1 = new ByteArrayOutputStream((this.f13716e - this.f13715d) + 80) {
                    public String toString() {
                        int i = (this.count <= 0 || this.buf[this.count - 1] != 13) ? this.count : this.count - 1;
                        try {
                            return new String(this.buf, 0, i, C4076b.this.f13713b.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1:
                while (true) {
                    r1.write(this.f13714c, this.f13715d, this.f13716e - this.f13715d);
                    this.f13716e = -1;
                    m16942c();
                    i = this.f13715d;
                    while (true) {
                        if (i != this.f13716e) {
                            if (this.f13714c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f13715d) {
                    r1.write(this.f13714c, this.f13715d, i - this.f13715d);
                }
                this.f13715d = i + 1;
                String byteArrayOutputStream = r1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    /* renamed from: b */
    public boolean mo23755b() {
        return this.f13716e == -1;
    }

    public void close() {
        synchronized (this.f13712a) {
            if (this.f13714c != null) {
                this.f13714c = null;
                this.f13712a.close();
            }
        }
    }
}
