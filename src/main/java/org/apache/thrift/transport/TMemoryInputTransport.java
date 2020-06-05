package org.apache.thrift.transport;

/* renamed from: org.apache.thrift.transport.c */
public final class TMemoryInputTransport extends TTransport {
    /* renamed from: a */
    private byte[] f29193a;
    /* renamed from: b */
    private int f29194b;
    /* renamed from: c */
    private int f29195c;

    /* renamed from: a */
    public boolean mo40953a() {
        return true;
    }

    public void close() {
    }

    /* renamed from: a */
    public void mo40979a(byte[] bArr) {
        mo40980d(bArr, 0, bArr.length);
    }

    /* renamed from: d */
    public void mo40980d(byte[] bArr, int i, int i2) {
        this.f29193a = bArr;
        this.f29194b = i;
        this.f29195c = i + i2;
    }

    /* renamed from: b */
    public int mo40954b(byte[] bArr, int i, int i2) throws TTransportException {
        int e = mo40977e();
        if (i2 > e) {
            i2 = e;
        }
        if (i2 > 0) {
            System.arraycopy(this.f29193a, this.f29194b, bArr, i, i2);
            mo40974a(i2);
        }
        return i2;
    }

    /* renamed from: c */
    public void mo40956c(byte[] bArr, int i, int i2) throws TTransportException {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    /* renamed from: c */
    public byte[] mo40975c() {
        return this.f29193a;
    }

    /* renamed from: d */
    public int mo40976d() {
        return this.f29194b;
    }

    /* renamed from: e */
    public int mo40977e() {
        return this.f29195c - this.f29194b;
    }

    /* renamed from: a */
    public void mo40974a(int i) {
        this.f29194b += i;
    }
}
