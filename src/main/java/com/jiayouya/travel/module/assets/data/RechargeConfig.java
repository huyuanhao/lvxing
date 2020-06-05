package com.jiayouya.travel.module.assets.data;

import com.jiayouya.travel.module.common.data.PayChannelItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/data/RechargeConfig;", "", "methods", "", "Lcom/jiayouya/travel/module/common/data/PayChannelItem;", "(Ljava/util/List;)V", "getMethods", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: RechargeConfig.kt */
public final class RechargeConfig {
    private final List<PayChannelItem> methods;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem>, for r1v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.assets.data.RechargeConfig copy$default(com.jiayouya.travel.module.assets.data.RechargeConfig r0, java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem> r1, int r2, java.lang.Object r3) {
        /*
        r2 = r2 & 1
        if (r2 == 0) goto L_0x0006
        java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem> r1 = r0.methods
    L_0x0006:
        com.jiayouya.travel.module.assets.data.RechargeConfig r0 = r0.copy(r1)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.assets.data.RechargeConfig.copy$default(com.jiayouya.travel.module.assets.data.RechargeConfig, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.assets.data.RechargeConfig");
    }

    public final List<PayChannelItem> component1() {
        return this.methods;
    }

    public final RechargeConfig copy(List<PayChannelItem> list) {
        C8271i.m35386b(list, "methods");
        return new RechargeConfig(list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r1.methods, (java.lang.Object) ((com.jiayouya.travel.module.assets.data.RechargeConfig) r2).methods) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015
        boolean r0 = r2 instanceof com.jiayouya.travel.module.assets.data.RechargeConfig
        if (r0 == 0) goto L_0x0013
        com.jiayouya.travel.module.assets.data.RechargeConfig r2 = (com.jiayouya.travel.module.assets.data.RechargeConfig) r2
        java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem> r0 = r1.methods
        java.util.List<com.jiayouya.travel.module.common.data.PayChannelItem> r2 = r2.methods
        boolean r2 = kotlin.jvm.internal.C8271i.m35384a(r0, r2)
        if (r2 == 0) goto L_0x0013
        goto L_0x0015
    L_0x0013:
        r2 = 0
        return r2
    L_0x0015:
        r2 = 1
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.assets.data.RechargeConfig.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List<PayChannelItem> list = this.methods;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RechargeConfig(methods=");
        sb.append(this.methods);
        sb.append(")");
        return sb.toString();
    }

    public RechargeConfig(List<PayChannelItem> list) {
        C8271i.m35386b(list, "methods");
        this.methods = list;
    }

    public final List<PayChannelItem> getMethods() {
        return this.methods;
    }
}
