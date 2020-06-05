package com.jiayouya.travel.module.p276me.p279ui;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p246d.AliBindUtil;
import com.jiayouya.travel.databinding.ActivityMyAliPayBinding;
import com.jiayouya.travel.module.common.data.AliUserRsp;
import com.jiayouya.travel.module.p276me.p278b.RefreshAliBindEvent;
import com.jiayouya.travel.module.p276me.p280vm.MyAliPayVM;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p642a.Context;
import ezy.p653ui.widget.round.RoundText;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0017¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/MyAliPayActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityMyAliPayBinding;", "Lcom/jiayouya/travel/module/me/vm/MyAliPayVM;", "()V", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MyAliPayActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.MyAliPayActivity */
public final class MyAliPayActivity extends BaseActivity<ActivityMyAliPayBinding, MyAliPayVM> {
    /* renamed from: c */
    private HashMap f11609c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MyAliPayActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.MyAliPayActivity$a */
    static final class C3151a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ MyAliPayActivity this$0;

        C3151a(MyAliPayActivity myAliPayActivity) {
            this.this$0 = myAliPayActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            AliBindUtil.m12938a(this.this$0, new C8246a<Unit>(this) {
                final /* synthetic */ C3151a this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    ((MyAliPayVM) this.this$0.this$0.mo19853a()).mo21473c();
                    Context.m34744a(this.this$0.this$0, "更换成功", 0, 0, 6, null);
                }
            }, C31532.INSTANCE);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/AliUserRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MyAliPayActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.MyAliPayActivity$b */
    static final class C3154b<T> implements Observer<AliUserRsp> {
        /* renamed from: a */
        final /* synthetic */ MyAliPayActivity f11610a;

        C3154b(MyAliPayActivity myAliPayActivity) {
            this.f11610a = myAliPayActivity;
        }

        /* renamed from: a */
        public final void onChanged(AliUserRsp aliUserRsp) {
            MyAliPayActivity.m14029a(this.f11610a).mo20092a(aliUserRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/event/RefreshAliBindEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MyAliPayActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.MyAliPayActivity$c */
    static final class C3155c<T> implements Consumer<RefreshAliBindEvent> {
        /* renamed from: a */
        final /* synthetic */ MyAliPayActivity f11611a;

        C3155c(MyAliPayActivity myAliPayActivity) {
            this.f11611a = myAliPayActivity;
        }

        /* renamed from: a */
        public final void accept(RefreshAliBindEvent cVar) {
            ((MyAliPayVM) this.f11611a.mo19853a()).mo21473c();
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11609c == null) {
            this.f11609c = new HashMap();
        }
        View view = (View) this.f11609c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11609c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_my_ali_pay;
    }

    /* renamed from: a */
    public static final /* synthetic */ ActivityMyAliPayBinding m14029a(MyAliPayActivity myAliPayActivity) {
        return (ActivityMyAliPayBinding) myAliPayActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<MyAliPayVM> mo19861d() {
        return MyAliPayVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        ((MyAliPayVM) mo19853a()).mo21473c();
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        ((MyAliPayVM) mo19853a()).mo21472b().observe(lifecycleOwner, new C3154b(this));
        C8019a.m34778a(RxBus.f27263a.mo38571a(RefreshAliBindEvent.class), lifecycleOwner, null, 2, null).mo37374a(new C3155c(this));
    }

    /* renamed from: k */
    public void mo19868k() {
        RoundText roundText = (RoundText) mo19852a(R.id.btn);
        C8271i.m35382a((Object) roundText, "btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3151a(this), 1, null);
    }
}
