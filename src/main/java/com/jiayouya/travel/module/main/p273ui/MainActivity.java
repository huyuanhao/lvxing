package com.jiayouya.travel.module.main.p273ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.elvishew.xlog.XLog;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p246d.InviteCodeUtil;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.ActivityMainBinding;
import com.jiayouya.travel.databinding.LayoutTabBinding;
import com.jiayouya.travel.module.common.data.SystemNotice;
import com.jiayouya.travel.module.common.p259ui.dialog.DialogManager;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.common.widget.FragmentSwitcher;
import com.jiayouya.travel.module.group.p268ui.fragment.TourGroupFragment;
import com.jiayouya.travel.module.main.p273ui.p274a.SystemNoticeDialog;
import com.jiayouya.travel.module.main.p275vm.MainVM;
import com.jiayouya.travel.module.p276me.p279ui.dialog.BindInviterDilaog;
import com.jiayouya.travel.module.p276me.p279ui.fragment.MeFragment;
import com.jiayouya.travel.module.travel.p286b.LogoutEvent;
import com.jiayouya.travel.module.travel.p288ui.fragment.TravelFragment;
import com.travel.adlibrary.AdSdk;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.C8185c;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0004J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u0012H\u0016J\u0012\u0010\"\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0012\u0010#\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010&\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u001fH\u0014J\b\u0010)\u001a\u00020\u0012H\u0002J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030+H\u0016J\u0012\u0010,\u001a\u00020\u00122\b\b\u0002\u0010-\u001a\u00020\u001bH\u0002J\b\u0010.\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\fj\b\u0012\u0004\u0012\u00020\n`\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u00060"}, mo39189d2 = {"Lcom/jiayouya/travel/module/main/ui/MainActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityMainBinding;", "Lcom/jiayouya/travel/module/main/vm/MainVM;", "()V", "mFragmentSwitcher", "Lcom/jiayouya/travel/module/common/widget/FragmentSwitcher;", "mLastClickTime", "", "tab", "", "tabTitles", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tabs", "", "[Ljava/lang/String;", "addTab", "", "id", "title", "image", "", "fragment", "Landroidx/fragment/app/Fragment;", "fetchData", "isRefresh", "", "getLayoutId", "initTabs", "savedInstanceState", "Landroid/os/Bundle;", "isFastClick", "onBackPressed", "onCreate", "onNewIntent", "intent", "Landroid/content/Intent;", "onRestoreInstanceState", "onSaveInstanceState", "outState", "processXgPush", "providerViewModelClass", "Ljava/lang/Class;", "setTabSelect", "isOnlyShowFragment", "setupObserver", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MainActivity.kt */
/* renamed from: com.jiayouya.travel.module.main.ui.MainActivity */
public final class MainActivity extends BaseActivity<ActivityMainBinding, MainVM> {
    /* renamed from: c */
    public static final C3094a f11539c = new C3094a(null);
    /* renamed from: d */
    private final ArrayList<String> f11540d = C8187k.m35273c("旅行", "旅行团", "我");
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final String[] f11541e = {"travel", "tourGroup", "me"};
    /* access modifiers changed from: private */
    /* renamed from: f */
    public String f11542f;
    /* renamed from: g */
    private FragmentSwitcher f11543g;
    /* renamed from: h */
    private long f11544h;
    /* renamed from: i */
    private HashMap f11545i;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/main/ui/MainActivity$Companion;", "", "()V", "TAB_GROUP", "", "TAB_HOME_TRAVEL", "TAB_ME", "launch", "", "context", "Landroid/content/Context;", "tab", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: MainActivity.kt */
    /* renamed from: com.jiayouya.travel.module.main.ui.MainActivity$a */
    public static final class C3094a {
        private C3094a() {
        }

        public /* synthetic */ C3094a(DefaultConstructorMarker fVar) {
            this();
        }

        /* renamed from: a */
        public static /* synthetic */ void m13887a(C3094a aVar, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "travel";
            }
            aVar.mo21178a(context, str);
        }

        /* renamed from: a */
        public final void mo21178a(Context context, String str) {
            C8271i.m35386b(context, "context");
            String str2 = "tab";
            C8271i.m35386b(str, str2);
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra(str2, str);
            context.startActivity(intent);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, mo39189d2 = {"com/jiayouya/travel/module/main/ui/MainActivity$initTabs$1", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "t", "onTabUnselected", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: MainActivity.kt */
    /* renamed from: com.jiayouya.travel.module.main.ui.MainActivity$b */
    public static final class C3095b implements OnTabSelectedListener {
        /* renamed from: a */
        final /* synthetic */ MainActivity f11546a;

        public void onTabReselected(Tab tab) {
        }

        public void onTabUnselected(Tab tab) {
        }

        C3095b(MainActivity mainActivity) {
            this.f11546a = mainActivity;
        }

        public void onTabSelected(Tab tab) {
            if (tab != null) {
                String str = this.f11546a.f11541e[tab.getPosition()];
                if (!C8271i.m35384a((Object) str, (Object) this.f11546a.f11542f)) {
                    this.f11546a.f11542f = str;
                    this.f11546a.m13879d(true);
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "Lcom/jiayouya/travel/module/common/data/SystemNotice;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MainActivity.kt */
    /* renamed from: com.jiayouya.travel.module.main.ui.MainActivity$c */
    static final class C3096c<T> implements Observer<List<? extends SystemNotice>> {
        /* renamed from: a */
        final /* synthetic */ MainActivity f11547a;

        C3096c(MainActivity mainActivity) {
            this.f11547a = mainActivity;
        }

        /* renamed from: a */
        public final void onChanged(List<SystemNotice> list) {
            if (!list.isEmpty()) {
                DialogManager a = DialogManager.f11300b.mo20713a();
                C8271i.m35382a((Object) list, "it");
                for (SystemNotice aVar : list) {
                    a.mo20712a(new SystemNoticeDialog(this.f11547a, aVar));
                }
                a.mo20711a();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MainActivity.kt */
    /* renamed from: com.jiayouya.travel.module.main.ui.MainActivity$d */
    static final class C3097d<T> implements Observer<Boolean> {
        /* renamed from: a */
        final /* synthetic */ MainActivity f11548a;

        C3097d(MainActivity mainActivity) {
            this.f11548a = mainActivity;
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            C8271i.m35382a((Object) bool, "it");
            if (bool.booleanValue()) {
                DialogManager a = DialogManager.f11300b.mo20713a();
                a.mo20712a(new BindInviterDilaog(this.f11548a, false, 2, null));
                a.mo20711a();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/event/LogoutEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MainActivity.kt */
    /* renamed from: com.jiayouya.travel.module.main.ui.MainActivity$e */
    static final class C3098e<T> implements Consumer<LogoutEvent> {
        /* renamed from: a */
        final /* synthetic */ MainActivity f11549a;

        C3098e(MainActivity mainActivity) {
            this.f11549a = mainActivity;
        }

        /* renamed from: a */
        public final void accept(LogoutEvent cVar) {
            this.f11549a.finish();
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11545i == null) {
            this.f11545i = new HashMap();
        }
        View view = (View) this.f11545i.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11545i.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_main;
    }

    /* renamed from: d */
    public Class<MainVM> mo19861d() {
        return MainVM.class;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        XLog.m12692b("main onNewIntent");
        setIntent(intent);
        m13881r();
        InviteCodeUtil.m12964a(intent);
        String stringExtra = intent != null ? intent.getStringExtra("tab") : null;
        if (stringExtra != null && !C8271i.m35384a((Object) stringExtra, (Object) this.f11542f)) {
            this.f11542f = stringExtra;
            StringBuilder sb = new StringBuilder();
            sb.append("main onNewIntent select tab:");
            sb.append(this.f11542f);
            XLog.m12692b(sb.toString());
            m13874a(this, false, 1, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m13878b(bundle);
        AdSdk.f25896a.mo37291a((Context) this);
        m13881r();
        BaseActivity.m12847a(this, false, 1, null);
        InviteCodeUtil.m12964a(getIntent());
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((MainVM) mo19853a()).mo21186c();
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        ((MainVM) mo19853a()).mo21185b().observe(lifecycleOwner, new C3096c(this));
        ResidentMemoryModel.f11323a.mo20738c().observe(lifecycleOwner, new C3097d(this));
        C8019a.m34778a(RxBus.f27263a.mo38571a(LogoutEvent.class), lifecycleOwner, null, 2, null).mo37374a(new C3098e(this));
    }

    /* renamed from: b */
    private final void m13878b(Bundle bundle) {
        String str;
        this.f11543g = new FragmentSwitcher(this, R.id.container);
        ((TabLayout) mo19852a(R.id.tabLayout)).addOnTabSelectedListener(new C3095b(this));
        String str2 = this.f11541e[0];
        Object obj = this.f11540d.get(0);
        C8271i.m35382a(obj, "tabTitles[0]");
        String str3 = (String) obj;
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.f11541e[0]);
        if (findFragmentByTag == null) {
            findFragmentByTag = new TravelFragment();
        }
        m13875a(str2, str3, (int) R.drawable.main_tab_travel, findFragmentByTag);
        String str4 = this.f11541e[1];
        Object obj2 = this.f11540d.get(1);
        C8271i.m35382a(obj2, "tabTitles[1]");
        String str5 = (String) obj2;
        Fragment findFragmentByTag2 = getSupportFragmentManager().findFragmentByTag(this.f11541e[1]);
        if (findFragmentByTag2 == null) {
            findFragmentByTag2 = new TourGroupFragment();
        }
        m13875a(str4, str5, (int) R.drawable.main_tab_wallet, findFragmentByTag2);
        String str6 = this.f11541e[2];
        Object obj3 = this.f11540d.get(2);
        C8271i.m35382a(obj3, "tabTitles[2]");
        String str7 = (String) obj3;
        Fragment findFragmentByTag3 = getSupportFragmentManager().findFragmentByTag(this.f11541e[2]);
        if (findFragmentByTag3 == null) {
            findFragmentByTag3 = new MeFragment();
        }
        m13875a(str6, str7, (int) R.drawable.main_tab_me, findFragmentByTag3);
        String str8 = "tab";
        if (bundle != null) {
            str = bundle.getString(str8);
        } else {
            str = getIntent().getStringExtra(str8);
        }
        if (str == null) {
            str = "travel";
        }
        this.f11542f = str;
        m13874a(this, false, 1, (Object) null);
    }

    /* renamed from: a */
    static /* synthetic */ void m13874a(MainActivity mainActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        mainActivity.m13879d(z);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final void m13879d(boolean z) {
        int i = 0;
        this.f11542f = TextUtils.isEmpty(this.f11542f) ? this.f11541e[0] : this.f11542f;
        FragmentSwitcher aVar = this.f11543g;
        if (aVar == null) {
            C8271i.m35387b("mFragmentSwitcher");
        }
        aVar.mo20755a(this.f11542f);
        if (C8185c.m35261b(this.f11541e, this.f11542f) != -1) {
            i = C8185c.m35261b(this.f11541e, this.f11542f);
        }
        if (!z) {
            Tab tabAt = ((TabLayout) mo19852a(R.id.tabLayout)).getTabAt(i);
            if (tabAt != null) {
                tabAt.select();
            }
        }
    }

    /* renamed from: a */
    private final void m13875a(String str, String str2, int i, Fragment fragment) {
        FragmentSwitcher aVar = this.f11543g;
        if (aVar == null) {
            C8271i.m35387b("mFragmentSwitcher");
        }
        aVar.mo20756a(str, fragment);
        LayoutTabBinding layoutTabBinding = (LayoutTabBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.layout_tab, null, false);
        Drawable drawable = getDrawable(i);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            layoutTabBinding.f11202a.setCompoundDrawables(null, drawable, null, null);
        }
        C8271i.m35382a((Object) layoutTabBinding, "binding");
        layoutTabBinding.mo20207a(str2);
        ((TabLayout) mo19852a(R.id.tabLayout)).addTab(((TabLayout) mo19852a(R.id.tabLayout)).newTab().setTag(str).setCustomView(layoutTabBinding.getRoot()));
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        C8271i.m35386b(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString("tab", this.f11542f);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f11542f = bundle != null ? bundle.getString("tab") : null;
        m13874a(this, false, 1, (Object) null);
    }

    public void onBackPressed() {
        if (m13880q()) {
            super.onBackPressed();
            finishAffinity();
            System.exit(0);
            return;
        }
        ezy.p642a.Context.m34744a(this, "再按一次退出程序！", 0, 0, 6, null);
    }

    /* renamed from: q */
    private final boolean m13880q() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f11544h < ((long) 4000)) {
            return true;
        }
        this.f11544h = currentTimeMillis;
        return false;
    }

    /* renamed from: r */
    private final void m13881r() {
        Intent intent = getIntent();
        String str = "intent";
        C8271i.m35382a((Object) intent, str);
        Uri data = intent.getData();
        if (data != null) {
            Intent intent2 = getIntent();
            C8271i.m35382a((Object) intent2, str);
            if (C8271i.m35384a((Object) intent2.getScheme(), (Object) "xgscheme")) {
                XLog.m12692b("processXgPush");
                String queryParameter = data.getQueryParameter("route");
                if (queryParameter != null) {
                    Router.m12969a(Router.f9644a, queryParameter, null, null, 6, null);
                }
            }
        }
    }
}
