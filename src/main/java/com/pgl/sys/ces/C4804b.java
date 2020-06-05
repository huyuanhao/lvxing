package com.pgl.sys.ces;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.pgl.p359a.p360a.C4777a;
import com.pgl.p359a.p361b.C4787e;
import com.pgl.p359a.p361b.C4788f;
import com.pgl.sys.ces.out.ISdkLite;
import com.pgl.sys.ces.p365a.C4796a;
import com.pgl.sys.ces.p365a.C4797b;
import com.pgl.sys.ces.p365a.C4799c;
import com.pgl.sys.ces.p365a.C4800d;
import com.pgl.sys.ces.p365a.C4801e;
import com.pgl.sys.ces.p365a.C4802f;
import com.pgl.sys.ces.p366b.C4808a;
import com.pgl.sys.ces.p367c.C4810a;
import com.pgl.sys.p362a.C4789a;
import com.pgl.sys.p362a.p363a.C4790a;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.pgl.sys.ces.b */
public class C4804b extends Thread implements ISdkLite {
    /* renamed from: g */
    public static boolean f15452g = false;
    /* renamed from: h */
    public static boolean f15453h = false;
    /* renamed from: i */
    private static volatile C4804b f15454i = null;
    /* renamed from: j */
    private static boolean f15455j = false;
    /* access modifiers changed from: private|static */
    /* renamed from: l */
    public static boolean f15456l = false;
    /* renamed from: m */
    private static Map<String, Object> f15457m;
    /* renamed from: a */
    public boolean f15458a = false;
    /* renamed from: b */
    public Context f15459b = null;
    /* renamed from: c */
    public String f15460c;
    /* renamed from: d */
    public String f15461d;
    /* renamed from: e */
    public String f15462e;
    /* renamed from: f */
    public String f15463f;
    /* renamed from: k */
    private boolean f15464k;

    private C4804b(Context context, String str) {
        String str2 = "";
        this.f15460c = str2;
        this.f15461d = str2;
        this.f15462e = str2;
        this.f15463f = str2;
        this.f15464k = false;
        setName("CZL-00");
        this.f15459b = context;
        this.f15460c = str;
    }

    /* renamed from: a */
    public static C4804b m19658a() {
        return f15454i;
    }

