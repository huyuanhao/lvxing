package com.bytedance.sdk.openadsdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: WeakHandler */
/* renamed from: com.bytedance.sdk.openadsdk.utils.ak */
public class C2538ak extends Handler {
    /* renamed from: a */
    private final WeakReference<C2539a> f9145a;

    /* compiled from: WeakHandler */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.ak$a */
    public interface C2539a {
        /* renamed from: a */
        void mo14813a(Message message);
    }

    public C2538ak(C2539a aVar) {
        this.f9145a = new WeakReference<>(aVar);
    }

    public C2538ak(Looper looper, C2539a aVar) {
        super(looper);
        this.f9145a = new WeakReference<>(aVar);
    }

    public void handleMessage(Message message) {
        C2539a aVar = (C2539a) this.f9145a.get();
        if (aVar != null && message != null) {
            aVar.mo14813a(message);
        }
    }
}
