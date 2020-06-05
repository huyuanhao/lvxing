package com.jiayouya.travel.module.travel.p288ui;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.databinding.ActivityHandbookBinding;
import com.jiayouya.travel.module.travel.data.HandbookItem;
import com.jiayouya.travel.module.travel.p290vm.HandbookVM;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p528b.OnRefreshListener;
import ezy.p642a.Context;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import ezy.p653ui.widget.recyclerview.decoration.HorizontalDividerItemDecoration.Builder;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/HandbookActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityHandbookBinding;", "Lcom/jiayouya/travel/module/travel/vm/HandbookVM;", "()V", "adapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "Lcom/jiayouya/travel/module/travel/data/HandbookItem;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "fetchData", "", "isRefresh", "", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: HandbookActivity.kt */
/* renamed from: com.jiayouya.travel.module.travel.ui.HandbookActivity */
public final class HandbookActivity extends BaseActivity<ActivityHandbookBinding, HandbookVM> {
    /* renamed from: c */
    private final BindingType f11926c = BindingType.create(HandbookItem.class, (int) R.layout.item_handbook);
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final SingleTypeAdapter<HandbookItem> f11927d = new SingleTypeAdapter<>(this.f11926c);
    /* renamed from: e */
    private HashMap f11928e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "Lcom/jiayouya/travel/module/travel/data/HandbookItem;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: HandbookActivity.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.HandbookActivity$a */
    static final class C3333a<T> implements Observer<List<? extends HandbookItem>> {
        /* renamed from: a */
        final /* synthetic */ HandbookActivity f11929a;

        C3333a(HandbookActivity handbookActivity) {
            this.f11929a = handbookActivity;
        }

        /* renamed from: a */
        public final void onChanged(List<HandbookItem> list) {
            this.f11929a.f11927d.setItems(list);
            this.f11929a.f11927d.notifyDataSetChanged();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "onRefresh"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: HandbookActivity.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.HandbookActivity$b */
    static final class C3334b implements OnRefreshListener {
        /* renamed from: a */
        final /* synthetic */ HandbookActivity f11930a;

        C3334b(HandbookActivity handbookActivity) {
            this.f11930a = handbookActivity;
        }

        /* renamed from: a_ */
        public final void mo20372a_(RefreshLayout jVar) {
            C8271i.m35386b(jVar, "it");
            BaseActivity.m12847a(this.f11930a, false, 1, null);
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11928e == null) {
            this.f11928e = new HashMap();
        }
        View view = (View) this.f11928e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11928e.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_handbook;
    }

    /* renamed from: d */
    public Class<HandbookVM> mo19861d() {
        return HandbookVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) mo19852a(R.id.list);
        C8271i.m35382a((Object) recyclerView, "list");
        recyclerView.setAdapter(this.f11927d);
        ((RecyclerView) mo19852a(R.id.list)).addItemDecoration(((Builder) ((Builder) ((Builder) new Builder(this).color(17170445)).size(Context.m34741a(this, 10.0f))).showLastDivider()).build());
        ((SmartRefreshLayout) mo19852a(R.id.refresh)).mo30862a((OnRefreshListener) new C3334b(this));
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) mo19852a(R.id.refresh);
        C8271i.m35382a((Object) smartRefreshLayout, "refresh");
        setupStatusView(smartRefreshLayout);
        BaseActivity.m12847a(this, false, 1, null);
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((HandbookVM) mo19853a()).mo22410c();
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        ((HandbookVM) mo19853a()).mo22409b().observe(this, new C3333a(this));
    }
}
