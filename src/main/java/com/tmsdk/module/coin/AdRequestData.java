package com.tmsdk.module.coin;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tmsdk.module.coin.AdConfig.BUSINESS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AdRequestData implements Parcelable {
    public static final int CACHE_NORMAL = 4;
    public static final Creator<AdRequestData> CREATOR = new Creator<AdRequestData>() {
        /* renamed from: a */
        public AdRequestData createFromParcel(Parcel parcel) {
            return new AdRequestData(parcel);
        }

        /* renamed from: a */
        public AdRequestData[] newArray(int i) {
            return new AdRequestData[i];
        }
    };
    public static final int NET_CACHE = 5;
    public static final int NORMAL = 0;
    public static final int NORMAL_CACHEFIRST = 1;
    public static final int ONLYCACHE = 2;
    public static final int ONLYNETWORK = 3;
    public Map<Integer, String> additionalParam;
    public String advKeyWord;
    public int advNum;
    @Deprecated
    public boolean autoLoadPicEnable;
    public BUSINESS business;
    public int businessType;
    public boolean includePrepullAd;
    public double latitude;
    public double longitude;
    public boolean mustMaterialPrepared;
    public ArrayList<Integer> positionFormatTypes;
    public int positionId;
    public int requestId;

    public AdRequestData() {
        this.advKeyWord = "";
        this.businessType = 0;
        this.additionalParam = new HashMap();
        this.autoLoadPicEnable = false;
        this.mustMaterialPrepared = false;
        this.includePrepullAd = false;
        this.latitude = -1.0d;
        this.longitude = -1.0d;
    }

    AdRequestData(Parcel parcel) {
        this.advKeyWord = "";
        boolean z = false;
        this.businessType = 0;
        this.additionalParam = new HashMap();
        this.autoLoadPicEnable = false;
        this.mustMaterialPrepared = false;
        this.includePrepullAd = false;
        this.latitude = -1.0d;
        this.longitude = -1.0d;
        this.requestId = parcel.readInt();
        this.positionId = parcel.readInt();
        this.advNum = parcel.readInt();
        this.positionFormatTypes = parcel.readArrayList(Integer.class.getClassLoader());
        this.advKeyWord = parcel.readString();
        this.businessType = parcel.readInt();
        this.additionalParam = parcel.readHashMap(HashMap.class.getClassLoader());
        this.autoLoadPicEnable = parcel.readByte() != 1;
        this.mustMaterialPrepared = parcel.readByte() != 1;
        if (parcel.readByte() != 1) {
            z = true;
        }
        this.includePrepullAd = z;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdRequestData [requestId=");
        sb.append(this.requestId);
        sb.append(", positionId=");
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

    public void updateRequestId() {
        int i;
        int i2 = ((527 + this.positionId) * 31) + this.advNum;
        try {
            if (this.additionalParam.size() > 0) {
                for (Entry value : this.additionalParam.entrySet()) {
                    for (char c : ((String) value.getValue()).toCharArray()) {
                        i2 += c * 31;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.requestId = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.requestId);
        parcel.writeInt(this.positionId);
        parcel.writeInt(this.advNum);
        parcel.writeList(this.positionFormatTypes);
        parcel.writeString(this.advKeyWord);
        parcel.writeInt(this.businessType);
        parcel.writeMap(this.additionalParam);
        parcel.writeByte(this.autoLoadPicEnable ^ true ? (byte) 1 : 0);
        parcel.writeByte(this.mustMaterialPrepared ^ true ? (byte) 1 : 0);
        parcel.writeByte(this.includePrepullAd ^ true ? (byte) 1 : 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public AdRequestData clone() {
        AdRequestData adRequestData = new AdRequestData();
        adRequestData.requestId = this.requestId;
        adRequestData.positionId = this.positionId;
        adRequestData.advNum = this.advNum;
        adRequestData.positionFormatTypes = (ArrayList) this.positionFormatTypes.clone();
        adRequestData.advKeyWord = this.advKeyWord;
        adRequestData.businessType = this.businessType;
        adRequestData.additionalParam.putAll(this.additionalParam);
        adRequestData.autoLoadPicEnable = this.autoLoadPicEnable;
        adRequestData.mustMaterialPrepared = this.mustMaterialPrepared;
        adRequestData.includePrepullAd = this.includePrepullAd;
        return adRequestData;
    }
}
