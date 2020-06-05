package okhttp3.internal.http2;

import com.tencent.android.tpush.common.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.C8417c;
import okio.ByteString;
import okio.C8525c;
import okio.C8529e;
import okio.C8547r;
import okio.C8548s;

/* compiled from: Http2Reader */
/* renamed from: okhttp3.internal.http2.f */
final class C8475f implements Closeable {
    /* renamed from: a */
    static final Logger f28766a = Logger.getLogger(C8457c.class.getName());
    /* renamed from: b */
    final C8455a f28767b = new C8455a(4096, this.f28769d);
    /* renamed from: c */
    private final C8529e f28768c;
    /* renamed from: d */
    private final C8476a f28769d = new C8476a(this.f28768c);
    /* renamed from: e */
    private final boolean f28770e;

    /* compiled from: Http2Reader */
    /* renamed from: okhttp3.internal.http2.f$a */
    static final class C8476a implements C8547r {
        /* renamed from: a */
        int f28771a;
        /* renamed from: b */
        byte f28772b;
        /* renamed from: c */
        int f28773c;
        /* renamed from: d */
        int f28774d;
        /* renamed from: e */
        short f28775e;
        /* renamed from: f */
        private final C8529e f28776f;

        public void close() throws IOException {
        }

        C8476a(C8529e eVar) {
            this.f28776f = eVar;
        }

        /* renamed from: a */
        public long mo40202a(C8525c cVar, long j) throws IOException {
            while (true) {
                int i = this.f28774d;
                if (i == 0) {
                    this.f28776f.mo40761h((long) this.f28775e);
                    this.f28775e = 0;
                    if ((this.f28772b & 4) != 0) {
                        return -1;
                    }
                    m36339b();
                } else {
                    long a = this.f28776f.mo40202a(cVar, Math.min(j, (long) i));
                    if (a == -1) {
                        return -1;
                    }
                    this.f28774d = (int) (((long) this.f28774d) - a);
                    return a;
                }
            }
        }

        /* renamed from: a */
        public C8548s mo40203a() {
            return this.f28776f.mo40203a();
        }

