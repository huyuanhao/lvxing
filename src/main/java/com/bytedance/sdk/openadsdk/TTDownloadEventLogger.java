package com.bytedance.sdk.openadsdk;

import com.p530ss.android.p531a.p532a.p536c.DownloadEventModel;

public interface TTDownloadEventLogger {
    void onEvent(DownloadEventModel dVar);

    void onV3Event(DownloadEventModel dVar);

    boolean shouldFilterOpenSdkLog();
}
