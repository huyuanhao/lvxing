package com.bytedance.sdk.p145a.p146a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: com.bytedance.sdk.a.a.j */
public final class GzipSource implements Source {
    /* renamed from: a */
    private int f5253a = 0;
    /* renamed from: b */
    private final BufferedSource f5254b;
    /* renamed from: c */
    private final Inflater f5255c;
    /* renamed from: d */
    private final InflaterSource f5256d;
    /* renamed from: e */
    private final CRC32 f5257e = new CRC32();

    public GzipSource(Source sVar) {
        if (sVar != null) {
            this.f5255c = new Inflater(true);
            this.f5254b = Okio.m6747a(sVar);
            this.f5256d = new InflaterSource(this.f5254b, this.f5255c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public long mo13511a(Buffer cVar, long j) throws IOException {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (i == 0) {
            return 0;
        } else {
            if (this.f5253a == 0) {
                m6738b();
                this.f5253a = 1;
            }
            if (this.f5253a == 1) {
                long j2 = cVar.f5243b;
                long a = this.f5256d.mo13511a(cVar, j);
                if (a != -1) {
                    m6736a(cVar, j2, a);
                    return a;
                }
                this.f5253a = 2;
            }
            if (this.f5253a == 2) {
                m6739c();
                this.f5253a = 3;
                if (!this.f5254b.mo13546e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    /* renamed from: b */
    private void m6738b() throws IOException {
        this.f5254b.mo13527a(10);
        byte b = this.f5254b.mo13535c().mo13529b(3);
        boolean z = ((b >> 1) & 1) == 1;
        if (z) {
            m6736a(this.f5254b.mo13535c(), 0, 10);
        }
        m6737a("ID1ID2", 8075, (int) this.f5254b.mo13560i());
        this.f5254b.mo13556h(8);
        if (((b >> 2) & 1) == 1) {
            this.f5254b.mo13527a(2);
            if (z) {
                m6736a(this.f5254b.mo13535c(), 0, 2);
            }
            long k = (long) this.f5254b.mo13535c().mo13565k();
            this.f5254b.mo13527a(k);
            if (z) {
                m6736a(this.f5254b.mo13535c(), 0, k);
            }
            this.f5254b.mo13556h(k);
        }
        if (((b >> 3) & 1) == 1) {
            long a = this.f5254b.mo13517a(0);
            if (a != -1) {
                if (z) {
                    m6736a(this.f5254b.mo13535c(), 0, a + 1);
                }
                this.f5254b.mo13556h(a + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b >> 4) & 1) == 1) {
            long a2 = this.f5254b.mo13517a(0);
            if (a2 != -1) {
                if (z) {
                    m6736a(this.f5254b.mo13535c(), 0, a2 + 1);
                }
                this.f5254b.mo13556h(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            m6737a("FHCRC", (int) this.f5254b.mo13565k(), (int) (short) ((int) this.f5257e.getValue()));
            this.f5257e.reset();
        }
    }

    /* renamed from: c */
    private void m6739c() throws IOException {
        m6737a("CRC", this.f5254b.mo13566l(), (int) this.f5257e.getValue());
        m6737a("ISIZE", this.f5254b.mo13566l(), (int) this.f5255c.getBytesWritten());
    }

    /* renamed from: a */
    public Timeout mo13512a() {
        return this.f5254b.mo13512a();
    }

    public void close() throws IOException {
        this.f5256d.close();
    }

    /* renamed from: a */
    private void m6736a(Buffer cVar, long j, long j2) {
        Segment oVar = cVar.f5242a;
        while (j >= ((long) (oVar.f5277c - oVar.f5276b))) {
            j -= (long) (oVar.f5277c - oVar.f5276b);
            oVar = oVar.f5280f;
        }
        while (j2 > 0) {
            int i = (int) (((long) oVar.f5276b) + j);
            int min = (int) Math.min((long) (oVar.f5277c - i), j2);
            this.f5257e.update(oVar.f5275a, i, min);
            j2 -= (long) min;
            oVar = oVar.f5280f;
            j = 0;
        }
    }

    /* renamed from: a */
    private void m6737a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
