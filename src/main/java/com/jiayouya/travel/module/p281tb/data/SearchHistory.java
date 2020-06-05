package com.jiayouya.travel.module.p281tb.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/data/SearchHistory;", "", "hot", "", "", "history", "(Ljava/util/List;Ljava/util/List;)V", "getHistory", "()Ljava/util/List;", "getHot", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: SearchHistory.kt */
/* renamed from: com.jiayouya.travel.module.tb.data.SearchHistory */
public final class SearchHistory {
    private final List<String> history;
    private final List<String> hot;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r1v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r2v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.p281tb.data.SearchHistory copy$default(com.jiayouya.travel.module.p281tb.data.SearchHistory r0, java.util.List<java.lang.String> r1, java.util.List<java.lang.String> r2, int r3, java.lang.Object r4) {
        /*
        r4 = r3 & 1
        if (r4 == 0) goto L_0x0006
        java.util.List<java.lang.String> r1 = r0.hot
    L_0x0006:
        r3 = r3 & 2
        if (r3 == 0) goto L_0x000c
        java.util.List<java.lang.String> r2 = r0.history
    L_0x000c:
        com.jiayouya.travel.module.tb.data.SearchHistory r0 = r0.copy(r1, r2)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.p281tb.data.SearchHistory.copy$default(com.jiayouya.travel.module.tb.data.SearchHistory, java.util.List, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.tb.data.SearchHistory");
    }

    public final List<String> component1() {
        return this.hot;
    }

    public final List<String> component2() {
        return this.history;
    }

    public final SearchHistory copy(List<String> list, List<String> list2) {
        C8271i.m35386b(list, "hot");
        C8271i.m35386b(list2, "history");
        return new SearchHistory(list, list2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.history, (java.lang.Object) r3.history) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f
        boolean r0 = r3 instanceof com.jiayouya.travel.module.p281tb.data.SearchHistory
        if (r0 == 0) goto L_0x001d
        com.jiayouya.travel.module.tb.data.SearchHistory r3 = (com.jiayouya.travel.module.p281tb.data.SearchHistory) r3
        java.util.List<java.lang.String> r0 = r2.hot
        java.util.List<java.lang.String> r1 = r3.hot
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x001d
        java.util.List<java.lang.String> r0 = r2.history
        java.util.List<java.lang.String> r3 = r3.history
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.p281tb.data.SearchHistory.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List<String> list = this.hot;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.history;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchHistory(hot=");
        sb.append(this.hot);
        sb.append(", history=");
        sb.append(this.history);
        sb.append(")");
        return sb.toString();
    }

    public SearchHistory(List<String> list, List<String> list2) {
        C8271i.m35386b(list, "hot");
        C8271i.m35386b(list2, "history");
        this.hot = list;
        this.history = list2;
    }

    public final List<String> getHistory() {
        return this.history;
    }

    public final List<String> getHot() {
        return this.hot;
    }
}
