package p706pl.droidsonroids.gif;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import epco.C7986n;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: pl.droidsonroids.gif.j */
class ReLinker {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final String f29294a = System.mapLibraryName("pl_droidsonroids_gif");

    private ReLinker() {
    }

    /* renamed from: a */
    static void m37450a(Context context) {
        synchronized (ReLinker.class) {
            System.load(m37454b(context).getAbsolutePath());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            m37451a((java.io.Closeable) r2);
            m37451a((java.io.Closeable) r5);
            m37455b(r1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0090 A[Catch:{ IOException -> 0x007c, all -> 0x0078, all -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c5 A[SYNTHETIC, Splitter:B:51:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0091 A[SYNTHETIC] */
    /* renamed from: b */
    private static java.io.File m37454b(android.content.Context r8) {
        /*
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = f29294a
        r0.append(r1)
        java.lang.String r1 = "1.2.6"
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.io.File r1 = new java.io.File
        r2 = 0
        java.lang.String r3 = "lib"
        java.io.File r3 = r8.getDir(r3, r2)
        r1.<init>(r3, r0)
        boolean r3 = r1.isFile()
        if (r3 == 0) goto L_0x0026
        return r1
    L_0x0026:
        java.io.File r3 = new java.io.File
        java.io.File r4 = r8.getCacheDir()
        r3.<init>(r4, r0)
        boolean r0 = r3.isFile()
        if (r0 == 0) goto L_0x0036
        return r3
    L_0x0036:
        java.lang.String r0 = "pl_droidsonroids_gif_surface"
        java.lang.String r0 = java.lang.System.mapLibraryName(r0)
        pl.droidsonroids.gif.j$1 r4 = new pl.droidsonroids.gif.j$1
        r4.m55834init(r0)
        m37452a(r1, r4)
        m37452a(r3, r4)
        android.content.pm.ApplicationInfo r8 = r8.getApplicationInfo()
        java.io.File r0 = new java.io.File
        java.lang.String r8 = r8.sourceDir
        r0.<init>(r8)
        r8 = 0
        java.util.zip.ZipFile r0 = m37449a(r0)     // Catch:{ all -> 0x00bf }
    L_0x0057:
        int r4 = r2 + 1
        r5 = 5
        if (r2 >= r5) goto L_0x00b9
        java.util.zip.ZipEntry r2 = m37447a(r0)     // Catch:{ all -> 0x00b7 }
        if (r2 == 0) goto L_0x0099
        java.io.InputStream r2 = r0.getInputStream(r2)     // Catch:{ IOException -> 0x008b, all -> 0x0082 }
        java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0080, all -> 0x007e }
        r5.<init>(r1)     // Catch:{ IOException -> 0x0080, all -> 0x007e }
        m37453a(r2, r5)     // Catch:{ IOException -> 0x007c, all -> 0x0078 }
        m37451a(r2)     // Catch:{ all -> 0x00b7 }
        m37451a(r5)     // Catch:{ all -> 0x00b7 }
        m37455b(r1)     // Catch:{ all -> 0x00b7 }
        goto L_0x00b9
    L_0x0078:
        r8 = move-exception
        r1 = r8
        r8 = r5
        goto L_0x0084
        goto L_0x008d
    L_0x007e:
        r1 = move-exception
        goto L_0x0084
    L_0x0080:
        r5 = r8
        goto L_0x008d
    L_0x0082:
        r1 = move-exception
        r2 = r8
    L_0x0084:
        m37451a(r2)     // Catch:{ all -> 0x00b7 }
        m37451a(r8)     // Catch:{ all -> 0x00b7 }
        throw r1     // Catch:{ all -> 0x00b7 }
    L_0x008b:
        r2 = r8
        r5 = r2
    L_0x008d:
        r6 = 2
        if (r4 <= r6) goto L_0x0091
        r1 = r3
    L_0x0091:
        m37451a(r2)     // Catch:{ all -> 0x00b7 }
        m37451a(r5)     // Catch:{ all -> 0x00b7 }
        r2 = r4
        goto L_0x0057
    L_0x0099:
        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00b7 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
        r1.<init>()     // Catch:{ all -> 0x00b7 }
        java.lang.String r2 = "Library "
        r1.append(r2)     // Catch:{ all -> 0x00b7 }
        java.lang.String r2 = f29294a     // Catch:{ all -> 0x00b7 }
        r1.append(r2)     // Catch:{ all -> 0x00b7 }
        java.lang.String r2 = " for supported ABIs not found in APK file"
        r1.append(r2)     // Catch:{ all -> 0x00b7 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b7 }
        r8.<init>(r1)     // Catch:{ all -> 0x00b7 }
        throw r8     // Catch:{ all -> 0x00b7 }
    L_0x00b7:
        r8 = move-exception
        goto L_0x00c3
    L_0x00b9:
        if (r0 == 0) goto L_0x00be
        r0.close()     // Catch:{ IOException -> 0x00be }
    L_0x00be:
        return r1
    L_0x00bf:
        r0 = move-exception
        r7 = r0
        r0 = r8
        r8 = r7
    L_0x00c3:
        if (r0 == 0) goto L_0x00c8
        r0.close()     // Catch:{ IOException -> 0x00c8 }
    L_0x00c8:
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p706pl.droidsonroids.gif.ReLinker.m37454b(android.content.Context):java.io.File");
    }

    /* renamed from: a */
    private static ZipEntry m37447a(ZipFile zipFile) {
        for (String a : m37456b()) {
            ZipEntry a2 = m37448a(zipFile, a);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static String[] m37456b() {
        if (VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    /* renamed from: a */
    private static ZipEntry m37448a(ZipFile zipFile, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(C7986n.f27122f);
        sb.append(str);
        sb.append("/");
        sb.append(f29294a);
        return zipFile.getEntry(sb.toString());
    }

    /* renamed from: a */
    private static ZipFile m37449a(File file) {
        ZipFile zipFile;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 5) {
                zipFile = null;
                break;
            }
            try {
                zipFile = new ZipFile(file, 1);
                break;
            } catch (IOException unused) {
                i = i2;
            }
        }
        if (zipFile != null) {
            return zipFile;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not open APK file: ");
        sb.append(file.getAbsolutePath());
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    private static void m37452a(File file, FilenameFilter filenameFilter) {
        File[] listFiles = file.getParentFile().listFiles(filenameFilter);
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }

    /* renamed from: b */
    private static void m37455b(File file) {
        file.setReadable(true, false);
        file.setExecutable(true, false);
        file.setWritable(true);
    }

    /* renamed from: a */
    private static void m37453a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static void m37451a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
