package btmsdkobf;

import android.os.Environment;
import android.text.TextUtils;
import btmsdkobf.C0747e.C0748a;
import com.tmsdk.module.coin.TMSDKContext;

/* renamed from: btmsdkobf.ey */
public class C0834ey {
    /* renamed from: a */
    public static int m869a(C0748a aVar) {
        int a;
        if (aVar.f671c == -209) {
            return TMSDKContext.S_NOTEXIST_NEWER_DB;
        }
        if (aVar != null && aVar.f671c == -208 && !TextUtils.isEmpty(aVar.f672d) && !TextUtils.isEmpty(aVar.f673e)) {
            C0837f fVar = new C0837f(C0638c.getApplicationContext());
            StringBuilder sb = new StringBuilder();
            sb.append(C0638c.getApplicationContext().getFilesDir().getAbsolutePath());
            sb.append("/");
            fVar.mo9535b(sb.toString());
            fVar.mo9536c(aVar.f673e);
            while (true) {
                a = fVar.mo9534a(null, aVar.f672d, false, null);
                if (a != -7) {
                    break;
                }
            }
            if (a == 0) {
                return 0;
            }
        }
        return TMSDKContext.S_ERR_UNKNOWN;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bd A[SYNTHETIC, Splitter:B:29:0x00bd] */
    /* renamed from: a */
    public static btmsdkobf.C0650cj m870a(java.lang.String r8, java.lang.String r9) {
        /*
        java.lang.String r0 = "FileUtil"
        java.lang.String r1 = "loadWupObjectFromFile"
        btmsdkobf.C0848ff.m907i(r0, r1)
        boolean r1 = android.text.TextUtils.isEmpty(r8)
        r2 = 0
        if (r1 == 0) goto L_0x000f
        return r2
    L_0x000f:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r3 = "aFilePath:"
        r1.append(r3)
        r1.append(r8)
        java.lang.String r1 = r1.toString()
        btmsdkobf.C0848ff.m907i(r0, r1)
        btmsdkobf.cj r1 = new btmsdkobf.cj
        r1.m40593init()
        java.io.File r3 = new java.io.File     // Catch:{ all -> 0x00a1 }
        r3.<init>(r8)     // Catch:{ all -> 0x00a1 }
        boolean r8 = r3.exists()     // Catch:{ all -> 0x00a1 }
        if (r8 != 0) goto L_0x0034
        return r2
    L_0x0034:
        tmsdk.wup.jce.wup.UniAttribute r8 = new tmsdk.wup.jce.wup.UniAttribute     // Catch:{ all -> 0x00a1 }
        r8.m56000init()     // Catch:{ all -> 0x00a1 }
        java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x00a1 }
        r4.<init>(r3)     // Catch:{ all -> 0x00a1 }
        r5 = 4
        byte[] r5 = new byte[r5]     // Catch:{ all -> 0x009f }
        r4.read(r5)     // Catch:{ all -> 0x009f }
        btmsdkobf.C0674d.m220b(r5)     // Catch:{ all -> 0x009f }
        r4.read(r5)     // Catch:{ all -> 0x009f }
        btmsdkobf.C0674d.m220b(r5)     // Catch:{ all -> 0x009f }
        r5 = 16
        byte[] r5 = new byte[r5]     // Catch:{ all -> 0x009f }
        r4.read(r5)     // Catch:{ all -> 0x009f }
        int r6 = r4.available()     // Catch:{ all -> 0x009f }
        byte[] r6 = new byte[r6]     // Catch:{ all -> 0x009f }
        r4.read(r6)     // Catch:{ all -> 0x009f }
        byte[] r7 = btmsdkobf.C0870g.m964c(r6)     // Catch:{ all -> 0x009f }
        java.lang.String r7 = btmsdkobf.C0674d.m218a(r7)     // Catch:{ all -> 0x009f }
        java.lang.String r5 = btmsdkobf.C0674d.m218a(r5)     // Catch:{ all -> 0x009f }
        boolean r5 = r7.equals(r5)     // Catch:{ all -> 0x009f }
        if (r5 != 0) goto L_0x0075
        java.lang.String r8 = "MD5校验失败"
        btmsdkobf.C0848ff.m907i(r0, r8)     // Catch:{ all -> 0x009f }
        return r2
    L_0x0075:
        byte[] r2 = tmsdk.common.tcc.C8708b.decrypt(r6, r2)     // Catch:{ all -> 0x009f }
        if (r9 == 0) goto L_0x0084
        int r5 = r9.length()     // Catch:{ all -> 0x009f }
        if (r5 <= 0) goto L_0x0084
        r8.setEncodeName(r9)     // Catch:{ all -> 0x009f }
    L_0x0084:
        r8.decode(r2)     // Catch:{ all -> 0x009f }
        java.lang.String r9 = r3.getName()     // Catch:{ all -> 0x009f }
        java.lang.String r2 = "."
        int r2 = r9.lastIndexOf(r2)     // Catch:{ all -> 0x009f }
        if (r2 <= 0) goto L_0x0098
        r3 = 0
        java.lang.String r9 = r9.substring(r3, r2)     // Catch:{ all -> 0x009f }
    L_0x0098:
        java.lang.Object r8 = r8.getByClass(r9, r1)     // Catch:{ all -> 0x009f }
        btmsdkobf.cj r8 = (btmsdkobf.C0650cj) r8     // Catch:{ all -> 0x009f }
        goto L_0x00c1
    L_0x009f:
        r8 = move-exception
        goto L_0x00a3
    L_0x00a1:
        r8 = move-exception
        r4 = r2
    L_0x00a3:
        java.lang.StringBuilder r9 = new java.lang.StringBuilder
        r9.<init>()
        java.lang.String r2 = "e:"
        r9.append(r2)
        java.lang.String r8 = r8.toString()
        r9.append(r8)
        java.lang.String r8 = r9.toString()
        btmsdkobf.C0848ff.m907i(r0, r8)
        if (r4 == 0) goto L_0x00c0
        r4.close()     // Catch:{ all -> 0x00c0 }
    L_0x00c0:
        r8 = r1
    L_0x00c1:
        return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0834ey.m870a(java.lang.String, java.lang.String):btmsdkobf.cj");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
            if (r13 != null) goto L_0x0053;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x008c */
    /* renamed from: a */
    public static btmsdkobf.C0747e.C0748a m871a(int r10, java.lang.String r11, int r12, int r13, byte[] r14, int r15) {
        /*
        btmsdkobf.e$a r0 = new btmsdkobf.e$a
        r0.m40681init()
        r0.f673e = r11
        java.util.ArrayList r1 = new java.util.ArrayList
        r1.<init>()
        btmsdkobf.bn r2 = new btmsdkobf.bn
        r2.m40558init()
        r2.f243dn = r10
        r1.add(r2)
        r10 = 1
        if (r13 <= 0) goto L_0x0020
        r2.version = r12
        r2.f242cn = r13
        r2.f244do = r14
        goto L_0x0066
    L_0x0020:
        java.lang.String r11 = btmsdkobf.C0747e.m557a(r11, r10)
        java.io.File r12 = new java.io.File
        r12.<init>(r11)
        boolean r11 = r12.exists()
        if (r11 == 0) goto L_0x005d
        r11 = 0
        java.io.FileInputStream r13 = new java.io.FileInputStream     // Catch:{ all -> 0x0059 }
        r13.<init>(r12)     // Catch:{ all -> 0x0059 }
        r11 = 4
        byte[] r11 = new byte[r11]     // Catch:{ all -> 0x0057 }
        r13.read(r11)     // Catch:{ all -> 0x0057 }
        int r12 = btmsdkobf.C0674d.m220b(r11)     // Catch:{ all -> 0x0057 }
        r2.version = r12     // Catch:{ all -> 0x0057 }
        r13.read(r11)     // Catch:{ all -> 0x0057 }
        int r11 = btmsdkobf.C0674d.m220b(r11)     // Catch:{ all -> 0x0057 }
        r2.f242cn = r11     // Catch:{ all -> 0x0057 }
        r11 = 16
        byte[] r11 = new byte[r11]     // Catch:{ all -> 0x0057 }
        r13.read(r11)     // Catch:{ all -> 0x0057 }
        r2.f244do = r11     // Catch:{ all -> 0x0057 }
    L_0x0053:
        r13.close()     // Catch:{ all -> 0x0066 }
        goto L_0x0066
        goto L_0x005a
    L_0x0059:
        r13 = r11
    L_0x005a:
        if (r13 == 0) goto L_0x0066
        goto L_0x0053
    L_0x005d:
        r11 = 0
        r2.version = r11
        r2.f242cn = r11
        byte[] r11 = new byte[r11]
        r2.f244do = r11
    L_0x0066:
        btmsdkobf.bm r4 = new btmsdkobf.bm
        r4.m40556init()
        r4.f239dk = r1
        r4.f240dl = r10
        java.lang.Object r10 = new java.lang.Object
        r10.<init>()
        java.lang.System.currentTimeMillis()
        r3 = 108(0x6c, float:1.51E-43)
        btmsdkobf.bo r5 = new btmsdkobf.bo
        r5.m40560init()
        r6 = 0
        btmsdkobf.ey$1 r7 = new btmsdkobf.ey$1
        r7.m40768init(r0, r10)
        long r8 = (long) r15
        btmsdkobf.C0638c.m75a(r3, r4, r5, r6, r7, r8)
        monitor-enter(r10)
        r10.wait()     // Catch:{ all -> 0x008c }
    L_0x008c:
        monitor-exit(r10)     // Catch:{ all -> 0x008e }
        return r0
    L_0x008e:
        r11 = move-exception
        monitor-exit(r10)     // Catch:{ all -> 0x008e }
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0834ey.m871a(int, java.lang.String, int, int, byte[], int):btmsdkobf.e$a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a A[SYNTHETIC, Splitter:B:32:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a4 A[SYNTHETIC, Splitter:B:40:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f8 A[SYNTHETIC, Splitter:B:79:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00ff A[SYNTHETIC, Splitter:B:83:0x00ff] */
    /* renamed from: a */
    public static java.lang.String m872a(java.lang.String r10, boolean r11) {
        /*
        boolean r0 = android.text.TextUtils.isEmpty(r10)
        if (r0 == 0) goto L_0x0009
        java.lang.String r10 = ""
        return r10
    L_0x0009:
        android.content.Context r0 = btmsdkobf.C0652cl.m85D()
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.io.File r2 = r0.getFilesDir()
        java.lang.String r2 = r2.toString()
        r1.append(r2)
        java.lang.String r2 = java.io.File.separator
        r1.append(r2)
        r1.append(r10)
        java.lang.String r1 = r1.toString()
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "aPath:"
        r2.append(r3)
        r2.append(r1)
        java.lang.String r2 = r2.toString()
        java.lang.String r3 = "FileUtil"
        btmsdkobf.C0848ff.m907i(r3, r2)
        r2 = 0
        java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00f5 }
        r4.<init>(r1)     // Catch:{ all -> 0x00f5 }
        boolean r5 = r4.exists()     // Catch:{ all -> 0x00f5 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
        r6.<init>()     // Catch:{ all -> 0x00f5 }
        java.lang.String r7 = "bExists:"
        r6.append(r7)     // Catch:{ all -> 0x00f5 }
        r6.append(r5)     // Catch:{ all -> 0x00f5 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00f5 }
        btmsdkobf.C0848ff.m907i(r3, r6)     // Catch:{ all -> 0x00f5 }
        r3 = 1
        r6 = 0
        if (r5 == 0) goto L_0x00a9
        if (r11 == 0) goto L_0x00a9
        android.content.res.AssetManager r7 = r0.getAssets()     // Catch:{ all -> 0x00a1 }
        java.io.InputStream r7 = r7.open(r10, r3)     // Catch:{ all -> 0x00a1 }
        r8 = 4
        byte[] r9 = new byte[r8]     // Catch:{ all -> 0x009f }
        r7.read(r9)     // Catch:{ all -> 0x009f }
        r7.read(r9)     // Catch:{ all -> 0x009f }
        int r9 = btmsdkobf.C0674d.m220b(r9)     // Catch:{ all -> 0x009f }
        if (r7 == 0) goto L_0x007f
        r7.close()     // Catch:{ all -> 0x007e }
        goto L_0x007f
    L_0x007e:
        return r1
    L_0x007f:
        java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ all -> 0x0097 }
        r7.<init>(r4)     // Catch:{ all -> 0x0097 }
        byte[] r8 = new byte[r8]     // Catch:{ all -> 0x0095 }
        r7.read(r8)     // Catch:{ all -> 0x0095 }
        r7.read(r8)     // Catch:{ all -> 0x0095 }
        int r8 = btmsdkobf.C0674d.m220b(r8)     // Catch:{ all -> 0x0095 }
        r7.close()     // Catch:{ all -> 0x0094 }
        goto L_0x00ab
    L_0x0094:
        return r1
        goto L_0x0098
    L_0x0097:
        r7 = r2
    L_0x0098:
        if (r7 == 0) goto L_0x009e
        r7.close()     // Catch:{ all -> 0x009e }
    L_0x009e:
        return r1
        goto L_0x00a2
    L_0x00a1:
        r7 = r2
    L_0x00a2:
        if (r7 == 0) goto L_0x00a8
        r7.close()     // Catch:{ all -> 0x00a8 }
    L_0x00a8:
        return r1
    L_0x00a9:
        r8 = 0
        r9 = 0
    L_0x00ab:
        if (r11 == 0) goto L_0x00b7
        if (r5 == 0) goto L_0x00b1
        if (r9 > r8) goto L_0x00b7
    L_0x00b1:
        if (r5 != 0) goto L_0x00b4
        goto L_0x00b7
    L_0x00b4:
        r10 = r2
        r11 = r10
        goto L_0x00e5
    L_0x00b7:
        if (r5 == 0) goto L_0x00bc
        r4.delete()     // Catch:{ all -> 0x00f5 }
    L_0x00bc:
        android.content.res.Resources r11 = r0.getResources()     // Catch:{ all -> 0x00f5 }
        android.content.res.AssetManager r11 = r11.getAssets()     // Catch:{ all -> 0x00f5 }
        java.io.InputStream r10 = r11.open(r10, r3)     // Catch:{ all -> 0x00f5 }
        java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ all -> 0x00f2 }
        r11.<init>(r4)     // Catch:{ all -> 0x00f2 }
        r0 = 8192(0x2000, float:1.14794E-41)
        byte[] r0 = new byte[r0]     // Catch:{ all -> 0x00f3 }
    L_0x00d1:
        int r2 = r10.read(r0)     // Catch:{ all -> 0x00f3 }
        if (r2 <= 0) goto L_0x00db
        r11.write(r0, r6, r2)     // Catch:{ all -> 0x00f3 }
        goto L_0x00d1
    L_0x00db:
        java.nio.channels.FileChannel r0 = r11.getChannel()     // Catch:{ all -> 0x00f3 }
        r0.force(r3)     // Catch:{ all -> 0x00f3 }
        r11.flush()     // Catch:{ all -> 0x00f3 }
    L_0x00e5:
        if (r10 == 0) goto L_0x00ec
        r10.close()     // Catch:{ IOException -> 0x00eb }
        goto L_0x00ec
    L_0x00ec:
        if (r11 == 0) goto L_0x00f1
        r11.close()     // Catch:{ IOException -> 0x00f1 }
    L_0x00f1:
        return r1
    L_0x00f2:
        r11 = r2
    L_0x00f3:
        r2 = r10
        goto L_0x00f6
    L_0x00f5:
        r11 = r2
    L_0x00f6:
        if (r2 == 0) goto L_0x00fd
        r2.close()     // Catch:{ IOException -> 0x00fc }
        goto L_0x00fd
    L_0x00fd:
        if (r11 == 0) goto L_0x0102
        r11.close()     // Catch:{ IOException -> 0x0102 }
    L_0x0102:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0834ey.m872a(java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b A[SYNTHETIC, Splitter:B:21:0x004b] */
    /* renamed from: a */
    public static boolean m873a(byte[] r4, java.lang.String r5) {
        /*
        r0 = 0
        if (r4 != 0) goto L_0x0004
        return r0
    L_0x0004:
        r1 = 0
        java.io.File r2 = new java.io.File     // Catch:{ all -> 0x002e }
        r2.<init>(r5)     // Catch:{ all -> 0x002e }
        boolean r5 = r2.exists()     // Catch:{ all -> 0x002e }
        if (r5 != 0) goto L_0x001e
        java.io.File r5 = r2.getAbsoluteFile()     // Catch:{ all -> 0x002e }
        java.io.File r5 = r5.getParentFile()     // Catch:{ all -> 0x002e }
        r5.mkdirs()     // Catch:{ all -> 0x002e }
        r2.createNewFile()     // Catch:{ all -> 0x002e }
    L_0x001e:
        java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x002e }
        r5.<init>(r2, r0)     // Catch:{ all -> 0x002e }
        r5.write(r4)     // Catch:{ all -> 0x002b }
        r0 = 1
        r5.close()     // Catch:{ all -> 0x004e }
        goto L_0x004e
    L_0x002b:
        r4 = move-exception
        r1 = r5
        goto L_0x002f
    L_0x002e:
        r4 = move-exception
    L_0x002f:
        java.lang.String r5 = "FileUtil"
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
        r2.<init>()     // Catch:{ all -> 0x004f }
        java.lang.String r3 = "saveFile(): "
        r2.append(r3)     // Catch:{ all -> 0x004f }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x004f }
        r2.append(r4)     // Catch:{ all -> 0x004f }
        java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x004f }
        btmsdkobf.C0848ff.m908w(r5, r4)     // Catch:{ all -> 0x004f }
        if (r1 == 0) goto L_0x004e
        r1.close()     // Catch:{ all -> 0x004e }
    L_0x004e:
        return r0
    L_0x004f:
        r4 = move-exception
        if (r1 == 0) goto L_0x0055
        r1.close()     // Catch:{ all -> 0x0055 }
    L_0x0055:
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0834ey.m873a(byte[], java.lang.String):boolean");
    }

    /* renamed from: cL */
    public static boolean m874cL() {
        boolean z = false;
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if (externalStorageState == null) {
                return false;
            }
            z = externalStorageState.equals("mounted");
            return z;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* renamed from: j */
    public static final java.lang.String m875j(java.lang.String r2, java.lang.String r3) {
        /*
        java.lang.String r2 = android.net.Uri.decode(r2)
        if (r2 == 0) goto L_0x002a
        r0 = 63
        int r0 = r2.indexOf(r0)
        if (r0 <= 0) goto L_0x0013
        r1 = 0
        java.lang.String r2 = r2.substring(r1, r0)
    L_0x0013:
        java.lang.String r0 = "/"
        boolean r0 = r2.endsWith(r0)
        if (r0 != 0) goto L_0x002a
        r0 = 47
        int r0 = r2.lastIndexOf(r0)
        int r0 = r0 + 1
        if (r0 <= 0) goto L_0x002a
        java.lang.String r2 = r2.substring(r0)
        goto L_0x002b
    L_0x002a:
        r2 = 0
    L_0x002b:
        if (r2 != 0) goto L_0x002e
        r2 = r3
    L_0x002e:
        if (r2 != 0) goto L_0x0032
        java.lang.String r2 = "downloadfile"
    L_0x0032:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0834ey.m875j(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0038, code lost:
            if (r1 == null) goto L_0x003b;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0025 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0033 A[SYNTHETIC, Splitter:B:23:0x0033] */
    /* renamed from: z */
    public static byte[] m876z(java.lang.String r5) {
        /*
        r0 = 0
        java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x002f }
        r1.<init>(r5)     // Catch:{ all -> 0x002f }
        java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x002d }
        int r2 = r1.available()     // Catch:{ all -> 0x002d }
        r5.<init>(r2)     // Catch:{ all -> 0x002d }
        r2 = 1024(0x400, float:1.435E-42)
        byte[] r2 = new byte[r2]     // Catch:{ all -> 0x002b }
    L_0x0013:
        int r3 = r1.read(r2)     // Catch:{ all -> 0x002b }
        if (r3 < 0) goto L_0x001e
        r4 = 0
        r5.write(r2, r4, r3)     // Catch:{ all -> 0x002b }
        goto L_0x0013
    L_0x001e:
        byte[] r0 = r5.toByteArray()     // Catch:{ all -> 0x002b }
        r5.close()     // Catch:{ all -> 0x0025 }
    L_0x0025:
        r1.close()     // Catch:{ all -> 0x0029 }
        goto L_0x003b
        goto L_0x003b
        goto L_0x0031
    L_0x002d:
        r5 = r0
        goto L_0x0031
    L_0x002f:
        r5 = r0
        r1 = r5
    L_0x0031:
        if (r5 == 0) goto L_0x0038
        r5.close()     // Catch:{ all -> 0x0037 }
        goto L_0x0038
    L_0x0038:
        if (r1 == 0) goto L_0x003b
        goto L_0x0025
    L_0x003b:
        if (r0 == 0) goto L_0x003e
        goto L_0x0044
    L_0x003e:
        java.lang.String r5 = ""
        byte[] r0 = r5.getBytes()
    L_0x0044:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0834ey.m876z(java.lang.String):byte[]");
    }
}
