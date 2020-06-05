package com.tencent.p605ep.common.adapt.iservice.account;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.tencent.ep.common.adapt.iservice.account.MainAccountInfo */
public class MainAccountInfo implements Parcelable {
    public static final Creator<MainAccountInfo> CREATOR = new Creator<MainAccountInfo>() {
        public MainAccountInfo createFromParcel(Parcel parcel) {
            return new MainAccountInfo(parcel);
        }

        public MainAccountInfo[] newArray(int i) {
            return new MainAccountInfo[i];
        }
    };
    public long account_id;
    public String mobile;
    /* renamed from: qq */
    public AccountInfo f24688qq;
    public AccountInfo qqpim;
    public String token;
    /* renamed from: wx */
    public AccountInfo f24689wx;

    public MainAccountInfo() {
    }

    private MainAccountInfo(Parcel parcel) {
        this.account_id = parcel.readLong();
        if (parcel.readInt() == 1) {
            this.f24688qq = new AccountInfo(parcel);
        }
        if (parcel.readInt() == 1) {
            this.f24689wx = new AccountInfo(parcel);
        }
        if (parcel.readInt() == 1) {
            this.qqpim = new AccountInfo(parcel);
        }
        if (parcel.readInt() == 1) {
            this.mobile = parcel.readString();
        }
        if (parcel.readInt() == 1) {
            this.token = parcel.readString();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.account_id);
        if (this.f24688qq != null) {
            parcel.writeInt(1);
            this.f24688qq.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.f24689wx != null) {
            parcel.writeInt(1);
            this.f24689wx.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.qqpim != null) {
            parcel.writeInt(1);
            this.qqpim.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.mobile != null) {
            parcel.writeInt(1);
            parcel.writeString(this.mobile);
        } else {
            parcel.writeInt(0);
        }
        if (this.token != null) {
            parcel.writeInt(1);
            parcel.writeString(this.token);
            return;
        }
        parcel.writeInt(0);
    }
}
