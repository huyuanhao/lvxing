package com.tencent.mta.track.util;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.tencent.mta.track.StatisticsDataAPI;
import com.tencent.mta.track.thrift.C7446l;
import com.tencent.mta.track.thrift.TrackPollReq;
import com.tencent.mta.track.thrift.TrackPollRsp;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.thrift.transport.TSocket;

/* compiled from: ProGuard */
public abstract class ThrifClient {
    /* renamed from: m */
    private static final Map f25005m = new HashMap();
    /* renamed from: a */
    private int f25006a = 0;
    /* renamed from: b */
    protected URI f25007b = null;
    /* renamed from: c */
    private Thread f25008c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C7472k f25009d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C7446l f25010e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public int f25011f = 1000;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public String f25012g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public ArrayList f25013h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public String f25014i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public String f25015j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public Context f25016k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public String f25017l;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public THRIFTSTATE f25018n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public int f25019o;
    /* renamed from: p */
    private String f25020p;
    /* renamed from: q */
    private int f25021q;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.util.ThrifClient$THRIFTSTATE */
    public enum THRIFTSTATE {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED,
        UNKNOW
    }

    /* renamed from: a */
    public abstract void mo35931a(List list);

    public ThrifClient(URI uri, int i, Context context) {
        String str = "";
        this.f25012g = str;
        this.f25013h = new ArrayList();
        this.f25014i = str;
        this.f25015j = str;
        this.f25017l = str;
        this.f25018n = THRIFTSTATE.NOT_YET_CONNECTED;
        this.f25019o = 1;
        this.f25020p = str;
        this.f25021q = 0;
        if (uri != null) {
            this.f25007b = uri;
            this.f25006a = i;
            this.f25009d = new C7472k(this, null);
            this.f25016k = context;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(15:1|2|3|(1:5)(2:6|7)|8|9|10|11|12|13|(1:15)(1:16)|17|(3:19|20|(2:22|23)(1:24))|25|26) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x00bc */
    /* renamed from: e */
    public java.lang.String m32314e() {
        /*
        r9 = this;
        java.lang.String r0 = "app_version"
        java.lang.String r1 = ""
        java.lang.String r2 = "main_bundle_identifier"
        java.lang.String r3 = "Android"
        java.util.Map r4 = f25005m
        java.lang.String r5 = "中国移动"
        java.lang.String r6 = "46000"
        r4.put(r6, r5)
        java.util.Map r4 = f25005m
        java.lang.String r6 = "46002"
        r4.put(r6, r5)
        java.util.Map r4 = f25005m
        java.lang.String r6 = "46007"
        r4.put(r6, r5)
        java.util.Map r4 = f25005m
        java.lang.String r6 = "46008"
        r4.put(r6, r5)
        java.util.Map r4 = f25005m
        java.lang.String r5 = "中国联通"
        java.lang.String r6 = "46001"
        r4.put(r6, r5)
        java.util.Map r4 = f25005m
        java.lang.String r6 = "46006"
        r4.put(r6, r5)
        java.util.Map r4 = f25005m
        java.lang.String r6 = "46009"
        r4.put(r6, r5)
        java.util.Map r4 = f25005m
        java.lang.String r5 = "中国电信"
        java.lang.String r6 = "46003"
        r4.put(r6, r5)
        java.util.Map r4 = f25005m
        java.lang.String r6 = "46005"
        r4.put(r6, r5)
        java.util.Map r4 = f25005m
        java.lang.String r6 = "46011"
        r4.put(r6, r5)
        android.content.Context r4 = r9.f25016k
        android.content.pm.PackageManager r4 = r4.getPackageManager()
        android.content.Context r5 = r9.f25016k
        android.content.res.Resources r5 = r5.getResources()
        android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
        org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0133 }
        r6.<init>()     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r7 = "lib"
        r6.put(r7, r3)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r7 = "lib_version"
        java.lang.String r8 = "3.4.0"
        r6.put(r7, r8)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r7 = "os"
        r6.put(r7, r3)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r3 = "os_version"
        java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r8 = "UNKNOWN"
        if (r7 != 0) goto L_0x0084
        r7 = r8
        goto L_0x0086
    L_0x0084:
        java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ JSONException -> 0x0133 }
    L_0x0086:
        r6.put(r3, r7)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r3 = "api_version"
        int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x0133 }
        r6.put(r3, r7)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r3 = "screen_height"
        int r7 = r5.heightPixels     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ JSONException -> 0x0133 }
        r6.put(r3, r7)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r3 = "screen_width"
        int r5 = r5.widthPixels     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ JSONException -> 0x0133 }
        r6.put(r3, r5)     // Catch:{ JSONException -> 0x0133 }
        android.content.Context r3 = r9.f25016k     // Catch:{ NameNotFoundException -> 0x00bc }
        java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x00bc }
        r5 = 0
        android.content.pm.PackageInfo r3 = r4.getPackageInfo(r3, r5)     // Catch:{ NameNotFoundException -> 0x00bc }
        java.lang.String r4 = r3.packageName     // Catch:{ NameNotFoundException -> 0x00bc }
        r6.put(r2, r4)     // Catch:{ NameNotFoundException -> 0x00bc }
        java.lang.String r3 = r3.versionName     // Catch:{ NameNotFoundException -> 0x00bc }
        r6.put(r0, r3)     // Catch:{ NameNotFoundException -> 0x00bc }
        goto L_0x00c2
    L_0x00bc:
        r6.put(r2, r1)     // Catch:{ JSONException -> 0x0133 }
        r6.put(r0, r1)     // Catch:{ JSONException -> 0x0133 }
    L_0x00c2:
        java.lang.String r0 = "device_name"
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0133 }
        r1.<init>()     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r2 = android.os.Build.BRAND     // Catch:{ JSONException -> 0x0133 }
        r1.append(r2)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r2 = "/"
        r1.append(r2)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r2 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x0133 }
        r1.append(r2)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0133 }
        r6.put(r0, r1)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r0 = "device_model"
        java.lang.String r1 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x0133 }
        if (r1 != 0) goto L_0x00e6
        goto L_0x00e8
    L_0x00e6:
        java.lang.String r8 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x0133 }
    L_0x00e8:
        r6.put(r0, r8)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r0 = "device_id"
        android.content.Context r1 = r9.f25016k     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r1 = com.tencent.mta.track.util.C7468g.m32342b(r1)     // Catch:{ JSONException -> 0x0133 }
        r6.put(r0, r1)     // Catch:{ JSONException -> 0x0133 }
        android.content.Context r0 = r9.f25016k     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r0 = com.tencent.mta.track.util.C7468g.m32346f(r0)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r1 = "network_type"
        r6.put(r1, r0)     // Catch:{ JSONException -> 0x0133 }
        android.content.Context r0 = r9.f25016k     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r1 = "phone"
        java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ JSONException -> 0x0133 }
        android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r0 = r0.getSimOperator()     // Catch:{ JSONException -> 0x0133 }
        boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0133 }
        if (r1 != 0) goto L_0x012e
        java.util.Map r1 = f25005m     // Catch:{ JSONException -> 0x0133 }
        boolean r1 = r1.containsKey(r0)     // Catch:{ JSONException -> 0x0133 }
        java.lang.String r2 = "carrier"
        if (r1 == 0) goto L_0x0129
        java.util.Map r1 = f25005m     // Catch:{ JSONException -> 0x0133 }
        java.lang.Object r0 = r1.get(r0)     // Catch:{ JSONException -> 0x0133 }
        r6.put(r2, r0)     // Catch:{ JSONException -> 0x0133 }
        goto L_0x012e
    L_0x0129:
        java.lang.String r0 = "其他"
        r6.put(r2, r0)     // Catch:{ JSONException -> 0x0133 }
    L_0x012e:
        java.lang.String r0 = r6.toString()     // Catch:{ JSONException -> 0x0133 }
        return r0
    L_0x0133:
        r0 = 0
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mta.track.util.ThrifClient.m32314e():java.lang.String");
    }

    /* renamed from: a */
    public void mo36417a() {
        mo36419b();
    }

    /* renamed from: b */
    public void mo36419b() {
        this.f25008c = new Thread(new C7471j(this, null));
        this.f25008c.start();
    }

    /* renamed from: a */
    public void mo36418a(String str, int i) {
        this.f25020p = str;
        this.f25021q = i;
        Message obtainMessage = this.f25009d.obtainMessage(1);
        obtainMessage.obj = str;
        obtainMessage.arg1 = i;
        if (StatisticsDataAPI.sharedInstance(this.f25016k).isDebugMode()) {
            StringBuilder sb = new StringBuilder();
            sb.append("send msg");
            sb.append(i);
            Log.i("track", sb.toString());
        }
        if (i == -1) {
            this.f25009d.sendMessage(obtainMessage);
        } else {
            this.f25009d.sendMessage(obtainMessage);
        }
    }

    /* renamed from: c */
    public boolean mo36420c() {
        return this.f25018n == THRIFTSTATE.OPEN || this.f25018n == THRIFTSTATE.CONNECTING;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32304a(TrackPollReq trackPollReq) {
        try {
            TrackPollRsp a = this.f25010e.mo36389a(trackPollReq);
            List list = a.sReqList;
            if (a.mo36310j()) {
                this.f25011f = a.pollInterval;
            }
            if (this.f25018n != THRIFTSTATE.CLOSED) {
                if (list == null) {
                    this.f25009d.sendMessageDelayed(this.f25009d.obtainMessage(1), (long) this.f25011f);
                    return;
                }
                this.f25018n = THRIFTSTATE.CONNECTING;
                mo35931a(list);
            }
        } catch (Throwable th) {
            this.f25018n = THRIFTSTATE.UNKNOW;
            StringBuilder sb = new StringBuilder();
            sb.append("Thrif poll : ");
            sb.append(th);
            sb.append(" , Thrif retrying connection");
            Log.e("track", sb.toString());
            C7463b.m32331a().mo36422a(new C7469h(this));
            mo36418a(this.f25020p, this.f25021q);
        }
    }

    /* renamed from: d */
    public void mo36421d() {
        this.f25009d.sendMessage(this.f25009d.obtainMessage(3));
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public TSocket m32316f() {
        try {
            TSocket eVar = new TSocket(this.f25007b.toString(), 4001, BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
            if (!eVar.mo40953a()) {
                eVar.mo40978f();
            }
            return eVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public String m32318g() {
        if (TextUtils.isEmpty(this.f25015j)) {
            this.f25015j = C7468g.m32345e(this.f25016k);
        }
        return this.f25015j;
    }
}
