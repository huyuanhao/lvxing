package com.tencent.bugly.beta.tinker;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.tinker.TinkerReport.Reporter;
import com.tencent.bugly.beta.tinker.TinkerUtils.ScreenState;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.library.TinkerLoadLibrary;
import com.tencent.tinker.lib.listener.PatchListener;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.patch.UpgradePatch;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerApplicationHelper;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;

/* compiled from: BUGLY */
public class TinkerManager {
    public static final String MF_FILE = "YAPATCH.MF";
    public static final String PATCH_DIR = "dex";
    public static final String PATCH_NAME = "patch.apk";
    private static final String TAG = "Tinker.TinkerManager";
    public static String apkOriginalBuildNum = null;
    private static boolean isInstalled = false;
    public static String patchCurBuildNum;
    public static boolean patchRestartOnScreenOff = true;
    static TinkerPatchResultListener patchResultListener;
    private static UncaughtExceptionHandler systemExceptionHandler;
    private static TinkerManager tinkerManager = new TinkerManager();
    public static TinkerReport tinkerReport;
    private static TinkerUncaughtExceptionHandler uncaughtExceptionHandler;
    static LoadReporter userLoadReporter;
    static PatchListener userPatchListener;
    static PatchReporter userPatchReporter;
    static AbstractPatch userUpgradePatchProcessor;
    private Application application;
    private ApplicationLike applicationLike;
    /* access modifiers changed from: private */
    public TinkerListener tinkerListener;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.beta.tinker.TinkerManager$TinkerListener */
    public interface TinkerListener {
        void onApplyFailure(String str);

        void onApplySuccess(String str);

        void onDownloadFailure(String str);

        void onDownloadSuccess(String str);

        void onPatchRollback();

        void onPatchStart();
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.beta.tinker.TinkerManager$TinkerPatchResultListener */
    public interface TinkerPatchResultListener {
        void onPatchResult(PatchResult patchResult);
    }

    static {
        String str = "";
        apkOriginalBuildNum = str;
        patchCurBuildNum = str;
    }

    public static boolean isPatchRestartOnScreenOff() {
        return patchRestartOnScreenOff;
    }

    public static void setPatchRestartOnScreenOff(boolean z) {
        patchRestartOnScreenOff = z;
    }

    public static TinkerManager getInstance() {
        return tinkerManager;
    }

    private void setTinkerApplicationLike(ApplicationLike applicationLike2) {
        this.applicationLike = applicationLike2;
        if (applicationLike2 != null) {
            this.application = applicationLike2.getApplication();
        }
    }

    public static ApplicationLike getTinkerApplicationLike() {
        return getInstance().applicationLike;
    }

    public static Application getApplication() {
        return getInstance().application;
    }

