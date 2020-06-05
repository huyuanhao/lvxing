package com.jiayouya.travel.module.travel.data;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/SysDataReq;", "Ljava/io/Serializable;", "coin", "", "buyData", "", "Lcom/jiayouya/travel/module/travel/data/BuyDataItem;", "positions", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "lastSysTime", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getBuyData", "()Ljava/util/List;", "getCoin", "()Ljava/lang/String;", "getLastSysTime", "getPositions", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: SysDataReq.kt */
public final class SysDataReq implements Serializable {
    public static final Companion Companion = new Companion(null);
    public static final long serialVersionUID = 1;
    private final List<BuyDataItem> buyData;
    private final String coin;
    private final String lastSysTime;
    private final List<PositionItem> positions;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/SysDataReq$Companion;", "", "()V", "serialVersionUID", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: SysDataReq.kt */
    /* renamed from: com.jiayouya.travel.module.travel.data.SysDataReq$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker fVar) {
            this();
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.travel.data.BuyDataItem>, for r2v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.travel.data.PositionItem>, for r3v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.travel.data.SysDataReq copy$default(com.jiayouya.travel.module.travel.data.SysDataReq r0, java.lang.String r1, java.util.List<com.jiayouya.travel.module.travel.data.BuyDataItem> r2, java.util.List<com.jiayouya.travel.module.travel.data.PositionItem> r3, java.lang.String r4, int r5, java.lang.Object r6) {
        /*
        r6 = r5 & 1
        if (r6 == 0) goto L_0x0006
        java.lang.String r1 = r0.coin
    L_0x0006:
        r6 = r5 & 2
        if (r6 == 0) goto L_0x000c
        java.util.List<com.jiayouya.travel.module.travel.data.BuyDataItem> r2 = r0.buyData
    L_0x000c:
        r6 = r5 & 4
        if (r6 == 0) goto L_0x0012
        java.util.List<com.jiayouya.travel.module.travel.data.PositionItem> r3 = r0.positions
    L_0x0012:
        r5 = r5 & 8
        if (r5 == 0) goto L_0x0018
        java.lang.String r4 = r0.lastSysTime
    L_0x0018:
        com.jiayouya.travel.module.travel.data.SysDataReq r0 = r0.copy(r1, r2, r3, r4)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.SysDataReq.copy$default(com.jiayouya.travel.module.travel.data.SysDataReq, java.lang.String, java.util.List, java.util.List, java.lang.String, int, java.lang.Object):com.jiayouya.travel.module.travel.data.SysDataReq");
    }

    public final String component1() {
        return this.coin;
    }

    public final List<BuyDataItem> component2() {
        return this.buyData;
    }

    public final List<PositionItem> component3() {
        return this.positions;
    }

    public final String component4() {
        return this.lastSysTime;
    }

    public final SysDataReq copy(String str, List<BuyDataItem> list, List<PositionItem> list2, String str2) {
        C8271i.m35386b(str, "coin");
        C8271i.m35386b(list, "buyData");
        C8271i.m35386b(list2, "positions");
        C8271i.m35386b(str2, "lastSysTime");
        return new SysDataReq(str, list, list2, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.lastSysTime, (java.lang.Object) r3.lastSysTime) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033
        boolean r0 = r3 instanceof com.jiayouya.travel.module.travel.data.SysDataReq
        if (r0 == 0) goto L_0x0031
        com.jiayouya.travel.module.travel.data.SysDataReq r3 = (com.jiayouya.travel.module.travel.data.SysDataReq) r3
        java.lang.String r0 = r2.coin
        java.lang.String r1 = r3.coin
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.util.List<com.jiayouya.travel.module.travel.data.BuyDataItem> r0 = r2.buyData
        java.util.List<com.jiayouya.travel.module.travel.data.BuyDataItem> r1 = r3.buyData
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.util.List<com.jiayouya.travel.module.travel.data.PositionItem> r0 = r2.positions
        java.util.List<com.jiayouya.travel.module.travel.data.PositionItem> r1 = r3.positions
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.lastSysTime
        java.lang.String r3 = r3.lastSysTime
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x0031
        goto L_0x0033
    L_0x0031:
        r3 = 0
        return r3
    L_0x0033:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.SysDataReq.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.coin;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<BuyDataItem> list = this.buyData;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<PositionItem> list2 = this.positions;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str2 = this.lastSysTime;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SysDataReq(coin=");
        sb.append(this.coin);
        sb.append(", buyData=");
        sb.append(this.buyData);
        sb.append(", positions=");
        sb.append(this.positions);
        sb.append(", lastSysTime=");
        sb.append(this.lastSysTime);
        sb.append(")");
        return sb.toString();
    }

    public SysDataReq(String str, List<BuyDataItem> list, List<PositionItem> list2, String str2) {
        C8271i.m35386b(str, "coin");
        C8271i.m35386b(list, "buyData");
        C8271i.m35386b(list2, "positions");
        C8271i.m35386b(str2, "lastSysTime");
        this.coin = str;
        this.buyData = list;
        this.positions = list2;
        this.lastSysTime = str2;
    }

    public final List<BuyDataItem> getBuyData() {
        return this.buyData;
    }

    public final String getCoin() {
        return this.coin;
    }

    public final String getLastSysTime() {
        return this.lastSysTime;
    }

    public final List<PositionItem> getPositions() {
        return this.positions;
    }
}
