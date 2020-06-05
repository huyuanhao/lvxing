package com.jiayouya.travel.module.common.p260vm;

import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.Launcher;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p257a.C2962j;
import ezy.app.p643a.API;
import ezy.app.p645rx.C8019a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;
import p681me.jessyan.retrofiturlmanager.RetrofitUrlManager;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\r\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00120\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u001cJK\u0010\u001d\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142%\b\u0002\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00162\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010 J\u001a\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010#\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007¨\u0006$"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/vm/ResidentMemoryModel;", "Landroidx/lifecycle/ViewModel;", "()V", "coin", "Landroidx/lifecycle/MutableLiveData;", "", "getCoin", "()Landroidx/lifecycle/MutableLiveData;", "isNeedBindCode", "", "uid", "Landroidx/lifecycle/MediatorLiveData;", "", "getUid", "()Landroidx/lifecycle/MediatorLiveData;", "user", "Lcom/jiayouya/travel/module/common/data/User;", "getUser", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "refreshCoin", "coinValue", "type", "", "refreshUser", "onSucceed", "onFail", "Lkotlin/Function0;", "setGlobalDomain", "host", "isSavePreference", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ResidentMemoryModel.kt */
/* renamed from: com.jiayouya.travel.module.common.vm.ResidentMemoryModel */
public final class ResidentMemoryModel extends ViewModel {
    /* renamed from: a */
    public static final ResidentMemoryModel f11323a = new ResidentMemoryModel();
    /* renamed from: b */
    private static final MutableLiveData<Double> f11324b = new MutableLiveData<>();
    /* renamed from: c */
    private static final MutableLiveData<User> f11325c = new MutableLiveData<>();
    /* renamed from: d */
    private static final MutableLiveData<Boolean> f11326d = new MutableLiveData<>();
    /* renamed from: e */
    private static final MediatorLiveData<String> f11327e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/User;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ResidentMemoryModel.kt */
    /* renamed from: com.jiayouya.travel.module.common.vm.ResidentMemoryModel$a */
    static final class C2981a extends Lambda implements C8247b<User, Unit> {
        final /* synthetic */ C8247b $action;

        C2981a(C8247b bVar) {
            this.$action = bVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((User) obj);
            return Unit.f27778a;
        }

