package com.jiayouya.travel.module.group.data;

import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, mo39189d2 = {"progressText", "", "Lcom/jiayouya/travel/module/group/data/GroupIndexRsp;", "progressTextSuffix", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: GroupIndexRsp.kt */
public final class GroupIndexRspKt {
    public static final String progressText(GroupIndexRsp groupIndexRsp) {
        C8271i.m35386b(groupIndexRsp, "$this$progressText");
        StringBuilder sb = new StringBuilder();
        sb.append("已解锁");
        sb.append(new DecimalFormat("0.##").format(Float.valueOf(groupIndexRsp.getPercent())));
        sb.append("%，解锁后");
        sb.append(groupIndexRsp.getTargetProfit());
        sb.append("元现金将自动存入钱包");
        return sb.toString();
    }

    public static final String progressTextSuffix(GroupIndexRsp groupIndexRsp) {
        C8271i.m35386b(groupIndexRsp, "$this$progressTextSuffix");
        StringBuilder sb = new StringBuilder();
        sb.append('X');
        sb.append(groupIndexRsp.getProfitRate());
        sb.append("倍加速");
        return sb.toString();
    }
}
