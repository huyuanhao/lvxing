package com.jiayouya.travel.module.travel.widget.merge;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p244b.ViewEx;
import com.jiayouya.travel.common.widget.countdownview.CountdownView;
import com.jiayouya.travel.common.widget.countdownview.CountdownView.C2910a;
import com.jiayouya.travel.databinding.ItemMergeBinding;
import com.jiayouya.travel.module.travel.data.PositionExtra;
import com.jiayouya.travel.module.travel.data.PositionItem;
import com.jiayouya.travel.module.travel.data.PositionItemKt;
import com.jiayouya.travel.module.travel.p286b.TempDogDismissEvent;
import com.jiayouya.travel.module.travel.p287c.GoldUtil;
import com.jiayouya.travel.module.travel.p287c.MediaPlayerUtil;
import com.jiayouya.travel.module.travel.p287c.MergeUtil;
import ezy.app.p645rx.RxBus;
import java.util.concurrent.TimeUnit;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
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

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0007J\b\u0010%\u001a\u00020\u001eH\u0014J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0003J\b\u0010+\u001a\u00020\u001eH\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/widget/merge/MergeChild;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/jiayouya/travel/databinding/ItemMergeBinding;", "kotlin.jvm.PlatformType", "d", "Lio/reactivex/disposables/Disposable;", "item", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "getItem", "()Lcom/jiayouya/travel/module/travel/data/PositionItem;", "setItem", "(Lcom/jiayouya/travel/module/travel/data/PositionItem;)V", "mediaPlayer", "Landroid/media/MediaPlayer;", "mergeParent", "Lcom/jiayouya/travel/module/travel/widget/merge/MergeLayout;", "getMergeParent", "()Lcom/jiayouya/travel/module/travel/widget/merge/MergeLayout;", "mergeParent$delegate", "Lkotlin/Lazy;", "transAnim", "Landroid/view/animation/TranslateAnimation;", "getTransAnim", "()Landroid/view/animation/TranslateAnimation;", "transAnim$delegate", "disInterval", "", "dismissTempAuto", "goldAddAnim", "initial", "", "initPlayer", "notifyDataChange", "onDetachedFromWindow", "playMusic", "processTempDog", "release", "setVisible", "startProfitAnim", "stopProfitAnim", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MergeChild.kt */
public final class MergeChild extends FrameLayout {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f12274a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final ItemMergeBinding f12275b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public MediaPlayer f12276c;
    /* renamed from: d */
    private PositionItem f12277d = PositionItemKt.createEmptyPosition$default(0, 1, null);
    /* renamed from: e */
    private final Lazy f12278e = C8182c.m35317a(new C3575d(this));
    /* renamed from: f */
    private final Lazy f12279f;
    /* renamed from: g */
    private Disposable f12280g;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/common/widget/countdownview/CountdownView;", "kotlin.jvm.PlatformType", "onEnd"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MergeChild.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.merge.MergeChild$a */
    static final class C3572a implements C2910a {
        /* renamed from: a */
        final /* synthetic */ MergeChild f12281a;

        C3572a(MergeChild mergeChild) {
            this.f12281a = mergeChild;
        }

