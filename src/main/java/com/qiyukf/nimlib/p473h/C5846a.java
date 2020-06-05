package com.qiyukf.nimlib.p473h;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.service.NimService;

/* renamed from: com.qiyukf.nimlib.h.a */
public class C5846a {
    /* renamed from: a */
    private long f18547a;
    /* renamed from: b */
    private long f18548b;
    /* renamed from: c */
    private boolean f18549c;

    /* renamed from: a */
    private static void m23424a(Context context, long j) {
        C5264a.m21624d(NotificationCompat.CATEGORY_SERVICE, "start keep alive alarm");
        Context applicationContext = context.getApplicationContext();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            PendingIntent service = PendingIntent.getService(applicationContext, 0, NimService.m23851a(applicationContext), 134217728);
            if (service != null) {
                try {
                    if (VERSION.SDK_INT >= 19) {
                        alarmManager.setExact(2, SystemClock.elapsedRealtime() + j, service);
                    } else {
                        alarmManager.set(2, SystemClock.elapsedRealtime() + j, service);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo28160a() {
    }

    /* renamed from: a */
    public final void mo28161a(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (z) {
            this.f18548b = elapsedRealtime;
            return;
        }
        this.f18547a = elapsedRealtime;
        this.f18549c = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo28162b() {
    }

    /* renamed from: c */
    public final void mo28163c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!this.f18549c) {
            long j = this.f18547a;
            if (elapsedRealtime - j < 240000) {
                long j2 = this.f18548b;
                if (elapsedRealtime - j2 < 250000) {
                    m23424a(C5718b.m23009a(), Math.max(Math.min(250000 - (elapsedRealtime - j2), 240000 - (elapsedRealtime - j)), 10000));
                    return;
                }
            }
            this.f18549c = true;
            mo28160a();
            m23424a(C5718b.m23009a(), 10000);
            return;
        }
        C5264a.m21617a("core", "reader idle timeout.");
        mo28162b();
    }

    /* renamed from: d */
    public final void mo28164d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f18548b = elapsedRealtime;
        this.f18547a = elapsedRealtime;
        this.f18549c = false;
        m23424a(C5718b.m23009a(), 240000);
    }

    /* renamed from: e */
    public final void mo28165e() {
        Context a = C5718b.m23009a();
        C5264a.m21624d(NotificationCompat.CATEGORY_SERVICE, "stop alarm");
        Context applicationContext = a.getApplicationContext();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            PendingIntent service = PendingIntent.getService(applicationContext, 0, NimService.m23851a(applicationContext), 268435456);
            if (service != null) {
                alarmManager.cancel(service);
            }
        }
        this.f18547a = 0;
        this.f18548b = 0;
        this.f18549c = false;
    }
}
