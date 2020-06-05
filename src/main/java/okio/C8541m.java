package okio;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: RealBufferedSource */
/* renamed from: okio.m */
final class C8541m implements C8529e {
    /* renamed from: a */
    public final C8525c f29042a = new C8525c();
    /* renamed from: b */
    public final C8547r f29043b;
    /* renamed from: c */
    boolean f29044c;

    C8541m(C8547r rVar) {
        if (rVar != null) {
            this.f29043b = rVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    /* renamed from: c */
    public C8525c mo40741c() {
        return this.f29042a;
    }

    /* renamed from: a */
    public long mo40202a(C8525c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f29044c) {
            throw new IllegalStateException("closed");
        } else if (this.f29042a.f29018b == 0 && this.f29043b.mo40202a(this.f29042a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        } else {
            return this.f29042a.mo40202a(cVar, Math.min(j, this.f29042a.f29018b));
        }
    }

    /* renamed from: f */
    public boolean mo40755f() throws IOException {
        if (!this.f29044c) {
            return this.f29042a.mo40755f() && this.f29043b.mo40202a(this.f29042a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public void mo40729a(long j) throws IOException {
        if (!mo40819b(j)) {
            throw new EOFException();
        }
    }

    /* renamed from: b */
    public boolean mo40819b(long j) throws IOException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (!this.f29044c) {
            while (this.f29042a.f29018b < j) {
                if (this.f29043b.mo40202a(this.f29042a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: i */
    public byte mo40763i() throws IOException {
        mo40729a(1);
        return this.f29042a.mo40763i();
    }

    /* renamed from: c */
    public ByteString mo40740c(long j) throws IOException {
        mo40729a(j);
        return this.f29042a.mo40740c(j);
    }

    /* renamed from: s */
    public byte[] mo40780s() throws IOException {
        this.f29042a.mo40719a(this.f29043b);
        return this.f29042a.mo40780s();
    }

    /* renamed from: g */
    public byte[] mo40758g(long j) throws IOException {
        mo40729a(j);
        return this.f29042a.mo40758g(j);
    }

    /* renamed from: a */
    public void mo40730a(byte[] bArr) throws IOException {
        try {
            mo40729a((long) bArr.length);
            this.f29042a.mo40730a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f29042a.f29018b > 0) {
                C8525c cVar = this.f29042a;
                int a = cVar.mo40715a(bArr, i, (int) cVar.f29018b);
                if (a != -1) {
                    i += a;
                } else {
                    throw new AssertionError();
                }
            }
            throw e;
        }
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f29042a.f29018b == 0 && this.f29043b.mo40202a(this.f29042a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f29042a.read(byteBuffer);
    }

    /* renamed from: a */
    public long mo40718a(C8546q qVar) throws IOException {
        if (qVar != null) {
            long j = 0;
            while (this.f29043b.mo40202a(this.f29042a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                long h = this.f29042a.mo40759h();
                if (h > 0) {
                    j += h;
                    qVar.mo40231a_(this.f29042a, h);
                }
            }
            if (this.f29042a.mo40734b() <= 0) {
                return j;
            }
            long b = j + this.f29042a.mo40734b();
            C8525c cVar = this.f29042a;
            qVar.mo40231a_(cVar, cVar.mo40734b());
            return b;
        }
        throw new IllegalArgumentException("sink == null");
    }

    /* renamed from: a */
    public String mo40721a(Charset charset) throws IOException {
        if (charset != null) {
            this.f29042a.mo40719a(this.f29043b);
            return this.f29042a.mo40721a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* renamed from: r */
    public String mo40778r() throws IOException {
        return mo40749e(Long.MAX_VALUE);
    }

    /* renamed from: e */
    public String mo40749e(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long a = mo40817a(10, 0, j2);
            if (a != -1) {
                return this.f29042a.mo40753f(a);
            }
            if (j2 < Long.MAX_VALUE && mo40819b(j2) && this.f29042a.mo40733b(j2 - 1) == 13 && mo40819b(1 + j2) && this.f29042a.mo40733b(j2) == 10) {
                return this.f29042a.mo40753f(j2);
            }
            C8525c cVar = new C8525c();
            C8525c cVar2 = this.f29042a;
            cVar2.mo40728a(cVar, 0, Math.min(32, cVar2.mo40734b()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(this.f29042a.mo40734b(), j));
            sb.append(" content=");
            sb.append(cVar.mo40776p().hex());
            sb.append(8230);
            throw new EOFException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("limit < 0: ");
        sb2.append(j);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* renamed from: j */
    public short mo40768j() throws IOException {
        mo40729a(2);
        return this.f29042a.mo40768j();
    }

    /* renamed from: l */
    public short mo40772l() throws IOException {
        mo40729a(2);
        return this.f29042a.mo40772l();
    }

    /* renamed from: k */
    public int mo40769k() throws IOException {
        mo40729a(4);
        return this.f29042a.mo40769k();
    }

    /* renamed from: m */
    public int mo40773m() throws IOException {
        mo40729a(4);
        return this.f29042a.mo40773m();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* renamed from: n */
    public long mo40774n() throws java.io.IOException {
        /*
        r6 = this;
        r0 = 1
        r6.mo40729a(r0)
        r0 = 0
        r1 = 0
    L_0x0007:
        int r2 = r1 + 1
        long r3 = (long) r2
        boolean r3 = r6.mo40819b(r3)
        if (r3 == 0) goto L_0x0040
        okio.c r3 = r6.f29042a
        long r4 = (long) r1
        byte r3 = r3.mo40733b(r4)
        r4 = 48
        if (r3 < r4) goto L_0x001f
        r4 = 57
        if (r3 <= r4) goto L_0x0026
    L_0x001f:
        if (r1 != 0) goto L_0x0028
        r4 = 45
        if (r3 == r4) goto L_0x0026
        goto L_0x0028
    L_0x0026:
        r1 = r2
        goto L_0x0007
    L_0x0028:
        if (r1 == 0) goto L_0x002b
        goto L_0x0040
    L_0x002b:
        java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
        r2 = 1
        java.lang.Object[] r2 = new java.lang.Object[r2]
        java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
        r2[r0] = r3
        java.lang.String r0 = "Expected leading [0-9] or '-' character but was %#x"
        java.lang.String r0 = java.lang.String.format(r0, r2)
        r1.<init>(r0)
        throw r1
    L_0x0040:
        okio.c r0 = r6.f29042a
        long r0 = r0.mo40774n()
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.C8541m.mo40774n():long");
    }

    /* renamed from: o */
    public long mo40775o() throws IOException {
        mo40729a(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!mo40819b((long) i2)) {
                break;
            }
            byte b = this.f29042a.mo40733b((long) i);
            if ((b >= 48 && b <= 57) || ((b >= 97 && b <= 102) || (b >= 65 && b <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
            }
        }
        return this.f29042a.mo40775o();
    }

    /* renamed from: h */
    public void mo40761h(long j) throws IOException {
        if (!this.f29044c) {
            while (j > 0) {
                if (this.f29042a.f29018b == 0 && this.f29043b.mo40202a(this.f29042a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f29042a.mo40734b());
                this.f29042a.mo40761h(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public long mo40716a(byte b) throws IOException {
        return mo40817a(b, 0, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long mo40817a(byte b, long j, long j2) throws IOException {
        if (this.f29044c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long a = this.f29042a.mo40717a(b, j, j2);
                if (a == -1) {
                    long j3 = this.f29042a.f29018b;
                    if (j3 >= j2 || this.f29043b.mo40202a(this.f29042a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return a;
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    public boolean mo40731a(long j, ByteString byteString) throws IOException {
        return mo40818a(j, byteString, 0, byteString.size());
    }

    /* renamed from: a */
    public boolean mo40818a(long j, ByteString byteString, int i, int i2) throws IOException {
        if (this.f29044c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        } else {
            int i3 = 0;
            while (i3 < i2) {
                long j2 = ((long) i3) + j;
                if (!mo40819b(1 + j2) || this.f29042a.mo40733b(j2) != byteString.getByte(i + i3)) {
                    return false;
                }
                i3++;
            }
            return true;
        }
    }

    /* renamed from: g */
    public InputStream mo40756g() {
        return new InputStream() {
            public int read() throws IOException {
                if (C8541m.this.f29044c) {
                    throw new IOException("closed");
                } else if (C8541m.this.f29042a.f29018b == 0 && C8541m.this.f29043b.mo40202a(C8541m.this.f29042a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                } else {
                    return C8541m.this.f29042a.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                }
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!C8541m.this.f29044c) {
                    C8550t.m36938a((long) bArr.length, (long) i, (long) i2);
                    if (C8541m.this.f29042a.f29018b == 0 && C8541m.this.f29043b.mo40202a(C8541m.this.f29042a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        return -1;
                    }
                    return C8541m.this.f29042a.mo40715a(bArr, i, i2);
                }
                throw new IOException("closed");
            }

            public int available() throws IOException {
                if (!C8541m.this.f29044c) {
                    return (int) Math.min(C8541m.this.f29042a.f29018b, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                C8541m.this.close();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(C8541m.this);
                sb.append(".inputStream()");
                return sb.toString();
            }
        };
    }

    public boolean isOpen() {
        return !this.f29044c;
    }

    public void close() throws IOException {
        if (!this.f29044c) {
            this.f29044c = true;
            this.f29043b.close();
            this.f29042a.mo40781t();
        }
    }

    /* renamed from: a */
    public C8548s mo40203a() {
        return this.f29043b.mo40203a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.f29043b);
        sb.append(")");
        return sb.toString();
    }
}
