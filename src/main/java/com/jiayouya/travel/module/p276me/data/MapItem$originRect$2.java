package com.jiayouya.travel.module.p276me.data;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Rect;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
/* compiled from: MapItem.kt */
/* renamed from: com.jiayouya.travel.module.me.data.MapItem$originRect$2 */
final class MapItem$originRect$2 extends Lambda implements C8246a<Rect> {
    final /* synthetic */ MapItem this$0;

    MapItem$originRect$2(MapItem mapItem) {
        this.this$0 = mapItem;
        super(0);
    }

    public final Rect invoke() {
        return new Rect(0, 0, this.this$0.getMarkBitmap().getWidth(), this.this$0.getMarkBitmap().getHeight());
    }
}
