package com.yanzhenjie.loading;

import android.content.Context;

public class Utils {
    public static float dip2px(Context context, float f) {
        return (float) ((((double) context.getResources().getDisplayMetrics().density) + 0.5d) * ((double) f));
    }

    public static float px2dip(Context context, int i) {
        return (float) (((double) i) / (((double) context.getResources().getDisplayMetrics().density) + 0.5d));
    }
}
