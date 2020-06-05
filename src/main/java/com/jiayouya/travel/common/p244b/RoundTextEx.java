package com.jiayouya.travel.common.p244b;

import android.graphics.drawable.Drawable;
import ezy.p653ui.widget.round.RoundDrawable;
import ezy.p653ui.widget.round.RoundLayout;
import ezy.p653ui.widget.round.RoundText;
import ezy.p653ui.widget.round.RoundUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006¨\u0006\t"}, mo39189d2 = {"setEnable", "", "Lezy/ui/widget/round/RoundLayout;", "isEnable", "", "enableColor", "", "disableColor", "Lezy/ui/widget/round/RoundText;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.b.i */
public final class RoundTextEx {
    /* renamed from: a */
    public static /* synthetic */ void m12837a(RoundText roundText, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "#7AE47A,#60CC60";
        }
        if ((i & 4) != 0) {
            str2 = "#FFF4F4F4,#FFF4F4F4";
        }
        m12836a(roundText, z, str, str2);
    }

    /* renamed from: a */
    public static final void m12836a(RoundText roundText, boolean z, String str, String str2) {
        C8271i.m35386b(roundText, "$this$setEnable");
        C8271i.m35386b(str, "enableColor");
        C8271i.m35386b(str2, "disableColor");
        roundText.setEnabled(z);
        Drawable background = roundText.getBackground();
        if (!(background instanceof RoundDrawable)) {
            return;
        }
        if (!z) {
            ((RoundDrawable) background).setGradientColors(RoundUtil.parseGradientColors(str2));
        } else {
            ((RoundDrawable) background).setGradientColors(RoundUtil.parseGradientColors(str));
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m12835a(RoundLayout roundLayout, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "#7AE47A,#60CC60";
        }
        if ((i & 4) != 0) {
            str2 = "#FFF4F4F4,#FFF4F4F4";
        }
        m12834a(roundLayout, z, str, str2);
    }

    /* renamed from: a */
    public static final void m12834a(RoundLayout roundLayout, boolean z, String str, String str2) {
        C8271i.m35386b(roundLayout, "$this$setEnable");
        C8271i.m35386b(str, "enableColor");
        C8271i.m35386b(str2, "disableColor");
        roundLayout.setEnabled(z);
        Drawable background = roundLayout.getBackground();
        if (!(background instanceof RoundDrawable)) {
            return;
        }
        if (!z) {
            ((RoundDrawable) background).setGradientColors(RoundUtil.parseGradientColors(str2));
        } else {
            ((RoundDrawable) background).setGradientColors(RoundUtil.parseGradientColors(str));
        }
    }
}
