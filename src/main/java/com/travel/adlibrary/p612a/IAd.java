package com.travel.adlibrary.p612a;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.elvishew.xlog.XLog;
import com.p522qq.p523e.ads.banner2.UnifiedBannerView;
import com.travel.adlibrary.AdSdk;
import com.travel.adlibrary.p614c.TencentAd;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8258m;
import kotlin.jvm.p679a.C8263r;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J*\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019H&¨\u0006\u001a"}, mo39189d2 = {"Lcom/travel/adlibrary/common/IAd;", "", "attachImageTextAdToViewGroup", "", "options", "Lcom/travel/adlibrary/common/AdOptions;", "reference", "Ljava/lang/ref/WeakReference;", "Lcom/travel/adlibrary/common/IImageTextView;", "init", "app", "Landroid/app/Application;", "isDebug", "", "loadImageTextAd", "loadInfoFlowAd", "loadSplashAd", "loadVideoAd", "adId", "", "onImageTextError", "onVideoDismiss", "onVideoError", "preLoadImageTextAd", "action", "Lkotlin/Function0;", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.travel.adlibrary.a.c */
public interface IAd {

    @Metadata(mo39187bv = {1, 0, 3}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: IAd.kt */
    /* renamed from: com.travel.adlibrary.a.c$a */
    public static final class C7671a {

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo39189d2 = {"com/travel/adlibrary/common/IAd$loadImageTextAd$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
        /* compiled from: IAd.kt */
        /* renamed from: com.travel.adlibrary.a.c$a$a */
        public static final class C7673a implements OnAttachStateChangeListener {
            /* renamed from: a */
            final /* synthetic */ BooleanRef f25926a;
            /* renamed from: b */
            final /* synthetic */ ObjectRef f25927b;

            public void onViewAttachedToWindow(View view) {
            }

            C7673a(BooleanRef booleanRef, ObjectRef objectRef) {
                this.f25926a = booleanRef;
                this.f25927b = objectRef;
            }

            public void onViewDetachedFromWindow(View view) {
                this.f25926a.element = true;
                WeakReference weakReference = (WeakReference) this.f25927b.element;
                if (weakReference != null) {
                    IImageTextView dVar = (IImageTextView) weakReference.get();
                    if (dVar != null) {
                        dVar.mo37334a();
                    }
                }
            }
        }

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: IAd.kt */
        /* renamed from: com.travel.adlibrary.a.c$a$b */
        static final class C7674b extends Lambda implements C8246a<Unit> {
            final /* synthetic */ BooleanRef $isDestroy;
            final /* synthetic */ AdOptions $options;
            final /* synthetic */ ObjectRef $realExposureRef;
            final /* synthetic */ IAd this$0;

            C7674b(IAd cVar, BooleanRef booleanRef, ObjectRef objectRef, AdOptions aVar) {
                this.this$0 = cVar;
                this.$isDestroy = booleanRef;
                this.$realExposureRef = objectRef;
                this.$options = aVar;
                super(0);
            }

            public final void invoke() {
                if (!this.$isDestroy.element) {
                    T t = (WeakReference) AdSdk.f25896a.mo37289a().poll();
                    if (t != null) {
                        this.$realExposureRef.element = t;
                        this.this$0.mo37328a(this.$options, (WeakReference<IImageTextView>) t);
                    }
                    if (AdSdk.f25896a.mo37289a().isEmpty()) {
                        this.$options.mo37303a(true);
                        IAd cVar = this.this$0;
                        AdOptions aVar = this.$options;
                        C7671a.m32993a(cVar, aVar, aVar.mo37305c(), null, 4, null);
                    }
                }
            }
        }

        /* renamed from: a */
        public static void m32992a(IAd cVar, AdOptions aVar) {
            C8271i.m35386b(aVar, "options");
            StringBuilder sb = new StringBuilder();
            sb.append("type=");
            sb.append(cVar.getClass().getName());
            sb.append("   list size==");
            sb.append(AdSdk.f25896a.mo37289a().size());
            XLog.m12692b(sb.toString());
            if (!TextUtils.isEmpty(aVar.mo37305c())) {
                if (aVar.mo37315k()) {
                    m32993a(cVar, aVar, aVar.mo37305c(), null, 4, null);
                    return;
                }
                ObjectRef objectRef = new ObjectRef();
                IImageTextView dVar = null;
                objectRef.element = (WeakReference) null;
                BooleanRef booleanRef = new BooleanRef();
                booleanRef.element = false;
                ViewGroup e = aVar.mo37307e();
                if (e != null) {
                    e.addOnAttachStateChangeListener(new C7673a(booleanRef, objectRef));
                }
                T t = (WeakReference) AdSdk.f25896a.mo37289a().poll();
                if (t != null) {
                    dVar = (IImageTextView) t.get();
                }
                if (dVar == null) {
                    cVar.mo37327a(aVar, aVar.mo37305c(), new C7674b(cVar, booleanRef, objectRef, aVar));
                } else {
                    objectRef.element = t;
                    cVar.mo37328a(aVar, (WeakReference<IImageTextView>) t);
                    if (AdSdk.f25896a.mo37289a().isEmpty()) {
                        aVar.mo37303a(true);
                        m32993a(cVar, aVar, aVar.mo37305c(), null, 4, null);
                    }
                }
            }
        }

        /* renamed from: b */
        public static void m32995b(IAd cVar, AdOptions aVar) {
            C8271i.m35386b(aVar, "options");
            XLog.m12692b("onImageTextError");
            TencentAd.f25936a.mo37329b(aVar);
        }

        /* renamed from: a */
        public static void m32994a(IAd cVar, AdOptions aVar, WeakReference<IImageTextView> weakReference) {
            C8271i.m35386b(aVar, "options");
            C8271i.m35386b(weakReference, "reference");
            if (aVar.mo37307e() != null) {
                ViewGroup e = aVar.mo37307e();
                e.removeAllViews();
                IImageTextView dVar = (IImageTextView) weakReference.get();
                if (dVar != null) {
                    View b = dVar.mo37335b();
                    if (b != null) {
                        if (b instanceof UnifiedBannerView) {
                            XLog.m12692b("tencent imageText");
                            e.addView(b, TencentAd.f25936a.mo37338a(aVar.mo37304b()));
                        } else {
                            XLog.m12692b("other imageText");
                            e.addView(b);
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public static /* synthetic */ void m32993a(IAd cVar, AdOptions aVar, String str, C8246a aVar2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    aVar2 = null;
                }
                cVar.mo37327a(aVar, str, aVar2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preLoadImageTextAd");
        }

        /* renamed from: a */
        public static void m32991a(IAd cVar) {
            XLog.m12692b("onVideoDismiss");
            C8263r rVar = (C8263r) AdSdk.f25896a.mo37293b().get("VIDEO_LOADING_CALL_BACK_KEY");
            if (rVar != null) {
                Unit jVar = (Unit) rVar.invoke("METHOD_ON_VIDEO_DISMISS", Integer.valueOf(0), Integer.valueOf(0), null);
            }
        }

        /* renamed from: c */
        public static void m32996c(final IAd cVar, final AdOptions aVar) {
            C8271i.m35386b(aVar, "options");
            LinkedList i = aVar.mo37313i();
            C7670b bVar = i != null ? (C7670b) i.poll() : null;
            if (bVar != null) {
                IAd a = AdSdk.f25896a.mo37288a(bVar.mo37319b());
                StringBuilder sb = new StringBuilder();
                sb.append("onVideoError retry adPlat==");
                sb.append(a.getClass().getName());
                sb.append("  ,id==");
                sb.append(bVar.mo37318a());
                XLog.m12692b(sb.toString());
                aVar.mo37302a(1);
                a.mo37326a(aVar, bVar.mo37318a());
                return;
            }
            aVar.mo37304b().runOnUiThread(new Runnable() {
                public final void run() {
                    cVar.mo37323a();
                    Boolean valueOf = Boolean.valueOf(false);
                    Toast.makeText(aVar.mo37304b(), "视频在准备中，请稍后再试~", 0).show();
                    C8258m l = aVar.mo37316l();
                    if (l != null) {
                        Unit jVar = (Unit) l.invoke(valueOf, valueOf);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    void mo37323a();

    /* renamed from: a */
    void mo37324a(Application application, boolean z);

    /* renamed from: a */
    void mo37325a(AdOptions aVar);

    /* renamed from: a */
    void mo37326a(AdOptions aVar, String str);

    /* renamed from: a */
    void mo37327a(AdOptions aVar, String str, C8246a<Unit> aVar2);

    /* renamed from: a */
    void mo37328a(AdOptions aVar, WeakReference<IImageTextView> weakReference);

    /* renamed from: b */
    void mo37329b(AdOptions aVar);

    /* renamed from: c */
    void mo37330c(AdOptions aVar);
}
