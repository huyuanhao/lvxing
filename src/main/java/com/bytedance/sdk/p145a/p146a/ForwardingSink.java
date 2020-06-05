package com.bytedance.sdk.p145a.p146a;

import java.io.IOException;

/* renamed from: com.bytedance.sdk.a.a.g */
public abstract class ForwardingSink implements Sink {
    /* renamed from: a */
    private final Sink f5250a;

    public ForwardingSink(Sink rVar) {
        if (rVar != null) {
            this.f5250a = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a_ */
    public void mo13507a_(Buffer cVar, long j) throws IOException {
        this.f5250a.mo13507a_(cVar, j);
    }

    public void flush() throws IOException {
        this.f5250a.flush();
    }

    /* renamed from: a */
    public Timeout mo13506a() {
        return this.f5250a.mo13506a();
    }

    public void close() throws IOException {
        this.f5250a.close();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.f5250a.toString());
        sb.append(")");
        return sb.toString();
    }
}
