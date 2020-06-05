package com.gyf.barlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;

class BarConfig {
    private static final String MIUI_FORCE_FSG_NAV_BAR = "force_fsg_nav_bar";
    private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
    private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    private static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";
    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
    private final int mActionBarHeight;
    private final boolean mHasNavigationBar;
    private final boolean mHasNotchScreen;
    private final boolean mInPortrait;
    private final int mNavigationBarHeight;
    private final int mNavigationBarWidth;
    private final float mSmallestWidthDp;
    private final int mStatusBarHeight;

    BarConfig(Activity activity) {
        boolean z = false;
        this.mInPortrait = activity.getResources().getConfiguration().orientation == 1;
        this.mSmallestWidthDp = getSmallestWidthDp(activity);
        this.mStatusBarHeight = getInternalDimensionSize(activity, STATUS_BAR_HEIGHT_RES_NAME);
        this.mActionBarHeight = getActionBarHeight(activity);
        this.mNavigationBarHeight = getNavigationBarHeight(activity);
        this.mNavigationBarWidth = getNavigationBarWidth(activity);
        if (this.mNavigationBarHeight > 0) {
            z = true;
        }
        this.mHasNavigationBar = z;
        this.mHasNotchScreen = NotchUtils.hasNotchScreen(activity);
    }

    private int getActionBarHeight(Context context) {
        if (VERSION.SDK_INT < 14) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843499, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    private int getNavigationBarHeight(Context context) {
        if (VERSION.SDK_INT < 14 || !hasNavBar((Activity) context)) {
            return 0;
        }
        return getInternalDimensionSize(context, this.mInPortrait ? NAV_BAR_HEIGHT_RES_NAME : NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME);
    }

    private int getNavigationBarWidth(Context context) {
        if (VERSION.SDK_INT < 14 || !hasNavBar((Activity) context)) {
            return 0;
        }
        return getInternalDimensionSize(context, NAV_BAR_WIDTH_RES_NAME);
    }

    private boolean hasNavBar(Activity activity) {
        boolean z = false;
        if (VERSION.SDK_INT >= 17 && Global.getInt(activity.getContentResolver(), MIUI_FORCE_FSG_NAV_BAR, 0) != 0) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        }
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i3 = displayMetrics2.heightPixels;
        if (i2 - displayMetrics2.widthPixels > 0 || i - i3 > 0) {
            z = true;
        }
        return z;
    }

    private int getInternalDimensionSize(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                return Math.round((((float) dimensionPixelSize) * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density);
            }
        } catch (NotFoundException unused) {
        }
        return 0;
    }

    private float getSmallestWidthDp(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (VERSION.SDK_INT >= 16) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        return Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    /* access modifiers changed from: 0000 */
    public boolean isNavigationAtBottom() {
        return this.mSmallestWidthDp >= 600.0f || this.mInPortrait;
    }

    /* access modifiers changed from: 0000 */
    public int getStatusBarHeight() {
        return this.mStatusBarHeight;
    }

    /* access modifiers changed from: 0000 */
    public int getActionBarHeight() {
        return this.mActionBarHeight;
    }

    /* access modifiers changed from: 0000 */
    public boolean hasNavigationBar() {
        return this.mHasNavigationBar;
    }

    /* access modifiers changed from: 0000 */
    public int getNavigationBarHeight() {
        return this.mNavigationBarHeight;
    }

    /* access modifiers changed from: 0000 */
    public int getNavigationBarWidth() {
        return this.mNavigationBarWidth;
    }

    /* access modifiers changed from: 0000 */
    public boolean hasNotchScreen() {
        return this.mHasNotchScreen;
    }
}
