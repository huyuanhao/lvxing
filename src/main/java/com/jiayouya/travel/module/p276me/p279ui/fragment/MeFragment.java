package com.jiayouya.travel.module.p276me.p279ui.fragment;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseFragment;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.OnItemClickListener;
import com.jiayouya.travel.common.p244b.AdapterEx;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.common.widget.ItemTypes;
import com.jiayouya.travel.databinding.FragmentMeBinding;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.main.p275vm.MeVM;
import com.jiayouya.travel.module.p276me.data.DogProgressRsp;
import com.jiayouya.travel.module.p276me.data.MeItem;
import com.jiayouya.travel.module.p276me.data.MeMenu;
import com.jiayouya.travel.module.p276me.data.TaskItem;
import com.jiayouya.travel.module.p276me.p279ui.dialog.GetBonusDogDilaog;
import com.jiayouya.travel.module.travel.data.C3325HB;
import com.jiayouya.travel.module.travel.p288ui.p289a.HbDilaog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p528b.OnRefreshListener;
import ezy.p653ui.widget.recyclerview.adapter.MultiTypeAdapter;
import ezy.p653ui.widget.recyclerview.decoration.FlexibleDividerDecoration.VisibilityProvider;
import ezy.p653ui.widget.recyclerview.decoration.HorizontalDividerItemDecoration.Builder;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/fragment/MeFragment;", "Lcom/jiayouya/travel/common/base/BaseFragment;", "Lcom/jiayouya/travel/databinding/FragmentMeBinding;", "Lcom/jiayouya/travel/module/main/vm/MeVM;", "()V", "adapter", "Lezy/ui/widget/recyclerview/adapter/MultiTypeAdapter;", "dividerType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "normalType", "taskType", "fetchData", "", "isRefresh", "", "getLayoutId", "", "initTypes", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "loadVideoAd", "onResume", "providerViewModelClass", "Ljava/lang/Class;", "setUserVisibleHint", "isVisibleToUser", "setupClick", "setupObserver", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MeFragment.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.fragment.MeFragment */
public final class MeFragment extends BaseFragment<FragmentMeBinding, MeVM> {
    /* renamed from: c */
    private final BindingType f11694c = BindingType.create(MeItem.class, R.layout.item_me_normal, 1);
    /* renamed from: d */
    private final BindingType f11695d = BindingType.create(TaskItem.class, R.layout.item_me_task, 2);
    /* renamed from: e */
    private final BindingType f11696e = BindingType.create(MeItem.class, R.layout.item_me_divider, 3);
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final MultiTypeAdapter f11697f = new MultiTypeAdapter(this.f11694c, this.f11695d, this.f11696e, ItemTypes.f9670a.mo20024a());
    /* renamed from: g */
    private HashMap f11698g;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MeFragment.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.fragment.MeFragment$a */
    static final class C3231a implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ MeFragment f11699a;

        C3231a(MeFragment meFragment) {
            this.f11699a = meFragment;
        }

