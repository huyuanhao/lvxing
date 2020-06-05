package com.jiayouya.travel.module.p276me.data;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/data/DogProgressRsp;", "", "percent", "", "(F)V", "getPercent", "()F", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DogProgressRsp.kt */
/* renamed from: com.jiayouya.travel.module.me.data.DogProgressRsp */
public final class DogProgressRsp {
    private final float percent;

    public static /* synthetic */ DogProgressRsp copy$default(DogProgressRsp dogProgressRsp, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = dogProgressRsp.percent;
        }
        return dogProgressRsp.copy(f);
    }

    public final float component1() {
        return this.percent;
    }

    public final DogProgressRsp copy(float f) {
        return new DogProgressRsp(f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (java.lang.Float.compare(r1.percent, ((com.jiayouya.travel.module.p276me.data.DogProgressRsp) r2).percent) == 0) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015
        boolean r0 = r2 instanceof com.jiayouya.travel.module.p276me.data.DogProgressRsp
        if (r0 == 0) goto L_0x0013
        com.jiayouya.travel.module.me.data.DogProgressRsp r2 = (com.jiayouya.travel.module.p276me.data.DogProgressRsp) r2
        float r0 = r1.percent
        float r2 = r2.percent
        int r2 = java.lang.Float.compare(r0, r2)
        if (r2 != 0) goto L_0x0013
        goto L_0x0015
    L_0x0013:
        r2 = 0
        return r2
    L_0x0015:
        r2 = 1
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.p276me.data.DogProgressRsp.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return Float.floatToIntBits(this.percent);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DogProgressRsp(percent=");
        sb.append(this.percent);
        sb.append(")");
        return sb.toString();
    }

    public DogProgressRsp(float f) {
        this.percent = f;
    }

    public final float getPercent() {
        return this.percent;
    }
}
