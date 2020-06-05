package p681me.jessyan.autosize;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import java.util.Locale;
import p681me.jessyan.autosize.external.ExternalAdaptInfo;
import p681me.jessyan.autosize.internal.CustomAdapt;
import p681me.jessyan.autosize.unit.Subunits;
import p681me.jessyan.autosize.utils.AutoSizeLog;
import p681me.jessyan.autosize.utils.Preconditions;

/* renamed from: me.jessyan.autosize.AutoSize */
public final class AutoSize {
    private static final int MODE_DEVICE_SIZE = Integer.MIN_VALUE;
    private static final int MODE_MASK = -1073741824;
    private static final int MODE_ON_WIDTH = 1073741824;
    private static final int MODE_SHIFT = 30;
    private static SparseArray<DisplayMetricsInfo> mCache = new SparseArray<>();

    /* renamed from: me.jessyan.autosize.AutoSize$1 */
    static /* synthetic */ class C83201 {
        static final /* synthetic */ int[] $SwitchMap$me$jessyan$autosize$unit$Subunits = new int[Subunits.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
            me.jessyan.autosize.unit.Subunits[] r0 = p681me.jessyan.autosize.unit.Subunits.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            $SwitchMap$me$jessyan$autosize$unit$Subunits = r0
            int[] r0 = $SwitchMap$me$jessyan$autosize$unit$Subunits     // Catch:{ NoSuchFieldError -> 0x0014 }
            me.jessyan.autosize.unit.Subunits r1 = p681me.jessyan.autosize.unit.Subunits.PT     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = $SwitchMap$me$jessyan$autosize$unit$Subunits     // Catch:{ NoSuchFieldError -> 0x001f }
            me.jessyan.autosize.unit.Subunits r1 = p681me.jessyan.autosize.unit.Subunits.MM     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = $SwitchMap$me$jessyan$autosize$unit$Subunits     // Catch:{ NoSuchFieldError -> 0x002a }
            me.jessyan.autosize.unit.Subunits r1 = p681me.jessyan.autosize.unit.Subunits.NONE     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = $SwitchMap$me$jessyan$autosize$unit$Subunits     // Catch:{ NoSuchFieldError -> 0x0035 }
            me.jessyan.autosize.unit.Subunits r1 = p681me.jessyan.autosize.unit.Subunits.IN     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: p681me.jessyan.autosize.AutoSize.C83201.m55189clinit():void");
        }
    }

    private AutoSize() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static boolean checkInit() {
        return AutoSizeConfig.getInstance().getInitDensity() != -1.0f;
    }

    public static void checkAndInit(Application application) {
        if (!checkInit()) {
            AutoSizeConfig.getInstance().setLog(true).init(application).setUseDeviceSize(false);
        }
    }

    public static void autoConvertDensityOfGlobal(Activity activity) {
        if (AutoSizeConfig.getInstance().isBaseOnWidth()) {
            autoConvertDensityBaseOnWidth(activity, (float) AutoSizeConfig.getInstance().getDesignWidthInDp());
        } else {
            autoConvertDensityBaseOnHeight(activity, (float) AutoSizeConfig.getInstance().getDesignHeightInDp());
        }
    }

    public static void autoConvertDensityOfCustomAdapt(Activity activity, CustomAdapt customAdapt) {
        int i;
        Preconditions.checkNotNull(customAdapt, "customAdapt == null");
        float sizeInDp = customAdapt.getSizeInDp();
        if (sizeInDp <= 0.0f) {
            if (customAdapt.isBaseOnWidth()) {
                i = AutoSizeConfig.getInstance().getDesignWidthInDp();
            } else {
                i = AutoSizeConfig.getInstance().getDesignHeightInDp();
            }
            sizeInDp = (float) i;
        }
        autoConvertDensity(activity, sizeInDp, customAdapt.isBaseOnWidth());
    }

    public static void autoConvertDensityOfExternalAdaptInfo(Activity activity, ExternalAdaptInfo externalAdaptInfo) {
        int i;
        Preconditions.checkNotNull(externalAdaptInfo, "externalAdaptInfo == null");
        float sizeInDp = externalAdaptInfo.getSizeInDp();
        if (sizeInDp <= 0.0f) {
            if (externalAdaptInfo.isBaseOnWidth()) {
                i = AutoSizeConfig.getInstance().getDesignWidthInDp();
            } else {
                i = AutoSizeConfig.getInstance().getDesignHeightInDp();
            }
            sizeInDp = (float) i;
        }
        autoConvertDensity(activity, sizeInDp, externalAdaptInfo.isBaseOnWidth());
    }

