package com.jiayouya.travel.module.p276me.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.jiayouya.travel.common.p244b.GloblaEx;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
/* compiled from: MapItem.kt */
/* renamed from: com.jiayouya.travel.module.me.data.MapItem$markBitmap$2 */
final class MapItem$markBitmap$2 extends Lambda implements C8246a<Bitmap> {
    final /* synthetic */ MapItem this$0;

    MapItem$markBitmap$2(MapItem mapItem) {
        this.this$0 = mapItem;
        super(0);
    }

    public final Bitmap invoke() {
        Drawable c = GloblaEx.m12820c(this.this$0.getResId());
        if (c != null) {
            return ((BitmapDrawable) c).getBitmap();
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
    }
}
