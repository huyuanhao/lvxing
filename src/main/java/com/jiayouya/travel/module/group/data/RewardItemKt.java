package com.jiayouya.travel.module.group.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo39189d2 = {"formatPercent", "", "Lcom/jiayouya/travel/module/group/data/RewardItem;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: RewardItem.kt */
public final class RewardItemKt {
    public static final String formatPercent(RewardItem rewardItem) {
        C8271i.m35386b(rewardItem, "$this$formatPercent");
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        sb.append(rewardItem.getPercent());
        sb.append('%');
        return sb.toString();
    }
}
