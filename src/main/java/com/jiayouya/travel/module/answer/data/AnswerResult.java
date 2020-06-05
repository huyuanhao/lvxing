package com.jiayouya.travel.module.answer.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, mo39189d2 = {"Lcom/jiayouya/travel/module/answer/data/AnswerResult;", "Landroid/os/Parcelable;", "coin", "", "timeText", "", "error", "Lcom/jiayouya/travel/module/answer/data/AnswerError;", "(DLjava/lang/String;Lcom/jiayouya/travel/module/answer/data/AnswerError;)V", "getCoin", "()D", "getError", "()Lcom/jiayouya/travel/module/answer/data/AnswerError;", "getTimeText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AnswerResult.kt */
public final class AnswerResult implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final double coin;
    private final AnswerError error;
    private final String timeText;

    @Metadata(mo39187bv = {1, 0, 3}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* renamed from: com.jiayouya.travel.module.answer.data.AnswerResult$Creator */
    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            C8271i.m35386b(parcel, "in");
            return new AnswerResult(parcel.readDouble(), parcel.readString(), parcel.readInt() != 0 ? (AnswerError) AnswerError.CREATOR.createFromParcel(parcel) : null);
        }

        public final Object[] newArray(int i) {
            return new AnswerResult[i];
        }
    }

    public static /* synthetic */ AnswerResult copy$default(AnswerResult answerResult, double d, String str, AnswerError answerError, int i, Object obj) {
        if ((i & 1) != 0) {
            d = answerResult.coin;
        }
        if ((i & 2) != 0) {
            str = answerResult.timeText;
        }
        if ((i & 4) != 0) {
            answerError = answerResult.error;
        }
        return answerResult.copy(d, str, answerError);
    }

    public final double component1() {
        return this.coin;
    }

    public final String component2() {
        return this.timeText;
    }

    public final AnswerError component3() {
        return this.error;
    }

    public final AnswerResult copy(double d, String str, AnswerError answerError) {
        return new AnswerResult(d, str, answerError);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r4.error, (java.lang.Object) r5.error) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        if (r4 == r5) goto L_0x0029
        boolean r0 = r5 instanceof com.jiayouya.travel.module.answer.data.AnswerResult
        if (r0 == 0) goto L_0x0027
        com.jiayouya.travel.module.answer.data.AnswerResult r5 = (com.jiayouya.travel.module.answer.data.AnswerResult) r5
        double r0 = r4.coin
        double r2 = r5.coin
        int r0 = java.lang.Double.compare(r0, r2)
        if (r0 != 0) goto L_0x0027
        java.lang.String r0 = r4.timeText
        java.lang.String r1 = r5.timeText
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0027
        com.jiayouya.travel.module.answer.data.AnswerError r0 = r4.error
        com.jiayouya.travel.module.answer.data.AnswerError r5 = r5.error
        boolean r5 = kotlin.jvm.internal.C8271i.m35384a(r0, r5)
        if (r5 == 0) goto L_0x0027
        goto L_0x0029
    L_0x0027:
        r5 = 0
        return r5
    L_0x0029:
        r5 = 1
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.answer.data.AnswerResult.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.coin);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        String str = this.timeText;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        AnswerError answerError = this.error;
        if (answerError != null) {
            i2 = answerError.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnswerResult(coin=");
        sb.append(this.coin);
        sb.append(", timeText=");
        sb.append(this.timeText);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C8271i.m35386b(parcel, "parcel");
        parcel.writeDouble(this.coin);
        parcel.writeString(this.timeText);
        AnswerError answerError = this.error;
        if (answerError != null) {
            parcel.writeInt(1);
            answerError.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public AnswerResult(double d, String str, AnswerError answerError) {
        this.coin = d;
        this.timeText = str;
        this.error = answerError;
    }

    public final double getCoin() {
        return this.coin;
    }

    public final AnswerError getError() {
        return this.error;
    }

    public final String getTimeText() {
        return this.timeText;
    }
}
