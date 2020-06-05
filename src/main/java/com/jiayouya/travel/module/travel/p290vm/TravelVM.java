package com.jiayouya.travel.module.travel.p290vm;

import androidx.lifecycle.MutableLiveData;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.C2914d;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.data.AdRsp;
import com.jiayouya.travel.module.common.data.Resource;
import com.jiayouya.travel.module.common.data.Resource.Companion;
import com.jiayouya.travel.module.explore.data.ExploreDoor;
import com.jiayouya.travel.module.explore.p263a.C2994b;
import com.jiayouya.travel.module.travel.data.BagInfo;
import com.jiayouya.travel.module.travel.data.BuyDogRsp;
import com.jiayouya.travel.module.travel.data.ClaimFreeCoinRsp;
import com.jiayouya.travel.module.travel.data.DogHomeRsp;
import com.jiayouya.travel.module.travel.data.DogInfo;
import com.jiayouya.travel.module.travel.data.DogShopItem;
import com.jiayouya.travel.module.travel.data.GameIndex;
import com.jiayouya.travel.module.travel.data.IndexPop;
import com.jiayouya.travel.module.travel.data.LoversMerge;
import com.jiayouya.travel.module.travel.data.LuckPoolRsp;
import com.jiayouya.travel.module.travel.data.MergeBonusDogItem;
import com.jiayouya.travel.module.travel.data.MergeDialExtra;
import com.jiayouya.travel.module.travel.data.MergeDialItem;
import com.jiayouya.travel.module.travel.data.MergeDogRsp;
import com.jiayouya.travel.module.travel.data.MergeSuper;
import com.jiayouya.travel.module.travel.data.PositionItem;
import com.jiayouya.travel.module.travel.data.RecycleDogRsp;
import com.jiayouya.travel.module.travel.p285a.C3322b;
import com.jiayouya.travel.module.travel.p285a.C3324d;
import com.jiayouya.travel.module.travel.p285a.GameService.C3323a;
import ezy.app.p643a.API;
import ezy.app.p643a.Session;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import okhttp3.C8364ac;
import p655io.reactivex.Observable;
import p655io.reactivex.ObservableSource;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.C8083a;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0010J\u0006\u0010N\u001a\u00020LJ\u000e\u0010O\u001a\u00020L2\u0006\u0010P\u001a\u00020\u0010J\u0006\u0010Q\u001a\u00020LJ\u0006\u0010R\u001a\u00020LJ\u0010\u0010S\u001a\u00020L2\b\b\u0002\u0010T\u001a\u00020(J\u000e\u0010U\u001a\u00020L2\u0006\u0010V\u001a\u00020\u0010J\u000e\u0010W\u001a\u00020L2\u0006\u0010P\u001a\u00020\u0010J\u000e\u0010X\u001a\u00020L2\u0006\u0010P\u001a\u00020\u0010J\u0006\u0010Y\u001a\u00020LJ\u0006\u0010Z\u001a\u00020LJ\u0006\u0010[\u001a\u00020LJ\u0016\u0010\\\u001a\u00020L2\u0006\u0010]\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u0010J\u0006\u0010_\u001a\u00020LJ\u0012\u0010`\u001a\u00020L2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010bJ\u0016\u0010c\u001a\u00020L2\u0006\u0010]\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u0010J\u000e\u0010d\u001a\u00020L2\u0006\u0010e\u001a\u00020fJ\u0016\u0010g\u001a\u00020L2\u0006\u0010]\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u0010J\b\u0010h\u001a\u00020LH\u0014J\u0006\u0010i\u001a\u00020LJ\u0010\u0010j\u001a\u00020L2\u0006\u0010k\u001a\u00020%H\u0002J\u000e\u0010l\u001a\u00020L2\u0006\u0010V\u001a\u00020\u0010J\u0010\u0010m\u001a\u00020L2\b\b\u0002\u0010n\u001a\u00020(J\u000e\u0010o\u001a\u00020L2\u0006\u0010P\u001a\u00020\u0010R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\bR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\bR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\bR#\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000204030\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\bR\u001d\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\bR\u001d\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\bR\u001d\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c030\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\bR\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\bR\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\bR\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\bR\u000e\u0010G\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R#\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I030\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\b¨\u0006p"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/vm/TravelVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "adData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/common/data/Resource;", "Lcom/jiayouya/travel/module/common/data/AdRsp;", "getAdData", "()Landroidx/lifecycle/MutableLiveData;", "bagInfoData", "Lcom/jiayouya/travel/module/travel/data/BagInfo;", "getBagInfoData", "buyDogData", "Lcom/jiayouya/travel/module/travel/data/BuyDogRsp;", "getBuyDogData", "coinRetryCount", "", "dis", "Lio/reactivex/disposables/Disposable;", "dogHomeData", "Lcom/jiayouya/travel/module/travel/data/DogHomeRsp;", "getDogHomeData", "dogInBagData", "getDogInBagData", "dogInfoData", "Lcom/jiayouya/travel/module/travel/data/DogInfo;", "getDogInfoData", "dogOutBagData", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "getDogOutBagData", "exploreDoorData", "Lcom/jiayouya/travel/module/explore/data/ExploreDoor;", "getExploreDoorData", "freeCoinData", "Lcom/jiayouya/travel/module/travel/data/ClaimFreeCoinRsp;", "getFreeCoinData", "gameIndexData", "Lcom/jiayouya/travel/module/travel/data/GameIndex;", "getGameIndexData", "isFirstInit", "", "()Z", "setFirstInit", "(Z)V", "isLoading", "lastTime", "", "loversMergeData", "Lcom/jiayouya/travel/module/travel/data/LoversMerge;", "getLoversMergeData", "mergeDialData", "", "Lcom/jiayouya/travel/module/travel/data/MergeDialItem;", "getMergeDialData", "mergeDogData", "Lcom/jiayouya/travel/module/travel/data/MergeDogRsp;", "getMergeDogData", "mergeSuperData", "Lcom/jiayouya/travel/module/travel/data/MergeSuper;", "getMergeSuperData", "moveDogData", "getMoveDogData", "poolData", "Lcom/jiayouya/travel/module/travel/data/LuckPoolRsp;", "getPoolData", "popData", "Lcom/jiayouya/travel/module/travel/data/IndexPop;", "getPopData", "recycleData", "Lcom/jiayouya/travel/module/travel/data/RecycleDogRsp;", "getRecycleData", "retryCount", "shopData", "Lcom/jiayouya/travel/module/travel/data/DogShopItem;", "getShopData", "ad", "", "scene", "bagInfo", "buyDog", "dogId", "claimFreeCoin", "dispose", "dogHome", "isOnlyProcessSuggestBuy", "dogInBag", "position", "dogInfo", "dogOutBag", "exploreDoor", "gameIndex", "homeSummary", "loversMerge", "p1", "p2", "luckPool", "mergeDial", "extra", "Lcom/jiayouya/travel/module/travel/data/MergeDialExtra;", "mergeDog", "mergeSuper", "item", "Lcom/jiayouya/travel/module/travel/data/MergeBonusDogItem;", "moveDog", "onCleared", "pop", "processGameIndex", "it", "recycle", "shop", "isShowDialog", "walkDogId", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TravelVM.kt */
/* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM */
public final class TravelVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<Resource<List<DogShopItem>>> f12159a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<RecycleDogRsp> f12160b = new MutableLiveData<>();
    /* renamed from: c */
    private final MutableLiveData<BuyDogRsp> f12161c = new MutableLiveData<>();
    /* renamed from: d */
    private final MutableLiveData<Resource<DogHomeRsp>> f12162d = new MutableLiveData<>();
    /* renamed from: e */
    private final MutableLiveData<Resource<MergeDogRsp>> f12163e = new MutableLiveData<>();
    /* renamed from: f */
    private final MutableLiveData<List<PositionItem>> f12164f = new MutableLiveData<>();
    /* renamed from: g */
    private Disposable f12165g;
    /* renamed from: h */
    private final MutableLiveData<GameIndex> f12166h = new MutableLiveData<>();
    /* access modifiers changed from: private */
    /* renamed from: i */
    public int f12167i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public boolean f12168j;
    /* renamed from: k */
    private boolean f12169k = true;
    /* renamed from: l */
    private long f12170l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public int f12171m;
    /* renamed from: n */
    private final MutableLiveData<LuckPoolRsp> f12172n = new MutableLiveData<>();
    /* renamed from: o */
    private final MutableLiveData<ClaimFreeCoinRsp> f12173o = new MutableLiveData<>();
    /* renamed from: p */
    private final MutableLiveData<Resource<AdRsp>> f12174p = new MutableLiveData<>();
    /* renamed from: q */
    private final MutableLiveData<IndexPop> f12175q = new MutableLiveData<>();
    /* renamed from: r */
    private final MutableLiveData<DogInfo> f12176r = new MutableLiveData<>();
    /* renamed from: s */
    private final MutableLiveData<Resource<List<MergeDialItem>>> f12177s = new MutableLiveData<>();
    /* renamed from: t */
    private final MutableLiveData<Resource<LoversMerge>> f12178t = new MutableLiveData<>();
    /* renamed from: u */
    private final MutableLiveData<Resource<MergeSuper>> f12179u = new MutableLiveData<>();
    /* renamed from: v */
    private final MutableLiveData<BagInfo> f12180v = new MutableLiveData<>();
    /* renamed from: w */
    private final MutableLiveData<Integer> f12181w = new MutableLiveData<>();
    /* renamed from: x */
    private final MutableLiveData<PositionItem> f12182x = new MutableLiveData<>();
    /* renamed from: y */
    private final MutableLiveData<ExploreDoor> f12183y = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/BagInfo;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$a */
    static final class C3522a<T> implements Consumer<BagInfo> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12184a;

        C3522a(TravelVM travelVM) {
            this.f12184a = travelVM;
        }

        /* renamed from: a */
        public final void accept(BagInfo bagInfo) {
            this.f12184a.mo22455w().postValue(bagInfo);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$aa */
    static final class C3523aa<T> implements Consumer<Throwable> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12185a;

        C3523aa(TravelVM travelVM) {
            this.f12185a = travelVM;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            TravelVM.m14824a(this.f12185a, false, 1, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/RecycleDogRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$ab */
    static final class C3524ab<T> implements Consumer<RecycleDogRsp> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12186a;

        C3524ab(TravelVM travelVM) {
            this.f12186a = travelVM;
        }

        /* renamed from: a */
        public final void accept(RecycleDogRsp recycleDogRsp) {
            this.f12186a.mo22429c().postValue(recycleDogRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "Lcom/jiayouya/travel/module/travel/data/DogShopItem;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$ac */
    static final class C3525ac<T> implements Consumer<List<? extends DogShopItem>> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12187a;
        /* renamed from: b */
        final /* synthetic */ boolean f12188b;

        C3525ac(TravelVM travelVM, boolean z) {
            this.f12187a = travelVM;
            this.f12188b = z;
        }

        /* renamed from: a */
        public final void accept(List<DogShopItem> list) {
            this.f12187a.mo22425b().postValue(Companion.success$default(Resource.Companion, list, false, Boolean.valueOf(this.f12188b), 2, null));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/BuyDogRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$b */
    static final class C3526b<T> implements Consumer<BuyDogRsp> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12189a;

        C3526b(TravelVM travelVM) {
            this.f12189a = travelVM;
        }

        /* renamed from: a */
        public final void accept(BuyDogRsp buyDogRsp) {
            this.f12189a.mo22433d().postValue(buyDogRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/ClaimFreeCoinRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$c */
    static final class C3527c<T> implements Consumer<ClaimFreeCoinRsp> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12190a;

        C3527c(TravelVM travelVM) {
            this.f12190a = travelVM;
        }

        /* renamed from: a */
        public final void accept(ClaimFreeCoinRsp claimFreeCoinRsp) {
            this.f12190a.mo22447o().postValue(claimFreeCoinRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/DogHomeRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$d */
    static final class C3528d<T> implements Consumer<DogHomeRsp> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12191a;
        /* renamed from: b */
        final /* synthetic */ boolean f12192b;

        C3528d(TravelVM travelVM, boolean z) {
            this.f12191a = travelVM;
            this.f12192b = z;
        }

        /* renamed from: a */
        public final void accept(DogHomeRsp dogHomeRsp) {
            this.f12191a.mo22435e().postValue(Companion.success$default(Resource.Companion, dogHomeRsp, false, Boolean.valueOf(this.f12192b), 2, null));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$e */
    static final class C3529e<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12193a;
        /* renamed from: b */
        final /* synthetic */ int f12194b;

        C3529e(TravelVM travelVM, int i) {
            this.f12193a = travelVM;
            this.f12194b = i;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            this.f12193a.mo22457y().postValue(Integer.valueOf(this.f12194b));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/DogInfo;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$f */
    static final class C3530f<T> implements Consumer<DogInfo> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12195a;

        C3530f(TravelVM travelVM) {
            this.f12195a = travelVM;
        }

        /* renamed from: a */
        public final void accept(DogInfo dogInfo) {
            this.f12195a.mo22451s().postValue(dogInfo);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$g */
    static final class C3531g<T> implements Consumer<PositionItem> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12196a;

        C3531g(TravelVM travelVM) {
            this.f12196a = travelVM;
        }

        /* renamed from: a */
        public final void accept(PositionItem positionItem) {
            this.f12196a.mo22458z().postValue(positionItem);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/explore/data/ExploreDoor;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$h */
    static final class C3532h<T> implements Consumer<ExploreDoor> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12197a;

        C3532h(TravelVM travelVM) {
            this.f12197a = travelVM;
        }

        /* renamed from: a */
        public final void accept(ExploreDoor exploreDoor) {
            this.f12197a.mo22418A().postValue(exploreDoor);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$i */
    static final class C3533i<T> implements Consumer<Throwable> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12198a;

        C3533i(TravelVM travelVM) {
            this.f12198a = travelVM;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            if (!Session.f27256a.mo38540c()) {
                C2914d.m13180a((Runnable) new Runnable(this) {
                    /* renamed from: a */
                    final /* synthetic */ C3533i f12199a;

                    {
                        this.f12199a = r1;
                    }

                    public final void run() {
                        this.f12199a.f12198a.mo22441i();
                    }
                }, ((long) PathInterpolatorCompat.MAX_NUM_POINTS) + (((long) this.f12198a.f12167i) * 3000));
                TravelVM travelVM = this.f12198a;
                travelVM.f12167i = travelVM.f12167i + 1;
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$j */
    static final class C3535j implements C8083a {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12200a;

        C3535j(TravelVM travelVM) {
            this.f12200a = travelVM;
        }

        /* renamed from: a */
        public final void mo19849a() {
            this.f12200a.f12167i = 0;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/GameIndex;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$k */
    static final class C3536k<T> implements Consumer<GameIndex> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12201a;

        C3536k(TravelVM travelVM) {
            this.f12201a = travelVM;
        }

        /* renamed from: a */
        public final void accept(GameIndex gameIndex) {
            TravelVM travelVM = this.f12201a;
            C8271i.m35382a((Object) gameIndex, "it");
            travelVM.m14820a(gameIndex);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$l */
    static final class C3537l<T> implements Consumer<Throwable> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12202a;

        C3537l(TravelVM travelVM) {
            this.f12202a = travelVM;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            if (!Session.f27256a.mo38540c()) {
                StringBuilder sb = new StringBuilder();
                sb.append("homeSummary doOnError isFirstInit==");
                sb.append(this.f12202a.mo22442j());
                XLog.m12691a(sb.toString());
                if (this.f12202a.mo22442j()) {
                    TravelVM travelVM = this.f12202a;
                    int b = travelVM.f12171m;
                    travelVM.f12171m = b + 1;
                    if (b < 3) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("homeSummary doOnError retryCount==");
                        sb2.append(this.f12202a.f12171m);
                        XLog.m12691a(sb2.toString());
                        C2914d.m13180a((Runnable) new Runnable(this) {
                            /* renamed from: a */
                            final /* synthetic */ C3537l f12203a;

                            {
                                this.f12203a = r1;
                            }

                            public final void run() {
                                this.f12203a.f12202a.mo22443k();
                            }
                        }, ((long) (this.f12202a.f12171m + 1)) * 1500);
                    }
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$m */
    static final class C3539m implements C8083a {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12204a;

        C3539m(TravelVM travelVM) {
            this.f12204a = travelVM;
        }

        /* renamed from: a */
        public final void mo19849a() {
            XLog.m12691a("homeSummary doFinally");
            this.f12204a.f12168j = false;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$n */
    static final class C3540n implements C8083a {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12205a;

        C3540n(TravelVM travelVM) {
            this.f12205a = travelVM;
        }

        /* renamed from: a */
        public final void mo19849a() {
            XLog.m12691a("homeSummary doOnComplete");
            this.f12205a.mo22432c(false);
            this.f12205a.f12171m = 0;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$o */
    static final class C3541o<T> implements Consumer<Object> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12206a;

        C3541o(TravelVM travelVM) {
            this.f12206a = travelVM;
        }

        public final void accept(Object obj) {
            XLog.m12691a("homeSummary subscribe");
            boolean z = obj instanceof List;
            Boolean valueOf = Boolean.valueOf(false);
            if (z) {
                List list = (List) obj;
                this.f12206a.mo22425b().postValue(Companion.success$default(Resource.Companion, obj, false, valueOf, 2, null));
            }
            if (obj instanceof GameIndex) {
                this.f12206a.m14820a((GameIndex) obj);
            }
            if (obj instanceof DogHomeRsp) {
                this.f12206a.mo22435e().postValue(Companion.success$default(Resource.Companion, obj, false, valueOf, 2, null));
            }
            if (obj instanceof IndexPop) {
                this.f12206a.mo22449q().postValue(obj);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$p */
    static final class C3542p<T> implements Consumer<Throwable> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12207a;

        C3542p(TravelVM travelVM) {
            this.f12207a = travelVM;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            TravelVM.m14824a(this.f12207a, false, 1, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/LoversMerge;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$q */
    static final class C3543q<T> implements Consumer<LoversMerge> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12208a;
        /* renamed from: b */
        final /* synthetic */ int f12209b;
        /* renamed from: c */
        final /* synthetic */ int f12210c;

        C3543q(TravelVM travelVM, int i, int i2) {
            this.f12208a = travelVM;
            this.f12209b = i;
            this.f12210c = i2;
        }

        /* renamed from: a */
        public final void accept(LoversMerge loversMerge) {
            this.f12208a.mo22453u().postValue(Companion.success$default(Resource.Companion, loversMerge, false, new int[]{this.f12209b, this.f12210c}, 2, null));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/LuckPoolRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$r */
    static final class C3544r<T> implements Consumer<LuckPoolRsp> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12211a;

        C3544r(TravelVM travelVM) {
            this.f12211a = travelVM;
        }

        /* renamed from: a */
        public final void accept(LuckPoolRsp luckPoolRsp) {
            this.f12211a.mo22445m().postValue(luckPoolRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "Lcom/jiayouya/travel/module/travel/data/MergeDialItem;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$s */
    static final class C3545s<T> implements Consumer<List<? extends MergeDialItem>> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12212a;
        /* renamed from: b */
        final /* synthetic */ MergeDialExtra f12213b;

        C3545s(TravelVM travelVM, MergeDialExtra mergeDialExtra) {
            this.f12212a = travelVM;
            this.f12213b = mergeDialExtra;
        }

        /* renamed from: a */
        public final void accept(List<MergeDialItem> list) {
            this.f12212a.mo22452t().postValue(Companion.success$default(Resource.Companion, list, false, this.f12213b, 2, null));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$t */
    static final class C3546t<T> implements Consumer<Throwable> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12214a;

        C3546t(TravelVM travelVM) {
            this.f12214a = travelVM;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            TravelVM.m14824a(this.f12214a, false, 1, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/MergeDogRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$u */
    static final class C3547u<T> implements Consumer<MergeDogRsp> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12215a;
        /* renamed from: b */
        final /* synthetic */ int f12216b;

        C3547u(TravelVM travelVM, int i) {
            this.f12215a = travelVM;
            this.f12216b = i;
        }

        /* renamed from: a */
        public final void accept(MergeDogRsp mergeDogRsp) {
            this.f12215a.mo22437f().postValue(Companion.success$default(Resource.Companion, mergeDogRsp, false, Integer.valueOf(this.f12216b), 2, null));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/MergeSuper;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$v */
    static final class C3548v<T> implements Consumer<MergeSuper> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12217a;
        /* renamed from: b */
        final /* synthetic */ MergeBonusDogItem f12218b;

        C3548v(TravelVM travelVM, MergeBonusDogItem mergeBonusDogItem) {
            this.f12217a = travelVM;
            this.f12218b = mergeBonusDogItem;
        }

        /* renamed from: a */
        public final void accept(MergeSuper mergeSuper) {
            this.f12217a.mo22454v().postValue(Companion.success$default(Resource.Companion, mergeSuper, false, this.f12218b, 2, null));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$w */
    static final class C3549w<T> implements Consumer<Throwable> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12219a;

        C3549w(TravelVM travelVM) {
            this.f12219a = travelVM;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            TravelVM.m14824a(this.f12219a, false, 1, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$x */
    static final class C3550x<T> implements Consumer<List<? extends PositionItem>> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12220a;

        C3550x(TravelVM travelVM) {
            this.f12220a = travelVM;
        }

        /* renamed from: a */
        public final void accept(List<PositionItem> list) {
            this.f12220a.mo22439g().postValue(list);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/IndexPop;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$y */
    static final class C3551y<T> implements Consumer<IndexPop> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12221a;

        C3551y(TravelVM travelVM) {
            this.f12221a = travelVM;
        }

        /* renamed from: a */
        public final void accept(IndexPop indexPop) {
            this.f12221a.mo22449q().postValue(indexPop);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Integer;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.TravelVM$z */
    static final class C3552z<T> implements Consumer<Integer> {
        /* renamed from: a */
        final /* synthetic */ TravelVM f12222a;

        C3552z(TravelVM travelVM) {
            this.f12222a = travelVM;
        }

        /* renamed from: a */
        public final void accept(Integer num) {
            if (!Session.f27256a.mo38540c()) {
                this.f12222a.mo22450r();
                this.f12222a.mo22424a(false);
                this.f12222a.mo22441i();
            }
        }
    }

    /* renamed from: b */
    public final MutableLiveData<Resource<List<DogShopItem>>> mo22425b() {
        return this.f12159a;
    }

    /* renamed from: c */
    public final MutableLiveData<RecycleDogRsp> mo22429c() {
        return this.f12160b;
    }

    /* renamed from: a */
    public final void mo22424a(boolean z) {
        Observable a = C3324d.m14443a(API.f27251a).mo21623a();
        if (z) {
            a = ObservableEx.m12824a(a, mo19904a());
        }
        a.mo38904c((Consumer<? super T>) new C3525ac<Object>(this, z));
    }

    /* renamed from: a */
    public final void mo22420a(int i) {
        C3324d.m14443a(API.f27251a).mo21624a(i).mo38884a((Consumer<? super Throwable>) new C3523aa<Object>(this)).mo38904c((Consumer<? super T>) new C3524ab<Object>(this));
    }

    /* renamed from: d */
    public final MutableLiveData<BuyDogRsp> mo22433d() {
        return this.f12161c;
    }

    /* renamed from: e */
    public final MutableLiveData<Resource<DogHomeRsp>> mo22435e() {
        return this.f12162d;
    }

    /* renamed from: f */
    public final MutableLiveData<Resource<MergeDogRsp>> mo22437f() {
        return this.f12163e;
    }

    /* renamed from: g */
    public final MutableLiveData<List<PositionItem>> mo22439g() {
        return this.f12164f;
    }

    /* renamed from: a */
    public static /* synthetic */ void m14824a(TravelVM travelVM, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        travelVM.mo22428b(z);
    }

    /* renamed from: b */
    public final void mo22428b(boolean z) {
        C3324d.m14443a(API.f27251a).mo21629b().mo38904c((Consumer<? super T>) new C3528d<Object>(this, z));
    }

    /* renamed from: h */
    public final MutableLiveData<GameIndex> mo22440h() {
        return this.f12166h;
    }

    /* renamed from: i */
    public final void mo22441i() {
        C3324d.m14443a(API.f27251a).mo21633c().mo38884a((Consumer<? super Throwable>) new C3533i<Object>(this)).mo38898b((C8083a) new C3535j(this)).mo38904c((Consumer<? super T>) new C3536k<Object>(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14820a(GameIndex gameIndex) {
        mo22444l();
        this.f12165g = Observable.m34996a(Integer.valueOf(0)).mo38897b(gameIndex.getSeconds(), TimeUnit.SECONDS).mo38904c((Consumer<? super T>) new C3552z<Object>(this));
        this.f12166h.postValue(gameIndex);
    }

    /* renamed from: c */
    public final void mo22432c(boolean z) {
        this.f12169k = z;
    }

    /* renamed from: j */
    public final boolean mo22442j() {
        return this.f12169k;
    }

    /* renamed from: k */
    public final void mo22443k() {
        Observable iVar;
        if (System.currentTimeMillis() - this.f12170l >= ((long) 1000)) {
            this.f12170l = System.currentTimeMillis();
            if (!this.f12168j) {
                this.f12168j = true;
                if (this.f12169k) {
                    iVar = Observable.m34995a((ObservableSource<? extends T>) C3324d.m14443a(API.f27251a).mo21623a(), (ObservableSource<? extends T>) C3324d.m14443a(API.f27251a).mo21633c(), (ObservableSource<? extends T>) C3324d.m14443a(API.f27251a).mo21629b(), (ObservableSource<? extends T>) C3324d.m14443a(API.f27251a).mo21643g());
                } else {
                    iVar = C3324d.m14443a(API.f27251a).mo21629b();
                }
                iVar.mo38884a((Consumer<? super Throwable>) new C3537l<Object>(this)).mo38883a((C8083a) new C3539m(this)).mo38898b((C8083a) new C3540n(this)).mo38904c((Consumer<? super T>) new C3541o<Object>(this));
            }
        }
    }

    /* renamed from: l */
    public final void mo22444l() {
        Disposable bVar = this.f12165g;
        if (bVar != null && !bVar.isDisposed()) {
            Disposable bVar2 = this.f12165g;
            if (bVar2 != null) {
                bVar2.dispose();
            }
        }
    }

    /* renamed from: b */
    public final void mo22426b(int i) {
        C3323a.m14442a(C3324d.m14443a(API.f27251a), i, null, 2, null).mo38904c((Consumer<? super T>) new C3526b<Object>(this));
    }

    /* renamed from: a */
    public final void mo22421a(int i, int i2) {
        C3324d.m14443a(API.f27251a).mo21631b(i, i2).mo38884a((Consumer<? super Throwable>) new C3546t<Object>(this)).mo38904c((Consumer<? super T>) new C3547u<Object>(this, i2));
    }

    /* renamed from: b */
    public final void mo22427b(int i, int i2) {
        C3324d.m14443a(API.f27251a).mo21625a(i, i2).mo38884a((Consumer<? super Throwable>) new C3549w<Object>(this)).mo38904c((Consumer<? super T>) new C3550x<Object>(this));
    }

    /* renamed from: m */
    public final MutableLiveData<LuckPoolRsp> mo22445m() {
        return this.f12172n;
    }

    /* renamed from: n */
    public final void mo22446n() {
        ObservableEx.m12824a(C3324d.m14443a(API.f27251a).mo21640e(), mo19904a()).mo38904c((Consumer<? super T>) new C3544r<Object>(this));
    }

    /* renamed from: o */
    public final MutableLiveData<ClaimFreeCoinRsp> mo22447o() {
        return this.f12173o;
    }

    /* renamed from: p */
    public final void mo22448p() {
        ObservableEx.m12824a(C3324d.m14443a(API.f27251a).mo21642f(), mo19904a()).mo38904c((Consumer<? super T>) new C3527c<Object>(this));
    }

    /* renamed from: q */
    public final MutableLiveData<IndexPop> mo22449q() {
        return this.f12175q;
    }

    /* renamed from: r */
    public final void mo22450r() {
        C3324d.m14443a(API.f27251a).mo21643g().mo38904c((Consumer<? super T>) new C3551y<Object>(this));
    }

    /* renamed from: s */
    public final MutableLiveData<DogInfo> mo22451s() {
        return this.f12176r;
    }

    /* renamed from: c */
    public final void mo22430c(int i) {
        ObservableEx.m12824a(C3324d.m14443a(API.f27251a).mo21630b(i), mo19904a()).mo38904c((Consumer<? super T>) new C3530f<Object>(this));
    }

    /* renamed from: t */
    public final MutableLiveData<Resource<List<MergeDialItem>>> mo22452t() {
        return this.f12177s;
    }

    /* renamed from: a */
    public final void mo22423a(MergeDialExtra mergeDialExtra) {
        ObservableEx.m12824a(C3324d.m14443a(API.f27251a).mo21646j(), mo19904a()).mo38904c((Consumer<? super T>) new C3545s<Object>(this, mergeDialExtra));
    }

    /* renamed from: u */
    public final MutableLiveData<Resource<LoversMerge>> mo22453u() {
        return this.f12178t;
    }

    /* renamed from: c */
    public final void mo22431c(int i, int i2) {
        C3324d.m14443a(API.f27251a).mo21635c(i, i2).mo38884a((Consumer<? super Throwable>) new C3542p<Object>(this)).mo38904c((Consumer<? super T>) new C3543q<Object>(this, i, i2));
    }

    /* renamed from: d */
    public final void mo22434d(int i) {
        C3324d.m14443a(API.f27251a).mo21634c(i).mo38910i();
    }

    /* renamed from: v */
    public final MutableLiveData<Resource<MergeSuper>> mo22454v() {
        return this.f12179u;
    }

    /* renamed from: a */
    public final void mo22422a(MergeBonusDogItem mergeBonusDogItem) {
        C8271i.m35386b(mergeBonusDogItem, "item");
        ObservableEx.m12824a(C3324d.m14443a(API.f27251a).mo21626a(mergeBonusDogItem.getYzDogIndex(), mergeBonusDogItem.getOzDogIndex(), mergeBonusDogItem.getMzDogIndex(), mergeBonusDogItem.getDyzDogIndex(), mergeBonusDogItem.getFzDogIndex()), mo19904a()).mo38904c((Consumer<? super T>) new C3548v<Object>(this, mergeBonusDogItem));
    }

    /* renamed from: w */
    public final MutableLiveData<BagInfo> mo22455w() {
        return this.f12180v;
    }

    /* renamed from: x */
    public final void mo22456x() {
        ObservableEx.m12824a(C3322b.m14416a(API.f27251a).mo21618a(), mo19904a()).mo38904c((Consumer<? super T>) new C3522a<Object>(this));
    }

    /* renamed from: y */
    public final MutableLiveData<Integer> mo22457y() {
        return this.f12181w;
    }

    /* renamed from: e */
    public final void mo22436e(int i) {
        ObservableEx.m12824a(C3322b.m14416a(API.f27251a).mo21619a(i), mo19904a()).mo38904c((Consumer<? super T>) new C3529e<Object>(this, i));
    }

    /* renamed from: z */
    public final MutableLiveData<PositionItem> mo22458z() {
        return this.f12182x;
    }

    /* renamed from: f */
    public final void mo22438f(int i) {
        ObservableEx.m12824a(C3322b.m14416a(API.f27251a).mo21621b(i), mo19904a()).mo38904c((Consumer<? super T>) new C3531g<Object>(this));
    }

    /* renamed from: A */
    public final MutableLiveData<ExploreDoor> mo22418A() {
        return this.f12183y;
    }

    /* renamed from: B */
    public final void mo22419B() {
        C2994b.m13658a(API.f27251a).mo20820c().mo38904c((Consumer<? super T>) new C3532h<Object>(this));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        mo22444l();
    }
}
