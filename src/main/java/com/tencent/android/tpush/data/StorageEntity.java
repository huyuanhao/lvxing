package com.tencent.android.tpush.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public class StorageEntity implements Parcelable {
    public static final Creator<StorageEntity> CREATOR = new Creator<StorageEntity>() {
        /* renamed from: a */
        public StorageEntity createFromParcel(Parcel parcel) {
            return new StorageEntity(parcel);
        }

        /* renamed from: a */
        public StorageEntity[] newArray(int i) {
            return new StorageEntity[i];
        }
    };
    /* renamed from: a */
    public String f23016a = "";
    /* renamed from: b */
    public int f23017b = -1;
    /* renamed from: c */
    public boolean f23018c;
    /* renamed from: d */
    public String f23019d;
    /* renamed from: e */
    public int f23020e;
    /* renamed from: f */
    public float f23021f;
    /* renamed from: g */
    public long f23022g;

    public int describeContents() {
        return 0;
    }

    public StorageEntity() {
    }

    public StorageEntity(Parcel parcel) {
        m29581a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f23016a);
        parcel.writeInt(this.f23017b);
        parcel.writeByte(this.f23018c);
        parcel.writeString(this.f23019d);
        parcel.writeInt(this.f23020e);
        parcel.writeFloat(this.f23021f);
        parcel.writeLong(this.f23022g);
    }

    /* renamed from: a */
    private void m29581a(Parcel parcel) {
        this.f23016a = parcel.readString();
        this.f23017b = parcel.readInt();
        boolean z = true;
        if (parcel.readByte() != 1) {
            z = false;
        }
        this.f23018c = z;
        this.f23019d = parcel.readString();
        this.f23020e = parcel.readInt();
        this.f23021f = parcel.readFloat();
        this.f23022g = parcel.readLong();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StorageEntity[key:");
        sb.append(this.f23016a);
        sb.append(",type:");
        sb.append(this.f23017b);
        sb.append(",strValue:");
        sb.append(this.f23019d);
        sb.append(",boolValue:");
        sb.append(this.f23018c);
        sb.append(",intValue");
        sb.append(this.f23020e);
        sb.append(",floatValue:");
        sb.append(this.f23021f);
        sb.append(",longValue:");
        sb.append(this.f23022g);
        sb.append("]");
        return sb.toString();
    }
}
