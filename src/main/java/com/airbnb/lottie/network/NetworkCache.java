package com.airbnb.lottie.network;

import android.content.Context;
import com.airbnb.lottie.L;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.airbnb.lottie.network.a */
class NetworkCache {
    /* renamed from: a */
    private final Context f1768a;
    /* renamed from: b */
    private final String f1769b;

    NetworkCache(Context context, String str) {
        this.f1768a = context.getApplicationContext();
        this.f1769b = str;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    public androidx.core.util.Pair<com.airbnb.lottie.network.FileExtension, java.io.InputStream> mo10170a() {
        /*
        r5 = this;
        r0 = 0
        java.lang.String r1 = r5.f1769b     // Catch:{ FileNotFoundException -> 0x0048 }
        java.io.File r1 = r5.m1739a(r1)     // Catch:{ FileNotFoundException -> 0x0048 }
        if (r1 != 0) goto L_0x000a
        return r0
    L_0x000a:
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{  }
        r2.<init>(r1)     // Catch:{  }
        java.lang.String r0 = r1.getAbsolutePath()
        java.lang.String r3 = ".zip"
        boolean r0 = r0.endsWith(r3)
        if (r0 == 0) goto L_0x001e
        com.airbnb.lottie.network.FileExtension r0 = com.airbnb.lottie.network.FileExtension.Zip
        goto L_0x0020
    L_0x001e:
        com.airbnb.lottie.network.FileExtension r0 = com.airbnb.lottie.network.FileExtension.Json
    L_0x0020:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "Cache hit for "
        r3.append(r4)
        java.lang.String r4 = r5.f1769b
        r3.append(r4)
        java.lang.String r4 = " at "
        r3.append(r4)
        java.lang.String r1 = r1.getAbsolutePath()
        r3.append(r1)
        java.lang.String r1 = r3.toString()
        com.airbnb.lottie.L.m1313a(r1)
        androidx.core.util.Pair r1 = new androidx.core.util.Pair
        r1.m38999init(r0, r2)
        return r1
    L_0x0048:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.network.NetworkCache.mo10170a():androidx.core.util.Pair");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public File mo10171a(InputStream inputStream, FileExtension fileExtension) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(this.f1768a.getCacheDir(), m1740a(this.f1769b, fileExtension, true));
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo10172a(FileExtension fileExtension) {
        File file = new File(this.f1768a.getCacheDir(), m1740a(this.f1769b, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        StringBuilder sb = new StringBuilder();
        sb.append("Copying temp file to real file (");
        sb.append(file2);
        sb.append(")");
        L.m1313a(sb.toString());
        if (!renameTo) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to rename cache file ");
            sb2.append(file.getAbsolutePath());
            sb2.append(" to ");
            sb2.append(file2.getAbsolutePath());
            sb2.append(".");
            L.m1314b(sb2.toString());
        }
    }

    /* renamed from: a */
    private File m1739a(String str) throws FileNotFoundException {
        File file = new File(this.f1768a.getCacheDir(), m1740a(str, FileExtension.Json, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.f1768a.getCacheDir(), m1740a(str, FileExtension.Zip, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    /* renamed from: a */
    private static String m1740a(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.extension : fileExtension.tempExtension());
        return sb.toString();
    }
}
