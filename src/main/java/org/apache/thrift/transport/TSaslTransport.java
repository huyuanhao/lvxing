package org.apache.thrift.transport;

import java.util.HashMap;
import java.util.Map;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;
import javax.security.sasl.SaslServer;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TByteArrayOutputStream;
import org.slf4j.C8580b;
import org.slf4j.LoggerFactory;

abstract class TSaslTransport extends TTransport {
    /* renamed from: b */
    static final /* synthetic */ boolean f29175b;
    /* renamed from: c */
    private static final C8580b f29176c;
    /* renamed from: a */
    protected TTransport f29177a;
    /* renamed from: d */
    private C8575a f29178d;
    /* renamed from: e */
    private boolean f29179e;
    /* renamed from: f */
    private TMemoryInputTransport f29180f;
    /* renamed from: g */
    private final TByteArrayOutputStream f29181g;

    /* renamed from: org.apache.thrift.transport.TSaslTransport$NegotiationStatus */
    protected enum NegotiationStatus {
        START(1),
        OK(2),
        BAD(3),
        ERROR(4),
        COMPLETE(5);
        
        private static final Map<Byte, NegotiationStatus> reverseMap = null;
        private final byte value;

        static {
            int i;
            NegotiationStatus[] negotiationStatusArr;
            reverseMap = new HashMap();
            for (NegotiationStatus negotiationStatus : (NegotiationStatus[]) NegotiationStatus.class.getEnumConstants()) {
                reverseMap.put(Byte.valueOf(negotiationStatus.getValue()), negotiationStatus);
            }
        }

        private NegotiationStatus(byte b) {
            this.value = b;
        }

        public byte getValue() {
            return this.value;
        }

        public static NegotiationStatus byValue(byte b) {
            return (NegotiationStatus) reverseMap.get(Byte.valueOf(b));
        }
    }

    /* renamed from: org.apache.thrift.transport.TSaslTransport$SaslRole */
    protected enum SaslRole {
        SERVER,
        CLIENT
    }

    /* renamed from: org.apache.thrift.transport.TSaslTransport$a */
    private static class C8575a {
        /* renamed from: a */
        public SaslServer f29183a;
        /* renamed from: b */
        public SaslClient f29184b;

        /* renamed from: a */
        public boolean mo40969a() {
            SaslClient saslClient = this.f29184b;
            if (saslClient != null) {
                return saslClient.isComplete();
            }
            return this.f29183a.isComplete();
        }

        /* renamed from: b */
        public void mo40971b() throws SaslException {
            SaslClient saslClient = this.f29184b;
            if (saslClient != null) {
                saslClient.dispose();
            } else {
                this.f29183a.dispose();
            }
        }

        /* renamed from: a */
        public byte[] mo40970a(byte[] bArr, int i, int i2) throws SaslException {
            SaslClient saslClient = this.f29184b;
            if (saslClient != null) {
                return saslClient.unwrap(bArr, i, i2);
            }
            return this.f29183a.unwrap(bArr, i, i2);
        }

        /* renamed from: b */
        public byte[] mo40972b(byte[] bArr, int i, int i2) throws SaslException {
            SaslClient saslClient = this.f29184b;
            if (saslClient != null) {
                return saslClient.wrap(bArr, i, i2);
            }
            return this.f29183a.wrap(bArr, i, i2);
        }
    }

    /* renamed from: f */
    public abstract SaslRole mo40966f();

    static {
        Class<TSaslTransport> cls = TSaslTransport.class;
        f29175b = !cls.desiredAssertionStatus();
        f29176c = LoggerFactory.m37315a(cls);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public int mo40967g() throws TTransportException {
        byte[] bArr = new byte[4];
        this.f29177a.mo40952a(bArr, 0, bArr.length);
        return EncodingUtils.m36968a(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo40965b(int i) throws TTransportException {
        byte[] bArr = new byte[4];
        TFramedTransport.m37260a(i, bArr);
        this.f29177a.mo40982b(bArr);
    }

    public void close() {
        this.f29177a.close();
        try {
            this.f29178d.mo40971b();
        } catch (SaslException unused) {
        }
    }

    /* renamed from: a */
    public boolean mo40953a() {
        if (this.f29177a.mo40953a()) {
            C8575a aVar = this.f29178d;
            if (aVar != null && aVar.mo40969a()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public int mo40954b(byte[] bArr, int i, int i2) throws TTransportException {
        if (mo40953a()) {
            int b = this.f29180f.mo40954b(bArr, i, i2);
            if (b > 0) {
                return b;
            }
            try {
                m37247h();
                return this.f29180f.mo40954b(bArr, i, i2);
            } catch (SaslException e) {
                throw new TTransportException((Throwable) e);
            }
        } else {
            throw new TTransportException("SASL authentication not complete");
        }
    }

    /* renamed from: h */
    private void m37247h() throws TTransportException, SaslException {
        int g = mo40967g();
        if (g >= 0) {
            byte[] bArr = new byte[g];
            f29176c.debug("{}: reading data length: {}", mo40966f(), Integer.valueOf(g));
            this.f29177a.mo40952a(bArr, 0, g);
            if (this.f29179e) {
                bArr = this.f29178d.mo40970a(bArr, 0, bArr.length);
                f29176c.debug("data length after unwrap: {}", (Object) Integer.valueOf(bArr.length));
            }
            this.f29180f.mo40979a(bArr);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Read a negative frame size (");
        sb.append(g);
        sb.append(")!");
        throw new TTransportException(sb.toString());
    }

    /* renamed from: c */
    public void mo40956c(byte[] bArr, int i, int i2) throws TTransportException {
        if (mo40953a()) {
            this.f29181g.write(bArr, i, i2);
            return;
        }
        throw new TTransportException("SASL authentication not complete");
    }

    /* renamed from: b */
    public void mo40955b() throws TTransportException {
        byte[] a = this.f29181g.mo40877a();
        int b = this.f29181g.mo40878b();
        this.f29181g.reset();
        if (this.f29179e) {
            f29176c.debug("data length before wrap: {}", (Object) Integer.valueOf(b));
            try {
                a = this.f29178d.mo40972b(a, 0, b);
                b = a.length;
            } catch (SaslException e) {
                throw new TTransportException((Throwable) e);
            }
        }
        f29176c.debug("writing data length: {}", (Object) Integer.valueOf(b));
        mo40965b(b);
        this.f29177a.mo40956c(a, 0, b);
        this.f29177a.mo40955b();
    }
}
