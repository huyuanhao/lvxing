package com.p530ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.p530ss.android.socialbase.downloader.p557b.ListenerType;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadFileUriProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickCallback;
import com.p530ss.android.socialbase.downloader.p559d.ProcessCallback;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.downloader.n */
public interface IDownloadProxy {
    /* renamed from: a */
    int mo32012a(String str, String str2);

    /* renamed from: a */
    List<DownloadInfo> mo32013a(String str);

    /* renamed from: a */
    void mo32014a();

    /* renamed from: a */
    void mo32015a(int i);

    /* renamed from: a */
    void mo32016a(int i, int i2);

    /* renamed from: a */
    void mo32017a(int i, int i2, int i3, int i4);

    /* renamed from: a */
    void mo32018a(int i, int i2, int i3, long j);

    /* renamed from: a */
    void mo32019a(int i, int i2, long j);

    /* renamed from: a */
    void mo32020a(int i, int i2, IDownloadListener adVar, ListenerType hVar, boolean z);

    /* renamed from: a */
    void mo32021a(int i, Notification notification);

    /* renamed from: a */
    void mo32022a(int i, IDownloadNotificationEventListener agVar);

    /* renamed from: a */
    void mo32023a(int i, List<DownloadChunk> list);

    /* renamed from: a */
    void mo32024a(int i, boolean z);

    /* renamed from: a */
    void mo32025a(ProcessCallback hVar);

    /* renamed from: a */
    void mo32026a(DownloadChunk bVar);

    /* renamed from: a */
    void mo32027a(C6712d dVar);

    /* renamed from: a */
    void mo32028a(List<String> list);

    /* renamed from: a */
    void mo32029a(boolean z, boolean z2);

    /* renamed from: a */
    boolean mo32030a(DownloadInfo cVar);

    /* renamed from: b */
    DownloadInfo mo32031b(String str, String str2);

    /* renamed from: b */
    List<DownloadInfo> mo32032b(String str);

    /* renamed from: b */
    void mo32033b(int i, int i2, IDownloadListener adVar, ListenerType hVar, boolean z);

    /* renamed from: b */
    void mo32034b(int i, List<DownloadChunk> list);

    /* renamed from: b */
    void mo32035b(int i, boolean z);

    /* renamed from: b */
    void mo32036b(DownloadInfo cVar);

    /* renamed from: b */
    void mo32037b(C6712d dVar);

    /* renamed from: b */
    boolean mo32038b();

    /* renamed from: b */
    boolean mo32039b(int i);

    /* renamed from: c */
    List<DownloadInfo> mo32040c(String str);

    /* renamed from: c */
    void mo32041c(int i);

    /* renamed from: c */
    void mo32042c(int i, boolean z);

    /* renamed from: c */
    boolean mo32043c();

    /* renamed from: c */
    boolean mo32044c(DownloadInfo cVar);

    /* renamed from: d */
    List<DownloadInfo> mo32045d(String str);

    /* renamed from: d */
    void mo32046d();

    /* renamed from: d */
    void mo32047d(int i);

    /* renamed from: e */
    long mo32048e(int i);

    /* renamed from: e */
    List<DownloadInfo> mo32049e(String str);

    /* renamed from: e */
    boolean mo32050e();

    /* renamed from: f */
    int mo32051f(int i);

    /* renamed from: f */
    void mo32052f();

    /* renamed from: g */
    boolean mo32053g();

    /* renamed from: g */
    boolean mo32054g(int i);

    /* renamed from: h */
    DownloadInfo mo32055h(int i);

    /* renamed from: i */
    List<DownloadChunk> mo32056i(int i);

    /* renamed from: j */
    void mo32057j(int i);

    /* renamed from: k */
    void mo32058k(int i);

    /* renamed from: l */
    boolean mo32059l(int i);

    /* renamed from: m */
    int mo32060m(int i);

    /* renamed from: n */
    boolean mo32061n(int i);

    /* renamed from: o */
    void mo32062o(int i);

    /* renamed from: p */
    boolean mo32063p(int i);

    /* renamed from: q */
    IDownloadNotificationEventListener mo32064q(int i);

    /* renamed from: r */
    INotificationClickCallback mo32065r(int i);

    /* renamed from: s */
    IDownloadFileUriProvider mo32066s(int i);
}
