package com.p522qq.p523e.comm;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.SVSD;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;

/* renamed from: com.qq.e.comm.DownloadService */
public class DownloadService extends Service {
    /* renamed from: a */
    private SVSD f20158a;

    /* renamed from: a */
    private boolean m25174a(String str) {
        if (this.f20158a == null) {
            try {
                if (GDTADManager.getInstance().initWith(getApplicationContext(), str)) {
                    this.f20158a = GDTADManager.getInstance().getPM().getPOFactory().getAPKDownloadServiceDelegate(this);
                    this.f20158a.onCreate();
                } else {
                    GDTLogger.report("Init GDTADManager fail in DownloadService.oncreate");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.f20158a != null;
    }

    public IBinder onBind(Intent intent) {
        GDTLogger.m25258d("DownloadService.onBind");
        SVSD svsd = this.f20158a;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        StringBuilder sb = new StringBuilder("DownloadService.onBind,appID=");
        sb.append(stringExtra);
        GDTLogger.m25258d(sb.toString());
        if (StringUtil.isEmpty(stringExtra) || !m25174a(stringExtra)) {
            return null;
        }
        return this.f20158a.onBind(intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd = this.f20158a;
        if (svsd != null) {
            svsd.onConfigurationChanged(configuration);
        }
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        SVSD svsd = this.f20158a;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    public void onLowMemory() {
        SVSD svsd = this.f20158a;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    public void onRebind(Intent intent) {
        SVSD svsd = this.f20158a;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf(i2);
            return 2;
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        if (!StringUtil.isEmpty(stringExtra) && m25174a(stringExtra)) {
            return this.f20158a.onStartCommand(intent, i, i2);
        }
        GDTLogger.m25263w("Failto Start new download Service");
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        SVSD svsd = this.f20158a;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    public void onTrimMemory(int i) {
        SVSD svsd = this.f20158a;
        if (svsd != null) {
            svsd.onTrimMemory(i);
        }
    }

    public boolean onUnbind(Intent intent) {
        SVSD svsd = this.f20158a;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }
}
