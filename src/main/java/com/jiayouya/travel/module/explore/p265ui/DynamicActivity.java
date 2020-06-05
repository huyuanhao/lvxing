package com.jiayouya.travel.module.explore.p265ui;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.p244b.AdapterEx;
import com.jiayouya.travel.databinding.ActivityDynamicBinding;
import com.jiayouya.travel.module.explore.data.DynamicContent;
import com.jiayouya.travel.module.explore.data.DynamicTitle;
import com.jiayouya.travel.module.explore.p266vm.DynamicVM;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p528b.OnRefreshListener;
import ezy.app.data.DataPage;
import ezy.p653ui.widget.recyclerview.adapter.EndlessAdapter;
import ezy.p653ui.widget.recyclerview.adapter.EndlessAdapter.OnLoadMoreListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/ui/DynamicActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityDynamicBinding;", "Lcom/jiayouya/travel/module/explore/vm/DynamicVM;", "()V", "adapter", "Lezy/ui/widget/recyclerview/adapter/EndlessAdapter;", "contentType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "titleType", "fetchData", "", "isRefresh", "", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DynamicActivity.kt */
/* renamed from: com.jiayouya.travel.module.explore.ui.DynamicActivity */
public final class DynamicActivity extends BaseActivity<ActivityDynamicBinding, DynamicVM> {
    /* renamed from: c */
    private final BindingType f11388c = BindingType.create(DynamicTitle.class, R.layout.item_dynamic_title, 0);
    /* renamed from: d */
    private final BindingType f11389d = BindingType.create(DynamicContent.class, R.layout.item_dynamic_content, 1);
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final EndlessAdapter f11390e = new EndlessAdapter(this.f11388c, this.f11389d);
    /* renamed from: f */
    private HashMap f11391f;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/explore/data/DynamicContent;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DynamicActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.DynamicActivity$a */
    static final class C2995a<T> implements Observer<DataPage<DynamicContent>> {
        /* renamed from: a */
        final /* synthetic */ DynamicActivity f11392a;

        C2995a(DynamicActivity dynamicActivity) {
            this.f11392a = dynamicActivity;
        }

        /* renamed from: a */
        public final void onChanged(DataPage<DynamicContent> dataPage) {
            AdapterEx.m12806a(this.f11392a.f11390e, dataPage, null, false, 2, null);
            Map linkedHashMap = new LinkedHashMap();
            List items = this.f11392a.f11390e.getItems();
            C8271i.m35382a((Object) items, "adapter.items");
            Iterable iterable = items;
            Collection arrayList = new ArrayList();
            for (Object next : iterable) {
                if (next instanceof DynamicContent) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            this.f11392a.f11390e.setItems(list);
            int i = 0;
            int i2 = 0;
            for (Object next2 : list) {
                int i3 = i + 1;
                if (i < 0) {
                    C8187k.m35272b();
                }
                DynamicContent dynamicContent = (DynamicContent) next2;
                dynamicContent.setFirst(i == 0);
                if (i == 0) {
                    linkedHashMap.put(Integer.valueOf(i + i2), new DynamicTitle(dynamicContent.timeText()));
                } else if (true ^ C8271i.m35384a((Object) ((DynamicContent) list.get(i - 1)).timeText(), (Object) dynamicContent.timeText())) {
                    linkedHashMap.put(Integer.valueOf(i + i2), new DynamicTitle(dynamicContent.getTimeText()));
                } else {
                    i = i3;
                }
                i2++;
                i = i3;
            }
            for (Entry entry : linkedHashMap.entrySet()) {
                this.f11392a.f11390e.getItems().add(((Number) entry.getKey()).intValue(), (DynamicTitle) entry.getValue());
            }
            this.f11392a.f11390e.notifyDataSetChanged();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "onLoadMore"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DynamicActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.DynamicActivity$b */
    static final class C2996b implements OnLoadMoreListener {
        /* renamed from: a */
        final /* synthetic */ DynamicActivity f11393a;

        C2996b(DynamicActivity dynamicActivity) {
            this.f11393a = dynamicActivity;
        }

        public final void onLoadMore() {
            this.f11393a.mo19858b(false);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "onRefresh"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DynamicActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.DynamicActivity$c */
    static final class C2997c implements OnRefreshListener {
        /* renamed from: a */
        final /* synthetic */ DynamicActivity f11394a;

        C2997c(DynamicActivity dynamicActivity) {
            this.f11394a = dynamicActivity;
        }

        /* renamed from: a_ */
        public final void mo20372a_(RefreshLayout jVar) {
            C8271i.m35386b(jVar, "it");
            BaseActivity.m12847a(this.f11394a, false, 1, null);
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11391f == null) {
            this.f11391f = new HashMap();
        }
        View view = (View) this.f11391f.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11391f.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_dynamic;
    }

    /* renamed from: d */
    public Class<DynamicVM> mo19861d() {
        return DynamicVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) mo19852a(R.id.list);
        C8271i.m35382a((Object) recyclerView, "list");
        recyclerView.setAdapter(this.f11390e);
        this.f11390e.setOnLoadMoreListener(new C2996b(this));
        ((SmartRefreshLayout) mo19852a(R.id.refresh)).mo30862a((OnRefreshListener) new C2997c(this));
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) mo19852a(R.id.refresh);
        C8271i.m35382a((Object) smartRefreshLayout, "refresh");
        setupStatusView(smartRefreshLayout);
        BaseActivity.m12847a(this, false, 1, null);
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((DynamicVM) mo19853a()).mo20925a(z);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        ((DynamicVM) mo19853a()).mo20926b().observe(this, new C2995a(this));
    }
}
