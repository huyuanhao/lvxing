package com.pgl.p359a.p361b;

import android.content.Context;
import android.os.Build;
import epco.C7986n;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.pgl.a.b.e */
public class C4787e {
    /* renamed from: a */
    private static List<String> f15435a = new ArrayList();

    /* renamed from: a */
    private static File m19621a(Context context) {
        if (context == null || context.getFilesDir() == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "libso");
        if (!file.exists()) {
            C4783b.m19611a(file.getAbsolutePath());
        }
        return file;
    }

    /* renamed from: a */
    private static String m19622a(Context context, String str, File file) {
        InputStream inputStream;
        ZipFile zipFile;
        String message;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        String str2 = "/";
        String str3 = C7986n.f27122f;
        FileOutputStream fileOutputStream2 = null;
        try {
            zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(Build.CPU_ABI);
                sb.append(str2);
                sb.append(System.mapLibraryName(str));
                ZipEntry entry = zipFile.getEntry(sb.toString());
                if (entry == null) {
                    int indexOf = Build.CPU_ABI.indexOf(45);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str3);
                    String str4 = Build.CPU_ABI;
                    if (indexOf <= 0) {
                        indexOf = Build.CPU_ABI.length();
                    }
                    sb2.append(str4.substring(0, indexOf));
                    sb2.append(str2);
                    sb2.append(System.mapLibraryName(str));
                    String sb3 = sb2.toString();
                    ZipEntry entry2 = zipFile.getEntry(sb3);
                    if (entry2 == null) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Library entry not found:");
                        sb4.append(sb3);
                        message = sb4.toString();
                        C4783b.m19608a((Closeable) null);
                        C4783b.m19608a((Closeable) null);
                        C4783b.m19610a(zipFile);
                        return message;
                    }
                    entry = entry2;
                }
                file.createNewFile();
                inputStream2 = zipFile.getInputStream(entry);
            } catch (Throwable th) {
                th = th;
                inputStream = null;
                try {
                    message = th.getMessage();
                    C4783b.m19608a((Closeable) fileOutputStream2);
                    C4783b.m19608a((Closeable) inputStream);
                    C4783b.m19610a(zipFile);
                    return message;
                } catch (Throwable th2) {
                    C4783b.m19608a((Closeable) fileOutputStream2);
                    C4783b.m19608a((Closeable) inputStream);
                    C4783b.m19610a(zipFile);
                    throw th2;
                }
            }
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                inputStream = inputStream2;
                th = th4;
                message = th.getMessage();
                C4783b.m19608a((Closeable) fileOutputStream2);
                C4783b.m19608a((Closeable) inputStream);
                C4783b.m19610a(zipFile);
                return message;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        C4783b.m19609a(file.getAbsolutePath(), 493);
                        C4783b.m19608a((Closeable) fileOutputStream);
                        C4783b.m19608a((Closeable) inputStream2);
                        C4783b.m19610a(zipFile);
                        return null;
                    }
                }
            } catch (Throwable th5) {
                fileOutputStream2 = fileOutputStream;
                inputStream = inputStream2;
                th = th5;
                message = th.getMessage();
                C4783b.m19608a((Closeable) fileOutputStream2);
                C4783b.m19608a((Closeable) inputStream);
                C4783b.m19610a(zipFile);
                return message;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            zipFile = null;
            message = th.getMessage();
            C4783b.m19608a((Closeable) fileOutputStream2);
            C4783b.m19608a((Closeable) inputStream);
            C4783b.m19610a(zipFile);
            return message;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0040, code lost:
            return true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x001a */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0020 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0022 A[SYNTHETIC, Splitter:B:19:0x0022] */
    /* renamed from: a */
    public static synchronized boolean m19623a(android.content.Context r5, java.lang.String r6) {
        /*
        java.lang.Class<com.pgl.a.b.e> r0 = com.pgl.p359a.p361b.C4787e.class
        monitor-enter(r0)
        java.util.List<java.lang.String> r1 = f15435a     // Catch:{ all -> 0x0043 }
        boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x0043 }
        r2 = 1
        if (r1 == 0) goto L_0x000e
        monitor-exit(r0)
        return r2
    L_0x000e:
        r1 = 0
        java.lang.System.loadLibrary(r6)     // Catch:{ UnsatisfiedLinkError -> 0x001a, all -> 0x0018 }
        java.util.List<java.lang.String> r3 = f15435a     // Catch:{ UnsatisfiedLinkError -> 0x001a, all -> 0x0018 }
        r3.add(r6)     // Catch:{ UnsatisfiedLinkError -> 0x001a, all -> 0x0018 }
        goto L_0x003f
    L_0x0018:
        monitor-exit(r0)
        return r1
    L_0x001a:
        java.io.File r3 = m19624b(r5, r6)     // Catch:{ all -> 0x0043 }
        if (r3 != 0) goto L_0x0022
        monitor-exit(r0)
        return r1
    L_0x0022:
        boolean r4 = r3.exists()     // Catch:{ all -> 0x0043 }
        if (r4 == 0) goto L_0x002b
        r3.delete()     // Catch:{ all -> 0x0043 }
    L_0x002b:
        java.lang.String r5 = m19622a(r5, r6, r3)     // Catch:{ all -> 0x0043 }
        if (r5 == 0) goto L_0x0033
        monitor-exit(r0)
        return r1
    L_0x0033:
        java.lang.String r5 = r3.getAbsolutePath()     // Catch:{ all -> 0x0041 }
        java.lang.System.load(r5)     // Catch:{ all -> 0x0041 }
        java.util.List<java.lang.String> r5 = f15435a     // Catch:{ all -> 0x0041 }
        r5.add(r6)     // Catch:{ all -> 0x0041 }
    L_0x003f:
        monitor-exit(r0)
        return r2
    L_0x0041:
        monitor-exit(r0)
        return r1
    L_0x0043:
        r5 = move-exception
        monitor-exit(r0)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.p359a.p361b.C4787e.m19623a(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: b */
    private static File m19624b(Context context, String str) {
        String mapLibraryName = System.mapLibraryName(str);
        File a = m19621a(context);
        if (a != null) {
            return new File(a, mapLibraryName);
        }
        return null;
    }
}
