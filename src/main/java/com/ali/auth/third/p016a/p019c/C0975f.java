package com.ali.auth.third.p016a.p019c;

import android.app.Activity;
import android.webkit.WebView;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p032i.C1017b;
import com.ali.auth.third.core.util.C1034a;
import com.ali.auth.third.p016a.C0955a;
import com.ali.auth.third.p034ui.p035a.C1067a;

/* renamed from: com.ali.auth.third.a.c.f */
public class C0975f extends C1017b<String, Void, Void> {
    /* renamed from: b */
    private WebView f1865b;

    public C0975f(WebView webView) {
        super((Activity) webView.getContext());
        this.f1865b = webView;
    }

    /* access modifiers changed from: protected|varargs */
    /* renamed from: a */
    public Void mo10274a(String... strArr) {
        if (!C0989a.f1893h.mo10331b()) {
            C1067a.m2074a(this.f1976a);
            C0955a.f1830a.mo10262a(this.f1976a);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10282a(Throwable th) {
        C1034a.m1977a();
    }
}
