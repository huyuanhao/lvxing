package com.jiayouya.travel.module.p281tb.p283ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.transition.Transition;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView.OnEditorActionListener;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import com.gyf.barlibrary.ImmersionBar;
import com.jakewharton.rxbinding2.p241a.RxTextView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.ClickableBindingHolder;
import com.jiayouya.travel.common.binding.OnBindListener;
import com.jiayouya.travel.common.binding.OnItemClickListener;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p244b.TextViewEx;
import com.jiayouya.travel.common.p244b.ViewEx;
import com.jiayouya.travel.common.p246d.TransitionUtils.C2901a;
import com.jiayouya.travel.databinding.ActivitySearchBinding;
import com.jiayouya.travel.databinding.ItemAssociateBinding;
import com.jiayouya.travel.databinding.ItemSortTabBinding;
import com.jiayouya.travel.module.p281tb.data.GoodsItem;
import com.jiayouya.travel.module.p281tb.data.SearchHistory;
import com.jiayouya.travel.module.p281tb.p284vm.SearchVM;
import com.jiayouya.travel.module.p281tb.widget.TagGroup;
import com.jiayouya.travel.module.p281tb.widget.TagGroup.C3319a;
import ezy.assist.p647b.SoftInputUtil;
import ezy.p642a.TextView;
import ezy.p653ui.widget.recyclerview.adapter.EndlessAdapter;
import ezy.p653ui.widget.recyclerview.adapter.EndlessAdapter.OnLoadMoreListener;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import ezy.p653ui.widget.recyclerview.decoration.HorizontalDividerItemDecoration.Builder;
import ezy.p653ui.widget.round.RoundText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.reflect.C8280j;
import kotlin.text.C8313m;
import okhttp3.C8364ac;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J(\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\"H\u0002J\u001a\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00072\b\b\u0002\u0010(\u001a\u00020\rH\u0002J\b\u0010)\u001a\u00020\"H\u0016J\b\u0010*\u001a\u00020 H\u0016J\u0012\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020 H\u0014J\u0010\u0010/\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0007H\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\u000301H\u0016J\u0010\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020 H\u0002J\u001e\u00105\u001a\u00020 2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010(\u001a\u00020\rH\u0002J\u0010\u00107\u001a\u00020 2\u0006\u00103\u001a\u00020\u001eH\u0002J\b\u00108\u001a\u00020 H\u0002J\b\u00109\u001a\u00020 H\u0016J\b\u0010:\u001a\u00020 H\u0002J\b\u0010;\u001a\u00020 H\u0002J\b\u0010<\u001a\u00020 H\u0002J\u0012\u0010=\u001a\u00020 2\b\b\u0002\u0010>\u001a\u00020\rH\u0002J\b\u0010?\u001a\u00020 H\u0002J\u0012\u0010@\u001a\u00020 2\b\b\u0002\u0010A\u001a\u00020\rH\u0002J\u001c\u0010B\u001a\u00020 2\b\u0010C\u001a\u0004\u0018\u00010\u001e2\b\u0010D\u001a\u0004\u0018\u00010\u001eH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0013\u001a\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00148BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/ui/SearchActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivitySearchBinding;", "Lcom/jiayouya/travel/module/tb/vm/SearchVM;", "()V", "associateAdapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "", "associateBindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "field", "isAutoSearch", "", "mKeywords", "getMKeywords", "()Ljava/lang/String;", "mKeywords$delegate", "Lkotlin/Lazy;", "mList", "Ljava/util/ArrayList;", "Lcom/jiayouya/travel/module/tb/data/GoodsItem;", "getMList", "()Ljava/util/ArrayList;", "mList$delegate", "resultAdapter", "Lezy/ui/widget/recyclerview/adapter/EndlessAdapter;", "resultBindType", "sort", "unSelectTab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "addTab", "", "resId", "", "name", "isSelect", "index", "doSearch", "str", "isRefresh", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onTagClicked", "providerViewModelClass", "Ljava/lang/Class;", "reselectTab", "tab", "resetTabs", "search", "keyword", "selectTab", "setupAssociate", "setupClick", "setupObserve", "setupTabs", "setupView", "showDrawerLayout", "isOpen", "temporaryCloseAssociate", "turnDrawer", "isUnLock", "unSelected", "unSelectedTab", "selectedTab", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: SearchActivity.kt */
/* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity */
public final class SearchActivity extends BaseActivity<ActivitySearchBinding, SearchVM> {
    /* renamed from: c */
    static final /* synthetic */ C8280j[] f11805c;
    /* renamed from: d */
    private final Lazy f11806d = C8182c.m35317a(new C3277a(this));
    /* renamed from: e */
    private final Lazy f11807e = C8182c.m35317a(new C3278b(this));
    /* renamed from: f */
    private final BindingType f11808f = BindingType.create(String.class, (int) R.layout.item_associate);
    /* access modifiers changed from: private|final */
    /* renamed from: g */
    public final SingleTypeAdapter<String> f11809g = new SingleTypeAdapter<>(this.f11808f);
    /* renamed from: h */
    private final BindingType f11810h = BindingType.create(GoodsItem.class, (int) R.layout.item_search_result);
    /* renamed from: i */
    private final EndlessAdapter f11811i = new EndlessAdapter(this.f11810h);
    /* renamed from: j */
    private String f11812j;
    /* renamed from: k */
    private String f11813k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public Tab f11814l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean f11815m;
    /* renamed from: n */
    private HashMap f11816n;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$a */
    static final class C3277a extends Lambda implements C8246a<String> {
        final /* synthetic */ SearchActivity this$0;

        C3277a(SearchActivity searchActivity) {
            this.this$0 = searchActivity;
            super(0);
        }

        public final String invoke() {
            String str = "keyword";
            if (this.this$0.getIntent().getStringExtra(str) == null) {
                return "";
            }
            String stringExtra = this.this$0.getIntent().getStringExtra(str);
            C8271i.m35382a((Object) stringExtra, "intent.getStringExtra(\"keyword\")");
            return C8313m.m35461a(stringExtra, "_", "#", false, 4, (Object) null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/jiayouya/travel/module/tb/data/GoodsItem;", "kotlin.jvm.PlatformType", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$b */
    static final class C3278b extends Lambda implements C8246a<ArrayList<GoodsItem>> {
        final /* synthetic */ SearchActivity this$0;

        C3278b(SearchActivity searchActivity) {
            this.this$0 = searchActivity;
            super(0);
        }

        public final ArrayList<GoodsItem> invoke() {
            ArrayList<GoodsItem> parcelableArrayListExtra = this.this$0.getIntent().getParcelableArrayListExtra("searchResult");
            if (parcelableArrayListExtra != null) {
                return parcelableArrayListExtra;
            }
            return null;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$c */
    static final class C3279c implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11817a;

        C3279c(SearchActivity searchActivity) {
            this.f11817a = searchActivity;
        }

        /* renamed from: a */
        public final void mo19912a(View view, int i, long j) {
            String str = (String) this.f11817a.f11809g.getItem(i);
            this.f11817a.m14344x();
            EditText editText = SearchActivity.m14313a(this.f11817a).f10173f;
            editText.setText(str);
            editText.setSelection(str.length());
            SoftInputUtil.m34790b(view);
            SearchActivity searchActivity = this.f11817a;
            C8271i.m35382a((Object) str, "keyword");
            SearchActivity.m14328b(searchActivity, str, false, 2, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0003¨\u0006\u00010\u0003¨\u0006\u00012\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, mo39189d2 = {"<anonymous>", "", "holder", "Lcom/jiayouya/travel/common/binding/ClickableBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "kotlin.jvm.PlatformType", "item", "", "onBind"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$d */
    static final class C3280d implements OnBindListener {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11818a;

        C3280d(SearchActivity searchActivity) {
            this.f11818a = searchActivity;
        }

        /* renamed from: a */
        public final void mo19911a(ClickableBindingHolder<ViewDataBinding> clickableBindingHolder, Object obj) {
            if (obj != null) {
                String str = (String) obj;
                EditText editText = SearchActivity.m14313a(this.f11818a).f10173f;
                C8271i.m35382a((Object) editText, "binding.editKeyword");
                String a = TextView.m34747a(editText);
                Binding binding = clickableBindingHolder.binding;
                if (binding != null) {
                    ItemAssociateBinding itemAssociateBinding = (ItemAssociateBinding) binding;
                    CharSequence charSequence = a;
                    if (!(charSequence.length() == 0)) {
                        CharSequence charSequence2 = (CharSequence) obj;
                        if (C8313m.m35480a(charSequence2, charSequence, false, 2, (Object) null)) {
                            C8313m.m35469a(charSequence2, a, 0, false, 6, (Object) null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.databinding.ItemAssociateBinding");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$e */
    static final class C3281e extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SearchActivity this$0;

        C3281e(SearchActivity searchActivity) {
            this.this$0 = searchActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            EditText editText = (EditText) this.this$0.mo19852a(R.id.edit_keyword);
            String str = "edit_keyword";
            C8271i.m35382a((Object) editText, str);
            if (TextViewEx.m12838a(editText)) {
                GloblaEx.m12816a("请输入关键字", 0, 0, 6, null);
                return;
            }
            SearchActivity searchActivity = this.this$0;
            EditText editText2 = (EditText) searchActivity.mo19852a(R.id.edit_keyword);
            C8271i.m35382a((Object) editText2, str);
            SearchActivity.m14328b(searchActivity, TextView.m34747a(editText2), false, 2, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$f */
    static final class C3282f extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SearchActivity this$0;

        C3282f(SearchActivity searchActivity) {
            this.this$0 = searchActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            ((SearchVM) this.this$0.mo19853a()).mo21591f();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$g */
    static final class C3283g extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SearchActivity this$0;

        C3283g(SearchActivity searchActivity) {
            this.this$0 = searchActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.onBackPressed();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$h */
    static final class C3284h extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SearchActivity this$0;

        C3284h(SearchActivity searchActivity) {
            this.this$0 = searchActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            ((EditText) this.this$0.mo19852a(R.id.edit_keyword)).setText("");
            EditText editText = (EditText) this.this$0.mo19852a(R.id.edit_keyword);
            C8271i.m35382a((Object) editText, "edit_keyword");
            editText.setFocusable(true);
            LinearLayout linearLayout = (LinearLayout) this.this$0.mo19852a(R.id.lyt_result);
            C8271i.m35382a((Object) linearLayout, "lyt_result");
            ViewEx.m12841a(linearLayout, false, 1, null);
            RecyclerView recyclerView = (RecyclerView) this.this$0.mo19852a(R.id.associate_list);
            C8271i.m35382a((Object) recyclerView, "associate_list");
            ViewEx.m12841a(recyclerView, false, 1, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$i */
    static final class C3285i extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SearchActivity this$0;

        C3285i(SearchActivity searchActivity) {
            this.this$0 = searchActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            view.setSelected(true);
            android.widget.TextView textView = (android.widget.TextView) this.this$0.mo19852a(R.id.txt_tb);
            C8271i.m35382a((Object) textView, "txt_tb");
            textView.setSelected(false);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$j */
    static final class C3286j extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SearchActivity this$0;

        C3286j(SearchActivity searchActivity) {
            this.this$0 = searchActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            view.setSelected(true);
            android.widget.TextView textView = (android.widget.TextView) this.this$0.mo19852a(R.id.txt_tm);
            C8271i.m35382a((Object) textView, "txt_tm");
            textView.setSelected(false);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$k */
    static final class C3287k extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SearchActivity this$0;

        C3287k(SearchActivity searchActivity) {
            this.this$0 = searchActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            EditText editText = (EditText) this.this$0.mo19852a(R.id.edit_min);
            C8271i.m35382a((Object) editText, "edit_min");
            int b = TextView.m34748b(editText);
            EditText editText2 = (EditText) this.this$0.mo19852a(R.id.edit_max);
            C8271i.m35382a((Object) editText2, "edit_max");
            if (b > TextView.m34748b(editText2)) {
                GloblaEx.m12816a("请输入合理的价格区间", 0, 0, 6, null);
                return;
            }
            this.this$0.m14335d(false);
            SearchActivity.m14320a(this.this$0, null, false, 3, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$l */
    static final class C3288l extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SearchActivity this$0;

        C3288l(SearchActivity searchActivity) {
            this.this$0 = searchActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            android.widget.TextView textView = (android.widget.TextView) this.this$0.mo19852a(R.id.txt_tb);
            C8271i.m35382a((Object) textView, "txt_tb");
            textView.setSelected(true);
            android.widget.TextView textView2 = (android.widget.TextView) this.this$0.mo19852a(R.id.txt_tm);
            C8271i.m35382a((Object) textView2, "txt_tm");
            textView2.setSelected(false);
            String str = "";
            ((EditText) this.this$0.mo19852a(R.id.edit_max)).setText(str);
            ((EditText) this.this$0.mo19852a(R.id.edit_min)).setText(str);
            SearchActivity searchActivity = this.this$0;
            Tab tabAt = ((TabLayout) searchActivity.mo19852a(R.id.tabs)).getTabAt(3);
            TabLayout tabLayout = (TabLayout) this.this$0.mo19852a(R.id.tabs);
            TabLayout tabLayout2 = (TabLayout) this.this$0.mo19852a(R.id.tabs);
            C8271i.m35382a((Object) tabLayout2, "tabs");
            searchActivity.m14316a(tabAt, tabLayout.getTabAt(tabLayout2.getSelectedTabPosition()));
            SearchActivity.m14320a(this.this$0, null, false, 3, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$m */
    static final class C3289m implements OnItemClickListener {
        /* renamed from: a */
        public static final C3289m f11819a = new C3289m();

        C3289m() {
        }

        /* renamed from: a */
        public final void mo19912a(View view, int i, long j) {
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/tb/data/SearchHistory;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$n */
    static final class C3290n<T> implements Observer<SearchHistory> {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11820a;

        C3290n(SearchActivity searchActivity) {
            this.f11820a = searchActivity;
        }

        /* renamed from: a */
        public final void onChanged(SearchHistory searchHistory) {
            if (searchHistory != null) {
                SearchActivity.m14313a(this.f11820a).f10188u.setTag(searchHistory.getHistory());
                SearchActivity.m14313a(this.f11820a).f10189v.setTag(searchHistory.getHot());
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$o */
    static final class C3291o<T> implements Observer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11821a;

        C3291o(SearchActivity searchActivity) {
            this.f11821a = searchActivity;
        }

        /* renamed from: a */
        public final void onChanged(C8364ac acVar) {
            FrameLayout frameLayout = SearchActivity.m14313a(this.f11821a).f10180m;
            C8271i.m35382a((Object) frameLayout, "binding.lytHistory");
            ViewEx.m12841a(frameLayout, false, 1, null);
            TagGroup tagGroup = SearchActivity.m14313a(this.f11821a).f10188u;
            C8271i.m35382a((Object) tagGroup, "binding.tagHistory");
            ViewEx.m12841a(tagGroup, false, 1, null);
            SearchActivity.m14313a(this.f11821a).f10188u.removeAllViews();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$p */
    static final class C3292p<T> implements Observer<List<? extends String>> {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11822a;

        C3292p(SearchActivity searchActivity) {
            this.f11822a = searchActivity;
        }

        /* renamed from: a */
        public final void onChanged(List<String> list) {
            ActivitySearchBinding a = SearchActivity.m14313a(this.f11822a);
            ProgressBar progressBar = a.f10168a;
            C8271i.m35382a((Object) progressBar, "associateBar");
            ViewEx.m12841a(progressBar, false, 1, null);
            String str = "associateList";
            String str2 = "txtAssociate";
            if (list == null || !list.isEmpty()) {
                android.widget.TextView textView = a.f10190w;
                C8271i.m35382a((Object) textView, str2);
                ViewEx.m12840a(textView, true);
                RecyclerView recyclerView = a.f10169b;
                C8271i.m35382a((Object) recyclerView, str);
                ViewEx.m12840a(recyclerView, false);
            } else {
                android.widget.TextView textView2 = a.f10190w;
                C8271i.m35382a((Object) textView2, str2);
                ViewEx.m12840a(textView2, false);
                RecyclerView recyclerView2 = a.f10169b;
                C8271i.m35382a((Object) recyclerView2, str);
                ViewEx.m12840a(recyclerView2, true);
            }
            this.f11822a.f11809g.setItems(list);
            this.f11822a.f11809g.notifyDataSetChanged();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, mo39189d2 = {"com/jiayouya/travel/module/tb/ui/SearchActivity$setupTabs$1$1", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$q */
    public static final class C3293q implements OnTabSelectedListener {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11823a;

        C3293q(SearchActivity searchActivity) {
            this.f11823a = searchActivity;
        }

        public void onTabReselected(Tab tab) {
            if (tab != null) {
                this.f11823a.m14326b(tab);
                if (tab.getPosition() != 3 && this.f11823a.f11815m) {
                    SearchActivity.m14320a(this.f11823a, null, false, 3, null);
                }
            }
        }

        public void onTabUnselected(Tab tab) {
            if (tab != null && tab.getPosition() != 3 && this.f11823a.f11815m) {
                this.f11823a.f11814l = tab;
            }
        }

        public void onTabSelected(Tab tab) {
            if (tab != null) {
                this.f11823a.m14315a(tab);
                if (tab.getPosition() != 3) {
                    SearchActivity.m14320a(this.f11823a, null, false, 3, null);
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo39189d2 = {"<anonymous>", "", "onLoadMore", "com/jiayouya/travel/module/tb/ui/SearchActivity$setupView$6$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$r */
    static final class C3294r implements OnLoadMoreListener {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11824a;

        C3294r(SearchActivity searchActivity) {
            this.f11824a = searchActivity;
        }

        public final void onLoadMore() {
            SearchActivity.m14320a(this.f11824a, null, false, 1, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo39189d2 = {"<anonymous>", "", "text", "", "kotlin.jvm.PlatformType", "accept", "com/jiayouya/travel/module/tb/ui/SearchActivity$setupView$7$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$s */
    static final class C3295s<T> implements Consumer<CharSequence> {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11825a;

        C3295s(SearchActivity searchActivity) {
            this.f11825a = searchActivity;
        }

        /* renamed from: a */
        public final void accept(CharSequence charSequence) {
            FrameLayout frameLayout = (FrameLayout) this.f11825a.mo19852a(R.id.lyt_associate);
            C8271i.m35382a((Object) frameLayout, "lyt_associate");
            View view = frameLayout;
            C8271i.m35382a((Object) charSequence, "text");
            boolean z = true;
            ViewEx.m12840a(view, charSequence.length() == 0);
            ProgressBar progressBar = (ProgressBar) this.f11825a.mo19852a(R.id.associate_bar);
            C8271i.m35382a((Object) progressBar, "associate_bar");
            ViewEx.m12840a(progressBar, false);
            android.widget.TextView textView = (android.widget.TextView) this.f11825a.mo19852a(R.id.txt_associate);
            C8271i.m35382a((Object) textView, "txt_associate");
            ViewEx.m12841a(textView, false, 1, null);
            RecyclerView recyclerView = (RecyclerView) this.f11825a.mo19852a(R.id.associate_list);
            C8271i.m35382a((Object) recyclerView, "associate_list");
            ViewEx.m12841a(recyclerView, false, 1, null);
            LinearLayout linearLayout = (LinearLayout) this.f11825a.mo19852a(R.id.lyt_result);
            C8271i.m35382a((Object) linearLayout, "lyt_result");
            ViewEx.m12841a(linearLayout, false, 1, null);
            ImageView imageView = (ImageView) this.f11825a.mo19852a(R.id.img_delete);
            C8271i.m35382a((Object) imageView, "img_delete");
            View view2 = imageView;
            if (charSequence.length() != 0) {
                z = false;
            }
            ViewEx.m12840a(view2, z);
            if (this.f11825a.f11815m) {
                ((SearchVM) this.f11825a.mo19853a()).mo21586a(charSequence.toString());
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, mo39189d2 = {"<anonymous>", "", "v", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction", "com/jiayouya/travel/module/tb/ui/SearchActivity$setupView$7$2"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$t */
    static final class C3296t implements OnEditorActionListener {
        /* renamed from: a */
        final /* synthetic */ EditText f11826a;
        /* renamed from: b */
        final /* synthetic */ SearchActivity f11827b;

        C3296t(EditText editText, SearchActivity searchActivity) {
            this.f11826a = editText;
            this.f11827b = searchActivity;
        }

        public final boolean onEditorAction(android.widget.TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            EditText editText = (EditText) this.f11827b.mo19852a(R.id.edit_keyword);
            C8271i.m35382a((Object) editText, "edit_keyword");
            if (TextViewEx.m12838a(editText)) {
                GloblaEx.m12816a("请输入关键字", 0, 0, 6, null);
                return true;
            }
            SearchActivity.m14328b(this.f11827b, TextView.m34747a(this.f11826a), false, 2, null);
            return true;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo39189d2 = {"com/jiayouya/travel/module/tb/ui/SearchActivity$setupView$1", "Lcom/jiayouya/travel/common/util/TransitionUtils$TransitionListenerAdapter;", "onTransitionEnd", "", "transition", "Landroid/transition/Transition;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$u */
    public static final class C3297u extends C2901a {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11828a;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: SearchActivity.kt */
        /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$u$a */
        static final class C3298a implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C3297u f11829a;

            C3298a(C3297u uVar) {
                this.f11829a = uVar;
            }

            public final void run() {
                SoftInputUtil.m34787a((View) (EditText) this.f11829a.f11828a.mo19852a(R.id.edit_keyword));
            }
        }

        C3297u(SearchActivity searchActivity) {
            this.f11828a = searchActivity;
        }

        public void onTransitionEnd(Transition transition) {
            C8271i.m35386b(transition, "transition");
            if (!this.f11828a.isDestroyed() && !this.f11828a.isFinishing()) {
                ((EditText) this.f11828a.mo19852a(R.id.edit_keyword)).post(new C3298a(this));
            }
            transition.removeListener(this);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "onGlobalLayout"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$v */
    static final class C3299v implements OnGlobalLayoutListener {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11830a;

        C3299v(SearchActivity searchActivity) {
            this.f11830a = searchActivity;
        }

        public final void onGlobalLayout() {
            SearchActivity searchActivity = this.f11830a;
            LinearLayout linearLayout = (LinearLayout) searchActivity.mo19852a(R.id.lyt_result);
            C8271i.m35382a((Object) linearLayout, "lyt_result");
            searchActivity.m14336e(linearLayout.getVisibility() == 0);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$w */
    static final class C3300w implements C3319a {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11831a;

        C3300w(SearchActivity searchActivity) {
            this.f11831a = searchActivity;
        }

        /* renamed from: a */
        public final void mo21578a(String str) {
            SearchActivity searchActivity = this.f11831a;
            C8271i.m35382a((Object) str, "it");
            searchActivity.m14323a(str);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$x */
    static final class C3301x implements C3319a {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11832a;

        C3301x(SearchActivity searchActivity) {
            this.f11832a = searchActivity;
        }

        /* renamed from: a */
        public final void mo21578a(String str) {
            SearchActivity searchActivity = this.f11832a;
            C8271i.m35382a((Object) str, "it");
            searchActivity.m14323a(str);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SearchActivity.kt */
    /* renamed from: com.jiayouya.travel.module.tb.ui.SearchActivity$y */
    static final class C3302y implements Runnable {
        /* renamed from: a */
        final /* synthetic */ SearchActivity f11833a;

        C3302y(SearchActivity searchActivity) {
            this.f11833a = searchActivity;
        }

        public final void run() {
            this.f11833a.f11815m = true;
        }
    }

    static {
        Class<SearchActivity> cls = SearchActivity.class;
        f11805c = new C8280j[]{C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "mKeywords", "getMKeywords()Ljava/lang/String;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "mList", "getMList()Ljava/util/ArrayList;"))};
    }

    /* renamed from: q */
    private final String m14337q() {
        Lazy bVar = this.f11806d;
        C8280j jVar = f11805c[0];
        return (String) bVar.getValue();
    }

    /* renamed from: r */
    private final ArrayList<GoodsItem> m14338r() {
        Lazy bVar = this.f11807e;
        C8280j jVar = f11805c[1];
        return (ArrayList) bVar.getValue();
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11816n == null) {
            this.f11816n = new HashMap();
        }
        View view = (View) this.f11816n.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11816n.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_search;
    }

    public SearchActivity() {
        String str = "";
        this.f11812j = str;
        this.f11813k = str;
        this.f11815m = true;
    }

    /* renamed from: a */
    public static final /* synthetic */ ActivitySearchBinding m14313a(SearchActivity searchActivity) {
        return (ActivitySearchBinding) searchActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<SearchVM> mo19861d() {
        return SearchVM.class;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m14340t();
        mo19868k();
        m14339s();
        m14343w();
        ((SearchVM) mo19853a()).mo21590e();
        if (m14337q().length() > 0) {
            ((EditText) mo19852a(R.id.edit_keyword)).setText(m14337q());
            ((EditText) mo19852a(R.id.edit_keyword)).setSelection(m14337q().length());
            ArrayList r = m14338r();
            if (r == null || !(!r.isEmpty())) {
                m14328b(this, m14337q(), false, 2, null);
                return;
            }
            overridePendingTransition(R.anim.anim_activity_fade_in, R.anim.anim_activity_fade_out);
            SoftInputUtil.m34790b((EditText) mo19852a(R.id.edit_keyword));
            FrameLayout frameLayout = (FrameLayout) mo19852a(R.id.lyt_history);
            C8271i.m35382a((Object) frameLayout, "lyt_history");
            ViewEx.m12841a(frameLayout, false, 1, null);
            FrameLayout frameLayout2 = (FrameLayout) mo19852a(R.id.lyt_associate);
            C8271i.m35382a((Object) frameLayout2, "lyt_associate");
            ViewEx.m12841a(frameLayout2, false, 1, null);
            ProgressBar progressBar = (ProgressBar) mo19852a(R.id.progress_bar);
            C8271i.m35382a((Object) progressBar, "progress_bar");
            ViewEx.m12841a(progressBar, false, 1, null);
            ScrollView scrollView = (ScrollView) mo19852a(R.id.scroll);
            C8271i.m35382a((Object) scrollView, "scroll");
            ViewEx.m12841a(scrollView, false, 1, null);
            LinearLayout linearLayout = (LinearLayout) mo19852a(R.id.lyt_result);
            C8271i.m35382a((Object) linearLayout, "lyt_result");
            ViewEx.m12840a(linearLayout, false);
            this.f11811i.setItems(m14338r());
            this.f11811i.notifyDataSetChanged();
            ((ActivitySearchBinding) mo19857b()).f10183p.scrollToPosition(0);
        }
    }

    /* renamed from: k */
    public void mo19868k() {
        android.widget.TextView textView = (android.widget.TextView) mo19852a(R.id.txt_search);
        C8271i.m35382a((Object) textView, "txt_search");
        ezy.p642a.View.m34750a(textView, 0, new C3281e(this), 1, null);
        ImageView imageView = (ImageView) mo19852a(R.id.btn_clean_history);
        C8271i.m35382a((Object) imageView, "btn_clean_history");
        ezy.p642a.View.m34750a(imageView, 0, new C3282f(this), 1, null);
        ImageView imageView2 = (ImageView) mo19852a(R.id.img_back);
        C8271i.m35382a((Object) imageView2, "img_back");
        ezy.p642a.View.m34750a(imageView2, 0, new C3283g(this), 1, null);
        ImageView imageView3 = (ImageView) mo19852a(R.id.img_delete);
        C8271i.m35382a((Object) imageView3, "img_delete");
        ezy.p642a.View.m34750a(imageView3, 0, new C3284h(this), 1, null);
        android.widget.TextView textView2 = (android.widget.TextView) mo19852a(R.id.txt_tm);
        C8271i.m35382a((Object) textView2, "txt_tm");
        ezy.p642a.View.m34750a(textView2, 0, new C3285i(this), 1, null);
        android.widget.TextView textView3 = (android.widget.TextView) mo19852a(R.id.txt_tb);
        C8271i.m35382a((Object) textView3, "txt_tb");
        ezy.p642a.View.m34750a(textView3, 0, new C3286j(this), 1, null);
        RoundText roundText = (RoundText) mo19852a(R.id.btn_confirm);
        C8271i.m35382a((Object) roundText, "btn_confirm");
        ezy.p642a.View.m34750a(roundText, 0, new C3287k(this), 1, null);
        android.widget.TextView textView4 = (android.widget.TextView) mo19852a(R.id.btn_reset);
        C8271i.m35382a((Object) textView4, "btn_reset");
        ezy.p642a.View.m34750a(textView4, 0, new C3288l(this), 1, null);
        this.f11810h.setOnItemClick(C3289m.f11819a);
    }

    /* renamed from: a */
    static /* synthetic */ void m14320a(SearchActivity searchActivity, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        searchActivity.m14324a(str, z);
    }

    /* renamed from: a */
    private final void m14324a(String str, boolean z) {
        if (z) {
            RecyclerView recyclerView = (RecyclerView) mo19852a(R.id.result_list);
            C8271i.m35382a((Object) recyclerView, "result_list");
            ViewEx.m12841a(recyclerView, false, 1, null);
            ProgressBar progressBar = (ProgressBar) mo19852a(R.id.progress_bar);
            C8271i.m35382a((Object) progressBar, "progress_bar");
            ViewEx.m12840a(progressBar, false);
        }
    }

    /* renamed from: s */
    private final void m14339s() {
        LifecycleOwner lifecycleOwner = this;
        ((SearchVM) mo19853a()).mo21587b().observe(lifecycleOwner, new C3290n(this));
        ((SearchVM) mo19853a()).mo21588c().observe(lifecycleOwner, new C3291o(this));
        ((SearchVM) mo19853a()).mo21589d().observe(lifecycleOwner, new C3292p(this));
    }

    /* renamed from: t */
    private final void m14340t() {
        Window window = getWindow();
        C8271i.m35382a((Object) window, "window");
        window.getEnterTransition().addListener(new C3297u(this));
        LinearLayout linearLayout = (LinearLayout) mo19852a(R.id.lyt_result);
        C8271i.m35382a((Object) linearLayout, "lyt_result");
        linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new C3299v(this));
        View a = mo19852a(R.id.status_view2);
        C8271i.m35382a((Object) a, "status_view2");
        a.getLayoutParams().height = ImmersionBar.getStatusBarHeight(this);
        ((TagGroup) mo19852a(R.id.tag_history)).setOnTagItemClickListener(new C3300w(this));
        ((TagGroup) mo19852a(R.id.tag_recommend)).setOnTagItemClickListener(new C3301x(this));
        RecyclerView recyclerView = (RecyclerView) mo19852a(R.id.result_list);
        this.f11811i.setOnLoadMoreListener(new C3294r(this));
        this.f11811i.setNoMoreText("已经没有商品了");
        recyclerView.setAdapter(this.f11811i);
        recyclerView.addItemDecoration(((Builder) new Builder(this).drawable((int) R.drawable.divider)).margin(GloblaEx.m12810a(140.0f), 0).build());
        EditText editText = (EditText) mo19852a(R.id.edit_keyword);
        RxTextView.m12726a(editText).mo38904c((Consumer<? super T>) new C3295s<Object>(this));
        editText.setOnEditorActionListener(new C3296t(editText, this));
        m14341u();
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14323a(String str) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            m14344x();
            EditText editText = (EditText) mo19852a(R.id.edit_keyword);
            SoftInputUtil.m34790b(editText);
            editText.setText(charSequence);
            editText.setSelection(str.length());
            m14328b(this, str, false, 2, null);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m14328b(SearchActivity searchActivity, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        searchActivity.m14330b(str, z);
    }

    /* renamed from: b */
    private final void m14330b(String str, boolean z) {
        LinearLayout linearLayout = (LinearLayout) mo19852a(R.id.lyt_result);
        String str2 = "lyt_result";
        C8271i.m35382a((Object) linearLayout, str2);
        if (linearLayout.getVisibility() != 0) {
            m14342v();
        }
        SoftInputUtil.m34790b((EditText) mo19852a(R.id.edit_keyword));
        LinearLayout linearLayout2 = (LinearLayout) mo19852a(R.id.lyt_result);
        C8271i.m35382a((Object) linearLayout2, str2);
        ViewEx.m12840a(linearLayout2, false);
        ProgressBar progressBar = (ProgressBar) mo19852a(R.id.progress_bar);
        C8271i.m35382a((Object) progressBar, "progress_bar");
        ViewEx.m12840a(progressBar, false);
        RecyclerView recyclerView = (RecyclerView) mo19852a(R.id.result_list);
        C8271i.m35382a((Object) recyclerView, "result_list");
        ViewEx.m12841a(recyclerView, false, 1, null);
        m14324a(str, z);
    }

    /* renamed from: u */
    private final void m14341u() {
        TabLayout tabLayout = (TabLayout) mo19852a(R.id.tabs);
        m14314a((int) R.mipmap.ic_sort_down, "销量", true, 0);
        m14314a((int) R.mipmap.ic_sort_grey, "价格", false, 1);
        m14314a((int) R.mipmap.ic_sort_grey, "金币", false, 2);
        m14314a((int) R.mipmap.ic_sort_refresh, "筛选", false, 3);
        tabLayout.addOnTabSelectedListener(new C3293q(this));
    }

    /* renamed from: a */
    private final void m14314a(int i, String str, boolean z, int i2) {
        ItemSortTabBinding itemSortTabBinding = (ItemSortTabBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.item_sort_tab, null, false);
        android.widget.TextView textView = itemSortTabBinding.f11177b;
        String str2 = "binding.tabNameTxt";
        C8271i.m35382a((Object) textView, str2);
        textView.setText(str);
        if (i != 0) {
            itemSortTabBinding.f11176a.setImageResource(i);
        } else {
            ImageView imageView = itemSortTabBinding.f11176a;
            C8271i.m35382a((Object) imageView, "binding.tabImg");
            imageView.setVisibility(8);
        }
        TabLayout tabLayout = (TabLayout) mo19852a(R.id.tabs);
        Tab newTab = ((TabLayout) mo19852a(R.id.tabs)).newTab();
        C8271i.m35382a((Object) itemSortTabBinding, "binding");
        tabLayout.addTab(newTab.setCustomView(itemSortTabBinding.getRoot()), z);
        if (i2 == 0) {
            itemSortTabBinding.f11177b.setTextColor(GloblaEx.m12811a((int) R.color.orange_FFA229));
            android.widget.TextView textView2 = itemSortTabBinding.f11177b;
            C8271i.m35382a((Object) textView2, str2);
            TextPaint paint = textView2.getPaint();
            C8271i.m35382a((Object) paint, "binding.tabNameTxt.paint");
            paint.setFakeBoldText(true);
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14315a(Tab tab) {
        int position = tab.getPosition();
        View customView = tab.getCustomView();
        if (customView != null) {
            android.widget.TextView textView = (android.widget.TextView) customView.findViewById(R.id.tab_name_txt);
            textView.setTextColor(GloblaEx.m12811a((int) R.color.orange_FF661A));
            C8271i.m35382a((Object) textView, "textView");
            TextPaint paint = textView.getPaint();
            C8271i.m35382a((Object) paint, "textView.paint");
            paint.setFakeBoldText(true);
            ImageView imageView = (ImageView) customView.findViewById(R.id.tab_img);
            if (position == 0) {
                m14316a(this.f11814l, tab);
                String str = "";
                this.f11813k = str;
                this.f11812j = str;
                imageView.setImageResource(R.mipmap.ic_sort_down);
            } else if (position == 1) {
                m14316a(this.f11814l, tab);
                this.f11813k = "des";
                this.f11812j = "totalSales";
                imageView.setImageResource(R.mipmap.ic_sort_down);
            } else if (position != 2) {
                m14322a(this, false, 1, (Object) null);
                imageView.setImageResource(R.mipmap.ic_sort_refresh);
            } else {
                m14316a(this.f11814l, tab);
                this.f11813k = "asc";
                this.f11812j = "price";
                imageView.setImageResource(R.mipmap.ic_sort_down);
            }
        }
    }

    /* renamed from: v */
    private final void m14342v() {
        String str = "";
        this.f11813k = str;
        this.f11812j = str;
        TabLayout tabLayout = (TabLayout) mo19852a(R.id.tabs);
        int tabCount = tabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            Tab tabAt = tabLayout.getTabAt(i);
            if (i != 0) {
                m14316a(tabAt, (Tab) null);
            } else if (tabAt != null) {
                tabAt.select();
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m14322a(SearchActivity searchActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        searchActivity.m14335d(z);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final void m14335d(boolean z) {
        DrawerLayout drawerLayout = (DrawerLayout) mo19852a(R.id.lyt_drawer);
        if (z) {
            drawerLayout.openDrawer((int) GravityCompat.END);
        } else {
            drawerLayout.closeDrawer((int) GravityCompat.END);
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14316a(Tab tab, Tab tab2) {
        if (tab != null && !C8271i.m35384a((Object) tab, (Object) tab2)) {
            int position = tab.getPosition();
            View customView = tab.getCustomView();
            if (customView != null) {
                android.widget.TextView textView = (android.widget.TextView) customView.findViewById(R.id.tab_name_txt);
                C8271i.m35382a((Object) textView, "textView");
                TextPaint paint = textView.getPaint();
                C8271i.m35382a((Object) paint, "textView.paint");
                paint.setFakeBoldText(false);
                textView.setTextColor(GloblaEx.m12811a((int) R.color.textSecondary));
                ImageView imageView = (ImageView) customView.findViewById(R.id.tab_img);
                if (position != 3) {
                    imageView.setImageResource(R.mipmap.ic_sort_grey);
                } else {
                    imageView.setImageResource(R.mipmap.ic_sort_refresh);
                }
            }
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final void m14326b(Tab tab) {
        int position = tab.getPosition();
        View customView = tab.getCustomView();
        if (customView != null) {
            android.widget.TextView textView = (android.widget.TextView) customView.findViewById(R.id.tab_name_txt);
            ImageView imageView = (ImageView) customView.findViewById(R.id.tab_img);
            if (position == 2) {
                this.f11812j = "price";
                String str = "des";
                if (C8271i.m35384a((Object) this.f11813k, (Object) str)) {
                    this.f11813k = "asc";
                    imageView.setImageResource(R.mipmap.ic_sort_grey);
                    return;
                }
                this.f11813k = str;
                imageView.setImageResource(R.mipmap.ic_sort_down);
            } else if (position == 3) {
                m14322a(this, false, 1, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final void m14336e(boolean z) {
        ((DrawerLayout) mo19852a(R.id.lyt_drawer)).setDrawerLockMode(!z);
    }

    /* renamed from: w */
    private final void m14343w() {
        RecyclerView recyclerView = (RecyclerView) mo19852a(R.id.associate_list);
        C8271i.m35382a((Object) recyclerView, "associate_list");
        recyclerView.setAdapter(this.f11809g);
        ((RecyclerView) mo19852a(R.id.associate_list)).addItemDecoration(((Builder) new Builder(this).drawable((int) R.drawable.divider)).margin(GloblaEx.m12810a(20.0f), GloblaEx.m12810a(20.0f)).build());
        this.f11808f.setOnItemClick(new C3279c(this));
        this.f11808f.setOnItemBind(new C3280d(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: x */
    public final void m14344x() {
        this.f11815m = false;
        ((ActivitySearchBinding) mo19857b()).getRoot().postDelayed(new C3302y(this), 100);
    }

    public void onBackPressed() {
        super.onBackPressed();
        SoftInputUtil.m34789a((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SoftInputUtil.m34789a((Activity) this);
    }
}
