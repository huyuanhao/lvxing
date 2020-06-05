package com.alibaba.baichuan.trade.biz.context;

import android.app.Activity;
import android.webkit.WebView;
import java.io.Serializable;
import java.lang.ref.WeakReference;

public class AlibcTradeContext {
    /* renamed from: a */
    public AlibcTradeTrackParam f2386a;
    /* renamed from: b */
    public WeakReference<WebView> f2387b;
    /* renamed from: c */
    public WeakReference<Activity> f2388c;

    /* renamed from: com.alibaba.baichuan.trade.biz.context.AlibcTradeContext$AlibcTradeCallback */
    public interface AlibcTradeCallback extends Serializable {
        void onFailure(int i, String str);

        void onTradeSuccess(AlibcTradeResult alibcTradeResult);
    }

    /* renamed from: a */
    public void mo10724a(Activity activity) {
        if (activity != null) {
            this.f2388c = new WeakReference<>(activity);
        }
    }

    /* renamed from: a */
    public void mo10725a(WebView webView) {
        if (webView != null) {
            this.f2387b = new WeakReference<>(webView);
        }
    }
}
