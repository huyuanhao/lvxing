package com.yanzhenjie.durban.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AspectRatio implements Parcelable {
    public static final Creator<AspectRatio> CREATOR = new Creator<AspectRatio>() {
        /* renamed from: a */
        public AspectRatio createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        /* renamed from: a */
        public AspectRatio[] newArray(int i) {
            return new AspectRatio[i];
        }
    };
    /* renamed from: a */
    private final String f26495a;
    /* renamed from: b */
    private final float f26496b;
    /* renamed from: c */
    private final float f26497c;

    public int describeContents() {
        return 0;
    }

    protected AspectRatio(Parcel parcel) {
        this.f26495a = parcel.readString();
        this.f26496b = parcel.readFloat();
        this.f26497c = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26495a);
        parcel.writeFloat(this.f26496b);
        parcel.writeFloat(this.f26497c);
    }
}
