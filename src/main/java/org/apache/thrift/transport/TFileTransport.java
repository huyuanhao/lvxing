package org.apache.thrift.transport;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class TFileTransport extends TTransport {
    /* renamed from: a */
    TailPolicy f29163a;
    /* renamed from: b */
    protected TSeekableFile f29164b;
    /* renamed from: c */
    protected OutputStream f29165c;
    /* renamed from: d */
    C8574b f29166d;
    /* renamed from: e */
    InputStream f29167e;
    /* renamed from: f */
    C8573a f29168f;
    /* renamed from: g */
    private boolean f29169g;

    /* renamed from: org.apache.thrift.transport.TFileTransport$TailPolicy */
    public enum TailPolicy {
        NOWAIT(0, 0),
        WAIT_FOREVER(500, -1);
        
        public final int retries_;
        public final int timeout_;

        private TailPolicy(int i, int i2) {
            this.timeout_ = i;
            this.retries_ = i2;
        }
    }

    /* renamed from: org.apache.thrift.transport.TFileTransport$a */
    public static class C8573a {
        /* renamed from: a */
        private int f29170a;
        /* renamed from: b */
        private long f29171b;

        /* renamed from: a */
        public void mo40959a(int i) {
            this.f29171b += (long) i;
        }

        /* renamed from: a */
        public int mo40958a() {
            int i = this.f29170a;
            return i - ((int) (this.f29171b % ((long) i)));
        }
    }

    /* renamed from: org.apache.thrift.transport.TFileTransport$b */
    public static class C8574b {
        /* renamed from: a */
        private byte[] f29172a;
        /* renamed from: b */
        private int f29173b = 0;
        /* renamed from: c */
        private int f29174c = 0;

        public C8574b(byte[] bArr) {
            this.f29172a = bArr;
        }

        /* renamed from: a */
        public byte[] mo40962a() {
            return this.f29172a;
        }

        /* renamed from: b */
        public int mo40963b() {
            return this.f29172a.length;
        }

        /* renamed from: a */
        public void mo40961a(int i) {
            this.f29173b = 0;
            this.f29174c = i;
        }

        /* renamed from: c */
        public int mo40964c() {
            return this.f29174c - this.f29173b;
        }

        /* renamed from: a */
        public int mo40960a(byte[] bArr, int i, int i2) {
            if (i2 == 0 || i2 > mo40964c()) {
                i2 = mo40964c();
            }
            if (i2 <= 0) {
                return i2;
            }
            System.arraycopy(this.f29172a, this.f29173b, bArr, i, i2);
            this.f29173b += i2;
            return i2;
        }
    }

    /* renamed from: a */
    private int m37233a(InputStream inputStream, byte[] bArr, int i, int i2, TailPolicy tailPolicy) throws TTransportException {
        int i3 = i;
        int i4 = i2;
        while (true) {
            int i5 = 0;
            while (i4 > 0) {
                try {
                    int read = inputStream.read(bArr, i3, i4);
                    if (read > 0) {
                        i3 += read;
                        i4 -= read;
                        this.f29168f.mo40959a(read);
                    } else if (read == -1) {
                        i5++;
                        if (tailPolicy.retries_ != -1 && tailPolicy.retries_ < i5) {
                            return i2 - i4;
                        }
                        if (tailPolicy.timeout_ > 0) {
                            try {
                                Thread.sleep((long) tailPolicy.timeout_);
                            } catch (InterruptedException unused) {
                            }
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected return from InputStream.read = ");
                        sb.append(read);
                        throw new TTransportException(sb.toString());
                    }
                } catch (IOException e) {
                    throw new TTransportException(e.getMessage(), (Throwable) e);
                }
            }
            return i2 - i4;
        }
    }

    /* renamed from: f */
    private boolean m37234f() throws TTransportException {
        int i;
        byte[] bArr = new byte[4];
        do {
            int a = this.f29168f.mo40958a();
            if (a < 4) {
                if (m37233a(this.f29167e, bArr, 0, a, this.f29163a) != a) {
                    return false;
                }
            }
            if (m37233a(this.f29167e, bArr, 0, 4, this.f29163a) != 4) {
                return false;
            }
            i = 0;
            for (int i2 = 3; i2 >= 0; i2--) {
                i |= (bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << (i2 * 8);
            }
            if (i > this.f29168f.mo40958a()) {
                throw new TTransportException("FileTransport error: bad event size");
            }
        } while (i == 0);
        if (this.f29166d.mo40963b() < i) {
            this.f29166d = new C8574b(new byte[i]);
        }
        if (m37233a(this.f29167e, this.f29166d.mo40962a(), 0, i, this.f29163a) != i) {
            return false;
        }
        this.f29166d.mo40961a(i);
        return true;
    }

    /* renamed from: a */
    public boolean mo40953a() {
        return this.f29167e != null && (this.f29169g || this.f29165c != null);
    }

    public void close() {
        TSeekableFile dVar = this.f29164b;
        if (dVar != null) {
            try {
                dVar.mo40981a();
            } catch (IOException e) {
                PrintStream printStream = System.err;
                StringBuilder sb = new StringBuilder();
                sb.append("WARNING: Error closing input file: ");
                sb.append(e.getMessage());
                printStream.println(sb.toString());
            }
            this.f29164b = null;
        }
        OutputStream outputStream = this.f29165c;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                PrintStream printStream2 = System.err;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("WARNING: Error closing output stream: ");
                sb2.append(e2.getMessage());
                printStream2.println(sb2.toString());
            }
            this.f29165c = null;
        }
    }

    /* renamed from: a */
    public int mo40952a(byte[] bArr, int i, int i2) throws TTransportException {
        int i3 = 0;
        while (i3 < i2) {
            int b = mo40954b(bArr, i + i3, i2 - i3);
            if (b < 0) {
                throw new TTransportException("Error in reading from file");
            } else if (b != 0) {
                i3 += b;
            } else {
                throw new TTransportException(4, "End of File reached");
            }
        }
        return i3;
    }

    /* renamed from: b */
    public int mo40954b(byte[] bArr, int i, int i2) throws TTransportException {
        if (!mo40953a()) {
            throw new TTransportException(1, "Must open before reading");
        } else if (this.f29166d.mo40964c() != 0 || m37234f()) {
            return this.f29166d.mo40960a(bArr, i, i2);
        } else {
            return 0;
        }
    }

    /* renamed from: c */
    public void mo40956c(byte[] bArr, int i, int i2) throws TTransportException {
        throw new TTransportException("Not Supported");
    }

    /* renamed from: b */
    public void mo40955b() throws TTransportException {
        throw new TTransportException("Not Supported");
    }
}
