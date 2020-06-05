package com.bytedance.sdk.openadsdk.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.utils.al */
public class ZipUtils {
    /* renamed from: a */
    public static List<File> m12102a(String str, String str2) throws IOException {
        return m12103a(str, str2, (String) null);
    }

    /* renamed from: a */
    public static List<File> m12103a(String str, String str2, String str3) throws IOException {
        return m12101a(m12100a(str), m12100a(str2), str3);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:7:0x0022=Splitter:B:7:0x0022, B:17:0x0058=Splitter:B:17:0x0058} */
    /* renamed from: a */
    public static java.util.List<java.io.File> m12101a(java.io.File r9, java.io.File r10, java.lang.String r11) throws java.io.IOException {
        /*
        if (r9 == 0) goto L_0x009d
        if (r10 != 0) goto L_0x0006
        goto L_0x009d
    L_0x0006:
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        java.util.zip.ZipFile r1 = new java.util.zip.ZipFile
        r1.<init>(r9)
        java.util.Enumeration r9 = r1.entries()
        boolean r2 = m12107b(r11)     // Catch:{ all -> 0x0098 }
        java.lang.String r3 = " is dangerous!"
        java.lang.String r4 = "entryName: "
        java.lang.String r5 = "ZipUtils"
        java.lang.String r6 = "../"
        if (r2 == 0) goto L_0x0058
    L_0x0022:
        boolean r11 = r9.hasMoreElements()     // Catch:{ all -> 0x0098 }
        if (r11 == 0) goto L_0x0094
        java.lang.Object r11 = r9.nextElement()     // Catch:{ all -> 0x0098 }
        java.util.zip.ZipEntry r11 = (java.util.zip.ZipEntry) r11     // Catch:{ all -> 0x0098 }
        java.lang.String r2 = r11.getName()     // Catch:{ all -> 0x0098 }
        boolean r7 = r2.contains(r6)     // Catch:{ all -> 0x0098 }
        if (r7 == 0) goto L_0x004e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
        r11.<init>()     // Catch:{ all -> 0x0098 }
        r11.append(r4)     // Catch:{ all -> 0x0098 }
        r11.append(r2)     // Catch:{ all -> 0x0098 }
        r11.append(r3)     // Catch:{ all -> 0x0098 }
        java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0098 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r5, r11)     // Catch:{ all -> 0x0098 }
        goto L_0x0022
    L_0x004e:
        boolean r11 = m12105a(r10, r0, r1, r11, r2)     // Catch:{ all -> 0x0098 }
        if (r11 != 0) goto L_0x0022
        r1.close()
        return r0
    L_0x0058:
        boolean r2 = r9.hasMoreElements()     // Catch:{ all -> 0x0098 }
        if (r2 == 0) goto L_0x0094
        java.lang.Object r2 = r9.nextElement()     // Catch:{ all -> 0x0098 }
        java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2     // Catch:{ all -> 0x0098 }
        java.lang.String r7 = r2.getName()     // Catch:{ all -> 0x0098 }
        boolean r8 = r7.contains(r6)     // Catch:{ all -> 0x0098 }
        if (r8 == 0) goto L_0x0084
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
        r2.<init>()     // Catch:{ all -> 0x0098 }
        r2.append(r4)     // Catch:{ all -> 0x0098 }
        r2.append(r7)     // Catch:{ all -> 0x0098 }
        r2.append(r3)     // Catch:{ all -> 0x0098 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0098 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r5, r2)     // Catch:{ all -> 0x0098 }
        goto L_0x0058
    L_0x0084:
        boolean r8 = r7.contains(r11)     // Catch:{ all -> 0x0098 }
        if (r8 == 0) goto L_0x0058
        boolean r2 = m12105a(r10, r0, r1, r2, r7)     // Catch:{ all -> 0x0098 }
        if (r2 != 0) goto L_0x0058
        r1.close()
        return r0
    L_0x0094:
        r1.close()
        return r0
    L_0x0098:
        r9 = move-exception
        r1.close()
        throw r9
    L_0x009d:
        r9 = 0
        return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.ZipUtils.m12101a(java.io.File, java.io.File, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0062  */
    /* renamed from: a */
    private static boolean m12105a(java.io.File r2, java.util.List<java.io.File> r3, java.util.zip.ZipFile r4, java.util.zip.ZipEntry r5, java.lang.String r6) throws java.io.IOException {
        /*
        java.io.File r0 = new java.io.File
        r0.<init>(r2, r6)
        r3.add(r0)
        boolean r2 = r5.isDirectory()
        if (r2 == 0) goto L_0x0013
        boolean r2 = m12104a(r0)
        return r2
    L_0x0013:
        boolean r2 = m12106b(r0)
        r3 = 0
        if (r2 != 0) goto L_0x001b
        return r3
    L_0x001b:
        r2 = 0
        java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x0053 }
        r6.<init>(r0)     // Catch:{ all -> 0x0053 }
        java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0050 }
        java.io.InputStream r4 = r4.getInputStream(r5)     // Catch:{ all -> 0x0050 }
        r0.<init>(r4)     // Catch:{ all -> 0x0050 }
        java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x004c }
        r4.<init>(r6)     // Catch:{ all -> 0x004c }
        r2 = 8192(0x2000, float:1.14794E-41)
        byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0049 }
    L_0x0033:
        int r5 = r0.read(r2)     // Catch:{ all -> 0x0049 }
        r1 = -1
        if (r5 == r1) goto L_0x003e
        r4.write(r2, r3, r5)     // Catch:{ all -> 0x0049 }
        goto L_0x0033
    L_0x003e:
        r0.close()
        r4.close()
        r6.close()
        r2 = 1
        return r2
    L_0x0049:
        r2 = move-exception
        r3 = r2
        goto L_0x004e
    L_0x004c:
        r3 = move-exception
        r4 = r2
    L_0x004e:
        r2 = r0
        goto L_0x0056
    L_0x0050:
        r3 = move-exception
        r4 = r2
        goto L_0x0056
    L_0x0053:
        r3 = move-exception
        r4 = r2
        r6 = r4
    L_0x0056:
        if (r2 == 0) goto L_0x005b
        r2.close()
    L_0x005b:
        if (r4 == 0) goto L_0x0060
        r4.close()
    L_0x0060:
        if (r6 == 0) goto L_0x0065
        r6.close()
    L_0x0065:
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.ZipUtils.m12105a(java.io.File, java.util.List, java.util.zip.ZipFile, java.util.zip.ZipEntry, java.lang.String):boolean");
    }

    /* renamed from: a */
    private static boolean m12104a(File file) {
        return file != null && (!file.exists() ? file.mkdirs() : file.isDirectory());
    }

    /* renamed from: b */
    private static boolean m12106b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!m12104a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static File m12100a(String str) {
        if (m12107b(str)) {
            return null;
        }
        return new File(str);
    }

    /* renamed from: b */
    private static boolean m12107b(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
