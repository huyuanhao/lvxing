package com.kwad.sdk.core.download;

import com.kwad.sdk.core.response.model.AdInfo;
import java.io.Serializable;

public class DownloadParams implements Serializable {
    private static final long serialVersionUID = -4966891183505507851L;
    public int downloadPlace = 1;
    public String mAppIcon;
    public String mAppName;
    public long mAppSize;
    public String mDownloadid;
    public String mFileMd5;
    public String mFileUrl;
    public String mPkgname;
    public String mShortDesc;
    public String mVersion;
    public String mVersionCode;

    public static DownloadParams transfrom(AdInfo adInfo) {
        DownloadParams downloadParams = new DownloadParams();
        downloadParams.mDownloadid = adInfo.downloadId;
        downloadParams.mAppName = adInfo.adBaseInfo.appName;
        downloadParams.mPkgname = adInfo.adBaseInfo.appPackageName;
        downloadParams.mFileUrl = adInfo.adConversionInfo.appDownloadUrl;
        downloadParams.mAppIcon = adInfo.adBaseInfo.appIconUrl;
        downloadParams.mShortDesc = adInfo.adBaseInfo.adDescription;
        return downloadParams;
    }
}
