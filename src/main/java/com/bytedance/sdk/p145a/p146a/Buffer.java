package com.bytedance.sdk.p145a.p146a;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* renamed from: com.bytedance.sdk.a.a.c */
public final class Buffer implements BufferedSink, BufferedSource, Cloneable, ByteChannel {
    /* renamed from: c */
    private static final byte[] f5241c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    /* renamed from: a */
    Segment f5242a;
    /* renamed from: b */
    long f5243b;

    /* renamed from: c */
    public Buffer mo13535c() {
        return this;
    }

    public void close() {
    }

    /* renamed from: d */
    public Buffer mo13578u() {
        return this;
    }

    public void flush() {
    }

    public boolean isOpen() {
        return true;
    }

    /* renamed from: b */
    public final long mo13530b() {
        return this.f5243b;
    }

    /* renamed from: e */
    public boolean mo13546e() {
        return this.f5243b == 0;
    }

    /* renamed from: a */
    public void mo13527a(long j) throws EOFException {
        if (this.f5243b < j) {
            throw new EOFException();
        }
    }

    /* renamed from: f */
    public InputStream mo13549f() {
        return new InputStream() {
            public void close() {
            }

            public int read() {
                if (Buffer.this.f5243b > 0) {
                    return Buffer.this.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                }
                return -1;
            }

            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.mo13516a(bArr, i, i2);
            }

            public int available() {
                return (int) Math.min(Buffer.this.f5243b, 2147483647L);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(Buffer.this);
                sb.append(".inputStream()");
                return sb.toString();
            }
        };
    }

    /* renamed from: a */
    public final Buffer mo13521a(Buffer cVar, long j, long j2) {
        if (cVar != null) {
            C1868u.m6834a(this.f5243b, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f5243b += j2;
            Segment oVar = this.f5242a;
            while (j >= ((long) (oVar.f5277c - oVar.f5276b))) {
                j -= (long) (oVar.f5277c - oVar.f5276b);
                oVar = oVar.f5280f;
            }
            while (j2 > 0) {
                Segment a = oVar.mo13633a();
                a.f5276b = (int) (((long) a.f5276b) + j);
                a.f5277c = Math.min(a.f5276b + ((int) j2), a.f5277c);
                Segment oVar2 = cVar.f5242a;
                if (oVar2 == null) {
                    a.f5281g = a;
                    a.f5280f = a;
                    cVar.f5242a = a;
                } else {
                    oVar2.f5281g.mo13635a(a);
                }
                j2 -= (long) (a.f5277c - a.f5276b);
                oVar = oVar.f5280f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: g */
    public final long mo13551g() {
        long j = this.f5243b;
        if (j == 0) {
            return 0;
        }
        Segment oVar = this.f5242a.f5281g;
        if (oVar.f5277c < 8192 && oVar.f5279e) {
            j -= (long) (oVar.f5277c - oVar.f5276b);
        }
        return j;
    }

    /* renamed from: h */
    public byte mo13554h() {
        if (this.f5243b != 0) {
            Segment oVar = this.f5242a;
            int i = oVar.f5276b;
            int i2 = oVar.f5277c;
            int i3 = i + 1;
            byte b = oVar.f5275a[i];
            this.f5243b--;
            if (i3 == i2) {
                this.f5242a = oVar.mo13637b();
                SegmentPool.m6801a(oVar);
            } else {
                oVar.f5276b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    /* renamed from: b */
    public final byte mo13529b(long j) {
        C1868u.m6834a(this.f5243b, j, 1);
        long j2 = this.f5243b;
        if (j2 - j > j) {
            Segment oVar = this.f5242a;
            while (true) {
                long j3 = (long) (oVar.f5277c - oVar.f5276b);
                if (j < j3) {
                    return oVar.f5275a[oVar.f5276b + ((int) j)];
                }
                j -= j3;
                oVar = oVar.f5280f;
            }
        } else {
            long j4 = j - j2;
            Segment oVar2 = this.f5242a;
            do {
                oVar2 = oVar2.f5281g;
                j4 += (long) (oVar2.f5277c - oVar2.f5276b);
            } while (j4 < 0);
            return oVar2.f5275a[oVar2.f5276b + ((int) j4)];
        }
    }

    /* renamed from: i */
    public short mo13560i() {
        if (this.f5243b >= 2) {
            Segment oVar = this.f5242a;
            int i = oVar.f5276b;
            int i2 = oVar.f5277c;
            if (i2 - i < 2) {
                return (short) (((mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
            }
            byte[] bArr = oVar.f5275a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            this.f5243b -= 2;
            if (i4 == i2) {
                this.f5242a = oVar.mo13637b();
                SegmentPool.m6801a(oVar);
            } else {
                oVar.f5276b = i4;
            }
            return (short) b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 2: ");
        sb.append(this.f5243b);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: j */
    public int mo13562j() {
        if (this.f5243b >= 4) {
            Segment oVar = this.f5242a;
            int i = oVar.f5276b;
            int i2 = oVar.f5277c;
            if (i2 - i < 4) {
                return ((mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | ((mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            }
            byte[] bArr = oVar.f5275a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | ((bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            this.f5243b -= 4;
            if (i6 == i2) {
                this.f5242a = oVar.mo13637b();
                SegmentPool.m6801a(oVar);
            } else {
                oVar.f5276b = i6;
            }
            return b3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 4: ");
        sb.append(this.f5243b);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: k */
    public short mo13565k() {
        return C1868u.m6833a(mo13560i());
    }

    /* renamed from: l */
    public int mo13566l() {
        return C1868u.m6832a(mo13562j());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
            if (r8 != r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
            r15.f5242a = r6.mo13637b();
            com.bytedance.sdk.p145a.p146a.SegmentPool.m6801a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
            r6.f5276b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009f, code lost:
            if (r0 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    /* renamed from: m */
    public long mo13568m() {
        /*
        r15 = this;
        long r0 = r15.f5243b
        r2 = 0
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 == 0) goto L_0x00ac
        r0 = 0
        r4 = r2
        r1 = 0
    L_0x000b:
        com.bytedance.sdk.a.a.o r6 = r15.f5242a
        byte[] r7 = r6.f5275a
        int r8 = r6.f5276b
        int r9 = r6.f5277c
    L_0x0013:
        if (r8 >= r9) goto L_0x0091
        byte r10 = r7[r8]
        r11 = 48
        if (r10 < r11) goto L_0x0022
        r11 = 57
        if (r10 > r11) goto L_0x0022
        int r11 = r10 + -48
        goto L_0x003a
    L_0x0022:
        r11 = 97
        if (r10 < r11) goto L_0x002f
        r11 = 102(0x66, float:1.43E-43)
        if (r10 > r11) goto L_0x002f
        int r11 = r10 + -97
    L_0x002c:
        int r11 = r11 + 10
        goto L_0x003a
    L_0x002f:
        r11 = 65
        if (r10 < r11) goto L_0x0072
        r11 = 70
        if (r10 > r11) goto L_0x0072
        int r11 = r10 + -65
        goto L_0x002c
    L_0x003a:
        r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
        long r12 = r12 & r4
        int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
        if (r14 != 0) goto L_0x004a
        r10 = 4
        long r4 = r4 << r10
        long r10 = (long) r11
        long r4 = r4 | r10
        int r8 = r8 + 1
        int r1 = r1 + 1
        goto L_0x0013
    L_0x004a:
        com.bytedance.sdk.a.a.c r0 = new com.bytedance.sdk.a.a.c
        r0.m42894init()
        com.bytedance.sdk.a.a.c r0 = r0.mo13564k(r4)
        com.bytedance.sdk.a.a.c r0 = r0.mo13559i(r10)
        java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "Number too large: "
        r2.append(r3)
        java.lang.String r0 = r0.mo13570o()
        r2.append(r0)
        java.lang.String r0 = r2.toString()
        r1.<init>(r0)
        throw r1
    L_0x0072:
        if (r1 == 0) goto L_0x0076
        r0 = 1
        goto L_0x0091
    L_0x0076:
        java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
        r1.append(r2)
        java.lang.String r2 = java.lang.Integer.toHexString(r10)
        r1.append(r2)
        java.lang.String r1 = r1.toString()
        r0.<init>(r1)
        throw r0
    L_0x0091:
        if (r8 != r9) goto L_0x009d
        com.bytedance.sdk.a.a.o r7 = r6.mo13637b()
        r15.f5242a = r7
        com.bytedance.sdk.p145a.p146a.SegmentPool.m6801a(r6)
        goto L_0x009f
    L_0x009d:
        r6.f5276b = r8
    L_0x009f:
        if (r0 != 0) goto L_0x00a5
        com.bytedance.sdk.a.a.o r6 = r15.f5242a
        if (r6 != 0) goto L_0x000b
    L_0x00a5:
        long r2 = r15.f5243b
        long r0 = (long) r1
        long r2 = r2 - r0
        r15.f5243b = r2
        return r4
    L_0x00ac:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
        java.lang.String r1 = "size == 0"
        r0.<init>(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p146a.Buffer.mo13568m():long");
    }

    /* renamed from: n */
    public ByteString mo13569n() {
        return new ByteString(mo13572q());
    }

    /* renamed from: c */
    public ByteString mo13539c(long j) throws EOFException {
        return new ByteString(mo13553g(j));
    }

    /* renamed from: o */
    public String mo13570o() {
        try {
            return mo13526a(this.f5243b, C1868u.f5290a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: d */
    public String mo13543d(long j) throws EOFException {
        return mo13526a(j, C1868u.f5290a);
    }

    /* renamed from: a */
    public String mo13526a(long j, Charset charset) throws EOFException {
        C1868u.m6834a(this.f5243b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount > Integer.MAX_VALUE: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (j == 0) {
            return "";
        } else {
            Segment oVar = this.f5242a;
            if (((long) oVar.f5276b) + j > ((long) oVar.f5277c)) {
                return new String(mo13553g(j), charset);
            }
            String str = new String(oVar.f5275a, oVar.f5276b, (int) j, charset);
            oVar.f5276b = (int) (((long) oVar.f5276b) + j);
            this.f5243b -= j;
            if (oVar.f5276b == oVar.f5277c) {
                this.f5242a = oVar.mo13637b();
                SegmentPool.m6801a(oVar);
            }
            return str;
        }
    }

    /* renamed from: p */
    public String mo13571p() throws EOFException {
        return mo13545e(Long.MAX_VALUE);
    }

    /* renamed from: e */
    public String mo13545e(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long a = mo13518a(10, 0, j2);
            if (a != -1) {
                return mo13550f(a);
            }
            if (j2 < mo13530b() && mo13529b(j2 - 1) == 13 && mo13529b(j2) == 10) {
                return mo13550f(j2);
            }
            Buffer cVar = new Buffer();
            mo13521a(cVar, 0, Math.min(32, mo13530b()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(mo13530b(), j));
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

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo13550f(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (mo13529b(j2) == 13) {
                String d = mo13543d(j2);
                mo13556h(2);
                return d;
            }
        }
        String d2 = mo13543d(j);
        mo13556h(1);
        return d2;
    }

    /* renamed from: q */
    public byte[] mo13572q() {
        try {
            return mo13553g(this.f5243b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: g */
    public byte[] mo13553g(long j) throws EOFException {
        C1868u.m6834a(this.f5243b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            mo13528a(bArr);
            return bArr;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("byteCount > Integer.MAX_VALUE: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public void mo13528a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a = mo13516a(bArr, i, bArr.length - i);
            if (a != -1) {
                i += a;
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public int mo13516a(byte[] bArr, int i, int i2) {
        C1868u.m6834a((long) bArr.length, (long) i, (long) i2);
        Segment oVar = this.f5242a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i2, oVar.f5277c - oVar.f5276b);
        System.arraycopy(oVar.f5275a, oVar.f5276b, bArr, i, min);
        oVar.f5276b += min;
        this.f5243b -= (long) min;
        if (oVar.f5276b == oVar.f5277c) {
            this.f5242a = oVar.mo13637b();
            SegmentPool.m6801a(oVar);
        }
        return min;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment oVar = this.f5242a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.f5277c - oVar.f5276b);
        byteBuffer.put(oVar.f5275a, oVar.f5276b, min);
        oVar.f5276b += min;
        this.f5243b -= (long) min;
        if (oVar.f5276b == oVar.f5277c) {
            this.f5242a = oVar.mo13637b();
            SegmentPool.m6801a(oVar);
        }
        return min;
    }

    /* renamed from: r */
    public final void mo13573r() {
        try {
            mo13556h(this.f5243b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: h */
    public void mo13556h(long j) throws EOFException {
        while (j > 0) {
            Segment oVar = this.f5242a;
            if (oVar != null) {
                int min = (int) Math.min(j, (long) (oVar.f5277c - this.f5242a.f5276b));
                long j2 = (long) min;
                this.f5243b -= j2;
                j -= j2;
                this.f5242a.f5276b += min;
                if (this.f5242a.f5276b == this.f5242a.f5277c) {
                    Segment oVar2 = this.f5242a;
                    this.f5242a = oVar2.mo13637b();
                    SegmentPool.m6801a(oVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public Buffer mo13522a(ByteString fVar) {
        if (fVar != null) {
            fVar.mo13588a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public Buffer mo13534b(String str) {
        return mo13524a(str, 0, str.length());
    }

    /* renamed from: a */
    public Buffer mo13524a(String str, int i, int i2) {
        char c;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("beginIndex < 0: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("endIndex < beginIndex: ");
            sb2.append(i2);
            sb2.append(" < ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    Segment e = mo13544e(1);
                    byte[] bArr = e.f5275a;
                    int i3 = e.f5277c - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i4 < min) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 >= 128) {
                            break;
                        }
                        int i5 = i4 + 1;
                        bArr[i4 + i3] = (byte) charAt2;
                        i4 = i5;
                    }
                    int i6 = (i3 + i4) - e.f5277c;
                    e.f5277c += i6;
                    this.f5243b += (long) i6;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        mo13559i((charAt >> 6) | 192);
                        mo13559i((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        mo13559i((charAt >> 12) | 224);
                        mo13559i(((charAt >> 6) & 63) | 128);
                        mo13559i((int) (charAt & '?') | 128);
                    } else {
                        int i7 = i + 1;
                        if (i7 < i2) {
                            c = str.charAt(i7);
                        } else {
                            c = 0;
                        }
                        if (charAt > 56319 || c < 56320 || c > 57343) {
                            mo13559i(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt & 10239) << 10) | (9215 & c)) + 0;
                            mo13559i((i8 >> 18) | ScreenUtil.G8_WIDTH);
                            mo13559i(((i8 >> 12) & 63) | 128);
                            mo13559i(((i8 >> 6) & 63) | 128);
                            mo13559i((i8 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("endIndex > string.length: ");
            sb3.append(i2);
            sb3.append(" > ");
            sb3.append(str.length());
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    /* renamed from: a */
    public Buffer mo13520a(int i) {
        if (i < 128) {
            mo13559i(i);
        } else if (i < 2048) {
            mo13559i((i >> 6) | 192);
            mo13559i((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                mo13559i((i >> 12) | 224);
                mo13559i(((i >> 6) & 63) | 128);
                mo13559i((i & 63) | 128);
            } else {
                mo13559i(63);
            }
        } else if (i <= 1114111) {
            mo13559i((i >> 18) | ScreenUtil.G8_WIDTH);
            mo13559i(((i >> 12) & 63) | 128);
            mo13559i(((i >> 6) & 63) | 128);
            mo13559i((i & 63) | 128);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected code point: ");
            sb.append(Integer.toHexString(i));
            throw new IllegalArgumentException(sb.toString());
        }
        return this;
    }

    /* renamed from: a */
    public Buffer mo13525a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("beginIndex < 0: ");
            sb.append(i);
            throw new IllegalAccessError(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("endIndex < beginIndex: ");
            sb2.append(i2);
            sb2.append(" < ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i2 > str.length()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("endIndex > string.length: ");
            sb3.append(i2);
            sb3.append(" > ");
            sb3.append(str.length());
            throw new IllegalArgumentException(sb3.toString());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(C1868u.f5290a)) {
            return mo13524a(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return mo13538c(bytes, 0, bytes.length);
        }
    }

    /* renamed from: b */
    public Buffer mo13537c(byte[] bArr) {
        if (bArr != null) {
            return mo13538c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public Buffer mo13538c(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            C1868u.m6834a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                Segment e = mo13544e(1);
                int min = Math.min(i3 - i, 8192 - e.f5277c);
                System.arraycopy(bArr, i, e.f5275a, e.f5277c, min);
                i += min;
                e.f5277c += min;
            }
            this.f5243b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                Segment e = mo13544e(1);
                int min = Math.min(i, 8192 - e.f5277c);
                byteBuffer.get(e.f5275a, e.f5277c, min);
                i -= min;
                e.f5277c += min;
            }
            this.f5243b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public long mo13519a(Source sVar) throws IOException {
        if (sVar != null) {
            long j = 0;
            while (true) {
                long a = sVar.mo13511a(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (a == -1) {
                    return j;
                }
                j += a;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: b */
    public Buffer mo13559i(int i) {
        Segment e = mo13544e(1);
        byte[] bArr = e.f5275a;
        int i2 = e.f5277c;
        e.f5277c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f5243b++;
        return this;
    }

    /* renamed from: c */
    public Buffer mo13555h(int i) {
        Segment e = mo13544e(2);
        byte[] bArr = e.f5275a;
        int i2 = e.f5277c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f5277c = i4;
        this.f5243b += 2;
        return this;
    }

    /* renamed from: d */
    public Buffer mo13552g(int i) {
        Segment e = mo13544e(4);
        byte[] bArr = e.f5275a;
        int i2 = e.f5277c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i & 255);
        e.f5277c = i6;
        this.f5243b += 4;
        return this;
    }

    /* renamed from: i */
    public Buffer mo13567l(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return mo13559i(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return mo13534b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment e = mo13544e(i2);
        byte[] bArr = e.f5275a;
        int i3 = e.f5277c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = f5241c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        e.f5277c += i2;
        this.f5243b += (long) i2;
        return this;
    }

    /* renamed from: j */
    public Buffer mo13564k(long j) {
        if (j == 0) {
            return mo13559i(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment e = mo13544e(numberOfTrailingZeros);
        byte[] bArr = e.f5275a;
        int i = e.f5277c;
        for (int i2 = (e.f5277c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f5241c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f5277c += numberOfTrailingZeros;
        this.f5243b += (long) numberOfTrailingZeros;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public Segment mo13544e(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        Segment oVar = this.f5242a;
        if (oVar == null) {
            this.f5242a = SegmentPool.m6800a();
            Segment oVar2 = this.f5242a;
            oVar2.f5281g = oVar2;
            oVar2.f5280f = oVar2;
            return oVar2;
        }
        Segment oVar3 = oVar.f5281g;
        if (oVar3.f5277c + i > 8192 || !oVar3.f5279e) {
            oVar3 = oVar3.mo13635a(SegmentPool.m6800a());
        }
        return oVar3;
    }

    /* renamed from: a_ */
    public void mo13507a_(Buffer cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            C1868u.m6834a(cVar.f5243b, 0, j);
            while (j > 0) {
                if (j < ((long) (cVar.f5242a.f5277c - cVar.f5242a.f5276b))) {
                    Segment oVar = this.f5242a;
                    Segment oVar2 = oVar != null ? oVar.f5281g : null;
                    if (oVar2 != null && oVar2.f5279e) {
                        if ((((long) oVar2.f5277c) + j) - ((long) (oVar2.f5278d ? 0 : oVar2.f5276b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            cVar.f5242a.mo13636a(oVar2, (int) j);
                            cVar.f5243b -= j;
                            this.f5243b += j;
                            return;
                        }
                    }
                    cVar.f5242a = cVar.f5242a.mo13634a((int) j);
                }
                Segment oVar3 = cVar.f5242a;
                long j2 = (long) (oVar3.f5277c - oVar3.f5276b);
                cVar.f5242a = oVar3.mo13637b();
                Segment oVar4 = this.f5242a;
                if (oVar4 == null) {
                    this.f5242a = oVar3;
                    Segment oVar5 = this.f5242a;
                    oVar5.f5281g = oVar5;
                    oVar5.f5280f = oVar5;
                } else {
                    oVar4.f5281g.mo13635a(oVar3).mo13638c();
                }
                cVar.f5243b -= j2;
                this.f5243b += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    /* renamed from: a */
    public long mo13511a(Buffer cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f5243b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.mo13507a_(this, j);
            return j;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public long mo13517a(byte b) {
        return mo13518a(b, 0, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long mo13518a(byte b, long j, long j2) {
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f5243b), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j4 = this.f5243b;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4) {
            return -1;
        }
        Segment oVar = this.f5242a;
        if (oVar == null) {
            return -1;
        }
        long j5 = this.f5243b;
        if (j5 - j >= j) {
            while (true) {
                j5 = j3;
                j3 = ((long) (oVar.f5277c - oVar.f5276b)) + j5;
                if (j3 >= j) {
                    break;
                }
                oVar = oVar.f5280f;
            }
        } else {
            while (j5 > j) {
                oVar = oVar.f5281g;
                j5 -= (long) (oVar.f5277c - oVar.f5276b);
            }
        }
        long j6 = j;
        while (j5 < j4) {
            byte[] bArr = oVar.f5275a;
            int min = (int) Math.min((long) oVar.f5277c, (((long) oVar.f5276b) + j4) - j5);
            for (int i = (int) ((((long) oVar.f5276b) + j6) - j5); i < min; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - oVar.f5276b)) + j5;
                }
            }
            byte b2 = b;
            j6 = ((long) (oVar.f5277c - oVar.f5276b)) + j5;
            oVar = oVar.f5280f;
            j5 = j6;
        }
        return -1;
    }

    /* renamed from: a */
    public Timeout mo13506a() {
        return Timeout.f5286c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer cVar = (Buffer) obj;
        long j = this.f5243b;
        if (j != cVar.f5243b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        Segment oVar = this.f5242a;
        Segment oVar2 = cVar.f5242a;
        int i = oVar.f5276b;
        int i2 = oVar2.f5276b;
        while (j2 < this.f5243b) {
            long min = (long) Math.min(oVar.f5277c - i, oVar2.f5277c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (oVar.f5275a[i4] != oVar2.f5275a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == oVar.f5277c) {
                oVar = oVar.f5280f;
                i = oVar.f5276b;
            } else {
                i = i4;
            }
            if (i3 == oVar2.f5277c) {
                oVar2 = oVar2.f5280f;
                i2 = oVar2.f5276b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public int hashCode() {
        Segment oVar = this.f5242a;
        if (oVar == null) {
            return 0;
        }
        int i = 1;
        do {
            for (int i2 = oVar.f5276b; i2 < oVar.f5277c; i2++) {
                i = (i * 31) + oVar.f5275a[i2];
            }
            oVar = oVar.f5280f;
        } while (oVar != this.f5242a);
        return i;
    }

    public String toString() {
        return mo13576t().toString();
    }

    /* renamed from: s */
    public Buffer clone() {
        Buffer cVar = new Buffer();
        if (this.f5243b == 0) {
            return cVar;
        }
        cVar.f5242a = this.f5242a.mo13633a();
        Segment oVar = cVar.f5242a;
        oVar.f5281g = oVar;
        oVar.f5280f = oVar;
        Segment oVar2 = this.f5242a;
        while (true) {
            oVar2 = oVar2.f5280f;
            if (oVar2 != this.f5242a) {
                cVar.f5242a.f5281g.mo13635a(oVar2.mo13633a());
            } else {
                cVar.f5243b = this.f5243b;
                return cVar;
            }
        }
    }

    /* renamed from: t */
    public final ByteString mo13576t() {
        long j = this.f5243b;
        if (j <= 2147483647L) {
            return mo13548f((int) j);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size > Integer.MAX_VALUE: ");
        sb.append(this.f5243b);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: f */
    public final ByteString mo13548f(int i) {
        if (i == 0) {
            return ByteString.f5246b;
        }
        return new SegmentedByteString(this, i);
    }
}
