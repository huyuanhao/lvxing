package com.tencent.mta.track;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.b */
class C7367b {
    /* renamed from: a */
    final /* synthetic */ C7340a f24938a;
    /* renamed from: b */
    private final Object f24939b = new Object();
    /* renamed from: c */
    private Handler f24940c;

    public C7367b(C7340a aVar) {
        this.f24938a = aVar;
        HandlerThread handlerThread = new HandlerThread("com.tencent.mta.track.AnalyticsMessages.Worker", 1);
        handlerThread.start();
        this.f24940c = new C7372c(this, handlerThread.getLooper());
    }

    /* renamed from: a */
    public void mo35902a(Message message) {
        synchronized (this.f24939b) {
            if (this.f24940c == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Dead worker dropping a message: ");
                sb.append(message.what);
                Log.w("AnalyticsMessages", sb.toString());
            } else {
                this.f24940c.sendMessage(message);
            }
        }
    }
}
