package com.jiayouya.travel.module.p276me.p280vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.data.CheckPhoneRsp;
import com.jiayouya.travel.module.common.p257a.C2961h;
import com.jiayouya.travel.module.common.p257a.C2962j;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import ezy.app.p643a.API;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import okhttp3.C8364ac;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0018"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/vm/PhoneVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "bindData", "Landroidx/lifecycle/MutableLiveData;", "", "getBindData", "()Landroidx/lifecycle/MutableLiveData;", "checkData", "Lcom/jiayouya/travel/module/common/data/CheckPhoneRsp;", "getCheckData", "codeData", "getCodeData", "saveData", "getSaveData", "bind", "", "phone", "", "code", "check", "scene", "", "edit", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: PhoneVM.kt */
/* renamed from: com.jiayouya.travel.module.me.vm.PhoneVM */
public final class PhoneVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<Object> f11740a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<Object> f11741b = new MutableLiveData<>();
    /* renamed from: c */
    private final MutableLiveData<Object> f11742c = new MutableLiveData<>();
    /* renamed from: d */
    private final MutableLiveData<CheckPhoneRsp> f11743d = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.PhoneVM$a */
    static final class C3253a<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ PhoneVM f11744a;

        C3253a(PhoneVM phoneVM) {
            this.f11744a = phoneVM;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            this.f11744a.mo21487d().postValue(acVar);
            ResidentMemoryModel.m13597a(ResidentMemoryModel.f11323a, null, null, null, 7, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/CheckPhoneRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.PhoneVM$b */
    static final class C3254b<T> implements Consumer<CheckPhoneRsp> {
        /* renamed from: a */
        final /* synthetic */ PhoneVM f11745a;

        C3254b(PhoneVM phoneVM) {
            this.f11745a = phoneVM;
        }

        /* renamed from: a */
        public final void accept(CheckPhoneRsp checkPhoneRsp) {
            this.f11745a.mo21488e().postValue(checkPhoneRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.PhoneVM$c */
    static final class C3255c<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ PhoneVM f11746a;

        C3255c(PhoneVM phoneVM) {
            this.f11746a = phoneVM;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            this.f11746a.mo21486c().postValue(acVar);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.PhoneVM$d */
    static final class C3256d<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ PhoneVM f11747a;

        C3256d(PhoneVM phoneVM) {
            this.f11747a = phoneVM;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            this.f11747a.mo21484b().postValue(acVar);
            ResidentMemoryModel.m13597a(ResidentMemoryModel.f11323a, null, null, null, 7, null);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<Object> mo21484b() {
        return this.f11740a;
    }

    /* renamed from: c */
    public final MutableLiveData<Object> mo21486c() {
        return this.f11741b;
    }

    /* renamed from: d */
    public final MutableLiveData<Object> mo21487d() {
        return this.f11742c;
    }

    /* renamed from: e */
    public final MutableLiveData<CheckPhoneRsp> mo21488e() {
        return this.f11743d;
    }

    /* renamed from: a */
    public final void mo21483a(String str, String str2) {
        C8271i.m35386b(str, "phone");
        C8271i.m35386b(str2, "code");
        ObservableEx.m12824a(C2962j.m13561a(API.f27251a).mo20420a(str, str2), mo19904a()).mo38904c((Consumer<? super T>) new C3253a<Object>(this));
    }

    /* renamed from: a */
    public final void mo21482a(String str) {
        C8271i.m35386b(str, "code");
        ObservableEx.m12824a(C2962j.m13561a(API.f27251a).mo20419a(str), mo19904a()).mo38904c((Consumer<? super T>) new C3254b<Object>(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001e, code lost:
            if (r1 != null) goto L_0x0023;
     */
    /* renamed from: b */
    public final void mo21485b(java.lang.String r3, java.lang.String r4) {
        /*
        r2 = this;
        java.lang.String r0 = "phone"
        kotlin.jvm.internal.C8271i.m35386b(r3, r0)
        java.lang.String r0 = "code"
        kotlin.jvm.internal.C8271i.m35386b(r4, r0)
        ezy.app.a.a r0 = ezy.app.p643a.API.f27251a
        com.jiayouya.travel.module.common.a.i r0 = com.jiayouya.travel.module.common.p257a.C2962j.m13561a(r0)
        androidx.lifecycle.MutableLiveData<com.jiayouya.travel.module.common.data.CheckPhoneRsp> r1 = r2.f11743d
        java.lang.Object r1 = r1.getValue()
        com.jiayouya.travel.module.common.data.CheckPhoneRsp r1 = (com.jiayouya.travel.module.common.data.CheckPhoneRsp) r1
        if (r1 == 0) goto L_0x0021
        java.lang.String r1 = r1.getCredential()
        if (r1 == 0) goto L_0x0021
        goto L_0x0023
    L_0x0021:
        java.lang.String r1 = ""
    L_0x0023:
        io.reactivex.i r3 = r0.mo20421a(r3, r4, r1)
        androidx.lifecycle.MutableLiveData r4 = r2.mo19904a()
        io.reactivex.i r3 = com.jiayouya.travel.common.p244b.ObservableEx.m12824a(r3, r4)
        com.jiayouya.travel.module.me.vm.PhoneVM$d r4 = new com.jiayouya.travel.module.me.vm.PhoneVM$d
        r4.m46807init(r2)
        io.reactivex.d.g r4 = (p655io.reactivex.p664d.Consumer) r4
        r3.mo38904c(r4)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.p276me.p280vm.PhoneVM.mo21485b(java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public final void mo21481a(int i, String str) {
        C8271i.m35386b(str, "phone");
        ObservableEx.m12824a(C2961h.m13543a(API.f27251a).mo20415a(i, str), mo19904a()).mo38904c((Consumer<? super T>) new C3255c<Object>(this));
    }
}
