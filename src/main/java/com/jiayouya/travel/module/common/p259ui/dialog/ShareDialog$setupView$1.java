package com.jiayouya.travel.module.common.p259ui.dialog;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.jiayouya.travel.module.common.data.ShareItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo39189d2 = {"com/jiayouya/travel/module/common/ui/dialog/ShareDialog$setupView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ShareDilaog.kt */
/* renamed from: com.jiayouya.travel.module.common.ui.dialog.ShareDialog$setupView$1 */
public final class ShareDialog$setupView$1 extends OnScrollListener {
    /* renamed from: a */
    final /* synthetic */ ShareDilaog f11298a;

    ShareDialog$setupView$1(ShareDilaog cVar) {
        this.f11298a = cVar;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        C8271i.m35386b(recyclerView, "recyclerView");
        if (i == 0) {
            RecyclerView recyclerView2 = this.f11298a.f11309b.f10619d;
            C8271i.m35382a((Object) recyclerView2, "binding.list");
            LayoutManager layoutManager = recyclerView2.getLayoutManager();
            if (layoutManager == null) {
                return;
            }
            if (layoutManager != null) {
                int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
                List items = this.f11298a.f11311d.getItems();
                C8271i.m35382a((Object) items, "adapter.items");
                int i2 = 0;
                for (Object next : items) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        C8187k.m35272b();
                    }
                    ((ShareItem) next).setSelected(i2 == findFirstCompletelyVisibleItemPosition);
                    i2 = i3;
                }
                this.f11298a.f11311d.notifyDataSetChanged();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }
}
