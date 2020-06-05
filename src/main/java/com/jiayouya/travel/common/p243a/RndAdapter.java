package com.jiayouya.travel.common.p243a;

import androidx.databinding.BindingAdapter;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/common/adapter/RndAdapter;", "", "()V", "adaptEnable", "", "view", "Lezy/ui/widget/round/RoundText;", "isEnable", "", "enableColor", "", "disableColor", "adaptRndBgColor", "startColor", "", "endColor", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.a.c */
public final class RndAdapter {
    /* renamed from: a */
    public static final RndAdapter f9560a = new RndAdapter();

    private RndAdapter() {
    }

    @JvmStatic
    @BindingAdapter(requireAll = false, value = {"isEnable", "enableColor", "disableColor"})
    /* renamed from: a */
    public static final void m12785a(RoundText roundText, boolean z, String str, String str2) {
        C8271i.m35386b(roundText, "view");
        if (str == null || str2 == null) {
            RoundTextEx.m12837a(roundText, z, (String) null, (String) null, 6, (Object) null);
        } else {
            RoundTextEx.m12836a(roundText, z, str, str2);
        }
    }
}
