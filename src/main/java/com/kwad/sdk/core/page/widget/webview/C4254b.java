package com.kwad.sdk.core.page.widget.webview;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.kwad.sdk.core.p319c.C4065b;
import com.tencent.mid.sotrage.StorageInterface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.page.widget.webview.b */
public class C4254b extends WebView {
    /* renamed from: b */
    private static final String[] f14073b = {"getClass", "hashCode", "notify", "notifyAll", "equals", "toString", "wait"};
    /* renamed from: a */
    private Boolean f14074a;
    /* renamed from: c */
    private final HashMap<String, Object> f14075c = new HashMap<>();
    /* renamed from: d */
    private String f14076d = null;

    public C4254b(Context context) {
        super(context);
        m17506a(context);
    }

    public C4254b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17506a(context);
    }

    public C4254b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17506a(context);
    }

    /* renamed from: a */
    private Class<?> m17505a(Object obj) {
        Class<Boolean> cls = obj.getClass();
        return cls == Integer.class ? Integer.TYPE : cls == Boolean.class ? Boolean.TYPE : String.class;
    }

    /* renamed from: a */
    private void m17506a(Context context) {
        mo24353e();
    }

    /* renamed from: a */
    private void m17507a(String str, Object obj, StringBuilder sb) {
        Method[] methods;
        String str2;
        if (!TextUtils.isEmpty(str) && obj != null && sb != null) {
            Class cls = obj.getClass();
            sb.append("if(typeof(window.");
            sb.append(str);
            sb.append(")!='undefined'){");
            sb.append("}else {");
            sb.append("    window.");
            sb.append(str);
            sb.append("={");
            for (Method method : cls.getMethods()) {
                String name = method.getName();
                if (!m17510a(name)) {
                    sb.append("        ");
                    sb.append(name);
                    sb.append(":function(");
                    int length = method.getParameterTypes().length;
                    String str3 = StorageInterface.KEY_SPLITER;
                    String str4 = "arg";
                    if (length > 0) {
                        int i = length - 1;
                        int i2 = 0;
                        while (true) {
                            sb.append(str4);
                            if (i2 >= i) {
                                break;
                            }
                            sb.append(i2);
                            sb.append(str3);
                            i2++;
                        }
                        sb.append(i);
                    }
                    sb.append(") {");
                    String str5 = "'+";
                    String str6 = "MyApp:";
                    if (method.getReturnType() != Void.TYPE) {
                        sb.append("            return ");
                        str2 = "prompt('";
                    } else {
                        str2 = "            prompt('";
                    }
                    sb.append(str2);
                    sb.append(str6);
                    sb.append(str5);
                    sb.append("JSON.stringify({");
                    sb.append("obj");
                    String str7 = ":'";
                    sb.append(str7);
                    sb.append(str);
                    String str8 = "',";
                    sb.append(str8);
                    sb.append("func");
                    sb.append(str7);
                    sb.append(name);
                    sb.append(str8);
                    sb.append("args");
                    sb.append(":[");
                    if (length > 0) {
                        int i3 = length - 1;
                        int i4 = 0;
                        while (true) {
                            sb.append(str4);
                            if (i4 >= i3) {
                                break;
                            }
                            sb.append(i4);
                            sb.append(str3);
                            i4++;
                        }
                        sb.append(i3);
                    }
                    sb.append("]})");
                    sb.append(");");
                    sb.append("        }, ");
                }
            }
            sb.append("    };");
            sb.append("}");
        }
    }

    /* renamed from: a */
    private void m17508a(String str, String str2) {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod(str, new Class[]{String.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, new Object[]{str2});
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
            C4065b.m16865a(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042 A[Catch:{ Exception | NoSuchMethodException -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045 A[Catch:{ Exception | NoSuchMethodException -> 0x004e }] */
    /* renamed from: a */
    private boolean m17509a(android.webkit.JsPromptResult r6, java.lang.String r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
        r5 = this;
        java.util.HashMap<java.lang.String, java.lang.Object> r0 = r5.f14075c
        java.lang.Object r7 = r0.get(r7)
        r0 = 0
        if (r7 != 0) goto L_0x000d
        r6.cancel()
        return r0
    L_0x000d:
        r1 = 0
        if (r9 == 0) goto L_0x0012
        int r2 = r9.length
        goto L_0x0013
    L_0x0012:
        r2 = 0
    L_0x0013:
        if (r2 <= 0) goto L_0x0025
        java.lang.Class[] r1 = new java.lang.Class[r2]
        r3 = 0
    L_0x0018:
        if (r3 >= r2) goto L_0x0025
        r4 = r9[r3]
        java.lang.Class r4 = r5.m17505a(r4)
        r1[r3] = r4
        int r3 = r3 + 1
        goto L_0x0018
    L_0x0025:
        r2 = 1
        java.lang.Class r3 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x0050, Exception -> 0x004e }
        java.lang.reflect.Method r8 = r3.getMethod(r8, r1)     // Catch:{ NoSuchMethodException -> 0x0050, Exception -> 0x004e }
        java.lang.Object r7 = r8.invoke(r7, r9)     // Catch:{ NoSuchMethodException -> 0x0050, Exception -> 0x004e }
        if (r7 == 0) goto L_0x003f
        java.lang.Class r8 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x0050, Exception -> 0x004e }
        java.lang.Class r9 = java.lang.Void.TYPE     // Catch:{ NoSuchMethodException -> 0x0050, Exception -> 0x004e }
        if (r8 != r9) goto L_0x003d
        goto L_0x003f
    L_0x003d:
        r8 = 0
        goto L_0x0040
    L_0x003f:
        r8 = 1
    L_0x0040:
        if (r8 == 0) goto L_0x0045
        java.lang.String r7 = ""
        goto L_0x0049
    L_0x0045:
        java.lang.String r7 = r7.toString()     // Catch:{ NoSuchMethodException -> 0x0050, Exception -> 0x004e }
    L_0x0049:
        r6.confirm(r7)     // Catch:{ NoSuchMethodException -> 0x0050, Exception -> 0x004e }
        r0 = 1
        goto L_0x0054
    L_0x004e:
        r7 = move-exception
        goto L_0x0051
    L_0x0050:
        r7 = move-exception
    L_0x0051:
        com.kwad.sdk.core.p319c.C4065b.m16865a(r7)
    L_0x0054:
        r6.cancel()
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.page.widget.webview.C4254b.m17509a(android.webkit.JsPromptResult, java.lang.String, java.lang.String, java.lang.Object[]):boolean");
    }

    /* renamed from: a */
    private boolean m17510a(String str) {
        for (String equals : f14073b) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    private boolean mo24353e() {
        try {
            if (mo24369b() && !mo24370c()) {
                m17508a("removeJavascriptInterface", "searchBoxJavaBridge_");
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: f */
    private boolean mo24354f() {
        return ((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled();
    }

    /* renamed from: g */
    private void mo24355g() {
        try {
            if (!TextUtils.isEmpty(this.f14076d)) {
                loadUrl(this.f14076d);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: h */
    private String m17514h() {
        if (this.f14075c.size() == 0) {
            this.f14076d = null;
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:(function JsAddJavascriptInterface_(){");
        for (Entry entry : this.f14075c.entrySet()) {
            try {
                m17507a((String) entry.getKey(), entry.getValue(), sb);
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }
        sb.append("})()");
        return sb.toString();
    }

    private void setAccessibilityEnabled(boolean z) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setAccessibilityState", new Class[]{Boolean.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(accessibilityManager, new Object[]{Boolean.valueOf(z)});
            declaredMethod.setAccessible(false);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void mo24365a() {
        if (VERSION.SDK_INT == 17 && this.f14074a == null && mo24354f()) {
            this.f14074a = Boolean.valueOf(true);
            setAccessibilityEnabled(false);
        }
    }

    /* renamed from: a */
    public void mo24366a(WebView webView) {
        mo24371d();
    }

    /* renamed from: a */
    public boolean mo24367a(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (!str2.startsWith("MyApp:")) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2.substring(6));
            String string = jSONObject.getString("obj");
            String string2 = jSONObject.getString("func");
            JSONArray jSONArray = jSONObject.getJSONArray("args");
            Object[] objArr = null;
            if (jSONArray != null) {
                int length = jSONArray.length();
                if (length > 0) {
                    objArr = new Object[length];
                    for (int i = 0; i < length; i++) {
                        objArr[i] = jSONArray.get(i);
                    }
                }
            }
            if (m17509a(jsPromptResult, string, string2, objArr)) {
                return true;
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        jsPromptResult.cancel();
        return false;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14075c.put(str, obj);
            mo24371d();
        }
    }

    /* renamed from: b */
    public boolean mo24369b() {
        return VERSION.SDK_INT >= 11;
    }

    /* renamed from: c */
    public boolean mo24370c() {
        return VERSION.SDK_INT >= 17;
    }

    /* renamed from: d */
    public void mo24371d() {
        if (!TextUtils.isEmpty(this.f14076d)) {
            mo24355g();
            return;
        }
        this.f14076d = m17514h();
        mo24355g();
    }

    public void setOverScrollMode(int i) {
        try {
            super.setOverScrollMode(i);
        } catch (Exception e) {
            String stackTraceString = Log.getStackTraceString(e);
            if (stackTraceString.contains("android.content.pm.PackageManager$NameNotFoundException") || stackTraceString.contains("java.lang.RuntimeException: Cannot load WebView") || stackTraceString.contains("android.webkit.WebViewFactory$MissingWebViewPackageException: Failed to load WebView provider: No WebView installed")) {
                try {
                    destroy();
                } catch (Exception unused) {
                }
            } else {
                throw e;
            }
        }
    }
}
