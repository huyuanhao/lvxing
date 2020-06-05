package com.jiayouya.travel.module.explore.p265ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.LinearInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.C2914d;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.OnItemClickListener;
import com.jiayouya.travel.common.p244b.ResourceEx;
import com.jiayouya.travel.common.p246d.AdExtra;
import com.jiayouya.travel.common.widget.countdownview.CountdownView;
import com.jiayouya.travel.common.widget.countdownview.CountdownView.C2910a;
import com.jiayouya.travel.databinding.ActivityExploreBinding;
import com.jiayouya.travel.module.common.data.AdRsp;
import com.jiayouya.travel.module.common.data.AdRspKt;
import com.jiayouya.travel.module.common.data.Resource;
import com.jiayouya.travel.module.common.p258b.AdReportResultEvent;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.explore.data.DynamicItem;
import com.jiayouya.travel.module.explore.data.ExploreIndex;
import com.jiayouya.travel.module.explore.data.ExploreIndexKt;
import com.jiayouya.travel.module.explore.data.HarvestItem;
import com.jiayouya.travel.module.explore.data.TeamItem;
import com.jiayouya.travel.module.explore.p264b.DogImage;
import com.jiayouya.travel.module.explore.p265ui.dialog.GetDogDilaog;
import com.jiayouya.travel.module.explore.p265ui.dialog.HarvestDialog;
import com.jiayouya.travel.module.explore.p265ui.dialog.RecallDilaog;
import com.jiayouya.travel.module.explore.p265ui.dialog.ResurgenceDialog;
import com.jiayouya.travel.module.explore.p266vm.ExploreVM;
import com.jiayouya.travel.module.explore.widget.ShakeLayout;
import com.jiayouya.travel.module.travel.data.C3325HB;
import com.jiayouya.travel.module.travel.data.GetCoinItem;
import com.jiayouya.travel.module.travel.p288ui.p289a.GetCoinDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.HbDilaog;
import com.travel.adlibrary.AdSdk;
import com.travel.adlibrary.p612a.AdOptions;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p642a.Context;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import ezy.p653ui.widget.round.RoundLayout;
import ezy.p653ui.widget.round.RoundText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.jvm.p679a.C8258m;
import p655io.reactivex.Observable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J(\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0013H\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016J\u001a\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u0013H\u0002J\b\u0010.\u001a\u00020\u001aH\u0014J\u0018\u0010/\u001a\u00020\u001a2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u000101H\u0002J\u0018\u00102\u001a\u00020\u001a2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u000101H\u0002J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\u000304H\u0016J\u0018\u00105\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00106\u001a\u00020\u001eH\u0002J\b\u00107\u001a\u00020\u001aH\u0016J\b\u00108\u001a\u00020\u001aH\u0016J\u0012\u00109\u001a\u00020\u001a2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020\u001aH\u0002J\b\u0010=\u001a\u00020\u001aH\u0002J\u0010\u0010=\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010>\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010?\u001a\u00020\u000eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/ui/ExploreActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityExploreBinding;", "Lcom/jiayouya/travel/module/explore/vm/ExploreVM;", "()V", "d", "Lio/reactivex/disposables/Disposable;", "dynamicAdapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "Lcom/jiayouya/travel/module/explore/data/DynamicItem;", "dynamicType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "farAnim", "Landroid/animation/ObjectAnimator;", "harvestAdapter", "Lcom/jiayouya/travel/module/explore/data/HarvestItem;", "harvestType", "isBgAnimStarted", "", "middleAnim", "nearAnim", "teamAdapter", "Lcom/jiayouya/travel/module/explore/data/TeamItem;", "teamType", "addCoin", "", "createAnim", "curScrollX", "", "", "view", "Landroid/view/View;", "childWidth", "dispose", "fetchData", "isRefresh", "getLayoutId", "getScrollX", "initListView", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "loadVideo", "ad", "Lcom/jiayouya/travel/module/common/data/AdRsp;", "isRevive", "onDestroy", "processHarvest", "list", "", "processTeam", "providerViewModelClass", "Ljava/lang/Class;", "setBgAnim", "dur", "setupClick", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "startBgAnim", "stopBgAnim", "storeBgAnim", "anim", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ExploreActivity.kt */
/* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity */
public final class ExploreActivity extends BaseActivity<ActivityExploreBinding, ExploreVM> {
    /* renamed from: c */
    private final BindingType f11395c = BindingType.create(TeamItem.class, (int) R.layout.item_explore_team);
    /* renamed from: d */
    private final SingleTypeAdapter<TeamItem> f11396d = new SingleTypeAdapter<>(this.f11395c);
    /* renamed from: e */
    private final BindingType f11397e = BindingType.create(HarvestItem.class, (int) R.layout.item_explore_harvest);
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final SingleTypeAdapter<HarvestItem> f11398f = new SingleTypeAdapter<>(this.f11397e);
    /* renamed from: g */
    private final BindingType f11399g = BindingType.create(DynamicItem.class, (int) R.layout.item_explore_dynamic);
    /* access modifiers changed from: private|final */
    /* renamed from: h */
    public final SingleTypeAdapter<DynamicItem> f11400h = new SingleTypeAdapter<>(this.f11399g);
    /* renamed from: i */
    private Disposable f11401i;
    /* renamed from: j */
    private boolean f11402j;
    /* renamed from: k */
    private ObjectAnimator f11403k;
    /* renamed from: l */
    private ObjectAnimator f11404l;
    /* renamed from: m */
    private ObjectAnimator f11405m;
    /* renamed from: n */
    private HashMap f11406n;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Long;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$a */
    static final class C2998a<T> implements Consumer<Long> {
        /* renamed from: a */
        final /* synthetic */ ExploreActivity f11407a;

        C2998a(ExploreActivity exploreActivity) {
            this.f11407a = exploreActivity;
        }

        /* renamed from: a */
        public final void accept(Long l) {
            ((ShakeLayout) this.f11407a.mo19852a(R.id.lyt_shake)).mo20945c();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/jiayouya/travel/module/explore/ui/ExploreActivity$createAnim$1$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$b */
    static final class C2999b implements AnimatorUpdateListener {
        /* renamed from: a */
        final /* synthetic */ ExploreActivity f11408a;
        /* renamed from: b */
        final /* synthetic */ int f11409b;
        /* renamed from: c */
        final /* synthetic */ int f11410c;
        /* renamed from: d */
        final /* synthetic */ long f11411d;
        /* renamed from: e */
        final /* synthetic */ View f11412e;

        C2999b(ExploreActivity exploreActivity, int i, int i2, long j, View view) {
            this.f11408a = exploreActivity;
            this.f11409b = i;
            this.f11410c = i2;
            this.f11411d = j;
            this.f11412e = view;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            C8271i.m35382a((Object) valueAnimator, "it");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                int intValue = ((Integer) animatedValue).intValue();
                this.f11412e.setTag(R.id.tag, Integer.valueOf(intValue));
                if (this.f11409b != 0 && intValue == this.f11410c) {
                    this.f11408a.m13671a(this.f11412e);
                    ObjectAnimator a = this.f11408a.m13669a(0, this.f11411d, this.f11412e, this.f11410c);
                    this.f11408a.m13673a(this.f11412e, a);
                    a.start();
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "userId", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$c */
    static final class C3000c extends Lambda implements C8247b<String, Unit> {
        final /* synthetic */ AdRsp $ad;
        final /* synthetic */ boolean $isRevive;
        final /* synthetic */ ExploreActivity this$0;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: ExploreActivity.kt */
        /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$c$a */
        static final class C3001a extends Lambda implements C8258m<Boolean, Boolean, Unit> {
            final /* synthetic */ C3000c this$0;

            C3001a(C3000c cVar) {
                this.this$0 = cVar;
                super(2);
            }

            public /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                return Unit.f27778a;
            }

            public final void invoke(boolean z, boolean z2) {
                if (!this.this$0.this$0.isFinishing() && !this.this$0.this$0.isDestroyed() && this.this$0.$isRevive) {
                    C2914d.m13181a(new C8246a<Unit>(this) {
                        final /* synthetic */ C3001a this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void invoke() {
                            new ResurgenceDialog(this.this$0.this$0.this$0).show();
                        }
                    }, 100, this.this$0.this$0);
                }
            }
        }

        C3000c(ExploreActivity exploreActivity, AdRsp adRsp, boolean z) {
            this.this$0 = exploreActivity;
            this.$ad = adRsp;
            this.$isRevive = z;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return Unit.f27778a;
        }

        public final void invoke(String str) {
            String str2 = str;
            C8271i.m35386b(str2, "userId");
            AdOptions aVar = r1;
            AdOptions aVar2 = new AdOptions(0, this.this$0, this.$ad.getAdIdVideo(), str2, null, 0, null, AdExtra.m12931a(this.$ad.getAdLogId(), str2, (String) null, 4, (Object) null), 0.0f, AdRspKt.adVideoPlats(this.$ad), 0, false, new C3001a(this), 3440, null);
            AdExtra.m12935a(this.$ad.getAdLogId(), 0.0d);
            AdSdk.f25896a.mo37292a(aVar);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo39189d2 = {"com/jiayouya/travel/module/explore/ui/ExploreActivity$setBgAnim$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$d */
    public static final class C3003d implements OnGlobalLayoutListener {
        /* renamed from: a */
        final /* synthetic */ ExploreActivity f11413a;
        /* renamed from: b */
        final /* synthetic */ View f11414b;
        /* renamed from: c */
        final /* synthetic */ long f11415c;

        C3003d(ExploreActivity exploreActivity, View view, long j) {
            this.f11413a = exploreActivity;
            this.f11414b = view;
            this.f11415c = j;
        }

        public void onGlobalLayout() {
            int measuredWidth;
            this.f11414b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            View view = this.f11414b;
            if (C8271i.m35384a((Object) view, (Object) (HorizontalScrollView) this.f11413a.mo19852a(R.id.far_scroll_view))) {
                ImageView imageView = (ImageView) this.f11413a.mo19852a(R.id.bg_far);
                C8271i.m35382a((Object) imageView, "bg_far");
                measuredWidth = imageView.getMeasuredWidth();
            } else if (C8271i.m35384a((Object) view, (Object) (HorizontalScrollView) this.f11413a.mo19852a(R.id.middle_scroll_view))) {
                ImageView imageView2 = (ImageView) this.f11413a.mo19852a(R.id.bg_middle);
                C8271i.m35382a((Object) imageView2, "bg_middle");
                measuredWidth = imageView2.getMeasuredWidth();
            } else {
                ImageView imageView3 = (ImageView) this.f11413a.mo19852a(R.id.bg_near);
                C8271i.m35382a((Object) imageView3, "bg_near");
                measuredWidth = imageView3.getMeasuredWidth();
            }
            int i = measuredWidth;
            this.f11413a.m13671a(this.f11414b);
            ExploreActivity exploreActivity = this.f11413a;
            ObjectAnimator a = exploreActivity.m13669a(exploreActivity.m13681b(this.f11414b), this.f11415c, this.f11414b, i);
            this.f11413a.m13673a(this.f11414b, a);
            a.start();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$e */
    static final class C3004e extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ ExploreActivity this$0;

        C3004e(ExploreActivity exploreActivity) {
            this.this$0 = exploreActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            new RecallDilaog(this.this$0, new C8246a<Unit>(this) {
                final /* synthetic */ C3004e this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    ((ExploreVM) this.this$0.this$0.mo19853a()).mo20935g();
                }
            }).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$f */
    static final class C3006f extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ ExploreActivity this$0;

        C3006f(ExploreActivity exploreActivity) {
            this.this$0 = exploreActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            String str = "it";
            C8271i.m35386b(view, str);
            ExploreIndex a = ExploreActivity.m13683b(this.this$0).mo20085a();
            if (a != null) {
                C8271i.m35382a((Object) a, str);
                if (ExploreIndexKt.isPlayEnable(a)) {
                    if (!C8271i.m35384a((Object) a.getEnergy(), (Object) "0") || a.getSeconds() > 0) {
                        int status = a.getStatus();
                        int i = status != 1 ? status != 2 ? 7 : 6 : 5;
                        ((ExploreVM) this.this$0.mo19853a()).mo20928a(i);
                    } else {
                        Context.m34744a(this.this$0, "体力值用完啦~", 0, 0, 6, null);
                    }
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$g */
    static final class C3007g extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ ExploreActivity this$0;

        C3007g(ExploreActivity exploreActivity) {
            this.this$0 = exploreActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            new HarvestDialog(this.this$0).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$h */
    static final class C3008h implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ ExploreActivity f11416a;

        C3008h(ExploreActivity exploreActivity) {
            this.f11416a = exploreActivity;
        }

        /* renamed from: a */
        public final void mo19912a(View view, final int i, long j) {
            final HarvestItem harvestItem = (HarvestItem) this.f11416a.f11398f.getItem(i);
            if (harvestItem.getType() != -1) {
                C8271i.m35382a((Object) harvestItem, "item");
                if (ExploreIndexKt.isDog(harvestItem)) {
                    new GetDogDilaog(this.f11416a, harvestItem.getType(), new C8246a<Unit>(this) {
                        final /* synthetic */ C3008h this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void invoke() {
                            ExploreVM exploreVM = (ExploreVM) this.this$0.f11416a.mo19853a();
                            HarvestItem harvestItem = harvestItem;
                            C8271i.m35382a((Object) harvestItem, "item");
                            exploreVM.mo20929a(harvestItem, i);
                        }
                    }).show();
                } else {
                    ((ExploreVM) this.f11416a.mo19853a()).mo20929a(harvestItem, i);
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/event/AdReportResultEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$i */
    static final class C3010i<T> implements Consumer<AdReportResultEvent> {
        /* renamed from: a */
        final /* synthetic */ ExploreActivity f11417a;

        C3010i(ExploreActivity exploreActivity) {
            this.f11417a = exploreActivity;
        }

        /* renamed from: a */
        public final void accept(AdReportResultEvent aVar) {
            if (aVar.mo20434a()) {
                ((ExploreVM) this.f11417a.mo19853a()).mo20934f();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/explore/data/ExploreIndex;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$j */
    static final class C3011j<T> implements Observer<ExploreIndex> {
        /* renamed from: a */
        final /* synthetic */ ExploreActivity f11418a;

        C3011j(ExploreActivity exploreActivity) {
            this.f11418a = exploreActivity;
        }

        /* renamed from: a */
        public final void onChanged(ExploreIndex exploreIndex) {
            ExploreActivity.m13683b(this.f11418a).mo20086a(exploreIndex);
            List dynamic = exploreIndex.getDynamic();
            if (dynamic != null) {
                this.f11418a.f11400h.setItems(dynamic);
                this.f11418a.f11400h.notifyDataSetChanged();
            }
            this.f11418a.m13685b(exploreIndex.getRewards());
            this.f11418a.m13680a(exploreIndex.getDogs());
            if (exploreIndex.getSeconds() > 0) {
                this.f11418a.m13694t();
                this.f11418a.m13692r();
            } else {
                this.f11418a.m13695u();
                this.f11418a.m13693s();
                ShakeLayout shakeLayout = (ShakeLayout) this.f11418a.mo19852a(R.id.lyt_shake);
                shakeLayout.mo20942a();
                shakeLayout.mo20946d();
            }
            if ((!exploreIndex.getDogs().isEmpty()) && ((ShakeLayout) this.f11418a.mo19852a(R.id.lyt_shake)).getDogCount() == 0) {
                ((ShakeLayout) this.f11418a.mo19852a(R.id.lyt_shake)).mo20944b();
                List arrayList = new ArrayList();
                Iterable dogs = exploreIndex.getDogs();
                Collection arrayList2 = new ArrayList();
                for (Object next : dogs) {
                    if (((TeamItem) next).getNum() > 0) {
                        arrayList2.add(next);
                    }
                }
                for (TeamItem dogId : (List) arrayList2) {
                    arrayList.add(Integer.valueOf(DogImage.m13659a(dogId.getDogId())));
                }
                ((ShakeLayout) this.f11418a.mo19852a(R.id.lyt_shake)).mo20943a(arrayList);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$k */
    static final class C3012k<T> implements Observer<Object> {
        /* renamed from: a */
        final /* synthetic */ ExploreActivity f11419a;

        C3012k(ExploreActivity exploreActivity) {
            this.f11419a = exploreActivity;
        }

        public final void onChanged(Object obj) {
            C2914d.m13181a(new C8246a<Unit>(this) {
                final /* synthetic */ C3012k this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    ((ExploreVM) this.this$0.f11419a.mo19853a()).mo20934f();
                }
            }, 500, this.f11419a);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/Resource;", "Lcom/jiayouya/travel/module/common/data/AdRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$l */
    static final class C3014l<T> implements Observer<Resource<AdRsp>> {
        /* renamed from: a */
        final /* synthetic */ ExploreActivity f11420a;

        C3014l(ExploreActivity exploreActivity) {
            this.f11420a = exploreActivity;
        }

        /* renamed from: a */
        public final void onChanged(final Resource<AdRsp> resource) {
            C8271i.m35382a((Object) resource, "it");
            ResourceEx.m12833a(resource, new C8246a<Unit>(this) {
                final /* synthetic */ C3014l this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    ExploreActivity exploreActivity = this.this$0.f11420a;
                    Object data = resource.getData();
                    if (data == null) {
                        C8271i.m35380a();
                    }
                    ExploreActivity.m13678a(exploreActivity, (AdRsp) data, false, 2, (Object) null);
                }
            }, null, null, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$m */
    static final class C3016m<T> implements Observer<Integer> {
        /* renamed from: a */
        final /* synthetic */ ExploreActivity f11421a;

        C3016m(ExploreActivity exploreActivity) {
            this.f11421a = exploreActivity;
        }

        /* renamed from: a */
        public final void onChanged(Integer num) {
            int size = this.f11421a.f11398f.getItems().size();
            C8271i.m35382a((Object) num, "it");
            int intValue = num.intValue();
            if (intValue >= 0 && size > intValue && !this.f11421a.f11398f.getItems().isEmpty()) {
                HarvestItem harvestItem = (HarvestItem) this.f11421a.f11398f.getItem(num.intValue());
                int type = harvestItem.getType();
                if (type == 48) {
                    ExploreActivity exploreActivity = this.f11421a;
                    Activity activity = exploreActivity;
                    String string = exploreActivity.getString(R.string.explore_coin);
                    C8271i.m35382a((Object) string, "getString(R.string.explore_coin)");
                    GetCoinItem getCoinItem = r7;
                    GetCoinItem getCoinItem2 = new GetCoinItem("领取成功", string, harvestItem.getValue(), null, false, 16, null);
                    new GetCoinDilaog(activity, getCoinItem).show();
                    ResidentMemoryModel.f11323a.mo20733a(harvestItem.getValue(), 1);
                    harvestItem.setType(-1);
                    this.f11421a.f11398f.notifyDataSetChanged();
                } else if (type != 49) {
                    if (((int) harvestItem.getValue()) > 1) {
                        harvestItem.setValue(harvestItem.getValue() - ((double) 1));
                    } else {
                        harvestItem.setType(-1);
                    }
                    this.f11421a.f11398f.notifyDataSetChanged();
                } else {
                    android.content.Context context = this.f11421a;
                    C3325HB hb = new C3325HB("", null, "恭喜获得", String.valueOf(harvestItem.getValue()), 0, 5, 18, null);
                    HbDilaog iVar = new HbDilaog(context, hb, null, 4, null);
                    iVar.show();
                    harvestItem.setType(-1);
                    this.f11421a.f11398f.notifyDataSetChanged();
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$n */
    static final class C3017n implements OnTouchListener {
        /* renamed from: a */
        public static final C3017n f11422a = new C3017n();

        C3017n() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$o */
    static final class C3018o implements OnTouchListener {
        /* renamed from: a */
        public static final C3018o f11423a = new C3018o();

        C3018o() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$p */
    static final class C3019p implements OnTouchListener {
        /* renamed from: a */
        public static final C3019p f11424a = new C3019p();

        C3019p() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/common/widget/countdownview/CountdownView;", "kotlin.jvm.PlatformType", "onEnd"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreActivity.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$q */
    static final class C3020q implements C2910a {
        /* renamed from: a */
        final /* synthetic */ ExploreActivity f11425a;

        C3020q(ExploreActivity exploreActivity) {
            this.f11425a = exploreActivity;
        }

        /* renamed from: a */
        public final void mo20048a(CountdownView countdownView) {
            this.f11425a.m13695u();
            ((ExploreVM) this.f11425a.mo19853a()).mo20934f();
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11406n == null) {
            this.f11406n = new HashMap();
        }
        View view = (View) this.f11406n.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11406n.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_explore;
    }

    /* renamed from: b */
    public static final /* synthetic */ ActivityExploreBinding m13683b(ExploreActivity exploreActivity) {
        return (ActivityExploreBinding) exploreActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<ExploreVM> mo19861d() {
        return ExploreVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        ((HorizontalScrollView) mo19852a(R.id.far_scroll_view)).setOnTouchListener(C3017n.f11422a);
        ((HorizontalScrollView) mo19852a(R.id.middle_scroll_view)).setOnTouchListener(C3018o.f11423a);
        ((HorizontalScrollView) mo19852a(R.id.near_scroll_view)).setOnTouchListener(C3019p.f11424a);
        m13691q();
        NestedScrollView nestedScrollView = (NestedScrollView) mo19852a(R.id.scroll_view);
        C8271i.m35382a((Object) nestedScrollView, "scroll_view");
        setupStatusView(nestedScrollView);
        ((CountdownView) mo19852a(R.id.countdown_view)).setOnCountdownEndListener(new C3020q(this));
        BaseActivity.m12847a(this, false, 1, null);
    }

    /* renamed from: q */
    private final void m13691q() {
        RecyclerView recyclerView = (RecyclerView) mo19852a(R.id.team_list);
        recyclerView.setAdapter(this.f11396d);
        recyclerView.setFocusable(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new ExploreActivity$initListView$1$1(recyclerView, recyclerView.getContext(), 5));
        RecyclerView recyclerView2 = (RecyclerView) mo19852a(R.id.dynamic_list);
        recyclerView2.setAdapter(this.f11400h);
        recyclerView2.setFocusable(false);
        recyclerView2.setNestedScrollingEnabled(false);
        recyclerView2.setLayoutManager(new ExploreActivity$initListView$2$1(recyclerView2, recyclerView2.getContext()));
        RecyclerView recyclerView3 = (RecyclerView) mo19852a(R.id.harvest_list);
        recyclerView3.setAdapter(this.f11398f);
        recyclerView3.setFocusable(false);
        recyclerView3.setNestedScrollingEnabled(false);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new ExploreActivity$initListView$3$1(recyclerView3, recyclerView3.getContext(), 6));
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((ExploreVM) mo19853a()).mo20934f();
    }

    /* renamed from: h */
    public boolean mo19865h() {
        return ((ActivityExploreBinding) mo19857b()).mo20085a() == null;
    }

    /* renamed from: i */
    public boolean mo19866i() {
        return ((ActivityExploreBinding) mo19857b()).mo20085a() == null;
    }

    /* renamed from: k */
    public void mo19868k() {
        RoundText roundText = (RoundText) mo19852a(R.id.btn_recall);
        C8271i.m35382a((Object) roundText, "btn_recall");
        ezy.p642a.View.m34750a(roundText, 0, new C3004e(this), 1, null);
        RoundLayout roundLayout = (RoundLayout) mo19852a(R.id.btn_play);
        C8271i.m35382a((Object) roundLayout, "btn_play");
        ezy.p642a.View.m34750a(roundLayout, 0, new C3006f(this), 1, null);
        TextView textView = (TextView) mo19852a(R.id.tv_harvest);
        C8271i.m35382a((Object) textView, "tv_harvest");
        ezy.p642a.View.m34750a(textView, 0, new C3007g(this), 1, null);
        this.f11397e.setOnItemClick(new C3008h(this));
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        C8019a.m34778a(RxBus.f27263a.mo38571a(AdReportResultEvent.class), lifecycleOwner, null, 2, null).mo37374a(new C3010i(this));
        ((ExploreVM) mo19853a()).mo20931c().observe(lifecycleOwner, new C3011j(this));
        ((ExploreVM) mo19853a()).mo20930b().observe(lifecycleOwner, new C3012k(this));
        ((ExploreVM) mo19853a()).mo20932d().observe(lifecycleOwner, new C3014l(this));
        ((ExploreVM) mo19853a()).mo20933e().observe(lifecycleOwner, new C3016m(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m13680a(List<TeamItem> list) {
        List arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        if (list == null || list.size() < 5) {
            int size = 5 - (list != null ? list.size() : 0);
            for (int i = 0; i < size; i++) {
                arrayList.add(new TeamItem(0, -1));
            }
        }
        this.f11396d.setItems(arrayList);
        this.f11396d.notifyDataSetChanged();
    }

    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final void m13685b(List<HarvestItem> list) {
        if (list == null || list.size() < 6) {
            List arrayList = new ArrayList();
            if (list != null) {
                arrayList.addAll(list);
            }
            int size = 6 - (list != null ? list.size() : 0);
            for (int i = 0; i < size; i++) {
                arrayList.add(new HarvestItem(-1, 0.0d));
            }
            this.f11398f.setItems(arrayList);
        } else {
            this.f11398f.setItems(C8187k.m35286b((Collection) list));
        }
        this.f11398f.notifyDataSetChanged();
    }

    /* renamed from: a */
    static /* synthetic */ void m13678a(ExploreActivity exploreActivity, AdRsp adRsp, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        exploreActivity.m13674a(adRsp, z);
    }

    /* renamed from: a */
    private final void m13674a(AdRsp adRsp, boolean z) {
        ResidentMemoryModel.m13596a(ResidentMemoryModel.f11323a, (AppCompatActivity) null, (C8247b) new C3000c(this, adRsp, z), 1, (Object) null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: r */
    public final void m13692r() {
        m13693s();
        Observable a = Observable.m34990a(0, 12, TimeUnit.SECONDS);
        C8271i.m35382a((Object) a, "Observable.interval(0, 12, TimeUnit.SECONDS)");
        this.f11401i = C8019a.m34778a(a, this, null, 2, null).mo37374a(new C2998a(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: s */
    public final void m13693s() {
        Disposable bVar = this.f11401i;
        if (bVar != null && !bVar.isDisposed()) {
            Disposable bVar2 = this.f11401i;
            if (bVar2 != null) {
                bVar2.dispose();
            }
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: t */
    public final void m13694t() {
        if (!this.f11402j) {
            this.f11402j = true;
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) mo19852a(R.id.far_scroll_view);
            C8271i.m35382a((Object) horizontalScrollView, "far_scroll_view");
            m13672a((View) horizontalScrollView, 800000);
            HorizontalScrollView horizontalScrollView2 = (HorizontalScrollView) mo19852a(R.id.middle_scroll_view);
            C8271i.m35382a((Object) horizontalScrollView2, "middle_scroll_view");
            m13672a((View) horizontalScrollView2, 200000);
            HorizontalScrollView horizontalScrollView3 = (HorizontalScrollView) mo19852a(R.id.near_scroll_view);
            C8271i.m35382a((Object) horizontalScrollView3, "near_scroll_view");
            m13672a((View) horizontalScrollView3, 8000);
        }
    }

    /* renamed from: a */
    private final void m13672a(View view, long j) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new C3003d(this, view, j));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final ObjectAnimator m13669a(int i, long j, View view, int i2) {
        int i3 = 0;
        ObjectAnimator ofInt = ObjectAnimator.ofInt(view, "scrollX", new int[]{i, i2});
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration((long) ((((float) 1) - (((float) i) / ((float) i2))) * ((float) j)));
        ofInt.setRepeatMode(1);
        if (i == 0) {
            i3 = -1;
        }
        ofInt.setRepeatCount(i3);
        C2999b bVar = new C2999b(this, i, i2, j, view);
        ofInt.addUpdateListener(bVar);
        C8271i.m35382a((Object) ofInt, "anim.apply {\n           …}\n            }\n        }");
        return ofInt;
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m13671a(View view) {
        ObjectAnimator objectAnimator;
        if (C8271i.m35384a((Object) view, (Object) (HorizontalScrollView) mo19852a(R.id.far_scroll_view))) {
            objectAnimator = this.f11403k;
        } else if (C8271i.m35384a((Object) view, (Object) (HorizontalScrollView) mo19852a(R.id.middle_scroll_view))) {
            objectAnimator = this.f11405m;
        } else {
            objectAnimator = this.f11404l;
        }
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: u */
    public final void m13695u() {
        this.f11402j = false;
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) mo19852a(R.id.far_scroll_view);
        C8271i.m35382a((Object) horizontalScrollView, "far_scroll_view");
        m13671a((View) horizontalScrollView);
        HorizontalScrollView horizontalScrollView2 = (HorizontalScrollView) mo19852a(R.id.middle_scroll_view);
        C8271i.m35382a((Object) horizontalScrollView2, "middle_scroll_view");
        m13671a((View) horizontalScrollView2);
        HorizontalScrollView horizontalScrollView3 = (HorizontalScrollView) mo19852a(R.id.near_scroll_view);
        C8271i.m35382a((Object) horizontalScrollView3, "near_scroll_view");
        m13671a((View) horizontalScrollView3);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m13673a(View view, ObjectAnimator objectAnimator) {
        if (C8271i.m35384a((Object) view, (Object) (HorizontalScrollView) mo19852a(R.id.far_scroll_view))) {
            this.f11403k = objectAnimator;
        } else if (C8271i.m35384a((Object) view, (Object) (HorizontalScrollView) mo19852a(R.id.middle_scroll_view))) {
            this.f11405m = objectAnimator;
        } else {
            this.f11404l = objectAnimator;
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final int m13681b(View view) {
        Object tag = view.getTag(R.id.tag);
        if (tag instanceof Integer) {
            return ((Number) tag).intValue();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ((ExploreVM) mo19853a()).mo20936h();
    }
}
