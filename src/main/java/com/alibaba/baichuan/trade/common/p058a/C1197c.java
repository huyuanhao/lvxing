package com.alibaba.baichuan.trade.common.p058a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.alibaba.baichuan.trade.common.a.c */
public class C1197c {
    /* renamed from: a */
    private Handler f2480a;
    /* renamed from: b */
    private HandlerThread f2481b = new HandlerThread("AlibcMessageQueue");

    /* renamed from: com.alibaba.baichuan.trade.common.a.c$a */
    public static class C1198a {
        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo10844a(Message message) {
        }
    }

    /* renamed from: com.alibaba.baichuan.trade.common.a.c$b */
    class C1199b implements Callback {
        /* renamed from: b */
        private C1198a f2483b;

        C1199b(C1198a aVar) {
            this.f2483b = aVar;
        }

        public boolean handleMessage(Message message) {
            this.f2483b.mo10844a(message);
            return true;
        }
    }

    public C1197c(C1198a aVar) {
        this.f2481b.start();
        Looper looper = this.f2481b.getLooper();
        if (aVar == null) {
            aVar = new C1198a();
        }
        this.f2480a = new Handler(looper, new C1199b(aVar));
    }

    /* renamed from: a */
    public void mo10846a(Message message) {
        if (message != null) {
            this.f2480a.sendMessage(message);
        }
    }
}
