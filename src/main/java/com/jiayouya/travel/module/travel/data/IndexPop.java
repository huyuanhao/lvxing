package com.jiayouya.travel.module.travel.data;

import java.util.List;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/IndexPop;", "", "luckDog", "", "Lcom/jiayouya/travel/module/travel/data/LuckDog;", "city", "Lcom/jiayouya/travel/module/travel/data/UnlockCity;", "(Ljava/util/List;Ljava/util/List;)V", "getCity", "()Ljava/util/List;", "getLuckDog", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: IndexPop.kt */
public final class IndexPop {
    private final List<UnlockCity> city;
    private final List<LuckDog> luckDog;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.travel.data.LuckDog>, for r1v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.travel.data.UnlockCity>, for r2v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.travel.data.IndexPop copy$default(com.jiayouya.travel.module.travel.data.IndexPop r0, java.util.List<com.jiayouya.travel.module.travel.data.LuckDog> r1, java.util.List<com.jiayouya.travel.module.travel.data.UnlockCity> r2, int r3, java.lang.Object r4) {
        /*
        r4 = r3 & 1
        if (r4 == 0) goto L_0x0006
        java.util.List<com.jiayouya.travel.module.travel.data.LuckDog> r1 = r0.luckDog
    L_0x0006:
        r3 = r3 & 2
        if (r3 == 0) goto L_0x000c
        java.util.List<com.jiayouya.travel.module.travel.data.UnlockCity> r2 = r0.city
    L_0x000c:
        com.jiayouya.travel.module.travel.data.IndexPop r0 = r0.copy(r1, r2)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.IndexPop.copy$default(com.jiayouya.travel.module.travel.data.IndexPop, java.util.List, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.travel.data.IndexPop");
    }

    public final List<LuckDog> component1() {
        return this.luckDog;
    }

    public final List<UnlockCity> component2() {
        return this.city;
    }

    public final IndexPop copy(List<LuckDog> list, List<UnlockCity> list2) {
        return new IndexPop(list, list2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.city, (java.lang.Object) r3.city) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f
        boolean r0 = r3 instanceof com.jiayouya.travel.module.travel.data.IndexPop
        if (r0 == 0) goto L_0x001d
        com.jiayouya.travel.module.travel.data.IndexPop r3 = (com.jiayouya.travel.module.travel.data.IndexPop) r3
        java.util.List<com.jiayouya.travel.module.travel.data.LuckDog> r0 = r2.luckDog
        java.util.List<com.jiayouya.travel.module.travel.data.LuckDog> r1 = r3.luckDog
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x001d
        java.util.List<com.jiayouya.travel.module.travel.data.UnlockCity> r0 = r2.city
        java.util.List<com.jiayouya.travel.module.travel.data.UnlockCity> r3 = r3.city
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.IndexPop.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List<LuckDog> list = this.luckDog;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<UnlockCity> list2 = this.city;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IndexPop(luckDog=");
        sb.append(this.luckDog);
        sb.append(", city=");
        sb.append(this.city);
        sb.append(")");
        return sb.toString();
    }

    public IndexPop(List<LuckDog> list, List<UnlockCity> list2) {
        this.luckDog = list;
        this.city = list2;
    }

    public final List<UnlockCity> getCity() {
        return this.city;
    }

    public final List<LuckDog> getLuckDog() {
        return this.luckDog;
    }
}
