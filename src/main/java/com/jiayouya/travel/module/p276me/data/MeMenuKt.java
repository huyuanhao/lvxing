package com.jiayouya.travel.module.p276me.data;

import android.graphics.drawable.Drawable;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo39189d2 = {"getBgDrawable", "Landroid/graphics/drawable/Drawable;", "Lcom/jiayouya/travel/module/me/data/MeMenu;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: MeMenu.kt */
/* renamed from: com.jiayouya.travel.module.me.data.MeMenuKt */
public final class MeMenuKt {
    public static final Drawable getBgDrawable(MeMenu meMenu) {
        C8271i.m35386b(meMenu, "$this$getBgDrawable");
        if (meMenu.getHasPre() && meMenu.getHasNext()) {
            return GloblaEx.m12820c(R.drawable.bg_white);
        }
        if (meMenu.getHasPre()) {
            return GloblaEx.m12820c(R.drawable.bg_white_b_10);
        }
        if (meMenu.getHasNext()) {
            return GloblaEx.m12820c(R.drawable.bg_white_t_10);
        }
        return GloblaEx.m12820c(R.drawable.bg_white_10);
    }
}
