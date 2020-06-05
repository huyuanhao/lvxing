package org.apache.thrift.protocol;

import com.p522qq.taf.jce.JceStruct;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.thrift.ShortStack;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

public class TCompactProtocol extends TProtocol {
    /* renamed from: a */
    private static final byte[] f29074a = new byte[0];
    /* renamed from: b */
    private static final ByteBuffer f29075b = ByteBuffer.wrap(f29074a);
    /* renamed from: d */
    private static final TStruct f29076d;
    /* renamed from: e */
    private static final TField f29077e;
    /* renamed from: f */
    private static final byte[] f29078f = new byte[16];
    /* renamed from: g */
    private ShortStack f29079g;
    /* renamed from: h */
    private short f29080h;
    /* renamed from: i */
    private TField f29081i;
    /* renamed from: j */
    private Boolean f29082j;
    /* renamed from: k */
    private final long f29083k;
    /* renamed from: l */
    private final long f29084l;
    /* renamed from: m */
    private final byte[] f29085m;

    /* renamed from: org.apache.thrift.protocol.TCompactProtocol$Factory */
    public static class Factory implements TProtocolFactory {
        private final long containerLengthLimit_;
        private final long stringLengthLimit_;

        public Factory() {
            this(-1, -1);
        }

        public Factory(long j) {
            this(j, -1);
        }

        public Factory(long j, long j2) {
            this.containerLengthLimit_ = j2;
            this.stringLengthLimit_ = j;
        }

        public TProtocol getProtocol(TTransport fVar) {
            TCompactProtocol tCompactProtocol = new TCompactProtocol(fVar, this.stringLengthLimit_, this.containerLengthLimit_);
            return tCompactProtocol;
        }
    }

