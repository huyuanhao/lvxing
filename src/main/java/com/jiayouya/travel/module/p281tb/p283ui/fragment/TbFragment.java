package com.jiayouya.travel.module.p281tb.p283ui.fragment;

import android.app.ActivityOptions;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseFragment;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.ClickableBindingHolder;
import com.jiayouya.travel.common.binding.OnBindListener;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.FragmentTbBinding;
import com.jiayouya.travel.databinding.ItemOrderCoinBinding;
import com.jiayouya.travel.module.p281tb.data.OrderWorkerItem;
import com.jiayouya.travel.module.p281tb.p284vm.TbVM;
import com.jiayouya.travel.module.p281tb.widget.CircleProgressBar.C3313b;
import com.jiayouya.travel.module.p281tb.widget.CircleProgressBar.C3314c;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/ui/fragment/TbFragment;", "Lcom/jiayouya/travel/common/base/BaseFragment;", "Lcom/jiayouya/travel/databinding/FragmentTbBinding;", "Lcom/jiayouya/travel/module/tb/vm/TbVM;", "()V", "adapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "Lcom/jiayouya/travel/module/tb/data/OrderWorkerItem;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "", "setupListView", "setupView", "startTranAnim", "view", "Landroid/view/View;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TbFragment.kt */
/* renamed from: com.jiayouya.travel.module.tb.ui.fragment.TbFragment */
public final class TbFragment extends BaseFragment<FragmentTbBinding, TbVM> {
    /* renamed from: c */
    private final BindingType f11839c = BindingType.create(OrderWorkerItem.class, (int) R.layout.item_order_coin);
    /* renamed from: d */
    private final SingleTypeAdapter<OrderWorkerItem> f11840d = new SingleTypeAdapter<>(this.f11839c);
    /* renamed from: e */
    private HashMap f11841e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TbFragment.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.fragment.TbFragment$a */
    static final class C3305a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TbFragment this$0;

        C3305a(TbFragment tbFragment) {
            this.this$0 = tbFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            String str = "/tb/search";
            Router.m12969a(Router.f9644a, str, ActivityOptions.makeSceneTransitionAnimation(this.this$0.getActivity(), view, this.this$0.getString(R.string.transition_search)).toBundle(), null, 4, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0003¨\u0006\u00010\u0003¨\u0006\u00012\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, mo39189d2 = {"<anonymous>", "", "holder", "Lcom/jiayouya/travel/common/binding/ClickableBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "kotlin.jvm.PlatformType", "item", "", "onBind"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TbFragment.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.fragment.TbFragment$b */
    static final class C3306b implements OnBindListener {
        /* renamed from: a */
        final /* synthetic */ TbFragment f11842a;

        C3306b(TbFragment tbFragment) {
            this.f11842a = tbFragment;
        }

        /* renamed from: a */
        public final void mo19911a(ClickableBindingHolder<ViewDataBinding> clickableBindingHolder, Object obj) {
            if (obj != null) {
                OrderWorkerItem orderWorkerItem = (OrderWorkerItem) obj;
                Binding binding = clickableBindingHolder.binding;
                if (binding != null) {
                    final ItemOrderCoinBinding itemOrderCoinBinding = (ItemOrderCoinBinding) binding;
                    TextView textView = itemOrderCoinBinding.f11129d;
                    C8271i.m35382a((Object) textView, "binding.tvAdd");
                    textView.setVisibility(4);
                    itemOrderCoinBinding.f11128c.mo21596a((C3314c) new C3314c(this) {
                        /* renamed from: a */
                        final /* synthetic */ C3306b f11843a;

                        {
                            this.f11843a = r1;
                        }

                        /* renamed from: a */
                        public void mo21582a() {
                            TbFragment tbFragment = this.f11843a.f11842a;
                            TextView textView = itemOrderCoinBinding.f11129d;
                            C8271i.m35382a((Object) textView, "binding.tvAdd");
                            tbFragment.m14367b(textView);
                        }
                    }, (C3313b) obj);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.databinding.ItemOrderCoinBinding");
            }
            throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.module.tb.data.OrderWorkerItem");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, mo39189d2 = {"com/jiayouya/travel/module/tb/ui/fragment/TbFragment$startTranAnim$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TbFragment.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.fragment.TbFragment$c */
    public static final class C3308c implements AnimationListener {
        /* renamed from: a */
        final /* synthetic */ View f11845a;

        public void onAnimationRepeat(Animation animation) {
        }

        C3308c(View view) {
            this.f11845a = view;
        }

        public void onAnimationStart(Animation animation) {
            this.f11845a.setVisibility(0);
        }

        public void onAnimationEnd(Animation animation) {
            this.f11845a.setVisibility(4);
        }
    }

    /* renamed from: a */
    public View mo19880a(int i) {
        if (this.f11841e == null) {
            this.f11841e = new HashMap();
        }
        View view = (View) this.f11841e.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this.f11841e.put(Integer.valueOf(i), view);
        }
        return view;
    }

    /* renamed from: l */
    public int mo19896l() {
        return R.layout.fragment_tb;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo19902r();
    }

    /* renamed from: r */
    public void mo19902r() {
        HashMap hashMap = this.f11841e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* renamed from: e */
    public Class<TbVM> mo19889e() {
        return TbVM.class;
    }

    /* renamed from: f */
    public void mo19890f() {
        m14368s();
    }

    /* renamed from: s */
    private final void m14368s() {
        RecyclerView recyclerView = (RecyclerView) mo19880a(R.id.list);
        String str = "list";
        C8271i.m35382a((Object) recyclerView, str);
        recyclerView.setAdapter(this.f11840d);
        RecyclerView recyclerView2 = (RecyclerView) mo19880a(R.id.list);
        C8271i.m35382a((Object) recyclerView2, str);
        recyclerView2.setFocusable(false);
        this.f11840d.setItems(C8187k.m35271b(new OrderWorkerItem(null, 1, null), new OrderWorkerItem(null, 1, null)));
        this.f11839c.setOnItemBind(new C3306b(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final void m14367b(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.5f, 1, 0.0f);
        translateAnimation.setAnimationListener(new C3308c(view));
        translateAnimation.setDuration(300);
        view.startAnimation(translateAnimation);
    }

    /* renamed from: k */
    public void mo19895k() {
        TextView textView = (TextView) mo19880a(R.id.tv_search);
        C8271i.m35382a((Object) textView, "tv_search");
        ezy.p642a.View.m34750a(textView, 0, new C3305a(this), 1, null);
    }
}
