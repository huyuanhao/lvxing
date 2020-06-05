package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/UpgradeHb;", "", "hbInfo", "Lcom/jiayouya/travel/module/travel/data/HbInfo;", "(Lcom/jiayouya/travel/module/travel/data/HbInfo;)V", "getHbInfo", "()Lcom/jiayouya/travel/module/travel/data/HbInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: UpgradeHb.kt */
public final class UpgradeHb {
    private final HbInfo hbInfo;

    public static /* synthetic */ UpgradeHb copy$default(UpgradeHb upgradeHb, HbInfo hbInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            hbInfo2 = upgradeHb.hbInfo;
        }
        return upgradeHb.copy(hbInfo2);
    }

    public final HbInfo component1() {
        return this.hbInfo;
    }

    public final UpgradeHb copy(HbInfo hbInfo2) {
        return new UpgradeHb(hbInfo2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r1.hbInfo, (java.lang.Object) ((com.jiayouya.travel.module.travel.data.UpgradeHb) r2).hbInfo) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015
        boolean r0 = r2 instanceof com.jiayouya.travel.module.travel.data.UpgradeHb
        if (r0 == 0) goto L_0x0013
        com.jiayouya.travel.module.travel.data.UpgradeHb r2 = (com.jiayouya.travel.module.travel.data.UpgradeHb) r2
        com.jiayouya.travel.module.travel.data.HbInfo r0 = r1.hbInfo
        com.jiayouya.travel.module.travel.data.HbInfo r2 = r2.hbInfo
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.UpgradeHb.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        HbInfo hbInfo2 = this.hbInfo;
        if (hbInfo2 != null) {
            return hbInfo2.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UpgradeHb(hbInfo=");
        sb.append(this.hbInfo);
        sb.append(")");
        return sb.toString();
    }

    public UpgradeHb(HbInfo hbInfo2) {
        this.hbInfo = hbInfo2;
    }

    public final HbInfo getHbInfo() {
        return this.hbInfo;
    }
}
