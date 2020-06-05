package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.common.p246d.AdExtra;
import com.jiayouya.travel.databinding.DialogCoinBoxBinding;
import com.jiayouya.travel.module.common.data.AdRsp;
import com.jiayouya.travel.module.common.data.AdRspKt;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.travel.data.LuckDrawRsp;
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

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/CoinBoxDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "activity", "Landroid/app/Activity;", "item", "Lcom/jiayouya/travel/module/travel/data/LuckDrawRsp;", "isGold", "", "(Landroid/app/Activity;Lcom/jiayouya/travel/module/travel/data/LuckDrawRsp;Z)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/jiayouya/travel/databinding/DialogCoinBoxBinding;", "kotlin.jvm.PlatformType", "()Z", "loadVideoAd", "", "setupClick", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.b */
public final class CoinBoxDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogCoinBoxBinding f11945a = ((DialogCoinBoxBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_coin_box, null, false));
    /* renamed from: b */
    private final Activity f11946b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final LuckDrawRsp f11947c;
    /* renamed from: d */
    private final boolean f11948d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo39189d2 = {"<anonymous>", "", "userId", "", "invoke", "com/jiayouya/travel/module/travel/ui/dialog/CoinBoxDialog$loadVideoAd$1$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoinBoxDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.b$a */
    static final class C3345a extends Lambda implements C8247b<String, Unit> {
        final /* synthetic */ AdRsp $ad;
        final /* synthetic */ CoinBoxDilaog this$0;

        C3345a(AdRsp adRsp, CoinBoxDilaog bVar) {
            this.$ad = adRsp;
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
            AdOptions aVar2 = new AdOptions(0, this.this$0.mo22242a(), this.$ad.getAdIdVideo(), str2, null, 0, null, AdExtra.m12931a(this.$ad.getAdLogId(), str2, (String) null, 4, (Object) null), 0.0f, AdRspKt.adVideoPlats(this.$ad), 0, false, null, 7536, null);
            AdExtra.m12935a(this.$ad.getAdLogId(), this.this$0.f11947c.getCoin());
            if (AdSdk.f25896a.mo37292a(aVar)) {
                this.this$0.dismiss();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoinBoxDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.b$b */
    static final class C3346b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ CoinBoxDilaog this$0;

        C3346b(CoinBoxDilaog bVar) {
            this.this$0 = bVar;
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
    /* compiled from: CoinBoxDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.b$c */
    static final class C3347c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ CoinBoxDilaog this$0;

        C3347c(CoinBoxDilaog bVar) {
            this.this$0 = bVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.m14512d();
        }
    }

    /* renamed from: a */
    public final Activity mo22242a() {
        return this.f11946b;
    }

    public CoinBoxDilaog(Activity activity, LuckDrawRsp luckDrawRsp, boolean z) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        C8271i.m35386b(luckDrawRsp, "item");
        super(activity);
        this.f11946b = activity;
        this.f11947c = luckDrawRsp;
        this.f11948d = z;
        DialogCoinBoxBinding dialogCoinBoxBinding = this.f11945a;
        C8271i.m35382a((Object) dialogCoinBoxBinding, "binding");
        setView(dialogCoinBoxBinding.getRoot());
        m14511c();
        m14510b();
    }

    /* renamed from: b */
    private final void m14510b() {
        setDimAmount(0.7f);
        DialogCoinBoxBinding dialogCoinBoxBinding = this.f11945a;
        String str = "binding";
        C8271i.m35382a((Object) dialogCoinBoxBinding, str);
        View root = dialogCoinBoxBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
        RoundLayout roundLayout = this.f11945a.f10308a;
        C8271i.m35382a((Object) roundLayout, "binding.btn");
        AdRsp adInfo = this.f11947c.getAdInfo();
        boolean z = false;
        if ((adInfo != null ? adInfo.getAdNumVideo() : 0) > 0) {
            z = true;
        }
        RoundTextEx.m12835a(roundLayout, z, (String) null, (String) null, 6, (Object) null);
        DialogCoinBoxBinding dialogCoinBoxBinding2 = this.f11945a;
        C8271i.m35382a((Object) dialogCoinBoxBinding2, str);
        dialogCoinBoxBinding2.mo20109a(this.f11948d);
        DialogCoinBoxBinding dialogCoinBoxBinding3 = this.f11945a;
        C8271i.m35382a((Object) dialogCoinBoxBinding3, str);
        dialogCoinBoxBinding3.mo20108a(this.f11947c.getAdInfo());
    }

    /* renamed from: c */
    private final void m14511c() {
        ImageView imageView = this.f11945a.f10309b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3346b(this), 1, null);
        RoundLayout roundLayout = this.f11945a.f10308a;
        C8271i.m35382a((Object) roundLayout, "binding.btn");
        ezy.p642a.View.m34750a(roundLayout, 0, new C3347c(this), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final void m14512d() {
        AdRsp adInfo = this.f11947c.getAdInfo();
        if (adInfo != null) {
            ResidentMemoryModel.m13596a(ResidentMemoryModel.f11323a, (AppCompatActivity) null, (C8247b) new C3345a(adInfo, this), 1, (Object) null);
        }
    }
}
