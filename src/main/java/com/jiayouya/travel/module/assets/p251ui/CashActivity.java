package com.jiayouya.travel.module.assets.p251ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.OnItemClickListener;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.common.p246d.AliBindUtil;
import com.jiayouya.travel.common.p246d.DialogTool;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.ActivityCashBinding;
import com.jiayouya.travel.module.assets.data.CashApplyRsp;
import com.jiayouya.travel.module.assets.data.CashConfig;
import com.jiayouya.travel.module.assets.data.CashItem;
import com.jiayouya.travel.module.assets.p251ui.p252a.CashRuleDilaog;
import com.jiayouya.travel.module.assets.p253vm.CashVM;
import com.jiayouya.travel.module.common.data.CertifiedStatusRsp;
import com.jiayouya.travel.module.common.data.PayChannelItem;
import com.jiayouya.travel.module.common.p258b.RealNameAuthEvent;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p642a.Context;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import ezy.p653ui.widget.round.RoundText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u0012\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/ui/CashActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityCashBinding;", "Lcom/jiayouya/travel/module/assets/vm/CashVM;", "()V", "amountAdapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "Lcom/jiayouya/travel/module/assets/data/CashItem;", "amountBindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "channelAdapter", "Lcom/jiayouya/travel/module/common/data/PayChannelItem;", "channelBindType", "fetchData", "", "isRefresh", "", "getLayoutId", "", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "providerViewModelClass", "Ljava/lang/Class;", "setBtnEnable", "setupClick", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CashActivity.kt */
/* renamed from: com.jiayouya.travel.module.assets.ui.CashActivity */
public final class CashActivity extends BaseActivity<ActivityCashBinding, CashVM> {
    /* renamed from: c */
    private final BindingType f11245c = BindingType.create(CashItem.class, (int) R.layout.item_cash_amount);
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final SingleTypeAdapter<CashItem> f11246d = new SingleTypeAdapter<>(this.f11245c);
    /* renamed from: e */
    private final BindingType f11247e = BindingType.create(PayChannelItem.class, (int) R.layout.item_cash_type);
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final SingleTypeAdapter<PayChannelItem> f11248f = new SingleTypeAdapter<>(this.f11247e);
    /* renamed from: g */
    private HashMap f11249g;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashActivity.kt */
    /* renamed from: com.jiayouya.travel.module.assets.ui.CashActivity$a */
    static final class C2930a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ CashActivity this$0;

