package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource */
/* renamed from: okio.i */
public final class C8533i implements C8547r {
    /* renamed from: a */
    private int f29024a = 0;
    /* renamed from: b */
    private final C8529e f29025b;
    /* renamed from: c */
    private final Inflater f29026c;
    /* renamed from: d */
    private final C8534j f29027d;
    /* renamed from: e */
    private final CRC32 f29028e = new CRC32();

    public C8533i(C8547r rVar) {
        if (rVar != null) {
            this.f29026c = new Inflater(true);
            this.f29025b = C8535k.m36849a(rVar);
            this.f29027d = new C8534j(this.f29025b, this.f29026c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public long mo40202a(C8525c cVar, long j) throws IOException {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (i == 0) {
            return 0;
        } else {
            if (this.f29024a == 0) {
                m36840b();
                this.f29024a = 1;
            }
            if (this.f29024a == 1) {
                long j2 = cVar.f29018b;
                long a = this.f29027d.mo40202a(cVar, j);
                if (a != -1) {
                    m36839a(cVar, j2, a);
                    return a;
                }
                this.f29024a = 2;
            }
            if (this.f29024a == 2) {
                m36841c();
                this.f29024a = 3;
                if (!this.f29025b.mo40755f()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    /* renamed from: b */
    private void m36840b() throws IOException {
        this.f29025b.mo40729a(10);
        byte b = this.f29025b.mo40741c().mo40733b(3);
        boolean z = ((b >> 1) & 1) == 1;
        if (z) {
            m36839a(this.f29025b.mo40741c(), 0, 10);
        }
        m36838a("ID1ID2", 8075, (int) this.f29025b.mo40768j());
        this.f29025b.mo40761h(8);
        if (((b >> 2) & 1) == 1) {
            this.f29025b.mo40729a(2);
            if (z) {
                m36839a(this.f29025b.mo40741c(), 0, 2);
            }
            long l = (long) this.f29025b.mo40741c().mo40772l();
            this.f29025b.mo40729a(l);
            if (z) {
                m36839a(this.f29025b.mo40741c(), 0, l);
            }
            this.f29025b.mo40761h(l);
        }
        if (((b >> 3) & 1) == 1) {
            long a = this.f29025b.mo40716a(0);
            if (a != -1) {
                if (z) {
                    m36839a(this.f29025b.mo40741c(), 0, a + 1);
                }
                this.f29025b.mo40761h(a + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b >> 4) & 1) == 1) {
            long a2 = this.f29025b.mo40716a(0);
            if (a2 != -1) {
                if (z) {
                    m36839a(this.f29025b.mo40741c(), 0, a2 + 1);
                }
                this.f29025b.mo40761h(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            m36838a("FHCRC", (int) this.f29025b.mo40772l(), (int) (short) ((int) this.f29028e.getValue()));
            this.f29028e.reset();
        }
    }

    /* renamed from: c */
    private void m36841c() throws IOException {
        m36838a("CRC", this.f29025b.mo40773m(), (int) this.f29028e.getValue());
        m36838a("ISIZE", this.f29025b.mo40773m(), (int) this.f29026c.getBytesWritten());
    }

    /* renamed from: a */
    public C8548s mo40203a() {
        return this.f29025b.mo40203a();
    }

    public void close() throws IOException {
        this.f29027d.close();
    }

    /* renamed from: a */
    private void m36839a(C8525c cVar, long j, long j2) {
        C8543n nVar = cVar.f29017a;
        while (j >= ((long) (nVar.f29048c - nVar.f29047b))) {
            j -= (long) (nVar.f29048c - nVar.f29047b);
            nVar = nVar.f29051f;
        }
        while (j2 > 0) {
            int i = (int) (((long) nVar.f29047b) + j);
            int min = (int) Math.min((long) (nVar.f29048c - i), j2);
            this.f29028e.update(nVar.f29046a, i, min);
            j2 -= (long) min;
            nVar = nVar.f29051f;
            j = 0;
        }
    }

    /* renamed from: a */
    private void m36838a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
