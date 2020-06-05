package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource */
/* renamed from: okio.j */
public final class C8534j implements C8547r {
    /* renamed from: a */
    private final C8529e f29029a;
    /* renamed from: b */
    private final Inflater f29030b;
    /* renamed from: c */
    private int f29031c;
    /* renamed from: d */
    private boolean f29032d;

    C8534j(C8529e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f29029a = eVar;
            this.f29030b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    /* renamed from: a */
    public long mo40202a(C8525c cVar, long j) throws IOException {
        C8543n e;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f29032d) {
            throw new IllegalStateException("closed");
        } else if (i == 0) {
            return 0;
        } else {
            while (true) {
                boolean b = mo40811b();
                try {
                    e = cVar.mo40751e(1);
                    int inflate = this.f29030b.inflate(e.f29046a, e.f29048c, (int) Math.min(j, (long) (8192 - e.f29048c)));
                    if (inflate > 0) {
                        e.f29048c += inflate;
                        long j2 = (long) inflate;
                        cVar.f29018b += j2;
                        return j2;
                    } else if (this.f29030b.finished()) {
                        break;
                    } else if (this.f29030b.needsDictionary()) {
                        break;
                    } else if (b) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            m36844c();
            if (e.f29047b == e.f29048c) {
                cVar.f29017a = e.mo40832b();
                C8544o.m36918a(e);
            }
            return -1;
        }
    }

    /* renamed from: b */
    public boolean mo40811b() throws IOException {
        if (!this.f29030b.needsInput()) {
            return false;
        }
        m36844c();
        if (this.f29030b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f29029a.mo40755f()) {
            return true;
        } else {
            C8543n nVar = this.f29029a.mo40741c().f29017a;
            this.f29031c = nVar.f29048c - nVar.f29047b;
            this.f29030b.setInput(nVar.f29046a, nVar.f29047b, this.f29031c);
            return false;
        }
    }

    /* renamed from: c */
    private void m36844c() throws IOException {
        int i = this.f29031c;
        if (i != 0) {
            int remaining = i - this.f29030b.getRemaining();
            this.f29031c -= remaining;
            this.f29029a.mo40761h((long) remaining);
        }
    }

    /* renamed from: a */
    public C8548s mo40203a() {
        return this.f29029a.mo40203a();
    }

    public void close() throws IOException {
        if (!this.f29032d) {
            this.f29030b.end();
            this.f29032d = true;
            this.f29029a.close();
        }
    }
}