    public static void autoConvertDensityBaseOnWidth(Activity activity, float f) {
        autoConvertDensity(activity, f, true);
    }

    public static void autoConvertDensityBaseOnHeight(Activity activity, float f) {
        autoConvertDensity(activity, f, false);
    }

    public static void autoConvertDensity(Activity activity, float f, boolean z) {
        float f2;
        int i;
        int i2;
        int i3;
        int i4;
        float f3;
        float f4;
        float f5;
        int i5;
        float initScaledDensity;
        int i6;
        Activity activity2 = activity;
        Preconditions.checkNotNull(activity2, "activity == null");
        Preconditions.checkMainThread();
        if (z) {
            f2 = AutoSizeConfig.getInstance().getUnitsManager().getDesignWidth();
        } else {
            f2 = AutoSizeConfig.getInstance().getUnitsManager().getDesignHeight();
        }
        if (f2 <= 0.0f) {
            f2 = f;
        }
        if (z) {
            i = AutoSizeConfig.getInstance().getScreenWidth();
        } else {
            i = AutoSizeConfig.getInstance().getScreenHeight();
        }
        int round = Math.round((f + f2 + ((float) i)) * AutoSizeConfig.getInstance().getInitScaledDensity()) & 1073741823;
        int i7 = z ? round | MODE_ON_WIDTH : round & -1073741825;
        int i8 = AutoSizeConfig.getInstance().isUseDeviceSize() ? i7 | Integer.MIN_VALUE : i7 & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        DisplayMetricsInfo displayMetricsInfo = (DisplayMetricsInfo) mCache.get(i8);
        if (displayMetricsInfo == null) {
            if (z) {
                i5 = AutoSizeConfig.getInstance().getScreenWidth();
            } else {
                i5 = AutoSizeConfig.getInstance().getScreenHeight();
            }
            f3 = (((float) i5) * 1.0f) / f;
            if (AutoSizeConfig.getInstance().getPrivateFontScale() > 0.0f) {
                initScaledDensity = AutoSizeConfig.getInstance().getPrivateFontScale();
            } else if (AutoSizeConfig.getInstance().isExcludeFontScale()) {
                initScaledDensity = 1.0f;
            } else {
                initScaledDensity = (AutoSizeConfig.getInstance().getInitScaledDensity() * 1.0f) / AutoSizeConfig.getInstance().getInitDensity();
            }
            float f6 = initScaledDensity * f3;
            i4 = (int) (160.0f * f3);
            i3 = (int) (((float) AutoSizeConfig.getInstance().getScreenWidth()) / f3);
            i2 = (int) (((float) AutoSizeConfig.getInstance().getScreenHeight()) / f3);
            if (z) {
                i6 = AutoSizeConfig.getInstance().getScreenWidth();
            } else {
                i6 = AutoSizeConfig.getInstance().getScreenHeight();
            }
            float f7 = (((float) i6) * 1.0f) / f2;
            float f8 = f6;
            DisplayMetricsInfo displayMetricsInfo2 = r6;
            float f9 = f7;
            SparseArray<DisplayMetricsInfo> sparseArray = mCache;
            DisplayMetricsInfo displayMetricsInfo3 = new DisplayMetricsInfo(f3, i4, f6, f7, i3, i2);
            sparseArray.put(i8, displayMetricsInfo2);
            f5 = f8;
            f4 = f9;
        } else {
            f3 = displayMetricsInfo.getDensity();
            i4 = displayMetricsInfo.getDensityDpi();
            f5 = displayMetricsInfo.getScaledDensity();
            f4 = displayMetricsInfo.getXdpi();
            i3 = displayMetricsInfo.getScreenWidthDp();
            i2 = displayMetricsInfo.getScreenHeightDp();
        }
        setDensity(activity2, f3, i4, f5, f4);
        setScreenSizeDp(activity2, i3, i2);
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[13];
        objArr[0] = activity.getClass().getName();
        objArr[1] = activity.getClass().getSimpleName();
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = z ? "designWidthInDp" : "designHeightInDp";
        objArr[4] = Float.valueOf(f);
        objArr[5] = z ? "designWidthInSubunits" : "designHeightInSubunits";
        objArr[6] = Float.valueOf(f2);
        objArr[7] = Float.valueOf(f3);
        objArr[8] = Float.valueOf(f5);
        objArr[9] = Integer.valueOf(i4);
        objArr[10] = Float.valueOf(f4);
        objArr[11] = Integer.valueOf(i3);
        objArr[12] = Integer.valueOf(i2);
        AutoSizeLog.m35489d(String.format(locale, "The %s has been adapted! \n%s Info: isBaseOnWidth = %s, %s = %f, %s = %f, targetDensity = %f, targetScaledDensity = %f, targetDensityDpi = %d, targetXdpi = %f, targetScreenWidthDp = %d, targetScreenHeightDp = %d", objArr));
    }

