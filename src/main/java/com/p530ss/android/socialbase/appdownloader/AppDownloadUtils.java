package com.p530ss.android.socialbase.appdownloader;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.p530ss.android.socialbase.appdownloader.p552c.AbsAppDownloadDepend;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadDepend;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadEventHandler;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadFileUriProvider;
import com.p530ss.android.socialbase.appdownloader.p554e.p555a.PackageInfoUtils;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p557b.DownloadStatus;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadFileUriProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p563h.IDownloadGlobalMonitorListener;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.C6792i;
import com.p530ss.android.socialbase.downloader.p569m.DownloadDigestUtils;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import com.p530ss.android.socialbase.downloader.p569m.SystemUtils;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.io.File;
import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.c */
public class AppDownloadUtils {
    /* renamed from: a */
    private static NotificationChannel f21503a;

    /* renamed from: a */
    private static String m26649a(long j, long j2, String str) {
        double d = (double) j;
        if (j2 > 1) {
            d /= (double) j2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(new DecimalFormat("#.##").format(d));
        sb.append(" ");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m26648a(long j) {
        long[] jArr = {1099511627776L, 1073741824, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("0 ");
            sb.append(strArr[strArr.length - 1]);
            return sb.toString();
        }
        String str = null;
        int i = 0;
        while (true) {
            if (i >= jArr.length) {
                break;
            }
            long j2 = jArr[i];
            if (j >= j2) {
                str = m26649a(j, j2, strArr[i]);
                break;
            }
            i++;
        }
        return str;
    }

    /* renamed from: a */
    public static int m26645a(Context context, int i, boolean z) {
        DownloadInfo h = Downloader.m27478a(context).mo31928h(i);
        if (h != null) {
            if ("application/vnd.android.package-archive".equals(h.mo32231ah()) && !TextUtils.isEmpty(h.mo32297k()) && !TextUtils.isEmpty(h.mo32287h()) && new File(h.mo32297k(), h.mo32287h()).exists()) {
                boolean z2 = false;
                if (DownloadSetting.m28610a(i).mo32547a("install_queue_enable", 0) == 1) {
                    z2 = true;
                }
                if (z2) {
                    return InstallQueue.m26928a().mo31621a(context, i, z);
                }
                return m26661b(context, i, z);
            }
        }
        return 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0073, code lost:
            if (r3 != null) goto L_0x007f;
     */
    /* renamed from: b */
    public static int m26661b(android.content.Context r7, int r8, boolean r9) {
        /*
        com.ss.android.socialbase.downloader.downloader.f r0 = com.p530ss.android.socialbase.downloader.downloader.Downloader.m27478a(r7)
        com.ss.android.socialbase.downloader.g.c r0 = r0.mo31928h(r8)
        r1 = 2
        if (r0 == 0) goto L_0x0114
        java.lang.String r2 = r0.mo32231ah()
        java.lang.String r3 = "application/vnd.android.package-archive"
        boolean r2 = r3.equals(r2)
        if (r2 == 0) goto L_0x0114
        java.lang.String r2 = r0.mo32297k()
        boolean r2 = android.text.TextUtils.isEmpty(r2)
        if (r2 != 0) goto L_0x0114
        java.lang.String r2 = r0.mo32287h()
        boolean r2 = android.text.TextUtils.isEmpty(r2)
        if (r2 != 0) goto L_0x0114
        java.io.File r2 = new java.io.File
        java.lang.String r3 = r0.mo32297k()
        java.lang.String r4 = r0.mo32287h()
        r2.<init>(r3, r4)
        boolean r3 = r2.exists()
        if (r3 != 0) goto L_0x0040
        goto L_0x0114
    L_0x0040:
        java.lang.String r3 = r2.getPath()
        java.io.File r4 = android.os.Environment.getDataDirectory()
        java.lang.String r4 = r4.getAbsolutePath()
        boolean r3 = r3.startsWith(r4)
        r4 = 0
        if (r3 == 0) goto L_0x008a
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0078 }
        r3.<init>()     // Catch:{ all -> 0x0078 }
        java.lang.String r5 = "chmod 555 "
        r3.append(r5)     // Catch:{ all -> 0x0078 }
        java.lang.String r5 = r2.getAbsolutePath()     // Catch:{ all -> 0x0078 }
        r3.append(r5)     // Catch:{ all -> 0x0078 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0078 }
        java.lang.Runtime r5 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0078 }
        java.lang.Process r3 = r5.exec(r3)     // Catch:{ all -> 0x0078 }
        r3.waitFor()     // Catch:{ all -> 0x0076 }
        if (r3 == 0) goto L_0x008a
        goto L_0x007f
    L_0x0076:
        r5 = move-exception
        goto L_0x007a
    L_0x0078:
        r5 = move-exception
        r3 = r4
    L_0x007a:
        r5.printStackTrace()     // Catch:{ all -> 0x0083 }
        if (r3 == 0) goto L_0x008a
    L_0x007f:
        r3.destroy()
        goto L_0x008a
    L_0x0083:
        r7 = move-exception
        if (r3 == 0) goto L_0x0089
        r3.destroy()
    L_0x0089:
        throw r7
    L_0x008a:
        android.content.pm.PackageManager r3 = r7.getPackageManager()
        java.lang.String r5 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x009b }
        int r6 = m26643a()     // Catch:{ Exception -> 0x009b }
        android.content.pm.PackageInfo r4 = r3.getPackageArchiveInfo(r5, r6)     // Catch:{ Exception -> 0x009b }
        goto L_0x009c
    L_0x009c:
        boolean r3 = m26656a(r7, r0, r4)
        if (r3 == 0) goto L_0x00a3
        return r1
    L_0x00a3:
        if (r4 == 0) goto L_0x00cb
        int r3 = r0.mo32283g()
        com.ss.android.socialbase.downloader.k.a r3 = com.p530ss.android.socialbase.downloader.p567k.DownloadSetting.m28610a(r3)
        java.lang.String r5 = "install_callback_error"
        boolean r3 = r3.mo32550a(r5)
        if (r3 == 0) goto L_0x00cb
        android.os.Bundle r3 = r0.mo32261bg()
        java.lang.String r5 = r4.packageName
        java.lang.String r6 = "extra_apk_package_name"
        r3.putString(r6, r5)
        android.os.Bundle r3 = r0.mo32261bg()
        int r5 = r4.versionCode
        java.lang.String r6 = "extra_apk_version_code"
        r3.putInt(r6, r5)
    L_0x00cb:
        r3 = 1
        int[] r5 = new int[r3]
        boolean r6 = m26655a(r7, r4)
        if (r6 == 0) goto L_0x00df
        java.lang.String r8 = r4.packageName
        android.content.pm.PackageManager r2 = r7.getPackageManager()
        android.content.Intent r8 = r2.getLaunchIntentForPackage(r8)
        goto L_0x00f5
    L_0x00df:
        if (r9 != 0) goto L_0x00f1
        boolean r8 = m26654a(r7, r8, r2)
        if (r8 == 0) goto L_0x00f1
        android.os.Bundle r7 = r0.mo32261bg()
        java.lang.String r8 = "extra_silent_install_succeed"
        r7.putBoolean(r8, r3)
        return r3
    L_0x00f1:
        android.content.Intent r8 = m26646a(r7, r0, r2, r9, r5)
    L_0x00f5:
        r2 = 0
        if (r8 != 0) goto L_0x00ff
        r7 = r5[r2]
        if (r7 != r3) goto L_0x00fd
        goto L_0x00fe
    L_0x00fd:
        r1 = 0
    L_0x00fe:
        return r1
    L_0x00ff:
        r1 = 268435456(0x10000000, float:2.5243549E-29)
        r8.addFlags(r1)
        r1 = r5[r2]
        if (r1 != 0) goto L_0x010f
        boolean r9 = com.p530ss.android.socialbase.appdownloader.C6604b.m26618a(r7, r0, r8, r9)
        if (r9 == 0) goto L_0x010f
        return r3
    L_0x010f:
        r7.startActivity(r8)     // Catch:{ all -> 0x0113 }
        return r3
    L_0x0113:
        return r2
    L_0x0114:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26661b(android.content.Context, int, boolean):int");
    }

    /* renamed from: a */
    public static boolean m26656a(Context context, DownloadInfo cVar, PackageInfo packageInfo) {
        if (packageInfo != null && !packageInfo.packageName.equals(cVar.mo32319z())) {
            IAppDownloadEventHandler b = AppDownloader.m26714h().mo31485b();
            if (b != null) {
                b.mo31369a(cVar.mo32283g(), 8, cVar.mo32319z(), packageInfo.packageName, "");
                if (b.mo31372a()) {
                    return true;
                }
            }
            IDownloadNotificationEventListener i = Downloader.m27478a(context).mo31929i(cVar.mo32283g());
            if (i != null) {
                i.mo31500a(8, cVar, packageInfo.packageName, "");
                IAppDownloadDepend a = AppDownloader.m26714h().mo31474a();
                if ((a instanceof AbsAppDownloadDepend) && ((AbsAppDownloadDepend) a).mo31462c()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m26654a(Context context, int i, File file) {
        String str = "AppDownloadUtils";
        C6704a.m27758b(str, "start try silent install on miui");
        if (DownloadSetting.m28610a(i).mo32547a("back_miui_silent_install", 1) == 1) {
            C6704a.m27758b(str, "back_miui_silent_install = 1");
            return false;
        } else if (C6792i.m28940j() || C6792i.m28941k()) {
            String str2 = "com.miui.enterprise.service.EntInstallService";
            String str3 = "com.miui.securitycore";
            if (SystemUtils.m28953a(context, str3, str2)) {
                C6704a.m27758b(str, "EntInstallService exists");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(str3, str2));
                Bundle bundle = new Bundle();
                bundle.putInt("userId", 0);
                bundle.putInt("flag", 256);
                bundle.putString(AppEntity.KEY_APK_PATH_STR, file.getPath());
                bundle.putString("installerPkg", str3);
                intent.putExtras(bundle);
                try {
                    context.startService(intent);
                    C6704a.m27758b(str, "start EntInstallService");
                    return true;
                } catch (Exception e) {
                    C6704a.m27758b(str, "start EntInstallService error");
                    e.printStackTrace();
                    return false;
                }
            } else {
                C6704a.m27758b(str, "EntInstallService does not exist");
                return false;
            }
        } else {
            C6704a.m27758b(str, "neither miui10 nor miui11");
            return false;
        }
    }

    /* renamed from: a */
    public static int m26643a() {
        return AppDownloader.m26714h().mo31492e() ? 16384 : 0;
    }

    /* renamed from: a */
    public static Uri m26647a(int i, IDownloadFileUriProvider xVar, Context context, String str, File file) {
        Uri uri;
        if (xVar != null) {
            try {
                uri = xVar.mo31814a(str, file.getAbsolutePath());
            } catch (Throwable unused) {
            }
        } else {
            IAppDownloadFileUriProvider d = AppDownloader.m26714h().mo31491d();
            if (d != null) {
                uri = d.mo31469a(i, str, file.getAbsolutePath());
            }
            uri = null;
        }
        if (uri != null) {
            return uri;
        }
        try {
            if (VERSION.SDK_INT < 24 || TextUtils.isEmpty(str)) {
                return Uri.fromFile(file);
            }
            return FileProvider.getUriForFile(context, str, file);
        } catch (Throwable th) {
            th.printStackTrace();
            return uri;
        }
    }

    /* renamed from: a */
    private static Intent m26646a(Context context, DownloadInfo cVar, File file, boolean z, int[] iArr) {
        Uri a = m26647a(cVar.mo32283g(), Downloader.m27478a(context).mo31932l(cVar.mo32283g()), context, AppDownloader.m26714h().mo31490c(), file);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(a, "application/vnd.android.package-archive");
        IAppDownloadEventHandler b = AppDownloader.m26714h().mo31485b();
        int a2 = b != null ? b.mo31373a(cVar.mo32283g(), z) : 0;
        IDownloadNotificationEventListener i = Downloader.m27478a(context).mo31929i(cVar.mo32283g());
        if (i != null) {
            a2 = i.mo31501a(z);
        }
        iArr[0] = a2;
        if (a2 != 0) {
            return null;
        }
        return intent;
    }

    /* renamed from: a */
    public static boolean m26659a(DownloadInfo cVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(cVar.mo32319z()) && str.equals(cVar.mo32319z())) {
            return true;
        }
        if (TextUtils.isEmpty(cVar.mo32287h()) || !m26657a(C6694b.m27342B(), cVar, str)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007c, code lost:
            if (r10 == r4.versionCode) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c7, code lost:
            if (r10 == r4.versionCode) goto L_0x007e;
     */
    /* renamed from: a */
    public static boolean m26657a(android.content.Context r9, com.p530ss.android.socialbase.downloader.p562g.DownloadInfo r10, java.lang.String r11) {
        /*
        r0 = 0
        if (r9 != 0) goto L_0x0004
        return r0
    L_0x0004:
        java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00cb }
        java.lang.String r2 = r10.mo32297k()     // Catch:{ Exception -> 0x00cb }
        java.lang.String r3 = r10.mo32287h()     // Catch:{ Exception -> 0x00cb }
        r1.<init>(r2, r3)     // Catch:{ Exception -> 0x00cb }
        boolean r2 = r1.exists()     // Catch:{ Exception -> 0x00cb }
        r3 = 1
        r4 = 0
        if (r2 == 0) goto L_0x0080
        android.content.pm.PackageManager r2 = r9.getPackageManager()     // Catch:{ Exception -> 0x00cb }
        java.lang.String r5 = "AppDownloadUtils"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cb }
        r6.<init>()     // Catch:{ Exception -> 0x00cb }
        java.lang.String r7 = "isPackageNameEqualsWithApk fileName:"
        r6.append(r7)     // Catch:{ Exception -> 0x00cb }
        java.lang.String r7 = r10.mo32287h()     // Catch:{ Exception -> 0x00cb }
        r6.append(r7)     // Catch:{ Exception -> 0x00cb }
        java.lang.String r7 = " apkFileSize："
        r6.append(r7)     // Catch:{ Exception -> 0x00cb }
        long r7 = r1.length()     // Catch:{ Exception -> 0x00cb }
        r6.append(r7)     // Catch:{ Exception -> 0x00cb }
        java.lang.String r7 = " fileUrl："
        r6.append(r7)     // Catch:{ Exception -> 0x00cb }
        java.lang.String r10 = r10.mo32295j()     // Catch:{ Exception -> 0x00cb }
        r6.append(r10)     // Catch:{ Exception -> 0x00cb }
        java.lang.String r10 = r6.toString()     // Catch:{ Exception -> 0x00cb }
        android.util.Log.e(r5, r10)     // Catch:{ Exception -> 0x00cb }
        java.lang.String r10 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x00cb }
        int r1 = m26643a()     // Catch:{ Exception -> 0x00cb }
        android.content.pm.PackageInfo r10 = r2.getPackageArchiveInfo(r10, r1)     // Catch:{ Exception -> 0x00cb }
        if (r10 != 0) goto L_0x005e
        return r0
    L_0x005e:
        java.lang.String r1 = r10.packageName     // Catch:{ Exception -> 0x00cb }
        boolean r1 = r1.equals(r11)     // Catch:{ Exception -> 0x00cb }
        if (r1 != 0) goto L_0x0067
        return r0
    L_0x0067:
        int r10 = r10.versionCode     // Catch:{ Exception -> 0x00cb }
        android.content.pm.PackageManager r9 = r9.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0076 }
        int r1 = m26643a()     // Catch:{ NameNotFoundException -> 0x0076 }
        android.content.pm.PackageInfo r4 = r9.getPackageInfo(r11, r1)     // Catch:{ NameNotFoundException -> 0x0076 }
        goto L_0x0077
    L_0x0077:
        if (r4 != 0) goto L_0x007a
        goto L_0x00cf
    L_0x007a:
        int r9 = r4.versionCode     // Catch:{ Exception -> 0x00cb }
        if (r10 != r9) goto L_0x00cf
    L_0x007e:
        r0 = 1
        goto L_0x00cf
    L_0x0080:
        int r1 = r10.mo32283g()     // Catch:{ Exception -> 0x00cb }
        com.ss.android.socialbase.downloader.k.a r1 = com.p530ss.android.socialbase.downloader.p567k.DownloadSetting.m28610a(r1)     // Catch:{ Exception -> 0x00cb }
        java.lang.String r2 = "install_callback_error"
        boolean r1 = r1.mo32550a(r2)     // Catch:{ Exception -> 0x00cb }
        if (r1 == 0) goto L_0x00cf
        android.os.Bundle r1 = r10.mo32261bg()     // Catch:{ Exception -> 0x00cb }
        java.lang.String r2 = "extra_apk_package_name"
        java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x00cb }
        android.os.Bundle r10 = r10.mo32261bg()     // Catch:{ Exception -> 0x00cb }
        java.lang.String r2 = "extra_apk_version_code"
        int r10 = r10.getInt(r2)     // Catch:{ Exception -> 0x00cb }
        if (r1 == 0) goto L_0x00ca
        boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00cb }
        if (r2 == 0) goto L_0x00ad
        goto L_0x00ca
    L_0x00ad:
        boolean r1 = r1.equals(r11)     // Catch:{ Exception -> 0x00cb }
        if (r1 != 0) goto L_0x00b4
        return r0
    L_0x00b4:
        android.content.pm.PackageManager r9 = r9.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00c1 }
        int r1 = m26643a()     // Catch:{ NameNotFoundException -> 0x00c1 }
        android.content.pm.PackageInfo r4 = r9.getPackageInfo(r11, r1)     // Catch:{ NameNotFoundException -> 0x00c1 }
        goto L_0x00c2
    L_0x00c2:
        if (r4 != 0) goto L_0x00c5
        goto L_0x00cf
    L_0x00c5:
        int r9 = r4.versionCode     // Catch:{ Exception -> 0x00cb }
        if (r10 != r9) goto L_0x00cf
        goto L_0x007e
    L_0x00ca:
        return r0
    L_0x00cb:
        r9 = move-exception
        r9.printStackTrace()
    L_0x00cf:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26657a(android.content.Context, com.ss.android.socialbase.downloader.g.c, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static boolean m26655a(Context context, PackageInfo packageInfo) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, m26643a());
        } catch (NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 != null && i <= packageInfo2.versionCode) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m26662b(String str, String str2) {
        IDownloadGlobalMonitorListener D = C6694b.m27344D();
        if (D != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", str2);
            } catch (JSONException unused) {
            }
            D.mo32445a(str, jSONObject);
        }
    }

    /* renamed from: a */
    public static boolean m26658a(Context context, String str, String str2, String str3) {
        final File file;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                file = new File(str, str2);
                if (!file.exists()) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("isApkInstalled apkFileSize：fileName:");
                sb.append(file.getPath());
                sb.append(" apkFileSize");
                sb.append(file.length());
                Log.e("AppDownloadUtils", sb.toString());
                PackageInfo packageInfo = null;
                if (!DownloadExpSwitchCode.m28744a(268435456) || VERSION.SDK_INT < 21 || VERSION.SDK_INT >= 26) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("sigbus:\n\turl: ");
                    sb2.append(str3);
                    sb2.append("\n\tmd5: ");
                    sb2.append(DownloadDigestUtils.m28741a(file));
                    sb2.append("\n\tfileName: ");
                    sb2.append(file.getPath());
                    sb2.append("\n\tfileLength: ");
                    sb2.append(file.length());
                    sb2.append("\n");
                    m26662b("sigbus_test6", sb2.toString());
                    packageInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), m26643a());
                } else {
                    m26662b("sigbus_test1", "before getpackageinfo");
                    packageInfo = PackageInfoUtils.m26807a(file);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("success: packageName: ");
                    sb3.append(packageInfo.packageName);
                    sb3.append(", versionCode: ");
                    sb3.append(packageInfo.versionCode);
                    m26662b("sigbus_test2", sb3.toString());
                }
                return m26655a(context, packageInfo);
            } catch (RuntimeException e) {
                final RuntimeException runtimeException = e;
                ExecutorService k = C6694b.m27379k();
                final String str4 = str;
                final String str5 = str2;
                final String str6 = str3;
                C66121 r2 = new Runnable() {
                    public void run() {
                        String str = "\n";
                        try {
                            String a = DownloadDigestUtils.m28741a(file);
                            StringBuilder sb = new StringBuilder();
                            sb.append("failed:\n");
                            sb.append("\tmessage: ");
                            sb.append(runtimeException.getMessage());
                            sb.append(str);
                            sb.append("\tfilePath: ");
                            sb.append(str4);
                            sb.append(str);
                            sb.append("\tfileName: ");
                            sb.append(str5);
                            sb.append(str);
                            sb.append("\turl: ");
                            sb.append(str6);
                            sb.append(str);
                            sb.append("\tfileLength: ");
                            sb.append(file.length());
                            String str2 = "sigbus_test3";
                            if (!TextUtils.isEmpty(a)) {
                                sb.append("\tmd5: ");
                                sb.append(a);
                                sb.append(str);
                                str2 = "sigbus_test4";
                            }
                            AppDownloadUtils.m26662b(str2, sb.toString());
                        } catch (Throwable th) {
                            AppDownloadUtils.m26662b("sigbus_test5", th.getMessage());
                        }
                    }
                };
                k.execute(r2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
            if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
    /* renamed from: a */
    public static java.lang.String m26652a(java.lang.String r1, java.lang.String r2, java.lang.String r3, boolean r4) {
        /*
        boolean r0 = android.text.TextUtils.isEmpty(r1)
        if (r0 == 0) goto L_0x0009
        java.lang.String r1 = ""
        return r1
    L_0x0009:
        android.net.Uri r1 = android.net.Uri.parse(r1)
        java.lang.String r0 = "default.apk"
        if (r4 == 0) goto L_0x0026
        boolean r4 = android.text.TextUtils.isEmpty(r2)
        if (r4 == 0) goto L_0x003a
        java.lang.String r2 = r1.getLastPathSegment()
        boolean r2 = android.text.TextUtils.isEmpty(r2)
        if (r2 != 0) goto L_0x0037
        java.lang.String r2 = r1.getLastPathSegment()
        goto L_0x003a
    L_0x0026:
        java.lang.String r1 = r1.getLastPathSegment()
        boolean r4 = android.text.TextUtils.isEmpty(r1)
        if (r4 == 0) goto L_0x0039
        boolean r1 = android.text.TextUtils.isEmpty(r2)
        if (r1 != 0) goto L_0x0037
        goto L_0x003a
    L_0x0037:
        r2 = r0
        goto L_0x003a
    L_0x0039:
        r2 = r1
    L_0x003a:
        boolean r1 = m26668d(r3)
        if (r1 == 0) goto L_0x0057
        java.lang.String r1 = ".apk"
        boolean r3 = r2.endsWith(r1)
        if (r3 != 0) goto L_0x0057
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        r3.append(r2)
        r3.append(r1)
        java.lang.String r2 = r3.toString()
    L_0x0057:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26652a(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: a */
    public static String m26650a(Context context) {
        return m26651a(context, (String) null, (DownloadSetting) null);
    }

    /* renamed from: a */
    public static String m26651a(Context context, String str, DownloadSetting aVar) {
        if (context == null) {
            return "";
        }
        File f = AppDownloader.m26714h().mo31493f();
        if (f == null || !f.exists() || !f.isDirectory()) {
            f = m26667d(context);
        }
        if (f != null) {
            if (f.exists()) {
                if (!f.isDirectory()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(f.getAbsolutePath());
                    sb.append(" already exists and is not a directory");
                    throw new IllegalStateException(sb.toString());
                }
            } else if (!f.mkdirs()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to create directory: ");
                sb2.append(f.getAbsolutePath());
                throw new IllegalStateException(sb2.toString());
            }
            String absolutePath = f.getAbsolutePath();
            if (aVar != null) {
                JSONObject d = aVar.mo32555d("anti_hijack_dir");
                if (d != null) {
                    String optString = d.optString("dir_name");
                    if (!TextUtils.isEmpty(optString)) {
                        if (!optString.contains("%s")) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(optString);
                            sb3.append(str);
                            optString = sb3.toString();
                        } else {
                            try {
                                optString = String.format(optString, new Object[]{str});
                            } catch (Throwable unused) {
                            }
                        }
                        if (optString.length() > 255) {
                            optString = optString.substring(optString.length() - 255);
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(absolutePath);
                        sb4.append(File.separator);
                        sb4.append(optString);
                        absolutePath = sb4.toString();
                    }
                }
            }
            return absolutePath;
        }
        throw new IllegalStateException("Failed to get storage directory");
    }

    /* renamed from: a */
    public static boolean m26660a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (new JSONObject(str).optBoolean("bind_app", false)) {
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m26664b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optBoolean("bind_app", false) || !jSONObject.optBoolean("auto_install_with_notification", true)) {
                return true;
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static boolean m26666c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (new JSONObject(str).optBoolean("auto_install_without_notification", false)) {
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: a */
    public static int m26644a(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (DownloadStatus.m26982b(i)) {
            return 1;
        }
        if (DownloadStatus.m26981a(i)) {
            return 3;
        }
        return 0;
    }

    /* renamed from: d */
    public static boolean m26668d(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
            if (r0 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r0.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
            if (r0 == null) goto L_0x0044;
     */
    /* renamed from: b */
    public static boolean m26663b(android.content.Context r6) {
        /*
        int r0 = android.os.Build.VERSION.SDK_INT
        r1 = 0
        r2 = 20
        if (r0 <= r2) goto L_0x0044
        if (r6 != 0) goto L_0x000a
        goto L_0x0044
    L_0x000a:
        r0 = 0
        int r2 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26817b()     // Catch:{ all -> 0x0041 }
        android.content.res.Resources r3 = r6.getResources()     // Catch:{ all -> 0x0041 }
        int r2 = r3.getColor(r2)     // Catch:{ all -> 0x0041 }
        int r3 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26818c()     // Catch:{ all -> 0x0041 }
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26819d()     // Catch:{ all -> 0x0041 }
        r5 = 2
        int[] r5 = new int[r5]     // Catch:{ all -> 0x0041 }
        r5[r1] = r3     // Catch:{ all -> 0x0041 }
        r3 = 1
        r5[r3] = r4     // Catch:{ all -> 0x0041 }
        int r4 = com.p530ss.android.socialbase.appdownloader.AppResourceUtils.m26820e()     // Catch:{ all -> 0x0041 }
        android.content.res.TypedArray r0 = r6.obtainStyledAttributes(r4, r5)     // Catch:{ all -> 0x0041 }
        int r6 = r0.getColor(r1, r1)     // Catch:{ all -> 0x0041 }
        if (r2 != r6) goto L_0x003b
        if (r0 == 0) goto L_0x003a
        r0.recycle()     // Catch:{ all -> 0x003a }
    L_0x003a:
        return r3
    L_0x003b:
        if (r0 == 0) goto L_0x0044
    L_0x003d:
        r0.recycle()     // Catch:{ all -> 0x0044 }
        goto L_0x0044
    L_0x0041:
        if (r0 == 0) goto L_0x0044
        goto L_0x003d
    L_0x0044:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26663b(android.content.Context):boolean");
    }

    /* renamed from: c */
    public static String m26665c(Context context) {
        String str = "111111";
        try {
            if (f21503a == null) {
                f21503a = new NotificationChannel(str, "channel_appdownloader", 3);
                f21503a.setSound(null, null);
                f21503a.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(f21503a);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str;
    }

    /* renamed from: d */
    public static File m26667d(Context context) {
        String str = "";
        Context applicationContext = context.getApplicationContext();
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        if ("mounted".equals(str)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return applicationContext.getFilesDir();
    }
}
