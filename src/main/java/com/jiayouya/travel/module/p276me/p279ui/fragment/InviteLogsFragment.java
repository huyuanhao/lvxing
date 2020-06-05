package com.jiayouya.travel.module.p276me.p279ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseFragment;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.OnItemClickListener;
import com.jiayouya.travel.common.p244b.AdapterEx;
import com.jiayouya.travel.common.p244b.FragmentEx;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.widget.ItemTypes;
import com.jiayouya.travel.databinding.FragmentInviteLogsBinding;
import com.jiayouya.travel.module.common.data.ParentRsp;
import com.jiayouya.travel.module.group.data.InviteLogsItem;
import com.jiayouya.travel.module.group.p269vm.InviteLogsVM;
import com.jiayouya.travel.module.p276me.p279ui.dialog.MyInviterDilaog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p528b.OnRefreshListener;
import ezy.app.data.DataPage;
import ezy.p653ui.widget.recyclerview.adapter.EndlessAdapter;
import ezy.p653ui.widget.recyclerview.adapter.EndlessAdapter.OnLoadMoreListener;
import ezy.p653ui.widget.recyclerview.decoration.HorizontalDividerItemDecoration.Builder;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/fragment/InviteLogsFragment;", "Lcom/jiayouya/travel/common/base/BaseFragment;", "Lcom/jiayouya/travel/databinding/FragmentInviteLogsBinding;", "Lcom/jiayouya/travel/module/group/vm/InviteLogsVM;", "()V", "adapter", "Lezy/ui/widget/recyclerview/adapter/EndlessAdapter;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "type", "", "getType", "()I", "type$delegate", "Lkotlin/Lazy;", "fetchData", "", "isRefresh", "", "getLayoutId", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "setupObserver", "setupView", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: InviteLogsFragment.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.fragment.InviteLogsFragment */
public final class InviteLogsFragment extends BaseFragment<FragmentInviteLogsBinding, InviteLogsVM> {
    /* renamed from: c */
    static final /* synthetic */ C8280j[] f11684c = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(InviteLogsFragment.class), "type", "getType()I"))};
    /* renamed from: d */
    public static final C3226a f11685d = new C3226a(null);
    /* renamed from: e */
    private final BindingType f11686e = BindingType.create(InviteLogsItem.class, (int) R.layout.item_invite_logs);
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final EndlessAdapter f11687f = new EndlessAdapter(this.f11686e, ItemTypes.f9670a.mo20024a());
    /* renamed from: g */
    private final Lazy f11688g = FragmentEx.m12808a(this, "type", Integer.valueOf(1));
    /* renamed from: h */
    private HashMap f11689h;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/fragment/InviteLogsFragment$Companion;", "", "()V", "newInstance", "Lcom/jiayouya/travel/module/me/ui/fragment/InviteLogsFragment;", "type", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: InviteLogsFragment.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.fragment.InviteLogsFragment$a */
    public static final class C3226a {
        private C3226a() {
        }

        public /* synthetic */ C3226a(DefaultConstructorMarker fVar) {
            this();
        }

        /* renamed from: a */
        public final InviteLogsFragment mo21434a(int i) {
            InviteLogsFragment inviteLogsFragment = new InviteLogsFragment();
            Bundle bundle = new Bundle();
            ezy.p642a.Bundle.m34738a(bundle, "type", i);
            inviteLogsFragment.setArguments(bundle);
            return inviteLogsFragment;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteLogsFragment.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.fragment.InviteLogsFragment$b */
    static final class C3227b implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ InviteLogsFragment f11690a;

        C3227b(InviteLogsFragment inviteLogsFragment) {
            this.f11690a = inviteLogsFragment;
        }

        /* renamed from: a */
        public final void mo19912a(View view, int i, long j) {
            Object item = this.f11690a.f11687f.getItem(i);
            if (item != null) {
                InviteLogsItem inviteLogsItem = (InviteLogsItem) item;
                ParentRsp parentRsp = new ParentRsp(inviteLogsItem.getMaxLevel(), inviteLogsItem.getNickname(), "", inviteLogsItem.getWx(), inviteLogsItem.getQq(), inviteLogsItem.getAvatar());
                C8271i.m35382a((Object) view, "view");
                Context context = view.getContext();
                C8271i.m35382a((Object) context, "view.context");
                new MyInviterDilaog(context, parentRsp, 2).show();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.module.group.data.InviteLogsItem");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/group/data/InviteLogsItem;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteLogsFragment.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.fragment.InviteLogsFragment$c */
    static final class C3228c<T> implements Observer<DataPage<InviteLogsItem>> {
        /* renamed from: a */
        final /* synthetic */ InviteLogsFragment f11691a;

        C3228c(InviteLogsFragment inviteLogsFragment) {
            this.f11691a = inviteLogsFragment;
        }

        /* renamed from: a */
        public final void onChanged(DataPage<InviteLogsItem> dataPage) {
            AdapterEx.m12806a(this.f11691a.f11687f, dataPage, null, false, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "onRefresh"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteLogsFragment.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.fragment.InviteLogsFragment$d */
    static final class C3229d implements OnRefreshListener {
        /* renamed from: a */
        final /* synthetic */ InviteLogsFragment f11692a;

        C3229d(InviteLogsFragment inviteLogsFragment) {
            this.f11692a = inviteLogsFragment;
        }

        /* renamed from: a_ */
        public final void mo20372a_(RefreshLayout jVar) {
            C8271i.m35386b(jVar, "it");
            BaseFragment.m12877a(this.f11692a, false, 1, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "onLoadMore"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteLogsFragment.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.fragment.InviteLogsFragment$e */
    static final class C3230e implements OnLoadMoreListener {
        /* renamed from: a */
        final /* synthetic */ InviteLogsFragment f11693a;

        C3230e(InviteLogsFragment inviteLogsFragment) {
            this.f11693a = inviteLogsFragment;
        }

        public final void onLoadMore() {
            this.f11693a.mo19884a(false);
        }
    }

    /* renamed from: s */
    private final int m14174s() {
        Lazy bVar = this.f11688g;
        C8280j jVar = f11684c[0];
        return ((Number) bVar.getValue()).intValue();
    }

    /* renamed from: a */
    public View mo19880a(int i) {
        if (this.f11689h == null) {
            this.f11689h = new HashMap();
        }
        View view = (View) this.f11689h.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this.f11689h.put(Integer.valueOf(i), view);
        }
        return view;
    }

    /* renamed from: l */
    public int mo19896l() {
        return R.layout.fragment_invite_logs;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo19902r();
    }

    /* renamed from: r */
    public void mo19902r() {
        HashMap hashMap = this.f11689h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* renamed from: e */
    public Class<InviteLogsVM> mo19889e() {
        return InviteLogsVM.class;
    }

    /* renamed from: f */
    public void mo19890f() {
        RecyclerView recyclerView = (RecyclerView) mo19880a(R.id.list);
        C8271i.m35382a((Object) recyclerView, "list");
        recyclerView.setAdapter(this.f11687f);
        ((RecyclerView) mo19880a(R.id.list)).addItemDecoration(((Builder) new Builder(getContext()).drawable((int) R.drawable.divider)).margin(GloblaEx.m12810a(20.0f), 0).build());
        ((SmartRefreshLayout) mo19880a(R.id.refresh)).mo30862a((OnRefreshListener) new C3229d(this));
        this.f11687f.setOnLoadMoreListener(new C3230e(this));
        BaseFragment.m12877a(this, false, 1, null);
    }

    /* renamed from: k */
    public void mo19895k() {
        this.f11686e.setOnItemClick(new C3227b(this));
    }

    /* renamed from: a */
    public void mo19884a(boolean z) {
        ((InviteLogsVM) mo19881a()).mo21142a(z, m14174s());
    }

    /* renamed from: h */
    public boolean mo19892h() {
        return AdapterEx.m12807a(this.f11687f);
    }

    /* renamed from: i */
    public boolean mo19893i() {
        return AdapterEx.m12807a(this.f11687f);
    }

    /* renamed from: g */
    public void mo19891g() {
        super.mo19891g();
        ((InviteLogsVM) mo19881a()).mo21143b().observe(this, new C3228c(this));
    }
}
