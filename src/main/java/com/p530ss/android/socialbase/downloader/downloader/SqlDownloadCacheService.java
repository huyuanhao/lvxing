package com.p530ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.p530ss.android.socialbase.downloader.impls.DefaultDownloadCache;

/* renamed from: com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService */
public class SqlDownloadCacheService extends Service {
    /* renamed from: a */
    private static final String f21821a = SqlDownloadCacheService.class.getSimpleName();

    /* renamed from: a */
    public static void m27322a(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                Log.w(f21821a, "startServiceAndBind fail", th);
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        C6694b.m27353a(getApplicationContext());
    }

    public IBinder onBind(Intent intent) {
        IDownloadCache p = C6694b.m27384p();
        ISqlDownloadCache sVar = p instanceof DefaultDownloadCache ? ((DefaultDownloadCache) p).mo32512e() : p instanceof ISqlDownloadCache ? (ISqlDownloadCache) p : null;
        if (sVar instanceof IBinder) {
            return (IBinder) sVar;
        }
        return new Binder();
    }
}
