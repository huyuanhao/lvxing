package com.ali.auth.third.p034ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.ali.auth.third.core.p023b.C0985c;
import com.ali.auth.third.p016a.p018b.C0959a;
import com.ali.auth.third.p034ui.webview.AuthWebView;
import com.ali.auth.third.p034ui.webview.C1086b;

/* renamed from: com.ali.auth.third.ui.QRView */
public class QRView extends LinearLayout {
    /* renamed from: a */
    public static C0985c f2130a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public AuthWebView f2131b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public int f2132c;

    public QRView(Context context) {
        super(context);
    }

    public QRView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.ali_auth_qrview, this, true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        f2130a = null;
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2131b = (AuthWebView) findViewById(R.id.ali_auth_webview);
        this.f2131b.setPadding(0, 0, 0, 0);
        this.f2131b.mo10453a("loginBridge", (Object) new C0959a());
        this.f2131b.setWebChromeClient(new C1086b());
        this.f2131b.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        this.f2131b.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                QRView.this.f2131b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                QRView qRView = QRView.this;
                qRView.f2132c = qRView.f2131b.getWidth();
            }
        });
    }
}
