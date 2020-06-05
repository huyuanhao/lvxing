package com.jiayouya.travel.module.explore.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.databinding.ItemExploreTeamBinding;
import com.jiayouya.travel.module.explore.data.TeamItem;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/widget/TeamView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "Lcom/jiayouya/travel/databinding/ItemExploreTeamBinding;", "kotlin.jvm.PlatformType", "getB", "()Lcom/jiayouya/travel/databinding/ItemExploreTeamBinding;", "b$delegate", "Lkotlin/Lazy;", "setData", "", "item", "Lcom/jiayouya/travel/module/explore/data/TeamItem;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TeamView.kt */
public final class TeamView extends FrameLayout {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f11478a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(TeamView.class), "b", "getB()Lcom/jiayouya/travel/databinding/ItemExploreTeamBinding;"))};
    /* renamed from: b */
    private final Lazy f11479b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "Lcom/jiayouya/travel/databinding/ItemExploreTeamBinding;", "kotlin.jvm.PlatformType", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TeamView.kt */
    /* renamed from: com.jiayouya.travel.module.explore.widget.TeamView$a */
    static final class C3041a extends Lambda implements C8246a<ItemExploreTeamBinding> {
        final /* synthetic */ Context $context;

        C3041a(Context context) {
            this.$context = context;
            super(0);
        }

        public final ItemExploreTeamBinding invoke() {
            return (ItemExploreTeamBinding) DataBindingUtil.inflate(LayoutInflater.from(this.$context), R.layout.item_explore_team, null, false);
        }
    }

    private final ItemExploreTeamBinding getB() {
        Lazy bVar = this.f11479b;
        C8280j jVar = f11478a[0];
        return (ItemExploreTeamBinding) bVar.getValue();
    }

    public TeamView(Context context, AttributeSet attributeSet) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(attributeSet, "attrs");
        super(context, attributeSet);
        this.f11479b = C8182c.m35317a(new C3041a(context));
        LayoutParams layoutParams = new LayoutParams(GloblaEx.m12810a(50.0f), GloblaEx.m12810a(50.0f));
        ItemExploreTeamBinding b = getB();
        C8271i.m35382a((Object) b, "b");
        addView(b.getRoot(), layoutParams);
    }

    public final void setData(TeamItem teamItem) {
        C8271i.m35386b(teamItem, "item");
        ItemExploreTeamBinding b = getB();
        C8271i.m35382a((Object) b, "b");
        b.mo20183a(teamItem);
        getB().executePendingBindings();
    }
}
