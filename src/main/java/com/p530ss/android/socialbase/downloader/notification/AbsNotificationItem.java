package com.p530ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.notification.a */
public abstract class AbsNotificationItem {
    /* renamed from: a */
    private int f22461a;
    /* renamed from: b */
    private long f22462b;
    /* renamed from: c */
    private long f22463c;
    /* renamed from: d */
    private String f22464d;
    /* renamed from: e */
    private int f22465e = 0;
    /* renamed from: f */
    private long f22466f;
    /* renamed from: g */
    private int f22467g;
    /* renamed from: h */
    private boolean f22468h;

    /* renamed from: a */
    public abstract void mo31507a(BaseException aVar, boolean z);

    public AbsNotificationItem(int i, String str) {
        this.f22461a = i;
        this.f22464d = str;
    }

    /* renamed from: a */
    public void mo31508a(DownloadInfo cVar) {
        if (cVar != null) {
            this.f22461a = cVar.mo32283g();
            this.f22464d = cVar.mo32291i();
        }
    }

    /* renamed from: a */
    public int mo32624a() {
        return this.f22461a;
    }

    /* renamed from: b */
    public long mo32630b() {
        return this.f22462b;
    }

    /* renamed from: a */
    public void mo32626a(long j) {
        this.f22462b = j;
    }

    /* renamed from: c */
    public long mo32632c() {
        return this.f22463c;
    }

    /* renamed from: b */
    public void mo32631b(long j) {
        this.f22463c = j;
    }

    /* renamed from: d */
    public String mo32633d() {
        return this.f22464d;
    }

    /* renamed from: e */
    public int mo32634e() {
        return this.f22465e;
    }

    /* renamed from: a */
    public void mo32625a(int i, BaseException aVar, boolean z, boolean z2) {
        if (z2 || this.f22465e != i) {
            this.f22465e = i;
            mo31507a(aVar, z);
        }
    }

    /* renamed from: f */
    public long mo32635f() {
        if (this.f22466f == 0) {
            this.f22466f = System.currentTimeMillis();
        }
        return this.f22466f;
    }

    /* renamed from: a */
    public void mo32627a(long j, long j2) {
        this.f22462b = j;
        this.f22463c = j2;
        this.f22465e = 4;
        mo31507a((BaseException) null, false);
    }

    /* renamed from: a */
    public void mo32628a(Notification notification) {
        if (this.f22461a != 0 && notification != null) {
            DownloadNotificationManager.m28984a().mo32640a(this.f22461a, this.f22465e, notification);
        }
    }

    /* renamed from: g */
    public synchronized void mo32636g() {
        this.f22467g++;
    }

    /* renamed from: h */
    public int mo32637h() {
        return this.f22467g;
    }

    /* renamed from: i */
    public boolean mo32638i() {
        return this.f22468h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32629a(boolean z) {
        this.f22468h = z;
    }
}