        public final void invoke(User user) {
            C8271i.m35386b(user, "it");
            this.$action.invoke(user.getUid());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ResidentMemoryModel.kt */
    /* renamed from: com.jiayouya.travel.module.common.vm.ResidentMemoryModel$b */
    static final class C2982b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ double f11328a;
        /* renamed from: b */
        final /* synthetic */ int f11329b;

        C2982b(double d, int i) {
            this.f11328a = d;
            this.f11329b = i;
        }

        public final void run() {
            Double d = (Double) ResidentMemoryModel.f11323a.mo20732a().getValue();
            if (d == null) {
                d = Double.valueOf(0.0d);
            }
            C8271i.m35382a((Object) d, "coin.value ?: 0.0");
            double doubleValue = d.doubleValue();
            int i = this.f11329b;
            if (i == 1) {
                ResidentMemoryModel.f11323a.mo20732a().setValue(Double.valueOf(doubleValue + this.f11328a));
            } else if (i != 2) {
                ResidentMemoryModel.f11323a.mo20732a().setValue(Double.valueOf(this.f11328a));
            } else {
                ResidentMemoryModel.f11323a.mo20732a().setValue(Double.valueOf(Math.max(doubleValue - this.f11328a, 0.0d)));
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/User;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ResidentMemoryModel.kt */
    /* renamed from: com.jiayouya.travel.module.common.vm.ResidentMemoryModel$c */
    static final class C2983c<T> implements Consumer<User> {
        /* renamed from: a */
        final /* synthetic */ C8247b f11330a;

        C2983c(C8247b bVar) {
            this.f11330a = bVar;
        }

        /* renamed from: a */
        public final void accept(User user) {
            ResidentMemoryModel.m13598a(ResidentMemoryModel.f11323a, user.getHost(), false, 2, (Object) null);
            C8247b bVar = this.f11330a;
            if (bVar != null) {
                C8271i.m35382a((Object) user, "it");
                Unit jVar = (Unit) bVar.invoke(user);
            }
            ResidentMemoryModel.f11323a.mo20737b().postValue(user);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/User;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ResidentMemoryModel.kt */
    /* renamed from: com.jiayouya.travel.module.common.vm.ResidentMemoryModel$d */
    static final class C2984d<T> implements Consumer<User> {
        /* renamed from: a */
        final /* synthetic */ C8247b f11331a;

        C2984d(C8247b bVar) {
            this.f11331a = bVar;
        }

        /* renamed from: a */
        public final void accept(final User user) {
            Launcher.f9545a.mo19814a().post(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ C2984d f11332a;

                {
                    this.f11332a = r1;
                }

                public final void run() {
                    ResidentMemoryModel.m13598a(ResidentMemoryModel.f11323a, user.getHost(), false, 2, (Object) null);
                    C8247b bVar = this.f11332a.f11331a;
                    if (bVar != null) {
                        User user = user;
                        C8271i.m35382a((Object) user, "it");
                        Unit jVar = (Unit) bVar.invoke(user);
                    }
                    ResidentMemoryModel.f11323a.mo20737b().postValue(user);
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ResidentMemoryModel.kt */
    /* renamed from: com.jiayouya.travel.module.common.vm.ResidentMemoryModel$e */
    static final class C2986e<T> implements Consumer<Throwable> {
        /* renamed from: a */
        final /* synthetic */ C8246a f11334a;

        C2986e(C8246a aVar) {
            this.f11334a = aVar;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            Launcher.f9545a.mo19814a().post(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ C2986e f11335a;

                {
                    this.f11335a = r1;
                }

                public final void run() {
                    C8246a aVar = this.f11335a.f11334a;
                    if (aVar != null) {
                        Unit jVar = (Unit) aVar.invoke();
                    }
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/User;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ResidentMemoryModel.kt */
    /* renamed from: com.jiayouya.travel.module.common.vm.ResidentMemoryModel$f */
    static final class C2988f<T> implements Observer<S> {
        /* renamed from: a */
        final /* synthetic */ MediatorLiveData f11336a;

        C2988f(MediatorLiveData mediatorLiveData) {
            this.f11336a = mediatorLiveData;
        }

        /* renamed from: a */
        public final void onChanged(User user) {
            String str = null;
            if (!C8271i.m35384a(user != null ? user.getUid() : null, (Object) (String) this.f11336a.getValue())) {
                MediatorLiveData mediatorLiveData = this.f11336a;
                if (user != null) {
                    str = user.getUid();
                }
                mediatorLiveData.setValue(str);
            }
        }
    }

    static {
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(f11325c, new C2988f(mediatorLiveData));
        f11327e = mediatorLiveData;
    }

    private ResidentMemoryModel() {
    }

    /* renamed from: a */
    public final MutableLiveData<Double> mo20732a() {
        return f11324b;
    }

    /* renamed from: b */
    public final MutableLiveData<User> mo20737b() {
        return f11325c;
    }

    /* renamed from: c */
    public final MutableLiveData<Boolean> mo20738c() {
        return f11326d;
    }

    /* renamed from: d */
    public final MediatorLiveData<String> mo20739d() {
        return f11327e;
    }

    /* renamed from: a */
    public static /* synthetic */ void m13598a(ResidentMemoryModel residentMemoryModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        residentMemoryModel.mo20736a(str, z);
    }

    /* renamed from: a */
    public final void mo20736a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("setGlobalDomain host==");
            sb.append(str);
            XLog.m12692b(sb.toString());
            RetrofitUrlManager.getInstance().setGlobalDomain(str);
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m13596a(ResidentMemoryModel residentMemoryModel, AppCompatActivity appCompatActivity, C8247b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            appCompatActivity = null;
        }
        residentMemoryModel.mo20734a(appCompatActivity, bVar);
    }

    /* renamed from: a */
    public final void mo20734a(AppCompatActivity appCompatActivity, C8247b<? super String, Unit> bVar) {
        C8271i.m35386b(bVar, "action");
        String str = (String) f11327e.getValue();
        if (str == null) {
            str = "";
        }
        C8271i.m35382a((Object) str, "uid.value ?: \"\"");
        if (TextUtils.isEmpty(str)) {
            m13597a(this, appCompatActivity, new C2981a(bVar), null, 4, null);
            return;
        }
        bVar.invoke(str);
    }

    /* renamed from: a */
    public static /* synthetic */ void m13597a(ResidentMemoryModel residentMemoryModel, AppCompatActivity appCompatActivity, C8247b bVar, C8246a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            appCompatActivity = null;
        }
        if ((i & 2) != 0) {
            bVar = null;
        }
        if ((i & 4) != 0) {
            aVar = null;
        }
        residentMemoryModel.mo20735a(appCompatActivity, bVar, aVar);
    }

    /* renamed from: a */
    public final void mo20735a(AppCompatActivity appCompatActivity, C8247b<? super User, Unit> bVar, C8246a<Unit> aVar) {
        Observable a = C2962j.m13561a(API.f27251a).mo20417a().mo38884a((Consumer<? super Throwable>) new C2986e<Object>(aVar));
        if (appCompatActivity != null) {
            C8271i.m35382a((Object) a, "observable");
            C8019a.m34778a(a, appCompatActivity, null, 2, null).mo37374a(new C2983c(bVar));
            return;
        }
        a.mo38904c((Consumer<? super T>) new C2984d<Object>(bVar));
    }

    /* renamed from: a */
    public final synchronized void mo20733a(double d, int i) {
        Launcher.f9545a.mo19814a().post(new C2982b(d, i));
    }
}
