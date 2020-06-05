package com.tencent.p605ep.common.adapt.iservice.account;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.tencent.ep.common.adapt.iservice.account.AccountInfo */
public class AccountInfo implements Parcelable {
    public static final Creator<AccountInfo> CREATOR = new Creator<AccountInfo>() {
        public AccountInfo createFromParcel(Parcel parcel) {
            return new AccountInfo(parcel);
        }

        public AccountInfo[] newArray(int i) {
            return new AccountInfo[i];
        }
    };
    public boolean bound;
    public String name;
    public String open_id;
    public int status;
    public int type;
    public String union_id;
    public String user_id;

    public AccountInfo() {
    }

    AccountInfo(Parcel parcel) {
        this.type = parcel.readInt();
        boolean z = true;
        if (parcel.readInt() == 1) {
            this.user_id = parcel.readString();
        }
        if (parcel.readInt() == 1) {
            this.open_id = parcel.readString();
        }
        if (parcel.readInt() == 1) {
            this.union_id = parcel.readString();
        }
        if (parcel.readInt() == 1) {
            this.name = parcel.readString();
        }
        this.status = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.bound = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        if (this.user_id != null) {
            parcel.writeInt(1);
            parcel.writeString(this.user_id);
        } else {
            parcel.writeInt(0);
        }
        if (this.open_id != null) {
            parcel.writeInt(1);
            parcel.writeString(this.open_id);
        } else {
            parcel.writeInt(0);
        }
        if (this.union_id != null) {
            parcel.writeInt(1);
            parcel.writeString(this.union_id);
        } else {
            parcel.writeInt(0);
        }
        if (this.name != null) {
            parcel.writeInt(1);
            parcel.writeString(this.name);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.status);
        parcel.writeInt(this.bound);
    }
}
