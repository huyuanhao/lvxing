package com.tencent.mta.track;

import java.util.concurrent.TimeUnit;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.ae */
class C7345ae {
    /* renamed from: a */
    private final TimeUnit f24869a;
    /* renamed from: b */
    private long f24870b = System.currentTimeMillis();
    /* renamed from: c */
    private long f24871c;

    C7345ae(TimeUnit timeUnit) {
        this.f24869a = timeUnit;
        this.f24871c = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public long mo35844a() {
        long convert = this.f24869a.convert((System.currentTimeMillis() - this.f24870b) + this.f24871c, TimeUnit.MILLISECONDS);
        if (convert < 0) {
            return 0;
        }
        return convert;
    }

    /* renamed from: b */
    public long mo35846b() {
        return this.f24870b;
    }

    /* renamed from: c */
    public long mo35848c() {
        return this.f24871c;
    }

    /* renamed from: a */
    public void mo35845a(long j) {
        this.f24870b = j;
    }

    /* renamed from: b */
    public void mo35847b(long j) {
        this.f24871c = j;
    }
}
