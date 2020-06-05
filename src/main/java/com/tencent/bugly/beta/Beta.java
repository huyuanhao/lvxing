package com.tencent.bugly.beta;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.PointerIconCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.C8712a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C7127a;
import com.tencent.bugly.beta.global.C7130d;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.beta.global.C7132f;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.p602ui.C7149h;
import com.tencent.bugly.beta.p602ui.UILifecycleListener;
import com.tencent.bugly.beta.tinker.TinkerApplicationLike;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.tinker.TinkerManager.TinkerPatchResultListener;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.C7152c;
import com.tencent.bugly.beta.upgrade.UpgradeListener;
import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.tencent.bugly.beta.utils.C7159e;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.proguard.C7208ac;
import com.tencent.bugly.proguard.C7224am;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import com.tencent.bugly.proguard.C7270p;
import com.tencent.bugly.proguard.C7271q;
import com.tencent.bugly.proguard.C7273r;
import com.tencent.bugly.proguard.C7275s;
import com.tencent.bugly.proguard.C7278u;
import com.tencent.bugly.proguard.C7279v;
import com.tencent.bugly.proguard.C7280w;
import com.tencent.bugly.proguard.C7282y;
import epco.C7986n;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: BUGLY */
public class Beta extends C8712a {
    public static final String TAG_CANCEL_BUTTON = "beta_cancel_button";
    public static final String TAG_CONFIRM_BUTTON = "beta_confirm_button";
    public static final String TAG_IMG_BANNER = "beta_upgrade_banner";
    public static final String TAG_TIP_MESSAGE = "beta_tip_message";
    public static final String TAG_TITLE = "beta_title";
    public static final String TAG_UPGRADE_FEATURE = "beta_upgrade_feature";
    public static final String TAG_UPGRADE_INFO = "beta_upgrade_info";
    /* renamed from: a */
    private static DownloadTask f23668a = null;
    public static String appChannel = null;
    public static int appVersionCode = Integer.MIN_VALUE;
    public static String appVersionName = null;
    public static boolean autoCheckUpgrade = true;
    public static boolean autoDownloadOn4g = false;
    public static boolean autoDownloadOnWifi = false;
    public static boolean autoInit = true;
    public static boolean autoInstallApk = true;
    public static BetaPatchListener betaPatchListener = null;
    public static boolean canAutoDownloadPatch = true;
    public static boolean canAutoPatch = true;
    public static List<Class<? extends Activity>> canNotShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static boolean canNotifyUserRestart = false;
    public static boolean canShowApkInfo = true;
    public static List<Class<? extends Activity>> canShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static int defaultBannerId = 0;
    public static boolean dialogFullScreen = false;
    public static DownloadListener downloadListener = null;
    public static boolean enableHotfix = false;
    public static boolean enableNotification = true;
    public static long initDelay = 3000;
    public static String initProcessName = null;
    public static Beta instance = new Beta();
    public static int largeIconId = 0;
    public static boolean setPatchRestartOnScreenOff = true;
    public static boolean showInterruptedStrategy = true;
    public static int smallIconId = 0;
    public static List<String> soBlackList = Collections.synchronizedList(new ArrayList());
    public static File storageDir = null;
    public static String strNetworkTipsCancelBtn = "取消";
    public static String strNetworkTipsConfirmBtn = "继续下载";
    public static String strNetworkTipsMessage = "你已切换到移动网络，是否继续当前下载？";
    public static String strNetworkTipsTitle = "网络提示";
    public static String strNotificationClickToContinue = "继续下载";
    public static String strNotificationClickToInstall = "点击安装";
    public static String strNotificationClickToRetry = "点击重试";
    public static String strNotificationClickToView = "点击查看";
    public static String strNotificationDownloadError = "下载失败";
    public static String strNotificationDownloadSucc = "下载完成";
    public static String strNotificationDownloading = "正在下载";
    public static String strNotificationHaveNewVersion = "有新版本";
    public static String strToastCheckUpgradeError = "检查新版本失败，请稍后重试";
    public static String strToastCheckingUpgrade = "正在检查，请稍候...";
    public static String strToastYourAreTheLatestVersion = "你已经是最新版了";
    public static String strUpgradeDialogCancelBtn = "下次再说";
    public static String strUpgradeDialogContinueBtn = "继续";
    public static String strUpgradeDialogFeatureLabel = "更新说明";
    public static String strUpgradeDialogFileSizeLabel = "包大小";
    public static String strUpgradeDialogInstallBtn = "安装";
    public static String strUpgradeDialogRetryBtn = "重试";
    public static String strUpgradeDialogUpdateTimeLabel = "更新时间";
    public static String strUpgradeDialogUpgradeBtn = "立即更新";
    public static String strUpgradeDialogVersionLabel = "版本";
    public static int tipsDialogLayoutId;
    public static long upgradeCheckPeriod;
    public static int upgradeDialogLayoutId;
    public static UILifecycleListener<UpgradeInfo> upgradeDialogLifecycleListener;
    public static UpgradeListener upgradeListener;
    public static UpgradeStateListener upgradeStateListener;

    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public static Beta getInstance() {
        Beta beta = instance;
        beta.f23662id = PointerIconCompat.TYPE_HAND;
        beta.version = "1.4.2";
        beta.versionKey = "G10";
        return beta;
    }

