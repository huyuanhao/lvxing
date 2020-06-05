package com.jiayouya.travel.module.p276me.p279ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogGetBonusDogBinding;
import com.jiayouya.travel.module.p276me.data.ClaimSuperDog;
import com.jiayouya.travel.module.p276me.p277a.C3109b;
import ezy.app.p643a.API;
import ezy.app.p645rx.C8019a;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/dialog/GetBonusDogDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "action", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "binding", "Lcom/jiayouya/travel/databinding/DialogGetBonusDogBinding;", "kotlin.jvm.PlatformType", "setupClick", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.me.ui.dialog.d */
public final class GetBonusDogDilaog extends CustomDialog {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final DialogGetBonusDogBinding f11667a = ((DialogGetBonusDogBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_get_bonus_dog, null, false));
    /* renamed from: b */
    private final C8246a<Unit> f11668b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: GetBonusDogDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.d$a */
    static final class C3213a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ GetBonusDogDilaog this$0;

        C3213a(GetBonusDogDilaog dVar) {
            this.this$0 = dVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Observable e = C3109b.m13925a(API.f27251a).mo21213e();
            DialogGetBonusDogBinding a = this.this$0.f11667a;
            C8271i.m35382a((Object) a, "binding");
            View root = a.getRoot();
            C8271i.m35382a((Object) root, "binding.root");
            C8019a.m34776a(e, root).mo37374a(new Consumer<ClaimSuperDog>(this) {
                /* renamed from: a */
                final /* synthetic */ C3213a f11669a;

                {
                    this.f11669a = r1;
                }

                /* renamed from: a */
                public final void accept(ClaimSuperDog claimSuperDog) {
                    this.f11669a.this$0.mo21418a().invoke();
                    this.f11669a.this$0.dismiss();
                }
            });
        }
    }

    public GetBonusDogDilaog(Context context, C8246a<Unit> aVar) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(aVar, "action");
        super(context);
        this.f11668b = aVar;
        DialogGetBonusDogBinding dialogGetBonusDogBinding = this.f11667a;
        C8271i.m35382a((Object) dialogGetBonusDogBinding, "binding");
        setView(dialogGetBonusDogBinding.getRoot());
        m14154c();
        m14153b();
    }

    /* renamed from: a */
    public final C8246a<Unit> mo21418a() {
        return this.f11668b;
    }

    /* renamed from: b */
    private final void m14153b() {
        DialogGetBonusDogBinding dialogGetBonusDogBinding = this.f11667a;
        C8271i.m35382a((Object) dialogGetBonusDogBinding, "binding");
        View root = dialogGetBonusDogBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
        setDimAmount(0.7f);
    }

    /* renamed from: c */
    private final void m14154c() {
        RoundText roundText = this.f11667a.f10393a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3213a(this), 1, null);
    }
}
