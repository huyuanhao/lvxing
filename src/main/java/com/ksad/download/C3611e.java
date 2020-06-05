package com.ksad.download;

/* renamed from: com.ksad.download.e */
public class C3611e {
    /* renamed from: a */
    private C3613f f12374a;

    /* renamed from: com.ksad.download.e$a */
    private static final class C3612a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C3611e f12375a = new C3611e();
    }

    /* renamed from: a */
    public static C3611e m15066a() {
        return C3612a.f12375a;
    }

    /* renamed from: a */
    public synchronized void mo22730a(int i) {
        if (this.f12374a != null) {
            this.f12374a.mo22735a(i);
        }
    }

    /* renamed from: a */
    public synchronized void mo22731a(DownloadTask downloadTask) {
        if (downloadTask.isCanceled()) {
            mo22730a(downloadTask.getId());
        } else if (this.f12374a != null) {
            this.f12374a.mo22736a(downloadTask);
        }
    }

    /* renamed from: a */
    public synchronized void mo22732a(DownloadTask downloadTask, boolean z) {
        if (downloadTask.isCanceled()) {
            mo22730a(downloadTask.getId());
        } else if (this.f12374a != null) {
            this.f12374a.mo22737a(downloadTask, z);
        }
    }

    /* renamed from: a */
    public void mo22733a(C3613f fVar) {
        this.f12374a = fVar;
    }

    /* renamed from: b */
    public synchronized void mo22734b(DownloadTask downloadTask) {
        if (this.f12374a != null) {
            this.f12374a.mo22738b(downloadTask);
        }
    }
}
