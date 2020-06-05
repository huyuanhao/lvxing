package com.tencent.p605ep.common.adapt.iservice.vip;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.tencent.ep.common.adapt.iservice.vip.VIPInfo */
public class VIPInfo implements Parcelable {
    public static final Creator<VIPInfo> CREATOR = new Creator<VIPInfo>() {
        public VIPInfo createFromParcel(Parcel parcel) {
            return new VIPInfo(parcel);
        }

        public VIPInfo[] newArray(int i) {
            return new VIPInfo[i];
        }
    };
    public long endTime;
    public int errorCode;
    public int invitedUserCount;
    public boolean isVIP;
    public int maxInvitedCount;
    public boolean onceBuy;

    /* renamed from: com.tencent.ep.common.adapt.iservice.vip.VIPInfo$ErrorCode */
    public interface ErrorCode {
        public static final int FAIL = 3;
        public static final int LOGIN_OUT_OF_DATE = -1004;
        public static final int NONE = 0;
        public static final int UNLOGIN = 1;
    }

    public VIPInfo() {
    }

    protected VIPInfo(Parcel parcel) {
        this.errorCode = parcel.readInt();
        boolean z = true;
        this.isVIP = parcel.readByte() != 0;
        this.endTime = parcel.readLong();
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.onceBuy = z;
        this.invitedUserCount = parcel.readInt();
        this.maxInvitedCount = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VIPInfo{errorCode=");
        sb.append(this.errorCode);
        sb.append(", isVIP=");
        sb.append(this.isVIP);
        sb.append(", endTime=");
        sb.append(this.endTime);
        sb.append(", onceBuy=");
        sb.append(this.onceBuy);
        sb.append(", invitedUserCount=");
        sb.append(this.invitedUserCount);
        sb.append(", maxInvitedCount=");
        sb.append(this.maxInvitedCount);
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.errorCode);
        parcel.writeByte(this.isVIP);
        parcel.writeLong(this.endTime);
        parcel.writeByte(this.onceBuy);
        parcel.writeInt(this.invitedUserCount);
        parcel.writeInt(this.maxInvitedCount);
    }
}
