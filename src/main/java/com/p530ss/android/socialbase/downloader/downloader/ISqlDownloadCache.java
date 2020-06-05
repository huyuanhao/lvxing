package com.p530ss.android.socialbase.downloader.downloader;

import android.util.SparseArray;
import com.p530ss.android.socialbase.downloader.p558c.SqlCacheLoadCompleteCallback;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.downloader.s */
public interface ISqlDownloadCache extends IDownloadCache {
    /* renamed from: a */
    void mo31704a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<DownloadChunk>> sparseArray2, SqlCacheLoadCompleteCallback dVar);
}
