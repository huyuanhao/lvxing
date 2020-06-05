package com.ksad.download.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.ksad.download.C3605c;
import com.ksad.download.C3608d;
import com.ksad.download.DownloadTask.DownloadRequest;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadService extends Service {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public C3608d f12382a;
    /* renamed from: b */
    private final Map<String, Integer> f12383b = new ConcurrentHashMap();
    /* renamed from: c */
    private final C3618a f12384c = new C3618a(this);

    /* renamed from: com.ksad.download.service.DownloadService$a */
    static class C3618a extends Handler {
        /* renamed from: a */
        final WeakReference<DownloadService> f12385a;

        public C3618a(DownloadService downloadService) {
            this.f12385a = new WeakReference<>(downloadService);
        }

        public void handleMessage(Message message) {
            DownloadService downloadService = (DownloadService) this.f12385a.get();
            if (downloadService != null && message.what == 1) {
                if (downloadService.f12382a == null || !downloadService.f12382a.mo22725d()) {
                    sendEmptyMessageDelayed(1, 30000);
                } else {
                    downloadService.stopSelf();
                }
            }
        }
    }

    /* renamed from: a */
    private void m15095a(Intent intent) {
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("download_service_type_tag", 0);
                String stringExtra = intent.getStringExtra("download_service_id_tag");
                DownloadRequest downloadRequest = (DownloadRequest) intent.getSerializableExtra("download_service_args_tag");
                Integer num = (Integer) this.f12383b.get(stringExtra);
                if (intExtra == 1) {
                    this.f12383b.put(stringExtra, Integer.valueOf(this.f12382a.mo22715a(downloadRequest, (C3605c) null)));
                } else if (intExtra == 2) {
                    this.f12382a.mo22724d(num.intValue());
                } else if (intExtra == 3) {
                    this.f12382a.mo22727e(num.intValue());
                } else if (intExtra == 4) {
                    this.f12382a.mo22723c(num.intValue());
                }
            } catch (Exception unused) {
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.f12382a = C3608d.m15048a();
        this.f12384c.sendEmptyMessageDelayed(1, 30000);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m15095a(intent);
        return super.onStartCommand(intent, i, i2);
    }
}
