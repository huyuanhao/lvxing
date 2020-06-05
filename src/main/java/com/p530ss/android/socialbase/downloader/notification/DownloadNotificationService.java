package com.p530ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.text.TextUtils;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import com.tencent.mid.core.Constants;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService */
public class DownloadNotificationService extends Service {
    /* renamed from: a */
    private static final String f22439a = DownloadNotificationService.class.getSimpleName();
    /* renamed from: b */
    private static int f22440b = -1;
    /* renamed from: c */
    private static int f22441c = -1;
    /* renamed from: d */
    private static boolean f22442d = true;
    /* renamed from: e */
    private static boolean f22443e = false;
    /* renamed from: f */
    private static volatile long f22444f;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: g */
    public static volatile long f22445g;
    /* access modifiers changed from: private|static */
    /* renamed from: h */
    public static boolean f22446h;
    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static long f22447i = 900;
    /* renamed from: j */
    private HandlerThread f22448j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public Handler f22449k;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        m28966d();
        C6694b.m27353a((Context) this);
        DownloadSetting b = DownloadSetting.m28617b();
        int a = b.mo32547a("download_service_foreground", 0);
        if ((a == 1 || a == 3) && f22440b == -1) {
            f22440b = 0;
        }
        if ((a == 2 || a == 3) && f22441c == -1) {
            f22441c = 0;
        }
        f22443e = b.mo32552b("non_going_notification_foreground", false);
        f22446h = b.mo32552b("notify_too_fast", false);
        f22447i = b.mo32548a("notification_time_window", 900);
        long j = f22447i;
        if (j < 0 || j > 1200) {
            f22447i = 900;
        }
    }

    /* renamed from: d */
    private void m28966d() {
        if (this.f22448j == null) {
            this.f22448j = new HandlerThread("DownloaderNotifyThread");
            this.f22448j.start();
            this.f22449k = new Handler(this.f22448j.getLooper());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        HandlerThread handlerThread = this.f22448j;
        if (handlerThread != null) {
            try {
                handlerThread.quit();
            } catch (Throwable unused) {
            }
            this.f22448j = null;
            this.f22449k = null;
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m28957a(intent);
        return 2;
    }

    /* renamed from: a */
    private void m28957a(final Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                Handler handler = this.f22449k;
                if (handler != null) {
                    handler.post(new Runnable() {
                        public void run() {
                            final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                            final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                            if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                                final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                                int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                                if (!(intExtra == 0 || notification == null || notificationManager == null)) {
                                    if (intExtra2 == 4) {
                                        if (Downloader.m27478a(C6694b.m27342B()).mo31927g(intExtra)) {
                                            DownloadInfo h = Downloader.m27478a(C6694b.m27342B()).mo31928h(intExtra);
                                            if (DownloadNotificationService.f22446h) {
                                                if (h != null && h.mo32196a() && System.currentTimeMillis() - DownloadNotificationService.f22445g > DownloadNotificationService.f22447i) {
                                                    DownloadNotificationService.this.m28963b(notificationManager, intExtra, notification);
                                                    h.mo32250b();
                                                }
                                            } else if (h != null && h.mo32196a()) {
                                                DownloadNotificationService.this.m28963b(notificationManager, intExtra, notification);
                                                h.mo32250b();
                                            }
                                        }
                                    } else if (intExtra2 == -2 || intExtra2 == -3) {
                                        if (DownloadNotificationService.f22446h) {
                                            DownloadNotificationService.this.m28956a(notificationManager, intExtra, notification);
                                        } else if (DownloadNotificationService.this.f22449k != null) {
                                            DownloadNotificationService.this.f22449k.postDelayed(new Runnable() {
                                                public void run() {
                                                    DownloadNotificationService.this.m28963b(notificationManager, intExtra, notification);
                                                }
                                            }, intExtra2 == -2 ? 50 : 200);
                                        }
                                    } else if (DownloadNotificationService.f22446h) {
                                        DownloadNotificationService.this.m28956a(notificationManager, intExtra, notification);
                                    } else {
                                        DownloadNotificationService.this.m28963b(notificationManager, intExtra, notification);
                                    }
                                }
                            } else if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                                if (intExtra != 0) {
                                    DownloadNotificationService.this.m28955a(notificationManager, intExtra);
                                }
                            } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                                try {
                                    if (DownloadUtils.m28774a((Context) DownloadNotificationService.this, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
                                        ConnectivityManager connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getSystemService("connectivity");
                                        if (connectivityManager != null) {
                                            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                            if (activeNetworkInfo != null) {
                                                if (activeNetworkInfo.isConnected()) {
                                                    ArrayList arrayList = new ArrayList();
                                                    arrayList.add("application/vnd.android.package-archive");
                                                    arrayList.add("mime_type_plugin");
                                                    Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                                                    if (applicationContext != null) {
                                                        Downloader.m27478a(applicationContext).mo31917a((List<String>) arrayList);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                                try {
                                    Downloader.m27478a((Context) DownloadNotificationService.this).mo31913a();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28956a(final NotificationManager notificationManager, final int i, final Notification notification) {
        long currentTimeMillis = f22447i - (System.currentTimeMillis() - f22444f);
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis > 20000) {
            currentTimeMillis = 20000;
        }
        long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
        f22445g = currentTimeMillis2;
        f22444f = currentTimeMillis2;
        if (currentTimeMillis <= 0) {
            m28963b(notificationManager, i, notification);
            return;
        }
        Handler handler = this.f22449k;
        if (handler != null) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    DownloadNotificationService.this.m28963b(notificationManager, i, notification);
                }
            }, currentTimeMillis);
        }
    }

    /* renamed from: a */
    private boolean m28961a(int i, Notification notification) {
        if (!f22442d) {
            return false;
        }
        int i2 = f22440b;
        if (i2 != i) {
            int i3 = f22441c;
            if (i3 != i) {
                if (i2 != 0 && i3 != 0) {
                    return false;
                }
                if (f22443e && (notification.flags & 2) == 0) {
                    return false;
                }
                if (VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId())) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28963b(NotificationManager notificationManager, int i, Notification notification) {
        if (m28961a(i, notification)) {
            try {
                boolean z = true;
                boolean z2 = DownloadProcessDispatcher.m27395a().mo31855a(i) == 1 && !DownloadUtils.m28801c();
                if (z2 || f22440b != 0) {
                    if (!z2 || f22441c != 0) {
                        z = false;
                    }
                }
                if (z) {
                    IDownloadProxy c = DownloadProcessDispatcher.m27395a().mo31869c(i);
                    if (!c.mo32053g() || c.mo32038b()) {
                        String str = f22439a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = ");
                        sb.append(z2);
                        C6704a.m27760c(str, sb.toString());
                    } else {
                        String str2 = f22439a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("doNotify, startForeground, ======== id = ");
                        sb2.append(i);
                        sb2.append(", isIndependentProcess = ");
                        sb2.append(z2);
                        C6704a.m27760c(str2, sb2.toString());
                        if (z2) {
                            f22441c = i;
                        } else {
                            f22440b = i;
                        }
                        c.mo32021a(i, notification);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if ((f22440b == i || f22441c == i) && f22443e && (notification.flags & 2) == 0) {
            m28955a(notificationManager, i);
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (f22444f < currentTimeMillis) {
                f22444f = currentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c5 A[Catch:{ all -> 0x00cd, all -> 0x00f7 }] */
    /* renamed from: a */
    public void m28955a(android.app.NotificationManager r10, int r11) {
        /*
        r9 = this;
        int r0 = f22440b
        if (r0 == r11) goto L_0x000e
        int r0 = f22441c
        if (r0 != r11) goto L_0x0009
        goto L_0x000e
    L_0x0009:
        r10.cancel(r11)     // Catch:{ all -> 0x00fb }
        goto L_0x00fb
    L_0x000e:
        int r0 = f22440b
        r1 = 1
        r2 = 0
        if (r0 != r11) goto L_0x0018
        f22440b = r2
        r0 = 0
        goto L_0x001b
    L_0x0018:
        f22441c = r2
        r0 = 1
    L_0x001b:
        com.ss.android.socialbase.downloader.downloader.c r3 = com.p530ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.m27395a()     // Catch:{ all -> 0x0069 }
        com.ss.android.socialbase.downloader.downloader.n r3 = r3.mo31869c(r11)     // Catch:{ all -> 0x0069 }
        boolean r4 = r3.mo32038b()     // Catch:{ all -> 0x0069 }
        java.lang.String r5 = ", isIndependentProcess = "
        if (r4 != 0) goto L_0x0049
        f22442d = r2     // Catch:{ all -> 0x0069 }
        java.lang.String r4 = f22439a     // Catch:{ all -> 0x0069 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
        r6.<init>()     // Catch:{ all -> 0x0069 }
        java.lang.String r7 = "try to stopForeground when is not Foreground, id = "
        r6.append(r7)     // Catch:{ all -> 0x0069 }
        r6.append(r11)     // Catch:{ all -> 0x0069 }
        r6.append(r5)     // Catch:{ all -> 0x0069 }
        r6.append(r0)     // Catch:{ all -> 0x0069 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0069 }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27761d(r4, r6)     // Catch:{ all -> 0x0069 }
    L_0x0049:
        java.lang.String r4 = f22439a     // Catch:{ all -> 0x0069 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
        r6.<init>()     // Catch:{ all -> 0x0069 }
        java.lang.String r7 = "doCancel, ========== stopForeground id = "
        r6.append(r7)     // Catch:{ all -> 0x0069 }
        r6.append(r11)     // Catch:{ all -> 0x0069 }
        r6.append(r5)     // Catch:{ all -> 0x0069 }
        r6.append(r0)     // Catch:{ all -> 0x0069 }
        java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0069 }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27760c(r4, r5)     // Catch:{ all -> 0x0069 }
        r3.mo32029a(r2, r1)     // Catch:{ all -> 0x0069 }
        goto L_0x006d
    L_0x0069:
        r3 = move-exception
        r3.printStackTrace()
    L_0x006d:
        r10.cancel(r11)     // Catch:{ all -> 0x0071 }
        goto L_0x0072
    L_0x0072:
        boolean r3 = f22442d
        if (r3 != 0) goto L_0x0077
        return
    L_0x0077:
        com.ss.android.socialbase.downloader.notification.b r3 = com.p530ss.android.socialbase.downloader.notification.DownloadNotificationManager.m28984a()     // Catch:{ all -> 0x00f7 }
        android.util.SparseArray r3 = r3.mo32643b()     // Catch:{ all -> 0x00f7 }
        r4 = 0
        if (r3 == 0) goto L_0x00c2
        int r5 = r3.size()     // Catch:{ all -> 0x00f7 }
        int r5 = r5 - r1
    L_0x0087:
        if (r5 < 0) goto L_0x00c2
        java.lang.Object r6 = r3.valueAt(r5)     // Catch:{ all -> 0x00f7 }
        com.ss.android.socialbase.downloader.notification.a r6 = (com.p530ss.android.socialbase.downloader.notification.AbsNotificationItem) r6     // Catch:{ all -> 0x00f7 }
        if (r6 == 0) goto L_0x00bf
        int r7 = r6.mo32624a()     // Catch:{ all -> 0x00f7 }
        if (r7 == r11) goto L_0x00bf
        int r8 = f22440b     // Catch:{ all -> 0x00f7 }
        if (r7 == r8) goto L_0x00bf
        int r8 = f22441c     // Catch:{ all -> 0x00f7 }
        if (r7 == r8) goto L_0x00bf
        boolean r7 = r6.mo32638i()     // Catch:{ all -> 0x00f7 }
        if (r7 == 0) goto L_0x00bf
        com.ss.android.socialbase.downloader.downloader.c r7 = com.p530ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.m27395a()     // Catch:{ all -> 0x00f7 }
        int r8 = r6.mo32624a()     // Catch:{ all -> 0x00f7 }
        int r7 = r7.mo31855a(r8)     // Catch:{ all -> 0x00f7 }
        if (r7 != r1) goto L_0x00bb
        boolean r7 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28801c()     // Catch:{ all -> 0x00f7 }
        if (r7 != 0) goto L_0x00bb
        r7 = 1
        goto L_0x00bc
    L_0x00bb:
        r7 = 0
    L_0x00bc:
        if (r7 != r0) goto L_0x00bf
        goto L_0x00c3
    L_0x00bf:
        int r5 = r5 + -1
        goto L_0x0087
    L_0x00c2:
        r6 = r4
    L_0x00c3:
        if (r6 == 0) goto L_0x00fb
        int r11 = r6.mo32624a()     // Catch:{ all -> 0x00f7 }
        r10.cancel(r11)     // Catch:{ all -> 0x00cd }
        goto L_0x00d1
    L_0x00cd:
        r10 = move-exception
        r10.printStackTrace()     // Catch:{ all -> 0x00f7 }
    L_0x00d1:
        com.ss.android.socialbase.downloader.downloader.f r10 = com.p530ss.android.socialbase.downloader.downloader.Downloader.m27478a(r9)     // Catch:{ all -> 0x00f7 }
        int r10 = r10.mo31926f(r11)     // Catch:{ all -> 0x00f7 }
        if (r10 != r1) goto L_0x00dc
        goto L_0x00dd
    L_0x00dc:
        r1 = 0
    L_0x00dd:
        java.lang.String r10 = f22439a     // Catch:{ all -> 0x00f7 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
        r0.<init>()     // Catch:{ all -> 0x00f7 }
        java.lang.String r2 = "doCancel, updateNotification id = "
        r0.append(r2)     // Catch:{ all -> 0x00f7 }
        r0.append(r11)     // Catch:{ all -> 0x00f7 }
        java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x00f7 }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27760c(r10, r11)     // Catch:{ all -> 0x00f7 }
        r6.mo31507a(r4, r1)     // Catch:{ all -> 0x00f7 }
        goto L_0x00fb
    L_0x00f7:
        r10 = move-exception
        r10.printStackTrace()
    L_0x00fb:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.notification.DownloadNotificationService.m28955a(android.app.NotificationManager, int):void");
    }
}
