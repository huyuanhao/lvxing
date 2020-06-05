package com.jiayouya.travel.module.p281tb.data;

import com.jiayouya.travel.module.p281tb.widget.CircleProgressBar.C3313b;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/data/OrderWorkerItem;", "Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar$IProgress;", "title", "", "(Ljava/lang/String;)V", "lastProgress", "", "getLastProgress", "()F", "setLastProgress", "(F)V", "getTitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "getProgress", "hashCode", "", "setProgress", "", "progress", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: OrderCoinItem.kt */
/* renamed from: com.jiayouya.travel.module.tb.data.OrderWorkerItem */
public final class OrderWorkerItem implements C3313b {
    private float lastProgress;
    private final String title;

    public OrderWorkerItem() {
        this(null, 1, null);
    }

    public static /* synthetic */ OrderWorkerItem copy$default(OrderWorkerItem orderWorkerItem, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderWorkerItem.title;
        }
        return orderWorkerItem.copy(str);
    }

    public final String component1() {
        return this.title;
    }

    public final OrderWorkerItem copy(String str) {
        C8271i.m35386b(str, "title");
        return new OrderWorkerItem(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r1.title, (java.lang.Object) ((com.jiayouya.travel.module.p281tb.data.OrderWorkerItem) r2).title) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015
        boolean r0 = r2 instanceof com.jiayouya.travel.module.p281tb.data.OrderWorkerItem
        if (r0 == 0) goto L_0x0013
        com.jiayouya.travel.module.tb.data.OrderWorkerItem r2 = (com.jiayouya.travel.module.p281tb.data.OrderWorkerItem) r2
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.p281tb.data.OrderWorkerItem.equals(java.lang.Object):boolean");
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
        sb.append("OrderWorkerItem(title=");
        sb.append(this.title);
        sb.append(")");
        return sb.toString();
    }

    public OrderWorkerItem(String str) {
        C8271i.m35386b(str, "title");
        this.title = str;
    }

    public /* synthetic */ OrderWorkerItem(String str, int i, DefaultConstructorMarker fVar) {
        if ((i & 1) != 0) {
            str = "";
        }
        this(str);
    }

    public final String getTitle() {
        return this.title;
    }

    public final float getLastProgress() {
        return this.lastProgress;
    }

    public final void setLastProgress(float f) {
        this.lastProgress = f;
    }

    public float getProgress() {
        return this.lastProgress;
    }

    public void setProgress(float f) {
        this.lastProgress = f;
    }
}
