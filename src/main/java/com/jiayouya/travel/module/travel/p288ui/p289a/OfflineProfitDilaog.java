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
import com.jiayouya.travel.common.p246d.AdExtra;
import com.jiayouya.travel.common.p246d.RxUtil;
import com.jiayouya.travel.databinding.DialogOfflineProfitBinding;
import com.jiayouya.travel.module.common.data.AdRsp;
import com.jiayouya.travel.module.common.data.AdRspKt;
import com.jiayouya.travel.module.common.p259ui.dialog.DialogManager;
import com.jiayouya.travel.module.common.p259ui.dialog.ShareDilaog;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.travel.data.OfflineProfit;
import com.jiayouya.travel.module.travel.data.ShareSuccess;
import com.jiayouya.travel.module.travel.p285a.C3324d;
import com.jiayouya.travel.module.travel.p285a.GameService;
import com.tencent.android.tpush.common.Constants;
import com.travel.adlibrary.AdSdk;
import com.travel.adlibrary.p612a.AdOptions;
import ezy.app.p643a.API;
import ezy.app.p645rx.C8019a;
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
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.jvm.p679a.C8258m;
import kotlin.reflect.C8280j;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/OfflineProfitDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "activity", "Landroid/app/Activity;", "item", "Lcom/jiayouya/travel/module/travel/data/OfflineProfit;", "(Landroid/app/Activity;Lcom/jiayouya/travel/module/travel/data/OfflineProfit;)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/jiayouya/travel/databinding/DialogOfflineProfitBinding;", "kotlin.jvm.PlatformType", "isShowFlowAd", "", "()Z", "isShowFlowAd$delegate", "Lkotlin/Lazy;", "getItem", "()Lcom/jiayouya/travel/module/travel/data/OfflineProfit;", "loadImageTextAd", "", "loadInfoFlowAd", "loadVideoAd", "setCloseEnable", "setupClick", "setupView", "showShareDialog", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.m */
public final class OfflineProfitDilaog extends CustomDialog {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f12010a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(OfflineProfitDilaog.class), "isShowFlowAd", "isShowFlowAd()Z"))};
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final DialogOfflineProfitBinding f12011b = ((DialogOfflineProfitBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_offline_profit, null, false));
    /* renamed from: c */
    private final Lazy f12012c = C8182c.m35317a(new C3392a(this));
    /* renamed from: d */
    private final Activity f12013d;
    /* renamed from: e */
    private final OfflineProfit f12014e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: OfflineProfitDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.m$a */
    static final class C3392a extends Lambda implements C8246a<Boolean> {
        final /* synthetic */ OfflineProfitDilaog this$0;

        C3392a(OfflineProfitDilaog mVar) {
            this.this$0 = mVar;
            super(0);
        }

        public final boolean invoke() {
            AdRsp adInfo = this.this$0.mo22297b().getAdInfo();
            return !TextUtils.isEmpty(adInfo != null ? adInfo.getAdIdInfoFlow() : null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo39189d2 = {"<anonymous>", "", "userId", "", "invoke", "com/jiayouya/travel/module/travel/ui/dialog/OfflineProfitDialog$loadVideoAd$1$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: OfflineProfitDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.m$b */
    static final class C3393b extends Lambda implements C8247b<String, Unit> {
        final /* synthetic */ AdRsp $ad;
        final /* synthetic */ OfflineProfitDilaog this$0;

        C3393b(AdRsp adRsp, OfflineProfitDilaog mVar) {
            this.$ad = adRsp;
            this.this$0 = mVar;
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
            AdOptions aVar2 = new AdOptions(0, this.this$0.mo22296a(), this.$ad.getAdIdVideo(), str2, null, 0, null, AdExtra.m12931a(this.$ad.getAdLogId(), str2, (String) null, 4, (Object) null), 0.0f, AdRspKt.adVideoPlats(this.$ad), 0, false, new C8258m<Boolean, Boolean, Unit>(this) {
                final /* synthetic */ C3393b this$0;

                {
                    this.this$0 = r1;
                }

                public /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                    return Unit.f27778a;
                }

                public final void invoke(boolean z, boolean z2) {
                    if (!this.this$0.this$0.mo22296a().isDestroyed() && !this.this$0.this$0.mo22296a().isFinishing()) {
                        C2914d.m13180a((Runnable) new Runnable(this) {
                            /* renamed from: a */
                            final /* synthetic */ C33941 f12015a;

                            {
                                this.f12015a = r1;
                            }

                            public final void run() {
                                DialogManager a = DialogManager.f11300b.mo20713a();
                                a.mo20712a(new DoubleCoinDilaog(this.f12015a.this$0.this$0.mo22296a(), this.f12015a.this$0.this$0.mo22297b().getCoin(), this.f12015a.this$0.$ad.getAdIdInfoFlow()));
                                a.mo20711a();
                            }
                        }, 100);
                    }
                }
            }, 3440, null);
            AdExtra.m12935a(this.$ad.getAdLogId(), this.this$0.mo22297b().getCoin());
            if (AdSdk.f25896a.mo37292a(aVar)) {
                this.this$0.dismiss();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Long;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: OfflineProfitDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.m$c */
    static final class C3396c<T> implements Consumer<Long> {
        /* renamed from: a */
        final /* synthetic */ OfflineProfitDilaog f12016a;

        C3396c(OfflineProfitDilaog mVar) {
            this.f12016a = mVar;
        }

        /* renamed from: a */
        public final void accept(Long l) {
            boolean z = true;
            String str = "binding.ivClose";
            if (l != null && l.longValue() == 0) {
                this.f12016a.setCancelable(true);
                this.f12016a.setCanceledOnTouchOutside(true);
                TextView textView = this.f12016a.f12011b.f10536b;
                C8271i.m35382a((Object) textView, str);
                textView.setText("");
            } else {
                TextView textView2 = this.f12016a.f12011b.f10536b;
                C8271i.m35382a((Object) textView2, str);
                textView2.setText(String.valueOf(l));
            }
            TextView textView3 = this.f12016a.f12011b.f10536b;
            C8271i.m35382a((Object) textView3, str);
            if (l == null || l.longValue() != 0) {
                z = false;
            }
            textView3.setEnabled(z);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: OfflineProfitDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.m$d */
    static final class C3397d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ OfflineProfitDilaog this$0;

        C3397d(OfflineProfitDilaog mVar) {
            this.this$0 = mVar;
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
    /* compiled from: OfflineProfitDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.m$e */
    static final class C3398e extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ OfflineProfitDilaog this$0;

        C3398e(OfflineProfitDilaog mVar) {
            this.this$0 = mVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            if (TextUtils.isEmpty(this.this$0.mo22297b().getShareLogId())) {
                this.this$0.m14605h();
            } else {
                this.this$0.m14607j();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: OfflineProfitDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.m$f */
    static final class C3399f extends Lambda implements C8246a<Unit> {
        final /* synthetic */ BooleanRef $isClaim;
        final /* synthetic */ OfflineProfitDilaog this$0;

        C3399f(OfflineProfitDilaog mVar, BooleanRef booleanRef) {
            this.this$0 = mVar;
            this.$isClaim = booleanRef;
            super(0);
        }

        public final void invoke() {
            if (!this.$isClaim.element) {
                this.$isClaim.element = true;
                GameService a = C3324d.m14443a(API.f27251a);
                String shareLogId = this.this$0.mo22297b().getShareLogId();
                if (shareLogId == null) {
                    C8271i.m35380a();
                }
                Observable e = a.mo21641e(shareLogId);
                DialogOfflineProfitBinding a2 = this.this$0.f12011b;
                C8271i.m35382a((Object) a2, "binding");
                View root = a2.getRoot();
                C8271i.m35382a((Object) root, "binding.root");
                C8019a.m34776a(e, root).mo37374a(new Consumer<ShareSuccess>(this) {
                    /* renamed from: a */
                    final /* synthetic */ C3399f f12017a;

                    {
                        this.f12017a = r1;
                    }

                    /* renamed from: a */
                    public final void accept(ShareSuccess shareSuccess) {
                        ResidentMemoryModel.f11323a.mo20733a(shareSuccess.getCoin(), 1);
                        AdRsp adInfo = this.f12017a.this$0.mo22297b().getAdInfo();
                        if (adInfo != null) {
                            new DoubleCoinDilaog(this.f12017a.this$0.mo22296a(), shareSuccess.getCoin(), adInfo.getAdIdInfoFlow()).show();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: c */
    private final boolean m14600c() {
        Lazy bVar = this.f12012c;
        C8280j jVar = f12010a[0];
        return ((Boolean) bVar.getValue()).booleanValue();
    }

    /* renamed from: a */
    public final Activity mo22296a() {
        return this.f12013d;
    }

    /* renamed from: b */
    public final OfflineProfit mo22297b() {
        return this.f12014e;
    }

    public OfflineProfitDilaog(Activity activity, OfflineProfit offlineProfit) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        C8271i.m35386b(offlineProfit, "item");
        super(activity);
        this.f12013d = activity;
        this.f12014e = offlineProfit;
        DialogOfflineProfitBinding dialogOfflineProfitBinding = this.f12011b;
        C8271i.m35382a((Object) dialogOfflineProfitBinding, "binding");
        setView(dialogOfflineProfitBinding.getRoot());
        m14606i();
        m14601d();
    }

    /* renamed from: d */
    private final void m14601d() {
        DialogOfflineProfitBinding dialogOfflineProfitBinding = this.f12011b;
        String str = "binding";
        C8271i.m35382a((Object) dialogOfflineProfitBinding, str);
        dialogOfflineProfitBinding.mo20133a(this.f12014e);
        DialogOfflineProfitBinding dialogOfflineProfitBinding2 = this.f12011b;
        C8271i.m35382a((Object) dialogOfflineProfitBinding2, str);
        View root = dialogOfflineProfitBinding2.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        LayoutParams layoutParams = root.getLayoutParams();
        layoutParams.width = GloblaEx.m12809a();
        layoutParams.height = GloblaEx.m12818b(false);
        setDimAmount(0.7f);
        m14603f();
        m14604g();
        this.f12011b.f10538d.setImageResource(TextUtils.isEmpty(this.f12014e.getShareLogId()) ? R.mipmap.ic_tv_small : R.mipmap.ic_transfer);
        DialogOfflineProfitBinding dialogOfflineProfitBinding3 = this.f12011b;
        C8271i.m35382a((Object) dialogOfflineProfitBinding3, str);
        dialogOfflineProfitBinding3.mo20134a(m14600c());
        Glide.m5170a((View) this.f12011b.f10537c).mo12590a(Integer.valueOf(R.drawable.dog_walk)).mo12582a(this.f12011b.f10537c);
        m14602e();
    }

    /* renamed from: e */
    private final void m14602e() {
        if (m14600c()) {
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            Observable a = RxUtil.m12971a(3, TimeUnit.SECONDS);
            DialogOfflineProfitBinding dialogOfflineProfitBinding = this.f12011b;
            C8271i.m35382a((Object) dialogOfflineProfitBinding, "binding");
            View root = dialogOfflineProfitBinding.getRoot();
            C8271i.m35382a((Object) root, "binding.root");
            C8019a.m34776a(a, root).mo37374a(new C3396c(this));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
            if (r2 != null) goto L_0x0021;
     */
    /* renamed from: f */
    private final void m14603f() {
        /*
        r19 = this;
        r0 = r19
        com.jiayouya.travel.module.travel.data.OfflineProfit r1 = r0.f12014e
        com.jiayouya.travel.module.common.data.AdRsp r1 = r1.getAdInfo()
        if (r1 == 0) goto L_0x005a
        com.jiayouya.travel.module.common.vm.ResidentMemoryModel r2 = com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel.f11323a
        androidx.lifecycle.MutableLiveData r2 = r2.mo20737b()
        java.lang.Object r2 = r2.getValue()
        com.jiayouya.travel.module.common.data.User r2 = (com.jiayouya.travel.module.common.data.User) r2
        if (r2 == 0) goto L_0x001f
        java.lang.String r2 = r2.getUid()
        if (r2 == 0) goto L_0x001f
        goto L_0x0021
    L_0x001f:
        java.lang.String r2 = ""
    L_0x0021:
        r7 = r2
        com.travel.adlibrary.a.a r2 = new com.travel.adlibrary.a.a
        r4 = 5
        android.app.Activity r5 = r0.f12013d
        java.lang.String r6 = r1.getAdIdBanner()
        com.jiayouya.travel.databinding.DialogOfflineProfitBinding r1 = r0.f12011b
        android.widget.LinearLayout r1 = r1.f10540f
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
        com.jiayouya.travel.databinding.DialogOfflineProfitBinding r1 = r0.f12011b
        android.widget.LinearLayout r1 = r1.f10540f
        java.lang.String r3 = "binding.lytAdText"
        kotlin.jvm.internal.C8271i.m35382a(r1, r3)
        android.view.View r1 = (android.view.View) r1
        r3 = 0
        r5 = 2
        r6 = 0
        com.jiayouya.travel.common.p246d.AdExtra.m12934a(r1, r3, r5, r6)
        com.travel.adlibrary.AdSdk r1 = com.travel.adlibrary.AdSdk.f25896a
        r1.mo37292a(r2)
    L_0x005a:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.p288ui.p289a.OfflineProfitDilaog.m14603f():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
            if (r1 != null) goto L_0x0031;
     */
    /* renamed from: g */
    private final void m14604g() {
        /*
        r18 = this;
        r0 = r18
        com.jiayouya.travel.module.travel.data.OfflineProfit r1 = r0.f12014e
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
        android.app.Activity r4 = r0.f12013d
        com.jiayouya.travel.databinding.DialogOfflineProfitBinding r2 = r0.f12011b
        com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout r2 = r2.f10539e
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
        com.jiayouya.travel.databinding.DialogOfflineProfitBinding r2 = r0.f12011b
        com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout r2 = r2.f10539e
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.p288ui.p289a.OfflineProfitDilaog.m14604g():void");
    }

    /* access modifiers changed from: private|final */
    /* renamed from: h */
    public final void m14605h() {
        AdRsp adInfo = this.f12014e.getAdInfo();
        if (adInfo != null) {
            ResidentMemoryModel.m13596a(ResidentMemoryModel.f11323a, (AppCompatActivity) null, (C8247b) new C3393b(adInfo, this), 1, (Object) null);
        }
    }

    /* renamed from: i */
    private final void m14606i() {
        TextView textView = this.f12011b.f10536b;
        C8271i.m35382a((Object) textView, "binding.ivClose");
        ezy.p642a.View.m34750a(textView, 0, new C3397d(this), 1, null);
        RoundLayout roundLayout = this.f12011b.f10535a;
        C8271i.m35382a((Object) roundLayout, "binding.btnShare");
        ezy.p642a.View.m34750a(roundLayout, 0, new C3398e(this), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: j */
    public final void m14607j() {
        BooleanRef booleanRef = new BooleanRef();
        booleanRef.element = false;
        new ShareDilaog(this.f12013d, new C3399f(this, booleanRef)).show();
        dismiss();
    }
}
