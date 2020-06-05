package com.jiayouya.travel.module.p276me.p279ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.databinding.ActivityBonusDogBinding;
import com.jiayouya.travel.module.common.p259ui.dialog.ShareDilaog;
import com.jiayouya.travel.module.main.p273ui.MainActivity;
import com.jiayouya.travel.module.main.p273ui.MainActivity.C3094a;
import com.jiayouya.travel.module.p276me.data.DogAnalysisRsp;
import com.jiayouya.travel.module.p276me.p279ui.dialog.MyBonusDogDialog;
import com.jiayouya.travel.module.p276me.p280vm.BonusDogVM;
import com.jiayouya.travel.module.p276me.widget.ScoreView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/BonusDogActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityBonusDogBinding;", "Lcom/jiayouya/travel/module/me/vm/BonusDogVM;", "()V", "fetchData", "", "isRefresh", "", "getLayoutId", "", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BonusDogActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.BonusDogActivity */
public final class BonusDogActivity extends BaseActivity<ActivityBonusDogBinding, BonusDogVM> {
    /* renamed from: c */
    private HashMap f11576c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BonusDogActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.BonusDogActivity$a */
    static final class C3118a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ BonusDogActivity this$0;

        C3118a(BonusDogActivity bonusDogActivity) {
            this.this$0 = bonusDogActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            new MyBonusDogDialog(this.this$0).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BonusDogActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.BonusDogActivity$b */
    static final class C3119b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ BonusDogActivity this$0;

        C3119b(BonusDogActivity bonusDogActivity) {
            this.this$0 = bonusDogActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            C3094a.m13887a(MainActivity.f11539c, this.this$0, null, 2, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BonusDogActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.BonusDogActivity$c */
    static final class C3120c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ BonusDogActivity this$0;

        C3120c(BonusDogActivity bonusDogActivity) {
            this.this$0 = bonusDogActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            new ShareDilaog(this.this$0, null, 2, null).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/data/DogAnalysisRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BonusDogActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.BonusDogActivity$d */
    static final class C3121d<T> implements Observer<DogAnalysisRsp> {
        /* renamed from: a */
        final /* synthetic */ BonusDogActivity f11577a;

        C3121d(BonusDogActivity bonusDogActivity) {
            this.f11577a = bonusDogActivity;
        }

        /* renamed from: a */
        public final void onChanged(DogAnalysisRsp dogAnalysisRsp) {
            BonusDogActivity.m13950a(this.f11577a).mo20079a(dogAnalysisRsp);
            List arrayList = new ArrayList();
            arrayList.add(Float.valueOf(dogAnalysisRsp.getCity().getPercent()));
            arrayList.add(Float.valueOf(dogAnalysisRsp.getAdFee().getPercent()));
            arrayList.add(Float.valueOf(dogAnalysisRsp.getInvite().getPercent()));
            arrayList.add(Float.valueOf(dogAnalysisRsp.getMerge().getPercent()));
            arrayList.add(Float.valueOf(dogAnalysisRsp.getAdVideo().getPercent()));
            ((ScoreView) this.f11577a.mo19852a(R.id.lyt_radar)).setScore(arrayList);
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11576c == null) {
            this.f11576c = new HashMap();
        }
        View view = (View) this.f11576c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11576c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_bonus_dog;
    }

    /* renamed from: h */
    public boolean mo19865h() {
        return true;
    }

    /* renamed from: i */
    public boolean mo19866i() {
        return true;
    }

    /* renamed from: a */
    public static final /* synthetic */ ActivityBonusDogBinding m13950a(BonusDogActivity bonusDogActivity) {
        return (ActivityBonusDogBinding) bonusDogActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<BonusDogVM> mo19861d() {
        return BonusDogVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        ScrollView scrollView = (ScrollView) mo19852a(R.id.scroll_view);
        C8271i.m35382a((Object) scrollView, "scroll_view");
        setupStatusView(scrollView);
        BaseActivity.m12847a(this, false, 1, null);
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((BonusDogVM) mo19853a()).mo21449c();
    }

    /* renamed from: k */
    public void mo19868k() {
        TextView textView = (TextView) mo19852a(R.id.tv_my_dog);
        C8271i.m35382a((Object) textView, "tv_my_dog");
        ezy.p642a.View.m34750a(textView, 0, new C3118a(this), 1, null);
        ImageView imageView = (ImageView) mo19852a(R.id.iv_promote_active);
        C8271i.m35382a((Object) imageView, "iv_promote_active");
        ezy.p642a.View.m34750a(imageView, 0, new C3119b(this), 1, null);
        ImageView imageView2 = (ImageView) mo19852a(R.id.iv_invite);
        C8271i.m35382a((Object) imageView2, "iv_invite");
        ezy.p642a.View.m34750a(imageView2, 0, new C3120c(this), 1, null);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        ((BonusDogVM) mo19853a()).mo21448b().observe(this, new C3121d(this));
    }
}
