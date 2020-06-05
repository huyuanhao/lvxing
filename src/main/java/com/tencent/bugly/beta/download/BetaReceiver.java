package com.tencent.bugly.beta.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.bugly.beta.global.C7127a;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.beta.p602ui.C7144c;
import com.tencent.bugly.beta.p602ui.C7147f;
import com.tencent.bugly.beta.p602ui.C7148g;
import com.tencent.bugly.beta.p602ui.C7149h;
import com.tencent.bugly.beta.upgrade.C7152c;
import com.tencent.bugly.proguard.C7224am;
import com.tencent.bugly.proguard.C7226an;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BUGLY */
public class BetaReceiver extends BroadcastReceiver {
    public static String CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";
    public static ConcurrentHashMap<String, C7126c> netListeners = new ConcurrentHashMap<>(3);
    public static int netStatus = 0;

    public static synchronized void addTask(DownloadTask downloadTask) {
        synchronized (BetaReceiver.class) {
            netStatus = C7127a.m30539a(C7131e.f23698E.f23747s);
            C7147f fVar = new C7147f();
            fVar.f23796n = downloadTask;
            netListeners.put(downloadTask.getDownloadUrl(), new C7126c(2, downloadTask, Boolean.valueOf(false), fVar));
        }
    }

    public synchronized void onReceive(final Context context, final Intent intent) {
        C7224am.m31132a().mo34832a(new Runnable() {
            public void run() {
                try {
                    if (intent.getAction().equals(BetaReceiver.CONNECTIVITY_CHANGE)) {
                        int i = BetaReceiver.netStatus;
                        BetaReceiver.netStatus = C7127a.m30539a(context);
                        for (C7126c a : BetaReceiver.netListeners.values()) {
                            a.mo34327a(i, BetaReceiver.netStatus);
                        }
                    } else if (intent.getAction().equals(C7144c.f23780a.f23782c)) {
                        int intExtra = intent.getIntExtra("request", -1);
                        if (intExtra == 1) {
                            DownloadTask downloadTask = C7144c.f23780a.f23781b;
                            if (downloadTask != null) {
                                int status = downloadTask.getStatus();
                                if (status != 0) {
                                    if (status == 1) {
                                        C7127a.m30549a(C7131e.f23698E.f23747s, downloadTask.getSaveFile(), downloadTask.getMD5());
                                    } else if (status == 2) {
                                        BetaReceiver.netListeners.remove(downloadTask.getDownloadUrl());
                                        downloadTask.stop();
                                    } else if (!(status == 3 || status == 4 || status == 5)) {
                                    }
                                    if (C7152c.f23830a.f23834e == null && C7149h.f23802v != null) {
                                        C7149h.f23802v.mo34447a(downloadTask);
                                    }
                                }
                                BetaReceiver.addTask(downloadTask);
                                downloadTask.download();
                                C7149h.f23802v.mo34447a(downloadTask);
                            }
                        } else if (intExtra != 2) {
                            Log.v("", "do nothing");
                        } else {
                            C7148g.m30582a(C7144c.f23780a.f23784e, true, true, 0);
                        }
                    }
                } catch (Exception e) {
                    if (!C7226an.m31145b(e)) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
