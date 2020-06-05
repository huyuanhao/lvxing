package com.bytedance.sdk.p145a.p146a;

import java.io.IOException;

/* renamed from: com.bytedance.sdk.a.a.h */
public abstract class ForwardingSource implements Source {
    /* renamed from: a */
    private final Source f5251a;

    public ForwardingSource(Source sVar) {
        if (sVar != null) {
            this.f5251a = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: b */
    public final Source mo13605b() {
        return this.f5251a;
    }

    /* renamed from: a */
    public long mo13511a(Buffer cVar, long j) throws IOException {
        return this.f5251a.mo13511a(cVar, j);
    }

    /* renamed from: a */
    public Timeout mo13512a() {
        return this.f5251a.mo13512a();
    }

    public void close() throws IOException {
        this.f5251a.close();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.f5251a.toString());
        sb.append(")");
        return sb.toString();
    }
}