        /* renamed from: a */
        public final void mo20048a(CountdownView countdownView) {
            if (PositionItemKt.isTemp(this.f12281a.getItem())) {
                RxBus.f27263a.mo38572a((Object) new TempDogDismissEvent(this.f12281a.getItem()));
                MergeChild mergeChild = this.f12281a;
                mergeChild.setItem(PositionItemKt.createEmptyPosition(mergeChild.getItem().getPosition()));
                ItemMergeBinding a = this.f12281a.f12275b;
                String str = "binding";
                C8271i.m35382a((Object) a, str);
                a.mo20196a(this.f12281a.getItem());
                ItemMergeBinding a2 = this.f12281a.f12275b;
                C8271i.m35382a((Object) a2, str);
                a2.mo20195a(MergeUtil.m14455b(this.f12281a.getItem().getDogId()));
                this.f12281a.m14936j();
                this.f12281a.m14935i();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Long;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MergeChild.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.merge.MergeChild$b */
    static final class C3573b<T> implements Consumer<Long> {
        /* renamed from: a */
        final /* synthetic */ MergeChild f12282a;

        C3573b(MergeChild mergeChild) {
            this.f12282a = mergeChild;
        }

        /* renamed from: a */
        public final void accept(Long l) {
            this.f12282a.m14929d();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "queueIdle"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MergeChild.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.merge.MergeChild$c */
    static final class C3574c implements IdleHandler {
        /* renamed from: a */
        final /* synthetic */ MergeChild f12283a;

        C3574c(MergeChild mergeChild) {
            this.f12283a = mergeChild;
        }

        public final boolean queueIdle() {
            this.f12283a.f12276c = MediaPlayerUtil.m14448a("music/coin_add.mp3");
            return false;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Lcom/jiayouya/travel/module/travel/widget/merge/MergeLayout;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MergeChild.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.merge.MergeChild$d */
    static final class C3575d extends Lambda implements C8246a<MergeLayout> {
        final /* synthetic */ MergeChild this$0;

        C3575d(MergeChild mergeChild) {
            this.this$0 = mergeChild;
            super(0);
        }

        public final MergeLayout invoke() {
            ViewParent parent = this.this$0.getParent();
            if (parent != null) {
                return (MergeLayout) parent;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.module.travel.widget.merge.MergeLayout");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/view/animation/TranslateAnimation;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MergeChild.kt */
    /* renamed from: com.jiayouya.travel.module.travel.widget.merge.MergeChild$e */
    static final class C3576e extends Lambda implements C8246a<TranslateAnimation> {
        final /* synthetic */ MergeChild this$0;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, mo39189d2 = {"com/jiayouya/travel/module/travel/widget/merge/MergeChild$transAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
        /* compiled from: MergeChild.kt */
        /* renamed from: com.jiayouya.travel.module.travel.widget.merge.MergeChild$e$a */
        public static final class C3577a implements AnimationListener {
            /* renamed from: a */
            final /* synthetic */ C3576e f12284a;

            public void onAnimationRepeat(Animation animation) {
            }

            C3577a(C3576e eVar) {
                this.f12284a = eVar;
            }

            public void onAnimationStart(Animation animation) {
                FrameLayout frameLayout = this.f12284a.this$0.f12275b.f11101g;
                C8271i.m35382a((Object) frameLayout, "binding.lytProfit");
                ViewEx.m12842b(frameLayout, false);
            }

            public void onAnimationEnd(Animation animation) {
                FrameLayout frameLayout = this.f12284a.this$0.f12275b.f11101g;
                C8271i.m35382a((Object) frameLayout, "binding.lytProfit");
                ViewEx.m12843b(frameLayout, false, 1, null);
            }
        }

        C3576e(MergeChild mergeChild) {
            this.this$0 = mergeChild;
            super(0);
        }

        public final TranslateAnimation invoke() {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 2, 0.0f, 2, -0.5f);
            translateAnimation.setAnimationListener(new C3577a(this));
            translateAnimation.setDuration(500);
            return translateAnimation;
        }
    }

    static {
        Class<MergeChild> cls = MergeChild.class;
        f12274a = new C8280j[]{C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "mergeParent", "getMergeParent()Lcom/jiayouya/travel/module/travel/widget/merge/MergeLayout;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "transAnim", "getTransAnim()Landroid/view/animation/TranslateAnimation;"))};
    }

    private final MergeLayout getMergeParent() {
        Lazy bVar = this.f12278e;
        C8280j jVar = f12274a[0];
        return (MergeLayout) bVar.getValue();
    }

    private final TranslateAnimation getTransAnim() {
        Lazy bVar = this.f12279f;
        C8280j jVar = f12274a[1];
        return (TranslateAnimation) bVar.getValue();
    }

    public MergeChild(Context context) {
        C8271i.m35386b(context, "context");
        super(context);
        this.f12275b = (ItemMergeBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_merge, null, false);
        ItemMergeBinding itemMergeBinding = this.f12275b;
        C8271i.m35382a((Object) itemMergeBinding, "binding");
        addView(itemMergeBinding.getRoot());
        setClipChildren(false);
        m14932f();
        this.f12279f = C8182c.m35317a(new C3576e(this));
    }

    public final PositionItem getItem() {
        return this.f12277d;
    }

    public final void setItem(PositionItem positionItem) {
        C8271i.m35386b(positionItem, "<set-?>");
        this.f12277d = positionItem;
    }

    /* renamed from: a */
    public final void mo22509a() {
        ItemMergeBinding itemMergeBinding = this.f12275b;
        String str = "binding";
        C8271i.m35382a((Object) itemMergeBinding, str);
        itemMergeBinding.mo20196a(this.f12277d);
        ItemMergeBinding itemMergeBinding2 = this.f12275b;
        C8271i.m35382a((Object) itemMergeBinding2, str);
        itemMergeBinding2.mo20195a(MergeUtil.m14455b(this.f12277d.getDogId()));
        long j = (long) 1000;
        long j2 = (long) 4;
        m14923a(((j2 - (((System.currentTimeMillis() / j) - this.f12277d.getBirthTime()) % j2)) * j) + ((long) 500));
        m14925b();
        m14936j();
        this.f12275b.executePendingBindings();
    }

    /* renamed from: b */
    private final void m14925b() {
        if (PositionItemKt.isTemp(this.f12277d)) {
            PositionExtra extra = this.f12277d.getExtra();
            if (extra != null) {
                m14927c();
                long j = (long) 1000;
                long expire = (extra.getExpire() * j) - (System.currentTimeMillis() - (this.f12277d.getBirthTime() * j));
                StringBuilder sb = new StringBuilder();
                sb.append("time==");
                sb.append(expire);
                XLog.m12691a(sb.toString());
                this.f12275b.f11095a.mo20033a(expire);
            }
        }
    }

    /* renamed from: c */
    private final void m14927c() {
        this.f12275b.f11095a.setOnCountdownEndListener(new C3572a(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final void m14929d() {
        Double a = getMergeParent().mo22518a(this.f12277d);
        if (a != null) {
            double doubleValue = a.doubleValue();
            ItemMergeBinding itemMergeBinding = this.f12275b;
            C8271i.m35382a((Object) itemMergeBinding, "binding");
            PositionItem a2 = itemMergeBinding.mo20194a();
            if (a2 == null || a2.getDogId() != 38) {
                getMergeParent().mo22519a(doubleValue);
            }
            if (getMergeParent().mo22523a()) {
                TextView textView = this.f12275b.f11103i;
                StringBuilder sb = new StringBuilder();
                sb.append('+');
                sb.append(GoldUtil.f11900a.mo21651a(doubleValue));
                String sb2 = sb.toString();
                if (!C8271i.m35384a((Object) textView.getText().toString(), (Object) sb2)) {
                    int measureText = (int) textView.getPaint().measureText(sb2);
                    LinearLayout linearLayout = this.f12275b.f11102h;
                    C8271i.m35382a((Object) linearLayout, "binding.lytProfitTxt");
                    linearLayout.setX(((float) (GloblaEx.m12810a(60.0f) - measureText)) / 2.0f);
                }
                textView.setText(sb2);
                this.f12275b.f11101g.startAnimation(getTransAnim());
                this.f12275b.f11096b.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale));
                m14933g();
            }
        }
    }

    /* renamed from: e */
    private final void m14931e() {
        this.f12275b.f11103i.clearAnimation();
        this.f12275b.f11096b.clearAnimation();
    }

    /* renamed from: f */
    private final void m14932f() {
        Looper.myQueue().addIdleHandler(new C3574c(this));
    }

    /* renamed from: g */
    private final void m14933g() {
        MediaPlayer mediaPlayer = this.f12276c;
        if (mediaPlayer != null) {
            MediaPlayerUtil.m14449a(mediaPlayer);
        }
    }

    /* renamed from: h */
    private final void m14934h() {
        MediaPlayer mediaPlayer = this.f12276c;
        if (mediaPlayer != null) {
            MediaPlayerUtil.m14450b(mediaPlayer);
        }
    }

    /* renamed from: a */
    private final void m14923a(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("initial==");
        sb.append(j);
        XLog.m12691a(sb.toString());
        m14935i();
        m14931e();
        ItemMergeBinding itemMergeBinding = this.f12275b;
        C8271i.m35382a((Object) itemMergeBinding, "binding");
        PositionItem a = itemMergeBinding.mo20194a();
        if (a == null || a.getLevel() != 0) {
            this.f12280g = Observable.m34990a(j, 4500, TimeUnit.MILLISECONDS).mo38892a(AndroidSchedulers.m34919a()).mo38904c((Consumer<? super T>) new C3573b<Object>(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m14935i();
        m14934h();
    }

    /* access modifiers changed from: private|final */
    /* renamed from: i */
    public final void m14935i() {
        Disposable bVar = this.f12280g;
        if (bVar != null && !bVar.isDisposed()) {
            Disposable bVar2 = this.f12280g;
            if (bVar2 != null) {
                bVar2.dispose();
            }
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: j */
    public final void m14936j() {
        LinearLayout linearLayout = this.f12275b.f11099e;
        C8271i.m35382a((Object) linearLayout, "binding.lytClock");
        boolean z = true;
        ViewEx.m12840a(linearLayout, this.f12277d.getExtra() == null);
        ImageView imageView = this.f12275b.f11098d;
        C8271i.m35382a((Object) imageView, "binding.ivHb");
        ViewEx.m12842b(imageView, this.f12277d.getExtra() == null);
        LinearLayout linearLayout2 = this.f12275b.f11102h;
        C8271i.m35382a((Object) linearLayout2, "binding.lytProfitTxt");
        ViewEx.m12842b(linearLayout2, this.f12277d.getExtra() != null);
        FrameLayout frameLayout = this.f12275b.f11100f;
        C8271i.m35382a((Object) frameLayout, "binding.lytContainer");
        View view = frameLayout;
        if (this.f12277d.getLevel() != 0) {
            z = false;
        }
        ViewEx.m12840a(view, z);
    }
}
