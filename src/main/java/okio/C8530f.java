package okio;

import java.io.IOException;

/* compiled from: ForwardingSink */
/* renamed from: okio.f */
public abstract class C8530f implements C8546q {
    /* renamed from: a */
    private final C8546q f29021a;

    public C8530f(C8546q qVar) {
        if (qVar != null) {
            this.f29021a = qVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a_ */
    public void mo40231a_(C8525c cVar, long j) throws IOException {
        this.f29021a.mo40231a_(cVar, j);
    }

    public void flush() throws IOException {
        this.f29021a.flush();
    }

    /* renamed from: a */
    public C8548s mo40271a() {
        return this.f29021a.mo40271a();
    }

    public void close() throws IOException {
        this.f29021a.close();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.f29021a.toString());
        sb.append(")");
        return sb.toString();
    }
}
