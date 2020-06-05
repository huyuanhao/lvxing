package com.kwad.sdk.core.download;

import com.ksad.download.C3605c;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.p306a.C3805h;

/* renamed from: com.kwad.sdk.core.download.b */
public class C4094b extends C3605c {
    /* renamed from: g */
    private String m16999g(DownloadTask downloadTask) {
        return C3805h.m15773a(downloadTask.getUrl());
    }

    /* renamed from: a */
    public void mo22703a(DownloadTask downloadTask) {
    }

    /* renamed from: a */
    public void mo22704a(DownloadTask downloadTask, int i, int i2) {
    }

    /* renamed from: a */
    public void mo22705a(DownloadTask downloadTask, String str, boolean z, int i, int i2) {
    }

    /* renamed from: a */
    public void mo22706a(DownloadTask downloadTask, Throwable th) {
        C4097c.m17023b(m16999g(downloadTask), 0);
    }

    /* renamed from: b */
    public void mo22707b(DownloadTask downloadTask) {
        C4097c.m17021a(m16999g(downloadTask), downloadTask.getTargetFilePath());
    }

    /* renamed from: b */
    public void mo22708b(DownloadTask downloadTask, int i, int i2) {
        C4097c.m17020a(m16999g(downloadTask), i2 > 0 ? (int) ((((float) i) * 100.0f) / ((float) i2)) : 0);
    }

    /* renamed from: c */
    public void mo22709c(DownloadTask downloadTask) {
        if (downloadTask.getSmallFileSoFarBytes() == 0) {
            C4097c.m17019a(m16999g(downloadTask));
        }
    }

    /* renamed from: c */
    public void mo22710c(DownloadTask downloadTask, int i, int i2) {
        C4097c.m17022b(m16999g(downloadTask));
    }

    /* renamed from: d */
    public void mo22711d(DownloadTask downloadTask) {
    }

    /* renamed from: d */
    public void mo22712d(DownloadTask downloadTask, int i, int i2) {
        C4097c.m17024c(m16999g(downloadTask));
    }

    /* renamed from: e */
    public void mo22713e(DownloadTask downloadTask) {
        C4097c.m17025d(m16999g(downloadTask));
    }

    /* renamed from: f */
    public void mo22714f(DownloadTask downloadTask) {
    }
}
