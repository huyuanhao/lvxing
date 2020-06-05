package com.jiayouya.travel.module.group.p268ui.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseFragment;
import com.jiayouya.travel.databinding.FragmentTourGroupBinding;
import com.jiayouya.travel.module.common.data.ParentRsp;
import com.jiayouya.travel.module.common.p259ui.dialog.DialogManager;
import com.jiayouya.travel.module.common.p259ui.dialog.ShareDilaog;
import com.jiayouya.travel.module.group.data.Channel;
import com.jiayouya.travel.module.group.data.GroupIndexRsp;
import com.jiayouya.travel.module.group.data.TargetRewards;
import com.jiayouya.travel.module.group.p268ui.dialog.AchieveGoalDilaog;
import com.jiayouya.travel.module.group.p268ui.dialog.ChannelExplainDialog;
import com.jiayouya.travel.module.group.p268ui.dialog.TargetExplainDialog;
import com.jiayouya.travel.module.group.p268ui.dialog.TotalProfitDialog;
import com.jiayouya.travel.module.group.p268ui.dialog.UpgradeChannelDilaog;
import com.jiayouya.travel.module.main.p275vm.TourGroupVM;
import com.jiayouya.travel.module.p276me.p279ui.dialog.MyInviterDilaog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p528b.OnRefreshListener;
import ezy.p653ui.widget.round.RoundText;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/ui/fragment/TourGroupFragment;", "Lcom/jiayouya/travel/common/base/BaseFragment;", "Lcom/jiayouya/travel/databinding/FragmentTourGroupBinding;", "Lcom/jiayouya/travel/module/main/vm/TourGroupVM;", "()V", "fetchData", "", "isRefresh", "", "getLayoutId", "", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "onResume", "providerViewModelClass", "Ljava/lang/Class;", "setUserVisibleHint", "isVisibleToUser", "setupClick", "setupObserver", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TourGroupFragment.kt */
/* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment */
public final class TourGroupFragment extends BaseFragment<FragmentTourGroupBinding, TourGroupVM> {
    /* renamed from: c */
    private HashMap f11501c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$a */
    static final class C3053a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TourGroupFragment this$0;

