package com.p530ss.android.downloadlib.p541a;

import android.text.TextUtils;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.p541a.p542a.AdDownloadDialogManager;
import com.p530ss.android.downloadlib.p541a.p543b.C6544a;
import com.p530ss.android.downloadlib.p548d.AdEventHandler;
import com.p530ss.android.downloadlib.p549e.OpenAppUtils;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p536c.C6514b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ss.android.downloadlib.a.a */
public class AdDeepLinkManager {
    /* renamed from: a */
    private static AdDeepLinkManager f21274a;
    /* renamed from: b */
    private Map<String, C6514b> f21275b = new HashMap();
    /* renamed from: c */
    private Map<String, C6544a> f21276c;

    /* renamed from: a */
    public static AdDeepLinkManager m26130a() {
        if (f21274a == null) {
            synchronized (AdDeepLinkManager.class) {
                if (f21274a == null) {
                    f21274a = new AdDeepLinkManager();
                }
            }
        }
        return f21274a;
    }

    private AdDeepLinkManager() {
    }

    /* renamed from: b */
    private boolean m26131b(String str) {
        return this.f21275b.containsKey(str);
    }

    /* renamed from: a */
    public void mo31242a(C6514b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.mo31100a())) {
                this.f21275b.put(bVar.mo31103b(), bVar);
            } else {
                this.f21275b.remove(bVar.mo31103b());
            }
        }
    }

    /* renamed from: c */
    private C6514b m26132c(String str) {
        C6514b bVar = (C6514b) this.f21275b.get(str);
        if (bVar != null) {
            this.f21275b.remove(str);
        }
        return bVar;
    }

    /* renamed from: a */
    public boolean mo31244a(String str, NativeDownloadModel aVar) {
        if (!m26131b(str)) {
            return false;
        }
        C6514b c = m26132c(str);
        if (c == null) {
            return false;
        }
        AdEventHandler.m26446a().mo31400a("deeplink_url_app", aVar);
        int a = OpenAppUtils.m26491a(c.mo31100a()).mo31280a();
        if (a == 1 || a == 3) {
            AdEventHandler.m26446a().mo31400a("deeplink_open_success", aVar);
            C6565j.m26369c().mo31029a(C6565j.m26357a(), aVar.mo31229s(), null, null, str);
            return true;
        }
        AdEventHandler.m26446a().mo31400a("deeplink_open_fail", aVar);
        return false;
    }

    /* renamed from: a */
    public void mo31241a(C6507c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.mo31080t())) {
            if (this.f21276c == null) {
                this.f21276c = new HashMap();
            }
            Map<String, C6544a> map = this.f21276c;
            String t = cVar.mo31080t();
            C6544a aVar = new C6544a(0, cVar.mo31064d(), cVar.mo31065e(), cVar.mo31080t(), cVar.mo31066f(), cVar.mo31079s(), "");
            map.put(t, aVar);
        }
    }

    /* renamed from: a */
    public void mo31243a(String str) {
        if (this.f21276c != null && !TextUtils.isEmpty(str) && this.f21276c.containsKey(str)) {
            C6544a aVar = (C6544a) this.f21276c.remove(str);
            aVar.mo31258a();
            AdDownloadDialogManager.m26137a().mo31248a(aVar);
            this.f21276c.remove(str);
        }
    }
}
