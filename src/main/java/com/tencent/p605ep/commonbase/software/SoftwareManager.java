package com.tencent.p605ep.commonbase.software;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.tencent.p605ep.commonbase.api.BaseManagerC;
import com.tencent.p605ep.commonbase.utils.MD5Util;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.ep.commonbase.software.SoftwareManager */
public final class SoftwareManager extends BaseManagerC {
    /* renamed from: e */
    private static final String f24745e = "SoftwareManager";
    /* renamed from: b */
    private PackageManager f24746b = null;
    /* renamed from: c */
    private Context f24747c = null;
    /* renamed from: d */
    private CertificateFactory f24748d = null;

    /* renamed from: a */
    private int m31523a(int i) {
        int i2 = (i & 16) != 0 ? 64 : 0;
        return (i & 32) != 0 ? i2 | 4096 : i2;
    }

    /* renamed from: a */
    private Certificate m31524a(Signature signature) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        Certificate certificate = null;
        try {
            X509Certificate x509Certificate = (X509Certificate) this.f24748d.generateCertificate(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
                return x509Certificate;
            } catch (IOException e) {
                e = e;
                certificate = x509Certificate;
                e.printStackTrace();
                return certificate;
            }
        } catch (CertificateException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
        try {
            byteArrayInputStream.close();
            return null;
        } catch (IOException e5) {
            e = e5;
        }
    }

