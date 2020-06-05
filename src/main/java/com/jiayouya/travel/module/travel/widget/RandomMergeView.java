package com.jiayouya.travel.module.travel.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.reflect.C8280j;
import p655io.reactivex.Observable;
import p655io.reactivex.p659a.p661b.AndroidSchedulers;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.Consumer;
import p681me.jessyan.autosize.AutoSizeCompat;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001SB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010E\u001a\u00020FH\u0016J\u0018\u0010G\u001a\u00020:2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010I\u001a\u00020:H\u0014J\u0010\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020LH\u0014J\u0018\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007H\u0015J\u000e\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020\u0007J\u0006\u0010R\u001a\u00020:R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0018\u001a\n \u0019*\u0004\u0018\u00010\u00130\u00138BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001e\u0010\u000eR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R#\u0010(\u001a\n \u0019*\u0004\u0018\u00010\u00130\u00138BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b)\u0010\u001bR\u001b\u0010+\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b,\u0010\u000eR\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u00102\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b4\u0010\u0010\u001a\u0004\b3\u0010\u000eR\u001b\u00105\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b6\u0010\u000eR\"\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/widget/RandomMergeView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "count", "dis", "Lio/reactivex/disposables/Disposable;", "dogBitmapWidth", "getDogBitmapWidth", "()I", "dogBitmapWidth$delegate", "Lkotlin/Lazy;", "dogImageList", "Landroid/util/SparseArray;", "Landroid/graphics/Bitmap;", "getDogImageList", "()Landroid/util/SparseArray;", "dstRect", "Landroid/graphics/RectF;", "gridBitmap", "kotlin.jvm.PlatformType", "getGridBitmap", "()Landroid/graphics/Bitmap;", "gridBitmap$delegate", "gridBitmapWidth", "getGridBitmapWidth", "gridBitmapWidth$delegate", "gridPadding", "", "h", "Landroid/os/Handler;", "isEnd", "", "isLightVisible", "isStart", "lightBitmap", "getLightBitmap", "lightBitmap$delegate", "lightBitmapWidth", "getLightBitmapWidth", "lightBitmapWidth$delegate", "locationList", "", "Landroid/graphics/PointF;", "locationPosition", "offsetX", "getOffsetX", "offsetX$delegate", "offsetY", "getOffsetY", "offsetY$delegate", "onEndListener", "Lkotlin/Function0;", "", "getOnEndListener", "()Lkotlin/jvm/functions/Function0;", "setOnEndListener", "(Lkotlin/jvm/functions/Function0;)V", "space", "srcRect", "Landroid/graphics/Rect;", "startTime", "", "targetIndex", "getResources", "Landroid/content/res/Resources;", "initLocationList", "w", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setResult", "index", "startMerge", "MoveRunnable", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: RandomMergeView.kt */
public final class RandomMergeView extends View {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f12245a;
    /* renamed from: b */
    private final Lazy f12246b;
    /* renamed from: c */
    private final Lazy f12247c;
    /* renamed from: d */
    private final SparseArray<Bitmap> f12248d;
    /* renamed from: e */
    private final float f12249e;
    /* renamed from: f */
    private final int f12250f;
    /* access modifiers changed from: private|final */
    /* renamed from: g */
    public final List<PointF> f12251g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public int f12252h;
    /* renamed from: i */
    private C8246a<Unit> f12253i;
    /* renamed from: j */
    private final Lazy f12254j;
    /* renamed from: k */
    private final Lazy f12255k;
    /* renamed from: l */
    private final Lazy f12256l;
    /* renamed from: m */
    private final Lazy f12257m;
    /* renamed from: n */
    private final Lazy f12258n;
    /* renamed from: o */
    private final Rect f12259o;
    /* renamed from: p */
    private final RectF f12260p;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public int f12261q;
    /* access modifiers changed from: private */
    /* renamed from: r */
    public boolean f12262r;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public long f12263s;
    /* renamed from: t */
    private boolean f12264t;
    /* access modifiers changed from: private */
    /* renamed from: u */
    public boolean f12265u;
    /* access modifiers changed from: private */
    /* renamed from: v */
    public int f12266v;
    /* access modifiers changed from: private */
    /* renamed from: w */
    public Disposable f12267w;
    /* renamed from: x */
    private final Handler f12268x;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/widget/RandomMergeView$MoveRunnable;", "Ljava/lang/Runnable;", "isEnd", "Lkotlin/Function0;", "", "h", "Landroid/os/Handler;", "(Lkotlin/jvm/functions/Function0;Landroid/os/Handler;)V", "getH", "()Landroid/os/Handler;", "run", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.RandomMergeView$a */
    public static final class C3560a implements Runnable {
        /* renamed from: a */
        private final C8246a<Boolean> f12269a;
        /* renamed from: b */
        private final Handler f12270b;

