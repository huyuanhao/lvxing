package com.yanzhenjie.permission;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {
    /* renamed from: a */
    private static final String[] f26605a = {"_display_name", "_size"};
    /* renamed from: b */
    private static final File f26606b = new File("/");
    /* renamed from: c */
    private static final HashMap<String, C7815a> f26607c = new HashMap<>();
    /* renamed from: d */
    private C7815a f26608d;

    /* renamed from: com.yanzhenjie.permission.FileProvider$a */
    interface C7815a {
        /* renamed from: a */
        File mo38005a(Uri uri);
    }

    /* renamed from: com.yanzhenjie.permission.FileProvider$b */
    static class C7816b implements C7815a {
        /* renamed from: a */
        private final String f26609a;
        /* renamed from: b */
        private final HashMap<String, File> f26610b = new HashMap<>();

        C7816b(String str) {
            this.f26609a = str;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo38006a(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    file = file.getCanonicalFile();
                    this.f26610b.put(str, file);
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to resolve canonical path for ");
                    sb.append(file);
                    throw new IllegalArgumentException(sb.toString(), e);
                }
            } else {
                throw new IllegalArgumentException("Name must not be empty");
            }
        }

        /* renamed from: a */
        public File mo38005a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = (File) this.f26610b.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    file2 = file2.getCanonicalFile();
                    if (file2.getPath().startsWith(file.getPath())) {
                        return file2;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to resolve canonical path for ");
                    sb.append(file2);
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to find configured root for ");
                sb2.append(uri);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
    }

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.f26608d = m33935a(context, providerInfo.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File a = this.f26608d.mo38005a(uri);
        if (strArr == null) {
            strArr = f26605a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            String str4 = "_display_name";
            if (str4.equals(str3)) {
                strArr3[i2] = str4;
                i = i2 + 1;
                objArr[i2] = a.getName();
            } else {
                String str5 = "_size";
                if (str5.equals(str3)) {
                    strArr3[i2] = str5;
                    i = i2 + 1;
                    objArr[i2] = Long.valueOf(a.length());
                }
            }
            i2 = i;
        }
        String[] a2 = m33939a(strArr3, i2);
        Object[] a3 = m33938a(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(a2, 1);
        matrixCursor.addRow(a3);
        return matrixCursor;
    }

    public String getType(Uri uri) {
        File a = this.f26608d.mo38005a(uri);
        int lastIndexOf = a.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.f26608d.mo38005a(uri).delete();
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.f26608d.mo38005a(uri), m33934a(str));
    }

    /* renamed from: a */
    private static C7815a m33935a(Context context, String str) {
        C7815a aVar;
        synchronized (f26607c) {
            aVar = (C7815a) f26607c.get(str);
            if (aVar == null) {
                try {
                    aVar = m33940b(context, str);
                    f26607c.put(str, aVar);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return aVar;
    }

    /* renamed from: b */
    private static C7815a m33940b(Context context, String str) throws IOException, XmlPullParserException {
        C7816b bVar = new C7816b(str);
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData != null) {
            while (true) {
                int next = loadXmlMetaData.next();
                if (next == 1) {
                    return bVar;
                }
                if (next == 2) {
                    String name = loadXmlMetaData.getName();
                    File file = null;
                    String attributeValue = loadXmlMetaData.getAttributeValue(null, ArgKey.KEY_NAME);
                    String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                    if ("root-path".equals(name)) {
                        file = f26606b;
                    } else if ("files-path".equals(name)) {
                        file = context.getFilesDir();
                    } else if ("cache-path".equals(name)) {
                        file = context.getCacheDir();
                    } else if ("external-path".equals(name)) {
                        file = Environment.getExternalStorageDirectory();
                    } else if ("external-files-path".equals(name)) {
                        File[] c = m33941c(context, null);
                        if (c.length > 0) {
                            file = c[0];
                        }
                    } else if ("external-cache-path".equals(name)) {
                        File[] a = m33937a(context);
                        if (a.length > 0) {
                            file = a[0];
                        }
                    } else if (VERSION.SDK_INT >= 21 && "external-media-path".equals(name)) {
                        File[] externalMediaDirs = context.getExternalMediaDirs();
                        if (externalMediaDirs.length > 0) {
                            file = externalMediaDirs[0];
                        }
                    }
                    if (file != null) {
                        bVar.mo38006a(attributeValue, m33936a(file, attributeValue2));
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
    }

    /* renamed from: a */
    private static int m33934a(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid mode: ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private static File m33936a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    /* renamed from: a */
    private static String[] m33939a(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    /* renamed from: a */
    private static Object[] m33938a(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    /* renamed from: c */
    private static File[] m33941c(Context context, String str) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(str);
        }
        return new File[]{context.getExternalFilesDir(str)};
    }

    /* renamed from: a */
    public static File[] m33937a(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }
}
