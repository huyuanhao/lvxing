package com.jiayouya.travel.module.p276me.data;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/RectF;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
/* compiled from: MapItem.kt */
/* renamed from: com.jiayouya.travel.module.me.data.MapItem$markRect$2 */
final class MapItem$markRect$2 extends Lambda implements C8246a<RectF> {
    final /* synthetic */ MapItem this$0;

    MapItem$markRect$2(MapItem mapItem) {
        this.this$0 = mapItem;
        super(0);
    }

    public final RectF invoke() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        if (this.this$0.isScaleMark()) {
            f2 = this.this$0.getLocation().x;
            f = ((float) this.this$0.getMarkBitmap().getWidth()) * 0.5f;
        } else {
            f2 = this.this$0.getLocation().x;
            f = (float) this.this$0.getMarkBitmap().getWidth();
        }
        float f6 = f2 - (f / 2.0f);
        if (this.this$0.isScaleMark()) {
            f4 = this.this$0.getLocation().y;
            f3 = ((float) this.this$0.getMarkBitmap().getHeight()) * 0.5f;
        } else {
            f4 = this.this$0.getLocation().y;
            f3 = (float) this.this$0.getMarkBitmap().getHeight();
        }
        float f7 = f4 - f3;
        if (this.this$0.isScaleMark()) {
            f5 = this.this$0.getLocation().x + ((((float) this.this$0.getMarkBitmap().getWidth()) * 0.5f) / 2.0f);
        } else {
            f5 = (((float) this.this$0.getMarkBitmap().getWidth()) / 2.0f) + this.this$0.getLocation().x;
        }
        return new RectF(f6, f7, f5, this.this$0.getLocation().y);
    }
}
