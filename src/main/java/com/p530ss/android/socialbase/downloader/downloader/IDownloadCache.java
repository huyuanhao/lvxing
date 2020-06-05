package com.p530ss.android.socialbase.downloader.downloader;

import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.downloader.k */
public interface IDownloadCache {
    /* renamed from: a */
    DownloadInfo mo31664a(int i, int i2);

    /* renamed from: a */
    DownloadInfo mo31665a(int i, long j);

    /* renamed from: a */
    DownloadInfo mo31666a(int i, long j, String str, String str2);

    /* renamed from: a */
    List<DownloadInfo> mo31667a(String str);

    /* renamed from: a */
    void mo31669a(int i, int i2, int i3, int i4);

    /* renamed from: a */
    void mo31670a(int i, int i2, int i3, long j);

    /* renamed from: a */
    void mo31671a(int i, int i2, long j);

    /* renamed from: a */
    void mo31672a(int i, List<DownloadChunk> list);

    /* renamed from: a */
    void mo31674a(DownloadChunk bVar);

    /* renamed from: a */
    boolean mo31676a(DownloadInfo cVar);

    /* renamed from: b */
    DownloadInfo mo31677b(int i);

    /* renamed from: b */
    DownloadInfo mo31678b(int i, long j);

    /* renamed from: b */
    List<DownloadInfo> mo31679b(String str);

    /* renamed from: b */
    void mo31680b();

    /* renamed from: b */
    void mo31681b(int i, List<DownloadChunk> list);

    /* renamed from: b */
    void mo31682b(DownloadChunk bVar);

    /* renamed from: b */
    void mo31683b(DownloadInfo cVar);

    /* renamed from: c */
    DownloadInfo mo31684c(int i, long j);

    /* renamed from: c */
    List<DownloadChunk> mo31685c(int i);

    /* renamed from: c */
    List<DownloadInfo> mo31686c(String str);

    /* renamed from: c */
    boolean mo31687c();

    /* renamed from: d */
    DownloadInfo mo31688d(int i, long j);

    /* renamed from: d */
    List<DownloadInfo> mo31689d(String str);

    /* renamed from: d */
    void mo31690d(int i);

    /* renamed from: d */
    boolean mo31691d();

    /* renamed from: e */
    boolean mo31693e(int i);

    /* renamed from: f */
    boolean mo31694f(int i);

    /* renamed from: g */
    DownloadInfo mo31695g(int i);

    /* renamed from: h */
    DownloadInfo mo31696h(int i);

    /* renamed from: i */
    DownloadInfo mo31697i(int i);

    /* renamed from: j */
    DownloadInfo mo31698j(int i);
}
