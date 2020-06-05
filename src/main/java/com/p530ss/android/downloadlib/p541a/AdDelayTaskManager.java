package com.p530ss.android.downloadlib.p541a;

import android.os.Looper;
import android.os.Message;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.p541a.p542a.AdDownloadDialogManager;
import com.p530ss.android.downloadlib.p541a.p543b.C6544a;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager;
import com.p530ss.android.downloadlib.p548d.AdEventHandler;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.downloadlib.p549e.C6588h;
import com.p530ss.android.downloadlib.p549e.C6588h.C6589a;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.C6792i;
import com.p530ss.android.socialbase.downloader.p569m.SystemUtils;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a.b */
public class AdDelayTaskManager implements C6589a {
    /* renamed from: a */
    private static final String f21292a = AdDelayTaskManager.class.getSimpleName();
    /* renamed from: b */
    private static AdDelayTaskManager f21293b;
    /* renamed from: c */
    private C6588h f21294c = new C6588h(Looper.getMainLooper(), this);
    /* renamed from: d */
    private long f21295d;

    /* renamed from: a */
    public static AdDelayTaskManager m26160a() {
        if (f21293b == null) {
            synchronized (AdDelayTaskManager.class) {
                if (f21293b == null) {
                    f21293b = new AdDelayTaskManager();
                }
            }
        }
        return f21293b;
    }

    private AdDelayTaskManager() {
    }

    /* renamed from: a */
    public void mo31257a(DownloadInfo cVar, long j, long j2, String str, String str2, String str3, String str4) {
        C6544a aVar = new C6544a((long) cVar.mo32283g(), j, j2, str, str2, str3, str4);
        DownloadSetting a = DownloadSetting.m28610a(cVar.mo32283g());
        if (a.mo32547a("back_miui_silent_install", 1) == 0 && ((C6792i.m28940j() || C6792i.m28941k()) && SystemUtils.m28953a(C6565j.m26357a(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (cVar.mo32261bg().getBoolean("extra_silent_install_succeed", false)) {
                Message obtainMessage = this.f21294c.obtainMessage(200, aVar);
                obtainMessage.arg1 = 2;
                this.f21294c.sendMessageDelayed(obtainMessage, (long) a.mo32547a("check_silent_install_interval", 60000));
                return;
            }
            NativeDownloadModel d = ModelManager.m26169a().mo31275d(aVar.f21297b);
            JSONObject jSONObject = new JSONObject();
            int i = -1;
            try {
                jSONObject.put("type", "miui_silent_install");
                jSONObject.put("message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception unused) {
            }
            C6565j.m26373g().mo31357a(null, new BaseException(i, jSONObject.toString()), i);
            AdEventHandler.m26446a().mo31403a("embeded_ad", "anti_hijack_result", jSONObject, d);
        }
        if (C6565j.m26383q()) {
            long currentTimeMillis = System.currentTimeMillis() - this.f21295d;
            long t = C6565j.m26386t();
            if (currentTimeMillis < C6565j.m26387u()) {
                long u = C6565j.m26387u() - currentTimeMillis;
                t += u;
                this.f21295d = System.currentTimeMillis() + u;
            } else {
                this.f21295d = System.currentTimeMillis();
            }
            C6588h hVar = this.f21294c;
            hVar.sendMessageDelayed(hVar.obtainMessage(200, aVar), t);
        }
    }

    /* renamed from: a */
    private void m26161a(C6544a aVar, int i) {
        if (C6565j.m26377k() != null) {
            if ((!C6565j.m26377k().mo16475a() || C6565j.m26384r()) && aVar != null) {
                if (2 == i) {
                    NativeDownloadModel d = ModelManager.m26169a().mo31275d(aVar.f21297b);
                    JSONObject jSONObject = new JSONObject();
                    int i2 = -1;
                    try {
                        jSONObject.put("type", "miui_silent_install");
                        String str = "message";
                        if (C6587g.m26535c(C6565j.m26357a(), aVar.f21299d)) {
                            jSONObject.put(str, "miui_silent_install_succeed");
                            i2 = 4;
                        } else {
                            jSONObject.put(str, "miui_silent_install_failed: has started service");
                            i2 = 5;
                        }
                    } catch (Exception unused) {
                    }
                    C6565j.m26373g().mo31357a(null, new BaseException(i2, jSONObject.toString()), i2);
                    AdEventHandler.m26446a().mo31403a("embeded_ad", "anti_hijack_result", jSONObject, d);
                }
                if (C6587g.m26535c(C6565j.m26357a(), aVar.f21299d)) {
                    AdEventHandler.m26446a().mo31398a("delayinstall_installed", aVar.f21297b);
                } else if (!C6587g.m26528a(aVar.f21302g)) {
                    AdEventHandler.m26446a().mo31398a("delayinstall_file_lost", aVar.f21297b);
                } else if (AdDownloadDialogManager.m26137a().mo31250a(aVar.f21299d)) {
                    AdEventHandler.m26446a().mo31398a("delayinstall_conflict_with_back_dialog", aVar.f21297b);
                } else {
                    AdEventHandler.m26446a().mo31398a("delayinstall_install_start", aVar.f21297b);
                    AppDownloader.m26712a(C6565j.m26357a(), (int) aVar.f21296a);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo31256a(Message message) {
        if (message.what == 200) {
            m26161a((C6544a) message.obj, message.arg1);
        }
    }
}
