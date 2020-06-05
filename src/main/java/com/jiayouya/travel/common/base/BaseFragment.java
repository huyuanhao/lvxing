package com.jiayouya.travel.common.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.elvishew.xlog.XLog;
import com.gyf.barlibrary.ImmersionBar;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.LoadSirEx;
import com.jiayouya.travel.common.widget.LoadingDialog;
import com.kingja.loadsir.callback.Callback.OnReloadListener;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.HashMap;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010*\u001a\u00020+J\u0012\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020\u0014H\u0016J\b\u0010.\u001a\u00020/H&J\b\u00100\u001a\u00020\u0014H\u0016J\b\u00101\u001a\u00020\u0014H\u0016J\b\u00102\u001a\u00020+H\u0016J\u0014\u00103\u001a\u00020+2\f\u00104\u001a\b\u0012\u0004\u0012\u00020+05J&\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020+H\u0016J\b\u0010?\u001a\u00020+H\u0016J\u001a\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u0002072\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00010CH&J\b\u0010D\u001a\u00020+H\u0016J\u0019\u0010E\u001a\u00020+2\n\b\u0001\u0010F\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020+H\u0017J\b\u0010I\u001a\u00020+H\u0002J\u000e\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u000207J\b\u0010L\u001a\u00020+H\u0016J\u0006\u0010M\u001a\u00020+J\u0006\u0010N\u001a\u00020+J\u0010\u0010O\u001a\u00020+2\b\b\u0002\u0010P\u001a\u00020\u0014J\u0006\u0010Q\u001a\u00020+R\u001c\u0010\u0007\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u00020\u000e8DX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R \u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00028\u00018DX\u0002¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b'\u0010(¨\u0006R"}, mo39189d2 = {"Lcom/jiayouya/travel/common/base/BaseFragment;", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "immersionBar", "Lcom/gyf/barlibrary/ImmersionBar;", "getImmersionBar", "()Lcom/gyf/barlibrary/ImmersionBar;", "immersionBar$delegate", "Lkotlin/Lazy;", "isDarkStatusText", "", "()Z", "setDarkStatusText", "(Z)V", "isUsedImmersion", "isViewCreated", "setViewCreated", "loadService", "Lcom/kingja/loadsir/core/LoadService;", "getLoadService", "()Lcom/kingja/loadsir/core/LoadService;", "setLoadService", "(Lcom/kingja/loadsir/core/LoadService;)V", "loadingDialog", "Lcom/jiayouya/travel/common/widget/LoadingDialog;", "getLoadingDialog", "()Lcom/jiayouya/travel/common/widget/LoadingDialog;", "loadingDialog$delegate", "vm", "getVm", "()Lcom/jiayouya/travel/common/base/BaseViewModel;", "vm$delegate", "dismissLoading", "", "fetchData", "isRefresh", "getLayoutId", "", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "loadComplete", "makeSureViewCreated", "action", "Lkotlin/Function0;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onReload", "onViewCreated", "view", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "setupLoadingObserver", "event", "(Ljava/lang/Integer;)V", "setupObserver", "setupStatusBar", "setupStatusView", "normalStatusView", "setupView", "showEmpty", "showError", "showLoading", "isDialog", "showSuccess", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BaseFragment.kt */
public abstract class BaseFragment<Binding extends ViewDataBinding, T extends BaseViewModel> extends Fragment {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f9583a;
    /* renamed from: b */
    protected Binding f9584b;
    /* renamed from: c */
    private final Lazy f9585c = C8182c.m35317a(new C2877e(this));
    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean f9586d;
    /* renamed from: e */
    private boolean f9587e = true;
    /* renamed from: f */
    private final Lazy f9588f = C8182c.m35317a(new C2873a(this));
    /* renamed from: g */
    private boolean f9589g;
    /* renamed from: h */
    private LoadService<?> f9590h;
    /* renamed from: i */
    private final Lazy f9591i = C8182c.m35317a(new C2874b(this));
    /* renamed from: j */
    private HashMap f9592j;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "Lcom/gyf/barlibrary/ImmersionBar;", "kotlin.jvm.PlatformType", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseFragment.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseFragment$a */
    static final class C2873a extends Lambda implements C8246a<ImmersionBar> {
        final /* synthetic */ BaseFragment this$0;

        C2873a(BaseFragment baseFragment) {
            this.this$0 = baseFragment;
            super(0);
        }

