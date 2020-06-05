package com.jiayouya.travel.common.p244b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0002\u001a\f\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u0002¨\u0006\n"}, mo39189d2 = {"gone", "", "Landroid/view/View;", "isGone", "", "invisible", "isInvisible", "isVisible", "screenshot", "Landroid/graphics/Bitmap;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.b.k */
public final class ViewEx {
    /* renamed from: a */
    public static final Bitmap m12839a(View view) {
        C8271i.m35386b(view, "$this$screenshot");
        if (view.getHeight() == 0 || view.getWidth() == 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        view.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    public static /* synthetic */ void m12841a(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        m12840a(view, z);
    }

    /* renamed from: a */
    public static final void m12840a(View view, boolean z) {
        C8271i.m35386b(view, "$this$gone");
        view.setVisibility(z ? 8 : 0);
    }

    /* renamed from: b */
    public static /* synthetic */ void m12843b(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        m12842b(view, z);
    }

    /* renamed from: b */
    public static final void m12842b(View view, boolean z) {
        C8271i.m35386b(view, "$this$invisible");
        view.setVisibility(z ? 4 : 0);
    }

    /* renamed from: b */
    public static final boolean m12844b(View view) {
        C8271i.m35386b(view, "$this$isVisible");
        return view.getVisibility() == 0;
    }
}
