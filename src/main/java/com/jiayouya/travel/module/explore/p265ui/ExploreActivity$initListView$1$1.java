package com.jiayouya.travel.module.explore.p265ui;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo39189d2 = {"com/jiayouya/travel/module/explore/ui/ExploreActivity$initListView$1$1", "Landroidx/recyclerview/widget/GridLayoutManager;", "canScrollVertically", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ExploreActivity.kt */
/* renamed from: com.jiayouya.travel.module.explore.ui.ExploreActivity$initListView$1$1 */
public final class ExploreActivity$initListView$1$1 extends GridLayoutManager {
    /* renamed from: a */
    final /* synthetic */ RecyclerView f11426a;

    public boolean canScrollVertically() {
        return false;
    }

    ExploreActivity$initListView$1$1(RecyclerView recyclerView, Context context, int i) {
        this.f11426a = recyclerView;
        super(context, i);
    }
}
