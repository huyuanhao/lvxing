package com.p530ss.android.downloadlib.p547c;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.AdDownloadCompletedEventHandlerImpl;
import com.p530ss.android.downloadlib.DownloadDispatcherImpl;
import com.p530ss.android.downloadlib.p541a.AdDelayTaskManager;
import com.p530ss.android.downloadlib.p541a.AdDownloadSecurityManager;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager;
import com.p530ss.android.downloadlib.p548d.AdEventHandler;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadEventHandler;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.c.b */
public class NewDownloadCompletedEventDispatcher implements IAppDownloadEventHandler {
    /* renamed from: a */
    private Context f21411a;

    public NewDownloadCompletedEventDispatcher(Context context) {
        this.f21411a = context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo31370a(Context context, String str) {
        AdDownloadCompletedEventHandlerImpl.m26106a().mo31232a(str);
    }

    /* renamed from: a */
    public void mo31368a(int i, int i2, String str, int i3, long j) {
        int i4 = i2;
        Context context = this.f21411a;
        if (context != null) {
            int i5 = i;
            DownloadInfo h = Downloader.m27478a(context).mo31928h(i);
            if (!(h == null || h.mo32308q() == 0)) {
                NativeDownloadModel a = ModelManager.m26169a().mo31263a(h);
                if (a == null) {
                    C6587g.m26532b();
                } else if (i4 != 1) {
                    String str2 = "download_notification";
                    if (i4 == 3) {
                        AdEventHandler.m26446a().mo31403a(str2, "download_notification_install", AdDownloadCompletedEventHandlerImpl.m26109a(new JSONObject(), h), a);
                    } else if (i4 == 5) {
                        AdEventHandler.m26446a().mo31402a(str2, "download_notification_pause", a);
                    } else if (i4 == 6) {
                        AdEventHandler.m26446a().mo31402a(str2, "download_notification_continue", a);
                    } else if (i4 == 7) {
                        AdEventHandler.m26446a().mo31402a(str2, "download_notification_click", a);
                    }
                } else {
                    AdDownloadCompletedEventHandlerImpl.m26114a(h, a);
                    if ("application/vnd.android.package-archive".equals(h.mo32231ah())) {
                        AdDelayTaskManager.m26160a().mo31257a(h, a.mo31194a(), a.mo31200b(), a.mo31210d(), h.mo32291i(), a.mo31215f(), h.mo32305n());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo31373a(int i, boolean z) {
        if (C6565j.m26380n() != null) {
            return C6565j.m26380n().mo31030a(z);
        }
        return false;
    }

    /* renamed from: a */
    public void mo31371a(DownloadInfo cVar) {
        if (cVar != null) {
            DownloadDispatcherImpl.m26547a().mo31420a(cVar);
            AdEventHandler.m26446a().mo31395a(cVar, new BaseException((int) PointerIconCompat.TYPE_NO_DROP, ""));
        }
    }

    /* renamed from: a */
    public void mo31369a(int i, int i2, String str, String str2, String str3) {
        Context context = this.f21411a;
        if (context != null) {
            DownloadInfo h = Downloader.m27478a(context).mo31928h(i);
            if (h != null && h.mo32308q() == -3) {
                h.mo32270d(str2);
                AdDownloadSecurityManager.m26199a().mo31287a(this.f21411a, h);
            }
        }
    }

    /* renamed from: a */
    public boolean mo31372a() {
        return AdDownloadSecurityManager.m26199a().mo31288b();
    }
}
