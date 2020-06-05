package p681me.jessyan.autosize;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.lang.reflect.Field;
import p681me.jessyan.autosize.external.ExternalAdaptManager;
import p681me.jessyan.autosize.unit.UnitsManager;
import p681me.jessyan.autosize.utils.AutoSizeLog;
import p681me.jessyan.autosize.utils.Preconditions;

/* renamed from: me.jessyan.autosize.AutoSizeConfig */
public final class AutoSizeConfig {
    public static final boolean DEPENDENCY_ANDROIDX;
    public static final boolean DEPENDENCY_SUPPORT;
    private static final String KEY_DESIGN_HEIGHT_IN_DP = "design_height_in_dp";
    private static final String KEY_DESIGN_WIDTH_IN_DP = "design_width_in_dp";
    private static volatile AutoSizeConfig sInstance;
    private boolean isBaseOnWidth = true;
    private boolean isCustomFragment;
    private boolean isExcludeFontScale;
    private boolean isMiui;
    private boolean isStop;
    private boolean isUseDeviceSize = true;
    /* access modifiers changed from: private */
    public boolean isVertical;
    private ActivityLifecycleCallbacksImpl mActivityLifecycleCallbacks;
    private Application mApplication;
    /* access modifiers changed from: private */
    public int mDesignHeightInDp;
    /* access modifiers changed from: private */
    public int mDesignWidthInDp;
    private ExternalAdaptManager mExternalAdaptManager = new ExternalAdaptManager();
    private float mInitDensity = -1.0f;
    private int mInitDensityDpi;
    /* access modifiers changed from: private */
    public float mInitScaledDensity;
    private int mInitScreenHeightDp;
    private int mInitScreenWidthDp;
    private float mInitXdpi;
    private onAdaptListener mOnAdaptListener;
    /* access modifiers changed from: private */
    public int mScreenHeight;
    /* access modifiers changed from: private */
    public int mScreenWidth;
    private int mStatusBarHeight;
    private Field mTmpMetricsField;
    private UnitsManager mUnitsManager = new UnitsManager();
    private float privateFontScale;

    static {
        String str = "androidx.fragment.app.FragmentActivity";
        DEPENDENCY_ANDROIDX = findClassByClassName(str);
        DEPENDENCY_SUPPORT = findClassByClassName(str);
    }

