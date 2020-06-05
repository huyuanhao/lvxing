package com.yanzhenjie.album.widget.divider;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

/* renamed from: com.yanzhenjie.album.widget.divider.a */
class ColorDrawer extends Drawer {
    public ColorDrawer(int i, int i2, int i3) {
        super(new ColorDrawable(m33654a(i)), i2, i3);
    }

    /* renamed from: a */
    public static int m33654a(int i) {
        if (Color.alpha(i) == 0) {
            return i;
        }
        return Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
    }
}