        public final ImmersionBar invoke() {
            this.this$0.f9586d = true;
            return ImmersionBar.with((Fragment) this.this$0);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "Lcom/jiayouya/travel/common/widget/LoadingDialog;", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseFragment.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseFragment$b */
    static final class C2874b extends Lambda implements C8246a<LoadingDialog> {
        final /* synthetic */ BaseFragment this$0;

        C2874b(BaseFragment baseFragment) {
            this.this$0 = baseFragment;
            super(0);
        }

        public final LoadingDialog invoke() {
            Context context = this.this$0.getContext();
            if (context == null) {
                return null;
            }
            C8271i.m35382a((Object) context, "it");
            return new LoadingDialog(context);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0004\b\t\u0010\n"}, mo39189d2 = {"<anonymous>", "", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseFragment.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseFragment$c */
    static final class C2875c<T> implements Observer<Integer> {
        /* renamed from: a */
        final /* synthetic */ BaseFragment f9593a;

        C2875c(BaseFragment baseFragment) {
            this.f9593a = baseFragment;
        }

        /* renamed from: a */
        public final void onChanged(Integer num) {
            StringBuilder sb = new StringBuilder();
            sb.append("loadingEvent==>");
            sb.append(num);
            XLog.m12692b(sb.toString());
            if (num != null && num.intValue() == 0) {
                this.f9593a.mo19901q();
            } else if (num != null && num.intValue() == 1) {
                this.f9593a.mo19886b(true);
            } else if (num != null && num.intValue() == 2) {
                if (this.f9593a.mo19893i()) {
                    BaseFragment.m12878b(this.f9593a, false, 1, null);
                }
            } else if (num != null && num.intValue() == 3) {
                this.f9593a.mo19900p();
                this.f9593a.mo19894j();
            } else if (num != null && num.intValue() == 4) {
                if (this.f9593a.mo19892h()) {
                    this.f9593a.mo19899o();
                } else {
                    this.f9593a.mo19898n();
                }
                this.f9593a.mo19894j();
            } else if (num != null && num.intValue() == 5) {
                this.f9593a.mo19898n();
                this.f9593a.mo19894j();
            }
            this.f9593a.mo19883a(num);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onReload"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseFragment.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseFragment$d */
    static final class C2876d implements OnReloadListener {
        final /* synthetic */ BaseFragment this$0;

        C2876d(BaseFragment baseFragment) {
            this.this$0 = baseFragment;
        }

        public final void onReload(View view) {
            BaseFragment.m12878b(this.this$0, false, 1, null);
            this.this$0.mo19897m();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0001*\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "T", "Binding", "Landroidx/databinding/ViewDataBinding;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "invoke", "()Lcom/jiayouya/travel/common/base/BaseViewModel;"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseFragment.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseFragment$e */
    static final class C2877e extends Lambda implements C8246a<T> {
        final /* synthetic */ BaseFragment this$0;

        C2877e(BaseFragment baseFragment) {
            this.this$0 = baseFragment;
            super(0);
        }

        public final T invoke() {
            return (BaseViewModel) ViewModelProviders.m14of((Fragment) this.this$0).get(this.this$0.mo19889e());
        }
    }

    static {
        Class<BaseFragment> cls = BaseFragment.class;
        f9583a = new C8280j[]{C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "vm", "getVm()Lcom/jiayouya/travel/common/base/BaseViewModel;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "immersionBar", "getImmersionBar()Lcom/gyf/barlibrary/ImmersionBar;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "loadingDialog", "getLoadingDialog()Lcom/jiayouya/travel/common/widget/LoadingDialog;"))};
    }

    /* renamed from: s */
    private final LoadingDialog m12879s() {
        Lazy bVar = this.f9591i;
        C8280j jVar = f9583a[2];
        return (LoadingDialog) bVar.getValue();
    }

    /* renamed from: a */
    public View mo19880a(int i) {
        if (this.f9592j == null) {
            this.f9592j = new HashMap();
        }
        View view = (View) this.f9592j.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this.f9592j.put(Integer.valueOf(i), view);
        }
        return view;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final T mo19881a() {
        Lazy bVar = this.f9585c;
        C8280j jVar = f9583a[0];
        return (BaseViewModel) bVar.getValue();
    }

    /* renamed from: a */
    public void mo19883a(@LoadingType Integer num) {
    }

    /* renamed from: a */
    public void mo19884a(boolean z) {
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final ImmersionBar mo19885b() {
        Lazy bVar = this.f9588f;
        C8280j jVar = f9583a[1];
        return (ImmersionBar) bVar.getValue();
    }

    /* renamed from: e */
    public abstract Class<T> mo19889e();

    /* renamed from: f */
    public void mo19890f() {
    }

    /* renamed from: h */
    public boolean mo19892h() {
        return false;
    }

    /* renamed from: i */
    public boolean mo19893i() {
        return false;
    }

    /* renamed from: k */
    public void mo19895k() {
    }

    /* renamed from: l */
    public abstract int mo19896l();

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo19902r();
    }

    /* renamed from: r */
    public void mo19902r() {
        HashMap hashMap = this.f9592j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: c */
    public final Binding mo19887c() {
        Binding binding = this.f9584b;
        if (binding == null) {
            C8271i.m35387b("binding");
        }
        return binding;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: d */
    public final boolean mo19888d() {
        return this.f9589g;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C8271i.m35386b(layoutInflater, "inflater");
        Binding inflate = DataBindingUtil.inflate(layoutInflater, mo19896l(), viewGroup, false);
        C8271i.m35382a((Object) inflate, "DataBindingUtil.inflate(…utId(), container, false)");
        this.f9584b = inflate;
        this.f9589g = true;
        Binding binding = this.f9584b;
        if (binding == null) {
            C8271i.m35387b("binding");
        }
        return binding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        C8271i.m35386b(view, "view");
        super.onViewCreated(view, bundle);
        m12880t();
        mo19890f();
        mo19895k();
        mo19891g();
    }

    /* renamed from: t */
    private final void m12880t() {
        Binding binding = this.f9584b;
        if (binding == null) {
            C8271i.m35387b("binding");
        }
        View findViewById = binding.getRoot().findViewById(R.id.status_view);
        if (findViewById != null) {
            mo19885b().titleBar(findViewById);
        }
        mo19885b().statusBarDarkFont(this.f9587e).init();
    }

    /* renamed from: g */
    public void mo19891g() {
        mo19881a().mo19904a().observe(this, new C2875c(this));
    }

    /* renamed from: j */
    public void mo19894j() {
        Binding binding = this.f9584b;
        if (binding == null) {
            C8271i.m35387b("binding");
        }
        View findViewById = binding.getRoot().findViewById(R.id.refresh);
        if (findViewById instanceof SmartRefreshLayout) {
            ((SmartRefreshLayout) findViewById).mo30890g();
        }
    }

    /* renamed from: m */
    public void mo19897m() {
        m12877a(this, false, 1, null);
    }

    /* renamed from: a */
    public static /* synthetic */ void m12877a(BaseFragment baseFragment, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            baseFragment.mo19884a(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchData");
    }

    /* renamed from: a */
    public final void mo19882a(View view) {
        C8271i.m35386b(view, "normalStatusView");
        this.f9590h = LoadSir.m14996a().mo22631a((Object) view, (OnReloadListener) new C2876d(this));
    }

    /* renamed from: n */
    public final void mo19898n() {
        LoadService<?> bVar = this.f9590h;
        if (bVar != null) {
            bVar.mo22629a();
        }
    }

    /* renamed from: o */
    public final void mo19899o() {
        LoadService<?> bVar = this.f9590h;
        if (bVar != null) {
            LoadSirEx.m12821a(bVar);
        }
    }

    /* renamed from: p */
    public final void mo19900p() {
        LoadService<?> bVar = this.f9590h;
        if (bVar != null) {
            LoadSirEx.m12822b(bVar);
        }
    }

    /* renamed from: b */
    public static /* synthetic */ void m12878b(BaseFragment baseFragment, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            baseFragment.mo19886b(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoading");
    }

    /* renamed from: b */
    public final void mo19886b(boolean z) {
        if (z) {
            LoadingDialog s = m12879s();
            if (s != null && !s.isShowing()) {
                LoadingDialog s2 = m12879s();
                if (s2 != null) {
                    s2.show();
                    return;
                }
                return;
            }
            return;
        }
        LoadService<?> bVar = this.f9590h;
        if (bVar != null) {
            LoadSirEx.m12823c(bVar);
        }
    }

    /* renamed from: q */
    public final void mo19901q() {
        LoadingDialog s = m12879s();
        if (s != null && s.isShowing()) {
            LoadingDialog s2 = m12879s();
            if (s2 != null) {
                s2.dismiss();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f9586d) {
            mo19885b().destroy();
        }
    }
}
