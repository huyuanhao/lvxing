package com.bytedance.sdk.p145a.p147b.p148a.p153e;

import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p146a.BufferedSink;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.bytedance.sdk.a.b.a.e.j */
final class Http2Writer implements Closeable {
    /* renamed from: b */
    private static final Logger f5632b = Logger.getLogger(Http2.class.getName());
    /* renamed from: a */
    final C1889b f5633a = new C1889b(this.f5636e);
    /* renamed from: c */
    private final BufferedSink f5634c;
    /* renamed from: d */
    private final boolean f5635d;
    /* renamed from: e */
    private final Buffer f5636e = new Buffer();
    /* renamed from: f */
    private int f5637f = 16384;
    /* renamed from: g */
    private boolean f5638g;

    Http2Writer(BufferedSink dVar, boolean z) {
        this.f5634c = dVar;
        this.f5635d = z;
    }

    /* renamed from: a */
    public synchronized void mo13829a() throws IOException {
        if (this.f5638g) {
            throw new IOException("closed");
        } else if (this.f5635d) {
            if (f5632b.isLoggable(Level.FINE)) {
                f5632b.fine(C1876c.m6955a(">> CONNECTION %s", Http2.f5510a.mo13597e()));
            }
            this.f5634c.mo13537c(Http2.f5510a.mo13601h());
            this.f5634c.flush();
        }
    }

    /* renamed from: a */
    public synchronized void mo13836a(Settings nVar) throws IOException {
        if (!this.f5638g) {
            this.f5637f = nVar.mo13864d(this.f5637f);
            if (nVar.mo13861c() != -1) {
                this.f5633a.mo13765a(nVar.mo13861c());
            }
            mo13831a(0, 0, 4, 1);
            this.f5634c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo13832a(int i, int i2, List<Header> list) throws IOException {
        if (!this.f5638g) {
            this.f5633a.mo13768a(list);
            long b = this.f5636e.mo13530b();
            int min = (int) Math.min((long) (this.f5637f - 4), b);
            long j = (long) min;
            int i3 = (b > j ? 1 : (b == j ? 0 : -1));
            mo13831a(i, min + 4, 5, i3 == 0 ? (byte) 4 : 0);
            this.f5634c.mo13552g(i2 & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.f5634c.mo13507a_(this.f5636e, j);
            if (i3 > 0) {
                m7210b(i, b - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public synchronized void mo13841b() throws IOException {
        if (!this.f5638g) {
            this.f5634c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo13838a(boolean z, int i, int i2, List<Header> list) throws IOException {
        if (!this.f5638g) {
            mo13840a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo13834a(int i, ErrorCode bVar) throws IOException {
        if (this.f5638g) {
            throw new IOException("closed");
        } else if (bVar.f5480g != -1) {
            mo13831a(i, 4, 3, 0);
            this.f5634c.mo13552g(bVar.f5480g);
            this.f5634c.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: c */
    public int mo13843c() {
        return this.f5637f;
    }

    /* renamed from: a */
    public synchronized void mo13839a(boolean z, int i, Buffer cVar, int i2) throws IOException {
        if (!this.f5638g) {
            byte b = 0;
            if (z) {
                b = (byte) 1;
            }
            mo13830a(i, b, cVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13830a(int i, byte b, Buffer cVar, int i2) throws IOException {
        mo13831a(i, i2, 0, b);
        if (i2 > 0) {
            this.f5634c.mo13507a_(cVar, (long) i2);
        }
    }

    /* renamed from: b */
    public synchronized void mo13842b(Settings nVar) throws IOException {
        if (!this.f5638g) {
            int i = 0;
            mo13831a(0, nVar.mo13859b() * 6, 4, 0);
            while (i < 10) {
                if (nVar.mo13858a(i)) {
                    int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                    this.f5634c.mo13555h(i2);
                    this.f5634c.mo13552g(nVar.mo13860b(i));
                }
                i++;
            }
            this.f5634c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo13837a(boolean z, int i, int i2) throws IOException {
        if (!this.f5638g) {
            mo13831a(0, 8, 6, z ? (byte) 1 : 0);
            this.f5634c.mo13552g(i);
            this.f5634c.mo13552g(i2);
            this.f5634c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo13835a(int i, ErrorCode bVar, byte[] bArr) throws IOException {
        if (this.f5638g) {
            throw new IOException("closed");
        } else if (bVar.f5480g != -1) {
            mo13831a(0, bArr.length + 8, 7, 0);
            this.f5634c.mo13552g(i);
            this.f5634c.mo13552g(bVar.f5480g);
            if (bArr.length > 0) {
                this.f5634c.mo13537c(bArr);
            }
            this.f5634c.flush();
        } else {
            throw Http2.m7085a("errorCode.httpCode == -1", new Object[0]);
        }
    }

    /* renamed from: a */
    public synchronized void mo13833a(int i, long j) throws IOException {
        if (this.f5638g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw Http2.m7085a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            mo13831a(i, 4, 8, 0);
            this.f5634c.mo13552g((int) j);
            this.f5634c.flush();
        }
    }

    /* renamed from: a */
    public void mo13831a(int i, int i2, byte b, byte b2) throws IOException {
        if (f5632b.isLoggable(Level.FINE)) {
            f5632b.fine(Http2.m7087a(false, i, i2, b, b2));
        }
        int i3 = this.f5637f;
        if (i2 > i3) {
            throw Http2.m7085a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) == 0) {
            m7209a(this.f5634c, i2);
            this.f5634c.mo13559i(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            this.f5634c.mo13559i(b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            this.f5634c.mo13552g(i & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        } else {
            throw Http2.m7085a("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    public synchronized void close() throws IOException {
        this.f5638g = true;
        this.f5634c.close();
    }

    /* renamed from: a */
    private static void m7209a(BufferedSink dVar, int i) throws IOException {
        dVar.mo13559i((i >>> 16) & 255);
        dVar.mo13559i((i >>> 8) & 255);
        dVar.mo13559i(i & 255);
    }

    /* renamed from: b */
    private void m7210b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f5637f, j);
            long j2 = (long) min;
            j -= j2;
            mo13831a(i, min, 9, j == 0 ? (byte) 4 : 0);
            this.f5634c.mo13507a_(this.f5636e, j2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13840a(boolean z, int i, List<Header> list) throws IOException {
        if (!this.f5638g) {
            this.f5633a.mo13768a(list);
            long b = this.f5636e.mo13530b();
            int min = (int) Math.min((long) this.f5637f, b);
            long j = (long) min;
            int i2 = (b > j ? 1 : (b == j ? 0 : -1));
            byte b2 = i2 == 0 ? (byte) 4 : 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            mo13831a(i, min, 1, b2);
            this.f5634c.mo13507a_(this.f5636e, j);
            if (i2 > 0) {
                m7210b(i, b - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
