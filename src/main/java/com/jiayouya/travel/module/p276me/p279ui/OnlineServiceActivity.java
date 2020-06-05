package com.jiayouya.travel.module.p276me.p279ui;

import android.view.View;
import android.widget.ImageView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p244b.ViewEx;
import com.jiayouya.travel.common.p246d.FileUtil;
import com.jiayouya.travel.common.p246d.ImageUtil;
import com.jiayouya.travel.databinding.ActivityOnlineServiceBinding;
import com.jiayouya.travel.module.p276me.p280vm.OnlineServiceVM;
import ezy.p642a.Context;
import ezy.p653ui.widget.round.RoundText;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/OnlineServiceActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityOnlineServiceBinding;", "Lcom/jiayouya/travel/module/me/vm/OnlineServiceVM;", "()V", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: OnlineServiceActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.OnlineServiceActivity */
public final class OnlineServiceActivity extends BaseActivity<ActivityOnlineServiceBinding, OnlineServiceVM> {
    /* renamed from: c */
    private HashMap f11621c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: OnlineServiceActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.OnlineServiceActivity$a */
    static final class C3163a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ OnlineServiceActivity this$0;

        C3163a(OnlineServiceActivity onlineServiceActivity) {
            this.this$0 = onlineServiceActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            File file = new File(FileUtil.m12957a(this.this$0), "online_server_qrcode.jpeg");
            ImageView imageView = (ImageView) this.this$0.mo19852a(R.id.iv_qr_code);
            C8271i.m35382a((Object) imageView, "iv_qr_code");
            ImageUtil.m12961a(ViewEx.m12839a(imageView), file, 307200);
            Context.m34744a(this.this$0, "保存成功", 0, 0, 6, null);
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11621c == null) {
            this.f11621c = new HashMap();
        }
        View view = (View) this.f11621c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11621c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_online_service;
    }

    /* renamed from: d */
    public Class<OnlineServiceVM> mo19861d() {
        return OnlineServiceVM.class;
    }

    /* renamed from: k */
    public void mo19868k() {
        RoundText roundText = (RoundText) mo19852a(R.id.btn);
        C8271i.m35382a((Object) roundText, "btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3163a(this), 1, null);
    }
}
