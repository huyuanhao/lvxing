package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.C2914d;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.databinding.DialogLuckyDrawBinding;
import com.jiayouya.travel.module.common.data.AdRsp;
import com.jiayouya.travel.module.common.p257a.C2957b;
import com.jiayouya.travel.module.common.p258b.AdReportResultEvent;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.travel.data.C3325HB;
import com.jiayouya.travel.module.travel.data.GetCoinItem;
import com.jiayouya.travel.module.travel.data.HbInformation;
import com.jiayouya.travel.module.travel.data.LuckDrawRsp;
import com.jiayouya.travel.module.travel.data.LuckPoolItem;
import com.jiayouya.travel.module.travel.data.LuckPoolItemKt;
import com.jiayouya.travel.module.travel.data.LuckPoolRsp;
import com.jiayouya.travel.module.travel.p285a.C3324d;
import com.jiayouya.travel.module.travel.p286b.HbAmountEvent;
import com.jiayouya.travel.module.travel.p286b.RefreshDrawDotEvent;
import com.tencent.android.tpush.common.Constants;
import ezy.app.p643a.API;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001a\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/LuckyDrawDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "activity", "Landroid/app/Activity;", "item", "Lcom/jiayouya/travel/module/travel/data/LuckPoolRsp;", "(Landroid/app/Activity;Lcom/jiayouya/travel/module/travel/data/LuckPoolRsp;)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/jiayouya/travel/databinding/DialogLuckyDrawBinding;", "kotlin.jvm.PlatformType", "getItem", "()Lcom/jiayouya/travel/module/travel/data/LuckPoolRsp;", "ticketLogId", "", "doOnAnimatorEnd", "", "rsp", "Lcom/jiayouya/travel/module/travel/data/LuckDrawRsp;", "luckItem", "Lcom/jiayouya/travel/module/travel/data/LuckPoolItem;", "setDismissEnable", "isEnable", "", "setNewTicket", "newTickets", "", "isSetBtn", "setupClick", "setupObserve", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.k */
public final class LuckyDrawDilaog extends CustomDialog {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final DialogLuckyDrawBinding f11997a = ((DialogLuckyDrawBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_lucky_draw, null, false));
    /* access modifiers changed from: private */
    /* renamed from: b */
    public String f11998b;
    /* renamed from: c */
    private final Activity f11999c;
    /* renamed from: d */
    private final LuckPoolRsp f12000d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LuckyDrawDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.k$a */
    static final class C3380a extends Lambda implements C8247b<Integer, Unit> {
        final /* synthetic */ HbInformation $hb;

        C3380a(HbInformation hbInformation) {
            this.$hb = hbInformation;
            super(1);
        }

