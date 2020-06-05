package com.jiayouya.travel.module.main.p275vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.p276me.data.DogProgressRsp;
import com.jiayouya.travel.module.p276me.data.MeItem;
import com.jiayouya.travel.module.p276me.data.MeMenu;
import com.jiayouya.travel.module.p276me.data.TaskItem;
import com.jiayouya.travel.module.p276me.p277a.C3109b;
import com.jiayouya.travel.module.p276me.p277a.MeService.C3108a;
import com.jiayouya.travel.module.travel.data.HbInfo;
import com.jiayouya.travel.module.travel.data.UpgradeHb;
import com.jiayouya.travel.module.travel.p285a.C3324d;
import ezy.app.p643a.API;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Ref.ObjectRef;
import p655io.reactivex.Observable;
import p655io.reactivex.ObservableSource;
import p655io.reactivex.p664d.Consumer;
import p655io.reactivex.p664d.Function;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/main/vm/MeVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "menusData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/jiayouya/travel/module/me/data/MeMenu;", "getMenusData", "()Landroidx/lifecycle/MutableLiveData;", "progressData", "Lcom/jiayouya/travel/module/me/data/DogProgressRsp;", "getProgressData", "menus", "", "progress", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MeVM.kt */
/* renamed from: com.jiayouya.travel.module.main.vm.MeVM */
public final class MeVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<List<MeMenu>> f11554a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<DogProgressRsp> f11555b = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "Lcom/jiayouya/travel/module/me/data/MeItem;", "it", "Lcom/jiayouya/travel/module/travel/data/UpgradeHb;", "apply"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MeVM.kt */
    /* renamed from: com.jiayouya.travel.module.main.vm.MeVM$a */
    static final class C3102a<T, R> implements Function<T, ObservableSource<? extends R>> {
        /* renamed from: a */
        final /* synthetic */ ObjectRef f11556a;

        C3102a(ObjectRef objectRef) {
            this.f11556a = objectRef;
        }

        /* renamed from: a */
        public final Observable<List<MeItem>> apply(UpgradeHb upgradeHb) {
            C8271i.m35386b(upgradeHb, "it");
            this.f11556a.element = upgradeHb;
            return C3108a.m13924a(C3109b.m13925a(API.f27251a), 0, 1, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "Lcom/jiayouya/travel/module/me/data/MeItem;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MeVM.kt */
    /* renamed from: com.jiayouya.travel.module.main.vm.MeVM$b */
    static final class C3103b<T> implements Consumer<List<? extends MeItem>> {
        /* renamed from: a */
        final /* synthetic */ MeVM f11557a;
        /* renamed from: b */
        final /* synthetic */ ObjectRef f11558b;

        C3103b(MeVM meVM, ObjectRef objectRef) {
            this.f11557a = meVM;
            this.f11558b = objectRef;
        }

        /* renamed from: a */
        public final void accept(List<MeItem> list) {
            List arrayList = new ArrayList();
            UpgradeHb upgradeHb = (UpgradeHb) this.f11558b.element;
            if (upgradeHb != null) {
                HbInfo hbInfo = upgradeHb.getHbInfo();
                if (hbInfo != null) {
                    arrayList.add(new TaskItem(hbInfo.getDesc(), hbInfo.getHbId(), hbInfo.getImage(), hbInfo.getTitle()));
                }
            }
            C8271i.m35382a((Object) list, "it");
            arrayList.addAll(list);
            this.f11557a.mo21188b().postValue(arrayList);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/data/DogProgressRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MeVM.kt */
    /* renamed from: com.jiayouya.travel.module.main.vm.MeVM$c */
    static final class C3104c<T> implements Consumer<DogProgressRsp> {
        /* renamed from: a */
        final /* synthetic */ MeVM f11559a;

        C3104c(MeVM meVM) {
            this.f11559a = meVM;
        }

        /* renamed from: a */
        public final void accept(DogProgressRsp dogProgressRsp) {
            this.f11559a.mo21189c().postValue(dogProgressRsp);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<List<MeMenu>> mo21188b() {
        return this.f11554a;
    }

    /* renamed from: c */
    public final MutableLiveData<DogProgressRsp> mo21189c() {
        return this.f11555b;
    }

    /* renamed from: d */
    public final void mo21190d() {
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = (UpgradeHb) null;
        Observable a = C3324d.m14443a(API.f27251a).mo21644h().mo38886a((Function<? super T, ? extends ObservableSource<? extends R>>) new C3102a<Object,Object>(objectRef));
        C8271i.m35382a((Object) a, "API.game().upgradeHb().f…PI.me().menus()\n        }");
        ObservableEx.m12825b(a, mo19904a()).mo38904c((Consumer<? super T>) new C3103b<Object>(this, objectRef));
    }

    /* renamed from: e */
    public final void mo21191e() {
        C3109b.m13925a(API.f27251a).mo21205a().mo38904c((Consumer<? super T>) new C3104c<Object>(this));
    }
}
