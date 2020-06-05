package com.jiayouya.travel.module.travel.p288ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.base.BaseFragment;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.databinding.ActivityRankingListBinding;
import com.jiayouya.travel.module.common.p259ui.dialog.ShareDilaog;
import com.jiayouya.travel.module.common.widget.SimplePagerAdapter;
import com.jiayouya.travel.module.common.widget.indicator.CommonTabView;
import com.jiayouya.travel.module.common.widget.indicator.RndLinePagerIndicator;
import com.jiayouya.travel.module.travel.p288ui.fragment.CoinRankListFragment;
import com.jiayouya.travel.module.travel.p288ui.fragment.DogRankListFragment;
import com.jiayouya.travel.module.travel.p288ui.fragment.ProfitRankListFragment;
import com.jiayouya.travel.module.travel.p290vm.DogRankListVM;
import ezy.p653ui.widget.round.RoundText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IPagerTitleView;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R$\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\b\u0012\u0006\b\u0001\u0012\u00020\t0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/RankingListActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityRankingListBinding;", "Lcom/jiayouya/travel/module/travel/vm/DogRankListVM;", "()V", "fragments", "", "Lcom/jiayouya/travel/common/base/BaseFragment;", "Landroidx/databinding/ViewDataBinding;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "tabs", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setToolbarAlpha", "", "scrollY", "setupClick", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: RankingListActivity.kt */
/* renamed from: com.jiayouya.travel.module.travel.ui.RankingListActivity */
public final class RankingListActivity extends BaseActivity<ActivityRankingListBinding, DogRankListVM> {
    /* renamed from: c */
    private final List<BaseFragment<? extends ViewDataBinding, ? extends BaseViewModel>> f11931c = C8187k.m35271b(new DogRankListFragment(), new ProfitRankListFragment(), new CoinRankListFragment());
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final ArrayList<String> f11932d = C8187k.m35273c("分红犬排行", "收益排行", "金币排行");
    /* renamed from: e */
    private HashMap f11933e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RankingListActivity.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.RankingListActivity$a */
    static final class C3335a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ RankingListActivity this$0;

        C3335a(RankingListActivity rankingListActivity) {
            this.this$0 = rankingListActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            new ShareDilaog(this.this$0, null, 2, null).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, mo39189d2 = {"com/jiayouya/travel/module/travel/ui/RankingListActivity$setupView$1", "Lnet/lucode/hackware/magicindicator/buildins/commonnavigator/abs/CommonNavigatorAdapter;", "getCount", "", "getIndicator", "Lnet/lucode/hackware/magicindicator/buildins/commonnavigator/abs/IPagerIndicator;", "context", "Landroid/content/Context;", "getTitleView", "Lnet/lucode/hackware/magicindicator/buildins/commonnavigator/abs/IPagerTitleView;", "index", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: RankingListActivity.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.RankingListActivity$b */
    public static final class C3336b extends CommonNavigatorAdapter {
        /* renamed from: a */
        final /* synthetic */ RankingListActivity f11934a;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: RankingListActivity.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.RankingListActivity$b$a */
        static final class C3337a extends Lambda implements C8247b<View, Unit> {
            final /* synthetic */ int $index;
            final /* synthetic */ C3336b this$0;

            C3337a(C3336b bVar, int i) {
                this.this$0 = bVar;
                this.$index = i;
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.f27778a;
            }

            public final void invoke(View view) {
                C8271i.m35386b(view, "it");
                ViewPager viewPager = (ViewPager) this.this$0.f11934a.mo19852a(R.id.view_pager);
                C8271i.m35382a((Object) viewPager, "view_pager");
                viewPager.setCurrentItem(this.$index);
            }
        }

        C3336b(RankingListActivity rankingListActivity) {
            this.f11934a = rankingListActivity;
        }

        /* renamed from: a */
        public IPagerTitleView mo21561a(Context context, int i) {
            if (context == null) {
                C8271i.m35380a();
            }
            Object obj = this.f11934a.f11932d.get(i);
            C8271i.m35382a(obj, "tabs[index]");
            CommonTabView commonTabView = new CommonTabView(context, (String) obj);
            commonTabView.setSelectedBold(true);
            commonTabView.setNormalTextSize(14.0f);
            commonTabView.setSelectedTextSize(16.0f);
            commonTabView.setNormalColor(GloblaEx.m12811a((int) R.color.c333333));
            commonTabView.setSelectedColor(GloblaEx.m12811a((int) R.color.green_36AE55));
            ezy.p642a.View.m34750a(commonTabView, 0, new C3337a(this, i), 1, null);
            return commonTabView;
        }

        /* renamed from: a */
        public int mo21559a() {
            return this.f11934a.f11932d.size();
        }

        /* renamed from: a */
        public IPagerIndicator mo21560a(Context context) {
            RndLinePagerIndicator rndLinePagerIndicator = new RndLinePagerIndicator(this.f11934a, 0, 0, 6, null);
            rndLinePagerIndicator.setMode(2);
            rndLinePagerIndicator.setLineWidth((float) ezy.p642a.Context.m34741a(this.f11934a, 30.0f));
            return rndLinePagerIndicator;
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11933e == null) {
            this.f11933e = new HashMap();
        }
        View view = (View) this.f11933e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11933e.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_ranking_list;
    }

    /* renamed from: d */
    public Class<DogRankListVM> mo19861d() {
        return DogRankListVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        mo19856a(false);
        ViewPager viewPager = (ViewPager) mo19852a(R.id.view_pager);
        C8271i.m35382a((Object) viewPager, "view_pager");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Object[] array = this.f11931c.toArray(new BaseFragment[0]);
        if (array != null) {
            viewPager.setAdapter(new SimplePagerAdapter(supportFragmentManager, (Fragment[]) array));
            CommonNavigator commonNavigator = new CommonNavigator(this);
            commonNavigator.setAdjustMode(true);
            commonNavigator.setAdapter(new C3336b(this));
            MagicIndicator magicIndicator = (MagicIndicator) mo19852a(R.id.lyt_tab);
            C8271i.m35382a((Object) magicIndicator, "lyt_tab");
            magicIndicator.setNavigator(commonNavigator);
            ViewPagerHelper.m35751a((MagicIndicator) mo19852a(R.id.lyt_tab), (ViewPager) mo19852a(R.id.view_pager));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* renamed from: k */
    public void mo19868k() {
        RoundText roundText = (RoundText) mo19852a(R.id.btn_share);
        C8271i.m35382a((Object) roundText, "btn_share");
        ezy.p642a.View.m34750a(roundText, 0, new C3335a(this), 1, null);
    }
}
