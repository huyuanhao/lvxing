package com.qiyukf.unicorn.p513g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.service.NimReceiver;
import com.qiyukf.unicorn.api.SavePowerConfig;
import com.qiyukf.unicorn.p503f.C6168c;
import com.qiyukf.unicorn.p516j.C6207a;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.g.a */
public final class C6169a {
    /* renamed from: a */
    public static void m24481a(Context context) {
        SavePowerConfig f = C6177d.m24495a().mo29256f();
        long j = f == null ? -1 : f.checkInterval * 1000;
        if (j >= 0) {
            long max = Math.max(j, 900);
            Intent intent = new Intent(context, NimReceiver.class);
            intent.setAction("com.qiyukf.unicorn.ACTION.CHECK_MESSAGE");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
                if (broadcast != null) {
                    alarmManager.setRepeating(2, SystemClock.elapsedRealtime() + Math.max(max - (System.currentTimeMillis() - C6177d.m24495a().mo29252d()), 0), max, broadcast);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m24482a(final Context context, final boolean z) {
        new C6207a<Void, JSONObject>("Unicorn-HTTP") {
            /* access modifiers changed from: protected|final|synthetic */
            /* renamed from: a */
            public final /* synthetic */ Object mo27678a() {
                return C6168c.m24477a(C5718b.m23020g(), C5718b.m23015b(), C6177d.m24495a().mo29258h(), C5718b.m23019f(), C6177d.m24495a().mo29260j(), C6177d.m24495a().mo29261k());
            }

            /* access modifiers changed from: protected|final|synthetic */
            /* renamed from: a */
            public final /* synthetic */ void mo27679a(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                StringBuilder sb = new StringBuilder("query unread count: ");
                sb.append(jSONObject);
                C5264a.m21617a("PowerSaver", sb.toString());
                if (jSONObject != null) {
                    int b = C5366b.m22034b(jSONObject, "count");
                    int b2 = C5366b.m22034b(jSONObject, "push");
                    long c = C5366b.m22037c(jSONObject, "user");
                    long c2 = C5366b.m22037c(jSONObject, "app");
                    C6177d.m24495a().mo29247a(b2 == 1);
                    if (z) {
                        if (b > 0) {
                            C6174c.m24489a(context).mo29240a(1);
                        }
                        if (b2 == 1) {
                            SavePowerConfig f = C6177d.m24495a().mo29256f();
                            if (f != null && f.customPush) {
                                C6169a.m24483b(context);
                            }
                        }
                    } else {
                        C6174c.m24489a(context).mo29242b();
                    }
                    C6177d.m24495a().mo29253d(c);
                    C6177d.m24495a().mo29255e(c2);
                }
                C6177d.m24495a().mo29249b(System.currentTimeMillis());
            }
        }.mo29406a((Param[]) new Void[0]);
    }

    /* renamed from: b */
    public static void m24483b(Context context) {
        Intent intent = new Intent(context, NimReceiver.class);
        intent.setAction("com.qiyukf.unicorn.ACTION.CHECK_MESSAGE");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 268435456);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
            }
        }
    }
}
