package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.videocache.p343a.C4333a;
import com.kwad.sdk.core.videocache.p343a.C4335c;
import com.kwad.sdk.core.videocache.p343a.C4341f;
import com.kwad.sdk.core.videocache.p343a.C4342g;
import com.kwad.sdk.core.videocache.p344b.C4344a;
import com.kwad.sdk.core.videocache.p344b.C4345b;
import com.kwad.sdk.core.videocache.p346d.C4350b;
import com.kwad.sdk.core.videocache.p346d.C4351c;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.kwad.sdk.core.videocache.f */
public class C4353f {
    /* renamed from: a */
    private final Object f14266a;
    /* renamed from: b */
    private final ExecutorService f14267b;
    /* renamed from: c */
    private final Map<String, C4358g> f14268c;
    /* renamed from: d */
    private final ServerSocket f14269d;
    /* renamed from: e */
    private final int f14270e;
    /* renamed from: f */
    private final Thread f14271f;
    /* renamed from: g */
    private final C4346c f14272g;

    /* renamed from: com.kwad.sdk.core.videocache.f$a */
    public static final class C4355a {
        /* renamed from: a */
        private File f14273a;
        /* renamed from: b */
        private C4335c f14274b = new C4341f();
        /* renamed from: c */
        private C4333a f14275c = new C4342g(536870912);
        /* renamed from: d */
        private C4350b f14276d;
        /* renamed from: e */
        private C4345b f14277e = new C4344a();

        public C4355a(Context context) {
            this.f14276d = C4351c.m17759a(context);
            this.f14273a = C4369o.m17835a(context);
        }

        /* renamed from: b */
        private C4346c m17784b() {
            C4346c cVar = new C4346c(this.f14273a, this.f14274b, this.f14275c, this.f14276d, this.f14277e);
            return cVar;
        }

        /* renamed from: a */
        public C4355a mo24509a(long j) {
            this.f14275c = new C4342g(j);
            return this;
        }

        /* renamed from: a */
        public C4353f mo24510a() {
            return new C4353f(m17784b());
        }
    }

    /* renamed from: com.kwad.sdk.core.videocache.f$b */
    private final class C4356b implements Runnable {
        /* renamed from: b */
        private final Socket f14279b;

        public C4356b(Socket socket) {
            this.f14279b = socket;
        }

        public void run() {
            C4353f.this.m17773a(this.f14279b);
        }
    }

    /* renamed from: com.kwad.sdk.core.videocache.f$c */
    private final class C4357c implements Runnable {
        /* renamed from: b */
        private final CountDownLatch f14281b;

        public C4357c(CountDownLatch countDownLatch) {
            this.f14281b = countDownLatch;
        }

        public void run() {
            this.f14281b.countDown();
            C4353f.this.m17768a();
        }
    }

    private C4353f(C4346c cVar) {
        String str = "127.0.0.1";
        this.f14266a = new Object();
        this.f14267b = Executors.newFixedThreadPool(8);
        this.f14268c = new ConcurrentHashMap();
        this.f14272g = (C4346c) C4362j.m17805a(cVar);
        try {
            this.f14269d = new ServerSocket(0, 8, InetAddress.getByName(str));
            this.f14270e = this.f14269d.getLocalPort();
            C4361i.m17804a(str, this.f14270e);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f14271f = new Thread(new C4357c(countDownLatch));
            this.f14271f.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this.f14267b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17768a() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f14269d.accept();
                StringBuilder sb = new StringBuilder();
                sb.append("Accept new socket ");
                sb.append(accept);
                C4065b.m16863a("HttpProxyCacheServer", sb.toString());
                this.f14267b.submit(new C4356b(accept));
            } catch (IOException e) {
                m17772a((Throwable) new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    /* renamed from: a */
    private void m17771a(File file) {
        try {
            this.f14272g.f14253c.mo24488a(file);
        } catch (IOException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error touching file ");
            sb.append(file);
            C4065b.m16869d("HttpProxyCacheServer", sb.toString());
        }
    }

    /* renamed from: a */
    private void m17772a(Throwable th) {
        C4065b.m16869d("HttpProxyCacheServer", "HttpProxyCacheServer error");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17773a(Socket socket) {
        StringBuilder sb;
        String str = "Opened connections: ";
        String str2 = "HttpProxyCacheServer";
        try {
            C4348d a = C4348d.m17751a(socket.getInputStream());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request to cache proxy:");
            sb2.append(a);
            C4065b.m16863a(str2, sb2.toString());
            m17778d(C4366l.m17829c(a.f14259a)).mo24514a(a, socket);
            m17775b(socket);
            sb = new StringBuilder();
        } catch (SocketException unused) {
            C4065b.m16863a(str2, "Closing socket… Socket is closed by client.");
            m17775b(socket);
            sb = new StringBuilder();
        } catch (ProxyCacheException | IOException e) {
            m17772a((Throwable) new ProxyCacheException("Error processing request", e));
            m17775b(socket);
            sb = new StringBuilder();
        } catch (Throwable th) {
            m17775b(socket);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(m17774b());
            C4065b.m16863a(str2, sb3.toString());
            throw th;
        }
        sb.append(str);
        sb.append(m17774b());
        C4065b.m16863a(str2, sb.toString());
    }

    /* renamed from: b */
    private int m17774b() {
        int i;
        synchronized (this.f14266a) {
            i = 0;
            for (C4358g a : this.f14268c.values()) {
                i += a.mo24513a();
            }
        }
        return i;
    }

    /* renamed from: b */
    private void m17775b(Socket socket) {
        m17777c(socket);
        m17779d(socket);
        m17780e(socket);
    }

    /* renamed from: c */
    private String m17776c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", new Object[]{"127.0.0.1", Integer.valueOf(this.f14270e), C4366l.m17828b(str)});
    }

    /* renamed from: c */
    private void m17777c(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException unused) {
            C4065b.m16863a("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            m17772a((Throwable) new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    /* renamed from: d */
    private C4358g m17778d(String str) {
        C4358g gVar;
        synchronized (this.f14266a) {
            gVar = (C4358g) this.f14268c.get(str);
            if (gVar == null) {
                gVar = new C4358g(str, this.f14272g);
                this.f14268c.put(str, gVar);
            }
        }
        return gVar;
    }

    /* renamed from: d */
    private void m17779d(Socket socket) {
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException unused) {
            C4065b.m16868c("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    /* renamed from: e */
    private void m17780e(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            m17772a((Throwable) new ProxyCacheException("Error closing socket", e));
        }
    }

    /* renamed from: a */
    public String mo24506a(String str) {
        return mo24507a(str, true);
    }

    /* renamed from: a */
    public String mo24507a(String str, boolean z) {
        if (!z || !mo24508b(str).exists()) {
            return m17776c(str);
        }
        File b = mo24508b(str);
        m17771a(b);
        return Uri.fromFile(b).toString();
    }

    /* renamed from: b */
    public File mo24508b(String str) {
        return new File(this.f14272g.f14251a, this.f14272g.f14252b.mo24489a(str));
    }
}
