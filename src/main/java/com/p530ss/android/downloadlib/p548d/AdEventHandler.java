package com.p530ss.android.downloadlib.p548d;

import android.os.Build.VERSION;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.AdDownloadCompletedEventHandlerImpl;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager.C6546a;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;
import com.p530ss.android.p531a.p532a.p536c.DownloadEventModel;
import com.p530ss.android.p531a.p532a.p536c.DownloadEventModel.C6518a;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p569m.C6792i;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.d.a */
public class AdEventHandler {

    /* compiled from: AdEventHandler */
    /* renamed from: com.ss.android.downloadlib.d.a$a */
    private static class C6579a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static AdEventHandler f21424a = new AdEventHandler();
    }

    /* renamed from: a */
    public static AdEventHandler m26446a() {
        return C6579a.f21424a;
    }

    private AdEventHandler() {
    }

    /* renamed from: a */
    public void mo31391a(long j, int i) {
        C6546a e = ModelManager.m26169a().mo31276e(j);
        if (e.mo31279a()) {
            C6587g.m26532b();
        } else if (e.f21321c.mo31058l()) {
            DownloadEventConfig bVar = e.f21321c;
            String c = i == 1 ? bVar.mo31049c() : bVar.mo31048b();
            String a = C6587g.m26516a(e.f21321c.mo31050d(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("click_type", Integer.valueOf(i));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            m26451a(c, a, jSONObject, e.f21320b, e.f21321c);
        }
    }

    /* renamed from: a */
    public void mo31392a(long j, int i, DownloadInfo cVar) {
        C6546a e = ModelManager.m26169a().mo31276e(j);
        if (e.mo31279a()) {
            C6587g.m26532b();
            return;
        }
        String str = null;
        JSONObject jSONObject = new JSONObject();
        if (i == 1) {
            str = C6587g.m26516a(e.f21321c.mo31055i(), "storage_deny");
        } else if (i == 2) {
            str = C6587g.m26516a(e.f21321c.mo31051e(), "click_start");
            mo31396a(cVar, jSONObject);
        } else if (i == 3) {
            str = C6587g.m26516a(e.f21321c.mo31052f(), "click_pause");
        } else if (i == 4) {
            str = C6587g.m26516a(e.f21321c.mo31053g(), "click_continue");
        } else if (i == 5) {
            if (cVar != null) {
                try {
                    AdDownloadCompletedEventHandlerImpl.m26116a(jSONObject, cVar.mo32283g());
                    AdDownloadCompletedEventHandlerImpl.m26109a(jSONObject, cVar);
                } catch (Throwable unused) {
                }
            }
            str = C6587g.m26516a(e.f21321c.mo31054h(), "click_install");
        }
        m26450a(e.f21321c.mo31048b(), str, jSONObject, e.f21320b.mo31065e(), 1, e.f21320b, e.f21321c);
    }

    /* renamed from: b */
    public void mo31406b(long j, int i) {
        mo31392a(j, i, (DownloadInfo) null);
    }

    /* renamed from: a */
    public void mo31398a(String str, long j) {
        NativeDownloadModel d = ModelManager.m26169a().mo31275d(j);
        if (d == null) {
            C6587g.m26532b();
        } else {
            m26452b(d.mo31225o(), str, null, d);
        }
    }

    /* renamed from: a */
    public void mo31399a(String str, C6507c cVar, DownloadEventConfig bVar) {
        m26451a(bVar.mo31048b(), str, cVar.mo31083w(), cVar, bVar);
    }

    /* renamed from: a */
    public void mo31401a(String str, C6546a aVar) {
        m26451a(aVar.f21321c.mo31048b(), str, aVar.f21320b.mo31083w(), aVar.f21320b, aVar.f21321c);
    }

    /* renamed from: a */
    public void mo31397a(String str, int i, C6546a aVar) {
        m26450a(aVar.f21321c.mo31048b(), str, null, (long) i, 2, aVar.f21320b, aVar.f21321c);
    }

    /* renamed from: a */
    public void mo31394a(long j, boolean z, int i) {
        C6546a e = ModelManager.m26169a().mo31276e(j);
        if (e.mo31279a()) {
            C6587g.m26532b();
        } else if (e.f21320b.mo31085y() != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("click_type", Integer.valueOf(i));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            m26451a(e.f21321c.mo31048b(), z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, e.f21320b, e.f21321c);
        }
    }

    /* renamed from: a */
    public void mo31396a(DownloadInfo cVar, JSONObject jSONObject) {
        if (cVar != null) {
            try {
                jSONObject.put("total_bytes", cVar.mo32225ab());
                jSONObject.put("chunk_count", cVar.mo32219aV());
                jSONObject.put("app_name", cVar.mo32291i());
                jSONObject.put("network_quality", cVar.mo32227ad());
                jSONObject.put("save_path", cVar.mo32297k());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo31393a(long j, BaseException aVar) {
        C6546a e = ModelManager.m26169a().mo31276e(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", Integer.valueOf(0));
            if (aVar != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(aVar.mo32073a()));
                jSONObject.putOpt("fail_msg", aVar.mo32076b());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        m26451a(e.f21321c.mo31048b(), "download_failed", jSONObject, e.f21320b, e.f21321c);
    }

    /* renamed from: a */
    public void mo31402a(String str, String str2, NativeDownloadModel aVar) {
        if (aVar == null) {
            C6587g.m26532b();
        } else {
            m26452b(str, str2, null, aVar);
        }
    }

    /* renamed from: a */
    public void mo31400a(String str, NativeDownloadModel aVar) {
        if (aVar == null) {
            C6587g.m26532b();
        } else {
            m26452b(aVar.mo31225o(), str, null, aVar);
        }
    }

    /* renamed from: a */
    public void mo31403a(String str, String str2, JSONObject jSONObject, NativeDownloadModel aVar) {
        m26452b(str, str2, jSONObject, aVar);
    }

    /* renamed from: a */
    public void mo31404a(String str, JSONObject jSONObject, NativeDownloadModel aVar) {
        if (aVar == null) {
            C6587g.m26532b();
        } else {
            m26452b("embeded_ad", str, jSONObject, aVar);
        }
    }

    /* renamed from: a */
    public void mo31405a(JSONObject jSONObject, NativeDownloadModel aVar) {
        m26452b(aVar.mo31225o(), "download_finish", jSONObject, aVar);
    }

    /* renamed from: b */
    public void mo31407b(JSONObject jSONObject, NativeDownloadModel aVar) {
        m26452b(aVar.mo31225o(), "install_finish", jSONObject, aVar);
    }

    /* renamed from: a */
    public void mo31395a(DownloadInfo cVar, BaseException aVar) {
        if (cVar != null) {
            NativeDownloadModel a = ModelManager.m26169a().mo31263a(cVar);
            if (a == null) {
                C6587g.m26532b();
            } else if (!a.f21245a.get()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("download_time", Long.valueOf(cVar.mo32246aw()));
                    if (aVar != null) {
                        jSONObject.putOpt("fail_status", Integer.valueOf(aVar.mo32073a()));
                        jSONObject.putOpt("fail_msg", aVar.mo32076b());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                AdDownloadCompletedEventHandlerImpl.m26110a(jSONObject, cVar, true);
                mo31403a(a.mo31225o(), "download_failed", jSONObject, a);
            }
        }
    }

    /* renamed from: a */
    private void m26451a(String str, String str2, JSONObject jSONObject, C6507c cVar, DownloadEventConfig bVar) {
        m26450a(str, str2, jSONObject, cVar.mo31065e(), 2, cVar, bVar);
    }

    /* renamed from: a */
    private void m26450a(String str, String str2, JSONObject jSONObject, long j, int i, C6507c cVar, DownloadEventConfig bVar) {
        try {
            m26449a(new C6518a().mo31128a(C6587g.m26516a(str, "embeded_ad")).mo31134b(str2).mo31135b(cVar.mo31078r()).mo31126a(cVar.mo31064d()).mo31136c(cVar.mo31079s()).mo31133b(j).mo31137d(bVar.mo31047a()).mo31129a(cVar.mo31082v()).mo31130a(C6587g.m26518a(m26447a(cVar), jSONObject)).mo31127a(bVar.mo31056j()).mo31125a(i).mo31131a(bVar.mo31059m()).mo31132a());
        } catch (Exception e) {
            C6587g.m26520a((Throwable) e);
        }
    }

    /* renamed from: b */
    private void m26452b(String str, String str2, JSONObject jSONObject, NativeDownloadModel aVar) {
        try {
            m26449a(new C6518a().mo31128a(C6587g.m26516a(str, "embeded_ad")).mo31134b(str2).mo31135b(aVar.mo31217g()).mo31126a(aVar.mo31194a()).mo31136c(aVar.mo31215f()).mo31133b(aVar.mo31200b()).mo31137d(aVar.mo31226p()).mo31130a(C6587g.m26518a(m26448a(aVar), jSONObject)).mo31125a(2).mo31131a(aVar.mo31222l()).mo31132a());
        } catch (Exception e) {
            C6587g.m26520a((Throwable) e);
        }
    }

    /* renamed from: a */
    private JSONObject m26447a(C6507c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", cVar.mo31061a());
            jSONObject.put("package_name", cVar.mo31080t());
            jSONObject.put("android_int", VERSION.SDK_INT);
            jSONObject.put("rom_name", C6792i.m28936f());
            jSONObject.put("rom_version", C6792i.m28937g());
            C6587g.m26517a(cVar.mo31083w(), jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    private JSONObject m26448a(NativeDownloadModel aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", aVar.mo31227q());
            jSONObject.put("package_name", aVar.mo31210d());
            jSONObject.put("android_int", VERSION.SDK_INT);
            jSONObject.put("rom_name", C6792i.m28936f());
            jSONObject.put("rom_version", C6792i.m28937g());
            C6587g.m26517a(aVar.mo31218h(), jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    private void m26449a(DownloadEventModel dVar) {
        if (C6565j.m26367b() != null) {
            if (dVar.mo31123e()) {
                C6565j.m26367b().mo16476a(dVar);
            } else {
                C6565j.m26367b().mo16477b(dVar);
            }
        }
    }
}
