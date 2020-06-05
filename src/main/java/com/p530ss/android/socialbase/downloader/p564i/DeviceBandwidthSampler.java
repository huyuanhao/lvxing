package com.p530ss.android.socialbase.downloader.p564i;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.ss.android.socialbase.downloader.i.a */
public class DeviceBandwidthSampler {
    /* renamed from: a */
    private static final String f22116a = DeviceBandwidthSampler.class.getSimpleName();
    /* renamed from: f */
    private static long f22117f = -1;
    /* renamed from: g */
    private static volatile DeviceBandwidthSampler f22118g = null;
    /* renamed from: b */
    private final NetTrafficManager f22119b = NetTrafficManager.m28219a();
    /* renamed from: c */
    private final AtomicInteger f22120c = new AtomicInteger();
    /* renamed from: d */
    private final C6714a f22121d;
    /* renamed from: e */
    private long f22122e;

    /* compiled from: DeviceBandwidthSampler */
    /* renamed from: com.ss.android.socialbase.downloader.i.a$a */
    private class C6714a extends Handler {
        public C6714a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                DeviceBandwidthSampler.this.mo32448e();
                sendEmptyMessageDelayed(1, 1000);
            }
        }

        /* renamed from: a */
        public void mo32450a() {
            sendEmptyMessage(1);
        }

        /* renamed from: b */
        public void mo32451b() {
            removeMessages(1);
        }
    }

    /* renamed from: a */
    public static DeviceBandwidthSampler m28179a() {
        if (f22118g == null) {
            synchronized (DeviceBandwidthSampler.class) {
                if (f22118g == null) {
                    f22118g = new DeviceBandwidthSampler();
                }
            }
        }
        return f22118g;
    }

    private DeviceBandwidthSampler() {
        HandlerThread handlerThread = new HandlerThread("ParseThread");
        handlerThread.start();
        this.f22121d = new C6714a(handlerThread.getLooper());
    }

    /* renamed from: b */
    public void mo32446b() {
        try {
            if (this.f22120c.getAndIncrement() == 0) {
                if (C6704a.m27756a()) {
                    C6704a.m27758b(f22116a, "startSampling");
                }
                this.f22121d.mo32450a();
                this.f22122e = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public void mo32447c() {
        try {
            if (this.f22120c.decrementAndGet() == 0) {
                if (C6704a.m27756a()) {
                    C6704a.m27758b(f22116a, "stopSampling");
                }
                this.f22121d.mo32451b();
                mo32449f();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public static long m28180d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo32448e() {
        long j;
        try {
            if (DownloadUtils.m28773a(C6694b.m27342B())) {
                j = m28180d();
            } else {
                j = TrafficStats.getMobileRxBytes();
            }
            long j2 = j - f22117f;
            if (f22117f >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f22119b.mo32469a(j2, uptimeMillis - this.f22122e);
                    this.f22122e = uptimeMillis;
                }
            }
            f22117f = j;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo32449f() {
        mo32448e();
        f22117f = -1;
    }
}
