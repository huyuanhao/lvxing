package com.bumptech.glide.gifdecoder;

import android.util.Log;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.bumptech.glide.gifdecoder.c */
public class GifHeaderParser {
    /* renamed from: a */
    private final byte[] f4326a = new byte[256];
    /* renamed from: b */
    private ByteBuffer f4327b;
    /* renamed from: c */
    private GifHeader f4328c;
    /* renamed from: d */
    private int f4329d = 0;

    /* renamed from: a */
    public GifHeaderParser mo12575a(ByteBuffer byteBuffer) {
        m5219c();
        this.f4327b = byteBuffer.asReadOnlyBuffer();
        this.f4327b.position(0);
        this.f4327b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    /* renamed from: a */
    public void mo12576a() {
        this.f4327b = null;
        this.f4328c = null;
    }

    /* renamed from: c */
    private void m5219c() {
        this.f4327b = null;
        Arrays.fill(this.f4326a, 0);
        this.f4328c = new GifHeader();
        this.f4329d = 0;
    }

    /* renamed from: b */
    public GifHeader mo12577b() {
        if (this.f4327b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (m5231o()) {
            return this.f4328c;
        } else {
            m5224h();
            if (!m5231o()) {
                m5220d();
                if (this.f4328c.f4315c < 0) {
                    this.f4328c.f4314b = 1;
                }
            }
            return this.f4328c;
        }
    }

    /* renamed from: d */
    private void m5220d() {
        m5217a((int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* renamed from: a */
    private void m5217a(int i) {
        boolean z = false;
        while (!z && !m5231o() && this.f4328c.f4315c <= i) {
            int m = m5229m();
            if (m == 33) {
                int m2 = m5229m();
                if (m2 == 1) {
                    m5227k();
                } else if (m2 == 249) {
                    this.f4328c.f4316d = new GifFrame();
                    m5221e();
                } else if (m2 == 254) {
                    m5227k();
                } else if (m2 != 255) {
                    m5227k();
                } else {
                    m5228l();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.f4326a[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m5223g();
                    } else {
                        m5227k();
                    }
                }
            } else if (m == 44) {
                if (this.f4328c.f4316d == null) {
                    this.f4328c.f4316d = new GifFrame();
                }
                m5222f();
            } else if (m != 59) {
                this.f4328c.f4314b = 1;
            } else {
                z = true;
            }
        }
    }

    /* renamed from: e */
    private void m5221e() {
        m5229m();
        int m = m5229m();
        this.f4328c.f4316d.f4308g = (m & 28) >> 2;
        boolean z = true;
        if (this.f4328c.f4316d.f4308g == 0) {
            this.f4328c.f4316d.f4308g = 1;
        }
        GifFrame aVar = this.f4328c.f4316d;
        if ((m & 1) == 0) {
            z = false;
        }
        aVar.f4307f = z;
        int n = m5230n();
        if (n < 2) {
            n = 10;
        }
        this.f4328c.f4316d.f4310i = n * 10;
        this.f4328c.f4316d.f4309h = m5229m();
        m5229m();
    }

    /* renamed from: f */
    private void m5222f() {
        this.f4328c.f4316d.f4302a = m5230n();
        this.f4328c.f4316d.f4303b = m5230n();
        this.f4328c.f4316d.f4304c = m5230n();
        this.f4328c.f4316d.f4305d = m5230n();
        int m = m5229m();
        boolean z = false;
        boolean z2 = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((m & 7) + 1));
        GifFrame aVar = this.f4328c.f4316d;
        if ((m & 64) != 0) {
            z = true;
        }
        aVar.f4306e = z;
        if (z2) {
            this.f4328c.f4316d.f4312k = m5218b(pow);
        } else {
            this.f4328c.f4316d.f4312k = null;
        }
        this.f4328c.f4316d.f4311j = this.f4327b.position();
        m5226j();
        if (!m5231o()) {
            this.f4328c.f4315c++;
            this.f4328c.f4317e.add(this.f4328c.f4316d);
        }
    }

    /* renamed from: g */
    private void m5223g() {
        do {
            m5228l();
            byte[] bArr = this.f4326a;
            if (bArr[0] == 1) {
                this.f4328c.f4325m = ((bArr[2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            }
            if (this.f4329d <= 0) {
                return;
            }
        } while (!m5231o());
    }

    /* renamed from: h */
    private void m5224h() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) m5229m());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f4328c.f4314b = 1;
            return;
        }
        m5225i();
        if (this.f4328c.f4320h && !m5231o()) {
            GifHeader bVar = this.f4328c;
            bVar.f4313a = m5218b(bVar.f4321i);
            GifHeader bVar2 = this.f4328c;
            bVar2.f4324l = bVar2.f4313a[this.f4328c.f4322j];
        }
    }

    /* renamed from: i */
    private void m5225i() {
        this.f4328c.f4318f = m5230n();
        this.f4328c.f4319g = m5230n();
        int m = m5229m();
        this.f4328c.f4320h = (m & 128) != 0;
        this.f4328c.f4321i = (int) Math.pow(2.0d, (double) ((m & 7) + 1));
        this.f4328c.f4322j = m5229m();
        this.f4328c.f4323k = m5229m();
    }

    /* renamed from: b */
    private int[] m5218b(int i) {
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = null;
        try {
            this.f4327b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | 0 | ((bArr[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            String str = "GifHeaderParser";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Format Error Reading Color Table", e);
            }
            this.f4328c.f4314b = 1;
        }
        return iArr;
    }

    /* renamed from: j */
    private void m5226j() {
        m5229m();
        m5227k();
    }

    /* renamed from: k */
    private void m5227k() {
        int m;
        do {
            m = m5229m();
            this.f4327b.position(Math.min(this.f4327b.position() + m, this.f4327b.limit()));
        } while (m > 0);
    }

    /* renamed from: l */
    private void m5228l() {
        this.f4329d = m5229m();
        if (this.f4329d > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.f4329d) {
                try {
                    i2 = this.f4329d - i;
                    this.f4327b.get(this.f4326a, i, i2);
                    i += i2;
                } catch (Exception e) {
                    String str = "GifHeaderParser";
                    if (Log.isLoggable(str, 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error Reading Block n: ");
                        sb.append(i);
                        sb.append(" count: ");
                        sb.append(i2);
                        sb.append(" blockSize: ");
                        sb.append(this.f4329d);
                        Log.d(str, sb.toString(), e);
                    }
                    this.f4328c.f4314b = 1;
                    return;
                }
            }
        }
    }

    /* renamed from: m */
    private int m5229m() {
        try {
            return this.f4327b.get() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
        } catch (Exception unused) {
            this.f4328c.f4314b = 1;
            return 0;
        }
    }

    /* renamed from: n */
    private int m5230n() {
        return this.f4327b.getShort();
    }

    /* renamed from: o */
    private boolean m5231o() {
        return this.f4328c.f4314b != 0;
    }
}
