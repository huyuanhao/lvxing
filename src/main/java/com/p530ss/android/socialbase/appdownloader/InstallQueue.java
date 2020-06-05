package com.p530ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p556a.AppStatusManager;
import com.p530ss.android.socialbase.downloader.p556a.AppStatusManager.C6638a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.ss.android.socialbase.appdownloader.i */
public class InstallQueue {
    /* renamed from: a */
    private Queue<Integer> f21631a;
    /* renamed from: b */
    private boolean f21632b;
    /* renamed from: c */
    private long f21633c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public long f21634d;
    /* renamed from: e */
    private Handler f21635e;
    /* renamed from: f */
    private Runnable f21636f;

    /* compiled from: InstallQueue */
    /* renamed from: com.ss.android.socialbase.appdownloader.i$a */
    private static class C6627a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final InstallQueue f21646a = new InstallQueue();
    }

    private InstallQueue() {
        this.f21631a = new ArrayDeque();
        this.f21632b = false;
        this.f21635e = new Handler(Looper.getMainLooper());
        this.f21636f = new Runnable() {
            public void run() {
                InstallQueue.this.m26932b();
            }
        };
        AppStatusManager.m26964a().mo31645a((C6638a) new C6638a() {
            /* renamed from: c */
            public void mo31237c() {
            }

            /* renamed from: b */
            public void mo31235b() {
                if (System.currentTimeMillis() - InstallQueue.this.f21634d >= DownloadSetting.m28617b().mo32548a("install_on_resume_install_interval", 300000)) {
                    InstallQueue.this.f21634d = System.currentTimeMillis();
                    InstallQueue.this.m26932b();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26932b() {
        final Integer num = (Integer) this.f21631a.poll();
        this.f21635e.removeCallbacks(this.f21636f);
        if (num != null) {
            final Context B = C6694b.m27342B();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f21635e.post(new Runnable() {
                    public void run() {
                        InstallQueue.this.m26930b(B, num.intValue(), false);
                    }
                });
            } else {
                m26930b(B, num.intValue(), false);
            }
            this.f21635e.postDelayed(this.f21636f, 20000);
            return;
        }
        this.f21632b = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo31622a(DownloadInfo cVar, String str) {
        if (cVar != null && !TextUtils.isEmpty(str)) {
            m26932b();
        }
    }

    /* renamed from: a */
    public static InstallQueue m26928a() {
        return C6627a.f21646a;
    }

    /* renamed from: a */
    public int mo31621a(final Context context, final int i, final boolean z) {
        if (z) {
            return m26930b(context, i, z);
        }
        if (m26933c()) {
            this.f21635e.postDelayed(new Runnable() {
                public void run() {
                    InstallQueue.this.mo31621a(context, i, z);
                }
            }, 1000);
            return 1;
        } else if (AppStatusManager.m26964a().mo31648c()) {
            return m26930b(context, i, z);
        } else {
            if (this.f21631a.isEmpty() && !this.f21632b) {
                return m26930b(context, i, z);
            }
            int a = DownloadSetting.m28617b().mo32547a("install_queue_size", 3);
            while (this.f21631a.size() > a) {
                this.f21631a.poll();
            }
            this.f21635e.removeCallbacks(this.f21636f);
            this.f21635e.postDelayed(this.f21636f, DownloadSetting.m28610a(i).mo32548a("install_queue_timeout", 20000));
            if (!this.f21631a.contains(Integer.valueOf(i))) {
                this.f21631a.offer(Integer.valueOf(i));
            }
            return 1;
        }
    }

    /* renamed from: c */
    private boolean m26933c() {
        return System.currentTimeMillis() - this.f21633c < 1000;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m26930b(Context context, int i, boolean z) {
        int b = AppDownloadUtils.m26661b(context, i, z);
        if (b == 1) {
            this.f21632b = true;
        }
        this.f21633c = System.currentTimeMillis();
        return b;
    }
}
