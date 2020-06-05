package com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p174h.TTSdkSettings;
import com.p530ss.android.p531a.p532a.p533a.DownloadSettings;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.a.e */
public class LibSettings implements DownloadSettings {
    /* renamed from: b */
    private static boolean f8536b = true;
    /* renamed from: c */
    private static boolean f8537c = false;
    /* renamed from: d */
    private static boolean f8538d = true;
    /* renamed from: e */
    private static String f8539e = "com.oppo.market";
    /* renamed from: f */
    private static int f8540f = 0;
    /* renamed from: g */
    private static String f8541g = "com.huawei.appmarket";
    /* renamed from: h */
    private static int f8542h = 1;
    /* renamed from: i */
    private static int f8543i = 30;
    /* renamed from: j */
    private static int f8544j = 10;
    /* renamed from: k */
    private static int f8545k;
    /* renamed from: l */
    private static int f8546l;
    /* renamed from: m */
    private static volatile LibSettings f8547m;
    /* renamed from: a */
    private WeakReference<Context> f8548a;

    /* renamed from: a */
    private int m11097a(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 0) {
        }
        return 1;
    }

    /* renamed from: a */
    public static LibSettings m11098a(Context context) {
        if (f8547m == null) {
            synchronized (LibSettings.class) {
                if (f8547m == null) {
                    f8547m = new LibSettings(context);
                }
            }
        }
        return f8547m;
    }

    public LibSettings(Context context) {
        this.f8548a = new WeakReference<>(context);
        m11099b();
    }

    /* renamed from: a */
    public JSONObject mo16485a() {
        m11099b();
        return m11100c();
    }

    /* renamed from: b */
    private static void m11099b() {
        try {
            TTSdkSettings h = InternalContainer.m10069h();
            if (h != null) {
                f8536b = h.mo15818w();
                f8537c = h.mo15819x();
                f8538d = h.mo15820y();
                f8539e = h.mo15821z();
                f8540f = h.mo15753A();
                f8541g = h.mo15754B();
                f8542h = h.mo15755C();
                f8543i = h.mo15756D();
                f8544j = h.mo15757E();
                f8545k = h.mo15762J();
                f8546l = h.mo15763K();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033 A[Catch:{ all -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035 A[Catch:{ all -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f A[Catch:{ all -> 0x008a }] */
    /* renamed from: c */
    private org.json.JSONObject m11100c() {
        /*
        r5 = this;
        org.json.JSONObject r0 = new org.json.JSONObject
        r0.<init>()
        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x008a }
        r1.<init>()     // Catch:{ all -> 0x008a }
        int r0 = f8545k     // Catch:{ all -> 0x0089 }
        r2 = 1
        if (r0 != r2) goto L_0x002b
        boolean r0 = com.p530ss.android.socialbase.downloader.p569m.C6792i.m28934d()     // Catch:{ all -> 0x0089 }
        if (r0 == 0) goto L_0x001d
        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0089 }
        java.lang.String r3 = "{ \"anti_hijack_dir\": { \"dir_name\": \"安装\\\"%s\\\"\", \"ignore_task_save_path\":1 }, \"anti_hijack_report_config\": { \"report_file_manager_pkg_name\": \"com.oppo.filemanager,com.coloros.filemanager\", \"report_installer_pkg_name\": \"com.android.packageinstaller\" }, \"anti_plans\": [ { \"device_plans\": \"oppo1,oppo2\", \"device_requirements\": [ { \"package_names\": \"com.oppo.filemanager,com.coloros.filemanager\", \"version_black\": [], \"version_white\": [ \"310_3.1.0\", \"3400_3.4.0\", \"3601_3.6.1\", \"330_3.3.0\", \"3606_3.6.6\", \"3605_3.6.5\" ] }, { \"package_names\": \"com.android.packageinstaller\", \"version_black\": [], \"version_white\": [ \"140_3.0.2268\", \"140_3.0.2368\" ] } ], \"type\": \"jump_file_manager\" } ], \"bugfix\": { \"default\": 1 }, \"delete_file_after_install\":1 }"
        r0.<init>(r3)     // Catch:{ all -> 0x0089 }
        goto L_0x002c
    L_0x001d:
        boolean r0 = com.p530ss.android.socialbase.downloader.p569m.C6792i.m28933c()     // Catch:{ all -> 0x0089 }
        if (r0 == 0) goto L_0x002b
        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0089 }
        java.lang.String r3 = "{ \"anti_hijack_dir\": { \"dir_name\": \"安装\\\"%s\\\"\", \"ignore_task_save_path\":1 }, \"anti_hijack_report_config\": { \"report_file_manager_pkg_name\": \"com.android.filemanager\", \"report_installer_pkg_name\": \"com.android.packageinstaller\" }, \"anti_plans\": [ { \"device_plans\": \"vivo1,vivo2\", \"device_requirements\": [ { \"package_names\": \"com.android.filemanager\", \"version_black\": [], \"version_white\": [ \"22_3.0\", \"23_3.0\", \"23_2.5\", \"25_3.2\", \"25_3.1\", \"4030_4.0.3.0\", \"5140_5.1.4.0\", \"5301_5.3.0.1\", \"5211_5.2.1.1\", \"5512_5.5.1.2\", \"5401_5.4.0.1\", \"5205_5.2.0.5\", \"5203_5.2.0.3\", \"5302_5.3.0.2\", \"5312_5.3.1.2\", \"5102_5.1.0.2\", \"5204_5.2.0.4\", \"5314_5.3.1.4\", \"5313_5.3.1.3\", \"5005_5.0.0.5\", \"5112_5.1.1.2\", \"5400_5.4.0.0\", \"5002_5.0.0.2\", \"5130_5.1.3.0\", \"4210_4.2.1.0\", \"5111_5.1.1.1\", \"5311_5.3.1.1\", \"4200_4.2.0.0\" ] }, { \"package_names\": \"com.android.packageinstaller\", \"version_black\": [], \"version_white\": [ \"5_2.5.4.2\", \"5_2.5.4.3\", \"5_3.0.6.1\", \"5_3.0.6.2\", \"5_3.0.8.1\", \"5_3.0.8.0\", \"5_3.0.7.0\", \"5_3.0.9.0\", \"5_4.0.7.0\", \"5_4.0.6.0\", \"5_4.0.10.0\", \"5_5.0.5.0\", \"5_4.0.5.3\", \"5_3.0.7.1\", \"5_4.0.5.5\", \"5_5.0.6.1\", \"5_5.0.6.2\", \"28_5.0.6.5\", \"27_4.0.10.3\", \"26_4.0.10.3\", \"5067_5.0.6.7\", \"5066_5.0.6.6\", \"5068_5.0.6.8\", \"5_2.5.4.0\", \"27_4.0.10.4\", \"5_3.0.6.0\", \"5_2.5.3.0\", \"5_4.0.5.4\", \"5_3.0.3.3\", \"5_3.0.2.7\", \"5_3.0.5.0\", \"5_4.0.5.0\" ] } ], \"type\": \"jump_file_manager\" } ], \"bugfix\": { \"default\": 1 }, \"delete_file_after_install\":1 }"
        r0.<init>(r3)     // Catch:{ all -> 0x0089 }
        goto L_0x002c
    L_0x002b:
        r0 = r1
    L_0x002c:
        java.lang.String r1 = "landing_page_progressbar_visible"
        boolean r3 = f8537c     // Catch:{ all -> 0x008a }
        r4 = 0
        if (r3 == 0) goto L_0x0035
        r3 = 1
        goto L_0x0036
    L_0x0035:
        r3 = 0
    L_0x0036:
        r0.put(r1, r3)     // Catch:{ all -> 0x008a }
        java.lang.String r1 = "download_completed_event_tag"
        java.lang.String r3 = "openad_sdk_download_complete_tag"
        r0.put(r1, r3)     // Catch:{ all -> 0x008a }
        java.lang.String r1 = "is_enable_start_install_again"
        int r3 = f8542h     // Catch:{ all -> 0x008a }
        r0.put(r1, r3)     // Catch:{ all -> 0x008a }
        java.lang.String r1 = "start_install_interval"
        int r3 = f8543i     // Catch:{ all -> 0x008a }
        int r3 = r3 * 1000
        r0.put(r1, r3)     // Catch:{ all -> 0x008a }
        java.lang.String r1 = "next_install_min_interval"
        int r3 = f8544j     // Catch:{ all -> 0x008a }
        int r3 = r3 * 1000
        r0.put(r1, r3)     // Catch:{ all -> 0x008a }
        java.lang.String r1 = "hook"
        boolean r3 = f8538d     // Catch:{ all -> 0x008a }
        if (r3 == 0) goto L_0x0060
        r4 = 1
    L_0x0060:
        r0.put(r1, r4)     // Catch:{ all -> 0x008a }
        java.lang.String r1 = "hook_oppo_arg1"
        java.lang.String r3 = f8539e     // Catch:{ all -> 0x008a }
        r0.put(r1, r3)     // Catch:{ all -> 0x008a }
        java.lang.String r1 = "hook_oppo_arg4"
        int r3 = f8540f     // Catch:{ all -> 0x008a }
        r0.put(r1, r3)     // Catch:{ all -> 0x008a }
        java.lang.String r1 = "hook_huawei_arg1"
        java.lang.String r3 = f8541g     // Catch:{ all -> 0x008a }
        r0.put(r1, r3)     // Catch:{ all -> 0x008a }
        java.lang.String r1 = "check_hijack"
        r0.put(r1, r2)     // Catch:{ all -> 0x008a }
        java.lang.String r1 = "back_miui_silent_install"
        int r2 = f8546l     // Catch:{ all -> 0x008a }
        int r2 = r5.m11097a(r2)     // Catch:{ all -> 0x008a }
        r0.put(r1, r2)     // Catch:{ all -> 0x008a }
        goto L_0x008a
    L_0x0089:
        r0 = r1
    L_0x008a:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibSettings.m11100c():org.json.JSONObject");
    }

    static {
        m11099b();
    }
}
