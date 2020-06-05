package com.jiayouya.travel.module.common.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/PayMethodRsp;", "", "amount", "", "methods", "", "Lcom/jiayouya/travel/module/common/data/PayChannelItem;", "(Ljava/lang/String;Ljava/util/List;)V", "getAmount", "()Ljava/lang/String;", "getMethods", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: PayMethodRsp.kt */
public final class PayMethodRsp {
    private final String amount;
    private final List<PayChannelItem> methods;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem>, for r2v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.common.data.PayMethodRsp copy$default(com.jiayouya.travel.module.common.data.PayMethodRsp r0, java.lang.String r1, java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem> r2, int r3, java.lang.Object r4) {
        /*
        r4 = r3 & 1
        if (r4 == 0) goto L_0x0006
        java.lang.String r1 = r0.amount
    L_0x0006:
        r3 = r3 & 2
        if (r3 == 0) goto L_0x000c
        java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem> r2 = r0.methods
    L_0x000c:
        com.jiayouya.travel.module.common.data.PayMethodRsp r0 = r0.copy(r1, r2)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.common.data.PayMethodRsp.copy$default(com.jiayouya.travel.module.common.data.PayMethodRsp, java.lang.String, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.common.data.PayMethodRsp");
    }

    public final String component1() {
        return this.amount;
    }

    public final List<PayChannelItem> component2() {
        return this.methods;
    }

    public final PayMethodRsp copy(String str, List<PayChannelItem> list) {
        C8271i.m35386b(str, "amount");
        C8271i.m35386b(list, "methods");
        return new PayMethodRsp(str, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.methods, (java.lang.Object) r3.methods) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f
        boolean r0 = r3 instanceof com.jiayouya.travel.module.common.data.PayMethodRsp
        if (r0 == 0) goto L_0x001d
        com.jiayouya.travel.module.common.data.PayMethodRsp r3 = (com.jiayouya.travel.module.common.data.PayMethodRsp) r3
        java.lang.String r0 = r2.amount
        java.lang.String r1 = r3.amount
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x001d
        java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem> r0 = r2.methods
        java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem> r3 = r3.methods
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x001d
        goto L_0x001f
    L_0x001d:
        r3 = 0
        return r3
    L_0x001f:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.common.data.PayMethodRsp.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.amount;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<PayChannelItem> list = this.methods;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayMethodRsp(amount=");
        sb.append(this.amount);
        sb.append(", methods=");
        sb.append(this.methods);
        sb.append(")");
        return sb.toString();
    }

    public PayMethodRsp(String str, List<PayChannelItem> list) {
        C8271i.m35386b(str, "amount");
        C8271i.m35386b(list, "methods");
        this.amount = str;
        this.methods = list;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final List<PayChannelItem> getMethods() {
        return this.methods;
    }
}
