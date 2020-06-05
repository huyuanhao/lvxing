package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0001¨\u0006\u0007"}, mo39189d2 = {"createEmptyPosition", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "position", "", "isTemp", "", "validate", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: PositionItem.kt */
public final class PositionItemKt {
    public static final boolean isTemp(PositionItem positionItem) {
        C8271i.m35386b(positionItem, "$this$isTemp");
        return positionItem.getExtra() != null;
    }

    public static final boolean validate(PositionItem positionItem) {
        C8271i.m35386b(positionItem, "$this$validate");
        return positionItem.getLevel() != 0;
    }

    public static /* synthetic */ PositionItem createEmptyPosition$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return createEmptyPosition(i);
    }

    public static final PositionItem createEmptyPosition(int i) {
        PositionItem positionItem = new PositionItem(-1, 0, i, -1, null);
        return positionItem;
    }
}
