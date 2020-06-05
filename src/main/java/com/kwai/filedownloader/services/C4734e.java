package com.kwai.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.kwai.filedownloader.C4677m;
import com.kwai.filedownloader.p355c.C4610a;
import com.kwai.filedownloader.p355c.C4613b.C4614a;
import com.kwai.filedownloader.p356d.C4619b;
import java.lang.ref.WeakReference;

/* renamed from: com.kwai.filedownloader.services.e */
public class C4734e extends C4614a implements C4739i {
    /* renamed from: a */
    private final C4737g f15281a;
    /* renamed from: b */
    private final WeakReference<FileDownloadService> f15282b;

    /* renamed from: com.kwai.filedownloader.services.e$a */
    public interface C4735a {
        /* renamed from: a */
        void mo25295a();

        /* renamed from: a */
        void mo25297a(C4734e eVar);
    }

    C4734e(WeakReference<FileDownloadService> weakReference, C4737g gVar) {
        this.f15282b = weakReference;
        this.f15281a = gVar;
    }

    /* renamed from: a */
    public IBinder mo25337a(Intent intent) {
        return null;
    }

    /* renamed from: a */
    public void mo25012a() {
        this.f15281a.mo25341a();
    }

    /* renamed from: a */
    public void mo25013a(int i, Notification notification) {
        WeakReference<FileDownloadService> weakReference = this.f15282b;
        if (weakReference != null && weakReference.get() != null) {
            ((FileDownloadService) this.f15282b.get()).startForeground(i, notification);
        }
    }

    /* renamed from: a */
    public void mo25338a(Intent intent, int i, int i2) {
        C4677m.m19229b().mo25297a(this);
    }

    /* renamed from: a */
    public void mo25014a(C4610a aVar) {
    }

    /* renamed from: a */
    public void mo25015a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C4619b bVar, boolean z3) {
        this.f15281a.mo25342a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    /* renamed from: a */
    public void mo25016a(boolean z) {
        WeakReference<FileDownloadService> weakReference = this.f15282b;
        if (weakReference != null && weakReference.get() != null) {
            ((FileDownloadService) this.f15282b.get()).stopForeground(z);
        }
    }

    /* renamed from: a */
    public boolean mo25017a(int i) {
        return this.f15281a.mo25347b(i);
    }

    /* renamed from: a */
    public boolean mo25018a(String str, String str2) {
        return this.f15281a.mo25345a(str, str2);
    }

    /* renamed from: b */
    public void mo25019b(C4610a aVar) {
    }

    /* renamed from: b */
    public boolean mo25020b() {
        return this.f15281a.mo25346b();
    }

    /* renamed from: b */
    public boolean mo25021b(int i) {
        return this.f15281a.mo25352f(i);
    }

    /* renamed from: c */
    public long mo25022c(int i) {
        return this.f15281a.mo25348c(i);
    }

    /* renamed from: c */
    public void mo25023c() {
        this.f15281a.mo25349c();
    }

    /* renamed from: d */
    public long mo25024d(int i) {
        return this.f15281a.mo25350d(i);
    }

    /* renamed from: d */
    public void mo25339d() {
        C4677m.m19229b().mo25295a();
    }

    /* renamed from: e */
    public byte mo25025e(int i) {
        return this.f15281a.mo25351e(i);
    }

    /* renamed from: f */
    public boolean mo25026f(int i) {
        return this.f15281a.mo25353g(i);
    }
}
