package com.p530ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.p530ss.android.socialbase.downloader.downloader.DownloadService;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import java.lang.ref.WeakReference;

/* renamed from: com.ss.android.socialbase.downloader.downloader.p */
public interface IDownloadServiceHandler<T extends DownloadService> {
    /* renamed from: a */
    IBinder mo31836a(Intent intent);

    /* renamed from: a */
    void mo31837a(int i);

    /* renamed from: a */
    void mo31838a(int i, Notification notification);

    /* renamed from: a */
    void mo31840a(Intent intent, int i, int i2);

    /* renamed from: a */
    void mo31841a(IDownloadServiceConnectionListener oVar);

    /* renamed from: a */
    void mo31843a(WeakReference<T> weakReference);

    /* renamed from: a */
    void mo31844a(boolean z);

    /* renamed from: a */
    boolean mo31845a();

    /* renamed from: b */
    void mo31846b(C6712d dVar);

    /* renamed from: b */
    boolean mo31847b();

    /* renamed from: c */
    void mo31848c();

    /* renamed from: c */
    void mo31849c(C6712d dVar);

    /* renamed from: d */
    void mo31850d();

    /* renamed from: f */
    void mo31852f();
}
