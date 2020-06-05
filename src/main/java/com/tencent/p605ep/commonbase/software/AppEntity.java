package com.tencent.p605ep.commonbase.software;

import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import com.tencent.p605ep.commonbase.api.BaseEntity;
import java.util.HashMap;

/* renamed from: com.tencent.ep.commonbase.software.AppEntity */
public class AppEntity extends BaseEntity {
    public static final int FLAG_APK = 64;
    public static final int FLAG_APPNAME = 2048;
    public static final int FLAG_APP_INFO = 1;
    public static final int FLAG_APP_INFO_SIMPLE = 2;
    public static final int FLAG_ICON = 4;
    public static final int FLAG_INSTALLED_ON_SDCARD = 8192;
    public static final int FLAG_PERMISSIONS = 32;
    public static final int FLAG_PKGNAME = 128;
    public static final int FLAG_SIGNATURE = 16;
    public static final int FLAG_SIGNATURE_ARRAY = 4096;
    public static final int FLAG_UID = 1024;
    public static final int FLAG_VERSION = 8;
    public static final int FLAG_VERSIONCODE = 512;
    public static final int FLAG_VERSIONNAME = 256;
    public static final String KEY_APK_PATH_STR = "apkPath";
    public static final String KEY_APP_NAME_STR = "appName";
    public static final String KEY_ICON_DRAWABLE = "icon";
    public static final String KEY_INSTALLED_ON_SDCARD = "installedOnSdcard";
    public static final String KEY_IS_APK_BOOL = "isApk";
    public static final String KEY_IS_SYSTEM_BOOL = "isSystem";
    public static final String KEY_IS_UPDATE_SYSTEM_BOOL = "isUpdateSystem";
    public static final String KEY_LAST_MODIFIED_LONG = "lastModified";
    public static final String KEY_PERMISSION_STR_ARRAY = "permissions";
    public static final String KEY_PKG_NAME_STR = "pkgName";
    public static final String KEY_SIGNATURE_ARRAY = "signatureArray";
    public static final String KEY_SIGNATURE_COMPANY_STR = "signatureCompany";
    public static final String KEY_SIGNATURE_MD5_STR = "signatureCermMD5";
    public static final String KEY_SIZE_LONG = "size";
    public static final String KEY_UID = "uid";
    public static final String KEY_VERSION_CODE_INT = "versionCode";
    public static final String KEY_VERSION_STR = "version";
    /* renamed from: c */
    private static final long f24742c = 1;
    /* renamed from: b */
    private HashMap<String, Object> f24743b = new HashMap<>();

    /* renamed from: a */
    private String m31519a(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof String ? (String) obj : obj.toString();
    }

    public Object get(String str) {
        return this.f24743b.get(str);
    }

    public String getApkPath() {
        return m31519a(this.f24743b.get(KEY_APK_PATH_STR));
    }

    public String getAppName() {
        return m31519a(this.f24743b.get(KEY_APP_NAME_STR));
    }

    public String getCertMD5() {
        return m31519a(this.f24743b.get(KEY_SIGNATURE_MD5_STR));
    }

    public String getCompany() {
        return m31519a(this.f24743b.get(KEY_SIGNATURE_COMPANY_STR));
    }

    public Drawable getIcon() {
        Object obj = this.f24743b.get("icon");
        if (obj != null) {
            return (Drawable) obj;
        }
        return null;
    }

    public long getLastModifiedTime() {
        Object obj = this.f24743b.get(KEY_LAST_MODIFIED_LONG);
        if (obj != null) {
            return ((Long) obj).longValue();
        }
        return 0;
    }

    public String getPackageName() {
        return m31519a(this.f24743b.get(KEY_PKG_NAME_STR));
    }

    public String[] getPermissions() {
        Object obj = this.f24743b.get(KEY_PERMISSION_STR_ARRAY);
        if (obj != null) {
            return (String[]) obj;
        }
        return null;
    }

    public Signature[] getSignatures() {
        Object obj = this.f24743b.get(KEY_SIGNATURE_ARRAY);
        if (obj != null) {
            return (Signature[]) obj;
        }
        return null;
    }

    public long getSize() {
        Object obj = this.f24743b.get(KEY_SIZE_LONG);
        if (obj != null) {
            return ((Long) obj).longValue();
        }
        return 0;
    }

    public int getUid() {
        Object obj = this.f24743b.get(KEY_UID);
        if (obj != null) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public String getVersion() {
        return m31519a(this.f24743b.get(KEY_VERSION_STR));
    }

    public int getVersionCode() {
        Object obj = this.f24743b.get(KEY_VERSION_CODE_INT);
        if (obj != null) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public boolean isApk() {
        Object obj = this.f24743b.get(KEY_IS_APK_BOOL);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public boolean isInstalledOnSdcard() {
        Object obj = this.f24743b.get(KEY_INSTALLED_ON_SDCARD);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public boolean isSystemApp() {
        Object obj = this.f24743b.get(KEY_IS_SYSTEM_BOOL);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public boolean isUpdateSystemApp() {
        Object obj = this.f24743b.get(KEY_IS_UPDATE_SYSTEM_BOOL);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public void put(String str, Object obj) {
        this.f24743b.put(str, obj);
    }

    public void setApkFlag(boolean z) {
        this.f24743b.put(KEY_IS_APK_BOOL, Boolean.valueOf(z));
    }

    public void setApkPath(String str) {
        this.f24743b.put(KEY_APK_PATH_STR, str);
    }

    public void setAppName(String str) {
        this.f24743b.put(KEY_APP_NAME_STR, str);
    }

    public void setCertMD5(String str) {
        this.f24743b.put(KEY_SIGNATURE_MD5_STR, str);
    }

    public void setCompany(String str) {
        this.f24743b.put(KEY_SIGNATURE_COMPANY_STR, str);
    }

    public void setIcon(Drawable drawable) {
        this.f24743b.put("icon", drawable);
    }

    public void setInstalledOnSdcard(Boolean bool) {
        this.f24743b.put(KEY_INSTALLED_ON_SDCARD, bool);
    }

    public void setLastModifiedTime(long j) {
        this.f24743b.put(KEY_LAST_MODIFIED_LONG, Long.valueOf(j));
    }

    public void setPackageName(String str) {
        this.f24743b.put(KEY_PKG_NAME_STR, str);
    }

    public void setPermissions(String[] strArr) {
        this.f24743b.put(KEY_PERMISSION_STR_ARRAY, strArr);
    }

    public void setSignaturesArr(Signature[] signatureArr) {
        this.f24743b.put(KEY_SIGNATURE_ARRAY, signatureArr);
    }

    public void setSize(long j) {
        this.f24743b.put(KEY_SIZE_LONG, Long.valueOf(j));
    }

    public void setSystemFlag(boolean z) {
        this.f24743b.put(KEY_IS_SYSTEM_BOOL, Boolean.valueOf(z));
    }

    public void setUid(int i) {
        this.f24743b.put(KEY_UID, Integer.valueOf(i));
    }

    public void setUpdateSystemFlag(boolean z) {
        this.f24743b.put(KEY_IS_UPDATE_SYSTEM_BOOL, Boolean.valueOf(z));
    }

    public void setVersion(String str) {
        this.f24743b.put(KEY_VERSION_STR, str);
    }

    public void setVersionCode(int i) {
        this.f24743b.put(KEY_VERSION_CODE_INT, Integer.valueOf(i));
    }
}