    private static boolean findClassByClassName(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static AutoSizeConfig getInstance() {
        if (sInstance == null) {
            synchronized (AutoSizeConfig.class) {
                if (sInstance == null) {
                    sInstance = new AutoSizeConfig();
                }
            }
        }
        return sInstance;
    }

    private AutoSizeConfig() {
    }

    public Application getApplication() {
        Preconditions.checkNotNull(this.mApplication, "Please call the AutoSizeConfig#init() first");
        return this.mApplication;
    }

    /* access modifiers changed from: 0000 */
    public AutoSizeConfig init(Application application) {
        return init(application, true, null);
    }

    /* access modifiers changed from: 0000 */
    public AutoSizeConfig init(Application application, boolean z) {
        return init(application, z, null);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0124, code lost:
            if ("XResources".equals(r6.getResources().getClass().getSimpleName()) != false) goto L_0x0126;
     */
    public p681me.jessyan.autosize.AutoSizeConfig init(final android.app.Application r6, boolean r7, p681me.jessyan.autosize.AutoAdaptStrategy r8) {
        /*
        r5 = this;
        float r0 = r5.mInitDensity
        r1 = 0
        r2 = 1
        r3 = -1082130432(0xffffffffbf800000, float:-1.0)
        int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
        if (r0 != 0) goto L_0x000c
        r0 = 1
        goto L_0x000d
    L_0x000c:
        r0 = 0
    L_0x000d:
        java.lang.String r3 = "AutoSizeConfig#init() can only be called once"
        p681me.jessyan.autosize.utils.Preconditions.checkArgument(r0, r3)
        java.lang.String r0 = "application == null"
        p681me.jessyan.autosize.utils.Preconditions.checkNotNull(r6, r0)
        r5.mApplication = r6
        r5.isBaseOnWidth = r7
        android.content.res.Resources r7 = android.content.res.Resources.getSystem()
        android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
        android.content.res.Resources r0 = android.content.res.Resources.getSystem()
        android.content.res.Configuration r0 = r0.getConfiguration()
        me.jessyan.autosize.AutoSizeConfig r3 = getInstance()
        me.jessyan.autosize.unit.UnitsManager r3 = r3.getUnitsManager()
        me.jessyan.autosize.unit.Subunits r3 = r3.getSupportSubunits()
        me.jessyan.autosize.unit.Subunits r4 = p681me.jessyan.autosize.unit.Subunits.NONE
        if (r3 != r4) goto L_0x0044
        r3 = 360(0x168, float:5.04E-43)
        r5.mDesignWidthInDp = r3
        r3 = 640(0x280, float:8.97E-43)
        r5.mDesignHeightInDp = r3
        goto L_0x004c
    L_0x0044:
        r3 = 1080(0x438, float:1.513E-42)
        r5.mDesignWidthInDp = r3
        r3 = 1920(0x780, float:2.69E-42)
        r5.mDesignHeightInDp = r3
    L_0x004c:
        r5.getMetaData(r6)
        android.content.res.Resources r3 = r6.getResources()
        android.content.res.Configuration r3 = r3.getConfiguration()
        int r3 = r3.orientation
        if (r3 != r2) goto L_0x005d
        r3 = 1
        goto L_0x005e
    L_0x005d:
        r3 = 0
    L_0x005e:
        r5.isVertical = r3
        int[] r3 = p681me.jessyan.autosize.utils.ScreenUtils.getScreenSize(r6)
        r1 = r3[r1]
        r5.mScreenWidth = r1
        r1 = r3[r2]
        r5.mScreenHeight = r1
        int r1 = p681me.jessyan.autosize.utils.ScreenUtils.getStatusBarHeight()
        r5.mStatusBarHeight = r1
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r3 = "designWidthInDp = "
        r1.append(r3)
        int r3 = r5.mDesignWidthInDp
        r1.append(r3)
        java.lang.String r3 = ", designHeightInDp = "
        r1.append(r3)
        int r3 = r5.mDesignHeightInDp
        r1.append(r3)
        java.lang.String r3 = ", screenWidth = "
        r1.append(r3)
        int r3 = r5.mScreenWidth
        r1.append(r3)
        java.lang.String r3 = ", screenHeight = "
        r1.append(r3)
        int r3 = r5.mScreenHeight
        r1.append(r3)
        java.lang.String r1 = r1.toString()
        p681me.jessyan.autosize.utils.AutoSizeLog.m35489d(r1)
        float r1 = r7.density
        r5.mInitDensity = r1
        int r1 = r7.densityDpi
        r5.mInitDensityDpi = r1
        float r1 = r7.scaledDensity
        r5.mInitScaledDensity = r1
        float r7 = r7.xdpi
        r5.mInitXdpi = r7
        int r7 = r0.screenWidthDp
        r5.mInitScreenWidthDp = r7
        int r7 = r0.screenHeightDp
        r5.mInitScreenHeightDp = r7
        me.jessyan.autosize.AutoSizeConfig$1 r7 = new me.jessyan.autosize.AutoSizeConfig$1
        r7.m55195init(r6)
        r6.registerComponentCallbacks(r7)
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        java.lang.String r0 = "initDensity = "
        r7.append(r0)
        float r0 = r5.mInitDensity
        r7.append(r0)
        java.lang.String r0 = ", initScaledDensity = "
        r7.append(r0)
        float r0 = r5.mInitScaledDensity
        r7.append(r0)
        java.lang.String r7 = r7.toString()
        p681me.jessyan.autosize.utils.AutoSizeLog.m35489d(r7)
        me.jessyan.autosize.ActivityLifecycleCallbacksImpl r7 = new me.jessyan.autosize.ActivityLifecycleCallbacksImpl
        me.jessyan.autosize.WrapperAutoAdaptStrategy r0 = new me.jessyan.autosize.WrapperAutoAdaptStrategy
        if (r8 != 0) goto L_0x00f1
        me.jessyan.autosize.DefaultAutoAdaptStrategy r8 = new me.jessyan.autosize.DefaultAutoAdaptStrategy
        r8.m55198init()
    L_0x00f1:
        r0.m55209init(r8)
        r7.m55186init(r0)
        r5.mActivityLifecycleCallbacks = r7
        me.jessyan.autosize.ActivityLifecycleCallbacksImpl r7 = r5.mActivityLifecycleCallbacks
        r6.registerActivityLifecycleCallbacks(r7)
        android.content.res.Resources r7 = r6.getResources()
        java.lang.Class r7 = r7.getClass()
        java.lang.String r7 = r7.getSimpleName()
        java.lang.String r8 = "MiuiResources"
        boolean r7 = r8.equals(r7)
        if (r7 != 0) goto L_0x0126
        android.content.res.Resources r6 = r6.getResources()
        java.lang.Class r6 = r6.getClass()
        java.lang.String r6 = r6.getSimpleName()
        java.lang.String r7 = "XResources"
        boolean r6 = r7.equals(r6)
        if (r6 == 0) goto L_0x013b
    L_0x0126:
        r5.isMiui = r2
        java.lang.Class<android.content.res.Resources> r6 = android.content.res.Resources.class
        java.lang.String r7 = "mTmpMetrics"
        java.lang.reflect.Field r6 = r6.getDeclaredField(r7)     // Catch:{ Exception -> 0x0138 }
        r5.mTmpMetricsField = r6     // Catch:{ Exception -> 0x0138 }
        java.lang.reflect.Field r6 = r5.mTmpMetricsField     // Catch:{ Exception -> 0x0138 }
        r6.setAccessible(r2)     // Catch:{ Exception -> 0x0138 }
        goto L_0x013b
    L_0x0138:
        r6 = 0
        r5.mTmpMetricsField = r6
    L_0x013b:
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p681me.jessyan.autosize.AutoSizeConfig.init(android.app.Application, boolean, me.jessyan.autosize.AutoAdaptStrategy):me.jessyan.autosize.AutoSizeConfig");
    }

    public void restart() {
        Preconditions.checkNotNull(this.mActivityLifecycleCallbacks, "Please call the AutoSizeConfig#init() first");
        synchronized (AutoSizeConfig.class) {
            if (this.isStop) {
                this.mApplication.registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
                this.isStop = false;
            }
        }
    }

    public void stop(Activity activity) {
        Preconditions.checkNotNull(this.mActivityLifecycleCallbacks, "Please call the AutoSizeConfig#init() first");
        synchronized (AutoSizeConfig.class) {
            if (!this.isStop) {
                this.mApplication.unregisterActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
                AutoSize.cancelAdapt(activity);
                this.isStop = true;
            }
        }
    }

    public AutoSizeConfig setAutoAdaptStrategy(AutoAdaptStrategy autoAdaptStrategy) {
        Preconditions.checkNotNull(autoAdaptStrategy, "autoAdaptStrategy == null");
        Preconditions.checkNotNull(this.mActivityLifecycleCallbacks, "Please call the AutoSizeConfig#init() first");
        this.mActivityLifecycleCallbacks.setAutoAdaptStrategy(new WrapperAutoAdaptStrategy(autoAdaptStrategy));
        return this;
    }

    public AutoSizeConfig setOnAdaptListener(onAdaptListener onadaptlistener) {
        Preconditions.checkNotNull(onadaptlistener, "onAdaptListener == null");
        this.mOnAdaptListener = onadaptlistener;
        return this;
    }

    public AutoSizeConfig setBaseOnWidth(boolean z) {
        this.isBaseOnWidth = z;
        return this;
    }

    public AutoSizeConfig setUseDeviceSize(boolean z) {
        this.isUseDeviceSize = z;
        return this;
    }

    public AutoSizeConfig setLog(boolean z) {
        AutoSizeLog.setDebug(z);
        return this;
    }

    public AutoSizeConfig setCustomFragment(boolean z) {
        this.isCustomFragment = z;
        return this;
    }

    public boolean isCustomFragment() {
        return this.isCustomFragment;
    }

    public boolean isStop() {
        return this.isStop;
    }

    public ExternalAdaptManager getExternalAdaptManager() {
        return this.mExternalAdaptManager;
    }

    public UnitsManager getUnitsManager() {
        return this.mUnitsManager;
    }

    public onAdaptListener getOnAdaptListener() {
        return this.mOnAdaptListener;
    }

    public boolean isBaseOnWidth() {
        return this.isBaseOnWidth;
    }

    public boolean isUseDeviceSize() {
        return this.isUseDeviceSize;
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    public int getScreenHeight() {
        return isUseDeviceSize() ? this.mScreenHeight : this.mScreenHeight - this.mStatusBarHeight;
    }

    public int getDesignWidthInDp() {
        Preconditions.checkArgument(this.mDesignWidthInDp > 0, "you must set design_width_in_dp  in your AndroidManifest file");
        return this.mDesignWidthInDp;
    }

    public int getDesignHeightInDp() {
        Preconditions.checkArgument(this.mDesignHeightInDp > 0, "you must set design_height_in_dp  in your AndroidManifest file");
        return this.mDesignHeightInDp;
    }

    public float getInitDensity() {
        return this.mInitDensity;
    }

    public int getInitDensityDpi() {
        return this.mInitDensityDpi;
    }

    public float getInitScaledDensity() {
        return this.mInitScaledDensity;
    }

    public float getInitXdpi() {
        return this.mInitXdpi;
    }

    public int getInitScreenWidthDp() {
        return this.mInitScreenWidthDp;
    }

    public int getInitScreenHeightDp() {
        return this.mInitScreenHeightDp;
    }

    public boolean isVertical() {
        return this.isVertical;
    }

    public boolean isMiui() {
        return this.isMiui;
    }

    public Field getTmpMetricsField() {
        return this.mTmpMetricsField;
    }

    public AutoSizeConfig setVertical(boolean z) {
        this.isVertical = z;
        return this;
    }

    public boolean isExcludeFontScale() {
        return this.isExcludeFontScale;
    }

    public AutoSizeConfig setExcludeFontScale(boolean z) {
        this.isExcludeFontScale = z;
        return this;
    }

    public AutoSizeConfig setPrivateFontScale(float f) {
        this.privateFontScale = f;
        return this;
    }

    public float getPrivateFontScale() {
        return this.privateFontScale;
    }

    public AutoSizeConfig setScreenWidth(int i) {
        Preconditions.checkArgument(i > 0, "screenWidth must be > 0");
        this.mScreenWidth = i;
        return this;
    }

    public AutoSizeConfig setScreenHeight(int i) {
        Preconditions.checkArgument(i > 0, "screenHeight must be > 0");
        this.mScreenHeight = i;
        return this;
    }

    public AutoSizeConfig setDesignWidthInDp(int i) {
        Preconditions.checkArgument(i > 0, "designWidthInDp must be > 0");
        this.mDesignWidthInDp = i;
        return this;
    }

    public AutoSizeConfig setDesignHeightInDp(int i) {
        Preconditions.checkArgument(i > 0, "designHeightInDp must be > 0");
        this.mDesignHeightInDp = i;
        return this;
    }

    public AutoSizeConfig setStatusBarHeight(int i) {
        Preconditions.checkArgument(i > 0, "statusBarHeight must be > 0");
        this.mStatusBarHeight = i;
        return this;
    }

    private void getMetaData(final Context context) {
        new Thread(new Runnable() {
            public void run() {
                String str = AutoSizeConfig.KEY_DESIGN_HEIGHT_IN_DP;
                String str2 = AutoSizeConfig.KEY_DESIGN_WIDTH_IN_DP;
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && applicationInfo.metaData != null) {
                        if (applicationInfo.metaData.containsKey(str2)) {
                            AutoSizeConfig.this.mDesignWidthInDp = ((Integer) applicationInfo.metaData.get(str2)).intValue();
                        }
                        if (applicationInfo.metaData.containsKey(str)) {
                            AutoSizeConfig.this.mDesignHeightInDp = ((Integer) applicationInfo.metaData.get(str)).intValue();
                        }
                    }
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
