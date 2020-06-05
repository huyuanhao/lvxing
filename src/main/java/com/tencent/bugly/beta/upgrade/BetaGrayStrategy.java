package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.proguard.C7216ah;
import com.tencent.bugly.proguard.C7267m;
import com.tencent.bugly.proguard.C7282y;

/* compiled from: BUGLY */
public class BetaGrayStrategy implements Parcelable, Creator<BetaGrayStrategy> {
    public static final Creator<BetaGrayStrategy> CREATOR = new BetaGrayStrategy();
    /* renamed from: a */
    public C7282y f23818a;
    /* renamed from: b */
    public int f23819b = 0;
    /* renamed from: c */
    public long f23820c = -1;
    /* renamed from: d */
    public boolean f23821d = false;
    /* renamed from: e */
    public long f23822e = -1;

    public int describeContents() {
        return 0;
    }

    public BetaGrayStrategy(Parcel parcel) {
        boolean z = false;
        this.f23818a = (C7282y) C7216ah.m31077a(parcel.createByteArray(), C7282y.class);
        this.f23819b = parcel.readInt();
        this.f23820c = parcel.readLong();
        if (1 == parcel.readByte()) {
            z = true;
        }
        this.f23821d = z;
        this.f23822e = parcel.readLong();
    }

    public BetaGrayStrategy() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(C7216ah.m31078a((C7267m) this.f23818a));
        parcel.writeInt(this.f23819b);
        parcel.writeLong(this.f23820c);
        parcel.writeByte(this.f23821d ? (byte) 1 : 0);
        parcel.writeLong(this.f23822e);
    }

    /* renamed from: a */
    public BetaGrayStrategy createFromParcel(Parcel parcel) {
        return new BetaGrayStrategy(parcel);
    }

    /* renamed from: a */
    public BetaGrayStrategy[] newArray(int i) {
        return new BetaGrayStrategy[i];
    }
}
