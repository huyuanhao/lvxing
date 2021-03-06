package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/MergeSuper;", "", "merge", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "(Lcom/jiayouya/travel/module/travel/data/PositionItem;)V", "getMerge", "()Lcom/jiayouya/travel/module/travel/data/PositionItem;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MergeSuper.kt */
public final class MergeSuper {
    private final PositionItem merge;

    public static /* synthetic */ MergeSuper copy$default(MergeSuper mergeSuper, PositionItem positionItem, int i, Object obj) {
        if ((i & 1) != 0) {
            positionItem = mergeSuper.merge;
        }
        return mergeSuper.copy(positionItem);
    }

    public final PositionItem component1() {
        return this.merge;
    }

    public final MergeSuper copy(PositionItem positionItem) {
        C8271i.m35386b(positionItem, "merge");
        return new MergeSuper(positionItem);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r1.merge, (java.lang.Object) ((com.jiayouya.travel.module.travel.data.MergeSuper) r2).merge) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015
        boolean r0 = r2 instanceof com.jiayouya.travel.module.travel.data.MergeSuper
        if (r0 == 0) goto L_0x0013
        com.jiayouya.travel.module.travel.data.MergeSuper r2 = (com.jiayouya.travel.module.travel.data.MergeSuper) r2
        com.jiayouya.travel.module.travel.data.PositionItem r0 = r1.merge
        com.jiayouya.travel.module.travel.data.PositionItem r2 = r2.merge
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.MergeSuper.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        PositionItem positionItem = this.merge;
        if (positionItem != null) {
            return positionItem.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MergeSuper(merge=");
        sb.append(this.merge);
        sb.append(")");
        return sb.toString();
    }

    public MergeSuper(PositionItem positionItem) {
        C8271i.m35386b(positionItem, "merge");
        this.merge = positionItem;
    }

    public final PositionItem getMerge() {
        return this.merge;
    }
}
