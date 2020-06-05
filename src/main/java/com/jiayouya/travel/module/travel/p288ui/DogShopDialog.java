package com.jiayouya.travel.module.travel.p288ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.OnItemClickListener;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p245c.PreferenceRes;
import com.jiayouya.travel.databinding.DialogDogShopBinding;
import com.jiayouya.travel.databinding.ItemDogShopBinding;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.travel.data.BuyDogRsp;
import com.jiayouya.travel.module.travel.data.DogShopItem;
import com.jiayouya.travel.module.travel.p285a.C3324d;
import com.jiayouya.travel.module.travel.p285a.GameService.C3323a;
import com.jiayouya.travel.module.travel.p287c.GoldUtil;
import ezy.app.p643a.API;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import ezy.p653ui.widget.recyclerview.decoration.HorizontalDividerItemDecoration.Builder;
import java.util.List;
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

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \r*\u0004\u0018\u00010\u00190\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/DogShopDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "Landroidx/lifecycle/LifecycleOwner;", "context", "Landroid/content/Context;", "list", "", "Lcom/jiayouya/travel/module/travel/data/DogShopItem;", "(Landroid/content/Context;Ljava/util/List;)V", "adapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "binding", "Lcom/jiayouya/travel/databinding/DialogDogShopBinding;", "getBinding", "()Lcom/jiayouya/travel/databinding/DialogDogShopBinding;", "binding$delegate", "Lkotlin/Lazy;", "getList", "()Ljava/util/List;", "mLifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "prefs", "Landroid/content/SharedPreferences;", "buy", "", "position", "", "getLastRecordPosition", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "savePosition", "setupClick", "setupObserver", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DogShopDialog.kt */
/* renamed from: com.jiayouya.travel.module.travel.ui.DogShopDialog */
public final class DogShopDialog extends CustomDialog implements LifecycleOwner {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f11912a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(DogShopDialog.class), "binding", "getBinding()Lcom/jiayouya/travel/databinding/DialogDogShopBinding;"))};
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final LifecycleRegistry f11913b = new LifecycleRegistry(this);
    /* renamed from: c */
    private final Lazy f11914c = C8182c.m35317a(new C3326a(this));
    /* renamed from: d */
    private final BindingType f11915d = BindingType.create(DogShopItem.class, (int) R.layout.item_dog_shop);
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final SingleTypeAdapter<DogShopItem> f11916e = new SingleTypeAdapter<>(this.f11915d);
    /* renamed from: f */
    private final SharedPreferences f11917f;
    /* renamed from: g */
    private final List<DogShopItem> f11918g;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "Lcom/jiayouya/travel/databinding/DialogDogShopBinding;", "kotlin.jvm.PlatformType", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DogShopDialog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.DogShopDialog$a */
    static final class C3326a extends Lambda implements C8246a<DialogDogShopBinding> {
        final /* synthetic */ DogShopDialog this$0;

        C3326a(DogShopDialog dogShopDialog) {
            this.this$0 = dogShopDialog;
            super(0);
        }

        public final DialogDogShopBinding invoke() {
            return (DialogDogShopBinding) DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.dialog_dog_shop, null, false);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/BuyDogRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DogShopDialog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.DogShopDialog$b */
    static final class C3327b<T> implements Consumer<BuyDogRsp> {
        /* renamed from: a */
        final /* synthetic */ DogShopDialog f11919a;
        /* renamed from: b */
        final /* synthetic */ int f11920b;
        /* renamed from: c */
        final /* synthetic */ DogShopItem f11921c;

        C3327b(DogShopDialog dogShopDialog, int i, DogShopItem dogShopItem) {
            this.f11919a = dogShopDialog;
            this.f11920b = i;
            this.f11921c = dogShopItem;
        }

        /* renamed from: a */
        public final void accept(BuyDogRsp buyDogRsp) {
            this.f11919a.m14462b(this.f11920b);
            if (buyDogRsp.getPosition() == null && buyDogRsp.getSuggest() == null) {
                this.f11919a.dismiss();
            } else {
                DogShopItem dogShopItem = this.f11921c;
                dogShopItem.setBuyNum(dogShopItem.getBuyNum() + 1);
                this.f11919a.f11916e.notifyItemChanged(this.f11920b);
                GloblaEx.m12816a("购买成功", 0, 0, 6, null);
            }
            RxBus bVar = RxBus.f27263a;
            C8271i.m35382a((Object) buyDogRsp, "it");
            bVar.mo38572a((Object) buyDogRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DogShopDialog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.DogShopDialog$c */
    static final class C3328c implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ DogShopDialog f11922a;

        C3328c(DogShopDialog dogShopDialog) {
            this.f11922a = dogShopDialog;
        }

        /* renamed from: a */
        public final void mo19912a(View view, int i, long j) {
            this.f11922a.m14458a(i);
            final ItemDogShopBinding itemDogShopBinding = (ItemDogShopBinding) DataBindingUtil.getBinding(view);
            if (itemDogShopBinding != null) {
                C8271i.m35382a((Object) itemDogShopBinding, "DataBindingUtil.getBindi… ?: return@setOnItemClick");
                itemDogShopBinding.f10962a.animate().scaleX(1.2f).scaleY(1.2f).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        itemDogShopBinding.f10962a.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).setListener(null).start();
                    }
                }).start();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DogShopDialog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.DogShopDialog$d */
    static final class C3330d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ DogShopDialog this$0;

        C3330d(DogShopDialog dogShopDialog) {
            this.this$0 = dogShopDialog;
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

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Double;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DogShopDialog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.DogShopDialog$e */
    static final class C3331e<T> implements Observer<Double> {
        /* renamed from: a */
        final /* synthetic */ DogShopDialog f11924a;

        C3331e(DogShopDialog dogShopDialog) {
            this.f11924a = dogShopDialog;
        }

        /* renamed from: a */
        public final void onChanged(Double d) {
            TextView textView = this.f11924a.m14457a().f10351c;
            C8271i.m35382a((Object) textView, "binding.tvIcon");
            GoldUtil aVar = GoldUtil.f11900a;
            C8271i.m35382a((Object) d, "it");
            textView.setText(aVar.mo21651a(d.doubleValue()));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DogShopDialog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.DogShopDialog$f */
    static final class C3332f implements OnDismissListener {
        /* renamed from: a */
        final /* synthetic */ DogShopDialog f11925a;

        C3332f(DogShopDialog dogShopDialog) {
            this.f11925a = dogShopDialog;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f11925a.f11913b.handleLifecycleEvent(Event.ON_DESTROY);
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final DialogDogShopBinding m14457a() {
        Lazy bVar = this.f11914c;
        C8280j jVar = f11912a[0];
        return (DialogDogShopBinding) bVar.getValue();
    }

    public DogShopDialog(Context context, List<DogShopItem> list) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(list, "list");
        super(context);
        this.f11918g = list;
        this.f11917f = PreferenceManager.getDefaultSharedPreferences(context);
        this.f11913b.handleLifecycleEvent(Event.ON_START);
        setDimAmount(0.7f);
        DialogDogShopBinding a = m14457a();
        C8271i.m35382a((Object) a, "binding");
        setView(a.getRoot());
        m14461b();
        m14466d();
        m14465c();
    }

    public Lifecycle getLifecycle() {
        return this.f11913b;
    }

    /* renamed from: b */
    private final void m14461b() {
        RecyclerView recyclerView = m14457a().f10350b;
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(this.f11916e);
        recyclerView.addItemDecoration(((Builder) new Builder(recyclerView.getContext()).drawable((int) R.drawable.divider)).margin(dp2px(15.0f)).build());
        this.f11916e.setItems(this.f11918g);
        setOnDismissListener(new C3332f(this));
        int e = m14467e();
        int size = this.f11918g.size();
        if (e >= 0 && size > e) {
            m14457a().f10350b.scrollToPosition(e);
        }
    }

    /* renamed from: c */
    private final void m14465c() {
        ResidentMemoryModel.f11323a.mo20732a().observe(this, new C3331e(this));
    }

    /* renamed from: d */
    private final void m14466d() {
        this.f11915d.setOnItemClick(new C3328c(this));
        ImageView imageView = m14457a().f10349a;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3330d(this), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14458a(int i) {
        DogShopItem dogShopItem = (DogShopItem) this.f11916e.getItem(i);
        Observable a = C3323a.m14442a(C3324d.m14443a(API.f27251a), dogShopItem.getDogId(), null, 2, null);
        DialogDogShopBinding a2 = m14457a();
        C8271i.m35382a((Object) a2, "binding");
        View root = a2.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        C8019a.m34776a(a, root).mo37374a(new C3327b(this, i, dogShopItem));
    }

    /* renamed from: e */
    private final int m14467e() {
        SharedPreferences sharedPreferences = this.f11917f;
        StringBuilder sb = new StringBuilder();
        sb.append(PreferenceRes.f9605b.mo19920a().uid());
        sb.append("-shopPosition");
        return sharedPreferences.getInt(sb.toString(), -1);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final void m14462b(int i) {
        Editor edit = this.f11917f.edit();
        StringBuilder sb = new StringBuilder();
        sb.append(PreferenceRes.f9605b.mo19920a().uid());
        sb.append("-shopPosition");
        edit.putInt(sb.toString(), i).apply();
    }
}
