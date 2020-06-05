package com.p530ss.android.p531a.p532a.p534b.p535a;

import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadController;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;

/* renamed from: com.ss.android.a.a.b.a.a */
public interface DownloadCompletedListener {
    /* renamed from: a */
    void mo16552a(C6507c cVar, DownloadController aVar, DownloadEventConfig bVar);

    /* renamed from: a */
    void mo16553a(DownloadInfo cVar);

    /* renamed from: a */
    void mo16554a(DownloadInfo cVar, BaseException aVar, String str);

    /* renamed from: a */
    void mo16555a(DownloadInfo cVar, String str);

    /* renamed from: b */
    void mo16556b(DownloadInfo cVar, String str);
}
