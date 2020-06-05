package org.apache.thrift.protocol;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

public class TBinaryProtocol extends TProtocol {
    /* renamed from: d */
    private static final TStruct f29068d = new TStruct();
    /* renamed from: a */
    protected boolean f29069a;
    /* renamed from: b */
    protected boolean f29070b;
    /* renamed from: e */
    private final long f29071e;
    /* renamed from: f */
    private final long f29072f;
    /* renamed from: g */
    private final byte[] f29073g;

    /* renamed from: org.apache.thrift.protocol.TBinaryProtocol$Factory */
    public static class Factory implements TProtocolFactory {
        protected long containerLengthLimit_;
        protected boolean strictRead_;
        protected boolean strictWrite_;
        protected long stringLengthLimit_;

        public Factory() {
            this(false, true);
        }

        public Factory(boolean z, boolean z2) {
            this(z, z2, -1, -1);
        }

        public Factory(long j, long j2) {
            this(false, true, j, j2);
        }

        public Factory(boolean z, boolean z2, long j, long j2) {
            this.stringLengthLimit_ = j;
            this.containerLengthLimit_ = j2;
            this.strictRead_ = z;
            this.strictWrite_ = z2;
        }

        public TProtocol getProtocol(TTransport fVar) {
            TBinaryProtocol tBinaryProtocol = new TBinaryProtocol(fVar, this.stringLengthLimit_, this.containerLengthLimit_, this.strictRead_, this.strictWrite_);
            return tBinaryProtocol;
        }
    }

    /* renamed from: a */
    public void mo40890a() {
    }

    /* renamed from: a */
    public void mo40897a(TStruct iVar) {
    }

    /* renamed from: b */
    public void mo40900b() {
    }

    /* renamed from: c */
    public void mo40901c() {
    }

    /* renamed from: e */
    public void mo40903e() {
    }

    /* renamed from: g */
    public void mo40905g() {
    }

    /* renamed from: i */
    public void mo40907i() {
    }

    /* renamed from: k */
    public void mo40909k() {
    }

    /* renamed from: m */
    public void mo40911m() {
    }

    /* renamed from: o */
    public void mo40913o() {
    }

    /* renamed from: q */
    public void mo40915q() {
    }

    public TBinaryProtocol(TTransport fVar) {
        this(fVar, false, true);
    }

    public TBinaryProtocol(TTransport fVar, boolean z, boolean z2) {
        this(fVar, -1, -1, z, z2);
    }

    public TBinaryProtocol(TTransport fVar, long j, long j2, boolean z, boolean z2) {
        super(fVar);
        this.f29073g = new byte[8];
        this.f29071e = j;
        this.f29072f = j2;
        this.f29069a = z;
        this.f29070b = z2;
    }

    /* renamed from: a */
    public void mo40896a(TMessage eVar) throws TException {
        if (this.f29070b) {
            mo40892a((int) 0 | eVar.f29155b);
            mo40893a(eVar.f29154a);
            mo40892a(eVar.f29156c);
            return;
        }
        mo40893a(eVar.f29154a);
        mo40891a(eVar.f29155b);
        mo40892a(eVar.f29156c);
    }

    /* renamed from: a */
    public void mo40894a(TField bVar) throws TException {
        mo40891a(bVar.f29147b);
        mo40898a(bVar.f29148c);
    }

    /* renamed from: d */
    public void mo40902d() throws TException {
        mo40891a(0);
    }

    /* renamed from: a */
    public void mo40895a(TList cVar) throws TException {
        mo40891a(cVar.f29149a);
        mo40892a(cVar.f29150b);
    }

    /* renamed from: a */
    public void mo40891a(byte b) throws TException {
        this.f29073g[0] = b;
        this.f29157c.mo40956c(this.f29073g, 0, 1);
    }

    /* renamed from: a */
    public void mo40898a(short s) throws TException {
        byte[] bArr = this.f29073g;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f29157c.mo40956c(this.f29073g, 0, 2);
    }

    /* renamed from: a */
    public void mo40892a(int i) throws TException {
        byte[] bArr = this.f29073g;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.f29157c.mo40956c(this.f29073g, 0, 4);
    }

