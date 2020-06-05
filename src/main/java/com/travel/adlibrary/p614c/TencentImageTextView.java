package com.travel.adlibrary.p614c;

import android.view.View;
import com.p522qq.p523e.ads.banner2.UnifiedBannerView;
import com.travel.adlibrary.p612a.IImageTextView;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, mo39189d2 = {"Lcom/travel/adlibrary/tencent/TencentImageTextView;", "Lcom/travel/adlibrary/common/IImageTextView;", "view", "Lcom/qq/e/ads/banner2/UnifiedBannerView;", "(Lcom/qq/e/ads/banner2/UnifiedBannerView;)V", "getView", "()Lcom/qq/e/ads/banner2/UnifiedBannerView;", "getContentView", "Landroid/view/View;", "onDestroy", "", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.travel.adlibrary.c.b */
public final class TencentImageTextView implements IImageTextView {
    /* renamed from: a */
    private final UnifiedBannerView f25944a;

    public TencentImageTextView(UnifiedBannerView unifiedBannerView) {
        this.f25944a = unifiedBannerView;
    }

    /* renamed from: b */
    public View mo37335b() {
        return this.f25944a;
    }

    /* renamed from: a */
    public void mo37334a() {
        UnifiedBannerView unifiedBannerView = this.f25944a;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
    }
}
