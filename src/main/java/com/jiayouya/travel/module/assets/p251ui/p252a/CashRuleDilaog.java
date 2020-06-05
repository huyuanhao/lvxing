package com.jiayouya.travel.module.assets.p251ui.p252a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.databinding.DialogCashRuleBinding;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import ezy.p653ui.widget.round.RoundText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/ui/dialog/CashRuleDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "list", "", "", "(Landroid/content/Context;Ljava/util/List;)V", "adapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "binding", "Lcom/jiayouya/travel/databinding/DialogCashRuleBinding;", "getList", "()Ljava/util/List;", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.assets.ui.a.a */
public final class CashRuleDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogCashRuleBinding f11265a = ((DialogCashRuleBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_cash_rule, null, false));
    /* renamed from: b */
    private final BindingType f11266b = BindingType.create(String.class, (int) R.layout.item_cash_rule);
    /* renamed from: c */
    private final SingleTypeAdapter<String> f11267c = new SingleTypeAdapter<>(this.f11266b);
    /* renamed from: d */
    private final List<String> f11268d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashRuleDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.assets.ui.a.a$a */
    static final class C2944a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ CashRuleDilaog this$0;

        C2944a(CashRuleDilaog aVar) {
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
    /* compiled from: CashRuleDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.assets.ui.a.a$b */
    static final class C2945b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ CashRuleDilaog this$0;

        C2945b(CashRuleDilaog aVar) {
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

    public CashRuleDilaog(Context context, List<String> list) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(list, "list");
        super(context);
        this.f11268d = list;
        DialogCashRuleBinding dialogCashRuleBinding = this.f11265a;
        C8271i.m35382a((Object) dialogCashRuleBinding, "binding");
        setView(dialogCashRuleBinding.getRoot());
        m13491b();
        m13490a();
    }

    /* renamed from: a */
    private final void m13490a() {
        setDimAmount(0.7f);
        DialogCashRuleBinding dialogCashRuleBinding = this.f11265a;
        C8271i.m35382a((Object) dialogCashRuleBinding, "binding");
        View root = dialogCashRuleBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(270.0f);
        RecyclerView recyclerView = this.f11265a.f10292c;
        C8271i.m35382a((Object) recyclerView, "binding.list");
        recyclerView.setAdapter(this.f11267c);
        this.f11267c.setItems(this.f11268d);
        this.f11267c.notifyDataSetChanged();
    }

    /* renamed from: b */
    private final void m13491b() {
        ImageView imageView = this.f11265a.f10291b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C2944a(this), 1, null);
        RoundText roundText = this.f11265a.f10290a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C2945b(this), 1, null);
    }
}
