package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Dimension implements Parcelable {
    public static final Creator<Dimension> CREATOR = new Creator<Dimension>() {
        /* renamed from: a */
        public Dimension createFromParcel(Parcel parcel) {
            return Dimension.m3604a(parcel);
        }

        /* renamed from: a */
        public Dimension[] newArray(int i) {
            return new Dimension[i];
        }
    };
    /* renamed from: a */
    protected String f3245a;
    /* renamed from: b */
    protected String f3246b;

    public int describeContents() {
        return 0;
    }

    public Dimension() {
        this.f3246b = "null";
    }

    public Dimension(String str, String str2) {
        String str3 = "null";
        this.f3246b = str3;
        this.f3245a = str;
        if (str2 == null) {
            str2 = str3;
        }
        this.f3246b = str2;
    }

    /* renamed from: a */
    public String mo11666a() {
        return this.f3245a;
    }

    /* renamed from: b */
    public String mo11667b() {
        return this.f3246b;
    }

    public int hashCode() {
        String str = this.f3245a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dimension dimension = (Dimension) obj;
        String str = this.f3245a;
        if (str == null) {
            if (dimension.f3245a != null) {
                return false;
            }
        } else if (!str.equals(dimension.f3245a)) {
            return false;
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3246b);
        parcel.writeString(this.f3245a);
    }

    /* renamed from: a */
    static Dimension m3604a(Parcel parcel) {
        try {
            return new Dimension(parcel.readString(), parcel.readString());
        } catch (Throwable unused) {
            return null;
        }
    }
}
