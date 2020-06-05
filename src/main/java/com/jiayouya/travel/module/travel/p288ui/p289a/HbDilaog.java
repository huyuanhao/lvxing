package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.DialogHbBinding;
import com.jiayouya.travel.module.travel.data.C3325HB;
import com.jiayouya.travel.module.travel.data.OpenHbRsp;
import com.jiayouya.travel.module.travel.data.RecycleDogRsp;
import com.jiayouya.travel.module.travel.p285a.C3324d;
import com.jiayouya.travel.module.travel.p286b.HbAmountEvent;
import ezy.app.p643a.API;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p653ui.widget.dialog.CustomDialog;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.reflect.C8280j;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B<\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002R.\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/HbDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "item", "Lcom/jiayouya/travel/module/travel/data/HB;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "p", "", "(Landroid/content/Context;Lcom/jiayouya/travel/module/travel/data/HB;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lkotlin/jvm/functions/Function1;", "animator", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "getAnimator", "()Landroid/animation/ObjectAnimator;", "animator$delegate", "Lkotlin/Lazy;", "binding", "Lcom/jiayouya/travel/databinding/DialogHbBinding;", "getItem", "()Lcom/jiayouya/travel/module/travel/data/HB;", "rotate", "setupClick", "setupObserve", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.i */
public final class HbDilaog extends CustomDialog {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f11986a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(HbDilaog.class), "animator", "getAnimator()Landroid/animation/ObjectAnimator;"))};
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final DialogHbBinding f11987b;
    /* renamed from: c */
    private final Lazy f11988c;
    /* renamed from: d */
    private final C3325HB f11989d;
    /* renamed from: e */
    private final C8247b<Integer, Unit> f11990e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: HbDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.i$a */
    static final class C3369a extends Lambda implements C8246a<ObjectAnimator> {
        final /* synthetic */ HbDilaog this$0;

        C3369a(HbDilaog iVar) {
            this.this$0 = iVar;
            super(0);
        }

        public final ObjectAnimator invoke() {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.this$0.f11987b.f10447c, "rotationY", new float[]{0.0f, 90.0f, 0.0f});
            ofFloat.setDuration(500);
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(-1);
            ofFloat.setInterpolator(new LinearInterpolator());
            return ofFloat;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: HbDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.i$b */
    static final class C3370b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ HbDilaog this$0;

        C3370b(HbDilaog iVar) {
            this.this$0 = iVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            int type = this.this$0.mo22267a().getType();
            String str = "binding.root";
            String str2 = "binding";
            if (type != 1) {
                if (type != 2) {
                    if (type == 3) {
                        Observable a = C3324d.m14443a(API.f27251a).mo21624a(this.this$0.mo22267a().getPosition());
                        DialogHbBinding a2 = this.this$0.f11987b;
                        C8271i.m35382a((Object) a2, str2);
                        View root = a2.getRoot();
                        C8271i.m35382a((Object) root, str);
                        C8019a.m34776a(a, root).mo37374a(new Consumer<RecycleDogRsp>(this) {
                            /* renamed from: a */
                            final /* synthetic */ C3370b f11992a;

                            {
                                this.f11992a = r1;
                            }

                            /* renamed from: a */
                            public final void accept(RecycleDogRsp recycleDogRsp) {
                                DialogHbBinding a = this.f11992a.this$0.f11987b;
                                C8271i.m35382a((Object) a, "binding");
                                a.mo20124a(String.valueOf(recycleDogRsp.getNumber()));
                                C8247b b = this.f11992a.this$0.mo22268b();
                                if (b != null) {
                                    Unit jVar = (Unit) b.invoke(Integer.valueOf(this.f11992a.this$0.mo22267a().getPosition()));
                                }
                            }
                        });
                        return;
                    } else if (type != 4) {
                        return;
                    }
                }
                this.this$0.m14564g();
                C8247b b = this.this$0.mo22268b();
                if (b != null) {
                    Unit jVar = (Unit) b.invoke(Integer.valueOf(-1));
                    return;
                }
                return;
            }
            this.this$0.m14564g();
            Observable a3 = C3324d.m14443a(API.f27251a).mo21628a(this.this$0.mo22267a().getHbId());
            DialogHbBinding a4 = this.this$0.f11987b;
            C8271i.m35382a((Object) a4, str2);
            View root2 = a4.getRoot();
            C8271i.m35382a((Object) root2, str);
            C8019a.m34776a(a3, root2).mo37374a(new Consumer<OpenHbRsp>(this) {
                /* renamed from: a */
                final /* synthetic */ C3370b f11991a;

                {
                    this.f11991a = r1;
                }

                /* renamed from: a */
                public final void accept(OpenHbRsp openHbRsp) {
                    DialogHbBinding a = this.f11991a.this$0.f11987b;
                    C8271i.m35382a((Object) a, "binding");
                    a.mo20124a(openHbRsp.getNumber());
                    C8247b b = this.f11991a.this$0.mo22268b();
                    if (b != null) {
                        Unit jVar = (Unit) b.invoke(Integer.valueOf(-1));
                    }
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: HbDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.i$c */
    static final class C3373c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ HbDilaog this$0;

        C3373c(HbDilaog iVar) {
            this.this$0 = iVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Router.m12969a(Router.f9644a, "/assets/cash", null, null, 6, null);
            this.this$0.dismiss();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: HbDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.i$d */
    static final class C3374d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ HbDilaog this$0;

        C3374d(HbDilaog iVar) {
            this.this$0 = iVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Router.m12969a(Router.f9644a, "/assets/cash", null, null, 6, null);
            this.this$0.dismiss();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: HbDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.i$e */
    static final class C3375e extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ HbDilaog this$0;

        C3375e(HbDilaog iVar) {
            this.this$0 = iVar;
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

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/event/HbAmountEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: HbDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.i$f */
    static final class C3376f<T> implements Consumer<HbAmountEvent> {
        /* renamed from: a */
        final /* synthetic */ HbDilaog f11993a;

        C3376f(HbDilaog iVar) {
            this.f11993a = iVar;
        }

        /* renamed from: a */
        public final void accept(HbAmountEvent bVar) {
            DialogHbBinding a = this.f11993a.f11987b;
            C8271i.m35382a((Object) a, "binding");
            a.mo20124a(bVar.mo21649a());
        }
    }

    /* renamed from: f */
    private final ObjectAnimator m14563f() {
        Lazy bVar = this.f11988c;
        C8280j jVar = f11986a[0];
        return (ObjectAnimator) bVar.getValue();
    }

    public /* synthetic */ HbDilaog(Context context, C3325HB hb, C8247b bVar, int i, DefaultConstructorMarker fVar) {
        if ((i & 4) != 0) {
            bVar = null;
        }
        this(context, hb, bVar);
    }

    /* renamed from: a */
    public final C3325HB mo22267a() {
        return this.f11989d;
    }

    /* renamed from: b */
    public final C8247b<Integer, Unit> mo22268b() {
        return this.f11990e;
    }

    public HbDilaog(Context context, C3325HB hb, C8247b<? super Integer, Unit> bVar) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(hb, "item");
        super(context);
        this.f11989d = hb;
        this.f11990e = bVar;
        this.f11987b = (DialogHbBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_hb, null, false);
        DialogHbBinding dialogHbBinding = this.f11987b;
        C8271i.m35382a((Object) dialogHbBinding, "binding");
        setView(dialogHbBinding.getRoot());
        m14562e();
        m14561d();
        m14560c();
        this.f11988c = C8182c.m35317a(new C3369a(this));
    }

    /* renamed from: c */
    private final void m14560c() {
        Observable a = RxBus.f27263a.mo38571a(HbAmountEvent.class);
        DialogHbBinding dialogHbBinding = this.f11987b;
        C8271i.m35382a((Object) dialogHbBinding, "binding");
        View root = dialogHbBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        C8019a.m34776a(a, root).mo37374a(new C3376f(this));
    }

    /* renamed from: d */
    private final void m14561d() {
        setDimAmount(0.7f);
        DialogHbBinding dialogHbBinding = this.f11987b;
        String str = "binding";
        C8271i.m35382a((Object) dialogHbBinding, str);
        View root = dialogHbBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(300.0f);
        DialogHbBinding dialogHbBinding2 = this.f11987b;
        C8271i.m35382a((Object) dialogHbBinding2, str);
        dialogHbBinding2.mo20122a((int) R.mipmap.ic_launcher);
        DialogHbBinding dialogHbBinding3 = this.f11987b;
        C8271i.m35382a((Object) dialogHbBinding3, str);
        dialogHbBinding3.mo20123a(this.f11989d);
        if (this.f11989d.getType() == 5) {
            DialogHbBinding dialogHbBinding4 = this.f11987b;
            C8271i.m35382a((Object) dialogHbBinding4, str);
            dialogHbBinding4.mo20124a(this.f11989d.getAmount());
        }
    }

    /* renamed from: e */
    private final void m14562e() {
        ImageView imageView = this.f11987b.f10447c;
        C8271i.m35382a((Object) imageView, "binding.ivOpen");
        ezy.p642a.View.m34750a(imageView, 0, new C3370b(this), 1, null);
        TextView textView = this.f11987b.f10448d;
        C8271i.m35382a((Object) textView, "binding.tvWallet");
        ezy.p642a.View.m34750a(textView, 0, new C3373c(this), 1, null);
        FrameLayout frameLayout = this.f11987b.f10445a;
        C8271i.m35382a((Object) frameLayout, "binding.btnCash");
        ezy.p642a.View.m34750a(frameLayout, 0, new C3374d(this), 1, null);
        ImageView imageView2 = this.f11987b.f10446b;
        C8271i.m35382a((Object) imageView2, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView2, 0, new C3375e(this), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: g */
    public final void m14564g() {
        Context context = getContext();
        C8271i.m35382a((Object) context, "context");
        Resources resources = context.getResources();
        C8271i.m35382a((Object) resources, "context.resources");
        float f = resources.getDisplayMetrics().density * ((float) 16000);
        ImageView imageView = this.f11987b.f10447c;
        C8271i.m35382a((Object) imageView, "binding.ivOpen");
        imageView.setCameraDistance(f);
        m14563f().start();
    }
}
