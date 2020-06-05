package okhttp3.internal.http2;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.C8417c;
import okio.C8525c;
import okio.C8528d;

/* compiled from: Http2Writer */
/* renamed from: okhttp3.internal.http2.h */
final class C8482h implements Closeable {
    /* renamed from: b */
    private static final Logger f28803b = Logger.getLogger(C8457c.class.getName());
    /* renamed from: a */
    final C8456b f28804a = new C8456b(this.f28807e);
    /* renamed from: c */
    private final C8528d f28805c;
    /* renamed from: d */
    private final boolean f28806d;
    /* renamed from: e */
    private final C8525c f28807e = new C8525c();
    /* renamed from: f */
    private int f28808f = 16384;
    /* renamed from: g */
    private boolean f28809g;

    C8482h(C8528d dVar, boolean z) {
        this.f28805c = dVar;
        this.f28806d = z;
    }

    /* renamed from: a */
    public synchronized void mo40426a() throws IOException {
        if (this.f28809g) {
            throw new IOException("closed");
        } else if (this.f28806d) {
            if (f28803b.isLoggable(Level.FINE)) {
                f28803b.fine(C8417c.m36030a(">> CONNECTION %s", C8457c.f28681a.hex()));
            }
            this.f28805c.mo40743c(C8457c.f28681a.toByteArray());
            this.f28805c.flush();
        }
    }

    /* renamed from: a */
    public synchronized void mo40433a(C8487k kVar) throws IOException {
        if (!this.f28809g) {
            this.f28808f = kVar.mo40458d(this.f28808f);
            if (kVar.mo40455c() != -1) {
                this.f28804a.mo40361a(kVar.mo40455c());
            }
            mo40428a(0, 0, 4, 1);
            this.f28805c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo40429a(int i, int i2, List<C8453a> list) throws IOException {
        if (!this.f28809g) {
            this.f28804a.mo40363a(list);
            long b = this.f28807e.mo40734b();
            int min = (int) Math.min((long) (this.f28808f - 4), b);
            long j = (long) min;
            int i3 = (b > j ? 1 : (b == j ? 0 : -1));
            mo40428a(i, min + 4, 5, i3 == 0 ? (byte) 4 : 0);
            this.f28805c.mo40757g(i2 & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.f28805c.mo40231a_(this.f28807e, j);
            if (i3 > 0) {
                m36383b(i, b - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public synchronized void mo40438b() throws IOException {
        if (!this.f28809g) {
            this.f28805c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo40435a(boolean z, int i, int i2, List<C8453a> list) throws IOException {
        if (!this.f28809g) {
            mo40436a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo40431a(int i, ErrorCode errorCode) throws IOException {
        if (this.f28809g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            mo40428a(i, 4, 3, 0);
            this.f28805c.mo40757g(errorCode.httpCode);
            this.f28805c.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: c */
    public int mo40440c() {
        return this.f28808f;
    }

    /* renamed from: a */
    public synchronized void mo40437a(boolean z, int i, C8525c cVar, int i2) throws IOException {
        if (!this.f28809g) {
            byte b = 0;
            if (z) {
                b = (byte) 1;
            }
            mo40427a(i, b, cVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40427a(int i, byte b, C8525c cVar, int i2) throws IOException {
        mo40428a(i, i2, 0, b);
        if (i2 > 0) {
            this.f28805c.mo40231a_(cVar, (long) i2);
        }
    }

    /* renamed from: b */
    public synchronized void mo40439b(C8487k kVar) throws IOException {
        if (!this.f28809g) {
            int i = 0;
            mo40428a(0, kVar.mo40453b() * 6, 4, 0);
            while (i < 10) {
                if (kVar.mo40452a(i)) {
                    int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                    this.f28805c.mo40760h(i2);
                    this.f28805c.mo40757g(kVar.mo40454b(i));
                }
                i++;
            }
            this.f28805c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo40434a(boolean z, int i, int i2) throws IOException {
        if (!this.f28809g) {
            mo40428a(0, 8, 6, z ? (byte) 1 : 0);
            this.f28805c.mo40757g(i);
            this.f28805c.mo40757g(i2);
            this.f28805c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo40432a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f28809g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            mo40428a(0, bArr.length + 8, 7, 0);
            this.f28805c.mo40757g(i);
            this.f28805c.mo40757g(errorCode.httpCode);
            if (bArr.length > 0) {
                this.f28805c.mo40743c(bArr);
            }
            this.f28805c.flush();
        } else {
            throw C8457c.m36252a("errorCode.httpCode == -1", new Object[0]);
        }
    }

    /* renamed from: a */
    public synchronized void mo40430a(int i, long j) throws IOException {
        if (this.f28809g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw C8457c.m36252a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            mo40428a(i, 4, 8, 0);
            this.f28805c.mo40757g((int) j);
            this.f28805c.flush();
        }
    }

    /* renamed from: a */
    public void mo40428a(int i, int i2, byte b, byte b2) throws IOException {
        if (f28803b.isLoggable(Level.FINE)) {
            f28803b.fine(C8457c.m36254a(false, i, i2, b, b2));
        }
        int i3 = this.f28808f;
        if (i2 > i3) {
            throw C8457c.m36252a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) == 0) {
            m36382a(this.f28805c, i2);
            this.f28805c.mo40765i(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            this.f28805c.mo40765i(b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            this.f28805c.mo40757g(i & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        } else {
            throw C8457c.m36252a("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    public synchronized void close() throws IOException {
        this.f28809g = true;
        this.f28805c.close();
    }

    /* renamed from: a */
    private static void m36382a(C8528d dVar, int i) throws IOException {
        dVar.mo40765i((i >>> 16) & 255);
        dVar.mo40765i((i >>> 8) & 255);
        dVar.mo40765i(i & 255);
    }

    /* renamed from: b */
    private void m36383b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f28808f, j);
            long j2 = (long) min;
            j -= j2;
            mo40428a(i, min, 9, j == 0 ? (byte) 4 : 0);
            this.f28805c.mo40231a_(this.f28807e, j2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40436a(boolean z, int i, List<C8453a> list) throws IOException {
        if (!this.f28809g) {
            this.f28804a.mo40363a(list);
            long b = this.f28807e.mo40734b();
            int min = (int) Math.min((long) this.f28808f, b);
            long j = (long) min;
            int i2 = (b > j ? 1 : (b == j ? 0 : -1));
            byte b2 = i2 == 0 ? (byte) 4 : 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            mo40428a(i, min, 1, b2);
            this.f28805c.mo40231a_(this.f28807e, j);
            if (i2 > 0) {
                m36383b(i, b - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
