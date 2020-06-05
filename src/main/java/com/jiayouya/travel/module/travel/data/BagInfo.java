package com.jiayouya.travel.module.travel.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/BagInfo;", "", "maxNum", "", "useNum", "", "items", "", "Lcom/jiayouya/travel/module/travel/data/BagItem;", "(Ljava/lang/String;ILjava/util/List;)V", "getItems", "()Ljava/util/List;", "getMaxNum", "()Ljava/lang/String;", "setMaxNum", "(Ljava/lang/String;)V", "getUseNum", "()I", "setUseNum", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BagInfo.kt */
public final class BagInfo {
    private final List<BagItem> items;
    private String maxNum;
    private int useNum;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.travel.data.BagItem>, for r3v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.travel.data.BagInfo copy$default(com.jiayouya.travel.module.travel.data.BagInfo r0, java.lang.String r1, int r2, java.util.List<com.jiayouya.travel.module.travel.data.BagItem> r3, int r4, java.lang.Object r5) {
        /*
        r5 = r4 & 1
        if (r5 == 0) goto L_0x0006
        java.lang.String r1 = r0.maxNum
    L_0x0006:
        r5 = r4 & 2
        if (r5 == 0) goto L_0x000c
        int r2 = r0.useNum
    L_0x000c:
        r4 = r4 & 4
        if (r4 == 0) goto L_0x0012
        java.util.List<com.jiayouya.travel.module.travel.data.BagItem> r3 = r0.items
    L_0x0012:
        com.jiayouya.travel.module.travel.data.BagInfo r0 = r0.copy(r1, r2, r3)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.BagInfo.copy$default(com.jiayouya.travel.module.travel.data.BagInfo, java.lang.String, int, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.travel.data.BagInfo");
    }

    public final String component1() {
        return this.maxNum;
    }

    public final int component2() {
        return this.useNum;
    }

    public final List<BagItem> component3() {
        return this.items;
    }

    public final BagInfo copy(String str, int i, List<BagItem> list) {
        C8271i.m35386b(str, "maxNum");
        return new BagInfo(str, i, list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BagInfo) {
                BagInfo bagInfo = (BagInfo) obj;
                if (C8271i.m35384a((Object) this.maxNum, (Object) bagInfo.maxNum)) {
                    if (!(this.useNum == bagInfo.useNum) || !C8271i.m35384a((Object) this.items, (Object) bagInfo.items)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.maxNum;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.useNum) * 31;
        List<BagItem> list = this.items;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BagInfo(maxNum=");
        sb.append(this.maxNum);
        sb.append(", useNum=");
        sb.append(this.useNum);
        sb.append(", items=");
        sb.append(this.items);
        sb.append(")");
        return sb.toString();
    }

    public BagInfo(String str, int i, List<BagItem> list) {
        C8271i.m35386b(str, "maxNum");
        this.maxNum = str;
        this.useNum = i;
        this.items = list;
    }

    public final List<BagItem> getItems() {
        return this.items;
    }

    public final String getMaxNum() {
        return this.maxNum;
    }

    public final int getUseNum() {
        return this.useNum;
    }

    public final void setMaxNum(String str) {
        C8271i.m35386b(str, "<set-?>");
        this.maxNum = str;
    }

    public final void setUseNum(int i) {
        this.useNum = i;
    }
}
