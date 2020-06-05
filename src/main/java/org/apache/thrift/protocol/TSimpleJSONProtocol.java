package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Stack;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

public class TSimpleJSONProtocol extends TProtocol {
    /* access modifiers changed from: private|static|final */
    /* renamed from: e */
    public static final byte[] f29124e = {44};
    /* access modifiers changed from: private|static|final */
    /* renamed from: f */
    public static final byte[] f29125f = {58};
    /* renamed from: g */
    private static final byte[] f29126g = {123};
    /* renamed from: h */
    private static final byte[] f29127h = {125};
    /* renamed from: i */
    private static final byte[] f29128i = {91};
    /* renamed from: j */
    private static final byte[] f29129j = {93};
    /* renamed from: k */
    private static final TStruct f29130k = new TStruct();
    /* renamed from: l */
    private static final TField f29131l = new TField();
    /* renamed from: m */
    private static final TMessage f29132m = new TMessage();
    /* renamed from: n */
    private static final TSet f29133n = new TSet();
    /* renamed from: o */
    private static final TList f29134o = new TList();
    /* renamed from: p */
    private static final TMap f29135p = new TMap();
    /* renamed from: a */
    protected final C8568a f29136a = new C8568a();
    /* renamed from: b */
    protected Stack<C8568a> f29137b = new Stack<>();
    /* renamed from: d */
    protected C8568a f29138d = this.f29136a;

    /* renamed from: org.apache.thrift.protocol.TSimpleJSONProtocol$CollectionMapKeyException */
    public static class CollectionMapKeyException extends TException {
        public CollectionMapKeyException(String str) {
            super(str);
        }
    }

    /* renamed from: org.apache.thrift.protocol.TSimpleJSONProtocol$Factory */
    public static class Factory implements TProtocolFactory {
        public TProtocol getProtocol(TTransport fVar) {
            return new TSimpleJSONProtocol(fVar);
        }
    }

    /* renamed from: org.apache.thrift.protocol.TSimpleJSONProtocol$a */
    protected class C8568a {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo40940a() throws TException {
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public boolean mo40941b() {
            return false;
        }

        protected C8568a() {
        }
    }

    /* renamed from: org.apache.thrift.protocol.TSimpleJSONProtocol$b */
    protected class C8569b extends C8568a {
        /* renamed from: b */
        protected boolean f29140b = true;

        protected C8569b() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo40940a() throws TException {
            if (this.f29140b) {
                this.f29140b = false;
            } else {
                TSimpleJSONProtocol.this.f29157c.mo40982b(TSimpleJSONProtocol.f29124e);
            }
        }
    }

    /* renamed from: org.apache.thrift.protocol.TSimpleJSONProtocol$c */
    protected class C8570c extends C8568a {
        /* renamed from: b */
        protected boolean f29142b = true;
        /* renamed from: c */
        protected boolean f29143c = true;

        protected C8570c() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo40940a() throws TException {
            if (this.f29142b) {
                this.f29142b = false;
                this.f29143c = true;
                return;
            }
            TSimpleJSONProtocol.this.f29157c.mo40982b(this.f29143c ? TSimpleJSONProtocol.f29125f : TSimpleJSONProtocol.f29124e);
            this.f29143c = !this.f29143c;
        }
    }

    /* renamed from: c */
    public void mo40901c() {
    }

