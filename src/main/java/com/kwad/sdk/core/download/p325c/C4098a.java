package com.kwad.sdk.core.download.p325c;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.download.C3603b;
import com.ksad.download.DownloadTask.DownloadRequest;
import com.ksad.download.p295a.C3602a;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.p306a.C3805h;
import java.io.File;

/* renamed from: com.kwad.sdk.core.download.c.a */
public class C4098a implements AdDownloadProxy {
    /* renamed from: a */
    private boolean f13757a;

    public C4098a(boolean z) {
        this.f13757a = z;
    }

    /* renamed from: a */
    private String m17026a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(C3805h.m15773a(str));
        sb.append(".apk");
        return sb.toString();
    }

    public void cancelDownload(Context context, String str, DownloadParams downloadParams) {
        C3602a.m15022b(context, str);
    }

    public String getDownloadFilePath(DownloadParams downloadParams) {
        if (TextUtils.isEmpty(downloadParams.mFileUrl)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C3603b.m15028b());
        sb.append(File.separator);
        sb.append(m17026a(downloadParams.mFileUrl));
        return sb.toString();
    }

    public void pauseDownload(Context context, String str, DownloadParams downloadParams) {
        C3602a.m15020a(context, str);
    }

    public void startDownload(Context context, String str, DownloadParams downloadParams) {
        DownloadRequest downloadRequest = new DownloadRequest(downloadParams.mFileUrl);
        downloadRequest.setDestinationFileName(m17026a(downloadParams.mFileUrl));
        downloadRequest.setTag(downloadParams);
        downloadRequest.setNotificationVisibility(this.f13757a ? 3 : 0);
        C3602a.m15021a(context, str, downloadRequest);
    }
}
