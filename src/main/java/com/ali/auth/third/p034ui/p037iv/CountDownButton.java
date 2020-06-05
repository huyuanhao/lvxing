package com.ali.auth.third.p034ui.p037iv;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/* renamed from: com.ali.auth.third.ui.iv.CountDownButton */
public class CountDownButton extends Button {
    /* renamed from: a */
    protected C1076a f2177a;
    /* renamed from: b */
    protected int f2178b;
    /* renamed from: c */
    protected int f2179c;
    /* renamed from: d */
    private boolean f2180d;

    /* renamed from: com.ali.auth.third.ui.iv.CountDownButton$a */
    public interface C1076a {
    }

    public CountDownButton(Context context) {
        super(context);
        this.f2180d = false;
        this.f2180d = false;
    }

    public CountDownButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2180d = false;
        this.f2180d = false;
    }

    public void setGetCodeTitle(int i) {
        this.f2178b = i;
    }

    public void setTickListener(C1076a aVar) {
        this.f2177a = aVar;
    }

    public void setTickTitleRes(int i) {
        this.f2179c = i;
    }
}
