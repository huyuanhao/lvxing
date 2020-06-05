package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogUnlockCityBinding;
import com.jiayouya.travel.module.common.p259ui.dialog.ShareDilaog;
import com.jiayouya.travel.module.travel.data.UnlockCity;
import com.tencent.android.tpush.common.Constants;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/UnlockCityDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "activity", "Landroid/app/Activity;", "item", "Lcom/jiayouya/travel/module/travel/data/UnlockCity;", "(Landroid/app/Activity;Lcom/jiayouya/travel/module/travel/data/UnlockCity;)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/jiayouya/travel/databinding/DialogUnlockCityBinding;", "kotlin.jvm.PlatformType", "getItem", "()Lcom/jiayouya/travel/module/travel/data/UnlockCity;", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.s */
public final class UnlockCityDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogUnlockCityBinding f12044a = ((DialogUnlockCityBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_unlock_city, null, false));
    /* renamed from: b */
    private final Activity f12045b;
    /* renamed from: c */
    private final UnlockCity f12046c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: UnlockCityDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.s$a */
    static final class C3419a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ UnlockCityDilaog this$0;

        C3419a(UnlockCityDilaog sVar) {
            this.this$0 = sVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.dismiss();
            new ShareDilaog(this.this$0.mo22328a(), null, 2, null).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: UnlockCityDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.s$b */
    static final class C3420b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ UnlockCityDilaog this$0;

        C3420b(UnlockCityDilaog sVar) {
            this.this$0 = sVar;
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

    public UnlockCityDilaog(Activity activity, UnlockCity unlockCity) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        C8271i.m35386b(unlockCity, "item");
        super(activity);
        this.f12045b = activity;
        this.f12046c = unlockCity;
        DialogUnlockCityBinding dialogUnlockCityBinding = this.f12044a;
        C8271i.m35382a((Object) dialogUnlockCityBinding, "binding");
        setView(dialogUnlockCityBinding.getRoot());
        m14643c();
        m14642b();
    }

    /* renamed from: a */
    public final Activity mo22328a() {
        return this.f12045b;
    }

    /* renamed from: b */
    private final void m14642b() {
        setDimAmount(0.7f);
        DialogUnlockCityBinding dialogUnlockCityBinding = this.f12044a;
        String str = "binding";
        C8271i.m35382a((Object) dialogUnlockCityBinding, str);
        View root = dialogUnlockCityBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
        DialogUnlockCityBinding dialogUnlockCityBinding2 = this.f12044a;
        C8271i.m35382a((Object) dialogUnlockCityBinding2, str);
        dialogUnlockCityBinding2.mo20146a(this.f12046c);
    }

    /* renamed from: c */
    private final void m14643c() {
        RoundText roundText = this.f12044a.f10691a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3419a(this), 1, null);
        ImageView imageView = this.f12044a.f10692b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3420b(this), 1, null);
    }
}
