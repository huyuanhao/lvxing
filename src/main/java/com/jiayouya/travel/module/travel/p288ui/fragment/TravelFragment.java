package com.jiayouya.travel.module.travel.p288ui.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.app.hubert.guide.NewbieGuide;
import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighlightOptions.C1591a;
import com.app.hubert.guide.p127a.OnGuideChangedListener;
import com.app.hubert.guide.p127a.OnHighlightDrewListener;
import com.app.hubert.guide.p127a.OnLayoutInflatedListener;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.C2835b;
import com.jiayouya.travel.C2914d;
import com.jiayouya.travel.Launcher;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.AnimationListener;
import com.jiayouya.travel.common.base.BaseFragment;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p244b.ResourceEx;
import com.jiayouya.travel.common.p244b.ViewEx;
import com.jiayouya.travel.common.p245c.PreferenceRes;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.common.widget.RiseText;
import com.jiayouya.travel.common.widget.RndCornerProgressBar;
import com.jiayouya.travel.common.widget.countdownview.CountdownView;
import com.jiayouya.travel.common.widget.countdownview.CountdownView.C2910a;
import com.jiayouya.travel.databinding.FragmentTravelBinding;
import com.jiayouya.travel.module.common.data.Resource;
import com.jiayouya.travel.module.common.p259ui.dialog.DialogManager;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.explore.data.ExploreDoor;
import com.jiayouya.travel.module.travel.data.BagInfo;
import com.jiayouya.travel.module.travel.data.BuyDogRsp;
import com.jiayouya.travel.module.travel.data.C3325HB;
import com.jiayouya.travel.module.travel.data.ClaimFreeCoinRsp;
import com.jiayouya.travel.module.travel.data.DogHomeRsp;
import com.jiayouya.travel.module.travel.data.DogInfo;
import com.jiayouya.travel.module.travel.data.DogShopItem;
import com.jiayouya.travel.module.travel.data.Extra;
import com.jiayouya.travel.module.travel.data.GameIndex;
import com.jiayouya.travel.module.travel.data.GetCoinItem;
import com.jiayouya.travel.module.travel.data.IndexPop;
import com.jiayouya.travel.module.travel.data.LoversMerge;
import com.jiayouya.travel.module.travel.data.LuckDog;
import com.jiayouya.travel.module.travel.data.LuckPoolRsp;
import com.jiayouya.travel.module.travel.data.MergeBonusDogItem;
import com.jiayouya.travel.module.travel.data.MergeDialExtra;
import com.jiayouya.travel.module.travel.data.MergeDialItem;
import com.jiayouya.travel.module.travel.data.MergeDogRsp;
import com.jiayouya.travel.module.travel.data.MergeSuper;
import com.jiayouya.travel.module.travel.data.OfflineProfit;
import com.jiayouya.travel.module.travel.data.PositionExtra;
import com.jiayouya.travel.module.travel.data.PositionItem;
import com.jiayouya.travel.module.travel.data.PositionItemKt;
import com.jiayouya.travel.module.travel.data.RecycleDogRsp;
import com.jiayouya.travel.module.travel.data.SuggestBuyItem;
import com.jiayouya.travel.module.travel.data.TempBonusItem;
import com.jiayouya.travel.module.travel.data.UnlockCity;
import com.jiayouya.travel.module.travel.p286b.DogPickOutEvent;
import com.jiayouya.travel.module.travel.p286b.HbAmountEvent;
import com.jiayouya.travel.module.travel.p286b.LogoutEvent;
import com.jiayouya.travel.module.travel.p286b.RefreshDrawDotEvent;
import com.jiayouya.travel.module.travel.p286b.TempDogDismissEvent;
import com.jiayouya.travel.module.travel.p287c.GoldUtil;
import com.jiayouya.travel.module.travel.p287c.MediaPlayerUtil;
import com.jiayouya.travel.module.travel.p288ui.DogShopDialog;
import com.jiayouya.travel.module.travel.p288ui.p289a.CoinShortDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.DogDetailDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.DogUpgradeDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.GetCoinDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.GetMaxLevelDogDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.HbDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.LuckyDrawDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.MergeBonusDogDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.OfflineProfitDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.RandomMergeDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.RecycleHintDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.TempBonusDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.TempBonusDogDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.TempBonusProfitDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.UnlockCityDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.WarehouseDilaog;
import com.jiayouya.travel.module.travel.p288ui.p289a.WarehouseHintDialog;
import com.jiayouya.travel.module.travel.p290vm.TravelVM;
import com.jiayouya.travel.module.travel.widget.FloatImageView;
import com.jiayouya.travel.module.travel.widget.GradientText;
import com.jiayouya.travel.module.travel.widget.ScaleLayout;
import com.jiayouya.travel.module.travel.widget.merge.MergeChild;
import com.jiayouya.travel.module.travel.widget.merge.MergeLayout;
import com.tencent.android.tpush.common.Constants;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.collections.C8194y;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.jvm.p679a.C8258m;
import kotlin.jvm.p679a.C8262q;
import kotlin.p677d.C8238n;
import kotlin.reflect.C8280j;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J(\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"H\u0002J\b\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\fH\u0016J\u0010\u00102\u001a\u0002032\u0006\u0010#\u001a\u00020\"H\u0002J\b\u00104\u001a\u00020\"H\u0016J\u0010\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\"H\u0002J\u0010\u00107\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0002J\b\u00108\u001a\u000203H\u0002J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020\"H\u0002J\u0010\u0010;\u001a\u0002032\u0006\u0010:\u001a\u00020\"H\u0002J\u0016\u0010<\u001a\u0002002\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>H\u0002J\u0016\u0010@\u001a\u0002002\f\u0010=\u001a\b\u0012\u0004\u0012\u00020A0>H\u0002J\b\u0010B\u001a\u000200H\u0002J\b\u0010C\u001a\u000200H\u0002J\b\u0010D\u001a\u000200H\u0002J\b\u0010E\u001a\u000200H\u0002J\b\u0010F\u001a\u000200H\u0016J\u0010\u0010G\u001a\u0002002\u0006\u0010H\u001a\u00020\fH\u0016J\b\u0010I\u001a\u000200H\u0016J\b\u0010J\u001a\u000200H\u0016J\u0012\u0010K\u001a\u0002002\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0010\u0010N\u001a\u0002002\u0006\u0010O\u001a\u00020PH\u0002J\u001a\u0010Q\u001a\u0002002\u0006\u0010O\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020\fH\u0002J\u0018\u0010T\u001a\u0002002\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020)H\u0002J\b\u0010X\u001a\u000200H\u0002J\u000e\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00030ZH\u0016J\b\u0010[\u001a\u000200H\u0002J\u0018\u0010\\\u001a\u0002002\u0006\u0010*\u001a\u00020+2\u0006\u0010]\u001a\u00020)H\u0002J\u0010\u0010^\u001a\u0002002\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010_\u001a\u0002002\u0006\u0010`\u001a\u00020)H\u0002J\b\u0010a\u001a\u000200H\u0002J\b\u0010b\u001a\u000200H\u0002J\u0010\u0010c\u001a\u0002002\u0006\u0010O\u001a\u00020dH\u0002J\u0010\u0010e\u001a\u0002002\u0006\u0010f\u001a\u00020\fH\u0016J\u001a\u0010g\u001a\u0002002\u0006\u0010:\u001a\u00020\"2\b\b\u0002\u0010h\u001a\u00020\fH\u0002J\b\u0010i\u001a\u000200H\u0016J\b\u0010j\u001a\u000200H\u0016J\b\u0010k\u001a\u000200H\u0016J\b\u0010l\u001a\u000200H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/fragment/TravelFragment;", "Lcom/jiayouya/travel/common/base/BaseFragment;", "Lcom/jiayouya/travel/databinding/FragmentTravelBinding;", "Lcom/jiayouya/travel/module/travel/vm/TravelVM;", "()V", "guidePaint", "Landroid/graphics/Paint;", "getGuidePaint", "()Landroid/graphics/Paint;", "guidePaint$delegate", "Lkotlin/Lazy;", "isNeedProcessUI", "", "lastAmount", "", "player", "Landroid/media/MediaPlayer;", "rotateAnimation", "Landroid/view/animation/RotateAnimation;", "getRotateAnimation", "()Landroid/view/animation/RotateAnimation;", "rotateAnimation$delegate", "rotateRunnable", "Ljava/lang/Runnable;", "scaleAnim", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "getScaleAnim", "()Landroid/view/animation/Animation;", "scaleAnim$delegate", "walkDogLocation", "Landroid/graphics/Rect;", "warehouseLocation", "bgResId", "", "cityId", "type", "createAnim", "Landroid/animation/ObjectAnimator;", "curScrollX", "d", "", "view", "Landroid/view/View;", "childWidth", "createMergeBonusDogItem", "Lcom/jiayouya/travel/module/travel/data/MergeBonusDogItem;", "fetchData", "", "isRefresh", "getCityName", "", "getLayoutId", "getProfitByLevel", "level", "getScrollX", "getSpeed", "getWalkLottieFileName", "dogId", "getWalkLottieImageFolder", "initMergeLayout", "list", "", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "initMergeProfit", "Lcom/jiayouya/travel/module/travel/data/DogShopItem;", "initNewGuide", "initPlayer", "initScrollBg", "initTopLyt", "onDestroy", "onHiddenChanged", "hidden", "onPause", "onResume", "onViewStateRestored", "savedInstanceState", "Landroid/os/Bundle;", "processBuyRsp", "item", "Lcom/jiayouya/travel/module/travel/data/BuyDogRsp;", "processMergeRsp", "Lcom/jiayouya/travel/module/travel/data/MergeDogRsp;", "isMergeMaxLevel", "processTempBonusDog", "extra", "Lcom/jiayouya/travel/module/travel/data/PositionExtra;", "birthTime", "profitScaleAnim", "providerViewModelClass", "Ljava/lang/Class;", "removeRotate", "setBgAnim", "dur", "setCityBg", "setFreeCoinLyt", "seconds", "setMergeLytRangeY", "setSpeed", "setSuggestBuy", "Lcom/jiayouya/travel/module/travel/data/SuggestBuyItem;", "setUserVisibleHint", "isVisibleToUser", "setWalkLottie", "isNeedReport", "setupClick", "setupObserver", "setupView", "startRotate", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TravelFragment.kt */
/* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment */
public final class TravelFragment extends BaseFragment<FragmentTravelBinding, TravelVM> {
    /* renamed from: c */
    static final /* synthetic */ C8280j[] f12078c;
    /* renamed from: d */
    private final Lazy f12079d = C8182c.m35317a(new C3491i(this));
    /* access modifiers changed from: private */
    /* renamed from: e */
    public MediaPlayer f12080e;
    /* renamed from: f */
    private final Lazy f12081f = C8182c.m35317a(C3438a.INSTANCE);
    /* access modifiers changed from: private|final */
    /* renamed from: g */
    public final Rect f12082g = new Rect();
    /* access modifiers changed from: private|final */
    /* renamed from: h */
    public final Rect f12083h = new Rect();
    /* renamed from: i */
    private boolean f12084i;
    /* renamed from: j */
    private double f12085j;
    /* renamed from: k */
    private final Lazy f12086k = C8182c.m35317a(new C3488g(this));
    /* access modifiers changed from: private|final */
    /* renamed from: l */
    public final Runnable f12087l = new C3490h(this);
    /* renamed from: m */
    private HashMap f12088m;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$a */
    static final class C3438a extends Lambda implements C8246a<Paint> {
        public static final C3438a INSTANCE = new C3438a();

        C3438a() {
            super(0);
        }

        public final Paint invoke() {
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setAntiAlias(true);
            paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
            paint.setMaskFilter(new BlurMaskFilter(10.0f, Blur.INNER));
            return paint;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$aa */
    static final class C3439aa<T> implements Observer<Integer> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12089a;

        C3439aa(TravelFragment travelFragment) {
            this.f12089a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(Integer num) {
            MergeLayout mergeLayout = (MergeLayout) this.f12089a.mo19880a(R.id.lyt_merge);
            C8271i.m35382a((Object) num, "it");
            mergeLayout.mo22520a(num.intValue());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ab */
    static final class C3440ab<T> implements Observer<PositionItem> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12090a;

        C3440ab(TravelFragment travelFragment) {
            this.f12090a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(PositionItem positionItem) {
            GloblaEx.m12816a("取出成功", 0, 0, 6, null);
            MergeLayout mergeLayout = (MergeLayout) this.f12090a.mo19880a(R.id.lyt_merge);
            C8271i.m35382a((Object) positionItem, "it");
            mergeLayout.mo22521a(positionItem, positionItem.getPosition() - 1);
            RxBus.f27263a.mo38572a((Object) new DogPickOutEvent(positionItem.getDogId()));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/explore/data/ExploreDoor;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ac */
    static final class C3441ac<T> implements Observer<ExploreDoor> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12091a;

        C3441ac(TravelFragment travelFragment) {
            this.f12091a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(ExploreDoor exploreDoor) {
            FloatImageView floatImageView = (FloatImageView) this.f12091a.mo19880a(R.id.iv_explore);
            C8271i.m35382a((Object) floatImageView, "iv_explore");
            View view = floatImageView;
            boolean z = true;
            if (exploreDoor.getStatus() == 1) {
                z = false;
            }
            ViewEx.m12840a(view, z);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/event/RefreshDrawDotEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ad */
    static final class C3442ad<T> implements Consumer<RefreshDrawDotEvent> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12092a;

        C3442ad(TravelFragment travelFragment) {
            this.f12092a = travelFragment;
        }

        /* renamed from: a */
        public final void accept(RefreshDrawDotEvent dVar) {
            DogHomeRsp b = TravelFragment.m14745g(this.f12092a).mo20161b();
            if (b != null) {
                b.setTickets(dVar.mo21650a());
            }
            View a = this.f12092a.mo19880a(R.id.red_dot);
            C8271i.m35382a((Object) a, "red_dot");
            ViewEx.m12840a(a, dVar.mo21650a() <= 0);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/RecycleDogRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ae */
    static final class C3443ae<T> implements Observer<RecycleDogRsp> {
        /* renamed from: a */
        public static final C3443ae f12093a = new C3443ae();

        C3443ae() {
        }

        /* renamed from: a */
        public final void onChanged(RecycleDogRsp recycleDogRsp) {
            ResidentMemoryModel.f11323a.mo20733a(recycleDogRsp.getNumber(), 1);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/BuyDogRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$af */
    static final class C3444af<T> implements Consumer<BuyDogRsp> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12094a;

        C3444af(TravelFragment travelFragment) {
            this.f12094a = travelFragment;
        }

        /* renamed from: a */
        public final void accept(BuyDogRsp buyDogRsp) {
            TravelFragment travelFragment = this.f12094a;
            C8271i.m35382a((Object) buyDogRsp, "it");
            travelFragment.m14716a(buyDogRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/event/TempDogDismissEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ag */
    static final class C3445ag<T> implements Consumer<TempDogDismissEvent> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12095a;

        C3445ag(TravelFragment travelFragment) {
            this.f12095a = travelFragment;
        }

        /* renamed from: a */
        public final void accept(TempDogDismissEvent eVar) {
            TravelFragment.m14712a(this.f12095a).mo22450r();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/event/LogoutEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ah */
    static final class C3446ah<T> implements Consumer<LogoutEvent> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12096a;

        C3446ah(TravelFragment travelFragment) {
            this.f12096a = travelFragment;
        }

        /* renamed from: a */
        public final void accept(LogoutEvent cVar) {
            TravelFragment.m14712a(this.f12096a).mo22432c(true);
            ((MergeLayout) this.f12096a.mo19880a(R.id.lyt_merge)).mo22524b();
            TravelFragment.m14712a(this.f12096a).mo22444l();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/LuckPoolRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ai */
    static final class C3447ai<T> implements Observer<LuckPoolRsp> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12097a;

        C3447ai(TravelFragment travelFragment) {
            this.f12097a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(LuckPoolRsp luckPoolRsp) {
            FragmentActivity activity = this.f12097a.getActivity();
            if (activity != null) {
                C8271i.m35382a((Object) activity, "a");
                Activity activity2 = activity;
                C8271i.m35382a((Object) luckPoolRsp, "it");
                new LuckyDrawDilaog(activity2, luckPoolRsp).show();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/ClaimFreeCoinRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$aj */
    static final class C3448aj<T> implements Observer<ClaimFreeCoinRsp> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12098a;

        C3448aj(TravelFragment travelFragment) {
            this.f12098a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(ClaimFreeCoinRsp claimFreeCoinRsp) {
            ResidentMemoryModel.f11323a.mo20733a(claimFreeCoinRsp.getCoin(), 1);
            this.f12098a.m14714a(claimFreeCoinRsp.getSeconds());
            String str = "领取成功";
            GetCoinItem getCoinItem = new GetCoinItem(str, GloblaEx.m12814a(R.string.c66_and_orange, "", "恭喜获得"), claimFreeCoinRsp.getCoin(), claimFreeCoinRsp.getAdIdInfoFlow(), false, 16, null);
            FragmentActivity activity = this.f12098a.getActivity();
            if (activity == null) {
                C8271i.m35380a();
            }
            C8271i.m35382a((Object) activity, "activity!!");
            new GetCoinDilaog(activity, getCoinItem).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/DogInfo;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ak */
    static final class C3449ak<T> implements Observer<DogInfo> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12099a;

        C3449ak(TravelFragment travelFragment) {
            this.f12099a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(DogInfo dogInfo) {
            Context context = this.f12099a.getContext();
            if (context == null) {
                C8271i.m35380a();
            }
            C8271i.m35382a((Object) context, "context!!");
            C8271i.m35382a((Object) dogInfo, "it");
            new DogDetailDilaog(context, dogInfo).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/IndexPop;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$al */
    static final class C3450al<T> implements Observer<IndexPop> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12100a;

        C3450al(TravelFragment travelFragment) {
            this.f12100a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(IndexPop indexPop) {
            List<LuckDog> luckDog = indexPop.getLuckDog();
            if (luckDog != null) {
                for (LuckDog luckDog2 : luckDog) {
                    if (!TempBonusProfitDilaog.f12040a.mo22324a(luckDog2)) {
                        DialogManager a = DialogManager.f11300b.mo20713a();
                        Context context = this.f12100a.getContext();
                        if (context == null) {
                            C8271i.m35380a();
                        }
                        C8271i.m35382a((Object) context, "context!!");
                        a.mo20712a(new TempBonusProfitDilaog(context, luckDog2));
                    }
                }
            }
            List<UnlockCity> city = indexPop.getCity();
            if (city != null) {
                for (UnlockCity unlockCity : city) {
                    DialogManager a2 = DialogManager.f11300b.mo20713a();
                    FragmentActivity activity = this.f12100a.getActivity();
                    if (activity == null) {
                        C8271i.m35380a();
                    }
                    C8271i.m35382a((Object) activity, "activity!!");
                    a2.mo20712a(new UnlockCityDilaog(activity, unlockCity));
                }
            }
            DialogManager.f11300b.mo20713a().mo20711a();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/Resource;", "Lcom/jiayouya/travel/module/travel/data/MergeSuper;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$am */
    static final class C3451am<T> implements Observer<Resource<MergeSuper>> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12101a;

        C3451am(TravelFragment travelFragment) {
            this.f12101a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(final Resource<MergeSuper> resource) {
            if (resource != null) {
                ResourceEx.m12833a(resource, new C8246a<Unit>(this) {
                    final /* synthetic */ C3451am this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        Object extra = resource.getExtra();
                        if (extra != null) {
                            MergeBonusDogItem mergeBonusDogItem = (MergeBonusDogItem) extra;
                            MergeLayout mergeLayout = (MergeLayout) this.this$0.f12101a.mo19880a(R.id.lyt_merge);
                            mergeLayout.mo22520a(mergeBonusDogItem.getFzDogIndex());
                            mergeLayout.mo22520a(mergeBonusDogItem.getMzDogIndex());
                            mergeLayout.mo22520a(mergeBonusDogItem.getYzDogIndex());
                            mergeLayout.mo22520a(mergeBonusDogItem.getOzDogIndex());
                            mergeLayout.mo22520a(mergeBonusDogItem.getDyzDogIndex());
                            MergeSuper mergeSuper = (MergeSuper) resource.getData();
                            if (mergeSuper != null) {
                                PositionItem merge = mergeSuper.getMerge();
                                if (merge != null) {
                                    mergeLayout.mo22521a(merge, merge.getPosition() - 1);
                                    this.this$0.f12101a.m14713a(merge.getDogId(), true);
                                    FragmentActivity activity = this.this$0.f12101a.getActivity();
                                    if (activity == null) {
                                        C8271i.m35380a();
                                    }
                                    C8271i.m35382a((Object) activity, "activity!!");
                                    new GetMaxLevelDogDilaog(activity, "全球分红犬", merge.getDogId(), "每天获得旅行世界收益现金分红20%").show();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.module.travel.data.MergeBonusDogItem");
                    }
                }, null, null, 6, null);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/GameIndex;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$an */
    static final class C3453an<T> implements Observer<GameIndex> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12102a;

        C3453an(TravelFragment travelFragment) {
            this.f12102a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(GameIndex gameIndex) {
            TravelFragment.m14745g(this.f12102a).mo20158a(gameIndex);
            RndCornerProgressBar rndCornerProgressBar = (RndCornerProgressBar) this.f12102a.mo19880a(R.id.progress_bar);
            C8271i.m35382a((Object) rndCornerProgressBar, "progress_bar");
            rndCornerProgressBar.setProgress(gameIndex.getCity().getPercent());
            this.f12102a.m14742e(gameIndex.getCity().getId());
            ResidentMemoryModel.f11323a.mo20733a(gameIndex.getCoin(), 3);
            OfflineProfit offline = gameIndex.getOffline();
            if (offline != null) {
                FragmentActivity activity = this.f12102a.getActivity();
                if (activity != null) {
                    DialogManager a = DialogManager.f11300b.mo20713a();
                    C8271i.m35382a((Object) activity, Constants.FLAG_ACTIVITY_NAME);
                    a.mo20712a(new OfflineProfitDilaog(activity, offline));
                    a.mo20711a();
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/Resource;", "Lcom/jiayouya/travel/module/travel/data/DogHomeRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ao */
    static final class C3454ao<T> implements Observer<Resource<DogHomeRsp>> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12103a;

        C3454ao(TravelFragment travelFragment) {
            this.f12103a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(final Resource<DogHomeRsp> resource) {
            C8271i.m35382a((Object) resource, "it");
            ResourceEx.m12833a(resource, new C8246a<Unit>(this) {
                final /* synthetic */ C3454ao this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    Object extra = resource.getExtra();
                    if (extra != null) {
                        boolean booleanValue = ((Boolean) extra).booleanValue();
                        DogHomeRsp dogHomeRsp = (DogHomeRsp) resource.getData();
                        if (dogHomeRsp == null) {
                            return;
                        }
                        if (booleanValue) {
                            this.this$0.f12103a.m14719a(dogHomeRsp.getSuggest());
                            return;
                        }
                        TravelFragment.m14745g(this.this$0.f12103a).mo20157a(dogHomeRsp);
                        TravelFragment.m14722a(this.this$0.f12103a, dogHomeRsp.getWalkDogId(), false, 2, (Object) null);
                        this.this$0.f12103a.m14714a(dogHomeRsp.getFreeCoin());
                        this.this$0.f12103a.m14731a(dogHomeRsp.getPositions());
                        this.this$0.f12103a.m14719a(dogHomeRsp.getSuggest());
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
                }
            }, null, null, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo39189d2 = {"com/jiayouya/travel/module/travel/ui/fragment/TravelFragment$setupView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ap */
    public static final class C3456ap extends AnimatorListenerAdapter {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12104a;

        C3456ap(TravelFragment travelFragment) {
            this.f12104a = travelFragment;
        }

        public void onAnimationStart(Animator animator) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f12104a.mo19880a(R.id.lottie_view);
            C8271i.m35382a((Object) lottieAnimationView, "lottie_view");
            ViewEx.m12842b(lottieAnimationView, false);
        }

        public void onAnimationEnd(Animator animator) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f12104a.mo19880a(R.id.lottie_view);
            C8271i.m35382a((Object) lottieAnimationView, "lottie_view");
            ViewEx.m12843b(lottieAnimationView, false, 1, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/common/widget/countdownview/CountdownView;", "kotlin.jvm.PlatformType", "onEnd"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$aq */
    static final class C3457aq implements C2910a {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12105a;

        C3457aq(TravelFragment travelFragment) {
            this.f12105a = travelFragment;
        }

        /* renamed from: a */
        public final void mo20048a(CountdownView countdownView) {
            DialogManager a = DialogManager.f11300b.mo20713a();
            Object tag = ((CountdownView) this.f12105a.mo19880a(R.id.countdown_view)).getTag(R.id.tag);
            if (tag instanceof PositionExtra) {
                Context context = this.f12105a.getContext();
                if (context == null) {
                    C8271i.m35380a();
                }
                C8271i.m35382a((Object) context, "context!!");
                PositionExtra positionExtra = (PositionExtra) tag;
                a.mo20712a(new TempBonusProfitDilaog(context, new LuckDog(positionExtra.getLogId(), 38, String.valueOf(positionExtra.getAmount()), "恭喜获得30分钟广告分红")));
                a.mo20711a();
            }
            Observable b = Observable.m34996a(Integer.valueOf(0)).mo38897b(1500, TimeUnit.MILLISECONDS);
            C8271i.m35382a((Object) b, "Observable.just(0).delay…0, TimeUnit.MILLISECONDS)");
            C8019a.m34778a(b, this.f12105a, null, 2, null).mo37374a(new Consumer<Integer>(this) {
                /* renamed from: a */
                final /* synthetic */ C3457aq f12106a;

                {
                    this.f12106a = r1;
                }

                /* renamed from: a */
                public final void accept(Integer num) {
                    if (((MergeLayout) this.f12106a.f12105a.mo19880a(R.id.lyt_merge)) != null) {
                        Iterator it = ((MergeLayout) this.f12106a.f12105a.mo19880a(R.id.lyt_merge)).getChildList().iterator();
                        int i = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i = -1;
                                break;
                            } else if (PositionItemKt.isTemp(((MergeChild) it.next()).getItem())) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i == -1) {
                            TravelFragment.m14745g(this.f12106a.f12105a).mo20156a(-1);
                            PositionItem maxLevelItem = ((MergeLayout) this.f12106a.f12105a.mo19880a(R.id.lyt_merge)).getMaxLevelItem();
                            if (maxLevelItem != null) {
                                TravelFragment.m14722a(this.f12106a.f12105a, maxLevelItem.getDogId(), false, 2, (Object) null);
                            }
                            TravelFragment.m14745g(this.f12106a.f12105a).executePendingBindings();
                        } else {
                            PositionItem item = ((MergeChild) ((MergeLayout) this.f12106a.f12105a.mo19880a(R.id.lyt_merge)).getChildList().get(i)).getItem();
                            PositionExtra extra = item.getExtra();
                            if (extra != null) {
                                this.f12106a.f12105a.m14718a(extra, item.getBirthTime());
                            }
                        }
                    }
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "p1", "", "p2", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ar */
    static final class C3459ar extends Lambda implements C8258m<Integer, Integer, Unit> {
        final /* synthetic */ TravelFragment this$0;

        C3459ar(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(2);
        }

        public /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
            return Unit.f27778a;
        }

        public final void invoke(int i, int i2) {
            TravelFragment.m14712a(this.this$0).mo22427b(i, i2);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$as */
    static final class C3460as implements OnTouchListener {
        /* renamed from: a */
        public static final C3460as f12107a = new C3460as();

        C3460as() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$at */
    static final class C3461at implements OnTouchListener {
        /* renamed from: a */
        public static final C3461at f12108a = new C3461at();

        C3461at() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$au */
    static final class C3462au implements OnTouchListener {
        /* renamed from: a */
        public static final C3462au f12109a = new C3462au();

        C3462au() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "p1", "", "p2", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$av */
    static final class C3463av extends Lambda implements C8258m<Integer, Integer, Unit> {
        final /* synthetic */ TravelFragment this$0;

        C3463av(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(2);
        }

        public /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
            return Unit.f27778a;
        }

        public final void invoke(final int i, final int i2) {
            Context context = this.this$0.getContext();
            if (context == null) {
                C8271i.m35380a();
            }
            C8271i.m35382a((Object) context, "context!!");
            C3325HB hb = new C3325HB("恭喜您获得一个情侣犬红包", null, "恭喜您合成情侣犬获得", null, 0, 2, 26, null);
            new HbDilaog(context, hb, new C8247b<Integer, Unit>(this) {
                final /* synthetic */ C3463av this$0;

                {
                    this.this$0 = r1;
                }

                public /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.f27778a;
                }

                public final void invoke(int i) {
                    TravelFragment.m14712a(this.this$0.this$0).mo22431c(i, i2);
                }
            }).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "view", "Lcom/jiayouya/travel/module/travel/widget/merge/MergeChild;", "p1", "", "p2", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$aw */
    static final class C3465aw extends Lambda implements C8262q<MergeChild, Integer, Integer, Unit> {
        final /* synthetic */ TravelFragment this$0;

        C3465aw(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(3);
        }

        public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((MergeChild) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            return Unit.f27778a;
        }

        public final void invoke(MergeChild mergeChild, int i, int i2) {
            C8271i.m35386b(mergeChild, "view");
            if (((MergeChild) ((MergeLayout) this.this$0.mo19880a(R.id.lyt_merge)).getChildList().get(i2 - 1)).getItem().getLevel() == 38) {
                TravelFragment.m14712a(this.this$0).mo22423a(new MergeDialExtra(i, i2));
            } else {
                TravelFragment.m14712a(this.this$0).mo22421a(i, i2);
            }
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.this$0.mo19880a(R.id.lottie_view);
            lottieAnimationView.setX(mergeChild.getX() - (((float) (lottieAnimationView.getWidth() - mergeChild.getWidth())) / 2.0f));
            lottieAnimationView.setY(mergeChild.getY() - (((float) (lottieAnimationView.getHeight() - mergeChild.getWidth())) / 2.0f));
            lottieAnimationView.mo9732b();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ax */
    static final class C3466ax extends Lambda implements C8246a<Unit> {
        final /* synthetic */ TravelFragment this$0;

        C3466ax(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(0);
        }

        public final void invoke() {
            Context context = this.this$0.getContext();
            if (context == null) {
                C8271i.m35380a();
            }
            C8271i.m35382a((Object) context, "context!!");
            new MergeBonusDogDilaog(context, this.this$0.m14754v(), new C8247b<MergeBonusDogItem, Unit>(this) {
                final /* synthetic */ C3466ax this$0;

                {
                    this.this$0 = r1;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((MergeBonusDogItem) obj);
                    return Unit.f27778a;
                }

                public final void invoke(MergeBonusDogItem mergeBonusDogItem) {
                    C8271i.m35386b(mergeBonusDogItem, "it");
                    TravelFragment.m14712a(this.this$0.this$0).mo22422a(mergeBonusDogItem);
                }
            }).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "score", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ay */
    static final class C3468ay extends Lambda implements C8247b<Double, Unit> {
        final /* synthetic */ TravelFragment this$0;

        C3468ay(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(1);
        }

        public /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).doubleValue());
            return Unit.f27778a;
        }

        public final void invoke(double d) {
            ResidentMemoryModel.f11323a.mo20733a(d, 1);
            ((GradientText) this.this$0.mo19880a(R.id.tv_gold_icon)).startAnimation(this.this$0.m14751s());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "position", "", "dogId", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$az */
    static final class C3469az extends Lambda implements C8258m<Integer, Integer, Unit> {
        final /* synthetic */ TravelFragment this$0;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "invoke", "com/jiayouya/travel/module/travel/ui/fragment/TravelFragment$setupView$6$1$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: TravelFragment.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$az$a */
        static final class C3470a extends Lambda implements C8247b<Integer, Unit> {
            final /* synthetic */ int $dogId$inlined;
            final /* synthetic */ int $position$inlined;
            final /* synthetic */ C3469az this$0;

            C3470a(C3469az azVar, int i, int i2) {
                this.this$0 = azVar;
                this.$dogId$inlined = i;
                this.$position$inlined = i2;
                super(1);
            }

            public /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.f27778a;
            }

            public final void invoke(int i) {
                ((MergeLayout) this.this$0.this$0.mo19880a(R.id.lyt_merge)).mo22520a(this.$position$inlined);
            }
        }

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo39189d2 = {"<anonymous>", "", "invoke", "com/jiayouya/travel/module/travel/ui/fragment/TravelFragment$setupView$6$1$2"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: TravelFragment.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$az$b */
        static final class C3471b extends Lambda implements C8246a<Unit> {
            final /* synthetic */ int $dogId$inlined;
            final /* synthetic */ int $position$inlined;
            final /* synthetic */ C3469az this$0;

            C3471b(C3469az azVar, int i, int i2) {
                this.this$0 = azVar;
                this.$dogId$inlined = i;
                this.$position$inlined = i2;
                super(0);
            }

            public final void invoke() {
                ((MergeLayout) this.this$0.this$0.mo19880a(R.id.lyt_merge)).mo22520a(this.$position$inlined);
                TravelFragment.m14712a(this.this$0.this$0).mo22420a(this.$position$inlined);
            }
        }

        C3469az(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(2);
        }

        public /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
            return Unit.f27778a;
        }

        public final void invoke(int i, int i2) {
            Resource resource = (Resource) TravelFragment.m14712a(this.this$0).mo22425b().getValue();
            if (resource != null) {
                List list = (List) resource.getData();
                if (list != null) {
                    Iterator it = list.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i3 = -1;
                            break;
                        }
                        if (((DogShopItem) it.next()).getDogId() == i2) {
                            break;
                        }
                        i3++;
                    }
                    if (i3 != -1) {
                        DogShopItem dogShopItem = (DogShopItem) list.get(i3);
                        String str = "context!!";
                        if (i2 == 42) {
                            C3325HB hb = new C3325HB("回收单身狗立即获得5-50元红包", null, "恭喜您回收单身犬获得", null, i, 3, 10, null);
                            Context context = this.this$0.getContext();
                            if (context == null) {
                                C8271i.m35380a();
                            }
                            C8271i.m35382a((Object) context, str);
                            new HbDilaog(context, hb, new C3470a(this, i2, i)).show();
                            return;
                        }
                        Context context2 = this.this$0.getContext();
                        if (context2 == null) {
                            C8271i.m35380a();
                        }
                        C8271i.m35382a((Object) context2, str);
                        new RecycleHintDilaog(context2, i2, GoldUtil.f11900a.mo21651a(dogShopItem.getRecyclePrice()), new C3471b(this, i2, i)).show();
                    }
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$b */
    static final class C3472b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12110a;
        /* renamed from: b */
        final /* synthetic */ int[] f12111b;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "canvas", "Landroid/graphics/Canvas;", "kotlin.jvm.PlatformType", "rectF", "Landroid/graphics/RectF;", "onHighlightDrew"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: TravelFragment.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$b$a */
        static final class C3474a implements OnHighlightDrewListener {
            /* renamed from: a */
            final /* synthetic */ C3472b f12112a;

            C3474a(C3472b bVar) {
                this.f12112a = bVar;
            }

            /* renamed from: a */
            public final void mo12286a(Canvas canvas, RectF rectF) {
                canvas.drawRoundRect(rectF.left - ((float) ((MergeLayout) this.f12112a.f12110a.mo19880a(R.id.lyt_merge)).getSpace()), rectF.top - ((float) ((MergeLayout) this.f12112a.f12110a.mo19880a(R.id.lyt_merge)).getSpace()), rectF.right + rectF.width() + ((float) (((MergeLayout) this.f12112a.f12110a.mo19880a(R.id.lyt_merge)).getSpace() * 2)), rectF.bottom + ((float) ((MergeLayout) this.f12112a.f12110a.mo19880a(R.id.lyt_merge)).getSpace()), (float) GloblaEx.m12810a(10.0f), (float) GloblaEx.m12810a(10.0f), this.f12112a.f12110a.m14753u());
            }
        }

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "canvas", "Landroid/graphics/Canvas;", "kotlin.jvm.PlatformType", "rectF", "Landroid/graphics/RectF;", "onHighlightDrew"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: TravelFragment.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$b$b */
        static final class C3475b implements OnHighlightDrewListener {
            /* renamed from: a */
            final /* synthetic */ C3472b f12113a;

            C3475b(C3472b bVar) {
                this.f12113a = bVar;
            }

            /* renamed from: a */
            public final void mo12286a(Canvas canvas, RectF rectF) {
                canvas.drawRoundRect(rectF.left - ((float) GloblaEx.m12810a(15.0f)), rectF.top - ((float) GloblaEx.m12810a(15.0f)), rectF.right + ((float) GloblaEx.m12810a(15.0f)), rectF.bottom + ((float) GloblaEx.m12810a(10.0f)), (float) GloblaEx.m12810a(10.0f), (float) GloblaEx.m12810a(10.0f), this.f12113a.f12110a.m14753u());
            }
        }

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "canvas", "Landroid/graphics/Canvas;", "kotlin.jvm.PlatformType", "rectF", "Landroid/graphics/RectF;", "onHighlightDrew"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: TravelFragment.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$b$c */
        static final class C3476c implements OnHighlightDrewListener {
            /* renamed from: a */
            final /* synthetic */ C3472b f12114a;
            /* renamed from: b */
            final /* synthetic */ Paint f12115b;

            C3476c(C3472b bVar, Paint paint) {
                this.f12114a = bVar;
                this.f12115b = paint;
            }

            /* renamed from: a */
            public final void mo12286a(Canvas canvas, RectF rectF) {
                canvas.drawRoundRect(rectF.left - ((float) ((MergeLayout) this.f12114a.f12110a.mo19880a(R.id.lyt_merge)).getSpace()), rectF.top - ((float) ((MergeLayout) this.f12114a.f12110a.mo19880a(R.id.lyt_merge)).getSpace()), rectF.right + ((float) ((MergeLayout) this.f12114a.f12110a.mo19880a(R.id.lyt_merge)).getSpace()), rectF.bottom + ((float) ((MergeLayout) this.f12114a.f12110a.mo19880a(R.id.lyt_merge)).getSpace()), (float) GloblaEx.m12810a(10.0f), (float) GloblaEx.m12810a(10.0f), this.f12114a.f12110a.m14753u());
                float measuredHeight = ((float) ((MergeLayout) this.f12114a.f12110a.mo19880a(R.id.lyt_merge)).getGarbageCanView().getMeasuredHeight()) + ((float) GloblaEx.m12810a(10.0f));
                float garbageCanTop = ((float) ((MergeLayout) this.f12114a.f12110a.mo19880a(R.id.lyt_merge)).getGarbageCanTop()) - ((float) GloblaEx.m12810a(5.0f));
                canvas.drawRoundRect(((float) GloblaEx.m12809a()) - measuredHeight, garbageCanTop, (float) GloblaEx.m12809a(), garbageCanTop + measuredHeight, (float) GloblaEx.m12810a(10.0f), (float) GloblaEx.m12810a(10.0f), this.f12115b);
            }
        }

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/app/hubert/guide/core/Controller;", "onLayoutInflated"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: TravelFragment.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$b$d */
        static final class C3477d implements OnLayoutInflatedListener {
            /* renamed from: a */
            final /* synthetic */ C3472b f12116a;

            C3477d(C3472b bVar) {
                this.f12116a = bVar;
            }

            /* renamed from: a */
            public final void mo12287a(View view, Controller bVar) {
                ((LinearLayout) this.f12116a.f12110a.mo19880a(R.id.lyt_coin)).getLocationOnScreen(this.f12116a.f12111b);
                TextView textView = (TextView) view.findViewById(R.id.tv);
                ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.lyt_container);
                C8271i.m35382a((Object) viewGroup, "lyt");
                viewGroup.setY(((float) this.f12116a.f12111b[1]) + ((float) GloblaEx.m12810a(50.0f)));
                C8271i.m35382a((Object) textView, "tv");
                textView.setText(Html.fromHtml(this.f12116a.f12110a.getString(R.string.green_and_white, "拖动合成", "高等级的狗")));
            }
        }

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/app/hubert/guide/core/Controller;", "onLayoutInflated"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: TravelFragment.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$b$e */
        static final class C3478e implements OnLayoutInflatedListener {
            /* renamed from: a */
            final /* synthetic */ C3472b f12117a;

            C3478e(C3472b bVar) {
                this.f12117a = bVar;
            }

            /* renamed from: a */
            public final void mo12287a(View view, Controller bVar) {
                this.f12117a.f12110a.mo19880a(R.id.add_view).getLocationOnScreen(this.f12117a.f12111b);
                TextView textView = (TextView) view.findViewById(R.id.tv);
                textView.setY(((float) this.f12117a.f12111b[1]) - ((float) GloblaEx.m12810a(40.0f)));
                textView.setText(Html.fromHtml(this.f12117a.f12110a.getString(R.string.green_and_white, "点这里", "买更多狗")));
            }
        }

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/app/hubert/guide/core/Controller;", "onLayoutInflated"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: TravelFragment.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$b$f */
        static final class C3479f implements OnLayoutInflatedListener {
            /* renamed from: a */
            final /* synthetic */ C3472b f12118a;

            C3479f(C3472b bVar) {
                this.f12118a = bVar;
            }

            /* renamed from: a */
            public final void mo12287a(View view, Controller bVar) {
                ((LinearLayout) this.f12118a.f12110a.mo19880a(R.id.lyt_coin)).getLocationOnScreen(this.f12118a.f12111b);
                TextView textView = (TextView) view.findViewById(R.id.tv);
                ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.lyt_container);
                C8271i.m35382a((Object) viewGroup, "lyt");
                viewGroup.setY(((float) this.f12118a.f12111b[1]) + ((float) GloblaEx.m12810a(10.0f)));
                C8271i.m35382a((Object) textView, "tv");
                textView.setText(Html.fromHtml(this.f12118a.f12110a.getString(R.string.green_and_white, "拖至垃圾桶", "可回收狗狗获得空位")));
            }
        }

        C3472b(TravelFragment travelFragment, int[] iArr) {
            this.f12110a = travelFragment;
            this.f12111b = iArr;
        }

        public final void run() {
            GuidePage a = GuidePage.m4830a().mo12321a((int) R.layout.layout_guide_1, new int[0]).mo12323a((View) ((MergeLayout) this.f12110a.mo19880a(R.id.lyt_merge)).getChildList().get(0), new C1591a().mo12334a(new C3474a(this)).mo12335a()).mo12324a(new C3477d(this));
            GuidePage a2 = GuidePage.m4830a().mo12321a((int) R.layout.layout_guide_2, new int[0]).mo12323a(this.f12110a.mo19880a(R.id.add_view), new C1591a().mo12334a(new C3475b(this)).mo12335a()).mo12324a(new C3478e(this));
            Paint paint = new Paint();
            paint.setColor(0);
            paint.setAntiAlias(true);
            paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
            paint.setMaskFilter(new BlurMaskFilter(10.0f, Blur.INNER));
            NewbieGuide.m4772a(this.f12110a.getActivity()).mo12300a("guide").mo12301a(true).mo12299a(a).mo12299a(a2).mo12299a(GuidePage.m4830a().mo12321a((int) R.layout.layout_guide_3, new int[0]).mo12323a((View) ((MergeLayout) this.f12110a.mo19880a(R.id.lyt_merge)).getChildList().get(0), new C1591a().mo12334a(new C3476c(this, paint)).mo12335a()).mo12324a(new C3479f(this))).mo12298a((OnGuideChangedListener) new OnGuideChangedListener() {
                /* renamed from: a */
                public void mo12284a(Controller bVar) {
                }

                /* renamed from: b */
                public void mo12285b(Controller bVar) {
                    PreferenceRes.f9605b.mo19925b(true);
                    DialogManager.f11300b.mo20713a().mo20711a();
                }
            }).mo12302a();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "view", "Lcom/jiayouya/travel/module/travel/widget/merge/MergeChild;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$ba */
    static final class C3480ba extends Lambda implements C8247b<MergeChild, Boolean> {
        final /* synthetic */ int[] $arr;
        final /* synthetic */ TravelFragment this$0;

        C3480ba(TravelFragment travelFragment, int[] iArr) {
            this.this$0 = travelFragment;
            this.$arr = iArr;
            super(1);
        }

        public /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((MergeChild) obj));
        }

        public final boolean invoke(final MergeChild mergeChild) {
            C8271i.m35386b(mergeChild, "view");
            mergeChild.getLocationOnScreen(this.$arr);
            int width = this.$arr[0] + (mergeChild.getWidth() / 2);
            int height = this.$arr[1] + (mergeChild.getHeight() / 2);
            if (this.this$0.f12082g.contains(width, height)) {
                this.this$0.m14713a(mergeChild.getItem().getDogId(), true);
            }
            if (!this.this$0.f12083h.contains(width, height)) {
                return false;
            }
            Context context = mergeChild.getContext();
            C8271i.m35382a((Object) context, "view.context");
            new WarehouseHintDialog(context, mergeChild.getItem(), new C8247b<Boolean, Unit>(this) {
                final /* synthetic */ C3480ba this$0;

                {
                    this.this$0 = r1;
                }

                public /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.f27778a;
                }

                public final void invoke(boolean z) {
                    if (z) {
                        TravelFragment.m14712a(this.this$0.this$0).mo22436e(mergeChild.getItem().getPosition());
                    }
                }
            }).show();
            return true;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$bb */
    static final class C3482bb extends Lambda implements C8246a<Unit> {
        final /* synthetic */ TravelFragment this$0;

        C3482bb(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(0);
        }

        public final void invoke() {
            this.this$0.m14704C();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/common/widget/countdownview/CountdownView;", "kotlin.jvm.PlatformType", "onEnd"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$bc */
    static final class C3483bc implements C2910a {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12119a;

        C3483bc(TravelFragment travelFragment) {
            this.f12119a = travelFragment;
        }

        /* renamed from: a */
        public final void mo20048a(CountdownView countdownView) {
            TravelVM.m14824a(TravelFragment.m14712a(this.f12119a), false, 1, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "queueIdle"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$c */
    static final class C3484c implements IdleHandler {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12120a;

        C3484c(TravelFragment travelFragment) {
            this.f12120a = travelFragment;
        }

        public final boolean queueIdle() {
            this.f12120a.f12080e = MediaPlayerUtil.m14448a("music/buy_dog.mp3");
            return false;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo39189d2 = {"com/jiayouya/travel/module/travel/ui/fragment/TravelFragment$initTopLyt$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$d */
    public static final class C3485d implements OnGlobalLayoutListener {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12121a;

        C3485d(TravelFragment travelFragment) {
            this.f12121a = travelFragment;
        }

        public void onGlobalLayout() {
            View root = TravelFragment.m14745g(this.f12121a).getRoot();
            C8271i.m35382a((Object) root, "binding.root");
            root.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int[] iArr = new int[2];
            ((LinearLayout) this.f12121a.mo19880a(R.id.lyt_coin)).getLocationOnScreen(iArr);
            int a = iArr[1] + GloblaEx.m12810a(40.0f);
            FrameLayout frameLayout = (FrameLayout) this.f12121a.mo19880a(R.id.lyt_top);
            C8271i.m35382a((Object) frameLayout, "lyt_top");
            frameLayout.getLayoutParams().height = a;
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) this.f12121a.mo19880a(R.id.far_scroll_view);
            String str = "far_scroll_view";
            C8271i.m35382a((Object) horizontalScrollView, str);
            HorizontalScrollView horizontalScrollView2 = (HorizontalScrollView) this.f12121a.mo19880a(R.id.near_scroll_view);
            String str2 = "near_scroll_view";
            C8271i.m35382a((Object) horizontalScrollView2, str2);
            int measuredHeight = a - horizontalScrollView2.getMeasuredHeight();
            HorizontalScrollView horizontalScrollView3 = (HorizontalScrollView) this.f12121a.mo19880a(R.id.far_scroll_view);
            C8271i.m35382a((Object) horizontalScrollView3, str);
            horizontalScrollView.setY(((float) (measuredHeight - horizontalScrollView3.getMeasuredHeight())) + ((float) GloblaEx.m12810a(1.0f)));
            StringBuilder sb = new StringBuilder();
            sb.append("height==");
            sb.append(a);
            sb.append(" ,measuredHeight1==");
            HorizontalScrollView horizontalScrollView4 = (HorizontalScrollView) this.f12121a.mo19880a(R.id.near_scroll_view);
            C8271i.m35382a((Object) horizontalScrollView4, str2);
            sb.append(horizontalScrollView4.getMeasuredHeight());
            sb.append(" ,measuredHeight2==");
            HorizontalScrollView horizontalScrollView5 = (HorizontalScrollView) this.f12121a.mo19880a(R.id.far_scroll_view);
            C8271i.m35382a((Object) horizontalScrollView5, str);
            sb.append(horizontalScrollView5.getMeasuredHeight());
            XLog.m12691a(sb.toString());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$e */
    static final class C3486e implements Runnable {
        /* renamed from: a */
        final /* synthetic */ ScaleLayout f12122a;

        C3486e(ScaleLayout scaleLayout) {
            this.f12122a = scaleLayout;
        }

        public final void run() {
            ScaleLayout scaleLayout = this.f12122a;
            if (scaleLayout != null) {
                scaleLayout.setEnabled(true);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$f */
    static final class C3487f implements Runnable {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12123a;

        C3487f(TravelFragment travelFragment) {
            this.f12123a = travelFragment;
        }

        public final void run() {
            TravelFragment.m14712a(this.f12123a).mo22428b(true);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/view/animation/RotateAnimation;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$g */
    static final class C3488g extends Lambda implements C8246a<RotateAnimation> {
        final /* synthetic */ TravelFragment this$0;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, mo39189d2 = {"com/jiayouya/travel/module/travel/ui/fragment/TravelFragment$rotateAnimation$2$1$1", "Lcom/jiayouya/travel/common/AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
        /* compiled from: TravelFragment.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$g$a */
        public static final class C3489a extends AnimationListener {
            /* renamed from: a */
            final /* synthetic */ C3488g f12124a;

            C3489a(C3488g gVar) {
                this.f12124a = gVar;
            }

            public void onAnimationEnd(Animation animation) {
                if (((ScaleLayout) this.f12124a.this$0.mo19880a(R.id.lyt_add)) != null) {
                    ((ScaleLayout) this.f12124a.this$0.mo19880a(R.id.lyt_add)).postDelayed(this.f12124a.this$0.f12087l, 5000);
                }
            }
        }

        C3488g(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(0);
        }

        public final RotateAnimation invoke() {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 8.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setAnimationListener(new C3489a(this));
            rotateAnimation.setInterpolator(new CycleInterpolator(4.0f));
            rotateAnimation.setDuration(600);
            return rotateAnimation;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$h */
    static final class C3490h implements Runnable {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12125a;

        C3490h(TravelFragment travelFragment) {
            this.f12125a = travelFragment;
        }

        public final void run() {
            this.f12125a.m14706E();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$i */
    static final class C3491i extends Lambda implements C8246a<Animation> {
        final /* synthetic */ TravelFragment this$0;

        C3491i(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(0);
        }

        public final Animation invoke() {
            return AnimationUtils.loadAnimation(this.this$0.getContext(), R.anim.anim_coin_scale);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo39189d2 = {"com/jiayouya/travel/module/travel/ui/fragment/TravelFragment$setBgAnim$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$j */
    public static final class C3492j implements OnGlobalLayoutListener {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12126a;
        /* renamed from: b */
        final /* synthetic */ View f12127b;
        /* renamed from: c */
        final /* synthetic */ long f12128c;

        C3492j(TravelFragment travelFragment, View view, long j) {
            this.f12126a = travelFragment;
            this.f12127b = view;
            this.f12128c = j;
        }

        public void onGlobalLayout() {
            int measuredWidth;
            this.f12127b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            Animation animation = this.f12127b.getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            View view = this.f12127b;
            if (C8271i.m35384a((Object) view, (Object) (HorizontalScrollView) this.f12126a.mo19880a(R.id.far_scroll_view))) {
                ImageView imageView = (ImageView) this.f12126a.mo19880a(R.id.bg_far);
                C8271i.m35382a((Object) imageView, "bg_far");
                measuredWidth = imageView.getMeasuredWidth();
            } else if (C8271i.m35384a((Object) view, (Object) (HorizontalScrollView) this.f12126a.mo19880a(R.id.middle_scroll_view))) {
                ImageView imageView2 = (ImageView) this.f12126a.mo19880a(R.id.bg_middle);
                C8271i.m35382a((Object) imageView2, "bg_middle");
                measuredWidth = imageView2.getMeasuredWidth();
            } else {
                ImageView imageView3 = (ImageView) this.f12126a.mo19880a(R.id.bg_near);
                C8271i.m35382a((Object) imageView3, "bg_near");
                measuredWidth = imageView3.getMeasuredWidth();
            }
            int i = measuredWidth;
            TravelFragment travelFragment = this.f12126a;
            travelFragment.m14710a(travelFragment.m14732b(this.f12127b), this.f12128c, this.f12127b, i).start();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo39189d2 = {"com/jiayouya/travel/module/travel/ui/fragment/TravelFragment$setMergeLytRangeY$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$k */
    public static final class C3493k implements OnGlobalLayoutListener {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12129a;

        C3493k(TravelFragment travelFragment) {
            this.f12129a = travelFragment;
        }

        public void onGlobalLayout() {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f12129a.mo19880a(R.id.walk_lottie_view);
            String str = "walk_lottie_view";
            C8271i.m35382a((Object) lottieAnimationView, str);
            lottieAnimationView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int[] iArr = new int[2];
            ((LottieAnimationView) this.f12129a.mo19880a(R.id.walk_lottie_view)).getLocationOnScreen(iArr);
            Rect d = this.f12129a.f12082g;
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = iArr[0];
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f12129a.mo19880a(R.id.walk_lottie_view);
            C8271i.m35382a((Object) lottieAnimationView2, str);
            int measuredWidth = i3 + lottieAnimationView2.getMeasuredWidth();
            int i4 = iArr[1];
            LottieAnimationView lottieAnimationView3 = (LottieAnimationView) this.f12129a.mo19880a(R.id.walk_lottie_view);
            C8271i.m35382a((Object) lottieAnimationView3, str);
            d.set(i, i2, measuredWidth, i4 + lottieAnimationView3.getMeasuredHeight());
            ((ImageView) this.f12129a.mo19880a(R.id.iv_shop)).getLocationOnScreen(iArr);
            MergeLayout mergeLayout = (MergeLayout) this.f12129a.mo19880a(R.id.lyt_merge);
            int i5 = iArr[1];
            ImageView imageView = (ImageView) this.f12129a.mo19880a(R.id.iv_shop);
            C8271i.m35382a((Object) imageView, "iv_shop");
            mergeLayout.setMinTouchRangeY(i5 + imageView.getMeasuredHeight());
            ((FrameLayout) this.f12129a.mo19880a(R.id.lyt_bottom)).getLocationOnScreen(iArr);
            ((MergeLayout) this.f12129a.mo19880a(R.id.lyt_merge)).setMaxTouchRangeY(iArr[1]);
            TextView textView = (TextView) this.f12129a.mo19880a(R.id.tv_warehouse);
            textView.getLocationOnScreen(iArr);
            this.f12129a.f12083h.set(iArr[0] - GloblaEx.m12810a(10.0f), iArr[1] - GloblaEx.m12810a(10.0f), iArr[0] + textView.getWidth() + GloblaEx.m12810a(10.0f), iArr[1] + textView.getHeight() + GloblaEx.m12810a(10.0f));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$l */
    static final class C3494l implements Runnable {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12130a;

        C3494l(TravelFragment travelFragment) {
            this.f12130a = travelFragment;
        }

        public final void run() {
            TravelFragment.m14745g(this.f12130a).mo20160a(this.f12130a.m14703B());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$m */
    static final class C3495m extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TravelFragment this$0;

        C3495m(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(final View view) {
            C8271i.m35386b(view, "it");
            view.animate().scaleX(1.2f).scaleY(1.2f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).setListener(null).start();
                }
            }).start();
            if (((MergeLayout) this.this$0.mo19880a(R.id.lyt_merge)).mo22525c()) {
                GloblaEx.m12816a("位置已满，请先合成或回收狗狗", 0, 0, 6, null);
                return;
            }
            SuggestBuyItem a = TravelFragment.m14745g(this.this$0).mo20155a();
            if (a != null) {
                TravelFragment.m14712a(this.this$0).mo22426b(a.getDogId());
                MediaPlayer i = this.this$0.f12080e;
                if (i != null) {
                    MediaPlayerUtil.m14449a(i);
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$n */
    static final class C3497n extends Lambda implements C8247b<View, Unit> {
        public static final C3497n INSTANCE = new C3497n();

        C3497n() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Router.m12969a(Router.f9644a, "/travel/handbook", null, null, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$o */
    static final class C3498o extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TravelFragment this$0;

        C3498o(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            TravelFragment.m14712a(this.this$0).mo22446n();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$p */
    static final class C3499p extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TravelFragment this$0;

        C3499p(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Object tag = ((LottieAnimationView) this.this$0.mo19880a(R.id.walk_lottie_view)).getTag(R.id.tag);
            if (tag instanceof Integer) {
                if (C8271i.m35384a(tag, (Object) Integer.valueOf(47))) {
                    Iterator it = ((MergeLayout) this.this$0.mo19880a(R.id.lyt_merge)).getChildList().iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        }
                        if (((MergeChild) it.next()).getItem().getDogId() == 38) {
                            break;
                        }
                        i++;
                    }
                    if (i != -1) {
                        Object tag2 = ((CountdownView) this.this$0.mo19880a(R.id.bonus_countdown_view)).getTag(R.id.tag);
                        if (tag2 instanceof PositionExtra) {
                            long expire = ((PositionExtra) tag2).getExpire() / ((long) 60);
                            RiseText riseText = (RiseText) this.this$0.mo19880a(R.id.tv_rise);
                            C8271i.m35382a((Object) riseText, "tv_rise");
                            TempBonusItem tempBonusItem = new TempBonusItem(expire, riseText.getText().toString());
                            Context context = view.getContext();
                            C8271i.m35382a((Object) context, "it.context");
                            new TempBonusDilaog(context, tempBonusItem).show();
                            return;
                        }
                        return;
                    }
                }
                TravelFragment.m14712a(this.this$0).mo22430c(((Number) tag).intValue());
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$q */
    static final class C3500q extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TravelFragment this$0;

        C3500q(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            TravelFragment.m14712a(this.this$0).mo22448p();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$r */
    static final class C3501r extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TravelFragment this$0;

        C3501r(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            TravelFragment.m14712a(this.this$0).mo22456x();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$s */
    static final class C3502s extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TravelFragment this$0;

        C3502s(TravelFragment travelFragment) {
            this.this$0 = travelFragment;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            TravelFragment.m14712a(this.this$0).mo22424a(true);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Double;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$t */
    static final class C3503t<T> implements Observer<Double> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12132a;

        C3503t(TravelFragment travelFragment) {
            this.f12132a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(Double d) {
            GradientText gradientText = (GradientText) this.f12132a.mo19880a(R.id.tv_gold_icon);
            C8271i.m35382a((Object) gradientText, "tv_gold_icon");
            GoldUtil aVar = GoldUtil.f11900a;
            C8271i.m35382a((Object) d, "it");
            gradientText.setText(aVar.mo21651a(d.doubleValue()));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004 \u0006*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/Resource;", "", "Lcom/jiayouya/travel/module/travel/data/DogShopItem;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$u */
    static final class C3504u<T> implements Observer<Resource<List<? extends DogShopItem>>> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12133a;

        C3504u(TravelFragment travelFragment) {
            this.f12133a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(Resource<List<DogShopItem>> resource) {
            Object extra = resource.getExtra();
            if (extra instanceof Boolean) {
                if (((Boolean) extra).booleanValue()) {
                    List list = (List) resource.getData();
                    if (list != null) {
                        Iterable iterable = list;
                        Collection arrayList = new ArrayList();
                        for (Object next : iterable) {
                            if (((DogShopItem) next).getLevel() <= 37) {
                                arrayList.add(next);
                            }
                        }
                        List list2 = (List) arrayList;
                        Context context = this.f12133a.getContext();
                        if (context == null) {
                            C8271i.m35380a();
                        }
                        C8271i.m35382a((Object) context, "context!!");
                        new DogShopDialog(context, list2).show();
                    }
                }
                List list3 = (List) resource.getData();
                if (list3 != null) {
                    this.f12133a.m14736b(list3);
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/BuyDogRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$v */
    static final class C3505v<T> implements Observer<BuyDogRsp> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12134a;

        C3505v(TravelFragment travelFragment) {
            this.f12134a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(BuyDogRsp buyDogRsp) {
            TravelFragment travelFragment = this.f12134a;
            C8271i.m35382a((Object) buyDogRsp, "it");
            travelFragment.m14716a(buyDogRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/Resource;", "Lcom/jiayouya/travel/module/travel/data/MergeDogRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$w */
    static final class C3506w<T> implements Observer<Resource<MergeDogRsp>> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12135a;

        C3506w(TravelFragment travelFragment) {
            this.f12135a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(final Resource<MergeDogRsp> resource) {
            if (resource != null) {
                ResourceEx.m12833a(resource, new C8246a<Unit>(this) {
                    final /* synthetic */ C3506w this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        MergeDogRsp mergeDogRsp = (MergeDogRsp) resource.getData();
                        if (mergeDogRsp != null) {
                            TravelFragment.m14727a(this.this$0.f12135a, mergeDogRsp, false, 2, (Object) null);
                        }
                    }
                }, null, null, 6, null);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004 \u0006*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/Resource;", "", "Lcom/jiayouya/travel/module/travel/data/MergeDialItem;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$x */
    static final class C3508x<T> implements Observer<Resource<List<? extends MergeDialItem>>> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12136a;

        C3508x(TravelFragment travelFragment) {
            this.f12136a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(final Resource<List<MergeDialItem>> resource) {
            C8271i.m35382a((Object) resource, "it");
            ResourceEx.m12833a(resource, new C8246a<Unit>(this) {
                final /* synthetic */ C3508x this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    final Object extra = resource.getExtra();
                    List list = (List) resource.getData();
                    if (list != null && (extra instanceof MergeDialExtra)) {
                        MergeDialExtra mergeDialExtra = (MergeDialExtra) extra;
                        final MergeChild mergeChild = (MergeChild) ((MergeLayout) this.this$0.f12136a.mo19880a(R.id.lyt_merge)).getChildList().get(mergeDialExtra.getP2() - 1);
                        Context context = this.this$0.f12136a.getContext();
                        if (context == null) {
                            C8271i.m35380a();
                        }
                        C8271i.m35382a((Object) context, "context!!");
                        RandomMergeDilaog nVar = new RandomMergeDilaog(context, mergeDialExtra, list, new C8246a<Unit>(this) {
                            final /* synthetic */ C35091 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public final void invoke() {
                                mergeChild.getItem().setLevel(mergeChild.getItem().getLevel() - 1);
                                MergeLayout mergeLayout = (MergeLayout) this.this$0.this$0.f12136a.mo19880a(R.id.lyt_merge);
                                MergeLayout.m14943a(mergeLayout, mergeChild, false, 2, null);
                                Object tag = mergeChild.getTag(R.id.tag);
                                if (tag instanceof PositionItem) {
                                    MergeChild mergeChild = (MergeChild) mergeLayout.getChildList().get(((MergeDialExtra) extra).getP1() - 1);
                                    mergeChild.setItem((PositionItem) tag);
                                    MergeLayout.m14943a(mergeLayout, mergeChild, false, 2, null);
                                }
                            }
                        }, new C8247b<MergeDogRsp, Unit>(this) {
                            final /* synthetic */ C35091 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((MergeDogRsp) obj);
                                return Unit.f27778a;
                            }

                            public final void invoke(MergeDogRsp mergeDogRsp) {
                                C8271i.m35386b(mergeDogRsp, "rsp");
                                this.this$0.this$0.f12136a.m14717a(mergeDogRsp, true);
                                DialogManager a = DialogManager.f11300b.mo20713a();
                                FragmentActivity activity = this.this$0.this$0.f12136a.getActivity();
                                if (activity == null) {
                                    C8271i.m35380a();
                                }
                                C8271i.m35382a((Object) activity, "activity!!");
                                a.mo20712a(new GetMaxLevelDogDilaog(activity, mergeDogRsp.getMerge().getName(), mergeDogRsp.getMerge().getDogId(), mergeDogRsp.getMerge().getDesc()));
                                a.mo20711a();
                            }
                        });
                        nVar.show();
                    }
                }
            }, null, null, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/Resource;", "Lcom/jiayouya/travel/module/travel/data/LoversMerge;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$y */
    static final class C3512y<T> implements Observer<Resource<LoversMerge>> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12137a;

        C3512y(TravelFragment travelFragment) {
            this.f12137a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(final Resource<LoversMerge> resource) {
            if (resource != null) {
                ResourceEx.m12833a(resource, new C8246a<Unit>(this) {
                    final /* synthetic */ C3512y this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        Object extra = resource.getExtra();
                        if (extra instanceof int[]) {
                            MergeLayout mergeLayout = (MergeLayout) this.this$0.f12137a.mo19880a(R.id.lyt_merge);
                            int[] iArr = (int[]) extra;
                            mergeLayout.mo22520a(iArr[0]);
                            mergeLayout.mo22520a(iArr[1]);
                        }
                        LoversMerge loversMerge = (LoversMerge) resource.getData();
                        if (loversMerge != null) {
                            RxBus.f27263a.mo38572a((Object) new HbAmountEvent(loversMerge.getAmount()));
                        }
                    }
                }, null, null, 6, null);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/BagInfo;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelFragment.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$z */
    static final class C3514z<T> implements Observer<BagInfo> {
        /* renamed from: a */
        final /* synthetic */ TravelFragment f12138a;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo39189d2 = {"<anonymous>", "", "invoke", "com/jiayouya/travel/module/travel/ui/fragment/TravelFragment$setupObserver$15$1$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: TravelFragment.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$z$a */
        static final class C3515a extends Lambda implements C8246a<Boolean> {
            final /* synthetic */ BagInfo $it$inlined;
            final /* synthetic */ C3514z this$0;

            C3515a(C3514z zVar, BagInfo bagInfo) {
                this.this$0 = zVar;
                this.$it$inlined = bagInfo;
                super(0);
            }

            public final boolean invoke() {
                return !((MergeLayout) this.this$0.f12138a.mo19880a(R.id.lyt_merge)).mo22525c();
            }
        }

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo39189d2 = {"<anonymous>", "", "dogId", "", "invoke", "com/jiayouya/travel/module/travel/ui/fragment/TravelFragment$setupObserver$15$1$2"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: TravelFragment.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.fragment.TravelFragment$z$b */
        static final class C3516b extends Lambda implements C8247b<Integer, Unit> {
            final /* synthetic */ BagInfo $it$inlined;
            final /* synthetic */ C3514z this$0;

            C3516b(C3514z zVar, BagInfo bagInfo) {
                this.this$0 = zVar;
                this.$it$inlined = bagInfo;
                super(1);
            }

            public /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.f27778a;
            }

            public final void invoke(int i) {
                if (((MergeLayout) this.this$0.f12138a.mo19880a(R.id.lyt_merge)).mo22525c()) {
                    GloblaEx.m12816a("位置已满，请先合成或回收狗狗", 0, 0, 6, null);
                } else {
                    TravelFragment.m14712a(this.this$0.f12138a).mo22438f(i);
                }
            }
        }

        C3514z(TravelFragment travelFragment) {
            this.f12138a = travelFragment;
        }

        /* renamed from: a */
        public final void onChanged(BagInfo bagInfo) {
            FragmentActivity activity = this.f12138a.getActivity();
            if (activity != null) {
                C8271i.m35382a((Object) activity, Constants.FLAG_ACTIVITY_NAME);
                if (!activity.isDestroyed() && !activity.isFinishing()) {
                    Activity activity2 = activity;
                    C8271i.m35382a((Object) bagInfo, "it");
                    new WarehouseDilaog(activity2, bagInfo, new C3515a(this, bagInfo), new C3516b(this, bagInfo)).show();
                }
            }
        }
    }

    static {
        Class<TravelFragment> cls = TravelFragment.class;
        f12078c = new C8280j[]{C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "scaleAnim", "getScaleAnim()Landroid/view/animation/Animation;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "guidePaint", "getGuidePaint()Landroid/graphics/Paint;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "rotateAnimation", "getRotateAnimation()Landroid/view/animation/RotateAnimation;"))};
    }

    /* renamed from: D */
    private final RotateAnimation m14705D() {
        Lazy bVar = this.f12086k;
        C8280j jVar = f12078c[2];
        return (RotateAnimation) bVar.getValue();
    }

    /* renamed from: f */
    private final String m14743f(int i) {
        switch (i) {
            case 1:
                return "beijing";
            case 2:
                return "rb";
            case 3:
                return "yd";
            case 4:
                return "aiji";
            case 5:
                return "ydl";
            case 6:
                return "france";
            case 7:
                return "england";
            case 8:
                return "grl";
            case 9:
                return "canada";
            case 10:
                return "usa";
            case 11:
                return "new_york";
            case 12:
                return "zili";
            case 13:
                return "brazil";
            case 14:
                return "tns";
            case 15:
                return "mylh";
            case 16:
                return "mdjsj";
            case 17:
                return "congo";
            case 18:
                return "safrica";
            case 19:
                return "cbe";
            case 20:
                return "south_australia";
            case 21:
                return "melbourne";
            default:
                return "sydney";
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: s */
    public final Animation m14751s() {
        Lazy bVar = this.f12079d;
        C8280j jVar = f12078c[0];
        return (Animation) bVar.getValue();
    }

    /* access modifiers changed from: private|final */
    /* renamed from: u */
    public final Paint m14753u() {
        Lazy bVar = this.f12081f;
        C8280j jVar = f12078c[1];
        return (Paint) bVar.getValue();
    }

    /* renamed from: a */
    public View mo19880a(int i) {
        if (this.f12088m == null) {
            this.f12088m = new HashMap();
        }
        View view = (View) this.f12088m.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this.f12088m.put(Integer.valueOf(i), view);
        }
        return view;
    }

    /* renamed from: l */
    public int mo19896l() {
        return R.layout.fragment_travel;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo19902r();
    }

    /* renamed from: r */
    public void mo19902r() {
        HashMap hashMap = this.f12088m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ TravelVM m14712a(TravelFragment travelFragment) {
        return (TravelVM) travelFragment.mo19881a();
    }

    /* renamed from: g */
    public static final /* synthetic */ FragmentTravelBinding m14745g(TravelFragment travelFragment) {
        return (FragmentTravelBinding) travelFragment.mo19887c();
    }

    /* renamed from: e */
    public Class<TravelVM> mo19889e() {
        return TravelVM.class;
    }

    /* renamed from: f */
    public void mo19890f() {
        m14757y();
        ((LottieAnimationView) mo19880a(R.id.lottie_view)).mo9733b(true);
        ((LottieAnimationView) mo19880a(R.id.walk_lottie_view)).mo9733b(true);
        ((LottieAnimationView) mo19880a(R.id.lottie_view)).mo9727a((AnimatorListener) new C3456ap(this));
        m14758z();
        ((MergeLayout) mo19880a(R.id.lyt_merge)).setOnLoversMergeListener(new C3463av(this));
        ((MergeLayout) mo19880a(R.id.lyt_merge)).setOnMergeListener(new C3465aw(this));
        ((MergeLayout) mo19880a(R.id.lyt_merge)).setOnSuperMergeListener(new C3466ax(this));
        ((MergeLayout) mo19880a(R.id.lyt_merge)).setOnScoreAddListener(new C3468ay(this));
        ((MergeLayout) mo19880a(R.id.lyt_merge)).setOnRecycleStartListener(new C3469az(this));
        ((MergeLayout) mo19880a(R.id.lyt_merge)).setOnReleaseListener(new C3480ba(this, new int[2]));
        ((MergeLayout) mo19880a(R.id.lyt_merge)).setOnChildChangeListener(new C3482bb(this));
        ((CountdownView) mo19880a(R.id.countdown_view)).setOnCountdownEndListener(new C3483bc(this));
        ((CountdownView) mo19880a(R.id.bonus_countdown_view)).setOnCountdownEndListener(new C3457aq(this));
        ((MergeLayout) mo19880a(R.id.lyt_merge)).setOnMoveChangeListener(new C3459ar(this));
        ((HorizontalScrollView) mo19880a(R.id.far_scroll_view)).setOnTouchListener(C3460as.f12107a);
        ((HorizontalScrollView) mo19880a(R.id.middle_scroll_view)).setOnTouchListener(C3461at.f12108a);
        ((HorizontalScrollView) mo19880a(R.id.near_scroll_view)).setOnTouchListener(C3462au.f12109a);
        m14756x();
        m14702A();
        m14752t();
        m14755w();
        m14706E();
    }

    /* renamed from: t */
    private final void m14752t() {
        if (!PreferenceRes.f9605b.mo19928d()) {
            ((MergeLayout) mo19880a(R.id.lyt_merge)).postDelayed(new C3472b(this, new int[2]), 100);
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: v */
    public final MergeBonusDogItem m14754v() {
        List childList = ((MergeLayout) mo19880a(R.id.lyt_merge)).getChildList();
        Iterator it = childList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (((MergeChild) it.next()).getItem().getDogId() == 46) {
                break;
            }
            i++;
        }
        Iterator it2 = childList.iterator();
        int i2 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            }
            if (((MergeChild) it2.next()).getItem().getDogId() == 45) {
                break;
            }
            i2++;
        }
        Iterator it3 = childList.iterator();
        int i3 = 0;
        while (true) {
            if (!it3.hasNext()) {
                i3 = -1;
                break;
            }
            if (((MergeChild) it3.next()).getItem().getDogId() == 41) {
                break;
            }
            i3++;
        }
        Iterator it4 = childList.iterator();
        int i4 = 0;
        while (true) {
            if (!it4.hasNext()) {
                i4 = -1;
                break;
            }
            if (((MergeChild) it4.next()).getItem().getDogId() == 40) {
                break;
            }
            i4++;
        }
        Iterator it5 = childList.iterator();
        int i5 = 0;
        while (true) {
            if (!it5.hasNext()) {
                i5 = -1;
                break;
            }
            if (((MergeChild) it5.next()).getItem().getDogId() == 39) {
                break;
            }
            i5++;
        }
        if (i != -1) {
            i++;
        }
        int i6 = i;
        if (i3 != -1) {
            i3++;
        }
        int i7 = i3;
        if (i2 != -1) {
            i2++;
        }
        int i8 = i2;
        if (i5 != -1) {
            i5++;
        }
        int i9 = i5;
        if (i4 != -1) {
            i4++;
        }
        MergeBonusDogItem mergeBonusDogItem = new MergeBonusDogItem(i6, i7, i8, i9, i4);
        return mergeBonusDogItem;
    }

    /* renamed from: w */
    private final void m14755w() {
        Context context = getContext();
        if (context == null) {
            C8271i.m35380a();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_profit_scale);
        FrameLayout frameLayout = (FrameLayout) mo19880a(R.id.lyt_bonus_profit);
        C8271i.m35382a((Object) frameLayout, "lyt_bonus_profit");
        frameLayout.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    /* renamed from: x */
    private final void m14756x() {
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) mo19880a(R.id.far_scroll_view);
        C8271i.m35382a((Object) horizontalScrollView, "far_scroll_view");
        m14715a((View) horizontalScrollView, 250000);
        HorizontalScrollView horizontalScrollView2 = (HorizontalScrollView) mo19880a(R.id.middle_scroll_view);
        C8271i.m35382a((Object) horizontalScrollView2, "middle_scroll_view");
        m14715a((View) horizontalScrollView2, 200000);
        HorizontalScrollView horizontalScrollView3 = (HorizontalScrollView) mo19880a(R.id.near_scroll_view);
        C8271i.m35382a((Object) horizontalScrollView3, "near_scroll_view");
        m14715a((View) horizontalScrollView3, 12000);
    }

    /* renamed from: y */
    private final void m14757y() {
        Looper.myQueue().addIdleHandler(new C3484c(this));
    }

    /* renamed from: a */
    static /* synthetic */ void m14722a(TravelFragment travelFragment, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        travelFragment.m14713a(i, z);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14713a(int i, boolean z) {
        int i2 = 0;
        if (C8271i.m35384a(((LottieAnimationView) mo19880a(R.id.walk_lottie_view)).getTag(R.id.tag), (Object) Integer.valueOf(47))) {
            Iterator it = ((MergeLayout) mo19880a(R.id.lyt_merge)).getChildList().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                }
                if (((MergeChild) it.next()).getItem().getDogId() == 38) {
                    break;
                }
                i3++;
            }
            if (i3 != -1) {
                return;
            }
        }
        if (i != 0 && z) {
            ((TravelVM) mo19881a()).mo22434d(i);
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) mo19880a(R.id.walk_lottie_view);
        LayoutParams layoutParams = lottieAnimationView.getLayoutParams();
        if (layoutParams != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            if (i > 37) {
                i2 = GloblaEx.m12810a(20.0f);
            }
            marginLayoutParams.setMarginEnd(i2);
            lottieAnimationView.setLayoutParams(marginLayoutParams);
            if (i == 38) {
                i = 47;
            }
            if (1 <= i && 47 >= i) {
                try {
                    lottieAnimationView.setTag(R.id.tag, Integer.valueOf(i));
                    lottieAnimationView.setImageAssetsFolder(m14738c(i));
                    lottieAnimationView.setAnimation(m14734b(i));
                    lottieAnimationView.mo9732b();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* renamed from: b */
    private final String m14734b(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie/walk/level_");
        sb.append(i);
        sb.append("/data.json");
        return sb.toString();
    }

    /* renamed from: c */
    private final String m14738c(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie/walk/level_");
        sb.append(i);
        sb.append("/images");
        return sb.toString();
    }

    /* renamed from: z */
    private final void m14758z() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) mo19880a(R.id.walk_lottie_view);
        C8271i.m35382a((Object) lottieAnimationView, "walk_lottie_view");
        lottieAnimationView.getViewTreeObserver().addOnGlobalLayoutListener(new C3493k(this));
    }

    /* renamed from: a */
    public void mo19884a(boolean z) {
        ((TravelVM) mo19881a()).mo22443k();
        ((TravelVM) mo19881a()).mo22419B();
    }

    /* renamed from: k */
    public void mo19895k() {
        ScaleLayout scaleLayout = (ScaleLayout) mo19880a(R.id.lyt_add);
        C8271i.m35382a((Object) scaleLayout, "lyt_add");
        ezy.p642a.View.m34749a(scaleLayout, 500, new C3495m(this));
        TextView textView = (TextView) mo19880a(R.id.tv_handbook);
        C8271i.m35382a((Object) textView, "tv_handbook");
        ezy.p642a.View.m34750a(textView, 0, C3497n.INSTANCE, 1, null);
        ImageView imageView = (ImageView) mo19880a(R.id.iv_luck_draw);
        C8271i.m35382a((Object) imageView, "iv_luck_draw");
        ezy.p642a.View.m34750a(imageView, 0, new C3498o(this), 1, null);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) mo19880a(R.id.walk_lottie_view);
        C8271i.m35382a((Object) lottieAnimationView, "walk_lottie_view");
        ezy.p642a.View.m34750a(lottieAnimationView, 0, new C3499p(this), 1, null);
        FrameLayout frameLayout = (FrameLayout) mo19880a(R.id.lyt_free_coin);
        C8271i.m35382a((Object) frameLayout, "lyt_free_coin");
        ezy.p642a.View.m34750a(frameLayout, 0, new C3500q(this), 1, null);
        TextView textView2 = (TextView) mo19880a(R.id.tv_warehouse);
        C8271i.m35382a((Object) textView2, "tv_warehouse");
        ezy.p642a.View.m34750a(textView2, 0, new C3501r(this), 1, null);
        ImageView imageView2 = (ImageView) mo19880a(R.id.iv_shop);
        C8271i.m35382a((Object) imageView2, "iv_shop");
        ezy.p642a.View.m34750a(imageView2, 0, new C3502s(this), 1, null);
    }

    /* renamed from: g */
    public void mo19891g() {
        super.mo19891g();
        LifecycleOwner lifecycleOwner = this;
        ResidentMemoryModel.f11323a.mo20732a().observe(lifecycleOwner, new C3503t(this));
        ((TravelVM) mo19881a()).mo22429c().observe(lifecycleOwner, C3443ae.f12093a);
        ((TravelVM) mo19881a()).mo22445m().observe(lifecycleOwner, new C3447ai(this));
        ((TravelVM) mo19881a()).mo22447o().observe(lifecycleOwner, new C3448aj(this));
        ((TravelVM) mo19881a()).mo22451s().observe(lifecycleOwner, new C3449ak(this));
        ((TravelVM) mo19881a()).mo22449q().observe(lifecycleOwner, new C3450al(this));
        ((TravelVM) mo19881a()).mo22454v().observe(lifecycleOwner, new C3451am(this));
        ((TravelVM) mo19881a()).mo22440h().observe(lifecycleOwner, new C3453an(this));
        ((TravelVM) mo19881a()).mo22435e().observe(lifecycleOwner, new C3454ao(this));
        ((TravelVM) mo19881a()).mo22425b().observe(lifecycleOwner, new C3504u(this));
        ((TravelVM) mo19881a()).mo22433d().observe(lifecycleOwner, new C3505v(this));
        ((TravelVM) mo19881a()).mo22437f().observe(lifecycleOwner, new C3506w(this));
        ((TravelVM) mo19881a()).mo22452t().observe(lifecycleOwner, new C3508x(this));
        ((TravelVM) mo19881a()).mo22453u().observe(lifecycleOwner, new C3512y(this));
        ((TravelVM) mo19881a()).mo22455w().observe(lifecycleOwner, new C3514z(this));
        ((TravelVM) mo19881a()).mo22457y().observe(lifecycleOwner, new C3439aa(this));
        ((TravelVM) mo19881a()).mo22458z().observe(lifecycleOwner, new C3440ab(this));
        ((TravelVM) mo19881a()).mo22418A().observe(lifecycleOwner, new C3441ac(this));
        C8019a.m34778a(RxBus.f27263a.mo38571a(RefreshDrawDotEvent.class), lifecycleOwner, null, 2, null).mo37374a(new C3442ad(this));
        C8019a.m34778a(RxBus.f27263a.mo38571a(BuyDogRsp.class), lifecycleOwner, null, 2, null).mo37374a(new C3444af(this));
        C8019a.m34778a(RxBus.f27263a.mo38571a(TempDogDismissEvent.class), lifecycleOwner, null, 2, null).mo37374a(new C3445ag(this));
        C8019a.m34778a(RxBus.f27263a.mo38571a(LogoutEvent.class), lifecycleOwner, null, 2, null).mo37374a(new C3446ah(this));
    }

    /* renamed from: A */
    private final void m14702A() {
        View root = ((FragmentTravelBinding) mo19887c()).getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getViewTreeObserver().addOnGlobalLayoutListener(new C3485d(this));
    }

    /* renamed from: a */
    private final void m14715a(View view, long j) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new C3492j(this, view, j));
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        this.f12084i = !getUserVisibleHint();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z && this.f12084i) {
            XLog.m12691a("isNeedProcessUI");
            m14758z();
            m14702A();
            m14756x();
            this.f12084i = false;
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final ObjectAnimator m14710a(int i, long j, View view, int i2) {
        int i3 = 0;
        ObjectAnimator ofInt = ObjectAnimator.ofInt(view, "scrollX", new int[]{i, i2});
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration((long) ((((float) 1) - (((float) i) / ((float) i2))) * ((float) j)));
        ofInt.setRepeatMode(1);
        if (i == 0) {
            i3 = -1;
        }
        ofInt.setRepeatCount(i3);
        C8271i.m35382a((Object) ofInt, "anim.apply {\n           …//            }\n        }");
        return ofInt;
    }

    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final int m14732b(View view) {
        Object tag = view.getTag(R.id.tag);
        if (tag instanceof Integer) {
            return ((Number) tag).intValue();
        }
        return 0;
    }

    /* access modifiers changed from: private|final */
    /* renamed from: B */
    public final String m14703B() {
        String str = "0";
        if (((MergeLayout) mo19880a(R.id.lyt_merge)) == null) {
            return str;
        }
        double d = 0.0d;
        Iterable childList = ((MergeLayout) mo19880a(R.id.lyt_merge)).getChildList();
        Collection arrayList = new ArrayList();
        for (Object next : childList) {
            if (PositionItemKt.validate(((MergeChild) next).getItem())) {
                arrayList.add(next);
            }
        }
        List<MergeChild> list = (List) arrayList;
        if (list.isEmpty()) {
            return str;
        }
        for (MergeChild item : list) {
            d += m14739d(item.getItem().getLevel());
        }
        return GoldUtil.f11900a.mo21651a(d);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14719a(SuggestBuyItem suggestBuyItem) {
        ((FragmentTravelBinding) mo19887c()).mo20159a(suggestBuyItem);
        TextView textView = (TextView) mo19880a(R.id.tv_price);
        C8271i.m35382a((Object) textView, "tv_price");
        textView.setText(GoldUtil.f11900a.mo21651a(suggestBuyItem.getPrice()));
    }

    /* renamed from: d */
    private final double m14739d(int i) {
        Resource resource = (Resource) ((TravelVM) mo19881a()).mo22425b().getValue();
        if (resource != null) {
            List list = (List) resource.getData();
            if (list != null) {
                Iterator it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (((DogShopItem) it.next()).getLevel() == i) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1) {
                    return ((DogShopItem) list.get(i2)).getCoinProfit();
                }
            }
        }
        return 0.0d;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            if (mo19888d()) {
                ((MergeLayout) mo19880a(R.id.lyt_merge)).setUserVisibleHint(true);
                BaseFragment.m12877a(this, false, 1, null);
            }
        } else if (mo19888d()) {
            ((MergeLayout) mo19880a(R.id.lyt_merge)).setUserVisibleHint(false);
        }
    }

    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            ((MergeLayout) mo19880a(R.id.lyt_merge)).setUserVisibleHint(true);
            BaseFragment.m12877a(this, false, 1, null);
        }
    }

    public void onPause() {
        super.onPause();
        ((MergeLayout) mo19880a(R.id.lyt_merge)).setUserVisibleHint(false);
    }

    public void onDestroy() {
        super.onDestroy();
        MediaPlayer mediaPlayer = this.f12080e;
        if (mediaPlayer != null) {
            MediaPlayerUtil.m14450b(mediaPlayer);
        }
        m14707F();
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14714a(long j) {
        FrameLayout frameLayout = (FrameLayout) mo19880a(R.id.lyt_free_coin);
        C8271i.m35382a((Object) frameLayout, "lyt_free_coin");
        boolean z = true;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        frameLayout.setEnabled(i <= 0);
        if (i > 0) {
            ((CountdownView) mo19880a(R.id.countdown_view)).mo20033a(j * ((long) 1000));
        }
        CountdownView countdownView = (CountdownView) mo19880a(R.id.countdown_view);
        C8271i.m35382a((Object) countdownView, "countdown_view");
        ViewEx.m12842b(countdownView, i <= 0);
        ImageView imageView = (ImageView) mo19880a(R.id.iv_claim);
        C8271i.m35382a((Object) imageView, "iv_claim");
        View view = imageView;
        if (i <= 0) {
            z = false;
        }
        ViewEx.m12842b(view, z);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14718a(PositionExtra positionExtra, long j) {
        long j2 = (long) 1000;
        long expire = (positionExtra.getExpire() * j2) - (System.currentTimeMillis() - (j * j2));
        StringBuilder sb = new StringBuilder();
        sb.append("time1==");
        sb.append(expire);
        XLog.m12691a(sb.toString());
        if (expire > 0) {
            m14722a(this, 38, false, 2, (Object) null);
            ((CountdownView) mo19880a(R.id.bonus_countdown_view)).setTag(R.id.tag, positionExtra);
            ((FragmentTravelBinding) mo19887c()).mo20156a(expire);
            if (this.f12085j != positionExtra.getAmount()) {
                this.f12085j = positionExtra.getAmount();
                RiseText riseText = (RiseText) mo19880a(R.id.tv_rise);
                riseText.setDuration(expire);
                riseText.mo20021a(0.0d, positionExtra.getAmount());
            }
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14716a(BuyDogRsp buyDogRsp) {
        PositionItem position = buyDogRsp.getPosition();
        boolean z = true;
        if (position != null) {
            ((MergeLayout) mo19880a(R.id.lyt_merge)).mo22521a(position, position.getPosition() - 1);
        }
        SuggestBuyItem suggest = buyDogRsp.getSuggest();
        if (suggest != null) {
            m14719a(suggest);
        }
        if (buyDogRsp.getPosition() == null || buyDogRsp.getSuggest() == null) {
            z = false;
        }
        if (z) {
            ResidentMemoryModel.f11323a.mo20733a(buyDogRsp.getCoin(), 2);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            C8271i.m35382a((Object) activity, "activity ?: return");
            ScaleLayout scaleLayout = (ScaleLayout) mo19880a(R.id.lyt_add);
            Object tag = scaleLayout.getTag(R.id.tag_last_click_time);
            if (System.currentTimeMillis() - (tag instanceof Long ? ((Number) tag).longValue() : 0) < ((long) 1000)) {
                scaleLayout.setEnabled(false);
                scaleLayout.postDelayed(new C3486e(scaleLayout), 2000);
            }
            new CoinShortDilaog(activity, buyDogRsp).show();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m14727a(TravelFragment travelFragment, MergeDogRsp mergeDogRsp, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        travelFragment.m14717a(mergeDogRsp, z);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14717a(MergeDogRsp mergeDogRsp, boolean z) {
        PositionItem maxLevelItem = ((MergeLayout) mo19880a(R.id.lyt_merge)).getMaxLevelItem();
        int dogId = maxLevelItem != null ? maxLevelItem.getDogId() : 0;
        if (dogId != 38) {
            dogId--;
        }
        Object tag = ((LottieAnimationView) mo19880a(R.id.walk_lottie_view)).getTag(R.id.tag);
        if (mergeDogRsp.getMerge().getDogId() > dogId && (tag instanceof Integer) && C8271i.m35377a(mergeDogRsp.getMerge().getDogId(), ((Number) tag).intValue()) > 0) {
            m14713a(mergeDogRsp.getMerge().getDogId(), true);
        }
        if (z) {
            int position = mergeDogRsp.getMerge().getPosition() - 1;
            List childList = ((MergeLayout) mo19880a(R.id.lyt_merge)).getChildList();
            int size = childList.size();
            if (position >= 0 && size > position && ((MergeChild) childList.get(position)).getItem().getLevel() == 38) {
                MergeChild mergeChild = (MergeChild) childList.get(position);
                mergeChild.getItem().setDogId(mergeDogRsp.getMerge().getDogId());
                MergeLayout.m14943a((MergeLayout) mo19880a(R.id.lyt_merge), mergeChild, false, 2, null);
            }
        }
        Extra extra = mergeDogRsp.getExtra();
        String str = "context!!";
        if (extra != null) {
            DialogManager a = DialogManager.f11300b.mo20713a();
            Context context = getContext();
            if (context == null) {
                C8271i.m35380a();
            }
            C8271i.m35382a((Object) context, str);
            a.mo20712a(new TempBonusDogDilaog(context, extra));
            PositionExtra extra2 = extra.getExtra();
            if (extra2 != null) {
                m14718a(extra2, System.currentTimeMillis() / ((long) 1000));
            }
            MergeLayout mergeLayout = (MergeLayout) mo19880a(R.id.lyt_merge);
            PositionItem positionItem = new PositionItem(extra.getDogId(), extra.getLevel(), extra.getPosition(), System.currentTimeMillis() / ((long) 1000), extra.getExtra());
            mergeLayout.mo22521a(positionItem, extra.getPosition() - 1);
        }
        C3325HB hb = mergeDogRsp.getHb();
        if (hb != null) {
            hb.setType(1);
            DialogManager a2 = DialogManager.f11300b.mo20713a();
            Context context2 = getContext();
            if (context2 == null) {
                C8271i.m35380a();
            }
            C8271i.m35382a((Object) context2, str);
            HbDilaog iVar = new HbDilaog(context2, hb, null, 4, null);
            a2.mo20712a(iVar);
        }
        if (mergeDogRsp.isUpgrade()) {
            Launcher.f9545a.mo19814a().postDelayed(new C3487f(this), 500);
            if (mergeDogRsp.getMerge().getLevel() != 38) {
                DogHomeRsp b = ((FragmentTravelBinding) mo19887c()).mo20161b();
                if (b != null) {
                    String adProfit = b.getAdProfit();
                    if (adProfit != null) {
                        DialogManager a3 = DialogManager.f11300b.mo20713a();
                        Context context3 = getContext();
                        if (context3 == null) {
                            C8271i.m35380a();
                        }
                        C8271i.m35382a((Object) context3, str);
                        a3.mo20712a(new DogUpgradeDilaog(context3, adProfit, mergeDogRsp.getMerge()));
                    }
                }
            }
        }
        DialogManager.f11300b.mo20713a().mo20711a();
        m14704C();
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14731a(List<PositionItem> list) {
        Iterable<PositionItem> iterable = list;
        Map linkedHashMap = new LinkedHashMap(C8238n.m35355c(C8194y.m35252a(C8187k.m35274a(iterable, 10)), 16));
        for (PositionItem positionItem : iterable) {
            linkedHashMap.put(Integer.valueOf(positionItem.getPosition()), positionItem);
        }
        int mergeChildCount = ((MergeLayout) mo19880a(R.id.lyt_merge)).getMergeChildCount();
        int i = 0;
        while (i < mergeChildCount) {
            int i2 = i + 1;
            PositionItem positionItem2 = (PositionItem) linkedHashMap.get(Integer.valueOf(i2));
            if (positionItem2 == null) {
                positionItem2 = PositionItemKt.createEmptyPosition(i2);
            }
            ((MergeLayout) mo19880a(R.id.lyt_merge)).mo22521a(positionItem2, i);
            i = i2;
        }
        Iterator it = ((MergeLayout) mo19880a(R.id.lyt_merge)).getChildList().iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (((MergeChild) it.next()).getItem().getDogId() == 38) {
                break;
            }
            i3++;
        }
        if (i3 != -1) {
            MergeChild mergeChild = (MergeChild) ((MergeLayout) mo19880a(R.id.lyt_merge)).getChildList().get(i3);
            PositionExtra extra = mergeChild.getItem().getExtra();
            if (extra != null) {
                m14718a(extra, mergeChild.getItem().getBirthTime());
            }
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final void m14736b(List<DogShopItem> list) {
        Iterable<DogShopItem> iterable = list;
        Map linkedHashMap = new LinkedHashMap(C8238n.m35355c(C8194y.m35252a(C8187k.m35274a(iterable, 10)), 16));
        for (DogShopItem dogShopItem : iterable) {
            linkedHashMap.put(Integer.valueOf(dogShopItem.getLevel()), Double.valueOf(dogShopItem.getCoinProfit() * 4.0d));
        }
        ((MergeLayout) mo19880a(R.id.lyt_merge)).getProfitMap().clear();
        ((MergeLayout) mo19880a(R.id.lyt_merge)).getProfitMap().putAll(linkedHashMap);
        m14704C();
    }

    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final void m14742e(int i) {
        int a = m14708a(i, 1);
        int a2 = m14708a(i, 2);
        int a3 = m14708a(i, 3);
        String f = m14743f(i);
        if (C8271i.m35384a((Object) f, (Object) "mylh") || C8271i.m35384a((Object) f, (Object) "south_australia") || C8271i.m35384a((Object) f, (Object) "sydney")) {
            ((ImageView) mo19880a(R.id.bg_middle)).setPadding(0, 0, 0, 0);
            ((ImageView) mo19880a(R.id.bg_middle_2)).setPadding(0, 0, 0, 0);
        } else {
            ((ImageView) mo19880a(R.id.bg_middle)).setPadding(GloblaEx.m12810a(25.0f), 0, GloblaEx.m12810a(25.0f), 0);
            ((ImageView) mo19880a(R.id.bg_middle_2)).setPadding(GloblaEx.m12810a(25.0f), 0, GloblaEx.m12810a(25.0f), 0);
        }
        ((ImageView) mo19880a(R.id.bg_far)).setImageResource(a);
        ((ImageView) mo19880a(R.id.bg_far_2)).setImageResource(a);
        ((ImageView) mo19880a(R.id.bg_middle)).setImageResource(a2);
        ((ImageView) mo19880a(R.id.bg_middle_2)).setImageResource(a2);
        ((ImageView) mo19880a(R.id.bg_near)).setImageResource(a3);
        ((ImageView) mo19880a(R.id.bg_near_2)).setImageResource(a3);
    }

    /* renamed from: a */
    private final int m14708a(int i, int i2) {
        String str = i2 != 1 ? i2 != 2 ? "near" : "middle" : "far";
        Resources resources = C2835b.f9544a.getResources();
        StringBuilder sb = new StringBuilder();
        sb.append("bg_");
        sb.append(m14743f(i));
        sb.append('_');
        sb.append(str);
        return resources.getIdentifier(sb.toString(), "mipmap", C2835b.f9544a.getPackageName());
    }

    /* access modifiers changed from: private|final */
    /* renamed from: C */
    public final void m14704C() {
        C2914d.m13180a((Runnable) new C3494l(this), 100);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: E */
    public final void m14706E() {
        if (((ScaleLayout) mo19880a(R.id.lyt_add)) != null) {
            ScaleLayout scaleLayout = (ScaleLayout) mo19880a(R.id.lyt_add);
            m14705D().reset();
            scaleLayout.startAnimation(m14705D());
        }
    }

    /* renamed from: F */
    private final void m14707F() {
        if (((ScaleLayout) mo19880a(R.id.lyt_add)) != null) {
            ScaleLayout scaleLayout = (ScaleLayout) mo19880a(R.id.lyt_add);
            C8271i.m35382a((Object) scaleLayout, "lyt_add");
            Handler handler = scaleLayout.getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.f12087l);
            }
        }
    }
}
