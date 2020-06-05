package com.p522qq.p523e.comm.net;

import com.p522qq.p523e.comm.net.NetworkClient.Priority;
import com.p522qq.p523e.comm.net.p524rr.Request;
import com.p522qq.p523e.comm.net.p524rr.Request.Method;
import com.p522qq.p523e.comm.net.p524rr.Response;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.tencent.bugly.BuglyStrategy.C7120a;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.qq.e.comm.net.NetworkClientImpl */
public class NetworkClientImpl implements NetworkClient {
    /* renamed from: a */
    private static final NetworkClient f20269a = new NetworkClientImpl();
    /* renamed from: b */
    private final ExecutorService f20270b;
    /* renamed from: c */
    private PriorityBlockingQueue<Runnable> f20271c = new PriorityBlockingQueue<>(15);

    /* renamed from: com.qq.e.comm.net.NetworkClientImpl$1 */
    static /* synthetic */ class C64311 {
        /* renamed from: a */
        static final /* synthetic */ int[] f20272a = new int[Method.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.qq.e.comm.net.rr.Request$Method[] r0 = com.p522qq.p523e.comm.net.p524rr.Request.Method.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f20272a = r0
            int[] r0 = f20272a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.qq.e.comm.net.rr.Request$Method r1 = com.p522qq.p523e.comm.net.p524rr.Request.Method.POST     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f20272a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.qq.e.comm.net.rr.Request$Method r1 = com.p522qq.p523e.comm.net.p524rr.Request.Method.GET     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.comm.net.NetworkClientImpl.C64311.m50876clinit():void");
        }
    }

    /* renamed from: com.qq.e.comm.net.NetworkClientImpl$NetFutureTask */
    private class NetFutureTask<T> extends FutureTask<T> implements Comparable<NetFutureTask<T>> {
        /* renamed from: a */
        private final Priority f20273a;

        public NetFutureTask(Callable<T> callable, Priority priority) {
            super(callable);
            this.f20273a = priority;
        }

        public int compareTo(NetFutureTask<T> netFutureTask) {
            if (netFutureTask == null) {
                return 1;
            }
            return this.f20273a.value() - netFutureTask.f20273a.value();
        }
    }

    /* renamed from: com.qq.e.comm.net.NetworkClientImpl$TaskCallable */
    private static class TaskCallable implements Callable<Response> {
        /* renamed from: a */
        private Request f20275a;
        /* renamed from: b */
        private NetworkCallBack f20276b;

        public TaskCallable(Request request) {
            this(request, null);
        }

        public TaskCallable(Request request, NetworkCallBack networkCallBack) {
            this.f20275a = request;
            this.f20276b = networkCallBack;
        }

