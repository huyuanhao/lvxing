package com.p368pw.p392us;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.LruCache;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat.Builder;
import com.p368pw.inner.base.p387d.C5196m.C5202b;
import com.p368pw.inner.base.p387d.C5196m.C5203c;
import com.pw.R;
import com.tencent.stat.apkreader.ChannelReader;
import java.util.HashMap;

/* renamed from: com.pw.us.DownloadNotifyManager */
public class DownloadNotifyManager {
    /* access modifiers changed from: private|static */
    public static LruCache<String, Bitmap> bitmapCache = new LruCache<>(3);
    private static HashMap<String, Integer> lastUpdateProgress = new HashMap<>();
    private static HashMap<String, Long> lastUpdateTime = new HashMap<>();

    private static void loadImageAndShowNotification(Context context, String str, String str2, String str3, int i, boolean z) {
        Bitmap bitmap = (Bitmap) bitmapCache.get(str2);
        if (bitmap != null) {
            showNotification(context, str, bitmap, str3, i, z);
            return;
        }
        C5203c cVar = new C5203c(context);
        final String str4 = str2;
        final Context context2 = context;
        final String str5 = str;
        final String str6 = str3;
        final int i2 = i;
        final boolean z2 = z;
        C52391 r1 = new C5202b() {
            public void onBitmapLoadFailed(String str) {
                DownloadNotifyManager.showNotification(context2, str5, null, str6, i2, z2);
            }

            public void onBitmapLoadSuccess(Bitmap bitmap) {
                if (bitmap == null) {
                    onBitmapLoadFailed("bitmap is null.");
                    return;
                }
                DownloadNotifyManager.bitmapCache.put(str4, bitmap);
                DownloadNotifyManager.showNotification(context2, str5, bitmap, str6, i2, z2);
            }
        };
        cVar.mo26827a((C5202b) r1).mo26828a(str2).mo26829a().mo26818a();
    }

    /* access modifiers changed from: private|static */
    public static void showNotification(Context context, String str, Bitmap bitmap, String str2, int i, boolean z) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.win_sdk_layout_notification_progress);
        String str3 = "setText";
        remoteViews.setCharSequence(R.id.win_sdk_name, str3, str2);
        int i2 = R.id.win_sdk_progress_text;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("%");
        remoteViews.setCharSequence(i2, str3, sb.toString());
        remoteViews.setProgressBar(R.id.win_sdk_progress, 100, i, false);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.win_sdk_icon, bitmap);
        }
        remoteViews.setCharSequence(R.id.win_sdk_downloading_text, str3, z ? "下载完成" : "正在下载");
        Builder autoCancel = new Builder(context, context.getPackageName()).setPriority(-1).setSmallIcon(R.drawable.win_down_icon).setCustomContentView(remoteViews).setOngoing(false).setDefaults(8).setVibrate(null).setOnlyAlertOnce(true).setSound(null).setAutoCancel(false);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(context.getPackageName(), ChannelReader.CHANNEL_KEY, 3);
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setSound(null, null);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        if (notificationManager != null) {
            notificationManager.notify(str.hashCode(), autoCancel.build());
        }
    }

    public static void showNotify(Context context, String str, String str2, String str3, int i, boolean z) {
        if (!z) {
            Integer num = (Integer) lastUpdateProgress.get(str);
            if (num == null || num.intValue() != i) {
                Long l = (Long) lastUpdateTime.get(str);
                if (l == null || System.currentTimeMillis() - l.longValue() >= 1000) {
                    lastUpdateTime.put(str, Long.valueOf(System.currentTimeMillis()));
                    lastUpdateProgress.put(str, Integer.valueOf(i));
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            lastUpdateTime.remove(str);
            lastUpdateProgress.remove(str);
        }
        loadImageAndShowNotification(context, str, str2, str3, i, z);
    }
}
