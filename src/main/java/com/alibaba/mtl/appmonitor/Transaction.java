package com.alibaba.mtl.appmonitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import java.util.Map;

public class Transaction implements Parcelable {
    public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
        /* renamed from: a */
        public Transaction createFromParcel(Parcel parcel) {
            return Transaction.m3278a(parcel);
        }

        /* renamed from: a */
        public Transaction[] newArray(int i) {
            return new Transaction[i];
        }
    };
    /* renamed from: a */
    protected Integer f3087a;
    /* renamed from: b */
    protected String f3088b;
    /* renamed from: c */
    protected String f3089c;
    /* renamed from: d */
    protected DimensionValueSet f3090d;
    /* renamed from: e */
    protected String f3091e;
    /* renamed from: f */
    protected Map<String, String> f3092f;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3090d, i);
        parcel.writeInt(this.f3087a.intValue());
        parcel.writeString(this.f3088b);
        parcel.writeString(this.f3089c);
        parcel.writeString(this.f3091e);
        parcel.writeMap(this.f3092f);
    }

    /* renamed from: a */
    static Transaction m3278a(Parcel parcel) {
        Class<Transaction> cls = Transaction.class;
        Transaction transaction = new Transaction();
        try {
            transaction.f3090d = (DimensionValueSet) parcel.readParcelable(cls.getClassLoader());
            transaction.f3087a = Integer.valueOf(parcel.readInt());
            transaction.f3088b = parcel.readString();
            transaction.f3089c = parcel.readString();
            transaction.f3091e = parcel.readString();
            transaction.f3092f = parcel.readHashMap(cls.getClassLoader());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return transaction;
    }
}
