package com.jiayouya.travel.common.base;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.android.arouter.p043a.ARouter;
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
import com.travel.adlibrary.AdSdk;
import java.util.HashMap;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8263r;
import kotlin.reflect.C8280j;
import p681me.jessyan.autosize.AutoSizeCompat;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010+\u001a\u00020,J\u0012\u0010-\u001a\u00020,2\b\b\u0002\u0010.\u001a\u00020\u0014H\u0016J\b\u0010/\u001a\u000200H&J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u0014H\u0016J\b\u00104\u001a\u00020\u0014H\u0016J\b\u00105\u001a\u00020,H\u0016J\u0012\u00106\u001a\u00020,2\b\u00107\u001a\u0004\u0018\u000108H\u0014J\b\u00109\u001a\u00020,H\u0014J\b\u0010:\u001a\u00020,H\u0016J\b\u0010;\u001a\u00020,H\u0014Jf\u0010<\u001a`\u0012\u0013\u0012\u00110>¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0013\u0012\u001100¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(B\u0012\u0013\u0012\u001100¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(C\u0012\u0015\u0012\u0013\u0018\u00010D¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020,\u0018\u00010=H\u0002J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00010GH&J\b\u0010H\u001a\u00020,H\u0016J\u0019\u0010I\u001a\u00020,2\n\b\u0001\u0010J\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0002\u0010KJ\b\u0010L\u001a\u00020,H\u0017J\b\u0010M\u001a\u00020,H\u0016J\u000e\u0010N\u001a\u00020,2\u0006\u0010O\u001a\u00020PJ\b\u0010Q\u001a\u00020,H\u0002J\u0012\u0010R\u001a\u00020,2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0006\u0010S\u001a\u00020,J\u0006\u0010T\u001a\u00020,J\u0010\u0010U\u001a\u00020,2\b\b\u0002\u0010V\u001a\u00020\u0014J\u0006\u0010W\u001a\u00020,R\u001c\u0010\u0007\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u00020\u000e8DX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b\"\u0010#R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00028\u00018FX\u0002¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b(\u0010)¨\u0006X"}, mo39189d2 = {"Lcom/jiayouya/travel/common/base/BaseActivity;", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "immersionBar", "Lcom/gyf/barlibrary/ImmersionBar;", "getImmersionBar", "()Lcom/gyf/barlibrary/ImmersionBar;", "immersionBar$delegate", "Lkotlin/Lazy;", "isDarkStatusText", "", "()Z", "setDarkStatusText", "(Z)V", "isUsedImmersion", "isVideoLoading", "loadService", "Lcom/kingja/loadsir/core/LoadService;", "getLoadService", "()Lcom/kingja/loadsir/core/LoadService;", "setLoadService", "(Lcom/kingja/loadsir/core/LoadService;)V", "loadingDialog", "Lcom/jiayouya/travel/common/widget/LoadingDialog;", "getLoadingDialog", "()Lcom/jiayouya/travel/common/widget/LoadingDialog;", "loadingDialog$delegate", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "vm", "getVm", "()Lcom/jiayouya/travel/common/base/BaseViewModel;", "vm$delegate", "dismissLoading", "", "fetchData", "isRefresh", "getLayoutId", "", "getResources", "Landroid/content/res/Resources;", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "loadComplete", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onReload", "onResume", "processVideoLoading", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "methodName", "adPlat", "isBak", "", "extra", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "setupLoadingObserver", "event", "(Ljava/lang/Integer;)V", "setupObserver", "setupStatusBar", "setupStatusView", "normalStatusView", "Landroid/view/View;", "setupToolbar", "setupView", "showEmpty", "showError", "showLoading", "isDialog", "showSuccess", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BaseActivity.kt */
public abstract class BaseActivity<Binding extends ViewDataBinding, T extends BaseViewModel> extends AppCompatActivity {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f9569a;
    /* renamed from: b */
    protected Binding f9570b;
    /* renamed from: c */
    private final Lazy f9571c = C8182c.m35317a(new C2872h(this));
    /* renamed from: d */
    private Toolbar f9572d;
    /* renamed from: e */
    private LoadService<?> f9573e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean f9574f;
    /* renamed from: g */
    private boolean f9575g = true;
    /* renamed from: h */
    private final Lazy f9576h = C8182c.m35317a(new C2866b(this));
    /* renamed from: i */
    private final Lazy f9577i = C8182c.m35317a(new C2867c(this));
    /* access modifiers changed from: private */
    /* renamed from: j */
    public boolean f9578j;
    /* renamed from: k */
    private HashMap f9579k;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseActivity.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseActivity$a */
    static final class C2865a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ BaseActivity f9580a;

        C2865a(BaseActivity baseActivity) {
            this.f9580a = baseActivity;
        }

        public final void run() {
            AutoSizeCompat.autoConvertDensityOfGlobal(BaseActivity.super.getResources());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "Lcom/gyf/barlibrary/ImmersionBar;", "kotlin.jvm.PlatformType", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseActivity.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseActivity$b */
    static final class C2866b extends Lambda implements C8246a<ImmersionBar> {
        final /* synthetic */ BaseActivity this$0;

        C2866b(BaseActivity baseActivity) {
            this.this$0 = baseActivity;
            super(0);
        }

        public final ImmersionBar invoke() {
            this.this$0.f9574f = true;
            return ImmersionBar.with((Activity) this.this$0);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "Lcom/jiayouya/travel/common/widget/LoadingDialog;", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseActivity.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseActivity$c */
    static final class C2867c extends Lambda implements C8246a<LoadingDialog> {
        final /* synthetic */ BaseActivity this$0;

        C2867c(BaseActivity baseActivity) {
            this.this$0 = baseActivity;
            super(0);
        }

        public final LoadingDialog invoke() {
            return new LoadingDialog(this.this$0);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\n¢\u0006\u0002\b\r"}, mo39189d2 = {"<anonymous>", "", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "method", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseActivity.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseActivity$d */
    static final class C2868d extends Lambda implements C8263r<String, Integer, Integer, Object, Unit> {
        final /* synthetic */ BaseActivity this$0;

        C2868d(BaseActivity baseActivity) {
            this.this$0 = baseActivity;
            super(4);
        }

        public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue(), obj4);
            return Unit.f27778a;
        }

        public final void invoke(String str, int i, int i2, Object obj) {
            C8271i.m35386b(str, "method");
            int hashCode = str.hashCode();
            if (hashCode != -1997133194) {
                if (hashCode == -662111292 && str.equals("METHOD_ON_VIDEO_DISMISS")) {
                    this.this$0.f9578j = false;
                    this.this$0.mo19873p();
                }
            } else if (str.equals("METHOD_ON_VIDEO_LOADING")) {
                this.this$0.mo19860c(true);
                this.this$0.f9578j = true;
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0004\b\t\u0010\n"}, mo39189d2 = {"<anonymous>", "", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseActivity.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseActivity$e */
    static final class C2869e<T> implements Observer<Integer> {
        /* renamed from: a */
        final /* synthetic */ BaseActivity f9581a;

        C2869e(BaseActivity baseActivity) {
            this.f9581a = baseActivity;
        }

        /* renamed from: a */
        public final void onChanged(Integer num) {
            StringBuilder sb = new StringBuilder();
            sb.append("loadingEvent==>");
            sb.append(num);
            XLog.m12692b(sb.toString());
            if (num != null && num.intValue() == 0) {
                this.f9581a.mo19873p();
            } else if (num != null && num.intValue() == 1) {
                this.f9581a.mo19860c(true);
            } else if (num != null && num.intValue() == 2) {
                if (this.f9581a.mo19866i()) {
                    BaseActivity.m12849b(this.f9581a, false, 1, null);
                }
            } else if (num != null && num.intValue() == 3) {
                this.f9581a.mo19872o();
                this.f9581a.mo19867j();
            } else if (num != null && num.intValue() == 4) {
                if (this.f9581a.mo19865h()) {
                    this.f9581a.mo19871n();
                } else {
                    this.f9581a.mo19870m();
                }
                this.f9581a.mo19867j();
            } else if (num != null && num.intValue() == 5) {
                this.f9581a.mo19870m();
                this.f9581a.mo19867j();
            }
            this.f9581a.mo19855a(num);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onReload"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseActivity.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseActivity$f */
    static final class C2870f implements OnReloadListener {
        final /* synthetic */ BaseActivity this$0;

        C2870f(BaseActivity baseActivity) {
            this.this$0 = baseActivity;
        }

        public final void onReload(View view) {
            BaseActivity.m12849b(this.this$0, false, 1, null);
            this.this$0.mo19869l();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\t¨\u0006\n"}, mo39189d2 = {"<anonymous>", "", "Binding", "Landroidx/databinding/ViewDataBinding;", "T", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/jiayouya/travel/common/base/BaseActivity$setupToolbar$1$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseActivity.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseActivity$g */
    static final class C2871g implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ BaseActivity f9582a;

        C2871g(BaseActivity baseActivity) {
            this.f9582a = baseActivity;
        }

        public final void onClick(View view) {
            this.f9582a.onBackPressed();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0001*\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "T", "Binding", "Landroidx/databinding/ViewDataBinding;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "invoke", "()Lcom/jiayouya/travel/common/base/BaseViewModel;"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BaseActivity.kt */
    /* renamed from: com.jiayouya.travel.common.base.BaseActivity$h */
    static final class C2872h extends Lambda implements C8246a<T> {
        final /* synthetic */ BaseActivity this$0;

        C2872h(BaseActivity baseActivity) {
            this.this$0 = baseActivity;
            super(0);
        }

        public final T invoke() {
            return (BaseViewModel) ViewModelProviders.m16of((FragmentActivity) this.this$0).get(this.this$0.mo19861d());
        }
    }

    static {
        Class<BaseActivity> cls = BaseActivity.class;
        f9569a = new C8280j[]{C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "vm", "getVm()Lcom/jiayouya/travel/common/base/BaseViewModel;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "immersionBar", "getImmersionBar()Lcom/gyf/barlibrary/ImmersionBar;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "loadingDialog", "getLoadingDialog()Lcom/jiayouya/travel/common/widget/LoadingDialog;"))};
    }

    /* renamed from: q */
    private final LoadingDialog m12850q() {
        Lazy bVar = this.f9577i;
        C8280j jVar = f9569a[2];
        return (LoadingDialog) bVar.getValue();
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f9579k == null) {
            this.f9579k = new HashMap();
        }
        View view = (View) this.f9579k.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f9579k.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: a */
    public final T mo19853a() {
        Lazy bVar = this.f9571c;
        C8280j jVar = f9569a[0];
        return (BaseViewModel) bVar.getValue();
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
    }

    /* renamed from: a */
    public void mo19855a(@LoadingType Integer num) {
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: c */
    public final ImmersionBar mo19859c() {
        Lazy bVar = this.f9576h;
        C8280j jVar = f9569a[1];
        return (ImmersionBar) bVar.getValue();
    }

    /* renamed from: d */
    public abstract Class<T> mo19861d();

    /* renamed from: f */
    public abstract int mo19863f();

    /* renamed from: h */
    public boolean mo19865h() {
        return false;
    }

    /* renamed from: i */
    public boolean mo19866i() {
        return false;
    }

    /* renamed from: k */
    public void mo19868k() {
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final Binding mo19857b() {
        Binding binding = this.f9570b;
        if (binding == null) {
            C8271i.m35387b("binding");
        }
        return binding;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo19856a(boolean z) {
        this.f9575g = z;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ARouter.m2127a().mo10489a((Object) this);
        Binding contentView = DataBindingUtil.setContentView(this, mo19863f());
        C8271i.m35382a((Object) contentView, "DataBindingUtil.setConte…View(this, getLayoutId())");
        this.f9570b = contentView;
        m12852s();
        mo19854a(bundle);
        mo19862e();
        mo19868k();
        mo19864g();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f9578j = false;
        AdSdk.f25896a.mo37293b().put("VIDEO_LOADING_CALL_BACK_KEY", m12851r());
    }

    /* renamed from: r */
    private final C8263r<String, Integer, Integer, Object, Unit> m12851r() {
        return new C2868d<>(this);
    }

    /* renamed from: e */
    public void mo19862e() {
        View findViewById = findViewById(R.id.status_view);
        if (findViewById == null) {
            findViewById = this.f9572d;
        }
        if (findViewById != null) {
            mo19859c().titleBar(findViewById);
        }
        mo19859c().statusBarDarkFont(this.f9575g).init();
    }

    /* renamed from: s */
    private final void m12852s() {
        this.f9572d = (Toolbar) findViewById(R.id.toolbar);
        Toolbar toolbar = this.f9572d;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new C2871g(this));
        }
    }

    /* renamed from: g */
    public void mo19864g() {
        mo19853a().mo19904a().observe(this, new C2869e(this));
    }

    /* renamed from: j */
    public void mo19867j() {
        View findViewById = findViewById(R.id.refresh);
        if (findViewById instanceof SmartRefreshLayout) {
            ((SmartRefreshLayout) findViewById).mo30890g();
        }
    }

    public final void setupStatusView(View view) {
        C8271i.m35386b(view, "normalStatusView");
        this.f9573e = LoadSir.m14996a().mo22631a((Object) view, (OnReloadListener) new C2870f(this));
    }

    /* renamed from: l */
    public void mo19869l() {
        m12847a(this, false, 1, null);
    }

    /* renamed from: a */
    public static /* synthetic */ void m12847a(BaseActivity baseActivity, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            baseActivity.mo19858b(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchData");
    }

    /* renamed from: m */
    public final void mo19870m() {
        LoadService<?> bVar = this.f9573e;
        if (bVar != null) {
            bVar.mo22629a();
        }
    }

    /* renamed from: n */
    public final void mo19871n() {
        LoadService<?> bVar = this.f9573e;
        if (bVar != null) {
            LoadSirEx.m12821a(bVar);
        }
    }

    /* renamed from: o */
    public final void mo19872o() {
        LoadService<?> bVar = this.f9573e;
        if (bVar != null) {
            LoadSirEx.m12822b(bVar);
        }
    }

    /* renamed from: b */
    public static /* synthetic */ void m12849b(BaseActivity baseActivity, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            baseActivity.mo19860c(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoading");
    }

    /* renamed from: c */
    public final void mo19860c(boolean z) {
        if (!z) {
            LoadService<?> bVar = this.f9573e;
            if (bVar != null) {
                LoadSirEx.m12823c(bVar);
            }
        } else if (!m12850q().isShowing()) {
            m12850q().show();
        }
    }

    /* renamed from: p */
    public final void mo19873p() {
        try {
            if (!this.f9578j && m12850q().isShowing()) {
                m12850q().dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f9574f) {
            mo19859c().destroy();
        }
    }

    public Resources getResources() {
        runOnUiThread(new C2865a(this));
        Resources resources = super.getResources();
        C8271i.m35382a((Object) resources, "super.getResources()");
        return resources;
    }
}
