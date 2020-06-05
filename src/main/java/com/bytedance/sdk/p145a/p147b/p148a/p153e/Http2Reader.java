package com.bytedance.sdk.p145a.p147b.p148a.p153e;

import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p146a.BufferedSource;
import com.bytedance.sdk.p145a.p146a.ByteString;
import com.bytedance.sdk.p145a.p146a.Source;
import com.bytedance.sdk.p145a.p146a.Timeout;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.bytedance.sdk.a.b.a.e.h */
final class Http2Reader implements Closeable {
    /* renamed from: a */
    static final Logger f5595a = Logger.getLogger(Http2.class.getName());
    /* renamed from: b */
    final C1888a f5596b = new C1888a(4096, this.f5598d);
    /* renamed from: c */
    private final BufferedSource f5597c;
    /* renamed from: d */
    private final C1905a f5598d = new C1905a(this.f5597c);
    /* renamed from: e */
    private final boolean f5599e;

    /* compiled from: Http2Reader */
    /* renamed from: com.bytedance.sdk.a.b.a.e.h$a */
    static final class C1905a implements Source {
        /* renamed from: a */
        int f5600a;
        /* renamed from: b */
        byte f5601b;
        /* renamed from: c */
        int f5602c;
        /* renamed from: d */
        int f5603d;
        /* renamed from: e */
        short f5604e;
        /* renamed from: f */
        private final BufferedSource f5605f;

        public void close() throws IOException {
        }

        C1905a(BufferedSource eVar) {
            this.f5605f = eVar;
        }

        /* renamed from: a */
        public long mo13511a(Buffer cVar, long j) throws IOException {
            while (true) {
                int i = this.f5603d;
                if (i == 0) {
                    this.f5605f.mo13556h((long) this.f5604e);
                    this.f5604e = 0;
                    if ((this.f5601b & 4) != 0) {
                        return -1;
                    }
                    m7166b();
                } else {
                    long a = this.f5605f.mo13511a(cVar, Math.min(j, (long) i));
                    if (a == -1) {
                        return -1;
                    }
                    this.f5603d = (int) (((long) this.f5603d) - a);
                    return a;
                }
            }
        }

        /* renamed from: a */
        public Timeout mo13512a() {
            return this.f5605f.mo13512a();
        }

