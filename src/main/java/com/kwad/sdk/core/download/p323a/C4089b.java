package com.kwad.sdk.core.download.p323a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.C4100d;
import com.kwad.sdk.core.download.C4103e;
import com.kwad.sdk.core.download.C4104f;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.p306a.C3795a;
import com.kwad.sdk.p306a.C3808k;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.download.a.b */
public class C4089b implements C4103e {
    /* renamed from: a */
    private Handler f13747a;
    /* renamed from: b */
    private AdTemplate f13748b;
    /* renamed from: c */
    private AdInfo f13749c;
    /* renamed from: d */
    private JSONObject f13750d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public HashSet<KsAppDownloadListener> f13751e;

    public C4089b(AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public C4089b(AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public C4089b(AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public C4089b(AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.f13747a = new Handler(Looper.getMainLooper());
        this.f13751e = new HashSet<>();
        this.f13748b = adTemplate;
        this.f13749c = C4324c.m17668e(adTemplate);
        this.f13750d = jSONObject;
        if (ksAppDownloadListener != null) {
            mo23770a(ksAppDownloadListener);
        }
        C4100d.m17030a((C4103e) this);
        C4100d.m17031a(this.f13748b);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m16971d(KsAppDownloadListener ksAppDownloadListener) {
        int i = this.f13749c.progress;
        switch (this.f13749c.status) {
            case UNKNOWN:
                ksAppDownloadListener.onIdle();
                return;
            case DOWNLOADING:
            case PROGRESS:
                ksAppDownloadListener.onProgressUpdate(i);
                return;
            case FINISHED:
            case INSTALL:
                ksAppDownloadListener.onDownloadFinished();
                return;
            case INSTALL_FINSHED:
                ksAppDownloadListener.onInstalled();
                return;
            default:
                return;
        }
    }

    /* renamed from: e */
    private void m16972e() {
        this.f13747a.post(new Runnable() {
            public void run() {
                Iterator it = C4089b.this.f13751e.iterator();
                while (it.hasNext()) {
                    KsAppDownloadListener ksAppDownloadListener = (KsAppDownloadListener) it.next();
                    if (ksAppDownloadListener != null) {
                        C4089b.this.m16971d(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    /* renamed from: f */
    private void m16973f() {
        String str = this.f13749c.adBaseInfo.appPackageName;
        Context context = KsAdSDK.getContext();
        if (context != null) {
            if (C3808k.m15786a(context, str)) {
                this.f13749c.status = DOWNLOADSTAUS.INSTALL_FINSHED;
                return;
            }
            if (this.f13749c.status == DOWNLOADSTAUS.INSTALL_FINSHED) {
                this.f13749c.status = DOWNLOADSTAUS.UNKNOWN;
                this.f13749c.progress = 0;
            }
            if (this.f13749c.status == DOWNLOADSTAUS.FINISHED) {
                String str2 = this.f13749c.downloadFilePath;
                if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                    this.f13749c.status = DOWNLOADSTAUS.UNKNOWN;
                    this.f13749c.progress = 0;
                }
            }
            if (this.f13749c.status == DOWNLOADSTAUS.UNKNOWN) {
                AdDownloadProxy proxyForDownload = KsAdSDK.getProxyForDownload();
                if (proxyForDownload != null) {
                    String downloadFilePath = proxyForDownload.getDownloadFilePath(DownloadParams.transfrom(this.f13749c));
                    if (!TextUtils.isEmpty(downloadFilePath) && new File(downloadFilePath).exists()) {
                        AdInfo adInfo = this.f13749c;
                        adInfo.downloadFilePath = downloadFilePath;
                        adInfo.status = DOWNLOADSTAUS.FINISHED;
                    }
                }
            }
        }
    }

    /* renamed from: g */
    private void m16974g() {
        String str = this.f13749c.adConversionInfo.marketUrl;
        StringBuilder sb = new StringBuilder();
        sb.append("Market URL Schema=");
        sb.append(str);
        C4065b.m16867b("ApkDownloadHelper", sb.toString());
        if (!TextUtils.isEmpty(str) ? C3795a.m15729a(KsAdSDK.getContext(), str, this.f13749c.adBaseInfo.appPackageName) : false) {
            C4143b.m17144i(this.f13748b);
        } else {
            m16977j();
        }
    }

    /* renamed from: h */
    private void m16975h() {
        String str = this.f13749c.adBaseInfo.appPackageName;
        Context context = KsAdSDK.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("openApp fail appContext:");
            sb.append(context);
            sb.append("--appPkgName:");
            sb.append(str);
            C4065b.m16869d("ApkDownloadHelper", sb.toString());
            return;
        }
        C3808k.m15787b(context, str);
    }

    /* renamed from: i */
    private void m16976i() {
        String str = this.f13749c.downloadFilePath;
        Context context = KsAdSDK.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("openApp fail appContext:");
            sb.append(context);
            sb.append("--filePath:");
            sb.append(str);
            C4065b.m16869d("ApkDownloadHelper", sb.toString());
            return;
        }
        KsAdSDK.getProxyForAdInstall().installApp(context, str);
    }

    /* renamed from: j */
    private void m16977j() {
        Context context = KsAdSDK.getContext();
        if (context != null) {
            if (!C3607b.m15045a(context)) {
                C4065b.m16869d("ApkDownloadHelper", "no network while download app");
            } else {
                C4104f.m17050a(context, this.f13749c);
            }
        }
    }

    /* renamed from: a */
    public String mo23769a() {
        return this.f13749c.downloadId;
    }

    /* renamed from: a */
    public void mo23770a(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener != null) {
            this.f13751e.add(ksAppDownloadListener);
            m16973f();
            m16971d(ksAppDownloadListener);
        }
    }

    /* renamed from: a */
    public void mo23771a(String str) {
        if (this.f13749c.downloadId.equals(str)) {
            if (this.f13749c.status != DOWNLOADSTAUS.START) {
                C4143b.m17126b(this.f13748b);
            }
            this.f13749c.status = DOWNLOADSTAUS.START;
            m16972e();
        }
    }

    /* renamed from: a */
    public void mo23772a(String str, int i) {
        if (this.f13749c.downloadId.equals(str)) {
            this.f13749c.status = DOWNLOADSTAUS.PROGRESS;
            this.f13749c.progress = i;
            m16972e();
        }
    }

    /* renamed from: a */
    public void mo23773a(String str, String str2) {
        if (this.f13749c.downloadId.equals(str)) {
            if (this.f13749c.status != DOWNLOADSTAUS.FINISHED && !this.f13748b.mDownloadFinishReported) {
                C4143b.m17135d(this.f13748b, this.f13750d);
                this.f13748b.mDownloadFinishReported = true;
            }
            this.f13749c.status = DOWNLOADSTAUS.FINISHED;
            AdInfo adInfo = this.f13749c;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            m16972e();
            ApkCacheManager.m16880a().mo23729b();
        }
    }

    /* renamed from: b */
    public String mo23774b() {
        return this.f13749c.adBaseInfo.appPackageName;
    }

    /* renamed from: b */
    public void mo23775b(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener != null) {
            this.f13751e.remove(ksAppDownloadListener);
        }
    }

    /* renamed from: b */
    public void mo23776b(String str) {
        if (this.f13749c.downloadId.equals(str)) {
            if (this.f13749c.status != DOWNLOADSTAUS.PAUSED) {
                C4143b.m17129b(this.f13748b, this.f13750d);
            }
            this.f13749c.status = DOWNLOADSTAUS.PAUSED;
            m16972e();
        }
    }

    /* renamed from: b */
    public void mo23777b(String str, int i) {
        if (this.f13749c.downloadId.equals(str)) {
            this.f13749c.status = DOWNLOADSTAUS.FAILED;
            m16972e();
        }
    }

    /* renamed from: c */
    public void mo23778c() {
        m16973f();
        switch (this.f13749c.status) {
            case UNKNOWN:
            case START:
            case PAUSED:
            case CANCELLED:
            case DELETED:
            case FAILED:
                m16974g();
                return;
            case FINISHED:
            case INSTALL:
            case INSTALL_FAILED:
                m16976i();
                return;
            case INSTALL_FINSHED:
                m16975h();
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    public void mo23779c(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener != null) {
            m16973f();
            m16971d(ksAppDownloadListener);
        }
    }

    /* renamed from: c */
    public void mo23780c(String str) {
        if (this.f13749c.downloadId.equals(str)) {
            if (this.f13749c.status != DOWNLOADSTAUS.DOWNLOADING) {
                C4143b.m17132c(this.f13748b, this.f13750d);
            }
            this.f13749c.status = DOWNLOADSTAUS.DOWNLOADING;
            m16972e();
        }
    }

    /* renamed from: c */
    public void mo23781c(String str, int i) {
        this.f13749c.status = DOWNLOADSTAUS.INSTALL_FINSHED;
        m16972e();
    }

    /* renamed from: d */
    public void mo23782d() {
        HashSet<KsAppDownloadListener> hashSet = this.f13751e;
        if (hashSet != null) {
            hashSet.clear();
        }
    }

    /* renamed from: d */
    public void mo23783d(String str) {
        if (this.f13749c.downloadId.equals(str)) {
            if (this.f13749c.status != DOWNLOADSTAUS.CANCELLED) {
                C4143b.m17137e(this.f13748b, this.f13750d);
            }
            this.f13749c.status = DOWNLOADSTAUS.CANCELLED;
            m16972e();
        }
    }

    /* renamed from: e */
    public void mo23784e(String str) {
        if (this.f13749c.downloadId.equals(str)) {
            this.f13749c.status = DOWNLOADSTAUS.INSTALL;
            m16972e();
        }
    }

    /* renamed from: f */
    public void mo23785f(String str) {
        this.f13749c.status = DOWNLOADSTAUS.INSTALLING;
        m16972e();
    }

    /* renamed from: g */
    public void mo23786g(String str) {
        if (this.f13749c.downloadId.equals(str)) {
            this.f13749c.status = DOWNLOADSTAUS.INSTALL_FAILED;
            m16972e();
        }
    }
}