        /* renamed from: a */
        private void m25239a(HttpURLConnection httpURLConnection) {
            for (Entry entry : this.f20275a.getHeaders().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            StringBuilder sb = new StringBuilder("GDTADNetClient-[");
            sb.append(System.getProperty("http.agent"));
            sb.append("]");
            httpURLConnection.setRequestProperty("User-Agent", sb.toString());
            if (this.f20275a.getConnectionTimeOut() > 0) {
                httpURLConnection.setConnectTimeout(this.f20275a.getConnectionTimeOut());
            } else {
                httpURLConnection.setConnectTimeout(C7120a.MAX_USERDATA_VALUE_LENGTH);
            }
            if (this.f20275a.getSocketTimeOut() > 0) {
                httpURLConnection.setReadTimeout(this.f20275a.getSocketTimeOut());
            } else {
                httpURLConnection.setReadTimeout(C7120a.MAX_USERDATA_VALUE_LENGTH);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
            if (r6.f20275a.isAutoClose() != false) goto L_0x006d;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x007f, code lost:
            if (r1 != null) goto L_0x006d;
     */
        public com.p522qq.p523e.comm.net.p524rr.Response call() throws java.lang.Exception {
            /*
            r6 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0056 }
            com.qq.e.comm.net.rr.Request r2 = r6.f20275a     // Catch:{ Exception -> 0x0056 }
            java.lang.String r2 = r2.getUrlWithParas()     // Catch:{ Exception -> 0x0056 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0056 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0056 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0056 }
            r6.m25239a(r1)     // Catch:{ Exception -> 0x0056 }
            int[] r2 = com.p522qq.p523e.comm.net.NetworkClientImpl.C64311.f20272a     // Catch:{ Exception -> 0x0056 }
            com.qq.e.comm.net.rr.Request r3 = r6.f20275a     // Catch:{ Exception -> 0x0056 }
            com.qq.e.comm.net.rr.Request$Method r3 = r3.getMethod()     // Catch:{ Exception -> 0x0056 }
            int r3 = r3.ordinal()     // Catch:{ Exception -> 0x0056 }
            r2 = r2[r3]     // Catch:{ Exception -> 0x0056 }
            r3 = 1
            if (r2 == r3) goto L_0x0027
            goto L_0x004b
        L_0x0027:
            r1.setDoOutput(r3)     // Catch:{ Exception -> 0x0056 }
            r2 = 0
            r1.setChunkedStreamingMode(r2)     // Catch:{ Exception -> 0x0056 }
            com.qq.e.comm.net.rr.Request r2 = r6.f20275a     // Catch:{ Exception -> 0x0056 }
            byte[] r2 = r2.getPostData()     // Catch:{ Exception -> 0x0056 }
            if (r2 == 0) goto L_0x004b
            int r3 = r2.length     // Catch:{ Exception -> 0x0056 }
            if (r3 <= 0) goto L_0x004b
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0056 }
            java.io.OutputStream r4 = r1.getOutputStream()     // Catch:{ Exception -> 0x0056 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0056 }
            r3.write(r2)     // Catch:{ Exception -> 0x0056 }
            r3.flush()     // Catch:{ Exception -> 0x0056 }
            r3.close()     // Catch:{ Exception -> 0x0056 }
        L_0x004b:
            java.net.HttpURLConnection r1 = com.p522qq.p523e.comm.net.NetworkClientImpl.followRedirect(r1)     // Catch:{ Exception -> 0x0056 }
            com.qq.e.comm.net.rr.Request r2 = r6.f20275a     // Catch:{ Exception -> 0x0056 }
            com.qq.e.comm.net.rr.Response r1 = r2.initResponse(r1)     // Catch:{ Exception -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x005a:
            if (r0 != 0) goto L_0x0071
            com.qq.e.comm.net.NetworkCallBack r0 = r6.f20276b
            if (r0 == 0) goto L_0x0065
            com.qq.e.comm.net.rr.Request r2 = r6.f20275a
            r0.onResponse(r2, r1)
        L_0x0065:
            com.qq.e.comm.net.rr.Request r0 = r6.f20275a
            boolean r0 = r0.isAutoClose()
            if (r0 == 0) goto L_0x0082
        L_0x006d:
            r1.close()
            goto L_0x0082
        L_0x0071:
            com.qq.e.comm.net.NetworkCallBack r2 = r6.f20276b
            if (r2 == 0) goto L_0x0083
            java.lang.String r2 = "NetworkClientException"
            com.p522qq.p523e.comm.util.GDTLogger.m25264w(r2, r0)
            com.qq.e.comm.net.NetworkCallBack r2 = r6.f20276b
            r2.onException(r0)
            if (r1 == 0) goto L_0x0082
            goto L_0x006d
        L_0x0082:
            return r1
        L_0x0083:
            throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.comm.net.NetworkClientImpl.TaskCallable.call():com.qq.e.comm.net.rr.Response");
        }
    }

    private NetworkClientImpl() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 180, TimeUnit.SECONDS, this.f20271c);
        this.f20270b = threadPoolExecutor;
    }

    public static HttpURLConnection followRedirect(HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection == null) {
            return null;
        }
        int i = 0;
        int connectTimeout = httpURLConnection.getConnectTimeout();
        int readTimeout = httpURLConnection.getReadTimeout();
        while (i < 3) {
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 302 && responseCode != 301 && responseCode != 303) {
                break;
            }
            String headerField = httpURLConnection.getHeaderField("location");
            httpURLConnection.disconnect();
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            httpURLConnection.setConnectTimeout(connectTimeout);
            httpURLConnection.setReadTimeout(readTimeout);
            i++;
        }
        if (i != 3) {
            return httpURLConnection;
        }
        StringBuilder sb = new StringBuilder("HttpURLConnection exceed max redirect ");
        sb.append(3);
        sb.append(" ");
        sb.append(httpURLConnection.getURL());
        throw new IOException(sb.toString());
    }

    public static NetworkClient getInstance() {
        return f20269a;
    }

    public Future<Response> submit(Request request) {
        return submit(request, Priority.Mid);
    }

    public Future<Response> submit(Request request, Priority priority) {
        NetFutureTask netFutureTask = new NetFutureTask(new TaskCallable(request), priority);
        this.f20270b.execute(netFutureTask);
        StringBuilder sb = new StringBuilder("QueueSize:");
        sb.append(this.f20271c.size());
        GDTLogger.m25258d(sb.toString());
        return netFutureTask;
    }

    public void submit(Request request, NetworkCallBack networkCallBack) {
        submit(request, Priority.Mid, networkCallBack);
    }

    public void submit(Request request, Priority priority, NetworkCallBack networkCallBack) {
        submit(request, priority, networkCallBack, this.f20270b);
    }

    public void submit(Request request, Priority priority, NetworkCallBack networkCallBack, Executor executor) {
        if (executor == null) {
            GDTLogger.m25260e("Submit failed for no executor");
            return;
        }
        executor.execute(new NetFutureTask(new TaskCallable(request, networkCallBack), priority));
        StringBuilder sb = new StringBuilder("QueueSize:");
        sb.append(this.f20271c.size());
        GDTLogger.m25258d(sb.toString());
    }
}
