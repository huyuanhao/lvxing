package com.alibaba.wireless.security.open.middletier.p093fc.p094ui;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.alibaba.wireless.security.framework.utils.C1347a;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.alibaba.wireless.security.open.middletier.fc.ui.ContainerActivity */
public class ContainerActivity extends Activity {
    /* access modifiers changed from: private|static */
    /* renamed from: m */
    public static C1376a f3580m;
    /* renamed from: a */
    WebView f3581a = null;
    /* renamed from: b */
    long f3582b = 0;
    /* renamed from: c */
    String f3583c;
    /* renamed from: d */
    String f3584d;
    /* renamed from: e */
    long f3585e;
    /* renamed from: f */
    String f3586f;
    /* renamed from: g */
    String f3587g;
    /* renamed from: h */
    boolean f3588h;
    /* renamed from: i */
    final int f3589i;
    /* renamed from: j */
    final int f3590j;
    /* renamed from: k */
    final int f3591k;
    /* renamed from: l */
    final int f3592l;

    public ContainerActivity() {
        String str = "";
        this.f3583c = str;
        this.f3584d = "?action=close";
        this.f3586f = str;
        this.f3587g = str;
        this.f3588h = false;
        this.f3589i = 7;
        this.f3590j = 0;
        this.f3591k = 100107;
        this.f3592l = 2303;
    }

