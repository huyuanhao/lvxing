package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout */
/* renamed from: okio.h */
public class C8532h extends C8548s {
    /* renamed from: a */
    private C8548s f29023a;

    public C8532h(C8548s sVar) {
        if (sVar != null) {
            this.f29023a = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public final C8548s mo40802a() {
        return this.f29023a;
    }

    /* renamed from: a */
    public final C8532h mo40801a(C8548s sVar) {
        if (sVar != null) {
            this.f29023a = sVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public C8548s mo40804a(long j, TimeUnit timeUnit) {
        return this.f29023a.mo40804a(j, timeUnit);
    }

    /* renamed from: n_ */
    public long mo40808n_() {
        return this.f29023a.mo40808n_();
    }

    /* renamed from: o_ */
    public boolean mo40809o_() {
        return this.f29023a.mo40809o_();
    }

    /* renamed from: d */
    public long mo40805d() {
        return this.f29023a.mo40805d();
    }

    /* renamed from: a */
    public C8548s mo40803a(long j) {
        return this.f29023a.mo40803a(j);
    }

    /* renamed from: p_ */
    public C8548s mo40810p_() {
        return this.f29023a.mo40810p_();
    }

    /* renamed from: f */
    public C8548s mo40806f() {
        return this.f29023a.mo40806f();
    }

    /* renamed from: g */
    public void mo40807g() throws IOException {
        this.f29023a.mo40807g();
    }
}
