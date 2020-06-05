package com.jiayouya.travel.module.p276me.p279ui;

import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.databinding.ActivityInviteLogsBinding;
import com.jiayouya.travel.module.common.widget.SimplePagerAdapter;
import com.jiayouya.travel.module.group.p269vm.InviteLogsVM;
import com.jiayouya.travel.module.p276me.p279ui.dialog.SortPopWindow;
import com.jiayouya.travel.module.p276me.p279ui.fragment.InviteLogsFragment;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/InviteLogsActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityInviteLogsBinding;", "Lcom/jiayouya/travel/module/group/vm/InviteLogsVM;", "()V", "fragments", "", "Lcom/jiayouya/travel/module/me/ui/fragment/InviteLogsFragment;", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setTabClick", "", "position", "setTabStatus", "selectedView", "Landroid/view/View;", "setupClick", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: InviteLogsActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.InviteLogsActivity */
public final class InviteLogsActivity extends BaseActivity<ActivityInviteLogsBinding, InviteLogsVM> {
    /* renamed from: c */
    private final List<InviteLogsFragment> f11594c = C8187k.m35271b(InviteLogsFragment.f11685d.mo21434a(1), InviteLogsFragment.f11685d.mo21434a(2), InviteLogsFragment.f11685d.mo21434a(3));
    /* renamed from: d */
    private HashMap f11595d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteLogsActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.InviteLogsActivity$a */
    static final class C3139a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ int $position;
        final /* synthetic */ InviteLogsActivity this$0;

        C3139a(InviteLogsActivity inviteLogsActivity, int i) {
            this.this$0 = inviteLogsActivity;
            this.$position = i;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.m14001a(view);
            ViewPager viewPager = (ViewPager) this.this$0.mo19852a(R.id.view_pager);
            C8271i.m35382a((Object) viewPager, "view_pager");
            viewPager.setCurrentItem(this.$position);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteLogsActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.InviteLogsActivity$b */
    static final class C3140b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ InviteLogsActivity this$0;

        C3140b(InviteLogsActivity inviteLogsActivity) {
            this.this$0 = inviteLogsActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            new SortPopWindow(this.this$0, C31411.INSTANCE).showAsDropDown((TextView) this.this$0.mo19852a(R.id.tv_sort));
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11595d == null) {
            this.f11595d = new HashMap();
        }
        View view = (View) this.f11595d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11595d.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_invite_logs;
    }

    /* renamed from: d */
    public Class<InviteLogsVM> mo19861d() {
        return InviteLogsVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        ViewPager viewPager = (ViewPager) mo19852a(R.id.view_pager);
        C8271i.m35382a((Object) viewPager, "view_pager");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Object[] array = this.f11594c.toArray(new InviteLogsFragment[0]);
        if (array != null) {
            viewPager.setAdapter(new SimplePagerAdapter(supportFragmentManager, (Fragment[]) array));
            ((ViewPager) mo19852a(R.id.view_pager)).addOnPageChangeListener(new InviteLogsActivity$setupView$1(this));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* renamed from: k */
    public void mo19868k() {
        LinearLayout linearLayout = (LinearLayout) mo19852a(R.id.lyt_tab);
        C8271i.m35382a((Object) linearLayout, "lyt_tab");
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = ((LinearLayout) mo19852a(R.id.lyt_tab)).getChildAt(i);
            m14003b(i);
            if (i == 0) {
                C8271i.m35382a((Object) childAt, "child");
                m14001a(childAt);
            }
        }
        TextView textView = (TextView) mo19852a(R.id.tv_sort);
        C8271i.m35382a((Object) textView, "tv_sort");
        ezy.p642a.View.m34750a(textView, 0, new C3140b(this), 1, null);
    }

    /* renamed from: b */
    private final void m14003b(int i) {
        View childAt = ((LinearLayout) mo19852a(R.id.lyt_tab)).getChildAt(i);
        C8271i.m35382a((Object) childAt, "child");
        ezy.p642a.View.m34750a(childAt, 0, new C3139a(this, i), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14001a(View view) {
        LinearLayout linearLayout = (LinearLayout) mo19852a(R.id.lyt_tab);
        C8271i.m35382a((Object) linearLayout, "lyt_tab");
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = ((LinearLayout) mo19852a(R.id.lyt_tab)).getChildAt(i);
            C8271i.m35382a((Object) childAt, "child");
            childAt.setSelected(C8271i.m35384a((Object) childAt, (Object) view));
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                TextPaint paint = textView.getPaint();
                C8271i.m35382a((Object) paint, "child.paint");
                paint.setFakeBoldText(textView.isSelected());
            }
        }
    }
}
