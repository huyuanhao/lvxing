package com.jiayouya.travel.module.travel.data;

import android.content.res.Resources;
import com.jiayouya.travel.C2835b;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0005"}, mo39189d2 = {"isShowImage", "", "Lcom/jiayouya/travel/module/travel/data/CoinRankListItem;", "positionImage", "", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: CoinRankListItem.kt */
public final class CoinRankListItemKt {
    public static final boolean isShowImage(CoinRankListItem coinRankListItem) {
        C8271i.m35386b(coinRankListItem, "$this$isShowImage");
        return coinRankListItem.getPosition() <= 3;
    }

    public static final int positionImage(CoinRankListItem coinRankListItem) {
        C8271i.m35386b(coinRankListItem, "$this$positionImage");
        Resources resources = C2835b.f9544a.getResources();
        StringBuilder sb = new StringBuilder();
        sb.append("ic_ranking_");
        sb.append(coinRankListItem.getPosition());
        return resources.getIdentifier(sb.toString(), "mipmap", C2835b.f9544a.getPackageName());
    }
}