        C2930a(CashActivity cashActivity) {
            this.this$0 = cashActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            CashConfig a = CashActivity.m13450a(this.this$0).mo20081a();
            if (a != null) {
                List feeExplain = a.getFeeExplain();
                if (feeExplain != null) {
                    new CashRuleDilaog(this.this$0, feeExplain).show();
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashActivity.kt */
    /* renamed from: com.jiayouya.travel.module.assets.ui.CashActivity$b */
    static final class C2931b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ CashActivity this$0;

        C2931b(CashActivity cashActivity) {
            this.this$0 = cashActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            List items = this.this$0.f11246d.getItems();
            C8271i.m35382a((Object) items, "amountAdapter.items");
            Iterator it = items.iterator();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (((CashItem) it.next()).isSelected()) {
                    break;
                } else {
                    i2++;
                }
            }
            List items2 = this.this$0.f11248f.getItems();
            C8271i.m35382a((Object) items2, "channelAdapter.items");
            Iterator it2 = items2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                } else if (((PayChannelItem) it2.next()).isSelected()) {
                    break;
                } else {
                    i++;
                }
            }
            if (i2 != -1 && i != -1) {
                PayChannelItem payChannelItem = (PayChannelItem) this.this$0.f11248f.getItems().get(i);
                String value = ((CashItem) this.this$0.f11246d.getItems().get(i2)).getValue();
                String key = payChannelItem.getKey();
                if (payChannelItem.getStatus() == 2) {
                    DialogTool.m12956a(this.this$0, "温馨提示", "首次提现前需要先进行实名认证", "去认证", null, C29321.INSTANCE, null, 80, null);
                    return;
                }
                ((CashVM) this.this$0.mo19853a()).mo20379a(key, value);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashActivity.kt */
    /* renamed from: com.jiayouya.travel.module.assets.ui.CashActivity$c */
    static final class C2933c implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ CashActivity f11250a;

        C2933c(CashActivity cashActivity) {
            this.f11250a = cashActivity;
        }

        /* renamed from: a */
        public final void mo19912a(View view, int i, long j) {
            List items = this.f11250a.f11246d.getItems();
            C8271i.m35382a((Object) items, "amountAdapter.items");
            int i2 = 0;
            for (Object next : items) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    C8187k.m35272b();
                }
                ((CashItem) next).setSelected(i2 == i);
                i2 = i3;
            }
            this.f11250a.f11246d.notifyDataSetChanged();
            this.f11250a.m13454q();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashActivity.kt */
    /* renamed from: com.jiayouya.travel.module.assets.ui.CashActivity$d */
    static final class C2934d implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ CashActivity f11251a;

        C2934d(CashActivity cashActivity) {
            this.f11251a = cashActivity;
        }

        /* renamed from: a */
        public final void mo19912a(View view, int i, long j) {
            int status = ((PayChannelItem) this.f11251a.f11248f.getItem(i)).getStatus();
            if (status != 0) {
                if (status != 2) {
                    List items = this.f11251a.f11248f.getItems();
                    C8271i.m35382a((Object) items, "channelAdapter.items");
                    int i2 = 0;
                    for (Object next : items) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            C8187k.m35272b();
                        }
                        ((PayChannelItem) next).setSelected(i2 == i);
                        i2 = i3;
                    }
                    this.f11251a.f11248f.notifyDataSetChanged();
                } else {
                    ((CashVM) this.f11251a.mo19853a()).mo20384f();
                }
                this.f11251a.m13454q();
                return;
            }
            Context.m34744a(this.f11251a, "该提现方式暂不可用", 0, 0, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/event/RealNameAuthEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashActivity.kt */
    /* renamed from: com.jiayouya.travel.module.assets.ui.CashActivity$e */
    static final class C2935e<T> implements Consumer<RealNameAuthEvent> {
        /* renamed from: a */
        final /* synthetic */ CashActivity f11252a;

        C2935e(CashActivity cashActivity) {
            this.f11252a = cashActivity;
        }

        /* renamed from: a */
        public final void accept(RealNameAuthEvent cVar) {
            if (cVar.mo20436a()) {
                BaseActivity.m12847a(this.f11252a, false, 1, null);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/assets/data/CashConfig;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashActivity.kt */
    /* renamed from: com.jiayouya.travel.module.assets.ui.CashActivity$f */
    static final class C2936f<T> implements Observer<CashConfig> {
        /* renamed from: a */
        final /* synthetic */ CashActivity f11253a;

        C2936f(CashActivity cashActivity) {
            this.f11253a = cashActivity;
        }

        /* renamed from: a */
        public final void onChanged(CashConfig cashConfig) {
            CashActivity.m13450a(this.f11253a).mo20082a(cashConfig);
            Iterable<String> cash = cashConfig.getCash();
            Collection arrayList = new ArrayList();
            for (String cashItem : cash) {
                C8187k.m35278a(arrayList, (Iterable) C8187k.m35265a(new CashItem(cashItem)));
            }
            List list = (List) arrayList;
            if (!list.isEmpty()) {
                ((CashItem) list.get(0)).setSelected(true);
            }
            this.f11253a.f11246d.setItems(list);
            this.f11253a.f11246d.notifyDataSetChanged();
            this.f11253a.f11248f.setItems(cashConfig.getChannels());
            this.f11253a.f11248f.notifyDataSetChanged();
            this.f11253a.m13454q();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/assets/data/CashApplyRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashActivity.kt */
    /* renamed from: com.jiayouya.travel.module.assets.ui.CashActivity$g */
    static final class C2937g<T> implements Observer<CashApplyRsp> {
        /* renamed from: a */
        public static final C2937g f11254a = new C2937g();

        C2937g() {
        }

        /* renamed from: a */
        public final void onChanged(CashApplyRsp cashApplyRsp) {
            Bundle bundle = new Bundle();
            C8271i.m35382a((Object) cashApplyRsp, "it");
            ezy.p642a.Bundle.m34739a(bundle, "item", (Parcelable) cashApplyRsp);
            Router.m12969a(Router.f9644a, "/assets/cashResult", bundle, null, 4, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/CertifiedStatusRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashActivity.kt */
    /* renamed from: com.jiayouya.travel.module.assets.ui.CashActivity$h */
    static final class C2938h<T> implements Observer<CertifiedStatusRsp> {
        /* renamed from: a */
        final /* synthetic */ CashActivity f11255a;

        C2938h(CashActivity cashActivity) {
            this.f11255a = cashActivity;
        }

        /* renamed from: a */
        public final void onChanged(CertifiedStatusRsp certifiedStatusRsp) {
            if (certifiedStatusRsp.getStatus() == 1) {
                AliBindUtil.m12939a(this.f11255a, new C8246a<Unit>(this) {
                    final /* synthetic */ C2938h this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        BaseActivity.m12847a(this.this$0.f11255a, false, 1, null);
                    }
                }, null, 4, null);
            } else {
                Router.m12969a(Router.f9644a, "/me/realNameAuth", null, null, 6, null);
            }
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11249g == null) {
            this.f11249g = new HashMap();
        }
        View view = (View) this.f11249g.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11249g.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_cash;
    }

    /* renamed from: a */
    public static final /* synthetic */ ActivityCashBinding m13450a(CashActivity cashActivity) {
        return (ActivityCashBinding) cashActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<CashVM> mo19861d() {
        return CashVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        mo19856a(false);
        RecyclerView recyclerView = (RecyclerView) mo19852a(R.id.list_amount);
        C8271i.m35382a((Object) recyclerView, "list_amount");
        recyclerView.setAdapter(this.f11246d);
        RecyclerView recyclerView2 = (RecyclerView) mo19852a(R.id.list_type);
        C8271i.m35382a((Object) recyclerView2, "list_type");
        recyclerView2.setAdapter(this.f11248f);
        LinearLayout linearLayout = (LinearLayout) mo19852a(R.id.lyt_container);
        C8271i.m35382a((Object) linearLayout, "lyt_container");
        setupStatusView(linearLayout);
        BaseActivity.m12847a(this, false, 1, null);
    }

    /* renamed from: h */
    public boolean mo19865h() {
        return ((ActivityCashBinding) mo19857b()).mo20081a() == null;
    }

    /* renamed from: i */
    public boolean mo19866i() {
        return ((ActivityCashBinding) mo19857b()).mo20081a() == null;
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((CashVM) mo19853a()).mo20383e();
    }

    /* renamed from: k */
    public void mo19868k() {
        TextView textView = (TextView) mo19852a(R.id.tv_cash_rule);
        C8271i.m35382a((Object) textView, "tv_cash_rule");
        ezy.p642a.View.m34750a(textView, 0, new C2930a(this), 1, null);
        RoundText roundText = (RoundText) mo19852a(R.id.btn_cash);
        C8271i.m35382a((Object) roundText, "btn_cash");
        ezy.p642a.View.m34750a(roundText, 0, new C2931b(this), 1, null);
        this.f11245c.setOnItemClick(new C2933c(this));
        this.f11247e.setOnItemClick(new C2934d(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: q */
    public final void m13454q() {
        List items = this.f11248f.getItems();
        C8271i.m35382a((Object) items, "channelAdapter.items");
        Iterator it = items.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((PayChannelItem) it.next()).isSelected()) {
                break;
            } else {
                i++;
            }
        }
        List items2 = this.f11246d.getItems();
        C8271i.m35382a((Object) items2, "amountAdapter.items");
        Iterator it2 = items2.iterator();
        int i2 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            } else if (((CashItem) it2.next()).isSelected()) {
                break;
            } else {
                i2++;
            }
        }
        RoundText roundText = (RoundText) mo19852a(R.id.btn_cash);
        C8271i.m35382a((Object) roundText, "btn_cash");
        boolean z = (i == -1 || i2 == -1) ? false : true;
        RoundTextEx.m12837a(roundText, z, (String) null, (String) null, 6, (Object) null);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        C8019a.m34778a(RxBus.f27263a.mo38571a(RealNameAuthEvent.class), lifecycleOwner, null, 2, null).mo37374a(new C2935e(this));
        ((CashVM) mo19853a()).mo20380b().observe(lifecycleOwner, new C2936f(this));
        ((CashVM) mo19853a()).mo20381c().observe(lifecycleOwner, C2937g.f11254a);
        ((CashVM) mo19853a()).mo20382d().observe(lifecycleOwner, new C2938h(this));
    }
}
