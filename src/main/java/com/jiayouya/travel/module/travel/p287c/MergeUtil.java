package com.jiayouya.travel.module.travel.p287c;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.jiayouya.travel.C2835b;
import com.jiayouya.travel.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u001a\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u001a\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¨\u0006\u0012"}, mo39189d2 = {"centerDistance", "", "rect1", "Landroid/graphics/Rect;", "rect2", "findMaxCoverView", "Landroid/view/View;", "curView", "list", "", "getDogRes", "", "dogId", "getDogRes2", "isLovers", "", "dogId1", "dogId2", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.c.c */
public final class MergeUtil {
    /* renamed from: a */
    public static final boolean m14454a(int i, int i2) {
        return (i == 43 && i2 == 44) || (i == 44 && i2 == 43);
    }

    /* renamed from: a */
    public static final View m14453a(View view, List<? extends View> list) {
        C8271i.m35386b(view, "curView");
        C8271i.m35386b(list, "list");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        View view2 = null;
        double d = -1.0d;
        for (View view3 : list) {
            if (!C8271i.m35384a((Object) view3, (Object) view)) {
                Rect rect2 = new Rect();
                view3.getGlobalVisibleRect(rect2);
                if (Rect.intersects(rect, rect2)) {
                    double a = m14451a(rect, rect2);
                    if (d == -1.0d || a < d) {
                        view2 = view3;
                        d = a;
                    }
                }
            }
        }
        return view2;
    }

    /* renamed from: a */
    public static final double m14451a(Rect rect, Rect rect2) {
        C8271i.m35386b(rect, "rect1");
        C8271i.m35386b(rect2, "rect2");
        int abs = Math.abs(rect.centerX() - rect2.centerX());
        int abs2 = Math.abs(rect.centerY() - rect2.centerY());
        if (abs == 0 && abs2 == 0) {
            return 0.0d;
        }
        double d = (double) abs2;
        return Math.sqrt(((double) (abs * abs)) + (d * d));
    }

    /* renamed from: a */
    public static final int m14452a(int i) {
        if (i == 38) {
            return R.mipmap.ic_dog_xianshi;
        }
        Resources resources = C2835b.f9544a.getResources();
        StringBuilder sb = new StringBuilder();
        sb.append("ic_dog_level");
        sb.append(i);
        return resources.getIdentifier(sb.toString(), "mipmap", C2835b.f9544a.getPackageName());
    }

    /* renamed from: b */
    public static final int m14455b(int i) {
        if (i == 38) {
            return R.mipmap.ic_dog_level47;
        }
        Resources resources = C2835b.f9544a.getResources();
        StringBuilder sb = new StringBuilder();
        sb.append("ic_dog_level");
        sb.append(i);
        return resources.getIdentifier(sb.toString(), "mipmap", C2835b.f9544a.getPackageName());
    }
}
