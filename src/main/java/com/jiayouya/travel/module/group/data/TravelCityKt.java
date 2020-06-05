package com.jiayouya.travel.module.group.data;

import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo39189d2 = {"progressText", "", "Lcom/jiayouya/travel/module/group/data/TravelCity;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: TravelCity.kt */
public final class TravelCityKt {
    public static final String progressText(TravelCity travelCity) {
        C8271i.m35386b(travelCity, "$this$progressText");
        StringBuilder sb = new StringBuilder();
        sb.append(new DecimalFormat("#0.00").format((double) travelCity.getNextCity().getPercent()));
        sb.append("%");
        return sb.toString();
    }
}