    public static void cancelAdapt(Activity activity) {
        float f;
        Preconditions.checkMainThread();
        float initXdpi = AutoSizeConfig.getInstance().getInitXdpi();
        int i = C83201.$SwitchMap$me$jessyan$autosize$unit$Subunits[AutoSizeConfig.getInstance().getUnitsManager().getSupportSubunits().ordinal()];
        if (i != 1) {
            if (i == 2) {
                f = 25.4f;
            }
            setDensity(activity, AutoSizeConfig.getInstance().getInitDensity(), AutoSizeConfig.getInstance().getInitDensityDpi(), AutoSizeConfig.getInstance().getInitScaledDensity(), initXdpi);
            setScreenSizeDp(activity, AutoSizeConfig.getInstance().getInitScreenWidthDp(), AutoSizeConfig.getInstance().getInitScreenHeightDp());
        }
        f = 72.0f;
        initXdpi /= f;
        setDensity(activity, AutoSizeConfig.getInstance().getInitDensity(), AutoSizeConfig.getInstance().getInitDensityDpi(), AutoSizeConfig.getInstance().getInitScaledDensity(), initXdpi);
        setScreenSizeDp(activity, AutoSizeConfig.getInstance().getInitScreenWidthDp(), AutoSizeConfig.getInstance().getInitScreenHeightDp());
    }

    public static void initCompatMultiProcess(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        sb.append(context.getPackageName());
        sb.append(".autosize-init-provider");
        contentResolver.query(Uri.parse(sb.toString()), null, null, null, null);
    }

    private static void setDensity(Activity activity, float f, int i, float f2, float f3) {
        setDensity(activity.getResources().getDisplayMetrics(), f, i, f2, f3);
        setDensity(AutoSizeConfig.getInstance().getApplication().getResources().getDisplayMetrics(), f, i, f2, f3);
        DisplayMetrics metricsOnMiui = getMetricsOnMiui(activity.getResources());
        DisplayMetrics metricsOnMiui2 = getMetricsOnMiui(AutoSizeConfig.getInstance().getApplication().getResources());
        if (metricsOnMiui != null) {
            setDensity(metricsOnMiui, f, i, f2, f3);
        }
        if (metricsOnMiui2 != null) {
            setDensity(metricsOnMiui2, f, i, f2, f3);
        }
    }

    private static void setDensity(DisplayMetrics displayMetrics, float f, int i, float f2, float f3) {
        if (AutoSizeConfig.getInstance().getUnitsManager().isSupportDP()) {
            displayMetrics.density = f;
            displayMetrics.densityDpi = i;
        }
        if (AutoSizeConfig.getInstance().getUnitsManager().isSupportSP()) {
            displayMetrics.scaledDensity = f2;
        }
        int i2 = C83201.$SwitchMap$me$jessyan$autosize$unit$Subunits[AutoSizeConfig.getInstance().getUnitsManager().getSupportSubunits().ordinal()];
        if (i2 == 1) {
            displayMetrics.xdpi = f3 * 72.0f;
        } else if (i2 == 2) {
            displayMetrics.xdpi = f3 * 25.4f;
        } else if (i2 != 3 && i2 == 4) {
            displayMetrics.xdpi = f3;
        }
    }

    private static void setScreenSizeDp(Activity activity, int i, int i2) {
        if (AutoSizeConfig.getInstance().getUnitsManager().isSupportDP() && AutoSizeConfig.getInstance().getUnitsManager().isSupportScreenSizeDP()) {
            setScreenSizeDp(activity.getResources().getConfiguration(), i, i2);
            setScreenSizeDp(AutoSizeConfig.getInstance().getApplication().getResources().getConfiguration(), i, i2);
        }
    }

    private static void setScreenSizeDp(Configuration configuration, int i, int i2) {
        configuration.screenWidthDp = i;
        configuration.screenHeightDp = i2;
    }

    private static DisplayMetrics getMetricsOnMiui(Resources resources) {
        if (AutoSizeConfig.getInstance().isMiui() && AutoSizeConfig.getInstance().getTmpMetricsField() != null) {
            try {
                return (DisplayMetrics) AutoSizeConfig.getInstance().getTmpMetricsField().get(resources);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
