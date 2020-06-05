package com.jiayouya.travel.module.p281tb.p283ui;

import android.view.View;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.databinding.ActivityOrderDetailsBinding;
import com.jiayouya.travel.module.p281tb.p284vm.OrderDetailsVM;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016¨\u0006\t"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/ui/OrderDetailsActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityOrderDetailsBinding;", "Lcom/jiayouya/travel/module/tb/vm/OrderDetailsVM;", "()V", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: OrderDetailsActivity.kt */
/* renamed from: com.jiayouya.travel.module.tb.ui.OrderDetailsActivity */
public final class OrderDetailsActivity extends BaseActivity<ActivityOrderDetailsBinding, OrderDetailsVM> {
    /* renamed from: c */
    private HashMap f11804c;

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11804c == null) {
            this.f11804c = new HashMap();
        }
        View view = (View) this.f11804c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11804c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_order_details;
    }

    /* renamed from: d */
    public Class<OrderDetailsVM> mo19861d() {
        return OrderDetailsVM.class;
    }
}
