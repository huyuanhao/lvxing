package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.travel.data.DogInfo;

public abstract class DialogDogDetailBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f10337a;
    @Bindable
    /* renamed from: b */
    protected DogInfo f10338b;

    /* renamed from: a */
    public abstract void mo20112a(DogInfo dogInfo);

    protected DialogDogDetailBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f10337a = imageView;
    }
}
