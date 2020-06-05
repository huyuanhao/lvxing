package com.travel.adlibrary.p615d;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.travel.adlibrary.p612a.IImageTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, mo39189d2 = {"Lcom/travel/adlibrary/tt/TTImageTextView;", "Lcom/travel/adlibrary/common/IImageTextView;", "view", "Landroid/view/View;", "ad", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "(Landroid/view/View;Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;)V", "getAd", "()Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "getView", "()Landroid/view/View;", "getContentView", "onDestroy", "", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.travel.adlibrary.d.b */
public final class TTImageTextView implements IImageTextView {
    /* renamed from: a */
    private final View f25964a;
    /* renamed from: b */
    private final TTNativeExpressAd f25965b;

    public TTImageTextView(View view, TTNativeExpressAd tTNativeExpressAd) {
        C8271i.m35386b(tTNativeExpressAd, "ad");
        this.f25964a = view;
        this.f25965b = tTNativeExpressAd;
    }

    /* renamed from: b */
    public View mo37335b() {
        return this.f25964a;
    }

    /* renamed from: a */
    public void mo37334a() {
        this.f25965b.destroy();
    }
}
