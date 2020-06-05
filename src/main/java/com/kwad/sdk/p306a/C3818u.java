package com.kwad.sdk.p306a;

import android.os.Handler;
import android.os.Message;
import com.kwad.sdk.core.p319c.C4065b;
import java.lang.ref.WeakReference;

/* renamed from: com.kwad.sdk.a.u */
public class C3818u extends Handler {
    /* renamed from: a */
    private WeakReference<C3819a> f12939a;

    /* renamed from: com.kwad.sdk.a.u$a */
    public interface C3819a {
        /* renamed from: a */
        void mo23214a(Message message);
    }

    public C3818u(C3819a aVar) {
        this.f12939a = new WeakReference<>(aVar);
    }

    public void handleMessage(Message message) {
        try {
            if (this.f12939a != null) {
                C3819a aVar = (C3819a) this.f12939a.get();
                if (aVar != null) {
                    aVar.mo23214a(message);
                    super.handleMessage(message);
                }
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }
}
