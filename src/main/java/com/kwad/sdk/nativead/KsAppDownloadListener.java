package com.kwad.sdk.nativead;

public interface KsAppDownloadListener {
    void onDownloadFinished();

    void onIdle();

    void onInstalled();

    void onProgressUpdate(int i);
}
