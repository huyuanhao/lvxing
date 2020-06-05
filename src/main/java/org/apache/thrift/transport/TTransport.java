package org.apache.thrift.transport;

import java.io.Closeable;

/* renamed from: org.apache.thrift.transport.f */
public abstract class TTransport implements Closeable {
    /* renamed from: a */
    public void mo40974a(int i) {
    }

    /* renamed from: a */
    public abstract boolean mo40953a();

    /* renamed from: b */
    public abstract int mo40954b(byte[] bArr, int i, int i2) throws TTransportException;

    /* renamed from: b */
    public void mo40955b() throws TTransportException {
    }

    /* renamed from: c */
    public abstract void mo40956c(byte[] bArr, int i, int i2) throws TTransportException;

    /* renamed from: c */
    public byte[] mo40975c() {
        return null;
    }

    public abstract void close();

    /* renamed from: d */
    public int mo40976d() {
        return 0;
    }

    /* renamed from: e */
    public int mo40977e() {
        return -1;
    }

    /* renamed from: a */
    public int mo40952a(byte[] bArr, int i, int i2) throws TTransportException {
        int i3 = 0;
        while (i3 < i2) {
            int b = mo40954b(bArr, i + i3, i2 - i3);
            if (b > 0) {
                i3 += b;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot read. Remote side has closed. Tried to read ");
                sb.append(i2);
                sb.append(" bytes, but only got ");
                sb.append(i3);
                sb.append(" bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
                throw new TTransportException(sb.toString());
            }
        }
        return i3;
    }

    /* renamed from: b */
    public void mo40982b(byte[] bArr) throws TTransportException {
        mo40956c(bArr, 0, bArr.length);
    }
}
