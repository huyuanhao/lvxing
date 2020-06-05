package com.p522qq.p523e.comm.net;

import com.p522qq.p523e.comm.net.p524rr.Request;
import com.p522qq.p523e.comm.net.p524rr.Response;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* renamed from: com.qq.e.comm.net.NetworkClient */
public interface NetworkClient {

    /* renamed from: com.qq.e.comm.net.NetworkClient$Priority */
    public enum Priority {
        High(1),
        Mid(2),
        Low(3);
        
        /* renamed from: a */
        private int f20268a;

        private Priority(int i) {
            this.f20268a = i;
        }

        public final int value() {
            return this.f20268a;
        }
    }

    Future<Response> submit(Request request);

    Future<Response> submit(Request request, Priority priority);

    void submit(Request request, NetworkCallBack networkCallBack);

    void submit(Request request, Priority priority, NetworkCallBack networkCallBack);

    void submit(Request request, Priority priority, NetworkCallBack networkCallBack, Executor executor);
}
