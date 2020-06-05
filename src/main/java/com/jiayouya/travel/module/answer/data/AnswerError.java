package com.jiayouya.travel.module.answer.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, mo39189d2 = {"Lcom/jiayouya/travel/module/answer/data/AnswerError;", "Landroid/os/Parcelable;", "num", "", "items", "", "Lcom/jiayouya/travel/module/answer/data/AnswerErrorItem;", "(Ljava/lang/String;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "getNum", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AnswerResult.kt */
public final class AnswerError implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final List<AnswerErrorItem> items;
    private final String num;

    @Metadata(mo39187bv = {1, 0, 3}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* renamed from: com.jiayouya.travel.module.answer.data.AnswerError$Creator */
    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            C8271i.m35386b(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((AnswerErrorItem) AnswerErrorItem.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new AnswerError(readString, arrayList);
        }

        public final Object[] newArray(int i) {
            return new AnswerError[i];
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.answer.data.AnswerErrorItem>, for r2v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.answer.data.AnswerError copy$default(com.jiayouya.travel.module.answer.data.AnswerError r0, java.lang.String r1, java.util.List<com.jiayouya.travel.module.answer.data.AnswerErrorItem> r2, int r3, java.lang.Object r4) {
        /*
        r4 = r3 & 1
        if (r4 == 0) goto L_0x0006
        java.lang.String r1 = r0.num
    L_0x0006:
        r3 = r3 & 2
        if (r3 == 0) goto L_0x000c
        java.util.List<com.jiayouya.travel.module.answer.data.AnswerErrorItem> r2 = r0.items
    L_0x000c:
        com.jiayouya.travel.module.answer.data.AnswerError r0 = r0.copy(r1, r2)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.answer.data.AnswerError.copy$default(com.jiayouya.travel.module.answer.data.AnswerError, java.lang.String, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.answer.data.AnswerError");
    }

    public final String component1() {
        return this.num;
    }

    public final List<AnswerErrorItem> component2() {
        return this.items;
    }

    public final AnswerError copy(String str, List<AnswerErrorItem> list) {
        C8271i.m35386b(str, "num");
        C8271i.m35386b(list, "items");
        return new AnswerError(str, list);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.items, (java.lang.Object) r3.items) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f
        boolean r0 = r3 instanceof com.jiayouya.travel.module.answer.data.AnswerError
        if (r0 == 0) goto L_0x001d
        com.jiayouya.travel.module.answer.data.AnswerError r3 = (com.jiayouya.travel.module.answer.data.AnswerError) r3
        java.lang.String r0 = r2.num
        java.lang.String r1 = r3.num
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x001d
        java.util.List<com.jiayouya.travel.module.answer.data.AnswerErrorItem> r0 = r2.items
        java.util.List<com.jiayouya.travel.module.answer.data.AnswerErrorItem> r3 = r3.items
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.answer.data.AnswerError.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.num;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<AnswerErrorItem> list = this.items;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnswerError(num=");
        sb.append(this.num);
        sb.append(", items=");
        sb.append(this.items);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C8271i.m35386b(parcel, "parcel");
        parcel.writeString(this.num);
        List<AnswerErrorItem> list = this.items;
        parcel.writeInt(list.size());
        for (AnswerErrorItem writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public AnswerError(String str, List<AnswerErrorItem> list) {
        C8271i.m35386b(str, "num");
        C8271i.m35386b(list, "items");
        this.num = str;
        this.items = list;
    }

    public final List<AnswerErrorItem> getItems() {
        return this.items;
    }

    public final String getNum() {
        return this.num;
    }
}
