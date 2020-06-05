package org.apache.thrift.protocol;

import com.p522qq.taf.jce.JceStruct;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Stack;
import org.apache.thrift.TByteArrayOutputStream;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

public class TJSONProtocol extends TProtocol {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final byte[] f29086a = {44};
    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final byte[] f29087b = {58};
    /* renamed from: d */
    private static final byte[] f29088d = {123};
    /* renamed from: e */
    private static final byte[] f29089e = {125};
    /* renamed from: f */
    private static final byte[] f29090f = {91};
    /* renamed from: g */
    private static final byte[] f29091g = {93};
    /* renamed from: h */
    private static final byte[] f29092h = {34};
    /* renamed from: i */
    private static final byte[] f29093i = {92};
    /* renamed from: j */
    private static final byte[] f29094j = {48};
    /* renamed from: k */
    private static final byte[] f29095k = {92, 117, 48, 48};
    /* renamed from: l */
    private static final byte[] f29096l = {0, 0, 0, 0, 0, 0, 0, 0, 98, 116, 110, 0, 102, 114, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 34, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    /* renamed from: m */
    private static final byte[] f29097m = {34, 92, 47, 8, JceStruct.ZERO_TAG, 10, JceStruct.SIMPLE_LIST, 9};
    /* renamed from: n */
    private static final byte[] f29098n = {116, 102};
    /* renamed from: o */
    private static final byte[] f29099o = {105, 56};
    /* renamed from: p */
    private static final byte[] f29100p = {105, 49, 54};
    /* renamed from: q */
    private static final byte[] f29101q = {105, 51, 50};
    /* renamed from: r */
    private static final byte[] f29102r = {105, 54, 52};
    /* renamed from: s */
    private static final byte[] f29103s = {100, 98, 108};
    /* renamed from: t */
    private static final byte[] f29104t = {114, 101, 99};
    /* renamed from: u */
    private static final byte[] f29105u = {115, 116, 114};
    /* renamed from: v */
    private static final byte[] f29106v = {109, 97, 112};
    /* renamed from: w */
    private static final byte[] f29107w = {108, 115, 116};
    /* renamed from: x */
    private static final byte[] f29108x = {115, 101, 116};
    /* renamed from: y */
    private static final TStruct f29109y = new TStruct();
    /* renamed from: A */
    private C8564a f29110A = new C8564a();
    /* renamed from: B */
    private C8567d f29111B = new C8567d();
    /* renamed from: C */
    private boolean f29112C = false;
    /* renamed from: D */
    private byte[] f29113D = new byte[4];
    /* renamed from: z */
    private Stack<C8564a> f29114z = new Stack<>();

    /* renamed from: org.apache.thrift.protocol.TJSONProtocol$Factory */
    public static class Factory implements TProtocolFactory {
        protected boolean fieldNamesAsString_ = false;

        public Factory() {
        }

        public Factory(boolean z) {
            this.fieldNamesAsString_ = z;
        }

        public TProtocol getProtocol(TTransport fVar) {
            return new TJSONProtocol(fVar, this.fieldNamesAsString_);
        }
    }

    /* renamed from: org.apache.thrift.protocol.TJSONProtocol$a */
    protected class C8564a {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo40928a() throws TException {
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo40929b() throws TException {
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public boolean mo40930c() {
            return false;
        }

        protected C8564a() {
        }
    }

    /* renamed from: org.apache.thrift.protocol.TJSONProtocol$b */
    protected class C8565b extends C8564a {
        /* renamed from: c */
        private boolean f29117c = true;

        protected C8565b() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo40928a() throws TException {
            if (this.f29117c) {
                this.f29117c = false;
            } else {
                TJSONProtocol.this.f29157c.mo40982b(TJSONProtocol.f29086a);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo40929b() throws TException {
            if (this.f29117c) {
                this.f29117c = false;
            } else {
                TJSONProtocol.this.mo40927a(TJSONProtocol.f29086a);
            }
        }
    }

    /* renamed from: org.apache.thrift.protocol.TJSONProtocol$c */
    protected class C8566c extends C8564a {
        /* renamed from: c */
        private boolean f29119c = true;
        /* renamed from: d */
        private boolean f29120d = true;

        protected C8566c() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo40928a() throws TException {
            if (this.f29119c) {
                this.f29119c = false;
                this.f29120d = true;
                return;
            }
            TJSONProtocol.this.f29157c.mo40982b(this.f29120d ? TJSONProtocol.f29087b : TJSONProtocol.f29086a);
            this.f29120d = !this.f29120d;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo40929b() throws TException {
            if (this.f29119c) {
                this.f29119c = false;
                this.f29120d = true;
                return;
            }
            TJSONProtocol.this.mo40927a(this.f29120d ? TJSONProtocol.f29087b : TJSONProtocol.f29086a);
            this.f29120d = !this.f29120d;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public boolean mo40930c() {
            return this.f29120d;
        }
    }

    /* renamed from: org.apache.thrift.protocol.TJSONProtocol$d */
    protected class C8567d {
        /* renamed from: b */
        private boolean f29122b;
        /* renamed from: c */
        private byte[] f29123c = new byte[1];

        protected C8567d() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public byte mo40931a() throws TException {
            if (this.f29122b) {
                this.f29122b = false;
            } else {
                TJSONProtocol.this.f29157c.mo40952a(this.f29123c, 0, 1);
            }
            return this.f29123c[0];
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public byte mo40932b() throws TException {
            if (!this.f29122b) {
                TJSONProtocol.this.f29157c.mo40952a(this.f29123c, 0, 1);
            }
            this.f29122b = true;
            return this.f29123c[0];
        }
    }

    /* renamed from: c */
    private static final byte m37100c(byte b) {
        byte b2 = (byte) (b & 15);
        return (byte) (b2 < 10 ? ((char) b2) + '0' : ((char) (b2 - 10)) + 'a');
    }

    /* renamed from: d */
    private boolean m37102d(byte b) {
        if (!(b == 43 || b == 69 || b == 101 || b == 45 || b == 46)) {
            switch (b) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public void mo40902d() {
    }

    /* renamed from: a */
    private static final byte[] m37097a(byte b) throws TException {
        switch (b) {
            case 2:
                return f29098n;
            case 3:
                return f29099o;
            case 4:
                return f29103s;
            case 6:
                return f29100p;
            case 8:
                return f29101q;
            case 10:
                return f29102r;
            case 11:
                return f29105u;
            case 12:
                return f29104t;
            case 13:
                return f29106v;
            case 14:
                return f29108x;
            case 15:
                return f29107w;
            default:
                throw new TProtocolException(5, "Unrecognized type");
        }
    }

    /* renamed from: b */
    private static final byte m37099b(byte[] bArr) throws TException {
        byte b = 0;
        if (bArr.length > 1) {
            byte b2 = bArr[0];
            if (b2 == 100) {
                b = 4;
            } else if (b2 == 105) {
                byte b3 = bArr[1];
                if (b3 == 49) {
                    b = 6;
                } else if (b3 == 51) {
                    b = 8;
                } else if (b3 == 54) {
                    b = 10;
                } else if (b3 == 56) {
                    b = 3;
                }
            } else if (b2 == 108) {
                b = 15;
            } else if (b2 != 109) {
                switch (b2) {
                    case 114:
                        b = JceStruct.ZERO_TAG;
                        break;
                    case 115:
                        if (bArr[1] != 116) {
                            if (bArr[1] == 101) {
                                b = 14;
                                break;
                            }
                        } else {
                            b = JceStruct.STRUCT_END;
                            break;
                        }
                        break;
                    case 116:
                        b = 2;
                        break;
                }
            } else {
                b = JceStruct.SIMPLE_LIST;
            }
        }
        if (b != 0) {
            return b;
        }
        throw new TProtocolException(5, "Unrecognized type");
    }

    /* renamed from: a */
    private void m37096a(C8564a aVar) {
        this.f29114z.push(this.f29110A);
        this.f29110A = aVar;
    }

    /* renamed from: D */
    private void m37080D() {
        this.f29110A = (C8564a) this.f29114z.pop();
    }

    /* renamed from: E */
    private void m37081E() {
        while (!this.f29114z.isEmpty()) {
            m37080D();
        }
    }

    public TJSONProtocol(TTransport fVar, boolean z) {
        super(fVar);
        this.f29112C = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo40927a(byte[] bArr) throws TException {
        byte a = this.f29111B.mo40931a();
        if (a != bArr[0]) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected character:");
            sb.append((char) a);
            throw new TProtocolException(1, sb.toString());
        }
    }

    /* renamed from: b */
    private static final byte m37098b(byte b) throws TException {
        int i;
        if (b >= 48 && b <= 57) {
            i = ((char) b) - '0';
        } else if (b < 97 || b > 102) {
            throw new TProtocolException(1, "Expected hex character");
        } else {
            i = (((char) b) - 'a') + 10;
        }
        return (byte) i;
    }

    /* renamed from: c */
    private void m37101c(byte[] bArr) throws TException {
        this.f29110A.mo40928a();
        this.f29157c.mo40982b(f29092h);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) < 48) {
                byte[] bArr2 = this.f29113D;
                bArr2[0] = f29096l[bArr[i]];
                if (bArr2[0] == 1) {
                    this.f29157c.mo40956c(bArr, i, 1);
                } else if (bArr2[0] > 1) {
                    this.f29157c.mo40982b(f29093i);
                    this.f29157c.mo40956c(this.f29113D, 0, 1);
                } else {
                    this.f29157c.mo40982b(f29095k);
                    this.f29113D[0] = m37100c((byte) (bArr[i] >> 4));
                    this.f29113D[1] = m37100c(bArr[i]);
                    this.f29157c.mo40956c(this.f29113D, 0, 2);
                }
            } else if (bArr[i] == f29093i[0]) {
                this.f29157c.mo40982b(f29093i);
                this.f29157c.mo40982b(f29093i);
            } else {
                this.f29157c.mo40956c(bArr, i, 1);
            }
        }
        this.f29157c.mo40982b(f29092h);
    }

    /* renamed from: a */
    private void m37095a(long j) throws TException {
        this.f29110A.mo40928a();
        String l = Long.toString(j);
        boolean c = this.f29110A.mo40930c();
        if (c) {
            this.f29157c.mo40982b(f29092h);
        }
        try {
            this.f29157c.mo40982b(l.getBytes("UTF-8"));
            if (c) {
                this.f29157c.mo40982b(f29092h);
            }
        } catch (UnsupportedEncodingException unused) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: F */
    private void m37082F() throws TException {
        this.f29110A.mo40928a();
        this.f29157c.mo40982b(f29088d);
        m37096a((C8564a) new C8566c());
    }

    /* renamed from: G */
    private void m37083G() throws TException {
        m37080D();
        this.f29157c.mo40982b(f29089e);
    }

    /* renamed from: H */
    private void m37084H() throws TException {
        this.f29110A.mo40928a();
        this.f29157c.mo40982b(f29090f);
        m37096a((C8564a) new C8565b());
    }

    /* renamed from: I */
    private void m37085I() throws TException {
        m37080D();
        this.f29157c.mo40982b(f29091g);
    }

    /* renamed from: a */
    public void mo40896a(TMessage eVar) throws TException {
        m37081E();
        m37084H();
        m37095a(1);
        try {
            m37101c(eVar.f29154a.getBytes("UTF-8"));
            m37095a((long) eVar.f29155b);
            m37095a((long) eVar.f29156c);
        } catch (UnsupportedEncodingException unused) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: a */
    public void mo40890a() throws TException {
        m37085I();
    }

    /* renamed from: a */
    public void mo40897a(TStruct iVar) throws TException {
        m37082F();
    }

    /* renamed from: b */
    public void mo40900b() throws TException {
        m37083G();
    }

    /* renamed from: a */
    public void mo40894a(TField bVar) throws TException {
        if (this.f29112C) {
            mo40893a(bVar.f29146a);
        } else {
            m37095a((long) bVar.f29148c);
        }
        m37082F();
        m37101c(m37097a(bVar.f29147b));
    }

    /* renamed from: c */
    public void mo40901c() throws TException {
        m37083G();
    }

    /* renamed from: a */
    public void mo40895a(TList cVar) throws TException {
        m37084H();
        m37101c(m37097a(cVar.f29149a));
        m37095a((long) cVar.f29150b);
    }

    /* renamed from: e */
    public void mo40903e() throws TException {
        m37085I();
    }

    /* renamed from: a */
    public void mo40898a(short s) throws TException {
        m37095a((long) s);
    }

    /* renamed from: a */
    public void mo40892a(int i) throws TException {
        m37095a((long) i);
    }

    /* renamed from: a */
    public void mo40893a(String str) throws TException {
        try {
            m37101c(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: a */
    private TByteArrayOutputStream m37094a(boolean z) throws TException {
        TByteArrayOutputStream dVar = new TByteArrayOutputStream(16);
        ArrayList arrayList = new ArrayList();
        if (!z) {
            this.f29110A.mo40929b();
        }
        mo40927a(f29092h);
        while (true) {
            byte a = this.f29111B.mo40931a();
            if (a == f29092h[0]) {
                return dVar;
            }
            if (a == f29095k[0]) {
                byte a2 = this.f29111B.mo40931a();
                if (a2 == f29095k[1]) {
                    this.f29157c.mo40952a(this.f29113D, 0, 4);
                    int b = (short) ((((short) m37098b(this.f29113D[0])) << 12) + (((short) m37098b(this.f29113D[1])) << 8) + (((short) m37098b(this.f29113D[2])) << 4) + ((short) m37098b(this.f29113D[3])));
                    char c = (char) b;
                    try {
                        if (!Character.isHighSurrogate(c)) {
                            String str = "UTF-8";
                            if (!Character.isLowSurrogate(c)) {
                                dVar.write(new String(new int[]{b}, 0, 1).getBytes(str));
                            } else if (arrayList.size() != 0) {
                                arrayList.add(Character.valueOf(c));
                                dVar.write(new String(new int[]{((Character) arrayList.get(0)).charValue(), ((Character) arrayList.get(1)).charValue()}, 0, 2).getBytes(str));
                                arrayList.clear();
                            } else {
                                throw new TProtocolException(1, "Expected high surrogate char");
                            }
                        } else if (arrayList.size() <= 0) {
                            arrayList.add(Character.valueOf(c));
                        } else {
                            throw new TProtocolException(1, "Expected low surrogate char");
                        }
                    } catch (UnsupportedEncodingException unused) {
                        throw new TProtocolException(5, "JVM does not support UTF-8");
                    } catch (IOException unused2) {
                        throw new TProtocolException(1, "Invalid unicode sequence");
                    }
                } else {
                    int indexOf = "\"\\/bfnrt".indexOf(a2);
                    if (indexOf != -1) {
                        a = f29097m[indexOf];
                    } else {
                        throw new TProtocolException(1, "Expected control char");
                    }
                }
            }
            dVar.write(a);
        }
    }

    /* renamed from: J */
    private String m37086J() throws TException {
        StringBuilder sb = new StringBuilder();
        while (m37102d(this.f29111B.mo40932b())) {
            sb.append((char) this.f29111B.mo40931a());
        }
        return sb.toString();
    }

    /* renamed from: K */
    private long m37087K() throws TException {
        this.f29110A.mo40929b();
        if (this.f29110A.mo40930c()) {
            mo40927a(f29092h);
        }
        String J = m37086J();
        if (this.f29110A.mo40930c()) {
            mo40927a(f29092h);
        }
        try {
            return Long.valueOf(J).longValue();
        } catch (NumberFormatException unused) {
            throw new TProtocolException(1, "Bad data encounted in numeric data");
        }
    }

    /* renamed from: L */
    private double m37088L() throws TException {
        this.f29110A.mo40929b();
        if (this.f29111B.mo40932b() == f29092h[0]) {
            try {
                double doubleValue = Double.valueOf(m37094a(true).toString("UTF-8")).doubleValue();
                if (!this.f29110A.mo40930c() && !Double.isNaN(doubleValue)) {
                    if (!Double.isInfinite(doubleValue)) {
                        throw new TProtocolException(1, "Numeric data unexpectedly quoted");
                    }
                }
                return doubleValue;
            } catch (UnsupportedEncodingException unused) {
                throw new TException("JVM DOES NOT SUPPORT UTF-8");
            }
        } else {
            if (this.f29110A.mo40930c()) {
                mo40927a(f29092h);
            }
            try {
                return Double.valueOf(m37086J()).doubleValue();
            } catch (NumberFormatException unused2) {
                throw new TProtocolException(1, "Bad data encounted in numeric data");
            }
        }
    }

    /* renamed from: M */
    private byte[] m37089M() throws TException {
        TByteArrayOutputStream a = m37094a(false);
        byte[] a2 = a.mo40877a();
        int b = a.mo40878b();
        int i = b >= 2 ? b - 2 : 0;
        int i2 = b - 1;
        while (i2 >= i && a2[i2] == 61) {
            b--;
            i2--;
        }
        int i3 = 0;
        int i4 = 0;
        while (b >= 4) {
            TBase64Utils.m37196a(a2, i3, 4, a2, i4);
            i3 += 4;
            b -= 4;
            i4 += 3;
        }
        if (b > 1) {
            TBase64Utils.m37196a(a2, i3, b, a2, i4);
            i4 += b - 1;
        }
        byte[] bArr = new byte[i4];
        System.arraycopy(a2, 0, bArr, 0, i4);
        return bArr;
    }

    /* renamed from: N */
    private void m37090N() throws TException {
        this.f29110A.mo40929b();
        mo40927a(f29088d);
        m37096a((C8564a) new C8566c());
    }

    /* renamed from: O */
    private void m37091O() throws TException {
        mo40927a(f29089e);
        m37080D();
    }

    /* renamed from: P */
    private void m37092P() throws TException {
        this.f29110A.mo40929b();
        mo40927a(f29090f);
        m37096a((C8564a) new C8565b());
    }

    /* renamed from: Q */
    private void m37093Q() throws TException {
        mo40927a(f29091g);
        m37080D();
    }

    /* renamed from: f */
    public TMessage mo40904f() throws TException {
        m37081E();
        m37092P();
        if (m37087K() == 1) {
            try {
                return new TMessage(m37094a(false).toString("UTF-8"), (byte) ((int) m37087K()), (int) m37087K());
            } catch (UnsupportedEncodingException unused) {
                throw new TException("JVM DOES NOT SUPPORT UTF-8");
            }
        } else {
            throw new TProtocolException(4, "Message contained bad version.");
        }
    }

    /* renamed from: g */
    public void mo40905g() throws TException {
        m37093Q();
    }

    /* renamed from: h */
    public TStruct mo40906h() throws TException {
        m37090N();
        return f29109y;
    }

    /* renamed from: i */
    public void mo40907i() throws TException {
        m37091O();
    }

    /* renamed from: j */
    public TField mo40908j() throws TException {
        short s;
        byte b = 0;
        if (this.f29111B.mo40932b() == f29089e[0]) {
            s = 0;
        } else {
            s = (short) ((int) m37087K());
            m37090N();
            b = m37099b(m37094a(false).mo40877a());
        }
        return new TField("", b, s);
    }

    /* renamed from: k */
    public void mo40909k() throws TException {
        m37091O();
    }

    /* renamed from: l */
    public TMap mo40910l() throws TException {
        m37092P();
        byte b = m37099b(m37094a(false).mo40877a());
        byte b2 = m37099b(m37094a(false).mo40877a());
        int K = (int) m37087K();
        m37090N();
        return new TMap(b, b2, K);
    }

    /* renamed from: m */
    public void mo40911m() throws TException {
        m37091O();
        m37093Q();
    }

    /* renamed from: n */
    public TList mo40912n() throws TException {
        m37092P();
        return new TList(m37099b(m37094a(false).mo40877a()), (int) m37087K());
    }

    /* renamed from: o */
    public void mo40913o() throws TException {
        m37093Q();
    }

    /* renamed from: p */
    public TSet mo40914p() throws TException {
        m37092P();
        return new TSet(m37099b(m37094a(false).mo40877a()), (int) m37087K());
    }

    /* renamed from: q */
    public void mo40915q() throws TException {
        m37093Q();
    }

    /* renamed from: r */
    public boolean mo40916r() throws TException {
        return m37087K() != 0;
    }

    /* renamed from: s */
    public byte mo40917s() throws TException {
        return (byte) ((int) m37087K());
    }

    /* renamed from: t */
    public short mo40918t() throws TException {
        return (short) ((int) m37087K());
    }

    /* renamed from: u */
    public int mo40919u() throws TException {
        return (int) m37087K();
    }

    /* renamed from: v */
    public long mo40920v() throws TException {
        return m37087K();
    }

    /* renamed from: w */
    public double mo40921w() throws TException {
        return m37088L();
    }

    /* renamed from: x */
    public String mo40922x() throws TException {
        try {
            return m37094a(false).toString("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: y */
    public ByteBuffer mo40923y() throws TException {
        return ByteBuffer.wrap(m37089M());
    }
}
