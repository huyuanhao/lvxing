package com.jiayouya.travel.module.p276me.p279ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar.C0954a;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.ClickableBindingHolder;
import com.jiayouya.travel.common.binding.OnBindListener;
import com.jiayouya.travel.common.binding.OnItemClickListener;
import com.jiayouya.travel.common.p244b.ResourceEx;
import com.jiayouya.travel.common.widget.RndCornerProgressBar;
import com.jiayouya.travel.databinding.ActivityMapBinding;
import com.jiayouya.travel.databinding.ItemMapBinding;
import com.jiayouya.travel.module.common.data.Resource;
import com.jiayouya.travel.module.group.data.City;
import com.jiayouya.travel.module.group.data.ClaimCityReward;
import com.jiayouya.travel.module.group.data.RewardItem;
import com.jiayouya.travel.module.group.data.RewardItemKt;
import com.jiayouya.travel.module.group.data.TravelCity;
import com.jiayouya.travel.module.p276me.data.DogProgressRsp;
import com.jiayouya.travel.module.p276me.data.MapItem;
import com.jiayouya.travel.module.p276me.p279ui.dialog.TravelCityDilaog;
import com.jiayouya.travel.module.p276me.p280vm.MapVM;
import com.jiayouya.travel.module.p276me.widget.MapView;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.collections.C8194y;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.p677d.C8238n;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH\u0016J\u0016\u0010\u001b\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\u0012\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/MapActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityMapBinding;", "Lcom/jiayouya/travel/module/me/vm/MapVM;", "()V", "adapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "Lcom/jiayouya/travel/module/group/data/RewardItem;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "items", "", "fetchData", "", "isRefresh", "", "getLayoutId", "", "initMapView", "city", "", "Lcom/jiayouya/travel/module/group/data/City;", "curId", "nextId", "providerViewModelClass", "Ljava/lang/Class;", "setRewardItems", "list", "setupClick", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MapActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.MapActivity */
public final class MapActivity extends BaseActivity<ActivityMapBinding, MapVM> {
    /* renamed from: c */
    private final BindingType f11597c = BindingType.create(RewardItem.class, (int) R.layout.item_map);
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final SingleTypeAdapter<RewardItem> f11598d = new SingleTypeAdapter<>(this.f11597c);
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final List<RewardItem> f11599e = new ArrayList();
    /* renamed from: f */
    private HashMap f11600f;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.MapActivity$a */
    static final class C3142a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ MapActivity this$0;

