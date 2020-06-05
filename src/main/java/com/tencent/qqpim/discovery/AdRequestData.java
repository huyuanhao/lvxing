package com.tencent.qqpim.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class AdRequestData implements Parcelable {
    public static final int CACHE_NORMAL = 4;
    public static final Creator<AdRequestData> CREATOR = new Creator<AdRequestData>() {
        public AdRequestData createFromParcel(Parcel parcel) {
            return new AdRequestData(parcel);
        }

        public AdRequestData[] newArray(int i) {
            return new AdRequestData[i];
        }
    };
    public static final int NORMAL = 0;
    public static final int NORMAL_CACHEFIRST = 1;
    public static final int ONLYCACHE = 2;
    public static final int ONLYNETWORK = 3;
    public int advNum;
    @Deprecated
    public boolean autoLoadPicEnable;
    public boolean includePrepullAd;
    public boolean mustMaterialPrepared;
    public int pos_height;
    public int pos_width;
    public ArrayList<Integer> positionFormatTypes;
    public int positionId;
    /* renamed from: ua */
    public String f25046ua;

    public AdRequestData() {
        this.pos_width = -1;
        this.pos_height = -1;
        this.f25046ua = null;
        this.autoLoadPicEnable = false;
        this.mustMaterialPrepared = false;
        this.includePrepullAd = false;
    }

    AdRequestData(Parcel parcel) {
        this.pos_width = -1;
        this.pos_height = -1;
        this.f25046ua = null;
        boolean z = false;
        this.autoLoadPicEnable = false;
        this.mustMaterialPrepared = false;
        this.includePrepullAd = false;
        this.positionId = parcel.readInt();
        this.advNum = parcel.readInt();
        this.positionFormatTypes = parcel.readArrayList(Integer.class.getClassLoader());
        this.autoLoadPicEnable = parcel.readByte() != 1;
        this.mustMaterialPrepared = parcel.readByte() != 1;
        if (parcel.readByte() != 1) {
            z = true;
        }
        this.includePrepullAd = z;
        this.pos_width = parcel.readInt();
        this.pos_height = parcel.readInt();
        this.f25046ua = parcel.readString();
    }

    /* access modifiers changed from: protected */
    public AdRequestData clone() {
        AdRequestData adRequestData = new AdRequestData();
        adRequestData.positionId = this.positionId;
        adRequestData.advNum = this.advNum;
        adRequestData.positionFormatTypes = (ArrayList) this.positionFormatTypes.clone();
        adRequestData.autoLoadPicEnable = this.autoLoadPicEnable;
        adRequestData.mustMaterialPrepared = this.mustMaterialPrepared;
        adRequestData.includePrepullAd = this.includePrepullAd;
        adRequestData.pos_height = this.pos_height;
        adRequestData.pos_width = this.pos_width;
        adRequestData.f25046ua = this.f25046ua;
        return adRequestData;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdRequestData [positionId=");
        sb.append(this.positionId);
        sb.append(", advNum=");
        sb.append(this.advNum);
        sb.append(", positionFormatTypes=");
        sb.append(this.positionFormatTypes);
        sb.append(", autoLoadPicEnable=");
        sb.append(this.autoLoadPicEnable);
        sb.append(", mustMaterialPrepared=");
        sb.append(this.mustMaterialPrepared);
        sb.append(", includePrepullAd=");
        sb.append(this.includePrepullAd);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.positionId);
        parcel.writeInt(this.advNum);
        parcel.writeList(this.positionFormatTypes);
        parcel.writeByte(this.autoLoadPicEnable ^ true ? (byte) 1 : 0);
        parcel.writeByte(this.mustMaterialPrepared ^ true ? (byte) 1 : 0);
        parcel.writeByte(this.includePrepullAd ^ true ? (byte) 1 : 0);
        parcel.writeInt(this.pos_width);
        parcel.writeInt(this.pos_height);
        parcel.writeString(this.f25046ua);
    }
}
