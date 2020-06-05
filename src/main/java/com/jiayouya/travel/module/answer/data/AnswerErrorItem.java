package com.jiayouya.travel.module.answer.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000e¨\u0006 "}, mo39189d2 = {"Lcom/jiayouya/travel/module/answer/data/AnswerErrorItem;", "Landroid/os/Parcelable;", "id", "", "question", "answer", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAnswer", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getQuestion", "setQuestion", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AnswerResult.kt */
public final class AnswerErrorItem implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final List<String> answer;
    /* renamed from: id */
    private final String f11221id;
    private String question;

    @Metadata(mo39187bv = {1, 0, 3}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* renamed from: com.jiayouya.travel.module.answer.data.AnswerErrorItem$Creator */
    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            C8271i.m35386b(parcel, "in");
            return new AnswerErrorItem(parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        public final Object[] newArray(int i) {
            return new AnswerErrorItem[i];
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r3v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.answer.data.AnswerErrorItem copy$default(com.jiayouya.travel.module.answer.data.AnswerErrorItem r0, java.lang.String r1, java.lang.String r2, java.util.List<java.lang.String> r3, int r4, java.lang.Object r5) {
        /*
        r5 = r4 & 1
        if (r5 == 0) goto L_0x0006
        java.lang.String r1 = r0.f11221id
    L_0x0006:
        r5 = r4 & 2
        if (r5 == 0) goto L_0x000c
        java.lang.String r2 = r0.question
    L_0x000c:
        r4 = r4 & 4
        if (r4 == 0) goto L_0x0012
        java.util.List<java.lang.String> r3 = r0.answer
    L_0x0012:
        com.jiayouya.travel.module.answer.data.AnswerErrorItem r0 = r0.copy(r1, r2, r3)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.answer.data.AnswerErrorItem.copy$default(com.jiayouya.travel.module.answer.data.AnswerErrorItem, java.lang.String, java.lang.String, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.answer.data.AnswerErrorItem");
    }

    public final String component1() {
        return this.f11221id;
    }

    public final String component2() {
        return this.question;
    }

    public final List<String> component3() {
        return this.answer;
    }

    public final AnswerErrorItem copy(String str, String str2, List<String> list) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, "question");
        C8271i.m35386b(list, "answer");
        return new AnswerErrorItem(str, str2, list);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.answer, (java.lang.Object) r3.answer) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029
        boolean r0 = r3 instanceof com.jiayouya.travel.module.answer.data.AnswerErrorItem
        if (r0 == 0) goto L_0x0027
        com.jiayouya.travel.module.answer.data.AnswerErrorItem r3 = (com.jiayouya.travel.module.answer.data.AnswerErrorItem) r3
        java.lang.String r0 = r2.f11221id
        java.lang.String r1 = r3.f11221id
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0027
        java.lang.String r0 = r2.question
        java.lang.String r1 = r3.question
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0027
        java.util.List<java.lang.String> r0 = r2.answer
        java.util.List<java.lang.String> r3 = r3.answer
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x0027
        goto L_0x0029
    L_0x0027:
        r3 = 0
        return r3
    L_0x0029:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.answer.data.AnswerErrorItem.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.f11221id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.question;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<String> list = this.answer;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnswerErrorItem(id=");
        sb.append(this.f11221id);
        sb.append(", question=");
        sb.append(this.question);
        sb.append(", answer=");
        sb.append(this.answer);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C8271i.m35386b(parcel, "parcel");
        parcel.writeString(this.f11221id);
        parcel.writeString(this.question);
        parcel.writeStringList(this.answer);
    }

    public AnswerErrorItem(String str, String str2, List<String> list) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, "question");
        C8271i.m35386b(list, "answer");
        this.f11221id = str;
        this.question = str2;
        this.answer = list;
    }

    public final List<String> getAnswer() {
        return this.answer;
    }

    public final String getId() {
        return this.f11221id;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final void setQuestion(String str) {
        C8271i.m35386b(str, "<set-?>");
        this.question = str;
    }
}
