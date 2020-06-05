package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.travel.data.C3325HB;

public abstract class DialogHbBinding extends ViewDataBinding {
    /* renamed from: a */
    public final FrameLayout f10445a;
    /* renamed from: b */
    public final ImageView f10446b;
    /* renamed from: c */
    public final ImageView f10447c;
    /* renamed from: d */
    public final TextView f10448d;
    @Bindable
    /* renamed from: e */
    protected String f10449e;
    @Bindable
    /* renamed from: f */
    protected int f10450f;
    @Bindable
    /* renamed from: g */
    protected C3325HB f10451g;

    /* renamed from: a */
    public abstract void mo20122a(int i);

    /* renamed from: a */
    public abstract void mo20123a(C3325HB hb);

    /* renamed from: a */
    public abstract void mo20124a(String str);

    protected DialogHbBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.f10445a = frameLayout;
        this.f10446b = imageView;
        this.f10447c = imageView2;
        this.f10448d = textView;
    }
}
