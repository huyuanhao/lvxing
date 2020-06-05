package com.alipay.sdk.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.app.statistic.C1505a;
import com.alipay.sdk.util.C1553o;
import com.alipay.sdk.widget.C1559a;
import java.lang.ref.WeakReference;

/* renamed from: com.alipay.sdk.app.b */
public class C1494b extends WebViewClient {
    /* renamed from: a */
    private Activity f3819a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean f3820b;
    /* renamed from: c */
    private Handler f3821c = new Handler(this.f3819a.getMainLooper());
    /* renamed from: d */
    private C1559a f3822d;
    /* renamed from: e */
    private boolean f3823e;

    /* renamed from: com.alipay.sdk.app.b$a */
    private static final class C1495a implements Runnable {
        /* renamed from: a */
        private final WeakReference<C1494b> f3824a;

        C1495a(C1494b bVar) {
            this.f3824a = new WeakReference<>(bVar);
        }

        public void run() {
            C1494b bVar = (C1494b) this.f3824a.get();
            if (bVar != null) {
                bVar.m4429d();
            }
        }
    }

    public C1494b(Activity activity) {
        this.f3819a = activity;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f3823e = true;
        super.onReceivedError(webView, i, str, str2);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.f3819a;
        if (activity != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("1");
            sb.append(sslError);
            C1505a.m4452a("net", "SSLError", sb.toString());
            if (this.f3820b) {
                sslErrorHandler.proceed();
                this.f3820b = false;
                return;
            }
            activity.runOnUiThread(new C1496c(this, activity, sslErrorHandler));
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return C1553o.m4676a(webView, str, this.f3819a);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Activity activity = this.f3819a;
        if (!(this.f3821c == null || activity == null || activity.isFinishing())) {
            m4428c();
            this.f3821c.postDelayed(new C1495a(this), 30000);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    public void onPageFinished(WebView webView, String str) {
        Activity activity = this.f3819a;
        if (this.f3821c != null && activity != null && !activity.isFinishing()) {
            m4429d();
            this.f3821c.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: c */
    private void m4428c() {
        Activity activity = this.f3819a;
        if (activity != null) {
            if (this.f3822d == null) {
                this.f3822d = new C1559a(activity, "正在加载");
                this.f3822d.mo12245a(true);
            }
            this.f3822d.mo12244a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m4429d() {
        C1559a aVar = this.f3822d;
        if (aVar != null) {
            aVar.mo12246b();
        }
        this.f3822d = null;
    }

    /* renamed from: a */
    public void mo12129a() {
        this.f3821c = null;
        this.f3819a = null;
    }

    /* renamed from: b */
    public boolean mo12130b() {
        return this.f3823e;
    }
}
