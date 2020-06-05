package com.jiayouya.travel.module.travel.widget.merge;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.app.NotificationCompat;
import androidx.customview.widget.ViewDragHelper;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.module.travel.data.PositionItem;
import com.jiayouya.travel.module.travel.data.PositionItemKt;
import com.jiayouya.travel.module.travel.p287c.MediaPlayerUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.jvm.p679a.C8258m;
import kotlin.jvm.p679a.C8262q;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010l\u001a\u00020+J\u0012\u0010m\u001a\u00020\u001b2\b\u0010n\u001a\u0004\u0018\u00010oH\u0016J\b\u0010p\u001a\u00020\u000fH\u0002J\b\u0010q\u001a\u00020\u000fH\u0002J\b\u0010r\u001a\u0004\u0018\u00010sJ\u0006\u0010t\u001a\u00020\u000fJ\u0015\u0010u\u001a\u0004\u0018\u00010T2\u0006\u0010v\u001a\u00020s¢\u0006\u0002\u0010wJ\b\u0010x\u001a\u00020+H\u0002J\u0006\u0010y\u001a\u00020\u001bJ\u0010\u0010z\u001a\u00020+2\u0006\u0010B\u001a\u00020\tH\u0002J\u0018\u0010{\u001a\u00020+2\u0006\u0010|\u001a\u00020\u000b2\b\b\u0002\u0010}\u001a\u00020\u001bJ\b\u0010~\u001a\u00020+H\u0014J\u0010\u0010\u001a\u00020\u001b2\u0006\u0010n\u001a\u00020oH\u0016J6\u0010\u0001\u001a\u00020+2\u0007\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020\u000f2\u0007\u0010\u0001\u001a\u00020\u000f2\u0007\u0010\u0001\u001a\u00020\u000f2\u0007\u0010\u0001\u001a\u00020\u000fH\u0015J\u0015\u0010\u0001\u001a\u00020+2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\u000f\u0010\u0001\u001a\u00020+2\u0006\u0010U\u001a\u00020TJ\u0012\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020oH\u0016J\t\u0010\u0001\u001a\u00020+H\u0002J\t\u0010\u0001\u001a\u00020+H\u0002J\u000f\u0010\u0001\u001a\u00020+2\u0006\u0010I\u001a\u00020\u000fJ\t\u0010\u0001\u001a\u00020+H\u0002J\u0018\u0010\u0001\u001a\u00020+2\u0006\u0010v\u001a\u00020s2\u0007\u0010\u0001\u001a\u00020\u000fJ\u000f\u0010\u0001\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020\u001bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010%R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/RL\u00100\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020+\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109Ra\u0010:\u001aI\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020+\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@Ra\u0010A\u001aI\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(B\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020+\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@RL\u0010E\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020+\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00107\"\u0004\bG\u00109RL\u0010H\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(I\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020+\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00107\"\u0004\bL\u00109R7\u0010M\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u001b\u0018\u00010NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR7\u0010S\u001a\u001f\u0012\u0013\u0012\u00110T¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(U\u0012\u0004\u0012\u00020+\u0018\u00010NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010P\"\u0004\bW\u0010RR\"\u0010X\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010-\"\u0004\bZ\u0010/R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020T0^¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u000e\u0010a\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u0011\u0010b\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0012R\u0014\u0010d\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010e\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R#\u0010f\u001a\n h*\u0004\u0018\u00010g0g8BX\u0002¢\u0006\f\n\u0004\bk\u0010\u0014\u001a\u0004\bi\u0010j¨\u0006\u0001"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/widget/merge/MergeLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "boxList", "", "Landroid/view/View;", "childList", "Lcom/jiayouya/travel/module/travel/widget/merge/MergeChild;", "getChildList", "()Ljava/util/List;", "columns", "", "garbageCanTop", "getGarbageCanTop", "()I", "garbageCanTop$delegate", "Lkotlin/Lazy;", "garbageCanView", "Lcom/jiayouya/travel/module/travel/widget/merge/GarbageCanView;", "getGarbageCanView", "()Lcom/jiayouya/travel/module/travel/widget/merge/GarbageCanView;", "garbageOffsetX", "isVisibleToUser", "", "()Z", "setVisibleToUser", "(Z)V", "lastLeft", "lastTop", "marginBottom", "maxTouchRangeY", "getMaxTouchRangeY", "setMaxTouchRangeY", "(I)V", "minTouchRangeY", "getMinTouchRangeY", "setMinTouchRangeY", "onChildChangeListener", "Lkotlin/Function0;", "", "getOnChildChangeListener", "()Lkotlin/jvm/functions/Function0;", "setOnChildChangeListener", "(Lkotlin/jvm/functions/Function0;)V", "onLoversMergeListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "p1", "p2", "getOnLoversMergeListener", "()Lkotlin/jvm/functions/Function2;", "setOnLoversMergeListener", "(Lkotlin/jvm/functions/Function2;)V", "onMaxLevelChangeListener", "Lkotlin/Function3;", "maxLevel", "getOnMaxLevelChangeListener", "()Lkotlin/jvm/functions/Function3;", "setOnMaxLevelChangeListener", "(Lkotlin/jvm/functions/Function3;)V", "onMergeListener", "view", "getOnMergeListener", "setOnMergeListener", "onMoveChangeListener", "getOnMoveChangeListener", "setOnMoveChangeListener", "onRecycleStartListener", "position", "dogId", "getOnRecycleStartListener", "setOnRecycleStartListener", "onReleaseListener", "Lkotlin/Function1;", "getOnReleaseListener", "()Lkotlin/jvm/functions/Function1;", "setOnReleaseListener", "(Lkotlin/jvm/functions/Function1;)V", "onScoreAddListener", "", "score", "getOnScoreAddListener", "setOnScoreAddListener", "onSuperMergeListener", "getOnSuperMergeListener", "setOnSuperMergeListener", "player", "Landroid/media/MediaPlayer;", "profitMap", "", "getProfitMap", "()Ljava/util/Map;", "rows", "space", "getSpace", "specialIdList", "totalList", "viewDragHelper", "Landroidx/customview/widget/ViewDragHelper;", "kotlin.jvm.PlatformType", "getViewDragHelper", "()Landroidx/customview/widget/ViewDragHelper;", "viewDragHelper$delegate", "clear", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getChildSize", "getMaxLevel", "getMaxLevelItem", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "getMergeChildCount", "getProfit", "item", "(Lcom/jiayouya/travel/module/travel/data/PositionItem;)Ljava/lang/Double;", "initPlayer", "isFull", "layoutChild", "notifyChildChanged", "child", "isChangeBirth", "onDetachedFromWindow", "onInterceptTouchEvent", "onLayout", "changed", "left", "top", "right", "bottom", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "onScoreAdd", "onTouchEvent", "event", "playMergeMusic", "release", "removeChild", "resetLastRecord", "setData", "index", "setUserVisibleHint", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MergeLayout.kt */
public final class MergeLayout extends FrameLayout {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f12285a;
    /* access modifiers changed from: private|final */
    /* renamed from: A */
    public final int f12286A;
    /* renamed from: B */
    private int f12287B;
    /* renamed from: C */
    private int f12288C;
    /* renamed from: b */
    private final Lazy f12289b = C8182c.m35317a(new C3582e(this));
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final List<Integer> f12290c = C8187k.m35271b(Integer.valueOf(39), Integer.valueOf(40), Integer.valueOf(41), Integer.valueOf(45), Integer.valueOf(46));
    /* renamed from: d */
    private final List<MergeChild> f12291d = new ArrayList();
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final List<View> f12292e = new ArrayList();
    /* renamed from: f */
    private final List<View> f12293f = new ArrayList();
    /* renamed from: g */
    private final int f12294g = 4;
    /* access modifiers changed from: private|final */
    /* renamed from: h */
    public final int f12295h = 3;
    /* renamed from: i */
    private final int f12296i = GloblaEx.m12810a(10.0f);
    /* renamed from: j */
    private int f12297j;
    /* renamed from: k */
    private int f12298k;
    /* renamed from: l */
    private final Lazy f12299l = C8182c.m35317a(new C3578a(this));
    /* renamed from: m */
    private final GarbageCanView f12300m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public MediaPlayer f12301n;
    /* renamed from: o */
    private C8247b<? super Double, Unit> f12302o;
    /* renamed from: p */
    private C8258m<? super Integer, ? super Integer, Unit> f12303p;
    /* renamed from: q */
    private C8262q<? super Integer, ? super Integer, ? super Integer, Unit> f12304q;
    /* renamed from: r */
    private C8262q<? super MergeChild, ? super Integer, ? super Integer, Unit> f12305r;
    /* renamed from: s */
    private C8258m<? super Integer, ? super Integer, Unit> f12306s;
    /* renamed from: t */
    private C8246a<Unit> f12307t;
    /* renamed from: u */
    private C8258m<? super Integer, ? super Integer, Unit> f12308u;
    /* renamed from: v */
    private C8247b<? super MergeChild, Boolean> f12309v;
    /* renamed from: w */
    private C8246a<Unit> f12310w;
    /* renamed from: x */
    private final Map<Integer, Double> f12311x;
    /* renamed from: y */
    private boolean f12312y;
    /* renamed from: z */
    private final int f12313z;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MergeLayout.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.merge.MergeLayout$a */
    static final class C3578a extends Lambda implements C8246a<Integer> {
        final /* synthetic */ MergeLayout this$0;

        C3578a(MergeLayout mergeLayout) {
            this.this$0 = mergeLayout;
            super(0);
        }

        public final int invoke() {
            return (((this.this$0.getMeasuredHeight() - this.this$0.f12286A) - (this.this$0.f12295h * this.this$0.getChildSize())) - ((this.this$0.f12295h - 1) * this.this$0.getSpace())) - GloblaEx.m12810a(60.0f);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "o1", "Lcom/jiayouya/travel/module/travel/widget/merge/MergeChild;", "kotlin.jvm.PlatformType", "o2", "compare"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MergeLayout.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.merge.MergeLayout$b */
    static final class C3579b<T> implements Comparator<MergeChild> {
        /* renamed from: a */
        public static final C3579b f12314a = new C3579b();

        C3579b() {
        }

        /* renamed from: a */
        public final int compare(MergeChild mergeChild, MergeChild mergeChild2) {
            if (!PositionItemKt.isTemp(mergeChild.getItem()) || PositionItemKt.isTemp(mergeChild2.getItem())) {
                if (!PositionItemKt.isTemp(mergeChild.getItem()) && PositionItemKt.isTemp(mergeChild2.getItem())) {
                    return 1;
                }
                if (PositionItemKt.isTemp(mergeChild.getItem()) && PositionItemKt.isTemp(mergeChild2.getItem())) {
                    return 0;
                }
                if (mergeChild.getItem().getLevel() >= mergeChild2.getItem().getLevel()) {
                    return 1;
                }
            }
            return -1;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "o1", "Lcom/jiayouya/travel/module/travel/widget/merge/MergeChild;", "kotlin.jvm.PlatformType", "o2", "compare"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MergeLayout.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.merge.MergeLayout$c */
    static final class C3580c<T> implements Comparator<MergeChild> {
        /* renamed from: a */
        public static final C3580c f12315a = new C3580c();

        C3580c() {
        }

        /* renamed from: a */
        public final int compare(MergeChild mergeChild, MergeChild mergeChild2) {
            if (!PositionItemKt.isTemp(mergeChild.getItem()) || PositionItemKt.isTemp(mergeChild2.getItem())) {
                if (!PositionItemKt.isTemp(mergeChild.getItem()) && PositionItemKt.isTemp(mergeChild2.getItem())) {
                    return 1;
                }
                if (PositionItemKt.isTemp(mergeChild.getItem()) && PositionItemKt.isTemp(mergeChild2.getItem())) {
                    return 0;
                }
                if (mergeChild.getItem().getLevel() >= mergeChild2.getItem().getLevel()) {
                    return 1;
                }
            }
            return -1;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "queueIdle"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MergeLayout.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.merge.MergeLayout$d */
    static final class C3581d implements IdleHandler {
        /* renamed from: a */
        final /* synthetic */ MergeLayout f12316a;

        C3581d(MergeLayout mergeLayout) {
            this.f12316a = mergeLayout;
        }

        public final boolean queueIdle() {
            this.f12316a.f12301n = MediaPlayerUtil.m14448a("music/dog_merge.mp3");
            return false;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "Landroidx/customview/widget/ViewDragHelper;", "kotlin.jvm.PlatformType", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MergeLayout.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.merge.MergeLayout$e */
    static final class C3582e extends Lambda implements C8246a<ViewDragHelper> {
        final /* synthetic */ MergeLayout this$0;

        C3582e(MergeLayout mergeLayout) {
            this.this$0 = mergeLayout;
            super(0);
        }

        public final ViewDragHelper invoke() {
            return ViewDragHelper.create(this.this$0, new MergeLayout$viewDragHelper$2$1(this));
        }
    }

    static {
        Class<MergeLayout> cls = MergeLayout.class;
        f12285a = new C8280j[]{C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "viewDragHelper", "getViewDragHelper()Landroidx/customview/widget/ViewDragHelper;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "garbageCanTop", "getGarbageCanTop()I"))};
    }

    private final ViewDragHelper getViewDragHelper() {
        Lazy bVar = this.f12289b;
        C8280j jVar = f12285a[0];
        return (ViewDragHelper) bVar.getValue();
    }

    public final int getGarbageCanTop() {
        Lazy bVar = this.f12299l;
        C8280j jVar = f12285a[1];
        return ((Number) bVar.getValue()).intValue();
    }

    public MergeLayout(Context context, AttributeSet attributeSet) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(attributeSet, "attrs");
        super(context, attributeSet);
        this.f12300m = new GarbageCanView(context);
        this.f12311x = new LinkedHashMap();
        addView(this.f12300m, new LayoutParams(GloblaEx.m12810a(38.0f), GloblaEx.m12810a(55.0f)));
        int childSize = getChildSize();
        int i = this.f12295h;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f12294g;
            for (int i4 = 0; i4 < i3; i4++) {
                View view = new View(context);
                view.setLayoutParams(new LayoutParams(childSize, childSize));
                view.setBackground(GloblaEx.m12820c(R.drawable.bg_box));
                this.f12293f.add(view);
                addView(view);
            }
        }
        int i5 = this.f12295h;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = this.f12294g;
            int i8 = 0;
            while (i8 < i7) {
                MergeChild mergeChild = new MergeChild(context);
                i8++;
                mergeChild.getItem().setPosition((this.f12294g * i6) + i8);
                mergeChild.setLayoutParams(new LayoutParams(childSize, childSize));
                addView(mergeChild);
                this.f12291d.add(mergeChild);
            }
        }
        this.f12292e.add(this.f12300m);
        this.f12292e.addAll(this.f12291d);
        m14946d();
        setClipChildren(false);
        setClipToPadding(false);
        this.f12313z = GloblaEx.m12810a(8.0f);
        this.f12286A = GloblaEx.m12810a(73.0f);
    }

    public final List<MergeChild> getChildList() {
        return this.f12291d;
    }

    public final int getSpace() {
        return this.f12296i;
    }

    public final GarbageCanView getGarbageCanView() {
        return this.f12300m;
    }

    public final C8247b<Double, Unit> getOnScoreAddListener() {
        return this.f12302o;
    }

    public final void setOnScoreAddListener(C8247b<? super Double, Unit> bVar) {
        this.f12302o = bVar;
    }

    public final C8258m<Integer, Integer, Unit> getOnRecycleStartListener() {
        return this.f12303p;
    }

    public final void setOnRecycleStartListener(C8258m<? super Integer, ? super Integer, Unit> mVar) {
        this.f12303p = mVar;
    }

    public final C8262q<Integer, Integer, Integer, Unit> getOnMaxLevelChangeListener() {
        return this.f12304q;
    }

    public final void setOnMaxLevelChangeListener(C8262q<? super Integer, ? super Integer, ? super Integer, Unit> qVar) {
        this.f12304q = qVar;
    }

    public final C8262q<MergeChild, Integer, Integer, Unit> getOnMergeListener() {
        return this.f12305r;
    }

    public final void setOnMergeListener(C8262q<? super MergeChild, ? super Integer, ? super Integer, Unit> qVar) {
        this.f12305r = qVar;
    }

    public final C8258m<Integer, Integer, Unit> getOnLoversMergeListener() {
        return this.f12306s;
    }

    public final void setOnLoversMergeListener(C8258m<? super Integer, ? super Integer, Unit> mVar) {
        this.f12306s = mVar;
    }

    public final C8246a<Unit> getOnSuperMergeListener() {
        return this.f12307t;
    }

    public final void setOnSuperMergeListener(C8246a<Unit> aVar) {
        this.f12307t = aVar;
    }

    public final C8258m<Integer, Integer, Unit> getOnMoveChangeListener() {
        return this.f12308u;
    }

    public final void setOnMoveChangeListener(C8258m<? super Integer, ? super Integer, Unit> mVar) {
        this.f12308u = mVar;
    }

    public final C8247b<MergeChild, Boolean> getOnReleaseListener() {
        return this.f12309v;
    }

    public final void setOnReleaseListener(C8247b<? super MergeChild, Boolean> bVar) {
        this.f12309v = bVar;
    }

    public final C8246a<Unit> getOnChildChangeListener() {
        return this.f12310w;
    }

    public final void setOnChildChangeListener(C8246a<Unit> aVar) {
        this.f12310w = aVar;
    }

    public final Map<Integer, Double> getProfitMap() {
        return this.f12311x;
    }

    /* renamed from: a */
    public final boolean mo22523a() {
        return this.f12312y;
    }

    public final void setVisibleToUser(boolean z) {
        this.f12312y = z;
    }

    /* renamed from: d */
    private final void m14946d() {
        Looper.myQueue().addIdleHandler(new C3581d(this));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.f12318a;
        for (MergeChild layoutParams : this.f12291d) {
            ViewGroup.LayoutParams layoutParams2 = layoutParams.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = i;
        }
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            return null;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.f12318a = getChildSize();
        return savedState;
    }

    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final void m14949e() {
        MediaPlayer mediaPlayer = this.f12301n;
        if (mediaPlayer != null) {
            MediaPlayerUtil.m14449a(mediaPlayer);
        }
    }

    /* renamed from: f */
    private final void m14951f() {
        MediaPlayer mediaPlayer = this.f12301n;
        if (mediaPlayer != null) {
            MediaPlayerUtil.m14450b(mediaPlayer);
        }
    }

    /* renamed from: a */
    public final Double mo22518a(PositionItem positionItem) {
        C8271i.m35386b(positionItem, "item");
        return (Double) this.f12311x.get(Integer.valueOf(positionItem.getLevel()));
    }

    /* renamed from: a */
    public static /* synthetic */ void m14943a(MergeLayout mergeLayout, MergeChild mergeChild, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        mergeLayout.mo22522a(mergeChild, z);
    }

    /* renamed from: a */
    public final void mo22522a(MergeChild mergeChild, boolean z) {
        C8271i.m35386b(mergeChild, "child");
        if (z) {
            mergeChild.getItem().setBirthTime(System.currentTimeMillis() / ((long) 1000));
        }
        mergeChild.mo22509a();
    }

    /* access modifiers changed from: private|final */
    public final int getChildSize() {
        int a = ((getMeasuredWidth() == 0 ? GloblaEx.m12809a() : getMeasuredWidth()) - getPaddingStart()) - getPaddingEnd();
        int i = this.f12296i;
        int i2 = this.f12294g;
        return (a - (i * (i2 - 1))) / i2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f12300m.layout((getMeasuredWidth() - this.f12300m.getMeasuredWidth()) + this.f12313z, getGarbageCanTop(), getMeasuredWidth() + this.f12313z, getGarbageCanTop() + this.f12300m.getMeasuredHeight());
        if (!this.f12293f.isEmpty()) {
            m14953g();
            for (View a : this.f12293f) {
                m14941a(a);
            }
            if (!this.f12291d.isEmpty()) {
                m14953g();
                for (MergeChild a2 : this.f12291d) {
                    m14941a((View) a2);
                }
            }
        }
    }

    /* renamed from: g */
    private final void m14953g() {
        this.f12297j = getPaddingLeft();
        this.f12298k = ((getMeasuredHeight() - this.f12286A) - (this.f12295h * ((MergeChild) this.f12291d.get(0)).getLayoutParams().height)) - ((this.f12295h - 1) * this.f12296i);
    }

    /* renamed from: a */
    private final void m14941a(View view) {
        view.setLeft(this.f12297j);
        view.setRight(view.getLeft() + view.getLayoutParams().width);
        view.setTop(this.f12298k);
        view.setBottom(view.getTop() + view.getLayoutParams().height);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        this.f12297j += view.getLayoutParams().width + this.f12296i;
        if (this.f12297j >= (getWidth() - getPaddingEnd()) - getPaddingStart()) {
            this.f12297j = getPaddingLeft();
            this.f12298k += view.getLayoutParams().height + this.f12296i;
        }
    }

    /* access modifiers changed from: private|final */
    public final int getMaxLevel() {
        int i = 0;
        if (this.f12291d.isEmpty()) {
            return 0;
        }
        MergeChild mergeChild = (MergeChild) C8187k.m35281a((Iterable) this.f12291d, (Comparator) C3579b.f12314a);
        if (mergeChild != null) {
            PositionItem item = mergeChild.getItem();
            if (item != null) {
                i = item.getLevel();
            }
        }
        return i;
    }

    public final PositionItem getMaxLevelItem() {
        PositionItem positionItem = null;
        if (this.f12291d.isEmpty()) {
            return null;
        }
        MergeChild mergeChild = (MergeChild) C8187k.m35281a((Iterable) this.f12291d, (Comparator) C3580c.f12315a);
        if (mergeChild != null) {
            positionItem = mergeChild.getItem();
        }
        return positionItem;
    }

    public final int getMinTouchRangeY() {
        return this.f12287B;
    }

    public final void setMinTouchRangeY(int i) {
        this.f12287B = i;
    }

    public final int getMaxTouchRangeY() {
        return this.f12288C;
    }

    public final void setMaxTouchRangeY(int i) {
        this.f12288C = i;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() != 0 || (motionEvent.getY() > ((float) this.f12287B) && motionEvent.getY() < ((float) this.f12288C))) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        C8271i.m35386b(motionEvent, "ev");
        return getViewDragHelper().shouldInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C8271i.m35386b(motionEvent, NotificationCompat.CATEGORY_EVENT);
        getViewDragHelper().processTouchEvent(motionEvent);
        return true;
    }

    public final void setUserVisibleHint(boolean z) {
        this.f12312y = z;
    }

    /* renamed from: a */
    public final void mo22519a(double d) {
        C8247b<? super Double, Unit> bVar = this.f12302o;
        if (bVar != null) {
            Unit jVar = (Unit) bVar.invoke(Double.valueOf(d));
        }
    }

    public final int getMergeChildCount() {
        return this.f12291d.size();
    }

    /* renamed from: a */
    public final void mo22521a(PositionItem positionItem, int i) {
        C8271i.m35386b(positionItem, "item");
        if (!this.f12291d.isEmpty() && i <= this.f12291d.size() - 1 && i >= 0) {
            MergeChild mergeChild = (MergeChild) this.f12291d.get(i);
            mergeChild.setItem(positionItem);
            m14943a(this, mergeChild, false, 2, null);
            C8246a<Unit> aVar = this.f12310w;
            if (aVar != null) {
                Unit jVar = (Unit) aVar.invoke();
            }
        }
    }

    /* renamed from: a */
    public final void mo22520a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("removeChild start p==");
        sb.append(i);
        XLog.m12691a(sb.toString());
        if (i >= 0 && !this.f12291d.isEmpty() && i <= this.f12291d.size()) {
            MergeChild mergeChild = (MergeChild) this.f12291d.get(i - 1);
            mergeChild.setItem(PositionItemKt.createEmptyPosition(i));
            m14943a(this, mergeChild, false, 2, null);
            C8246a<Unit> aVar = this.f12310w;
            if (aVar != null) {
                Unit jVar = (Unit) aVar.invoke();
            }
            XLog.m12691a("removeChild end");
        }
    }

    /* renamed from: b */
    public final void mo22524b() {
        int mergeChildCount = getMergeChildCount();
        int i = 0;
        while (i < mergeChildCount) {
            int i2 = i + 1;
            mo22521a(PositionItemKt.createEmptyPosition(i2), i);
            i = i2;
        }
    }

    /* renamed from: c */
    public final boolean mo22525c() {
        Iterator it = this.f12291d.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (!PositionItemKt.validate(((MergeChild) it.next()).getItem())) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m14951f();
    }
}
