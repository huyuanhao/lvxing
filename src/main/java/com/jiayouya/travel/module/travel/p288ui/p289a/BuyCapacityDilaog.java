package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.databinding.DialogBuyCapacityBinding;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.travel.data.BuyDogRsp;
import com.jiayouya.travel.module.travel.data.ExpandBag;
import com.jiayouya.travel.module.travel.data.ExpandPrice;
import com.jiayouya.travel.module.travel.p285a.C3322b;
import com.tencent.android.tpush.common.Constants;
import ezy.app.p643a.API;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/BuyCapacityDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/jiayouya/travel/databinding/DialogBuyCapacityBinding;", "kotlin.jvm.PlatformType", "fetchPrice", "", "setupClick", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.a */
public final class BuyCapacityDilaog extends CustomDialog {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final DialogBuyCapacityBinding f11941a = ((DialogBuyCapacityBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_buy_capacity, null, false));
    /* renamed from: b */
    private final Activity f11942b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/ExpandPrice;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BuyCapacityDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.a$a */
    static final class C3341a<T> implements Consumer<ExpandPrice> {
        /* renamed from: a */
        final /* synthetic */ BuyCapacityDilaog f11943a;

        C3341a(BuyCapacityDilaog aVar) {
            this.f11943a = aVar;
        }

        /* renamed from: a */
        public final void accept(ExpandPrice expandPrice) {
            DialogBuyCapacityBinding a = this.f11943a.f11941a;
            C8271i.m35382a((Object) a, "binding");
            a.mo20107a(expandPrice);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BuyCapacityDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.a$b */
    static final class C3342b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ BuyCapacityDilaog this$0;

        C3342b(BuyCapacityDilaog aVar) {
            this.this$0 = aVar;
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
    /* compiled from: BuyCapacityDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.a$c */
    static final class C3343c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ BuyCapacityDilaog this$0;

        C3343c(BuyCapacityDilaog aVar) {
            this.this$0 = aVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Observable c = C3322b.m14416a(API.f27251a).mo21622c();
            DialogBuyCapacityBinding a = this.this$0.f11941a;
            C8271i.m35382a((Object) a, "binding");
            View root = a.getRoot();
            C8271i.m35382a((Object) root, "binding.root");
            C8019a.m34776a(c, root).mo37374a(new Consumer<ExpandBag>(this) {
                /* renamed from: a */
                final /* synthetic */ C3343c f11944a;

                {
                    this.f11944a = r1;
                }

                /* renamed from: a */
                public final void accept(ExpandBag expandBag) {
                    if (expandBag.getAdInfo() == null) {
                        GloblaEx.m12816a("扩容成功", 0, 0, 6, null);
                        RxBus bVar = RxBus.f27263a;
                        C8271i.m35382a((Object) expandBag, "it");
                        bVar.mo38572a((Object) expandBag);
                        DialogBuyCapacityBinding a = this.f11944a.this$0.f11941a;
                        C8271i.m35382a((Object) a, "binding");
                        ExpandPrice a2 = a.mo20106a();
                        if (a2 != null) {
                            ResidentMemoryModel.f11323a.mo20733a(a2.getPrice(), 2);
                        }
                        this.f11944a.this$0.m14504d();
                    } else if (!this.f11944a.this$0.mo22237a().isDestroyed() && !this.f11944a.this$0.mo22237a().isFinishing()) {
                        Activity a3 = this.f11944a.this$0.mo22237a();
                        BuyDogRsp buyDogRsp = new BuyDogRsp(expandBag.getCoin(), null, null, expandBag.getAdInfo(), expandBag.getTimeText());
                        new CoinShortDilaog(a3, buyDogRsp).show();
                    }
                }
            });
        }
    }

    public BuyCapacityDilaog(Activity activity) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        super(activity);
        this.f11942b = activity;
        DialogBuyCapacityBinding dialogBuyCapacityBinding = this.f11941a;
        C8271i.m35382a((Object) dialogBuyCapacityBinding, "binding");
        setView(dialogBuyCapacityBinding.getRoot());
        m14503c();
        m14501b();
    }

    /* renamed from: a */
    public final Activity mo22237a() {
        return this.f11942b;
    }

    /* renamed from: b */
    private final void m14501b() {
        setDimAmount(0.7f);
        DialogBuyCapacityBinding dialogBuyCapacityBinding = this.f11941a;
        C8271i.m35382a((Object) dialogBuyCapacityBinding, "binding");
        View root = dialogBuyCapacityBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(245.0f);
        m14504d();
    }

    /* renamed from: c */
    private final void m14503c() {
        ImageView imageView = this.f11941a.f10283b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3342b(this), 1, null);
        RoundText roundText = this.f11941a.f10282a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3343c(this), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final void m14504d() {
        Observable b = C3322b.m14416a(API.f27251a).mo21620b();
        DialogBuyCapacityBinding dialogBuyCapacityBinding = this.f11941a;
        C8271i.m35382a((Object) dialogBuyCapacityBinding, "binding");
        View root = dialogBuyCapacityBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        C8019a.m34776a(b, root).mo37374a(new C3341a(this));
    }
}
