package okio;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;

/* compiled from: Buffer */
/* renamed from: okio.c */
public final class C8525c implements Cloneable, ByteChannel, C8528d, C8529e {
    /* renamed from: c */
    private static final byte[] f29016c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable
    /* renamed from: a */
    C8543n f29017a;
    /* renamed from: b */
    long f29018b;

    /* renamed from: c */
    public C8525c mo40741c() {
        return this;
    }

    public void close() {
    }

    /* renamed from: e */
    public C8525c mo40787x() {
        return this;
    }

    public void flush() {
    }

    public boolean isOpen() {
        return true;
    }

    /* renamed from: b */
    public long mo40734b() {
        return this.f29018b;
    }

    /* renamed from: d */
    public OutputStream mo40746d() {
        return new OutputStream() {
            public void close() {
            }

            public void flush() {
            }

            public void write(int i) {
                C8525c.this.mo40765i((int) (byte) i);
            }

            public void write(byte[] bArr, int i, int i2) {
                C8525c.this.mo40744c(bArr, i, i2);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(C8525c.this);
                sb.append(".outputStream()");
                return sb.toString();
            }
        };
    }

    /* renamed from: f */
    public boolean mo40755f() {
        return this.f29018b == 0;
    }

    /* renamed from: a */
    public void mo40729a(long j) throws EOFException {
        if (this.f29018b < j) {
            throw new EOFException();
        }
    }

    /* renamed from: g */
    public InputStream mo40756g() {
        return new InputStream() {
            public void close() {
            }

            public int read() {
                if (C8525c.this.f29018b > 0) {
                    return C8525c.this.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                }
                return -1;
            }

            public int read(byte[] bArr, int i, int i2) {
                return C8525c.this.mo40715a(bArr, i, i2);
            }

            public int available() {
                return (int) Math.min(C8525c.this.f29018b, 2147483647L);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(C8525c.this);
                sb.append(".inputStream()");
                return sb.toString();
            }
        };
    }

