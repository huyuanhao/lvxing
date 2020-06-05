package com.jiayouya.travel.module.p276me.p279ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jakewharton.rxbinding2.p241a.RxTextView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.databinding.DialogBindInviterBinding;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p257a.C2962j;
import com.jiayouya.travel.module.common.p257a.UserService;
import com.jiayouya.travel.module.p276me.p278b.BindInviterEvent;
import ezy.app.p643a.API;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p642a.TextView;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0003R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/dialog/BindInviterDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "isMustBind", "", "(Landroid/content/Context;Z)V", "binding", "Lcom/jiayouya/travel/databinding/DialogBindInviterBinding;", "kotlin.jvm.PlatformType", "setupClick", "", "setupObserve", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.me.ui.dialog.a */
public final class BindInviterDilaog extends CustomDialog {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final DialogBindInviterBinding f11658a;
    /* renamed from: b */
    private final boolean f11659b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BindInviterDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.a$a */
    static final class C3203a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ BindInviterDilaog this$0;

        C3203a(BindInviterDilaog aVar) {
            this.this$0 = aVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            UserService a = C2962j.m13561a(API.f27251a);
            EditText editText = this.this$0.f11658a.f10267b;
            C8271i.m35382a((Object) editText, "binding.editCode");
            Observable c = a.mo20427c(TextView.m34747a(editText));
            DialogBindInviterBinding a2 = this.this$0.f11658a;
            C8271i.m35382a((Object) a2, "binding");
            View root = a2.getRoot();
            C8271i.m35382a((Object) root, "binding.root");
            C8019a.m34776a(c, root).mo37374a(new Consumer<User>(this) {
                /* renamed from: a */
                final /* synthetic */ C3203a f11660a;

                {
                    this.f11660a = r1;
                }

                /* renamed from: a */
                public final void accept(User user) {
                    Dialog dialog = this.f11660a.this$0;
                    C8271i.m35382a((Object) user, "it");
                    EditText editText = this.f11660a.this$0.f11658a.f10267b;
                    C8271i.m35382a((Object) editText, "binding.editCode");
                    new InviterHintDilaog(dialog, user, TextView.m34747a(editText)).show();
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BindInviterDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.a$b */
    static final class C3205b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ BindInviterDilaog this$0;

        C3205b(BindInviterDilaog aVar) {
            this.this$0 = aVar;
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
    /* compiled from: BindInviterDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.a$c */
    static final class C3206c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ BindInviterDilaog this$0;

        C3206c(BindInviterDilaog aVar) {
            this.this$0 = aVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            EditText editText = this.this$0.f11658a.f10267b;
            editText.setText("10001");
            editText.setSelection(editText.getText().length());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/event/BindInviterEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BindInviterDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.a$d */
    static final class C3207d<T> implements Consumer<BindInviterEvent> {
        /* renamed from: a */
        final /* synthetic */ BindInviterDilaog f11661a;

        C3207d(BindInviterDilaog aVar) {
            this.f11661a = aVar;
        }

        /* renamed from: a */
        public final void accept(BindInviterEvent bVar) {
            this.f11661a.dismiss();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BindInviterDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.a$e */
    static final class C3208e<T> implements Consumer<CharSequence> {
        /* renamed from: a */
        final /* synthetic */ BindInviterDilaog f11662a;

        C3208e(BindInviterDilaog aVar) {
            this.f11662a = aVar;
        }

        /* renamed from: a */
        public final void accept(CharSequence charSequence) {
            RoundText roundText = this.f11662a.f11658a.f10266a;
            C8271i.m35382a((Object) roundText, "binding.btn");
            boolean z = charSequence == null || charSequence.length() == 0;
            RoundTextEx.m12837a(roundText, !z, (String) null, (String) null, 6, (Object) null);
        }
    }

    public /* synthetic */ BindInviterDilaog(Context context, boolean z, int i, DefaultConstructorMarker fVar) {
        if ((i & 2) != 0) {
            z = false;
        }
        this(context, z);
    }

    public BindInviterDilaog(Context context, boolean z) {
        C8271i.m35386b(context, "context");
        super(context);
        this.f11659b = z;
        this.f11658a = (DialogBindInviterBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_bind_inviter, null, false);
        DialogBindInviterBinding dialogBindInviterBinding = this.f11658a;
        C8271i.m35382a((Object) dialogBindInviterBinding, "binding");
        setView(dialogBindInviterBinding.getRoot());
        m14142c();
        m14141b();
        m14140a();
    }

    /* renamed from: a */
    private final void m14140a() {
        Observable a = RxBus.f27263a.mo38571a(BindInviterEvent.class);
        DialogBindInviterBinding dialogBindInviterBinding = this.f11658a;
        C8271i.m35382a((Object) dialogBindInviterBinding, "binding");
        View root = dialogBindInviterBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        C8019a.m34776a(a, root).mo37374a(new C3207d(this));
    }

    /* renamed from: b */
    private final void m14141b() {
        setDimAmount(0.7f);
        DialogBindInviterBinding dialogBindInviterBinding = this.f11658a;
        String str = "binding";
        C8271i.m35382a((Object) dialogBindInviterBinding, str);
        View root = dialogBindInviterBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(260.0f);
        RxTextView.m12726a(this.f11658a.f10267b).mo38904c((Consumer<? super T>) new C3208e<Object>(this));
        setCancelable(!this.f11659b);
        setCanceledOnTouchOutside(!this.f11659b);
        DialogBindInviterBinding dialogBindInviterBinding2 = this.f11658a;
        C8271i.m35382a((Object) dialogBindInviterBinding2, str);
        dialogBindInviterBinding2.mo20105a(this.f11659b);
    }

    /* renamed from: c */
    private final void m14142c() {
        RoundText roundText = this.f11658a.f10266a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3203a(this), 1, null);
        ImageView imageView = this.f11658a.f10268c;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3205b(this), 1, null);
        android.widget.TextView textView = this.f11658a.f10269d;
        C8271i.m35382a((Object) textView, "binding.tvNoCode");
        ezy.p642a.View.m34750a(textView, 0, new C3206c(this), 1, null);
    }
}
