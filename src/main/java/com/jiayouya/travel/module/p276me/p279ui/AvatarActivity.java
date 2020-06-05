package com.jiayouya.travel.module.p276me.p279ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p246d.FileUtil;
import com.jiayouya.travel.databinding.ActivityAvatarBinding;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.p276me.p278b.AvatarEvent;
import com.jiayouya.travel.module.p276me.p279ui.dialog.ChangeAvatarDialog;
import com.jiayouya.travel.module.p276me.p280vm.AvatarVM;
import com.yanzhenjie.durban.Durban;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/AvatarActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityAvatarBinding;", "Lcom/jiayouya/travel/module/me/vm/AvatarVM;", "()V", "getLayoutId", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AvatarActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.AvatarActivity */
public final class AvatarActivity extends BaseActivity<ActivityAvatarBinding, AvatarVM> {
    /* renamed from: c */
    private HashMap f11570c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AvatarActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.AvatarActivity$a */
    static final class C3113a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ AvatarActivity this$0;

        C3113a(AvatarActivity avatarActivity) {
            this.this$0 = avatarActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            new ChangeAvatarDialog(this.this$0).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/User;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AvatarActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.AvatarActivity$b */
    static final class C3114b<T> implements Observer<User> {
        /* renamed from: a */
        final /* synthetic */ AvatarActivity f11571a;

        C3114b(AvatarActivity avatarActivity) {
            this.f11571a = avatarActivity;
        }

        /* renamed from: a */
        public final void onChanged(User user) {
            Glide.m5171a((FragmentActivity) this.f11571a).mo12591a(user.getAvatar()).mo12582a((ImageView) this.f11571a.mo19852a(R.id.iv_avatar));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/event/AvatarEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AvatarActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.AvatarActivity$c */
    static final class C3115c<T> implements Consumer<AvatarEvent> {
        /* renamed from: a */
        final /* synthetic */ AvatarActivity f11572a;

        C3115c(AvatarActivity avatarActivity) {
            this.f11572a = avatarActivity;
        }

        /* renamed from: a */
        public final void accept(AvatarEvent aVar) {
            Durban.m33762a((Activity) this.f11572a).mo37793a(aVar.mo21214a()).mo37792a(FileUtil.m12957a(this.f11572a).getAbsolutePath()).mo37791a(400, 400).mo37789a(1.0f, 1.0f).mo37794b(0).mo37796c(75).mo37790a(3).mo37797d(167).mo37795b();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AvatarActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.AvatarActivity$d */
    static final class C3116d<T> implements Observer<Object> {
        /* renamed from: a */
        public static final C3116d f11573a = new C3116d();

        C3116d() {
        }

        public final void onChanged(Object obj) {
            GloblaEx.m12816a("设置成功", 0, 0, 6, null);
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11570c == null) {
            this.f11570c = new HashMap();
        }
        View view = (View) this.f11570c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11570c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_avatar;
    }

    /* renamed from: d */
    public Class<AvatarVM> mo19861d() {
        return AvatarVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        mo19856a(false);
    }

    /* renamed from: k */
    public void mo19868k() {
        ImageView imageView = (ImageView) mo19852a(R.id.iv_title_right);
        C8271i.m35382a((Object) imageView, "iv_title_right");
        ezy.p642a.View.m34750a(imageView, 0, new C3113a(this), 1, null);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        ResidentMemoryModel.f11323a.mo20737b().observe(lifecycleOwner, new C3114b(this));
        C8019a.m34778a(RxBus.f27263a.mo38571a(AvatarEvent.class), lifecycleOwner, null, 2, null).mo37374a(new C3115c(this));
        ((AvatarVM) mo19853a()).mo21443b().observe(lifecycleOwner, C3116d.f11573a);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null && i == 167) {
            String str = (String) Durban.m33764a(intent).get(0);
            Glide.m5171a((FragmentActivity) this).mo12591a(str).mo12582a((ImageView) mo19852a(R.id.iv_avatar));
            AvatarVM avatarVM = (AvatarVM) mo19853a();
            C8271i.m35382a((Object) str, "path");
            avatarVM.mo21442a(str);
        }
    }
}
