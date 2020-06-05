package com.kwad.sdk.core.p326e.p328b;

import android.text.TextUtils;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p319c.C4065b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import okhttp3.C8358aa;
import okhttp3.C8362ab;
import okhttp3.C8510v;
import okhttp3.C8513x;
import okhttp3.C8513x.C8515a;
import okhttp3.C8518z.C8519a;
import okhttp3.FormBody;
import okhttp3.FormBody.C8502a;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.e.b.b */
public class C4108b {
    /* renamed from: a */
    public static String f13767a = "UTF-8";
    /* renamed from: b */
    public static C8513x f13768b = new C8515a().mo40622a(3000, TimeUnit.MILLISECONDS).mo40633b(6000, TimeUnit.MILLISECONDS).mo40632a();
    /* renamed from: c */
    private static final String f13769c;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("ksad-android-2.6.5.2-");
        sb.append(KsAdSDK.getAppId());
        f13769c = sb.toString();
    }

    /* renamed from: a */
    private static String m17061a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4065b.m16865a(e);
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* renamed from: a */
    public static java.lang.String m17062a(okhttp3.C8362ab r6) {
        /*
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        r1 = 0
        okhttp3.ac r2 = r6.mo40097h()     // Catch:{ all -> 0x0065 }
        java.io.InputStream r2 = r2.mo40124d()     // Catch:{ all -> 0x0065 }
        java.lang.String r3 = "Content-Encoding"
        java.util.List r6 = r6.mo40087a(r3)     // Catch:{ all -> 0x0063 }
        r3 = 0
        if (r6 == 0) goto L_0x0032
        java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0063 }
    L_0x001b:
        boolean r4 = r6.hasNext()     // Catch:{ all -> 0x0063 }
        if (r4 == 0) goto L_0x0032
        java.lang.Object r4 = r6.next()     // Catch:{ all -> 0x0063 }
        java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0063 }
        if (r4 == 0) goto L_0x001b
        java.lang.String r5 = "gzip"
        boolean r4 = r5.equalsIgnoreCase(r4)     // Catch:{ all -> 0x0063 }
        if (r4 == 0) goto L_0x001b
        r3 = 1
    L_0x0032:
        if (r3 == 0) goto L_0x003b
        java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0063 }
        r6.<init>(r2)     // Catch:{ all -> 0x0063 }
        r1 = r6
        goto L_0x003c
    L_0x003b:
        r6 = r2
    L_0x003c:
        java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0063 }
        java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x0063 }
        java.lang.String r5 = f13767a     // Catch:{ all -> 0x0063 }
        r4.<init>(r6, r5)     // Catch:{ all -> 0x0063 }
        r6 = 8
        r3.<init>(r4, r6)     // Catch:{ all -> 0x0063 }
    L_0x004a:
        java.lang.String r6 = r3.readLine()     // Catch:{ all -> 0x0063 }
        if (r6 == 0) goto L_0x0054
        r0.append(r6)     // Catch:{ all -> 0x0063 }
        goto L_0x004a
    L_0x0054:
        if (r1 == 0) goto L_0x0059
        r1.close()
    L_0x0059:
        if (r2 == 0) goto L_0x005e
        r2.close()
    L_0x005e:
        java.lang.String r6 = r0.toString()
        return r6
    L_0x0063:
        r6 = move-exception
        goto L_0x0067
    L_0x0065:
        r6 = move-exception
        r2 = r1
    L_0x0067:
        if (r1 == 0) goto L_0x006c
        r1.close()
    L_0x006c:
        if (r2 == 0) goto L_0x0071
        r2.close()
    L_0x0071:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.p326e.p328b.C4108b.m17062a(okhttp3.ab):java.lang.String");
    }

    /* renamed from: a */
    public static C8362ab m17063a(String str, Map<String, String> map) {
        try {
            C8519a a = new C8519a().mo40655a(str);
            a.mo40662b("User-Agent", f13769c);
            m17067a(a, map);
            return m17066a().mo40177a(a.mo40663b()).mo40173a();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static C8362ab m17064a(String str, Map<String, String> map, Map<String, String> map2) {
        try {
            C8519a a = new C8519a().mo40655a(str);
            a.mo40662b("User-Agent", f13769c);
            m17067a(a, map);
            m17069b(a, map2);
            return m17066a().mo40177a(a.mo40663b()).mo40173a();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static C8362ab m17065a(String str, Map<String, String> map, JSONObject jSONObject) {
        try {
            C8519a a = new C8519a().mo40655a(str);
            a.mo40662b("User-Agent", f13769c);
            m17067a(a, map);
            m17068a(a, jSONObject);
            return m17066a().mo40177a(a.mo40663b()).mo40173a();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static C8513x m17066a() {
        return f13768b;
    }

    /* renamed from: a */
    public static void m17067a(C8519a aVar, Map<String, String> map) {
        if (aVar != null && map != null && !map.isEmpty()) {
            for (Entry entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        aVar.mo40661b((String) entry.getKey());
                        aVar.mo40662b((String) entry.getKey(), (String) entry.getValue());
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m17068a(C8519a aVar, JSONObject jSONObject) {
        aVar.mo40658a(C8358aa.m35765a(C8510v.m36598b("application/json; charset=utf-8"), jSONObject.toString()));
    }

    /* renamed from: b */
    public static void m17069b(C8519a aVar, Map<String, String> map) {
        FormBody qVar;
        if (map == null || map.isEmpty()) {
            qVar = null;
        } else {
            C8502a aVar2 = new C8502a();
            for (Entry entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        aVar2.mo40524b((String) entry.getKey(), m17061a((String) entry.getValue()));
                    } catch (Exception unused) {
                    }
                }
            }
            qVar = aVar2.mo40523a();
        }
        if (aVar != null && qVar != null) {
            aVar.mo40658a((C8358aa) qVar);
        }
    }
}
