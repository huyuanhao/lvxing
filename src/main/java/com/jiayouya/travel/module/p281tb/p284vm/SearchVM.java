package com.jiayouya.travel.module.p281tb.p284vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.module.common.data.Resource;
import com.jiayouya.travel.module.p281tb.data.GoodsItem;
import com.jiayouya.travel.module.p281tb.data.SearchHistory;
import com.jiayouya.travel.module.p281tb.p282a.C3274b;
import ezy.app.data.DataPage;
import ezy.app.p643a.API;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.text.C8313m;
import okhttp3.C8364ac;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016JT\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020$R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00110\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b¨\u0006%"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/vm/SearchVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "associateSearchData", "Landroidx/lifecycle/MutableLiveData;", "", "", "getAssociateSearchData", "()Landroidx/lifecycle/MutableLiveData;", "deleteData", "Lokhttp3/ResponseBody;", "getDeleteData", "historyData", "Lcom/jiayouya/travel/module/tb/data/SearchHistory;", "getHistoryData", "next", "searchResultData", "Lcom/jiayouya/travel/module/common/data/Resource;", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/tb/data/GoodsItem;", "getSearchResultData", "associateSearch", "", "keyword", "deleteHistory", "fetchHistory", "search", "keywords", "hasCoupon", "", "field", "sort", "isTmall", "startPrice", "endPrice", "isRefresh", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: SearchVM.kt */
/* renamed from: com.jiayouya.travel.module.tb.vm.SearchVM */
public final class SearchVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<SearchHistory> f11849a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<C8364ac> f11850b = new MutableLiveData<>();
    /* renamed from: c */
    private final MutableLiveData<List<String>> f11851c = new MutableLiveData<>();
    /* renamed from: d */
    private final MutableLiveData<Resource<DataPage<GoodsItem>>> f11852d = new MutableLiveData<>();
    /* renamed from: e */
    private String f11853e = "";

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchVM.kt */
    /* renamed from: com.jiayouya.travel.module.tb.vm.SearchVM$a */
    static final class C3309a<T> implements Consumer<List<? extends String>> {
        /* renamed from: a */
        final /* synthetic */ SearchVM f11854a;

        C3309a(SearchVM searchVM) {
            this.f11854a = searchVM;
        }

        /* renamed from: a */
        public final void accept(List<String> list) {
            this.f11854a.mo21589d().postValue(list);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchVM.kt */
    /* renamed from: com.jiayouya.travel.module.tb.vm.SearchVM$b */
    static final class C3310b<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ SearchVM f11855a;

        C3310b(SearchVM searchVM) {
            this.f11855a = searchVM;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            this.f11855a.mo21588c().postValue(acVar);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/tb/data/SearchHistory;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchVM.kt */
    /* renamed from: com.jiayouya.travel.module.tb.vm.SearchVM$c */
    static final class C3311c<T> implements Consumer<SearchHistory> {
        /* renamed from: a */
        final /* synthetic */ SearchVM f11856a;

        C3311c(SearchVM searchVM) {
            this.f11856a = searchVM;
        }

        /* renamed from: a */
        public final void accept(SearchHistory searchHistory) {
            this.f11856a.mo21587b().postValue(searchHistory);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<SearchHistory> mo21587b() {
        return this.f11849a;
    }

    /* renamed from: c */
    public final MutableLiveData<C8364ac> mo21588c() {
        return this.f11850b;
    }

    /* renamed from: d */
    public final MutableLiveData<List<String>> mo21589d() {
        return this.f11851c;
    }

    /* renamed from: e */
    public final void mo21590e() {
        C3274b.m14301a(API.f27251a).mo21522a().mo38904c((Consumer<? super T>) new C3311c<Object>(this));
    }

    /* renamed from: f */
    public final void mo21591f() {
        C3274b.m14301a(API.f27251a).mo21524b().mo38904c((Consumer<? super T>) new C3310b<Object>(this));
    }

    /* renamed from: a */
    public final void mo21586a(String str) {
        C8271i.m35386b(str, "keyword");
        C3274b.m14301a(API.f27251a).mo21523a(C8313m.m35483b(str).toString()).mo38904c((Consumer<? super T>) new C3309a<Object>(this));
    }
}
