package com.jiayouya.travel.module.p276me.data;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.text.C8313m;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0006"}, mo39189d2 = {"formatRoute", "", "Lcom/jiayouya/travel/module/me/data/MeItem;", "isHasNotice", "", "isNotice", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: MeItem.kt */
/* renamed from: com.jiayouya.travel.module.me.data.MeItemKt */
public final class MeItemKt {
    public static final String formatRoute(MeItem meItem) {
        C8271i.m35386b(meItem, "$this$formatRoute");
        return (!C8271i.m35384a((Object) meItem.getRoute(), (Object) C8313m.m35470a((CharSequence) "/answer/index", 0, 1).toString()) || TextUtils.isEmpty(meItem.getValue())) ? meItem.getRoute() : "";
    }

    public static final boolean isNotice(MeItem meItem) {
        C8271i.m35386b(meItem, "$this$isNotice");
        return C8271i.m35384a((Object) meItem.getMark(), (Object) "my_messages");
    }

    public static final boolean isHasNotice(MeItem meItem) {
        C8271i.m35386b(meItem, "$this$isHasNotice");
        return isNotice(meItem) && !TextUtils.isEmpty(meItem.getValue());
    }
}
