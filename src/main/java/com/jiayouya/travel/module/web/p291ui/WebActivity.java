package com.jiayouya.travel.module.web.p291ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p244b.ActivityEx;
import com.jiayouya.travel.common.p246d.WebUtils;
import com.jiayouya.travel.databinding.ActivityWebBinding;
import com.jiayouya.travel.module.common.widget.LollipopFixedWebView;
import com.jiayouya.travel.module.web.p292vm.WebVM;
import ezy.p653ui.widget.CenteredTitleBar;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8247b;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, mo39189d2 = {"Lcom/jiayouya/travel/module/web/ui/WebActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityWebBinding;", "Lcom/jiayouya/travel/module/web/vm/WebVM;", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "url$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "onBackPressed", "", "onDestroy", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: WebActivity.kt */
/* renamed from: com.jiayouya.travel.module.web.ui.WebActivity */
public final class WebActivity extends BaseActivity<ActivityWebBinding, WebVM> {
    /* renamed from: c */
    static final /* synthetic */ C8280j[] f12319c = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(WebActivity.class), "url", "getUrl()Ljava/lang/String;"))};
    /* renamed from: d */
    public static final C3584a f12320d = new C3584a(null);
    /* renamed from: e */
    private final Lazy f12321e = ActivityEx.m12803a(this, "url", "");
    /* renamed from: f */
    private HashMap f12322f;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo39189d2 = {"Lcom/jiayouya/travel/module/web/ui/WebActivity$Companion;", "", "()V", "launch", "", "context", "Landroid/content/Context;", "url", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: WebActivity.kt */
    /* renamed from: com.jiayouya.travel.module.web.ui.WebActivity$a */
    public static final class C3584a {
        private C3584a() {
        }

        public /* synthetic */ C3584a(DefaultConstructorMarker fVar) {
            this();
        }

        /* renamed from: a */
        public final void mo22574a(Context context, String str) {
            C8271i.m35386b(context, "context");
            String str2 = "url";
            C8271i.m35386b(str, str2);
            Intent intent = new Intent(context, WebActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(str2, str);
            context.startActivity(intent);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: WebActivity.kt */
    /* renamed from: com.jiayouya.travel.module.web.ui.WebActivity$b */
    static final class C3585b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ WebActivity this$0;

        C3585b(WebActivity webActivity) {
            this.this$0 = webActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            ((LollipopFixedWebView) this.this$0.mo19852a(R.id.web)).reload();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: WebActivity.kt */
    /* renamed from: com.jiayouya.travel.module.web.ui.WebActivity$c */
    static final class C3586c implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ WebActivity f12323a;

        C3586c(WebActivity webActivity) {
            this.f12323a = webActivity;
        }

        public final void onClick(View view) {
            this.f12323a.onBackPressed();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: WebActivity.kt */
    /* renamed from: com.jiayouya.travel.module.web.ui.WebActivity$d */
    static final class C3587d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ WebActivity this$0;

        C3587d(WebActivity webActivity) {
            this.this$0 = webActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.finish();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0012"}, mo39189d2 = {"com/jiayouya/travel/module/web/ui/WebActivity$setupView$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "shouldOverrideUrlLoading", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: WebActivity.kt */
    /* renamed from: com.jiayouya.travel.module.web.ui.WebActivity$e */
    public static final class C3588e extends WebViewClient {
        /* renamed from: a */
        final /* synthetic */ WebActivity f12324a;

        C3588e(WebActivity webActivity) {
            this.f12324a = webActivity;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C8271i.m35386b(webView, "view");
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C8271i.m35386b(webView, "view");
            ProgressBar progressBar = (ProgressBar) this.f12324a.mo19852a(R.id.progress_bar);
            C8271i.m35382a((Object) progressBar, "progress_bar");
            progressBar.setVisibility(0);
        }

        public void onPageFinished(WebView webView, String str) {
            C8271i.m35386b(webView, "view");
            ProgressBar progressBar = (ProgressBar) this.f12324a.mo19852a(R.id.progress_bar);
            C8271i.m35382a((Object) progressBar, "progress_bar");
            progressBar.setVisibility(8);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            C8271i.m35386b(webView, "view");
            C8271i.m35386b(sslErrorHandler, "handler");
            C8271i.m35386b(sslError, "error");
            sslErrorHandler.proceed();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo39189d2 = {"com/jiayouya/travel/module/web/ui/WebActivity$setupView$2", "Landroid/webkit/WebChromeClient;", "onProgressChanged", "", "view", "Landroid/webkit/WebView;", "newProgress", "", "onReceivedTitle", "title", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: WebActivity.kt */
    /* renamed from: com.jiayouya.travel.module.web.ui.WebActivity$f */
    public static final class C3589f extends WebChromeClient {
        /* renamed from: a */
        final /* synthetic */ WebActivity f12325a;

        C3589f(WebActivity webActivity) {
            this.f12325a = webActivity;
        }

        public void onReceivedTitle(WebView webView, String str) {
            C8271i.m35386b(webView, "view");
            CharSequence charSequence = str;
            if (!TextUtils.isEmpty(charSequence) && this.f12325a.getSupportActionBar() != null) {
                ActionBar supportActionBar = this.f12325a.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setTitle(charSequence);
                }
                ActionBar supportActionBar2 = this.f12325a.getSupportActionBar();
                if (supportActionBar2 != null) {
                    supportActionBar2.setDisplayShowTitleEnabled(true);
                }
            }
        }

        public void onProgressChanged(WebView webView, int i) {
            C8271i.m35386b(webView, "view");
            ProgressBar progressBar = (ProgressBar) this.f12325a.mo19852a(R.id.progress_bar);
            C8271i.m35382a((Object) progressBar, "progress_bar");
            progressBar.setProgress(i);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0006\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, mo39189d2 = {"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "userAgent", "contentDisposition", "mimetype", "contentLength", "", "onDownloadStart"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: WebActivity.kt */
    /* renamed from: com.jiayouya.travel.module.web.ui.WebActivity$g */
    static final class C3590g implements DownloadListener {
        /* renamed from: a */
        final /* synthetic */ WebActivity f12326a;

        C3590g(WebActivity webActivity) {
            this.f12326a = webActivity;
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            this.f12326a.startActivity(intent);
        }
    }

    /* renamed from: q */
    private final String m14966q() {
        Lazy bVar = this.f12321e;
        C8280j jVar = f12319c[0];
        return (String) bVar.getValue();
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f12322f == null) {
            this.f12322f = new HashMap();
        }
        View view = (View) this.f12322f.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f12322f.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_web;
    }

    /* renamed from: d */
    public Class<WebVM> mo19861d() {
        return WebVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        LollipopFixedWebView lollipopFixedWebView = (LollipopFixedWebView) mo19852a(R.id.web);
        String str = "web";
        C8271i.m35382a((Object) lollipopFixedWebView, str);
        lollipopFixedWebView.setWebViewClient(new C3588e(this));
        LollipopFixedWebView lollipopFixedWebView2 = (LollipopFixedWebView) mo19852a(R.id.web);
        C8271i.m35382a((Object) lollipopFixedWebView2, str);
        lollipopFixedWebView2.setWebChromeClient(new C3589f(this));
        LollipopFixedWebView lollipopFixedWebView3 = (LollipopFixedWebView) mo19852a(R.id.web);
        C8271i.m35382a((Object) lollipopFixedWebView3, str);
        WebUtils.m12978a(lollipopFixedWebView3);
        LollipopFixedWebView lollipopFixedWebView4 = (LollipopFixedWebView) mo19852a(R.id.web);
        LollipopFixedWebView lollipopFixedWebView5 = (LollipopFixedWebView) mo19852a(R.id.web);
        C8271i.m35382a((Object) lollipopFixedWebView5, str);
        lollipopFixedWebView4.addJavascriptInterface(new C3591a(lollipopFixedWebView5), "Travel");
        ((LollipopFixedWebView) mo19852a(R.id.web)).setDownloadListener(new C3590g(this));
        ((LollipopFixedWebView) mo19852a(R.id.web)).loadUrl(m14966q());
    }

    /* renamed from: k */
    public void mo19868k() {
        ImageView imageView = (ImageView) mo19852a(R.id.iv_refresh);
        C8271i.m35382a((Object) imageView, "iv_refresh");
        ezy.p642a.View.m34750a(imageView, 0, new C3585b(this), 1, null);
        ((CenteredTitleBar) mo19852a(R.id.toolbar)).setNavigationOnClickListener(new C3586c(this));
        TextView textView = (TextView) mo19852a(R.id.tv_close);
        C8271i.m35382a((Object) textView, "tv_close");
        ezy.p642a.View.m34750a(textView, 0, new C3587d(this), 1, null);
    }

    public void onBackPressed() {
        if (((LollipopFixedWebView) mo19852a(R.id.web)).canGoBack()) {
            ((LollipopFixedWebView) mo19852a(R.id.web)).goBack();
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        WebUtils.m12979b((LollipopFixedWebView) mo19852a(R.id.web));
        super.onDestroy();
    }
}
