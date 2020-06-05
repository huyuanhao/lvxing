package com.p530ss.android.downloadlib;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.p530ss.android.downloadad.p538a.AdWebViewDownloadManager;
import com.p530ss.android.downloadad.p538a.p539a.AdDownloadController.C6525a;
import com.p530ss.android.downloadad.p538a.p539a.AdDownloadEventConfig.C6527a;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.p541a.AdDeepLinkManager;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager.C6546a;
import com.p530ss.android.downloadlib.p548d.AdEventHandler;
import com.p530ss.android.downloadlib.p549e.OpenAppUtils;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadController;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;

/* renamed from: com.ss.android.downloadlib.b */
public class AdWebViewDownloadManagerImpl implements AdWebViewDownloadManager {
    /* renamed from: a */
    private static String f21403a = AdWebViewDownloadManagerImpl.class.getSimpleName();
    /* renamed from: b */
    private static volatile AdWebViewDownloadManagerImpl f21404b;
    /* renamed from: c */
    private TTDownloader f21405c = TTDownloader.m26565a(C6565j.m26357a());

    private AdWebViewDownloadManagerImpl() {
    }

    /* renamed from: a */
    public static AdWebViewDownloadManagerImpl m26401a() {
        if (f21404b == null) {
            synchronized (AdWebViewDownloadManagerImpl.class) {
                if (f21404b == null) {
                    f21404b = new AdWebViewDownloadManagerImpl();
                }
            }
        }
        return f21404b;
    }

    /* renamed from: a */
    public boolean mo31193a(Context context, Uri uri, C6507c cVar) {
        boolean z = true;
        if (C6565j.m26375i().optInt("disable_market") == 1 || uri == null) {
            return false;
        }
        if (context == null) {
            context = C6565j.m26357a();
        }
        Context context2 = context;
        if (cVar == null) {
            if (OpenAppUtils.m26489a(context2, uri).mo31280a() != 5) {
                z = false;
            }
            return z;
        }
        C6546a aVar = new C6546a(cVar.mo31064d(), cVar, m26403c(), m26402b());
        AdEventHandler.m26446a().mo31399a("market_click_open", cVar, aVar.f21321c);
        String queryParameter = uri.getQueryParameter("id");
        if (OpenAppUtils.m26490a(context2, queryParameter).mo31280a() == 5) {
            AdEventHandler.m26446a().mo31401a("market_open_success", aVar);
            C6565j.m26369c().mo31029a(context2, aVar.f21320b, aVar.f21322d, aVar.f21321c, aVar.f21320b.mo31080t());
            AdDeepLinkManager.m26130a().mo31241a(aVar.f21320b);
            NativeDownloadModel aVar2 = new NativeDownloadModel(aVar.f21320b, aVar.f21321c, aVar.f21322d);
            if (!TextUtils.isEmpty(queryParameter)) {
                aVar2.mo31197a(queryParameter);
            }
            aVar2.mo31195a(2);
            aVar2.mo31207c(System.currentTimeMillis());
            aVar2.mo31211d(4);
            ModelManager.m26169a().mo31268a(aVar2);
            return true;
        }
        AdEventHandler.m26446a().mo31401a("market_open_failed", aVar);
        return false;
    }

    /* renamed from: b */
    public static DownloadController m26402b() {
        return new C6525a().mo31143a(0).mo31147b(0).mo31145a(true).mo31149c(false).mo31150d(false).mo31146a();
    }

    /* renamed from: c */
    public static DownloadEventConfig m26403c() {
        String str = "landing_h5_download_ad_button";
        return new C6527a().mo31152a(str).mo31155b(str).mo31167k("click_start_detail").mo31168l("click_pause_detail").mo31169m("click_continue_detail").mo31170n("click_install_detail").mo31171o("click_open_detail").mo31173q("storage_deny_detail").mo31151a(1).mo31153a(false).mo31156b(true).mo31160d(false).mo31154a();
    }
}