        /* renamed from: b */
        private void m7166b() throws IOException {
            int i = this.f5602c;
            int a = Http2Reader.m7152a(this.f5605f);
            this.f5603d = a;
            this.f5600a = a;
            byte h = (byte) (this.f5605f.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            this.f5601b = (byte) (this.f5605f.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (Http2Reader.f5595a.isLoggable(Level.FINE)) {
                Http2Reader.f5595a.fine(Http2.m7087a(true, this.f5602c, this.f5600a, h, this.f5601b));
            }
            this.f5602c = this.f5605f.mo13562j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (h != 9) {
                throw Http2.m7088b("%s != TYPE_CONTINUATION", Byte.valueOf(h));
            } else if (this.f5602c != i) {
                throw Http2.m7088b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* compiled from: Http2Reader */
    /* renamed from: com.bytedance.sdk.a.b.a.e.h$b */
    interface C1906b {
        /* renamed from: a */
        void mo13796a(int i, int i2, int i3, boolean z);

        /* renamed from: a */
        void mo13797a(int i, int i2, List<Header> list) throws IOException;

        /* renamed from: a */
        void mo13798a(int i, long j);

        /* renamed from: a */
        void mo13799a(int i, ErrorCode bVar);

        /* renamed from: a */
        void mo13800a(int i, ErrorCode bVar, ByteString fVar);

        /* renamed from: a */
        void mo13801a(boolean z, int i, int i2);

        /* renamed from: a */
        void mo13802a(boolean z, int i, int i2, List<Header> list);

        /* renamed from: a */
        void mo13803a(boolean z, int i, BufferedSource eVar, int i2) throws IOException;

        /* renamed from: a */
        void mo13804a(boolean z, Settings nVar);

        /* renamed from: b */
        void mo13805b();
    }

    Http2Reader(BufferedSource eVar, boolean z) {
        this.f5597c = eVar;
        this.f5599e = z;
    }

    /* renamed from: a */
    public void mo13806a(C1906b bVar) throws IOException {
        if (!this.f5599e) {
            ByteString c = this.f5597c.mo13539c((long) Http2.f5510a.mo13600g());
            if (f5595a.isLoggable(Level.FINE)) {
                f5595a.fine(C1876c.m6955a("<< CONNECTION %s", c.mo13597e()));
            }
            if (!Http2.f5510a.equals(c)) {
                throw Http2.m7088b("Expected a connection header but was %s", c.mo13587a());
            }
        } else if (!mo13807a(true, bVar)) {
            throw Http2.m7088b("Required SETTINGS preface not received", new Object[0]);
        }
    }

    /* renamed from: a */
    public boolean mo13807a(boolean z, C1906b bVar) throws IOException {
        try {
            this.f5597c.mo13527a(9);
            int a = m7152a(this.f5597c);
            if (a < 0 || a > 16384) {
                throw Http2.m7088b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
            }
            byte h = (byte) (this.f5597c.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (!z || h == 4) {
                byte h2 = (byte) (this.f5597c.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
                int j = this.f5597c.mo13562j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                if (f5595a.isLoggable(Level.FINE)) {
                    f5595a.fine(Http2.m7087a(true, j, a, h, h2));
                }
                switch (h) {
                    case 0:
                        m7156b(bVar, a, h2, j);
                        break;
                    case 1:
                        m7155a(bVar, a, h2, j);
                        break;
                    case 2:
                        m7157c(bVar, a, h2, j);
                        break;
                    case 3:
                        m7158d(bVar, a, h2, j);
                        break;
                    case 4:
                        m7159e(bVar, a, h2, j);
                        break;
                    case 5:
                        m7160f(bVar, a, h2, j);
                        break;
                    case 6:
                        m7161g(bVar, a, h2, j);
                        break;
                    case 7:
                        m7162h(bVar, a, h2, j);
                        break;
                    case 8:
                        m7163i(bVar, a, h2, j);
                        break;
                    default:
                        this.f5597c.mo13556h((long) a);
                        break;
                }
                return true;
            }
            throw Http2.m7088b("Expected a SETTINGS frame but was %s", Byte.valueOf(h));
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m7155a(C1906b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.f5597c.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            }
            if ((b & 32) != 0) {
                m7154a(bVar, i2);
                i -= 5;
            }
            bVar.mo13802a(z, i2, -1, m7153a(m7151a(i, b, s), s, b, i2));
            return;
        }
        throw Http2.m7088b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    /* renamed from: a */
    private List<Header> m7153a(int i, short s, byte b, int i2) throws IOException {
        C1905a aVar = this.f5598d;
        aVar.f5603d = i;
        aVar.f5600a = i;
        aVar.f5604e = s;
        aVar.f5601b = b;
        aVar.f5602c = i2;
        this.f5596b.mo13762a();
        return this.f5596b.mo13763b();
    }

    /* renamed from: b */
    private void m7156b(C1906b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.f5597c.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
                }
                bVar.mo13803a(z2, i2, this.f5597c, m7151a(i, b, s));
                this.f5597c.mo13556h((long) s);
                return;
            }
            throw Http2.m7088b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw Http2.m7088b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    /* renamed from: c */
    private void m7157c(C1906b bVar, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw Http2.m7088b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 != 0) {
            m7154a(bVar, i2);
        } else {
            throw Http2.m7088b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    /* renamed from: a */
    private void m7154a(C1906b bVar, int i) throws IOException {
        int j = this.f5597c.mo13562j();
        bVar.mo13796a(i, j & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, (this.f5597c.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + 1, (Integer.MIN_VALUE & j) != 0);
    }

    /* renamed from: d */
    private void m7158d(C1906b bVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.m7088b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 != 0) {
            int j = this.f5597c.mo13562j();
            ErrorCode a = ErrorCode.m7057a(j);
            if (a != null) {
                bVar.mo13799a(i2, a);
            } else {
                throw Http2.m7088b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(j));
            }
        } else {
            throw Http2.m7088b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    /* renamed from: e */
    private void m7159e(C1906b bVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw Http2.m7088b("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b & 1) != 0) {
            if (i == 0) {
                bVar.mo13805b();
            } else {
                throw Http2.m7088b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
        } else if (i % 6 == 0) {
            Settings nVar = new Settings();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short i4 = this.f5597c.mo13560i();
                int j = this.f5597c.mo13562j();
                switch (i4) {
                    case 2:
                        if (!(j == 0 || j == 1)) {
                            throw Http2.m7088b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                    case 3:
                        i4 = 4;
                        break;
                    case 4:
                        i4 = 7;
                        if (j >= 0) {
                            break;
                        } else {
                            throw Http2.m7088b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    case 5:
                        if (j >= 16384 && j <= 16777215) {
                            break;
                        } else {
                            throw Http2.m7088b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(j));
                        }
                        break;
                }
                nVar.mo13855a(i4, j);
            }
            bVar.mo13804a(false, nVar);
        } else {
            throw Http2.m7088b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
    }

    /* renamed from: f */
    private void m7160f(C1906b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.f5597c.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            }
            bVar.mo13797a(i2, this.f5597c.mo13562j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, m7153a(m7151a(i - 4, b, s), s, b, i2));
            return;
        }
        throw Http2.m7088b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    /* renamed from: g */
    private void m7161g(C1906b bVar, int i, byte b, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            throw Http2.m7088b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int j = this.f5597c.mo13562j();
            int j2 = this.f5597c.mo13562j();
            if ((b & 1) != 0) {
                z = true;
            }
            bVar.mo13801a(z, j, j2);
        } else {
            throw Http2.m7088b("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    /* renamed from: h */
    private void m7162h(C1906b bVar, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw Http2.m7088b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int j = this.f5597c.mo13562j();
            int j2 = this.f5597c.mo13562j();
            int i3 = i - 8;
            ErrorCode a = ErrorCode.m7057a(j2);
            if (a != null) {
                ByteString fVar = ByteString.f5246b;
                if (i3 > 0) {
                    fVar = this.f5597c.mo13539c((long) i3);
                }
                bVar.mo13800a(j, a, fVar);
                return;
            }
            throw Http2.m7088b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(j2));
        } else {
            throw Http2.m7088b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    /* renamed from: i */
    private void m7163i(C1906b bVar, int i, byte b, int i2) throws IOException {
        if (i == 4) {
            long j = ((long) this.f5597c.mo13562j()) & 2147483647L;
            if (j != 0) {
                bVar.mo13798a(i2, j);
            } else {
                throw Http2.m7088b("windowSizeIncrement was 0", Long.valueOf(j));
            }
        } else {
            throw Http2.m7088b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
    }

    public void close() throws IOException {
        this.f5597c.close();
    }

    /* renamed from: a */
    static int m7152a(BufferedSource eVar) throws IOException {
        return (eVar.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((eVar.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((eVar.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
    }

    /* renamed from: a */
    static int m7151a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw Http2.m7088b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