        C3053a(TourGroupFragment tourGroupFragment) {
            this.this$0 = tourGroupFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            FragmentActivity activity = this.this$0.getActivity();
            if (activity == null) {
                C8271i.m35380a();
            }
            C8271i.m35382a((Object) activity, "activity!!");
            new ShareDilaog(activity, null, 2, null).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$b */
    static final class C3054b extends Lambda implements C8247b<View, Unit> {
        public static final C3054b INSTANCE = new C3054b();

        C3054b() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Context context = view.getContext();
            C8271i.m35382a((Object) context, "it.context");
            new TotalProfitDialog(context).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$c */
    static final class C3055c extends Lambda implements C8247b<View, Unit> {
        public static final C3055c INSTANCE = new C3055c();

        C3055c() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Context context = view.getContext();
            C8271i.m35382a((Object) context, "it.context");
            new TargetExplainDialog(context).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$d */
    static final class C3056d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TourGroupFragment this$0;

        C3056d(TourGroupFragment tourGroupFragment) {
            this.this$0 = tourGroupFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            FragmentActivity activity = this.this$0.getActivity();
            if (activity == null) {
                C8271i.m35380a();
            }
            C8271i.m35382a((Object) activity, "activity!!");
            new ShareDilaog(activity, null, 2, null).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$e */
    static final class C3057e extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TourGroupFragment this$0;

        C3057e(TourGroupFragment tourGroupFragment) {
            this.this$0 = tourGroupFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            FragmentActivity activity = this.this$0.getActivity();
            if (activity == null) {
                C8271i.m35380a();
            }
            C8271i.m35382a((Object) activity, "activity!!");
            new ShareDilaog(activity, null, 2, null).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$f */
    static final class C3058f extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TourGroupFragment this$0;

        C3058f(TourGroupFragment tourGroupFragment) {
            this.this$0 = tourGroupFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            TourGroupFragment.m13797a(this.this$0).mo21200f();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$g */
    static final class C3059g extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TourGroupFragment this$0;

        C3059g(TourGroupFragment tourGroupFragment) {
            this.this$0 = tourGroupFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            TourGroupFragment.m13797a(this.this$0).mo21201g();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$h */
    static final class C3060h extends Lambda implements C8247b<View, Unit> {
        public static final C3060h INSTANCE = new C3060h();

        C3060h() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Context context = view.getContext();
            C8271i.m35382a((Object) context, "it.context");
            new ChannelExplainDialog(context).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$i */
    static final class C3061i extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TourGroupFragment this$0;

        C3061i(TourGroupFragment tourGroupFragment) {
            this.this$0 = tourGroupFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            GroupIndexRsp a = TourGroupFragment.m13798b(this.this$0).mo20153a();
            if (a != null) {
                Channel channel = a.getChannel();
                if (channel != null) {
                    Context context = this.this$0.getContext();
                    if (context == null) {
                        C8271i.m35380a();
                    }
                    C8271i.m35382a((Object) context, "context!!");
                    new UpgradeChannelDilaog(context, channel.getContactInfo()).show();
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/group/data/GroupIndexRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$j */
    static final class C3062j<T> implements Observer<GroupIndexRsp> {
        /* renamed from: a */
        final /* synthetic */ TourGroupFragment f11502a;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, mo39189d2 = {"<anonymous>", "", "invoke", "com/jiayouya/travel/module/group/ui/fragment/TourGroupFragment$setupObserver$1$1$1$1", "com/jiayouya/travel/module/group/ui/fragment/TourGroupFragment$setupObserver$1$$special$$inlined$apply$lambda$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: TourGroupFragment.kt */
        /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$j$a */
        static final class C3063a extends Lambda implements C8246a<Unit> {
            final /* synthetic */ TargetRewards $it$inlined;
            final /* synthetic */ C3062j this$0;

            C3063a(TargetRewards targetRewards, C3062j jVar) {
                this.$it$inlined = targetRewards;
                this.this$0 = jVar;
                super(0);
            }

            public final void invoke() {
                TourGroupFragment.m13797a(this.this$0.f11502a).mo21195a(this.$it$inlined.getId());
            }
        }

        C3062j(TourGroupFragment tourGroupFragment) {
            this.f11502a = tourGroupFragment;
        }

        /* renamed from: a */
        public final void onChanged(GroupIndexRsp groupIndexRsp) {
            TourGroupFragment.m13798b(this.f11502a).mo20154a(groupIndexRsp);
            List<TargetRewards> targetRewards = groupIndexRsp.getTargetRewards();
            if (targetRewards != null) {
                for (TargetRewards targetRewards2 : targetRewards) {
                    DialogManager a = DialogManager.f11300b.mo20713a();
                    Context context = this.f11502a.getContext();
                    if (context == null) {
                        C8271i.m35380a();
                    }
                    C8271i.m35382a((Object) context, "context!!");
                    a.mo20712a(new AchieveGoalDilaog(context, targetRewards2, new C3063a(targetRewards2, this)));
                    a.mo20711a();
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/ParentRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$k */
    static final class C3064k<T> implements Observer<ParentRsp> {
        /* renamed from: a */
        final /* synthetic */ TourGroupFragment f11503a;

        C3064k(TourGroupFragment tourGroupFragment) {
            this.f11503a = tourGroupFragment;
        }

        /* renamed from: a */
        public final void onChanged(ParentRsp parentRsp) {
            Context context = this.f11503a.getContext();
            if (context == null) {
                C8271i.m35380a();
            }
            C8271i.m35382a((Object) context, "context!!");
            C8271i.m35382a((Object) parentRsp, "it");
            MyInviterDilaog fVar = new MyInviterDilaog(context, parentRsp, 0, 4, null);
            fVar.show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/ParentRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$l */
    static final class C3065l<T> implements Observer<ParentRsp> {
        /* renamed from: a */
        final /* synthetic */ TourGroupFragment f11504a;

        C3065l(TourGroupFragment tourGroupFragment) {
            this.f11504a = tourGroupFragment;
        }

        /* renamed from: a */
        public final void onChanged(ParentRsp parentRsp) {
            Context context = this.f11504a.getContext();
            if (context == null) {
                C8271i.m35380a();
            }
            C8271i.m35382a((Object) context, "context!!");
            C8271i.m35382a((Object) parentRsp, "it");
            MyInviterDilaog fVar = new MyInviterDilaog(context, parentRsp, 0, 4, null);
            fVar.show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "onRefresh"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupFragment.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.fragment.TourGroupFragment$m */
    static final class C3066m implements OnRefreshListener {
        /* renamed from: a */
        final /* synthetic */ TourGroupFragment f11505a;

        C3066m(TourGroupFragment tourGroupFragment) {
            this.f11505a = tourGroupFragment;
        }

        /* renamed from: a_ */
        public final void mo20372a_(RefreshLayout jVar) {
            C8271i.m35386b(jVar, "it");
            BaseFragment.m12877a(this.f11505a, false, 1, null);
        }
    }

    /* renamed from: a */
    public View mo19880a(int i) {
        if (this.f11501c == null) {
            this.f11501c = new HashMap();
        }
        View view = (View) this.f11501c.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this.f11501c.put(Integer.valueOf(i), view);
        }
        return view;
    }

    /* renamed from: l */
    public int mo19896l() {
        return R.layout.fragment_tour_group;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo19902r();
    }

    /* renamed from: r */
    public void mo19902r() {
        HashMap hashMap = this.f11501c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ TourGroupVM m13797a(TourGroupFragment tourGroupFragment) {
        return (TourGroupVM) tourGroupFragment.mo19881a();
    }

    /* renamed from: b */
    public static final /* synthetic */ FragmentTourGroupBinding m13798b(TourGroupFragment tourGroupFragment) {
        return (FragmentTourGroupBinding) tourGroupFragment.mo19887c();
    }

    /* renamed from: e */
    public Class<TourGroupVM> mo19889e() {
        return TourGroupVM.class;
    }

    /* renamed from: f */
    public void mo19890f() {
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) mo19880a(R.id.refresh);
        C8271i.m35382a((Object) smartRefreshLayout, "refresh");
        mo19882a((View) smartRefreshLayout);
        ((SmartRefreshLayout) mo19880a(R.id.refresh)).mo30862a((OnRefreshListener) new C3066m(this));
    }

    /* renamed from: k */
    public void mo19895k() {
        RoundText roundText = (RoundText) mo19880a(R.id.btn_invite);
        C8271i.m35382a((Object) roundText, "btn_invite");
        ezy.p642a.View.m34750a(roundText, 0, new C3053a(this), 1, null);
        TextView textView = (TextView) mo19880a(R.id.tv_total_profit);
        C8271i.m35382a((Object) textView, "tv_total_profit");
        ezy.p642a.View.m34750a(textView, 0, C3054b.INSTANCE, 1, null);
        TextView textView2 = (TextView) mo19880a(R.id.tv_target);
        C8271i.m35382a((Object) textView2, "tv_target");
        ezy.p642a.View.m34750a(textView2, 0, C3055c.INSTANCE, 1, null);
        TextView textView3 = (TextView) mo19880a(R.id.tv_friend_auth);
        C8271i.m35382a((Object) textView3, "tv_friend_auth");
        ezy.p642a.View.m34750a(textView3, 0, new C3056d(this), 1, null);
        TextView textView4 = (TextView) mo19880a(R.id.tv_notify_friend);
        C8271i.m35382a((Object) textView4, "tv_notify_friend");
        ezy.p642a.View.m34750a(textView4, 0, new C3057e(this), 1, null);
        TextView textView5 = (TextView) mo19880a(R.id.tv_contact_inviter);
        C8271i.m35382a((Object) textView5, "tv_contact_inviter");
        ezy.p642a.View.m34750a(textView5, 0, new C3058f(this), 1, null);
        TextView textView6 = (TextView) mo19880a(R.id.tv_contact_star);
        C8271i.m35382a((Object) textView6, "tv_contact_star");
        ezy.p642a.View.m34750a(textView6, 0, new C3059g(this), 1, null);
        TextView textView7 = (TextView) mo19880a(R.id.tv_channel_explain);
        C8271i.m35382a((Object) textView7, "tv_channel_explain");
        ezy.p642a.View.m34750a(textView7, 0, C3060h.INSTANCE, 1, null);
        RoundText roundText2 = (RoundText) mo19880a(R.id.btn_upgrade_channel);
        C8271i.m35382a((Object) roundText2, "btn_upgrade_channel");
        ezy.p642a.View.m34750a(roundText2, 0, new C3061i(this), 1, null);
    }

    /* renamed from: a */
    public void mo19884a(boolean z) {
        ((TourGroupVM) mo19881a()).mo21199e();
    }

    /* renamed from: h */
    public boolean mo19892h() {
        return ((FragmentTourGroupBinding) mo19887c()).mo20153a() == null;
    }

    /* renamed from: i */
    public boolean mo19893i() {
        return ((FragmentTourGroupBinding) mo19887c()).mo20153a() == null;
    }

    /* renamed from: g */
    public void mo19891g() {
        super.mo19891g();
        LifecycleOwner lifecycleOwner = this;
        ((TourGroupVM) mo19881a()).mo21196b().observe(lifecycleOwner, new C3062j(this));
        ((TourGroupVM) mo19881a()).mo21197c().observe(lifecycleOwner, new C3064k(this));
        ((TourGroupVM) mo19881a()).mo21198d().observe(lifecycleOwner, new C3065l(this));
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
