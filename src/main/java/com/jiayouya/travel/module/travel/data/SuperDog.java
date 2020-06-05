package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/SuperDog;", "", "name", "", "percent", "", "desc", "items", "", "(Ljava/lang/String;FLjava/lang/String;Ljava/util/List;)V", "getDesc", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getName", "getPercent", "()F", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DogInfo.kt */
public final class SuperDog {
    private final String desc;
    private final List<String> items;
    private final String name;
    private final float percent;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r4v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.travel.data.SuperDog copy$default(com.jiayouya.travel.module.travel.data.SuperDog r0, java.lang.String r1, float r2, java.lang.String r3, java.util.List<java.lang.String> r4, int r5, java.lang.Object r6) {
        /*
        r6 = r5 & 1
        if (r6 == 0) goto L_0x0006
        java.lang.String r1 = r0.name
    L_0x0006:
        r6 = r5 & 2
        if (r6 == 0) goto L_0x000c
        float r2 = r0.percent
    L_0x000c:
        r6 = r5 & 4
        if (r6 == 0) goto L_0x0012
        java.lang.String r3 = r0.desc
    L_0x0012:
        r5 = r5 & 8
        if (r5 == 0) goto L_0x0018
        java.util.List<java.lang.String> r4 = r0.items
    L_0x0018:
        com.jiayouya.travel.module.travel.data.SuperDog r0 = r0.copy(r1, r2, r3, r4)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.SuperDog.copy$default(com.jiayouya.travel.module.travel.data.SuperDog, java.lang.String, float, java.lang.String, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.travel.data.SuperDog");
    }

    public final String component1() {
        return this.name;
    }

    public final float component2() {
        return this.percent;
    }

    public final String component3() {
        return this.desc;
    }

    public final List<String> component4() {
        return this.items;
    }

    public final SuperDog copy(String str, float f, String str2, List<String> list) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, ArgKey.KEY_DESC);
        C8271i.m35386b(list, "items");
        return new SuperDog(str, f, str2, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.items, (java.lang.Object) r3.items) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033
        boolean r0 = r3 instanceof com.jiayouya.travel.module.travel.data.SuperDog
        if (r0 == 0) goto L_0x0031
        com.jiayouya.travel.module.travel.data.SuperDog r3 = (com.jiayouya.travel.module.travel.data.SuperDog) r3
        java.lang.String r0 = r2.name
        java.lang.String r1 = r3.name
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        float r0 = r2.percent
        float r1 = r3.percent
        int r0 = java.lang.Float.compare(r0, r1)
        if (r0 != 0) goto L_0x0031
        java.lang.String r0 = r2.desc
        java.lang.String r1 = r3.desc
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.util.List<java.lang.String> r0 = r2.items
        java.util.List<java.lang.String> r3 = r3.items
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.SuperDog.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Float.floatToIntBits(this.percent)) * 31;
        String str2 = this.desc;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<String> list = this.items;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SuperDog(name=");
        sb.append(this.name);
        sb.append(", percent=");
        sb.append(this.percent);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(", items=");
        sb.append(this.items);
        sb.append(")");
        return sb.toString();
    }

    public SuperDog(String str, float f, String str2, List<String> list) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, ArgKey.KEY_DESC);
        C8271i.m35386b(list, "items");
        this.name = str;
        this.percent = f;
        this.desc = str2;
        this.items = list;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final List<String> getItems() {
        return this.items;
    }

    public final String getName() {
        return this.name;
    }

    public final float getPercent() {
        return this.percent;
    }
}
