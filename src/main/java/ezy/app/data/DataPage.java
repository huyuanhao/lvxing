package ezy.app.data;

import java.util.List;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, mo39189d2 = {"Lezy/app/data/DataPage;", "ItemType", "", "()V", "hasMore", "", "getHasMore", "()Z", "isRefresh", "setRefresh", "(Z)V", "items", "", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "next", "", "getNext", "()Ljava/lang/String;", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DataPage.kt */
public class DataPage<ItemType> {
    private final boolean hasMore;
    private boolean isRefresh;
    private List<? extends ItemType> items;
    private final String next = "";

    public final String getNext() {
        return this.next;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<ItemType> getItems() {
        return this.items;
    }

    public final void setItems(List<? extends ItemType> list) {
        this.items = list;
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    public final void setRefresh(boolean z) {
        this.isRefresh = z;
    }
}
