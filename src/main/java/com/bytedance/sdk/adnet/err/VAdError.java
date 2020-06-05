package com.bytedance.sdk.adnet.err;

import com.bytedance.sdk.adnet.core.NetworkResponse;

public class VAdError extends Exception {
    /* renamed from: a */
    private long f6333a;
    public final NetworkResponse networkResponse;

    public VAdError() {
        this.networkResponse = null;
    }

    public VAdError(NetworkResponse lVar) {
        this.networkResponse = lVar;
    }

    public VAdError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VAdError(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public VAdError(Throwable th) {
        super(th);
        this.networkResponse = null;
    }

    public void setNetworkTimeMs(long j) {
        this.f6333a = j;
    }

    public long getNetworkTimeMs() {
        return this.f6333a;
    }
}
