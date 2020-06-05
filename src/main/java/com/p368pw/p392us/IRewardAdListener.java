package com.p368pw.p392us;

/* renamed from: com.pw.us.IRewardAdListener */
public interface IRewardAdListener {
    void onClosed();

    void onDownloadFinished(String str, String str2);

    void onDownloadStarted(String str);

    void onError(String str);

    void onInstalled(String str, String str2);

    void onLoaded(Setting setting);

    void onShowed();

    void onVideoComplete();
}
