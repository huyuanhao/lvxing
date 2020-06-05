package com.alipay.sdk.widget;

import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alipay.sdk.util.C1550l;
import com.alipay.sdk.util.C1553o;

public class WebViewWindow extends LinearLayout {
    /* access modifiers changed from: private|static */
    /* renamed from: f */
    public static Handler f3970f = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    /* renamed from: a */
    public ImageView f3971a;
    /* renamed from: b */
    private TextView f3972b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public ImageView f3973c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public ProgressBar f3974d;
    /* renamed from: e */
    private WebView f3975e;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public C1556a f3976g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C1557b f3977h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public C1558c f3978i;
    /* renamed from: j */
    private OnClickListener f3979j;
    /* renamed from: k */
    private final float f3980k;

    /* renamed from: com.alipay.sdk.widget.WebViewWindow$a */
    public interface C1556a {
        /* renamed from: a */
        void mo12236a(WebViewWindow webViewWindow, String str);

        /* renamed from: a */
        boolean mo12237a(WebViewWindow webViewWindow, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* renamed from: com.alipay.sdk.widget.WebViewWindow$b */
    public interface C1557b {
        /* renamed from: a */
        boolean mo12238a(WebViewWindow webViewWindow, int i, String str, String str2);

        /* renamed from: a */
        boolean mo12239a(WebViewWindow webViewWindow, SslErrorHandler sslErrorHandler, SslError sslError);

        /* renamed from: b */
        boolean mo12240b(WebViewWindow webViewWindow, String str);

        /* renamed from: c */
        boolean mo12241c(WebViewWindow webViewWindow, String str);
    }

    /* renamed from: com.alipay.sdk.widget.WebViewWindow$c */
    public interface C1558c {
        /* renamed from: a */
        void mo12242a(WebViewWindow webViewWindow);

        /* renamed from: b */
        void mo12243b(WebViewWindow webViewWindow);
    }

    public WebViewWindow(Context context) {
        this(context, null);
    }

    public WebViewWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3979j = new C1577q(this);
        this.f3980k = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        m4702a(context);
        m4705b(context);
        m4707c(context);
    }

    /* renamed from: a */
    private void m4702a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.f3971a = new ImageView(context);
        this.f3971a.setOnClickListener(this.f3979j);
        this.f3971a.setScaleType(ScaleType.CENTER);
        this.f3971a.setImageDrawable(C1550l.m4657a("iVBORw0KGgoAAAANSUhEUgAAAEgAAABIBAMAAACnw650AAAAFVBMVEUAAAARjusRkOkQjuoRkeoRj+oQjunya570AAAABnRSTlMAinWeSkk7CjRNAAAAZElEQVRIx+3MOw6AIBQF0YsrMDGx1obaLeGH/S9BQgkJ82rypp4ceTN1ilvyKizmZIAyU7FML0JVYig55BBAfQ2EU4V4CpZJ+2AiSj11C6rUoTannBpRn4W6xNQjLBSI2+TN0w/+3HT2wPClrQAAAABJRU5ErkJggg==", context));
        this.f3971a.setPadding(m4700a(12), 0, m4700a(12), 0);
        linearLayout.addView(this.f3971a, new LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LayoutParams(m4700a(1), m4700a(25)));
        this.f3972b = new TextView(context);
        this.f3972b.setTextColor(-15658735);
        this.f3972b.setTextSize(17.0f);
        this.f3972b.setMaxLines(1);
        this.f3972b.setEllipsize(TruncateAt.END);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.setMargins(m4700a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.f3972b, layoutParams);
        this.f3973c = new ImageView(context);
        this.f3973c.setOnClickListener(this.f3979j);
        this.f3973c.setScaleType(ScaleType.CENTER);
        this.f3973c.setImageDrawable(C1550l.m4657a("iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAMAAABiM0N1AAAAmVBMVEUAAAARj+oQjuoRkOsVk/AQj+oRjuoQj+oSkO3///8Rj+kRj+oQkOsTk+whm/8Qj+oRj+oQj+oSkus2p/8QjuoQj+oQj+oQj+oQj+oRj+oTkuwRj+oQj+oRj+oRj+oSkOsSkO0ZlfMbk+8XnPgQj+oRj+oQj+oQj+sSj+sRkOoSkescqv8Rj+oQj+oSj+sXku4Rj+kQjuoQjumXGBCVAAAAMnRSTlMAxPtPF8ry7CoB9npbGwe6lm0wBODazb1+aSejm5GEYjcTDwvls6uJc0g/CdWfRCF20AXrk5QAAAJqSURBVFjD7ZfXmpswEIUFphmDCxi3talurGvm/R8uYSDe5FNBwlzsxf6XmvFBmiaZ/PCdWDk9CWn61OhHCMAaXfoRAth7wx6EkMXnWyrho4yg4bDpquI8Jy78Q7eoj9cmUFijsaLM0JsD9CD0uQAa9aNdPuCFvbA7B9t/Becap8Pu6Q/2jcyH81VHc/WCHDQZXwbvtUhQ61iDlqadncU6Rp31yGkZIzOAu7AjtPpYGREzq/pY5DRFHS1siyO6HfkOKTrMjdb2qevV4zosK7MbkFY2LmYk55hL6juCIFWMOI2KGzblmho3b18EIbxL1hs6r5m2Q2WaEElwS3NW4xh6ZZJuzTtUsBKT4G0h35s4y1mNgkNoS6TZ8SKBXTZQGBNYdPTozXGYKoyLAmOasttjThT4xT6Ch+2qIjRhV9Ja3NC87Kyo5We1vCNEMW1T+j1VLZ9UhE54Q1DL52r5piJ0YxdegvWlHOwTu76uKkJX+MOTHno4YFSEbHYdhViojsLrCTg/MKnhKWaEYzvkZFM8aOkPH7iTSvoFZKD7jGEJbarkRaxQyOeWvGVIbsji152jK7TbDgRzcIuz7SGj89BFU8d30TqWeDtrILxyTkD1IXfvmHseuU3lVHDz607bw0f3xDqejm5ncd0j8VDwfoibRy8RcgTkWHBvocbDbMlJsQAkGnAOHwGy90kLmQY1Wkob07/GaCNRIzdoWK7/+6y/XkLDJCcynOGFuUrKIMuCMonNr9VpSOQoIxBgJ0SacGbzZNy4ICrkscvU2fpElYz+U3sd+aQThjfVmjNa5i15kLcojM3Gz8kP34jf4VaV3X55gNEAAAAASUVORK5CYII=", context));
        this.f3973c.setPadding(m4700a(12), 0, m4700a(12), 0);
        linearLayout.addView(this.f3973c, new LayoutParams(-2, -2));
        addView(linearLayout, new LayoutParams(-1, m4700a(48)));
    }

