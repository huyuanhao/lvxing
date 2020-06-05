package com.jiayouya.travel.module.travel.p288ui.fragment;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseFragment;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.p244b.AdapterEx;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.widget.ItemTypes;
import com.jiayouya.travel.databinding.FragmentDogRankListBinding;
import com.jiayouya.travel.module.travel.data.DogRankListItem;
import com.jiayouya.travel.module.travel.p290vm.DogRankListVM;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p528b.OnRefreshListener;
import ezy.app.data.DataPage;
import ezy.p653ui.widget.recyclerview.adapter.EndlessAdapter;
import ezy.p653ui.widget.recyclerview.adapter.EndlessAdapter.OnLoadMoreListener;
import ezy.p653ui.widget.recyclerview.decoration.HorizontalDividerItemDecoration.Builder;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/fragment/DogRankListFragment;", "Lcom/jiayouya/travel/common/base/BaseFragment;", "Lcom/jiayouya/travel/databinding/FragmentDogRankListBinding;", "Lcom/jiayouya/travel/module/travel/vm/DogRankListVM;", "()V", "adapter", "Lezy/ui/widget/recyclerview/adapter/EndlessAdapter;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "fetchData", "", "isRefresh", "", "getLayoutId", "", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "providerViewModelClass", "Ljava/lang/Class;", "setupObserver", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DogRankListFragment.kt */
/* renamed from: com.jiayouya.travel.module.travel.ui.fragment.DogRankListFragment */
public final class DogRankListFragment extends BaseFragment<FragmentDogRankListBinding, DogRankListVM> {
    /* renamed from: c */
    private final BindingType f12066c = BindingType.create(DogRankListItem.class, (int) R.layout.item_dog_rank_list);
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final EndlessAdapter f12067d = new EndlessAdapter(this.f12066c, ItemTypes.f9670a.mo20024a());
    /* renamed from: e */
    private HashMap f12068e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/travel/data/DogRankListItem;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DogRankListFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.DogRankListFragment$a */
    static final class C3432a<T> implements Observer<DataPage<DogRankListItem>> {
        /* renamed from: a */
        final /* synthetic */ DogRankListFragment f12069a;

        C3432a(DogRankListFragment dogRankListFragment) {
            this.f12069a = dogRankListFragment;
        }

        /* renamed from: a */
        public final void onChanged(DataPage<DogRankListItem> dataPage) {
            AdapterEx.m12806a(this.f12069a.f12067d, dataPage, null, false, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "onRefresh"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DogRankListFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.DogRankListFragment$b */
    static final class C3433b implements OnRefreshListener {
        /* renamed from: a */
        final /* synthetic */ DogRankListFragment f12070a;

        C3433b(DogRankListFragment dogRankListFragment) {
            this.f12070a = dogRankListFragment;
        }

        /* renamed from: a_ */
        public final void mo20372a_(RefreshLayout jVar) {
            C8271i.m35386b(jVar, "it");
            BaseFragment.m12877a(this.f12070a, false, 1, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "onLoadMore"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DogRankListFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.DogRankListFragment$c */
    static final class C3434c implements OnLoadMoreListener {
        /* renamed from: a */
        final /* synthetic */ DogRankListFragment f12071a;

        C3434c(DogRankListFragment dogRankListFragment) {
            this.f12071a = dogRankListFragment;
        }

        public final void onLoadMore() {
            this.f12071a.mo19884a(false);
        }
    }

    /* renamed from: a */
    public View mo19880a(int i) {
        if (this.f12068e == null) {
            this.f12068e = new HashMap();
        }
        View view = (View) this.f12068e.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this.f12068e.put(Integer.valueOf(i), view);
        }
        return view;
    }

    /* renamed from: l */
    public int mo19896l() {
        return R.layout.fragment_dog_rank_list;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo19902r();
    }

    /* renamed from: r */
    public void mo19902r() {
        HashMap hashMap = this.f12068e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* renamed from: e */
    public Class<DogRankListVM> mo19889e() {
        return DogRankListVM.class;
    }

    /* renamed from: f */
    public void mo19890f() {
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) mo19880a(R.id.refresh);
        C8271i.m35382a((Object) smartRefreshLayout, "refresh");
        mo19882a((View) smartRefreshLayout);
        RecyclerView recyclerView = (RecyclerView) mo19880a(R.id.list);
        C8271i.m35382a((Object) recyclerView, "list");
        recyclerView.setAdapter(this.f12067d);
        RecyclerView recyclerView2 = (RecyclerView) mo19880a(R.id.list);
        Context context = getContext();
        if (context == null) {
            C8271i.m35380a();
        }
        recyclerView2.addItemDecoration(((Builder) new Builder(context).drawable((int) R.drawable.divider)).margin(GloblaEx.m12810a(20.0f), 0).build());
        ((SmartRefreshLayout) mo19880a(R.id.refresh)).mo30862a((OnRefreshListener) new C3433b(this));
        this.f12067d.setOnLoadMoreListener(new C3434c(this));
        BaseFragment.m12877a(this, false, 1, null);
    }

    /* renamed from: a */
    public void mo19884a(boolean z) {
        ((DogRankListVM) mo19881a()).mo22406a(z);
    }

    /* renamed from: h */
    public boolean mo19892h() {
        return AdapterEx.m12807a(this.f12067d);
    }

    /* renamed from: i */
    public boolean mo19893i() {
        return AdapterEx.m12807a(this.f12067d);
    }

    /* renamed from: g */
    public void mo19891g() {
        super.mo19891g();
        ((DogRankListVM) mo19881a()).mo22407b().observe(this, new C3432a(this));
    }
}
