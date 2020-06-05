package com.jiayouya.travel.module.group.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/data/TargetRewards;", "", "id", "", "amount", "nextRate", "nextTarget", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getId", "getNextRate", "getNextTarget", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: GroupIndexRsp.kt */
public final class TargetRewards {
    private final String amount;
    /* renamed from: id */
    private final String f11486id;
    private final String nextRate;
    private final String nextTarget;

    public static /* synthetic */ TargetRewards copy$default(TargetRewards targetRewards, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = targetRewards.f11486id;
        }
        if ((i & 2) != 0) {
            str2 = targetRewards.amount;
        }
        if ((i & 4) != 0) {
            str3 = targetRewards.nextRate;
        }
        if ((i & 8) != 0) {
            str4 = targetRewards.nextTarget;
        }
        return targetRewards.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.f11486id;
    }

    public final String component2() {
        return this.amount;
    }

    public final String component3() {
        return this.nextRate;
    }

    public final String component4() {
        return this.nextTarget;
    }

    public final TargetRewards copy(String str, String str2, String str3, String str4) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, "amount");
        C8271i.m35386b(str3, "nextRate");
        C8271i.m35386b(str4, "nextTarget");
        return new TargetRewards(str, str2, str3, str4);
    }

    /* JADX INFO: used method not loaded: kotlin.jvm.internal.i.a(java.lang.Object, java.lang.Object):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.nextTarget, (java.lang.Object) r3.nextTarget) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033
        boolean r0 = r3 instanceof com.jiayouya.travel.module.group.data.TargetRewards
        if (r0 == 0) goto L_0x0031
        com.jiayouya.travel.module.group.data.TargetRewards r3 = (com.jiayouya.travel.module.group.data.TargetRewards) r3
        java.lang.String r0 = r2.f11486id
        java.lang.String r1 = r3.f11486id
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.amount
        java.lang.String r1 = r3.amount
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.nextRate
        java.lang.String r1 = r3.nextRate
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.nextTarget
        java.lang.String r3 = r3.nextTarget
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.group.data.TargetRewards.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.f11486id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.amount;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.nextRate;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.nextTarget;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TargetRewards(id=");
        sb.append(this.f11486id);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", nextRate=");
        sb.append(this.nextRate);
        sb.append(", nextTarget=");
        sb.append(this.nextTarget);
        sb.append(")");
        return sb.toString();
    }

    public TargetRewards(String str, String str2, String str3, String str4) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, "amount");
        C8271i.m35386b(str3, "nextRate");
        C8271i.m35386b(str4, "nextTarget");
        this.f11486id = str;
        this.amount = str2;
        this.nextRate = str3;
        this.nextTarget = str4;
    }

    public final String getId() {
        return this.f11486id;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getNextRate() {
        return this.nextRate;
    }

    public final String getNextTarget() {
        return this.nextTarget;
    }
}
