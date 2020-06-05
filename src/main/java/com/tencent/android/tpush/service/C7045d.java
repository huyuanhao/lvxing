package com.tencent.android.tpush.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import androidx.core.app.NotificationCompat;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.d */
public class C7045d {
    /* renamed from: a */
    private static C7045d f23423a = new C7045d();
    /* renamed from: b */
    private static AlarmManager f23424b = null;

    private C7045d() {
    }

    /* renamed from: a */
    public static C7045d m30117a() {
        if (f23424b == null) {
            m30118b();
        }
        return f23423a;
    }

    /* renamed from: a */
    public void mo34149a(int i, long j, PendingIntent pendingIntent) {
        if (f23424b != null) {
            if (VERSION.SDK_INT >= 23) {
                try {
                    Method declaredMethod = f23424b.getClass().getDeclaredMethod("setAndAllowWhileIdle", new Class[]{Integer.class, Long.class, PendingIntent.class});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(f23424b, new Object[]{Integer.valueOf(i), Long.valueOf(j), pendingIntent});
                    return;
                } catch (Throwable th) {
                    C6864a.m29306g(Constants.LogTag, th.getMessage());
                }
            }
            f23424b.set(i, j, pendingIntent);
        }
    }

    /* renamed from: b */
    private static synchronized void m30118b() {
        synchronized (C7045d.class) {
            if (f23424b == null && C6973b.m29776f() != null) {
                f23424b = (AlarmManager) C6973b.m29776f().getSystemService(NotificationCompat.CATEGORY_ALARM);
            }
        }
    }
}
