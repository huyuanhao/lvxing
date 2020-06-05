package com.bytedance.sdk.p145a.p146a;

import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bytedance.sdk.a.a.m */
final class RealBufferedSink implements BufferedSink {
    /* renamed from: a */
    public final Buffer f5268a = new Buffer();
    /* renamed from: b */
    public final Sink f5269b;
    /* renamed from: c */
    boolean f5270c;

    RealBufferedSink(Sink rVar) {
        if (rVar != null) {
            this.f5269b = rVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    /* renamed from: c */
    public Buffer mo13535c() {
        return this.f5268a;
    }

    /* renamed from: a_ */
    public void mo13507a_(Buffer cVar, long j) throws IOException {
        if (!this.f5270c) {
            this.f5268a.mo13507a_(cVar, j);
            mo13578u();
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public BufferedSink mo13534b(String str) throws IOException {
        if (!this.f5270c) {
            this.f5268a.mo13534b(str);
            return mo13578u();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: c */
    public BufferedSink mo13537c(byte[] bArr) throws IOException {
        if (!this.f5270c) {
            this.f5268a.mo13537c(bArr);
            return mo13578u();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: c */
    public BufferedSink mo13538c(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f5270c) {
            this.f5268a.mo13538c(bArr, i, i2);
            return mo13578u();
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f5270c) {
            int write = this.f5268a.write(byteBuffer);
            mo13578u();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: i */
    public BufferedSink mo13559i(int i) throws IOException {
        if (!this.f5270c) {
            this.f5268a.mo13559i(i);
            return mo13578u();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: h */
    public BufferedSink mo13555h(int i) throws IOException {
        if (!this.f5270c) {
            this.f5268a.mo13555h(i);
            return mo13578u();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: g */
    public BufferedSink mo13552g(int i) throws IOException {
        if (!this.f5270c) {
            this.f5268a.mo13552g(i);
            return mo13578u();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: l */
    public BufferedSink mo13567l(long j) throws IOException {
        if (!this.f5270c) {
            this.f5268a.mo13567l(j);
            return mo13578u();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: k */
    public BufferedSink mo13564k(long j) throws IOException {
        if (!this.f5270c) {
            this.f5268a.mo13564k(j);
            return mo13578u();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: u */
    public BufferedSink mo13578u() throws IOException {
        if (!this.f5270c) {
            long g = this.f5268a.mo13551g();
            if (g > 0) {
                this.f5269b.mo13507a_(this.f5268a, g);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() throws IOException {
        if (!this.f5270c) {
            if (this.f5268a.f5243b > 0) {
                Sink rVar = this.f5269b;
                Buffer cVar = this.f5268a;
                rVar.mo13507a_(cVar, cVar.f5243b);
            }
            this.f5269b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f5270c;
    }

    public void close() throws IOException {
        if (!this.f5270c) {
            Throwable th = null;
            try {
                if (this.f5268a.f5243b > 0) {
                    this.f5269b.mo13507a_(this.f5268a, this.f5268a.f5243b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f5269b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f5270c = true;
            if (th != null) {
                C1868u.m6835a(th);
            }
        }
    }

    /* renamed from: a */
    public Timeout mo13506a() {
        return this.f5269b.mo13506a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.f5269b);
        sb.append(")");
        return sb.toString();
    }
}