    /* renamed from: a */
    private String m4025a(String str) throws MalformedURLException {
        String query = new URL(str).getQuery();
        StringBuilder sb = new StringBuilder();
        String str2 = "tmd_nc=1";
        if (!TextUtils.isEmpty(query)) {
            String str3 = null;
            String str4 = "&";
            String[] split = query.split(str4);
            for (String str5 : split) {
                if (str5.startsWith("http_referer=")) {
                    this.f3583c = str5.substring(13);
                    str3 = str5;
                } else if (!str5.equalsIgnoreCase("native=1")) {
                    sb.append(str5);
                    sb.append(str4);
                }
            }
            sb.append(str2);
            if (str3 != null) {
                sb.append(str4);
                sb.append(str3);
            }
            return str.replace(query, sb.toString());
        }
        sb.append(str);
        String str6 = "?";
        if (!str.endsWith(str6)) {
            sb.append(str6);
        }
        sb.append(str2);
        return sb.toString();
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (f3580m != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onBackPressed UI Callback : ");
            sb.append(this.f3582b);
            Log.d("ContainerActivity", sb.toString());
            f3580m.mo11903a(this.f3582b, 4, null);
        }
        if (this.f3588h) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = this.f3586f;
            long j = currentTimeMillis - this.f3585e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(this.f3582b);
            C1347a.m3972a("100107", 0, 7, str, j, "", "onBackPressed", null, sb2.toString(), this.f3587g);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    public void onCreate(android.os.Bundle r29) {
        /*
        r28 = this;
        r1 = r28
        java.lang.String r2 = ""
        super.onCreate(r29)
        long r3 = java.lang.System.currentTimeMillis()
        r1.f3585e = r3
        java.lang.String r3 = "onCreate"
        java.lang.String r4 = "ContainerActivity"
        java.lang.String r0 = "start activity-->e"
        android.util.Log.d(r4, r0)
        android.content.Intent r0 = r28.getIntent()     // Catch:{ Exception -> 0x00d3 }
        java.lang.String r5 = "needUT"
        r6 = 0
        boolean r5 = r0.getBooleanExtra(r5, r6)     // Catch:{ Exception -> 0x00d3 }
        r1.f3588h = r5     // Catch:{ Exception -> 0x00d3 }
        java.lang.String r5 = "sessionId"
        r7 = 0
        long r7 = r0.getLongExtra(r5, r7)     // Catch:{ Exception -> 0x00d3 }
        r1.f3582b = r7     // Catch:{ Exception -> 0x00d3 }
        java.lang.String r5 = "pluginVersion"
        java.lang.String r5 = r0.getStringExtra(r5)     // Catch:{ Exception -> 0x00d3 }
        r1.f3586f = r5     // Catch:{ Exception -> 0x00d3 }
        java.lang.String r5 = "bxUUID"
        java.lang.String r5 = r0.getStringExtra(r5)     // Catch:{ Exception -> 0x00d3 }
        r1.f3587g = r5     // Catch:{ Exception -> 0x00d3 }
        java.lang.String r5 = "location"
        java.lang.String r0 = r0.getStringExtra(r5)     // Catch:{ Exception -> 0x00d3 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d3 }
        r5.<init>()     // Catch:{ Exception -> 0x00d3 }
        java.lang.String r7 = "origin Location : "
        r5.append(r7)     // Catch:{ Exception -> 0x00d3 }
        r5.append(r0)     // Catch:{ Exception -> 0x00d3 }
        java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00d3 }
        android.util.Log.d(r4, r5)     // Catch:{ Exception -> 0x00d3 }
        java.lang.String r5 = r1.m4025a(r0)     // Catch:{ Exception -> 0x00d3 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cf }
        r0.<init>()     // Catch:{ Exception -> 0x00cf }
        java.lang.String r7 = "processed Location : "
        r0.append(r7)     // Catch:{ Exception -> 0x00cf }
        r0.append(r5)     // Catch:{ Exception -> 0x00cf }
        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00cf }
        android.util.Log.d(r4, r0)     // Catch:{ Exception -> 0x00cf }
        android.widget.LinearLayout r0 = new android.widget.LinearLayout     // Catch:{ Exception -> 0x00cf }
        r0.<init>(r1)     // Catch:{ Exception -> 0x00cf }
        r7 = 1
        r0.setOrientation(r7)     // Catch:{ Exception -> 0x00cf }
        android.widget.LinearLayout$LayoutParams r8 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x00cf }
        r9 = -1
        r8.<init>(r9, r9)     // Catch:{ Exception -> 0x00cf }
        r0.setLayoutParams(r8)     // Catch:{ Exception -> 0x00cf }
        android.webkit.WebView r8 = new android.webkit.WebView     // Catch:{ Exception -> 0x00cf }
        r8.<init>(r1)     // Catch:{ Exception -> 0x00cf }
        r1.f3581a = r8     // Catch:{ Exception -> 0x00cf }
        android.webkit.WebView r8 = r1.f3581a     // Catch:{ Exception -> 0x00cf }
        android.webkit.WebSettings r8 = r8.getSettings()     // Catch:{ Exception -> 0x00cf }
        r8.setJavaScriptEnabled(r7)     // Catch:{ Exception -> 0x00cf }
        r8.setUseWideViewPort(r7)     // Catch:{ Exception -> 0x00cf }
        r8.setLoadWithOverviewMode(r7)     // Catch:{ Exception -> 0x00cf }
        r8.setJavaScriptCanOpenWindowsAutomatically(r6)     // Catch:{ Exception -> 0x00cf }
        r8.setDomStorageEnabled(r7)     // Catch:{ Exception -> 0x00cf }
        android.webkit.WebView r6 = r1.f3581a     // Catch:{ Exception -> 0x00cf }
        android.view.ViewGroup$LayoutParams r7 = new android.view.ViewGroup$LayoutParams     // Catch:{ Exception -> 0x00cf }
        r7.<init>(r9, r9)     // Catch:{ Exception -> 0x00cf }
        r0.addView(r6, r7)     // Catch:{ Exception -> 0x00cf }
        r1.setContentView(r0)     // Catch:{ Exception -> 0x00cf }
        android.webkit.WebView r0 = r1.f3581a     // Catch:{ Exception -> 0x00cf }
        com.alibaba.wireless.security.open.middletier.fc.ui.ContainerActivity$1 r6 = new com.alibaba.wireless.security.open.middletier.fc.ui.ContainerActivity$1     // Catch:{ Exception -> 0x00cf }
        r6.m41998init()     // Catch:{ Exception -> 0x00cf }
        r0.setWebViewClient(r6)     // Catch:{ Exception -> 0x00cf }
        android.webkit.WebView r0 = r1.f3581a     // Catch:{ Exception -> 0x00cf }
        r0.loadUrl(r5)     // Catch:{ Exception -> 0x00cf }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cf }
        r0.<init>()     // Catch:{ Exception -> 0x00cf }
        r0.append(r3)     // Catch:{ Exception -> 0x00cf }
        java.lang.String r6 = "||loadUrl"
        r0.append(r6)     // Catch:{ Exception -> 0x00cf }
        java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x00cf }
        r24 = r3
        r25 = r5
        goto L_0x0137
    L_0x00cf:
        r0 = move-exception
        r16 = r5
        goto L_0x00d6
    L_0x00d3:
        r0 = move-exception
        r16 = r2
    L_0x00d6:
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r6 = "onCreate failed."
        r5.append(r6)
        r5.append(r0)
        java.lang.String r5 = r5.toString()
        android.util.Log.e(r4, r5)
        com.alibaba.wireless.security.open.middletier.fc.ui.a r4 = f3580m
        if (r4 == 0) goto L_0x00f5
        long r5 = r1.f3582b
        r7 = 2
        r8 = 0
        r4.mo11903a(r5, r7, r8)
    L_0x00f5:
        long r4 = java.lang.System.currentTimeMillis()
        r6 = 2303(0x8ff, float:3.227E-42)
        r7 = 7
        java.lang.String r8 = r1.f3586f
        long r9 = r1.f3585e
        long r9 = r4 - r9
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        r4.append(r2)
        java.lang.String r0 = r0.getMessage()
        r4.append(r0)
        java.lang.String r11 = r4.toString()
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        r0.append(r2)
        long r4 = r1.f3582b
        r0.append(r4)
        java.lang.String r14 = r0.toString()
        java.lang.String r15 = r1.f3587g
        java.lang.String r5 = "100107"
        r12 = r3
        r13 = r16
        com.alibaba.wireless.security.framework.utils.C1347a.m3972a(r5, r6, r7, r8, r9, r11, r12, r13, r14, r15)
        r28.finish()
        r24 = r3
        r25 = r16
    L_0x0137:
        boolean r0 = r1.f3588h
        if (r0 == 0) goto L_0x0167
        long r3 = java.lang.System.currentTimeMillis()
        r18 = 0
        r19 = 7
        java.lang.String r0 = r1.f3586f
        long r5 = r1.f3585e
        long r21 = r3 - r5
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        r3.append(r2)
        long r4 = r1.f3582b
        r3.append(r4)
        java.lang.String r26 = r3.toString()
        java.lang.String r2 = r1.f3587g
        java.lang.String r17 = "100107"
        java.lang.String r23 = ""
        r20 = r0
        r27 = r2
        com.alibaba.wireless.security.framework.utils.C1347a.m3972a(r17, r18, r19, r20, r21, r23, r24, r25, r26, r27)
    L_0x0167:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.open.middletier.p093fc.p094ui.ContainerActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.f3581a;
        if (webView != null) {
            try {
                webView.setVisibility(8);
                this.f3581a.removeAllViews();
                this.f3581a.destroy();
                this.f3581a = null;
            } catch (Exception e) {
                String str = this.f3586f;
                StringBuilder sb = new StringBuilder();
                String str2 = "";
                sb.append(str2);
                sb.append(e.getMessage());
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(this.f3582b);
                C1347a.m3972a("100107", 2303, 7, str, 0, sb2, "onDestroy", null, sb3.toString(), this.f3587g);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("WebView onDestroy error : ");
                sb4.append(e.getMessage());
                Log.e("ContainerActivity", sb4.toString());
            }
        }
    }

    public void onResume() {
        super.onResume();
        C1376a aVar = f3580m;
        if (aVar != null) {
            aVar.mo11902a(this.f3582b);
        }
    }
}
