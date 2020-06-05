package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityNicknameBinding extends ViewDataBinding {
    /* renamed from: a */
    public final EditText f10084a;
    /* renamed from: b */
    public final ImageView f10085b;
    /* renamed from: c */
    public final TextView f10086c;

    protected ActivityNicknameBinding(Object obj, View view, int i, EditText editText, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f10084a = editText;
        this.f10085b = imageView;
        this.f10086c = textView;
    }
}
