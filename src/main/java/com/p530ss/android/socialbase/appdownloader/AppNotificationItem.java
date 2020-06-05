package com.p530ss.android.socialbase.appdownloader;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat.Builder;
import com.p530ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;

/* renamed from: com.ss.android.socialbase.appdownloader.e */
public class AppNotificationItem extends AbsNotificationItem {
    /* renamed from: a */
    private final Context f21543a;
    /* renamed from: b */
    private final Resources f21544b = this.f21543a.getResources();
    /* renamed from: c */
    private String f21545c;
    /* renamed from: d */
    private String f21546d;
    /* renamed from: e */
    private String f21547e;

    public AppNotificationItem(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.f21546d = str2;
        this.f21545c = str3;
        this.f21547e = str4;
        this.f21543a = context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo31508a(DownloadInfo cVar) {
        super.mo31508a(cVar);
        this.f21546d = cVar.mo32297k();
        this.f21545c = cVar.mo32287h();
        this.f21547e = cVar.mo32318y();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31507a(BaseException aVar, boolean z) {
        if (this.f21543a != null) {
            try {
                mo32628a(m26771b(aVar, z));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0133  */
    /* renamed from: b */
    private android.app.Notification m26771b(com.p530ss.android.socialbase.downloader.p560e.BaseException r24, boolean r25) {
        /*
        r23 = this;
        r0 = r23
        r1 = r24
        int r2 = r23.mo32634e()
        int r3 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26644a(r2)
        r4 = 0
        if (r3 != 0) goto L_0x0010
        return r4
    L_0x0010:
        androidx.core.app.NotificationCompat$Builder r5 = r23.m26773k()
        long r6 = r23.mo32635f()
        r5.setWhen(r6)
        int r6 = r23.mo32624a()
        com.ss.android.socialbase.downloader.k.a r7 = com.p530ss.android.socialbase.downloader.p567k.DownloadSetting.m28610a(r6)
        int r8 = android.os.Build.VERSION.SDK_INT
        r9 = 24
        r10 = 1
        r11 = 0
        if (r8 < r9) goto L_0x003b
        java.lang.String r8 = "set_notification_group"
        int r8 = r7.mo32547a(r8, r11)
        if (r8 != r10) goto L_0x003b
        java.lang.String r8 = "com.ss.android.socialbase.APP_DOWNLOADER"
        r5.setGroup(r8)
        r5.setGroupSummary(r11)
    L_0x003b:
        int r8 = r0.m26768a(r3)
        if (r8 != 0) goto L_0x0042
        return r4
    L_0x0042:
        r5.setSmallIcon(r8)
        r9 = -4
        r12 = -1
        r13 = 3
        java.lang.String r14 = "android.ss.intent.action.DOWNLOAD_DELETE"
        r15 = 2
        r4 = 4
        if (r3 == r10) goto L_0x0094
        if (r3 == r4) goto L_0x0094
        if (r3 != r15) goto L_0x0053
        goto L_0x0094
    L_0x0053:
        if (r3 != r13) goto L_0x00a9
        r5.setOngoing(r11)
        r5.setAutoCancel(r10)
        java.lang.String r16 = "android.ss.intent.action.DOWNLOAD_OPEN"
        if (r2 == r12) goto L_0x0082
        if (r2 != r9) goto L_0x0062
        goto L_0x0082
    L_0x0062:
        r9 = -3
        if (r2 != r9) goto L_0x0080
        java.lang.String r2 = "notification_click_install_auto_cancel"
        int r2 = r7.mo32547a(r2, r10)
        if (r2 != 0) goto L_0x0080
        r5.setAutoCancel(r11)
        int r2 = r23.mo32637h()
        if (r2 <= 0) goto L_0x007d
        r5.setOngoing(r11)
        r14 = r16
        r2 = 0
        goto L_0x0083
    L_0x007d:
        r5.setOngoing(r10)
    L_0x0080:
        r14 = r16
    L_0x0082:
        r2 = 1
    L_0x0083:
        android.app.PendingIntent r9 = r0.m26769a(r14, r3, r6)
        r5.setContentIntent(r9)
        java.lang.String r9 = "android.ss.intent.action.DOWNLOAD_HIDE"
        android.app.PendingIntent r9 = r0.m26769a(r9, r3, r6)
        r5.setDeleteIntent(r9)
        goto L_0x00aa
    L_0x0094:
        android.app.PendingIntent r2 = r0.m26769a(r14, r3, r6)
        r5.setContentIntent(r2)
        if (r3 == r10) goto L_0x00a2
        if (r3 != r4) goto L_0x00a0
        goto L_0x00a2
    L_0x00a0:
        r2 = 0
        goto L_0x00a3
    L_0x00a2:
        r2 = 1
    L_0x00a3:
        r5.setOngoing(r2)
        r5.setAutoCancel(r11)
    L_0x00a9:
        r2 = 1
    L_0x00aa:
        long r17 = r23.mo32630b()
        long r19 = r23.mo32632c()
        if (r3 == r10) goto L_0x00b9
        if (r3 != r4) goto L_0x00b7
        goto L_0x00b9
    L_0x00b7:
        r13 = 0
        goto L_0x00c6
    L_0x00b9:
        r21 = 0
        int r9 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
        if (r9 <= 0) goto L_0x00b7
        r21 = 100
        long r17 = r17 * r21
        long r12 = r17 / r19
        int r13 = (int) r12
    L_0x00c6:
        java.lang.String r12 = r23.mo32633d()
        boolean r16 = android.text.TextUtils.isEmpty(r12)
        if (r16 == 0) goto L_0x00dc
        java.lang.String r12 = "appdownloader_download_unknown_title"
        int r12 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r12)
        android.content.res.Resources r9 = r0.f21544b
        java.lang.String r12 = r9.getString(r12)
    L_0x00dc:
        android.widget.RemoteViews r9 = r23.m26772j()
        android.content.Intent r14 = new android.content.Intent
        android.content.Context r11 = r0.f21543a
        java.lang.Class<com.ss.android.socialbase.appdownloader.DownloadHandlerService> r15 = com.p530ss.android.socialbase.appdownloader.DownloadHandlerService.class
        r14.<init>(r11, r15)
        java.lang.String r11 = "android.ss.intent.action.DOWNLOAD_CLICK"
        r14.setAction(r11)
        java.lang.String r11 = r23.mo32633d()
        java.lang.String r15 = "notification_name"
        r14.putExtra(r15, r11)
        java.lang.String r11 = "extra_click_download_ids"
        r14.putExtra(r11, r6)
        java.lang.String r11 = "extra_click_download_type"
        r14.putExtra(r11, r3)
        int r11 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26825j()
        android.content.Context r15 = r0.f21543a
        r4 = 134217728(0x8000000, float:3.85186E-34)
        android.app.PendingIntent r4 = android.app.PendingIntent.getService(r15, r6, r14, r4)
        r9.setOnClickPendingIntent(r11, r4)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26827l()
        r9.setTextViewText(r4, r12)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26822g()
        r11 = 100
        r12 = r25
        r9.setProgressBar(r4, r11, r13, r12)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26826k()
        r9.setImageViewResource(r4, r8)
        java.lang.String r4 = "appdownloader_notification_download_pause"
        java.lang.String r8 = "/"
        java.lang.String r11 = ""
        r12 = 8
        if (r3 == r10) goto L_0x02f6
        r13 = 4
        if (r3 != r13) goto L_0x0138
        goto L_0x02f6
    L_0x0138:
        r13 = 2
        if (r3 != r13) goto L_0x01a7
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        long r6 = r23.mo32630b()
        java.lang.String r3 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26648a(r6)
        r1.append(r3)
        r1.append(r8)
        long r6 = r23.mo32632c()
        java.lang.String r3 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26648a(r6)
        r1.append(r3)
        java.lang.String r11 = r1.toString()
        int r1 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r4)
        android.content.Context r3 = r0.f21543a
        android.content.res.Resources r3 = r3.getResources()
        java.lang.String r1 = r3.getString(r1)
        java.lang.String r3 = "appdownloader_notification_download_resume"
        int r3 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r3)
        android.content.Context r4 = r0.f21543a
        android.content.res.Resources r4 = r4.getResources()
        java.lang.String r3 = r4.getString(r3)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26822g()
        r9.setViewVisibility(r4, r12)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26823h()
        r9.setViewVisibility(r4, r12)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26824i()
        r6 = 0
        r9.setViewVisibility(r4, r6)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26825j()
        java.lang.String r7 = r0.f21547e
        boolean r7 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26660a(r7)
        if (r7 == 0) goto L_0x01a2
        r9.setViewVisibility(r4, r12)
        goto L_0x0368
    L_0x01a2:
        r9.setViewVisibility(r4, r6)
        goto L_0x0368
    L_0x01a7:
        r4 = 3
        if (r3 != r4) goto L_0x02f3
        android.content.Context r3 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27342B()
        com.ss.android.socialbase.downloader.downloader.f r3 = com.p530ss.android.socialbase.downloader.downloader.Downloader.m27478a(r3)
        com.ss.android.socialbase.downloader.g.c r3 = r3.mo31928h(r6)
        int r4 = r23.mo32634e()
        r8 = -1
        if (r4 == r8) goto L_0x0267
        int r4 = r23.mo32634e()
        r8 = -4
        if (r4 != r8) goto L_0x01c6
        goto L_0x0267
    L_0x01c6:
        int r1 = r23.mo32634e()
        r4 = -3
        if (r1 != r4) goto L_0x0264
        long r7 = r23.mo32632c()
        java.lang.String r1 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26648a(r7)
        java.lang.String r4 = "appdownloader_notification_download_complete_open"
        if (r3 == 0) goto L_0x0231
        java.lang.String r7 = r3.mo32231ah()
        boolean r7 = android.text.TextUtils.isEmpty(r7)
        if (r7 != 0) goto L_0x0231
        java.lang.String r7 = r3.mo32231ah()
        java.lang.String r8 = "application/vnd.android.package-archive"
        boolean r7 = r7.equals(r8)
        if (r7 == 0) goto L_0x0231
        android.content.Context r6 = r0.f21543a
        java.lang.String r7 = r0.f21546d
        java.lang.String r8 = r0.f21545c
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r13 = "url: "
        r11.append(r13)
        java.lang.String r13 = r3.mo32295j()
        r11.append(r13)
        java.lang.String r13 = ", backupUrl: "
        r11.append(r13)
        java.lang.String r3 = r3.mo32165K()
        r11.append(r3)
        java.lang.String r3 = r11.toString()
        boolean r3 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26658a(r6, r7, r8, r3)
        if (r3 == 0) goto L_0x0221
        int r3 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r4)
        goto L_0x0245
    L_0x0221:
        java.lang.String r3 = "appdownloader_notification_download_complete_with_install"
        int r3 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r3)
        android.content.res.Resources r4 = r0.f21544b
        java.lang.String r4 = r4.getString(r3)
        r5.setContentText(r4)
        goto L_0x0245
    L_0x0231:
        java.lang.String r3 = "appdownloader_notification_download_complete_without_install"
        int r3 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r3)
        com.ss.android.socialbase.downloader.downloader.c r7 = com.p530ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.m27395a()
        com.ss.android.socialbase.downloader.d.d r6 = r7.mo31883l(r6)
        if (r6 == 0) goto L_0x0245
        int r3 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r4)
    L_0x0245:
        android.content.Context r4 = r0.f21543a
        android.content.res.Resources r4 = r4.getResources()
        java.lang.String r3 = r4.getString(r3)
        java.lang.String r4 = "appdownloader_notification_download_install"
        int r4 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r4)
        android.content.Context r6 = r0.f21543a
        android.content.res.Resources r6 = r6.getResources()
        java.lang.String r4 = r6.getString(r4)
        r11 = r1
        r1 = r3
        r3 = r4
        goto L_0x02d4
    L_0x0264:
        r1 = r11
        r3 = r1
        goto L_0x02d4
    L_0x0267:
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26829n()
        r9.setViewVisibility(r4, r12)
        if (r1 == 0) goto L_0x0289
        int r4 = r24.mo32073a()
        r6 = 1006(0x3ee, float:1.41E-42)
        if (r4 != r6) goto L_0x0289
        java.lang.String r1 = "appdownloader_notification_download_space_failed"
        int r1 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r1)
        android.content.Context r3 = r0.f21543a
        android.content.res.Resources r3 = r3.getResources()
        java.lang.String r1 = r3.getString(r1)
        goto L_0x02c4
    L_0x0289:
        boolean r1 = r0.m26770a(r1, r7, r3)
        if (r1 == 0) goto L_0x02b4
        if (r3 == 0) goto L_0x0299
        boolean r1 = r3.mo32317x()
        if (r1 == 0) goto L_0x0299
        r1 = 1
        goto L_0x029a
    L_0x0299:
        r1 = 0
    L_0x029a:
        if (r1 == 0) goto L_0x02a3
        java.lang.String r1 = "appdownloader_notification_download_waiting_wifi"
        int r1 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r1)
        goto L_0x02a9
    L_0x02a3:
        java.lang.String r1 = "appdownloader_notification_download_waiting_net"
        int r1 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r1)
    L_0x02a9:
        android.content.Context r3 = r0.f21543a
        android.content.res.Resources r3 = r3.getResources()
        java.lang.String r1 = r3.getString(r1)
        goto L_0x02c4
    L_0x02b4:
        java.lang.String r1 = "appdownloader_notification_download_failed"
        int r1 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r1)
        android.content.Context r3 = r0.f21543a
        android.content.res.Resources r3 = r3.getResources()
        java.lang.String r1 = r3.getString(r1)
    L_0x02c4:
        java.lang.String r3 = "appdownloader_notification_download_restart"
        int r3 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r3)
        android.content.Context r4 = r0.f21543a
        android.content.res.Resources r4 = r4.getResources()
        java.lang.String r3 = r4.getString(r3)
    L_0x02d4:
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26822g()
        r9.setViewVisibility(r4, r12)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26823h()
        r6 = 0
        r9.setViewVisibility(r4, r6)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26824i()
        r9.setViewVisibility(r4, r12)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26825j()
        r9.setViewVisibility(r4, r12)
        goto L_0x0368
    L_0x02f3:
        r1 = r11
        r3 = r1
        goto L_0x0368
    L_0x02f6:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        long r6 = r23.mo32630b()
        java.lang.String r6 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26648a(r6)
        r1.append(r6)
        r1.append(r8)
        long r6 = r23.mo32632c()
        java.lang.String r6 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26648a(r6)
        r1.append(r6)
        java.lang.String r11 = r1.toString()
        if (r3 != r10) goto L_0x0321
        java.lang.String r1 = "appdownloader_notification_downloading"
        int r1 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r1)
        goto L_0x0327
    L_0x0321:
        java.lang.String r1 = "appdownloader_notification_prepare"
        int r1 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r1)
    L_0x0327:
        android.content.Context r3 = r0.f21543a
        android.content.res.Resources r3 = r3.getResources()
        java.lang.String r1 = r3.getString(r1)
        int r3 = com.p530ss.android.socialbase.appdownloader.ResourceUtils.m26947b(r4)
        android.content.Context r4 = r0.f21543a
        android.content.res.Resources r4 = r4.getResources()
        java.lang.String r3 = r4.getString(r3)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26822g()
        r6 = 0
        r9.setViewVisibility(r4, r6)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26823h()
        r9.setViewVisibility(r4, r12)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26824i()
        r9.setViewVisibility(r4, r6)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26825j()
        java.lang.String r7 = r0.f21547e
        boolean r7 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26660a(r7)
        if (r7 == 0) goto L_0x0365
        r9.setViewVisibility(r4, r12)
        goto L_0x0368
    L_0x0365:
        r9.setViewVisibility(r4, r6)
    L_0x0368:
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26828m()
        r9.setTextViewText(r4, r11)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26830o()
        r9.setTextViewText(r4, r1)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26829n()
        r9.setTextViewText(r4, r11)
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26831p()
        r9.setTextViewText(r4, r1)
        int r1 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26825j()
        r9.setTextViewText(r1, r3)
        android.app.Notification r1 = r5.build()
        if (r2 == 0) goto L_0x039b
        int r2 = r1.flags
        r3 = 2
        r2 = r2 | r3
        r1.flags = r2
        r0.mo32629a(r10)
        goto L_0x039f
    L_0x039b:
        r2 = 0
        r0.mo32629a(r2)
    L_0x039f:
        r1.contentView = r9
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.appdownloader.AppNotificationItem.m26771b(com.ss.android.socialbase.downloader.e.a, boolean):android.app.Notification");
    }

    /* renamed from: a */
    private boolean m26770a(BaseException aVar, DownloadSetting aVar2, DownloadInfo cVar) {
        if (aVar != null && ((aVar.mo32073a() == 1013 || aVar.mo32073a() == 1049) && cVar != null)) {
            if ("application/vnd.android.package-archive".contains(cVar.mo32231ah()) && aVar2.mo32547a("notification_text_opt", 0) == 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    private RemoteViews m26772j() {
        RemoteViews remoteViews = new RemoteViews(this.f21543a.getPackageName(), AppResourceUtils.m26816a());
        if (VERSION.SDK_INT > 20) {
            try {
                if (AppDownloadUtils.m26663b(this.f21543a)) {
                    remoteViews.setInt(AppResourceUtils.m26821f(), "setBackgroundColor", this.f21543a.getResources().getColor(AppResourceUtils.m26832q()));
                }
            } catch (Throwable unused) {
            }
        }
        return remoteViews;
    }

    /* renamed from: a */
    private int m26768a(int i) {
        if (i == 1 || i == 4) {
            return AppResourceUtils.m26833r();
        }
        if (i == 2) {
            return AppResourceUtils.m26834s();
        }
        if (i == 3) {
            return AppResourceUtils.m26835t();
        }
        return 0;
    }

    /* renamed from: a */
    private PendingIntent m26769a(String str, int i, int i2) {
        Intent intent = new Intent(this.f21543a, DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f21543a, i2, intent, 134217728);
    }

    /* renamed from: k */
    private Builder m26773k() {
        String g = AppDownloader.m26714h().mo31494g();
        if (VERSION.SDK_INT < 26) {
            return new Builder(this.f21543a);
        }
        if (TextUtils.isEmpty(g)) {
            g = AppDownloadUtils.m26665c(this.f21543a);
        }
        try {
            if (AppDownloader.m26714h().mo31495i() != null) {
                return AppDownloader.m26714h().mo31495i().mo31470a(this.f21543a, g);
            }
            return new Builder(this.f21543a, g);
        } catch (NoSuchMethodError unused) {
            return new Builder(this.f21543a);
        }
    }
}
