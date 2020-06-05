package com.jiayouya.travel.module.p276me.p279ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.Switch;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p246d.AliBindUtil;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.ActivitySettingBinding;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.p276me.data.VoiceStatus;
import com.jiayouya.travel.module.p276me.p279ui.dialog.BindPhoneHintDilaog;
import com.jiayouya.travel.module.p276me.p279ui.dialog.ExitDilaog;
import com.jiayouya.travel.module.p276me.p280vm.SettingVM;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p528b.OnRefreshListener;
import ezy.app.p643a.Session;
import ezy.p653ui.widget.round.RoundText;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/SettingActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivitySettingBinding;", "Lcom/jiayouya/travel/module/me/vm/SettingVM;", "()V", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: SettingActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.SettingActivity */
public final class SettingActivity extends BaseActivity<ActivitySettingBinding, SettingVM> {
    /* renamed from: c */
    private HashMap f11643c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SettingActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.SettingActivity$a */
    static final class C3182a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SettingActivity this$0;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: SettingActivity.kt */
        /* renamed from: com.jiayouya.travel.module.me.ui.SettingActivity$a$a */
        static final class C3183a extends Lambda implements C8246a<Unit> {
            public static final C3183a INSTANCE = new C3183a();

            C3183a() {
                super(0);
            }

            public final void invoke() {
                Router.m12969a(Router.f9644a, "/me/phone", null, null, 6, null);
            }
        }

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: SettingActivity.kt */
        /* renamed from: com.jiayouya.travel.module.me.ui.SettingActivity$a$b */
        static final class C3184b extends Lambda implements C8246a<Unit> {
            public static final C3184b INSTANCE = new C3184b();

            C3184b() {
                super(0);
            }

            public final void invoke() {
            }
        }

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: SettingActivity.kt */
        /* renamed from: com.jiayouya.travel.module.me.ui.SettingActivity$a$c */
        static final class C3185c extends Lambda implements C8246a<Unit> {
            public static final C3185c INSTANCE = new C3185c();

            C3185c() {
                super(0);
            }

            public final void invoke() {
            }
        }

        C3182a(SettingActivity settingActivity) {
            this.this$0 = settingActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            User a = SettingActivity.m14105a(this.this$0).mo20100a();
            if (a == null) {
                return;
            }
            if (a.isBindAliPay()) {
                Router.m12969a(Router.f9644a, "/me/myAliPay", null, null, 6, null);
            } else if (TextUtils.isEmpty(a.getMobile())) {
                new BindPhoneHintDilaog(this.this$0, C3183a.INSTANCE).show();
            } else {
                AliBindUtil.m12938a(this.this$0, C3184b.INSTANCE, C3185c.INSTANCE);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SettingActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.SettingActivity$b */
    static final class C3186b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SettingActivity this$0;

        C3186b(SettingActivity settingActivity) {
            this.this$0 = settingActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            new ExitDilaog(this.this$0, new C8246a<Unit>(this) {
                final /* synthetic */ C3186b this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    Session.f27256a.mo38542e();
                    Router.m12969a(Router.f9644a, "/login/wx", null, null, 6, null);
                    this.this$0.this$0.finish();
                }
            }).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/User;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SettingActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.SettingActivity$c */
    static final class C3188c<T> implements Observer<User> {
        /* renamed from: a */
        final /* synthetic */ SettingActivity f11644a;

        C3188c(SettingActivity settingActivity) {
            this.f11644a = settingActivity;
        }

        /* renamed from: a */
        public final void onChanged(User user) {
            ((SmartRefreshLayout) this.f11644a.mo19852a(R.id.refresh)).mo30890g();
            SettingActivity.m14105a(this.f11644a).mo20101a(user);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/data/VoiceStatus;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SettingActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.SettingActivity$d */
    static final class C3189d<T> implements Observer<VoiceStatus> {
        /* renamed from: a */
        final /* synthetic */ SettingActivity f11645a;

        C3189d(SettingActivity settingActivity) {
            this.f11645a = settingActivity;
        }

        /* renamed from: a */
        public final void onChanged(VoiceStatus voiceStatus) {
            SettingActivity.m14105a(this.f11645a).mo20102a(voiceStatus);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "onRefresh"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SettingActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.SettingActivity$e */
    static final class C3190e implements OnRefreshListener {
        /* renamed from: a */
        final /* synthetic */ SettingActivity f11646a;

        C3190e(SettingActivity settingActivity) {
            this.f11646a = settingActivity;
        }

        /* renamed from: a_ */
        public final void mo20372a_(RefreshLayout jVar) {
            C8271i.m35386b(jVar, "it");
            ResidentMemoryModel.m13597a(ResidentMemoryModel.f11323a, this.f11646a, null, null, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SettingActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.SettingActivity$f */
    static final class C3191f implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ SettingActivity f11647a;

        C3191f(SettingActivity settingActivity) {
            this.f11647a = settingActivity;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ((SettingVM) this.f11647a.mo19853a()).mo21502a(z);
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11643c == null) {
            this.f11643c = new HashMap();
        }
        View view = (View) this.f11643c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11643c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_setting;
    }

    /* renamed from: a */
    public static final /* synthetic */ ActivitySettingBinding m14105a(SettingActivity settingActivity) {
        return (ActivitySettingBinding) settingActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<SettingVM> mo19861d() {
        return SettingVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        ((SmartRefreshLayout) mo19852a(R.id.refresh)).mo30862a((OnRefreshListener) new C3190e(this));
        ((Switch) mo19852a(R.id.switch_view)).setOnCheckedChangeListener(new C3191f(this));
        ((ActivitySettingBinding) mo19857b()).mo20103a("v1.4.8");
        ((SettingVM) mo19853a()).mo21504c();
    }

    /* renamed from: k */
    public void mo19868k() {
        LinearLayout linearLayout = (LinearLayout) mo19852a(R.id.lyt_ali);
        C8271i.m35382a((Object) linearLayout, "lyt_ali");
        ezy.p642a.View.m34750a(linearLayout, 0, new C3182a(this), 1, null);
        RoundText roundText = (RoundText) mo19852a(R.id.btn_exit);
        C8271i.m35382a((Object) roundText, "btn_exit");
        ezy.p642a.View.m34750a(roundText, 0, new C3186b(this), 1, null);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        ResidentMemoryModel.f11323a.mo20737b().observe(lifecycleOwner, new C3188c(this));
        ((SettingVM) mo19853a()).mo21503b().observe(lifecycleOwner, new C3189d(this));
    }
}
