package com.ali.auth.third.p034ui;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ali.auth.third.core.C0980a;
import com.ali.auth.third.core.model.C1030k;
import com.ali.auth.third.core.p023b.C0985c;
import com.ali.auth.third.p016a.C0958b;
import com.ali.auth.third.p016a.p018b.C0959a;
import com.ali.auth.third.p034ui.webview.BaseWebViewActivity;
import com.ali.auth.third.p034ui.webview.C1083a;

/* renamed from: com.ali.auth.third.ui.QrLoginConfirmActivity */
public class QrLoginConfirmActivity extends BaseWebViewActivity {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public WebViewClient mo10385a() {
        return new C1083a(this) {
            public boolean shouldOverrideUrlLoading(final WebView webView, String str) {
                if (!((C0958b) C0980a.m1867a(C0958b.class)).mo10272a(str)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                ((C0958b) C0980a.m1867a(C0958b.class)).mo10271a((C0985c) new C0985c() {
                    /* renamed from: a */
                    public void mo10305a(int i, String str) {
                    }

                    /* renamed from: a */
                    public void mo10306a(C1030k kVar) {
                        webView.reload();
                    }
                });
                return true;
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2196f.mo10453a("accountBridge", (Object) new C0959a());
    }
}
