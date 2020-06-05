package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.SystemNotice;

public abstract class DialogSystemNoticeBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f10625a;
    /* renamed from: b */
    public final ImageView f10626b;
    @Bindable
    /* renamed from: c */
    protected SystemNotice f10627c;

    /* renamed from: a */
    public abstract void mo20141a(SystemNotice systemNotice);

    protected DialogSystemNoticeBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.f10625a = imageView;
        this.f10626b = imageView2;
    }
}
