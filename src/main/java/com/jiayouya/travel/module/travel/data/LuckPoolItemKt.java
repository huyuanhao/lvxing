package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, mo39189d2 = {"isBox", "", "Lcom/jiayouya/travel/module/travel/data/LuckPoolItem;", "isHb", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: LuckPoolItem.kt */
public final class LuckPoolItemKt {
    public static final boolean isBox(LuckPoolItem luckPoolItem) {
        C8271i.m35386b(luckPoolItem, "$this$isBox");
        return luckPoolItem.getImage() == 5 || luckPoolItem.getImage() == 6;
    }

    public static final boolean isHb(LuckPoolItem luckPoolItem) {
        C8271i.m35386b(luckPoolItem, "$this$isHb");
        return luckPoolItem.getImage() == 7;
    }
}