    /* renamed from: b */
    private void m4705b(Context context) {
        this.f3974d = new ProgressBar(context, null, 16973855);
        this.f3974d.setProgressDrawable(context.getResources().getDrawable(17301612));
        this.f3974d.setMax(100);
        this.f3974d.setBackgroundColor(-218103809);
        addView(this.f3974d, new LayoutParams(-1, m4700a(2)));
    }

    /* renamed from: c */
    private void m4707c(Context context) {
        this.f3975e = new WebView(context);
        this.f3975e.setVerticalScrollbarOverlay(true);
        mo12224a(this.f3975e, context);
        WebSettings settings = this.f3975e.getSettings();
        settings.setUseWideViewPort(true);
        settings.setAppCacheMaxSize(5242880);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        try {
            this.f3975e.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f3975e.removeJavascriptInterface("accessibility");
            this.f3975e.removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception unused) {
        }
        addView(this.f3975e, new LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo12224a(WebView webView, Context context) {
        String userAgentString = webView.getSettings().getUserAgentString();
        String packageName = context.getPackageName();
        String h = C1553o.m4696h(context);
        StringBuilder sb = new StringBuilder();
        sb.append(userAgentString);
        sb.append(" AlipaySDK(");
        sb.append(packageName);
        String str = "/";
        sb.append(str);
        sb.append(h);
        sb.append(str);
        sb.append("15.6.5");
        sb.append(")");
        webView.getSettings().setUserAgentString(sb.toString());
    }

    public void setChromeProxy(C1556a aVar) {
        this.f3976g = aVar;
        if (aVar == null) {
            this.f3975e.setWebChromeClient(null);
        } else {
            this.f3975e.setWebChromeClient(new C1579s(this));
        }
    }

    public void setWebClientProxy(C1557b bVar) {
        this.f3977h = bVar;
        if (bVar == null) {
            this.f3975e.setWebViewClient(null);
        } else {
            this.f3975e.setWebViewClient(new C1580t(this));
        }
    }

    public void setWebEventProxy(C1558c cVar) {
        this.f3978i = cVar;
    }

    public String getUrl() {
        return this.f3975e.getUrl();
    }

    /* renamed from: a */
    public void mo12225a(String str) {
        this.f3975e.loadUrl(str);
    }

    /* renamed from: a */
    public void mo12226a(String str, byte[] bArr) {
        this.f3975e.postUrl(str, bArr);
    }

    public ImageView getBackButton() {
        return this.f3971a;
    }

    public TextView getTitle() {
        return this.f3972b;
    }

    public ImageView getRefreshButton() {
        return this.f3973c;
    }

    public ProgressBar getProgressbar() {
        return this.f3974d;
    }

    public WebView getWebView() {
        return this.f3975e;
    }

    /* renamed from: a */
    public void mo12223a() {
        removeAllViews();
        this.f3975e.removeAllViews();
        this.f3975e.setWebViewClient(null);
        this.f3975e.setWebChromeClient(null);
        this.f3975e.destroy();
    }

    /* renamed from: a */
    private int m4700a(int i) {
        return (int) (((float) i) * this.f3980k);
    }
}
