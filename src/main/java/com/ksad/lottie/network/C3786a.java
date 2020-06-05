package com.ksad.lottie.network;

import android.content.Context;
import com.ksad.lottie.C3665c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* renamed from: com.ksad.lottie.network.a */
class C3786a {
    /* renamed from: a */
    private final Context f12905a;
    /* renamed from: b */
    private final String f12906b;

    C3786a(Context context, String str) {
        this.f12905a = context.getApplicationContext();
        this.f12906b = str;
    }

    /* renamed from: a */
    private File m15710a(String str) {
        File file = new File(this.f12905a.getCacheDir(), m15711a(str, FileExtension.Json, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.f12905a.getCacheDir(), m15711a(str, FileExtension.Zip, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    /* renamed from: a */
    private static String m15711a(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.extension : fileExtension.tempExtension());
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    public androidx.core.util.Pair<com.ksad.lottie.network.FileExtension, java.io.InputStream> mo23178a() {
        /*
        r5 = this;
        r0 = 0
        java.lang.String r1 = r5.f12906b     // Catch:{ FileNotFoundException -> 0x0048 }
        java.io.File r1 = r5.m15710a(r1)     // Catch:{ FileNotFoundException -> 0x0048 }
        if (r1 != 0) goto L_0x000a
        return r0
    L_0x000a:
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{  }
        r2.<init>(r1)     // Catch:{  }
        java.lang.String r0 = r1.getAbsolutePath()
        java.lang.String r3 = ".zip"
        boolean r0 = r0.endsWith(r3)
        if (r0 == 0) goto L_0x001e
        com.ksad.lottie.network.FileExtension r0 = com.ksad.lottie.network.FileExtension.Zip
        goto L_0x0020
    L_0x001e:
        com.ksad.lottie.network.FileExtension r0 = com.ksad.lottie.network.FileExtension.Json
    L_0x0020:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "Cache hit for "
        r3.append(r4)
        java.lang.String r4 = r5.f12906b
        r3.append(r4)
        java.lang.String r4 = " at "
        r3.append(r4)
        java.lang.String r1 = r1.getAbsolutePath()
        r3.append(r1)
        java.lang.String r1 = r3.toString()
        com.ksad.lottie.C3665c.m15250a(r1)
        androidx.core.util.Pair r1 = new androidx.core.util.Pair
        r1.m38999init(r0, r2)
        return r1
    L_0x0048:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ksad.lottie.network.C3786a.mo23178a():androidx.core.util.Pair");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public File mo23179a(InputStream inputStream, FileExtension fileExtension) {
        FileOutputStream fileOutputStream;
        File file = new File(this.f12905a.getCacheDir(), m15711a(this.f12906b, fileExtension, true));
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
    public void mo23180a(FileExtension fileExtension) {
        File file = new File(this.f12905a.getCacheDir(), m15711a(this.f12906b, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        StringBuilder sb = new StringBuilder();
        sb.append("Copying temp file to real file (");
        sb.append(file2);
        sb.append(")");
        C3665c.m15250a(sb.toString());
        if (!renameTo) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to rename cache file ");
            sb2.append(file.getAbsolutePath());
            sb2.append(" to ");
            sb2.append(file2.getAbsolutePath());
            sb2.append(".");
            C3665c.m15251b(sb2.toString());
        }
    }
}