    public static void checkUpgrade() {
        checkUpgrade(true, false);
    }

    public static void checkUpgrade(boolean z, boolean z2) {
        try {
            if (TextUtils.isEmpty(C7131e.f23698E.f23750v)) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    C7224am.m31132a().mo34832a(new C7130d(19, Boolean.valueOf(z), Boolean.valueOf(z2)));
                    return;
                }
                synchronized (C7131e.f23698E) {
                    while (TextUtils.isEmpty(C7131e.f23698E.f23750v)) {
                        try {
                            C7131e.f23698E.wait();
                        } catch (InterruptedException unused) {
                            C7226an.m31149e("wait error", new Object[0]);
                        }
                    }
                }
            }
            if (!z) {
                if (TextUtils.isEmpty(C7131e.f23698E.f23750v)) {
                    C7226an.m31149e("[beta] BetaModule is uninitialized", new Object[0]);
                } else {
                    BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) C7127a.m30544a("st.bch", BetaGrayStrategy.CREATOR);
                    if (!(betaGrayStrategy == null || betaGrayStrategy.f23818a == null || System.currentTimeMillis() - betaGrayStrategy.f23822e > C7131e.f23698E.f23731c)) {
                        if (betaGrayStrategy.f23818a.f24668p != 3) {
                            C7152c.f23830a.mo34475a(z, z2, 0, null, "");
                        }
                    }
                    C7152c.f23830a.mo34474a(z, z2, 0);
                }
            }
            if (z) {
                if (TextUtils.isEmpty(C7131e.f23698E.f23750v)) {
                    C7226an.m31149e("[beta] BetaModule is uninitialized", new Object[0]);
                    if (upgradeStateListener != null) {
                        C7159e.m30681a(new C7130d(18, upgradeStateListener, Integer.valueOf(-1), Boolean.valueOf(z)));
                    } else {
                        C7159e.m30681a(new C7130d(5, strToastCheckUpgradeError));
                    }
                } else {
                    C7152c.f23830a.mo34474a(z, z2, 1);
                    if (upgradeStateListener != null) {
                        C7159e.m30681a(new C7130d(18, upgradeStateListener, Integer.valueOf(2), Boolean.valueOf(z)));
                    } else {
                        C7159e.m30681a(new C7130d(5, strToastCheckingUpgrade));
                    }
                }
            }
        } catch (Exception e) {
            if (!C7226an.m31145b(e)) {
                e.printStackTrace();
            }
        }
    }

    public static UpgradeInfo getUpgradeInfo() {
        try {
            C7152c.f23830a.f23831b = (BetaGrayStrategy) C7127a.m30544a("st.bch", BetaGrayStrategy.CREATOR);
            if (C7152c.f23830a.f23831b != null) {
                return new UpgradeInfo(C7152c.f23830a.f23831b.f23818a);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static synchronized void init(Context context, boolean z) {
        synchronized (Beta.class) {
            C7226an.m31141a("Beta init start....", new Object[0]);
            C7208ac a = C7208ac.m31021a();
            int i = instance.f23662id;
            int i2 = C7131e.f23699a + 1;
            C7131e.f23699a = i2;
            a.mo34768a(i, i2);
            if (TextUtils.isEmpty(initProcessName)) {
                initProcessName = context.getPackageName();
            }
            C7226an.m31141a("Beta will init at: %s", initProcessName);
            String str = C7174a.m30754b().f24024e;
            C7226an.m31141a("current process: %s", str);
            if (TextUtils.equals(initProcessName, str)) {
                C7131e eVar = C7131e.f23698E;
                if (!TextUtils.isEmpty(eVar.f23750v)) {
                    C7226an.m31148d("Beta has been initialized [apkMD5 : %s]", eVar.f23750v);
                    return;
                }
                C7226an.m31141a("current upgrade sdk version:1.4.2", new Object[0]);
                eVar.f23703D = z;
                if (upgradeCheckPeriod < 0) {
                    C7226an.m31148d("upgradeCheckPeriod cannot be negative", new Object[0]);
                } else {
                    eVar.f23731c = upgradeCheckPeriod;
                    C7226an.m31141a("setted upgradeCheckPeriod: %d", Long.valueOf(upgradeCheckPeriod));
                }
                if (initDelay < 0) {
                    C7226an.m31148d("initDelay cannot be negative", new Object[0]);
                } else {
                    eVar.f23730b = initDelay;
                    C7226an.m31141a("setted initDelay: %d", Long.valueOf(initDelay));
                }
                if (smallIconId != 0) {
                    try {
                        if (context.getResources().getDrawable(smallIconId) != null) {
                            eVar.f23734f = smallIconId;
                            C7226an.m31141a("setted smallIconId: %d", Integer.valueOf(smallIconId));
                        }
                    } catch (Exception e) {
                        C7226an.m31149e("smallIconId is not available:\n %s", e.toString());
                    }
                }
                if (largeIconId != 0) {
                    try {
                        if (context.getResources().getDrawable(largeIconId) != null) {
                            eVar.f23735g = largeIconId;
                            C7226an.m31141a("setted largeIconId: %d", Integer.valueOf(largeIconId));
                        }
                    } catch (Exception e2) {
                        C7226an.m31149e("largeIconId is not available:\n %s", e2.toString());
                    }
                }
                if (defaultBannerId != 0) {
                    try {
                        if (context.getResources().getDrawable(defaultBannerId) != null) {
                            eVar.f23736h = defaultBannerId;
                            C7226an.m31141a("setted defaultBannerId: %d", Integer.valueOf(defaultBannerId));
                        }
                    } catch (Exception e3) {
                        C7226an.m31149e("defaultBannerId is not available:\n %s", e3.toString());
                    }
                }
                if (upgradeDialogLayoutId != 0) {
                    try {
                        XmlResourceParser layout = context.getResources().getLayout(upgradeDialogLayoutId);
                        if (layout != null) {
                            eVar.f23737i = upgradeDialogLayoutId;
                            C7226an.m31141a("setted upgradeDialogLayoutId: %d", Integer.valueOf(upgradeDialogLayoutId));
                            layout.close();
                        }
                    } catch (Exception e4) {
                        C7226an.m31149e("upgradeDialogLayoutId is not available:\n %s", e4.toString());
                    }
                }
                if (tipsDialogLayoutId != 0) {
                    try {
                        XmlResourceParser layout2 = context.getResources().getLayout(tipsDialogLayoutId);
                        if (layout2 != null) {
                            eVar.f23738j = tipsDialogLayoutId;
                            C7226an.m31141a("setted tipsDialogLayoutId: %d", Integer.valueOf(tipsDialogLayoutId));
                            layout2.close();
                        }
                    } catch (Exception e5) {
                        C7226an.m31149e("tipsDialogLayoutId is not available:\n %s", e5.toString());
                    }
                }
                if (upgradeDialogLifecycleListener != null) {
                    try {
                        eVar.f23739k = upgradeDialogLifecycleListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append("setted upgradeDialogLifecycleListener:%s");
                        sb.append(upgradeDialogLifecycleListener);
                        C7226an.m31141a(sb.toString(), new Object[0]);
                    } catch (Exception e6) {
                        C7226an.m31149e("upgradeDialogLifecycleListener is not available:\n %", e6.toString());
                    }
                }
                if (canShowUpgradeActs != null && !canShowUpgradeActs.isEmpty()) {
                    for (Class cls : canShowUpgradeActs) {
                        if (cls != null) {
                            eVar.f23741m.add(cls);
                        }
                    }
                    C7226an.m31141a("setted canShowUpgradeActs: %s", eVar.f23741m);
                }
                if (canNotShowUpgradeActs != null && !canNotShowUpgradeActs.isEmpty()) {
                    for (Class cls2 : canNotShowUpgradeActs) {
                        if (cls2 != null) {
                            eVar.f23742n.add(cls2);
                        }
                    }
                    C7226an.m31141a("setted canNotShowUpgradeActs: %s", eVar.f23742n);
                }
                eVar.f23732d = autoCheckUpgrade;
                String str2 = "autoCheckUpgrade %s";
                Object[] objArr = new Object[1];
                objArr[0] = eVar.f23732d ? "is opened" : "is closed";
                C7226an.m31141a(str2, objArr);
                eVar.f23728ad = autoInstallApk;
                String str3 = "autoInstallApk %s";
                Object[] objArr2 = new Object[1];
                objArr2[0] = eVar.f23728ad ? "is opened" : "is closed";
                C7226an.m31141a(str3, objArr2);
                eVar.f23718T = autoDownloadOn4g;
                String str4 = "autoDownloadOn4g %s";
                Object[] objArr3 = new Object[1];
                objArr3[0] = eVar.f23718T ? "is opened" : "is closed";
                C7226an.m31141a(str4, objArr3);
                eVar.f23733e = showInterruptedStrategy;
                String str5 = "showInterruptedStrategy %s";
                Object[] objArr4 = new Object[1];
                objArr4[0] = eVar.f23733e ? "is opened" : "is closed";
                C7226an.m31141a(str5, objArr4);
                String str6 = "isDIY %s";
                Object[] objArr5 = new Object[1];
                objArr5[0] = upgradeListener != null ? "is opened" : "is closed";
                C7226an.m31141a(str6, objArr5);
                if (storageDir != null) {
                    if (storageDir.exists() || storageDir.mkdirs()) {
                        eVar.f23740l = storageDir;
                        C7226an.m31141a("setted storageDir: %s", storageDir.getAbsolutePath());
                    } else {
                        C7226an.m31141a("storageDir is not exists: %s", storageDir.getAbsolutePath());
                    }
                }
                if (eVar.f23744p == null) {
                    eVar.f23744p = C7275s.f24609a;
                }
                if (TextUtils.isEmpty(eVar.f23749u)) {
                    eVar.f23749u = C7174a.m30754b().mo34591f();
                }
                eVar.f23716R = enableNotification;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(enableNotification);
                sb2.append("");
                C7226an.m31141a("enableNotification %s", sb2.toString());
                eVar.f23717S = autoDownloadOnWifi;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(autoDownloadOnWifi);
                sb3.append("");
                C7226an.m31141a("autoDownloadOnWifi %s", sb3.toString());
                eVar.f23719U = canShowApkInfo;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(canShowApkInfo);
                sb4.append("");
                C7226an.m31141a("canShowApkInfo %s", sb4.toString());
                eVar.f23720V = canAutoPatch;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(canAutoPatch);
                sb5.append("");
                C7226an.m31141a("canAutoPatch %s", sb5.toString());
                eVar.f23721W = betaPatchListener;
                eVar.f23752x = appVersionName;
                eVar.f23751w = appVersionCode;
                eVar.f23722X = canNotifyUserRestart;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(canNotifyUserRestart);
                sb6.append("");
                C7226an.m31141a("canNotifyUserRestart %s", sb6.toString());
                eVar.f23723Y = canAutoDownloadPatch;
                StringBuilder sb7 = new StringBuilder();
                sb7.append(canAutoDownloadPatch);
                sb7.append("");
                C7226an.m31141a("canAutoDownloadPatch %s", sb7.toString());
                eVar.f23724Z = enableHotfix;
                StringBuilder sb8 = new StringBuilder();
                sb8.append(enableHotfix);
                sb8.append("");
                C7226an.m31141a("enableHotfix %s", sb8.toString());
                TinkerManager.setPatchRestartOnScreenOff(setPatchRestartOnScreenOff);
                StringBuilder sb9 = new StringBuilder();
                sb9.append(setPatchRestartOnScreenOff);
                sb9.append("");
                C7226an.m31141a("setPatchRestartOnScreenOff %s", sb9.toString());
                if (soBlackList != null && !soBlackList.isEmpty()) {
                    for (String str7 : soBlackList) {
                        if (str7 != null) {
                            eVar.f23725aa.add(str7);
                        }
                    }
                    C7226an.m31141a("setted soBlackList: %s", eVar.f23725aa);
                }
                if (appChannel != null) {
                    eVar.f23714P = appChannel;
                    C7226an.m31141a("Beta channel %s", appChannel);
                }
                eVar.mo34339a(context);
                ResBean.f23687a = (ResBean) C7127a.m30544a("rb.bch", ResBean.CREATOR);
                if (ResBean.f23687a == null) {
                    ResBean.f23687a = new ResBean();
                }
                C7152c.f23830a.f23834e = upgradeListener;
                C7152c.f23830a.f23835f = upgradeStateListener;
                C7152c.f23830a.f23833d = downloadListener;
                if (!(getStrategyTask() == null || downloadListener == null)) {
                    getStrategyTask().addListener(C7152c.f23830a.f23833d);
                }
                if (enableHotfix) {
                    C7226an.m31141a("enableHotfix %s", "1");
                    C7232aq.m31212b("D4", "1");
                    C7273r.m31419a(context);
                }
                Resources resources = context.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                Configuration configuration = resources.getConfiguration();
                configuration.locale = Locale.getDefault();
                if (configuration.locale.equals(Locale.US) || configuration.locale.equals(Locale.ENGLISH)) {
                    strToastYourAreTheLatestVersion = context.getResources().getString(C7122R.string.strToastYourAreTheLatestVersion);
                    strToastCheckUpgradeError = context.getResources().getString(C7122R.string.strToastCheckUpgradeError);
                    strToastCheckingUpgrade = context.getResources().getString(C7122R.string.strToastCheckingUpgrade);
                    strNotificationDownloading = context.getResources().getString(C7122R.string.strNotificationDownloading);
                    strNotificationClickToView = context.getResources().getString(C7122R.string.strNotificationClickToView);
                    strNotificationClickToInstall = context.getResources().getString(C7122R.string.strNotificationClickToInstall);
                    strNotificationClickToContinue = context.getResources().getString(C7122R.string.strNotificationClickToContinue);
                    strNotificationClickToRetry = context.getResources().getString(C7122R.string.strNotificationClickToRetry);
                    strNotificationDownloadSucc = context.getResources().getString(C7122R.string.strNotificationDownloadSucc);
                    strNotificationDownloadError = context.getResources().getString(C7122R.string.strNotificationDownloadError);
                    strNotificationHaveNewVersion = context.getResources().getString(C7122R.string.strNotificationHaveNewVersion);
                    strNetworkTipsMessage = context.getResources().getString(C7122R.string.strNetworkTipsMessage);
                    strNetworkTipsTitle = context.getResources().getString(C7122R.string.strNetworkTipsTitle);
                    strNetworkTipsConfirmBtn = context.getResources().getString(C7122R.string.strNetworkTipsConfirmBtn);
                    strNetworkTipsCancelBtn = context.getResources().getString(C7122R.string.strNetworkTipsCancelBtn);
                    strUpgradeDialogVersionLabel = context.getResources().getString(C7122R.string.strUpgradeDialogVersionLabel);
                    strUpgradeDialogFileSizeLabel = context.getResources().getString(C7122R.string.strUpgradeDialogFileSizeLabel);
                    strUpgradeDialogUpdateTimeLabel = context.getResources().getString(C7122R.string.strUpgradeDialogUpdateTimeLabel);
                    strUpgradeDialogFeatureLabel = context.getResources().getString(C7122R.string.strUpgradeDialogFeatureLabel);
                    strUpgradeDialogUpgradeBtn = context.getResources().getString(C7122R.string.strUpgradeDialogUpgradeBtn);
                    strUpgradeDialogInstallBtn = context.getResources().getString(C7122R.string.strUpgradeDialogInstallBtn);
                    strUpgradeDialogRetryBtn = context.getResources().getString(C7122R.string.strUpgradeDialogRetryBtn);
                    strUpgradeDialogContinueBtn = context.getResources().getString(C7122R.string.strUpgradeDialogContinueBtn);
                    strUpgradeDialogCancelBtn = context.getResources().getString(C7122R.string.strUpgradeDialogCancelBtn);
                }
                resources.updateConfiguration(configuration, displayMetrics);
                C7224am.m31132a().mo34833a(new C7130d(1, new Object[0]), eVar.f23730b);
                C7208ac a2 = C7208ac.m31021a();
                int i3 = instance.f23662id;
                int i4 = C7131e.f23699a - 1;
                C7131e.f23699a = i4;
                a2.mo34768a(i3, i4);
                C7226an.m31141a("Beta init finished...", new Object[0]);
            }
        }
    }

    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        C7174a.m30754b().mo34586c("G10", "1.4.2");
        if (autoInit) {
            init(context, z);
        }
    }

    public String[] getTables() {
        return new String[]{"dl_1002", "ge_1002", "st_1002"};
    }

    /* JADX INFO: unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:1:0x0014 in {} preds:[B:0:0x0000, B:41:0x0138]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.calcImmediateDominators(BlockProcessor.java:303)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:255)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:55)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    public void onDbUpgrade(android.database.sqlite.SQLiteDatabase r21, int r22, int r23) {
        /*
        r20 = this;
        r9 = r21
        java.lang.String r10 = "st_1002"
        java.lang.String r11 = "_dt"
        java.lang.String r12 = "_tm"
        java.lang.String r13 = " , "
        java.lang.String r14 = "_tp"
        java.lang.String r15 = " "
        java.lang.String r8 = "_id"
        r6 = r22
        r7 = r23
    L_0x0014:
        if (r6 >= r7) goto L_0x0148
        r0 = 10
        if (r6 == r0) goto L_0x0021
        r19 = r6
        r16 = r13
        r13 = r8
        goto L_0x0138
    L_0x0021:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0097 }
        r0.<init>()     // Catch:{ all -> 0x0097 }
        r1 = 0     // Catch:{ all -> 0x0097 }
        r0.setLength(r1)     // Catch:{ all -> 0x0097 }
        java.lang.String r2 = " CREATE TABLE  IF NOT EXISTS "     // Catch:{ all -> 0x0097 }
        r0.append(r2)     // Catch:{ all -> 0x0097 }
        r0.append(r10)     // Catch:{ all -> 0x0097 }
        java.lang.String r2 = " ( "     // Catch:{ all -> 0x0097 }
        r0.append(r2)     // Catch:{ all -> 0x0097 }
        r0.append(r8)     // Catch:{ all -> 0x0097 }
        r0.append(r15)     // Catch:{ all -> 0x0097 }
        java.lang.String r2 = "integer"     // Catch:{ all -> 0x0097 }
        r0.append(r2)     // Catch:{ all -> 0x0097 }
        r0.append(r13)     // Catch:{ all -> 0x0097 }
        r0.append(r14)     // Catch:{ all -> 0x0097 }
        r0.append(r15)     // Catch:{ all -> 0x0097 }
        java.lang.String r2 = "text"     // Catch:{ all -> 0x0097 }
        r0.append(r2)     // Catch:{ all -> 0x0097 }
        r0.append(r13)     // Catch:{ all -> 0x0097 }
        r0.append(r12)     // Catch:{ all -> 0x0097 }
        r0.append(r15)     // Catch:{ all -> 0x0097 }
        java.lang.String r2 = "int"     // Catch:{ all -> 0x0097 }
        r0.append(r2)     // Catch:{ all -> 0x0097 }
        r0.append(r13)     // Catch:{ all -> 0x0097 }
        r0.append(r11)     // Catch:{ all -> 0x0097 }
        r0.append(r15)     // Catch:{ all -> 0x0097 }
        java.lang.String r2 = "blob"     // Catch:{ all -> 0x0097 }
        r0.append(r2)     // Catch:{ all -> 0x0097 }
        java.lang.String r2 = ",primary key("     // Catch:{ all -> 0x0097 }
        r0.append(r2)     // Catch:{ all -> 0x0097 }
        r0.append(r8)     // Catch:{ all -> 0x0097 }
        java.lang.String r2 = ","     // Catch:{ all -> 0x0097 }
        r0.append(r2)     // Catch:{ all -> 0x0097 }
        r0.append(r14)     // Catch:{ all -> 0x0097 }
        java.lang.String r2 = " )) "     // Catch:{ all -> 0x0097 }
        r0.append(r2)     // Catch:{ all -> 0x0097 }
        java.lang.String r2 = "create %s"     // Catch:{ all -> 0x0097 }
        r3 = 1     // Catch:{ all -> 0x0097 }
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0097 }
        java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x0097 }
        r3[r1] = r4     // Catch:{ all -> 0x0097 }
        com.tencent.bugly.proguard.C7226an.m31147c(r2, r3)     // Catch:{ all -> 0x0097 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0097 }
        r9.execSQL(r0)     // Catch:{ all -> 0x0097 }
        goto L_0x00a1
    L_0x0097:
        r0 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31145b(r0)
        if (r1 != 0) goto L_0x00a1
        r0.printStackTrace()
    L_0x00a1:
        r5 = 0
        java.lang.String r4 = "_id = 1002"
        java.lang.String r2 = "t_pf"
        r3 = 0
        r0 = 0
        r16 = 0
        r17 = 0
        r18 = 0
        r1 = r21
        r5 = r0
        r19 = r6
        r6 = r16
        r7 = r17
        r16 = r13
        r13 = r8
        r8 = r18
        android.database.Cursor r5 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x011f }
        if (r5 != 0) goto L_0x00c8
        if (r5 == 0) goto L_0x00c7
        r5.close()
    L_0x00c7:
        return
    L_0x00c8:
        boolean r0 = r5.moveToNext()     // Catch:{ all -> 0x011d }
        if (r0 == 0) goto L_0x011a     // Catch:{ all -> 0x011d }
        android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ all -> 0x011d }
        r0.<init>()     // Catch:{ all -> 0x011d }
        int r1 = r5.getColumnIndex(r13)     // Catch:{ all -> 0x011d }
        long r1 = r5.getLong(r1)     // Catch:{ all -> 0x011d }
        r3 = 0     // Catch:{ all -> 0x011d }
        int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))     // Catch:{ all -> 0x011d }
        if (r6 <= 0) goto L_0x00f0     // Catch:{ all -> 0x011d }
        int r1 = r5.getColumnIndex(r13)     // Catch:{ all -> 0x011d }
        long r1 = r5.getLong(r1)     // Catch:{ all -> 0x011d }
        java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x011d }
        r0.put(r13, r1)     // Catch:{ all -> 0x011d }
    L_0x00f0:
        int r1 = r5.getColumnIndex(r12)     // Catch:{ all -> 0x011d }
        long r1 = r5.getLong(r1)     // Catch:{ all -> 0x011d }
        java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x011d }
        r0.put(r12, r1)     // Catch:{ all -> 0x011d }
        int r1 = r5.getColumnIndex(r14)     // Catch:{ all -> 0x011d }
        java.lang.String r1 = r5.getString(r1)     // Catch:{ all -> 0x011d }
        r0.put(r14, r1)     // Catch:{ all -> 0x011d }
        int r1 = r5.getColumnIndex(r11)     // Catch:{ all -> 0x011d }
        byte[] r1 = r5.getBlob(r1)     // Catch:{ all -> 0x011d }
        r0.put(r11, r1)     // Catch:{ all -> 0x011d }
        r1 = 0     // Catch:{ all -> 0x011d }
        r9.replace(r10, r1, r0)     // Catch:{ all -> 0x011d }
        goto L_0x00c8
    L_0x011a:
        if (r5 == 0) goto L_0x0138
        goto L_0x0135
    L_0x011d:
        r0 = move-exception
        goto L_0x012a
    L_0x011f:
        r0 = move-exception
        r1 = 0
        r5 = r1
        goto L_0x012a
    L_0x0123:
        r0 = move-exception
        r1 = r5
        r19 = r6
        r16 = r13
        r13 = r8
    L_0x012a:
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31145b(r0)     // Catch:{ all -> 0x0141 }
        if (r1 != 0) goto L_0x0133     // Catch:{ all -> 0x0141 }
        r0.printStackTrace()     // Catch:{ all -> 0x0141 }
    L_0x0133:
        if (r5 == 0) goto L_0x0138
    L_0x0135:
        r5.close()
    L_0x0138:
        int r6 = r19 + 1
        r7 = r23
        r8 = r13
        r13 = r16
        goto L_0x0014
    L_0x0141:
        r0 = move-exception
        if (r5 == 0) goto L_0x0147
        r5.close()
    L_0x0147:
        throw r0
    L_0x0148:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.onDbUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    public static void registerDownloadListener(DownloadListener downloadListener2) {
        C7131e.f23698E.f23745q = downloadListener2;
        if (C7131e.f23698E.f23745q != null && C7152c.f23830a.f23832c != null) {
            C7152c.f23830a.f23832c.addListener(downloadListener2);
        }
    }

    public static void unregisterDownloadListener() {
        if (C7152c.f23830a.f23832c != null) {
            C7152c.f23830a.f23832c.removeListener(C7131e.f23698E.f23745q);
        }
        C7131e.f23698E.f23745q = null;
    }

    public static DownloadTask startDownload() {
        if (C7152c.f23830a.f23838i == null || C7152c.f23830a.f23838i.f23697b[0] != C7152c.f23830a.f23832c) {
            C7152c.f23830a.f23838i = new C7130d(13, C7152c.f23830a.f23832c, C7152c.f23830a.f23831b);
        }
        C7152c.f23830a.f23838i.run();
        return C7152c.f23830a.f23832c;
    }

    public static void cancelDownload() {
        if (!(C7152c.f23830a.f23839j != null && C7152c.f23830a.f23839j.f23697b[0] == C7152c.f23830a.f23832c && C7152c.f23830a.f23839j.f23697b[1] == C7152c.f23830a.f23831b && ((Boolean) C7152c.f23830a.f23839j.f23697b[2]).booleanValue() == C7152c.f23830a.f23836g)) {
            C7152c.f23830a.f23839j = new C7130d(14, C7152c.f23830a.f23832c, C7152c.f23830a.f23831b, Boolean.valueOf(C7152c.f23830a.f23836g));
        }
        C7152c.f23830a.f23839j.run();
    }

    public static DownloadTask getStrategyTask() {
        if (f23668a == null) {
            C7152c.f23830a.f23831b = (BetaGrayStrategy) C7127a.m30544a("st.bch", BetaGrayStrategy.CREATOR);
            if (C7152c.f23830a.f23831b != null) {
                f23668a = C7131e.f23698E.f23744p.mo34326a(C7152c.f23830a.f23831b.f23818a.f24658f.f24618b, C7131e.f23698E.f23748t.getAbsolutePath(), null, C7152c.f23830a.f23831b.f23818a.f24658f.f24617a);
                C7152c.f23830a.f23832c = f23668a;
            }
        }
        return C7152c.f23830a.f23832c;
    }

    public static synchronized void showUpgradeDialog(String str, int i, String str2, long j, int i2, int i3, String str3, String str4, long j2, String str5, String str6, int i4, DownloadListener downloadListener2, Runnable runnable, Runnable runnable2, boolean z) {
        C7282y yVar;
        synchronized (Beta.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("IMG_title", str6);
            hashMap.put("VAL_style", String.valueOf(i4));
            C7279v vVar = new C7279v(C7131e.f23698E.f23749u, 1, i3, str3, i2, "", 1, "", str5, "1.4.2", "");
            C7278u uVar = new C7278u(str5, str4, "", j2, "");
            C7282y yVar2 = r2;
            C7282y yVar3 = new C7282y(str, str2, j, 0, vVar, uVar, (byte) i, 0, 0, null, "", hashMap, null, 1, System.currentTimeMillis(), 1);
            if (f23668a != null && !f23668a.getDownloadUrl().equals(str4)) {
                f23668a.delete(true);
                f23668a = null;
            }
            if (f23668a == null) {
                yVar = yVar2;
                f23668a = C7131e.f23698E.f23744p.mo34326a(yVar.f24658f.f24618b, C7131e.f23698E.f23748t.getAbsolutePath(), null, yVar.f24658f.f24617a);
            } else {
                yVar = yVar2;
            }
            f23668a.addListener(downloadListener2);
            C7149h.f23802v.mo34448a(yVar, f23668a);
            C7149h.f23802v.f23810r = runnable;
            C7149h.f23802v.f23811s = runnable2;
            C7132f.f23755a.mo34341a(C7131e.f23698E.f23744p, yVar.f24664l);
            boolean z2 = false;
            if (z) {
                C7132f fVar = C7132f.f23755a;
                Object[] objArr = new Object[2];
                objArr[0] = C7149h.f23802v;
                if (yVar.f24659g == 2) {
                    z2 = true;
                }
                objArr[1] = Boolean.valueOf(z2);
                fVar.mo34343a((Runnable) new C7130d(2, objArr), (int) PathInterpolatorCompat.MAX_NUM_POINTS);
            } else {
                C7132f fVar2 = C7132f.f23755a;
                Object[] objArr2 = new Object[2];
                objArr2[0] = C7149h.f23802v;
                if (yVar.f24659g == 2) {
                    z2 = true;
                }
                objArr2[1] = Boolean.valueOf(z2);
                fVar2.mo34342a(new C7130d(2, objArr2));
            }
        }
    }

    public static synchronized void onUpgradeReceived(String str, int i, String str2, long j, int i2, int i3, String str3, String str4, long j2, String str5, String str6, int i4, int i5, long j3, String str7, boolean z, boolean z2, int i6, String str8, long j4) {
        synchronized (Beta.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("IMG_title", str6);
            hashMap.put("VAL_style", String.valueOf(i4));
            C7279v vVar = new C7279v(C7131e.f23698E.f23749u, 1, i3, str3, i2, "", 1, "", str5, "", "");
            C7278u uVar = new C7278u(str5, str4, "", j2, "");
            C7282y yVar = new C7282y(str, str2, j, 0, vVar, uVar, (byte) i, i5, j3, null, "", hashMap, str7, 1, j4, 1);
            C7152c.f23830a.mo34475a(z, z2, i6, yVar, str8 == null ? "" : str8);
        }
    }

    public static synchronized C7282y getUpgradeStrategy() {
        synchronized (Beta.class) {
            C7152c.f23830a.f23831b = (BetaGrayStrategy) C7127a.m30544a("st.bch", BetaGrayStrategy.CREATOR);
            try {
                if (C7152c.f23830a.f23831b != null) {
                    C7282y yVar = (C7282y) C7152c.f23830a.f23831b.f23818a.clone();
                    return yVar;
                }
            } catch (Exception unused) {
            }
            return null;
        }
    }

    public static synchronized void installApk(File file) {
        synchronized (Beta.class) {
            try {
                C7282y upgradeStrategy = getUpgradeStrategy();
                if (upgradeStrategy != null && C7127a.m30549a(C7131e.f23698E.f23747s, file, upgradeStrategy.f24658f.f24617a)) {
                    C7270p pVar = C7270p.f24600a;
                    C7280w wVar = new C7280w("install", System.currentTimeMillis(), 0, 0, upgradeStrategy.f24657e, upgradeStrategy.f24665m, upgradeStrategy.f24668p, null);
                    pVar.mo34953a(wVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return;
    }

    public static synchronized void saveInstallEvent(boolean z) {
        synchronized (Beta.class) {
            try {
                C7282y upgradeStrategy = getUpgradeStrategy();
                if (upgradeStrategy != null && z) {
                    C7127a.m30547a("installApkMd5", upgradeStrategy.f24658f.f24617a);
                    C7270p pVar = C7270p.f24600a;
                    C7280w wVar = new C7280w("install", System.currentTimeMillis(), 0, 0, upgradeStrategy.f24657e, upgradeStrategy.f24665m, upgradeStrategy.f24668p, null);
                    pVar.mo34953a(wVar);
                    C7226an.m31141a("安装事件保存成功", new Object[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return;
    }

    public static void applyTinkerPatch(Context context, String str) {
        TinkerManager.getInstance().applyPatch(context, str);
    }

    public static void downloadPatch() {
        C7271q.f24601a.f24602b = C7271q.f24601a.mo34959a(null);
        try {
            if (C7271q.f24601a.f24602b != null) {
                C7271q.f24601a.mo34960a(0, C7271q.f24601a.f24602b.f23818a, true);
            }
        } catch (Exception unused) {
        }
    }

    public static void applyDownloadedPatch() {
        if (new File(C7131e.f23698E.f23706H.getAbsolutePath()).exists()) {
            TinkerManager.getInstance().applyPatch(C7131e.f23698E.f23706H.getAbsolutePath(), true);
            return;
        }
        C7226an.m31146c(Beta.class, "[applyDownloadedPatch] patch file not exist", new Object[0]);
    }

    public static void installTinker() {
        enableHotfix = true;
        installTinker(TinkerApplicationLike.getTinkerPatchApplicationLike());
    }

    public static void installTinker(Object obj) {
        enableHotfix = true;
        TinkerManager.installTinker(obj);
    }

    public static void installTinker(Object obj, Object obj2, Object obj3, Object obj4, TinkerPatchResultListener tinkerPatchResultListener, Object obj5) {
        enableHotfix = true;
        TinkerManager.installTinker(obj, obj2, obj3, obj4, tinkerPatchResultListener, obj5);
    }

    public static void cleanTinkerPatch(boolean z) {
        C7127a.m30548a("IS_PATCH_ROLL_BACK", false);
        TinkerManager.getInstance().cleanPatch(z);
    }

    public static void loadArmLibrary(Context context, String str) {
        TinkerManager.loadArmLibrary(context, str);
    }

    public static void loadArmV7Library(Context context, String str) {
        TinkerManager.loadArmV7Library(context, str);
    }

    public static void loadLibraryFromTinker(Context context, String str, String str2) {
        TinkerManager.loadLibraryFromTinker(context, str, str2);
    }

    public static void loadLibrary(String str) {
        boolean z;
        C7131e eVar = C7131e.f23698E;
        String str2 = "LoadSoFileResult";
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    if (C7127a.m30556b(str2, true)) {
                        C7127a.m30548a(str2, false);
                        String b = C7127a.m30555b(str, "");
                        boolean b2 = C7127a.m30556b("PatchResult", false);
                        if (TextUtils.isEmpty(b) || !b2) {
                            z = false;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append(C7986n.f27122f);
                            sb.append(b);
                            z = TinkerManager.loadLibraryFromTinker(eVar.f23747s, sb.toString(), str);
                        }
                        if (!z) {
                            System.loadLibrary(str);
                        }
                        C7127a.m30548a(str2, true);
                    } else {
                        System.loadLibrary(str);
                        C7127a.m30548a("IS_PATCH_ROLL_BACK", true);
                        cleanTinkerPatch(true);
                    }
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                C7127a.m30548a(str2, false);
            }
        }
        C7226an.m31149e("libName is invalid", new Object[0]);
    }

    public static void unInit() {
        String str = "IS_PATCH_ROLL_BACK";
        if (C7127a.m30556b(str, false)) {
            C7127a.m30548a(str, false);
            TinkerManager.getInstance().cleanPatch(true);
        }
    }
}