    public static void registJavaCrashHandler() {
        if (uncaughtExceptionHandler == null) {
            systemExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            uncaughtExceptionHandler = new TinkerUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    public static void unregistJavaCrashHandler() {
        UncaughtExceptionHandler uncaughtExceptionHandler2 = systemExceptionHandler;
        if (uncaughtExceptionHandler2 != null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler2);
        }
    }

    public static void setUpgradeRetryEnable(boolean z) {
        UpgradePatchRetry.getInstance(getTinkerApplicationLike().getApplication()).setRetryEnable(z);
    }

    private static void installDefaultTinker(ApplicationLike applicationLike2) {
        boolean z = isInstalled;
        String str = TAG;
        if (z) {
            TinkerLog.w(str, "install tinker, but has installed, ignore", new Object[0]);
        } else if (applicationLike2 == null) {
            TinkerLog.e(str, "Tinker ApplicationLike is null", new Object[0]);
        } else {
            getInstance().setTinkerApplicationLike(applicationLike2);
            registJavaCrashHandler();
            setUpgradeRetryEnable(true);
            tinkerReport = new TinkerReport();
            TinkerLog.setTinkerLogImp(new TinkerLogger());
            if (TinkerInstaller.install(applicationLike2, new TinkerLoadReporter(applicationLike2.getApplication()), new TinkerPatchReporter(applicationLike2.getApplication()), new TinkerPatchListener(applicationLike2.getApplication()), TinkerResultService.class, new UpgradePatch()) != null) {
                isInstalled = true;
            }
        }
    }

    public static void installTinker(Object obj) {
        String str = TAG;
        if (obj == null) {
            TinkerLog.e(str, "Tinker ApplicationLike is null", new Object[0]);
            return;
        }
        if (obj instanceof ApplicationLike) {
            installDefaultTinker((ApplicationLike) obj);
        } else {
            TinkerLog.e(str, "NOT tinker ApplicationLike object", new Object[0]);
        }
    }

    public static void installTinker(Object obj, Object obj2, Object obj3, Object obj4, TinkerPatchResultListener tinkerPatchResultListener, Object obj5) {
        String str = TAG;
        if (obj2 != null) {
            if (obj2 instanceof LoadReporter) {
                userLoadReporter = (LoadReporter) obj2;
            } else {
                TinkerLog.e(str, "NOT LoadReporter object", new Object[0]);
                return;
            }
        }
        if (obj3 != null) {
            if (obj3 instanceof PatchReporter) {
                userPatchReporter = (PatchReporter) obj3;
            } else {
                TinkerLog.e(str, "NOT PatchReporter object", new Object[0]);
                return;
            }
        }
        if (obj4 != null) {
            if (obj4 instanceof PatchListener) {
                userPatchListener = (PatchListener) obj4;
            } else {
                TinkerLog.e(str, "NOT PatchListener object", new Object[0]);
                return;
            }
        }
        if (tinkerPatchResultListener != null) {
            if (tinkerPatchResultListener instanceof TinkerPatchResultListener) {
                patchResultListener = tinkerPatchResultListener;
            } else {
                TinkerLog.e(str, "NOT TinkerPatchResultListener object", new Object[0]);
                return;
            }
        }
        if (obj5 != null) {
            if (obj5 instanceof AbstractPatch) {
                userUpgradePatchProcessor = (AbstractPatch) obj5;
            } else {
                TinkerLog.e(str, "NOT AbstractPatch object", new Object[0]);
                return;
            }
        }
        installTinker(obj);
    }

    public static void loadArmLibrary(Context context, String str) {
        TinkerLoadLibrary.loadArmLibrary(context, str);
    }

    public static void loadArmV7Library(Context context, String str) {
        TinkerLoadLibrary.loadArmV7Library(context, str);
    }

    public static boolean loadLibraryFromTinker(Context context, String str, String str2) {
        return TinkerLoadLibrary.loadLibraryFromTinker(context, str, str2);
    }

    public void applyPatch(Context context, String str) {
        if (!isInstalled) {
            TinkerLog.w(TAG, "Tinker has not been installed.", new Object[0]);
            return;
        }
        TinkerListener tinkerListener2 = this.tinkerListener;
        if (tinkerListener2 != null) {
            tinkerListener2.onPatchStart();
        }
        TinkerInstaller.onReceiveUpgradePatch(context, str);
    }

    public static String getTinkerId() {
        String str = "tinker_id_";
        String str2 = "";
        if (Tinker.with(getApplication()).isTinkerLoaded()) {
            HashMap packageConfigs = TinkerApplicationHelper.getPackageConfigs(getTinkerApplicationLike());
            return packageConfigs != null ? String.valueOf(packageConfigs.get("TINKER_ID")).replace(str, str2) : str2;
        }
        String manifestTinkerID = ShareTinkerInternals.getManifestTinkerID(getApplication());
        return !TextUtils.isEmpty(manifestTinkerID) ? manifestTinkerID.replace(str, str2) : str2;
    }

    public static String getNewTinkerId() {
        HashMap packageConfigs = TinkerApplicationHelper.getPackageConfigs(getTinkerApplicationLike());
        String str = "";
        return packageConfigs != null ? String.valueOf(packageConfigs.get("NEW_TINKER_ID")).replace("tinker_id_", str) : str;
    }

    public void cleanPatch(boolean z) {
        onPatchRollback(z);
    }

    public static boolean isTinkerManagerInstalled() {
        return isInstalled;
    }

    public void setTinkerListener(TinkerListener tinkerListener2) {
        this.tinkerListener = tinkerListener2;
    }

    public TinkerListener getTinkerListener() {
        return this.tinkerListener;
    }

    public void setTinkerReport(Reporter reporter) {
        TinkerReport tinkerReport2 = tinkerReport;
        if (tinkerReport2 != null) {
            tinkerReport2.setReporter(reporter);
        }
    }

    public void onDownloadSuccess(String str, boolean z) {
        String str2 = TAG;
        try {
            TinkerLog.d(str2, "onDownloadSuccess.", new Object[0]);
            if (this.tinkerListener != null) {
                this.tinkerListener.onDownloadSuccess(str);
            }
            applyPatch(str, z);
        } catch (Exception unused) {
            TinkerLog.e(str2, "apply patch failed", new Object[0]);
        }
    }

    public void applyPatch(String str, boolean z) {
        String str2 = TAG;
        try {
            File file = new File(this.applicationLike.getApplication().getDir(PATCH_DIR, 0).getAbsolutePath(), PATCH_NAME);
            File file2 = null;
            if (checkNewPatch(str)) {
                TinkerLog.d(str2, "has new patch.", new Object[0]);
                file2 = new File(str);
                TinkerUtils.copy(file2, file);
            }
            if (!file.exists()) {
                TinkerLog.d(str2, "patch not exist, just return.", new Object[0]);
                return;
            }
            if (file2 != null && z) {
                TinkerLog.d(str2, "starting patch.", new Object[0]);
                applyPatch((Context) this.applicationLike.getApplication(), file2.getAbsolutePath());
            }
        } catch (Exception e) {
            TinkerLog.e(str2, e.getMessage(), new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0034  */
    public boolean checkNewPatch(java.lang.String r7) {
        /*
        r6 = this;
        java.lang.String r0 = "To"
        java.lang.String r1 = "From"
        r2 = 0
        java.lang.Object[] r3 = new java.lang.Object[r2]
        java.lang.String r4 = "Tinker.TinkerManager"
        java.lang.String r5 = "check if has new patch."
        com.tencent.tinker.lib.util.TinkerLog.d(r4, r5, r3)
        java.lang.String r3 = getTinkerId()
        apkOriginalBuildNum = r3
        java.lang.String r3 = getNewTinkerId()
        patchCurBuildNum = r3
        boolean r3 = android.text.TextUtils.isEmpty(r7)
        r5 = 1
        if (r3 == 0) goto L_0x0025
        r7 = 0
        r3 = r7
    L_0x0023:
        r7 = 0
        goto L_0x0032
    L_0x0025:
        java.io.File r3 = new java.io.File
        r3.<init>(r7)
        boolean r7 = r3.exists()
        if (r7 != 0) goto L_0x0031
        goto L_0x0023
    L_0x0031:
        r7 = 1
    L_0x0032:
        if (r7 == 0) goto L_0x008f
        java.lang.String r7 = "YAPATCH.MF"
        byte[] r7 = com.tencent.bugly.beta.tinker.TinkerUtils.readJarEntry(r3, r7)
        if (r7 != 0) goto L_0x003d
        return r2
    L_0x003d:
        java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
        r3.<init>(r7)
        java.util.Properties r7 = new java.util.Properties     // Catch:{ Exception -> 0x0087 }
        r7.<init>()     // Catch:{ Exception -> 0x0087 }
        r7.load(r3)     // Catch:{ Exception -> 0x0087 }
        java.lang.String r3 = r7.getProperty(r1)     // Catch:{ Exception -> 0x0087 }
        if (r3 == 0) goto L_0x007f
        java.lang.String r3 = r7.getProperty(r0)     // Catch:{ Exception -> 0x0087 }
        if (r3 != 0) goto L_0x0057
        goto L_0x007f
    L_0x0057:
        java.lang.String r3 = apkOriginalBuildNum     // Catch:{ Exception -> 0x0087 }
        if (r3 != 0) goto L_0x0063
        java.lang.String r7 = "patchCurBuildNum is null"
        java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0087 }
        com.tencent.tinker.lib.util.TinkerLog.e(r4, r7, r0)     // Catch:{ Exception -> 0x0087 }
        return r2
    L_0x0063:
        java.lang.String r3 = apkOriginalBuildNum     // Catch:{ Exception -> 0x0087 }
        java.lang.String r1 = r7.getProperty(r1)     // Catch:{ Exception -> 0x0087 }
        boolean r1 = r3.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0087 }
        if (r1 == 0) goto L_0x0077
        java.lang.String r7 = r7.getProperty(r0)     // Catch:{ Exception -> 0x0087 }
        patchCurBuildNum = r7     // Catch:{ Exception -> 0x0087 }
        r2 = 1
        goto L_0x0090
    L_0x0077:
        java.lang.String r7 = "orign buildno invalid"
        java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0087 }
        com.tencent.tinker.lib.util.TinkerLog.e(r4, r7, r0)     // Catch:{ Exception -> 0x0087 }
        goto L_0x0090
    L_0x007f:
        java.lang.String r7 = "From/To is null"
        java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0087 }
        com.tencent.tinker.lib.util.TinkerLog.e(r4, r7, r0)     // Catch:{ Exception -> 0x0087 }
        return r2
    L_0x0087:
        java.lang.Object[] r7 = new java.lang.Object[r2]
        java.lang.String r0 = "get properties failed"
        com.tencent.tinker.lib.util.TinkerLog.e(r4, r0, r7)
        goto L_0x0090
    L_0x008f:
        r2 = r7
    L_0x0090:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.tinker.TinkerManager.checkNewPatch(java.lang.String):boolean");
    }

    public File getPatchDirectory(Context context) {
        return SharePatchFileUtil.getPatchDirectory(context);
    }

    public void onDownloadFailure(String str) {
        TinkerListener tinkerListener2 = this.tinkerListener;
        if (tinkerListener2 != null) {
            tinkerListener2.onDownloadFailure(str);
        }
    }

    public void onApplySuccess(String str) {
        TinkerListener tinkerListener2 = this.tinkerListener;
        if (tinkerListener2 != null) {
            tinkerListener2.onApplySuccess(str);
        }
    }

    public void onApplyFailure(String str) {
        TinkerListener tinkerListener2 = this.tinkerListener;
        if (tinkerListener2 != null) {
            tinkerListener2.onApplyFailure(str);
        }
    }

    public void onPatchRollback(boolean z) {
        if (!Tinker.with(getApplication()).isTinkerLoaded()) {
            TinkerLog.w("Tinker.PatchRequestCallback", "TinkerPatchRequestCallback: onPatchRollback, tinker is not loaded, just return", new Object[0]);
            return;
        }
        String str = TAG;
        if (z) {
            TinkerLog.i(str, "delete patch now", new Object[0]);
            TinkerUtils.rollbackPatch(getApplication());
        } else {
            TinkerLog.i(str, "tinker wait screen to restart process", new Object[0]);
            new ScreenState(getApplication(), new IOnScreenOff() {
                public void onScreenOff() {
                    TinkerUtils.rollbackPatch(TinkerManager.getApplication());
                }
            });
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (TinkerManager.this.tinkerListener != null) {
                    TinkerManager.this.tinkerListener.onPatchRollback();
                }
            }
        });
    }
}
