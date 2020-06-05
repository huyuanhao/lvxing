package com.qiyukf.nimlib.p469e;

import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.unicorn.api.RequestCallback;

/* renamed from: com.qiyukf.nimlib.e.k */
public class C5824k implements AbortableFuture {
    /* renamed from: a */
    private RequestCallback f18497a;
    /* renamed from: b */
    private C5817i f18498b;

    public C5824k(C5817i iVar) {
        this.f18498b = iVar;
    }

    /* renamed from: a */
    public final void mo28130a() {
        if (this.f18497a != null) {
            int i = this.f18498b.f18481b.f18488a;
            Object obj = this.f18498b.f18481b.f18489b;
            if (i == 200) {
                this.f18497a.onSuccess(obj);
            } else if (obj instanceof Throwable) {
                this.f18497a.onException((Throwable) obj);
            } else {
                this.f18497a.onFailed(i);
            }
        }
    }

    /* renamed from: a */
    public final void mo28131a(int i, Object obj) {
        this.f18498b.mo28111a(i);
        this.f18498b.mo28112a(obj);
    }

    public boolean abort() {
        return C5805a.m23314b(this.f18498b);
    }

    public final void setCallback(RequestCallback requestCallback) {
        this.f18497a = requestCallback;
    }
}
