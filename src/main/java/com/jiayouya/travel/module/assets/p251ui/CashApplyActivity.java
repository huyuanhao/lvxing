package com.jiayouya.travel.module.assets.p251ui;

import android.os.Bundle;
import android.view.View;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.databinding.ActivityCashApplyBinding;
import com.jiayouya.travel.module.assets.data.CashApplyRsp;
import com.jiayouya.travel.module.assets.p253vm.CashApplyVM;
import ezy.p653ui.widget.round.RoundText;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/ui/CashApplyActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityCashApplyBinding;", "Lcom/jiayouya/travel/module/assets/vm/CashApplyVM;", "()V", "item", "Lcom/jiayouya/travel/module/assets/data/CashApplyRsp;", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CashApplyActivity.kt */
/* renamed from: com.jiayouya.travel.module.assets.ui.CashApplyActivity */
public final class CashApplyActivity extends BaseActivity<ActivityCashApplyBinding, CashApplyVM> {
    /* renamed from: c */
    public CashApplyRsp f11256c;
    /* renamed from: d */
    private HashMap f11257d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashApplyActivity.kt */
    /* renamed from: com.jiayouya.travel.module.assets.ui.CashApplyActivity$a */
    static final class C2940a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ CashApplyActivity this$0;

        C2940a(CashApplyActivity cashApplyActivity) {
            this.this$0 = cashApplyActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.finish();
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11257d == null) {
            this.f11257d = new HashMap();
        }
        View view = (View) this.f11257d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11257d.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_cash_apply;
    }

    /* renamed from: d */
    public Class<CashApplyVM> mo19861d() {
        return CashApplyVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        ((ActivityCashApplyBinding) mo19857b()).mo20080a(this.f11256c);
    }

    /* renamed from: k */
    public void mo19868k() {
        RoundText roundText = (RoundText) mo19852a(R.id.btn_complete);
        C8271i.m35382a((Object) roundText, "btn_complete");
        ezy.p642a.View.m34750a(roundText, 0, new C2940a(this), 1, null);
    }
}
