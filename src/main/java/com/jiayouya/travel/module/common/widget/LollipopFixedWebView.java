package com.jiayouya.travel.module.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.webkit.WebView;

public class LollipopFixedWebView extends WebView {
    public LollipopFixedWebView(Context context) {
        super(m13611a(context));
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet) {
        super(m13611a(context), attributeSet);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i) {
        super(m13611a(context), attributeSet, i);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(m13611a(context), attributeSet, i, i2);
    }

    /* renamed from: a */
    private static Context m13611a(Context context) {
        return (VERSION.SDK_INT < 21 || VERSION.SDK_INT >= 23) ? context : context.createConfigurationContext(new Configuration());
    }
}
