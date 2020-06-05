package com.jiayouya.travel.module.common.data;

import com.jiayouya.travel.R;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo39189d2 = {"logoSelector", "", "Lcom/jiayouya/travel/module/common/data/PayChannelItem;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: PayChannelItem.kt */
public final class PayChannelItemKt {
    public static final int logoSelector(PayChannelItem payChannelItem) {
        C8271i.m35386b(payChannelItem, "$this$logoSelector");
        return C8271i.m35384a((Object) payChannelItem.getKey(), (Object) "2") ? R.drawable.selector_wx_cash : R.drawable.selector_ali_cash;
    }
}
