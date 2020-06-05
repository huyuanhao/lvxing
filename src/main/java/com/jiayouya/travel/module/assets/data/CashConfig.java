package com.jiayouya.travel.module.assets.data;

import com.jiayouya.travel.module.common.data.PayChannelItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003JM\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006 "}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/data/CashConfig;", "", "balance", "", "feeText", "feeExplain", "", "channels", "Lcom/jiayouya/travel/module/common/data/PayChannelItem;", "cash", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBalance", "()Ljava/lang/String;", "setBalance", "(Ljava/lang/String;)V", "getCash", "()Ljava/util/List;", "getChannels", "getFeeExplain", "getFeeText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CashConfig.kt */
public final class CashConfig {
    private String balance;
    private final List<String> cash;
    private final List<PayChannelItem> channels;
    private final List<String> feeExplain;
    private final String feeText;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem>, for r7v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r6v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r8v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.assets.data.CashConfig copy$default(com.jiayouya.travel.module.assets.data.CashConfig r3, java.lang.String r4, java.lang.String r5, java.util.List<java.lang.String> r6, java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem> r7, java.util.List<java.lang.String> r8, int r9, java.lang.Object r10) {
        /*
        r10 = r9 & 1
        if (r10 == 0) goto L_0x0006
        java.lang.String r4 = r3.balance
    L_0x0006:
        r10 = r9 & 2
        if (r10 == 0) goto L_0x000c
        java.lang.String r5 = r3.feeText
    L_0x000c:
        r10 = r5
        r5 = r9 & 4
        if (r5 == 0) goto L_0x0013
        java.util.List<java.lang.String> r6 = r3.feeExplain
    L_0x0013:
        r0 = r6
        r5 = r9 & 8
        if (r5 == 0) goto L_0x001a
        java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem> r7 = r3.channels
    L_0x001a:
        r1 = r7
        r5 = r9 & 16
        if (r5 == 0) goto L_0x0021
        java.util.List<java.lang.String> r8 = r3.cash
    L_0x0021:
        r2 = r8
        r5 = r3
        r6 = r4
        r7 = r10
        r8 = r0
        r9 = r1
        r10 = r2
        com.jiayouya.travel.module.assets.data.CashConfig r3 = r5.copy(r6, r7, r8, r9, r10)
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.assets.data.CashConfig.copy$default(com.jiayouya.travel.module.assets.data.CashConfig, java.lang.String, java.lang.String, java.util.List, java.util.List, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.assets.data.CashConfig");
    }

    public final String component1() {
        return this.balance;
    }

    public final String component2() {
        return this.feeText;
    }

    public final List<String> component3() {
        return this.feeExplain;
    }

    public final List<PayChannelItem> component4() {
        return this.channels;
    }

    public final List<String> component5() {
        return this.cash;
    }

    public final CashConfig copy(String str, String str2, List<String> list, List<PayChannelItem> list2, List<String> list3) {
        C8271i.m35386b(str, "balance");
        C8271i.m35386b(str2, "feeText");
        C8271i.m35386b(list, "feeExplain");
        C8271i.m35386b(list2, "channels");
        C8271i.m35386b(list3, "cash");
        CashConfig cashConfig = new CashConfig(str, str2, list, list2, list3);
        return cashConfig;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.cash, (java.lang.Object) r3.cash) != false) goto L_0x003d;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x003d
        boolean r0 = r3 instanceof com.jiayouya.travel.module.assets.data.CashConfig
        if (r0 == 0) goto L_0x003b
        com.jiayouya.travel.module.assets.data.CashConfig r3 = (com.jiayouya.travel.module.assets.data.CashConfig) r3
        java.lang.String r0 = r2.balance
        java.lang.String r1 = r3.balance
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        java.lang.String r0 = r2.feeText
        java.lang.String r1 = r3.feeText
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        java.util.List<java.lang.String> r0 = r2.feeExplain
        java.util.List<java.lang.String> r1 = r3.feeExplain
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem> r0 = r2.channels
        java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem> r1 = r3.channels
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x003b
        java.util.List<java.lang.String> r0 = r2.cash
        java.util.List<java.lang.String> r3 = r3.cash
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x003b
        goto L_0x003d
    L_0x003b:
        r3 = 0
        return r3
    L_0x003d:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.assets.data.CashConfig.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.balance;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.feeText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<String> list = this.feeExplain;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<PayChannelItem> list2 = this.channels;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<String> list3 = this.cash;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashConfig(balance=");
        sb.append(this.balance);
        sb.append(", feeText=");
        sb.append(this.feeText);
        sb.append(", feeExplain=");
        sb.append(this.feeExplain);
        sb.append(", channels=");
        sb.append(this.channels);
        sb.append(", cash=");
        sb.append(this.cash);
        sb.append(")");
        return sb.toString();
    }

    public CashConfig(String str, String str2, List<String> list, List<PayChannelItem> list2, List<String> list3) {
        C8271i.m35386b(str, "balance");
        C8271i.m35386b(str2, "feeText");
        C8271i.m35386b(list, "feeExplain");
        C8271i.m35386b(list2, "channels");
        C8271i.m35386b(list3, "cash");
        this.balance = str;
        this.feeText = str2;
        this.feeExplain = list;
        this.channels = list2;
        this.cash = list3;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final List<String> getFeeExplain() {
        return this.feeExplain;
    }

    public final String getFeeText() {
        return this.feeText;
    }

    public final void setBalance(String str) {
        C8271i.m35386b(str, "<set-?>");
        this.balance = str;
    }

    public final List<String> getCash() {
        return this.cash;
    }

    public final List<PayChannelItem> getChannels() {
        return this.channels;
    }
}
