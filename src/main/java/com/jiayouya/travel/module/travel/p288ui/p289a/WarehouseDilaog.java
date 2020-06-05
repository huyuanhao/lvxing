package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.OnItemClickListener;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.common.p244b.ViewEx;
import com.jiayouya.travel.databinding.DialogWarehouseBinding;
import com.jiayouya.travel.module.travel.data.BagInfo;
import com.jiayouya.travel.module.travel.data.BagItem;
import com.jiayouya.travel.module.travel.data.ExpandBag;
import com.jiayouya.travel.module.travel.p286b.DogPickOutEvent;
import com.tencent.android.tpush.common.Constants;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import ezy.p653ui.widget.recyclerview.decoration.HorizontalDividerItemDecoration.Builder;
import ezy.p653ui.widget.round.RoundText;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001BF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\u0010J\u0019\u0010 \u001a\u00020\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\"J\u0012\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\u000fH\u0002J\b\u0010&\u001a\u00020\u000fH\u0002J\b\u0010'\u001a\u00020\u000fH\u0002J\b\u0010(\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u001a0\u001aX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR,\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006)"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/WarehouseDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "activity", "Landroid/app/Activity;", "item", "Lcom/jiayouya/travel/module/travel/data/BagInfo;", "isCanPickOut", "Lkotlin/Function0;", "", "pickOutAction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "dogId", "", "(Landroid/app/Activity;Lcom/jiayouya/travel/module/travel/data/BagInfo;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroid/app/Activity;", "adapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "Lcom/jiayouya/travel/module/travel/data/BagItem;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "binding", "Lcom/jiayouya/travel/databinding/DialogWarehouseBinding;", "()Lkotlin/jvm/functions/Function0;", "getItem", "()Lcom/jiayouya/travel/module/travel/data/BagInfo;", "getPickOutAction", "()Lkotlin/jvm/functions/Function1;", "setBtnEnable", "isSelected", "(Ljava/lang/Boolean;)V", "setCapacity", "isPickOut", "setStatusView", "setupClick", "setupObserve", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.t */
public final class WarehouseDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogWarehouseBinding f12047a = ((DialogWarehouseBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_warehouse, null, false));
    /* renamed from: b */
    private final BindingType f12048b = BindingType.create(BagItem.class, (int) R.layout.item_warehouse);
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final SingleTypeAdapter<BagItem> f12049c = new SingleTypeAdapter<>(this.f12048b);
    /* renamed from: d */
    private final Activity f12050d;
    /* renamed from: e */
    private final BagInfo f12051e;
    /* renamed from: f */
    private final C8246a<Boolean> f12052f;
    /* renamed from: g */
    private final C8247b<Integer, Unit> f12053g;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: WarehouseDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.t$a */
    static final class C3421a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ WarehouseDilaog this$0;

        C3421a(WarehouseDilaog tVar) {
            this.this$0 = tVar;
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
    /* compiled from: WarehouseDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.t$b */
    static final class C3422b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ WarehouseDilaog this$0;

        C3422b(WarehouseDilaog tVar) {
            this.this$0 = tVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            List items = this.this$0.f12049c.getItems();
            C8271i.m35382a((Object) items, "adapter.items");
            Iterator it = items.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (((BagItem) it.next()).isSelected()) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                this.this$0.mo22333c().invoke(Integer.valueOf(((BagItem) this.this$0.f12049c.getItem(i)).getDogId()));
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: WarehouseDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.t$c */
    static final class C3423c implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ WarehouseDilaog f12054a;

        C3423c(WarehouseDilaog tVar) {
            this.f12054a = tVar;
        }

        /* renamed from: a */
        public final void mo19912a(View view, int i, long j) {
            this.f12054a.m14650a(Boolean.valueOf(true));
            List items = this.f12054a.f12049c.getItems();
            C8271i.m35382a((Object) items, "adapter.items");
            int i2 = 0;
            for (Object next : items) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    C8187k.m35272b();
                }
                ((BagItem) next).setSelected(i2 == i);
                i2 = i3;
            }
            this.f12054a.f12049c.notifyDataSetChanged();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: WarehouseDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.t$d */
    static final class C3424d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ WarehouseDilaog this$0;

        C3424d(WarehouseDilaog tVar) {
            this.this$0 = tVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            if (!this.this$0.mo22331a().isFinishing() && !this.this$0.mo22331a().isDestroyed()) {
                new BuyCapacityDilaog(this.this$0.mo22331a()).show();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "event", "Lcom/jiayouya/travel/module/travel/event/DogPickOutEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: WarehouseDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.t$e */
    static final class C3425e<T> implements Consumer<DogPickOutEvent> {
        /* renamed from: a */
        final /* synthetic */ WarehouseDilaog f12055a;

        C3425e(WarehouseDilaog tVar) {
            this.f12055a = tVar;
        }

        /* renamed from: a */
        public final void accept(DogPickOutEvent aVar) {
            List items = this.f12055a.f12049c.getItems();
            C8271i.m35382a((Object) items, "adapter.items");
            Iterator it = items.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (((BagItem) it.next()).getDogId() == aVar.mo21648a()) {
                    break;
                }
                i++;
            }
            if (i != -1) {
                this.f12055a.m14651a(true);
                BagItem bagItem = (BagItem) this.f12055a.f12049c.getItem(i);
                bagItem.setNum(bagItem.getNum() - 1);
                if (bagItem.getNum() <= 0) {
                    this.f12055a.f12049c.getItems().remove(i);
                }
                this.f12055a.f12049c.notifyDataSetChanged();
                WarehouseDilaog.m14647a(this.f12055a, (Boolean) null, 1, (Object) null);
                this.f12055a.m14656g();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/ExpandBag;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: WarehouseDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.t$f */
    static final class C3426f<T> implements Consumer<ExpandBag> {
        /* renamed from: a */
        final /* synthetic */ WarehouseDilaog f12056a;

        C3426f(WarehouseDilaog tVar) {
            this.f12056a = tVar;
        }

        /* renamed from: a */
        public final void accept(ExpandBag expandBag) {
            this.f12056a.mo22332b().setMaxNum(expandBag.getMaxNum());
            WarehouseDilaog.m14649a(this.f12056a, false, 1, (Object) null);
        }
    }

    /* renamed from: a */
    public final Activity mo22331a() {
        return this.f12050d;
    }

    /* renamed from: b */
    public final BagInfo mo22332b() {
        return this.f12051e;
    }

    /* renamed from: c */
    public final C8247b<Integer, Unit> mo22333c() {
        return this.f12053g;
    }

    public WarehouseDilaog(Activity activity, BagInfo bagInfo, C8246a<Boolean> aVar, C8247b<? super Integer, Unit> bVar) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        C8271i.m35386b(bagInfo, "item");
        C8271i.m35386b(aVar, "isCanPickOut");
        C8271i.m35386b(bVar, "pickOutAction");
        super(activity);
        this.f12050d = activity;
        this.f12051e = bagInfo;
        this.f12052f = aVar;
        this.f12053g = bVar;
        DialogWarehouseBinding dialogWarehouseBinding = this.f12047a;
        C8271i.m35382a((Object) dialogWarehouseBinding, "binding");
        setView(dialogWarehouseBinding.getRoot());
        m14655f();
        m14654e();
        m14653d();
    }

    /* renamed from: d */
    private final void m14653d() {
        Observable a = RxBus.f27263a.mo38571a(DogPickOutEvent.class);
        DialogWarehouseBinding dialogWarehouseBinding = this.f12047a;
        String str = "binding";
        C8271i.m35382a((Object) dialogWarehouseBinding, str);
        View root = dialogWarehouseBinding.getRoot();
        String str2 = "binding.root";
        C8271i.m35382a((Object) root, str2);
        C8019a.m34776a(a, root).mo37374a(new C3425e(this));
        Observable a2 = RxBus.f27263a.mo38571a(ExpandBag.class);
        DialogWarehouseBinding dialogWarehouseBinding2 = this.f12047a;
        C8271i.m35382a((Object) dialogWarehouseBinding2, str);
        View root2 = dialogWarehouseBinding2.getRoot();
        C8271i.m35382a((Object) root2, str2);
        C8019a.m34776a(a2, root2).mo37374a(new C3426f(this));
    }

    /* renamed from: e */
    private final void m14654e() {
        setDimAmount(0.7f);
        DialogWarehouseBinding dialogWarehouseBinding = this.f12047a;
        C8271i.m35382a((Object) dialogWarehouseBinding, "binding");
        View root = dialogWarehouseBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(325.0f);
        RecyclerView recyclerView = this.f12047a.f10715e;
        C8271i.m35382a((Object) recyclerView, "binding.list");
        recyclerView.setAdapter(this.f12049c);
        this.f12047a.f10715e.addItemDecoration(((Builder) ((Builder) new Builder(getContext()).drawable((int) R.drawable.divider)).showLastDivider()).build());
        if (!(this.f12051e.getItems() == null)) {
            this.f12049c.setItems(this.f12051e.getItems());
            this.f12049c.notifyDataSetChanged();
        }
        m14650a(Boolean.valueOf(false));
        m14649a(this, false, 1, (Object) null);
        m14656g();
    }

    /* renamed from: f */
    private final void m14655f() {
        FrameLayout frameLayout = this.f12047a.f10713c;
        C8271i.m35382a((Object) frameLayout, "binding.ivClose");
        ezy.p642a.View.m34750a(frameLayout, 0, new C3421a(this), 1, null);
        RoundText roundText = this.f12047a.f10711a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3422b(this), 1, null);
        this.f12048b.setOnItemClick(new C3423c(this));
        RoundText roundText2 = this.f12047a.f10712b;
        C8271i.m35382a((Object) roundText2, "binding.btnExpand");
        ezy.p642a.View.m34750a(roundText2, 0, new C3424d(this), 1, null);
    }

    /* renamed from: a */
    static /* synthetic */ void m14647a(WarehouseDilaog tVar, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        tVar.m14650a(bool);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14650a(Boolean bool) {
        boolean z;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            List items = this.f12049c.getItems();
            C8271i.m35382a((Object) items, "adapter.items");
            Iterator it = items.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (((BagItem) it.next()).isSelected()) {
                    break;
                } else {
                    i++;
                }
            }
            z = i != -1;
        }
        RoundText roundText = this.f12047a.f10711a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        RoundTextEx.m12837a(roundText, z, (String) null, "#C0CAD6,#B2B8C6", 2, (Object) null);
    }

    /* renamed from: a */
    static /* synthetic */ void m14649a(WarehouseDilaog tVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        tVar.m14651a(z);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14651a(boolean z) {
        String str;
        DialogWarehouseBinding dialogWarehouseBinding = this.f12047a;
        C8271i.m35382a((Object) dialogWarehouseBinding, "binding");
        if (z) {
            StringBuilder sb = new StringBuilder();
            BagInfo bagInfo = this.f12051e;
            bagInfo.setUseNum(bagInfo.getUseNum() - 1);
            sb.append(Math.max(0, bagInfo.getUseNum()));
            sb.append('/');
            sb.append(this.f12051e.getMaxNum());
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f12051e.getUseNum());
            sb2.append('/');
            sb2.append(this.f12051e.getMaxNum());
            str = sb2.toString();
        }
        dialogWarehouseBinding.mo20148a(str);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: g */
    public final void m14656g() {
        boolean isEmpty = this.f12049c.getItems().isEmpty();
        RecyclerView recyclerView = this.f12047a.f10715e;
        C8271i.m35382a((Object) recyclerView, "binding.list");
        ViewEx.m12840a(recyclerView, isEmpty);
        ConstraintLayout constraintLayout = this.f12047a.f10716f;
        C8271i.m35382a((Object) constraintLayout, "binding.lytEmpty");
        ViewEx.m12840a(constraintLayout, !isEmpty);
    }
}
