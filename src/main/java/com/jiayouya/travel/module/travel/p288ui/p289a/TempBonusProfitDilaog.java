package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.DialogTempBonusProfitBinding;
import com.jiayouya.travel.module.travel.data.LuckDog;
import com.jiayouya.travel.module.travel.p285a.C3324d;
import ezy.app.p643a.API;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/TempBonusProfitDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "item", "Lcom/jiayouya/travel/module/travel/data/LuckDog;", "(Landroid/content/Context;Lcom/jiayouya/travel/module/travel/data/LuckDog;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogTempBonusProfitBinding;", "kotlin.jvm.PlatformType", "getItem", "()Lcom/jiayouya/travel/module/travel/data/LuckDog;", "claimProfit", "", "dismiss", "setupClick", "setupView", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.r */
public final class TempBonusProfitDilaog extends CustomDialog {
    /* renamed from: a */
    public static final C3415a f12040a = new C3415a(null);
    /* access modifiers changed from: private|static|final */
    /* renamed from: d */
    public static final List<Integer> f12041d = new ArrayList();
    /* renamed from: b */
    private final DialogTempBonusProfitBinding f12042b = ((DialogTempBonusProfitBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_temp_bonus_profit, null, false));
    /* renamed from: c */
    private final LuckDog f12043c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/TempBonusProfitDialog$Companion;", "", "()V", "idList", "", "", "getIdList", "()Ljava/util/List;", "isAlreadyExist", "", "item", "Lcom/jiayouya/travel/module/travel/data/LuckDog;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TempBonusProfitDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.r$a */
    public static final class C3415a {
        private C3415a() {
        }

        public /* synthetic */ C3415a(DefaultConstructorMarker fVar) {
            this();
        }

        /* renamed from: a */
        public final List<Integer> mo22323a() {
            return TempBonusProfitDilaog.f12041d;
        }

        /* renamed from: a */
        public final boolean mo22324a(LuckDog luckDog) {
            C8271i.m35386b(luckDog, "item");
            Iterator it = mo22323a().iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (luckDog.getId() == ((Number) it.next()).intValue()) {
                    break;
                }
                i++;
            }
            if (i != -1) {
                return true;
            }
            return false;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TempBonusProfitDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.r$b */
    static final class C3416b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TempBonusProfitDilaog this$0;

        C3416b(TempBonusProfitDilaog rVar) {
            this.this$0 = rVar;
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
    /* compiled from: TempBonusProfitDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.r$c */
    static final class C3417c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TempBonusProfitDilaog this$0;

        C3417c(TempBonusProfitDilaog rVar) {
            this.this$0 = rVar;
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
    /* compiled from: TempBonusProfitDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.r$d */
    static final class C3418d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TempBonusProfitDilaog this$0;

        C3418d(TempBonusProfitDilaog rVar) {
            this.this$0 = rVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.dismiss();
            Router.m12969a(Router.f9644a, "/me/bonusDetail", null, null, 6, null);
        }
    }

    public TempBonusProfitDilaog(Context context, LuckDog luckDog) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(luckDog, "item");
        super(context);
        this.f12043c = luckDog;
        DialogTempBonusProfitBinding dialogTempBonusProfitBinding = this.f12042b;
        C8271i.m35382a((Object) dialogTempBonusProfitBinding, "binding");
        setView(dialogTempBonusProfitBinding.getRoot());
        m14638c();
        m14637b();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        f12041d.add(Integer.valueOf(this.f12043c.getId()));
    }

    /* renamed from: b */
    private final void m14637b() {
        setDimAmount(0.7f);
        DialogTempBonusProfitBinding dialogTempBonusProfitBinding = this.f12042b;
        String str = "binding";
        C8271i.m35382a((Object) dialogTempBonusProfitBinding, str);
        View root = dialogTempBonusProfitBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
        DialogTempBonusProfitBinding dialogTempBonusProfitBinding2 = this.f12042b;
        C8271i.m35382a((Object) dialogTempBonusProfitBinding2, str);
        dialogTempBonusProfitBinding2.mo20144a(this.f12043c);
    }

    /* renamed from: c */
    private final void m14638c() {
        ImageView imageView = this.f12042b.f10667b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3416b(this), 1, null);
        RoundText roundText = this.f12042b.f10666a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3417c(this), 1, null);
        TextView textView = this.f12042b.f10668c;
        C8271i.m35382a((Object) textView, "binding.tvBonusDog");
        ezy.p642a.View.m34750a(textView, 0, new C3418d(this), 1, null);
    }

    public void dismiss() {
        super.dismiss();
        m14639d();
        f12041d.remove(Integer.valueOf(this.f12043c.getId()));
    }

    /* renamed from: d */
    private final void m14639d() {
        C3324d.m14443a(API.f27251a).mo21638d(this.f12043c.getId()).mo38910i();
    }
}
