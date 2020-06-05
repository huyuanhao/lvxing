package com.qiyukf.nimlib.p429a.p431b.p432a;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p397b.C5290a;
import com.qiyukf.basesdk.p394b.p395a.p397b.C5298c;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.nimlib.p429a.p431b.C5649a;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p436c.p437a.C5674d;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p449f.C5713a;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* renamed from: com.qiyukf.nimlib.a.b.a.d */
public final class C5653d extends C5649a {
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b3 A[SYNTHETIC, Splitter:B:39:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c9 A[SYNTHETIC, Splitter:B:44:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e1 A[SYNTHETIC, Splitter:B:52:0x00e1] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f7 A[SYNTHETIC, Splitter:B:57:0x00f7] */
    /* renamed from: a */
    private static java.lang.String m22824a() {
        /*
        java.lang.String r0 = "prepareFile is error logpath:"
        java.lang.String r1 = "UploadLogNotifyHandler"
        com.qiyukf.nimlib.k.c.b r2 = com.qiyukf.nimlib.p488k.p491c.C5944b.TYPE_LOG
        java.lang.String r3 = "nim_sdk.log"
        java.lang.String r2 = com.qiyukf.nimlib.p488k.p491c.C5946c.m23842b(r3, r2)
        boolean r3 = android.text.TextUtils.isEmpty(r2)
        r4 = 0
        if (r3 == 0) goto L_0x0014
        return r4
    L_0x0014:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        java.lang.String r5 = "nim_sdk_"
        r3.<init>(r5)
        long r5 = java.lang.System.currentTimeMillis()
        r3.append(r5)
        java.lang.String r5 = ".log"
        r3.append(r5)
        java.lang.String r3 = r3.toString()
        com.qiyukf.nimlib.k.c.b r5 = com.qiyukf.nimlib.p488k.p491c.C5944b.TYPE_LOG
        java.lang.String r3 = com.qiyukf.nimlib.p488k.p491c.C5946c.m23834a(r3, r5)
        java.io.FileWriter r5 = new java.io.FileWriter     // Catch:{ IOException -> 0x009e, all -> 0x009a }
        r5.<init>(r3)     // Catch:{ IOException -> 0x009e, all -> 0x009a }
        java.lang.String r6 = com.qiyukf.unicorn.p501d.C6041b.m24069a()     // Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r5.write(r6)     // Catch:{ IOException -> 0x0095, all -> 0x0092 }
        java.io.FileReader r6 = new java.io.FileReader     // Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r6.<init>(r2)     // Catch:{ IOException -> 0x0095, all -> 0x0092 }
        java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0090 }
        r4.<init>(r2)     // Catch:{ IOException -> 0x0090 }
        long r7 = r4.length()     // Catch:{ IOException -> 0x0090 }
        android.content.Context r4 = com.qiyukf.nimlib.C5718b.m23009a()     // Catch:{ IOException -> 0x0090 }
        int r4 = com.qiyukf.basesdk.p412c.p417d.C5411c.m22134a(r4)     // Catch:{ IOException -> 0x0090 }
        r9 = 1
        if (r4 == r9) goto L_0x0061
        r9 = 512000(0x7d000, double:2.529616E-318)
        int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
        if (r4 <= 0) goto L_0x0061
        long r7 = r7 - r9
        r6.skip(r7)     // Catch:{ IOException -> 0x0090 }
    L_0x0061:
        r4 = 1024(0x400, float:1.435E-42)
        char[] r4 = new char[r4]     // Catch:{ IOException -> 0x0090 }
    L_0x0065:
        int r7 = r6.read(r4)     // Catch:{ IOException -> 0x0090 }
        r8 = -1
        if (r7 == r8) goto L_0x0071
        r8 = 0
        r5.write(r4, r8, r7)     // Catch:{ IOException -> 0x0090 }
        goto L_0x0065
    L_0x0071:
        r5.close()     // Catch:{ IOException -> 0x0075 }
        goto L_0x0085
    L_0x0075:
        r4 = move-exception
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>(r0)
        r5.append(r2)
        java.lang.String r5 = r5.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r1, r5, r4)
    L_0x0085:
        r6.close()     // Catch:{ IOException -> 0x0089 }
        goto L_0x00dd
    L_0x0089:
        r4 = move-exception
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>(r0)
        goto L_0x00d3
    L_0x0090:
        r4 = move-exception
        goto L_0x00a2
    L_0x0092:
        r3 = move-exception
        r6 = r4
        goto L_0x00df
    L_0x0095:
        r6 = move-exception
        r11 = r6
        r6 = r4
        r4 = r11
        goto L_0x00a2
    L_0x009a:
        r3 = move-exception
        r5 = r4
        r6 = r5
        goto L_0x00df
    L_0x009e:
        r5 = move-exception
        r6 = r4
        r4 = r5
        r5 = r6
    L_0x00a2:
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00de }
        r7.<init>(r0)     // Catch:{ all -> 0x00de }
        r7.append(r2)     // Catch:{ all -> 0x00de }
        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00de }
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r1, r7, r4)     // Catch:{ all -> 0x00de }
        if (r5 == 0) goto L_0x00c7
        r5.close()     // Catch:{ IOException -> 0x00b7 }
        goto L_0x00c7
    L_0x00b7:
        r4 = move-exception
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>(r0)
        r5.append(r2)
        java.lang.String r5 = r5.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r1, r5, r4)
    L_0x00c7:
        if (r6 == 0) goto L_0x00dd
        r6.close()     // Catch:{ IOException -> 0x00cd }
        goto L_0x00dd
    L_0x00cd:
        r4 = move-exception
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>(r0)
    L_0x00d3:
        r5.append(r2)
        java.lang.String r0 = r5.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r1, r0, r4)
    L_0x00dd:
        return r3
    L_0x00de:
        r3 = move-exception
    L_0x00df:
        if (r5 == 0) goto L_0x00f5
        r5.close()     // Catch:{ IOException -> 0x00e5 }
        goto L_0x00f5
    L_0x00e5:
        r4 = move-exception
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>(r0)
        r5.append(r2)
        java.lang.String r5 = r5.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r1, r5, r4)
    L_0x00f5:
        if (r6 == 0) goto L_0x010b
        r6.close()     // Catch:{ IOException -> 0x00fb }
        goto L_0x010b
    L_0x00fb:
        r4 = move-exception
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>(r0)
        r5.append(r2)
        java.lang.String r0 = r5.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r1, r0, r4)
    L_0x010b:
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p429a.p431b.p432a.C5653d.m22824a():java.lang.String");
    }

    /* renamed from: a */
    private static void m22825a(String str, ZipOutputStream zipOutputStream) {
        if (zipOutputStream != null) {
            File file = new File(str);
            if (file.isFile()) {
                ZipEntry zipEntry = new ZipEntry(file.getName());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                zipOutputStream.putNextEntry(zipEntry);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        zipOutputStream.closeEntry();
                        bufferedInputStream.close();
                        return;
                    }
                }
            } else {
                String[] list = file.list();
                if (list.length <= 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(File.separator);
                    zipOutputStream.putNextEntry(new ZipEntry(sb.toString()));
                    zipOutputStream.closeEntry();
                }
                for (String append : list) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(File.separator);
                    sb2.append(append);
                    m22825a(sb2.toString(), zipOutputStream);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo27842a(C5686a aVar) {
        String a = m22824a();
        if (a != null && new File(a).exists()) {
            try {
                final String a2 = C5946c.m23834a(C5406d.m22120b(), C5944b.TYPE_LOG);
                ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(a2)));
                m22825a(a, zipOutputStream);
                zipOutputStream.finish();
                zipOutputStream.close();
                new File(a).delete();
                C5290a.m21719a().mo27154a(a2, null, a2, new C5298c() {
                    /* renamed from: a */
                    public final void mo27169a() {
                    }

                    /* renamed from: a */
                    public final void mo27170a(int i) {
                    }

                    /* renamed from: a */
                    public final void mo27171a(long j, long j2) {
                    }

                    /* renamed from: a */
                    public final void mo27172a(String str) {
                        C5668c.m22861a().mo27865a((C5669a) new C5674d(str), C5713a.f18257d);
                        new File(a2).delete();
                    }
                });
            } catch (Exception e) {
                C5264a.m21621b("UploadLogNotifyHandler", "uploadLog is error", e);
            }
        }
    }
}