        public /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).intValue());
            return Unit.f27778a;
        }

        public final void invoke(int i) {
            RxBus.f27263a.mo38572a((Object) new HbAmountEvent(this.$hb.getAmount()));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LuckyDrawDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.k$b */
    static final class C3381b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ LuckyDrawDilaog this$0;

        C3381b(LuckyDrawDilaog kVar) {
            this.this$0 = kVar;
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

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LuckyDrawDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.k$c */
    static final class C3382c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ LuckyDrawDilaog this$0;

        C3382c(LuckyDrawDilaog kVar) {
            this.this$0 = kVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(final View view) {
            C8271i.m35386b(view, "view");
            view.setEnabled(false);
            this.this$0.f11997a.f10484b.mo22488a();
            Observable a = C3324d.m14443a(API.f27251a).mo21637d().mo38884a((Consumer<? super Throwable>) new Consumer<Throwable>(this) {
                /* renamed from: a */
                final /* synthetic */ C3382c f12001a;

                {
                    this.f12001a = r1;
                }

                /* renamed from: a */
                public final void accept(Throwable th) {
                    C2914d.m13179a((Runnable) new Runnable(this) {
                        /* renamed from: a */
                        final /* synthetic */ C33831 f12003a;

                        {
                            this.f12003a = r1;
                        }

                        public final void run() {
                            view.setEnabled(true);
                            this.f12003a.f12001a.this$0.f11997a.f10484b.setResult(0);
                            this.f12003a.f12001a.this$0.f11997a.f10484b.setOnEndListener(null);
                            GloblaEx.m12816a("似乎出了点问题，请重试~", 0, 0, 6, null);
                        }
                    });
                }
            });
            C8271i.m35382a((Object) a, "API.game().luckDraw().do…         })\n            }");
            DialogLuckyDrawBinding b = this.this$0.f11997a;
            C8271i.m35382a((Object) b, "binding");
            View root = b.getRoot();
            C8271i.m35382a((Object) root, "binding.root");
            C8019a.m34776a(a, root).mo37374a(new Consumer<LuckDrawRsp>(this) {
                /* renamed from: a */
                final /* synthetic */ C3382c f12004a;

                {
                    this.f12004a = r1;
                }

                /* renamed from: a */
                public final void accept(final LuckDrawRsp luckDrawRsp) {
                    int i = 0;
                    LuckyDrawDilaog.m14579a(this.f12004a.this$0, luckDrawRsp.getTickets(), false, 2, null);
                    if (luckDrawRsp.getTickets() == 0) {
                        RxBus.f27263a.mo38572a((Object) new RefreshDrawDotEvent(0));
                    }
                    Iterator it = this.f12004a.this$0.mo22282b().getPool().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        } else if (C8271i.m35384a((Object) ((LuckPoolItem) it.next()).getId(), (Object) luckDrawRsp.getPrizeId())) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i != -1) {
                        this.f12004a.this$0.f11997a.f10484b.setResult(i);
                        final LuckPoolItem luckPoolItem = (LuckPoolItem) this.f12004a.this$0.mo22282b().getPool().get(i);
                        this.f12004a.this$0.f11997a.f10484b.setOnEndListener(new C8246a<Unit>(this) {
                            final /* synthetic */ C33852 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public final void invoke() {
                                LuckyDrawDilaog kVar = this.this$0.f12004a.this$0;
                                LuckDrawRsp luckDrawRsp = luckDrawRsp;
                                C8271i.m35382a((Object) luckDrawRsp, "rsp");
                                kVar.m14577a(luckDrawRsp, luckPoolItem);
                            }
                        });
                    }
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LuckyDrawDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.k$d */
    static final class C3387d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ LuckyDrawDilaog this$0;

        C3387d(LuckyDrawDilaog kVar) {
            this.this$0 = kVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Observable a = C2957b.m13527a(API.f27251a).mo20403a(4);
            DialogLuckyDrawBinding b = this.this$0.f11997a;
            C8271i.m35382a((Object) b, "binding");
            View root = b.getRoot();
            C8271i.m35382a((Object) root, "binding.root");
            C8019a.m34776a(a, root).mo37374a(new Consumer<AdRsp>(this) {
                /* renamed from: a */
                final /* synthetic */ C3387d f12005a;

                {
                    this.f12005a = r1;
                }

                /* renamed from: a */
                public final void accept(AdRsp adRsp) {
                    this.f12005a.this$0.f11998b = adRsp.getAdLogId();
                    Activity a = this.f12005a.this$0.mo22281a();
                    C8271i.m35382a((Object) adRsp, "it");
                    new LuckTicketDilaog(a, adRsp).show();
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/event/AdReportResultEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LuckyDrawDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.k$e */
    static final class C3389e<T> implements Consumer<AdReportResultEvent> {
        /* renamed from: a */
        final /* synthetic */ LuckyDrawDilaog f12006a;

        C3389e(LuckyDrawDilaog kVar) {
            this.f12006a = kVar;
        }

        /* renamed from: a */
        public final void accept(AdReportResultEvent aVar) {
            if (C8271i.m35384a((Object) aVar.mo20435b(), (Object) this.f12006a.f11998b) && aVar.mo20434a()) {
                RxBus.f27263a.mo38572a((Object) new RefreshDrawDotEvent(5));
                this.f12006a.m14576a(5, true);
            }
        }
    }

    public LuckyDrawDilaog(Activity activity, LuckPoolRsp luckPoolRsp) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        C8271i.m35386b(luckPoolRsp, "item");
        super(activity);
        this.f11999c = activity;
        this.f12000d = luckPoolRsp;
        DialogLuckyDrawBinding dialogLuckyDrawBinding = this.f11997a;
        C8271i.m35382a((Object) dialogLuckyDrawBinding, "binding");
        setView(dialogLuckyDrawBinding.getRoot());
        m14586e();
        m14584c();
        this.f11998b = "";
    }

    /* renamed from: a */
    public final Activity mo22281a() {
        return this.f11999c;
    }

    /* renamed from: b */
    public final LuckPoolRsp mo22282b() {
        return this.f12000d;
    }

    /* renamed from: c */
    private final void m14584c() {
        setDimAmount(0.7f);
        DialogLuckyDrawBinding dialogLuckyDrawBinding = this.f11997a;
        String str = "binding";
        C8271i.m35382a((Object) dialogLuckyDrawBinding, str);
        View root = dialogLuckyDrawBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(300.0f);
        this.f11997a.f10484b.setData(this.f12000d.getPool());
        DialogLuckyDrawBinding dialogLuckyDrawBinding2 = this.f11997a;
        C8271i.m35382a((Object) dialogLuckyDrawBinding2, str);
        dialogLuckyDrawBinding2.mo20129a(this.f12000d);
        RoundText roundText = this.f11997a.f10483a;
        C8271i.m35382a((Object) roundText, "binding.btnStart");
        RoundTextEx.m12837a(roundText, this.f12000d.getTickets() > 0, (String) null, (String) null, 6, (Object) null);
        m14582a(false);
        m14585d();
    }

    /* renamed from: d */
    private final void m14585d() {
        Observable a = RxBus.f27263a.mo38571a(AdReportResultEvent.class);
        DialogLuckyDrawBinding dialogLuckyDrawBinding = this.f11997a;
        C8271i.m35382a((Object) dialogLuckyDrawBinding, "binding");
        View root = dialogLuckyDrawBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        C8019a.m34776a(a, root).mo37374a(new C3389e(this));
    }

    /* renamed from: e */
    private final void m14586e() {
        ImageView imageView = this.f11997a.f10485c;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3381b(this), 1, null);
        RoundText roundText = this.f11997a.f10483a;
        C8271i.m35382a((Object) roundText, "binding.btnStart");
        ezy.p642a.View.m34750a(roundText, 0, new C3382c(this), 1, null);
        TextView textView = this.f11997a.f10486d;
        C8271i.m35382a((Object) textView, "binding.tvGetTicket");
        ezy.p642a.View.m34750a(textView, 0, new C3387d(this), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14577a(LuckDrawRsp luckDrawRsp, LuckPoolItem luckPoolItem) {
        LuckDrawRsp luckDrawRsp2;
        if (!this.f11999c.isFinishing() && !this.f11999c.isDestroyed()) {
            RoundText roundText = this.f11997a.f10483a;
            C8271i.m35382a((Object) roundText, "binding.btnStart");
            DialogLuckyDrawBinding dialogLuckyDrawBinding = this.f11997a;
            C8271i.m35382a((Object) dialogLuckyDrawBinding, "binding");
            LuckPoolRsp a = dialogLuckyDrawBinding.mo20128a();
            boolean z = false;
            RoundTextEx.m12837a(roundText, (a != null ? a.getTickets() : 0) > 0, (String) null, (String) null, 6, (Object) null);
            if (LuckPoolItemKt.isBox(luckPoolItem)) {
                Activity activity = this.f11999c;
                if (luckPoolItem.getImage() == 6) {
                    luckDrawRsp2 = luckDrawRsp;
                    z = true;
                } else {
                    luckDrawRsp2 = luckDrawRsp;
                }
                new CoinBoxDilaog(activity, luckDrawRsp2, z).show();
                return;
            }
            LuckDrawRsp luckDrawRsp3 = luckDrawRsp;
            if (LuckPoolItemKt.isHb(luckPoolItem)) {
                HbInformation hbInfo = luckDrawRsp.getHbInfo();
                if (hbInfo != null) {
                    Context context = getContext();
                    C8271i.m35382a((Object) context, "context");
                    StringBuilder sb = new StringBuilder();
                    sb.append("恭喜您获得红包(");
                    sb.append(hbInfo.getText());
                    sb.append(')');
                    C3325HB hb = new C3325HB(sb.toString(), null, "恭喜您开红包获得", null, 0, 4, 26, null);
                    new HbDilaog(context, hb, new C3380a(hbInfo)).show();
                    return;
                }
                return;
            }
            ResidentMemoryModel.f11323a.mo20733a(luckDrawRsp.getCoin(), 1);
            Object[] objArr = new Object[2];
            objArr[0] = "恭喜获得";
            String timeText = luckDrawRsp.getTimeText();
            if (timeText == null) {
                timeText = "";
            }
            objArr[1] = timeText;
            GetCoinItem getCoinItem = new GetCoinItem("", GloblaEx.m12814a(R.string.c66_and_orange, objArr), luckDrawRsp.getCoin(), luckDrawRsp.getAdIdInfoFlow(), false, 16, null);
            new GetCoinDilaog(this.f11999c, getCoinItem).show();
        }
    }

    /* renamed from: a */
    private final void m14582a(boolean z) {
        setCanceledOnTouchOutside(z);
    }

    /* renamed from: a */
    static /* synthetic */ void m14579a(LuckyDrawDilaog kVar, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        kVar.m14576a(i, z);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14576a(int i, boolean z) {
        DialogLuckyDrawBinding dialogLuckyDrawBinding = this.f11997a;
        String str = "binding";
        C8271i.m35382a((Object) dialogLuckyDrawBinding, str);
        LuckPoolRsp a = dialogLuckyDrawBinding.mo20128a();
        if (a != null) {
            LuckPoolRsp luckPoolRsp = new LuckPoolRsp(i, a.getDesc(), a.getPool());
            DialogLuckyDrawBinding dialogLuckyDrawBinding2 = this.f11997a;
            C8271i.m35382a((Object) dialogLuckyDrawBinding2, str);
            dialogLuckyDrawBinding2.mo20129a(luckPoolRsp);
            this.f11997a.executePendingBindings();
            if (z) {
                RoundText roundText = this.f11997a.f10483a;
                C8271i.m35382a((Object) roundText, "binding.btnStart");
                RoundTextEx.m12837a(roundText, i > 0, (String) null, (String) null, 6, (Object) null);
            }
        }
    }
}
