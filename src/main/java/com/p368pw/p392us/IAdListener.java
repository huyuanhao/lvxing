package com.p368pw.p392us;

/* renamed from: com.pw.us.IAdListener */
public interface IAdListener {
    void onClicked();

    void onDownloadFinished(String str);

    void onDownloadStarted();

    void onError(String str);

    void onInstalled();

    void onLoaded(AdInfo adInfo, Setting setting);

    void onShowed();
}