        /* renamed from: b */
        private void m36339b() throws IOException {
            int i = this.f28773c;
            int a = C8475f.m36325a(this.f28776f);
            this.f28774d = a;
            this.f28771a = a;
            byte i2 = (byte) (this.f28776f.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            this.f28772b = (byte) (this.f28776f.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (C8475f.f28766a.isLoggable(Level.FINE)) {
                C8475f.f28766a.fine(C8457c.m36254a(true, this.f28773c, this.f28771a, i2, this.f28772b));
            }
            this.f28773c = this.f28776f.mo40769k() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (i2 != 9) {
                throw C8457c.m36255b("%s != TYPE_CONTINUATION", Byte.valueOf(i2));
            } else if (this.f28773c != i) {
                throw C8457c.m36255b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* compiled from: Http2Reader */
    /* renamed from: okhttp3.internal.http2.f$b */
    interface C8477b {
        /* renamed from: a */
        void mo40391a();

        /* renamed from: a */
        void mo40392a(int i, int i2, int i3, boolean z);

        /* renamed from: a */
        void mo40393a(int i, int i2, List<C8453a> list) throws IOException;

        /* renamed from: a */
        void mo40394a(int i, long j);

        /* renamed from: a */
        void mo40395a(int i, ErrorCode errorCode);

        /* renamed from: a */
        void mo40396a(int i, ErrorCode errorCode, ByteString byteString);

        /* renamed from: a */
        void mo40397a(boolean z, int i, int i2);

        /* renamed from: a */
        void mo40398a(boolean z, int i, int i2, List<C8453a> list);

        /* renamed from: a */
        void mo40399a(boolean z, int i, C8529e eVar, int i2) throws IOException;

        /* renamed from: a */
        void mo40400a(boolean z, C8487k kVar);
    }

    C8475f(C8529e eVar, boolean z) {
        this.f28768c = eVar;
        this.f28770e = z;
    }

    /* renamed from: a */
    public void mo40401a(C8477b bVar) throws IOException {
        if (!this.f28770e) {
            ByteString c = this.f28768c.mo40740c((long) C8457c.f28681a.size());
            if (f28766a.isLoggable(Level.FINE)) {
                f28766a.fine(C8417c.m36030a("<< CONNECTION %s", c.hex()));
            }
            if (!C8457c.f28681a.equals(c)) {
                throw C8457c.m36255b("Expected a connection header but was %s", c.utf8());
            }
        } else if (!mo40402a(true, bVar)) {
            throw C8457c.m36255b("Required SETTINGS preface not received", new Object[0]);
        }
    }

    /* renamed from: a */
    public boolean mo40402a(boolean z, C8477b bVar) throws IOException {
        try {
            this.f28768c.mo40729a(9);
            int a = m36325a(this.f28768c);
            if (a < 0 || a > 16384) {
                throw C8457c.m36255b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
            }
            byte i = (byte) (this.f28768c.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (!z || i == 4) {
                byte i2 = (byte) (this.f28768c.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
                int k = this.f28768c.mo40769k() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                if (f28766a.isLoggable(Level.FINE)) {
                    f28766a.fine(C8457c.m36254a(true, k, a, i, i2));
                }
                switch (i) {
                    case 0:
                        m36329b(bVar, a, i2, k);
                        break;
                    case 1:
                        m36328a(bVar, a, i2, k);
                        break;
                    case 2:
                        m36330c(bVar, a, i2, k);
                        break;
                    case 3:
                        m36331d(bVar, a, i2, k);
                        break;
                    case 4:
                        m36332e(bVar, a, i2, k);
                        break;
                    case 5:
                        m36333f(bVar, a, i2, k);
                        break;
                    case 6:
                        m36334g(bVar, a, i2, k);
                        break;
                    case 7:
                        m36335h(bVar, a, i2, k);
                        break;
                    case 8:
                        m36336i(bVar, a, i2, k);
                        break;
                    default:
                        this.f28768c.mo40761h((long) a);
                        break;
                }
                return true;
            }
            throw C8457c.m36255b("Expected a SETTINGS frame but was %s", Byte.valueOf(i));
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m36328a(C8477b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.f28768c.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            }
            if ((b & 32) != 0) {
                m36327a(bVar, i2);
                i -= 5;
            }
            bVar.mo40398a(z, i2, -1, m36326a(m36324a(i, b, s), s, b, i2));
            return;
        }
        throw C8457c.m36255b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    /* renamed from: a */
    private List<C8453a> m36326a(int i, short s, byte b, int i2) throws IOException {
        C8476a aVar = this.f28769d;
        aVar.f28774d = i;
        aVar.f28771a = i;
        aVar.f28775e = s;
        aVar.f28772b = b;
        aVar.f28773c = i2;
        this.f28767b.mo40358a();
        return this.f28767b.mo40359b();
    }

    /* renamed from: b */
    private void m36329b(C8477b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.f28768c.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
                }
                bVar.mo40399a(z2, i2, this.f28768c, m36324a(i, b, s));
                this.f28768c.mo40761h((long) s);
                return;
            }
            throw C8457c.m36255b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw C8457c.m36255b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    /* renamed from: c */
    private void m36330c(C8477b bVar, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw C8457c.m36255b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 != 0) {
            m36327a(bVar, i2);
        } else {
            throw C8457c.m36255b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    /* renamed from: a */
    private void m36327a(C8477b bVar, int i) throws IOException {
        int k = this.f28768c.mo40769k();
        bVar.mo40392a(i, k & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, (this.f28768c.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + 1, (Integer.MIN_VALUE & k) != 0);
    }

    /* renamed from: d */
    private void m36331d(C8477b bVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw C8457c.m36255b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 != 0) {
            int k = this.f28768c.mo40769k();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(k);
            if (fromHttp2 != null) {
                bVar.mo40395a(i2, fromHttp2);
            } else {
                throw C8457c.m36255b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(k));
            }
        } else {
            throw C8457c.m36255b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    /* renamed from: e */
    private void m36332e(C8477b bVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw C8457c.m36255b("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b & 1) != 0) {
            if (i == 0) {
                bVar.mo40391a();
            } else {
                throw C8457c.m36255b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
        } else if (i % 6 == 0) {
            C8487k kVar = new C8487k();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short j = this.f28768c.mo40768j() & Constants.PROTOCOL_NONE;
                int k = this.f28768c.mo40769k();
                switch (j) {
                    case 2:
                        if (!(k == 0 || k == 1)) {
                            throw C8457c.m36255b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                    case 3:
                        j = 4;
                        break;
                    case 4:
                        j = 7;
                        if (k >= 0) {
                            break;
                        } else {
                            throw C8457c.m36255b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    case 5:
                        if (k >= 16384 && k <= 16777215) {
                            break;
                        } else {
                            throw C8457c.m36255b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(k));
                        }
                        break;
                }
                kVar.mo40449a(j, k);
            }
            bVar.mo40400a(false, kVar);
        } else {
            throw C8457c.m36255b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
    }

    /* renamed from: f */
    private void m36333f(C8477b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.f28768c.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            }
            bVar.mo40393a(i2, this.f28768c.mo40769k() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, m36326a(m36324a(i - 4, b, s), s, b, i2));
            return;
        }
        throw C8457c.m36255b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    /* renamed from: g */
    private void m36334g(C8477b bVar, int i, byte b, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            throw C8457c.m36255b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int k = this.f28768c.mo40769k();
            int k2 = this.f28768c.mo40769k();
            if ((b & 1) != 0) {
                z = true;
            }
            bVar.mo40397a(z, k, k2);
        } else {
            throw C8457c.m36255b("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    /* renamed from: h */
    private void m36335h(C8477b bVar, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw C8457c.m36255b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int k = this.f28768c.mo40769k();
            int k2 = this.f28768c.mo40769k();
            int i3 = i - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(k2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i3 > 0) {
                    byteString = this.f28768c.mo40740c((long) i3);
                }
                bVar.mo40396a(k, fromHttp2, byteString);
                return;
            }
            throw C8457c.m36255b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(k2));
        } else {
            throw C8457c.m36255b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    /* renamed from: i */
    private void m36336i(C8477b bVar, int i, byte b, int i2) throws IOException {
        if (i == 4) {
            long k = ((long) this.f28768c.mo40769k()) & 2147483647L;
            if (k != 0) {
                bVar.mo40394a(i2, k);
            } else {
                throw C8457c.m36255b("windowSizeIncrement was 0", Long.valueOf(k));
            }
        } else {
            throw C8457c.m36255b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
    }

    public void close() throws IOException {
        this.f28768c.close();
    }

    /* renamed from: a */
    static int m36325a(C8529e eVar) throws IOException {
        return (eVar.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((eVar.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((eVar.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
    }

    /* renamed from: a */
    static int m36324a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw C8457c.m36255b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
