package com.jiayouya.travel.module.common.widget.round.p262b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J(\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016¨\u0006\u0017"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/widget/round/policy/GeneralRoundView21Policy;", "Lcom/jiayouya/travel/module/common/widget/round/policy/AbsRoundViewPolicy;", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "attrs", "", "attrIndex", "", "(Landroid/view/View;Landroid/content/Context;Landroid/util/AttributeSet;[II)V", "afterDispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "beforeDispatchDraw", "onLayout", "left", "top", "right", "bottom", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.widget.round.b.c */
public final class GeneralRoundView21Policy extends AbsRoundViewPolicy {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo39189d2 = {"com/jiayouya/travel/module/common/widget/round/policy/GeneralRoundView21Policy$afterDispatchDraw$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: GeneralRoundView21Policy.kt */
    /* renamed from: com.jiayouya.travel.module.common.widget.round.b.c$a */
    public static final class C2993a extends ViewOutlineProvider {
        /* renamed from: a */
        final /* synthetic */ GeneralRoundView21Policy f11383a;

        C2993a(GeneralRoundView21Policy cVar) {
            this.f11383a = cVar;
        }

        public void getOutline(View view, Outline outline) {
            C8271i.m35386b(view, "view");
            C8271i.m35386b(outline, "outline");
            outline.setRoundRect(0, 0, this.f11383a.mo20800b().getWidth(), this.f11383a.mo20800b().getHeight(), this.f11383a.mo20798a());
        }
    }

    /* renamed from: a */
    public void mo20802a(int i, int i2, int i3, int i4) {
    }

    public GeneralRoundView21Policy(View view, Context context, AttributeSet attributeSet, int[] iArr, int i) {
        C8271i.m35386b(view, "view");
        C8271i.m35386b(context, "context");
        C8271i.m35386b(iArr, "attrs");
        super(view, context, attributeSet, iArr, i);
    }

    /* renamed from: a */
    public void mo20803a(Canvas canvas) {
        mo20800b().setClipToOutline(true);
    }

    /* renamed from: b */
    public void mo20804b(Canvas canvas) {
        mo20800b().setOutlineProvider(new C2993a(this));
    }
}
