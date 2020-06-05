package com.bytedance.sdk.p145a.p146a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.a.a.i */
public class ForwardingTimeout extends Timeout {
    /* renamed from: a */
    private Timeout f5252a;

    public ForwardingTimeout(Timeout tVar) {
        if (tVar != null) {
            this.f5252a = tVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public final Timeout mo13608a() {
        return this.f5252a;
    }

    /* renamed from: a */
    public final ForwardingTimeout mo13607a(Timeout tVar) {
        if (tVar != null) {
            this.f5252a = tVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public Timeout mo13610a(long j, TimeUnit timeUnit) {
        return this.f5252a.mo13610a(j, timeUnit);
    }

    /* renamed from: j_ */
    public long mo13615j_() {
        return this.f5252a.mo13615j_();
    }

    /* renamed from: k_ */
    public boolean mo13616k_() {
        return this.f5252a.mo13616k_();
    }

    /* renamed from: d */
    public long mo13611d() {
        return this.f5252a.mo13611d();
    }

    /* renamed from: a */
    public Timeout mo13609a(long j) {
        return this.f5252a.mo13609a(j);
    }

    /* renamed from: e */
    public Timeout mo13612e() {
        return this.f5252a.mo13612e();
    }

    /* renamed from: f */
    public Timeout mo13613f() {
        return this.f5252a.mo13613f();
    }

    /* renamed from: g */
    public void mo13614g() throws IOException {
        this.f5252a.mo13614g();
    }
}
