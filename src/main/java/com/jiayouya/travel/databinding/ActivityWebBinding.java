package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.widget.LollipopFixedWebView;
import ezy.p653ui.widget.CenteredTitleBar;

public abstract class ActivityWebBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f10246a;
    /* renamed from: b */
    public final ProgressBar f10247b;
    /* renamed from: c */
    public final CenteredTitleBar f10248c;
    /* renamed from: d */
    public final TextView f10249d;
    /* renamed from: e */
    public final LollipopFixedWebView f10250e;

    protected ActivityWebBinding(Object obj, View view, int i, ImageView imageView, ProgressBar progressBar, CenteredTitleBar centeredTitleBar, TextView textView, LollipopFixedWebView lollipopFixedWebView) {
        super(obj, view, i);
        this.f10246a = imageView;
        this.f10247b = progressBar;
        this.f10248c = centeredTitleBar;
        this.f10249d = textView;
        this.f10250e = lollipopFixedWebView;
    }
}
