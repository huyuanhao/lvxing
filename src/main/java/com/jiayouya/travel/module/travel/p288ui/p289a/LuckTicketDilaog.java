package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.common.p246d.AdExtra;
import com.jiayouya.travel.databinding.DialogLuckTicketBinding;
import com.jiayouya.travel.module.common.data.AdRsp;
import com.jiayouya.travel.module.common.data.AdRspKt;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.tencent.android.tpush.common.Constants;
import com.travel.adlibrary.AdSdk;
import com.travel.adlibrary.p612a.AdOptions;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/LuckTicketDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "activity", "Landroid/app/Activity;", "ad", "Lcom/jiayouya/travel/module/common/data/AdRsp;", "(Landroid/app/Activity;Lcom/jiayouya/travel/module/common/data/AdRsp;)V", "getActivity", "()Landroid/app/Activity;", "getAd", "()Lcom/jiayouya/travel/module/common/data/AdRsp;", "binding", "Lcom/jiayouya/travel/databinding/DialogLuckTicketBinding;", "kotlin.jvm.PlatformType", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.j */
public final class LuckTicketDilaog extends CustomDialog {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final DialogLuckTicketBinding f11994a = ((DialogLuckTicketBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_luck_ticket, null, false));
    /* renamed from: b */
    private final Activity f11995b;
    /* renamed from: c */
    private final AdRsp f11996c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LuckTicketDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.j$a */
    static final class C3377a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ LuckTicketDilaog this$0;

        C3377a(LuckTicketDilaog jVar) {
            this.this$0 = jVar;
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
    /* compiled from: LuckTicketDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.j$b */
    static final class C3378b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ LuckTicketDilaog this$0;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo39189d2 = {"<anonymous>", "", "userId", "", "invoke", "com/jiayouya/travel/module/travel/ui/dialog/LuckTicketDialog$setupClick$2$1$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: LuckTicketDilaog.kt */
        /* renamed from: com.jiayouya.travel.module.travel.ui.a.j$b$a */
        static final class C3379a extends Lambda implements C8247b<String, Unit> {
            final /* synthetic */ AdRsp $it;
            final /* synthetic */ C3378b this$0;

            C3379a(AdRsp adRsp, C3378b bVar) {
                this.$it = adRsp;
                this.this$0 = bVar;
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
                AdOptions aVar2 = new AdOptions(0, this.this$0.this$0.mo22276a(), this.$it.getAdIdVideo(), str2, null, 0, null, AdExtra.m12931a(this.$it.getAdLogId(), str2, (String) null, 4, (Object) null), 0.0f, AdRspKt.adVideoPlats(this.this$0.this$0.mo22277b()), 0, false, null, 7536, null);
                AdExtra.m12935a(this.$it.getAdLogId(), 0.0d);
                if (AdSdk.f25896a.mo37292a(aVar)) {
                    this.this$0.this$0.dismiss();
                }
            }
        }

        C3378b(LuckTicketDilaog jVar) {
            this.this$0 = jVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            DialogLuckTicketBinding a = this.this$0.f11994a;
            C8271i.m35382a((Object) a, "binding");
            AdRsp a2 = a.mo20126a();
            if (a2 != null) {
                ResidentMemoryModel.m13596a(ResidentMemoryModel.f11323a, (AppCompatActivity) null, (C8247b) new C3379a(a2, this), 1, (Object) null);
            }
        }
    }

    /* renamed from: a */
    public final Activity mo22276a() {
        return this.f11995b;
    }

    /* renamed from: b */
    public final AdRsp mo22277b() {
        return this.f11996c;
    }

    public LuckTicketDilaog(Activity activity, AdRsp adRsp) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        C8271i.m35386b(adRsp, "ad");
        super(activity);
        this.f11995b = activity;
        this.f11996c = adRsp;
        DialogLuckTicketBinding dialogLuckTicketBinding = this.f11994a;
        C8271i.m35382a((Object) dialogLuckTicketBinding, "binding");
        setView(dialogLuckTicketBinding.getRoot());
        m14572d();
        m14571c();
    }

    /* renamed from: c */
    private final void m14571c() {
        setDimAmount(0.7f);
        DialogLuckTicketBinding dialogLuckTicketBinding = this.f11994a;
        String str = "binding";
        C8271i.m35382a((Object) dialogLuckTicketBinding, str);
        View root = dialogLuckTicketBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
        DialogLuckTicketBinding dialogLuckTicketBinding2 = this.f11994a;
        C8271i.m35382a((Object) dialogLuckTicketBinding2, str);
        dialogLuckTicketBinding2.mo20127a(this.f11996c);
        RoundLayout roundLayout = this.f11994a.f10475a;
        C8271i.m35382a((Object) roundLayout, "binding.btn");
        RoundTextEx.m12835a(roundLayout, this.f11996c.getAdNumVideo() > 0, (String) null, (String) null, 6, (Object) null);
    }

    /* renamed from: d */
    private final void m14572d() {
        ImageView imageView = this.f11994a.f10476b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3377a(this), 1, null);
        RoundLayout roundLayout = this.f11994a.f10475a;
        C8271i.m35382a((Object) roundLayout, "binding.btn");
        ezy.p642a.View.m34750a(roundLayout, 0, new C3378b(this), 1, null);
    }
}
