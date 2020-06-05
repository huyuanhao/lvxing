package org.apache.thrift.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.slf4j.C8580b;
import org.slf4j.LoggerFactory;

/* renamed from: org.apache.thrift.transport.b */
public class TIOStreamTransport extends TTransport {
    /* renamed from: c */
    private static final C8580b f29190c = LoggerFactory.m37316a(TIOStreamTransport.class.getName());
    /* renamed from: a */
    protected InputStream f29191a = null;
    /* renamed from: b */
    protected OutputStream f29192b = null;

    /* renamed from: a */
    public boolean mo40953a() {
        return true;
    }

    /* renamed from: f */
    public void mo40978f() throws TTransportException {
    }

    protected TIOStreamTransport() {
    }

    public void close() {
        InputStream inputStream = this.f29191a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                f29190c.warn("Error closing input stream.", (Throwable) e);
            }
            this.f29191a = null;
        }
        OutputStream outputStream = this.f29192b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                f29190c.warn("Error closing output stream.", (Throwable) e2);
            }
            this.f29192b = null;
        }
    }

    /* renamed from: b */
    public int mo40954b(byte[] bArr, int i, int i2) throws TTransportException {
        InputStream inputStream = this.f29191a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new TTransportException(4);
            } catch (IOException e) {
                throw new TTransportException(0, (Throwable) e);
            }
        } else {
            throw new TTransportException(1, "Cannot read from null inputStream");
        }
    }

    /* renamed from: c */
    public void mo40956c(byte[] bArr, int i, int i2) throws TTransportException {
        OutputStream outputStream = this.f29192b;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
            } catch (IOException e) {
                throw new TTransportException(0, (Throwable) e);
            }
        } else {
            throw new TTransportException(1, "Cannot write to null outputStream");
        }
    }

    /* renamed from: b */
    public void mo40955b() throws TTransportException {
        OutputStream outputStream = this.f29192b;
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
                throw new TTransportException(0, (Throwable) e);
            }
        } else {
            throw new TTransportException(1, "Cannot flush null outputStream");
        }
    }
}
