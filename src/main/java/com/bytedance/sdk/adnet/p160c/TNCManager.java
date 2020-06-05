package com.bytedance.sdk.adnet.p160c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.p158a.AppConfig;
import com.bytedance.sdk.adnet.p161d.C1987d;
import com.bytedance.sdk.adnet.p161d.NetworkUtils;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.sdk.adnet.c.f */
public class TNCManager implements TNCBridge {
    /* renamed from: c */
    private static TNCManager f6166c;
    /* renamed from: a */
    Handler f6167a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 10000) {
                TNCManager.this.m7775a(message.arg1 != 0);
            }
        }
    };
    /* renamed from: b */
    private long f6168b = 0;
    /* renamed from: d */
    private boolean f6169d = false;
    /* renamed from: e */
    private Context f6170e;
    /* renamed from: f */
    private TNCConfigHandler f6171f;
    /* renamed from: g */
    private int f6172g = 0;
    /* renamed from: h */
    private long f6173h = 0;
    /* renamed from: i */
    private int f6174i = 0;
    /* renamed from: j */
    private HashMap<String, Integer> f6175j = new HashMap<>();
    /* renamed from: k */
    private HashMap<String, Integer> f6176k = new HashMap<>();
    /* renamed from: l */
    private int f6177l = 0;
    /* renamed from: m */
    private HashMap<String, Integer> f6178m = new HashMap<>();
    /* renamed from: n */
    private HashMap<String, Integer> f6179n = new HashMap<>();
    /* renamed from: o */
    private boolean f6180o = true;
    /* renamed from: p */
    private Map<String, Integer> f6181p = new HashMap();

    /* renamed from: a */
    private boolean m7777a(int i) {
        return i >= 200 && i < 400;
    }

    /* renamed from: a */
    public static synchronized TNCManager m7771a() {
        TNCManager fVar;
        synchronized (TNCManager.class) {
            if (f6166c == null) {
                f6166c = new TNCManager();
            }
            fVar = f6166c;
        }
        return fVar;
    }

    private TNCManager() {
    }

    /* renamed from: b */
    public void mo14246b() {
        this.f6181p.clear();
    }

    /* renamed from: a */
    public synchronized void mo14245a(Context context, boolean z) {
        if (!this.f6169d) {
            this.f6170e = context;
            this.f6180o = z;
            this.f6171f = new TNCConfigHandler(context, z);
            if (z) {
                m7782f();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("initTnc, isMainProc: ");
            sb.append(z);
            sb.append(" probeCmd: ");
            sb.append(this.f6172g);
            sb.append(" probeVersion: ");
            sb.append(this.f6173h);
            C1987d.m7948b("TNCManager", sb.toString());
            this.f6169d = true;
        }
    }

    /* renamed from: f */
    private void m7782f() {
        SharedPreferences sharedPreferences = this.f6170e.getSharedPreferences("ttnet_tnc_config", 0);
        this.f6172g = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.f6173h = sharedPreferences.getLong("tnc_probe_version", 0);
    }

    /* renamed from: c */
    public TNCConfig mo14247c() {
        TNCConfigHandler eVar = this.f6171f;
        if (eVar != null) {
            return eVar.mo14243c();
        }
        return null;
    }

    /* renamed from: d */
    public Map<String, String> mo14248d() {
        TNCConfig c = mo14247c();
        if (c != null) {
            return c.f6150d;
        }
        return null;
    }

    /* renamed from: e */
    public TNCConfigHandler mo14249e() {
        return this.f6171f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071  */
    /* renamed from: a */
    public java.lang.String mo14244a(java.lang.String r7) {
        /*
        r6 = this;
        boolean r0 = android.text.TextUtils.isEmpty(r7)
        if (r0 != 0) goto L_0x00f8
        java.lang.String r0 = "/network/get_network"
        boolean r0 = r7.contains(r0)
        if (r0 != 0) goto L_0x00f8
        java.lang.String r0 = "/get_domains/v4"
        boolean r0 = r7.contains(r0)
        if (r0 != 0) goto L_0x00f8
        java.lang.String r0 = "/ies/speed"
        boolean r0 = r7.contains(r0)
        if (r0 == 0) goto L_0x0020
        goto L_0x00f8
    L_0x0020:
        r0 = 0
        java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x0031 }
        r1.<init>(r7)     // Catch:{ all -> 0x0031 }
        java.lang.String r2 = r1.getProtocol()     // Catch:{ all -> 0x0031 }
        java.lang.String r0 = r1.getHost()     // Catch:{ all -> 0x002f }
        goto L_0x0036
    L_0x002f:
        r1 = move-exception
        goto L_0x0033
    L_0x0031:
        r1 = move-exception
        r2 = r0
    L_0x0033:
        r1.printStackTrace()
    L_0x0036:
        boolean r1 = android.text.TextUtils.isEmpty(r2)
        if (r1 != 0) goto L_0x00f8
        java.lang.String r1 = "http"
        boolean r1 = r1.equals(r2)
        if (r1 != 0) goto L_0x004c
        java.lang.String r1 = "https"
        boolean r1 = r1.equals(r2)
        if (r1 == 0) goto L_0x00f8
    L_0x004c:
        boolean r1 = android.text.TextUtils.isEmpty(r0)
        if (r1 == 0) goto L_0x0054
        goto L_0x00f8
    L_0x0054:
        boolean r1 = r6.m7781d(r0)
        java.lang.String r3 = "TNCManager"
        if (r1 == 0) goto L_0x0071
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "handleHostMapping, TNC host faild num over limit: "
        r1.append(r2)
        r1.append(r0)
        java.lang.String r0 = r1.toString()
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r3, r0)
        return r7
    L_0x0071:
        java.util.Map r1 = r6.mo14248d()
        if (r1 == 0) goto L_0x00e4
        boolean r4 = r1.containsKey(r0)
        if (r4 != 0) goto L_0x007e
        goto L_0x00e4
    L_0x007e:
        java.lang.Object r1 = r1.get(r0)
        java.lang.String r1 = (java.lang.String) r1
        boolean r4 = android.text.TextUtils.isEmpty(r1)
        if (r4 == 0) goto L_0x008b
        return r7
    L_0x008b:
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r5 = "handleHostMapping, match, origin: "
        r4.append(r5)
        r4.append(r7)
        java.lang.String r4 = r4.toString()
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r3, r4)
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        r4.append(r2)
        java.lang.String r5 = "://"
        r4.append(r5)
        r4.append(r0)
        java.lang.String r0 = r4.toString()
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        r4.append(r2)
        r4.append(r5)
        r4.append(r1)
        java.lang.String r1 = r4.toString()
        boolean r2 = r7.startsWith(r0)
        if (r2 == 0) goto L_0x00cf
        java.lang.String r7 = r7.replaceFirst(r0, r1)
    L_0x00cf:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "handleHostMapping, target: "
        r0.append(r1)
        r0.append(r7)
        java.lang.String r0 = r0.toString()
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r3, r0)
        return r7
    L_0x00e4:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "handleHostMapping, nomatch: "
        r1.append(r2)
        r1.append(r0)
        java.lang.String r0 = r1.toString()
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r3, r0)
    L_0x00f8:
        return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.p160c.TNCManager.mo14244a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0198, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x019d, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo14237a(com.bytedance.sdk.adnet.core.Request r8, com.bytedance.sdk.adnet.core.C1982p r9) {
        /*
        r7 = this;
        monitor-enter(r7)
        if (r8 == 0) goto L_0x019c
        if (r9 != 0) goto L_0x0007
        goto L_0x019c
    L_0x0007:
        boolean r0 = r7.f6180o     // Catch:{ all -> 0x0199 }
        if (r0 != 0) goto L_0x000d
        monitor-exit(r7)
        return
    L_0x000d:
        android.content.Context r0 = r7.f6170e     // Catch:{ all -> 0x0199 }
        boolean r0 = com.bytedance.sdk.adnet.p161d.NetworkUtils.m7954a(r0)     // Catch:{ all -> 0x0199 }
        if (r0 != 0) goto L_0x0017
        monitor-exit(r7)
        return
    L_0x0017:
        r0 = 0
        java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0023 }
        java.lang.String r2 = r8.getUrl()     // Catch:{ Exception -> 0x0023 }
        r1.<init>(r2)     // Catch:{ Exception -> 0x0023 }
        r0 = r1
        goto L_0x0024
    L_0x0024:
        if (r0 != 0) goto L_0x0028
        monitor-exit(r7)
        return
    L_0x0028:
        java.lang.String r1 = r0.getProtocol()     // Catch:{ all -> 0x0199 }
        java.lang.String r2 = r0.getHost()     // Catch:{ all -> 0x0199 }
        java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x0199 }
        java.lang.String r8 = r8.getIpAddrStr()     // Catch:{ all -> 0x0199 }
        long r3 = r9.f6300h     // Catch:{ all -> 0x0199 }
        int r4 = (int) r3     // Catch:{ all -> 0x0199 }
        java.lang.String r3 = "http"
        boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0199 }
        if (r3 != 0) goto L_0x004d
        java.lang.String r3 = "https"
        boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0199 }
        if (r3 != 0) goto L_0x004d
        monitor-exit(r7)
        return
    L_0x004d:
        boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0199 }
        if (r3 == 0) goto L_0x0055
        monitor-exit(r7)
        return
    L_0x0055:
        java.lang.String r3 = "TNCManager"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
        r5.<init>()     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = "onResponse, url: "
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        r5.append(r1)     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = "://"
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        r5.append(r2)     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = "#"
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        r5.append(r8)     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = "#"
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        r5.append(r4)     // Catch:{ all -> 0x0199 }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0199 }
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r3, r5)     // Catch:{ all -> 0x0199 }
        com.bytedance.sdk.adnet.c.d r3 = r7.mo14247c()     // Catch:{ all -> 0x0199 }
        if (r3 == 0) goto L_0x0090
        boolean r5 = r3.f6148b     // Catch:{ all -> 0x0199 }
        if (r5 == 0) goto L_0x0090
        r7.m7774a(r9, r2)     // Catch:{ all -> 0x0199 }
    L_0x0090:
        if (r3 != 0) goto L_0x0094
        monitor-exit(r7)
        return
    L_0x0094:
        java.lang.String r9 = "TNCManager"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
        r5.<init>()     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = "onResponse, url matched: "
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        r5.append(r1)     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = "://"
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        r5.append(r2)     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = "#"
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        r5.append(r8)     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = "#"
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        r5.append(r4)     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = " "
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        int r6 = r7.f6174i     // Catch:{ all -> 0x0199 }
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = "#"
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r7.f6175j     // Catch:{ all -> 0x0199 }
        int r6 = r6.size()     // Catch:{ all -> 0x0199 }
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = "#"
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r7.f6176k     // Catch:{ all -> 0x0199 }
        int r6 = r6.size()     // Catch:{ all -> 0x0199 }
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = " "
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        int r6 = r7.f6177l     // Catch:{ all -> 0x0199 }
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = "#"
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r7.f6178m     // Catch:{ all -> 0x0199 }
        int r6 = r6.size()     // Catch:{ all -> 0x0199 }
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        java.lang.String r6 = "#"
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r7.f6179n     // Catch:{ all -> 0x0199 }
        int r6 = r6.size()     // Catch:{ all -> 0x0199 }
        r5.append(r6)     // Catch:{ all -> 0x0199 }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0199 }
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r9, r5)     // Catch:{ all -> 0x0199 }
        if (r4 <= 0) goto L_0x0197
        boolean r9 = r7.m7777a(r4)     // Catch:{ all -> 0x0199 }
        if (r9 == 0) goto L_0x0125
        int r8 = r7.f6174i     // Catch:{ all -> 0x0199 }
        if (r8 > 0) goto L_0x011e
        int r8 = r7.f6177l     // Catch:{ all -> 0x0199 }
        if (r8 <= 0) goto L_0x0121
    L_0x011e:
        r7.m7783g()     // Catch:{ all -> 0x0199 }
    L_0x0121:
        r7.m7780c(r2)     // Catch:{ all -> 0x0199 }
        goto L_0x0197
    L_0x0125:
        boolean r9 = r7.m7779b(r4)     // Catch:{ all -> 0x0199 }
        if (r9 != 0) goto L_0x0197
        int r9 = r7.f6177l     // Catch:{ all -> 0x0199 }
        int r9 = r9 + 1
        r7.f6177l = r9     // Catch:{ all -> 0x0199 }
        java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.f6178m     // Catch:{ all -> 0x0199 }
        r5 = 0
        java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0199 }
        r9.put(r0, r6)     // Catch:{ all -> 0x0199 }
        java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.f6179n     // Catch:{ all -> 0x0199 }
        java.lang.Integer r0 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0199 }
        r9.put(r8, r0)     // Catch:{ all -> 0x0199 }
        int r9 = r7.f6177l     // Catch:{ all -> 0x0199 }
        int r0 = r3.f6154h     // Catch:{ all -> 0x0199 }
        if (r9 < r0) goto L_0x0194
        java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.f6178m     // Catch:{ all -> 0x0199 }
        int r9 = r9.size()     // Catch:{ all -> 0x0199 }
        int r0 = r3.f6155i     // Catch:{ all -> 0x0199 }
        if (r9 < r0) goto L_0x0194
        java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.f6179n     // Catch:{ all -> 0x0199 }
        int r9 = r9.size()     // Catch:{ all -> 0x0199 }
        int r0 = r3.f6156j     // Catch:{ all -> 0x0199 }
        if (r9 < r0) goto L_0x0194
        java.lang.String r9 = "TNCManager"
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
        r0.<init>()     // Catch:{ all -> 0x0199 }
        java.lang.String r3 = "onResponse, url doUpdate: "
        r0.append(r3)     // Catch:{ all -> 0x0199 }
        r0.append(r1)     // Catch:{ all -> 0x0199 }
        java.lang.String r1 = "://"
        r0.append(r1)     // Catch:{ all -> 0x0199 }
        r0.append(r2)     // Catch:{ all -> 0x0199 }
        java.lang.String r1 = "#"
        r0.append(r1)     // Catch:{ all -> 0x0199 }
        r0.append(r8)     // Catch:{ all -> 0x0199 }
        java.lang.String r8 = "#"
        r0.append(r8)     // Catch:{ all -> 0x0199 }
        r0.append(r4)     // Catch:{ all -> 0x0199 }
        java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x0199 }
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r9, r8)     // Catch:{ all -> 0x0199 }
        r8 = 0
        r7.m7776a(r5, r8)     // Catch:{ all -> 0x0199 }
        r7.m7783g()     // Catch:{ all -> 0x0199 }
    L_0x0194:
        r7.m7778b(r2)     // Catch:{ all -> 0x0199 }
    L_0x0197:
        monitor-exit(r7)
        return
    L_0x0199:
        r8 = move-exception
        monitor-exit(r7)
        throw r8
    L_0x019c:
        monitor-exit(r7)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.p160c.TNCManager.mo14237a(com.bytedance.sdk.adnet.core.Request, com.bytedance.sdk.adnet.core.p):void");
    }

    /* renamed from: b */
    private void m7778b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Map d = mo14248d();
            if (d != null && d.containsValue(str)) {
                if (this.f6181p.get(str) == null) {
                    this.f6181p.put(str, Integer.valueOf(1));
                } else {
                    this.f6181p.put(str, Integer.valueOf(((Integer) this.f6181p.get(str)).intValue() + 1));
                }
            }
        }
    }

    /* renamed from: c */
    private void m7780c(String str) {
        if (!TextUtils.isEmpty(str) && this.f6181p.containsKey(str)) {
            this.f6181p.put(str, Integer.valueOf(0));
        }
    }

    /* renamed from: d */
    private boolean m7781d(String str) {
        Map d = mo14248d();
        if (d == null) {
            return false;
        }
        String str2 = (String) d.get(str);
        if (TextUtils.isEmpty(str2) || this.f6181p.get(str2) == null || ((Integer) this.f6181p.get(str2)).intValue() < 3) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleHostMapping, TNC host faild num over limit: ");
        sb.append(str);
        C1987d.m7948b("TNCManager", sb.toString());
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x013a, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo14238a(com.bytedance.sdk.adnet.core.Request r8, java.lang.Exception r9) {
        /*
        r7 = this;
        monitor-enter(r7)
        if (r8 == 0) goto L_0x0139
        if (r9 != 0) goto L_0x0007
        goto L_0x0139
    L_0x0007:
        boolean r0 = r7.f6180o     // Catch:{ all -> 0x0136 }
        if (r0 != 0) goto L_0x000d
        monitor-exit(r7)
        return
    L_0x000d:
        android.content.Context r0 = r7.f6170e     // Catch:{ all -> 0x0136 }
        boolean r0 = com.bytedance.sdk.adnet.p161d.NetworkUtils.m7954a(r0)     // Catch:{ all -> 0x0136 }
        if (r0 != 0) goto L_0x0017
        monitor-exit(r7)
        return
    L_0x0017:
        r0 = 0
        java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0023 }
        java.lang.String r2 = r8.getUrl()     // Catch:{ Exception -> 0x0023 }
        r1.<init>(r2)     // Catch:{ Exception -> 0x0023 }
        r0 = r1
        goto L_0x0024
    L_0x0024:
        if (r0 != 0) goto L_0x0028
        monitor-exit(r7)
        return
    L_0x0028:
        java.lang.String r1 = r0.getProtocol()     // Catch:{ all -> 0x0136 }
        java.lang.String r2 = r0.getHost()     // Catch:{ all -> 0x0136 }
        java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x0136 }
        java.lang.String r8 = r8.getIpAddrStr()     // Catch:{ all -> 0x0136 }
        java.lang.String r9 = r7.m7772a(r9)     // Catch:{ all -> 0x0136 }
        java.lang.String r3 = "http"
        boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0136 }
        if (r3 != 0) goto L_0x004e
        java.lang.String r3 = "https"
        boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0136 }
        if (r3 != 0) goto L_0x004e
        monitor-exit(r7)
        return
    L_0x004e:
        com.bytedance.sdk.adnet.c.d r3 = r7.mo14247c()     // Catch:{ all -> 0x0136 }
        if (r3 != 0) goto L_0x0056
        monitor-exit(r7)
        return
    L_0x0056:
        java.lang.String r4 = "TNCManager"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0136 }
        r5.<init>()     // Catch:{ all -> 0x0136 }
        java.lang.String r6 = "onError, url matched: "
        r5.append(r6)     // Catch:{ all -> 0x0136 }
        r5.append(r1)     // Catch:{ all -> 0x0136 }
        java.lang.String r6 = "://"
        r5.append(r6)     // Catch:{ all -> 0x0136 }
        r5.append(r2)     // Catch:{ all -> 0x0136 }
        java.lang.String r6 = "#"
        r5.append(r6)     // Catch:{ all -> 0x0136 }
        r5.append(r8)     // Catch:{ all -> 0x0136 }
        java.lang.String r6 = "#"
        r5.append(r6)     // Catch:{ all -> 0x0136 }
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        java.lang.String r9 = " "
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        int r9 = r7.f6174i     // Catch:{ all -> 0x0136 }
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        java.lang.String r9 = "#"
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.f6175j     // Catch:{ all -> 0x0136 }
        int r9 = r9.size()     // Catch:{ all -> 0x0136 }
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        java.lang.String r9 = "#"
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.f6176k     // Catch:{ all -> 0x0136 }
        int r9 = r9.size()     // Catch:{ all -> 0x0136 }
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        java.lang.String r9 = " "
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        int r9 = r7.f6177l     // Catch:{ all -> 0x0136 }
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        java.lang.String r9 = "#"
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.f6178m     // Catch:{ all -> 0x0136 }
        int r9 = r9.size()     // Catch:{ all -> 0x0136 }
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        java.lang.String r9 = "#"
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.f6179n     // Catch:{ all -> 0x0136 }
        int r9 = r9.size()     // Catch:{ all -> 0x0136 }
        r5.append(r9)     // Catch:{ all -> 0x0136 }
        java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x0136 }
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r4, r9)     // Catch:{ all -> 0x0136 }
        int r9 = r7.f6174i     // Catch:{ all -> 0x0136 }
        int r9 = r9 + 1
        r7.f6174i = r9     // Catch:{ all -> 0x0136 }
        java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.f6175j     // Catch:{ all -> 0x0136 }
        r4 = 0
        java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0136 }
        r9.put(r0, r5)     // Catch:{ all -> 0x0136 }
        java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.f6176k     // Catch:{ all -> 0x0136 }
        java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0136 }
        r9.put(r8, r0)     // Catch:{ all -> 0x0136 }
        int r9 = r7.f6174i     // Catch:{ all -> 0x0136 }
        int r0 = r3.f6151e     // Catch:{ all -> 0x0136 }
        if (r9 < r0) goto L_0x0131
        java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.f6175j     // Catch:{ all -> 0x0136 }
        int r9 = r9.size()     // Catch:{ all -> 0x0136 }
        int r0 = r3.f6152f     // Catch:{ all -> 0x0136 }
        if (r9 < r0) goto L_0x0131
        java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.f6176k     // Catch:{ all -> 0x0136 }
        int r9 = r9.size()     // Catch:{ all -> 0x0136 }
        int r0 = r3.f6153g     // Catch:{ all -> 0x0136 }
        if (r9 < r0) goto L_0x0131
        java.lang.String r9 = "TNCManager"
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0136 }
        r0.<init>()     // Catch:{ all -> 0x0136 }
        java.lang.String r3 = "onError, url doUpate: "
        r0.append(r3)     // Catch:{ all -> 0x0136 }
        r0.append(r1)     // Catch:{ all -> 0x0136 }
        java.lang.String r1 = "://"
        r0.append(r1)     // Catch:{ all -> 0x0136 }
        r0.append(r2)     // Catch:{ all -> 0x0136 }
        java.lang.String r1 = "#"
        r0.append(r1)     // Catch:{ all -> 0x0136 }
        r0.append(r8)     // Catch:{ all -> 0x0136 }
        java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x0136 }
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r9, r8)     // Catch:{ all -> 0x0136 }
        r8 = 0
        r7.m7776a(r4, r8)     // Catch:{ all -> 0x0136 }
        r7.m7783g()     // Catch:{ all -> 0x0136 }
    L_0x0131:
        r7.m7778b(r2)     // Catch:{ all -> 0x0136 }
        monitor-exit(r7)
        return
    L_0x0136:
        r8 = move-exception
        monitor-exit(r7)
        throw r8
    L_0x0139:
        monitor-exit(r7)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.p160c.TNCManager.mo14238a(com.bytedance.sdk.adnet.core.Request, java.lang.Exception):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2  */
    /* renamed from: a */
    private void m7774a(com.bytedance.sdk.adnet.core.C1982p r12, java.lang.String r13) {
        /*
        r11 = this;
        if (r12 != 0) goto L_0x0003
        return
    L_0x0003:
        boolean r0 = r11.f6180o
        if (r0 != 0) goto L_0x0008
        return
    L_0x0008:
        r0 = 0
        java.lang.String r1 = "tt-idc-switch"
        java.lang.String r12 = r12.mo14372a(r1, r0)
        boolean r0 = android.text.TextUtils.isEmpty(r12)
        java.lang.String r1 = "TNCManager"
        if (r0 == 0) goto L_0x002c
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        r12.<init>()
        java.lang.String r0 = "handleTncProbe, no probeProto, "
        r12.append(r0)
        r12.append(r13)
        java.lang.String r12 = r12.toString()
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r1, r12)
        return
    L_0x002c:
        java.lang.String r0 = "@"
        java.lang.String[] r12 = r12.split(r0)
        if (r12 == 0) goto L_0x0104
        int r2 = r12.length
        r3 = 2
        if (r2 == r3) goto L_0x003a
        goto L_0x0104
    L_0x003a:
        r2 = 1
        r3 = 0
        r5 = 0
        r6 = r12[r5]     // Catch:{ all -> 0x004d }
        int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ all -> 0x004d }
        r12 = r12[r2]     // Catch:{ all -> 0x004b }
        long r7 = java.lang.Long.parseLong(r12)     // Catch:{ all -> 0x004b }
        goto L_0x0067
    L_0x004b:
        r12 = move-exception
        goto L_0x004f
    L_0x004d:
        r12 = move-exception
        r6 = 0
    L_0x004f:
        r12.printStackTrace()
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        r12.<init>()
        java.lang.String r7 = "handleTncProbe, probeProto except, "
        r12.append(r7)
        r12.append(r13)
        java.lang.String r12 = r12.toString()
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r1, r12)
        r7 = r3
    L_0x0067:
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        r12.<init>()
        java.lang.String r9 = "handleTncProbe, local: "
        r12.append(r9)
        int r9 = r11.f6172g
        r12.append(r9)
        r12.append(r0)
        long r9 = r11.f6173h
        r12.append(r9)
        java.lang.String r9 = " svr: "
        r12.append(r9)
        r12.append(r6)
        r12.append(r0)
        r12.append(r7)
        java.lang.String r0 = " "
        r12.append(r0)
        r12.append(r13)
        java.lang.String r12 = r12.toString()
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r1, r12)
        long r9 = r11.f6173h
        int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
        if (r12 > 0) goto L_0x00a2
        return
    L_0x00a2:
        r11.f6172g = r6
        r11.f6173h = r7
        android.content.Context r12 = r11.f6170e
        java.lang.String r9 = "ttnet_tnc_config"
        android.content.SharedPreferences r12 = r12.getSharedPreferences(r9, r5)
        android.content.SharedPreferences$Editor r12 = r12.edit()
        java.lang.String r5 = "tnc_probe_cmd"
        android.content.SharedPreferences$Editor r12 = r12.putInt(r5, r6)
        java.lang.String r5 = "tnc_probe_version"
        android.content.SharedPreferences$Editor r12 = r12.putLong(r5, r7)
        r12.apply()
        int r12 = r11.f6172g
        r5 = 10000(0x2710, float:1.4013E-41)
        if (r12 != r5) goto L_0x0103
        com.bytedance.sdk.adnet.c.d r12 = r11.mo14247c()
        if (r12 != 0) goto L_0x00ce
        return
    L_0x00ce:
        java.util.Random r5 = new java.util.Random
        long r6 = java.lang.System.currentTimeMillis()
        r5.<init>(r6)
        int r6 = r12.f6158l
        if (r6 <= 0) goto L_0x00e6
        int r12 = r12.f6158l
        int r12 = r5.nextInt(r12)
        long r3 = (long) r12
        r5 = 1000(0x3e8, double:4.94E-321)
        long r3 = r3 * r5
    L_0x00e6:
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        r12.<init>()
        java.lang.String r5 = "handleTncProbe, updateConfig delay: "
        r12.append(r5)
        r12.append(r3)
        r12.append(r0)
        r12.append(r13)
        java.lang.String r12 = r12.toString()
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r1, r12)
        r11.m7776a(r2, r3)
    L_0x0103:
        return
    L_0x0104:
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        r12.<init>()
        java.lang.String r0 = "handleTncProbe, probeProto err, "
        r12.append(r0)
        r12.append(r13)
        java.lang.String r12 = r12.toString()
        com.bytedance.sdk.adnet.p161d.C1987d.m7948b(r1, r12)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.p160c.TNCManager.m7774a(com.bytedance.sdk.adnet.core.p, java.lang.String):void");
    }

    /* renamed from: a */
    private void m7776a(boolean z, long j) {
        if (!this.f6167a.hasMessages(C7516p.f25219Cf)) {
            Message obtainMessage = this.f6167a.obtainMessage();
            obtainMessage.what = C7516p.f25219Cf;
            obtainMessage.arg1 = z;
            if (j > 0) {
                this.f6167a.sendMessageDelayed(obtainMessage, j);
            } else {
                this.f6167a.sendMessage(obtainMessage);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7775a(boolean z) {
        TNCConfig c = mo14247c();
        if (c != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("doUpdateRemote, ");
            sb.append(z);
            String str = "TNCManager";
            C1987d.m7948b(str, sb.toString());
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.f6168b + (((long) c.f6157k) * 1000) <= elapsedRealtime) {
                this.f6168b = elapsedRealtime;
                AppConfig.m7653a(this.f6170e).mo14165b(NetworkUtils.m7954a(this.f6170e));
                return;
            }
            C1987d.m7948b(str, "doUpdateRemote, time limit");
        }
    }

    /* renamed from: g */
    private void m7783g() {
        C1987d.m7948b("TNCManager", "resetTNCControlState");
        this.f6174i = 0;
        this.f6175j.clear();
        this.f6176k.clear();
        this.f6177l = 0;
        this.f6178m.clear();
        this.f6179n.clear();
    }

    /* renamed from: a */
    private String m7772a(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().toLowerCase();
    }

    /* renamed from: b */
    private boolean m7779b(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        TNCConfig c = mo14247c();
        if (c != null && !TextUtils.isEmpty(c.f6159m)) {
            String str = c.f6159m;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            if (str.contains(sb.toString())) {
                return true;
            }
        }
        return false;
    }
}
