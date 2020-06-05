package com.tencent.qqpim.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qqpim.discovery.ADReporter.OuterReportMetaData;
import com.tencent.qqpim.discovery.internal.model.ClickDataModel;
import java.util.ArrayList;

public class AdDisplayModel implements Parcelable {
    public static final Creator<AdDisplayModel> CREATOR = new Creator<AdDisplayModel>() {
        public AdDisplayModel createFromParcel(Parcel parcel) {
            return new AdDisplayModel(parcel);
        }

        public AdDisplayModel[] newArray(int i) {
            return new AdDisplayModel[i];
        }
    };
    public String appDownloadUrl;
    public ClickDataModel cModel;
    public String channelId;
    public int continuousExposureTime;
    public int effectiveTime;
    public int exposureInterval;
    public String imageUrl1;
    public String imageUrl2;
    public String imageUrl3;
    public ArrayList<String> imgList;
    public String imgMd5;
    public boolean isAutoAppDownload;
    public boolean isDeepLink;
    public int isneedGuide;
    public String jumpUrl;
    public boolean jumpurlenable;
    public AdJumpInfo mAdJumpInfo;
    public String notifyContent;
    public int notifyInterval;
    public String packageName;
    public int percentSpent;
    public int positionId;
    public long predisplaytime;
    public OuterReportMetaData reportMetaData;
    public int scenes;
    public boolean sdkADRequest = false;
    public String sdkParamappid;
    public String sdkPosId;
    public int sdkType = 0;
    public int sdkgdtPosAmount;
    public int sdkgdtrequestTimeout;
    public int templateType;
    public String text1;
    public String text2;
    public String text3;
    public String text4;
    public String uniqueKey;
    public String videoMd5;
    public String videoUrl;
    public String zipMd5;
    public String zipUrl;

    public AdDisplayModel() {
        String str = "";
        this.sdkParamappid = str;
        this.sdkPosId = str;
        this.sdkgdtPosAmount = 0;
        this.sdkgdtrequestTimeout = 0;
        this.isneedGuide = 0;
        this.positionId = 0;
        this.notifyInterval = 0;
        this.notifyContent = str;
        this.percentSpent = 0;
        this.effectiveTime = 0;
        this.continuousExposureTime = 0;
        this.exposureInterval = 0;
        this.jumpurlenable = true;
        this.imgList = null;
        this.cModel = null;
        this.mAdJumpInfo = new AdJumpInfo();
        this.reportMetaData = new OuterReportMetaData();
    }

