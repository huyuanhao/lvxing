package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/ExpandPrice;", "", "price", "", "(D)V", "getPrice", "()D", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ExpandPrice.kt */
public final class ExpandPrice {
    private final double price;

    public static /* synthetic */ ExpandPrice copy$default(ExpandPrice expandPrice, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            d = expandPrice.price;
        }
        return expandPrice.copy(d);
    }

    public final double component1() {
        return this.price;
    }

    public final ExpandPrice copy(double d) {
        return new ExpandPrice(d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (java.lang.Double.compare(r4.price, ((com.jiayouya.travel.module.travel.data.ExpandPrice) r5).price) == 0) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        if (r4 == r5) goto L_0x0015
        boolean r0 = r5 instanceof com.jiayouya.travel.module.travel.data.ExpandPrice
        if (r0 == 0) goto L_0x0013
        com.jiayouya.travel.module.travel.data.ExpandPrice r5 = (com.jiayouya.travel.module.travel.data.ExpandPrice) r5
        double r0 = r4.price
        double r2 = r5.price
        int r5 = java.lang.Double.compare(r0, r2)
        if (r5 != 0) goto L_0x0013
        goto L_0x0015
    L_0x0013:
        r5 = 0
        return r5
    L_0x0015:
        r5 = 1
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.ExpandPrice.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.price);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExpandPrice(price=");
        sb.append(this.price);
        sb.append(")");
        return sb.toString();
    }

    public ExpandPrice(double d) {
        this.price = d;
    }

    public final double getPrice() {
        return this.price;
    }
}