        public C3560a(C8246a<Boolean> aVar, Handler handler) {
            C8271i.m35386b(aVar, "isEnd");
            C8271i.m35386b(handler, "h");
            this.f12269a = aVar;
            this.f12270b = handler;
        }

        public void run() {
            if (!((Boolean) this.f12269a.invoke()).booleanValue()) {
                this.f12270b.sendEmptyMessage(1);
                this.f12270b.postDelayed(this, 100);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.RandomMergeView$b */
    static final class C3561b extends Lambda implements C8246a<Integer> {
        public static final C3561b INSTANCE = new C3561b();

        C3561b() {
            super(0);
        }

        public final int invoke() {
            return GloblaEx.m12810a(55.0f);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.RandomMergeView$c */
    static final class C3562c extends Lambda implements C8246a<Bitmap> {
        public static final C3562c INSTANCE = new C3562c();

        C3562c() {
            super(0);
        }

        public final Bitmap invoke() {
            Drawable c = GloblaEx.m12820c(R.mipmap.ic_merge_grid);
            if (c != null) {
                return ((BitmapDrawable) c).getBitmap();
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.RandomMergeView$d */
    static final class C3563d extends Lambda implements C8246a<Integer> {
        public static final C3563d INSTANCE = new C3563d();

        C3563d() {
            super(0);
        }

        public final int invoke() {
            return GloblaEx.m12810a(65.0f);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "msg", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.RandomMergeView$e */
    static final class C3564e implements Callback {
        /* renamed from: a */
        final /* synthetic */ RandomMergeView f12271a;

        C3564e(RandomMergeView randomMergeView) {
            this.f12271a = randomMergeView;
        }

        public final boolean handleMessage(Message message) {
            Integer valueOf = message != null ? Integer.valueOf(message.what) : null;
            if (valueOf != null && valueOf.intValue() == 1) {
                if (this.f12271a.f12261q == this.f12271a.f12252h && System.currentTimeMillis() - this.f12271a.f12263s > ((long) PathInterpolatorCompat.MAX_NUM_POINTS)) {
                    this.f12271a.f12262r = true;
                    this.f12271a.f12267w = Observable.m34990a(200, 100, TimeUnit.MILLISECONDS).mo38892a(AndroidSchedulers.m34919a()).mo38904c((Consumer<? super T>) new Consumer<Long>(this) {
                        /* renamed from: a */
                        final /* synthetic */ C3564e f12272a;

                        {
                            this.f12272a = r1;
                        }

                        /* renamed from: a */
                        public final void accept(Long l) {
                            RandomMergeView randomMergeView = this.f12272a.f12271a;
                            int h = randomMergeView.f12266v;
                            randomMergeView.f12266v = h + 1;
                            if (h > 2) {
                                Disposable g = this.f12272a.f12271a.f12267w;
                                if (g != null) {
                                    g.dispose();
                                }
                                this.f12272a.f12271a.f12265u = true;
                                this.f12272a.f12271a.postDelayed(new Runnable(this) {
                                    /* renamed from: a */
                                    final /* synthetic */ C35651 f12273a;

                                    {
                                        this.f12273a = r1;
                                    }

                                    public final void run() {
                                        C8246a onEndListener = this.f12273a.f12272a.f12271a.getOnEndListener();
                                        if (onEndListener != null) {
                                            Unit jVar = (Unit) onEndListener.invoke();
                                        }
                                    }
                                }, 500);
                            } else {
                                this.f12272a.f12271a.f12265u = true ^ this.f12272a.f12271a.f12265u;
                            }
                            this.f12272a.f12271a.invalidate();
                        }
                    });
                } else if (this.f12271a.f12252h == this.f12271a.f12251g.size() - 1) {
                    this.f12271a.f12252h = 0;
                } else {
                    RandomMergeView randomMergeView = this.f12271a;
                    randomMergeView.f12252h = randomMergeView.f12252h + 1;
                }
                this.f12271a.invalidate();
            }
            return true;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.RandomMergeView$f */
    static final class C3567f extends Lambda implements C8246a<Bitmap> {
        public static final C3567f INSTANCE = new C3567f();

        C3567f() {
            super(0);
        }

        public final Bitmap invoke() {
            Drawable c = GloblaEx.m12820c(R.mipmap.ic_merge_light);
            if (c != null) {
                return ((BitmapDrawable) c).getBitmap();
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.RandomMergeView$g */
    static final class C3568g extends Lambda implements C8246a<Integer> {
        public static final C3568g INSTANCE = new C3568g();

        C3568g() {
            super(0);
        }

        public final int invoke() {
            return GloblaEx.m12810a(91.0f);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.RandomMergeView$h */
    static final class C3569h extends Lambda implements C8246a<Integer> {
        final /* synthetic */ RandomMergeView this$0;

        C3569h(RandomMergeView randomMergeView) {
            this.this$0 = randomMergeView;
            super(0);
        }

        public final int invoke() {
            return (this.this$0.getLightBitmapWidth() - this.this$0.getGridBitmapWidth()) / 2;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.RandomMergeView$i */
    static final class C3570i extends Lambda implements C8246a<Integer> {
        final /* synthetic */ RandomMergeView this$0;

        C3570i(RandomMergeView randomMergeView) {
            this.this$0 = randomMergeView;
            super(0);
        }

        public final int invoke() {
            return ((this.this$0.getLightBitmapWidth() - this.this$0.getGridBitmapWidth()) / 2) + GloblaEx.m12810a(2.0f);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeView.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.RandomMergeView$j */
    static final class C3571j extends Lambda implements C8246a<Boolean> {
        final /* synthetic */ RandomMergeView this$0;

        C3571j(RandomMergeView randomMergeView) {
            this.this$0 = randomMergeView;
            super(0);
        }

        public final boolean invoke() {
            return this.this$0.f12262r;
        }
    }

    static {
        Class<RandomMergeView> cls = RandomMergeView.class;
        f12245a = new C8280j[]{C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "gridBitmap", "getGridBitmap()Landroid/graphics/Bitmap;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "lightBitmap", "getLightBitmap()Landroid/graphics/Bitmap;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "lightBitmapWidth", "getLightBitmapWidth()I")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "offsetX", "getOffsetX()I")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "offsetY", "getOffsetY()I")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "gridBitmapWidth", "getGridBitmapWidth()I")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "dogBitmapWidth", "getDogBitmapWidth()I"))};
    }

    public RandomMergeView(Context context) {
        this(context, null, 0, 6, null);
    }

    public RandomMergeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final int getDogBitmapWidth() {
        Lazy bVar = this.f12258n;
        C8280j jVar = f12245a[6];
        return ((Number) bVar.getValue()).intValue();
    }

    private final Bitmap getGridBitmap() {
        Lazy bVar = this.f12246b;
        C8280j jVar = f12245a[0];
        return (Bitmap) bVar.getValue();
    }

    /* access modifiers changed from: private|final */
    public final int getGridBitmapWidth() {
        Lazy bVar = this.f12257m;
        C8280j jVar = f12245a[5];
        return ((Number) bVar.getValue()).intValue();
    }

    private final Bitmap getLightBitmap() {
        Lazy bVar = this.f12247c;
        C8280j jVar = f12245a[1];
        return (Bitmap) bVar.getValue();
    }

    /* access modifiers changed from: private|final */
    public final int getLightBitmapWidth() {
        Lazy bVar = this.f12254j;
        C8280j jVar = f12245a[2];
        return ((Number) bVar.getValue()).intValue();
    }

    private final int getOffsetX() {
        Lazy bVar = this.f12255k;
        C8280j jVar = f12245a[3];
        return ((Number) bVar.getValue()).intValue();
    }

    private final int getOffsetY() {
        Lazy bVar = this.f12256l;
        C8280j jVar = f12245a[4];
        return ((Number) bVar.getValue()).intValue();
    }

    public /* synthetic */ RandomMergeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker fVar) {
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public RandomMergeView(Context context, AttributeSet attributeSet, int i) {
        C8271i.m35386b(context, "context");
        super(context, attributeSet, i);
        this.f12246b = C8182c.m35317a(C3562c.INSTANCE);
        this.f12247c = C8182c.m35317a(C3567f.INSTANCE);
        this.f12248d = new SparseArray<>();
        this.f12249e = (float) GloblaEx.m12810a(15.0f);
        this.f12250f = GloblaEx.m12810a(-1.5f);
        this.f12251g = new ArrayList();
        this.f12254j = C8182c.m35317a(C3568g.INSTANCE);
        this.f12255k = C8182c.m35317a(new C3569h(this));
        this.f12256l = C8182c.m35317a(new C3570i(this));
        this.f12257m = C8182c.m35317a(C3563d.INSTANCE);
        this.f12258n = C8182c.m35317a(C3561b.INSTANCE);
        this.f12259o = new Rect();
        this.f12260p = new RectF();
        this.f12261q = -1;
        this.f12265u = true;
        this.f12268x = new Handler(Looper.getMainLooper(), new C3564e(this));
    }

    public final SparseArray<Bitmap> getDogImageList() {
        return this.f12248d;
    }

    public final C8246a<Unit> getOnEndListener() {
        return this.f12253i;
    }

    public final void setOnEndListener(C8246a<Unit> aVar) {
        this.f12253i = aVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        m14904a(size, size2);
    }

    /* renamed from: a */
    private final void m14904a(int i, int i2) {
        float f;
        float gridBitmapWidth;
        boolean z;
        float f2;
        float f3 = this.f12249e;
        this.f12251g.clear();
        boolean z2 = true;
        float f4 = f3;
        float f5 = f4;
        boolean z3 = true;
        boolean z4 = true;
        for (int i3 = 0; i3 < 12; i3++) {
            if (i3 < 4) {
                if (z2) {
                    f2 = this.f12249e;
                    z = false;
                } else {
                    z = z2;
                    f2 = ((float) (getGridBitmapWidth() + this.f12250f)) + f5;
                }
                gridBitmapWidth = this.f12249e;
                f5 = f2;
                z2 = z;
            } else {
                if (i3 < 7) {
                    f4 += (float) (getGridBitmapWidth() + this.f12250f);
                    f5 = (((float) (getGridBitmapWidth() + this.f12250f)) * 3.0f) + this.f12249e;
                } else if (i3 < 10) {
                    if (z4) {
                        f = this.f12249e + (((float) (getGridBitmapWidth() + this.f12250f)) * 2.0f);
                        z4 = false;
                    } else {
                        f = f5 - ((float) (getGridBitmapWidth() + this.f12250f));
                    }
                    gridBitmapWidth = this.f12249e + (((float) (getGridBitmapWidth() + this.f12250f)) * 3.0f);
                    f5 = f;
                } else {
                    if (z3) {
                        f4 = this.f12249e + (((float) (getGridBitmapWidth() + this.f12250f)) * 2.0f);
                        z3 = false;
                    } else {
                        f4 -= (float) (getGridBitmapWidth() + this.f12250f);
                    }
                    f5 = this.f12249e;
                }
                this.f12251g.add(new PointF(f5, f4));
            }
            f4 = gridBitmapWidth;
            this.f12251g.add(new PointF(f5, f4));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        C8271i.m35386b(canvas, "canvas");
        int i = 0;
        for (Object next : this.f12251g) {
            int i2 = i + 1;
            if (i < 0) {
                C8187k.m35272b();
            }
            PointF pointF = (PointF) next;
            Rect rect = this.f12259o;
            Bitmap gridBitmap = getGridBitmap();
            String str = "gridBitmap";
            C8271i.m35382a((Object) gridBitmap, str);
            int width = gridBitmap.getWidth();
            Bitmap gridBitmap2 = getGridBitmap();
            C8271i.m35382a((Object) gridBitmap2, str);
            rect.set(0, 0, width, gridBitmap2.getHeight());
            this.f12260p.set(pointF.x, pointF.y, pointF.x + ((float) getGridBitmapWidth()), pointF.y + ((float) getGridBitmapWidth()));
            canvas.drawBitmap(getGridBitmap(), this.f12259o, this.f12260p, null);
            Bitmap bitmap = (Bitmap) this.f12248d.get(i);
            if (bitmap != null) {
                this.f12259o.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                float a = pointF.x + ((float) GloblaEx.m12810a(5.0f));
                float a2 = pointF.y + ((float) GloblaEx.m12810a(3.0f));
                this.f12260p.set(a, a2, ((float) getDogBitmapWidth()) + a, ((float) getDogBitmapWidth()) + a2);
                canvas.drawBitmap(bitmap, this.f12259o, this.f12260p, null);
            }
            i = i2;
        }
        if (this.f12264t && this.f12265u) {
            PointF pointF2 = (PointF) this.f12251g.get(this.f12252h);
            Rect rect2 = this.f12259o;
            Bitmap lightBitmap = getLightBitmap();
            String str2 = "lightBitmap";
            C8271i.m35382a((Object) lightBitmap, str2);
            int width2 = lightBitmap.getWidth();
            Bitmap lightBitmap2 = getLightBitmap();
            C8271i.m35382a((Object) lightBitmap2, str2);
            rect2.set(0, 0, width2, lightBitmap2.getHeight());
            float offsetX = pointF2.x - ((float) getOffsetX());
            float offsetY = pointF2.y - ((float) getOffsetY());
            this.f12260p.set(offsetX, offsetY, ((float) getLightBitmapWidth()) + offsetX, ((float) getLightBitmapWidth()) + offsetY);
            canvas.drawBitmap(getLightBitmap(), this.f12259o, this.f12260p, null);
        }
    }

    public Resources getResources() {
        AutoSizeCompat.autoConvertDensityOfGlobal(super.getResources());
        Resources resources = super.getResources();
        C8271i.m35382a((Object) resources, "super.getResources()");
        return resources;
    }

    /* renamed from: a */
    public final void mo22496a() {
        this.f12266v = 0;
        this.f12261q = -1;
        this.f12262r = false;
        this.f12264t = true;
        this.f12263s = System.currentTimeMillis();
        new C3560a(new C3571j(this), this.f12268x).run();
    }

    public final void setResult(int i) {
        int size = this.f12251g.size();
        if (i >= 0 && size > i) {
            this.f12261q = i;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable bVar = this.f12267w;
        if (bVar != null) {
            bVar.dispose();
        }
        this.f12262r = true;
        this.f12268x.removeMessages(1);
    }
}
