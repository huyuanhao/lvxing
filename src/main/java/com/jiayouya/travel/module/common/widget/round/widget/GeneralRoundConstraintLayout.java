package com.jiayouya.travel.module.common.widget.round.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.common.widget.round.p261a.GeneralRoundViewImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0002J0\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006 "}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/widget/round/widget/GeneralRoundConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/jiayouya/travel/module/common/widget/round/abs/IRoundView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "generalRoundViewImpl", "Lcom/jiayouya/travel/module/common/widget/round/abs/GeneralRoundViewImpl;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "init", "view", "Landroid/view/View;", "attributeSet", "onLayout", "changed", "", "left", "top", "right", "bottom", "setCornerRadius", "cornerRadius", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: GeneralRoundConstraintLayout.kt */
public final class GeneralRoundConstraintLayout extends ConstraintLayout {
    /* renamed from: a */
    private GeneralRoundViewImpl f11384a;

    public GeneralRoundConstraintLayout(Context context) {
        C8271i.m35386b(context, "context");
        this(context, null);
    }

    public GeneralRoundConstraintLayout(Context context, AttributeSet attributeSet) {
        C8271i.m35386b(context, "context");
        super(context, attributeSet);
        m13649a(this, context, attributeSet);
    }

    public GeneralRoundConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        C8271i.m35386b(context, "context");
        super(context, attributeSet, i);
        m13649a(this, context, attributeSet);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        GeneralRoundViewImpl aVar = this.f11384a;
        if (aVar == null) {
            C8271i.m35387b("generalRoundViewImpl");
        }
        aVar.mo20796a(z, i, i2, i3, i4);
    }

    public void dispatchDraw(Canvas canvas) {
        GeneralRoundViewImpl aVar = this.f11384a;
        String str = "generalRoundViewImpl";
        if (aVar == null) {
            C8271i.m35387b(str);
        }
        aVar.mo20795a(canvas);
        super.dispatchDraw(canvas);
        GeneralRoundViewImpl aVar2 = this.f11384a;
        if (aVar2 == null) {
            C8271i.m35387b(str);
        }
        aVar2.mo20797b(canvas);
    }

    /* renamed from: a */
    private final void m13649a(View view, Context context, AttributeSet attributeSet) {
        int[] iArr = R.styleable.GeneralRoundConstraintLayout;
        C8271i.m35382a((Object) iArr, "R.styleable.GeneralRoundConstraintLayout");
        GeneralRoundViewImpl aVar = new GeneralRoundViewImpl(view, context, attributeSet, iArr, 0);
        this.f11384a = aVar;
    }

    public void setCornerRadius(float f) {
        GeneralRoundViewImpl aVar = this.f11384a;
        if (aVar == null) {
            C8271i.m35387b("generalRoundViewImpl");
        }
        aVar.mo20794a(f);
    }
}