    /* renamed from: d */
    public void mo40902d() {
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

    /* renamed from: s */
    public byte mo40917s() throws TException {
        return 0;
    }

    /* renamed from: t */
    public short mo40918t() throws TException {
        return 0;
    }

    /* renamed from: u */
    public int mo40919u() throws TException {
        return 0;
    }

    /* renamed from: v */
    public long mo40920v() throws TException {
        return 0;
    }

    /* renamed from: w */
    public double mo40921w() throws TException {
        return 0.0d;
    }

    /* renamed from: x */
    public String mo40922x() throws TException {
        return "";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo40936a(C8568a aVar) {
        this.f29137b.push(this.f29138d);
        this.f29138d = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void mo40939z() {
        this.f29138d = (C8568a) this.f29137b.pop();
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public void mo40934A() {
        while (!this.f29137b.isEmpty()) {
            mo40939z();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo40937b(String str) throws CollectionMapKeyException {
        if (this.f29138d.mo40941b()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot serialize a map with keys that are of type ");
            sb.append(str);
            throw new CollectionMapKeyException(sb.toString());
        }
    }

    public TSimpleJSONProtocol(TTransport fVar) {
        super(fVar);
    }

    /* renamed from: a */
    public void mo40896a(TMessage eVar) throws TException {
        mo40934A();
        this.f29157c.mo40982b(f29128i);
        mo40936a((C8568a) new C8569b());
        mo40893a(eVar.f29154a);
        mo40935a(eVar.f29155b);
        mo40892a(eVar.f29156c);
    }

    /* renamed from: a */
    public void mo40890a() throws TException {
        mo40939z();
        this.f29157c.mo40982b(f29129j);
    }

    /* renamed from: a */
    public void mo40897a(TStruct iVar) throws TException {
        this.f29138d.mo40940a();
        this.f29157c.mo40982b(f29126g);
        mo40936a((C8568a) new C8570c());
    }

    /* renamed from: b */
    public void mo40900b() throws TException {
        mo40939z();
        this.f29157c.mo40982b(f29127h);
    }

    /* renamed from: a */
    public void mo40894a(TField bVar) throws TException {
        mo40893a(bVar.f29146a);
    }

    /* renamed from: a */
    public void mo40895a(TList cVar) throws TException {
        mo40937b("list");
        this.f29138d.mo40940a();
        this.f29157c.mo40982b(f29128i);
        mo40936a((C8568a) new C8569b());
    }

    /* renamed from: e */
    public void mo40903e() throws TException {
        mo40939z();
        this.f29157c.mo40982b(f29129j);
    }

    /* renamed from: a */
    public void mo40935a(byte b) throws TException {
        mo40892a((int) b);
    }

    /* renamed from: a */
    public void mo40898a(short s) throws TException {
        mo40892a((int) s);
    }

    /* renamed from: a */
    public void mo40892a(int i) throws TException {
        if (this.f29138d.mo40941b()) {
            mo40893a(Integer.toString(i));
            return;
        }
        this.f29138d.mo40940a();
        mo40938c(Integer.toString(i));
    }

    /* renamed from: c */
    public void mo40938c(String str) throws TException {
        try {
            this.f29157c.mo40982b(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: a */
    public void mo40893a(String str) throws TException {
        this.f29138d.mo40940a();
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 16);
        stringBuffer.append('\"');
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                stringBuffer.append('\\');
                stringBuffer.append('f');
            } else if (charAt != 13) {
                if (charAt != '\"' && charAt != '\\') {
                    switch (charAt) {
                        case 8:
                            stringBuffer.append('\\');
                            stringBuffer.append('b');
                            break;
                        case 9:
                            stringBuffer.append('\\');
                            stringBuffer.append('t');
                            break;
                        case 10:
                            stringBuffer.append('\\');
                            stringBuffer.append('n');
                            break;
                        default:
                            if (charAt >= ' ') {
                                stringBuffer.append(charAt);
                                break;
                            } else {
                                String hexString = Integer.toHexString(charAt);
                                stringBuffer.append('\\');
                                stringBuffer.append('u');
                                for (int i2 = 4; i2 > hexString.length(); i2--) {
                                    stringBuffer.append('0');
                                }
                                stringBuffer.append(hexString);
                                break;
                            }
                    }
                } else {
                    stringBuffer.append('\\');
                    stringBuffer.append(charAt);
                }
            } else {
                stringBuffer.append('\\');
                stringBuffer.append('r');
            }
        }
        stringBuffer.append('\"');
        mo40938c(stringBuffer.toString());
    }

    /* renamed from: f */
    public TMessage mo40904f() throws TException {
        return f29132m;
    }

    /* renamed from: h */
    public TStruct mo40906h() {
        return f29130k;
    }

    /* renamed from: j */
    public TField mo40908j() throws TException {
        return f29131l;
    }

    /* renamed from: l */
    public TMap mo40910l() throws TException {
        return f29135p;
    }

    /* renamed from: n */
    public TList mo40912n() throws TException {
        return f29134o;
    }

    /* renamed from: p */
    public TSet mo40914p() throws TException {
        return f29133n;
    }

    /* renamed from: r */
    public boolean mo40916r() throws TException {
        return mo40917s() == 1;
    }

    /* renamed from: y */
    public ByteBuffer mo40923y() throws TException {
        return ByteBuffer.wrap(new byte[0]);
    }
}
