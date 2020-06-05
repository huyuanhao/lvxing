package com.jiayouya.travel.module.travel.data;

import com.jiayouya.travel.module.travel.p287c.GoldUtil;
import com.jiayouya.travel.module.travel.p287c.MergeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002¨\u0006\u0007"}, mo39189d2 = {"curPrice", "", "Lcom/jiayouya/travel/module/travel/data/DogShopItem;", "curPriceStr", "", "image", "", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: DogShopItem.kt */
public final class DogShopItemKt {
    public static final double curPrice(DogShopItem dogShopItem) {
        C8271i.m35386b(dogShopItem, "$this$curPrice");
        return Math.floor(Math.min(((double) dogShopItem.getInitPrice()) * Math.pow(dogShopItem.getRiseRate(), (double) dogShopItem.getBuyNum()), dogShopItem.getMaxPrice()));
    }

    public static final String curPriceStr(DogShopItem dogShopItem) {
        C8271i.m35386b(dogShopItem, "$this$curPriceStr");
        return GoldUtil.f11900a.mo21651a(curPrice(dogShopItem));
    }

    public static final int image(DogShopItem dogShopItem) {
        C8271i.m35386b(dogShopItem, "$this$image");
        return MergeUtil.m14455b(dogShopItem.getDogId());
    }
}