    /* renamed from: a */
    public C8525c mo40728a(C8525c cVar, long j, long j2) {
        if (cVar != null) {
            C8550t.m36938a(this.f29018b, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f29018b += j2;
            C8543n nVar = this.f29017a;
            while (j >= ((long) (nVar.f29048c - nVar.f29047b))) {
                j -= (long) (nVar.f29048c - nVar.f29047b);
                nVar = nVar.f29051f;
            }
            while (j2 > 0) {
                C8543n a = nVar.mo40828a();
                a.f29047b = (int) (((long) a.f29047b) + j);
                a.f29048c = Math.min(a.f29047b + ((int) j2), a.f29048c);
                C8543n nVar2 = cVar.f29017a;
                if (nVar2 == null) {
                    a.f29052g = a;
                    a.f29051f = a;
                    cVar.f29017a = a;
                } else {
                    nVar2.f29052g.mo40830a(a);
                }
                j2 -= (long) (a.f29048c - a.f29047b);
                nVar = nVar.f29051f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: h */
    public long mo40759h() {
        long j = this.f29018b;
        if (j == 0) {
            return 0;
        }
        C8543n nVar = this.f29017a.f29052g;
        if (nVar.f29048c < 8192 && nVar.f29050e) {
            j -= (long) (nVar.f29048c - nVar.f29047b);
        }
        return j;
    }

    /* renamed from: i */
    public byte mo40763i() {
        if (this.f29018b != 0) {
            C8543n nVar = this.f29017a;
            int i = nVar.f29047b;
            int i2 = nVar.f29048c;
            int i3 = i + 1;
            byte b = nVar.f29046a[i];
            this.f29018b--;
            if (i3 == i2) {
                this.f29017a = nVar.mo40832b();
                C8544o.m36918a(nVar);
            } else {
                nVar.f29047b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    /* renamed from: b */
    public byte mo40733b(long j) {
        C8550t.m36938a(this.f29018b, j, 1);
        long j2 = this.f29018b;
        if (j2 - j > j) {
            C8543n nVar = this.f29017a;
            while (true) {
                long j3 = (long) (nVar.f29048c - nVar.f29047b);
                if (j < j3) {
                    return nVar.f29046a[nVar.f29047b + ((int) j)];
                }
                j -= j3;
                nVar = nVar.f29051f;
            }
        } else {
            long j4 = j - j2;
            C8543n nVar2 = this.f29017a;
            do {
                nVar2 = nVar2.f29052g;
                j4 += (long) (nVar2.f29048c - nVar2.f29047b);
            } while (j4 < 0);
            return nVar2.f29046a[nVar2.f29047b + ((int) j4)];
        }
    }

    /* renamed from: j */
    public short mo40768j() {
        if (this.f29018b >= 2) {
            C8543n nVar = this.f29017a;
            int i = nVar.f29047b;
            int i2 = nVar.f29048c;
            if (i2 - i < 2) {
                return (short) (((mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
            }
            byte[] bArr = nVar.f29046a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            this.f29018b -= 2;
            if (i4 == i2) {
                this.f29017a = nVar.mo40832b();
                C8544o.m36918a(nVar);
            } else {
                nVar.f29047b = i4;
            }
            return (short) b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 2: ");
        sb.append(this.f29018b);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: k */
    public int mo40769k() {
        if (this.f29018b >= 4) {
            C8543n nVar = this.f29017a;
            int i = nVar.f29047b;
            int i2 = nVar.f29048c;
            if (i2 - i < 4) {
                return ((mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | ((mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            }
            byte[] bArr = nVar.f29046a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | ((bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            this.f29018b -= 4;
            if (i6 == i2) {
                this.f29017a = nVar.mo40832b();
                C8544o.m36918a(nVar);
            } else {
                nVar.f29047b = i6;
            }
            return b3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 4: ");
        sb.append(this.f29018b);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: l */
    public short mo40772l() {
        return C8550t.m36937a(mo40768j());
    }

    /* renamed from: m */
    public int mo40773m() {
        return C8550t.m36936a(mo40769k());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
            if (r5 != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
            r1.mo40763i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
            r3 = new java.lang.StringBuilder();
            r3.append("Number too large: ");
            r3.append(r1.mo40777q());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
            throw new java.lang.NumberFormatException(r3.toString());
     */
    /* renamed from: n */
    public long mo40774n() {
        /*
        r17 = this;
        r0 = r17
        long r1 = r0.f29018b
        r3 = 0
        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r5 == 0) goto L_0x00b7
        r5 = -7
        r7 = 0
        r8 = r5
        r5 = 0
        r6 = 0
    L_0x0010:
        okio.n r10 = r0.f29017a
        byte[] r11 = r10.f29046a
        int r12 = r10.f29047b
        int r13 = r10.f29048c
    L_0x0018:
        if (r12 >= r13) goto L_0x0098
        byte r15 = r11[r12]
        r14 = 48
        if (r15 < r14) goto L_0x006a
        r1 = 57
        if (r15 > r1) goto L_0x006a
        int r14 = r14 - r15
        r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
        int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
        if (r16 < 0) goto L_0x003d
        if (r16 != 0) goto L_0x0036
        long r1 = (long) r14
        int r16 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
        if (r16 >= 0) goto L_0x0036
        goto L_0x003d
    L_0x0036:
        r1 = 10
        long r3 = r3 * r1
        long r1 = (long) r14
        long r3 = r3 + r1
        goto L_0x0074
    L_0x003d:
        okio.c r1 = new okio.c
        r1.m55563init()
        okio.c r1 = r1.mo40771l(r3)
        okio.c r1 = r1.mo40765i(r15)
        if (r5 != 0) goto L_0x004f
        r1.mo40763i()
    L_0x004f:
        java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "Number too large: "
        r3.append(r4)
        java.lang.String r1 = r1.mo40777q()
        r3.append(r1)
        java.lang.String r1 = r3.toString()
        r2.<init>(r1)
        throw r2
    L_0x006a:
        r1 = 45
        if (r15 != r1) goto L_0x0079
        if (r7 != 0) goto L_0x0079
        r1 = 1
        long r8 = r8 - r1
        r5 = 1
    L_0x0074:
        int r12 = r12 + 1
        int r7 = r7 + 1
        goto L_0x0018
    L_0x0079:
        if (r7 == 0) goto L_0x007d
        r6 = 1
        goto L_0x0098
    L_0x007d:
        java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
        r2.append(r3)
        java.lang.String r3 = java.lang.Integer.toHexString(r15)
        r2.append(r3)
        java.lang.String r2 = r2.toString()
        r1.<init>(r2)
        throw r1
    L_0x0098:
        if (r12 != r13) goto L_0x00a4
        okio.n r1 = r10.mo40832b()
        r0.f29017a = r1
        okio.C8544o.m36918a(r10)
        goto L_0x00a6
    L_0x00a4:
        r10.f29047b = r12
    L_0x00a6:
        if (r6 != 0) goto L_0x00ac
        okio.n r1 = r0.f29017a
        if (r1 != 0) goto L_0x0010
    L_0x00ac:
        long r1 = r0.f29018b
        long r6 = (long) r7
        long r1 = r1 - r6
        r0.f29018b = r1
        if (r5 == 0) goto L_0x00b5
        goto L_0x00b6
    L_0x00b5:
        long r3 = -r3
    L_0x00b6:
        return r3
    L_0x00b7:
        java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
        java.lang.String r2 = "size == 0"
        r1.<init>(r2)
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.C8525c.mo40774n():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
            if (r8 != r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
            r15.f29017a = r6.mo40832b();
            okio.C8544o.m36918a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
            r6.f29047b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009f, code lost:
            if (r0 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    /* renamed from: o */
    public long mo40775o() {
        /*
        r15 = this;
        long r0 = r15.f29018b
        r2 = 0
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 == 0) goto L_0x00ac
        r0 = 0
        r4 = r2
        r1 = 0
    L_0x000b:
        okio.n r6 = r15.f29017a
        byte[] r7 = r6.f29046a
        int r8 = r6.f29047b
        int r9 = r6.f29048c
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
        okio.c r0 = new okio.c
        r0.m55563init()
        okio.c r0 = r0.mo40770k(r4)
        okio.c r0 = r0.mo40765i(r10)
        java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "Number too large: "
        r2.append(r3)
        java.lang.String r0 = r0.mo40777q()
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
        okio.n r7 = r6.mo40832b()
        r15.f29017a = r7
        okio.C8544o.m36918a(r6)
        goto L_0x009f
    L_0x009d:
        r6.f29047b = r8
    L_0x009f:
        if (r0 != 0) goto L_0x00a5
        okio.n r6 = r15.f29017a
        if (r6 != 0) goto L_0x000b
    L_0x00a5:
        long r2 = r15.f29018b
        long r0 = (long) r1
        long r2 = r2 - r0
        r15.f29018b = r2
        return r4
    L_0x00ac:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
        java.lang.String r1 = "size == 0"
        r0.<init>(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.C8525c.mo40775o():long");
    }

    /* renamed from: p */
    public ByteString mo40776p() {
        return new ByteString(mo40780s());
    }

    /* renamed from: c */
    public ByteString mo40740c(long j) throws EOFException {
        return new ByteString(mo40758g(j));
    }

    /* renamed from: a */
    public long mo40718a(C8546q qVar) throws IOException {
        long j = this.f29018b;
        if (j > 0) {
            qVar.mo40231a_(this, j);
        }
        return j;
    }

    /* renamed from: q */
    public String mo40777q() {
        try {
            return mo40720a(this.f29018b, C8550t.f29059a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: d */
    public String mo40747d(long j) throws EOFException {
        return mo40720a(j, C8550t.f29059a);
    }

    /* renamed from: a */
    public String mo40721a(Charset charset) {
        try {
            return mo40720a(this.f29018b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public String mo40720a(long j, Charset charset) throws EOFException {
        C8550t.m36938a(this.f29018b, 0, j);
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
            C8543n nVar = this.f29017a;
            if (((long) nVar.f29047b) + j > ((long) nVar.f29048c)) {
                return new String(mo40758g(j), charset);
            }
            String str = new String(nVar.f29046a, nVar.f29047b, (int) j, charset);
            nVar.f29047b = (int) (((long) nVar.f29047b) + j);
            this.f29018b -= j;
            if (nVar.f29047b == nVar.f29048c) {
                this.f29017a = nVar.mo40832b();
                C8544o.m36918a(nVar);
            }
            return str;
        }
    }

    /* renamed from: r */
    public String mo40778r() throws EOFException {
        return mo40749e(Long.MAX_VALUE);
    }

    /* renamed from: e */
    public String mo40749e(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long a = mo40717a(10, 0, j2);
            if (a != -1) {
                return mo40753f(a);
            }
            if (j2 < mo40734b() && mo40733b(j2 - 1) == 13 && mo40733b(j2) == 10) {
                return mo40753f(j2);
            }
            C8525c cVar = new C8525c();
            mo40728a(cVar, 0, Math.min(32, mo40734b()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(mo40734b(), j));
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

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo40753f(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (mo40733b(j2) == 13) {
                String d = mo40747d(j2);
                mo40761h(2);
                return d;
            }
        }
        String d2 = mo40747d(j);
        mo40761h(1);
        return d2;
    }

    /* renamed from: s */
    public byte[] mo40780s() {
        try {
            return mo40758g(this.f29018b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: g */
    public byte[] mo40758g(long j) throws EOFException {
        C8550t.m36938a(this.f29018b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            mo40730a(bArr);
            return bArr;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("byteCount > Integer.MAX_VALUE: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public void mo40730a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a = mo40715a(bArr, i, bArr.length - i);
            if (a != -1) {
                i += a;
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public int mo40715a(byte[] bArr, int i, int i2) {
        C8550t.m36938a((long) bArr.length, (long) i, (long) i2);
        C8543n nVar = this.f29017a;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(i2, nVar.f29048c - nVar.f29047b);
        System.arraycopy(nVar.f29046a, nVar.f29047b, bArr, i, min);
        nVar.f29047b += min;
        this.f29018b -= (long) min;
        if (nVar.f29047b == nVar.f29048c) {
            this.f29017a = nVar.mo40832b();
            C8544o.m36918a(nVar);
        }
        return min;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        C8543n nVar = this.f29017a;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), nVar.f29048c - nVar.f29047b);
        byteBuffer.put(nVar.f29046a, nVar.f29047b, min);
        nVar.f29047b += min;
        this.f29018b -= (long) min;
        if (nVar.f29047b == nVar.f29048c) {
            this.f29017a = nVar.mo40832b();
            C8544o.m36918a(nVar);
        }
        return min;
    }

    /* renamed from: t */
    public void mo40781t() {
        try {
            mo40761h(this.f29018b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: h */
    public void mo40761h(long j) throws EOFException {
        while (j > 0) {
            C8543n nVar = this.f29017a;
            if (nVar != null) {
                int min = (int) Math.min(j, (long) (nVar.f29048c - this.f29017a.f29047b));
                long j2 = (long) min;
                this.f29018b -= j2;
                j -= j2;
                this.f29017a.f29047b += min;
                if (this.f29017a.f29047b == this.f29017a.f29048c) {
                    C8543n nVar2 = this.f29017a;
                    this.f29017a = nVar2.mo40832b();
                    C8544o.m36918a(nVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public C8525c mo40739b(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public C8525c mo40738b(String str) {
        return mo40724a(str, 0, str.length());
    }

    /* renamed from: a */
    public C8525c mo40724a(String str, int i, int i2) {
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
                    C8543n e = mo40751e(1);
                    byte[] bArr = e.f29046a;
                    int i3 = e.f29048c - i;
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
                    int i6 = (i3 + i4) - e.f29048c;
                    e.f29048c += i6;
                    this.f29018b += (long) i6;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        mo40765i((charAt >> 6) | 192);
                        mo40765i((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        mo40765i((charAt >> 12) | 224);
                        mo40765i(((charAt >> 6) & 63) | 128);
                        mo40765i((int) (charAt & '?') | 128);
                    } else {
                        int i7 = i + 1;
                        if (i7 < i2) {
                            c = str.charAt(i7);
                        } else {
                            c = 0;
                        }
                        if (charAt > 56319 || c < 56320 || c > 57343) {
                            mo40765i(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt & 10239) << 10) | (9215 & c)) + 0;
                            mo40765i((i8 >> 18) | ScreenUtil.G8_WIDTH);
                            mo40765i(((i8 >> 12) & 63) | 128);
                            mo40765i(((i8 >> 6) & 63) | 128);
                            mo40765i((i8 & 63) | 128);
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
    public C8525c mo40722a(int i) {
        if (i < 128) {
            mo40765i(i);
        } else if (i < 2048) {
            mo40765i((i >> 6) | 192);
            mo40765i((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                mo40765i((i >> 12) | 224);
                mo40765i(((i >> 6) & 63) | 128);
                mo40765i((i & 63) | 128);
            } else {
                mo40765i(63);
            }
        } else if (i <= 1114111) {
            mo40765i((i >> 18) | ScreenUtil.G8_WIDTH);
            mo40765i(((i >> 12) & 63) | 128);
            mo40765i(((i >> 6) & 63) | 128);
            mo40765i((i & 63) | 128);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected code point: ");
            sb.append(Integer.toHexString(i));
            throw new IllegalArgumentException(sb.toString());
        }
        return this;
    }

    /* renamed from: a */
    public C8525c mo40726a(String str, Charset charset) {
        return mo40725a(str, 0, str.length(), charset);
    }

    /* renamed from: a */
    public C8525c mo40725a(String str, int i, int i2, Charset charset) {
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
        } else if (charset.equals(C8550t.f29059a)) {
            return mo40724a(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return mo40744c(bytes, 0, bytes.length);
        }
    }

    /* renamed from: b */
    public C8525c mo40743c(byte[] bArr) {
        if (bArr != null) {
            return mo40744c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public C8525c mo40744c(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            C8550t.m36938a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                C8543n e = mo40751e(1);
                int min = Math.min(i3 - i, 8192 - e.f29048c);
                System.arraycopy(bArr, i, e.f29046a, e.f29048c, min);
                i += min;
                e.f29048c += min;
            }
            this.f29018b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                C8543n e = mo40751e(1);
                int min = Math.min(i, 8192 - e.f29048c);
                byteBuffer.get(e.f29046a, e.f29048c, min);
                i -= min;
                e.f29048c += min;
            }
            this.f29018b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public long mo40719a(C8547r rVar) throws IOException {
        if (rVar != null) {
            long j = 0;
            while (true) {
                long a = rVar.mo40202a(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
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
    public C8525c mo40765i(int i) {
        C8543n e = mo40751e(1);
        byte[] bArr = e.f29046a;
        int i2 = e.f29048c;
        e.f29048c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f29018b++;
        return this;
    }

    /* renamed from: c */
    public C8525c mo40760h(int i) {
        C8543n e = mo40751e(2);
        byte[] bArr = e.f29046a;
        int i2 = e.f29048c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f29048c = i4;
        this.f29018b += 2;
        return this;
    }

    /* renamed from: d */
    public C8525c mo40757g(int i) {
        C8543n e = mo40751e(4);
        byte[] bArr = e.f29046a;
        int i2 = e.f29048c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i & 255);
        e.f29048c = i6;
        this.f29018b += 4;
        return this;
    }

    /* renamed from: i */
    public C8525c mo40771l(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return mo40765i(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return mo40738b("-9223372036854775808");
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
        C8543n e = mo40751e(i2);
        byte[] bArr = e.f29046a;
        int i3 = e.f29048c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = f29016c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        e.f29048c += i2;
        this.f29018b += (long) i2;
        return this;
    }

    /* renamed from: j */
    public C8525c mo40770k(long j) {
        if (j == 0) {
            return mo40765i(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C8543n e = mo40751e(numberOfTrailingZeros);
        byte[] bArr = e.f29046a;
        int i = e.f29048c;
        for (int i2 = (e.f29048c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f29016c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f29048c += numberOfTrailingZeros;
        this.f29018b += (long) numberOfTrailingZeros;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C8543n mo40751e(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        C8543n nVar = this.f29017a;
        if (nVar == null) {
            this.f29017a = C8544o.m36917a();
            C8543n nVar2 = this.f29017a;
            nVar2.f29052g = nVar2;
            nVar2.f29051f = nVar2;
            return nVar2;
        }
        C8543n nVar3 = nVar.f29052g;
        if (nVar3.f29048c + i > 8192 || !nVar3.f29050e) {
            nVar3 = nVar3.mo40830a(C8544o.m36917a());
        }
        return nVar3;
    }

    /* renamed from: a_ */
    public void mo40231a_(C8525c cVar, long j) {
        int i;
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            C8550t.m36938a(cVar.f29018b, 0, j);
            while (j > 0) {
                if (j < ((long) (cVar.f29017a.f29048c - cVar.f29017a.f29047b))) {
                    C8543n nVar = this.f29017a;
                    C8543n nVar2 = nVar != null ? nVar.f29052g : null;
                    if (nVar2 != null && nVar2.f29050e) {
                        long j2 = ((long) nVar2.f29048c) + j;
                        if (nVar2.f29049d) {
                            i = 0;
                        } else {
                            i = nVar2.f29047b;
                        }
                        if (j2 - ((long) i) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            cVar.f29017a.mo40831a(nVar2, (int) j);
                            cVar.f29018b -= j;
                            this.f29018b += j;
                            return;
                        }
                    }
                    cVar.f29017a = cVar.f29017a.mo40829a((int) j);
                }
                C8543n nVar3 = cVar.f29017a;
                long j3 = (long) (nVar3.f29048c - nVar3.f29047b);
                cVar.f29017a = nVar3.mo40832b();
                C8543n nVar4 = this.f29017a;
                if (nVar4 == null) {
                    this.f29017a = nVar3;
                    C8543n nVar5 = this.f29017a;
                    nVar5.f29052g = nVar5;
                    nVar5.f29051f = nVar5;
                } else {
                    nVar4.f29052g.mo40830a(nVar3).mo40833c();
                }
                cVar.f29018b -= j3;
                this.f29018b += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    /* renamed from: a */
    public long mo40202a(C8525c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f29018b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.mo40231a_(this, j);
            return j;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public long mo40716a(byte b) {
        return mo40717a(b, 0, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long mo40717a(byte b, long j, long j2) {
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f29018b), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j4 = this.f29018b;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4) {
            return -1;
        }
        C8543n nVar = this.f29017a;
        if (nVar == null) {
            return -1;
        }
        long j5 = this.f29018b;
        if (j5 - j >= j) {
            while (true) {
                j5 = j3;
                j3 = ((long) (nVar.f29048c - nVar.f29047b)) + j5;
                if (j3 >= j) {
                    break;
                }
                nVar = nVar.f29051f;
            }
        } else {
            while (j5 > j) {
                nVar = nVar.f29052g;
                j5 -= (long) (nVar.f29048c - nVar.f29047b);
            }
        }
        long j6 = j;
        while (j5 < j4) {
            byte[] bArr = nVar.f29046a;
            int min = (int) Math.min((long) nVar.f29048c, (((long) nVar.f29047b) + j4) - j5);
            for (int i = (int) ((((long) nVar.f29047b) + j6) - j5); i < min; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - nVar.f29047b)) + j5;
                }
            }
            byte b2 = b;
            j6 = ((long) (nVar.f29048c - nVar.f29047b)) + j5;
            nVar = nVar.f29051f;
            j5 = j6;
        }
        return -1;
    }

    /* renamed from: a */
    public boolean mo40731a(long j, ByteString byteString) {
        return mo40732a(j, byteString, 0, byteString.size());
    }

    /* renamed from: a */
    public boolean mo40732a(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f29018b - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (mo40733b(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public C8548s mo40271a() {
        return C8548s.f29055c;
    }

    /* renamed from: u */
    public ByteString mo40783u() {
        return m36719c("MD5");
    }

    /* renamed from: c */
    private ByteString m36719c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            if (this.f29017a != null) {
                instance.update(this.f29017a.f29046a, this.f29017a.f29047b, this.f29017a.f29048c - this.f29017a.f29047b);
                C8543n nVar = this.f29017a;
                while (true) {
                    nVar = nVar.f29051f;
                    if (nVar == this.f29017a) {
                        break;
                    }
                    instance.update(nVar.f29046a, nVar.f29047b, nVar.f29048c - nVar.f29047b);
                }
            }
            return ByteString.m36697of(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8525c)) {
            return false;
        }
        C8525c cVar = (C8525c) obj;
        long j = this.f29018b;
        if (j != cVar.f29018b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        C8543n nVar = this.f29017a;
        C8543n nVar2 = cVar.f29017a;
        int i = nVar.f29047b;
        int i2 = nVar2.f29047b;
        while (j2 < this.f29018b) {
            long min = (long) Math.min(nVar.f29048c - i, nVar2.f29048c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (nVar.f29046a[i4] != nVar2.f29046a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == nVar.f29048c) {
                nVar = nVar.f29051f;
                i = nVar.f29047b;
            } else {
                i = i4;
            }
            if (i3 == nVar2.f29048c) {
                nVar2 = nVar2.f29051f;
                i2 = nVar2.f29047b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public int hashCode() {
        C8543n nVar = this.f29017a;
        if (nVar == null) {
            return 0;
        }
        int i = 1;
        do {
            for (int i2 = nVar.f29047b; i2 < nVar.f29048c; i2++) {
                i = (i * 31) + nVar.f29046a[i2];
            }
            nVar = nVar.f29051f;
        } while (nVar != this.f29017a);
        return i;
    }

    public String toString() {
        return mo40785w().toString();
    }

    /* renamed from: v */
    public C8525c clone() {
        C8525c cVar = new C8525c();
        if (this.f29018b == 0) {
            return cVar;
        }
        cVar.f29017a = this.f29017a.mo40828a();
        C8543n nVar = cVar.f29017a;
        nVar.f29052g = nVar;
        nVar.f29051f = nVar;
        C8543n nVar2 = this.f29017a;
        while (true) {
            nVar2 = nVar2.f29051f;
            if (nVar2 != this.f29017a) {
                cVar.f29017a.f29052g.mo40830a(nVar2.mo40828a());
            } else {
                cVar.f29018b = this.f29018b;
                return cVar;
            }
        }
    }

    /* renamed from: w */
    public ByteString mo40785w() {
        long j = this.f29018b;
        if (j <= 2147483647L) {
            return mo40754f((int) j);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size > Integer.MAX_VALUE: ");
        sb.append(this.f29018b);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: f */
    public ByteString mo40754f(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new C8545p(this, i);
    }
}