    /* renamed from: a */
    private long m37029a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* renamed from: c */
    private int m37035c(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: c */
    private boolean m37036c(byte b) {
        byte b2 = b & 15;
        return b2 == 1 || b2 == 2;
    }

    /* renamed from: h */
    private int m37043h(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    /* renamed from: a */
    public void mo40890a() throws TException {
    }

    /* renamed from: c */
    public void mo40901c() throws TException {
    }

    /* renamed from: e */
    public void mo40903e() throws TException {
    }

    /* renamed from: g */
    public void mo40905g() throws TException {
    }

    /* renamed from: k */
    public void mo40909k() throws TException {
    }

    /* renamed from: m */
    public void mo40911m() throws TException {
    }

    /* renamed from: o */
    public void mo40913o() throws TException {
    }

    /* renamed from: q */
    public void mo40915q() throws TException {
    }

    static {
        String str = "";
        f29076d = new TStruct(str);
        f29077e = new TField(str, 0, 0);
        byte[] bArr = f29078f;
        bArr[0] = 0;
        bArr[2] = 1;
        bArr[3] = 3;
        bArr[6] = 4;
        bArr[8] = 5;
        bArr[10] = 6;
        bArr[4] = 7;
        bArr[11] = 8;
        bArr[15] = 9;
        bArr[14] = 10;
        bArr[13] = JceStruct.STRUCT_END;
        bArr[12] = JceStruct.ZERO_TAG;
    }

    public TCompactProtocol(TTransport fVar, long j, long j2) {
        super(fVar);
        this.f29079g = new ShortStack(15);
        this.f29080h = 0;
        this.f29081i = null;
        this.f29082j = null;
        this.f29085m = new byte[10];
        this.f29083k = j;
        this.f29084l = j2;
    }

    public TCompactProtocol(TTransport fVar) {
        this(fVar, -1, -1);
    }

    /* renamed from: a */
    public void mo40896a(TMessage eVar) throws TException {
        m37033b(-126);
        m37038d(((eVar.f29155b << 5) & -32) | 1);
        mo40944b(eVar.f29156c);
        mo40893a(eVar.f29154a);
    }

    /* renamed from: a */
    public void mo40897a(TStruct iVar) throws TException {
        this.f29079g.mo40874a(this.f29080h);
        this.f29080h = 0;
    }

    /* renamed from: b */
    public void mo40900b() throws TException {
        this.f29080h = this.f29079g.mo40873a();
    }

    /* renamed from: a */
    public void mo40894a(TField bVar) throws TException {
        if (bVar.f29147b == 2) {
            this.f29081i = bVar;
        } else {
            m37031a(bVar, -1);
        }
    }

    /* renamed from: a */
    private void m37031a(TField bVar, byte b) throws TException {
        if (b == -1) {
            b = m37039e(bVar.f29147b);
        }
        if (bVar.f29148c <= this.f29080h || bVar.f29148c - this.f29080h > 15) {
            m37033b(b);
            mo40898a(bVar.f29148c);
        } else {
            m37038d((int) b | ((bVar.f29148c - this.f29080h) << 4));
        }
        this.f29080h = bVar.f29148c;
    }

    /* renamed from: d */
    public void mo40902d() throws TException {
        m37033b(0);
    }

    /* renamed from: a */
    public void mo40895a(TList cVar) throws TException {
        mo40926a(cVar.f29149a, cVar.f29150b);
    }

    /* renamed from: a */
    public void mo40925a(byte b) throws TException {
        m37033b(b);
    }

    /* renamed from: a */
    public void mo40898a(short s) throws TException {
        mo40944b(m37035c((int) s));
    }

    /* renamed from: a */
    public void mo40892a(int i) throws TException {
        mo40944b(m37035c(i));
    }

    /* renamed from: a */
    public void mo40893a(String str) throws TException {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            m37032a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new TException("UTF-8 not supported!");
        }
    }

    /* renamed from: a */
    private void m37032a(byte[] bArr, int i, int i2) throws TException {
        mo40944b(i2);
        this.f29157c.mo40956c(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo40926a(byte b, int i) throws TException {
        if (i <= 14) {
            m37038d((int) m37039e(b) | (i << 4));
            return;
        }
        m37038d((int) m37039e(b) | -16);
        mo40944b(i);
    }

    /* renamed from: b */
    private void mo40944b(int i) throws TException {
        int i2 = 0;
        while ((i & -128) != 0) {
            int i3 = i2 + 1;
            this.f29085m[i2] = (byte) ((i & 127) | 128);
            i >>>= 7;
            i2 = i3;
        }
        int i4 = i2 + 1;
        this.f29085m[i2] = (byte) i;
        this.f29157c.mo40956c(this.f29085m, 0, i4);
    }

    /* renamed from: b */
    private void m37033b(byte b) throws TException {
        this.f29085m[0] = b;
        this.f29157c.mo40956c(this.f29085m, 0, 1);
    }

    /* renamed from: d */
    private void m37038d(int i) throws TException {
        m37033b((byte) i);
    }

    /* renamed from: f */
    public TMessage mo40904f() throws TException {
        byte s = mo40917s();
        if (s == -126) {
            byte s2 = mo40917s();
            byte b = (byte) (s2 & 31);
            if (b == 1) {
                return new TMessage(mo40922x(), (byte) ((s2 >> 5) & 7), m37044z());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected version 1 but got ");
            sb.append(b);
            throw new TProtocolException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected protocol id ");
        sb2.append(Integer.toHexString(-126));
        sb2.append(" but got ");
        sb2.append(Integer.toHexString(s));
        throw new TProtocolException(sb2.toString());
    }

    /* renamed from: h */
    public TStruct mo40906h() throws TException {
        this.f29079g.mo40874a(this.f29080h);
        this.f29080h = 0;
        return f29076d;
    }

    /* renamed from: i */
    public void mo40907i() throws TException {
        this.f29080h = this.f29079g.mo40873a();
    }

    /* renamed from: j */
    public TField mo40908j() throws TException {
        short s;
        byte s2 = mo40917s();
        if (s2 == 0) {
            return f29077e;
        }
        short s3 = (short) ((s2 & -16) >> 4);
        if (s3 == 0) {
            s = mo40918t();
        } else {
            s = (short) (this.f29080h + s3);
        }
        byte b = (byte) (s2 & 15);
        TField bVar = new TField("", m37037d(b), s);
        if (m37036c(s2)) {
            this.f29082j = b == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f29080h = bVar.f29148c;
        return bVar;
    }

    /* renamed from: l */
    public TMap mo40910l() throws TException {
        byte b;
        int z = m37044z();
        m37042g(z);
        if (z == 0) {
            b = 0;
        } else {
            b = mo40917s();
        }
        return new TMap(m37037d((byte) (b >> 4)), m37037d((byte) (b & 15)), z);
    }

    /* renamed from: n */
    public TList mo40912n() throws TException {
        byte s = mo40917s();
        int i = (s >> 4) & 15;
        if (i == 15) {
            i = m37044z();
        }
        m37042g(i);
        return new TList(m37037d(s), i);
    }

    /* renamed from: p */
    public TSet mo40914p() throws TException {
        return new TSet(mo40912n());
    }

    /* renamed from: r */
    public boolean mo40916r() throws TException {
        Boolean bool = this.f29082j;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            this.f29082j = null;
            return booleanValue;
        }
        boolean z = true;
        if (mo40917s() != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: s */
    public byte mo40917s() throws TException {
        if (this.f29157c.mo40977e() > 0) {
            byte b = this.f29157c.mo40975c()[this.f29157c.mo40976d()];
            this.f29157c.mo40974a(1);
            return b;
        }
        this.f29157c.mo40952a(this.f29085m, 0, 1);
        return this.f29085m[0];
    }

    /* renamed from: t */
    public short mo40918t() throws TException {
        return (short) m37043h(m37044z());
    }

    /* renamed from: u */
    public int mo40919u() throws TException {
        return m37043h(m37044z());
    }

    /* renamed from: v */
    public long mo40920v() throws TException {
        return m37029a(m37028A());
    }

    /* renamed from: w */
    public double mo40921w() throws TException {
        this.f29157c.mo40952a(this.f29085m, 0, 8);
        return Double.longBitsToDouble(m37030a(this.f29085m));
    }

    /* renamed from: x */
    public String mo40922x() throws TException {
        int z = m37044z();
        m37041f(z);
        if (z == 0) {
            return "";
        }
        try {
            String str = "UTF-8";
            if (this.f29157c.mo40977e() < z) {
                return new String(m37040e(z), str);
            }
            String str2 = new String(this.f29157c.mo40975c(), this.f29157c.mo40976d(), z, str);
            this.f29157c.mo40974a(z);
            return str2;
        } catch (UnsupportedEncodingException unused) {
            throw new TException("UTF-8 not supported!");
        }
    }

    /* renamed from: y */
    public ByteBuffer mo40923y() throws TException {
        int z = m37044z();
        m37041f(z);
        if (z == 0) {
            return f29075b;
        }
        if (this.f29157c.mo40977e() >= z) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f29157c.mo40975c(), this.f29157c.mo40976d(), z);
            this.f29157c.mo40974a(z);
            return wrap;
        }
        byte[] bArr = new byte[z];
        this.f29157c.mo40952a(bArr, 0, z);
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: e */
    private byte[] m37040e(int i) throws TException {
        if (i == 0) {
            return f29074a;
        }
        byte[] bArr = new byte[i];
        this.f29157c.mo40952a(bArr, 0, i);
        return bArr;
    }

    /* renamed from: f */
    private void m37041f(int i) throws TProtocolException {
        if (i >= 0) {
            long j = this.f29083k;
            if (j != -1 && ((long) i) > j) {
                StringBuilder sb = new StringBuilder();
                sb.append("Length exceeded max allowed: ");
                sb.append(i);
                throw new TProtocolException(3, sb.toString());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Negative length: ");
        sb2.append(i);
        throw new TProtocolException(2, sb2.toString());
    }

    /* renamed from: g */
    private void m37042g(int i) throws TProtocolException {
        if (i >= 0) {
            long j = this.f29084l;
            if (j != -1 && ((long) i) > j) {
                StringBuilder sb = new StringBuilder();
                sb.append("Length exceeded max allowed: ");
                sb.append(i);
                throw new TProtocolException(3, sb.toString());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Negative length: ");
        sb2.append(i);
        throw new TProtocolException(2, sb2.toString());
    }

    /* renamed from: z */
    private int m37044z() throws TException {
        int i = 0;
        if (this.f29157c.mo40977e() >= 5) {
            byte[] c = this.f29157c.mo40975c();
            int d = this.f29157c.mo40976d();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte b = c[d + i];
                i2 |= (b & Byte.MAX_VALUE) << i3;
                if ((b & Byte.MIN_VALUE) != Byte.MIN_VALUE) {
                    this.f29157c.mo40974a(i + 1);
                    return i2;
                }
                i3 += 7;
                i++;
            }
        } else {
            int i4 = 0;
            while (true) {
                byte s = mo40917s();
                i |= (s & Byte.MAX_VALUE) << i4;
                if ((s & Byte.MIN_VALUE) != Byte.MIN_VALUE) {
                    return i;
                }
                i4 += 7;
            }
        }
    }

    /* renamed from: A */
    private long m37028A() throws TException {
        long j;
        int i = 0;
        long j2 = 0;
        if (this.f29157c.mo40977e() >= 10) {
            byte[] c = this.f29157c.mo40975c();
            int d = this.f29157c.mo40976d();
            int i2 = 0;
            while (true) {
                byte b = c[d + i];
                j2 |= ((long) (b & Byte.MAX_VALUE)) << i2;
                if ((b & Byte.MIN_VALUE) != Byte.MIN_VALUE) {
                    break;
                }
                i2 += 7;
                i++;
            }
            this.f29157c.mo40974a(i + 1);
        } else {
            while (true) {
                byte s = mo40917s();
                j2 |= ((long) (s & Byte.MAX_VALUE)) << i;
                if ((s & Byte.MIN_VALUE) != Byte.MIN_VALUE) {
                    break;
                }
                i += 7;
            }
        }
        return j;
    }

    /* renamed from: a */
    private long m37030a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (255 & ((long) bArr[0]));
    }

    /* renamed from: d */
    private byte m37037d(byte b) throws TProtocolException {
        byte b2 = (byte) (b & 15);
        switch (b2) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 6;
            case 5:
                return 8;
            case 6:
                return 10;
            case 7:
                return 4;
            case 8:
                return JceStruct.STRUCT_END;
            case 9:
                return 15;
            case 10:
                return 14;
            case 11:
                return JceStruct.SIMPLE_LIST;
            case 12:
                return JceStruct.ZERO_TAG;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("don't know what type: ");
                sb.append(b2);
                throw new TProtocolException(sb.toString());
        }
    }

    /* renamed from: e */
    private byte m37039e(byte b) {
        return f29078f[b];
    }
}