        C3142a(MapActivity mapActivity) {
            this.this$0 = mapActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.finish();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.MapActivity$b */
    static final class C3143b implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ MapActivity f11601a;

        C3143b(MapActivity mapActivity) {
            this.f11601a = mapActivity;
        }

        /* renamed from: a */
        public final void mo19912a(View view, int i, long j) {
            RewardItem rewardItem = (RewardItem) this.f11601a.f11598d.getItem(i);
            if (rewardItem.getStatus() == 1) {
                ((MapVM) this.f11601a.mo19853a()).mo21463a(rewardItem.getId());
                if (rewardItem.isNowCity()) {
                    rewardItem.setStatus(2);
                    this.f11601a.f11598d.notifyDataSetChanged();
                } else {
                    int i2 = 0;
                    Iterator it = this.f11601a.f11599e.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i2 = -1;
                            break;
                        } else if (C8271i.m35384a((Object) ((RewardItem) it.next()).getId(), (Object) rewardItem.getId())) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 != -1) {
                        this.f11601a.f11599e.remove(i2);
                        MapActivity mapActivity = this.f11601a;
                        mapActivity.m14012a(mapActivity.f11599e);
                    }
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/group/data/TravelCity;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.MapActivity$c */
    static final class C3144c<T> implements Observer<TravelCity> {
        /* renamed from: a */
        final /* synthetic */ MapActivity f11602a;

        C3144c(MapActivity mapActivity) {
            this.f11602a = mapActivity;
        }

        /* renamed from: a */
        public final void onChanged(TravelCity travelCity) {
            MapActivity.m14009a(this.f11602a).mo20090a(travelCity);
            this.f11602a.m14013a(travelCity.getCity(), travelCity.getNowCity().getId(), travelCity.getNextCity().getId());
            this.f11602a.f11599e.clear();
            this.f11602a.f11599e.addAll(travelCity.getRewardList());
            this.f11602a.m14012a(travelCity.getRewardList());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/data/DogProgressRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.MapActivity$d */
    static final class C3145d<T> implements Observer<DogProgressRsp> {
        /* renamed from: a */
        final /* synthetic */ MapActivity f11603a;

        C3145d(MapActivity mapActivity) {
            this.f11603a = mapActivity;
        }

        /* renamed from: a */
        public final void onChanged(DogProgressRsp dogProgressRsp) {
            MapActivity.m14009a(this.f11603a).mo20091a(dogProgressRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/Resource;", "Lcom/jiayouya/travel/module/group/data/ClaimCityReward;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.MapActivity$e */
    static final class C3146e<T> implements Observer<Resource<ClaimCityReward>> {
        /* renamed from: a */
        final /* synthetic */ MapActivity f11604a;

        C3146e(MapActivity mapActivity) {
            this.f11604a = mapActivity;
        }

        /* renamed from: a */
        public final void onChanged(final Resource<ClaimCityReward> resource) {
            C8271i.m35382a((Object) resource, "it");
            ResourceEx.m12833a(resource, new C8246a<Unit>(this) {
                final /* synthetic */ C3146e this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    Object extra = resource.getExtra();
                    List items = this.this$0.f11604a.f11598d.getItems();
                    C8271i.m35382a((Object) items, "adapter.items");
                    Iterator it = items.iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        } else if (C8271i.m35384a((Object) ((RewardItem) it.next()).getId(), extra)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    ClaimCityReward claimCityReward = (ClaimCityReward) resource.getData();
                    if (claimCityReward != null) {
                        if (i != -1) {
                            ((RewardItem) this.this$0.f11604a.f11598d.getItems().get(i)).setPercent(claimCityReward.getPercent());
                            this.this$0.f11604a.f11598d.notifyItemChanged(i);
                        }
                        Context context = this.this$0.f11604a;
                        StringBuilder sb = new StringBuilder();
                        sb.append(claimCityReward.getPercent());
                        sb.append('%');
                        new TravelCityDilaog(context, sb.toString()).show();
                    }
                }
            }, null, null, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0003¨\u0006\u00010\u0003¨\u0006\u00012\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, mo39189d2 = {"<anonymous>", "", "holder", "Lcom/jiayouya/travel/common/binding/ClickableBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "kotlin.jvm.PlatformType", "item", "", "onBind"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.MapActivity$f */
    static final class C3148f implements OnBindListener {
        /* renamed from: a */
        public static final C3148f f11605a = new C3148f();

        C3148f() {
        }

        /* renamed from: a */
        public final void mo19911a(ClickableBindingHolder<ViewDataBinding> clickableBindingHolder, Object obj) {
            if (obj != null) {
                RewardItem rewardItem = (RewardItem) obj;
                Binding binding = clickableBindingHolder.binding;
                if (binding != null) {
                    TextView textView = ((ItemMapBinding) binding).f11055a;
                    C8271i.m35382a((Object) textView, "binding.tvPercent");
                    textView.setText(RewardItemKt.formatPercent(rewardItem));
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.databinding.ItemMapBinding");
            }
            throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.module.group.data.RewardItem");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "viewId", "", "progress", "", "isPrimaryProgress", "", "isSecondaryProgress", "onProgressChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.MapActivity$g */
    static final class C3149g implements C0954a {
        /* renamed from: a */
        final /* synthetic */ MapActivity f11606a;

        C3149g(MapActivity mapActivity) {
            this.f11606a = mapActivity;
        }

        /* renamed from: a */
        public final void mo10258a(int i, final float f, boolean z, boolean z2) {
            if (z) {
                ((LinearLayout) this.f11606a.mo19852a(R.id.tv_progress)).post(new Runnable(this) {
                    /* renamed from: a */
                    final /* synthetic */ C3149g f11607a;

                    {
                        this.f11607a = r1;
                    }

                    public final void run() {
                        LinearLayout linearLayout = (LinearLayout) this.f11607a.f11606a.mo19852a(R.id.tv_progress);
                        String str = "tv_progress";
                        C8271i.m35382a((Object) linearLayout, str);
                        float a = (float) ezy.p642a.Context.m34741a(this.f11607a.f11606a, 30.0f);
                        LinearLayout linearLayout2 = (LinearLayout) this.f11607a.f11606a.mo19852a(R.id.tv_progress);
                        C8271i.m35382a((Object) linearLayout2, str);
                        float measuredWidth = a - (((float) linearLayout2.getMeasuredWidth()) / 2.0f);
                        RndCornerProgressBar rndCornerProgressBar = (RndCornerProgressBar) this.f11607a.f11606a.mo19852a(R.id.progress_bar);
                        C8271i.m35382a((Object) rndCornerProgressBar, "progress_bar");
                        linearLayout.setX(measuredWidth + ((((float) rndCornerProgressBar.getMeasuredWidth()) * f) / ((float) 100)));
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11600f == null) {
            this.f11600f = new HashMap();
        }
        View view = (View) this.f11600f.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11600f.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_map;
    }

    /* renamed from: a */
    public static final /* synthetic */ ActivityMapBinding m14009a(MapActivity mapActivity) {
        return (ActivityMapBinding) mapActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<MapVM> mo19861d() {
        return MapVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        mo19856a(false);
        RecyclerView recyclerView = (RecyclerView) mo19852a(R.id.list);
        String str = "list";
        C8271i.m35382a((Object) recyclerView, str);
        recyclerView.setAdapter(this.f11598d);
        RecyclerView recyclerView2 = (RecyclerView) mo19852a(R.id.list);
        C8271i.m35382a((Object) recyclerView2, str);
        recyclerView2.setItemAnimator(null);
        BaseActivity.m12847a(this, false, 1, null);
        this.f11597c.setOnItemBind(C3148f.f11605a);
        ((RndCornerProgressBar) mo19852a(R.id.progress_bar)).setOnProgressChangedListener(new C3149g(this));
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        ((MapVM) mo19853a()).mo21464b().observe(lifecycleOwner, new C3144c(this));
        ((MapVM) mo19853a()).mo21465c().observe(lifecycleOwner, new C3145d(this));
        ((MapVM) mo19853a()).mo21466d().observe(lifecycleOwner, new C3146e(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14012a(List<RewardItem> list) {
        if (list.size() > 6) {
            list = list.subList(0, 6);
        }
        this.f11598d.setItems(list);
        this.f11598d.notifyDataSetChanged();
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((MapVM) mo19853a()).mo21467e();
        ((MapVM) mo19853a()).mo21468f();
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14013a(List<City> list, int i, int i2) {
        Iterable<City> iterable = list;
        Map linkedHashMap = new LinkedHashMap(C8238n.m35355c(C8194y.m35252a(C8187k.m35274a(iterable, 10)), 16));
        for (City city : iterable) {
            linkedHashMap.put(Integer.valueOf(city.getId()), city);
        }
        for (MapItem mapItem : ((MapView) mo19852a(R.id.map_view)).getList()) {
            City city2 = (City) linkedHashMap.get(Integer.valueOf(mapItem.getId()));
            if (city2 != null) {
                mapItem.setName(city2.getName());
                boolean z = true;
                mapItem.setDrawMark(city2.getStatus() != 2);
                mapItem.setScaleMark(city2.getStatus() == 0);
                mapItem.setCurCity(mapItem.getId() == i);
                mapItem.setNextCity(mapItem.getId() == i2);
                if (mapItem.isCurCity() || mapItem.isNextCity() || city2.getStatus() == 0) {
                    z = false;
                }
                mapItem.setCirclePoint(z);
            }
        }
        ((MapView) mo19852a(R.id.map_view)).mo21513a();
    }

    /* renamed from: k */
    public void mo19868k() {
        ImageView imageView = (ImageView) mo19852a(R.id.iv_back);
        C8271i.m35382a((Object) imageView, "iv_back");
        ezy.p642a.View.m34750a(imageView, 0, new C3142a(this), 1, null);
        this.f11597c.setOnItemClick(new C3143b(this));
    }
}
