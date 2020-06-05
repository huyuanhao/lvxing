package com.kwai.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.kwai.filedownloader.message.C4698e;
import com.kwai.filedownloader.message.C4698e.C4700b;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.p355c.C4610a;
import com.kwai.filedownloader.p355c.C4613b.C4614a;
import com.kwai.filedownloader.p356d.C4619b;
import com.kwai.filedownloader.p358f.C4660d;
import java.lang.ref.WeakReference;

/* renamed from: com.kwai.filedownloader.services.d */
public class C4733d extends C4614a implements C4700b, C4739i {
    /* renamed from: a */
    private final RemoteCallbackList<C4610a> f15278a = new RemoteCallbackList<>();
    /* renamed from: b */
    private final C4737g f15279b;
    /* renamed from: c */
    private final WeakReference<FileDownloadService> f15280c;

    C4733d(WeakReference<FileDownloadService> weakReference, C4737g gVar) {
        this.f15280c = weakReference;
        this.f15279b = gVar;
        C4698e.m19280a().mo25289a((C4700b) this);
    }

    /* renamed from: b */
    private synchronized int m19405b(MessageSnapshot messageSnapshot) {
        int beginBroadcast;
        RemoteCallbackList<C4610a> remoteCallbackList;
        beginBroadcast = this.f15278a.beginBroadcast();
        int i = 0;
        while (i < beginBroadcast) {
            try {
                ((C4610a) this.f15278a.getBroadcastItem(i)).mo25008a(messageSnapshot);
                i++;
            } catch (RemoteException e) {
                try {
                    C4660d.m19121a((Object) this, (Throwable) e, "callback error", new Object[0]);
                    remoteCallbackList = this.f15278a;
                } catch (Throwable th) {
                    this.f15278a.finishBroadcast();
                    throw th;
                }
            }
        }
        remoteCallbackList = this.f15278a;
        remoteCallbackList.finishBroadcast();
        return beginBroadcast;
    }

    /* renamed from: a */
    public IBinder mo25337a(Intent intent) {
        return this;
    }

    /* renamed from: a */
    public void mo25012a() {
        this.f15279b.mo25341a();
    }

    /* renamed from: a */
    public void mo25013a(int i, Notification notification) {
        WeakReference<FileDownloadService> weakReference = this.f15280c;
        if (weakReference != null && weakReference.get() != null) {
            ((FileDownloadService) this.f15280c.get()).startForeground(i, notification);
        }
    }

    /* renamed from: a */
    public void mo25338a(Intent intent, int i, int i2) {
    }

    /* renamed from: a */
    public void mo25014a(C4610a aVar) {
        this.f15278a.register(aVar);
    }

    /* renamed from: a */
    public void mo25290a(MessageSnapshot messageSnapshot) {
        m19405b(messageSnapshot);
    }

    /* renamed from: a */
    public void mo25015a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C4619b bVar, boolean z3) {
        this.f15279b.mo25342a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    /* renamed from: a */
    public void mo25016a(boolean z) {
        WeakReference<FileDownloadService> weakReference = this.f15280c;
        if (weakReference != null && weakReference.get() != null) {
            ((FileDownloadService) this.f15280c.get()).stopForeground(z);
        }
    }

    /* renamed from: a */
    public boolean mo25017a(int i) {
        return this.f15279b.mo25347b(i);
    }

    /* renamed from: a */
    public boolean mo25018a(String str, String str2) {
        return this.f15279b.mo25345a(str, str2);
    }

    /* renamed from: b */
    public void mo25019b(C4610a aVar) {
        this.f15278a.unregister(aVar);
    }

    /* renamed from: b */
    public boolean mo25020b() {
        return this.f15279b.mo25346b();
    }

    /* renamed from: b */
    public boolean mo25021b(int i) {
        return this.f15279b.mo25352f(i);
    }

    /* renamed from: c */
    public long mo25022c(int i) {
        return this.f15279b.mo25348c(i);
    }

    /* renamed from: c */
    public void mo25023c() {
        this.f15279b.mo25349c();
    }

    /* renamed from: d */
    public long mo25024d(int i) {
        return this.f15279b.mo25350d(i);
    }

    /* renamed from: d */
    public void mo25339d() {
        C4698e.m19280a().mo25289a((C4700b) null);
    }

    /* renamed from: e */
    public byte mo25025e(int i) {
        return this.f15279b.mo25351e(i);
    }

    /* renamed from: f */
    public boolean mo25026f(int i) {
        return this.f15279b.mo25353g(i);
    }
}
