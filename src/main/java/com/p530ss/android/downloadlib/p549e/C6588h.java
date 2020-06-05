package com.p530ss.android.downloadlib.p549e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: WeakHandler */
/* renamed from: com.ss.android.downloadlib.e.h */
public class C6588h extends Handler {
    /* renamed from: a */
    WeakReference<C6589a> f21434a;

    /* compiled from: WeakHandler */
    /* renamed from: com.ss.android.downloadlib.e.h$a */
    public interface C6589a {
        /* renamed from: a */
        void mo31256a(Message message);
    }

    public C6588h(Looper looper, C6589a aVar) {
        super(looper);
        this.f21434a = new WeakReference<>(aVar);
    }

    public void handleMessage(Message message) {
        C6589a aVar = (C6589a) this.f21434a.get();
        if (aVar != null && message != null) {
            aVar.mo31256a(message);
        }
    }
}
