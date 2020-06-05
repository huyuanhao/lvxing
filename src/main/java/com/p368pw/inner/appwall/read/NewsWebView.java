package com.p368pw.inner.appwall.read;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/* renamed from: com.pw.inner.appwall.read.NewsWebView */
public class NewsWebView extends WebView {
    /* renamed from: a */
    private C5045a f16518a;

    /* renamed from: com.pw.inner.appwall.read.NewsWebView$a */
    public interface C5045a {
        void onMove();
    }

    public NewsWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            this.f16518a.onMove();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnScrollChangeListener(C5045a aVar) {
        this.f16518a = aVar;
    }
}
