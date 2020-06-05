package com.jiayouya.travel.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/common/widget/MaxHeightRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxHeight", "", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "onMeasure", "", "widthSpec", "heightSpec", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MaxHeightRecyclerView.kt */
public final class MaxHeightRecyclerView extends RecyclerView {
    /* renamed from: a */
    private int f9666a = -1;

    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public final int getMaxHeight() {
        return this.f9666a;
    }

    public final void setMaxHeight(int i) {
        this.f9666a = i;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.f9666a;
        if (i3 > 0) {
            i2 = MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
