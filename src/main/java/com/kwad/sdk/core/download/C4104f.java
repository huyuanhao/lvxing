package com.kwad.sdk.core.download;

import android.content.Context;
import android.os.Environment;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.export.proxy.AdDownloadProxy;

/* renamed from: com.kwad.sdk.core.download.f */
public class C4104f {
    /* renamed from: a */
    private static final String f13763a;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append("/downloadFileSync/.temp");
        f13763a = sb.toString();
    }

    /* renamed from: a */
    public static void m17050a(Context context, AdInfo adInfo) {
        AdDownloadProxy proxyForDownload = KsAdSDK.getProxyForDownload();
        if (proxyForDownload != null) {
            DownloadParams transfrom = DownloadParams.transfrom(adInfo);
            proxyForDownload.startDownload(context, transfrom.mDownloadid, transfrom);
        }
    }
}
