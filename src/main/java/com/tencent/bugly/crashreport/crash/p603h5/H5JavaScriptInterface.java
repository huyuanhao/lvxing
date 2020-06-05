package com.tencent.bugly.crashreport.crash.p603h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport.WebViewInterface;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface */
public class H5JavaScriptInterface {
    /* renamed from: a */
    private static HashSet<Integer> f24243a = new HashSet<>();
    /* renamed from: b */
    private String f24244b = null;
    /* renamed from: c */
    private Thread f24245c = null;
    /* renamed from: d */
    private String f24246d = null;
    /* renamed from: e */
    private Map<String, String> f24247e = null;

    private H5JavaScriptInterface() {
    }

    public static H5JavaScriptInterface getInstance(WebViewInterface webViewInterface) {
        if (webViewInterface == null || f24243a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f24243a.add(Integer.valueOf(webViewInterface.hashCode()));
        h5JavaScriptInterface.f24245c = Thread.currentThread();
        h5JavaScriptInterface.f24246d = m30983a(h5JavaScriptInterface.f24245c);
        h5JavaScriptInterface.f24247e = m30984a(webViewInterface);
        return h5JavaScriptInterface;
    }

    /* renamed from: a */
    private static String m30983a(Thread thread) {
        if (thread == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = "\n";
        sb.append(str);
        for (int i = 2; i < thread.getStackTrace().length; i++) {
            StackTraceElement stackTraceElement = thread.getStackTrace()[i];
            if (!stackTraceElement.toString().contains("crashreport")) {
                sb.append(stackTraceElement.toString());
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static Map<String, String> m30984a(WebViewInterface webViewInterface) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(webViewInterface.getContentDescription());
        hashMap.put("[WebView] ContentDescription", sb.toString());
        return hashMap;
    }

    /* renamed from: a */
    private C7200a m30982a(String str) {
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C7200a aVar = new C7200a();
                aVar.f24248a = jSONObject.getString("projectRoot");
                if (aVar.f24248a == null) {
                    return null;
                }
                aVar.f24249b = jSONObject.getString("context");
                if (aVar.f24249b == null) {
                    return null;
                }
                aVar.f24250c = jSONObject.getString("url");
                if (aVar.f24250c == null) {
                    return null;
                }
                aVar.f24251d = jSONObject.getString("userAgent");
                if (aVar.f24251d == null) {
                    return null;
                }
                aVar.f24252e = jSONObject.getString("language");
                if (aVar.f24252e == null) {
                    return null;
                }
                aVar.f24253f = jSONObject.getString(ArgKey.KEY_NAME);
                if (aVar.f24253f != null) {
                    if (!aVar.f24253f.equals("null")) {
                        String string = jSONObject.getString("stacktrace");
                        if (string == null) {
                            return null;
                        }
                        int indexOf = string.indexOf("\n");
                        if (indexOf < 0) {
                            C7226an.m31148d("H5 crash stack's format is wrong!", new Object[0]);
                            return null;
                        }
                        aVar.f24255h = string.substring(indexOf + 1);
                        aVar.f24254g = string.substring(0, indexOf);
                        int indexOf2 = aVar.f24254g.indexOf(":");
                        if (indexOf2 > 0) {
                            aVar.f24254g = aVar.f24254g.substring(indexOf2 + 1);
                        }
                        aVar.f24256i = jSONObject.getString("file");
                        if (aVar.f24253f == null) {
                            return null;
                        }
                        aVar.f24257j = jSONObject.getLong("lineNumber");
                        if (aVar.f24257j < 0) {
                            return null;
                        }
                        aVar.f24258k = jSONObject.getLong("columnNumber");
                        if (aVar.f24258k < 0) {
                            return null;
                        }
                        C7226an.m31141a("H5 crash information is following: ", new Object[0]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("[projectRoot]: ");
                        sb.append(aVar.f24248a);
                        C7226an.m31141a(sb.toString(), new Object[0]);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("[context]: ");
                        sb2.append(aVar.f24249b);
                        C7226an.m31141a(sb2.toString(), new Object[0]);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("[url]: ");
                        sb3.append(aVar.f24250c);
                        C7226an.m31141a(sb3.toString(), new Object[0]);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("[userAgent]: ");
                        sb4.append(aVar.f24251d);
                        C7226an.m31141a(sb4.toString(), new Object[0]);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("[language]: ");
                        sb5.append(aVar.f24252e);
                        C7226an.m31141a(sb5.toString(), new Object[0]);
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("[name]: ");
                        sb6.append(aVar.f24253f);
                        C7226an.m31141a(sb6.toString(), new Object[0]);
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("[message]: ");
                        sb7.append(aVar.f24254g);
                        C7226an.m31141a(sb7.toString(), new Object[0]);
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("[stacktrace]: \n");
                        sb8.append(aVar.f24255h);
                        C7226an.m31141a(sb8.toString(), new Object[0]);
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append("[file]: ");
                        sb9.append(aVar.f24256i);
                        C7226an.m31141a(sb9.toString(), new Object[0]);
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("[lineNumber]: ");
                        sb10.append(aVar.f24257j);
                        C7226an.m31141a(sb10.toString(), new Object[0]);
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("[columnNumber]: ");
                        sb11.append(aVar.f24258k);
                        C7226an.m31141a(sb11.toString(), new Object[0]);
                        return aVar;
                    }
                }
                return null;
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m30985a(C7200a aVar, Thread thread, Map<String, String> map) {
        if (aVar != null) {
            InnerApi.postH5CrashAsync(thread, aVar.f24253f, aVar.f24254g, aVar.f24255h, map);
        }
    }

    @JavascriptInterface
    public void printLog(String str) {
        C7226an.m31148d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            C7226an.m31148d("Payload from JS is null.", new Object[0]);
            return;
        }
        String b = C7232aq.m31207b(str.getBytes());
        String str2 = this.f24244b;
        if (str2 == null || !str2.equals(b)) {
            this.f24244b = b;
            C7226an.m31148d("Handling JS exception ...", new Object[0]);
            C7200a a = m30982a(str);
            if (a == null) {
                C7226an.m31148d("Failed to parse payload.", new Object[0]);
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(a.mo34723a());
            linkedHashMap.putAll(this.f24247e);
            linkedHashMap.put("Java Stack", this.f24246d);
            m30985a(a, this.f24245c, linkedHashMap);
            return;
        }
        C7226an.m31148d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
    }
}
