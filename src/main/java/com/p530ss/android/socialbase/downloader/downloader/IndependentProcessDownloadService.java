package com.p530ss.android.socialbase.downloader.downloader;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import java.lang.ref.WeakReference;

/* renamed from: com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService */
public class IndependentProcessDownloadService extends DownloadService {
    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final String f21812b = IndependentProcessDownloadService.class.getSimpleName();
    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static boolean f21813c = false;
    /* renamed from: d */
    private static int f21814d = 0;
    /* renamed from: e */
    private static long f21815e = 0;
    /* renamed from: f */
    private Handler f21816f = new Handler(Looper.getMainLooper());
    /* renamed from: g */
    private ServiceConnection f21817g = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IndependentProcessDownloadService.f21813c = true;
            C6704a.m27758b(IndependentProcessDownloadService.f21812b, "onServiceConnected: ");
            try {
                iBinder.linkToDeath(new DeathRecipient() {
                    public void binderDied() {
                        IndependentProcessDownloadService.f21813c = false;
                        C6704a.m27761d(IndependentProcessDownloadService.f21812b, "binderDied:");
                        IndependentProcessDownloadService.this.m27319b();
                    }
                }, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            IndependentProcessDownloadService.f21813c = false;
        }
    };

    public void onCreate() {
        super.onCreate();
        C6694b.m27353a((Context) this);
        this.f21807a = C6694b.m27386r();
        this.f21807a.mo31843a(new WeakReference<>(this));
        m27319b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27319b() {
        if (VERSION.SDK_INT >= 26 || !DownloadExpSwitchCode.m28744a(512) || f21813c) {
            return;
        }
        if (f21814d > 5) {
            C6704a.m27761d(f21812b, "bindMainProcess: bind too many times!!! ");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f21815e < 15000) {
            C6704a.m27761d(f21812b, "bindMainProcess: time too short since last bind!!! ");
            return;
        }
        f21814d++;
        f21815e = currentTimeMillis;
        this.f21816f.postDelayed(new Runnable() {
            public void run() {
                IndependentProcessDownloadService.this.m27321c();
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m27321c() {
        C6704a.m27758b(f21812b, "bindMainProcess: ");
        Intent intent = new Intent(this, DownloadService.class);
        try {
            bindService(intent, this.f21817g, 1);
            startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
