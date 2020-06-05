package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogGetMaxLevelDogBinding;
import com.jiayouya.travel.module.travel.p287c.MergeUtil;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/GetMaxLevelDogDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "activity", "Landroid/app/Activity;", "name", "", "resId", "", "desc", "(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/jiayouya/travel/databinding/DialogGetMaxLevelDogBinding;", "kotlin.jvm.PlatformType", "getDesc", "()Ljava/lang/String;", "getName", "getResId", "()I", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.h */
public final class GetMaxLevelDogDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogGetMaxLevelDogBinding f11981a = ((DialogGetMaxLevelDogBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_get_max_level_dog, null, false));
    /* renamed from: b */
    private final Activity f11982b;
    /* renamed from: c */
    private final String f11983c;
    /* renamed from: d */
    private final int f11984d;
    /* renamed from: e */
    private final String f11985e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: GetMaxLevelDogDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.h$a */
    static final class C3367a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ GetMaxLevelDogDilaog this$0;

        C3367a(GetMaxLevelDogDilaog hVar) {
            this.this$0 = hVar;
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
    /* compiled from: GetMaxLevelDogDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.h$b */
    static final class C3368b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ GetMaxLevelDogDilaog this$0;

        C3368b(GetMaxLevelDogDilaog hVar) {
            this.this$0 = hVar;
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

    public GetMaxLevelDogDilaog(Activity activity, String str, int i, String str2) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        super(activity);
        this.f11982b = activity;
        this.f11983c = str;
        this.f11984d = i;
        this.f11985e = str2;
        DialogGetMaxLevelDogBinding dialogGetMaxLevelDogBinding = this.f11981a;
        C8271i.m35382a((Object) dialogGetMaxLevelDogBinding, "binding");
        setView(dialogGetMaxLevelDogBinding.getRoot());
        m14557b();
        m14556a();
    }

    /* renamed from: a */
    private final void m14556a() {
        DialogGetMaxLevelDogBinding dialogGetMaxLevelDogBinding = this.f11981a;
        String str = "binding";
        C8271i.m35382a((Object) dialogGetMaxLevelDogBinding, str);
        View root = dialogGetMaxLevelDogBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
        setDimAmount(0.7f);
        DialogGetMaxLevelDogBinding dialogGetMaxLevelDogBinding2 = this.f11981a;
        C8271i.m35382a((Object) dialogGetMaxLevelDogBinding2, str);
        dialogGetMaxLevelDogBinding2.mo20120a(this.f11983c);
        DialogGetMaxLevelDogBinding dialogGetMaxLevelDogBinding3 = this.f11981a;
        C8271i.m35382a((Object) dialogGetMaxLevelDogBinding3, str);
        dialogGetMaxLevelDogBinding3.mo20119a(MergeUtil.m14455b(this.f11984d));
        DialogGetMaxLevelDogBinding dialogGetMaxLevelDogBinding4 = this.f11981a;
        C8271i.m35382a((Object) dialogGetMaxLevelDogBinding4, str);
        dialogGetMaxLevelDogBinding4.mo20121b(this.f11985e);
    }

    /* renamed from: b */
    private final void m14557b() {
        RoundText roundText = this.f11981a.f10427a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3367a(this), 1, null);
        ImageView imageView = this.f11981a.f10428b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3368b(this), 1, null);
    }
}
