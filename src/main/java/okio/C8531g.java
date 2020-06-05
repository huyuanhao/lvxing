package okio;

import java.io.IOException;

/* compiled from: ForwardingSource */
/* renamed from: okio.g */
public abstract class C8531g implements C8547r {
    /* renamed from: a */
    private final C8547r f29022a;

    public C8531g(C8547r rVar) {
        if (rVar != null) {
            this.f29022a = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: b */
    public final C8547r mo40799b() {
        return this.f29022a;
    }

    /* renamed from: a */
    public long mo40202a(C8525c cVar, long j) throws IOException {
        return this.f29022a.mo40202a(cVar, j);
    }

    /* renamed from: a */
    public C8548s mo40203a() {
        return this.f29022a.mo40203a();
    }

    public void close() throws IOException {
        this.f29022a.close();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.f29022a.toString());
        sb.append(")");
        return sb.toString();
    }
}
