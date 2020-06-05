package com.p530ss.android.socialbase.appdownloader.p554e.p555a;

import android.content.pm.PackageInfo;
import com.tencent.p605ep.commonbase.software.AppEntity;
import epco.C7986n;
import java.io.File;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.ss.android.socialbase.appdownloader.e.a.e */
public class PackageInfoUtils {
    /* renamed from: a */
    private static String m26808a(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    /* renamed from: a */
    public static PackageInfo m26807a(File file) {
        int b;
        long j;
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration entries = zipFile.entries();
            String str = null;
            ZipEntry zipEntry = null;
            while (true) {
                boolean hasMoreElements = entries.hasMoreElements();
                String str2 = C7986n.f27118b;
                if (!hasMoreElements) {
                    break;
                }
                zipEntry = (ZipEntry) entries.nextElement();
                if (!zipEntry.isDirectory()) {
                    if (str2.equals(zipEntry.getName())) {
                        break;
                    }
                }
            }
            if (zipEntry == null || !str2.equals(zipEntry.getName())) {
                throw new CustomGetPackageInfoFailedException("没有找到AndroidManifest.xml entry");
            }
            AXmlResourceParser aVar = new AXmlResourceParser();
            aVar.mo31511a(zipFile.getInputStream(zipEntry));
            do {
                b = aVar.mo31512b();
                if (b == 1) {
                    throw new CustomGetPackageInfoFailedException("已达到END_DOCUMENT");
                }
            } while (b != 2);
            int e = aVar.mo31518e();
            String str3 = null;
            String str4 = null;
            for (int i = 0; i != e; i++) {
                if ("versionName".equals(aVar.mo31509a(i))) {
                    str3 = m26809a(aVar, i);
                } else if (AppEntity.KEY_VERSION_CODE_INT.equals(aVar.mo31509a(i))) {
                    str = m26809a(aVar, i);
                } else if ("package".equals(aVar.mo31509a(i))) {
                    str4 = m26809a(aVar, i);
                }
            }
            try {
                j = Long.parseLong(str);
            } catch (CustomGetPackageInfoFailedException unused) {
                j = -1;
            }
            if (j != -1) {
                PackageInfo packageInfo = new PackageInfo();
                packageInfo.versionName = str3;
                packageInfo.versionCode = (int) j;
                packageInfo.packageName = str4;
                return packageInfo;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("versionCode获取失败: ");
            sb.append(str);
            throw new CustomGetPackageInfoFailedException(sb.toString());
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("throwable: ");
            sb2.append(th.getMessage());
            sb2.append(th.toString());
            throw new CustomGetPackageInfoFailedException(sb2.toString());
        }
    }

    /* renamed from: a */
    private static String m26809a(AXmlResourceParser aVar, int i) {
        int b = aVar.mo31513b(i);
        int c = aVar.mo31515c(i);
        if (b == 3) {
            return aVar.mo31517d(i);
        }
        if (b == 2) {
            return String.format("?%s%08X", new Object[]{m26808a(c), Integer.valueOf(c)});
        } else if (b >= 16 && b <= 31) {
            return String.valueOf(c);
        } else {
            return String.format("<0x%X, type 0x%02X>", new Object[]{Integer.valueOf(c), Integer.valueOf(b)});
        }
    }
}
