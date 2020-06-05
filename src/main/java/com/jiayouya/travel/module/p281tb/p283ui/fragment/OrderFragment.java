package com.jiayouya.travel.module.p281tb.p283ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseFragment;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.OnItemClickListener;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.common.widget.ItemTypes;
import com.jiayouya.travel.databinding.FragmentOrderBinding;
import com.jiayouya.travel.module.p281tb.p284vm.OrderVM;
import ezy.p653ui.widget.recyclerview.adapter.EndlessAdapter;
import ezy.p653ui.widget.recyclerview.decoration.HorizontalDividerItemDecoration.Builder;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/ui/fragment/OrderFragment;", "Lcom/jiayouya/travel/common/base/BaseFragment;", "Lcom/jiayouya/travel/databinding/FragmentOrderBinding;", "Lcom/jiayouya/travel/module/tb/vm/OrderVM;", "()V", "adapter", "Lezy/ui/widget/recyclerview/adapter/EndlessAdapter;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "", "setupView", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: OrderFragment.kt */
/* renamed from: com.jiayouya.travel.module.tb.ui.fragment.OrderFragment */
public final class OrderFragment extends BaseFragment<FragmentOrderBinding, OrderVM> {
    /* renamed from: c */
    public static final C3303a f11834c = new C3303a(null);
    /* renamed from: d */
    private final BindingType f11835d = BindingType.create(String.class, (int) R.layout.item_order);
    /* renamed from: e */
    private final EndlessAdapter f11836e = new EndlessAdapter(this.f11835d, ItemTypes.f9670a.mo20024a());
    /* renamed from: f */
    private HashMap f11837f;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/ui/fragment/OrderFragment$Companion;", "", "()V", "newInstance", "Lcom/jiayouya/travel/module/tb/ui/fragment/OrderFragment;", "type", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: OrderFragment.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.fragment.OrderFragment$a */
    public static final class C3303a {
        private C3303a() {
        }

        public /* synthetic */ C3303a(DefaultConstructorMarker fVar) {
            this();
        }

        /* renamed from: a */
        public final OrderFragment mo21580a(int i) {
            OrderFragment orderFragment = new OrderFragment();
            Bundle bundle = new Bundle();
            ezy.p642a.Bundle.m34738a(bundle, "type", i);
            orderFragment.setArguments(bundle);
            return orderFragment;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: OrderFragment.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.fragment.OrderFragment$b */
    static final class C3304b implements OnItemClickListener {
        /* renamed from: a */
        public static final C3304b f11838a = new C3304b();

        C3304b() {
        }

        /* renamed from: a */
        public final void mo19912a(View view, int i, long j) {
            Router.m12969a(Router.f9644a, "/tb/orderDetails", null, null, 6, null);
        }
    }

    /* renamed from: a */
    public View mo19880a(int i) {
        if (this.f11837f == null) {
            this.f11837f = new HashMap();
        }
        View view = (View) this.f11837f.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this.f11837f.put(Integer.valueOf(i), view);
        }
        return view;
    }

    /* renamed from: l */
    public int mo19896l() {
        return R.layout.fragment_order;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo19902r();
    }

    /* renamed from: r */
    public void mo19902r() {
        HashMap hashMap = this.f11837f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* renamed from: e */
    public Class<OrderVM> mo19889e() {
        return OrderVM.class;
    }

    /* renamed from: f */
    public void mo19890f() {
        RecyclerView recyclerView = (RecyclerView) mo19880a(R.id.list);
        C8271i.m35382a((Object) recyclerView, "list");
        recyclerView.setAdapter(this.f11836e);
        RecyclerView recyclerView2 = (RecyclerView) mo19880a(R.id.list);
        Context context = getContext();
        if (context == null) {
            C8271i.m35380a();
        }
        recyclerView2.addItemDecoration(((Builder) ((Builder) ((Builder) new Builder(context).color(GloblaEx.m12811a(17170445))).size(GloblaEx.m12810a(11.0f))).showLastDivider()).build());
        String str = "";
        this.f11836e.setItems(C8187k.m35271b(str, str));
    }

    /* renamed from: k */
    public void mo19895k() {
        this.f11835d.setOnItemClick(C3304b.f11838a);
    }
}
