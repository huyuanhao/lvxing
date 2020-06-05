package com.tencent.p605ep.commonbase.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.p605ep.commonbase.api.AppContext;
import com.tencent.p605ep.commonbase.api.Log;

/* renamed from: com.tencent.ep.commonbase.utils.ScreenUtil */
public final class ScreenUtil {
    public static final int G8_DENSITY = 120;
    public static final int G8_HEIGHT = 320;
    public static final int G8_WIDTH = 240;
    public static final int M9_DENSITY = 320;
    public static final int M9_HEIGHT = 960;
    public static final int M9_WIDTH = 640;
    static final String MEIZU_MX2_M040 = "M040";
    static final String MEIZU_MX2_M045 = "M045";
    static final String MEIZU_MX3 = "M353";
    public static final int N7_DENSITY = 213;
    public static final int N7_HEIGHT = 1205;
    public static final int N7_WIDTH = 800;
    static int mAutoLayoutHeight = 0;
    public static int mBoxHeight = 0;
    static float mBoxPercent = 0.215f;
    public static int mDensityDpi = 0;
    static int mFrameworkHeight = 0;
    public static int mListHeight = 0;
    static float mListPercent = 0.71f;
    private static int mScreenHeight;
    private static int mScreenWidth;

    static {
        setParams();
    }

    public static int getDensityDpi() {
        return AppContext.getAppContext().getResources().getDisplayMetrics().densityDpi;
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        try {
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static int getNotificationBarHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static int getRealHeight() {
        WindowManager windowManager = (WindowManager) AppContext.getAppContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        try {
            Class cls = Class.forName("android.view.Display");
            if (VERSION.SDK_INT > 8) {
                cls.getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics});
            }
            return displayMetrics.heightPixels;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int getScreenHeight() {
        return AppContext.getAppContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return AppContext.getAppContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getXBigScreenHeight(int i) {
        return isXBigScreen() ? (int) ((((float) getScreenWidth()) / 480.0f) * ((float) i)) : i;
    }

    public static boolean is1280BigScreen() {
        return setParams() && mScreenHeight >= 1280 && !isNexus7Series() && mScreenHeight < 1920;
    }

    public static boolean is1920BigScreen() {
        return setParams() && mScreenHeight >= 1920;
    }

    public static boolean is854Screen() {
        if (setParams()) {
            int i = mScreenHeight;
            if (i >= 854 && i < 960) {
                return true;
            }
        }
        return false;
    }

    public static boolean is960Screen() {
        return setParams() && mScreenHeight >= 960 && !isM9Series() && mScreenHeight < 1280;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
            if (isM9Series() == false) goto L_0x0022;
     */
    public static boolean isBigScreen() {
        /*
        boolean r0 = setParams()
        if (r0 == 0) goto L_0x001c
        int r0 = mDensityDpi
        r1 = 160(0xa0, float:2.24E-43)
        if (r0 <= r1) goto L_0x001c
        r1 = 240(0xf0, float:3.36E-43)
        if (r0 > r1) goto L_0x001c
        int r0 = mScreenHeight
        r1 = 800(0x320, float:1.121E-42)
        if (r0 > r1) goto L_0x001c
        boolean r0 = isM9Series()
        if (r0 == 0) goto L_0x0022
    L_0x001c:
        boolean r0 = isNexus7Series()
        if (r0 == 0) goto L_0x0024
    L_0x0022:
        r0 = 1
        goto L_0x0025
    L_0x0024:
        r0 = 0
    L_0x0025:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.ScreenUtil.isBigScreen():boolean");
    }

    public static boolean isG8Series() {
        return setParams() && mScreenWidth == 240 && mScreenHeight == 320 && mDensityDpi == 120;
    }

    public static boolean isM9Series() {
        return setParams() && mScreenWidth == 640 && mScreenHeight == 960 && mDensityDpi == 320;
    }

    public static boolean isMSmallScreen() {
        return isG8Series();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
            if (r0 <= 160) goto L_0x0016;
     */
    public static boolean isMiddleScreen() {
        /*
        boolean r0 = setParams()
        if (r0 == 0) goto L_0x0010
        int r0 = mDensityDpi
        r1 = 120(0x78, float:1.68E-43)
        if (r0 <= r1) goto L_0x0010
        r1 = 160(0xa0, float:2.24E-43)
        if (r0 <= r1) goto L_0x0016
    L_0x0010:
        boolean r0 = isM9Series()
        if (r0 == 0) goto L_0x0018
    L_0x0016:
        r0 = 1
        goto L_0x0019
    L_0x0018:
        r0 = 0
    L_0x0019:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.ScreenUtil.isMiddleScreen():boolean");
    }

    public static boolean isNexus7Series() {
        return setParams() && mScreenWidth == 800 && mScreenHeight == 1205 && mDensityDpi == 213;
    }

    public static boolean isSmallScreen() {
        return setParams() && mDensityDpi <= 120;
    }

    public static boolean isXBigScreen() {
        return setParams() && !isSmallScreen() && !isMiddleScreen() && !isBigScreen() && !isM9Series();
    }

    public static void setAutoLayoutHeight(int i) {
        mAutoLayoutHeight = i;
    }

    public static boolean setParams() {
        DisplayMetrics displayMetrics = AppContext.getAppContext().getResources().getDisplayMetrics();
        mScreenWidth = displayMetrics.widthPixels;
        mScreenHeight = displayMetrics.heightPixels;
        mDensityDpi = displayMetrics.densityDpi;
        StringBuilder sb = new StringBuilder();
        sb.append("ScreenUtil setParams mDensityDpi ");
        sb.append(mDensityDpi);
        sb.append(" mScreenWidth ");
        sb.append(mScreenWidth);
        sb.append(" mScreenHeight ");
        sb.append(mScreenHeight);
        Log.m31483i("ScreenUtil", sb.toString());
        return true;
    }
}
