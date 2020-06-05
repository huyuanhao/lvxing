package com.travel.adlibrary.p617f;

import android.app.Application;
import android.os.Looper;
import android.widget.Toast;
import com.elvishew.xlog.XLog;
import com.p368pw.WinLib;
import com.p368pw.p392us.IRewardAdListener;
import com.p368pw.p392us.Setting;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import com.travel.adlibrary.AdSdk;
import com.travel.adlibrary.p612a.AdOptions;
import com.travel.adlibrary.p612a.IAd;
import com.travel.adlibrary.p612a.IAd.C7671a;
import com.travel.adlibrary.p612a.IImageTextView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8258m;
import kotlin.jvm.p679a.C8263r;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, mo39189d2 = {"Lcom/travel/adlibrary/zz/ZzAd;", "Lcom/travel/adlibrary/common/IAd;", "()V", "init", "", "app", "Landroid/app/Application;", "isDebug", "", "loadImageTextAd", "options", "Lcom/travel/adlibrary/common/AdOptions;", "loadInfoFlowAd", "loadSplashAd", "loadVideoAd", "adId", "", "preLoadImageTextAd", "action", "Lkotlin/Function0;", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.travel.adlibrary.f.a */
public final class ZzAd implements IAd {
    /* renamed from: a */
    public static final ZzAd f25966a = new ZzAd();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0013\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo39189d2 = {"com/travel/adlibrary/zz/ZzAd$loadVideoAd$setting$1", "Lcom/pw/us/IRewardAdListener;", "isErrorOnce", "", "()Z", "setErrorOnce", "(Z)V", "startShowTime", "", "invokeCallback", "", "onClosed", "onDownloadFinished", "pkgName", "", "apkPath", "onDownloadStarted", "onError", "msg", "onInstalled", "onLoaded", "setting", "Lcom/pw/us/Setting;", "onShowed", "onVideoComplete", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: ZzAd.kt */
    /* renamed from: com.travel.adlibrary.f.a$a */
    public static final class C7691a implements IRewardAdListener {
        /* renamed from: a */
        final /* synthetic */ AdOptions f25967a;
        /* renamed from: b */
        private long f25968b;
        /* renamed from: c */
        private volatile boolean f25969c;

        C7691a(AdOptions aVar) {
            this.f25967a = aVar;
        }

        /* renamed from: a */
        public final void mo37347a() {
            StringBuilder sb = new StringBuilder();
            sb.append("isMainThread==");
            sb.append(C8271i.m35384a((Object) Looper.getMainLooper(), (Object) Looper.myLooper()));
            XLog.m12692b(sb.toString());
            if (System.currentTimeMillis() - this.f25968b < ((long) C7516p.f25219Cf)) {
                Toast.makeText(this.f25967a.mo37304b(), "广告展示出错，请稍后再试~", 0).show();
                return;
            }
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_COMPLETED", Integer.valueOf(3), Integer.valueOf(this.f25967a.mo37314j()), null);
            }
            C8258m l = this.f25967a.mo37316l();
            if (l != null) {
                Unit jVar2 = (Unit) l.invoke(Boolean.valueOf(true), Boolean.valueOf(false));
            }
        }

        public void onError(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("zzAd error, msg = ");
            sb.append(str);
            XLog.m12692b(sb.toString());
            if (!this.f25969c) {
                ZzAd.f25966a.mo37346d(this.f25967a);
                this.f25969c = true;
            }
        }

        public void onLoaded(Setting setting) {
            C8271i.m35386b(setting, "setting");
            XLog.m12692b("zzAd load");
            WinLib.show(this.f25967a.mo37304b(), setting);
        }

        public void onShowed() {
            XLog.m12692b("zzAd show");
            this.f25968b = System.currentTimeMillis();
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_SHOW", Integer.valueOf(3), Integer.valueOf(this.f25967a.mo37314j()), null);
            }
        }

        public void onClosed() {
            XLog.m12692b("zzAd close");
            mo37347a();
            ZzAd.f25966a.mo37323a();
        }

        public void onVideoComplete() {
            XLog.m12692b("zzAd video complete");
        }

        public void onDownloadStarted(String str) {
            XLog.m12692b("zzAd download start");
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_CLICKED", Integer.valueOf(3), Integer.valueOf(this.f25967a.mo37314j()), null);
            }
        }

        public void onDownloadFinished(String str, String str2) {
            XLog.m12692b("zzAd download finish");
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_DOWNLOADED", Integer.valueOf(3), Integer.valueOf(this.f25967a.mo37314j()), null);
            }
        }

        public void onInstalled(String str, String str2) {
            XLog.m12692b("zzAd install");
        }
    }

    /* renamed from: a */
    public void mo37325a(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
    }

    /* renamed from: a */
    public void mo37327a(AdOptions aVar, String str, C8246a<Unit> aVar2) {
        C8271i.m35386b(aVar, "options");
        C8271i.m35386b(str, "adId");
    }

    /* renamed from: b */
    public void mo37329b(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
    }

    /* renamed from: c */
    public void mo37330c(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
    }

    private ZzAd() {
    }

    /* renamed from: a */
    public void mo37323a() {
        C7671a.m32991a(this);
    }

    /* renamed from: a */
    public void mo37328a(AdOptions aVar, WeakReference<IImageTextView> weakReference) {
        C8271i.m35386b(aVar, "options");
        C8271i.m35386b(weakReference, "reference");
        C7671a.m32994a(this, aVar, weakReference);
    }

    /* renamed from: d */
    public void mo37346d(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
        C7671a.m32996c(this, aVar);
    }

    /* renamed from: a */
    public void mo37324a(Application application, boolean z) {
        C8271i.m35386b(application, "app");
        WinLib.setDebug(z);
        WinLib.setTestMode(z);
        WinLib.init(application, "URQWGZMJQTXSQOS9FQIO1W0F", "");
    }

    /* renamed from: a */
    public void mo37326a(AdOptions aVar, String str) {
        C8271i.m35386b(aVar, "options");
        C8271i.m35386b(str, "adId");
        Setting setting = new Setting(aVar.mo37304b(), 3, str, (IRewardAdListener) new C7691a(aVar));
        setting.setUserId(aVar.mo37306d());
        WinLib.load(setting);
    }
}