    /* renamed from: a */
    private void m31525a(PackageInfo packageInfo, AppEntity appEntity) {
        if (packageInfo != null) {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null && signatureArr.length >= 1) {
                X509Certificate x509Certificate = (X509Certificate) m31524a(signatureArr[0]);
                if (x509Certificate != null) {
                    String str = null;
                    try {
                        str = MD5Util.encrypt_bytes(x509Certificate.getEncoded());
                    } catch (CertificateEncodingException e) {
                        e.printStackTrace();
                    }
                    appEntity.put(AppEntity.KEY_SIGNATURE_MD5_STR, str);
                }
            }
        }
    }

    /* renamed from: a */
    private void m31526a(PackageInfo packageInfo, AppEntity appEntity, int i) {
        if (!(packageInfo == null || appEntity == null)) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                int i2 = i & 1;
                int i3 = -1;
                String str = AppEntity.KEY_UID;
                String str2 = AppEntity.KEY_IS_SYSTEM_BOOL;
                String str3 = AppEntity.KEY_PKG_NAME_STR;
                boolean z = true;
                if (i2 != 0) {
                    appEntity.put(str3, applicationInfo.packageName);
                    appEntity.put(AppEntity.KEY_APP_NAME_STR, this.f24746b.getApplicationLabel(packageInfo.applicationInfo).toString());
                    appEntity.put(str2, Boolean.valueOf((packageInfo.applicationInfo.flags & 1) != 0));
                    ApplicationInfo applicationInfo2 = packageInfo.applicationInfo;
                    appEntity.put(str, Integer.valueOf(applicationInfo2 != null ? applicationInfo2.uid : -1));
                }
                if ((i & 2) != 0) {
                    appEntity.put(str3, packageInfo.applicationInfo.packageName);
                    if ((packageInfo.applicationInfo.flags & 1) == 0) {
                        z = false;
                    }
                    appEntity.put(str2, Boolean.valueOf(z));
                    ApplicationInfo applicationInfo3 = packageInfo.applicationInfo;
                    if (applicationInfo3 != null) {
                        i3 = applicationInfo3.uid;
                    }
                    appEntity.put(str, Integer.valueOf(i3));
                }
                if ((i & 4) != 0) {
                    appEntity.put("icon", packageInfo.applicationInfo.loadIcon(this.f24746b));
                }
                if ((i & 8) != 0) {
                    appEntity.put(AppEntity.KEY_VERSION_STR, packageInfo.versionName);
                    appEntity.put(AppEntity.KEY_VERSION_CODE_INT, Integer.valueOf(packageInfo.versionCode));
                    File file = new File(packageInfo.applicationInfo.sourceDir);
                    appEntity.put(AppEntity.KEY_SIZE_LONG, Long.valueOf(file.length()));
                    appEntity.put(AppEntity.KEY_LAST_MODIFIED_LONG, Long.valueOf(file.lastModified()));
                }
                if ((i & 16) != 0) {
                    m31525a(packageInfo, appEntity);
                }
                if ((i & 32) != 0) {
                    appEntity.put(AppEntity.KEY_PERMISSION_STR_ARRAY, packageInfo.requestedPermissions);
                }
                if ((i & 64) != 0) {
                    appEntity.put(AppEntity.KEY_APK_PATH_STR, packageInfo.applicationInfo.sourceDir);
                    appEntity.put(AppEntity.KEY_IS_APK_BOOL, Boolean.valueOf(false));
                }
            }
        }
    }

    public AppEntity getAppInfo(AppEntity appEntity, int i) {
        PackageInfo packageInfo = getPackageInfo((String) appEntity.get(AppEntity.KEY_PKG_NAME_STR), m31523a(i));
        if (packageInfo == null) {
            return null;
        }
        m31526a(packageInfo, appEntity, i);
        return appEntity;
    }

    public AppEntity getAppInfo(String str, int i) {
        AppEntity appEntity = new AppEntity();
        appEntity.put(AppEntity.KEY_PKG_NAME_STR, str);
        return getAppInfo(appEntity, i);
    }

    public int getAppVersionStatus(String str, int i) {
        PackageInfo packageInfo = getPackageInfo(str, 0);
        if (packageInfo == null) {
            return -1;
        }
        int i2 = packageInfo.versionCode;
        if (i == i2) {
            return 0;
        }
        if (i < i2) {
            return i == 0 ? -2 : 2;
        }
        return 1;
    }

    public ArrayList<AppEntity> getInstalledApp(int i, int i2) {
        List<PackageInfo> list;
        try {
            list = this.f24746b.getInstalledPackages(i);
        } catch (Exception e) {
            e.printStackTrace();
            list = null;
        }
        ArrayList<AppEntity> arrayList = new ArrayList<>();
        if (list != null) {
            for (PackageInfo packageInfo : list) {
                if (packageInfo != null) {
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    if (applicationInfo != null) {
                        boolean z = (applicationInfo.flags & 1) != 0;
                        String str = packageInfo.applicationInfo.packageName;
                        if ((z || i2 != 1) && (!z || i2 != 0)) {
                            if (!str.equals(this.f24747c.getPackageName())) {
                                AppEntity appEntity = new AppEntity();
                                m31526a(packageInfo, appEntity, i);
                                arrayList.add(appEntity);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public PackageInfo getPackageInfo(String str, int i) {
        try {
            return this.f24746b.getPackageInfo(str, i);
        } catch (Exception unused) {
            return null;
        }
    }

    public PackageStats getPackageSizeInfo(String str) {
        return null;
    }

    public boolean isPackageInstalled(String str) {
        return getPackageInfo(str, 0) != null;
    }

    public void onCreate(Context context) {
        this.f24747c = context;
        this.f24746b = context.getPackageManager();
        try {
            this.f24748d = CertificateFactory.getInstance("X.509");
        } catch (CertificateException unused) {
        }
    }

    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i) {
        try {
            return this.f24746b.queryBroadcastReceivers(intent, i);
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public List<ResolveInfo> queryIntentActivities(Intent intent, int i) {
        try {
            return this.f24746b.queryIntentActivities(intent, i);
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public List<ResolveInfo> queryIntentServices(Intent intent, int i) {
        try {
            return this.f24746b.queryIntentServices(intent, i);
        } catch (Exception unused) {
            return new ArrayList();
        }
    }
}
