package p681me.jessyan.autosize.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: me.jessyan.autosize.utils.ScreenUtils */
public class ScreenUtils {
    private ScreenUtils() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static int getStatusBarHeight() {
        try {
            int identifier = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return Resources.getSystem().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (NotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int[] getScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static int[] getRawScreenSize(Context context) {
        int[] iArr = new int[2];
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (VERSION.SDK_INT >= 14 && VERSION.SDK_INT < 17) {
            try {
                i = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i2 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        if (VERSION.SDK_INT >= 17) {
            try {
                Point point = new Point();
                Display.class.getMethod("getRealSize", new Class[]{Point.class}).invoke(defaultDisplay, new Object[]{point});
                i = point.x;
                i2 = point.y;
            } catch (Exception unused2) {
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    public static int getHeightOfNavigationBar(Context context) {
        if (VERSION.SDK_INT < 17 || Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
            return getRawScreenSize(context)[1] - getScreenSize(context)[1];
        }
        return 0;
    }
}
