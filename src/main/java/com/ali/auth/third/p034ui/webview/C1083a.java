package com.ali.auth.third.p034ui.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ali.auth.third.ui.R;
import java.lang.ref.WeakReference;

/* renamed from: com.ali.auth.third.ui.webview.a */
public class C1083a extends WebViewClient {
    /* renamed from: b */
    protected WeakReference<Activity> f2207b;
    /* renamed from: c */
    protected boolean f2208c = true;
    /* renamed from: d */
    protected boolean f2209d = false;

    public C1083a(Activity activity) {
        this.f2207b = new WeakReference<>(activity);
    }

    public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = (Activity) this.f2207b.get();
        if (this.f2208c) {
            String string = webView.getContext().getResources().getString(R.string.aliuser_ssl_error_title);
            String string2 = webView.getContext().getResources().getString(R.string.aliuser_ssl_error_info);
            String string3 = webView.getContext().getResources().getString(R.string.aliuser_common_ok);
            C10841 r2 = new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                    C1083a.this.f2209d = true;
                }
            };
            String string4 = webView.getContext().getResources().getString(R.string.aliuser_cancel);
            C10852 r4 = new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                    C1083a.this.f2209d = false;
                }
            };
            Builder builder = new Builder(webView.getContext());
            builder.setPositiveButton(string3, r2);
            builder.setNeutralButton(string4, r4);
            try {
                AlertDialog create = builder.create();
                create.setTitle(string);
                create.setMessage(string2);
                create.show();
                this.f2208c = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.f2209d) {
            sslErrorHandler.proceed();
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }
}
