package com.jiayouya.travel.module.explore.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import ezy.app.p645rx.C8019a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import p655io.reactivex.Observable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u001e\u0018\u0000 <2\u00020\u0001:\u0001<B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u001fH\u0002J\u0016\u0010!\u001a\u00020\u001f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rJ\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0007H\u0002J \u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u000bH\u0002J\u0006\u0010*\u001a\u00020\u001fJ\u0006\u0010+\u001a\u00020\u0007J\b\u0010,\u001a\u00020\u0010H\u0002J\u0016\u0010-\u001a\u00020\u00102\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\nH\u0002J(\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u0006\u00104\u001a\u00020\u001fJ\u0006\u00105\u001a\u00020\u001fJ\b\u00106\u001a\u00020\u001fH\u0002J\u000e\u00107\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0007J\b\u00108\u001a\u00020\u001fH\u0002J\u0016\u00109\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0002J\u0010\u0010:\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u000bH\u0002J\b\u0010;\u001a\u00020\u001fH\u0002R2\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\r0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0014\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\r0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0004¢\u0006\u0002\n\u0000¨\u0006="}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/widget/ShakeLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "coinList", "", "Landroid/view/View;", "kotlin.jvm.PlatformType", "", "curCanChoseRandomXs", "Ljava/util/ArrayList;", "", "curCanChoseRandomYs", "d", "Lio/reactivex/disposables/Disposable;", "dogList", "dogRandomYs", "isShakeAnimStarted", "", "mRandom", "Ljava/util/Random;", "maxX", "maxY", "minY", "speedList", "addCoin", "", "addCoinView", "addDog", "list", "addDogView", "resId", "addShowViewAnimation", "view", "x", "y", "animRemoveView", "dispose", "getDogCount", "getDogLocation", "getRandomLocation", "choseRandoms", "onSizeChanged", "w", "h", "oldw", "oldh", "resetCoin", "resetDog", "setCurrentCanChoseRandoms", "setMinY", "setOffSetX", "setOffSetY", "setSpd", "startShakeAnimation", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ShakeLayout.kt */
public final class ShakeLayout extends FrameLayout {
    /* renamed from: a */
    public static final C3036a f11456a = new C3036a(null);
    /* renamed from: n */
    private static final List<Float> f11457n = C8187k.m35269a((Object[]) new Float[]{Float.valueOf(0.83f), Float.valueOf(0.85f), Float.valueOf(0.93f), Float.valueOf(0.95f)});
    /* renamed from: o */
    private static final List<Float> f11458o;
    /* renamed from: p */
    private static final List<Float> f11459p;
    /* renamed from: b */
    private final List<Float> f11460b;
    /* renamed from: c */
    private final ArrayList<Float> f11461c;
    /* renamed from: d */
    private final ArrayList<Float> f11462d;
    /* renamed from: e */
    private final ArrayList<Float> f11463e;
    /* renamed from: f */
    private final Random f11464f;
    /* access modifiers changed from: private|final */
    /* renamed from: g */
    public final List<View> f11465g;
    /* access modifiers changed from: private|final */
    /* renamed from: h */
    public final List<View> f11466h;
    /* renamed from: i */
    private int f11467i;
    /* renamed from: j */
    private int f11468j;
    /* renamed from: k */
    private int f11469k;
    /* renamed from: l */
    private Disposable f11470l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean f11471m;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/widget/ShakeLayout$Companion;", "", "()V", "CHANGE_RANGE", "", "DOG_CHOSE_RANDOMS", "", "", "PROGRESS_DELAY_MILLIS", "", "X_MAX_CHOSE_RANDOMS", "Y_MAX_CHOSE_RANDOMS", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: ShakeLayout.kt */
    /* renamed from: com.jiayouya.travel.module.explore.widget.ShakeLayout$a */
    public static final class C3036a {
        private C3036a() {
        }

        public /* synthetic */ C3036a(DefaultConstructorMarker fVar) {
            this();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ShakeLayout.kt */
    /* renamed from: com.jiayouya.travel.module.explore.widget.ShakeLayout$b */
    static final class C3037b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ ShakeLayout f11472a;

        C3037b(ShakeLayout shakeLayout) {
            this.f11472a = shakeLayout;
        }

        public final void run() {
            this.f11472a.m13755f();
            if (!this.f11472a.f11471m) {
                this.f11472a.m13757g();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ShakeLayout.kt */
    /* renamed from: com.jiayouya.travel.module.explore.widget.ShakeLayout$c */
    static final class C3038c implements Runnable {
        /* renamed from: a */
        final /* synthetic */ ShakeLayout f11473a;
        /* renamed from: b */
        final /* synthetic */ List f11474b;

        C3038c(ShakeLayout shakeLayout, List list) {
            this.f11473a = shakeLayout;
            this.f11474b = list;
        }

        public final void run() {
            for (Number intValue : this.f11474b) {
                this.f11473a.m13743a(intValue.intValue());
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo39189d2 = {"com/jiayouya/travel/module/explore/widget/ShakeLayout$animRemoveView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: ShakeLayout.kt */
    /* renamed from: com.jiayouya.travel.module.explore.widget.ShakeLayout$d */
    public static final class C3039d extends AnimatorListenerAdapter {
        /* renamed from: a */
        final /* synthetic */ ShakeLayout f11475a;
        /* renamed from: b */
        final /* synthetic */ View f11476b;

        C3039d(ShakeLayout shakeLayout, View view) {
            this.f11475a = shakeLayout;
            this.f11476b = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f11475a.removeView(this.f11476b);
            this.f11475a.f11465g.remove(this.f11476b);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Long;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ShakeLayout.kt */
    /* renamed from: com.jiayouya.travel.module.explore.widget.ShakeLayout$e */
    static final class C3040e<T> implements Consumer<Long> {
        /* renamed from: a */
        final /* synthetic */ ShakeLayout f11477a;

        C3040e(ShakeLayout shakeLayout) {
            this.f11477a = shakeLayout;
        }

        /* renamed from: a */
        public final void accept(Long l) {
            ShakeLayout shakeLayout = this.f11477a;
            List d = shakeLayout.f11465g;
            C8271i.m35382a((Object) d, "coinList");
            shakeLayout.setOffSetY(d);
            ShakeLayout shakeLayout2 = this.f11477a;
            List e = shakeLayout2.f11466h;
            C8271i.m35382a((Object) e, "dogList");
            shakeLayout2.setOffSetY(e);
            this.f11477a.m13758h();
        }
    }

    public ShakeLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public ShakeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ShakeLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker fVar) {
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public ShakeLayout(Context context, AttributeSet attributeSet, int i) {
        C8271i.m35386b(context, "context");
        super(context, attributeSet, i);
        this.f11460b = C8187k.m35269a((Object[]) new Float[]{Float.valueOf(0.1f), Float.valueOf(0.15f), Float.valueOf(0.2f)});
        this.f11461c = new ArrayList<>();
        this.f11462d = new ArrayList<>();
        this.f11463e = new ArrayList<>();
        this.f11464f = new Random();
        this.f11465g = Collections.synchronizedList(new ArrayList());
        this.f11466h = Collections.synchronizedList(new ArrayList());
        this.f11468j = GloblaEx.m12810a(10.0f);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f11467i = i;
        this.f11469k = i2 - GloblaEx.m12810a(30.0f);
    }

    /* renamed from: a */
    public final void mo20942a() {
        List<View> list = this.f11465g;
        C8271i.m35382a((Object) list, "coinList");
        for (View removeView : list) {
            removeView(removeView);
        }
        this.f11465g.clear();
        this.f11463e.clear();
        this.f11461c.clear();
    }

    /* renamed from: b */
    public final void mo20944b() {
        int size = this.f11466h.size();
        for (int i = 0; i < size; i++) {
            removeView((View) this.f11466h.get(i));
        }
        this.f11466h.clear();
        this.f11462d.clear();
    }

    public final int getDogCount() {
        return this.f11466h.size();
    }

    /* renamed from: a */
    public final void mo20943a(List<Integer> list) {
        if (list != null && !list.isEmpty() && list.size() <= 5) {
            post(new C3038c(this, list));
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m13743a(int i) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(i);
        imageView.setTag(R.id.isUp, Boolean.valueOf(this.f11464f.nextBoolean()));
        this.f11466h.add(imageView);
        View view = imageView;
        m13745a(view, (((float) GloblaEx.m12809a()) / 2.0f) * getDogLocation(), ((float) (getMeasuredHeight() - this.f11464f.nextInt(10))) - ((float) GloblaEx.m12810a(120.0f)));
        setSpd(view);
    }

    private final float getDogLocation() {
        if (this.f11462d.isEmpty()) {
            this.f11462d.addAll(f11459p);
        }
        ArrayList<Float> arrayList = this.f11462d;
        Object obj = arrayList.get(arrayList.size() - 1);
        C8271i.m35382a(obj, "dogRandomYs[dogRandomYs.size - 1]");
        float floatValue = ((Number) obj).floatValue();
        this.f11462d.remove(Float.valueOf(floatValue));
        return floatValue;
    }

    /* renamed from: c */
    public final void mo20945c() {
        post(new C3037b(this));
    }

    /* renamed from: e */
    private final void m13754e() {
        this.f11461c.addAll(f11457n);
        this.f11463e.addAll(f11458o);
    }

    public final void setMinY(int i) {
        this.f11468j = i;
    }

    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final void m13755f() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.mipmap.ic_explore_pop_coin);
        imageView.setTag(R.id.isUp, Boolean.valueOf(this.f11464f.nextBoolean()));
        this.f11465g.add(imageView);
        View view = imageView;
        m13745a(view, ((float) this.f11467i) * m13749b((List<Float>) this.f11461c), Math.max((float) this.f11468j, ((float) this.f11469k) * m13749b((List<Float>) this.f11463e)));
        setSpd(view);
    }

    /* renamed from: a */
    private final void m13745a(View view, float f, float f2) {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        view.setTag(R.id.isCanShake, Boolean.valueOf(true));
        view.setTag(R.id.original_y, Float.valueOf(f2));
        addView(view, layoutParams);
        view.setScaleX(0.0f);
        view.setScaleY(0.0f);
        view.setX(f);
        view.setY(f2);
        view.animate().scaleY(1.0f).scaleX(1.0f).setDuration(500).start();
    }

    /* renamed from: b */
    private final float m13749b(List<Float> list) {
        if (list.size() <= 0) {
            m13754e();
        }
        float floatValue = ((Number) list.get(this.f11464f.nextInt(list.size()))).floatValue();
        list.remove(Float.valueOf(floatValue));
        return floatValue;
    }

    private final void setSpd(View view) {
        List<Float> list = this.f11460b;
        view.setTag(R.id.spd, Float.valueOf(((Number) list.get(this.f11464f.nextInt(list.size()))).floatValue()));
    }

    /* access modifiers changed from: private|final */
    public final void setOffSetY(List<? extends View> list) {
        for (View view : list) {
            Object tag = view.getTag(R.id.isCanShake);
            if (!(tag instanceof Boolean) || ((Boolean) tag).booleanValue()) {
                if (view.getTag(R.id.spd) == null) {
                    setSpd(view);
                }
                Object tag2 = view.getTag(R.id.spd);
                String str = "null cannot be cast to non-null type kotlin.Float";
                if (tag2 != null) {
                    float floatValue = ((Float) tag2).floatValue();
                    Object tag3 = view.getTag(R.id.original_y);
                    if (tag3 != null) {
                        float floatValue2 = ((Float) tag3).floatValue();
                        Object tag4 = view.getTag(R.id.isUp);
                        if (tag4 != null) {
                            float y = ((Boolean) tag4).booleanValue() ? view.getY() - floatValue : view.getY() + floatValue;
                            float f = y - floatValue2;
                            float f2 = (float) 10;
                            if (f > f2) {
                                y = floatValue2 + f2;
                                view.setTag(R.id.isUp, Boolean.valueOf(true));
                            } else if (f < ((float) -10)) {
                                y = floatValue2 - f2;
                                view.setTag(R.id.isUp, Boolean.valueOf(false));
                            }
                            view.setY(y);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                    } else {
                        throw new TypeCastException(str);
                    }
                } else {
                    throw new TypeCastException(str);
                }
            }
        }
    }

    /* renamed from: a */
    private final void m13744a(View view) {
        Object tag = view.getTag(R.id.isRemoved);
        if (!(tag instanceof Boolean) || !((Boolean) tag).booleanValue()) {
            view.setTag(R.id.isRemoved, Boolean.valueOf(true));
            view.animate().scaleX(0.0f).scaleY(0.0f).setDuration(1000).setListener(new C3039d(this, view)).start();
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: g */
    public final void m13757g() {
        mo20946d();
        this.f11471m = true;
        Observable a = Observable.m34990a(0, 8, TimeUnit.MILLISECONDS);
        C8271i.m35382a((Object) a, "Observable.interval(0, P…S, TimeUnit.MILLISECONDS)");
        this.f11470l = C8019a.m34776a(a, this).mo37374a(new C3040e(this));
    }

    /* renamed from: d */
    public final void mo20946d() {
        this.f11471m = false;
        Disposable bVar = this.f11470l;
        if (bVar != null && !bVar.isDisposed()) {
            Disposable bVar2 = this.f11470l;
            if (bVar2 != null) {
                bVar2.dispose();
            }
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: h */
    public final void m13758h() {
        List<View> list = this.f11465g;
        C8271i.m35382a((Object) list, "coinList");
        for (View view : list) {
            C8271i.m35382a((Object) view, "it");
            view.setX(view.getX() - 0.1f);
            List<View> list2 = this.f11466h;
            C8271i.m35382a((Object) list2, "dogList");
            if (!list2.isEmpty()) {
                View view2 = (View) this.f11466h.get(0);
                float x = view.getX();
                C8271i.m35382a((Object) view2, "rightDog");
                if (x <= view2.getX() + ((float) GloblaEx.m12810a(40.0f))) {
                    m13744a(view);
                }
            }
        }
    }

    /* JADX INFO: used method not loaded: kotlin.collections.m.a(java.lang.Object[]):null, types can be incorrect */
    static {
        Float valueOf = Float.valueOf(0.8f);
        f11458o = C8187k.m35269a((Object[]) new Float[]{Float.valueOf(0.7f), Float.valueOf(0.73f), Float.valueOf(0.78f), valueOf});
        f11459p = C8187k.m35269a((Object[]) new Float[]{Float.valueOf(0.060000002f), Float.valueOf(0.2f), Float.valueOf(0.4f), Float.valueOf(0.56f), valueOf});
    }
}
