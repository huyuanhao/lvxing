package com.travel.adlibrary.p614c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.elvishew.xlog.XLog;
import com.p522qq.p523e.ads.banner2.UnifiedBannerADListener;
import com.p522qq.p523e.ads.banner2.UnifiedBannerView;
import com.p522qq.p523e.ads.rewardvideo.RewardVideoAD;
import com.p522qq.p523e.ads.rewardvideo.RewardVideoADListener;
import com.p522qq.p523e.ads.splash.SplashAD;
import com.p522qq.p523e.ads.splash.SplashADListener;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.util.AdError;
import com.tencent.android.tpush.common.Constants;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import com.travel.adlibrary.AdSdk;
import com.travel.adlibrary.p612a.AdOptions;
import com.travel.adlibrary.p612a.IAd;
import com.travel.adlibrary.p612a.IAd.C7671a;
import com.travel.adlibrary.p612a.IImageTextView;
import com.travel.adlibrary.p616e.C7690a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8258m;
import kotlin.jvm.p679a.C8263r;
import kotlin.p675c.C8183a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo39189d2 = {"Lcom/travel/adlibrary/tencent/TencentAd;", "Lcom/travel/adlibrary/common/IAd;", "()V", "appId", "", "rewardAd", "Lcom/qq/e/ads/rewardvideo/RewardVideoAD;", "getBannerLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "activity", "Landroid/app/Activity;", "init", "", "app", "Landroid/app/Application;", "isDebug", "", "loadInfoFlowAd", "options", "Lcom/travel/adlibrary/common/AdOptions;", "loadSplashAd", "loadVideoAd", "adId", "preLoadImageTextAd", "action", "Lkotlin/Function0;", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.travel.adlibrary.c.a */
public final class TencentAd implements IAd {
    /* renamed from: a */
    public static final TencentAd f25936a = new TencentAd();
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static RewardVideoAD f25937b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, mo39189d2 = {"com/travel/adlibrary/tencent/TencentAd$loadSplashAd$1", "Lcom/qq/e/ads/splash/SplashADListener;", "onADClicked", "", "onADDismissed", "onADExposure", "onADLoaded", "l", "", "onADPresent", "onADTick", "onNoAD", "e", "Lcom/qq/e/comm/util/AdError;", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TencentAd.kt */
    /* renamed from: com.travel.adlibrary.c.a$a */
    public static final class C7677a implements SplashADListener {
        public void onADExposure() {
        }

        public void onADLoaded(long j) {
        }

        public void onADPresent() {
        }

        public void onADTick(long j) {
        }

        C7677a() {
        }

        public void onADDismissed() {
            XLog.m12692b("TencentAd onADDismissed");
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("SPLASH_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_DISMISS", Integer.valueOf(2), Integer.valueOf(0), null);
            }
        }

        public void onNoAD(AdError adError) {
            StringBuilder sb = new StringBuilder();
            sb.append("TencentAd onNoAD code==");
            sb.append(adError != null ? Integer.valueOf(adError.getErrorCode()) : null);
            sb.append("  msg==");
            sb.append(adError != null ? adError.getErrorMsg() : null);
            XLog.m12692b(sb.toString());
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("SPLASH_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_ERROR", Integer.valueOf(2), Integer.valueOf(0), null);
            }
        }

        public void onADClicked() {
            XLog.m12692b("TencentAd onAdClicked");
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("SPLASH_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_CLICKED", Integer.valueOf(2), Integer.valueOf(0), null);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo39189d2 = {"com/travel/adlibrary/tencent/TencentAd$loadVideoAd$1", "Lcom/qq/e/ads/rewardvideo/RewardVideoADListener;", "isAdClose", "", "isErrorOnce", "()Z", "setErrorOnce", "(Z)V", "isRewardVerify", "rewardVerify", "startShowTime", "", "invokeCallback", "", "onADClick", "onADClose", "onADExpose", "onADLoad", "onADShow", "onError", "e", "Lcom/qq/e/comm/util/AdError;", "onReward", "onVideoCached", "onVideoComplete", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TencentAd.kt */
    /* renamed from: com.travel.adlibrary.c.a$b */
    public static final class C7678b implements RewardVideoADListener {
        /* renamed from: a */
        final /* synthetic */ AdOptions f25938a;
        /* renamed from: b */
        private volatile boolean f25939b;
        /* renamed from: c */
        private volatile boolean f25940c;
        /* renamed from: d */
        private boolean f25941d;
        /* renamed from: e */
        private long f25942e;
        /* renamed from: f */
        private volatile boolean f25943f;

        public void onADExpose() {
        }

        public void onVideoCached() {
        }

        C7678b(AdOptions aVar) {
            this.f25938a = aVar;
        }

        /* renamed from: a */
        public final void mo37340a() {
            StringBuilder sb = new StringBuilder();
            sb.append("isMainThread==");
            sb.append(C8271i.m35384a((Object) Looper.getMainLooper(), (Object) Looper.myLooper()));
            XLog.m12692b(sb.toString());
            TencentAd.f25937b = null;
            if (this.f25939b && this.f25940c) {
                if (System.currentTimeMillis() - this.f25942e < ((long) C7516p.f25219Cf)) {
                    Toast.makeText(this.f25938a.mo37304b(), "广告展示出错，请稍后再试~", 0).show();
                    return;
                }
                C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
                if (rVar != null) {
                    Unit jVar = (Unit) rVar.invoke("METHOD_ON_COMPLETED", Integer.valueOf(2), Integer.valueOf(this.f25938a.mo37314j()), Boolean.valueOf(true));
                }
                C8258m l = this.f25938a.mo37316l();
                if (l != null) {
                    Unit jVar2 = (Unit) l.invoke(Boolean.valueOf(this.f25941d), Boolean.valueOf(true));
                }
            }
        }

        public void onADClick() {
            XLog.m12691a("TencentAd Video bar click");
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_CLICKED", Integer.valueOf(2), Integer.valueOf(this.f25938a.mo37314j()), null);
            }
        }

        public void onReward() {
            XLog.m12691a("TencentAd Video onReward");
            this.f25940c = true;
            this.f25941d = true;
            mo37340a();
        }

        public void onADClose() {
            XLog.m12691a("TencentAd Video close");
            this.f25939b = true;
            mo37340a();
            TencentAd.f25936a.mo37323a();
        }

        public void onADLoad() {
            RewardVideoAD a = TencentAd.f25937b;
            if (a != null) {
                a.showAD();
            }
        }

        public void onVideoComplete() {
            XLog.m12691a("TencentAd Video complete");
        }

        public void onError(AdError adError) {
            StringBuilder sb = new StringBuilder();
            sb.append("TencentAd Video onError code==");
            String str = null;
            sb.append(adError != null ? Integer.valueOf(adError.getErrorCode()) : null);
            sb.append("  msg==");
            if (adError != null) {
                str = adError.getErrorMsg();
            }
            sb.append(str);
            XLog.m12692b(sb.toString());
            if (!this.f25943f) {
                TencentAd.f25936a.mo37339d(this.f25938a);
                this.f25943f = true;
            }
        }

        public void onADShow() {
            XLog.m12691a("TencentAd Video show");
            this.f25942e = System.currentTimeMillis();
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_SHOW", Integer.valueOf(2), Integer.valueOf(this.f25938a.mo37314j()), null);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, mo39189d2 = {"com/travel/adlibrary/tencent/TencentAd$preLoadImageTextAd$bannerView$1", "Lcom/qq/e/ads/banner2/UnifiedBannerADListener;", "onADClicked", "", "onADCloseOverlay", "onADClosed", "onADExposure", "onADLeftApplication", "onADOpenOverlay", "onADReceive", "onNoAD", "error", "Lcom/qq/e/comm/util/AdError;", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TencentAd.kt */
    /* renamed from: com.travel.adlibrary.c.a$c */
    public static final class C7679c implements UnifiedBannerADListener {
        C7679c() {
        }

        public void onADCloseOverlay() {
            XLog.m12692b("TencentAd image onADCloseOverlay");
        }

        public void onADExposure() {
            XLog.m12692b("TencentAd image onADExposure");
        }

        public void onADClosed() {
            XLog.m12692b("TencentAd image onADClosed");
        }

        public void onADLeftApplication() {
            XLog.m12692b("TencentAd image onADLeftApplication");
        }

        public void onADOpenOverlay() {
            XLog.m12692b("TencentAd image onADOpenOverlay");
        }

        public void onNoAD(AdError adError) {
            StringBuilder sb = new StringBuilder();
            sb.append("TencentAd image errorCode==");
            String str = null;
            sb.append(adError != null ? Integer.valueOf(adError.getErrorCode()) : null);
            sb.append(" ,errorMsg==");
            if (adError != null) {
                str = adError.getErrorMsg();
            }
            sb.append(str);
            XLog.m12692b(sb.toString());
        }

        public void onADReceive() {
            XLog.m12692b("TencentAd image onADReceive");
        }

        public void onADClicked() {
            XLog.m12692b("TencentAd image onADClicked");
        }
    }

    /* renamed from: c */
    public void mo37330c(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
    }

    private TencentAd() {
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

    /* renamed from: b */
    public void mo37329b(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
        C7671a.m32992a(this, aVar);
    }

    /* renamed from: d */
    public void mo37339d(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
        C7671a.m32996c(this, aVar);
    }

    /* renamed from: a */
    public void mo37324a(Application application, boolean z) {
        C8271i.m35386b(application, "app");
        Context context = application;
        GDTADManager.getInstance().initWith(context, "1110216063");
        if (VERSION.SDK_INT >= 28) {
            String a = C7690a.m33043a(context);
            if (!C8271i.m35384a((Object) application.getPackageName(), (Object) a)) {
                WebView.setDataDirectorySuffix(a);
            }
        }
    }

    /* renamed from: a */
    public void mo37325a(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
        new SplashAD(aVar.mo37304b(), aVar.mo37305c(), new C7677a());
    }

    /* renamed from: a */
    public void mo37326a(AdOptions aVar, String str) {
        C8271i.m35386b(aVar, "options");
        C8271i.m35386b(str, "adId");
        RewardVideoAD rewardVideoAD = new RewardVideoAD(aVar.mo37304b(), str, new C7678b(aVar));
        rewardVideoAD.loadAD();
        f25937b = rewardVideoAD;
    }

    /* renamed from: a */
    public final LayoutParams mo37338a(Activity activity) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        Point point = new Point();
        WindowManager windowManager = activity.getWindowManager();
        C8271i.m35382a((Object) windowManager, "activity.windowManager");
        windowManager.getDefaultDisplay().getSize(point);
        return new LayoutParams(point.x, C8183a.m35250a(((float) point.x) / 6.4f));
    }

    /* renamed from: a */
    public void mo37327a(AdOptions aVar, String str, C8246a<Unit> aVar2) {
        C8271i.m35386b(aVar, "options");
        C8271i.m35386b(str, "adId");
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView(aVar.mo37304b(), "8071516168516728", new C7679c());
        unifiedBannerView.loadAD();
        AdSdk.f25896a.mo37289a().offer(new WeakReference(new TencentImageTextView(unifiedBannerView)));
        if (aVar2 != null) {
            Unit jVar = (Unit) aVar2.invoke();
        }
    }
}
