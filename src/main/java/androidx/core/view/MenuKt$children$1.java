package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¨\u0006\u0005"}, mo39189d2 = {"androidx/core/view/MenuKt$children$1", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "iterator", "", "core-ktx_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Menu.kt */
public final class MenuKt$children$1 implements Sequence<MenuItem> {
    final /* synthetic */ Menu $this_children;

    MenuKt$children$1(Menu menu) {
        this.$this_children = menu;
    }

    public Iterator<MenuItem> iterator() {
        return MenuKt.iterator(this.$this_children);
    }
}
