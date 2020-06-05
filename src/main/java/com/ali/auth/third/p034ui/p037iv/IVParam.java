package com.ali.auth.third.p034ui.p037iv;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.ali.auth.third.ui.iv.IVParam */
public class IVParam implements Parcelable {
    public static final Creator<IVParam> CREATOR = new Creator<IVParam>() {
        /* renamed from: a */
        public IVParam createFromParcel(Parcel parcel) {
            return new IVParam(parcel);
        }

        /* renamed from: a */
        public IVParam[] newArray(int i) {
            return new IVParam[i];
        }
    };
    /* renamed from: a */
    public String f2181a;
    /* renamed from: b */
    public String f2182b;
    /* renamed from: c */
    public String f2183c;
    /* renamed from: d */
    public String f2184d;
    /* renamed from: e */
    public String f2185e;
    /* renamed from: f */
    public String f2186f;
    /* renamed from: g */
    public String f2187g;
    /* renamed from: h */
    public String f2188h;

    public IVParam() {
    }

    protected IVParam(Parcel parcel) {
        this.f2181a = parcel.readString();
        this.f2182b = parcel.readString();
        this.f2183c = parcel.readString();
        this.f2184d = parcel.readString();
        this.f2185e = parcel.readString();
        this.f2186f = parcel.readString();
        this.f2187g = parcel.readString();
        this.f2188h = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2181a);
        parcel.writeString(this.f2182b);
        parcel.writeString(this.f2183c);
        parcel.writeString(this.f2184d);
        parcel.writeString(this.f2185e);
        parcel.writeString(this.f2186f);
        parcel.writeString(this.f2187g);
        parcel.writeString(this.f2188h);
    }
}
