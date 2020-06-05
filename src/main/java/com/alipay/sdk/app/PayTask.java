package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity.C1491a;
import com.alipay.sdk.app.statistic.C1505a;
import com.alipay.sdk.p120a.C1489a;
import com.alipay.sdk.p121b.C1508a;
import com.alipay.sdk.p121b.C1508a.C1509a;
import com.alipay.sdk.p121b.C1511c;
import com.alipay.sdk.p122c.C1513a;
import com.alipay.sdk.p124e.p125a.C1525d;
import com.alipay.sdk.p126f.C1531b;
import com.alipay.sdk.protocol.C1533a;
import com.alipay.sdk.protocol.C1534b;
import com.alipay.sdk.sys.C1535a;
import com.alipay.sdk.sys.C1536b;
import com.alipay.sdk.util.C1537a;
import com.alipay.sdk.util.C1542e;
import com.alipay.sdk.util.C1543f;
import com.alipay.sdk.util.C1543f.C1544a;
import com.alipay.sdk.util.C1548j;
import com.alipay.sdk.util.C1551m;
import com.alipay.sdk.util.C1553o;
import com.alipay.sdk.util.C1553o.C1554a;
import com.alipay.sdk.widget.C1559a;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class PayTask {
    /* renamed from: a */
    static final Object f3804a = C1543f.class;
    /* renamed from: h */
    private static long f3805h = 0;
    /* renamed from: i */
    private static long f3806i = -1;
    /* renamed from: b */
    private Activity f3807b;
    /* renamed from: c */
    private C1559a f3808c;
    /* renamed from: d */
    private String f3809d = "wappaygw.alipay.com/service/rest.htm";
    /* renamed from: e */
    private String f3810e = "mclient.alipay.com/service/rest.htm";
    /* renamed from: f */
    private String f3811f = "mclient.alipay.com/home/exterfaceAssign.htm";
    /* renamed from: g */
    private Map<String, C1492a> f3812g = new HashMap();

    /* renamed from: com.alipay.sdk.app.PayTask$a */
    private class C1492a {
        /* renamed from: b */
        private String f3814b;
        /* renamed from: c */
        private String f3815c;
        /* renamed from: d */
        private String f3816d;
        /* renamed from: e */
        private String f3817e;

        private C1492a() {
            String str = "";
            this.f3814b = str;
            this.f3815c = str;
            this.f3816d = str;
            this.f3817e = str;
        }

        /* synthetic */ C1492a(PayTask payTask, C1500g gVar) {
            this();
        }

        /* renamed from: a */
        public String mo12119a() {
            return this.f3814b;
        }

        /* renamed from: a */
        public void mo12120a(String str) {
            this.f3814b = str;
        }

        /* renamed from: b */
        public String mo12121b() {
            return this.f3816d;
        }

        /* renamed from: b */
        public void mo12122b(String str) {
            this.f3816d = str;
        }

        /* renamed from: c */
        public String mo12123c() {
            return this.f3815c;
        }

        /* renamed from: c */
        public void mo12124c(String str) {
            this.f3815c = str;
        }

        /* renamed from: d */
        public String mo12125d() {
            return this.f3817e;
        }

        /* renamed from: d */
        public void mo12126d(String str) {
            this.f3817e = str;
        }
    }

    public String getVersion() {
        return "15.6.5";
    }

    public PayTask(Activity activity) {
        this.f3807b = activity;
        C1536b.m4608a().mo12201a(this.f3807b, C1511c.m4489a());
        C1505a.m4450a(activity);
        this.f3808c = new C1559a(activity, "去支付宝付款");
    }

    public synchronized String pay(String str, boolean z) {
        String str2;
        if (m4415b()) {
            return C1503j.m4443d();
        }
        if (z) {
            showLoading();
        }
        if (str.contains("payment_inst=")) {
            String substring = str.substring(str.indexOf("payment_inst=") + 13);
            int indexOf = substring.indexOf(38);
            if (indexOf > 0) {
                substring = substring.substring(0, indexOf);
            }
            C1502i.m4435a(substring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
        } else {
            C1502i.m4435a("");
        }
        if (str.contains("service=alipay.acquire.mr.ord.createandpay")) {
            C1489a.f3788c = true;
        }
        if (C1489a.f3788c) {
            if (str.startsWith("https://wappaygw.alipay.com/home/exterfaceAssign.htm?")) {
                str = str.substring(str.indexOf("https://wappaygw.alipay.com/home/exterfaceAssign.htm?") + 53);
            } else if (str.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm?")) {
                str = str.substring(str.indexOf("https://mclient.alipay.com/home/exterfaceAssign.htm?") + 52);
            }
        }
        try {
            str2 = m4407a(str);
            C1548j.m4652a(this.f3807b.getApplicationContext(), str2);
        } catch (Throwable th) {
            String c = C1503j.m4442c();
            C1542e.m4633a(th);
            str2 = c;
            return str2;
        } finally {
            C1508a.m4475g().mo12154a(this.f3807b.getApplicationContext());
            dismissLoading();
            C1505a.m4456b(this.f3807b.getApplicationContext(), str);
        }
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        return C1551m.m4662a(pay(str, z));
    }

    public synchronized String fetchTradeToken() {
        return C1548j.m4650a(this.f3807b.getApplicationContext());
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String fetchOrderInfoFromH5PayUrl;
        fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
            new Thread(new C1500g(this, fetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00dc, code lost:
            if (r9.startsWith(r0.toString()) != false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0179, code lost:
            if (r9.startsWith(r0.toString()) != false) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003f, code lost:
            if (r9.startsWith(r0.toString()) != false) goto L_0x0041;
     */
    public synchronized java.lang.String fetchOrderInfoFromH5PayUrl(java.lang.String r17) {
        /*
        r16 = this;
        r8 = r16
        r1 = r17
        monitor-enter(r16)
        boolean r0 = android.text.TextUtils.isEmpty(r17)     // Catch:{ all -> 0x04ac }
        if (r0 != 0) goto L_0x04b0
        java.lang.String r9 = r17.trim()     // Catch:{ all -> 0x04ac }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r0.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "https://"
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = r8.f3809d     // Catch:{ all -> 0x04ac }
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x04ac }
        boolean r0 = r9.startsWith(r0)     // Catch:{ all -> 0x04ac }
        if (r0 != 0) goto L_0x0041
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r0.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "http://"
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = r8.f3809d     // Catch:{ all -> 0x04ac }
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x04ac }
        boolean r0 = r9.startsWith(r0)     // Catch:{ all -> 0x04ac }
        if (r0 == 0) goto L_0x00ac
    L_0x0041:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r0.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "(http|https)://"
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = r8.f3809d     // Catch:{ all -> 0x04ac }
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "\\?"
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = ""
        java.lang.String r0 = r9.replaceFirst(r0, r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x04ac }
        boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04ac }
        if (r2 != 0) goto L_0x00ac
        java.util.Map r0 = com.alipay.sdk.util.C1553o.m4680b(r0)     // Catch:{ all -> 0x04ac }
        java.lang.String r1 = "req_data"
        java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x04ac }
        java.lang.String r1 = "<request_token>"
        java.lang.String r2 = "</request_token>"
        java.lang.String r0 = com.alipay.sdk.util.C1553o.m4672a(r1, r2, r0)     // Catch:{ all -> 0x04ac }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r1.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "_input_charset=\"utf-8\"&ordertoken=\""
        r1.append(r2)     // Catch:{ all -> 0x04ac }
        r1.append(r0)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\""
        r1.append(r0)     // Catch:{ all -> 0x04ac }
        com.alipay.sdk.sys.a r0 = new com.alipay.sdk.sys.a     // Catch:{ all -> 0x04ac }
        android.app.Activity r2 = r8.f3807b     // Catch:{ all -> 0x04ac }
        r0.m42164init(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "sc"
        java.lang.String r3 = "h5tonative"
        java.lang.String r0 = r0.mo12200a(r2, r3)     // Catch:{ all -> 0x04ac }
        r1.append(r0)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = "\""
        r1.append(r0)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x04ac }
        monitor-exit(r16)
        return r0
    L_0x00ac:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r0.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "https://"
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = r8.f3810e     // Catch:{ all -> 0x04ac }
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x04ac }
        boolean r0 = r9.startsWith(r0)     // Catch:{ all -> 0x04ac }
        if (r0 != 0) goto L_0x00de
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r0.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "http://"
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = r8.f3810e     // Catch:{ all -> 0x04ac }
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x04ac }
        boolean r0 = r9.startsWith(r0)     // Catch:{ all -> 0x04ac }
        if (r0 == 0) goto L_0x0149
    L_0x00de:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r0.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "(http|https)://"
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = r8.f3810e     // Catch:{ all -> 0x04ac }
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "\\?"
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = ""
        java.lang.String r0 = r9.replaceFirst(r0, r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x04ac }
        boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04ac }
        if (r2 != 0) goto L_0x0149
        java.util.Map r0 = com.alipay.sdk.util.C1553o.m4680b(r0)     // Catch:{ all -> 0x04ac }
        java.lang.String r1 = "req_data"
        java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x04ac }
        java.lang.String r1 = "<request_token>"
        java.lang.String r2 = "</request_token>"
        java.lang.String r0 = com.alipay.sdk.util.C1553o.m4672a(r1, r2, r0)     // Catch:{ all -> 0x04ac }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r1.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "_input_charset=\"utf-8\"&ordertoken=\""
        r1.append(r2)     // Catch:{ all -> 0x04ac }
        r1.append(r0)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\""
        r1.append(r0)     // Catch:{ all -> 0x04ac }
        com.alipay.sdk.sys.a r0 = new com.alipay.sdk.sys.a     // Catch:{ all -> 0x04ac }
        android.app.Activity r2 = r8.f3807b     // Catch:{ all -> 0x04ac }
        r0.m42164init(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "sc"
        java.lang.String r3 = "h5tonative"
        java.lang.String r0 = r0.mo12200a(r2, r3)     // Catch:{ all -> 0x04ac }
        r1.append(r0)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = "\""
        r1.append(r0)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x04ac }
        monitor-exit(r16)
        return r0
    L_0x0149:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r0.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "https://"
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = r8.f3811f     // Catch:{ all -> 0x04ac }
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x04ac }
        boolean r0 = r9.startsWith(r0)     // Catch:{ all -> 0x04ac }
        if (r0 != 0) goto L_0x017b
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r0.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "http://"
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = r8.f3811f     // Catch:{ all -> 0x04ac }
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x04ac }
        boolean r0 = r9.startsWith(r0)     // Catch:{ all -> 0x04ac }
        if (r0 == 0) goto L_0x01ec
    L_0x017b:
        java.lang.String r0 = "alipay.wap.create.direct.pay.by.user"
        boolean r0 = r9.contains(r0)     // Catch:{ all -> 0x04ac }
        if (r0 != 0) goto L_0x018b
        java.lang.String r0 = "create_forex_trade_wap"
        boolean r0 = r9.contains(r0)     // Catch:{ all -> 0x04ac }
        if (r0 == 0) goto L_0x01ec
    L_0x018b:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r0.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "(http|https)://"
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = r8.f3811f     // Catch:{ all -> 0x04ac }
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "\\?"
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = ""
        java.lang.String r0 = r9.replaceFirst(r0, r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x04ac }
        boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04ac }
        if (r0 != 0) goto L_0x01ec
        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x01e8 }
        r0.<init>()     // Catch:{ all -> 0x01e8 }
        java.lang.String r2 = "url"
        r0.put(r2, r1)     // Catch:{ all -> 0x01e8 }
        java.lang.String r2 = "bizcontext"
        com.alipay.sdk.sys.a r3 = new com.alipay.sdk.sys.a     // Catch:{ all -> 0x01e8 }
        android.app.Activity r4 = r8.f3807b     // Catch:{ all -> 0x01e8 }
        r3.m42164init(r4)     // Catch:{ all -> 0x01e8 }
        java.lang.String r4 = "sc"
        java.lang.String r5 = "h5tonative"
        java.lang.String r3 = r3.mo12200a(r4, r5)     // Catch:{ all -> 0x01e8 }
        r0.put(r2, r3)     // Catch:{ all -> 0x01e8 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e8 }
        r2.<init>()     // Catch:{ all -> 0x01e8 }
        java.lang.String r3 = "new_external_info=="
        r2.append(r3)     // Catch:{ all -> 0x01e8 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01e8 }
        r2.append(r0)     // Catch:{ all -> 0x01e8 }
        java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x01e8 }
        monitor-exit(r16)
        return r0
    L_0x01e8:
        r0 = move-exception
        com.alipay.sdk.util.C1542e.m4633a(r0)     // Catch:{ all -> 0x04ac }
    L_0x01ec:
        java.lang.String r0 = "^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)"
        java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ all -> 0x04ac }
        java.util.regex.Matcher r0 = r0.matcher(r1)     // Catch:{ all -> 0x04ac }
        boolean r0 = r0.find()     // Catch:{ all -> 0x04ac }
        r10 = 0
        if (r0 == 0) goto L_0x0332
        java.lang.String r0 = "?"
        java.lang.String r2 = ""
        java.lang.String r0 = com.alipay.sdk.util.C1553o.m4672a(r0, r2, r1)     // Catch:{ all -> 0x04ac }
        boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04ac }
        if (r1 != 0) goto L_0x0332
        java.util.Map r0 = com.alipay.sdk.util.C1553o.m4680b(r0)     // Catch:{ all -> 0x04ac }
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r11.<init>()     // Catch:{ all -> 0x04ac }
        r2 = 0
        r3 = 1
        java.lang.String r4 = "trade_no"
        java.lang.String r1 = "trade_no"
        java.lang.String r5 = "alipay_trade_no"
        java.lang.String[] r7 = new java.lang.String[]{r1, r5}     // Catch:{ all -> 0x04ac }
        r1 = r16
        r5 = r11
        r6 = r0
        boolean r1 = r1.m4413a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x04ac }
        if (r1 == 0) goto L_0x0332
        r2 = 1
        r3 = 0
        java.lang.String r4 = "pay_phase_id"
        java.lang.String r1 = "payPhaseId"
        java.lang.String r5 = "pay_phase_id"
        java.lang.String r6 = "out_relation_id"
        java.lang.String[] r7 = new java.lang.String[]{r1, r5, r6}     // Catch:{ all -> 0x04ac }
        r1 = r16
        r5 = r11
        r6 = r0
        r1.m4413a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x04ac }
        java.lang.String r1 = "&biz_sub_type=\"TRADE\""
        r11.append(r1)     // Catch:{ all -> 0x04ac }
        java.lang.String r1 = "&biz_type=\"trade\""
        r11.append(r1)     // Catch:{ all -> 0x04ac }
        java.lang.String r1 = "app_name"
        java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x04ac }
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x04ac }
        boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x04ac }
        if (r2 == 0) goto L_0x0268
        java.lang.String r2 = "cid"
        java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x04ac }
        java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x04ac }
        boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x04ac }
        if (r2 != 0) goto L_0x0268
        java.lang.String r1 = "ali1688"
        goto L_0x028c
    L_0x0268:
        boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x04ac }
        if (r2 == 0) goto L_0x028c
        java.lang.String r2 = "sid"
        java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x04ac }
        java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x04ac }
        boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x04ac }
        if (r2 == 0) goto L_0x028a
        java.lang.String r2 = "s_id"
        java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x04ac }
        java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x04ac }
        boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x04ac }
        if (r2 != 0) goto L_0x028c
    L_0x028a:
        java.lang.String r1 = "tb"
    L_0x028c:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r2.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r3 = "&app_name=\""
        r2.append(r3)     // Catch:{ all -> 0x04ac }
        r2.append(r1)     // Catch:{ all -> 0x04ac }
        java.lang.String r1 = "\""
        r2.append(r1)     // Catch:{ all -> 0x04ac }
        java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x04ac }
        r11.append(r1)     // Catch:{ all -> 0x04ac }
        r2 = 1
        r3 = 1
        java.lang.String r4 = "extern_token"
        java.lang.String r1 = "extern_token"
        java.lang.String r5 = "cid"
        java.lang.String r6 = "sid"
        java.lang.String r7 = "s_id"
        java.lang.String[] r7 = new java.lang.String[]{r1, r5, r6, r7}     // Catch:{ all -> 0x04ac }
        r1 = r16
        r5 = r11
        r6 = r0
        boolean r1 = r1.m4413a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x04ac }
        if (r1 != 0) goto L_0x02c3
        java.lang.String r0 = ""
        monitor-exit(r16)
        return r0
    L_0x02c3:
        r2 = 1
        r3 = 0
        java.lang.String r4 = "appenv"
        java.lang.String r1 = "appenv"
        java.lang.String[] r7 = new java.lang.String[]{r1}     // Catch:{ all -> 0x04ac }
        r1 = r16
        r5 = r11
        r6 = r0
        r1.m4413a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x04ac }
        java.lang.String r1 = "&pay_channel_id=\"alipay_sdk\""
        r11.append(r1)     // Catch:{ all -> 0x04ac }
        com.alipay.sdk.app.PayTask$a r1 = new com.alipay.sdk.app.PayTask$a     // Catch:{ all -> 0x04ac }
        r1.m42124init(r8, r10)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "return_url"
        java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x04ac }
        r1.mo12120a(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "show_url"
        java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x04ac }
        r1.mo12124c(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "pay_order_id"
        java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x04ac }
        r1.mo12122b(r0)     // Catch:{ all -> 0x04ac }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ac }
        r0.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = r11.toString()     // Catch:{ all -> 0x04ac }
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "&bizcontext=\""
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        com.alipay.sdk.sys.a r2 = new com.alipay.sdk.sys.a     // Catch:{ all -> 0x04ac }
        android.app.Activity r3 = r8.f3807b     // Catch:{ all -> 0x04ac }
        r2.m42164init(r3)     // Catch:{ all -> 0x04ac }
        java.lang.String r3 = "sc"
        java.lang.String r4 = "h5tonative"
        java.lang.String r2 = r2.mo12200a(r3, r4)     // Catch:{ all -> 0x04ac }
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "\""
        r0.append(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x04ac }
        java.util.Map<java.lang.String, com.alipay.sdk.app.PayTask$a> r2 = r8.f3812g     // Catch:{ all -> 0x04ac }
        r2.put(r0, r1)     // Catch:{ all -> 0x04ac }
        monitor-exit(r16)
        return r0
    L_0x0332:
        java.lang.String r0 = "mclient.alipay.com/cashier/mobilepay.htm"
        boolean r0 = r9.contains(r0)     // Catch:{ all -> 0x04ac }
        r1 = 0
        r2 = 1
        if (r0 != 0) goto L_0x047e
        boolean r0 = com.alipay.sdk.app.EnvUtils.m4395a()     // Catch:{ all -> 0x04ac }
        if (r0 == 0) goto L_0x034c
        java.lang.String r0 = "mobileclientgw.alipaydev.com/cashier/mobilepay.htm"
        boolean r0 = r9.contains(r0)     // Catch:{ all -> 0x04ac }
        if (r0 == 0) goto L_0x034c
        goto L_0x047e
    L_0x034c:
        com.alipay.sdk.b.a r0 = com.alipay.sdk.p121b.C1508a.m4475g()     // Catch:{ all -> 0x04ac }
        boolean r0 = r0.mo12156c()     // Catch:{ all -> 0x04ac }
        if (r0 == 0) goto L_0x04b0
        java.lang.String r0 = "^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?"
        java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ all -> 0x04ac }
        java.util.regex.Matcher r0 = r0.matcher(r9)     // Catch:{ all -> 0x04ac }
        boolean r0 = r0.find()     // Catch:{ all -> 0x04ac }
        if (r0 == 0) goto L_0x04b0
        android.net.Uri r0 = android.net.Uri.parse(r9)     // Catch:{ all -> 0x04ac }
        java.lang.String r3 = "return_url"
        java.lang.String r3 = r0.getQueryParameter(r3)     // Catch:{ all -> 0x04ac }
        java.lang.String r4 = "show_url"
        java.lang.String r4 = r0.getQueryParameter(r4)     // Catch:{ all -> 0x04ac }
        java.lang.String r5 = "pay_order_id"
        java.lang.String r5 = r0.getQueryParameter(r5)     // Catch:{ all -> 0x04ac }
        r6 = 2
        java.lang.String[] r7 = new java.lang.String[r6]     // Catch:{ all -> 0x04ac }
        java.lang.String r9 = "trade_nos"
        java.lang.String r9 = r0.getQueryParameter(r9)     // Catch:{ all -> 0x04ac }
        r7[r1] = r9     // Catch:{ all -> 0x04ac }
        java.lang.String r9 = "alipay_trade_no"
        java.lang.String r9 = r0.getQueryParameter(r9)     // Catch:{ all -> 0x04ac }
        r7[r2] = r9     // Catch:{ all -> 0x04ac }
        java.lang.String r7 = m4411a(r7)     // Catch:{ all -> 0x04ac }
        r9 = 3
        java.lang.String[] r11 = new java.lang.String[r9]     // Catch:{ all -> 0x04ac }
        java.lang.String r12 = "payPhaseId"
        java.lang.String r12 = r0.getQueryParameter(r12)     // Catch:{ all -> 0x04ac }
        r11[r1] = r12     // Catch:{ all -> 0x04ac }
        java.lang.String r12 = "pay_phase_id"
        java.lang.String r12 = r0.getQueryParameter(r12)     // Catch:{ all -> 0x04ac }
        r11[r2] = r12     // Catch:{ all -> 0x04ac }
        java.lang.String r12 = "out_relation_id"
        java.lang.String r12 = r0.getQueryParameter(r12)     // Catch:{ all -> 0x04ac }
        r11[r6] = r12     // Catch:{ all -> 0x04ac }
        java.lang.String r11 = m4411a(r11)     // Catch:{ all -> 0x04ac }
        r12 = 4
        java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ all -> 0x04ac }
        java.lang.String r14 = "app_name"
        java.lang.String r14 = r0.getQueryParameter(r14)     // Catch:{ all -> 0x04ac }
        r13[r1] = r14     // Catch:{ all -> 0x04ac }
        java.lang.String r14 = "cid"
        java.lang.String r14 = r0.getQueryParameter(r14)     // Catch:{ all -> 0x04ac }
        boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x04ac }
        if (r14 != 0) goto L_0x03cc
        java.lang.String r14 = "ali1688"
        goto L_0x03ce
    L_0x03cc:
        java.lang.String r14 = ""
    L_0x03ce:
        r13[r2] = r14     // Catch:{ all -> 0x04ac }
        java.lang.String r14 = "sid"
        java.lang.String r14 = r0.getQueryParameter(r14)     // Catch:{ all -> 0x04ac }
        boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x04ac }
        if (r14 != 0) goto L_0x03df
        java.lang.String r14 = "tb"
        goto L_0x03e1
    L_0x03df:
        java.lang.String r14 = ""
    L_0x03e1:
        r13[r6] = r14     // Catch:{ all -> 0x04ac }
        java.lang.String r14 = "s_id"
        java.lang.String r14 = r0.getQueryParameter(r14)     // Catch:{ all -> 0x04ac }
        boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x04ac }
        if (r14 != 0) goto L_0x03f2
        java.lang.String r14 = "tb"
        goto L_0x03f4
    L_0x03f2:
        java.lang.String r14 = ""
    L_0x03f4:
        r13[r9] = r14     // Catch:{ all -> 0x04ac }
        java.lang.String r13 = m4411a(r13)     // Catch:{ all -> 0x04ac }
        java.lang.String[] r14 = new java.lang.String[r12]     // Catch:{ all -> 0x04ac }
        java.lang.String r15 = "extern_token"
        java.lang.String r15 = r0.getQueryParameter(r15)     // Catch:{ all -> 0x04ac }
        r14[r1] = r15     // Catch:{ all -> 0x04ac }
        java.lang.String r15 = "cid"
        java.lang.String r15 = r0.getQueryParameter(r15)     // Catch:{ all -> 0x04ac }
        r14[r2] = r15     // Catch:{ all -> 0x04ac }
        java.lang.String r15 = "sid"
        java.lang.String r15 = r0.getQueryParameter(r15)     // Catch:{ all -> 0x04ac }
        r14[r6] = r15     // Catch:{ all -> 0x04ac }
        java.lang.String r15 = "s_id"
        java.lang.String r15 = r0.getQueryParameter(r15)     // Catch:{ all -> 0x04ac }
        r14[r9] = r15     // Catch:{ all -> 0x04ac }
        java.lang.String r14 = m4411a(r14)     // Catch:{ all -> 0x04ac }
        java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ all -> 0x04ac }
        java.lang.String r10 = "appenv"
        java.lang.String r0 = r0.getQueryParameter(r10)     // Catch:{ all -> 0x04ac }
        r15[r1] = r0     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = m4411a(r15)     // Catch:{ all -> 0x04ac }
        boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x04ac }
        if (r10 != 0) goto L_0x04b0
        boolean r10 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x04ac }
        if (r10 != 0) goto L_0x04b0
        boolean r10 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x04ac }
        if (r10 != 0) goto L_0x04b0
        java.lang.String r10 = "trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\""
        r15 = 6
        java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ all -> 0x04ac }
        r15[r1] = r7     // Catch:{ all -> 0x04ac }
        r15[r2] = r11     // Catch:{ all -> 0x04ac }
        r15[r6] = r13     // Catch:{ all -> 0x04ac }
        r15[r9] = r14     // Catch:{ all -> 0x04ac }
        r15[r12] = r0     // Catch:{ all -> 0x04ac }
        r0 = 5
        com.alipay.sdk.sys.a r1 = new com.alipay.sdk.sys.a     // Catch:{ all -> 0x04ac }
        android.app.Activity r2 = r8.f3807b     // Catch:{ all -> 0x04ac }
        r1.m42164init(r2)     // Catch:{ all -> 0x04ac }
        java.lang.String r2 = "sc"
        java.lang.String r6 = "h5tonative"
        java.lang.String r1 = r1.mo12200a(r2, r6)     // Catch:{ all -> 0x04ac }
        r15[r0] = r1     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = java.lang.String.format(r10, r15)     // Catch:{ all -> 0x04ac }
        com.alipay.sdk.app.PayTask$a r1 = new com.alipay.sdk.app.PayTask$a     // Catch:{ all -> 0x04ac }
        r2 = 0
        r1.m42124init(r8, r2)     // Catch:{ all -> 0x04ac }
        r1.mo12120a(r3)     // Catch:{ all -> 0x04ac }
        r1.mo12124c(r4)     // Catch:{ all -> 0x04ac }
        r1.mo12122b(r5)     // Catch:{ all -> 0x04ac }
        r1.mo12126d(r7)     // Catch:{ all -> 0x04ac }
        java.util.Map<java.lang.String, com.alipay.sdk.app.PayTask$a> r2 = r8.f3812g     // Catch:{ all -> 0x04ac }
        r2.put(r0, r1)     // Catch:{ all -> 0x04ac }
        monitor-exit(r16)
        return r0
    L_0x047e:
        com.alipay.sdk.sys.a r0 = new com.alipay.sdk.sys.a     // Catch:{ all -> 0x04ac }
        android.app.Activity r3 = r8.f3807b     // Catch:{ all -> 0x04ac }
        r0.m42164init(r3)     // Catch:{ all -> 0x04ac }
        java.lang.String r3 = "sc"
        java.lang.String r4 = "h5tonative"
        java.lang.String r0 = r0.mo12200a(r3, r4)     // Catch:{ all -> 0x04ac }
        org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x04ac }
        r3.<init>()     // Catch:{ all -> 0x04ac }
        java.lang.String r4 = "url"
        r3.put(r4, r9)     // Catch:{ all -> 0x04ac }
        java.lang.String r4 = "bizcontext"
        r3.put(r4, r0)     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = "new_external_info==%s"
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x04ac }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x04ac }
        r2[r1] = r3     // Catch:{ all -> 0x04ac }
        java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ all -> 0x04ac }
        monitor-exit(r16)
        return r0
    L_0x04ac:
        r0 = move-exception
        com.alipay.sdk.util.C1542e.m4633a(r0)     // Catch:{ all -> 0x04b4 }
    L_0x04b0:
        java.lang.String r0 = ""
        monitor-exit(r16)
        return r0
    L_0x04b4:
        r0 = move-exception
        monitor-exit(r16)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.fetchOrderInfoFromH5PayUrl(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static final String m4411a(String... strArr) {
        String str = "";
        if (strArr == null) {
            return str;
        }
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return str;
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        synchronized (PayTask.class) {
            try {
                C1536b.m4608a().mo12201a(context, C1511c.m4489a());
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - f3805h < ((long) C1508a.m4475g().mo12158e())) {
                    return false;
                }
                f3805h = elapsedRealtime;
                C1508a.m4475g().mo12154a(context.getApplicationContext());
                return true;
            } catch (Exception e) {
                C1542e.m4633a(e);
                return false;
            }
        }
    }

    /* renamed from: a */
    private boolean m4413a(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i];
            if (!TextUtils.isEmpty((CharSequence) map.get(str3))) {
                str2 = (String) map.get(str3);
                break;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            String str4 = "\"";
            String str5 = "=\"";
            if (z) {
                sb.append("&");
                sb.append(str);
                sb.append(str5);
                sb.append(str2);
                sb.append(str4);
            } else {
                sb.append(str);
                sb.append(str5);
                sb.append(str2);
                sb.append(str4);
            }
        } else if (z2) {
            return false;
        }
        return true;
    }

    public synchronized C1537a h5Pay(String str, boolean z) {
        C1537a aVar;
        aVar = new C1537a();
        try {
            String[] split = pay(str, z).split(";");
            HashMap hashMap = new HashMap();
            for (String str2 : split) {
                int indexOf = str2.indexOf("={");
                if (indexOf >= 0) {
                    String substring = str2.substring(0, indexOf);
                    hashMap.put(substring, m4408a(str2, substring));
                }
            }
            if (hashMap.containsKey("resultStatus")) {
                aVar.mo12207b((String) hashMap.get("resultStatus"));
            }
            aVar.mo12206a(m4410a(str, (Map<String, String>) hashMap));
            if (TextUtils.isEmpty(aVar.mo12205a())) {
                C1505a.m4452a(KEYS.BIZ, "H5CbUrlEmpty", "");
            }
        } catch (Throwable th) {
            C1505a.m4453a(KEYS.BIZ, "H5CbEx", th);
            C1542e.m4633a(th);
        }
        return aVar;
    }

    /* renamed from: a */
    private String m4410a(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean equals = "9000".equals(map.get("resultStatus"));
        String str2 = (String) map.get(ArgKey.KEY_RESULT);
        C1492a aVar = (C1492a) this.f3812g.remove(str);
        String[] strArr = new String[2];
        String str3 = "";
        strArr[0] = aVar != null ? aVar.mo12121b() : str3;
        strArr[1] = aVar != null ? aVar.mo12125d() : str3;
        m4411a(strArr);
        String str4 = "callBackUrl";
        if (map.containsKey(str4)) {
            return (String) map.get(str4);
        }
        if (str2.length() > 15) {
            String str5 = "\"";
            String str6 = "&";
            String str7 = "utf-8";
            String a = m4411a(C1553o.m4672a("&callBackUrl=\"", str5, str2), C1553o.m4672a("&call_back_url=\"", str5, str2), C1553o.m4672a("&return_url=\"", str5, str2), URLDecoder.decode(C1553o.m4672a("&return_url=", str6, str2), str7), URLDecoder.decode(C1553o.m4672a("&callBackUrl=", str6, str2), str7), C1553o.m4672a("call_back_url=\"", str5, str2));
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
        }
        if (aVar != null) {
            String a2 = equals ? aVar.mo12119a() : aVar.mo12123c();
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        return aVar != null ? C1508a.m4475g().mo12157d() : str3;
    }

    /* renamed from: a */
    private String m4408a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("={");
        String sb2 = sb.toString();
        return str.substring(str.indexOf(sb2) + sb2.length(), str.lastIndexOf("}"));
    }

    /* renamed from: a */
    private C1544a m4404a() {
        return new C1501h(this);
    }

    public void showLoading() {
        C1559a aVar = this.f3808c;
        if (aVar != null) {
            aVar.mo12244a();
        }
    }

    public void dismissLoading() {
        C1559a aVar = this.f3808c;
        if (aVar != null) {
            aVar.mo12246b();
            this.f3808c = null;
        }
    }

    /* renamed from: a */
    private String m4407a(String str) {
        String a = new C1535a(this.f3807b).mo12199a(str);
        if (a.contains("paymethod=\"expressGateway\"")) {
            return m4414b(a);
        }
        List<C1509a> f = C1508a.m4475g().mo12159f();
        if (!C1508a.m4475g().f3866a || f == null) {
            f = C1502i.f3836a;
        }
        boolean b = C1553o.m4682b((Context) this.f3807b, f);
        String str2 = "";
        String str3 = KEYS.BIZ;
        if (b) {
            C1543f fVar = new C1543f(this.f3807b, m4404a());
            String a2 = fVar.mo12216a(a);
            fVar.mo12217a();
            if (TextUtils.equals(a2, "failed") || TextUtils.equals(a2, "scheme_failed")) {
                C1505a.m4452a(str3, "LogBindCalledH5", str2);
                return m4414b(a);
            } else if (TextUtils.isEmpty(a2)) {
                return C1503j.m4442c();
            } else {
                if (!a2.contains("{\"isLogin\":\"false\"}")) {
                    return a2;
                }
                C1505a.m4452a(str3, "LogHkLoginByIntent", str2);
                return m4409a(a, f, a2, this.f3807b);
            }
        } else {
            C1505a.m4452a(str3, "LogCalledH5", str2);
            return m4414b(a);
        }
    }

    /* renamed from: a */
    private static String m4409a(String str, List<C1509a> list, String str2, Activity activity) {
        C1554a a = C1553o.m4666a((Context) activity, list);
        if (a == null || a.mo12220a() || a.mo12221b() || !TextUtils.equals(a.f3966a.packageName, "hk.alipay.wallet")) {
            return str2;
        }
        C1542e.m4631a("msp", "PayTask:payResult: NOT_LOGIN");
        String valueOf = String.valueOf(str.hashCode());
        PayResultActivity.f3801a.put(valueOf, new Object());
        Intent intent = new Intent(activity, PayResultActivity.class);
        intent.putExtra("orderSuffix", str);
        intent.putExtra("externalPkgName", activity.getPackageName());
        intent.putExtra("phonecashier.pay.hash", valueOf);
        activity.startActivity(intent);
        synchronized (PayResultActivity.f3801a.get(valueOf)) {
            try {
                C1542e.m4631a("msp", "PayTask:payResult: wait");
                PayResultActivity.f3801a.get(valueOf).wait();
            } catch (InterruptedException e) {
                String str3 = "msp";
                StringBuilder sb = new StringBuilder();
                sb.append("PayTask:payResult: InterruptedException:");
                sb.append(e);
                C1542e.m4631a(str3, sb.toString());
                return C1503j.m4442c();
            }
        }
        String str4 = C1491a.f3803b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PayTask:payResult: result:");
        sb2.append(str4);
        C1542e.m4631a("msp", sb2.toString());
        return str4;
    }

    /* renamed from: b */
    private String m4414b(String str) {
        showLoading();
        C1504k kVar = null;
        try {
            JSONObject c = new C1525d().mo12172a(this.f3807b.getApplicationContext(), str).mo12178c();
            String optString = c.optString("end_code", null);
            List a = C1534b.m4594a(c.optJSONObject("form").optJSONObject("onload"));
            int i = 0;
            for (int i2 = 0; i2 < a.size(); i2++) {
                if (((C1534b) a.get(i2)).mo12197a() == C1533a.Update) {
                    C1534b.m4595a((C1534b) a.get(i2));
                }
            }
            m4412a(c);
            dismissLoading();
            while (i < a.size()) {
                C1534b bVar = (C1534b) a.get(i);
                if (bVar.mo12197a() == C1533a.WapPay) {
                    String a2 = m4405a(bVar);
                    dismissLoading();
                    return a2;
                } else if (bVar.mo12197a() == C1533a.OpenWeb) {
                    String a3 = m4406a(bVar, optString);
                    dismissLoading();
                    return a3;
                } else {
                    i++;
                }
            }
        } catch (IOException e) {
            kVar = C1504k.m4445b(C1504k.NETWORK_ERROR.mo12142a());
            C1505a.m4455a("net", (Throwable) e);
        } catch (Throwable th) {
            dismissLoading();
            throw th;
        }
        dismissLoading();
        if (kVar == null) {
            kVar = C1504k.m4445b(C1504k.FAILED.mo12142a());
        }
        return C1503j.m4438a(kVar.mo12142a(), kVar.mo12145b(), "");
    }

    /* renamed from: a */
    private void m4412a(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString("client_key");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                C1531b.m4573a(C1536b.m4608a().mo12202b()).mo12194a(optString, optString2);
            }
        } catch (Throwable th) {
            C1505a.m4453a(KEYS.BIZ, "ParserTidClientKeyEx", th);
        }
    }

    /* renamed from: a */
    private String m4406a(C1534b bVar, String str) {
        boolean b;
        String a;
        String[] b2 = bVar.mo12198b();
        Intent intent = new Intent(this.f3807b, H5PayActivity.class);
        try {
            JSONObject d = C1553o.m4690d(new String(C1513a.m4508a(b2[2])));
            intent.putExtra("url", b2[0]);
            intent.putExtra("title", b2[1]);
            intent.putExtra(AppEntity.KEY_VERSION_STR, "v2");
            intent.putExtra("method", d.optString("method", "POST"));
            C1503j.m4440a(false);
            C1503j.m4439a((String) null);
            this.f3807b.startActivity(intent);
            synchronized (f3804a) {
                try {
                    f3804a.wait();
                    b = C1503j.m4441b();
                    a = C1503j.m4437a();
                    C1503j.m4440a(false);
                    C1503j.m4439a((String) null);
                } catch (InterruptedException e) {
                    C1542e.m4633a(e);
                    return C1503j.m4442c();
                }
            }
            String str2 = "";
            if (b) {
                try {
                    List a2 = C1534b.m4594a(C1553o.m4690d(new String(C1513a.m4508a(a))));
                    int i = 0;
                    while (true) {
                        if (i >= a2.size()) {
                            break;
                        }
                        C1534b bVar2 = (C1534b) a2.get(i);
                        if (bVar2.mo12197a() == C1533a.SetResult) {
                            String[] b3 = bVar2.mo12198b();
                            str2 = C1503j.m4438a(Integer.valueOf(b3[1]).intValue(), b3[0], C1553o.m4692e(b3[2]));
                            break;
                        }
                        i++;
                    }
                } catch (Throwable th) {
                    C1542e.m4633a(th);
                    C1505a.m4454a(KEYS.BIZ, "H5PayDataAnalysisError", th, a);
                }
            }
            if (TextUtils.isEmpty(str2)) {
                try {
                    str2 = C1503j.m4438a(Integer.valueOf(str).intValue(), "", "");
                } catch (Throwable th2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("endCode: ");
                    sb.append(str);
                    C1505a.m4454a(KEYS.BIZ, "H5PayDataAnalysisError", th2, sb.toString());
                    str2 = C1503j.m4438a(8000, "", "");
                }
            }
            return str2;
        } catch (Throwable th3) {
            C1542e.m4633a(th3);
            C1505a.m4454a(KEYS.BIZ, "H5PayDataAnalysisError", th3, Arrays.toString(b2));
            return C1503j.m4442c();
        }
    }

    /* renamed from: a */
    private String m4405a(C1534b bVar) {
        String[] b = bVar.mo12198b();
        Intent intent = new Intent(this.f3807b, H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", b[0]);
        if (b.length == 2) {
            bundle.putString("cookie", b[1]);
        }
        intent.putExtras(bundle);
        this.f3807b.startActivity(intent);
        synchronized (f3804a) {
            try {
                f3804a.wait();
            } catch (InterruptedException e) {
                C1542e.m4633a(e);
                return C1503j.m4442c();
            }
        }
        String a = C1503j.m4437a();
        if (TextUtils.isEmpty(a)) {
            a = C1503j.m4442c();
        }
        return a;
    }

    /* renamed from: b */
    private static boolean m4415b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f3806i < 3000) {
            return true;
        }
        f3806i = elapsedRealtime;
        return false;
    }
}
