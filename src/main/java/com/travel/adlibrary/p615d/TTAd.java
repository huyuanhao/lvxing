package com.travel.adlibrary.p615d;

import android.app.Application;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConfig.Builder;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener;
import com.elvishew.xlog.XLog;
import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.p605ep.commonbase.software.AppEntity;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import com.travel.adlibrary.AdSdk;
import com.travel.adlibrary.R;
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

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, mo39189d2 = {"Lcom/travel/adlibrary/tt/TTAd;", "Lcom/travel/adlibrary/common/IAd;", "()V", "init", "", "app", "Landroid/app/Application;", "isDebug", "", "loadInfoFlowAd", "options", "Lcom/travel/adlibrary/common/AdOptions;", "loadSplashAd", "loadVideoAd", "adId", "", "preLoadImageTextAd", "action", "Lkotlin/Function0;", "setDownloadListener", "ad", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.travel.adlibrary.d.a */
public final class TTAd implements IAd {
    /* renamed from: a */
    public static final TTAd f25945a = new TTAd();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016¨\u0006\f"}, mo39189d2 = {"com/travel/adlibrary/tt/TTAd$loadInfoFlowAd$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$NativeExpressAdListener;", "onError", "", "code", "", "message", "", "onNativeExpressAdLoad", "ads", "", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TTAd.kt */
    /* renamed from: com.travel.adlibrary.d.a$a */
    public static final class C7680a implements NativeExpressAdListener {
        /* renamed from: a */
        final /* synthetic */ AdOptions f25946a;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\"\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, mo39189d2 = {"com/travel/adlibrary/tt/TTAd$loadInfoFlowAd$1$onNativeExpressAdLoad$1", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd$ExpressAdInteractionListener;", "onAdClicked", "", "view", "Landroid/view/View;", "type", "", "onAdShow", "onRenderFail", "msg", "", "code", "onRenderSuccess", "width", "", "height", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
        /* compiled from: TTAd.kt */
        /* renamed from: com.travel.adlibrary.d.a$a$a */
        public static final class C7681a implements ExpressAdInteractionListener {
            /* renamed from: a */
            final /* synthetic */ C7680a f25947a;
            /* renamed from: b */
            final /* synthetic */ TTNativeExpressAd f25948b;

            C7681a(C7680a aVar, TTNativeExpressAd tTNativeExpressAd) {
                this.f25947a = aVar;
                this.f25948b = tTNativeExpressAd;
            }

            public void onAdClicked(View view, int i) {
                XLog.m12691a("onAdClicked");
            }

            public void onAdShow(View view, int i) {
                XLog.m12691a("onAdShow");
            }

            public void onRenderFail(View view, String str, int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("code==");
                sb.append(i);
                sb.append(" message==");
                sb.append(str);
                XLog.m12691a(sb.toString());
                this.f25948b.destroy();
            }

            public void onRenderSuccess(View view, float f, float f2) {
                StringBuilder sb = new StringBuilder();
                sb.append("onRenderSuccess width==");
                sb.append(f);
                sb.append(" height==");
                sb.append(f2);
                XLog.m12691a(sb.toString());
                ViewGroup e = this.f25947a.f25946a.mo37307e();
                if (e != null) {
                    e.removeAllViews();
                    e.addView(view);
                }
            }
        }

        C7680a(AdOptions aVar) {
            this.f25946a = aVar;
        }

        public void onError(int i, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("TTAd onError code=");
            sb.append(i);
            sb.append(",message=");
            sb.append(str);
            XLog.m12692b(sb.toString());
        }

        public void onNativeExpressAdLoad(List<? extends TTNativeExpressAd> list) {
            if (list != null && !list.isEmpty()) {
                TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) list.get(0);
                tTNativeExpressAd.setExpressInteractionListener((ExpressAdInteractionListener) new C7681a(this, tTNativeExpressAd));
                TTAd.f25945a.m33026a(tTNativeExpressAd);
                tTNativeExpressAd.render();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0017J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017J\b\u0010\u000b\u001a\u00020\u0003H\u0017¨\u0006\f"}, mo39189d2 = {"com/travel/adlibrary/tt/TTAd$loadSplashAd$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$SplashAdListener;", "onError", "", "code", "", "message", "", "onSplashAdLoad", "ad", "Lcom/bytedance/sdk/openadsdk/TTSplashAd;", "onTimeout", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TTAd.kt */
    /* renamed from: com.travel.adlibrary.d.a$b */
    public static final class C7682b implements SplashAdListener {
        /* renamed from: a */
        final /* synthetic */ AdOptions f25949a;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, mo39189d2 = {"com/travel/adlibrary/tt/TTAd$loadSplashAd$1$onSplashAdLoad$1", "Lcom/bytedance/sdk/openadsdk/TTSplashAd$AdInteractionListener;", "onAdClicked", "", "view", "Landroid/view/View;", "type", "", "onAdShow", "onAdSkip", "onAdTimeOver", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
        /* compiled from: TTAd.kt */
        /* renamed from: com.travel.adlibrary.d.a$b$a */
        public static final class C7683a implements AdInteractionListener {
            C7683a() {
            }

            public void onAdClicked(View view, int i) {
                XLog.m12692b("TTAd onAdClicked");
                C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("SPLASH_CALL_BACK_KEY");
                if (rVar != null) {
                    Unit jVar = (Unit) rVar.invoke("METHOD_ON_CLICKED", Integer.valueOf(1), Integer.valueOf(0), null);
                }
            }

            public void onAdShow(View view, int i) {
                XLog.m12692b("TTAd onAdShow");
            }

            public void onAdSkip() {
                XLog.m12692b("TTAd onAdSkip");
                C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("SPLASH_CALL_BACK_KEY");
                if (rVar != null) {
                    Unit jVar = (Unit) rVar.invoke("METHOD_ON_DISMISS", Integer.valueOf(1), Integer.valueOf(0), null);
                }
            }

            public void onAdTimeOver() {
                XLog.m12692b("TTAd onAdTimeOver");
                C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("SPLASH_CALL_BACK_KEY");
                if (rVar != null) {
                    Unit jVar = (Unit) rVar.invoke("METHOD_ON_ERROR", Integer.valueOf(1), Integer.valueOf(0), null);
                }
            }
        }

        C7682b(AdOptions aVar) {
            this.f25949a = aVar;
        }

        public void onError(int i, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("TTAd onError code=");
            sb.append(i);
            sb.append(",message=");
            sb.append(str);
            XLog.m12692b(sb.toString());
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("SPLASH_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_ERROR", Integer.valueOf(1), Integer.valueOf(0), null);
            }
        }

        public void onTimeout() {
            XLog.m12692b("TTAd onTimeout");
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("SPLASH_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_ERROR", Integer.valueOf(1), Integer.valueOf(0), null);
            }
        }

        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            if (tTSplashAd != null) {
                View splashView = tTSplashAd.getSplashView();
                C8271i.m35382a((Object) splashView, "ad.splashView");
                ViewGroup e = this.f25949a.mo37307e();
                if (e != null) {
                    e.removeAllViews();
                }
                ViewGroup e2 = this.f25949a.mo37307e();
                if (e2 != null) {
                    e2.addView(splashView);
                }
                tTSplashAd.setSplashInteractionListener(new C7683a());
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo39189d2 = {"com/travel/adlibrary/tt/TTAd$loadVideoAd$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$RewardVideoAdListener;", "isErrorOnce", "", "()Z", "setErrorOnce", "(Z)V", "onError", "", "code", "", "message", "", "onRewardVideoAdLoad", "ad", "Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;", "onRewardVideoCached", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TTAd.kt */
    /* renamed from: com.travel.adlibrary.d.a$c */
    public static final class C7684c implements RewardVideoAdListener {
        /* renamed from: a */
        final /* synthetic */ AdOptions f25950a;
        /* renamed from: b */
        private volatile boolean f25951b;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\"\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo39189d2 = {"com/travel/adlibrary/tt/TTAd$loadVideoAd$1$onRewardVideoAdLoad$1", "Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd$RewardAdInteractionListener;", "isAdClose", "", "isRewardVerify", "rewardVerify", "startShowTime", "", "invokeCallback", "", "onAdClose", "onAdShow", "onAdVideoBarClick", "onRewardVerify", "rewardAmount", "", "rewardName", "", "onSkippedVideo", "onVideoComplete", "onVideoError", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
        /* compiled from: TTAd.kt */
        /* renamed from: com.travel.adlibrary.d.a$c$a */
        public static final class C7685a implements RewardAdInteractionListener {
            /* renamed from: a */
            final /* synthetic */ C7684c f25952a;
            /* renamed from: b */
            private volatile boolean f25953b;
            /* renamed from: c */
            private volatile boolean f25954c;
            /* renamed from: d */
            private boolean f25955d;
            /* renamed from: e */
            private long f25956e;

            C7685a(C7684c cVar) {
                this.f25952a = cVar;
            }

            /* renamed from: a */
            public final void mo37345a() {
                StringBuilder sb = new StringBuilder();
                sb.append("isMainThread==");
                sb.append(C8271i.m35384a((Object) Looper.getMainLooper(), (Object) Looper.myLooper()));
                XLog.m12692b(sb.toString());
                if (this.f25953b && this.f25954c) {
                    if (System.currentTimeMillis() - this.f25956e < ((long) C7516p.f25219Cf)) {
                        Toast.makeText(this.f25952a.f25950a.mo37304b(), "广告展示出错，请稍后再试~", 0).show();
                        return;
                    }
                    C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
                    if (rVar != null) {
                        Unit jVar = (Unit) rVar.invoke("METHOD_ON_COMPLETED", Integer.valueOf(1), Integer.valueOf(this.f25952a.f25950a.mo37314j()), null);
                    }
                    C8258m l = this.f25952a.f25950a.mo37316l();
                    if (l != null) {
                        Unit jVar2 = (Unit) l.invoke(Boolean.valueOf(this.f25955d), Boolean.valueOf(false));
                    }
                }
            }

            public void onAdShow() {
                XLog.m12692b("TTAd Video show");
                this.f25956e = System.currentTimeMillis();
                C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
                if (rVar != null) {
                    Unit jVar = (Unit) rVar.invoke("METHOD_ON_SHOW", Integer.valueOf(1), Integer.valueOf(this.f25952a.f25950a.mo37314j()), null);
                }
            }

            public void onAdVideoBarClick() {
                XLog.m12692b("TTAd Video bar click");
                C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
                if (rVar != null) {
                    Unit jVar = (Unit) rVar.invoke("METHOD_ON_CLICKED", Integer.valueOf(1), Integer.valueOf(this.f25952a.f25950a.mo37314j()), null);
                }
            }

            public void onAdClose() {
                XLog.m12692b("TTAd Video close");
                this.f25953b = true;
                mo37345a();
                TTAd.f25945a.mo37323a();
            }

            public void onVideoComplete() {
                XLog.m12692b("TTAd Video complete");
            }

            public void onVideoError() {
                XLog.m12692b("TTAd Video error");
                if (!this.f25952a.mo37344a()) {
                    TTAd.f25945a.mo37342e(this.f25952a.f25950a);
                    this.f25952a.mo37343a(true);
                }
            }

            public void onRewardVerify(boolean z, int i, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("TTAd verify:");
                sb.append(z);
                sb.append(", amount:");
                sb.append(i);
                sb.append(", name:");
                sb.append(str);
                XLog.m12692b(sb.toString());
                this.f25954c = true;
                this.f25955d = z;
                mo37345a();
            }

            public void onSkippedVideo() {
                XLog.m12692b("TTAd Video onSkippedVideo");
            }
        }

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J,\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo39189d2 = {"com/travel/adlibrary/tt/TTAd$loadVideoAd$1$onRewardVideoAdLoad$2", "Lcom/bytedance/sdk/openadsdk/TTAppDownloadListener;", "hasShowDownloadActive", "", "onDownloadActive", "", "totalBytes", "", "currBytes", "fileName", "", "appName", "onDownloadFailed", "onDownloadFinished", "onDownloadPaused", "onIdle", "onInstalled", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
        /* compiled from: TTAd.kt */
        /* renamed from: com.travel.adlibrary.d.a$c$b */
        public static final class C7686b implements TTAppDownloadListener {
            /* renamed from: a */
            final /* synthetic */ C7684c f25957a;
            /* renamed from: b */
            private boolean f25958b;

            C7686b(C7684c cVar) {
                this.f25957a = cVar;
            }

            public void onIdle() {
                this.f25958b = false;
            }

            public void onDownloadActive(long j, long j2, String str, String str2) {
                if (!this.f25958b) {
                    this.f25958b = true;
                    XLog.m12691a("下载中，点击下载区域暂停");
                }
            }

            public void onDownloadPaused(long j, long j2, String str, String str2) {
                C8271i.m35386b(str, "fileName");
                C8271i.m35386b(str2, AppEntity.KEY_APP_NAME_STR);
                XLog.m12691a("下载暂停，点击下载区域继续");
            }

            public void onDownloadFailed(long j, long j2, String str, String str2) {
                XLog.m12691a("下载失败，点击下载区域重新下载");
            }

            public void onDownloadFinished(long j, String str, String str2) {
                XLog.m12691a("下载完成，点击下载区域重新下载");
                C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_CALL_BACK_KEY");
                if (rVar != null) {
                    Unit jVar = (Unit) rVar.invoke("METHOD_ON_DOWNLOADED", Integer.valueOf(1), Integer.valueOf(this.f25957a.f25950a.mo37314j()), null);
                }
            }

            public void onInstalled(String str, String str2) {
                XLog.m12691a("安装完成，点击下载区域打开");
            }
        }

        C7684c(AdOptions aVar) {
            this.f25950a = aVar;
        }

        /* renamed from: a */
        public final void mo37343a(boolean z) {
            this.f25951b = z;
        }

        /* renamed from: a */
        public final boolean mo37344a() {
            return this.f25951b;
        }

        public void onError(int i, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("TTAd Video [");
            sb.append(i);
            sb.append("]message");
            XLog.m12692b(sb.toString());
            if (!this.f25951b) {
                TTAd.f25945a.mo37342e(this.f25950a);
                this.f25951b = true;
            }
        }

        public void onRewardVideoCached() {
            XLog.m12692b("TTAd Video video cached");
        }

        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            C8271i.m35386b(tTRewardVideoAd, "ad");
            XLog.m12692b("TTAd Video loaded");
            tTRewardVideoAd.setShowDownLoadBar(true);
            tTRewardVideoAd.setRewardAdInteractionListener(new C7685a(this));
            tTRewardVideoAd.setDownloadListener(new C7686b(this));
            tTRewardVideoAd.showRewardVideoAd(this.f25950a.mo37304b());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016¨\u0006\f"}, mo39189d2 = {"com/travel/adlibrary/tt/TTAd$preLoadImageTextAd$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$NativeExpressAdListener;", "onError", "", "code", "", "message", "", "onNativeExpressAdLoad", "list", "", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TTAd.kt */
    /* renamed from: com.travel.adlibrary.d.a$d */
    public static final class C7687d implements NativeExpressAdListener {
        /* renamed from: a */
        final /* synthetic */ AdOptions f25959a;
        /* renamed from: b */
        final /* synthetic */ C8246a f25960b;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\"\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, mo39189d2 = {"com/travel/adlibrary/tt/TTAd$preLoadImageTextAd$1$onNativeExpressAdLoad$1", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd$ExpressAdInteractionListener;", "onAdClicked", "", "p0", "Landroid/view/View;", "p1", "", "onAdShow", "onRenderFail", "message", "", "code", "onRenderSuccess", "view", "width", "", "height", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
        /* compiled from: TTAd.kt */
        /* renamed from: com.travel.adlibrary.d.a$d$a */
        public static final class C7688a implements ExpressAdInteractionListener {
            /* renamed from: a */
            final /* synthetic */ C7687d f25961a;
            /* renamed from: b */
            final /* synthetic */ TTNativeExpressAd f25962b;

            C7688a(C7687d dVar, TTNativeExpressAd tTNativeExpressAd) {
                this.f25961a = dVar;
                this.f25962b = tTNativeExpressAd;
            }

            public void onAdClicked(View view, int i) {
                C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("TEXT_CALL_BACK_KEY");
                if (rVar != null) {
                    Unit jVar = (Unit) rVar.invoke("METHOD_ON_CLICKED", Integer.valueOf(1), Integer.valueOf(0), null);
                }
            }

            public void onAdShow(View view, int i) {
                C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("TEXT_CALL_BACK_KEY");
                if (rVar != null) {
                    Unit jVar = (Unit) rVar.invoke("METHOD_ON_SHOW", Integer.valueOf(1), Integer.valueOf(0), null);
                }
            }

            public void onRenderSuccess(View view, float f, float f2) {
                StringBuilder sb = new StringBuilder();
                sb.append("TTAd onRenderSuccess width==");
                sb.append(f);
                sb.append(" height==");
                sb.append(f2);
                XLog.m12692b(sb.toString());
                if (view != null) {
                    AdSdk.f25896a.mo37289a().offer(new WeakReference(new TTImageTextView(view, this.f25962b)));
                    C8246a aVar = this.f25961a.f25960b;
                    if (aVar != null) {
                        Unit jVar = (Unit) aVar.invoke();
                    }
                }
            }

            public void onRenderFail(View view, String str, int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("TTAd onRenderFail code==");
                sb.append(i);
                sb.append(" message==");
                sb.append(str);
                XLog.m12692b(sb.toString());
                TTAd.f25945a.mo37341d(this.f25961a.f25959a);
                this.f25962b.destroy();
            }
        }

        C7687d(AdOptions aVar, C8246a aVar2) {
            this.f25959a = aVar;
            this.f25960b = aVar2;
        }

        public void onError(int i, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("TTAd onError code==");
            sb.append(i);
            sb.append(" message==");
            sb.append(str);
            XLog.m12692b(sb.toString());
            TTAd.f25945a.mo37341d(this.f25959a);
        }

        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list != null && !list.isEmpty()) {
                TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) list.get(0);
                TTAd.f25945a.m33026a(tTNativeExpressAd);
                tTNativeExpressAd.setExpressInteractionListener((ExpressAdInteractionListener) new C7688a(this, tTNativeExpressAd));
                tTNativeExpressAd.setSlideIntervalTime(C7120a.MAX_USERDATA_VALUE_LENGTH);
                try {
                    tTNativeExpressAd.render();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J,\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J,\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u001c\u0010\u0014\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, mo39189d2 = {"com/travel/adlibrary/tt/TTAd$setDownloadListener$1", "Lcom/bytedance/sdk/openadsdk/TTAppDownloadListener;", "mHasShowDownloadActive", "", "getMHasShowDownloadActive", "()Z", "setMHasShowDownloadActive", "(Z)V", "onDownloadActive", "", "totalBytes", "", "currBytes", "fileName", "", "appName", "onDownloadFailed", "onDownloadFinished", "onDownloadPaused", "onIdle", "onInstalled", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TTAd.kt */
    /* renamed from: com.travel.adlibrary.d.a$e */
    public static final class C7689e implements TTAppDownloadListener {
        /* renamed from: a */
        private boolean f25963a;

        public void onIdle() {
        }

        C7689e() {
        }

        public void onDownloadActive(long j, long j2, String str, String str2) {
            if (!this.f25963a) {
                this.f25963a = true;
                XLog.m12691a("下载中，点击暂停");
            }
        }

        public void onDownloadPaused(long j, long j2, String str, String str2) {
            XLog.m12691a("下载暂停，点击继续");
        }

        public void onDownloadFailed(long j, long j2, String str, String str2) {
            XLog.m12691a("下载失败，点击重新下载");
        }

        public void onInstalled(String str, String str2) {
            XLog.m12691a("安装完成，点击图片打开");
        }

        public void onDownloadFinished(long j, String str, String str2) {
            XLog.m12691a("点击安装");
        }
    }

    private TTAd() {
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
    public void mo37341d(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
        C7671a.m32995b(this, aVar);
    }

    /* renamed from: e */
    public void mo37342e(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
        C7671a.m32996c(this, aVar);
    }

    /* renamed from: a */
    public void mo37324a(Application application, boolean z) {
        C8271i.m35386b(application, "app");
        String str = z ? "5033945" : "5038035";
        StringBuilder sb = new StringBuilder();
        sb.append("appId==");
        sb.append(str);
        XLog.m12691a(sb.toString());
        TTAdSdk.init(application, new Builder().appId(str).useTextureView(true).appName(application.getString(R.string.app_name)).titleBarTheme(1).allowShowNotify(true).allowShowPageWhenScreenLock(false).debug(false).directDownloadNetworkType(4, 3).supportMultiProcess(false).build());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TT ad version==");
        TTAdManager adManager = TTAdSdk.getAdManager();
        C8271i.m35382a((Object) adManager, "TTAdSdk.getAdManager()");
        sb2.append(adManager.getSDKVersion());
        XLog.m12692b(sb2.toString());
    }

    /* renamed from: a */
    public void mo37325a(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
        TTAdSdk.getAdManager().createAdNative(aVar.mo37304b()).loadSplashAd(new AdSlot.Builder().setCodeId(aVar.mo37305c()).setSupportDeepLink(true).setImageAcceptedSize(1080, 1920).build(), new C7682b(aVar), aVar.mo37309f());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0040, code lost:
            if (r1 != null) goto L_0x0045;
     */
    /* renamed from: a */
    public void mo37326a(com.travel.adlibrary.p612a.AdOptions r9, java.lang.String r10) {
        /*
        r8 = this;
        java.lang.String r0 = "options"
        kotlin.jvm.internal.C8271i.m35386b(r9, r0)
        java.lang.String r0 = "adId"
        kotlin.jvm.internal.C8271i.m35386b(r10, r0)
        com.bytedance.sdk.openadsdk.TTAdManager r0 = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager()
        android.app.Activity r1 = r9.mo37304b()
        android.content.Context r1 = (android.content.Context) r1
        com.bytedance.sdk.openadsdk.TTAdNative r0 = r0.createAdNative(r1)
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "====> userId = "
        r1.append(r2)
        java.lang.String r2 = r9.mo37306d()
        r1.append(r2)
        java.lang.String r1 = r1.toString()
        com.elvishew.xlog.XLog.m12691a(r1)
        java.lang.String r2 = r9.mo37310g()
        if (r2 == 0) goto L_0x0043
        r5 = 0
        r6 = 4
        r7 = 0
        java.lang.String r3 = "adIdValue"
        r4 = r10
        java.lang.String r1 = kotlin.text.C8313m.m35461a(r2, r3, r4, r5, r6, r7)
        if (r1 == 0) goto L_0x0043
        goto L_0x0045
    L_0x0043:
        java.lang.String r1 = ""
    L_0x0045:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "extra==="
        r2.append(r3)
        r2.append(r1)
        java.lang.String r2 = r2.toString()
        com.elvishew.xlog.XLog.m12692b(r2)
        com.bytedance.sdk.openadsdk.AdSlot$Builder r2 = new com.bytedance.sdk.openadsdk.AdSlot$Builder
        r2.m43221init()
        com.bytedance.sdk.openadsdk.AdSlot$Builder r10 = r2.setCodeId(r10)
        r2 = 1
        com.bytedance.sdk.openadsdk.AdSlot$Builder r10 = r10.setSupportDeepLink(r2)
        r3 = 1080(0x438, float:1.513E-42)
        r4 = 1920(0x780, float:2.69E-42)
        com.bytedance.sdk.openadsdk.AdSlot$Builder r10 = r10.setImageAcceptedSize(r3, r4)
        java.lang.String r3 = r9.mo37306d()
        com.bytedance.sdk.openadsdk.AdSlot$Builder r10 = r10.setUserID(r3)
        com.bytedance.sdk.openadsdk.AdSlot$Builder r10 = r10.setOrientation(r2)
        com.bytedance.sdk.openadsdk.AdSlot$Builder r10 = r10.setMediaExtra(r1)
        com.bytedance.sdk.openadsdk.AdSlot r10 = r10.build()
        if (r0 == 0) goto L_0x008f
        com.travel.adlibrary.d.a$c r1 = new com.travel.adlibrary.d.a$c
        r1.m53821init(r9)
        com.bytedance.sdk.openadsdk.TTAdNative$RewardVideoAdListener r1 = (com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener) r1
        r0.loadRewardVideoAd(r10, r1)
    L_0x008f:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.adlibrary.p615d.TTAd.mo37326a(com.travel.adlibrary.a.a, java.lang.String):void");
    }

    /* renamed from: a */
    public void mo37327a(AdOptions aVar, String str, C8246a<Unit> aVar2) {
        C8271i.m35386b(aVar, "options");
        C8271i.m35386b(str, "adId");
        try {
            if (!TextUtils.isEmpty(str)) {
                TTAdSdk.getAdManager().createAdNative(aVar.mo37304b().getApplication()).loadBannerExpressAd(new AdSlot.Builder().setCodeId(str).setSupportDeepLink(true).setExpressViewAcceptedSize(400.0f, 0.0f).setImageAcceptedSize(ScreenUtil.M9_WIDTH, 320).setAdCount(1).build(), new C7687d(aVar, aVar2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m33026a(TTNativeExpressAd tTNativeExpressAd) {
        if (tTNativeExpressAd.getInteractionType() == 4) {
            tTNativeExpressAd.setDownloadListener(new C7689e());
        }
    }

    /* renamed from: c */
    public void mo37330c(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
        try {
            if (!TextUtils.isEmpty(aVar.mo37305c())) {
                TTAdSdk.getAdManager().createAdNative(aVar.mo37304b()).loadNativeExpressAd(new AdSlot.Builder().setCodeId(aVar.mo37305c()).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(aVar.mo37311h(), 0.0f).setImageAcceptedSize(ScreenUtil.M9_WIDTH, 320).build(), new C7680a(aVar));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