    AdDisplayModel(Parcel parcel) {
        boolean z = false;
        String str = "";
        this.sdkParamappid = str;
        this.sdkPosId = str;
        this.sdkgdtPosAmount = 0;
        this.sdkgdtrequestTimeout = 0;
        this.isneedGuide = 0;
        this.positionId = 0;
        this.notifyInterval = 0;
        this.notifyContent = str;
        this.percentSpent = 0;
        this.effectiveTime = 0;
        this.continuousExposureTime = 0;
        this.exposureInterval = 0;
        this.jumpurlenable = true;
        this.imgList = null;
        this.cModel = null;
        this.mAdJumpInfo = new AdJumpInfo();
        this.reportMetaData = new OuterReportMetaData();
        this.isneedGuide = parcel.readInt();
        this.positionId = parcel.readInt();
        this.templateType = parcel.readInt();
        this.text1 = parcel.readString();
        this.text2 = parcel.readString();
        this.text3 = parcel.readString();
        this.text4 = parcel.readString();
        this.imageUrl1 = parcel.readString();
        this.imageUrl2 = parcel.readString();
        this.imageUrl3 = parcel.readString();
        this.notifyInterval = parcel.readInt();
        this.notifyContent = parcel.readString();
        this.uniqueKey = parcel.readString();
        this.percentSpent = parcel.readInt();
        this.effectiveTime = parcel.readInt();
        this.continuousExposureTime = parcel.readInt();
        this.exposureInterval = parcel.readInt();
        this.scenes = parcel.readInt();
        this.jumpurlenable = parcel.readByte() != 0;
        this.predisplaytime = parcel.readLong();
        this.videoUrl = parcel.readString();
        this.imgMd5 = parcel.readString();
        this.videoMd5 = parcel.readString();
        this.zipUrl = parcel.readString();
        this.zipMd5 = parcel.readString();
        this.isAutoAppDownload = parcel.readByte() == 0;
        this.jumpUrl = parcel.readString();
        this.appDownloadUrl = parcel.readString();
        this.packageName = parcel.readString();
        this.isDeepLink = parcel.readByte() == 1;
        this.channelId = parcel.readString();
        this.imgList = parcel.readArrayList(String.class.getClassLoader());
        if (parcel.readByte() == 1) {
            z = true;
        }
        this.sdkADRequest = z;
        this.sdkType = parcel.readInt();
        this.sdkParamappid = parcel.readString();
        this.sdkPosId = parcel.readString();
        this.sdkgdtPosAmount = parcel.readInt();
        this.sdkgdtrequestTimeout = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public boolean isJumpUrlEnable() {
        return this.jumpurlenable;
    }

    public void setJumpUrlEnable(boolean z) {
        this.jumpurlenable = z;
    }

    public String toSDKString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdDisplayModel sdkType=");
        sb.append(this.sdkType);
        sb.append(" ，sdkParamappid=");
        sb.append(this.sdkParamappid);
        sb.append(" ，sdkPosId=");
        sb.append(this.sdkPosId);
        sb.append(" ，sdkgdtPosAmount=");
        sb.append(this.sdkgdtPosAmount);
        sb.append(" ，sdkgdtrequestTimeout=");
        sb.append(this.sdkgdtrequestTimeout);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdDisplayModel [isneedGuide=");
        sb.append(this.isneedGuide);
        sb.append(", positionId=");
        sb.append(this.positionId);
        sb.append(", templateType=");
        sb.append(this.templateType);
        sb.append(", text1=");
        sb.append(this.text1);
        sb.append(", text2=");
        sb.append(this.text2);
        sb.append(", text3=");
        sb.append(this.text3);
        sb.append(", text4=");
        sb.append(this.text4);
        sb.append(", imageUrl1=");
        sb.append(this.imageUrl1);
        sb.append(", imageUrl2=");
        sb.append(this.imageUrl2);
        sb.append(", imageUrl3=");
        sb.append(this.imageUrl3);
        sb.append(", notifyInterval=");
        sb.append(this.notifyInterval);
        sb.append(", notifyContent=");
        sb.append(this.notifyContent);
        sb.append(", uniqueKey=");
        sb.append(this.uniqueKey);
        sb.append(", percentSpent=");
        sb.append(this.percentSpent);
        sb.append(", effectiveTime=");
        sb.append(this.effectiveTime);
        sb.append(", continuousExposureTime=");
        sb.append(this.continuousExposureTime);
        sb.append(", exposureInterval=");
        sb.append(this.exposureInterval);
        sb.append(", scenes=");
        sb.append(this.scenes);
        sb.append(", jumpurlenable=");
        sb.append(this.jumpurlenable);
        sb.append(", predisplaytime=");
        sb.append(this.predisplaytime);
        sb.append(", videoUrl=");
        sb.append(this.videoUrl);
        sb.append(", imgMd5=");
        sb.append(this.imgMd5);
        sb.append(", videoMd5=");
        sb.append(this.videoMd5);
        sb.append(", zipMd5=");
        sb.append(this.zipMd5);
        sb.append(", zipUrl=");
        sb.append(this.zipUrl);
        sb.append(", packageName=");
        sb.append(this.packageName);
        sb.append(", isAutoAppDownload=");
        sb.append(this.isAutoAppDownload);
        sb.append(", jumpUrl=");
        sb.append(this.jumpUrl);
        sb.append(", appDownloadUrl=");
        sb.append(this.appDownloadUrl);
        sb.append(", isDeepLink=");
        sb.append(this.isDeepLink);
        sb.append(", channelId=");
        sb.append(this.channelId);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.isneedGuide);
        parcel.writeInt(this.positionId);
        parcel.writeInt(this.templateType);
        parcel.writeString(this.text1);
        parcel.writeString(this.text2);
        parcel.writeString(this.text3);
        parcel.writeString(this.text4);
        parcel.writeString(this.imageUrl1);
        parcel.writeString(this.imageUrl2);
        parcel.writeString(this.imageUrl3);
        parcel.writeInt(this.notifyInterval);
        parcel.writeString(this.notifyContent);
        parcel.writeString(this.uniqueKey);
        parcel.writeInt(this.percentSpent);
        parcel.writeInt(this.effectiveTime);
        parcel.writeInt(this.continuousExposureTime);
        parcel.writeInt(this.exposureInterval);
        parcel.writeInt(this.scenes);
        parcel.writeByte(this.jumpurlenable ? (byte) 1 : 0);
        parcel.writeLong(this.predisplaytime);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.imgMd5);
        parcel.writeString(this.videoMd5);
        parcel.writeString(this.zipUrl);
        parcel.writeString(this.zipMd5);
        parcel.writeByte(this.isAutoAppDownload ^ true ? (byte) 1 : 0);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.appDownloadUrl);
        parcel.writeString(this.packageName);
        parcel.writeByte(this.isDeepLink ? (byte) 1 : 0);
        parcel.writeString(this.channelId);
        parcel.writeList(this.imgList);
        parcel.writeByte(this.sdkADRequest ? (byte) 1 : 0);
        parcel.writeInt(this.sdkType);
        parcel.writeString(this.sdkParamappid);
        parcel.writeString(this.sdkPosId);
        parcel.writeInt(this.sdkgdtPosAmount);
        parcel.writeInt(this.sdkgdtrequestTimeout);
    }
}
