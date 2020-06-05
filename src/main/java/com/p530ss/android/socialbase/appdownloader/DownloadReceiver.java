package com.p530ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadDepend;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadEventHandler;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver */
public class DownloadReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static final String f21469a = DownloadReceiver.class.getSimpleName();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Handler f21470b = new Handler(Looper.getMainLooper());

    public void onReceive(final Context context, final Intent intent) {
        if (!(context == null || intent == null)) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                IAppDownloadDepend a = AppDownloader.m26714h().mo31474a();
                if (action.equals("android.intent.action.BOOT_COMPLETED") && (a == null || a.mo31375a())) {
                    if (C6704a.m27756a()) {
                        C6704a.m27754a(f21469a, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
                    }
                    m26587a(context, action);
                } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
                    if (C6704a.m27756a()) {
                        C6704a.m27754a(f21469a, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
                    }
                    m26587a(context, action);
                } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
                    C6694b.m27379k().execute(new Runnable() {
                        public void run() {
                            Uri data = intent.getData();
                            if (data != null) {
                                String schemeSpecificPart = data.getSchemeSpecificPart();
                                IAppDownloadEventHandler b = AppDownloader.m26714h().mo31485b();
                                if (b != null) {
                                    b.mo31370a(context, schemeSpecificPart);
                                }
                                List b2 = Downloader.m27478a(context).mo31919b("application/vnd.android.package-archive");
                                if (b2 != null) {
                                    Iterator it = b2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        final DownloadInfo cVar = (DownloadInfo) it.next();
                                        if (cVar != null && AppDownloadUtils.m26659a(cVar, schemeSpecificPart)) {
                                            IDownloadNotificationEventListener i = Downloader.m27478a(context).mo31929i(cVar.mo32283g());
                                            if (i != null && DownloadUtils.m28812e(i.mo31499a())) {
                                                i.mo31500a(9, cVar, schemeSpecificPart, "");
                                            }
                                            boolean z = false;
                                            if (DownloadSetting.m28610a(cVar.mo32283g()).mo32547a("install_queue_enable", 0) == 1) {
                                                z = true;
                                            }
                                            if (z) {
                                                InstallQueue.m26928a().mo31622a(cVar, schemeSpecificPart);
                                            }
                                            DownloadReceiver.this.f21470b.postDelayed(new Runnable() {
                                                public void run() {
                                                    C6694b.m27379k().execute(new Runnable() {
                                                        public void run() {
                                                            try {
                                                                if (cVar.mo32259be()) {
                                                                    DownloadUtils.m28787b(cVar);
                                                                }
                                                            } catch (Throwable th) {
                                                                th.printStackTrace();
                                                            }
                                                        }
                                                    });
                                                }
                                            }, 1000);
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    private void m26587a(Context context, String str) {
        try {
            Intent intent = new Intent(context, DownloadHandlerService.class);
            intent.setAction(str);
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
