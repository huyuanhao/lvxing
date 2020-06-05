package com.kwad.sdk.core.page;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.p306a.C3809l;
import java.io.Serializable;

public class AdWebViewActivity extends Activity {
    /* renamed from: a */
    private KsAdWebView f14039a;
    /* renamed from: b */
    private AdTemplate f14040b;

    /* renamed from: a */
    private void m17485a() {
        this.f14039a = (KsAdWebView) findViewById(C3809l.m15789a(this, "ksad_video_webview"));
        this.f14039a.setTemplateData(this.f14040b);
        this.f14039a.loadUrl(C4322a.m17654v(C4324c.m17668e(this.f14040b)));
        this.f14039a.mo24353e();
    }

    /* renamed from: a */
    public static void m17486a(Context context, AdTemplate adTemplate) {
        if (context != null && adTemplate != null) {
            Intent intent = new Intent(context, AdWebViewActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("key_template", adTemplate);
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C3809l.m15792b(this, "ksad_dialog_adwebview"));
        Serializable serializableExtra = getIntent().getSerializableExtra("key_template");
        if (serializableExtra instanceof AdTemplate) {
            this.f14040b = (AdTemplate) serializableExtra;
            m17485a();
            return;
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        KsAdWebView ksAdWebView = this.f14039a;
        if (ksAdWebView != null) {
            ksAdWebView.mo24354f();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }
}
