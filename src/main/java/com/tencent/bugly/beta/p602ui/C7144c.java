package com.tencent.bugly.beta.p602ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import androidx.core.app.NotificationCompat.Builder;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C7127a;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7282y;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.c */
public class C7144c {
    /* renamed from: a */
    public static C7144c f23780a = new C7144c();
    /* renamed from: b */
    public DownloadTask f23781b;
    /* renamed from: c */
    public String f23782c;
    /* renamed from: d */
    public C7282y f23783d;
    /* renamed from: e */
    public C7143b f23784e;
    /* renamed from: f */
    private NotificationManager f23785f;
    /* renamed from: g */
    private Notification f23786g;
    /* renamed from: h */
    private Context f23787h = C7131e.f23698E.f23747s;
    /* renamed from: i */
    private boolean f23788i = true;
    /* renamed from: j */
    private long f23789j;
    /* renamed from: k */
    private Builder f23790k;

    private C7144c() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23787h.getPackageName());
        sb.append(".beta.DOWNLOAD_NOTIFY");
        this.f23782c = sb.toString();
        this.f23785f = (NotificationManager) this.f23787h.getSystemService("notification");
        this.f23787h.registerReceiver(new BetaReceiver(), new IntentFilter(this.f23782c));
        m30574b();
    }

    /* renamed from: b */
    private void m30574b() {
        if (VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("001", "bugly_upgrade", 2);
            notificationChannel.setDescription("bugly upgrade");
            notificationChannel.enableVibration(false);
            notificationChannel.setVibrationPattern(new long[]{0});
            this.f23785f.createNotificationChannel(notificationChannel);
        }
    }

    /* renamed from: a */
    public void mo34444a(DownloadTask downloadTask) {
        this.f23781b = downloadTask;
        this.f23789j = this.f23781b.getSavedLength();
        this.f23788i = downloadTask.isNeededNotify();
        if (this.f23788i && C7131e.f23698E.f23716R) {
            this.f23785f.cancel(1000);
            Intent intent = new Intent(this.f23782c);
            intent.putExtra("request", 1);
            if (this.f23790k == null) {
                if (VERSION.SDK_INT >= 26) {
                    try {
                        this.f23790k = new Builder(this.f23787h, "001");
                    } catch (Throwable unused) {
                        this.f23790k = new Builder(this.f23787h);
                    }
                } else {
                    this.f23790k = new Builder(this.f23787h);
                }
            }
            Builder builder = this.f23790k;
            StringBuilder sb = new StringBuilder();
            sb.append(Beta.strNotificationDownloading);
            sb.append(C7131e.f23698E.f23753y);
            Builder contentTitle = builder.setTicker(sb.toString()).setContentTitle(C7131e.f23698E.f23753y);
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[2];
            objArr[0] = Beta.strNotificationDownloading;
            long j = 0;
            if (this.f23781b.getTotalLength() != 0) {
                j = (this.f23781b.getSavedLength() * 100) / this.f23781b.getTotalLength();
            }
            objArr[1] = Integer.valueOf((int) j);
            contentTitle.setContentText(String.format(locale, "%s %d%%", objArr)).setContentIntent(PendingIntent.getBroadcast(this.f23787h, 1, intent, 268435456)).setAutoCancel(false);
            if (C7131e.f23698E.f23734f > 0) {
                this.f23790k.setSmallIcon(C7131e.f23698E.f23734f);
            } else if (!(C7131e.f23698E.f23754z == null || C7131e.f23698E.f23754z.applicationInfo == null)) {
                this.f23790k.setSmallIcon(C7131e.f23698E.f23754z.applicationInfo.icon);
            }
            try {
                if (C7131e.f23698E.f23735g > 0 && this.f23787h.getResources().getDrawable(C7131e.f23698E.f23735g) != null) {
                    this.f23790k.setLargeIcon(C7127a.m30542a(this.f23787h.getResources().getDrawable(C7131e.f23698E.f23735g)));
                }
            } catch (NotFoundException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[initNotify] ");
                sb2.append(e.getMessage());
                C7226an.m31146c(C7144c.class, sb2.toString(), new Object[0]);
            }
            this.f23786g = this.f23790k.build();
            this.f23785f.notify(1000, this.f23786g);
        }
    }

    /* renamed from: a */
    public void mo34443a() {
        if (this.f23788i && this.f23781b != null && C7131e.f23698E.f23716R) {
            if (this.f23781b.getSavedLength() - this.f23789j > 307200 || this.f23781b.getStatus() == 1 || this.f23781b.getStatus() == 5 || this.f23781b.getStatus() == 3) {
                this.f23789j = this.f23781b.getSavedLength();
                String str = "%s %s";
                if (this.f23781b.getStatus() == 1) {
                    this.f23790k.setAutoCancel(true).setContentText(Beta.strNotificationClickToInstall).setContentTitle(String.format(str, new Object[]{C7131e.f23698E.f23753y, Beta.strNotificationDownloadSucc}));
                } else if (this.f23781b.getStatus() == 5) {
                    this.f23790k.setAutoCancel(false).setContentText(Beta.strNotificationClickToRetry).setContentTitle(String.format(str, new Object[]{C7131e.f23698E.f23753y, Beta.strNotificationDownloadError}));
                } else {
                    String str2 = "%s %d%%";
                    long j = 0;
                    if (this.f23781b.getStatus() == 2) {
                        Builder contentTitle = this.f23790k.setContentTitle(C7131e.f23698E.f23753y);
                        Locale locale = Locale.getDefault();
                        Object[] objArr = new Object[2];
                        objArr[0] = Beta.strNotificationDownloading;
                        if (this.f23781b.getTotalLength() != 0) {
                            j = (this.f23781b.getSavedLength() * 100) / this.f23781b.getTotalLength();
                        }
                        objArr[1] = Integer.valueOf((int) j);
                        contentTitle.setContentText(String.format(locale, str2, objArr)).setAutoCancel(false);
                    } else if (this.f23781b.getStatus() == 3) {
                        Builder contentTitle2 = this.f23790k.setContentTitle(C7131e.f23698E.f23753y);
                        Locale locale2 = Locale.getDefault();
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Beta.strNotificationClickToContinue;
                        if (this.f23781b.getTotalLength() != 0) {
                            j = (this.f23781b.getSavedLength() * 100) / this.f23781b.getTotalLength();
                        }
                        objArr2[1] = Integer.valueOf((int) j);
                        contentTitle2.setContentText(String.format(locale2, str2, objArr2)).setAutoCancel(false);
                    }
                }
                this.f23786g = this.f23790k.build();
                this.f23785f.notify(1000, this.f23786g);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002f */
    /* renamed from: a */
    public synchronized void mo34445a(com.tencent.bugly.proguard.C7282y r9, com.tencent.bugly.beta.p602ui.C7143b r10) {
        /*
        r8 = this;
        monitor-enter(r8)
        r8.f23783d = r9     // Catch:{ all -> 0x0109 }
        r8.f23784e = r10     // Catch:{ all -> 0x0109 }
        android.app.NotificationManager r10 = r8.f23785f     // Catch:{ all -> 0x0109 }
        r0 = 1001(0x3e9, float:1.403E-42)
        r10.cancel(r0)     // Catch:{ all -> 0x0109 }
        android.content.Intent r10 = new android.content.Intent     // Catch:{ all -> 0x0109 }
        java.lang.String r1 = r8.f23782c     // Catch:{ all -> 0x0109 }
        r10.<init>(r1)     // Catch:{ all -> 0x0109 }
        java.lang.String r1 = "request"
        r2 = 2
        r10.putExtra(r1, r2)     // Catch:{ all -> 0x0109 }
        androidx.core.app.NotificationCompat$Builder r1 = r8.f23790k     // Catch:{ all -> 0x0109 }
        if (r1 != 0) goto L_0x0042
        int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0109 }
        r3 = 26
        if (r1 < r3) goto L_0x0039
        androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch:{ all -> 0x002f }
        android.content.Context r3 = r8.f23787h     // Catch:{ all -> 0x002f }
        java.lang.String r4 = "001"
        r1.m38722init(r3, r4)     // Catch:{ all -> 0x002f }
        r8.f23790k = r1     // Catch:{ all -> 0x002f }
        goto L_0x0042
    L_0x002f:
        androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch:{ all -> 0x0109 }
        android.content.Context r3 = r8.f23787h     // Catch:{ all -> 0x0109 }
        r1.m38721init(r3)     // Catch:{ all -> 0x0109 }
        r8.f23790k = r1     // Catch:{ all -> 0x0109 }
        goto L_0x0042
    L_0x0039:
        androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch:{ all -> 0x0109 }
        android.content.Context r3 = r8.f23787h     // Catch:{ all -> 0x0109 }
        r1.m38721init(r3)     // Catch:{ all -> 0x0109 }
        r8.f23790k = r1     // Catch:{ all -> 0x0109 }
    L_0x0042:
        androidx.core.app.NotificationCompat$Builder r1 = r8.f23790k     // Catch:{ all -> 0x0109 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
        r3.<init>()     // Catch:{ all -> 0x0109 }
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0109 }
        java.lang.String r4 = r4.f23753y     // Catch:{ all -> 0x0109 }
        r3.append(r4)     // Catch:{ all -> 0x0109 }
        java.lang.String r4 = com.tencent.bugly.beta.Beta.strNotificationHaveNewVersion     // Catch:{ all -> 0x0109 }
        r3.append(r4)     // Catch:{ all -> 0x0109 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0109 }
        androidx.core.app.NotificationCompat$Builder r1 = r1.setTicker(r3)     // Catch:{ all -> 0x0109 }
        java.lang.String r3 = "%s %s"
        java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0109 }
        com.tencent.bugly.beta.global.e r5 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0109 }
        java.lang.String r5 = r5.f23753y     // Catch:{ all -> 0x0109 }
        r6 = 0
        r4[r6] = r5     // Catch:{ all -> 0x0109 }
        java.lang.String r5 = com.tencent.bugly.beta.Beta.strNotificationHaveNewVersion     // Catch:{ all -> 0x0109 }
        r7 = 1
        r4[r7] = r5     // Catch:{ all -> 0x0109 }
        java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x0109 }
        androidx.core.app.NotificationCompat$Builder r1 = r1.setContentTitle(r3)     // Catch:{ all -> 0x0109 }
        android.content.Context r3 = r8.f23787h     // Catch:{ all -> 0x0109 }
        r4 = 268435456(0x10000000, float:2.5243549E-29)
        android.app.PendingIntent r10 = android.app.PendingIntent.getBroadcast(r3, r2, r10, r4)     // Catch:{ all -> 0x0109 }
        androidx.core.app.NotificationCompat$Builder r10 = r1.setContentIntent(r10)     // Catch:{ all -> 0x0109 }
        androidx.core.app.NotificationCompat$Builder r10 = r10.setAutoCancel(r7)     // Catch:{ all -> 0x0109 }
        java.lang.String r1 = "%s.%s"
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0109 }
        com.tencent.bugly.proguard.v r3 = r9.f24657e     // Catch:{ all -> 0x0109 }
        java.lang.String r3 = r3.f24626d     // Catch:{ all -> 0x0109 }
        r2[r6] = r3     // Catch:{ all -> 0x0109 }
        com.tencent.bugly.proguard.v r9 = r9.f24657e     // Catch:{ all -> 0x0109 }
        int r9 = r9.f24625c     // Catch:{ all -> 0x0109 }
        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0109 }
        r2[r7] = r9     // Catch:{ all -> 0x0109 }
        java.lang.String r9 = java.lang.String.format(r1, r2)     // Catch:{ all -> 0x0109 }
        r10.setContentText(r9)     // Catch:{ all -> 0x0109 }
        com.tencent.bugly.beta.global.e r9 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0109 }
        int r9 = r9.f23734f     // Catch:{ all -> 0x0109 }
        if (r9 <= 0) goto L_0x00b0
        androidx.core.app.NotificationCompat$Builder r9 = r8.f23790k     // Catch:{ all -> 0x0109 }
        com.tencent.bugly.beta.global.e r10 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0109 }
        int r10 = r10.f23734f     // Catch:{ all -> 0x0109 }
        r9.setSmallIcon(r10)     // Catch:{ all -> 0x0109 }
        goto L_0x00cb
    L_0x00b0:
        com.tencent.bugly.beta.global.e r9 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0109 }
        android.content.pm.PackageInfo r9 = r9.f23754z     // Catch:{ all -> 0x0109 }
        if (r9 == 0) goto L_0x00cb
        com.tencent.bugly.beta.global.e r9 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0109 }
        android.content.pm.PackageInfo r9 = r9.f23754z     // Catch:{ all -> 0x0109 }
        android.content.pm.ApplicationInfo r9 = r9.applicationInfo     // Catch:{ all -> 0x0109 }
        if (r9 == 0) goto L_0x00cb
        androidx.core.app.NotificationCompat$Builder r9 = r8.f23790k     // Catch:{ all -> 0x0109 }
        com.tencent.bugly.beta.global.e r10 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0109 }
        android.content.pm.PackageInfo r10 = r10.f23754z     // Catch:{ all -> 0x0109 }
        android.content.pm.ApplicationInfo r10 = r10.applicationInfo     // Catch:{ all -> 0x0109 }
        int r10 = r10.icon     // Catch:{ all -> 0x0109 }
        r9.setSmallIcon(r10)     // Catch:{ all -> 0x0109 }
    L_0x00cb:
        com.tencent.bugly.beta.global.e r9 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0109 }
        int r9 = r9.f23735g     // Catch:{ all -> 0x0109 }
        if (r9 <= 0) goto L_0x00f8
        android.content.Context r9 = r8.f23787h     // Catch:{ all -> 0x0109 }
        android.content.res.Resources r9 = r9.getResources()     // Catch:{ all -> 0x0109 }
        com.tencent.bugly.beta.global.e r10 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0109 }
        int r10 = r10.f23735g     // Catch:{ all -> 0x0109 }
        android.graphics.drawable.Drawable r9 = r9.getDrawable(r10)     // Catch:{ all -> 0x0109 }
        if (r9 == 0) goto L_0x00f8
        androidx.core.app.NotificationCompat$Builder r9 = r8.f23790k     // Catch:{ all -> 0x0109 }
        android.content.Context r10 = r8.f23787h     // Catch:{ all -> 0x0109 }
        android.content.res.Resources r10 = r10.getResources()     // Catch:{ all -> 0x0109 }
        com.tencent.bugly.beta.global.e r1 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x0109 }
        int r1 = r1.f23735g     // Catch:{ all -> 0x0109 }
        android.graphics.drawable.Drawable r10 = r10.getDrawable(r1)     // Catch:{ all -> 0x0109 }
        android.graphics.Bitmap r10 = com.tencent.bugly.beta.global.C7127a.m30542a(r10)     // Catch:{ all -> 0x0109 }
        r9.setLargeIcon(r10)     // Catch:{ all -> 0x0109 }
    L_0x00f8:
        androidx.core.app.NotificationCompat$Builder r9 = r8.f23790k     // Catch:{ all -> 0x0109 }
        android.app.Notification r9 = r9.build()     // Catch:{ all -> 0x0109 }
        r8.f23786g = r9     // Catch:{ all -> 0x0109 }
        android.app.NotificationManager r9 = r8.f23785f     // Catch:{ all -> 0x0109 }
        android.app.Notification r10 = r8.f23786g     // Catch:{ all -> 0x0109 }
        r9.notify(r0, r10)     // Catch:{ all -> 0x0109 }
        monitor-exit(r8)
        return
    L_0x0109:
        r9 = move-exception
        monitor-exit(r8)
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.p602ui.C7144c.mo34445a(com.tencent.bugly.proguard.y, com.tencent.bugly.beta.ui.b):void");
    }
}
