package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.p131c.p132a.ViewTarget;
import com.bumptech.glide.p131c.p133b.Transition;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.ViewEx;
import com.jiayouya.travel.databinding.DialogRandomMergeBinding;
import com.jiayouya.travel.module.travel.data.MergeDialExtra;
import com.jiayouya.travel.module.travel.data.MergeDialItem;
import com.jiayouya.travel.module.travel.data.MergeDogRsp;
import com.jiayouya.travel.module.travel.p285a.C3324d;
import com.jiayouya.travel.module.travel.widget.RandomMergeView;
import ezy.app.p643a.API;
import ezy.app.p645rx.C8019a;
import ezy.p653ui.widget.dialog.CustomDialog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001BT\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0010\u0012J\b\u0010 \u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\b\u0010$\u001a\u00020\u000bH\u0002R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR,\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006%"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/RandomMergeDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "extra", "Lcom/jiayouya/travel/module/travel/data/MergeDialExtra;", "list", "", "Lcom/jiayouya/travel/module/travel/data/MergeDialItem;", "onMergeFail", "Lkotlin/Function0;", "", "onMergeSucceed", "Lkotlin/Function1;", "Lcom/jiayouya/travel/module/travel/data/MergeDogRsp;", "Lkotlin/ParameterName;", "name", "item", "(Landroid/content/Context;Lcom/jiayouya/travel/module/travel/data/MergeDialExtra;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogRandomMergeBinding;", "kotlin.jvm.PlatformType", "getExtra", "()Lcom/jiayouya/travel/module/travel/data/MergeDialExtra;", "isSucceed", "", "getList", "()Ljava/util/List;", "getOnMergeFail", "()Lkotlin/jvm/functions/Function0;", "getOnMergeSucceed", "()Lkotlin/jvm/functions/Function1;", "initDogBitmap", "setCanDismiss", "isCan", "setupClick", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.n */
public final class RandomMergeDilaog extends CustomDialog {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final DialogRandomMergeBinding f12018a = ((DialogRandomMergeBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_random_merge, null, false));
    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean f12019b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public MergeDogRsp f12020c;
    /* renamed from: d */
    private final MergeDialExtra f12021d;
    /* renamed from: e */
    private final List<MergeDialItem> f12022e;
    /* renamed from: f */
    private final C8246a<Unit> f12023f;
    /* renamed from: g */
    private final C8247b<MergeDogRsp, Unit> f12024g;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0003\u0018\u00010\bH\u0016¨\u0006\t¸\u0006\u0000"}, mo39189d2 = {"com/jiayouya/travel/module/travel/ui/dialog/RandomMergeDialog$initDogBitmap$1$1", "Lcom/bumptech/glide/request/target/ViewTarget;", "Landroid/widget/ImageView;", "Landroid/graphics/drawable/Drawable;", "onResourceReady", "", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.n$a */
    public static final class C3401a extends ViewTarget<ImageView, Drawable> {
        /* renamed from: b */
        final /* synthetic */ int f12025b;
        /* renamed from: c */
        final /* synthetic */ ImageView f12026c;
        /* renamed from: d */
        final /* synthetic */ RandomMergeDilaog f12027d;

        C3401a(int i, ImageView imageView, View view, RandomMergeDilaog nVar) {
            this.f12025b = i;
            this.f12026c = imageView;
            this.f12027d = nVar;
            super(view);
        }

        /* renamed from: a */
        public void onResourceReady(Drawable drawable, Transition<? super Drawable> fVar) {
            C8271i.m35386b(drawable, "resource");
            StringBuilder sb = new StringBuilder();
            sb.append("width==");
            sb.append(drawable.getIntrinsicWidth());
            XLog.m12692b(sb.toString());
            RandomMergeView randomMergeView = this.f12027d.f12018a.f10572d;
            randomMergeView.getDogImageList().put(this.f12025b, ((BitmapDrawable) drawable).getBitmap());
            randomMergeView.postInvalidate();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.n$b */
    static final class C3402b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ RandomMergeDilaog this$0;

        C3402b(RandomMergeDilaog nVar) {
            this.this$0 = nVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.dismiss();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.n$c */
    static final class C3403c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ RandomMergeDilaog this$0;

        C3403c(RandomMergeDilaog nVar) {
            this.this$0 = nVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.m14615a(false);
            view.setEnabled(false);
            this.this$0.f12018a.f10572d.mo22496a();
            Observable a = C3324d.m14443a(API.f27251a).mo21631b(this.this$0.mo22305a().getP1(), this.this$0.mo22305a().getP2()).mo38884a((Consumer<? super Throwable>) new Consumer<Throwable>(this) {
                /* renamed from: a */
                final /* synthetic */ C3403c f12028a;

                {
                    this.f12028a = r1;
                }

                /* renamed from: a */
                public final void accept(Throwable th) {
                    this.f12028a.this$0.f12018a.f10569a.post(new Runnable(this) {
                        /* renamed from: a */
                        final /* synthetic */ C34041 f12029a;

                        {
                            this.f12029a = r1;
                        }

                        public final void run() {
                            this.f12029a.f12028a.this$0.m14615a(true);
                        }
                    });
                }
            });
            C8271i.m35382a((Object) a, "API.game().merge(extra.p…          }\n            }");
            DialogRandomMergeBinding c = this.this$0.f12018a;
            C8271i.m35382a((Object) c, "binding");
            View root = c.getRoot();
            C8271i.m35382a((Object) root, "binding.root");
            C8019a.m34776a(a, root).mo37374a(new Consumer<MergeDogRsp>(this) {
                /* renamed from: a */
                final /* synthetic */ C3403c f12030a;

                {
                    this.f12030a = r1;
                }

                /* renamed from: a */
                public final void accept(MergeDogRsp mergeDogRsp) {
                    this.f12030a.this$0.f12019b = true;
                    Iterator it = this.f12030a.this$0.mo22306b().iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        }
                        if (((MergeDialItem) it.next()).getId() == mergeDogRsp.getMerge().getDogId()) {
                            break;
                        }
                        i++;
                    }
                    this.f12030a.this$0.f12018a.f10572d.setResult(i);
                    this.f12030a.this$0.f12020c = mergeDogRsp;
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.n$d */
    static final class C3407d extends Lambda implements C8246a<Unit> {
        final /* synthetic */ RandomMergeDilaog this$0;

        C3407d(RandomMergeDilaog nVar) {
            this.this$0 = nVar;
            super(0);
        }

        public final void invoke() {
            this.this$0.dismiss();
            MergeDogRsp a = this.this$0.f12020c;
            if (a != null) {
                this.this$0.mo22308d().invoke(a);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RandomMergeDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.n$e */
    static final class C3408e implements OnDismissListener {
        /* renamed from: a */
        final /* synthetic */ RandomMergeDilaog f12031a;

        C3408e(RandomMergeDilaog nVar) {
            this.f12031a = nVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            if (!this.f12031a.f12019b) {
                this.f12031a.mo22307c().invoke();
            }
        }
    }

    /* renamed from: a */
    public final MergeDialExtra mo22305a() {
        return this.f12021d;
    }

    /* renamed from: b */
    public final List<MergeDialItem> mo22306b() {
        return this.f12022e;
    }

    /* renamed from: c */
    public final C8246a<Unit> mo22307c() {
        return this.f12023f;
    }

    /* renamed from: d */
    public final C8247b<MergeDogRsp, Unit> mo22308d() {
        return this.f12024g;
    }

    public RandomMergeDilaog(Context context, MergeDialExtra mergeDialExtra, List<MergeDialItem> list, C8246a<Unit> aVar, C8247b<? super MergeDogRsp, Unit> bVar) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(mergeDialExtra, "extra");
        C8271i.m35386b(list, "list");
        C8271i.m35386b(aVar, "onMergeFail");
        C8271i.m35386b(bVar, "onMergeSucceed");
        super(context);
        this.f12021d = mergeDialExtra;
        this.f12022e = list;
        this.f12023f = aVar;
        this.f12024g = bVar;
        DialogRandomMergeBinding dialogRandomMergeBinding = this.f12018a;
        C8271i.m35382a((Object) dialogRandomMergeBinding, "binding");
        setView(dialogRandomMergeBinding.getRoot());
        m14620f();
        m14619e();
        m14621g();
    }

    /* renamed from: e */
    private final void m14619e() {
        setDimAmount(0.7f);
        this.f12018a.f10572d.setOnEndListener(new C3407d(this));
        setOnDismissListener(new C3408e(this));
    }

    /* renamed from: f */
    private final void m14620f() {
        ImageView imageView = this.f12018a.f10570b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3402b(this), 1, null);
        ImageView imageView2 = this.f12018a.f10569a;
        C8271i.m35382a((Object) imageView2, "binding.btn");
        ezy.p642a.View.m34750a(imageView2, 0, new C3403c(this), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14615a(boolean z) {
        setCanceledOnTouchOutside(z);
        setCancelable(z);
        ImageView imageView = this.f12018a.f10569a;
        C8271i.m35382a((Object) imageView, "binding.btn");
        imageView.setEnabled(z);
    }

    /* renamed from: g */
    private final void m14621g() {
        int i = 0;
        for (Object next : this.f12022e) {
            int i2 = i + 1;
            if (i < 0) {
                C8187k.m35272b();
            }
            MergeDialItem mergeDialItem = (MergeDialItem) next;
            ImageView imageView = new ImageView(getContext());
            View view = imageView;
            this.f12018a.f10571c.addView(view);
            imageView.setLayoutParams(new LayoutParams(dp2px(55.0f), dp2px(55.0f)));
            ViewEx.m12843b(view, false, 1, null);
            Glide.m5174b(getContext()).mo12591a(mergeDialItem.getImage()).mo12580a(new C3401a(i, imageView, view, this));
            i = i2;
        }
    }
}
