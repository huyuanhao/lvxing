package com.travel.adlibrary.p613b;

import android.app.Application;
import android.os.Looper;
import android.widget.Toast;
import com.elvishew.xlog.XLog;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.SdkConfig.Builder;
import com.kwad.sdk.export.p347i.IAdRequestManager.RewardVideoAdListener;
import com.kwad.sdk.export.p347i.KsRewardVideoAd;
import com.kwad.sdk.export.p347i.KsRewardVideoAd.RewardAdInteractionListener;
import com.kwad.sdk.protocol.model.AdScene;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import com.travel.adlibrary.AdSdk;
import com.travel.adlibrary.p612a.AdOptions;
import com.travel.adlibrary.p612a.IAd;
import com.travel.adlibrary.p612a.IAd.C7671a;
import com.travel.adlibrary.p612a.IImageTextView;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8258m;
import kotlin.jvm.p679a.C8263r;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0017"}, mo39189d2 = {"Lcom/travel/adlibrary/ks/KsAd;", "Lcom/travel/adlibrary/common/IAd;", "()V", "init", "", "app", "Landroid/app/Application;", "isDebug", "", "loadImageTextAd", "options", "Lcom/travel/adlibrary/common/AdOptions;", "loadInfoFlowAd", "loadSplashAd", "loadVideoAd", "adId", "", "preLoadImageTextAd", "action", "Lkotlin/Function0;", "showRewardVideoAd", "ad", "Lcom/kwad/sdk/export/i/KsRewardVideoAd;", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.travel.adlibrary.b.a */
public final class KsAd implements IAd {
    /* renamed from: a */
    public static final KsAd f25928a = new KsAd();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo39189d2 = {"com/travel/adlibrary/ks/KsAd$loadVideoAd$1", "Lcom/kwad/sdk/export/i/IAdRequestManager$RewardVideoAdListener;", "isErrorOnce", "", "()Z", "setErrorOnce", "(Z)V", "onError", "", "code", "", "msg", "", "onRewardVideoAdLoad", "adList", "", "Lcom/kwad/sdk/export/i/KsRewardVideoAd;", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: KsAd.kt */
    /* renamed from: com.travel.adlibrary.b.a$a */
    public static final class C7675a implements RewardVideoAdListener {
        /* renamed from: a */
        final /* synthetic */ AdOptions f25929a;
        /* renamed from: b */
        private volatile boolean f25930b;

        C7675a(AdOptions aVar) {
            this.f25929a = aVar;
        }

        public void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
            if (list == null || list.size() <= 0) {
                KsAd.f25928a.mo37336d(this.f25929a);
            } else {
                KsAd.f25928a.m32999a((KsRewardVideoAd) list.get(0), this.f25929a);
            }
        }

        public void onError(int i, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("KsAd onError code==");
            sb.append(i);
            sb.append(" msg==");
            sb.append(str);
            XLog.m12692b(sb.toString());
            if (!this.f25930b) {
                KsAd.f25928a.mo37336d(this.f25929a);
                this.f25930b = true;
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo39189d2 = {"com/travel/adlibrary/ks/KsAd$showRewardVideoAd$1", "Lcom/kwad/sdk/export/i/KsRewardVideoAd$RewardAdInteractionListener;", "isAdClose", "", "isErrorOnce", "()Z", "setErrorOnce", "(Z)V", "isRewardVerify", "startShowTime", "", "invokeCallback", "", "onAdClicked", "onPageDismiss", "onRewardVerify", "onVideoPlayEnd", "onVideoPlayError", "code", "", "extra", "onVideoPlayStart", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: KsAd.kt */
    /* renamed from: com.travel.adlibrary.b.a$b */
    public static final class C7676b implements RewardAdInteractionListener {
        /* renamed from: a */
        final /* synthetic */ AdOptions f25931a;
        /* renamed from: b */
        private volatile boolean f25932b;
        /* renamed from: c */
        private volatile boolean f25933c;
        /* renamed from: d */
        private long f25934d;
        /* renamed from: e */
        private volatile boolean f25935e;

        public void onVideoPlayEnd() {
        }

        C7676b(AdOptions aVar) {
            this.f25931a = aVar;
        }

        /* renamed from: a */
        public final void mo37337a() {
            StringBuilder sb = new StringBuilder();
            sb.append("isMainThread==");
            sb.append(C8271i.m35384a((Object) Looper.getMainLooper(), (Object) Looper.myLooper()));
            XLog.m12692b(sb.toString());
            if (this.f25932b && this.f25933c) {
                if (System.currentTimeMillis() - this.f25934d < ((long) C7516p.f25219Cf)) {
                    Toast.makeText(this.f25931a.mo37304b(), "广告展示出错，请稍后再试~", 0).show();
                    return;
                }
                C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
                if (rVar != null) {
                    Unit jVar = (Unit) rVar.invoke("METHOD_ON_COMPLETED", Integer.valueOf(4), Integer.valueOf(this.f25931a.mo37314j()), null);
                }
                C8258m l = this.f25931a.mo37316l();
                if (l != null) {
                    Unit jVar2 = (Unit) l.invoke(Boolean.valueOf(true), Boolean.valueOf(false));
                }
            }
        }

        public void onRewardVerify() {
            XLog.m12692b("KsAd Video onRewardVerify");
            this.f25933c = true;
            mo37337a();
        }

        public void onAdClicked() {
            XLog.m12692b("KsAd Video bar click");
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_CLICKED", Integer.valueOf(4), Integer.valueOf(this.f25931a.mo37314j()), null);
            }
        }

        public void onVideoPlayStart() {
            XLog.m12692b("KsAd Video show start");
            this.f25934d = System.currentTimeMillis();
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_SHOW", Integer.valueOf(4), Integer.valueOf(this.f25931a.mo37314j()), null);
            }
        }

        public void onVideoPlayError(int i, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("KsAd onVideoPlayError code==");
            sb.append(i);
            sb.append(" extra==");
            sb.append(i2);
            XLog.m12692b(sb.toString());
            if (!this.f25935e) {
                KsAd.f25928a.mo37336d(this.f25931a);
                this.f25935e = true;
            }
        }

        public void onPageDismiss() {
            XLog.m12692b("KsAd Video close");
            this.f25932b = true;
            mo37337a();
            KsAd.f25928a.mo37323a();
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

    private KsAd() {
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
    public void mo37336d(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
        C7671a.m32996c(this, aVar);
    }

    /* renamed from: a */
    public void mo37324a(Application application, boolean z) {
        C8271i.m35386b(application, "app");
        KsAdSDK.init(application, new Builder().appId("518500001").appName("旅行世界").showNotification(true).debug(z).build());
    }

    /* renamed from: a */
    public void mo37326a(AdOptions aVar, String str) {
        C8271i.m35386b(aVar, "options");
        C8271i.m35386b(str, "adId");
        KsAdSDK.getAdManager().loadRewardVideoAd(new AdScene(Long.parseLong(str)), new C7675a(aVar));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m32999a(KsRewardVideoAd ksRewardVideoAd, AdOptions aVar) {
        if (ksRewardVideoAd == null || !ksRewardVideoAd.isAdEnable()) {
            mo37336d(aVar);
            return;
        }
        ksRewardVideoAd.setRewardAdInteractionListener(new C7676b(aVar));
        ksRewardVideoAd.showRewardVideoAd(aVar.mo37304b(), null);
    }
}
