package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.bumptech.glide.Glide;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.common.p246d.RxUtil;
import com.jiayouya.travel.databinding.DialogGetCoinBinding;
import com.jiayouya.travel.module.travel.data.GetCoinItem;
import com.tencent.android.tpush.common.Constants;
import ezy.app.p645rx.C8019a;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
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
import kotlin.reflect.C8280j;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/GetCoinDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "activity", "Landroid/app/Activity;", "item", "Lcom/jiayouya/travel/module/travel/data/GetCoinItem;", "(Landroid/app/Activity;Lcom/jiayouya/travel/module/travel/data/GetCoinItem;)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/jiayouya/travel/databinding/DialogGetCoinBinding;", "kotlin.jvm.PlatformType", "isShowFlowAd", "", "()Z", "isShowFlowAd$delegate", "Lkotlin/Lazy;", "getItem", "()Lcom/jiayouya/travel/module/travel/data/GetCoinItem;", "loadImageTextAd", "", "loadInfoFlowAd", "setCloseEnable", "setupClick", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.g */
public final class GetCoinDilaog extends CustomDialog {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f11975a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(GetCoinDilaog.class), "isShowFlowAd", "isShowFlowAd()Z"))};
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final DialogGetCoinBinding f11976b = ((DialogGetCoinBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_get_coin, null, false));
    /* renamed from: c */
    private final Lazy f11977c = C8182c.m35317a(new C3363a(this));
    /* renamed from: d */
    private final Activity f11978d;
    /* renamed from: e */
    private final GetCoinItem f11979e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: GetCoinDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.g$a */
    static final class C3363a extends Lambda implements C8246a<Boolean> {
        final /* synthetic */ GetCoinDilaog this$0;

        C3363a(GetCoinDilaog gVar) {
            this.this$0 = gVar;
            super(0);
        }

        public final boolean invoke() {
            return !TextUtils.isEmpty(this.this$0.mo22261a().getAdIdInfoFlow());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Long;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: GetCoinDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.g$b */
    static final class C3364b<T> implements Consumer<Long> {
        /* renamed from: a */
        final /* synthetic */ GetCoinDilaog f11980a;

        C3364b(GetCoinDilaog gVar) {
            this.f11980a = gVar;
        }

        /* renamed from: a */
        public final void accept(Long l) {
            String str = "binding.ivClose";
            if (l != null && l.longValue() == 0) {
                this.f11980a.setCancelable(true);
                this.f11980a.setCanceledOnTouchOutside(true);
                TextView textView = this.f11980a.f11976b.f10399b;
                C8271i.m35382a((Object) textView, str);
                textView.setText("");
            } else {
                TextView textView2 = this.f11980a.f11976b.f10399b;
                C8271i.m35382a((Object) textView2, str);
                textView2.setText(String.valueOf(l));
            }
            TextView textView3 = this.f11980a.f11976b.f10399b;
            C8271i.m35382a((Object) textView3, str);
            boolean z = l != null && l.longValue() == 0;
            textView3.setEnabled(z);
            RoundText roundText = this.f11980a.f11976b.f10398a;
            C8271i.m35382a((Object) roundText, "binding.btn");
            boolean z2 = l != null && l.longValue() == 0;
            RoundTextEx.m12837a(roundText, z2, (String) null, (String) null, 6, (Object) null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: GetCoinDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.g$c */
    static final class C3365c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ GetCoinDilaog this$0;

        C3365c(GetCoinDilaog gVar) {
            this.this$0 = gVar;
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
    /* compiled from: GetCoinDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.g$d */
    static final class C3366d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ GetCoinDilaog this$0;

        C3366d(GetCoinDilaog gVar) {
            this.this$0 = gVar;
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

    /* renamed from: b */
    private final boolean m14548b() {
        Lazy bVar = this.f11977c;
        C8280j jVar = f11975a[0];
        return ((Boolean) bVar.getValue()).booleanValue();
    }

    public GetCoinDilaog(Activity activity, GetCoinItem getCoinItem) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        C8271i.m35386b(getCoinItem, "item");
        super(activity);
        this.f11978d = activity;
        this.f11979e = getCoinItem;
        DialogGetCoinBinding dialogGetCoinBinding = this.f11976b;
        C8271i.m35382a((Object) dialogGetCoinBinding, "binding");
        setView(dialogGetCoinBinding.getRoot());
        m14552f();
        m14549c();
    }

    /* renamed from: a */
    public final GetCoinItem mo22261a() {
        return this.f11979e;
    }

    /* renamed from: c */
    private final void m14549c() {
        setDimAmount(0.7f);
        DialogGetCoinBinding dialogGetCoinBinding = this.f11976b;
        String str = "binding";
        C8271i.m35382a((Object) dialogGetCoinBinding, str);
        View root = dialogGetCoinBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        LayoutParams layoutParams = root.getLayoutParams();
        layoutParams.width = GloblaEx.m12809a();
        layoutParams.height = GloblaEx.m12818b(false);
        DialogGetCoinBinding dialogGetCoinBinding2 = this.f11976b;
        C8271i.m35382a((Object) dialogGetCoinBinding2, str);
        dialogGetCoinBinding2.mo20116a(this.f11979e);
        DialogGetCoinBinding dialogGetCoinBinding3 = this.f11976b;
        C8271i.m35382a((Object) dialogGetCoinBinding3, str);
        dialogGetCoinBinding3.mo20117a(m14548b());
        m14551e();
        Glide.m5170a((View) this.f11976b.f10400c).mo12590a(Integer.valueOf(R.drawable.dog_walk)).mo12582a(this.f11976b.f10400c);
        m14550d();
        m14553g();
    }

    /* renamed from: d */
    private final void m14550d() {
        if (m14548b()) {
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            Observable a = RxUtil.m12971a(3, TimeUnit.SECONDS);
            DialogGetCoinBinding dialogGetCoinBinding = this.f11976b;
            C8271i.m35382a((Object) dialogGetCoinBinding, "binding");
            View root = dialogGetCoinBinding.getRoot();
            C8271i.m35382a((Object) root, "binding.root");
            C8019a.m34776a(a, root).mo37374a(new C3364b(this));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
            if (r1 != null) goto L_0x0021;
     */
    /* renamed from: e */
    private final void m14551e() {
        /*
        r18 = this;
        r0 = r18
        com.jiayouya.travel.module.travel.data.GetCoinItem r1 = r0.f11979e
        java.lang.String r5 = r1.getAdIdInfoFlow()
        if (r5 == 0) goto L_0x007e
        com.jiayouya.travel.module.common.vm.ResidentMemoryModel r1 = com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel.f11323a
        androidx.lifecycle.MutableLiveData r1 = r1.mo20737b()
        java.lang.Object r1 = r1.getValue()
        com.jiayouya.travel.module.common.data.User r1 = (com.jiayouya.travel.module.common.data.User) r1
        if (r1 == 0) goto L_0x001f
        java.lang.String r1 = r1.getUid()
        if (r1 == 0) goto L_0x001f
        goto L_0x0021
    L_0x001f:
        java.lang.String r1 = ""
    L_0x0021:
        r6 = r1
        com.travel.adlibrary.a.a r1 = new com.travel.adlibrary.a.a
        r3 = 7
        android.app.Activity r4 = r0.f11978d
        com.jiayouya.travel.databinding.DialogGetCoinBinding r2 = r0.f11976b
        com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout r2 = r2.f10401d
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
        com.jiayouya.travel.databinding.DialogGetCoinBinding r2 = r0.f11976b
        com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout r2 = r2.f10401d
        java.lang.String r3 = "binding.lytAd"
        kotlin.jvm.internal.C8271i.m35382a(r2, r3)
        android.view.View r2 = (android.view.View) r2
        r3 = 0
        r5 = 2
        r6 = 0
        com.jiayouya.travel.common.p246d.AdExtra.m12934a(r2, r3, r5, r6)
        com.travel.adlibrary.AdSdk r2 = com.travel.adlibrary.AdSdk.f25896a
        r2.mo37292a(r1)
    L_0x007e:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.p288ui.p289a.GetCoinDilaog.m14551e():void");
    }

    /* renamed from: f */
    private final void m14552f() {
        TextView textView = this.f11976b.f10399b;
        C8271i.m35382a((Object) textView, "binding.ivClose");
        ezy.p642a.View.m34750a(textView, 0, new C3365c(this), 1, null);
        RoundText roundText = this.f11976b.f10398a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3366d(this), 1, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
            if (r1 != null) goto L_0x0019;
     */
    /* renamed from: g */
    private final void m14553g() {
        /*
        r18 = this;
        r0 = r18
        com.jiayouya.travel.module.common.vm.ResidentMemoryModel r1 = com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel.f11323a
        androidx.lifecycle.MutableLiveData r1 = r1.mo20737b()
        java.lang.Object r1 = r1.getValue()
        com.jiayouya.travel.module.common.data.User r1 = (com.jiayouya.travel.module.common.data.User) r1
        if (r1 == 0) goto L_0x0017
        java.lang.String r1 = r1.getUid()
        if (r1 == 0) goto L_0x0017
        goto L_0x0019
    L_0x0017:
        java.lang.String r1 = ""
    L_0x0019:
        r6 = r1
        com.jiayouya.travel.common.c.b r1 = com.jiayouya.travel.common.p245c.PreferenceRes.f9605b
        com.jiayouya.travel.module.common.data.LaunchConfig r1 = r1.mo19924b()
        java.lang.String r1 = r1.getAdIdBanner()
        java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        boolean r1 = android.text.TextUtils.isEmpty(r1)
        if (r1 == 0) goto L_0x002d
        return
    L_0x002d:
        com.travel.adlibrary.a.a r1 = new com.travel.adlibrary.a.a
        r3 = 5
        android.app.Activity r4 = r0.f11978d
        com.jiayouya.travel.common.c.b r2 = com.jiayouya.travel.common.p245c.PreferenceRes.f9605b
        com.jiayouya.travel.module.common.data.LaunchConfig r2 = r2.mo19924b()
        java.lang.String r5 = r2.getAdIdBanner()
        com.jiayouya.travel.databinding.DialogGetCoinBinding r2 = r0.f11976b
        android.widget.LinearLayout r2 = r2.f10402e
        r7 = r2
        android.view.ViewGroup r7 = (android.view.ViewGroup) r7
        r8 = 0
        r9 = 0
        r10 = 0
        r11 = 0
        r12 = 0
        r13 = 0
        r14 = 0
        r15 = 0
        r16 = 8160(0x1fe0, float:1.1435E-41)
        r17 = 0
        r2 = r1
        r2.m53800init(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
        com.travel.adlibrary.AdSdk r2 = com.travel.adlibrary.AdSdk.f25896a
        r2.mo37292a(r1)
        com.jiayouya.travel.databinding.DialogGetCoinBinding r1 = r0.f11976b
        android.widget.LinearLayout r1 = r1.f10402e
        java.lang.String r2 = "binding.lytAdText"
        kotlin.jvm.internal.C8271i.m35382a(r1, r2)
        android.view.View r1 = (android.view.View) r1
        r2 = 0
        r4 = 2
        r5 = 0
        com.jiayouya.travel.common.p246d.AdExtra.m12934a(r1, r2, r4, r5)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.p288ui.p289a.GetCoinDilaog.m14553g():void");
    }
}
