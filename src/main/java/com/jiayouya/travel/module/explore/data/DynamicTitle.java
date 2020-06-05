package com.jiayouya.travel.module.explore.data;

import ezy.p653ui.widget.recyclerview.item.Classifiable;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/data/DynamicTitle;", "Lezy/ui/widget/recyclerview/item/Classifiable;", "title", "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toSubtypeId", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DynamicTitle.kt */
public final class DynamicTitle implements Classifiable {
    private final String title;

    public static /* synthetic */ DynamicTitle copy$default(DynamicTitle dynamicTitle, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dynamicTitle.title;
        }
        return dynamicTitle.copy(str);
    }

    public final String component1() {
        return this.title;
    }

    public final DynamicTitle copy(String str) {
        C8271i.m35386b(str, "title");
        return new DynamicTitle(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r1.title, (java.lang.Object) ((com.jiayouya.travel.module.explore.data.DynamicTitle) r2).title) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015
        boolean r0 = r2 instanceof com.jiayouya.travel.module.explore.data.DynamicTitle
        if (r0 == 0) goto L_0x0013
        com.jiayouya.travel.module.explore.data.DynamicTitle r2 = (com.jiayouya.travel.module.explore.data.DynamicTitle) r2
        java.lang.String r0 = r1.title
        java.lang.String r2 = r2.title
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.explore.data.DynamicTitle.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.title;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DynamicTitle(title=");
        sb.append(this.title);
        sb.append(")");
        return sb.toString();
    }

    public long toSubtypeId() {
        return 0;
    }

    public DynamicTitle(String str) {
        C8271i.m35386b(str, "title");
        this.title = str;
    }

    public final String getTitle() {
        return this.title;
    }
}
