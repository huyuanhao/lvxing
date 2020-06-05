package org.apache.thrift.transport;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import org.apache.thrift.TByteArrayOutputStream;

/* renamed from: org.apache.thrift.transport.a */
public class TFramedTransport extends TTransport {
    /* renamed from: a */
    private int f29185a;
    /* renamed from: b */
    private TTransport f29186b;
    /* renamed from: c */
    private final TByteArrayOutputStream f29187c;
    /* renamed from: d */
    private TMemoryInputTransport f29188d;
    /* renamed from: e */
    private final byte[] f29189e;

    /* renamed from: a */
    public boolean mo40953a() {
        return this.f29186b.mo40953a();
    }

    public void close() {
        this.f29186b.close();
    }

    /* renamed from: b */
    public int mo40954b(byte[] bArr, int i, int i2) throws TTransportException {
        TMemoryInputTransport cVar = this.f29188d;
        if (cVar != null) {
            int b = cVar.mo40954b(bArr, i, i2);
            if (b > 0) {
                return b;
            }
        }
        m37261f();
        return this.f29188d.mo40954b(bArr, i, i2);
    }

    /* renamed from: c */
    public byte[] mo40975c() {
        return this.f29188d.mo40975c();
    }

    /* renamed from: d */
    public int mo40976d() {
        return this.f29188d.mo40976d();
    }

    /* renamed from: e */
    public int mo40977e() {
        return this.f29188d.mo40977e();
    }

    /* renamed from: a */
    public void mo40974a(int i) {
        this.f29188d.mo40974a(i);
    }

    /* renamed from: f */
    private void m37261f() throws TTransportException {
        this.f29186b.mo40952a(this.f29189e, 0, 4);
        int a = m37259a(this.f29189e);
        String str = ")!";
        if (a < 0) {
            close();
            StringBuilder sb = new StringBuilder();
            sb.append("Read a negative frame size (");
            sb.append(a);
            sb.append(str);
            throw new TTransportException(5, sb.toString());
        } else if (a <= this.f29185a) {
            byte[] bArr = new byte[a];
            this.f29186b.mo40952a(bArr, 0, a);
            this.f29188d.mo40979a(bArr);
        } else {
            close();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Frame size (");
            sb2.append(a);
            sb2.append(") larger than max length (");
            sb2.append(this.f29185a);
            sb2.append(str);
            throw new TTransportException(5, sb2.toString());
        }
    }

    /* renamed from: c */
    public void mo40956c(byte[] bArr, int i, int i2) throws TTransportException {
        this.f29187c.write(bArr, i, i2);
    }

    /* renamed from: b */
    public void mo40955b() throws TTransportException {
        byte[] a = this.f29187c.mo40877a();
        int b = this.f29187c.mo40878b();
        this.f29187c.reset();
        m37260a(b, this.f29189e);
        this.f29186b.mo40956c(this.f29189e, 0, 4);
        this.f29186b.mo40956c(a, 0, b);
        this.f29186b.mo40955b();
    }

    /* renamed from: a */
    public static final void m37260a(int i, byte[] bArr) {
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
    }

    /* renamed from: a */
    public static final int m37259a(byte[] bArr) {
        return (bArr[3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | ((bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((bArr[2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
    }
}
