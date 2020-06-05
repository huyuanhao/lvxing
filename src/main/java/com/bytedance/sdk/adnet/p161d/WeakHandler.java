package com.bytedance.sdk.adnet.p161d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: com.bytedance.sdk.adnet.d.j */
public class WeakHandler extends Handler {
    /* renamed from: a */
    private final WeakReference<C1993a> f6323a;

    /* compiled from: WeakHandler */
    /* renamed from: com.bytedance.sdk.adnet.d.j$a */
    public interface C1993a {
        /* renamed from: a */
        void mo14162a(Message message);
    }

    public WeakHandler(Looper looper, C1993a aVar) {
        super(looper);
        this.f6323a = new WeakReference<>(aVar);
    }

    public void handleMessage(Message message) {
        C1993a aVar = (C1993a) this.f6323a.get();
        if (aVar != null && message != null) {
            aVar.mo14162a(message);
        }
    }
}
