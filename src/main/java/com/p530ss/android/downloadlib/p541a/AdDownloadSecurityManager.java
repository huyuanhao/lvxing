package com.p530ss.android.downloadlib.p541a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.p530ss.android.downloadlib.DownloadDispatcherImpl;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.io.File;

/* renamed from: com.ss.android.downloadlib.a.c */
public class AdDownloadSecurityManager {
    /* renamed from: a */
    private static volatile AdDownloadSecurityManager f21331a;
    /* renamed from: b */
    private Handler f21332b = null;

    /* renamed from: a */
    public static AdDownloadSecurityManager m26199a() {
        if (f21331a == null) {
            synchronized (AdDownloadSecurityManager.class) {
                if (f21331a == null) {
                    f21331a = new AdDownloadSecurityManager();
                }
            }
        }
        return f21331a;
    }

    /* renamed from: a */
    public void mo31287a(Context context, DownloadInfo cVar) {
        if (mo31288b() && cVar != null) {
            try {
                File file = new File(cVar.mo32297k(), cVar.mo32287h());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f21332b == null) {
                this.f21332b = new Handler(Looper.getMainLooper());
            }
            final String j = cVar.mo32295j();
            Downloader.m27478a(context).mo31930j(cVar.mo32283g());
            this.f21332b.post(new Runnable() {
                public void run() {
                    C6565j.m26370d().mo16487a(3, C6565j.m26357a(), null, "下载失败，请重试！", null, 0);
                    CommonDownloadHandler a = DownloadDispatcherImpl.m26547a().mo31418a(j);
                    if (a != null) {
                        a.mo31325f();
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public boolean mo31288b() {
        return C6565j.m26375i().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
