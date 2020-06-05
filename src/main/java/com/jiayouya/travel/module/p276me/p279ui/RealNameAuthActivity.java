package com.jiayouya.travel.module.p276me.p279ui;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.net.RetrofitFactory;
import com.jiayouya.travel.common.p246d.AliBindUtil;
import com.jiayouya.travel.databinding.ActivityRealNameAuthBinding;
import com.jiayouya.travel.module.common.data.CertifiedStatusRsp;
import com.jiayouya.travel.module.common.p258b.RealNameAuthEvent;
import com.jiayouya.travel.module.p276me.p279ui.dialog.RealNameAuthFailDilaog;
import com.jiayouya.travel.module.p276me.p280vm.RealNameAuthVM;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p653ui.widget.round.RoundText;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/RealNameAuthActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityRealNameAuthBinding;", "Lcom/jiayouya/travel/module/me/vm/RealNameAuthVM;", "()V", "fetchData", "", "isRefresh", "", "getLayoutId", "", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "setupObserver", "setupStatusBar", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: RealNameAuthActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.RealNameAuthActivity */
public final class RealNameAuthActivity extends BaseActivity<ActivityRealNameAuthBinding, RealNameAuthVM> {
    /* renamed from: c */
    private HashMap f11640c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RealNameAuthActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.RealNameAuthActivity$a */
    static final class C3178a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ RealNameAuthActivity this$0;

        C3178a(RealNameAuthActivity realNameAuthActivity) {
            this.this$0 = realNameAuthActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            AliBindUtil.m12939a(this.this$0, new C8246a<Unit>(this) {
                final /* synthetic */ C3178a this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    RxBus.f27263a.mo38572a((Object) new RealNameAuthEvent(true));
                    BaseActivity.m12847a(this.this$0.this$0, false, 1, null);
                }
            }, null, 4, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/CertifiedStatusRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RealNameAuthActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.RealNameAuthActivity$b */
    static final class C3180b<T> implements Observer<CertifiedStatusRsp> {
        /* renamed from: a */
        final /* synthetic */ RealNameAuthActivity f11641a;

        C3180b(RealNameAuthActivity realNameAuthActivity) {
            this.f11641a = realNameAuthActivity;
        }

        /* renamed from: a */
        public final void onChanged(CertifiedStatusRsp certifiedStatusRsp) {
            ActivityRealNameAuthBinding a = RealNameAuthActivity.m14092a(this.f11641a);
            boolean z = true;
            if (certifiedStatusRsp.getStatus() != 1) {
                z = false;
            }
            a.mo20099a(z);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/event/RealNameAuthEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RealNameAuthActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.RealNameAuthActivity$c */
    static final class C3181c<T> implements Consumer<RealNameAuthEvent> {
        /* renamed from: a */
        final /* synthetic */ RealNameAuthActivity f11642a;

        C3181c(RealNameAuthActivity realNameAuthActivity) {
            this.f11642a = realNameAuthActivity;
        }

        /* renamed from: a */
        public final void accept(RealNameAuthEvent cVar) {
            if (!cVar.mo20436a()) {
                new RealNameAuthFailDilaog(this.f11642a, RetrofitFactory.f9659a.mo20016b()).show();
            }
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11640c == null) {
            this.f11640c = new HashMap();
        }
        View view = (View) this.f11640c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11640c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_real_name_auth;
    }

    /* renamed from: h */
    public boolean mo19865h() {
        return true;
    }

    /* renamed from: i */
    public boolean mo19866i() {
        return true;
    }

    /* renamed from: a */
    public static final /* synthetic */ ActivityRealNameAuthBinding m14092a(RealNameAuthActivity realNameAuthActivity) {
        return (ActivityRealNameAuthBinding) realNameAuthActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<RealNameAuthVM> mo19861d() {
        return RealNameAuthVM.class;
    }

    /* renamed from: e */
    public void mo19862e() {
        mo19859c().fitsSystemWindows(true).statusBarDarkFont(true).init();
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        FrameLayout frameLayout = (FrameLayout) mo19852a(R.id.lyt_container);
        C8271i.m35382a((Object) frameLayout, "lyt_container");
        setupStatusView(frameLayout);
        BaseActivity.m12847a(this, false, 1, null);
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((RealNameAuthVM) mo19853a()).mo21500c();
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        ((RealNameAuthVM) mo19853a()).mo21499b().observe(lifecycleOwner, new C3180b(this));
        C8019a.m34778a(RxBus.f27263a.mo38571a(RealNameAuthEvent.class), lifecycleOwner, null, 2, null).mo37374a(new C3181c(this));
    }

    /* renamed from: k */
    public void mo19868k() {
        RoundText roundText = (RoundText) mo19852a(R.id.btn);
        C8271i.m35382a((Object) roundText, "btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3178a(this), 1, null);
    }
}
