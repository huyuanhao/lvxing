package com.p368pw.p392us;

import android.view.View;

/* renamed from: com.pw.us.ISplashAdListener */
public interface ISplashAdListener {
    void onClicked();

    void onDownloadFinished(String str, String str2);

    void onDownloadStarted(String str);

    void onError(String str);

    void onInstalled(String str, String str2);

    void onLoaded(View view, Setting setting);

    void onShowed();

    void onSkip();

    void onTimeOver();
}
