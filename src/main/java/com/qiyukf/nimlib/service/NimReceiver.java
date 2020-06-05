package com.qiyukf.nimlib.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.unicorn.p513g.C6169a;

public class NimReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static int m23849a(String str) {
        if ("com.qiyukf.nim.ACTION.ALARM.REPEATING".equals(str)) {
            return 2;
        }
        return "com.qiyukf.unicorn.ACTION.CHECK_MESSAGE".equals(str) ? 5 : 3;
    }

    /* renamed from: a */
    public static void m23850a(Context context) {
        C5264a.m21624d(NotificationCompat.CATEGORY_SERVICE, "start repeating alarm");
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent(applicationContext, NimReceiver.class);
        intent.setAction("com.qiyukf.nim.ACTION.ALARM.REPEATING");
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(applicationContext, 0, intent, 134217728);
            if (broadcast != null) {
                try {
                    alarmManager.setRepeating(2, 600000 + SystemClock.elapsedRealtime(), 600000, broadcast);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if ("com.qiyukf.unicorn.ACTION.CHECK_MESSAGE".equals(intent.getAction())) {
                if (!C5743d.m23120e().logined()) {
                    if (!C5743d.m23112a()) {
                        NimService.m23852a(context, m23849a(intent.getAction()));
                    }
                    if (C5718b.m23009a() != null) {
                        C6169a.m24482a(context, true);
                    }
                }
            } else if (!C5743d.m23112a()) {
                if (!TextUtils.isEmpty(C5718b.m23015b())) {
                    NimService.m23852a(context, m23849a(intent.getAction()));
                    return;
                }
                C5264a.m21624d(NotificationCompat.CATEGORY_SERVICE, "stop alarm");
                Context applicationContext = context.getApplicationContext();
                Intent intent2 = new Intent(applicationContext, NimReceiver.class);
                intent2.setAction("com.qiyukf.nim.ACTION.ALARM.REPEATING");
                AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
                if (alarmManager != null) {
                    PendingIntent broadcast = PendingIntent.getBroadcast(applicationContext, 0, intent2, 268435456);
                    if (broadcast != null) {
                        alarmManager.cancel(broadcast);
                    }
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("NimReceiver on Receive exception, e=");
            sb.append(th.getMessage());
            C5264a.m21622c("NimReceiver", sb.toString());
        }
    }
}
