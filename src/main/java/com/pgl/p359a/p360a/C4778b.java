package com.pgl.p359a.p360a;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;

/* renamed from: com.pgl.a.a.b */
public abstract class C4778b {
    /* renamed from: p */
    private static HostnameVerifier f15413p = new C4780c();
    /* renamed from: a */
    public String f15414a;
    /* renamed from: b */
    private Context f15415b;
    /* renamed from: c */
    private String f15416c;
    /* renamed from: d */
    private int f15417d;
    /* renamed from: e */
    private int f15418e;
    /* renamed from: f */
    private byte[] f15419f;
    /* renamed from: g */
    private int f15420g = -1;
    /* renamed from: h */
    private byte[] f15421h = null;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public int f15422i = C7516p.f25219Cf;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public int f15423j = 1;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public int f15424k = 0;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean f15425l = false;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public HandlerThread f15426m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public Handler f15427n;
    /* renamed from: o */
    private boolean f15428o = false;
    /* renamed from: q */
    private HttpURLConnection f15429q = null;

    public C4778b(Context context, String str) {
        String str2 = "";
        this.f15414a = str2;
        if (str == null || str.length() <= 0) {
            str = str2;
        }
        this.f15415b = context;
        this.f15416c = str;
    }

    /* renamed from: a */
    private void m19593a(int i) {
        String str = "GET";
        switch (i) {
            case 1:
                str = "POST";
                break;
            case 3:
                str = "PUT";
                break;
            case 4:
                str = "DELETE";
                break;
            case 5:
                str = "HEAD";
                break;
            case 6:
                str = "TRACE";
                break;
        }
        this.f15429q.setRequestMethod(str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a7, code lost:
            if (r3 != null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b0, code lost:
            if (r3 != null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b3, code lost:
            r0 = r7.f15429q;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b5, code lost:
            if (r0 == null) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b7, code lost:
            r0.disconnect();
            r7.f15429q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bc, code lost:
            r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cb, code lost:
            if (r0 == false) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cd, code lost:
            mo25726a(r7.f15420g, r7.f15421h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d4, code lost:
            return r0;
     */
    /* renamed from: a */
    public boolean mo25756a() {
        /*
        r7 = this;
        r0 = 0
        r1 = 1
        r2 = 0
        java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x00be }
        java.lang.String r4 = r7.f15414a     // Catch:{ all -> 0x00be }
        r3.<init>(r4)     // Catch:{ all -> 0x00be }
        boolean r4 = r7.f15428o     // Catch:{ all -> 0x00be }
        if (r4 == 0) goto L_0x0037
        javax.net.ssl.TrustManager[] r4 = new javax.net.ssl.TrustManager[r1]     // Catch:{ all -> 0x00be }
        com.pgl.a.a.d r5 = new com.pgl.a.a.d     // Catch:{ all -> 0x00be }
        r5.m48860init()     // Catch:{ all -> 0x00be }
        r4[r0] = r5     // Catch:{ all -> 0x00be }
        java.lang.String r5 = "TLS"
        javax.net.ssl.SSLContext r5 = javax.net.ssl.SSLContext.getInstance(r5)     // Catch:{ all -> 0x00be }
        java.security.SecureRandom r6 = new java.security.SecureRandom     // Catch:{ all -> 0x00be }
        r6.<init>()     // Catch:{ all -> 0x00be }
        r5.init(r2, r4, r6)     // Catch:{ all -> 0x00be }
        javax.net.ssl.SSLSocketFactory r4 = r5.getSocketFactory()     // Catch:{ all -> 0x00be }
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r4)     // Catch:{ all -> 0x00be }
        java.net.Proxy r4 = java.net.Proxy.NO_PROXY     // Catch:{ all -> 0x00be }
        java.net.URLConnection r4 = r3.openConnection(r4)     // Catch:{ all -> 0x00be }
        java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x00be }
    L_0x0034:
        r7.f15429q = r4     // Catch:{ all -> 0x00be }
        goto L_0x003e
    L_0x0037:
        java.net.URLConnection r4 = r3.openConnection()     // Catch:{ all -> 0x00be }
        java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x00be }
        goto L_0x0034
    L_0x003e:
        java.lang.String r4 = "https"
        java.lang.String r3 = r3.getProtocol()     // Catch:{ all -> 0x00be }
        java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x00be }
        boolean r3 = r4.equals(r3)     // Catch:{ all -> 0x00be }
        if (r3 == 0) goto L_0x0057
        java.net.HttpURLConnection r3 = r7.f15429q     // Catch:{ all -> 0x00be }
        javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3     // Catch:{ all -> 0x00be }
        javax.net.ssl.HostnameVerifier r4 = f15413p     // Catch:{ all -> 0x00be }
        r3.setHostnameVerifier(r4)     // Catch:{ all -> 0x00be }
    L_0x0057:
        java.net.HttpURLConnection r3 = r7.f15429q     // Catch:{ all -> 0x00be }
        int r4 = r7.f15422i     // Catch:{ all -> 0x00be }
        r3.setConnectTimeout(r4)     // Catch:{ all -> 0x00be }
        java.net.HttpURLConnection r3 = r7.f15429q     // Catch:{ all -> 0x00be }
        int r4 = r7.f15422i     // Catch:{ all -> 0x00be }
        r3.setReadTimeout(r4)     // Catch:{ all -> 0x00be }
        int r3 = r7.f15417d     // Catch:{ all -> 0x00be }
        r7.m19593a(r3)     // Catch:{ all -> 0x00be }
        int r3 = r7.f15418e     // Catch:{ all -> 0x00be }
        r7.m19598b(r3)     // Catch:{ all -> 0x00be }
        byte[] r3 = r7.f15419f     // Catch:{ all -> 0x00be }
        if (r3 == 0) goto L_0x008e
        byte[] r3 = r7.f15419f     // Catch:{ all -> 0x00be }
        int r3 = r3.length     // Catch:{ all -> 0x00be }
        if (r3 <= 0) goto L_0x008e
        java.net.HttpURLConnection r3 = r7.f15429q     // Catch:{ all -> 0x00be }
        r3.setDoOutput(r1)     // Catch:{ all -> 0x00be }
        java.net.HttpURLConnection r3 = r7.f15429q     // Catch:{ all -> 0x00be }
        java.io.OutputStream r3 = r3.getOutputStream()     // Catch:{ all -> 0x00be }
        byte[] r4 = r7.f15419f     // Catch:{ all -> 0x00be }
        r3.write(r4)     // Catch:{ all -> 0x00be }
        r3.flush()     // Catch:{ all -> 0x00be }
        r3.close()     // Catch:{ all -> 0x00be }
    L_0x008e:
        java.net.HttpURLConnection r3 = r7.f15429q     // Catch:{ all -> 0x00be }
        r3.connect()     // Catch:{ all -> 0x00be }
        java.net.HttpURLConnection r3 = r7.f15429q     // Catch:{ all -> 0x00af }
        int r3 = r3.getResponseCode()     // Catch:{ all -> 0x00af }
        r7.f15420g = r3     // Catch:{ all -> 0x00af }
        java.net.HttpURLConnection r3 = r7.f15429q     // Catch:{ all -> 0x00af }
        java.io.InputStream r3 = r3.getInputStream()     // Catch:{ all -> 0x00af }
        byte[] r4 = r7.m19596a(r3)     // Catch:{ all -> 0x00ad }
        r7.f15421h = r4     // Catch:{ all -> 0x00ad }
        if (r3 == 0) goto L_0x00b3
    L_0x00a9:
        r3.close()     // Catch:{ all -> 0x00be }
        goto L_0x00b3
        goto L_0x00b0
    L_0x00af:
        r3 = r2
    L_0x00b0:
        if (r3 == 0) goto L_0x00b3
        goto L_0x00a9
    L_0x00b3:
        java.net.HttpURLConnection r0 = r7.f15429q
        if (r0 == 0) goto L_0x00bc
        r0.disconnect()
        r7.f15429q = r2
    L_0x00bc:
        r0 = 1
        goto L_0x00cb
    L_0x00be:
        r1 = move-exception
        r1.printStackTrace()     // Catch:{ all -> 0x00d5 }
        java.net.HttpURLConnection r1 = r7.f15429q
        if (r1 == 0) goto L_0x00cb
        r1.disconnect()
        r7.f15429q = r2
    L_0x00cb:
        if (r0 == 0) goto L_0x00d4
        int r1 = r7.f15420g
        byte[] r2 = r7.f15421h
        r7.mo25726a(r1, r2)
    L_0x00d4:
        return r0
    L_0x00d5:
        r0 = move-exception
        java.net.HttpURLConnection r1 = r7.f15429q
        if (r1 == 0) goto L_0x00df
        r1.disconnect()
        r7.f15429q = r2
    L_0x00df:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.p359a.p360a.C4778b.mo25756a():boolean");
    }

    /* renamed from: a */
    private byte[] m19596a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: b */
    private void m19598b(int i) {
        HttpURLConnection httpURLConnection;
        StringBuilder sb;
        String str = i != 1 ? i != 2 ? "" : "application/octet-stream" : "application/json; charset=utf-8";
        if (str.length() > 0) {
            this.f15429q.addRequestProperty("Content-Type", str);
        }
        HttpURLConnection httpURLConnection2 = this.f15429q;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sessionid=");
        sb2.append(this.f15416c);
        httpURLConnection2.addRequestProperty("Cookie", sb2.toString());
        try {
            String language = Locale.getDefault().getLanguage();
            boolean equalsIgnoreCase = language.equalsIgnoreCase("zh");
            String str2 = StorageInterface.KEY_SPLITER;
            String str3 = "Accept-Language";
            if (equalsIgnoreCase) {
                httpURLConnection = this.f15429q;
                sb = new StringBuilder();
                sb.append(Locale.getDefault().toString());
                sb.append(str2);
                sb.append(language);
                sb.append(";q=0.9");
            } else {
                httpURLConnection = this.f15429q;
                sb = new StringBuilder();
                sb.append(Locale.getDefault().toString());
                sb.append(str2);
                sb.append(language);
                sb.append(";q=0.9,en-US;q=0.6,en;q=0.4");
            }
            httpURLConnection.addRequestProperty(str3, sb.toString());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private void m19599b(int i, int i2, byte[] bArr) {
        this.f15417d = i;
        this.f15418e = i2;
        this.f15419f = bArr;
    }

    /* renamed from: a */
    public synchronized void mo25725a(int i, int i2, byte[] bArr) {
        if (!this.f15425l) {
            this.f15423j = 2;
            m19599b(i, i2, bArr);
            this.f15425l = true;
            this.f15424k = 0;
            this.f15426m = new HandlerThread("request");
            this.f15426m.start();
            this.f15427n = new Handler(this.f15426m.getLooper(), new Callback() {
                public boolean handleMessage(Message message) {
                    if (C4778b.this.f15424k >= C4778b.this.f15423j) {
                        C4778b.this.f15425l = false;
                        C4778b.this.f15424k = 0;
                        C4778b.this.f15426m.quit();
                        return false;
                    } else if (C4778b.this.mo25756a()) {
                        C4778b.this.f15425l = false;
                        C4778b.this.f15424k = 0;
                        C4778b.this.f15426m.quit();
                        return true;
                    } else {
                        C4778b.this.f15427n.sendEmptyMessageDelayed(1, (long) (C4778b.this.f15422i * 1));
                        C4778b.this.f15424k = C4778b.this.f15424k + 1;
                        return false;
                    }
                }
            });
            this.f15427n.sendEmptyMessage(1);
        }
    }

    /* renamed from: a */
    public abstract boolean mo25726a(int i, byte[] bArr);
}
