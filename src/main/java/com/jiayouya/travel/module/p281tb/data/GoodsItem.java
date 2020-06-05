package com.jiayouya.travel.module.p281tb.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/data/GoodsItem;", "Landroid/os/Parcelable;", "s", "", "(Ljava/lang/String;)V", "getS", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: GoodsItem.kt */
/* renamed from: com.jiayouya.travel.module.tb.data.GoodsItem */
public final class GoodsItem implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    /* renamed from: s */
    private final String f11799s;

    @Metadata(mo39187bv = {1, 0, 3}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* renamed from: com.jiayouya.travel.module.tb.data.GoodsItem$Creator */
    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            C8271i.m35386b(parcel, "in");
            return new GoodsItem(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new GoodsItem[i];
        }
    }

    public static /* synthetic */ GoodsItem copy$default(GoodsItem goodsItem, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = goodsItem.f11799s;
        }
        return goodsItem.copy(str);
    }

    public final String component1() {
        return this.f11799s;
    }

    public final GoodsItem copy(String str) {
        C8271i.m35386b(str, "s");
        return new GoodsItem(str);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r1.f11799s, (java.lang.Object) ((com.jiayouya.travel.module.p281tb.data.GoodsItem) r2).f11799s) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015
        boolean r0 = r2 instanceof com.jiayouya.travel.module.p281tb.data.GoodsItem
        if (r0 == 0) goto L_0x0013
        com.jiayouya.travel.module.tb.data.GoodsItem r2 = (com.jiayouya.travel.module.p281tb.data.GoodsItem) r2
        java.lang.String r0 = r1.f11799s
        java.lang.String r2 = r2.f11799s
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.p281tb.data.GoodsItem.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.f11799s;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GoodsItem(s=");
        sb.append(this.f11799s);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C8271i.m35386b(parcel, "parcel");
        parcel.writeString(this.f11799s);
    }

    public GoodsItem(String str) {
        C8271i.m35386b(str, "s");
        this.f11799s = str;
    }

    public final String getS() {
        return this.f11799s;
    }
}
