package com.jiayouya.travel.module.p276me.p279ui;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.p244b.AdapterEx;
import com.jiayouya.travel.common.widget.ItemTypes;
import com.jiayouya.travel.databinding.ActivityNoticeCenterBinding;
import com.jiayouya.travel.module.p276me.data.NoticeItem;
import com.jiayouya.travel.module.p276me.p280vm.NoticeCenterVM;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p528b.OnRefreshListener;
import ezy.app.data.DataPage;
import ezy.p653ui.widget.recyclerview.adapter.EndlessAdapter;
import ezy.p653ui.widget.recyclerview.adapter.EndlessAdapter.OnLoadMoreListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/NoticeCenterActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityNoticeCenterBinding;", "Lcom/jiayouya/travel/module/me/vm/NoticeCenterVM;", "()V", "adapter", "Lezy/ui/widget/recyclerview/adapter/EndlessAdapter;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "fetchData", "", "isRefresh", "", "getLayoutId", "", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "providerViewModelClass", "Ljava/lang/Class;", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: NoticeCenterActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.NoticeCenterActivity */
public final class NoticeCenterActivity extends BaseActivity<ActivityNoticeCenterBinding, NoticeCenterVM> {
    /* renamed from: c */
    private final BindingType f11615c = BindingType.create(NoticeItem.class, (int) R.layout.item_notice_center);
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final EndlessAdapter f11616d = new EndlessAdapter(this.f11615c, ItemTypes.f9670a.mo20024a());
    /* renamed from: e */
    private HashMap f11617e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/me/data/NoticeItem;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: NoticeCenterActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.NoticeCenterActivity$a */
    static final class C3160a<T> implements Observer<DataPage<NoticeItem>> {
        /* renamed from: a */
        final /* synthetic */ NoticeCenterActivity f11618a;

        C3160a(NoticeCenterActivity noticeCenterActivity) {
            this.f11618a = noticeCenterActivity;
        }

        /* renamed from: a */
        public final void onChanged(DataPage<NoticeItem> dataPage) {
            AdapterEx.m12806a(this.f11618a.f11616d, dataPage, null, false, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "onRefresh"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: NoticeCenterActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.NoticeCenterActivity$b */
    static final class C3161b implements OnRefreshListener {
        /* renamed from: a */
        final /* synthetic */ NoticeCenterActivity f11619a;

        C3161b(NoticeCenterActivity noticeCenterActivity) {
            this.f11619a = noticeCenterActivity;
        }

        /* renamed from: a_ */
        public final void mo20372a_(RefreshLayout jVar) {
            C8271i.m35386b(jVar, "it");
            BaseActivity.m12847a(this.f11619a, false, 1, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "onLoadMore"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: NoticeCenterActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.NoticeCenterActivity$c */
    static final class C3162c implements OnLoadMoreListener {
        /* renamed from: a */
        final /* synthetic */ NoticeCenterActivity f11620a;

        C3162c(NoticeCenterActivity noticeCenterActivity) {
            this.f11620a = noticeCenterActivity;
        }

        public final void onLoadMore() {
            this.f11620a.mo19858b(false);
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11617e == null) {
            this.f11617e = new HashMap();
        }
        View view = (View) this.f11617e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11617e.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_notice_center;
    }

    /* renamed from: d */
    public Class<NoticeCenterVM> mo19861d() {
        return NoticeCenterVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        ((SmartRefreshLayout) mo19852a(R.id.refresh)).mo30862a((OnRefreshListener) new C3161b(this));
        this.f11616d.setOnLoadMoreListener(new C3162c(this));
        RecyclerView recyclerView = (RecyclerView) mo19852a(R.id.list);
        C8271i.m35382a((Object) recyclerView, "list");
        recyclerView.setAdapter(this.f11616d);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) mo19852a(R.id.refresh);
        C8271i.m35382a((Object) smartRefreshLayout, "refresh");
        setupStatusView(smartRefreshLayout);
        BaseActivity.m12847a(this, false, 1, null);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        ((NoticeCenterVM) mo19853a()).mo21479b().observe(this, new C3160a(this));
    }

    /* renamed from: h */
    public boolean mo19865h() {
        return AdapterEx.m12807a(this.f11616d);
    }

    /* renamed from: i */
    public boolean mo19866i() {
        return AdapterEx.m12807a(this.f11616d);
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((NoticeCenterVM) mo19853a()).mo21478a(z);
    }
}
