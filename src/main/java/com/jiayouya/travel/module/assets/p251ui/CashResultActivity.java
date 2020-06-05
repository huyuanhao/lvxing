package com.jiayouya.travel.module.assets.p251ui;

import android.os.Bundle;
import android.view.View;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.databinding.ActivityCashResultBinding;
import com.jiayouya.travel.module.assets.p253vm.CashResultVM;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/ui/CashResultActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityCashResultBinding;", "Lcom/jiayouya/travel/module/assets/vm/CashResultVM;", "()V", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setupView", "", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CashResultActivity.kt */
/* renamed from: com.jiayouya.travel.module.assets.ui.CashResultActivity */
public final class CashResultActivity extends BaseActivity<ActivityCashResultBinding, CashResultVM> {
    /* renamed from: c */
    private HashMap f11264c;

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11264c == null) {
            this.f11264c = new HashMap();
        }
        View view = (View) this.f11264c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11264c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_cash_result;
    }

    /* renamed from: d */
    public Class<CashResultVM> mo19861d() {
        return CashResultVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        ((ActivityCashResultBinding) mo19857b()).mo20083a(true);
    }
}
