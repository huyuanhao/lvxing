package com.kwad.sdk.core.download.p324b;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat.Builder;
import com.ksad.download.C3603b;
import com.ksad.download.C3608d;
import com.ksad.download.C3613f;
import com.ksad.download.C3614g;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.diskcache.p322b.C4079a;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.p306a.C3809l;
import java.io.File;

/* renamed from: com.kwad.sdk.core.download.b.a */
public class C4095a implements C3613f {
    /* renamed from: a */
    private static final Handler f13754a = new C4096a();

    /* renamed from: com.kwad.sdk.core.download.b.a$a */
    private static class C4096a extends Handler {
        /* renamed from: a */
        private final SparseArray<Long> f13755a = new SparseArray<>();

        C4096a() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            boolean z = false;
            boolean z2 = message.arg1 == 1;
            if (message.arg2 == 1) {
                z = true;
            }
            Long l = (Long) this.f13755a.get(message.what);
            NotificationManager notificationManager = (NotificationManager) C3603b.m15023a().getSystemService("notification");
            if (notificationManager != null) {
                if (C3608d.m15048a().mo22716a(message.what) == null) {
                    removeMessages(message.what);
                    notificationManager.cancel(message.what);
                    return;
                }
                if (z2 || l == null || System.currentTimeMillis() - l.longValue() >= 110) {
                    if (z) {
                        notificationManager.cancel(message.what);
                    }
                    C4095a.m17014b(message.what, (Notification) message.obj);
                    this.f13755a.put(message.what, Long.valueOf(System.currentTimeMillis()));
                } else {
                    sendMessageDelayed(Message.obtain(message), (l.longValue() + 110) - System.currentTimeMillis());
                }
            }
        }
    }

    /* renamed from: a */
    private static String m17012a(long j) {
        return String.format("%.2fMB", new Object[]{Float.valueOf((((float) j) / 1000.0f) / 1000.0f)});
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m17014b(int i, Notification notification) {
        Context context = KsAdSDK.getContext();
        if (context != null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            try {
                if (VERSION.SDK_INT >= 26) {
                    NotificationChannel notificationChannel = new NotificationChannel("download_channel", "ksad", 3);
                    notificationChannel.enableLights(false);
                    notificationChannel.enableVibration(false);
                    notificationChannel.setSound(null, null);
                    notificationChannel.setShowBadge(false);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                notificationManager.notify(i, notification);
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }
    }

    /* renamed from: a */
    public void mo22735a(int i) {
        Context context = KsAdSDK.getContext();
        if (context != null) {
            ((NotificationManager) context.getSystemService("notification")).cancel(i);
        }
    }

    /* renamed from: a */
    public void mo22736a(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (!TextUtils.isEmpty(str)) {
                File c = C4079a.m16947a().mo23762c(str);
                if (c == null || !c.exists()) {
                    C4079a.m16947a().mo23759a(str);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo22737a(DownloadTask downloadTask, boolean z) {
        Context context = KsAdSDK.getContext();
        if (context != null) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C3809l.m15792b(context, "ksad_notification_download_progress"));
            Object tag = downloadTask.getTag();
            String str = "ksad_notification_default_icon";
            String str2 = "ksad_download_icon";
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File c = C4079a.m16947a().mo23762c(downloadParams.mAppIcon);
                if (c == null || !c.exists()) {
                    remoteViews.setImageViewResource(C3809l.m15789a(context, str2), C3809l.m15795d(context, str));
                } else {
                    remoteViews.setImageViewBitmap(C3809l.m15789a(context, str2), BitmapFactory.decodeFile(c.getAbsolutePath()));
                }
                remoteViews.setTextViewText(C3809l.m15789a(context, "ksad_download_name"), downloadParams.mAppName);
            } else {
                remoteViews.setImageViewResource(C3809l.m15789a(context, str2), C3809l.m15795d(context, str));
            }
            remoteViews.setTextViewText(C3809l.m15789a(context, "ksad_download_status"), "正在下载");
            int a = C3809l.m15789a(context, "ksad_download_size");
            StringBuilder sb = new StringBuilder();
            sb.append(m17012a((long) downloadTask.getSmallFileSoFarBytes()));
            sb.append(" / ");
            sb.append(m17012a((long) downloadTask.getSmallFileTotalBytes()));
            remoteViews.setTextViewText(a, sb.toString());
            int smallFileSoFarBytes = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
            int a2 = C3809l.m15789a(context, "ksad_download_percent_num");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("下载进度：  ");
            sb2.append(smallFileSoFarBytes);
            sb2.append("%");
            remoteViews.setTextViewText(a2, sb2.toString());
            remoteViews.setProgressBar(C3809l.m15789a(context, "ksad_download_progress"), 100, smallFileSoFarBytes, false);
            Builder builder = new Builder(context, "download_channel");
            builder.setContent(remoteViews).setWhen(System.currentTimeMillis()).setPriority(0).setOngoing(true).setOnlyAlertOnce(true).setPriority(-1).setSmallIcon(C3809l.m15795d(context, "ksad_notification_small_icon"));
            f13754a.removeMessages(downloadTask.getId());
            f13754a.obtainMessage(downloadTask.getId(), z, downloadTask.isCompleted(), builder.build()).sendToTarget();
        }
    }

    /* renamed from: b */
    public void mo22738b(DownloadTask downloadTask) {
        Context context = KsAdSDK.getContext();
        if (context != null) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C3809l.m15792b(context, "ksad_notification_download_completed"));
            Object tag = downloadTask.getTag();
            String str = "ksad_notification_default_icon";
            String str2 = "ksad_download_icon";
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File c = C4079a.m16947a().mo23762c(downloadParams.mAppIcon);
                if (c == null || !c.exists()) {
                    remoteViews.setImageViewResource(C3809l.m15789a(context, str2), C3809l.m15795d(context, str));
                } else {
                    remoteViews.setImageViewBitmap(C3809l.m15789a(context, str2), BitmapFactory.decodeFile(c.getAbsolutePath()));
                }
                remoteViews.setTextViewText(C3809l.m15789a(context, "ksad_download_name"), downloadParams.mAppName);
            } else {
                remoteViews.setImageViewResource(C3809l.m15789a(context, str2), C3809l.m15795d(context, str));
            }
            remoteViews.setTextViewText(C3809l.m15789a(context, "ksad_download_status"), "下载完成");
            remoteViews.setTextViewText(C3809l.m15789a(context, "ksad_download_size"), m17012a((long) downloadTask.getSmallFileTotalBytes()));
            remoteViews.setTextViewText(C3809l.m15789a(context, "ksad_download_install"), "立即安装");
            Builder builder = new Builder(context, "download_channel");
            builder.setContent(remoteViews).setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(true).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(C3614g.m15077a(downloadTask)).setSmallIcon(C3809l.m15795d(context, "ksad_notification_small_icon"));
            f13754a.removeMessages(downloadTask.getId());
            f13754a.obtainMessage(downloadTask.getId(), 1, 1, builder.build()).sendToTarget();
        }
    }
}
