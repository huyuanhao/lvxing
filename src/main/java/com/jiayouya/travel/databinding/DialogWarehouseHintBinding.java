package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.module.travel.data.PositionItem;
import ezy.p653ui.widget.round.RoundText;

public abstract class DialogWarehouseHintBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f10724a;
    /* renamed from: b */
    public final ImageView f10725b;
    @Bindable
    /* renamed from: c */
    protected PositionItem f10726c;

    /* renamed from: a */
    public abstract void mo20149a(PositionItem positionItem);

    protected DialogWarehouseHintBinding(Object obj, View view, int i, RoundText roundText, ImageView imageView) {
        super(obj, view, i);
        this.f10724a = roundText;
        this.f10725b = imageView;
    }
}