    /* renamed from: a */
    public static C4804b m19659a(Context context, String str, int i) {
        if (f15454i == null) {
            synchronized (C4804b.class) {
                if (f15454i == null) {
                    if (context == null) {
                        context = C4796a.m19631a().getApplicationContext();
                    }
                    if (context == null) {
                        return null;
                    }
                    f15454i = new C4804b(context, str);
                }
                C4777a.m19589a(i);
                C4787e.m19623a(context, "nms");
                m19660a(context);
            }
        }
        return f15454i;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:(3:3|4|(3:6|7|8))|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x00ca */
    /* renamed from: a */
    private static void m19660a(android.content.Context r5) {
        /*
        java.lang.Class<com.pgl.sys.ces.b> r0 = com.pgl.sys.ces.C4804b.class
        monitor-enter(r0)
        if (r5 == 0) goto L_0x00ca
        boolean r1 = f15455j     // Catch:{ all -> 0x00cc }
        if (r1 != 0) goto L_0x00ca
        r1 = 101(0x65, float:1.42E-43)
        java.lang.String r2 = "0"
        r3 = 0
        com.pgl.sys.ces.C4795a.meta(r1, r3, r2)     // Catch:{ all -> 0x00ca }
        r1 = 1020(0x3fc, float:1.43E-42)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
        r2.<init>()     // Catch:{ all -> 0x00ca }
        java.lang.String r4 = ""
        r2.append(r4)     // Catch:{ all -> 0x00ca }
        java.lang.String r4 = m19664b()     // Catch:{ all -> 0x00ca }
        r2.append(r4)     // Catch:{ all -> 0x00ca }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ca }
        com.pgl.sys.ces.C4795a.meta(r1, r3, r2)     // Catch:{ all -> 0x00ca }
        r1 = 105(0x69, float:1.47E-43)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
        r2.<init>()     // Catch:{ all -> 0x00ca }
        java.lang.String r4 = ""
        r2.append(r4)     // Catch:{ all -> 0x00ca }
        int r4 = com.pgl.sys.ces.p365a.C4796a.m19633b(r5)     // Catch:{ all -> 0x00ca }
        r2.append(r4)     // Catch:{ all -> 0x00ca }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ca }
        com.pgl.sys.ces.C4795a.meta(r1, r3, r2)     // Catch:{ all -> 0x00ca }
        r1 = 106(0x6a, float:1.49E-43)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
        r2.<init>()     // Catch:{ all -> 0x00ca }
        java.lang.String r4 = ""
        r2.append(r4)     // Catch:{ all -> 0x00ca }
        java.lang.String r4 = com.pgl.sys.ces.p365a.C4796a.m19632a(r5)     // Catch:{ all -> 0x00ca }
        r2.append(r4)     // Catch:{ all -> 0x00ca }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ca }
        com.pgl.sys.ces.C4795a.meta(r1, r3, r2)     // Catch:{ all -> 0x00ca }
        r1 = 107(0x6b, float:1.5E-43)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
        r2.<init>()     // Catch:{ all -> 0x00ca }
        java.lang.String r4 = ""
        r2.append(r4)     // Catch:{ all -> 0x00ca }
        java.lang.String r4 = com.pgl.sys.ces.p365a.C4796a.m19636c(r5)     // Catch:{ all -> 0x00ca }
        r2.append(r4)     // Catch:{ all -> 0x00ca }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ca }
        com.pgl.sys.ces.C4795a.meta(r1, r3, r2)     // Catch:{ all -> 0x00ca }
        r1 = 108(0x6c, float:1.51E-43)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
        r2.<init>()     // Catch:{ all -> 0x00ca }
        java.lang.String r4 = ""
        r2.append(r4)     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = com.pgl.sys.ces.p365a.C4796a.m19637d(r5)     // Catch:{ all -> 0x00ca }
        r2.append(r5)     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x00ca }
        com.pgl.sys.ces.C4795a.meta(r1, r3, r5)     // Catch:{ all -> 0x00ca }
        r5 = 109(0x6d, float:1.53E-43)
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
        r1.<init>()     // Catch:{ all -> 0x00ca }
        java.lang.String r2 = ""
        r1.append(r2)     // Catch:{ all -> 0x00ca }
        java.lang.String r2 = com.pgl.sys.ces.p365a.C4796a.m19634b()     // Catch:{ all -> 0x00ca }
        r1.append(r2)     // Catch:{ all -> 0x00ca }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ca }
        com.pgl.sys.ces.C4795a.meta(r5, r3, r1)     // Catch:{ all -> 0x00ca }
        r5 = 110(0x6e, float:1.54E-43)
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
        r1.<init>()     // Catch:{ all -> 0x00ca }
        java.lang.String r2 = ""
        r1.append(r2)     // Catch:{ all -> 0x00ca }
        java.lang.String r2 = com.pgl.sys.ces.p365a.C4796a.m19635c()     // Catch:{ all -> 0x00ca }
        r1.append(r2)     // Catch:{ all -> 0x00ca }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ca }
        com.pgl.sys.ces.C4795a.meta(r5, r3, r1)     // Catch:{ all -> 0x00ca }
        r5 = 1
        f15455j = r5     // Catch:{ all -> 0x00ca }
    L_0x00ca:
        monitor-exit(r0)     // Catch:{ all -> 0x00cc }
        return
    L_0x00cc:
        r5 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x00cc }
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.sys.ces.C4804b.m19660a(android.content.Context):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19662a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("CZL-");
        sb.append(str);
        new Thread(sb.toString()) {
            public void run() {
                C4812d.f15477a = 0;
                C4812d.m19682a(C4804b.this.f15459b);
            }
        }.start();
    }

    /* renamed from: b */
    public static String m19664b() {
        return m19658a().f15460c;
    }

    /* renamed from: c */
    public static String m19665c() {
        return m19658a().f15462e;
    }

    /* renamed from: d */
    public static String m19666d() {
        return m19658a().f15461d;
    }

    /* renamed from: e */
    private boolean m19667e() {
        return this.f15464k;
    }

    /* renamed from: f */
    private void m19668f() {
        C4789a.m19627a(this.f15459b, m19664b(), new C4790a() {
            /* renamed from: a */
            public void mo25732a(String str) {
                C4804b.f15456l = true;
            }
        });
    }

    /* renamed from: g */
    private boolean m19669g() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f15459b.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null || activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public void SetRegionType(int i) {
        C4777a.m19589a(i);
    }

    /* renamed from: a */
    public Object mo25741a(int i, Object obj) {
        String trim;
        String str = null;
        if (i == 123) {
            return C4801e.m19652a(this.f15459b);
        }
        if (i == 121) {
            return C4799c.m19646c(this.f15459b);
        }
        if (i == 122) {
            return C4799c.m19643a();
        }
        if (i == 126) {
            return C4799c.m19647d(this.f15459b);
        }
        if (i == 127) {
            return C4799c.m19644a(this.f15459b);
        }
        if (i == 128) {
            return C4799c.m19645b(this.f15459b);
        }
        if (i == 120) {
            return C4797b.m19638a();
        }
        if (i == 124) {
            return C4802f.m19656b(this.f15459b);
        }
        if (i == 130) {
            return C4802f.m19655a(this.f15459b);
        }
        if (i == 125) {
            return C4802f.m19657c(this.f15459b);
        }
        if (i == 129) {
            return C4800d.m19648a(this.f15459b);
        }
        if (i == 131) {
            return C4789a.m19626a();
        }
        if (i == 132) {
            reportNow((String) obj);
            return null;
        } else if (i == 134) {
            return C4808a.m19672a(this.f15459b).mo25753a();
        } else {
            if (i == 133) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Entry entry : f15457m.entrySet()) {
                        if (entry.getValue() == null) {
                            jSONObject.put((String) entry.getKey(), "");
                        } else {
                            jSONObject.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    str = jSONObject.toString();
                } catch (Throwable unused) {
                }
                trim = str == null ? "{}" : str.trim();
            } else if (i == 135) {
                String a = C4809c.m19676a();
                trim = a == null ? "0000000000000000000000000000000000000000" : a.trim();
            } else if (i != 136) {
                return null;
            } else {
                try {
                    str = this.f15459b.getPackageManager().getPackageInfo(this.f15459b.getPackageName(), 64).signatures[0].toByteArray();
                    return str;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return str;
                }
            }
            return trim;
        }
    }

    public String debugEntry(Context context, int i) {
        return (String) C4795a.meta(1024768, null, null);
    }

    public String onEvent() {
        return C4789a.m19626a();
    }

    public String pullSg() {
        return C4809c.m19676a();
    }

    public String pullVer(String str) {
        return C4809c.m19677a(str);
    }

    public void reportNow(final String str) {
        try {
            new Thread("CZL-LRT") {
                public void run() {
                    try {
                        if (!C4804b.f15453h) {
                            C4804b.this.m19662a("RPT-S");
                        }
                        long j = 0;
                        long timeInMillis = C4804b.m19658a().f15458a ? Calendar.getInstance().getTimeInMillis() : 0;
                        byte[] bArr = (byte[]) C4795a.meta(222, C4804b.this.f15459b, str);
                        if (C4804b.m19658a().f15458a) {
                            j = Calendar.getInstance().getTimeInMillis();
                        }
                        if (C4804b.m19658a().f15458a) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("[Efficient] report : ");
                            sb.append(j - timeInMillis);
                            Log.d("CZL_Efficient", sb.toString());
                        }
                        if (bArr == null || bArr.length <= 0) {
                            throw new NullPointerException("NullPointerException");
                        }
                        new C4810a(C4804b.this.f15459b, C4804b.this.f15461d).mo25725a(1, 2, bArr);
                    } catch (Throwable unused) {
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void run() {
        this.f15464k = true;
        C4788f.m19625a(60000);
        reportNow("CZL-L1st");
        while (true) {
            C4788f.m19625a(7200000);
            if (m19669g()) {
                reportNow("CZL-LLP");
                C4788f.m19625a(60000);
                m19662a("CZL-LSP");
            }
        }
    }

    public void setCustomInfo(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            f15457m = hashMap;
        }
    }

    public void setEfficientDebug(boolean z) {
        this.f15458a = z;
    }

    public void setParams(String str, String str2) {
        if (str != null && str.length() > 0) {
            this.f15462e = str;
            C4795a.meta(103, null, str);
        }
        if (str2 != null && str2.length() > 0) {
            this.f15463f = str2;
            C4795a.meta(104, null, str2);
        }
        m19662a("SP1");
        m19668f();
        if (!isAlive() || !m19667e()) {
            try {
                start();
            } catch (Throwable unused) {
            }
        }
    }
}
