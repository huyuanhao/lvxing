package com.jiayouya.travel.module.web.p291ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.p131c.p132a.ViewTarget;
import com.bumptech.glide.p131c.p133b.Transition;
import com.jiayouya.travel.C2835b;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import ezy.app.data.Token;
import ezy.app.p643a.Session;
import ezy.app.p643a.p644a.C8016d;
import java.lang.ref.WeakReference;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\bH\u0007J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u0016"}, mo39189d2 = {"Lcom/jiayouya/travel/module/web/ui/JSInterface;", "", "webView", "Landroid/webkit/WebView;", "(Landroid/webkit/WebView;)V", "reference", "Ljava/lang/ref/WeakReference;", "token", "", "getToken", "()Ljava/lang/String;", "uid", "getUid", "go", "", "route", "saveImage", "url", "sign", "method", "uri", "hashBody", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: WebActivity.kt */
/* renamed from: com.jiayouya.travel.module.web.ui.a */
public final class C3591a {
    /* renamed from: a */
    private final WeakReference<WebView> f12327a;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo39189d2 = {"<anonymous>", "", "run", "com/jiayouya/travel/module/web/ui/JSInterface$saveImage$1$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: WebActivity.kt */
    /* renamed from: com.jiayouya.travel.module.web.ui.a$a */
    static final class C3592a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ WebView f12328a;
        /* renamed from: b */
        final /* synthetic */ String f12329b;

        C3592a(WebView webView, String str) {
            this.f12328a = webView;
            this.f12329b = str;
        }

        public final void run() {
            final ImageView imageView = new ImageView(C2835b.f9544a);
            View view = imageView;
            this.f12328a.addView(view);
            Glide.m5174b((Context) C2835b.f9544a).mo12591a(this.f12329b).mo12580a(new ViewTarget<ImageView, Drawable>(this, view) {
                /* renamed from: b */
                final /* synthetic */ C3592a f12330b;

                {
                    this.f12330b = r1;
                }

                /* renamed from: a */
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> fVar) {
                    C8271i.m35386b(drawable, "resource");
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    WebView webView = this.f12330b.f12328a;
                    String str = "it";
                    C8271i.m35382a((Object) webView, str);
                    Context context = webView.getContext();
                    C8271i.m35382a((Object) context, "it.context");
                    String insertImage = Media.insertImage(context.getContentResolver(), bitmap, "在线客服", "二维码");
                    if (!TextUtils.isEmpty(insertImage)) {
                        WebView webView2 = this.f12330b.f12328a;
                        C8271i.m35382a((Object) webView2, str);
                        webView2.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(insertImage)));
                        GloblaEx.m12816a("保存成功", 0, 0, 6, null);
                    }
                }
            });
        }
    }

    public C3591a(WebView webView) {
        C8271i.m35386b(webView, "webView");
        this.f12327a = new WeakReference<>(webView);
    }

    @JavascriptInterface
    public final String getToken() {
        Token a = Session.f27256a.mo38534a();
        if (a != null) {
            return a.getAccessToken();
        }
        return null;
    }

    @JavascriptInterface
    public final String getUid() {
        User user = (User) ResidentMemoryModel.f11323a.mo20737b().getValue();
        if (user != null) {
            return user.getUid();
        }
        return null;
    }

    @JavascriptInterface
    /* renamed from: go */
    public final void mo22587go(String str) {
        C8271i.m35386b(str, "route");
        Router.m12969a(Router.f9644a, str, null, null, 6, null);
    }

    @JavascriptInterface
    public final String sign(String str, String str2, String str3) {
        C8271i.m35386b(str, "method");
        C8271i.m35386b(str2, "uri");
        C8271i.m35386b(str3, "hashBody");
        return C8016d.m34760a("2179a2684d5b28623802399f6f9038f7", str, new URI(str2), str3);
    }

    @JavascriptInterface
    public final void saveImage(String str) {
        C8271i.m35386b(str, "url");
        WebView webView = (WebView) this.f12327a.get();
        if (webView != null) {
            webView.post(new C3592a(webView, str));
        }
    }
}
