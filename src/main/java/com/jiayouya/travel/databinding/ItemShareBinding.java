package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.common.data.ShareItem;

public abstract class ItemShareBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f11163a;
    /* renamed from: b */
    public final ImageView f11164b;
    @Bindable
    /* renamed from: c */
    protected ShareItem f11165c;

    protected ItemShareBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.f11163a = imageView;
        this.f11164b = imageView2;
    }
}
