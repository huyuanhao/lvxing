package com.bytedance.sdk.p145a.p146a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: com.bytedance.sdk.a.a.k */
public final class InflaterSource implements Source {
    /* renamed from: a */
    private final BufferedSource f5258a;
    /* renamed from: b */
    private final Inflater f5259b;
    /* renamed from: c */
    private int f5260c;
    /* renamed from: d */
    private boolean f5261d;

    InflaterSource(BufferedSource eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f5258a = eVar;
            this.f5259b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    /* renamed from: a */
    public long mo13511a(Buffer cVar, long j) throws IOException {
        Segment e;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f5261d) {
            throw new IllegalStateException("closed");
        } else if (i == 0) {
            return 0;
        } else {
            while (true) {
                boolean b = mo13617b();
                try {
                    e = cVar.mo13544e(1);
                    int inflate = this.f5259b.inflate(e.f5275a, e.f5277c, (int) Math.min(j, (long) (8192 - e.f5277c)));
                    if (inflate > 0) {
                        e.f5277c += inflate;
                        long j2 = (long) inflate;
                        cVar.f5243b += j2;
                        return j2;
                    } else if (this.f5259b.finished()) {
                        break;
                    } else if (this.f5259b.needsDictionary()) {
                        break;
                    } else if (b) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            m6742c();
            if (e.f5276b == e.f5277c) {
                cVar.f5242a = e.mo13637b();
                SegmentPool.m6801a(e);
            }
            return -1;
        }
    }

    /* renamed from: b */
    public final boolean mo13617b() throws IOException {
        if (!this.f5259b.needsInput()) {
            return false;
        }
        m6742c();
        if (this.f5259b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f5258a.mo13546e()) {
            return true;
        } else {
            Segment oVar = this.f5258a.mo13535c().f5242a;
            this.f5260c = oVar.f5277c - oVar.f5276b;
            this.f5259b.setInput(oVar.f5275a, oVar.f5276b, this.f5260c);
            return false;
        }
    }

    /* renamed from: c */
    private void m6742c() throws IOException {
        int i = this.f5260c;
        if (i != 0) {
            int remaining = i - this.f5259b.getRemaining();
            this.f5260c -= remaining;
            this.f5258a.mo13556h((long) remaining);
        }
    }

    /* renamed from: a */
    public Timeout mo13512a() {
        return this.f5258a.mo13512a();
    }

    public void close() throws IOException {
        if (!this.f5261d) {
            this.f5259b.end();
            this.f5261d = true;
            this.f5258a.close();
        }
    }
}
