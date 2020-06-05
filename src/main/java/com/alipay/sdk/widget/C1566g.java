package com.alipay.sdk.widget;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout;

/* renamed from: com.alipay.sdk.widget.g */
public abstract class C1566g extends FrameLayout {
    /* renamed from: a */
    protected Activity f3995a;

    /* renamed from: a */
    public abstract void mo12252a();

    /* renamed from: a */
    public abstract void mo12253a(String str);

    /* renamed from: b */
    public abstract boolean mo12255b();

    public C1566g(Activity activity) {
        super(activity);
        this.f3995a = activity;
    }

    /* renamed from: a */
    public void mo12254a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            CookieSyncManager.createInstance(this.f3995a.getApplicationContext()).sync();
            CookieManager.getInstance().setCookie(str, str2);
            CookieSyncManager.getInstance().sync();
        }
    }
}
