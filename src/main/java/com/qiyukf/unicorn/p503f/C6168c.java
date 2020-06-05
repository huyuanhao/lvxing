package com.qiyukf.unicorn.p503f;

import com.p522qq.p523e.comm.constants.Constants;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nimlib.p450b.C5725d;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.RequestCallback;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p502e.C6044c;
import com.qiyukf.unicorn.p502e.C6045d;
import com.qiyukf.unicorn.p503f.p504a.C6109b;
import com.qiyukf.unicorn.p503f.p512b.C6166a;
import com.qiyukf.unicorn.p503f.p512b.C6167b;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.f.c */
public final class C6168c {
    /* renamed from: a */
    public static int m24473a(String str) {
        int i;
        int a = C5725d.m23052a();
        String str2 = a == 1 ? "http://da.ysf.space" : a == 2 ? "http://da.qiyukf.netease.com" : "https://da.qiyukf.com";
        try {
            C6166a.m24465a(str2, String.format(Locale.getDefault(), "%s?ak=%s&bid=%s&r=%s", new Object[]{"/mobileda/da.gif", C6029d.m24043d(), C6029d.m24039c().getPackageName(), str}), null);
            i = 200;
        } catch (C6167b e) {
            i = e.mo29239a();
        }
        StringBuilder sb = new StringBuilder("upload records, code = ");
        sb.append(i);
        C5264a.m21624d("YSFClient", sb.toString());
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00bd  */
    /* renamed from: a */
    public static int m24474a(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, long r13) {
        /*
        java.lang.String r0 = com.qiyukf.unicorn.p503f.p512b.C6166a.m24464a()
        java.lang.String r1 = "/swallow/log"
        java.util.HashMap r2 = new java.util.HashMap
        r2.<init>()
        java.lang.String r3 = "android"
        java.lang.String r4 = "terminal"
        r2.put(r4, r3)
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        java.lang.String r5 = "sdk_"
        r4.<init>(r5)
        r4.append(r8)
        java.lang.String r8 = r4.toString()
        java.lang.String r4 = "version"
        r2.put(r4, r8)
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r5 = android.os.Build.BRAND
        r4.append(r5)
        java.lang.String r5 = "/"
        r4.append(r5)
        java.lang.String r6 = android.os.Build.MODEL
        r4.append(r6)
        r4.append(r5)
        java.lang.String r5 = android.os.Build.VERSION.RELEASE
        r4.append(r5)
        java.lang.String r4 = r4.toString()
        java.lang.String r5 = "platform"
        r2.put(r5, r4)
        java.lang.String r4 = "type"
        r2.put(r4, r9)
        boolean r4 = android.text.TextUtils.isEmpty(r10)
        if (r4 != 0) goto L_0x0068
        java.lang.String r4 = "\n"
        boolean r5 = r10.contains(r4)
        if (r5 != 0) goto L_0x005e
        goto L_0x0068
    L_0x005e:
        r5 = 0
        int r4 = r10.indexOf(r4)
        java.lang.String r4 = r10.substring(r5, r4)
        goto L_0x0069
    L_0x0068:
        r4 = r10
    L_0x0069:
        java.lang.String r5 = "identity"
        r2.put(r5, r4)
        java.lang.String r4 = com.qiyukf.nimlib.C5718b.m23020g()
        java.lang.String r5 = "appkey"
        r2.put(r5, r4)
        java.lang.String r5 = com.qiyukf.nimlib.C5718b.m23015b()
        boolean r6 = android.text.TextUtils.isEmpty(r5)
        if (r6 == 0) goto L_0x00a3
        android.content.Context r6 = com.qiyukf.nimlib.C5718b.m23009a()
        if (r6 == 0) goto L_0x00a3
        android.content.Context r5 = com.qiyukf.nimlib.C5718b.m23009a()
        android.content.ContentResolver r5 = r5.getContentResolver()
        java.lang.String r6 = "android_id"
        java.lang.String r5 = android.provider.Settings.Secure.getString(r5, r6)
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        java.lang.String r7 = "ANDROID_ID_"
        r6.<init>(r7)
        r6.append(r5)
        java.lang.String r5 = r6.toString()
    L_0x00a3:
        boolean r6 = android.text.TextUtils.isEmpty(r5)
        if (r6 == 0) goto L_0x00ab
        java.lang.String r5 = "ANONYMOUS"
    L_0x00ab:
        java.lang.String r6 = "clientid"
        r2.put(r6, r5)
        java.lang.String r5 = "level"
        java.lang.String r6 = "ERROR"
        r2.put(r5, r6)
        boolean r5 = android.text.TextUtils.isEmpty(r11)
        if (r5 == 0) goto L_0x00bf
        java.lang.String r11 = "EMPTY_MESSAGE"
    L_0x00bf:
        java.lang.String r5 = "message"
        r2.put(r5, r11)
        java.lang.String r11 = "attachment"
        r2.put(r11, r10)
        org.json.JSONObject r10 = new org.json.JSONObject
        r10.<init>()
        java.lang.String r11 = "count"
        com.qiyukf.basesdk.p412c.C5366b.m22029a(r10, r11, r12)
        java.lang.String r11 = "time"
        com.qiyukf.basesdk.p412c.C5366b.m22030a(r10, r11, r13)
        java.lang.String r10 = r10.toString()
        java.lang.String r11 = "extra"
        r2.put(r11, r10)
        long r10 = java.lang.System.currentTimeMillis()
        java.lang.String r12 = java.lang.String.valueOf(r10)
        java.lang.String r13 = "timestamp"
        r2.put(r13, r12)
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        java.lang.String r13 = "ysf"
        r12.<init>(r13)
        r12.append(r3)
        r12.append(r8)
        r12.append(r9)
        r12.append(r4)
        r12.append(r10)
        java.lang.String r8 = "qykf"
        r12.append(r8)
        java.lang.String r8 = r12.toString()
        java.lang.String r8 = com.qiyukf.basesdk.p412c.p416c.C5405c.m22113a(r8)
        java.lang.String r9 = "sign"
        r2.put(r9, r8)
        java.util.HashMap r8 = new java.util.HashMap
        r8.<init>()
        java.lang.String r8 = com.qiyukf.unicorn.p503f.p512b.C6166a.m24466a(r0, r1, r8, r2)     // Catch:{ b -> 0x012a }
        org.json.JSONObject r8 = com.qiyukf.basesdk.p412c.C5366b.m22027a(r8)     // Catch:{ b -> 0x012a }
        java.lang.String r9 = "code"
        int r8 = com.qiyukf.basesdk.p412c.C5366b.m22034b(r8, r9)     // Catch:{ b -> 0x012a }
        return r8
    L_0x012a:
        r8 = move-exception
        int r8 = r8.mo29239a()
        return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p503f.C6168c.m24474a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, long):int");
    }

    /* renamed from: a */
    public static C6165b m24475a(String str, String str2) {
        String str3 = "/webapi/user/create.action";
        HashMap hashMap = new HashMap(2);
        hashMap.put("appkey", str);
        hashMap.put("deviceid", str2);
        try {
            JSONObject a = C5366b.m22027a(C6166a.m24470b(str3, hashMap));
            C6165b bVar = new C6165b();
            int b = C5366b.m22034b(a, "code");
            if (b == 200) {
                JSONObject f = C5366b.m22040f(a, "info");
                C5264a.m21620b("test", f.toString());
                bVar.mo29235a(new LoginInfo(f.getString("accid"), f.getString("token")));
                boolean z = true;
                if (C5366b.m22034b(f, "push") != 1) {
                    z = false;
                }
                bVar.mo29236a(z);
                C6014b.m23943c(C5366b.m22039e(f, "bid"));
                return bVar;
            }
            StringBuilder sb = new StringBuilder("fetch login data error, code: ");
            sb.append(b);
            C5264a.m21617a("HTTP", sb.toString());
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static JSONObject m24476a() {
        String str = "/swallow/config";
        HashMap hashMap = new HashMap();
        hashMap.put("t", "aos");
        hashMap.put(Constants.PORTRAIT, "sdk");
        try {
            return C5366b.m22027a(C6166a.m24465a(C6166a.m24464a(), str, hashMap));
        } catch (C6167b e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static JSONObject m24477a(String str, String str2, long j, String str3, long j2, long j3) {
        String str4 = "/webapi/user/queryCount.action";
        HashMap hashMap = new HashMap(3);
        hashMap.put("time", String.valueOf(j));
        if (j2 <= 0 || j3 <= 0) {
            hashMap.put("appKey", str);
            hashMap.put("nimId", str2);
            hashMap.put("pkg", str3);
        } else {
            hashMap.put("user", String.valueOf(j2));
            hashMap.put("app", String.valueOf(j3));
        }
        try {
            return C5366b.m22040f(C5366b.m22027a(C6166a.m24470b(str4, hashMap)), ArgKey.KEY_RESULT);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m24478a(RequestCallback<List<C6045d>> requestCallback) {
        String str = "code";
        String str2 = "emojiPackage/get";
        HashMap hashMap = new HashMap();
        hashMap.put("k", C6029d.m24043d());
        try {
            ArrayList arrayList = new ArrayList();
            String a = C6166a.m24467a("/webapi/emoji/emojiPackage/get", hashMap);
            C5264a.m21617a(str2, a);
            JSONObject a2 = C5366b.m22027a(a);
            if (C5366b.m22034b(a2, str) == 200) {
                JSONArray g = C5366b.m22041g(a2, ArgKey.KEY_RESULT);
                for (int i = 0; i < g.length(); i++) {
                    JSONObject b = C5366b.m22036b(g, i);
                    C6045d dVar = new C6045d();
                    C6109b.m24269a((Object) dVar, b);
                    arrayList.add(dVar);
                }
                requestCallback.onSuccess(arrayList);
                return;
            }
            requestCallback.onFailed(C5366b.m22034b(a2, str));
        } catch (C6167b e) {
            requestCallback.onException(e);
            StringBuilder sb = new StringBuilder("is error code:");
            sb.append(e.mo29239a());
            C5264a.m21622c(str2, sb.toString());
        }
    }

    /* renamed from: b */
    public static JSONObject m24479b() {
        String str = "/webapi/user/da/config";
        HashMap hashMap = new HashMap();
        hashMap.put("ak", C6029d.m24043d());
        try {
            return C5366b.m22027a(C6166a.m24467a(str, hashMap));
        } catch (C6167b e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static List<C6044c> m24480c() {
        String str = "/webapi/emoji/emojiPackage/map";
        HashMap hashMap = new HashMap();
        hashMap.put("k", C6029d.m24043d());
        try {
            ArrayList arrayList = new ArrayList();
            String a = C6166a.m24467a(str, hashMap);
            C5264a.m21617a(str, a);
            JSONObject a2 = C5366b.m22027a(a);
            if (C5366b.m22034b(a2, "code") == 200) {
                JSONArray g = C5366b.m22041g(a2, ArgKey.KEY_RESULT);
                for (int i = 0; i < g.length(); i++) {
                    JSONObject b = C5366b.m22036b(g, i);
                    C6044c cVar = new C6044c();
                    C6109b.m24269a((Object) cVar, b);
                    arrayList.add(cVar);
                }
                return arrayList;
            }
        } catch (C6167b e) {
            StringBuilder sb = new StringBuilder("is error code:");
            sb.append(e.mo29239a());
            C5264a.m21622c(str, sb.toString());
        }
        return null;
    }
}
