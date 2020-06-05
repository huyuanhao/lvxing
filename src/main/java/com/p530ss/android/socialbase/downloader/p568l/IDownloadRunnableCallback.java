package com.p530ss.android.socialbase.downloader.p568l;

import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHeadHttpConnection;

/* renamed from: com.ss.android.socialbase.downloader.l.e */
public interface IDownloadRunnableCallback {
    /* renamed from: a */
    RetryCheckStatus mo32562a(BaseException aVar, long j);

    /* renamed from: a */
    RetryCheckStatus mo32563a(DownloadChunk bVar, BaseException aVar, long j);

    /* renamed from: a */
    DownloadChunk mo32564a(int i);

    /* renamed from: a */
    void mo32566a(BaseException aVar, boolean z);

    /* renamed from: a */
    void mo32567a(IDownloadHeadHttpConnection cVar);

    /* renamed from: a */
    void mo32568a(DownloadChunkRunnable bVar);

    /* renamed from: a */
    boolean mo32570a(long j) throws BaseException;

    /* renamed from: a */
    boolean mo32571a(BaseException aVar);

    /* renamed from: b */
    void mo32573b(BaseException aVar);

    /* renamed from: c */
    void mo32575c(BaseException aVar);
}
