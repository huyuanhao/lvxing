package com.bytedance.sdk.p145a.p146a;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.bytedance.sdk.a.a.n */
final class RealBufferedSource implements BufferedSource {
    /* renamed from: a */
    public final Buffer f5271a = new Buffer();
    /* renamed from: b */
    public final Source f5272b;
    /* renamed from: c */
    boolean f5273c;

    RealBufferedSource(Source sVar) {
        if (sVar != null) {
            this.f5272b = sVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    /* renamed from: c */
    public Buffer mo13535c() {
        return this.f5271a;
    }

    /* renamed from: a */
    public long mo13511a(Buffer cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f5273c) {
            throw new IllegalStateException("closed");
        } else if (this.f5271a.f5243b == 0 && this.f5272b.mo13511a(this.f5271a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        } else {
            return this.f5271a.mo13511a(cVar, Math.min(j, this.f5271a.f5243b));
        }
    }

    /* renamed from: e */
    public boolean mo13546e() throws IOException {
        if (!this.f5273c) {
            return this.f5271a.mo13546e() && this.f5272b.mo13511a(this.f5271a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public void mo13527a(long j) throws IOException {
        if (!mo13624b(j)) {
            throw new EOFException();
        }
    }

    /* renamed from: b */
    public boolean mo13624b(long j) throws IOException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (!this.f5273c) {
            while (this.f5271a.f5243b < j) {
                if (this.f5272b.mo13511a(this.f5271a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: h */
    public byte mo13554h() throws IOException {
        mo13527a(1);
        return this.f5271a.mo13554h();
    }

    /* renamed from: c */
    public ByteString mo13539c(long j) throws IOException {
        mo13527a(j);
        return this.f5271a.mo13539c(j);
    }

    /* renamed from: g */
    public byte[] mo13553g(long j) throws IOException {
        mo13527a(j);
        return this.f5271a.mo13553g(j);
    }

    /* renamed from: a */
    public void mo13528a(byte[] bArr) throws IOException {
        try {
            mo13527a((long) bArr.length);
            this.f5271a.mo13528a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f5271a.f5243b > 0) {
                Buffer cVar = this.f5271a;
                int a = cVar.mo13516a(bArr, i, (int) cVar.f5243b);
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
        if (this.f5271a.f5243b == 0 && this.f5272b.mo13511a(this.f5271a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f5271a.read(byteBuffer);
    }

    /* renamed from: p */
    public String mo13571p() throws IOException {
        return mo13545e(Long.MAX_VALUE);
    }

    /* renamed from: e */
    public String mo13545e(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long a = mo13623a(10, 0, j2);
            if (a != -1) {
                return this.f5271a.mo13550f(a);
            }
            if (j2 < Long.MAX_VALUE && mo13624b(j2) && this.f5271a.mo13529b(j2 - 1) == 13 && mo13624b(1 + j2) && this.f5271a.mo13529b(j2) == 10) {
                return this.f5271a.mo13550f(j2);
            }
            Buffer cVar = new Buffer();
            Buffer cVar2 = this.f5271a;
            cVar2.mo13521a(cVar, 0, Math.min(32, cVar2.mo13530b()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(this.f5271a.mo13530b(), j));
            sb.append(" content=");
            sb.append(cVar.mo13569n().mo13597e());
            sb.append(8230);
            throw new EOFException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("limit < 0: ");
        sb2.append(j);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* renamed from: i */
    public short mo13560i() throws IOException {
        mo13527a(2);
        return this.f5271a.mo13560i();
    }

    /* renamed from: k */
    public short mo13565k() throws IOException {
        mo13527a(2);
        return this.f5271a.mo13565k();
    }

    /* renamed from: j */
    public int mo13562j() throws IOException {
        mo13527a(4);
        return this.f5271a.mo13562j();
    }

    /* renamed from: l */
    public int mo13566l() throws IOException {
        mo13527a(4);
        return this.f5271a.mo13566l();
    }

    /* renamed from: m */
    public long mo13568m() throws IOException {
        mo13527a(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!mo13624b((long) i2)) {
                break;
            }
            byte b = this.f5271a.mo13529b((long) i);
            if ((b >= 48 && b <= 57) || ((b >= 97 && b <= 102) || (b >= 65 && b <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
            }
        }
        return this.f5271a.mo13568m();
    }

    /* renamed from: h */
    public void mo13556h(long j) throws IOException {
        if (!this.f5273c) {
            while (j > 0) {
                if (this.f5271a.f5243b == 0 && this.f5272b.mo13511a(this.f5271a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f5271a.mo13530b());
                this.f5271a.mo13556h(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public long mo13517a(byte b) throws IOException {
        return mo13623a(b, 0, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long mo13623a(byte b, long j, long j2) throws IOException {
        if (this.f5273c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long a = this.f5271a.mo13518a(b, j, j2);
                if (a == -1) {
                    long j3 = this.f5271a.f5243b;
                    if (j3 >= j2 || this.f5272b.mo13511a(this.f5271a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
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

    /* renamed from: f */
    public InputStream mo13549f() {
        return new InputStream() {
            public int read() throws IOException {
                if (RealBufferedSource.this.f5273c) {
                    throw new IOException("closed");
                } else if (RealBufferedSource.this.f5271a.f5243b == 0 && RealBufferedSource.this.f5272b.mo13511a(RealBufferedSource.this.f5271a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                } else {
                    return RealBufferedSource.this.f5271a.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                }
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!RealBufferedSource.this.f5273c) {
                    C1868u.m6834a((long) bArr.length, (long) i, (long) i2);
                    if (RealBufferedSource.this.f5271a.f5243b == 0 && RealBufferedSource.this.f5272b.mo13511a(RealBufferedSource.this.f5271a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.f5271a.mo13516a(bArr, i, i2);
                }
                throw new IOException("closed");
            }

            public int available() throws IOException {
                if (!RealBufferedSource.this.f5273c) {
                    return (int) Math.min(RealBufferedSource.this.f5271a.f5243b, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(RealBufferedSource.this);
                sb.append(".inputStream()");
                return sb.toString();
            }
        };
    }

    public boolean isOpen() {
        return !this.f5273c;
    }

    public void close() throws IOException {
        if (!this.f5273c) {
            this.f5273c = true;
            this.f5272b.close();
            this.f5271a.mo13573r();
        }
    }

    /* renamed from: a */
    public Timeout mo13512a() {
        return this.f5272b.mo13512a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.f5272b);
        sb.append(")");
        return sb.toString();
    }
}
