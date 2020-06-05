package com.tencent.p605ep.commonbase.network;

import android.content.Context;
import android.os.Environment;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.ep.commonbase.network.HttpGetFile */
public class HttpGetFile extends HttpBase {
    private boolean isContinue = false;
    private long mCompletedSize = 0;
    private Context mContext;
    private int mFileMode = 0;
    private boolean mIsCanceled = false;
    private String mSaveName = null;
    private String mSavePath;
    private String mTempName = null;
    private String mTempPath;
    private long mTotalSize = 0;

    /* renamed from: com.tencent.ep.commonbase.network.HttpGetFile$DataMd5Cheker */
    public interface DataMd5Cheker {
        boolean isMatch(String str);
    }

    public HttpGetFile(Context context) {
        this.mContext = context;
        this.mTempPath = context.getCacheDir().getAbsolutePath();
        this.mSavePath = context.getFilesDir().getAbsolutePath();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r9v0, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: type inference failed for: r9v4, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v9, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r9v7, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* JADX WARNING: type inference failed for: r7v16 */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r7v17 */
    /* JADX WARNING: type inference failed for: r7v18, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r9v11, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r9v12, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r7v25, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r9v14 */
    /* JADX WARNING: type inference failed for: r7v26 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r7v27 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r9v15 */
    /* JADX WARNING: type inference failed for: r7v28 */
    /* JADX WARNING: type inference failed for: r7v29 */
    /* JADX WARNING: type inference failed for: r9v16 */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v1
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x014d A[SYNTHETIC, Splitter:B:83:0x014d] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x015a A[SYNTHETIC, Splitter:B:88:0x015a] */
    /* JADX WARNING: Unknown variable types count: 17 */
    private int copyTempFile(boolean r13) {
        /*
        r12 = this;
        java.lang.String r0 = "fosclose file error"
        java.lang.String r1 = "fis close file error"
        java.lang.String r2 = "HttpBase"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = r12.mTempPath
        r3.append(r4)
        java.lang.String r4 = java.io.File.separator
        r3.append(r4)
        java.lang.String r4 = r12.mTempName
        r3.append(r4)
        java.lang.String r3 = r3.toString()
        java.lang.String r4 = "HttpGetFile"
        com.tencent.p605ep.commonbase.api.Log.m31483i(r4, r3)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r5 = r12.mSavePath
        r3.append(r5)
        java.lang.String r5 = java.io.File.separator
        r3.append(r5)
        java.lang.String r5 = r12.mSaveName
        r3.append(r5)
        java.lang.String r3 = r3.toString()
        com.tencent.p605ep.commonbase.api.Log.m31483i(r4, r3)
        r3 = -7001(0xffffffffffffe4a7, float:NaN)
        r4 = -7000(0xffffffffffffe4a8, float:NaN)
        r5 = 0
        java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x011c, Exception -> 0x0107, all -> 0x0103 }
        java.lang.String r7 = r12.mTempPath     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x011c, Exception -> 0x0107, all -> 0x0103 }
        java.lang.String r8 = r12.mTempName     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x011c, Exception -> 0x0107, all -> 0x0103 }
        r6.<init>(r7, r8)     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x011c, Exception -> 0x0107, all -> 0x0103 }
        boolean r7 = r6.exists()     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        r8 = 0
        if (r7 == 0) goto L_0x00cc
        int r7 = r12.mFileMode     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        r9 = 1
        if (r7 != r9) goto L_0x0074
        android.content.Context r7 = r12.mContext     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        java.io.File r7 = r7.getFilesDir()     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        java.lang.String r10 = r12.mSavePath     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        boolean r7 = r7.equals(r10)     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        if (r7 == 0) goto L_0x0074
        android.content.Context r7 = r12.mContext     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        java.lang.String r10 = r12.mSaveName     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        java.io.FileOutputStream r7 = r7.openFileOutput(r10, r9)     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        r9 = r7
        goto L_0x009b
    L_0x0074:
        java.io.File r7 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        java.lang.String r9 = r12.getFullPathSaveName()     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        r7.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        boolean r9 = r7.exists()     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        if (r9 == 0) goto L_0x008c
        r7.delete()     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        r9.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        goto L_0x009b
    L_0x008c:
        java.io.File r9 = r7.getParentFile()     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        r9.mkdirs()     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        r7.createNewFile()     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
        r9.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fd, Exception -> 0x00fa, all -> 0x00f7 }
    L_0x009b:
        java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00c7, IOException -> 0x00c2, Exception -> 0x00be, all -> 0x00bb }
        r7.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00c7, IOException -> 0x00c2, Exception -> 0x00be, all -> 0x00bb }
        r5 = 1024(0x400, float:1.435E-42)
        byte[] r5 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, Exception -> 0x00b5, all -> 0x00b2 }
    L_0x00a4:
        int r10 = r7.read(r5)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, Exception -> 0x00b5, all -> 0x00b2 }
        r11 = -1
        if (r10 == r11) goto L_0x00af
        r9.write(r5, r8, r10)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, Exception -> 0x00b5, all -> 0x00b2 }
        goto L_0x00a4
    L_0x00af:
        r5 = r7
        r3 = 0
        goto L_0x00cd
    L_0x00b2:
        r3 = move-exception
        goto L_0x014a
    L_0x00b5:
        r3 = move-exception
        goto L_0x00c0
    L_0x00b7:
        r3 = move-exception
        goto L_0x00c4
    L_0x00b9:
        r4 = move-exception
        goto L_0x00c9
    L_0x00bb:
        r3 = move-exception
        goto L_0x014b
    L_0x00be:
        r3 = move-exception
        r7 = r5
    L_0x00c0:
        r5 = r9
        goto L_0x010a
    L_0x00c2:
        r3 = move-exception
        r7 = r5
    L_0x00c4:
        r5 = r9
        goto L_0x011f
    L_0x00c7:
        r4 = move-exception
        r7 = r5
    L_0x00c9:
        r5 = r9
        goto L_0x0136
    L_0x00cc:
        r9 = r5
    L_0x00cd:
        if (r5 == 0) goto L_0x00dc
        r5.close()     // Catch:{ IOException -> 0x00d3 }
        goto L_0x00dc
    L_0x00d3:
        r3 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r1)
        r3.printStackTrace()
        r3 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x00dc:
        if (r9 == 0) goto L_0x00eb
        r9.close()     // Catch:{ IOException -> 0x00e2 }
        goto L_0x00eb
    L_0x00e2:
        r1 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r0)
        r1.printStackTrace()
        r3 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x00eb:
        if (r13 == 0) goto L_0x00f6
        boolean r13 = r6.exists()
        if (r13 == 0) goto L_0x00f6
        r6.delete()
    L_0x00f6:
        return r3
    L_0x00f7:
        r3 = move-exception
        r7 = r5
        goto L_0x0149
    L_0x00fa:
        r3 = move-exception
        r7 = r5
        goto L_0x010a
    L_0x00fd:
        r3 = move-exception
        r7 = r5
        goto L_0x011f
    L_0x0100:
        r4 = move-exception
        r7 = r5
        goto L_0x0136
    L_0x0103:
        r3 = move-exception
        r6 = r5
        r9 = r6
        goto L_0x014b
    L_0x0107:
        r3 = move-exception
        r6 = r5
        r7 = r6
    L_0x010a:
        java.lang.String r8 = "file op error"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r8)     // Catch:{ all -> 0x0148 }
        r3.printStackTrace()     // Catch:{ all -> 0x0148 }
        com.tencent.ep.commonbase.network.NetWorkException r8 = new com.tencent.ep.commonbase.network.NetWorkException     // Catch:{ all -> 0x0148 }
        java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0148 }
        r8.m52736init(r4, r3)     // Catch:{ all -> 0x0148 }
        throw r8     // Catch:{ all -> 0x0148 }
    L_0x011c:
        r3 = move-exception
        r6 = r5
        r7 = r6
    L_0x011f:
        r4 = -7056(0xffffffffffffe470, float:NaN)
        java.lang.String r8 = "file io error"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r8)     // Catch:{ all -> 0x0148 }
        r3.printStackTrace()     // Catch:{ all -> 0x0148 }
        com.tencent.ep.commonbase.network.NetWorkException r8 = new com.tencent.ep.commonbase.network.NetWorkException     // Catch:{ all -> 0x0148 }
        java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0148 }
        r8.m52736init(r4, r3)     // Catch:{ all -> 0x0148 }
        throw r8     // Catch:{ all -> 0x0148 }
    L_0x0133:
        r4 = move-exception
        r6 = r5
        r7 = r6
    L_0x0136:
        java.lang.String r8 = "file not found"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r8)     // Catch:{ all -> 0x0148 }
        r4.printStackTrace()     // Catch:{ all -> 0x0148 }
        com.tencent.ep.commonbase.network.NetWorkException r8 = new com.tencent.ep.commonbase.network.NetWorkException     // Catch:{ all -> 0x0148 }
        java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0148 }
        r8.m52736init(r3, r4)     // Catch:{ all -> 0x0148 }
        throw r8     // Catch:{ all -> 0x0148 }
    L_0x0148:
        r3 = move-exception
    L_0x0149:
        r9 = r5
    L_0x014a:
        r5 = r7
    L_0x014b:
        if (r5 == 0) goto L_0x0158
        r5.close()     // Catch:{ IOException -> 0x0151 }
        goto L_0x0158
    L_0x0151:
        r4 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r1)
        r4.printStackTrace()
    L_0x0158:
        if (r9 == 0) goto L_0x0165
        r9.close()     // Catch:{ IOException -> 0x015e }
        goto L_0x0165
    L_0x015e:
        r1 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r0)
        r1.printStackTrace()
    L_0x0165:
        if (r13 == 0) goto L_0x0172
        if (r6 == 0) goto L_0x0172
        boolean r13 = r6.exists()
        if (r13 == 0) goto L_0x0172
        r6.delete()
    L_0x0172:
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.network.HttpGetFile.copyTempFile(boolean):int");
    }

    public static File getExternalStorageDirectory() {
        try {
            return Environment.getExternalStorageDirectory();
        } catch (Throwable th) {
            th.printStackTrace();
            return new File("/sdcard");
        }
    }

    private boolean isRedirect(int i) {
        return i >= 301 && i <= 305;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v1, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r3v16, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r17v0 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: type inference failed for: r8v23, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r8v24 */
    /* JADX WARNING: type inference failed for: r17v2 */
    /* JADX WARNING: type inference failed for: r8v25 */
    /* JADX WARNING: type inference failed for: r17v3 */
    /* JADX WARNING: type inference failed for: r8v26 */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r8v27 */
    /* JADX WARNING: type inference failed for: r17v5 */
    /* JADX WARNING: type inference failed for: r8v28 */
    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r8v29 */
    /* JADX WARNING: type inference failed for: r3v25 */
    /* JADX WARNING: type inference failed for: r8v30 */
    /* JADX WARNING: type inference failed for: r8v31 */
    /* JADX WARNING: type inference failed for: r8v32 */
    /* JADX WARNING: type inference failed for: r8v33 */
    /* JADX WARNING: type inference failed for: r8v34 */
    /* JADX WARNING: type inference failed for: r8v35 */
    /* JADX WARNING: type inference failed for: r3v27 */
    /* JADX WARNING: type inference failed for: r8v36 */
    /* JADX WARNING: type inference failed for: r8v37 */
    /* JADX WARNING: type inference failed for: r8v38 */
    /* JADX WARNING: type inference failed for: r8v39 */
    /* JADX WARNING: type inference failed for: r8v40 */
    /* JADX WARNING: type inference failed for: r8v41 */
    /* JADX WARNING: type inference failed for: r8v42 */
    /* JADX WARNING: type inference failed for: r8v43 */
    /* JADX WARNING: type inference failed for: r17v7 */
    /* JADX WARNING: type inference failed for: r17v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x022f, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
            r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0236, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0237, code lost:
            r3 = r0;
            com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r4);
            r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0240, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r7, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
            r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0247, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0248, code lost:
            r3 = r0;
            com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r8);
            r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ca, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00cb, code lost:
            r16 = r15;
            r8 = r17;
            r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d3, code lost:
            r17 = r3;
            r18 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d8, code lost:
            r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
            r11.flush();
            r0 = new java.lang.StringBuilder();
            r0.append("mTotalSize: ");
            r0.append(r1.mTotalSize);
            r0.append(", mCompletedSize: ");
            r0.append(r1.mCompletedSize);
            r0.append(", httpEntity.getContentLength(): ");
            r0.append(r2);
            com.tencent.p605ep.commonbase.api.Log.m31483i(r7, r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0103, code lost:
            if (r9 != r2) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0105, code lost:
            r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0107, code lost:
            r14 = -7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010a, code lost:
            if (r15 == null) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x010c, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0113, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0114, code lost:
            r3 = r0;
            com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r18);
            r3.printStackTrace();
            r14 = -7000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0139, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x013a, code lost:
            r8 = r17;
            r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013f, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0140, code lost:
            r8 = r17;
            r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0145, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0146, code lost:
            r8 = r17;
            r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x014b, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x014c, code lost:
            r8 = r17;
            r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0151, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0152, code lost:
            r8 = r17;
            r4 = r18;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v3
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0139 A[ExcHandler: Exception (e java.lang.Exception), PHI: r17 r18 
  PHI: (r17v5 ?) = (r17v0 ?), (r17v7 ?), (r17v8 ?) binds: {(r17v0 ?)=B:58:?, (r17v7 ?)=B:57:0x00d8, (r17v8 ?)=B:48:0x00a6} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r18v5 java.lang.String) = (r18v0 java.lang.String), (r18v0 java.lang.String), (r18v6 java.lang.String) binds: {(r18v0 java.lang.String)=B:57:0x00d8, (r18v0 java.lang.String)=B:58:?, (r18v6 java.lang.String)=B:48:0x00a6} A[DONT_GENERATE, DONT_INLINE], Splitter:B:48:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x013f A[ExcHandler: IOException (e java.io.IOException), PHI: r17 r18 
  PHI: (r17v4 ?) = (r17v0 ?), (r17v0 ?), (r17v6 ?) binds: {(r17v0 ?)=B:57:0x00d8, (r17v0 ?)=B:58:?, (r17v6 ?)=B:48:0x00a6} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r18v4 java.lang.String) = (r18v0 java.lang.String), (r18v0 java.lang.String), (r18v6 java.lang.String) binds: {(r18v0 java.lang.String)=B:57:0x00d8, (r18v0 java.lang.String)=B:58:?, (r18v6 java.lang.String)=B:48:0x00a6} A[DONT_GENERATE, DONT_INLINE], Splitter:B:48:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0145 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), PHI: r17 r18 
  PHI: (r17v3 ?) = (r17v0 ?), (r17v0 ?), (r17v6 ?) binds: {(r17v0 ?)=B:57:0x00d8, (r17v0 ?)=B:58:?, (r17v6 ?)=B:48:0x00a6} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r18v3 java.lang.String) = (r18v0 java.lang.String), (r18v0 java.lang.String), (r18v6 java.lang.String) binds: {(r18v0 java.lang.String)=B:57:0x00d8, (r18v0 java.lang.String)=B:58:?, (r18v6 java.lang.String)=B:48:0x00a6} A[DONT_GENERATE, DONT_INLINE], Splitter:B:48:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x014b A[ExcHandler: SocketException (e java.net.SocketException), PHI: r17 r18 
  PHI: (r17v2 ?) = (r17v0 ?), (r17v0 ?), (r17v6 ?) binds: {(r17v0 ?)=B:57:0x00d8, (r17v0 ?)=B:58:?, (r17v6 ?)=B:48:0x00a6} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r18v2 java.lang.String) = (r18v0 java.lang.String), (r18v0 java.lang.String), (r18v6 java.lang.String) binds: {(r18v0 java.lang.String)=B:57:0x00d8, (r18v0 java.lang.String)=B:58:?, (r18v6 java.lang.String)=B:48:0x00a6} A[DONT_GENERATE, DONT_INLINE], Splitter:B:48:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0151 A[ExcHandler: FileNotFoundException (e java.io.FileNotFoundException), PHI: r17 r18 
  PHI: (r17v1 ?) = (r17v0 ?), (r17v0 ?), (r17v6 ?) binds: {(r17v0 ?)=B:57:0x00d8, (r17v0 ?)=B:58:?, (r17v6 ?)=B:48:0x00a6} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r18v1 java.lang.String) = (r18v0 java.lang.String), (r18v0 java.lang.String), (r18v6 java.lang.String) binds: {(r18v0 java.lang.String)=B:57:0x00d8, (r18v0 java.lang.String)=B:58:?, (r18v6 java.lang.String)=B:48:0x00a6} A[DONT_GENERATE, DONT_INLINE], Splitter:B:48:0x00a6] */
    /* JADX WARNING: Unknown variable types count: 36 */
    private int writeTempFile(java.io.InputStream r20, android.os.Bundle r21, boolean r22, int r23) {
        /*
        r19 = this;
        r1 = r19
        r0 = r21
        r2 = r23
        java.lang.String r3 = "fos close file error"
        java.lang.String r4 = "is close file error"
        java.lang.String r5 = "fos closing file"
        java.lang.String r6 = "is closing file"
        java.lang.String r7 = "HttpBase"
        r8 = 8192(0x2000, float:1.14794E-41)
        byte[] r8 = new byte[r8]
        long r9 = (long) r2
        long r12 = r1.mCompletedSize     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        long r9 = r9 + r12
        r1.mTotalSize = r9     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        long r9 = r1.mCompletedSize     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        r12 = 100
        long r9 = r9 * r12
        long r14 = r1.mTotalSize     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        long r9 = r9 / r14
        int r10 = (int) r9     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        r9 = 100
        r14 = 0
        if (r10 != r9) goto L_0x002a
        return r14
    L_0x002a:
        java.io.File r9 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        java.lang.String r15 = r1.mTempPath     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        java.lang.String r11 = r1.mTempName     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        r9.<init>(r15, r11)     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        boolean r11 = r9.exists()     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        if (r11 != 0) goto L_0x0043
        java.io.File r11 = r9.getParentFile()     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        r11.mkdirs()     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        r9.createNewFile()     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
    L_0x0043:
        java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        r15 = 1
        r11.<init>(r9, r15)     // Catch:{ FileNotFoundException -> 0x0213, SocketException -> 0x01e5, SocketTimeoutException -> 0x01b9, IOException -> 0x01a0, Exception -> 0x0180, all -> 0x0178 }
        if (r22 == 0) goto L_0x006d
        java.util.zip.InflaterInputStream r9 = new java.util.zip.InflaterInputStream     // Catch:{ FileNotFoundException -> 0x0069, SocketException -> 0x0065, SocketTimeoutException -> 0x0061, IOException -> 0x005d, Exception -> 0x0059, all -> 0x0054 }
        r15 = r20
        r9.<init>(r15)     // Catch:{ FileNotFoundException -> 0x0069, SocketException -> 0x0065, SocketTimeoutException -> 0x0061, IOException -> 0x005d, Exception -> 0x0059, all -> 0x0054 }
        r15 = r9
        goto L_0x006f
    L_0x0054:
        r0 = move-exception
        r2 = r0
        r8 = r3
        goto L_0x017c
    L_0x0059:
        r0 = move-exception
        r8 = r3
        goto L_0x0183
    L_0x005d:
        r0 = move-exception
        r8 = r3
        goto L_0x01a3
    L_0x0061:
        r0 = move-exception
        r8 = r3
        goto L_0x01bc
    L_0x0065:
        r0 = move-exception
        r8 = r3
        goto L_0x01e8
    L_0x0069:
        r0 = move-exception
        r8 = r3
        goto L_0x0216
    L_0x006d:
        r15 = r20
    L_0x006f:
        r9 = 0
    L_0x0070:
        int r14 = r15.read(r8)     // Catch:{ FileNotFoundException -> 0x0172, SocketException -> 0x016c, SocketTimeoutException -> 0x0167, IOException -> 0x0162, Exception -> 0x015d, all -> 0x0157 }
        r12 = -1
        if (r14 == r12) goto L_0x00d3
        boolean r12 = r1.mIsCanceled     // Catch:{ FileNotFoundException -> 0x0172, SocketException -> 0x016c, SocketTimeoutException -> 0x0167, IOException -> 0x0162, Exception -> 0x015d, all -> 0x0157 }
        if (r12 == 0) goto L_0x009e
        r2 = -5003(0xffffffffffffec75, float:NaN)
        if (r15 == 0) goto L_0x008e
        com.tencent.p605ep.commonbase.api.Log.m31483i(r7, r6)
        r15.close()     // Catch:{ IOException -> 0x0086 }
        goto L_0x008e
    L_0x0086:
        r0 = move-exception
        r6 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r4)
        r6.printStackTrace()
    L_0x008e:
        com.tencent.p605ep.commonbase.api.Log.m31483i(r7, r5)
        r11.close()     // Catch:{ IOException -> 0x0095 }
        goto L_0x009d
    L_0x0095:
        r0 = move-exception
        r4 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r3)
        r4.printStackTrace()
    L_0x009d:
        return r2
    L_0x009e:
        long r12 = r1.mCompletedSize     // Catch:{ FileNotFoundException -> 0x0172, SocketException -> 0x016c, SocketTimeoutException -> 0x0167, IOException -> 0x0162, Exception -> 0x015d, all -> 0x0157 }
        r17 = r3
        r18 = r4
        long r3 = (long) r14
        long r12 = r12 + r3
        r1.mCompletedSize = r12     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x00ca }
        int r9 = r9 + r14
        long r3 = r1.mCompletedSize     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x00ca }
        r12 = 100
        long r3 = r3 * r12
        long r12 = r1.mTotalSize     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x00ca }
        long r3 = r3 / r12
        int r4 = (int) r3     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x00ca }
        if (r4 == r10) goto L_0x00bf
        java.lang.String r3 = "key_progress"
        r0.putInt(r3, r4)     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x00ca }
        r3 = 2
        r1.doCallback(r3, r0)     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x00ca }
        r10 = r4
    L_0x00bf:
        r3 = 0
        r11.write(r8, r3, r14)     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x00ca }
        r3 = r17
        r4 = r18
        r12 = 100
        goto L_0x0070
    L_0x00ca:
        r0 = move-exception
        r16 = r15
        r8 = r17
        r4 = r18
        goto L_0x022c
    L_0x00d3:
        r17 = r3
        r18 = r4
        r3 = 0
        r11.flush()     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        r0.<init>()     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        java.lang.String r4 = "mTotalSize: "
        r0.append(r4)     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        long r12 = r1.mTotalSize     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        r0.append(r12)     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        java.lang.String r4 = ", mCompletedSize: "
        r0.append(r4)     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        long r12 = r1.mCompletedSize     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        r0.append(r12)     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        java.lang.String r4 = ", httpEntity.getContentLength(): "
        r0.append(r4)     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        r0.append(r2)     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        java.lang.String r0 = r0.toString()     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r7, r0)     // Catch:{ FileNotFoundException -> 0x0151, SocketException -> 0x014b, SocketTimeoutException -> 0x0145, IOException -> 0x013f, Exception -> 0x0139, all -> 0x0133 }
        if (r9 != r2) goto L_0x0107
        r14 = 0
        goto L_0x0108
    L_0x0107:
        r14 = -7
    L_0x0108:
        r2 = -7000(0xffffffffffffe4a8, float:NaN)
        if (r15 == 0) goto L_0x011f
        com.tencent.p605ep.commonbase.api.Log.m31483i(r7, r6)
        r15.close()     // Catch:{ IOException -> 0x0113 }
        goto L_0x011f
    L_0x0113:
        r0 = move-exception
        r3 = r0
        r4 = r18
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r4)
        r3.printStackTrace()
        r14 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x011f:
        com.tencent.p605ep.commonbase.api.Log.m31483i(r7, r5)
        r11.close()     // Catch:{ IOException -> 0x0126 }
        goto L_0x0132
    L_0x0126:
        r0 = move-exception
        r3 = r0
        r8 = r17
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r8)
        r3.printStackTrace()
        r14 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x0132:
        return r14
    L_0x0133:
        r0 = move-exception
        r8 = r17
        r4 = r18
        goto L_0x0159
    L_0x0139:
        r0 = move-exception
        r8 = r17
        r4 = r18
        goto L_0x015f
    L_0x013f:
        r0 = move-exception
        r8 = r17
        r4 = r18
        goto L_0x0164
    L_0x0145:
        r0 = move-exception
        r8 = r17
        r4 = r18
        goto L_0x0169
    L_0x014b:
        r0 = move-exception
        r8 = r17
        r4 = r18
        goto L_0x016e
    L_0x0151:
        r0 = move-exception
        r8 = r17
        r4 = r18
        goto L_0x0174
    L_0x0157:
        r0 = move-exception
        r8 = r3
    L_0x0159:
        r16 = r15
        goto L_0x022c
    L_0x015d:
        r0 = move-exception
        r8 = r3
    L_0x015f:
        r16 = r15
        goto L_0x0185
    L_0x0162:
        r0 = move-exception
        r8 = r3
    L_0x0164:
        r16 = r15
        goto L_0x01a5
    L_0x0167:
        r0 = move-exception
        r8 = r3
    L_0x0169:
        r16 = r15
        goto L_0x01be
    L_0x016c:
        r0 = move-exception
        r8 = r3
    L_0x016e:
        r16 = r15
        goto L_0x01ea
    L_0x0172:
        r0 = move-exception
        r8 = r3
    L_0x0174:
        r16 = r15
        goto L_0x0218
    L_0x0178:
        r0 = move-exception
        r8 = r3
        r2 = r0
        r11 = 0
    L_0x017c:
        r16 = 0
        goto L_0x022d
    L_0x0180:
        r0 = move-exception
        r8 = r3
        r11 = 0
    L_0x0183:
        r16 = 0
    L_0x0185:
        r2 = -5000(0xffffffffffffec78, float:NaN)
        java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x0211 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r3)     // Catch:{ all -> 0x0211 }
        java.lang.String r3 = "receive data error"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r3)     // Catch:{ all -> 0x0211 }
        r0.printStackTrace()     // Catch:{ all -> 0x0211 }
        com.tencent.ep.commonbase.network.NetWorkException r3 = new com.tencent.ep.commonbase.network.NetWorkException     // Catch:{ all -> 0x0211 }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0211 }
        r3.m52736init(r2, r0)     // Catch:{ all -> 0x0211 }
        throw r3     // Catch:{ all -> 0x0211 }
    L_0x01a0:
        r0 = move-exception
        r8 = r3
        r11 = 0
    L_0x01a3:
        r16 = 0
    L_0x01a5:
        r2 = -5056(0xffffffffffffec40, float:NaN)
        java.lang.String r3 = "socket or file io error"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r3)     // Catch:{ all -> 0x0211 }
        r0.printStackTrace()     // Catch:{ all -> 0x0211 }
        com.tencent.ep.commonbase.network.NetWorkException r3 = new com.tencent.ep.commonbase.network.NetWorkException     // Catch:{ all -> 0x0211 }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0211 }
        r3.m52736init(r2, r0)     // Catch:{ all -> 0x0211 }
        throw r3     // Catch:{ all -> 0x0211 }
    L_0x01b9:
        r0 = move-exception
        r8 = r3
        r11 = 0
    L_0x01bc:
        r16 = 0
    L_0x01be:
        r2 = -5055(0xffffffffffffec41, float:NaN)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0211 }
        r3.<init>()     // Catch:{ all -> 0x0211 }
        java.lang.String r9 = "socket timeout error:"
        r3.append(r9)     // Catch:{ all -> 0x0211 }
        java.lang.String r9 = r0.getMessage()     // Catch:{ all -> 0x0211 }
        r3.append(r9)     // Catch:{ all -> 0x0211 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0211 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r3)     // Catch:{ all -> 0x0211 }
        r0.printStackTrace()     // Catch:{ all -> 0x0211 }
        com.tencent.ep.commonbase.network.NetWorkException r3 = new com.tencent.ep.commonbase.network.NetWorkException     // Catch:{ all -> 0x0211 }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0211 }
        r3.m52736init(r2, r0)     // Catch:{ all -> 0x0211 }
        throw r3     // Catch:{ all -> 0x0211 }
    L_0x01e5:
        r0 = move-exception
        r8 = r3
        r11 = 0
    L_0x01e8:
        r16 = 0
    L_0x01ea:
        r2 = -5054(0xffffffffffffec42, float:NaN)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0211 }
        r3.<init>()     // Catch:{ all -> 0x0211 }
        java.lang.String r9 = "socket error:"
        r3.append(r9)     // Catch:{ all -> 0x0211 }
        java.lang.String r9 = r0.getMessage()     // Catch:{ all -> 0x0211 }
        r3.append(r9)     // Catch:{ all -> 0x0211 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0211 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r3)     // Catch:{ all -> 0x0211 }
        r0.printStackTrace()     // Catch:{ all -> 0x0211 }
        com.tencent.ep.commonbase.network.NetWorkException r3 = new com.tencent.ep.commonbase.network.NetWorkException     // Catch:{ all -> 0x0211 }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0211 }
        r3.m52736init(r2, r0)     // Catch:{ all -> 0x0211 }
        throw r3     // Catch:{ all -> 0x0211 }
    L_0x0211:
        r0 = move-exception
        goto L_0x022c
    L_0x0213:
        r0 = move-exception
        r8 = r3
        r11 = 0
    L_0x0216:
        r16 = 0
    L_0x0218:
        r2 = -7001(0xffffffffffffe4a7, float:NaN)
        java.lang.String r3 = "file not found"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r3)     // Catch:{ all -> 0x0211 }
        r0.printStackTrace()     // Catch:{ all -> 0x0211 }
        com.tencent.ep.commonbase.network.NetWorkException r3 = new com.tencent.ep.commonbase.network.NetWorkException     // Catch:{ all -> 0x0211 }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0211 }
        r3.m52736init(r2, r0)     // Catch:{ all -> 0x0211 }
        throw r3     // Catch:{ all -> 0x0211 }
    L_0x022c:
        r2 = r0
    L_0x022d:
        if (r16 == 0) goto L_0x023e
        com.tencent.p605ep.commonbase.api.Log.m31483i(r7, r6)
        r16.close()     // Catch:{ IOException -> 0x0236 }
        goto L_0x023e
    L_0x0236:
        r0 = move-exception
        r3 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r4)
        r3.printStackTrace()
    L_0x023e:
        if (r11 == 0) goto L_0x024f
        com.tencent.p605ep.commonbase.api.Log.m31483i(r7, r5)
        r11.close()     // Catch:{ IOException -> 0x0247 }
        goto L_0x024f
    L_0x0247:
        r0 = move-exception
        r3 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r8)
        r3.printStackTrace()
    L_0x024f:
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.network.HttpGetFile.writeTempFile(java.io.InputStream, android.os.Bundle, boolean, int):int");
    }

    public synchronized void cancelGet() {
        this.mIsCanceled = true;
    }

    public int doGetFile(String str, String str2, boolean z, DataMd5Cheker dataMd5Cheker) {
        return doGetFile(str, str2, z, dataMd5Cheker, 0);
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v0, types: [android.os.Bundle] */
    /* JADX WARNING: type inference failed for: r17v0 */
    /* JADX WARNING: type inference failed for: r16v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r8v1, types: [android.os.Bundle] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r16v1 */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.os.Bundle] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v4, types: [android.os.Bundle] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r16v2 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r16v3 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r16v4 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r16v5 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r3v15, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r16v6 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r16v7 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r8v18, types: [android.os.Bundle] */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r3v18, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r16v8 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r16v9 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: type inference failed for: r16v10 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: type inference failed for: r8v23 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: type inference failed for: r3v23, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r16v11 */
    /* JADX WARNING: type inference failed for: r16v12 */
    /* JADX WARNING: type inference failed for: r8v24 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r3v24 */
    /* JADX WARNING: type inference failed for: r8v25 */
    /* JADX WARNING: type inference failed for: r4v22 */
    /* JADX WARNING: type inference failed for: r16v13 */
    /* JADX WARNING: type inference failed for: r8v26 */
    /* JADX WARNING: type inference failed for: r16v14 */
    /* JADX WARNING: type inference failed for: r8v27 */
    /* JADX WARNING: type inference failed for: r4v23 */
    /* JADX WARNING: type inference failed for: r16v15 */
    /* JADX WARNING: type inference failed for: r8v28 */
    /* JADX WARNING: type inference failed for: r4v24 */
    /* JADX WARNING: type inference failed for: r8v29 */
    /* JADX WARNING: type inference failed for: r4v25 */
    /* JADX WARNING: type inference failed for: r16v16 */
    /* JADX WARNING: type inference failed for: r8v30 */
    /* JADX WARNING: type inference failed for: r8v31 */
    /* JADX WARNING: type inference failed for: r4v26 */
    /* JADX WARNING: type inference failed for: r1v28, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r16v17 */
    /* JADX WARNING: type inference failed for: r8v32 */
    /* JADX WARNING: type inference failed for: r4v28 */
    /* JADX WARNING: type inference failed for: r1v30 */
    /* JADX WARNING: type inference failed for: r16v18 */
    /* JADX WARNING: type inference failed for: r8v33 */
    /* JADX WARNING: type inference failed for: r4v29 */
    /* JADX WARNING: type inference failed for: r16v19 */
    /* JADX WARNING: type inference failed for: r8v34 */
    /* JADX WARNING: type inference failed for: r4v31 */
    /* JADX WARNING: type inference failed for: r16v20 */
    /* JADX WARNING: type inference failed for: r8v35 */
    /* JADX WARNING: type inference failed for: r4v32 */
    /* JADX WARNING: type inference failed for: r16v21 */
    /* JADX WARNING: type inference failed for: r8v36 */
    /* JADX WARNING: type inference failed for: r4v33 */
    /* JADX WARNING: type inference failed for: r16v22 */
    /* JADX WARNING: type inference failed for: r8v37 */
    /* JADX WARNING: type inference failed for: r4v34 */
    /* JADX WARNING: type inference failed for: r16v23 */
    /* JADX WARNING: type inference failed for: r8v38 */
    /* JADX WARNING: type inference failed for: r4v35 */
    /* JADX WARNING: type inference failed for: r16v24 */
    /* JADX WARNING: type inference failed for: r8v39 */
    /* JADX WARNING: type inference failed for: r4v36 */
    /* JADX WARNING: type inference failed for: r8v44, types: [android.os.Bundle] */
    /* JADX WARNING: type inference failed for: r4v49 */
    /* JADX WARNING: type inference failed for: r16v25 */
    /* JADX WARNING: type inference failed for: r3v29 */
    /* JADX WARNING: type inference failed for: r1v38, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v30 */
    /* JADX WARNING: type inference failed for: r3v31 */
    /* JADX WARNING: type inference failed for: r3v32 */
    /* JADX WARNING: type inference failed for: r3v33 */
    /* JADX WARNING: type inference failed for: r3v34 */
    /* JADX WARNING: type inference failed for: r3v35 */
    /* JADX WARNING: type inference failed for: r16v26 */
    /* JADX WARNING: type inference failed for: r16v27 */
    /* JADX WARNING: type inference failed for: r3v38 */
    /* JADX WARNING: type inference failed for: r16v28 */
    /* JADX WARNING: type inference failed for: r3v42 */
    /* JADX WARNING: type inference failed for: r16v29 */
    /* JADX WARNING: type inference failed for: r16v30 */
    /* JADX WARNING: type inference failed for: r21v1 */
    /* JADX WARNING: type inference failed for: r8v47, types: [android.os.Bundle] */
    /* JADX WARNING: type inference failed for: r4v54, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v48 */
    /* JADX WARNING: type inference failed for: r4v62 */
    /* JADX WARNING: type inference failed for: r3v50 */
    /* JADX WARNING: type inference failed for: r8v49 */
    /* JADX WARNING: type inference failed for: r4v63 */
    /* JADX WARNING: type inference failed for: r8v50 */
    /* JADX WARNING: type inference failed for: r16v31 */
    /* JADX WARNING: type inference failed for: r8v51 */
    /* JADX WARNING: type inference failed for: r16v32 */
    /* JADX WARNING: type inference failed for: r8v52 */
    /* JADX WARNING: type inference failed for: r16v33 */
    /* JADX WARNING: type inference failed for: r8v53 */
    /* JADX WARNING: type inference failed for: r16v34 */
    /* JADX WARNING: type inference failed for: r8v54 */
    /* JADX WARNING: type inference failed for: r16v35 */
    /* JADX WARNING: type inference failed for: r8v55 */
    /* JADX WARNING: type inference failed for: r16v36 */
    /* JADX WARNING: type inference failed for: r8v56 */
    /* JADX WARNING: type inference failed for: r8v57 */
    /* JADX WARNING: type inference failed for: r4v65 */
    /* JADX WARNING: type inference failed for: r16v37 */
    /* JADX WARNING: type inference failed for: r8v58 */
    /* JADX WARNING: type inference failed for: r4v66 */
    /* JADX WARNING: type inference failed for: r3v51 */
    /* JADX WARNING: type inference failed for: r8v59 */
    /* JADX WARNING: type inference failed for: r4v67 */
    /* JADX WARNING: type inference failed for: r3v52 */
    /* JADX WARNING: type inference failed for: r8v60 */
    /* JADX WARNING: type inference failed for: r4v68 */
    /* JADX WARNING: type inference failed for: r3v53 */
    /* JADX WARNING: type inference failed for: r8v61 */
    /* JADX WARNING: type inference failed for: r4v69 */
    /* JADX WARNING: type inference failed for: r3v54 */
    /* JADX WARNING: type inference failed for: r8v62 */
    /* JADX WARNING: type inference failed for: r4v70 */
    /* JADX WARNING: type inference failed for: r16v38 */
    /* JADX WARNING: type inference failed for: r8v63 */
    /* JADX WARNING: type inference failed for: r4v71 */
    /* JADX WARNING: type inference failed for: r3v56 */
    /* JADX WARNING: type inference failed for: r8v64 */
    /* JADX WARNING: type inference failed for: r4v72 */
    /* JADX WARNING: type inference failed for: r8v65 */
    /* JADX WARNING: type inference failed for: r4v73 */
    /* JADX WARNING: type inference failed for: r1v62 */
    /* JADX WARNING: type inference failed for: r8v66 */
    /* JADX WARNING: type inference failed for: r4v74 */
    /* JADX WARNING: type inference failed for: r1v63 */
    /* JADX WARNING: type inference failed for: r8v67 */
    /* JADX WARNING: type inference failed for: r4v75 */
    /* JADX WARNING: type inference failed for: r3v58 */
    /* JADX WARNING: type inference failed for: r8v68 */
    /* JADX WARNING: type inference failed for: r4v76 */
    /* JADX WARNING: type inference failed for: r8v69 */
    /* JADX WARNING: type inference failed for: r4v77 */
    /* JADX WARNING: type inference failed for: r8v70 */
    /* JADX WARNING: type inference failed for: r4v78 */
    /* JADX WARNING: type inference failed for: r8v71 */
    /* JADX WARNING: type inference failed for: r16v39 */
    /* JADX WARNING: type inference failed for: r8v72 */
    /* JADX WARNING: type inference failed for: r4v79 */
    /* JADX WARNING: type inference failed for: r3v59 */
    /* JADX WARNING: type inference failed for: r8v73 */
    /* JADX WARNING: type inference failed for: r4v80 */
    /* JADX WARNING: type inference failed for: r8v74 */
    /* JADX WARNING: type inference failed for: r16v40 */
    /* JADX WARNING: type inference failed for: r8v75 */
    /* JADX WARNING: type inference failed for: r4v81 */
    /* JADX WARNING: type inference failed for: r8v76 */
    /* JADX WARNING: type inference failed for: r4v82 */
    /* JADX WARNING: type inference failed for: r8v77 */
    /* JADX WARNING: type inference failed for: r16v41 */
    /* JADX WARNING: type inference failed for: r8v78 */
    /* JADX WARNING: type inference failed for: r4v83 */
    /* JADX WARNING: type inference failed for: r3v60 */
    /* JADX WARNING: type inference failed for: r8v79 */
    /* JADX WARNING: type inference failed for: r4v84 */
    /* JADX WARNING: type inference failed for: r3v61 */
    /* JADX WARNING: type inference failed for: r8v80 */
    /* JADX WARNING: type inference failed for: r4v85 */
    /* JADX WARNING: type inference failed for: r8v81 */
    /* JADX WARNING: type inference failed for: r16v42 */
    /* JADX WARNING: type inference failed for: r8v82 */
    /* JADX WARNING: type inference failed for: r4v86 */
    /* JADX WARNING: type inference failed for: r8v83 */
    /* JADX WARNING: type inference failed for: r4v87 */
    /* JADX WARNING: type inference failed for: r8v84 */
    /* JADX WARNING: type inference failed for: r16v43 */
    /* JADX WARNING: type inference failed for: r16v44 */
    /* JADX WARNING: type inference failed for: r8v85 */
    /* JADX WARNING: type inference failed for: r4v88 */
    /* JADX WARNING: type inference failed for: r16v45 */
    /* JADX WARNING: type inference failed for: r8v86 */
    /* JADX WARNING: type inference failed for: r4v89 */
    /* JADX WARNING: type inference failed for: r8v87 */
    /* JADX WARNING: type inference failed for: r16v46 */
    /* JADX WARNING: type inference failed for: r8v88 */
    /* JADX WARNING: type inference failed for: r4v90 */
    /* JADX WARNING: type inference failed for: r8v89 */
    /* JADX WARNING: type inference failed for: r4v91 */
    /* JADX WARNING: type inference failed for: r16v47 */
    /* JADX WARNING: type inference failed for: r8v90 */
    /* JADX WARNING: type inference failed for: r4v92 */
    /* JADX WARNING: type inference failed for: r16v48 */
    /* JADX WARNING: type inference failed for: r8v91 */
    /* JADX WARNING: type inference failed for: r16v49 */
    /* JADX WARNING: type inference failed for: r8v92 */
    /* JADX WARNING: type inference failed for: r16v50 */
    /* JADX WARNING: type inference failed for: r8v93 */
    /* JADX WARNING: type inference failed for: r16v51 */
    /* JADX WARNING: type inference failed for: r8v94 */
    /* JADX WARNING: type inference failed for: r16v52 */
    /* JADX WARNING: type inference failed for: r8v95 */
    /* JADX WARNING: type inference failed for: r16v53 */
    /* JADX WARNING: type inference failed for: r8v96 */
    /* JADX WARNING: type inference failed for: r8v97 */
    /* JADX WARNING: type inference failed for: r4v93 */
    /* JADX WARNING: type inference failed for: r16v54 */
    /* JADX WARNING: type inference failed for: r1v64 */
    /* JADX WARNING: type inference failed for: r3v62 */
    /* JADX WARNING: type inference failed for: r16v55 */
    /* JADX WARNING: type inference failed for: r16v56 */
    /* JADX WARNING: type inference failed for: r8v98 */
    /* JADX WARNING: type inference failed for: r3v63 */
    /* JADX WARNING: type inference failed for: r8v99 */
    /* JADX WARNING: type inference failed for: r16v57 */
    /* JADX WARNING: type inference failed for: r3v64 */
    /* JADX WARNING: type inference failed for: r3v65 */
    /* JADX WARNING: type inference failed for: r3v66 */
    /* JADX WARNING: type inference failed for: r3v67 */
    /* JADX WARNING: type inference failed for: r8v100 */
    /* JADX WARNING: type inference failed for: r4v94 */
    /* JADX WARNING: type inference failed for: r16v58 */
    /* JADX WARNING: type inference failed for: r3v68 */
    /* JADX WARNING: type inference failed for: r1v65 */
    /* JADX WARNING: type inference failed for: r1v66 */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0243, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0244, code lost:
            r16 = r1;
            r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0248, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0249, code lost:
            r18 = r3;
            r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0264, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0265, code lost:
            r16 = r1;
            r2 = -4000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x026a, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x026b, code lost:
            r3 = r1;
            r18 = -4000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0276, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0277, code lost:
            r3 = r1;
            r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0282, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0283, code lost:
            r3 = r1;
            r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0287, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0288, code lost:
            r3 = r1;
            r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x028c, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x028d, code lost:
            r3 = r1;
            r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0067, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0068, code lost:
            r1 = r0;
            r8 = r6;
            r4 = r17;
            r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x031d, code lost:
            closeQuietly(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
            r1 = r0;
            r8 = r6;
            r4 = r17;
            r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x033e, code lost:
            closeQuietly(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0081, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0394, code lost:
            if (r3 == 0) goto L_0x03f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0396, code lost:
            closeQuietly(r3);
            r8 = r8;
            r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
            r1 = r0;
            r8 = r6;
            r4 = r17;
            r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x03c6, code lost:
            r8 = r8;
            r4 = r4;
            r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0089, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x03f1, code lost:
            if (r3 != 0) goto L_0x0396;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008a, code lost:
            r1 = r0;
            r8 = r6;
            r4 = r17;
            r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x041a, code lost:
            closeQuietly(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00da, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00db, code lost:
            r1 = r0;
            r8 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e2, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e3, code lost:
            r1 = r0;
            r8 = r6;
            r4 = r17;
            r3 = 0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0053, B:37:0x00d7] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v2
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0276 A[ExcHandler: Exception (r0v44 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:98:0x0202] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0282 A[ExcHandler: IOException (r0v41 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:98:0x0202] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0287 A[ExcHandler: SocketTimeoutException (r0v40 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:98:0x0202] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x028c A[ExcHandler: SocketException (r0v39 'e' java.net.SocketException A[CUSTOM_DECLARE]), Splitter:B:98:0x0202] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0067 A[ExcHandler: Exception (r0v70 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:8:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0079 A[ExcHandler: IOException (r0v69 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:8:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081 A[ExcHandler: SocketTimeoutException (r0v68 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:8:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x03c6 A[Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8, all -> 0x0414 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0089 A[ExcHandler: SocketException (r0v67 'e' java.net.SocketException A[CUSTOM_DECLARE]), Splitter:B:8:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x041a  */
    /* JADX WARNING: Unknown variable types count: 102 */
    public int doGetFile(java.lang.String r20, java.lang.String r21, boolean r22, com.tencent.p605ep.commonbase.network.HttpGetFile.DataMd5Cheker r23, int r24) {
        /*
        r19 = this;
        r7 = r19
        r1 = r21
        r5 = r23
        r2 = r24
        java.lang.String r8 = "key_downType"
        java.lang.String r9 = "key_sdcardstatus"
        java.lang.String r10 = "key_total"
        java.lang.String r11 = "key_downSize"
        java.lang.String r12 = "key_errorMsg"
        java.lang.String r13 = "key_errcode"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "doGetFile "
        r3.append(r4)
        r3.append(r1)
        java.lang.String r4 = " redirtTimes "
        r3.append(r4)
        r3.append(r2)
        java.lang.String r3 = r3.toString()
        java.lang.String r14 = "HttpBase"
        com.tencent.p605ep.commonbase.api.Log.m31477d(r14, r3)
        java.lang.String r15 = ""
        android.os.Bundle r6 = new android.os.Bundle
        r6.<init>()
        r17 = r8
        boolean r18 = android.text.TextUtils.isEmpty(r21)     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        if (r18 == 0) goto L_0x0049
        r8 = r6
        r4 = r17
        r1 = 0
        r3 = -3000(0xfffffffffffff448, float:NaN)
        goto L_0x0254
    L_0x0049:
        java.net.HttpURLConnection r3 = r7.getCon(r1)     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        if (r3 != 0) goto L_0x0091
        r3 = -3053(0xfffffffffffff413, float:NaN)
        java.lang.String r1 = "url == null"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r14, r1)     // Catch:{ SocketException -> 0x0089, SocketTimeoutException -> 0x0081, IOException -> 0x0079, NetWorkException -> 0x006f, Exception -> 0x0067, all -> 0x005c }
        r8 = r6
        r4 = r17
        r1 = 0
        goto L_0x0254
    L_0x005c:
        r0 = move-exception
        r1 = r0
        r8 = r6
        r4 = r17
        r2 = -3053(0xfffffffffffff413, float:NaN)
    L_0x0063:
        r16 = 0
        goto L_0x0418
    L_0x0067:
        r0 = move-exception
        r1 = r0
        r8 = r6
        r4 = r17
        r3 = 0
        goto L_0x02fc
    L_0x006f:
        r0 = move-exception
        r1 = r0
        r8 = r6
        r4 = r17
        r3 = 0
        r18 = -3053(0xfffffffffffff413, float:NaN)
        goto L_0x0334
    L_0x0079:
        r0 = move-exception
        r1 = r0
        r8 = r6
        r4 = r17
        r3 = 0
        goto L_0x0373
    L_0x0081:
        r0 = move-exception
        r1 = r0
        r8 = r6
        r4 = r17
        r3 = 0
        goto L_0x03a3
    L_0x0089:
        r0 = move-exception
        r1 = r0
        r8 = r6
        r4 = r17
        r3 = 0
        goto L_0x03d0
    L_0x0091:
        boolean r4 = r7.mIsCanceled     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        if (r4 == 0) goto L_0x009c
        r8 = r6
        r4 = r17
        r16 = 0
        goto L_0x01f9
    L_0x009c:
        boolean r4 = android.text.TextUtils.isEmpty(r20)     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        if (r4 != 0) goto L_0x00a5
        r1 = r20
        goto L_0x00aa
    L_0x00a5:
        r4 = 0
        java.lang.String r1 = com.tencent.p605ep.commonbase.utils.FileUtil.guessFileName(r1, r4)     // Catch:{ SocketException -> 0x02e0, SocketTimeoutException -> 0x02d8, IOException -> 0x02d0, NetWorkException -> 0x02c8, Exception -> 0x02c1, all -> 0x02ba }
    L_0x00aa:
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        r4.<init>()     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        r4.append(r1)     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        java.lang.String r8 = ".tmp"
        r4.append(r8)     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        java.lang.String r4 = r4.toString()     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        r7.mTempName = r4     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        r4.<init>()     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        java.lang.String r8 = "mTempName: "
        r4.append(r8)     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        java.lang.String r8 = r7.mTempName     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        r4.append(r8)     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        java.lang.String r4 = r4.toString()     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r14, r4)     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        java.lang.String r4 = r7.mSaveName     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        if (r4 != 0) goto L_0x00ea
        r7.mSaveName = r1     // Catch:{ SocketException -> 0x0089, SocketTimeoutException -> 0x0081, IOException -> 0x0079, NetWorkException -> 0x00e2, Exception -> 0x0067, all -> 0x00da }
        goto L_0x00ea
    L_0x00da:
        r0 = move-exception
        r1 = r0
        r8 = r6
    L_0x00dd:
        r4 = r17
        r2 = -3000(0xfffffffffffff448, float:NaN)
        goto L_0x0063
    L_0x00e2:
        r0 = move-exception
        r1 = r0
        r8 = r6
        r4 = r17
        r3 = 0
        goto L_0x0332
    L_0x00ea:
        java.io.File r1 = new java.io.File     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        java.lang.String r4 = r7.mTempPath     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        java.lang.String r8 = r7.mTempName     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        r1.<init>(r4, r8)     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        boolean r4 = r1.exists()     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        if (r4 == 0) goto L_0x0103
        long r4 = r1.length()     // Catch:{ SocketException -> 0x0089, SocketTimeoutException -> 0x0081, IOException -> 0x0079, NetWorkException -> 0x00e2, Exception -> 0x0067, all -> 0x00da }
        r7.mCompletedSize = r4     // Catch:{ SocketException -> 0x0089, SocketTimeoutException -> 0x0081, IOException -> 0x0079, NetWorkException -> 0x00e2, Exception -> 0x0067, all -> 0x00da }
        r1 = 1
        r7.isContinue = r1     // Catch:{ SocketException -> 0x0089, SocketTimeoutException -> 0x0081, IOException -> 0x0079, NetWorkException -> 0x00e2, Exception -> 0x0067, all -> 0x00da }
        goto L_0x0107
    L_0x0103:
        r4 = 0
        r7.mCompletedSize = r4     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
    L_0x0107:
        java.lang.String r1 = "Range"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        r4.<init>()     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        java.lang.String r5 = "bytes="
        r4.append(r5)     // Catch:{ SocketException -> 0x03c7, SocketTimeoutException -> 0x039a, IOException -> 0x036a, NetWorkException -> 0x0329, Exception -> 0x02f3, all -> 0x02e8 }
        r8 = r6
        long r5 = r7.mCompletedSize     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        r4.append(r5)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        java.lang.String r5 = "-"
        r4.append(r5)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        java.lang.String r4 = r4.toString()     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        r3.setRequestProperty(r1, r4)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        r3.connect()     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        int r1 = r3.getResponseCode()     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        r4.<init>()     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        java.lang.String r5 = "statusCode == "
        r4.append(r5)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        r4.append(r1)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        java.lang.String r4 = r4.toString()     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r14, r4)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        boolean r4 = r7.isRedirect(r1)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        if (r4 == 0) goto L_0x01db
        r4 = 3
        if (r2 > r4) goto L_0x01db
        if (r2 < 0) goto L_0x01db
        java.lang.String r4 = "Location"
        java.lang.String r4 = r3.getHeaderField(r4)     // Catch:{ Exception -> 0x0155, all -> 0x0152 }
        goto L_0x0170
    L_0x0152:
        r0 = move-exception
        r1 = r0
        goto L_0x00dd
    L_0x0155:
        r0 = move-exception
        r4 = r0
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        r5.<init>()     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        java.lang.String r6 = "getRedirectUrl() e: "
        r5.append(r6)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        java.lang.String r4 = r4.toString()     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        r5.append(r4)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        java.lang.String r4 = r5.toString()     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r14, r4)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        r4 = 0
    L_0x0170:
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        r5.<init>()     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        java.lang.String r6 = "[http_control]getRedirectUrl() "
        r5.append(r6)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        r5.append(r4)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        java.lang.String r5 = r5.toString()     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        com.tencent.p605ep.commonbase.api.Log.m31477d(r14, r5)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ SocketException -> 0x02b7, SocketTimeoutException -> 0x02b4, IOException -> 0x02b1, NetWorkException -> 0x02ae, Exception -> 0x02ac, all -> 0x02aa }
        if (r5 != 0) goto L_0x01db
        r5 = 1
        int r6 = r2 + 1
        r1 = r19
        r2 = r20
        r5 = -3000(0xfffffffffffff448, float:NaN)
        r16 = 0
        r3 = r4
        r21 = r8
        r8 = -7
        r4 = r22
        r8 = -3000(0xfffffffffffff448, float:NaN)
        r5 = r23
        r8 = r21
        int r1 = r1.doGetFile(r2, r3, r4, r5, r6)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d5, IOException -> 0x01d2, NetWorkException -> 0x01cf, Exception -> 0x01cc, all -> 0x01c9 }
        r2 = -3000(0xfffffffffffff448, float:NaN)
        r8.putInt(r13, r2)
        r8.putString(r12, r15)
        long r2 = r7.mCompletedSize
        int r3 = (int) r2
        r8.putInt(r11, r3)
        long r2 = r7.mTotalSize
        int r3 = (int) r2
        r8.putInt(r10, r3)
        r2 = 1
        r8.putInt(r9, r2)
        boolean r3 = r7.isContinue
        byte r3 = (byte) r3
        r4 = r17
        r8.putByte(r4, r3)
        r7.doCallback(r2, r8)
        return r1
    L_0x01c9:
        r0 = move-exception
        goto L_0x02be
    L_0x01cc:
        r0 = move-exception
        goto L_0x02c5
    L_0x01cf:
        r0 = move-exception
        goto L_0x02cc
    L_0x01d2:
        r0 = move-exception
        goto L_0x02d4
    L_0x01d5:
        r0 = move-exception
        goto L_0x02dc
    L_0x01d8:
        r0 = move-exception
        goto L_0x02e4
    L_0x01db:
        r4 = r17
        r16 = 0
        r2 = 200(0xc8, float:2.8E-43)
        if (r1 == r2) goto L_0x01f1
        r2 = 206(0xce, float:2.89E-43)
        if (r1 == r2) goto L_0x01f1
        r2 = -3000(0xfffffffffffff448, float:NaN)
        int r5 = -3000 - r1
        r6 = 416(0x1a0, float:5.83E-43)
        if (r1 == r6) goto L_0x01f5
        r3 = r5
        goto L_0x01fb
    L_0x01f1:
        r2 = -3000(0xfffffffffffff448, float:NaN)
        r5 = -3000(0xfffffffffffff448, float:NaN)
    L_0x01f5:
        boolean r1 = r7.mIsCanceled     // Catch:{ SocketException -> 0x02a7, SocketTimeoutException -> 0x02a4, IOException -> 0x02a1, NetWorkException -> 0x0299, Exception -> 0x0296, all -> 0x0291 }
        if (r1 == 0) goto L_0x01fe
    L_0x01f9:
        r3 = -3003(0xfffffffffffff445, float:NaN)
    L_0x01fb:
        r1 = r16
        goto L_0x0254
    L_0x01fe:
        java.io.InputStream r1 = r3.getInputStream()     // Catch:{ SocketException -> 0x02a7, SocketTimeoutException -> 0x02a4, IOException -> 0x02a1, NetWorkException -> 0x0299, Exception -> 0x0296, all -> 0x0291 }
        int r3 = r3.getContentLength()     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x027b, Exception -> 0x0276, all -> 0x026f }
        if (r1 == 0) goto L_0x024d
        if (r3 != 0) goto L_0x020b
        goto L_0x024d
    L_0x020b:
        r6 = r22
        int r3 = r7.writeTempFile(r1, r8, r6, r3)     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x027b, Exception -> 0x0276, all -> 0x026f }
        if (r3 == 0) goto L_0x0214
        goto L_0x0254
    L_0x0214:
        r5 = r23
        if (r5 == 0) goto L_0x0239
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x0248, Exception -> 0x0276, all -> 0x0243 }
        r6.<init>()     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x0248, Exception -> 0x0276, all -> 0x0243 }
        java.lang.String r2 = r7.mTempPath     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x0248, Exception -> 0x0276, all -> 0x0243 }
        r6.append(r2)     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x0248, Exception -> 0x0276, all -> 0x0243 }
        java.lang.String r2 = java.io.File.separator     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x0248, Exception -> 0x0276, all -> 0x0243 }
        r6.append(r2)     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x0248, Exception -> 0x0276, all -> 0x0243 }
        java.lang.String r2 = r7.mTempName     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x0248, Exception -> 0x0276, all -> 0x0243 }
        r6.append(r2)     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x0248, Exception -> 0x0276, all -> 0x0243 }
        java.lang.String r2 = r6.toString()     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x0248, Exception -> 0x0276, all -> 0x0243 }
        boolean r2 = r5.isMatch(r2)     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x0248, Exception -> 0x0276, all -> 0x0243 }
        if (r2 != 0) goto L_0x0239
        r3 = -7000(0xffffffffffffe4a8, float:NaN)
        goto L_0x0254
    L_0x0239:
        r2 = 1
        int r3 = r7.copyTempFile(r2)     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x0248, Exception -> 0x0276, all -> 0x0243 }
        if (r3 == 0) goto L_0x0241
        goto L_0x0254
    L_0x0241:
        r3 = 0
        goto L_0x0254
    L_0x0243:
        r0 = move-exception
        r16 = r1
        r2 = r3
        goto L_0x0273
    L_0x0248:
        r0 = move-exception
        r18 = r3
        r3 = r1
        goto L_0x027f
    L_0x024d:
        r3 = -4000(0xfffffffffffff060, float:NaN)
        java.lang.String r2 = "httpEntity == null"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r14, r2)     // Catch:{ SocketException -> 0x028c, SocketTimeoutException -> 0x0287, IOException -> 0x0282, NetWorkException -> 0x026a, Exception -> 0x0276, all -> 0x0264 }
    L_0x0254:
        if (r1 == 0) goto L_0x0259
        closeQuietly(r1)
    L_0x0259:
        if (r3 == 0) goto L_0x0261
        r1 = -7
        if (r3 == r1) goto L_0x0261
        r2 = r3
        goto L_0x03f4
    L_0x0261:
        r2 = r3
        goto L_0x0413
    L_0x0264:
        r0 = move-exception
        r16 = r1
        r2 = -4000(0xfffffffffffff060, float:NaN)
        goto L_0x0273
    L_0x026a:
        r0 = move-exception
        r3 = r1
        r18 = -4000(0xfffffffffffff060, float:NaN)
        goto L_0x027f
    L_0x026f:
        r0 = move-exception
        r16 = r1
        r2 = r5
    L_0x0273:
        r1 = r0
        goto L_0x0418
    L_0x0276:
        r0 = move-exception
        r3 = r1
        r1 = r0
        goto L_0x02fc
    L_0x027b:
        r0 = move-exception
        r3 = r1
        r18 = r5
    L_0x027f:
        r1 = r0
        goto L_0x0334
    L_0x0282:
        r0 = move-exception
        r3 = r1
        r1 = r0
        goto L_0x0373
    L_0x0287:
        r0 = move-exception
        r3 = r1
        r1 = r0
        goto L_0x03a3
    L_0x028c:
        r0 = move-exception
        r3 = r1
        r1 = r0
        goto L_0x03d0
    L_0x0291:
        r0 = move-exception
        r1 = r0
        r2 = r5
        goto L_0x0418
    L_0x0296:
        r0 = move-exception
        goto L_0x02f9
    L_0x0299:
        r0 = move-exception
        r1 = r0
        r18 = r5
        r3 = r16
        goto L_0x0334
    L_0x02a1:
        r0 = move-exception
        goto L_0x0370
    L_0x02a4:
        r0 = move-exception
        goto L_0x03a0
    L_0x02a7:
        r0 = move-exception
        goto L_0x03cd
    L_0x02aa:
        r0 = move-exception
        goto L_0x02ea
    L_0x02ac:
        r0 = move-exception
        goto L_0x02f5
    L_0x02ae:
        r0 = move-exception
        goto L_0x032b
    L_0x02b1:
        r0 = move-exception
        goto L_0x036c
    L_0x02b4:
        r0 = move-exception
        goto L_0x039c
    L_0x02b7:
        r0 = move-exception
        goto L_0x03c9
    L_0x02ba:
        r0 = move-exception
        r16 = r4
        r8 = r6
    L_0x02be:
        r4 = r17
        goto L_0x02ee
    L_0x02c1:
        r0 = move-exception
        r16 = r4
        r8 = r6
    L_0x02c5:
        r4 = r17
        goto L_0x02f9
    L_0x02c8:
        r0 = move-exception
        r16 = r4
        r8 = r6
    L_0x02cc:
        r4 = r17
        goto L_0x032f
    L_0x02d0:
        r0 = move-exception
        r16 = r4
        r8 = r6
    L_0x02d4:
        r4 = r17
        goto L_0x0370
    L_0x02d8:
        r0 = move-exception
        r16 = r4
        r8 = r6
    L_0x02dc:
        r4 = r17
        goto L_0x03a0
    L_0x02e0:
        r0 = move-exception
        r16 = r4
        r8 = r6
    L_0x02e4:
        r4 = r17
        goto L_0x03cd
    L_0x02e8:
        r0 = move-exception
        r8 = r6
    L_0x02ea:
        r4 = r17
        r16 = 0
    L_0x02ee:
        r1 = r0
    L_0x02ef:
        r2 = -3000(0xfffffffffffff448, float:NaN)
        goto L_0x0418
    L_0x02f3:
        r0 = move-exception
        r8 = r6
    L_0x02f5:
        r4 = r17
        r16 = 0
    L_0x02f9:
        r1 = r0
        r3 = r16
    L_0x02fc:
        java.lang.String r15 = r1.getMessage()     // Catch:{ all -> 0x0324 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0324 }
        r2.<init>()     // Catch:{ all -> 0x0324 }
        java.lang.String r5 = "get error:"
        r2.append(r5)     // Catch:{ all -> 0x0324 }
        java.lang.String r5 = r1.getMessage()     // Catch:{ all -> 0x0324 }
        r2.append(r5)     // Catch:{ all -> 0x0324 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0324 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r14, r2)     // Catch:{ all -> 0x0324 }
        r1.printStackTrace()     // Catch:{ all -> 0x0324 }
        if (r3 == 0) goto L_0x0320
        closeQuietly(r3)
    L_0x0320:
        r2 = -3000(0xfffffffffffff448, float:NaN)
        goto L_0x03f4
    L_0x0324:
        r0 = move-exception
        r1 = r0
        r16 = r3
        goto L_0x02ef
    L_0x0329:
        r0 = move-exception
        r8 = r6
    L_0x032b:
        r4 = r17
        r16 = 0
    L_0x032f:
        r1 = r0
        r3 = r16
    L_0x0332:
        r18 = -3000(0xfffffffffffff448, float:NaN)
    L_0x0334:
        int r2 = r1.getErrCode()     // Catch:{ all -> 0x0362 }
        java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0414 }
        if (r3 == 0) goto L_0x0341
        closeQuietly(r3)
    L_0x0341:
        if (r2 == 0) goto L_0x0413
        r3 = -7
        if (r2 == r3) goto L_0x0413
        r8.putInt(r13, r2)
        r8.putString(r12, r1)
        long r5 = r7.mCompletedSize
        int r1 = (int) r5
        r8.putInt(r11, r1)
        long r5 = r7.mTotalSize
        int r1 = (int) r5
        r8.putInt(r10, r1)
        r1 = 1
        r8.putInt(r9, r1)
        boolean r1 = r7.isContinue
        r3 = r1
        r1 = 1
        goto L_0x040c
    L_0x0362:
        r0 = move-exception
        r1 = r0
        r16 = r3
        r2 = r18
        goto L_0x0418
    L_0x036a:
        r0 = move-exception
        r8 = r6
    L_0x036c:
        r4 = r17
        r16 = 0
    L_0x0370:
        r1 = r0
        r3 = r16
    L_0x0373:
        r2 = -3056(0xfffffffffffff410, float:NaN)
        java.lang.String r15 = r1.getMessage()     // Catch:{ all -> 0x0414 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0414 }
        r5.<init>()     // Catch:{ all -> 0x0414 }
        java.lang.String r6 = "io error:"
        r5.append(r6)     // Catch:{ all -> 0x0414 }
        java.lang.String r6 = r1.getMessage()     // Catch:{ all -> 0x0414 }
        r5.append(r6)     // Catch:{ all -> 0x0414 }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0414 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r14, r5)     // Catch:{ all -> 0x0414 }
        r1.printStackTrace()     // Catch:{ all -> 0x0414 }
        if (r3 == 0) goto L_0x03f4
    L_0x0396:
        closeQuietly(r3)
        goto L_0x03f4
    L_0x039a:
        r0 = move-exception
        r8 = r6
    L_0x039c:
        r4 = r17
        r16 = 0
    L_0x03a0:
        r1 = r0
        r3 = r16
    L_0x03a3:
        r2 = -3055(0xfffffffffffff411, float:NaN)
        java.lang.String r15 = r1.getMessage()     // Catch:{ all -> 0x0414 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0414 }
        r5.<init>()     // Catch:{ all -> 0x0414 }
        java.lang.String r6 = "socket timeout error:"
        r5.append(r6)     // Catch:{ all -> 0x0414 }
        java.lang.String r6 = r1.getMessage()     // Catch:{ all -> 0x0414 }
        r5.append(r6)     // Catch:{ all -> 0x0414 }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0414 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r14, r5)     // Catch:{ all -> 0x0414 }
        r1.printStackTrace()     // Catch:{ all -> 0x0414 }
        if (r3 == 0) goto L_0x03f4
        goto L_0x0396
    L_0x03c7:
        r0 = move-exception
        r8 = r6
    L_0x03c9:
        r4 = r17
        r16 = 0
    L_0x03cd:
        r1 = r0
        r3 = r16
    L_0x03d0:
        r2 = -3054(0xfffffffffffff412, float:NaN)
        java.lang.String r15 = r1.getMessage()     // Catch:{ all -> 0x0414 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0414 }
        r5.<init>()     // Catch:{ all -> 0x0414 }
        java.lang.String r6 = "socket error:"
        r5.append(r6)     // Catch:{ all -> 0x0414 }
        java.lang.String r6 = r1.getMessage()     // Catch:{ all -> 0x0414 }
        r5.append(r6)     // Catch:{ all -> 0x0414 }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0414 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r14, r5)     // Catch:{ all -> 0x0414 }
        r1.printStackTrace()     // Catch:{ all -> 0x0414 }
        if (r3 == 0) goto L_0x03f4
        goto L_0x0396
    L_0x03f4:
        r8.putInt(r13, r2)
        r8.putString(r12, r15)
        long r5 = r7.mCompletedSize
        int r1 = (int) r5
        r8.putInt(r11, r1)
        long r5 = r7.mTotalSize
        int r1 = (int) r5
        r8.putInt(r10, r1)
        r1 = 1
        r8.putInt(r9, r1)
        boolean r3 = r7.isContinue
    L_0x040c:
        byte r3 = (byte) r3
        r8.putByte(r4, r3)
        r7.doCallback(r1, r8)
    L_0x0413:
        return r2
    L_0x0414:
        r0 = move-exception
        r1 = r0
        r16 = r3
    L_0x0418:
        if (r16 == 0) goto L_0x041d
        closeQuietly(r16)
    L_0x041d:
        if (r2 == 0) goto L_0x0441
        r3 = -7
        if (r2 == r3) goto L_0x0441
        r8.putInt(r13, r2)
        r8.putString(r12, r15)
        long r2 = r7.mCompletedSize
        int r3 = (int) r2
        r8.putInt(r11, r3)
        long r2 = r7.mTotalSize
        int r3 = (int) r2
        r8.putInt(r10, r3)
        r2 = 1
        r8.putInt(r9, r2)
        boolean r3 = r7.isContinue
        byte r3 = (byte) r3
        r8.putByte(r4, r3)
        r7.doCallback(r2, r8)
    L_0x0441:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.network.HttpGetFile.doGetFile(java.lang.String, java.lang.String, boolean, com.tencent.ep.commonbase.network.HttpGetFile$DataMd5Cheker, int):int");
    }

    public String getAbsoluteDownFileName() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mSavePath);
        sb.append(File.separator);
        sb.append(this.mSaveName);
        return sb.toString();
    }

    public String getFullPathSaveName() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mSavePath);
        sb.append(File.separator);
        sb.append(this.mSaveName);
        return sb.toString();
    }

    public synchronized boolean isCanceled() {
        return this.mIsCanceled;
    }

    public void setFileMode(int i) {
        this.mFileMode = i;
    }

    public void setSaveName(String str) {
        this.mSaveName = str;
    }

    public void setSavePath(String str) {
        this.mSavePath = str;
    }
}
