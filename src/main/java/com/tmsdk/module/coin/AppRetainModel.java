package com.tmsdk.module.coin;

public class AppRetainModel {
    public static final int downloadComplete = 1;
    public static final int installed = 2;
    public String apkInstallPath;
    public String appName;
    public int clickNum;
    public long downloadOrInstallTime;
    public long lastClickTime;
    public String mBigPicUrl;
    public String mBtnText;
    public String mDownloadUrl;
    public String mFullScreenPicUrl;
    public String mIconUrl;
    public String mJumpUrl;
    public String mMainTitle;
    public String mSubTitle;
    public int mTaskType;
    public String mThreePicUrl;
    public String mUniqueKey;
    public String mVideoUrl;
    public int status;
    public int version = 0;

    /* renamed from: com.tmsdk.module.coin.AppRetainModel$AD_TYPE */
    public enum AD_TYPE {
        H5,
        APP
    }

    public AppRetainModel(long j, String str, int i, String str2, String str3, int i2) {
        this.downloadOrInstallTime = j;
        this.appName = str;
        this.mTaskType = i;
        this.mUniqueKey = str2;
        this.apkInstallPath = str3;
        this.status = i2;
    }

    public AppRetainModel(long j, String str, int i, String str2, String str3, int i2, String str4, String str5, String str6) {
        this.downloadOrInstallTime = j;
        this.appName = str;
        this.mTaskType = i;
        this.mUniqueKey = str2;
        this.apkInstallPath = str3;
        this.status = i2;
        this.mMainTitle = str4;
        this.mBtnText = str5;
        this.mIconUrl = str6;
    }
}
