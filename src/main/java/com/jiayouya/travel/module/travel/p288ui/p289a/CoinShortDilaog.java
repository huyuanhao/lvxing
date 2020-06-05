package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.bumptech.glide.Glide;
import com.jiayouya.travel.C2914d;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.common.p246d.AdExtra;
import com.jiayouya.travel.common.p246d.RxUtil;
import com.jiayouya.travel.databinding.DialogCoinShortBinding;
import com.jiayouya.travel.module.common.data.AdRsp;
import com.jiayouya.travel.module.common.data.AdRspKt;
import com.jiayouya.travel.module.common.p258b.AdReportResultEvent;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.travel.data.BuyDogRsp;
import com.jiayouya.travel.module.travel.data.GetCoinItem;
import com.tencent.android.tpush.common.Constants;
import com.travel.adlibrary.AdSdk;
import com.travel.adlibrary.p612a.AdOptions;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundLayout;
import java.util.concurrent.TimeUnit;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.jvm.p679a.C8258m;
import kotlin.reflect.C8280j;
import p655io.reactivex.Observable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/CoinShortDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "activity", "Landroid/app/Activity;", "item", "Lcom/jiayouya/travel/module/travel/data/BuyDogRsp;", "(Landroid/app/Activity;Lcom/jiayouya/travel/module/travel/data/BuyDogRsp;)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/jiayouya/travel/databinding/DialogCoinShortBinding;", "kotlin.jvm.PlatformType", "d", "Lio/reactivex/disposables/Disposable;", "isClosedAd", "", "isLong", "isReported", "isShowFlowAd", "()Z", "isShowFlowAd$delegate", "Lkotlin/Lazy;", "getItem", "()Lcom/jiayouya/travel/module/travel/data/BuyDogRsp;", "dispose", "", "loadImageTextAd", "loadInfoFlowAd", "loadVideoAd", "setCloseEnable", "setupClick", "setupObserve", "setupView", "showGetCoin", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.c */
public final class CoinShortDilaog extends CustomDialog {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f11949a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(CoinShortDilaog.class), "isShowFlowAd", "isShowFlowAd()Z"))};
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final DialogCoinShortBinding f11950b = ((DialogCoinShortBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_coin_short, null, false));
    /* renamed from: c */
    private final Lazy f11951c = C8182c.m35317a(new C3348a(this));
    /* renamed from: d */
    private Disposable f11952d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean f11953e;
    /* access modifiers changed from: private|volatile */
    /* renamed from: f */
    public volatile boolean f11954f;
    /* access modifiers changed from: private|volatile */
    /* renamed from: g */
    public volatile boolean f11955g;
    /* renamed from: h */
    private final Activity f11956h;
    /* renamed from: i */
    private final BuyDogRsp f11957i;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoinShortDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.c$a */
    static final class C3348a extends Lambda implements C8246a<Boolean> {
        final /* synthetic */ CoinShortDilaog this$0;

        C3348a(CoinShortDilaog cVar) {
            this.this$0 = cVar;
            super(0);
        }

        public final boolean invoke() {
            AdRsp adInfo = this.this$0.mo22247b().getAdInfo();
            return !TextUtils.isEmpty(adInfo != null ? adInfo.getAdIdInfoFlow() : null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "userId", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoinShortDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.c$b */
    static final class C3349b extends Lambda implements C8247b<String, Unit> {
        final /* synthetic */ AdRsp $ad;
        final /* synthetic */ CoinShortDilaog this$0;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "isLong", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: CoinShortDilaog.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.a.c$b$a */
        static final class C3350a extends Lambda implements C8258m<Boolean, Boolean, Unit> {
            final /* synthetic */ C3349b this$0;

            C3350a(C3349b bVar) {
                this.this$0 = bVar;
                super(2);
            }

            public /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                return Unit.f27778a;
            }

            public final void invoke(boolean z, boolean z2) {
                this.this$0.this$0.f11955g = true;
                this.this$0.this$0.f11953e = z2;
                this.this$0.this$0.m14530l();
            }
        }

        C3349b(CoinShortDilaog cVar, AdRsp adRsp) {
            this.this$0 = cVar;
            this.$ad = adRsp;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return Unit.f27778a;
        }

        public final void invoke(String str) {
            String str2 = str;
            C8271i.m35386b(str2, "userId");
            AdOptions aVar = r1;
            AdOptions aVar2 = new AdOptions(0, this.this$0.mo22246a(), this.$ad.getAdIdVideo(), str2, null, 0, null, AdExtra.m12931a(this.$ad.getAdLogId(), str2, (String) null, 4, (Object) null), 0.0f, AdRspKt.adVideoPlats(this.$ad), 0, false, new C3350a(this), 3440, null);
            AdExtra.m12935a(this.$ad.getAdLogId(), this.this$0.mo22247b().getCoin());
            if (AdSdk.f25896a.mo37292a(aVar)) {
                this.this$0.dismiss();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Long;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoinShortDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.c$c */
    static final class C3351c<T> implements Consumer<Long> {
        /* renamed from: a */
        final /* synthetic */ CoinShortDilaog f11958a;

        C3351c(CoinShortDilaog cVar) {
            this.f11958a = cVar;
        }

        /* renamed from: a */
        public final void accept(Long l) {
            boolean z = true;
            String str = "binding.ivClose";
            if (l != null && l.longValue() == 0) {
                this.f11958a.setCancelable(true);
                this.f11958a.setCanceledOnTouchOutside(true);
                TextView textView = this.f11958a.f11950b.f10321b;
                C8271i.m35382a((Object) textView, str);
                textView.setText("");
            } else {
                TextView textView2 = this.f11958a.f11950b.f10321b;
                C8271i.m35382a((Object) textView2, str);
                textView2.setText(String.valueOf(l));
            }
            TextView textView3 = this.f11958a.f11950b.f10321b;
            C8271i.m35382a((Object) textView3, str);
            if (l == null || l.longValue() != 0) {
                z = false;
            }
            textView3.setEnabled(z);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoinShortDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.c$d */
    static final class C3352d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ CoinShortDilaog this$0;

        C3352d(CoinShortDilaog cVar) {
            this.this$0 = cVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.dismiss();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoinShortDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.c$e */
    static final class C3353e extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ CoinShortDilaog this$0;

        C3353e(CoinShortDilaog cVar) {
            this.this$0 = cVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.m14528j();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/event/AdReportResultEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoinShortDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.c$f */
    static final class C3354f<T> implements Consumer<AdReportResultEvent> {
        /* renamed from: a */
        final /* synthetic */ CoinShortDilaog f11959a;
        /* renamed from: b */
        final /* synthetic */ AdRsp f11960b;

        C3354f(CoinShortDilaog cVar, AdRsp adRsp) {
            this.f11959a = cVar;
            this.f11960b = adRsp;
        }

        /* renamed from: a */
        public final void accept(AdReportResultEvent aVar) {
            if (C8271i.m35384a((Object) aVar.mo20435b(), (Object) this.f11960b.getAdLogId())) {
                if (aVar.mo20434a()) {
                    this.f11959a.f11954f = true;
                    this.f11959a.m14530l();
                }
                this.f11959a.m14527i();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoinShortDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.c$g */
    static final class C3355g implements Runnable {
        /* renamed from: a */
        final /* synthetic */ CoinShortDilaog f11961a;
        /* renamed from: b */
        final /* synthetic */ GetCoinItem f11962b;

        C3355g(CoinShortDilaog cVar, GetCoinItem getCoinItem) {
            this.f11961a = cVar;
            this.f11962b = getCoinItem;
        }

        public final void run() {
            new GetCoinDilaog(this.f11961a.mo22246a(), this.f11962b).show();
        }
    }

    /* renamed from: c */
    private final boolean m14520c() {
        Lazy bVar = this.f11951c;
        C8280j jVar = f11949a[0];
        return ((Boolean) bVar.getValue()).booleanValue();
    }

    /* renamed from: a */
    public final Activity mo22246a() {
        return this.f11956h;
    }

    /* renamed from: b */
    public final BuyDogRsp mo22247b() {
        return this.f11957i;
    }

    public CoinShortDilaog(Activity activity, BuyDogRsp buyDogRsp) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        C8271i.m35386b(buyDogRsp, "item");
        super(activity);
        this.f11956h = activity;
        this.f11957i = buyDogRsp;
        DialogCoinShortBinding dialogCoinShortBinding = this.f11950b;
        C8271i.m35382a((Object) dialogCoinShortBinding, "binding");
        setView(dialogCoinShortBinding.getRoot());
        m14526h();
        m14521d();
    }

    /* renamed from: d */
    private final void m14521d() {
        DialogCoinShortBinding dialogCoinShortBinding = this.f11950b;
        String str = "binding";
        C8271i.m35382a((Object) dialogCoinShortBinding, str);
        View root = dialogCoinShortBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        LayoutParams layoutParams = root.getLayoutParams();
        layoutParams.width = GloblaEx.m12809a();
        layoutParams.height = GloblaEx.m12818b(false);
        setDimAmount(0.7f);
        m14524f();
        m14523e();
        m14525g();
        Glide.m5170a((View) this.f11950b.f10322c).mo12590a(Integer.valueOf(R.drawable.dog_walk)).mo12582a(this.f11950b.f10322c);
        DialogCoinShortBinding dialogCoinShortBinding2 = this.f11950b;
        C8271i.m35382a((Object) dialogCoinShortBinding2, str);
        dialogCoinShortBinding2.mo20110a(this.f11957i);
        DialogCoinShortBinding dialogCoinShortBinding3 = this.f11950b;
        C8271i.m35382a((Object) dialogCoinShortBinding3, str);
        dialogCoinShortBinding3.mo20111a(m14520c());
        RoundLayout roundLayout = this.f11950b.f10320a;
        C8271i.m35382a((Object) roundLayout, "binding.btnSee");
        AdRsp adInfo = this.f11957i.getAdInfo();
        RoundTextEx.m12835a(roundLayout, (adInfo != null ? adInfo.getAdNumVideo() : 0) > 0, (String) null, (String) null, 6, (Object) null);
        m14529k();
    }

    /* renamed from: e */
    private final void m14523e() {
        if (m14520c()) {
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            Observable a = RxUtil.m12971a(3, TimeUnit.SECONDS);
            DialogCoinShortBinding dialogCoinShortBinding = this.f11950b;
            C8271i.m35382a((Object) dialogCoinShortBinding, "binding");
            View root = dialogCoinShortBinding.getRoot();
            C8271i.m35382a((Object) root, "binding.root");
            C8019a.m34776a(a, root).mo37374a(new C3351c(this));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
            if (r2 != null) goto L_0x002e;
     */
    /* renamed from: f */
    private final void m14524f() {
        /*
        r19 = this;
        r0 = r19
        com.jiayouya.travel.module.travel.data.BuyDogRsp r1 = r0.f11957i
        com.jiayouya.travel.module.common.data.AdRsp r1 = r1.getAdInfo()
        if (r1 == 0) goto L_0x0067
        java.lang.String r2 = r1.getAdIdBanner()
        java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        boolean r2 = android.text.TextUtils.isEmpty(r2)
        if (r2 == 0) goto L_0x0017
        return
    L_0x0017:
        com.jiayouya.travel.module.common.vm.ResidentMemoryModel r2 = com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel.f11323a
        androidx.lifecycle.MutableLiveData r2 = r2.mo20737b()
        java.lang.Object r2 = r2.getValue()
        com.jiayouya.travel.module.common.data.User r2 = (com.jiayouya.travel.module.common.data.User) r2
        if (r2 == 0) goto L_0x002c
        java.lang.String r2 = r2.getUid()
        if (r2 == 0) goto L_0x002c
        goto L_0x002e
    L_0x002c:
        java.lang.String r2 = ""
    L_0x002e:
        r7 = r2
        com.travel.adlibrary.a.a r2 = new com.travel.adlibrary.a.a
        r4 = 5
        android.app.Activity r5 = r0.f11956h
        java.lang.String r6 = r1.getAdIdBanner()
        com.jiayouya.travel.databinding.DialogCoinShortBinding r1 = r0.f11950b
        android.widget.LinearLayout r1 = r1.f10324e
        r8 = r1
        android.view.ViewGroup r8 = (android.view.ViewGroup) r8
        r9 = 0
        r10 = 0
        r11 = 0
        r12 = 0
        r13 = 0
        r14 = 0
        r15 = 0
        r16 = 0
        r17 = 8160(0x1fe0, float:1.1435E-41)
        r18 = 0
        r3 = r2
        r3.m53800init(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
        com.jiayouya.travel.databinding.DialogCoinShortBinding r1 = r0.f11950b
        android.widget.LinearLayout r1 = r1.f10324e
        java.lang.String r3 = "binding.lytAdText"
        kotlin.jvm.internal.C8271i.m35382a(r1, r3)
        android.view.View r1 = (android.view.View) r1
        r3 = 0
        r5 = 2
        r6 = 0
        com.jiayouya.travel.common.p246d.AdExtra.m12934a(r1, r3, r5, r6)
        com.travel.adlibrary.AdSdk r1 = com.travel.adlibrary.AdSdk.f25896a
        r1.mo37292a(r2)
    L_0x0067:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.p288ui.p289a.CoinShortDilaog.m14524f():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
            if (r1 != null) goto L_0x0031;
     */
    /* renamed from: g */
    private final void m14525g() {
        /*
        r18 = this;
        r0 = r18
        com.jiayouya.travel.module.travel.data.BuyDogRsp r1 = r0.f11957i
        com.jiayouya.travel.module.common.data.AdRsp r1 = r1.getAdInfo()
        if (r1 == 0) goto L_0x008e
        java.lang.String r5 = r1.getAdIdInfoFlow()
        if (r5 == 0) goto L_0x008e
        r1 = r5
        java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        boolean r1 = android.text.TextUtils.isEmpty(r1)
        if (r1 == 0) goto L_0x001a
        return
    L_0x001a:
        com.jiayouya.travel.module.common.vm.ResidentMemoryModel r1 = com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel.f11323a
        androidx.lifecycle.MutableLiveData r1 = r1.mo20737b()
        java.lang.Object r1 = r1.getValue()
        com.jiayouya.travel.module.common.data.User r1 = (com.jiayouya.travel.module.common.data.User) r1
        if (r1 == 0) goto L_0x002f
        java.lang.String r1 = r1.getUid()
        if (r1 == 0) goto L_0x002f
        goto L_0x0031
    L_0x002f:
        java.lang.String r1 = ""
    L_0x0031:
        r6 = r1
        com.travel.adlibrary.a.a r1 = new com.travel.adlibrary.a.a
        r3 = 7
        android.app.Activity r4 = r0.f11956h
        com.jiayouya.travel.databinding.DialogCoinShortBinding r2 = r0.f11950b
        com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout r2 = r2.f10323d
        r7 = r2
        android.view.ViewGroup r7 = (android.view.ViewGroup) r7
        r8 = 0
        r9 = 0
        r10 = 0
        r2 = 1133051904(0x43890000, float:274.0)
        me.jessyan.autosize.AutoSizeConfig r11 = p681me.jessyan.autosize.AutoSizeConfig.getInstance()
        java.lang.String r12 = "AutoSizeConfig.getInstance()"
        kotlin.jvm.internal.C8271i.m35382a(r11, r12)
        float r11 = r11.getInitDensity()
        float r2 = r2 / r11
        android.content.Context r11 = r18.getContext()
        java.lang.String r12 = "context"
        kotlin.jvm.internal.C8271i.m35382a(r11, r12)
        android.content.res.Resources r11 = r11.getResources()
        java.lang.String r12 = "context.resources"
        kotlin.jvm.internal.C8271i.m35382a(r11, r12)
        android.util.DisplayMetrics r11 = r11.getDisplayMetrics()
        float r11 = r11.density
        float r11 = r11 * r2
        r12 = 0
        r13 = 0
        r14 = 0
        r15 = 0
        r16 = 7904(0x1ee0, float:1.1076E-41)
        r17 = 0
        r2 = r1
        r2.m53800init(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
        com.jiayouya.travel.databinding.DialogCoinShortBinding r2 = r0.f11950b
        com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout r2 = r2.f10323d
        java.lang.String r3 = "binding.lytAd"
        kotlin.jvm.internal.C8271i.m35382a(r2, r3)
        android.view.View r2 = (android.view.View) r2
        r3 = 0
        r5 = 2
        r6 = 0
        com.jiayouya.travel.common.p246d.AdExtra.m12934a(r2, r3, r5, r6)
        com.travel.adlibrary.AdSdk r2 = com.travel.adlibrary.AdSdk.f25896a
        r2.mo37292a(r1)
    L_0x008e:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.p288ui.p289a.CoinShortDilaog.m14525g():void");
    }

    /* renamed from: h */
    private final void m14526h() {
        TextView textView = this.f11950b.f10321b;
        C8271i.m35382a((Object) textView, "binding.ivClose");
        ezy.p642a.View.m34750a(textView, 0, new C3352d(this), 1, null);
        RoundLayout roundLayout = this.f11950b.f10320a;
        C8271i.m35382a((Object) roundLayout, "binding.btnSee");
        ezy.p642a.View.m34750a(roundLayout, 0, new C3353e(this), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: i */
    public final void m14527i() {
        Disposable bVar = this.f11952d;
        if (bVar != null && !bVar.isDisposed()) {
            Disposable bVar2 = this.f11952d;
            if (bVar2 != null) {
                bVar2.dispose();
            }
        }
        this.f11952d = null;
    }

    /* access modifiers changed from: private|final */
    /* renamed from: j */
    public final void m14528j() {
        AdRsp adInfo = this.f11957i.getAdInfo();
        if (adInfo != null) {
            ResidentMemoryModel.m13596a(ResidentMemoryModel.f11323a, (AppCompatActivity) null, (C8247b) new C3349b(this, adInfo), 1, (Object) null);
        }
    }

    /* renamed from: k */
    private final void m14529k() {
        m14527i();
        AdRsp adInfo = this.f11957i.getAdInfo();
        if (adInfo != null) {
            this.f11952d = RxBus.f27263a.mo38571a(AdReportResultEvent.class).mo38904c((Consumer<? super T>) new C3354f<Object>(this, adInfo));
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: l */
    public final void m14530l() {
        if (this.f11954f && this.f11955g && !this.f11956h.isFinishing() && !this.f11956h.isDestroyed()) {
            AdRsp adInfo = this.f11957i.getAdInfo();
            if (adInfo != null) {
                String str = "";
                GetCoinItem getCoinItem = new GetCoinItem(str, GloblaEx.m12814a(R.string.c66_and_orange, "恭喜获得", this.f11957i.getTimeText()), this.f11957i.getCoin(), adInfo.getAdIdInfoFlow(), this.f11953e);
                C2914d.m13179a((Runnable) new C3355g(this, getCoinItem));
            }
        }
    }
}
