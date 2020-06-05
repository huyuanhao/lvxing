package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.bumptech.glide.Glide;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p246d.RxUtil;
import com.jiayouya.travel.databinding.DialogDoubleCoinBinding;
import com.jiayouya.travel.module.travel.p287c.GoldUtil;
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

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u001b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/DoubleCoinDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "activity", "Landroid/app/Activity;", "coin", "", "adIdInfoFlow", "", "(Landroid/app/Activity;DLjava/lang/String;)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/jiayouya/travel/databinding/DialogDoubleCoinBinding;", "kotlin.jvm.PlatformType", "getCoin", "()D", "isShowFlowAd", "", "()Z", "isShowFlowAd$delegate", "Lkotlin/Lazy;", "loadImageTextAd", "", "loadInfoFlowAd", "setCloseEnable", "setupClick", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.f */
public final class DoubleCoinDilaog extends CustomDialog {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f11968a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(DoubleCoinDilaog.class), "isShowFlowAd", "isShowFlowAd()Z"))};
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final DialogDoubleCoinBinding f11969b = ((DialogDoubleCoinBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_double_coin, null, false));
    /* renamed from: c */
    private final Lazy f11970c = C8182c.m35317a(new C3359a(this));
    /* renamed from: d */
    private final Activity f11971d;
    /* renamed from: e */
    private final double f11972e;
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final String f11973f;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DoubleCoinDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.f$a */
    static final class C3359a extends Lambda implements C8246a<Boolean> {
        final /* synthetic */ DoubleCoinDilaog this$0;

        C3359a(DoubleCoinDilaog fVar) {
            this.this$0 = fVar;
            super(0);
        }

        public final boolean invoke() {
            return !TextUtils.isEmpty(this.this$0.f11973f);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Long;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DoubleCoinDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.f$b */
    static final class C3360b<T> implements Consumer<Long> {
        /* renamed from: a */
        final /* synthetic */ DoubleCoinDilaog f11974a;

        C3360b(DoubleCoinDilaog fVar) {
            this.f11974a = fVar;
        }

        /* renamed from: a */
        public final void accept(Long l) {
            boolean z = true;
            String str = "binding.ivClose";
            if (l != null && l.longValue() == 0) {
                this.f11974a.setCancelable(true);
                this.f11974a.setCanceledOnTouchOutside(true);
                TextView textView = this.f11974a.f11969b.f10371b;
                C8271i.m35382a((Object) textView, str);
                textView.setText("");
            } else {
                TextView textView2 = this.f11974a.f11969b.f10371b;
                C8271i.m35382a((Object) textView2, str);
                textView2.setText(String.valueOf(l));
            }
            TextView textView3 = this.f11974a.f11969b.f10371b;
            C8271i.m35382a((Object) textView3, str);
            if (l == null || l.longValue() != 0) {
                z = false;
            }
            textView3.setEnabled(z);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DoubleCoinDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.f$c */
    static final class C3361c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ DoubleCoinDilaog this$0;

        C3361c(DoubleCoinDilaog fVar) {
            this.this$0 = fVar;
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
    /* compiled from: DoubleCoinDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.f$d */
    static final class C3362d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ DoubleCoinDilaog this$0;

        C3362d(DoubleCoinDilaog fVar) {
            this.this$0 = fVar;
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

    /* renamed from: a */
    private final boolean m14540a() {
        Lazy bVar = this.f11970c;
        C8280j jVar = f11968a[0];
        return ((Boolean) bVar.getValue()).booleanValue();
    }

    public DoubleCoinDilaog(Activity activity, double d, String str) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        super(activity);
        this.f11971d = activity;
        this.f11972e = d;
        this.f11973f = str;
        DialogDoubleCoinBinding dialogDoubleCoinBinding = this.f11969b;
        C8271i.m35382a((Object) dialogDoubleCoinBinding, "binding");
        setView(dialogDoubleCoinBinding.getRoot());
        m14545e();
        m14542b();
    }

    /* renamed from: b */
    private final void m14542b() {
        setDimAmount(0.7f);
        DialogDoubleCoinBinding dialogDoubleCoinBinding = this.f11969b;
        String str = "binding";
        C8271i.m35382a((Object) dialogDoubleCoinBinding, str);
        View root = dialogDoubleCoinBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = GloblaEx.m12809a();
        m14544d();
        Glide.m5170a((View) this.f11969b.f10372c).mo12590a(Integer.valueOf(R.drawable.dog_walk)).mo12582a(this.f11969b.f10372c);
        TextView textView = this.f11969b.f10374e;
        C8271i.m35382a((Object) textView, "binding.tvCoin");
        textView.setText(GoldUtil.f11900a.mo21651a(this.f11972e));
        DialogDoubleCoinBinding dialogDoubleCoinBinding2 = this.f11969b;
        C8271i.m35382a((Object) dialogDoubleCoinBinding2, str);
        dialogDoubleCoinBinding2.mo20115a(m14540a());
        m14543c();
    }

    /* renamed from: c */
    private final void m14543c() {
        if (!TextUtils.isEmpty(this.f11973f)) {
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            Observable a = RxUtil.m12971a(3, TimeUnit.SECONDS);
            DialogDoubleCoinBinding dialogDoubleCoinBinding = this.f11969b;
            C8271i.m35382a((Object) dialogDoubleCoinBinding, "binding");
            View root = dialogDoubleCoinBinding.getRoot();
            C8271i.m35382a((Object) root, "binding.root");
            C8019a.m34776a(a, root).mo37374a(new C3360b(this));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
            if (r1 != null) goto L_0x0019;
     */
    /* renamed from: d */
    private final void m14544d() {
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
        java.lang.String r1 = r0.f11973f
        java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        boolean r1 = android.text.TextUtils.isEmpty(r1)
        if (r1 == 0) goto L_0x0025
        return
    L_0x0025:
        com.travel.adlibrary.a.a r1 = new com.travel.adlibrary.a.a
        r3 = 7
        android.app.Activity r4 = r0.f11971d
        java.lang.String r5 = r0.f11973f
        if (r5 != 0) goto L_0x0031
        kotlin.jvm.internal.C8271i.m35380a()
    L_0x0031:
        com.jiayouya.travel.databinding.DialogDoubleCoinBinding r2 = r0.f11969b
        com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout r2 = r2.f10373d
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
        com.jiayouya.travel.databinding.DialogDoubleCoinBinding r2 = r0.f11969b
        com.jiayouya.travel.module.common.widget.round.widget.GeneralRoundLinearLayout r2 = r2.f10373d
        java.lang.String r3 = "binding.lytAd"
        kotlin.jvm.internal.C8271i.m35382a(r2, r3)
        android.view.View r2 = (android.view.View) r2
        r3 = 0
        r5 = 2
        r6 = 0
        com.jiayouya.travel.common.p246d.AdExtra.m12934a(r2, r3, r5, r6)
        com.travel.adlibrary.AdSdk r2 = com.travel.adlibrary.AdSdk.f25896a
        r2.mo37292a(r1)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.p288ui.p289a.DoubleCoinDilaog.m14544d():void");
    }

    /* renamed from: e */
    private final void m14545e() {
        RoundText roundText = this.f11969b.f10370a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3361c(this), 1, null);
        TextView textView = this.f11969b.f10371b;
        C8271i.m35382a((Object) textView, "binding.ivClose");
        ezy.p642a.View.m34750a(textView, 0, new C3362d(this), 1, null);
    }
}
