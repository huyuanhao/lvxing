package com.kwad.sdk.core.videocache.p343a;

import java.io.File;

/* renamed from: com.kwad.sdk.core.videocache.a.g */
public class C4342g extends C4339e {
    /* renamed from: a */
    private final long f14250a;

    public C4342g(long j) {
        if (j > 0) {
            this.f14250a = j;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo24492a(File file, long j, int i) {
        return j <= this.f14250a;
    }
}
