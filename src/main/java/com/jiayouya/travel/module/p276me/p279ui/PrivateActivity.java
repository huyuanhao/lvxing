package com.jiayouya.travel.module.p276me.p279ui;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.Switch;
import androidx.lifecycle.Observer;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.databinding.ActivityPrivateBinding;
import com.jiayouya.travel.module.common.data.UserPrivacyRsp;
import com.jiayouya.travel.module.p276me.p280vm.PrivateVM;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/PrivateActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityPrivateBinding;", "Lcom/jiayouya/travel/module/me/vm/PrivateVM;", "()V", "isEnable", "", "fetchData", "", "isRefresh", "getLayoutId", "", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "providerViewModelClass", "Ljava/lang/Class;", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: PrivateActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.PrivateActivity */
public final class PrivateActivity extends BaseActivity<ActivityPrivateBinding, PrivateVM> {
    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean f11634c;
    /* renamed from: d */
    private HashMap f11635d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/UserPrivacyRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PrivateActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.PrivateActivity$a */
    static final class C3174a<T> implements Observer<UserPrivacyRsp> {
        /* renamed from: a */
        final /* synthetic */ PrivateActivity f11636a;

        C3174a(PrivateActivity privateActivity) {
            this.f11636a = privateActivity;
        }

        /* renamed from: a */
        public final void onChanged(UserPrivacyRsp userPrivacyRsp) {
            PrivateActivity.m14082b(this.f11636a).mo20098a(userPrivacyRsp);
            PrivateActivity.m14082b(this.f11636a).getRoot().postDelayed(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ C3174a f11637a;

                {
                    this.f11637a = r1;
                }

                public final void run() {
                    this.f11637a.f11636a.f11634c = true;
                }
            }, 100);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PrivateActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.PrivateActivity$b */
    static final class C3176b implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ PrivateActivity f11638a;

        C3176b(PrivateActivity privateActivity) {
            this.f11638a = privateActivity;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f11638a.f11634c) {
                PrivateVM.m14262a((PrivateVM) this.f11638a.mo19853a(), z, 0, 2, null);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PrivateActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.PrivateActivity$c */
    static final class C3177c implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ PrivateActivity f11639a;

        C3177c(PrivateActivity privateActivity) {
            this.f11639a = privateActivity;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f11639a.f11634c) {
                PrivateVM.m14262a((PrivateVM) this.f11639a.mo19853a(), 0, z, 1, null);
            }
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11635d == null) {
            this.f11635d = new HashMap();
        }
        View view = (View) this.f11635d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11635d.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_private;
    }

    /* renamed from: h */
    public boolean mo19865h() {
        return true;
    }

    /* renamed from: i */
    public boolean mo19866i() {
        return true;
    }

    /* renamed from: b */
    public static final /* synthetic */ ActivityPrivateBinding m14082b(PrivateActivity privateActivity) {
        return (ActivityPrivateBinding) privateActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<PrivateVM> mo19861d() {
        return PrivateVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        LinearLayout linearLayout = (LinearLayout) mo19852a(R.id.lyt_container);
        C8271i.m35382a((Object) linearLayout, "lyt_container");
        setupStatusView(linearLayout);
        ((Switch) mo19852a(R.id.switch_view)).setOnCheckedChangeListener(new C3176b(this));
        ((Switch) mo19852a(R.id.switch_view2)).setOnCheckedChangeListener(new C3177c(this));
        BaseActivity.m12847a(this, false, 1, null);
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((PrivateVM) mo19853a()).mo21496d();
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        ((PrivateVM) mo19853a()).mo21494b().observe(this, new C3174a(this));
    }
}
