package com.jiayouya.travel.common.p244b;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import p655io.reactivex.Observable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.C8083a;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u001a*\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0007"}, mo39189d2 = {"useLoading", "Lio/reactivex/Observable;", "T", "loadingEvent", "Landroidx/lifecycle/MutableLiveData;", "", "useStatus", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.b.f */
public final class ObservableEx {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "T", "it", "Lio/reactivex/disposables/Disposable;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ObservableEx.kt */
    /* renamed from: com.jiayouya.travel.common.b.f$a */
    static final class C2860a<T> implements Consumer<Disposable> {
        /* renamed from: a */
        final /* synthetic */ MutableLiveData f9564a;

        C2860a(MutableLiveData mutableLiveData) {
            this.f9564a = mutableLiveData;
        }

        /* renamed from: a */
        public final void accept(Disposable bVar) {
            this.f9564a.postValue(Integer.valueOf(1));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "", "T", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ObservableEx.kt */
    /* renamed from: com.jiayouya.travel.common.b.f$b */
    static final class C2861b implements C8083a {
        /* renamed from: a */
        final /* synthetic */ MutableLiveData f9565a;

        C2861b(MutableLiveData mutableLiveData) {
            this.f9565a = mutableLiveData;
        }

        /* renamed from: a */
        public final void mo19849a() {
            this.f9565a.postValue(Integer.valueOf(0));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "T", "it", "Lio/reactivex/disposables/Disposable;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ObservableEx.kt */
    /* renamed from: com.jiayouya.travel.common.b.f$c */
    static final class C2862c<T> implements Consumer<Disposable> {
        /* renamed from: a */
        final /* synthetic */ MutableLiveData f9566a;

        C2862c(MutableLiveData mutableLiveData) {
            this.f9566a = mutableLiveData;
        }

        /* renamed from: a */
        public final void accept(Disposable bVar) {
            this.f9566a.postValue(Integer.valueOf(2));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "T", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ObservableEx.kt */
    /* renamed from: com.jiayouya.travel.common.b.f$d */
    static final class C2863d<T> implements Consumer<Throwable> {
        /* renamed from: a */
        final /* synthetic */ MutableLiveData f9567a;

        C2863d(MutableLiveData mutableLiveData) {
            this.f9567a = mutableLiveData;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f9567a.postValue(Integer.valueOf(4));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "", "T", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ObservableEx.kt */
    /* renamed from: com.jiayouya.travel.common.b.f$e */
    static final class C2864e implements C8083a {
        /* renamed from: a */
        final /* synthetic */ MutableLiveData f9568a;

        C2864e(MutableLiveData mutableLiveData) {
            this.f9568a = mutableLiveData;
        }

        /* renamed from: a */
        public final void mo19849a() {
            this.f9568a.postValue(Integer.valueOf(5));
        }
    }

    /* renamed from: a */
    public static final <T> Observable<T> m12824a(Observable<T> iVar, MutableLiveData<Integer> mutableLiveData) {
        C8271i.m35386b(iVar, "$this$useLoading");
        C8271i.m35386b(mutableLiveData, "loadingEvent");
        Observable<T> a = iVar.mo38899b((Consumer<? super Disposable>) new C2860a<Object>(mutableLiveData)).mo38883a((C8083a) new C2861b(mutableLiveData));
        C8271i.m35382a((Object) a, "this.doOnSubscribe { loa…(CANCEL_LOADING_DIALOG) }");
        return a;
    }

    /* renamed from: b */
    public static final <T> Observable<T> m12825b(Observable<T> iVar, MutableLiveData<Integer> mutableLiveData) {
        C8271i.m35386b(iVar, "$this$useStatus");
        C8271i.m35386b(mutableLiveData, "loadingEvent");
        Observable<T> b = iVar.mo38899b((Consumer<? super Disposable>) new C2862c<Object>(mutableLiveData)).mo38884a((Consumer<? super Throwable>) new C2863d<Object>(mutableLiveData)).mo38898b((C8083a) new C2864e(mutableLiveData));
        C8271i.m35382a((Object) b, "this.doOnSubscribe {\n   …Value(SHOW_SUCCESS)\n    }");
        return b;
    }
}
