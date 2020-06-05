package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\b\u001a\u00020\u0004H\u0002J\t\u0010\t\u001a\u00020\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo39189d2 = {"androidx/core/graphics/RegionKt$iterator$1", "", "Landroid/graphics/Rect;", "hasMore", "", "iterator", "Landroid/graphics/RegionIterator;", "rect", "hasNext", "next", "core-ktx_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Region.kt */
public final class RegionKt$iterator$1 implements Iterator<Rect> {
    final /* synthetic */ Region $this_iterator;
    private boolean hasMore = this.iterator.next(this.rect);
    private final RegionIterator iterator = new RegionIterator(this.$this_iterator);
    private final Rect rect = new Rect();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    RegionKt$iterator$1(Region region) {
        this.$this_iterator = region;
    }

    public boolean hasNext() {
        return this.hasMore;
    }

    public Rect next() {
        if (this.hasMore) {
            Rect rect2 = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return rect2;
        }
        throw new IndexOutOfBoundsException();
    }
}