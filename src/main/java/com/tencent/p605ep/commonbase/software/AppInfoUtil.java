package com.tencent.p605ep.commonbase.software;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.p605ep.commonbase.api.AppContext;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.p605ep.commonbase.utils.MD5Util;
import epco.C7949b;
import epco.C7969g;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.tencent.ep.commonbase.software.AppInfoUtil */
public class AppInfoUtil {
    /* renamed from: a */
    private static final String f24744a = "AppInfoUtil";

    /* renamed from: a */
    private static AppInfo m31520a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo();
        try {
            if (packageInfo.applicationInfo != null && !TextUtils.isEmpty(packageInfo.applicationInfo.packageName)) {
                appInfo.mPkgName = packageInfo.applicationInfo.packageName;
            }
            if (packageInfo.applicationInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (applicationLabel != null) {
                    appInfo.mAppName = applicationLabel.toString();
                }
            }
            appInfo.mVersionCode = packageInfo.versionCode;
            appInfo.mVersionName = packageInfo.versionName;
            if (packageInfo.applicationInfo != null) {
                appInfo.mApkPath = packageInfo.applicationInfo.sourceDir;
            }
            appInfo.mIsSystemApp = false;
            appInfo.mUid = -1;
            File file = new File(appInfo.mApkPath);
            if (file.exists()) {
                appInfo.mSize = file.length();
                appInfo.mLastModified = file.lastModified();
            }
            if (packageInfo.signatures != null) {
                if (packageInfo.signatures.length >= 1) {
                    X509Certificate x509Certificate = (X509Certificate) m31521a(packageInfo.signatures[0]);
                    if (x509Certificate != null) {
                        appInfo.mSignatureMD5 = MD5Util.getByteMd5(x509Certificate.getEncoded());
                    }
                    return appInfo;
                }
            }
            return appInfo;
        } catch (Throwable th) {
            Log.m31487w(f24744a, th.getMessage());
        }
    }

    /* renamed from: a */
    private static Certificate m31521a(Signature signature) {
        Throwable th;
        Certificate certificate;
        String str = f24744a;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        try {
            certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
                return certificate;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            certificate = null;
            th = th3;
            Log.m31487w(str, th.getMessage());
            return certificate;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
            r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
    /* renamed from: a */
    private static java.security.cert.Certificate m31522a(java.security.cert.CertificateFactory r1, android.content.pm.Signature r2) {
        /*
        java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
        byte[] r2 = r2.toByteArray()
        r0.<init>(r2)
        r2 = 0
        java.security.cert.Certificate r1 = r1.generateCertificate(r0)     // Catch:{ all -> 0x0015 }
        java.security.cert.X509Certificate r1 = (java.security.cert.X509Certificate) r1     // Catch:{ all -> 0x0015 }
        r0.close()     // Catch:{ all -> 0x0013 }
    L_0x0013:
        r2 = r1
        goto L_0x0018
    L_0x0015:
        r0.close()     // Catch:{ all -> 0x0018 }
    L_0x0018:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.software.AppInfoUtil.m31522a(java.security.cert.CertificateFactory, android.content.pm.Signature):java.security.cert.Certificate");
    }

    public static ArrayList<String> extractPkgCertMd5s(String str, int i) {
        String str2 = f24744a;
        String str3 = "extractPkgCertMd5s(), e: ";
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = AppContext.getAppContext().getPackageManager().getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                Signature[] signatureArr = packageInfo.signatures;
                int i2 = 0;
                while (i2 < signatureArr.length && i2 < i) {
                    X509Certificate x509Certificate = (X509Certificate) m31522a(CertificateFactory.getInstance("X.509"), signatureArr[i2]);
                    if (x509Certificate != null) {
                        arrayList.add(MD5Util.getByteMd5(x509Certificate.getEncoded()));
                    }
                    i2++;
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(th.getMessage());
            Log.m31487w(str2, sb.toString());
        }
        return arrayList;
    }

    public static AppInfo getApkInfo(String str, boolean z) {
        AppInfo appInfo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PackageManager packageManager = AppContext.getAppContext().getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0);
            packageArchiveInfo.applicationInfo.sourceDir = str;
            packageArchiveInfo.applicationInfo.publicSourceDir = str;
            appInfo = m31520a(packageManager, packageArchiveInfo);
            if (z) {
                appInfo.mSignatureMD5 = getSignature(str);
            }
        } catch (Throwable th) {
            Log.m31487w(f24744a, th.getMessage());
        }
        return appInfo;
    }

    public static List<AppInfo> getInstalledAppList() {
        ArrayList arrayList = new ArrayList();
        try {
            PackageManager packageManager = AppContext.getAppContext().getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages == null) {
                return null;
            }
            for (PackageInfo a : installedPackages) {
                AppInfo a2 = m31520a(packageManager, a);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            Log.m31487w(f24744a, th.getMessage());
        }
    }

    public static String getSignature(String str) {
        ZipEntry zipEntry;
        try {
            ZipFile zipFile = new ZipFile(new File(str));
            Enumeration entries = zipFile.entries();
            while (true) {
                if (!entries.hasMoreElements()) {
                    zipEntry = null;
                    break;
                }
                zipEntry = (ZipEntry) entries.nextElement();
                if (!zipEntry.getName().contains("../")) {
                    if (!zipEntry.isDirectory()) {
                        if (zipEntry.getName().toUpperCase().endsWith(".RSA")) {
                            break;
                        } else if (zipEntry.getName().toUpperCase().endsWith(".DSA")) {
                            break;
                        }
                    }
                }
            }
            if (zipEntry != null) {
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                C7949b a = new C7969g(inputStream).mo38338a();
                inputStream.close();
                return a.f27001g;
            }
            throw new IOException("ApkParser certificate not found");
        } catch (Throwable unused) {
            return null;
        }
    }
}
