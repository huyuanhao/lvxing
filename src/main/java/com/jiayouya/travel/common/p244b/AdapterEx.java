package com.jiayouya.travel.common.p244b;

import com.jiayouya.travel.module.common.data.ListEmptyData;
import ezy.app.data.DataPage;
import ezy.p653ui.widget.recyclerview.adapter.EndlessAdapter;
import ezy.p653ui.widget.recyclerview.adapter.MultiTypeAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\"\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a.\u0010\t\u001a\u00020\u0004*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\u0001¨\u0006\u000e"}, mo39189d2 = {"isEmpty", "", "Lezy/ui/widget/recyclerview/adapter/MultiTypeAdapter;", "setDataList", "", "list", "", "empty", "", "setDataPage", "Lezy/ui/widget/recyclerview/adapter/EndlessAdapter;", "dp", "Lezy/app/data/DataPage;", "isNotifyNow", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.b.b */
public final class AdapterEx {
    /* renamed from: a */
    public static /* synthetic */ void m12806a(EndlessAdapter endlessAdapter, DataPage dataPage, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = new ListEmptyData(null, 0, 3, null);
        }
        if ((i & 4) != 0) {
            z = true;
        }
        m12805a(endlessAdapter, dataPage, obj, z);
    }

    /* renamed from: a */
    public static final void m12805a(EndlessAdapter endlessAdapter, DataPage<?> dataPage, Object obj, boolean z) {
        C8271i.m35386b(endlessAdapter, "$this$setDataPage");
        if (dataPage != null && dataPage.isRefresh()) {
            endlessAdapter.getItems().clear();
        }
        if (dataPage != null) {
            List items = dataPage.getItems();
            if (items != null) {
                endlessAdapter.getItems().addAll(items);
            }
        }
        if (endlessAdapter.getItems().isEmpty()) {
            if (obj != null) {
                endlessAdapter.getItems().add(obj);
            }
            endlessAdapter.setLoadMoreVisible(false);
        } else if (dataPage == null || !dataPage.getHasMore()) {
            endlessAdapter.showEnded();
            endlessAdapter.setLoadMoreVisible(true);
        } else {
            endlessAdapter.setLoadMoreStatus(0);
            endlessAdapter.setLoadMoreVisible(true);
        }
        if (z) {
            endlessAdapter.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public static final boolean m12807a(MultiTypeAdapter multiTypeAdapter) {
        C8271i.m35386b(multiTypeAdapter, "$this$isEmpty");
        return multiTypeAdapter.getItems().isEmpty();
    }
}
