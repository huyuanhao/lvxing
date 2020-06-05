package com.jiayouya.travel.module.p276me.p279ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.lifecycle.Observer;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.databinding.ActivityBonusDetailBinding;
import com.jiayouya.travel.module.p276me.data.BonusDetailRsp;
import com.jiayouya.travel.module.p276me.p280vm.BonusDetailVM;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/BonusDetailActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityBonusDetailBinding;", "Lcom/jiayouya/travel/module/me/vm/BonusDetailVM;", "()V", "fetchData", "", "isRefresh", "", "getLayoutId", "", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "providerViewModelClass", "Ljava/lang/Class;", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BonusDetailActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.BonusDetailActivity */
public final class BonusDetailActivity extends BaseActivity<ActivityBonusDetailBinding, BonusDetailVM> {
    /* renamed from: c */
    private HashMap f11574c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/data/BonusDetailRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BonusDetailActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.BonusDetailActivity$a */
    static final class C3117a<T> implements Observer<BonusDetailRsp> {
        /* renamed from: a */
        final /* synthetic */ BonusDetailActivity f11575a;

        C3117a(BonusDetailActivity bonusDetailActivity) {
            this.f11575a = bonusDetailActivity;
        }

        /* renamed from: a */
        public final void onChanged(BonusDetailRsp bonusDetailRsp) {
            BonusDetailActivity.m13940a(this.f11575a).mo20078a(bonusDetailRsp);
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11574c == null) {
            this.f11574c = new HashMap();
        }
        View view = (View) this.f11574c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11574c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_bonus_detail;
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
    public static final /* synthetic */ ActivityBonusDetailBinding m13940a(BonusDetailActivity bonusDetailActivity) {
        return (ActivityBonusDetailBinding) bonusDetailActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<BonusDetailVM> mo19861d() {
        return BonusDetailVM.class;
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((BonusDetailVM) mo19853a()).mo21446c();
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        ScrollView scrollView = (ScrollView) mo19852a(R.id.scroll_view);
        C8271i.m35382a((Object) scrollView, "scroll_view");
        setupStatusView(scrollView);
        BaseActivity.m12847a(this, false, 1, null);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        ((BonusDetailVM) mo19853a()).mo21445b().observe(this, new C3117a(this));
    }
}
