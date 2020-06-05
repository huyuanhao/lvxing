package com.tencent.android.tpush.cloudctr.network;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl.C6892a;
import com.tencent.android.tpush.p580b.C6864a;
import java.io.Serializable;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: ProGuard */
public class CloudControlDownloadService extends IntentService {
    /* renamed from: a */
    static ConcurrentLinkedQueue<DownloadItem> f22959a = new ConcurrentLinkedQueue<>();
    /* renamed from: b */
    private static Bundle f22960b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public DownloadItem f22961c;

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static Intent m29449b(DownloadItem downloadItem) {
        Intent intent = new Intent("com.tencent.android.tpush.cloudcontrol.action.DOWNLOAD_FILE_FINISH");
        intent.putExtra("EXT_DOWNLOAD_ITEM", downloadItem);
        return intent;
    }

    /* renamed from: a */
    public static DownloadItem m29445a(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("EXT_DOWNLOAD_ITEM");
        if (serializableExtra instanceof DownloadItem) {
            return (DownloadItem) serializableExtra;
        }
        return null;
    }

    /* renamed from: a */
    public static void m29448a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent();
        Context applicationContext = context.getApplicationContext();
        intent.setClass(applicationContext, CloudControlDownloadService.class);
        DownloadItem downloadItem = new DownloadItem();
        downloadItem.setMd5(str5);
        downloadItem.setDownloadUrl(str);
        downloadItem.setDownloadSavedDir(str3);
        downloadItem.setFileName(str2);
        downloadItem.setBusinessCode(str4);
        intent.putExtra("EXT_DOWNLOAD_ITEM", downloadItem);
        applicationContext.startService(intent);
    }

    /* renamed from: a */
    public static void m29447a(Context context, DownloadItem downloadItem) {
        Intent intent = new Intent();
        Context applicationContext = context.getApplicationContext();
        intent.setClass(applicationContext, CloudControlDownloadService.class);
        intent.putExtra("EXT_DOWNLOAD_ITEM", downloadItem);
        applicationContext.startService(intent);
    }

    public CloudControlDownloadService() {
        super("CloudControl DownloadService");
    }

    public void onCreate() {
        C6864a.m29298c("DownloadService", "onCreate()");
        super.onCreate();
        if (f22960b == null) {
            f22960b = new Bundle();
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        String str = "DownloadService";
        try {
            C6864a.m29298c(str, "action:onHandleIntent");
            Serializable serializableExtra = intent.getSerializableExtra("EXT_DOWNLOAD_ITEM");
            if (serializableExtra instanceof DownloadItem) {
                this.f22961c = (DownloadItem) serializableExtra;
                if (this.f22961c == null) {
                    C6864a.m29306g(str, "NULL msg item");
                } else if (!Environment.getExternalStorageState().equals("mounted")) {
                    C6864a.m29306g(str, "SDCard can not work");
                } else if (this.f22961c._isDownloadFinished) {
                    C6864a.m29298c(str, "The Msg download is already finished.");
                } else {
                    if (!f22959a.contains(this.f22961c)) {
                        f22959a.offer(this.f22961c);
                    }
                    Thread.currentThread().setPriority(1);
                    new CloudControlDownloadControl(this, this.f22961c, f22960b, new C6892a() {
                        /* renamed from: a */
                        public void mo33079a(String str, boolean z) {
                            C6864a.m29298c("DownloadService", "download file Succeed");
                            CloudControlDownloadService.this.f22961c._isDownloadFinished = true;
                            CloudControlDownloadService.f22959a.remove(CloudControlDownloadService.this.f22961c);
                            CloudControlDownloadService.this.f22961c._isDownloadInterrupted = true;
                            CloudControlDownloadService.this.f22961c.setDownloadSucceed(true);
                            CloudControlDownloadService.this.sendBroadcast(CloudControlDownloadService.m29449b(CloudControlDownloadService.this.f22961c));
                        }

                        /* renamed from: a */
                        public void mo33078a(int i) {
                            if (CloudControlDownloadControl.m29441a(i)) {
                                CloudControlDownloadService.this.f22961c._isEverDownloadFailed = true;
                            }
                            CloudControlDownloadService.this.f22961c._isDownloadInterrupted = true;
                            CloudControlDownloadService.this.f22961c.setDownloadSucceed(false);
                            CloudControlDownloadService.this.sendBroadcast(CloudControlDownloadService.m29449b(CloudControlDownloadService.this.f22961c));
                        }
                    }, PathInterpolatorCompat.MAX_NUM_POINTS);
                }
            }
        } catch (Exception unused) {
            C6864a.m29308i(str, "download file error");
        }
    }
}
