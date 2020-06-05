package com.jiayouya.travel.module.group.p268ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogAchieveGoalBinding;
import com.jiayouya.travel.module.group.data.TargetRewards;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/ui/dialog/AchieveGoalDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "item", "Lcom/jiayouya/travel/module/group/data/TargetRewards;", "action", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/jiayouya/travel/module/group/data/TargetRewards;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "binding", "Lcom/jiayouya/travel/databinding/DialogAchieveGoalBinding;", "kotlin.jvm.PlatformType", "getItem", "()Lcom/jiayouya/travel/module/group/data/TargetRewards;", "setupClick", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.group.ui.dialog.a */
public final class AchieveGoalDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogAchieveGoalBinding f11496a = ((DialogAchieveGoalBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_achieve_goal, null, false));
    /* renamed from: b */
    private final TargetRewards f11497b;
    /* renamed from: c */
    private final C8246a<Unit> f11498c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AchieveGoalDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.dialog.a$a */
    static final class C3049a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ AchieveGoalDilaog this$0;

        C3049a(AchieveGoalDilaog aVar) {
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
    /* compiled from: AchieveGoalDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.dialog.a$b */
    static final class C3050b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ AchieveGoalDilaog this$0;

        C3050b(AchieveGoalDilaog aVar) {
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
            this.this$0.mo21125a().invoke();
        }
    }

    /* renamed from: a */
    public final C8246a<Unit> mo21125a() {
        return this.f11498c;
    }

    public AchieveGoalDilaog(Context context, TargetRewards targetRewards, C8246a<Unit> aVar) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(targetRewards, "item");
        C8271i.m35386b(aVar, "action");
        super(context);
        this.f11497b = targetRewards;
        this.f11498c = aVar;
        DialogAchieveGoalBinding dialogAchieveGoalBinding = this.f11496a;
        C8271i.m35382a((Object) dialogAchieveGoalBinding, "binding");
        setView(dialogAchieveGoalBinding.getRoot());
        m13792c();
        m13791b();
    }

    /* renamed from: b */
    private final void m13791b() {
        DialogAchieveGoalBinding dialogAchieveGoalBinding = this.f11496a;
        String str = "binding";
        C8271i.m35382a((Object) dialogAchieveGoalBinding, str);
        View root = dialogAchieveGoalBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
        DialogAchieveGoalBinding dialogAchieveGoalBinding2 = this.f11496a;
        C8271i.m35382a((Object) dialogAchieveGoalBinding2, str);
        dialogAchieveGoalBinding2.mo20104a(this.f11497b);
        setDimAmount(0.7f);
    }

    /* renamed from: c */
    private final void m13792c() {
        ImageView imageView = this.f11496a.f10256b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3049a(this), 1, null);
        RoundText roundText = this.f11496a.f10255a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3050b(this), 1, null);
    }
}
