package com.jiayouya.travel.module.common.widget.round.p261a;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.jiayouya.travel.module.common.widget.round.p262b.GeneralRoundView18Policy;
import com.jiayouya.travel.module.common.widget.round.p262b.GeneralRoundView21Policy;
import com.jiayouya.travel.module.common.widget.round.p262b.IRoundViewPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J2\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J0\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/widget/round/abs/GeneralRoundViewImpl;", "Lcom/jiayouya/travel/module/common/widget/round/abs/IRoundView;", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "attrs", "", "attrIndex", "", "(Landroid/view/View;Landroid/content/Context;Landroid/util/AttributeSet;[II)V", "generalRoundViewPolicy", "Lcom/jiayouya/travel/module/common/widget/round/policy/IRoundViewPolicy;", "afterDispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "beforeDispatchDraw", "init", "onLayout", "changed", "", "left", "top", "right", "bottom", "setCornerRadius", "cornerRadius", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.widget.round.a.a */
public final class GeneralRoundViewImpl {
    /* renamed from: a */
    private IRoundViewPolicy f11376a;

    public GeneralRoundViewImpl(View view, Context context, AttributeSet attributeSet, int[] iArr, int i) {
        C8271i.m35386b(view, "view");
        C8271i.m35386b(context, "context");
        C8271i.m35386b(iArr, "attrs");
        m13626a(view, context, attributeSet, iArr, i);
    }

    /* renamed from: a */
    public void mo20796a(boolean z, int i, int i2, int i3, int i4) {
        IRoundViewPolicy dVar = this.f11376a;
        if (dVar == null) {
            C8271i.m35387b("generalRoundViewPolicy");
        }
        dVar.mo20802a(i, i2, i3, i4);
    }

    /* renamed from: a */
    public final void mo20795a(Canvas canvas) {
        IRoundViewPolicy dVar = this.f11376a;
        if (dVar == null) {
            C8271i.m35387b("generalRoundViewPolicy");
        }
        dVar.mo20803a(canvas);
    }

    /* renamed from: b */
    public final void mo20797b(Canvas canvas) {
        IRoundViewPolicy dVar = this.f11376a;
        if (dVar == null) {
            C8271i.m35387b("generalRoundViewPolicy");
        }
        dVar.mo20804b(canvas);
    }

    /* renamed from: a */
    private final void m13626a(View view, Context context, AttributeSet attributeSet, int[] iArr, int i) {
        if (VERSION.SDK_INT >= 21) {
            GeneralRoundView21Policy cVar = new GeneralRoundView21Policy(view, context, attributeSet, iArr, i);
            this.f11376a = cVar;
            return;
        }
        GeneralRoundView18Policy bVar = new GeneralRoundView18Policy(view, context, attributeSet, iArr, i);
        this.f11376a = bVar;
    }

    /* renamed from: a */
    public void mo20794a(float f) {
        IRoundViewPolicy dVar = this.f11376a;
        if (dVar == null) {
            C8271i.m35387b("generalRoundViewPolicy");
        }
        dVar.mo20801b(f);
    }
}