        /* renamed from: a */
        public final void mo19912a(View view, int i, long j) {
            Object item = this.f11699a.f11697f.getItem(i);
            if (item != null) {
                TaskItem taskItem = (TaskItem) item;
                if (taskItem.getHbId() != 0) {
                    C8271i.m35382a((Object) view, "view");
                    Context context = view.getContext();
                    C8271i.m35382a((Object) context, "view.context");
                    C3325HB hb = new C3325HB(taskItem.getTitle(), String.valueOf(taskItem.getHbId()), null, null, 0, 0, 60, null);
                    new HbDilaog(context, hb, new C8247b<Integer, Unit>(this) {
                        final /* synthetic */ C3231a this$0;

                        {
                            this.this$0 = r1;
                        }

                        public /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.f27778a;
                        }

                        public final void invoke(int i) {
                            MeFragment.m14192d(this.this$0.f11699a).mo21190d();
                        }
                    }).show();
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.module.me.data.TaskItem");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MeFragment.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.fragment.MeFragment$b */
    static final class C3233b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ MeFragment this$0;

        C3233b(MeFragment meFragment) {
            this.this$0 = meFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            DogProgressRsp a = MeFragment.m14191c(this.this$0).mo20150a();
            if (a == null || a.getPercent() != 100.0f) {
                Router.m12969a(Router.f9644a, "/me/bonusDog", null, null, 6, null);
                return;
            }
            Context context = view.getContext();
            C8271i.m35382a((Object) context, "it.context");
            new GetBonusDogDilaog(context, new C8246a<Unit>(this) {
                final /* synthetic */ C3233b this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    MeFragment.m14192d(this.this$0.this$0).mo21191e();
                }
            }).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "Lcom/jiayouya/travel/module/me/data/MeMenu;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MeFragment.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.fragment.MeFragment$c */
    static final class C3235c<T> implements Observer<List<? extends MeMenu>> {
        /* renamed from: a */
        final /* synthetic */ MeFragment f11700a;

        C3235c(MeFragment meFragment) {
            this.f11700a = meFragment;
        }

        /* renamed from: a */
        public final void onChanged(List<? extends MeMenu> list) {
            this.f11700a.f11697f.setItems(list);
            this.f11700a.m14193s();
            this.f11700a.f11697f.notifyDataSetChanged();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/data/DogProgressRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MeFragment.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.fragment.MeFragment$d */
    static final class C3236d<T> implements Observer<DogProgressRsp> {
        /* renamed from: a */
        final /* synthetic */ MeFragment f11701a;

        C3236d(MeFragment meFragment) {
            this.f11701a = meFragment;
        }

        /* renamed from: a */
        public final void onChanged(DogProgressRsp dogProgressRsp) {
            MeFragment.m14191c(this.f11701a).mo20152a(dogProgressRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/User;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MeFragment.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.fragment.MeFragment$e */
    static final class C3237e<T> implements Observer<User> {
        /* renamed from: a */
        final /* synthetic */ MeFragment f11702a;

        C3237e(MeFragment meFragment) {
            this.f11702a = meFragment;
        }

        /* renamed from: a */
        public final void onChanged(User user) {
            MeFragment.m14191c(this.f11702a).mo20151a(user);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "position", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "shouldHideDivider"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MeFragment.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.fragment.MeFragment$f */
    static final class C3238f implements VisibilityProvider {
        /* renamed from: a */
        final /* synthetic */ MeFragment f11703a;

        C3238f(MeFragment meFragment) {
            this.f11703a = meFragment;
        }

        public final boolean shouldHideDivider(int i, RecyclerView recyclerView) {
            int itemCount = this.f11703a.f11697f.getItemCount();
            if (i < 0 || itemCount <= i) {
                return true;
            }
            Object item = this.f11703a.f11697f.getItem(i);
            if (item != null) {
                MeMenu meMenu = (MeMenu) item;
                if (!(!C8271i.m35384a((Object) "divider", (Object) meMenu.getTitle())) || !meMenu.getHasNext()) {
                    return true;
                }
                return false;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.module.me.data.MeMenu");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "onRefresh"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MeFragment.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.fragment.MeFragment$g */
    static final class C3239g implements OnRefreshListener {
        /* renamed from: a */
        final /* synthetic */ MeFragment f11704a;

        C3239g(MeFragment meFragment) {
            this.f11704a = meFragment;
        }

        /* renamed from: a_ */
        public final void mo20372a_(RefreshLayout jVar) {
            C8271i.m35386b(jVar, "it");
            BaseFragment.m12877a(this.f11704a, false, 1, null);
        }
    }

    /* renamed from: a */
    public View mo19880a(int i) {
        if (this.f11698g == null) {
            this.f11698g = new HashMap();
        }
        View view = (View) this.f11698g.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this.f11698g.put(Integer.valueOf(i), view);
        }
        return view;
    }

    /* renamed from: l */
    public int mo19896l() {
        return R.layout.fragment_me;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo19902r();
    }

    /* renamed from: r */
    public void mo19902r() {
        HashMap hashMap = this.f11698g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* renamed from: c */
    public static final /* synthetic */ FragmentMeBinding m14191c(MeFragment meFragment) {
        return (FragmentMeBinding) meFragment.mo19887c();
    }

    /* renamed from: d */
    public static final /* synthetic */ MeVM m14192d(MeFragment meFragment) {
        return (MeVM) meFragment.mo19881a();
    }

    /* renamed from: e */
    public Class<MeVM> mo19889e() {
        return MeVM.class;
    }

    /* renamed from: f */
    public void mo19890f() {
        RecyclerView recyclerView = (RecyclerView) mo19880a(R.id.list);
        String str = "list";
        C8271i.m35382a((Object) recyclerView, str);
        recyclerView.setFocusable(false);
        RecyclerView recyclerView2 = (RecyclerView) mo19880a(R.id.list);
        C8271i.m35382a((Object) recyclerView2, str);
        recyclerView2.setAdapter(this.f11697f);
        ((RecyclerView) mo19880a(R.id.list)).addItemDecoration(((Builder) ((Builder) new Builder(getContext()).visibilityProvider(new C3238f(this))).drawable((int) R.drawable.divider)).build());
        ((SmartRefreshLayout) mo19880a(R.id.refresh)).mo30862a((OnRefreshListener) new C3239g(this));
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) mo19880a(R.id.refresh);
        C8271i.m35382a((Object) smartRefreshLayout, "refresh");
        mo19882a((View) smartRefreshLayout);
    }

    /* renamed from: a */
    public void mo19884a(boolean z) {
        ((MeVM) mo19881a()).mo21190d();
        ((MeVM) mo19881a()).mo21191e();
        ResidentMemoryModel residentMemoryModel = ResidentMemoryModel.f11323a;
        FragmentActivity activity = getActivity();
        if (!(activity instanceof AppCompatActivity)) {
            activity = null;
        }
        ResidentMemoryModel.m13597a(residentMemoryModel, (AppCompatActivity) activity, null, null, 6, null);
    }

    /* renamed from: g */
    public void mo19891g() {
        super.mo19891g();
        LifecycleOwner lifecycleOwner = this;
        ((MeVM) mo19881a()).mo21188b().observe(lifecycleOwner, new C3235c(this));
        ((MeVM) mo19881a()).mo21189c().observe(lifecycleOwner, new C3236d(this));
        ResidentMemoryModel.f11323a.mo20737b().observe(lifecycleOwner, new C3237e(this));
    }

    /* renamed from: h */
    public boolean mo19892h() {
        return AdapterEx.m12807a(this.f11697f);
    }

    /* renamed from: i */
    public boolean mo19893i() {
        return AdapterEx.m12807a(this.f11697f);
    }

    /* renamed from: k */
    public void mo19895k() {
        this.f11695d.setOnItemClick(new C3231a(this));
        FrameLayout frameLayout = (FrameLayout) mo19880a(R.id.lyt_progress);
        C8271i.m35382a((Object) frameLayout, "lyt_progress");
        ezy.p642a.View.m34750a(frameLayout, 0, new C3233b(this), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: s */
    public final void m14193s() {
        boolean z;
        try {
            List items = this.f11697f.getItems();
            if (items != null) {
                int i = 0;
                for (Object next : items) {
                    int i2 = i + 1;
                    if (i < 0) {
                        C8187k.m35272b();
                    }
                    MeMenu meMenu = (MeMenu) next;
                    String str = "divider";
                    boolean z2 = true;
                    if (i != 0) {
                        if (!C8271i.m35384a((Object) ((MeMenu) items.get(i - 1)).getTitle(), (Object) str)) {
                            z = true;
                            meMenu.setHasPre(z);
                            if (i != items.size() - 1 || !(!C8271i.m35384a((Object) ((MeMenu) items.get(i2)).getTitle(), (Object) str))) {
                                z2 = false;
                            }
                            meMenu.setHasNext(z2);
                            i = i2;
                        }
                    }
                    z = false;
                    meMenu.setHasPre(z);
                    if (i != items.size() - 1) {
                    }
                    z2 = false;
                    meMenu.setHasNext(z2);
                    i = i2;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.jiayouya.travel.module.me.data.MeMenu>");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && mo19888d()) {
            BaseFragment.m12877a(this, false, 1, null);
        }
    }

    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            BaseFragment.m12877a(this, false, 1, null);
        }
    }
}