    /* renamed from: a */
    public void mo40893a(String str) throws TException {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo40892a(bytes.length);
            this.f29157c.mo40956c(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: f */
    public TMessage mo40904f() throws TException {
        int u = mo40919u();
        if (u < 0) {
            if ((-65536 & u) == -2147418112) {
                return new TMessage(mo40922x(), (byte) (u & 255), mo40919u());
            }
            throw new TProtocolException(4, "Bad version in readMessageBegin");
        } else if (!this.f29069a) {
            return new TMessage(mo40899b(u), mo40917s(), mo40919u());
        } else {
            throw new TProtocolException(4, "Missing version in readMessageBegin, old client?");
        }
    }

    /* renamed from: h */
    public TStruct mo40906h() {
        return f29068d;
    }

    /* renamed from: j */
    public TField mo40908j() throws TException {
        short s;
        byte s2 = mo40917s();
        if (s2 == 0) {
            s = 0;
        } else {
            s = mo40918t();
        }
        return new TField("", s2, s);
    }

    /* renamed from: l */
    public TMap mo40910l() throws TException {
        TMap dVar = new TMap(mo40917s(), mo40917s(), mo40919u());
        m36993d(dVar.f29153c);
        return dVar;
    }

    /* renamed from: n */
    public TList mo40912n() throws TException {
        TList cVar = new TList(mo40917s(), mo40919u());
        m36993d(cVar.f29150b);
        return cVar;
    }

    /* renamed from: p */
    public TSet mo40914p() throws TException {
        TSet hVar = new TSet(mo40917s(), mo40919u());
        m36993d(hVar.f29160b);
        return hVar;
    }

    /* renamed from: r */
    public boolean mo40916r() throws TException {
        return mo40917s() == 1;
    }

    /* renamed from: s */
    public byte mo40917s() throws TException {
        if (this.f29157c.mo40977e() >= 1) {
            byte b = this.f29157c.mo40975c()[this.f29157c.mo40976d()];
            this.f29157c.mo40974a(1);
            return b;
        }
        m36991a(this.f29073g, 0, 1);
        return this.f29073g[0];
    }

    /* renamed from: t */
    public short mo40918t() throws TException {
        byte[] bArr = this.f29073g;
        int i = 0;
        if (this.f29157c.mo40977e() >= 2) {
            bArr = this.f29157c.mo40975c();
            i = this.f29157c.mo40976d();
            this.f29157c.mo40974a(2);
        } else {
            m36991a(this.f29073g, 0, 2);
        }
        return (short) ((bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8));
    }

    /* renamed from: u */
    public int mo40919u() throws TException {
        byte[] bArr = this.f29073g;
        int i = 0;
        if (this.f29157c.mo40977e() >= 4) {
            bArr = this.f29157c.mo40975c();
            i = this.f29157c.mo40976d();
            this.f29157c.mo40974a(4);
        } else {
            m36991a(this.f29073g, 0, 4);
        }
        return (bArr[i + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | ((bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((bArr[i + 2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
    }

    /* renamed from: v */
    public long mo40920v() throws TException {
        byte[] bArr = this.f29073g;
        int i = 0;
        if (this.f29157c.mo40977e() >= 8) {
            bArr = this.f29157c.mo40975c();
            i = this.f29157c.mo40976d();
            this.f29157c.mo40974a(8);
        } else {
            m36991a(this.f29073g, 0, 8);
        }
        return ((long) (bArr[i + 7] & DeviceInfos.NETWORK_TYPE_UNCONNECTED)) | (((long) (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED)) << 56) | (((long) (bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED)) << 48) | (((long) (bArr[i + 2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED)) << 40) | (((long) (bArr[i + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED)) << 32) | (((long) (bArr[i + 4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED)) << 24) | (((long) (bArr[i + 5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED)) << 16) | (((long) (bArr[i + 6] & DeviceInfos.NETWORK_TYPE_UNCONNECTED)) << 8);
    }

    /* renamed from: w */
    public double mo40921w() throws TException {
        return Double.longBitsToDouble(mo40920v());
    }

    /* renamed from: x */
    public String mo40922x() throws TException {
        int u = mo40919u();
        m36992c(u);
        if (this.f29157c.mo40977e() < u) {
            return mo40899b(u);
        }
        try {
            String str = new String(this.f29157c.mo40975c(), this.f29157c.mo40976d(), u, "UTF-8");
            this.f29157c.mo40974a(u);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: b */
    public String mo40899b(int i) throws TException {
        try {
            byte[] bArr = new byte[i];
            this.f29157c.mo40952a(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: y */
    public ByteBuffer mo40923y() throws TException {
        int u = mo40919u();
        m36992c(u);
        if (this.f29157c.mo40977e() >= u) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f29157c.mo40975c(), this.f29157c.mo40976d(), u);
            this.f29157c.mo40974a(u);
            return wrap;
        }
        byte[] bArr = new byte[u];
        this.f29157c.mo40952a(bArr, 0, u);
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: c */
    private void m36992c(int i) throws TProtocolException {
        if (i >= 0) {
            long j = this.f29071e;
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

    /* renamed from: d */
    private void m36993d(int i) throws TProtocolException {
        if (i >= 0) {
            long j = this.f29072f;
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

    /* renamed from: a */
    private int m36991a(byte[] bArr, int i, int i2) throws TException {
        return this.f29157c.mo40952a(bArr, i, i2);
    }
}
