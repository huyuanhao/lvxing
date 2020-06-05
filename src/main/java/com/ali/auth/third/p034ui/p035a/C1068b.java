package com.ali.auth.third.p034ui.p035a;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ali.auth.third.core.p024c.C0989a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ali.auth.third.ui.a.b */
public class C1068b {
    /* renamed from: d */
    public WebView f2151d;
    /* renamed from: e */
    public int f2152e;

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2079d(String str) {
        WebView webView = this.f2151d;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: e */
    public static String m2080e(String str) {
        return str.replace("\\", "\\\\");
    }

    /* renamed from: a */
    public Activity mo10406a() {
        return (Activity) this.f2151d.getContext();
    }

    /* renamed from: a */
    public void mo10407a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            mo10409b(jSONObject.toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public void mo10408a(final String str) {
        C0989a.f1901p.mo10335a(new Runnable() {
            public void run() {
                String str;
                if (TextUtils.isEmpty(str)) {
                    str = String.format("javascript:window.HavanaBridge.onSuccess(%s);", new Object[]{Integer.valueOf(C1068b.this.f2152e)});
                } else {
                    str = String.format("javascript:window.HavanaBridge.onSuccess(%s,'%s');", new Object[]{Integer.valueOf(C1068b.this.f2152e), C1068b.m2080e(str)});
                }
                C1068b.this.m2079d(str);
            }
        });
    }

    /* renamed from: b */
    public void mo10409b(final String str) {
        C0989a.f1901p.mo10335a(new Runnable() {
            public void run() {
                String str;
                if (TextUtils.isEmpty(str)) {
                    str = String.format("javascript:window.HavanaBridge.onFailure(%s,'');", new Object[]{Integer.valueOf(C1068b.this.f2152e)});
                } else {
                    str = String.format("javascript:window.HavanaBridge.onFailure(%s,'%s');", new Object[]{Integer.valueOf(C1068b.this.f2152e), C1068b.m2080e(str)});
                }
                C1068b.this.m2079d(str);
            }
        });
    }
}
