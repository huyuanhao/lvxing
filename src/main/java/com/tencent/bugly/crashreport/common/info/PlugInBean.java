package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: BUGLY */
public class PlugInBean implements Parcelable {
    public static final Creator<PlugInBean> CREATOR = new Creator<PlugInBean>() {
        /* renamed from: a */
        public PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        /* renamed from: a */
        public PlugInBean[] newArray(int i) {
            return new PlugInBean[i];
        }
    };
    /* renamed from: a */
    public final String f23959a;
    /* renamed from: b */
    public final String f23960b;
    /* renamed from: c */
    public final String f23961c;

    public int describeContents() {
        return 0;
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f23959a = str;
        this.f23960b = str2;
        this.f23961c = str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("plid:");
        sb.append(this.f23959a);
        sb.append(" plV:");
        sb.append(this.f23960b);
        sb.append(" plUUID:");
        sb.append(this.f23961c);
        return sb.toString();
    }

    public PlugInBean(Parcel parcel) {
        this.f23959a = parcel.readString();
        this.f23960b = parcel.readString();
        this.f23961c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f23959a);
        parcel.writeString(this.f23960b);
        parcel.writeString(this.f23961c);
    }
}
