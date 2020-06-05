package btmsdkobf;

import android.content.Context;

/* renamed from: btmsdkobf.f */
public class C0837f extends C0661cr {
    /* renamed from: f */
    private String f962f = null;
    /* renamed from: g */
    private String f963g = null;
    /* renamed from: h */
    private String f964h = null;
    /* renamed from: i */
    private String f965i = null;
    /* renamed from: j */
    private int f966j = 0;
    /* renamed from: k */
    private boolean f967k = false;
    /* renamed from: l */
    private long f968l = 0;
    /* renamed from: m */
    private long f969m = 0;
    private Context mContext;
    /* renamed from: n */
    private boolean f970n = false;

    /* renamed from: btmsdkobf.f$a */
    public interface C0838a {
        /* renamed from: d */
        boolean mo9537d(String str);
    }

    public C0837f(Context context) {
        this.mContext = context;
        this.f962f = context.getCacheDir().getAbsolutePath();
        this.f963g = context.getFilesDir().getAbsolutePath();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r7v1, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r13v0, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r7v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r13v2 */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: type inference failed for: r13v3 */
    /* JADX WARNING: type inference failed for: r13v7, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r7v12 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r7v13 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r9v20 */
    /* JADX WARNING: type inference failed for: r7v15 */
    /* JADX WARNING: type inference failed for: r9v21 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r7v16 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r9v22 */
    /* JADX WARNING: type inference failed for: r7v17 */
    /* JADX WARNING: type inference failed for: r8v21, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v13, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v21, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r9v24, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r16v0 */
    /* JADX WARNING: type inference failed for: r7v18 */
    /* JADX WARNING: type inference failed for: r7v19 */
    /* JADX WARNING: type inference failed for: r7v20 */
    /* JADX WARNING: type inference failed for: r7v21 */
    /* JADX WARNING: type inference failed for: r7v22 */
    /* JADX WARNING: type inference failed for: r7v23 */
    /* JADX WARNING: type inference failed for: r7v24, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r9v25 */
    /* JADX WARNING: type inference failed for: r7v25 */
    /* JADX WARNING: type inference failed for: r9v27 */
    /* JADX WARNING: type inference failed for: r16v1 */
    /* JADX WARNING: type inference failed for: r2v26 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: type inference failed for: r7v27 */
    /* JADX WARNING: type inference failed for: r2v27 */
    /* JADX WARNING: type inference failed for: r8v23 */
    /* JADX WARNING: type inference failed for: r7v28 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: type inference failed for: r8v24 */
    /* JADX WARNING: type inference failed for: r7v29 */
    /* JADX WARNING: type inference failed for: r2v29 */
    /* JADX WARNING: type inference failed for: r8v25 */
    /* JADX WARNING: type inference failed for: r7v30 */
    /* JADX WARNING: type inference failed for: r2v30 */
    /* JADX WARNING: type inference failed for: r8v26 */
    /* JADX WARNING: type inference failed for: r7v31 */
    /* JADX WARNING: type inference failed for: r7v32 */
    /* JADX WARNING: type inference failed for: r2v36 */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r8v27, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r9v28 */
    /* JADX WARNING: type inference failed for: r7v33 */
    /* JADX WARNING: type inference failed for: r9v29, types: [java.util.zip.InflaterInputStream] */
    /* JADX WARNING: type inference failed for: r8v28 */
    /* JADX WARNING: type inference failed for: r9v30 */
    /* JADX WARNING: type inference failed for: r7v34 */
    /* JADX WARNING: type inference failed for: r13v8 */
    /* JADX WARNING: type inference failed for: r2v38 */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: type inference failed for: r7v35 */
    /* JADX WARNING: type inference failed for: r8v29 */
    /* JADX WARNING: type inference failed for: r13v10 */
    /* JADX WARNING: type inference failed for: r9v31 */
    /* JADX WARNING: type inference failed for: r8v30 */
    /* JADX WARNING: type inference failed for: r7v36 */
    /* JADX WARNING: type inference failed for: r7v37 */
    /* JADX WARNING: type inference failed for: r9v32 */
    /* JADX WARNING: type inference failed for: r8v31 */
    /* JADX WARNING: type inference failed for: r7v38 */
    /* JADX WARNING: type inference failed for: r2v39 */
    /* JADX WARNING: type inference failed for: r13v11 */
    /* JADX WARNING: type inference failed for: r8v32 */
    /* JADX WARNING: type inference failed for: r8v33 */
    /* JADX WARNING: type inference failed for: r8v34 */
    /* JADX WARNING: type inference failed for: r8v35 */
    /* JADX WARNING: type inference failed for: r9v33 */
    /* JADX WARNING: type inference failed for: r7v39 */
    /* JADX WARNING: type inference failed for: r8v36 */
    /* JADX WARNING: type inference failed for: r8v37 */
    /* JADX WARNING: type inference failed for: r3v24 */
    /* JADX WARNING: type inference failed for: r2v40 */
    /* JADX WARNING: type inference failed for: r9v34 */
    /* JADX WARNING: type inference failed for: r9v35 */
    /* JADX WARNING: type inference failed for: r8v38 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x017e, code lost:
            r9 = r2;
            r7 = r3;
            r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0180, code lost:
            r2 = r8;
            r8 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0184, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0185, code lost:
            r9 = r2;
            r7 = r3;
            r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0187, code lost:
            r2 = r8;
            r8 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x018b, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x018c, code lost:
            r9 = r2;
            r7 = r3;
            r2 = r0;
            r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0192, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0193, code lost:
            r9 = r2;
            r7 = r3;
            r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01b1, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01b2, code lost:
            r9 = r2;
            r7 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01c9, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01ca, code lost:
            r9 = r2;
            r7 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01f4, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01f5, code lost:
            r9 = r2;
            r7 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x021f, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0220, code lost:
            r9 = r2;
            r7 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x023d, code lost:
            btmsdkobf.C0848ff.m907i(r6, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
            r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0244, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0245, code lost:
            r3 = r0;
            btmsdkobf.C0848ff.m906e(r6, r7);
            r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x024e, code lost:
            btmsdkobf.C0848ff.m907i(r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
            r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0255, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0256, code lost:
            r3 = r0;
            btmsdkobf.C0848ff.m906e(r6, r9);
            r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e1, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e2, code lost:
            r9 = r2;
            r2 = r0;
            r7 = r3;
            r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e7, code lost:
            r9 = r2;
            r16 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            r13.flush();
            r0 = new java.lang.StringBuilder();
            r0.append("mTotalSize: ");
            r0.append(r1.f969m);
            r0.append(", mCompletedSize: ");
            r0.append(r1.f968l);
            r0.append(", httpConn.getContentLength(): ");
            r0.append(r18.getContentLength());
            btmsdkobf.C0848ff.m907i(r6, r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x011e, code lost:
            if (r10 != r18.getContentLength()) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0120, code lost:
            r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0122, code lost:
            r0 = -7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0125, code lost:
            if (r8 == 0) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0127, code lost:
            btmsdkobf.C0848ff.m907i(r6, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012e, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012f, code lost:
            r3 = r0;
            btmsdkobf.C0848ff.m906e(r6, r16);
            r3.printStackTrace();
            r0 = -7000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014c, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x014d, code lost:
            r7 = r16;
            r13 = r13;
            r9 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0151, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0152, code lost:
            r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0155, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0156, code lost:
            r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0159, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x015a, code lost:
            r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x015d, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x015e, code lost:
            r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0161, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0162, code lost:
            r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x016a, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x016b, code lost:
            r9 = r2;
            r7 = r3;
            r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x016d, code lost:
            r2 = r8;
            r8 = r13;
            r9 = r9;
            r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0170, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0171, code lost:
            r9 = r2;
            r7 = r3;
            r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0173, code lost:
            r2 = r8;
            r8 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0176, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0177, code lost:
            r9 = r2;
            r7 = r3;
            r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0179, code lost:
            r2 = r8;
            r8 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x017d, code lost:
            r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r13v1
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
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0184 A[ExcHandler: FileNotFoundException (e java.io.FileNotFoundException), PHI: r2 r3 r8 
  PHI: (r2v12 ?) = (r2v21 ?), (r2v21 ?), (r2v21 ?), (r2v21 ?), (r2v0 ?) binds: {(r2v21 ?)=B:18:0x0067, (r2v21 ?)=B:19:?, (r2v21 ?)=B:34:0x008e, (r2v21 ?)=B:35:?, (r2v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r3v8 ?) = (r3v13 ?), (r3v13 ?), (r3v13 ?), (r3v13 ?), (r3v0 ?) binds: {(r3v13 ?)=B:18:0x0067, (r3v13 ?)=B:19:?, (r3v13 ?)=B:34:0x008e, (r3v13 ?)=B:35:?, (r3v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r8v8 ?) = (r8v21 ?), (r8v21 ?), (r8v21 ?), (r8v21 ?), (r8v0 ?) binds: {(r8v21 ?)=B:18:0x0067, (r8v21 ?)=B:19:?, (r8v21 ?)=B:34:0x008e, (r8v21 ?)=B:35:?, (r8v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE], Splitter:B:11:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0192 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:1:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01b1 A[Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x0041, all -> 0x0237 }, ExcHandler: IOException (e java.io.IOException), Splitter:B:1:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01c9 A[Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x0041, all -> 0x0237 }, ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:1:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01f4 A[Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x0041, all -> 0x0237 }, ExcHandler: SocketException (e java.net.SocketException), Splitter:B:1:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x021f A[Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x0041, all -> 0x0237 }, ExcHandler: FileNotFoundException (e java.io.FileNotFoundException), Splitter:B:1:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x016a A[ExcHandler: Exception (e java.lang.Exception), PHI: r2 r3 r8 
  PHI: (r2v20 ?) = (r2v21 ?), (r2v21 ?), (r2v21 ?), (r2v38 ?), (r2v40 ?) binds: {(r2v21 ?)=B:19:?, (r2v21 ?)=B:34:0x008e, (r2v21 ?)=B:35:?, (r2v38 ?)=B:11:0x004f, (r2v40 ?)=B:18:0x0067} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r3v12 ?) = (r3v13 ?), (r3v13 ?), (r3v13 ?), (r3v23 ?), (r3v24 ?) binds: {(r3v13 ?)=B:19:?, (r3v13 ?)=B:34:0x008e, (r3v13 ?)=B:35:?, (r3v23 ?)=B:11:0x004f, (r3v24 ?)=B:18:0x0067} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r8v20 ?) = (r8v21 ?), (r8v21 ?), (r8v21 ?), (r8v21 ?), (r8v0 ?) binds: {(r8v21 ?)=B:18:0x0067, (r8v21 ?)=B:19:?, (r8v21 ?)=B:34:0x008e, (r8v21 ?)=B:35:?, (r8v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE], Splitter:B:11:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0170 A[ExcHandler: IOException (e java.io.IOException), PHI: r2 r3 r8 
  PHI: (r2v18 ?) = (r2v21 ?), (r2v21 ?), (r2v21 ?), (r2v21 ?), (r2v0 ?) binds: {(r2v21 ?)=B:18:0x0067, (r2v21 ?)=B:19:?, (r2v21 ?)=B:34:0x008e, (r2v21 ?)=B:35:?, (r2v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r3v11 ?) = (r3v13 ?), (r3v13 ?), (r3v13 ?), (r3v13 ?), (r3v0 ?) binds: {(r3v13 ?)=B:18:0x0067, (r3v13 ?)=B:19:?, (r3v13 ?)=B:34:0x008e, (r3v13 ?)=B:35:?, (r3v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r8v17 ?) = (r8v21 ?), (r8v21 ?), (r8v21 ?), (r8v21 ?), (r8v0 ?) binds: {(r8v21 ?)=B:18:0x0067, (r8v21 ?)=B:19:?, (r8v21 ?)=B:34:0x008e, (r8v21 ?)=B:35:?, (r8v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE], Splitter:B:11:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0176 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), PHI: r2 r3 r8 
  PHI: (r2v16 ?) = (r2v21 ?), (r2v21 ?), (r2v21 ?), (r2v21 ?), (r2v0 ?) binds: {(r2v21 ?)=B:18:0x0067, (r2v21 ?)=B:19:?, (r2v21 ?)=B:34:0x008e, (r2v21 ?)=B:35:?, (r2v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r3v10 ?) = (r3v13 ?), (r3v13 ?), (r3v13 ?), (r3v13 ?), (r3v0 ?) binds: {(r3v13 ?)=B:18:0x0067, (r3v13 ?)=B:19:?, (r3v13 ?)=B:34:0x008e, (r3v13 ?)=B:35:?, (r3v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r8v14 ?) = (r8v21 ?), (r8v21 ?), (r8v21 ?), (r8v21 ?), (r8v0 ?) binds: {(r8v21 ?)=B:18:0x0067, (r8v21 ?)=B:19:?, (r8v21 ?)=B:34:0x008e, (r8v21 ?)=B:35:?, (r8v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE], Splitter:B:11:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x017d A[ExcHandler: SocketException (e java.net.SocketException), PHI: r2 r3 r8 
  PHI: (r2v14 ?) = (r2v21 ?), (r2v21 ?), (r2v21 ?), (r2v21 ?), (r2v0 ?) binds: {(r2v21 ?)=B:18:0x0067, (r2v21 ?)=B:19:?, (r2v21 ?)=B:34:0x008e, (r2v21 ?)=B:35:?, (r2v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r3v9 ?) = (r3v13 ?), (r3v13 ?), (r3v13 ?), (r3v13 ?), (r3v0 ?) binds: {(r3v13 ?)=B:18:0x0067, (r3v13 ?)=B:19:?, (r3v13 ?)=B:34:0x008e, (r3v13 ?)=B:35:?, (r3v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r8v11 ?) = (r8v21 ?), (r8v21 ?), (r8v21 ?), (r8v21 ?), (r8v0 ?) binds: {(r8v21 ?)=B:18:0x0067, (r8v21 ?)=B:19:?, (r8v21 ?)=B:34:0x008e, (r8v21 ?)=B:35:?, (r8v0 ?)=B:11:0x004f} A[DONT_GENERATE, DONT_INLINE], Splitter:B:11:0x004f] */
    /* JADX WARNING: Unknown variable types count: 83 */
    /* renamed from: a */
    private int m882a(java.net.HttpURLConnection r18, android.os.Bundle r19, boolean r20) {
        /*
        r17 = this;
        r1 = r17
        r0 = r19
        java.lang.String r2 = "fos close file error"
        java.lang.String r3 = "is close file error"
        java.lang.String r4 = "fos closing file"
        java.lang.String r5 = "is closing file"
        java.lang.String r6 = "HttpBase"
        r7 = 8192(0x2000, float:1.14794E-41)
        byte[] r7 = new byte[r7]
        r8 = 0
        int r9 = r18.getContentLength()     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        long r9 = (long) r9     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        long r11 = r1.f968l     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        long r9 = r9 + r11
        r1.f969m = r9     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        long r9 = r1.f968l     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        r11 = 100
        long r9 = r9 * r11
        long r13 = r1.f969m     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        long r9 = r9 / r13
        int r10 = (int) r9     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        java.io.File r9 = new java.io.File     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        java.lang.String r13 = r1.f962f     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        java.lang.String r14 = r1.f964h     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        r9.<init>(r13, r14)     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        boolean r13 = r9.exists()     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        if (r13 != 0) goto L_0x0047
        java.io.File r13 = r9.getParentFile()     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x0041 }
        r13.mkdirs()     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x0041 }
        r9.createNewFile()     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x0041 }
        goto L_0x0047
    L_0x0041:
        r0 = move-exception
        r9 = r2
        r7 = r3
        r13 = r8
        goto L_0x023a
    L_0x0047:
        java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        r14 = 1
        r13.<init>(r9, r14)     // Catch:{ FileNotFoundException -> 0x021f, SocketException -> 0x01f4, SocketTimeoutException -> 0x01c9, IOException -> 0x01b1, Exception -> 0x0192, all -> 0x018b }
        if (r20 == 0) goto L_0x005a
        java.util.zip.InflaterInputStream r9 = new java.util.zip.InflaterInputStream     // Catch:{ FileNotFoundException -> 0x0184, SocketException -> 0x017d, SocketTimeoutException -> 0x0176, IOException -> 0x0170, Exception -> 0x016a, all -> 0x0165 }
        java.io.InputStream r14 = r18.getInputStream()     // Catch:{ FileNotFoundException -> 0x0184, SocketException -> 0x017d, SocketTimeoutException -> 0x0176, IOException -> 0x0170, Exception -> 0x016a, all -> 0x0165 }
        r9.<init>(r14)     // Catch:{ FileNotFoundException -> 0x0184, SocketException -> 0x017d, SocketTimeoutException -> 0x0176, IOException -> 0x0170, Exception -> 0x016a, all -> 0x0165 }
        r8 = r9
        goto L_0x005e
    L_0x005a:
        java.io.InputStream r8 = r18.getInputStream()     // Catch:{ FileNotFoundException -> 0x0184, SocketException -> 0x017d, SocketTimeoutException -> 0x0176, IOException -> 0x0170, Exception -> 0x016a, all -> 0x0165 }
    L_0x005e:
        r14 = r10
        r10 = 0
    L_0x0060:
        int r15 = r8.read(r7)     // Catch:{ FileNotFoundException -> 0x0184, SocketException -> 0x017d, SocketTimeoutException -> 0x0176, IOException -> 0x0170, Exception -> 0x016a, all -> 0x0165 }
        r9 = -1
        if (r15 == r9) goto L_0x00e7
        boolean r9 = r1.f967k     // Catch:{ FileNotFoundException -> 0x0184, SocketException -> 0x017d, SocketTimeoutException -> 0x0176, IOException -> 0x0170, Exception -> 0x016a, all -> 0x00e1 }
        if (r9 == 0) goto L_0x008e
        r7 = -5003(0xffffffffffffec75, float:NaN)
        if (r8 == 0) goto L_0x007e
        btmsdkobf.C0848ff.m907i(r6, r5)
        r8.close()     // Catch:{ IOException -> 0x0076 }
        goto L_0x007e
    L_0x0076:
        r0 = move-exception
        r5 = r0
        btmsdkobf.C0848ff.m906e(r6, r3)
        r5.printStackTrace()
    L_0x007e:
        btmsdkobf.C0848ff.m907i(r6, r4)
        r13.close()     // Catch:{ IOException -> 0x0085 }
        goto L_0x008d
    L_0x0085:
        r0 = move-exception
        r3 = r0
        btmsdkobf.C0848ff.m906e(r6, r2)
        r3.printStackTrace()
    L_0x008d:
        return r7
    L_0x008e:
        long r11 = r1.f968l     // Catch:{ FileNotFoundException -> 0x0184, SocketException -> 0x017d, SocketTimeoutException -> 0x0176, IOException -> 0x0170, Exception -> 0x016a, all -> 0x00e1 }
        r9 = r2
        r16 = r3
        long r2 = (long) r15
        long r11 = r11 + r2
        r1.f968l = r11     // Catch:{ FileNotFoundException -> 0x00da, SocketException -> 0x00d3, SocketTimeoutException -> 0x00cc, IOException -> 0x00c5, Exception -> 0x00be, all -> 0x00b8 }
        int r10 = r10 + r15
        long r2 = r1.f968l     // Catch:{ FileNotFoundException -> 0x00da, SocketException -> 0x00d3, SocketTimeoutException -> 0x00cc, IOException -> 0x00c5, Exception -> 0x00be, all -> 0x00b8 }
        r11 = 100
        long r2 = r2 * r11
        long r11 = r1.f969m     // Catch:{ FileNotFoundException -> 0x00da, SocketException -> 0x00d3, SocketTimeoutException -> 0x00cc, IOException -> 0x00c5, Exception -> 0x00be, all -> 0x00b8 }
        long r2 = r2 / r11
        int r3 = (int) r2     // Catch:{ FileNotFoundException -> 0x00da, SocketException -> 0x00d3, SocketTimeoutException -> 0x00cc, IOException -> 0x00c5, Exception -> 0x00be, all -> 0x00b8 }
        if (r3 == r14) goto L_0x00ae
        java.lang.String r2 = "key_progress"
        r0.putInt(r2, r3)     // Catch:{ FileNotFoundException -> 0x00da, SocketException -> 0x00d3, SocketTimeoutException -> 0x00cc, IOException -> 0x00c5, Exception -> 0x00be, all -> 0x00b8 }
        r2 = 2
        r1.mo9186a(r2, r0)     // Catch:{ FileNotFoundException -> 0x00da, SocketException -> 0x00d3, SocketTimeoutException -> 0x00cc, IOException -> 0x00c5, Exception -> 0x00be, all -> 0x00b8 }
        r14 = r3
    L_0x00ae:
        r2 = 0
        r13.write(r7, r2, r15)     // Catch:{ FileNotFoundException -> 0x00da, SocketException -> 0x00d3, SocketTimeoutException -> 0x00cc, IOException -> 0x00c5, Exception -> 0x00be, all -> 0x00b8 }
        r2 = r9
        r3 = r16
        r11 = 100
        goto L_0x0060
    L_0x00b8:
        r0 = move-exception
        r2 = r0
        r7 = r16
        goto L_0x023b
    L_0x00be:
        r0 = move-exception
        r2 = r8
        r8 = r13
        r7 = r16
        goto L_0x0196
    L_0x00c5:
        r0 = move-exception
        r2 = r8
        r8 = r13
        r7 = r16
        goto L_0x01b5
    L_0x00cc:
        r0 = move-exception
        r2 = r8
        r8 = r13
        r7 = r16
        goto L_0x01cd
    L_0x00d3:
        r0 = move-exception
        r2 = r8
        r8 = r13
        r7 = r16
        goto L_0x01f8
    L_0x00da:
        r0 = move-exception
        r2 = r8
        r8 = r13
        r7 = r16
        goto L_0x0223
    L_0x00e1:
        r0 = move-exception
        r9 = r2
        r2 = r0
        r7 = r3
        goto L_0x023b
    L_0x00e7:
        r9 = r2
        r16 = r3
        r2 = 0
        r13.flush()     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        r0.<init>()     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        java.lang.String r3 = "mTotalSize: "
        r0.append(r3)     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        long r11 = r1.f969m     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        r0.append(r11)     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        java.lang.String r3 = ", mCompletedSize: "
        r0.append(r3)     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        long r11 = r1.f968l     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        r0.append(r11)     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        java.lang.String r3 = ", httpConn.getContentLength(): "
        r0.append(r3)     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        int r3 = r18.getContentLength()     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        r0.append(r3)     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        java.lang.String r0 = r0.toString()     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        btmsdkobf.C0848ff.m907i(r6, r0)     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        int r0 = r18.getContentLength()     // Catch:{ FileNotFoundException -> 0x0161, SocketException -> 0x015d, SocketTimeoutException -> 0x0159, IOException -> 0x0155, Exception -> 0x0151, all -> 0x014c }
        if (r10 != r0) goto L_0x0122
        r0 = 0
        goto L_0x0123
    L_0x0122:
        r0 = -7
    L_0x0123:
        r2 = -7000(0xffffffffffffe4a8, float:NaN)
        if (r8 == 0) goto L_0x013a
        btmsdkobf.C0848ff.m907i(r6, r5)
        r8.close()     // Catch:{ IOException -> 0x012e }
        goto L_0x013a
    L_0x012e:
        r0 = move-exception
        r3 = r0
        r7 = r16
        btmsdkobf.C0848ff.m906e(r6, r7)
        r3.printStackTrace()
        r0 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x013a:
        btmsdkobf.C0848ff.m907i(r6, r4)
        r13.close()     // Catch:{ IOException -> 0x0141 }
        goto L_0x014b
    L_0x0141:
        r0 = move-exception
        r3 = r0
        btmsdkobf.C0848ff.m906e(r6, r9)
        r3.printStackTrace()
        r0 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x014b:
        return r0
    L_0x014c:
        r0 = move-exception
        r7 = r16
        goto L_0x023a
    L_0x0151:
        r0 = move-exception
        r7 = r16
        goto L_0x016d
    L_0x0155:
        r0 = move-exception
        r7 = r16
        goto L_0x0173
    L_0x0159:
        r0 = move-exception
        r7 = r16
        goto L_0x0179
    L_0x015d:
        r0 = move-exception
        r7 = r16
        goto L_0x0180
    L_0x0161:
        r0 = move-exception
        r7 = r16
        goto L_0x0187
    L_0x0165:
        r0 = move-exception
        r9 = r2
        r7 = r3
        goto L_0x023a
    L_0x016a:
        r0 = move-exception
        r9 = r2
        r7 = r3
    L_0x016d:
        r2 = r8
        r8 = r13
        goto L_0x0196
    L_0x0170:
        r0 = move-exception
        r9 = r2
        r7 = r3
    L_0x0173:
        r2 = r8
        r8 = r13
        goto L_0x01b5
    L_0x0176:
        r0 = move-exception
        r9 = r2
        r7 = r3
    L_0x0179:
        r2 = r8
        r8 = r13
        goto L_0x01cd
    L_0x017d:
        r0 = move-exception
        r9 = r2
        r7 = r3
    L_0x0180:
        r2 = r8
        r8 = r13
        goto L_0x01f8
    L_0x0184:
        r0 = move-exception
        r9 = r2
        r7 = r3
    L_0x0187:
        r2 = r8
        r8 = r13
        goto L_0x0223
    L_0x018b:
        r0 = move-exception
        r9 = r2
        r7 = r3
        r2 = r0
        r13 = r8
        goto L_0x023b
    L_0x0192:
        r0 = move-exception
        r9 = r2
        r7 = r3
        r2 = r8
    L_0x0196:
        r3 = -5000(0xffffffffffffec78, float:NaN)
        java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x0237 }
        btmsdkobf.C0848ff.m906e(r6, r10)     // Catch:{ all -> 0x0237 }
        java.lang.String r10 = "receive data error"
        btmsdkobf.C0848ff.m906e(r6, r10)     // Catch:{ all -> 0x0237 }
        r0.printStackTrace()     // Catch:{ all -> 0x0237 }
        btmsdkobf.cs r10 = new btmsdkobf.cs     // Catch:{ all -> 0x0237 }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0237 }
        r10.m40608init(r3, r0)     // Catch:{ all -> 0x0237 }
        throw r10     // Catch:{ all -> 0x0237 }
    L_0x01b1:
        r0 = move-exception
        r9 = r2
        r7 = r3
        r2 = r8
    L_0x01b5:
        r3 = -5056(0xffffffffffffec40, float:NaN)
        java.lang.String r10 = "socket or file io error"
        btmsdkobf.C0848ff.m906e(r6, r10)     // Catch:{ all -> 0x0237 }
        r0.printStackTrace()     // Catch:{ all -> 0x0237 }
        btmsdkobf.cs r10 = new btmsdkobf.cs     // Catch:{ all -> 0x0237 }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0237 }
        r10.m40608init(r3, r0)     // Catch:{ all -> 0x0237 }
        throw r10     // Catch:{ all -> 0x0237 }
    L_0x01c9:
        r0 = move-exception
        r9 = r2
        r7 = r3
        r2 = r8
    L_0x01cd:
        r3 = -5055(0xffffffffffffec41, float:NaN)
        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0237 }
        r10.<init>()     // Catch:{ all -> 0x0237 }
        java.lang.String r11 = "socket timeout error:"
        r10.append(r11)     // Catch:{ all -> 0x0237 }
        java.lang.String r11 = r0.getMessage()     // Catch:{ all -> 0x0237 }
        r10.append(r11)     // Catch:{ all -> 0x0237 }
        java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0237 }
        btmsdkobf.C0848ff.m906e(r6, r10)     // Catch:{ all -> 0x0237 }
        r0.printStackTrace()     // Catch:{ all -> 0x0237 }
        btmsdkobf.cs r10 = new btmsdkobf.cs     // Catch:{ all -> 0x0237 }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0237 }
        r10.m40608init(r3, r0)     // Catch:{ all -> 0x0237 }
        throw r10     // Catch:{ all -> 0x0237 }
    L_0x01f4:
        r0 = move-exception
        r9 = r2
        r7 = r3
        r2 = r8
    L_0x01f8:
        r3 = -5054(0xffffffffffffec42, float:NaN)
        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0237 }
        r10.<init>()     // Catch:{ all -> 0x0237 }
        java.lang.String r11 = "socket error:"
        r10.append(r11)     // Catch:{ all -> 0x0237 }
        java.lang.String r11 = r0.getMessage()     // Catch:{ all -> 0x0237 }
        r10.append(r11)     // Catch:{ all -> 0x0237 }
        java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0237 }
        btmsdkobf.C0848ff.m906e(r6, r10)     // Catch:{ all -> 0x0237 }
        r0.printStackTrace()     // Catch:{ all -> 0x0237 }
        btmsdkobf.cs r10 = new btmsdkobf.cs     // Catch:{ all -> 0x0237 }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0237 }
        r10.m40608init(r3, r0)     // Catch:{ all -> 0x0237 }
        throw r10     // Catch:{ all -> 0x0237 }
    L_0x021f:
        r0 = move-exception
        r9 = r2
        r7 = r3
        r2 = r8
    L_0x0223:
        r3 = -7001(0xffffffffffffe4a7, float:NaN)
        java.lang.String r10 = "file not found"
        btmsdkobf.C0848ff.m906e(r6, r10)     // Catch:{ all -> 0x0237 }
        r0.printStackTrace()     // Catch:{ all -> 0x0237 }
        btmsdkobf.cs r10 = new btmsdkobf.cs     // Catch:{ all -> 0x0237 }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0237 }
        r10.m40608init(r3, r0)     // Catch:{ all -> 0x0237 }
        throw r10     // Catch:{ all -> 0x0237 }
    L_0x0237:
        r0 = move-exception
        r13 = r8
        r8 = r2
    L_0x023a:
        r2 = r0
    L_0x023b:
        if (r8 == 0) goto L_0x024c
        btmsdkobf.C0848ff.m907i(r6, r5)
        r8.close()     // Catch:{ IOException -> 0x0244 }
        goto L_0x024c
    L_0x0244:
        r0 = move-exception
        r3 = r0
        btmsdkobf.C0848ff.m906e(r6, r7)
        r3.printStackTrace()
    L_0x024c:
        if (r13 == 0) goto L_0x025d
        btmsdkobf.C0848ff.m907i(r6, r4)
        r13.close()     // Catch:{ IOException -> 0x0255 }
        goto L_0x025d
    L_0x0255:
        r0 = move-exception
        r3 = r0
        btmsdkobf.C0848ff.m906e(r6, r9)
        r3.printStackTrace()
    L_0x025d:
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0837f.m882a(java.net.HttpURLConnection, android.os.Bundle, boolean):int");
    }

    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r9v0, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v5, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v8, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r9v8, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* JADX WARNING: type inference failed for: r7v15 */
    /* JADX WARNING: type inference failed for: r7v16, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r9v13, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r9v14, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r7v23, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r7v24 */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r7v25 */
    /* JADX WARNING: type inference failed for: r7v26 */
    /* JADX WARNING: type inference failed for: r9v20 */
    /* JADX WARNING: type inference failed for: r9v21 */
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
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0163 A[SYNTHETIC, Splitter:B:83:0x0163] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0170 A[SYNTHETIC, Splitter:B:88:0x0170] */
    /* JADX WARNING: Unknown variable types count: 15 */
    /* renamed from: a */
    private int m883a(boolean r13) {
        /*
        r12 = this;
        java.lang.String r0 = "fosclose file error"
        java.lang.String r1 = "fis close file error"
        java.lang.String r2 = "HttpBase"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = r12.f962f
        r3.append(r4)
        java.lang.String r4 = java.io.File.separator
        r3.append(r4)
        java.lang.String r4 = r12.f964h
        r3.append(r4)
        java.lang.String r3 = r3.toString()
        java.lang.String r4 = "HttpGetFile"
        btmsdkobf.C0848ff.m907i(r4, r3)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r5 = r12.f963g
        r3.append(r5)
        java.lang.String r5 = java.io.File.separator
        r3.append(r5)
        java.lang.String r5 = r12.f965i
        r3.append(r5)
        java.lang.String r3 = r3.toString()
        btmsdkobf.C0848ff.m907i(r4, r3)
        r3 = -7001(0xffffffffffffe4a7, float:NaN)
        r4 = -7000(0xffffffffffffe4a8, float:NaN)
        r5 = 0
        java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0132, Exception -> 0x011d, all -> 0x0119 }
        java.lang.String r7 = r12.f962f     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0132, Exception -> 0x011d, all -> 0x0119 }
        java.lang.String r8 = r12.f964h     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0132, Exception -> 0x011d, all -> 0x0119 }
        r6.<init>(r7, r8)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0132, Exception -> 0x011d, all -> 0x0119 }
        boolean r7 = r6.exists()     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        r8 = 0
        if (r7 == 0) goto L_0x00e2
        int r7 = r12.f966j     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        r9 = 1
        if (r7 != r9) goto L_0x0076
        android.content.Context r7 = r12.mContext     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        java.io.File r7 = r7.getFilesDir()     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        java.lang.String r9 = r12.f963g     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        boolean r7 = r7.equals(r9)     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        if (r7 == 0) goto L_0x0076
        android.content.Context r7 = r12.mContext     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        java.lang.String r9 = r12.f965i     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        int r10 = r12.f966j     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        java.io.FileOutputStream r7 = r7.openFileOutput(r9, r10)     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        r9 = r7
        goto L_0x00b1
    L_0x0076:
        java.io.File r7 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        r9.<init>()     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        java.lang.String r10 = r12.f963g     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        r9.append(r10)     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        java.lang.String r10 = java.io.File.separator     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        r9.append(r10)     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        java.lang.String r10 = r12.f965i     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        r9.append(r10)     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        java.lang.String r9 = r9.toString()     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        r7.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        boolean r9 = r7.exists()     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        if (r9 == 0) goto L_0x00a2
        r7.delete()     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        r9.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        goto L_0x00b1
    L_0x00a2:
        java.io.File r9 = r7.getParentFile()     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        r9.mkdirs()     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        r7.createNewFile()     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
        r9.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0116, IOException -> 0x0113, Exception -> 0x0110, all -> 0x010d }
    L_0x00b1:
        java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00d8, Exception -> 0x00d4, all -> 0x00d1 }
        r7.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00d8, Exception -> 0x00d4, all -> 0x00d1 }
        r5 = 1024(0x400, float:1.435E-42)
        byte[] r5 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x00cf, IOException -> 0x00cd, Exception -> 0x00cb, all -> 0x00c8 }
    L_0x00ba:
        int r10 = r7.read(r5)     // Catch:{ FileNotFoundException -> 0x00cf, IOException -> 0x00cd, Exception -> 0x00cb, all -> 0x00c8 }
        r11 = -1
        if (r10 == r11) goto L_0x00c5
        r9.write(r5, r8, r10)     // Catch:{ FileNotFoundException -> 0x00cf, IOException -> 0x00cd, Exception -> 0x00cb, all -> 0x00c8 }
        goto L_0x00ba
    L_0x00c5:
        r5 = r7
        r3 = 0
        goto L_0x00e3
    L_0x00c8:
        r3 = move-exception
        goto L_0x0160
    L_0x00cb:
        r3 = move-exception
        goto L_0x00d6
    L_0x00cd:
        r3 = move-exception
        goto L_0x00da
    L_0x00cf:
        r4 = move-exception
        goto L_0x00df
    L_0x00d1:
        r3 = move-exception
        goto L_0x0161
    L_0x00d4:
        r3 = move-exception
        r7 = r5
    L_0x00d6:
        r5 = r9
        goto L_0x0120
    L_0x00d8:
        r3 = move-exception
        r7 = r5
    L_0x00da:
        r5 = r9
        goto L_0x0135
    L_0x00dd:
        r4 = move-exception
        r7 = r5
    L_0x00df:
        r5 = r9
        goto L_0x014c
    L_0x00e2:
        r9 = r5
    L_0x00e3:
        if (r5 == 0) goto L_0x00f2
        r5.close()     // Catch:{ IOException -> 0x00e9 }
        goto L_0x00f2
    L_0x00e9:
        r3 = move-exception
        btmsdkobf.C0848ff.m906e(r2, r1)
        r3.printStackTrace()
        r3 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x00f2:
        if (r9 == 0) goto L_0x0101
        r9.close()     // Catch:{ IOException -> 0x00f8 }
        goto L_0x0101
    L_0x00f8:
        r1 = move-exception
        btmsdkobf.C0848ff.m906e(r2, r0)
        r1.printStackTrace()
        r3 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x0101:
        if (r13 == 0) goto L_0x010c
        boolean r13 = r6.exists()
        if (r13 == 0) goto L_0x010c
        r6.delete()
    L_0x010c:
        return r3
    L_0x010d:
        r3 = move-exception
        r9 = r5
        goto L_0x0161
    L_0x0110:
        r3 = move-exception
        r7 = r5
        goto L_0x0120
    L_0x0113:
        r3 = move-exception
        r7 = r5
        goto L_0x0135
    L_0x0116:
        r4 = move-exception
        r7 = r5
        goto L_0x014c
    L_0x0119:
        r3 = move-exception
        r6 = r5
        r9 = r6
        goto L_0x0161
    L_0x011d:
        r3 = move-exception
        r6 = r5
        r7 = r6
    L_0x0120:
        java.lang.String r8 = "file op error"
        btmsdkobf.C0848ff.m906e(r2, r8)     // Catch:{ all -> 0x015e }
        r3.printStackTrace()     // Catch:{ all -> 0x015e }
        btmsdkobf.cs r8 = new btmsdkobf.cs     // Catch:{ all -> 0x015e }
        java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x015e }
        r8.m40608init(r4, r3)     // Catch:{ all -> 0x015e }
        throw r8     // Catch:{ all -> 0x015e }
    L_0x0132:
        r3 = move-exception
        r6 = r5
        r7 = r6
    L_0x0135:
        r4 = -7056(0xffffffffffffe470, float:NaN)
        java.lang.String r8 = "file io error"
        btmsdkobf.C0848ff.m906e(r2, r8)     // Catch:{ all -> 0x015e }
        r3.printStackTrace()     // Catch:{ all -> 0x015e }
        btmsdkobf.cs r8 = new btmsdkobf.cs     // Catch:{ all -> 0x015e }
        java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x015e }
        r8.m40608init(r4, r3)     // Catch:{ all -> 0x015e }
        throw r8     // Catch:{ all -> 0x015e }
    L_0x0149:
        r4 = move-exception
        r6 = r5
        r7 = r6
    L_0x014c:
        java.lang.String r8 = "file not found"
        btmsdkobf.C0848ff.m906e(r2, r8)     // Catch:{ all -> 0x015e }
        r4.printStackTrace()     // Catch:{ all -> 0x015e }
        btmsdkobf.cs r8 = new btmsdkobf.cs     // Catch:{ all -> 0x015e }
        java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x015e }
        r8.m40608init(r3, r4)     // Catch:{ all -> 0x015e }
        throw r8     // Catch:{ all -> 0x015e }
    L_0x015e:
        r3 = move-exception
        r9 = r5
    L_0x0160:
        r5 = r7
    L_0x0161:
        if (r5 == 0) goto L_0x016e
        r5.close()     // Catch:{ IOException -> 0x0167 }
        goto L_0x016e
    L_0x0167:
        r4 = move-exception
        btmsdkobf.C0848ff.m906e(r2, r1)
        r4.printStackTrace()
    L_0x016e:
        if (r9 == 0) goto L_0x017b
        r9.close()     // Catch:{ IOException -> 0x0174 }
        goto L_0x017b
    L_0x0174:
        r1 = move-exception
        btmsdkobf.C0848ff.m906e(r2, r0)
        r1.printStackTrace()
    L_0x017b:
        if (r13 == 0) goto L_0x0188
        if (r6 == 0) goto L_0x0188
        boolean r13 = r6.exists()
        if (r13 == 0) goto L_0x0188
        r6.delete()
    L_0x0188:
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0837f.m883a(boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01f3, code lost:
            r5 = r13;
            r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f7, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01f8, code lost:
            r5 = r13;
            r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01fc, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01fd, code lost:
            r5 = r13;
            r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0222, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0223, code lost:
            r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0225, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0226, code lost:
            r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x022d, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x022e, code lost:
            r3 = r6;
            r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0251, code lost:
            r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x028a, code lost:
            r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0292, code lost:
            r11.putInt(r9, r13);
            r11.putString(r8, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02af, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02b0, code lost:
            r3 = r6;
            r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02d5, code lost:
            r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02df, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02e0, code lost:
            r3 = r6;
            r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0305, code lost:
            r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0309, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x030a, code lost:
            r3 = r6;
            r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x032f, code lost:
            r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0339, code lost:
            r14.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:?, code lost:
            return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e0, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e1, code lost:
            r2 = r0;
            r5 = r13;
            r12 = r14;
            r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f0, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f1, code lost:
            r2 = r0;
            r5 = r13;
            r12 = r14;
            r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f8, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f9, code lost:
            r2 = r0;
            r5 = r13;
            r12 = r14;
            r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0100, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0101, code lost:
            r2 = r0;
            r5 = r13;
            r12 = r14;
            r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0185, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0186, code lost:
            r2 = r0;
            r5 = r13;
            r3 = r17;
            r13 = -7000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x018e, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018f, code lost:
            r2 = r0;
            r5 = r13;
            r12 = r14;
            r3 = r17;
            r13 = -7000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0198, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0199, code lost:
            r5 = r13;
            r12 = r14;
            r3 = r17;
            r13 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01d2, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01d3, code lost:
            r5 = r13;
            r3 = r17;
            r13 = r2;
            r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01da, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01db, code lost:
            r5 = r13;
            r3 = r17;
            r13 = r2;
            r12 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01e0, code lost:
            r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e8, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e9, code lost:
            r5 = r13;
            r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01f2, code lost:
            r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01f7 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:52:0x010b] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01fc A[ExcHandler: SocketException (e java.net.SocketException), Splitter:B:52:0x010b] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0225 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x022d A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02af A[ExcHandler: IOException (r0v3 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:1:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02df A[ExcHandler: SocketTimeoutException (r0v2 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:1:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0309 A[ExcHandler: SocketException (r0v1 'e' java.net.SocketException A[CUSTOM_DECLARE]), Splitter:B:1:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:189:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e0 A[ExcHandler: Exception (r0v38 'e' java.lang.Exception A[CUSTOM_DECLARE]), PHI: r13 r17 
  PHI: (r13v35 java.lang.String) = (r13v24 java.lang.String), (r13v24 java.lang.String), (r13v24 java.lang.String), (r13v24 java.lang.String), (r13v37 java.lang.String), (r13v37 java.lang.String) binds: {(r13v24 java.lang.String)=B:65:0x0144, (r13v24 java.lang.String)=B:66:?, (r13v24 java.lang.String)=B:69:0x0164, (r13v24 java.lang.String)=B:70:?, (r13v37 java.lang.String)=B:37:0x00c5, (r13v37 java.lang.String)=B:38:?} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r17v6 java.lang.String) = (r17v1 java.lang.String), (r17v1 java.lang.String), (r17v1 java.lang.String), (r17v1 java.lang.String), (r17v7 java.lang.String), (r17v7 java.lang.String) binds: {(r17v1 java.lang.String)=B:65:0x0144, (r17v1 java.lang.String)=B:66:?, (r17v1 java.lang.String)=B:69:0x0164, (r17v1 java.lang.String)=B:70:?, (r17v7 java.lang.String)=B:37:0x00c5, (r17v7 java.lang.String)=B:38:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:37:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f0 A[ExcHandler: IOException (r0v37 'e' java.io.IOException A[CUSTOM_DECLARE]), PHI: r13 r17 
  PHI: (r13v34 java.lang.String) = (r13v24 java.lang.String), (r13v24 java.lang.String), (r13v24 java.lang.String), (r13v24 java.lang.String), (r13v37 java.lang.String), (r13v37 java.lang.String) binds: {(r13v24 java.lang.String)=B:65:0x0144, (r13v24 java.lang.String)=B:66:?, (r13v24 java.lang.String)=B:69:0x0164, (r13v24 java.lang.String)=B:70:?, (r13v37 java.lang.String)=B:37:0x00c5, (r13v37 java.lang.String)=B:38:?} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r17v5 java.lang.String) = (r17v1 java.lang.String), (r17v1 java.lang.String), (r17v1 java.lang.String), (r17v1 java.lang.String), (r17v7 java.lang.String), (r17v7 java.lang.String) binds: {(r17v1 java.lang.String)=B:65:0x0144, (r17v1 java.lang.String)=B:66:?, (r17v1 java.lang.String)=B:69:0x0164, (r17v1 java.lang.String)=B:70:?, (r17v7 java.lang.String)=B:37:0x00c5, (r17v7 java.lang.String)=B:38:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:37:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f8 A[ExcHandler: SocketTimeoutException (r0v36 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), PHI: r13 r17 
  PHI: (r13v33 java.lang.String) = (r13v24 java.lang.String), (r13v24 java.lang.String), (r13v24 java.lang.String), (r13v24 java.lang.String), (r13v37 java.lang.String), (r13v37 java.lang.String) binds: {(r13v24 java.lang.String)=B:65:0x0144, (r13v24 java.lang.String)=B:66:?, (r13v24 java.lang.String)=B:69:0x0164, (r13v24 java.lang.String)=B:70:?, (r13v37 java.lang.String)=B:37:0x00c5, (r13v37 java.lang.String)=B:38:?} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r17v4 java.lang.String) = (r17v1 java.lang.String), (r17v1 java.lang.String), (r17v1 java.lang.String), (r17v1 java.lang.String), (r17v7 java.lang.String), (r17v7 java.lang.String) binds: {(r17v1 java.lang.String)=B:65:0x0144, (r17v1 java.lang.String)=B:66:?, (r17v1 java.lang.String)=B:69:0x0164, (r17v1 java.lang.String)=B:70:?, (r17v7 java.lang.String)=B:37:0x00c5, (r17v7 java.lang.String)=B:38:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:37:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0100 A[ExcHandler: SocketException (r0v35 'e' java.net.SocketException A[CUSTOM_DECLARE]), PHI: r13 r17 
  PHI: (r13v32 java.lang.String) = (r13v24 java.lang.String), (r13v24 java.lang.String), (r13v24 java.lang.String), (r13v24 java.lang.String), (r13v37 java.lang.String), (r13v37 java.lang.String) binds: {(r13v24 java.lang.String)=B:65:0x0144, (r13v24 java.lang.String)=B:66:?, (r13v24 java.lang.String)=B:69:0x0164, (r13v24 java.lang.String)=B:70:?, (r13v37 java.lang.String)=B:37:0x00c5, (r13v37 java.lang.String)=B:38:?} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r17v3 java.lang.String) = (r17v1 java.lang.String), (r17v1 java.lang.String), (r17v1 java.lang.String), (r17v1 java.lang.String), (r17v7 java.lang.String), (r17v7 java.lang.String) binds: {(r17v1 java.lang.String)=B:65:0x0144, (r17v1 java.lang.String)=B:66:?, (r17v1 java.lang.String)=B:69:0x0164, (r17v1 java.lang.String)=B:70:?, (r17v7 java.lang.String)=B:37:0x00c5, (r17v7 java.lang.String)=B:38:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:37:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d2 A[ExcHandler: all (r0v30 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r2 
  PHI: (r2v43 int) = (r2v41 int), (r2v46 int), (r2v41 int), (r2v41 int) binds: {(r2v41 int)=B:77:0x019f, (r2v46 int)=B:78:?, (r2v41 int)=B:65:0x0144, (r2v41 int)=B:66:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:65:0x0144] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01e8 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:52:0x010b] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01f2 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:52:0x010b] */
    /* renamed from: a */
    public int mo9534a(java.lang.String r19, java.lang.String r20, boolean r21, btmsdkobf.C0837f.C0838a r22) {
        /*
        r18 = this;
        r1 = r18
        r2 = r20
        r3 = r22
        java.lang.String r4 = "HttpBase"
        java.lang.String r5 = "key_downType"
        java.lang.String r6 = "key_total"
        java.lang.String r7 = "key_downSize"
        java.lang.String r8 = "key_errorMsg"
        java.lang.String r9 = "key_errcode"
        java.lang.String r10 = ""
        android.os.Bundle r11 = new android.os.Bundle
        r11.<init>()
        r12 = 0
        r15 = 1
        boolean r14 = r1.f967k     // Catch:{ SocketException -> 0x0309, SocketTimeoutException -> 0x02df, IOException -> 0x02af, cs -> 0x0279, Exception -> 0x022d, all -> 0x0225 }
        r16 = -3003(0xfffffffffffff445, float:NaN)
        if (r14 == 0) goto L_0x0029
        r13 = r5
        r17 = r6
        r14 = r12
    L_0x0025:
        r2 = -3003(0xfffffffffffff445, float:NaN)
        goto L_0x01a7
    L_0x0029:
        java.net.URL r14 = new java.net.URL     // Catch:{ SocketException -> 0x0309, SocketTimeoutException -> 0x02df, IOException -> 0x02af, cs -> 0x0222, Exception -> 0x022d, all -> 0x0225 }
        r14.<init>(r2)     // Catch:{ SocketException -> 0x0309, SocketTimeoutException -> 0x02df, IOException -> 0x02af, cs -> 0x0222, Exception -> 0x022d, all -> 0x0225 }
        java.net.URLConnection r14 = r14.openConnection()     // Catch:{ SocketException -> 0x0309, SocketTimeoutException -> 0x02df, IOException -> 0x02af, cs -> 0x0222, Exception -> 0x022d, all -> 0x0225 }
        java.net.HttpURLConnection r14 = (java.net.HttpURLConnection) r14     // Catch:{ SocketException -> 0x0309, SocketTimeoutException -> 0x02df, IOException -> 0x02af, cs -> 0x0222, Exception -> 0x022d, all -> 0x0225 }
        r13 = 10000(0x2710, float:1.4013E-41)
        r14.setConnectTimeout(r13)     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        r13 = 20000(0x4e20, float:2.8026E-41)
        r14.setReadTimeout(r13)     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        r14.setInstanceFollowRedirects(r15)     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        java.lang.String r13 = "GET"
        r14.setRequestMethod(r13)     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        boolean r13 = android.text.TextUtils.isEmpty(r19)     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        if (r13 != 0) goto L_0x004f
        r2 = r19
        goto L_0x0053
    L_0x004f:
        java.lang.String r2 = btmsdkobf.C0834ey.m875j(r2, r12)     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
    L_0x0053:
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        r12.<init>()     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        r12.append(r2)     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        java.lang.String r13 = ".tmp"
        r12.append(r13)     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        java.lang.String r12 = r12.toString()     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        r1.f964h = r12     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        r12.<init>()     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        java.lang.String r13 = "mTempName: "
        r12.append(r13)     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        java.lang.String r13 = r1.f964h     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        r12.append(r13)     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        java.lang.String r12 = r12.toString()     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        btmsdkobf.C0848ff.m907i(r4, r12)     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        java.lang.String r12 = r1.f965i     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        if (r12 != 0) goto L_0x00a1
        r1.f965i = r2     // Catch:{ SocketException -> 0x009c, SocketTimeoutException -> 0x0097, IOException -> 0x0092, cs -> 0x008d, Exception -> 0x0088, all -> 0x0083 }
        goto L_0x00a1
    L_0x0083:
        r0 = move-exception
        r2 = r0
        r3 = r6
        goto L_0x0229
    L_0x0088:
        r0 = move-exception
        r2 = r0
        r3 = r6
        goto L_0x0208
    L_0x008d:
        r0 = move-exception
        r2 = r0
        r3 = r6
        goto L_0x020d
    L_0x0092:
        r0 = move-exception
        r2 = r0
        r3 = r6
        goto L_0x0213
    L_0x0097:
        r0 = move-exception
        r2 = r0
        r3 = r6
        goto L_0x0219
    L_0x009c:
        r0 = move-exception
        r2 = r0
        r3 = r6
        goto L_0x021f
    L_0x00a1:
        java.io.File r2 = new java.io.File     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        java.lang.String r12 = r1.f962f     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        java.lang.String r13 = r1.f964h     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        r2.<init>(r12, r13)     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        boolean r12 = r2.exists()     // Catch:{ SocketException -> 0x021c, SocketTimeoutException -> 0x0216, IOException -> 0x0210, cs -> 0x020a, Exception -> 0x0205, all -> 0x0201 }
        if (r12 == 0) goto L_0x0108
        long r12 = r2.length()     // Catch:{ SocketException -> 0x009c, SocketTimeoutException -> 0x0097, IOException -> 0x0092, cs -> 0x008d, Exception -> 0x0088, all -> 0x0083 }
        r1.f968l = r12     // Catch:{ SocketException -> 0x009c, SocketTimeoutException -> 0x0097, IOException -> 0x0092, cs -> 0x008d, Exception -> 0x0088, all -> 0x0083 }
        java.lang.String r2 = "RANGE"
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x009c, SocketTimeoutException -> 0x0097, IOException -> 0x0092, cs -> 0x008d, Exception -> 0x0088, all -> 0x0083 }
        r12.<init>()     // Catch:{ SocketException -> 0x009c, SocketTimeoutException -> 0x0097, IOException -> 0x0092, cs -> 0x008d, Exception -> 0x0088, all -> 0x0083 }
        java.lang.String r13 = "bytes="
        r12.append(r13)     // Catch:{ SocketException -> 0x009c, SocketTimeoutException -> 0x0097, IOException -> 0x0092, cs -> 0x008d, Exception -> 0x0088, all -> 0x0083 }
        r13 = r5
        r17 = r6
        long r5 = r1.f968l     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x00e8, Exception -> 0x00e0, all -> 0x00d9 }
        r12.append(r5)     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x00e8, Exception -> 0x00e0, all -> 0x00d9 }
        java.lang.String r5 = "-"
        r12.append(r5)     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x00e8, Exception -> 0x00e0, all -> 0x00d9 }
        java.lang.String r5 = r12.toString()     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x00e8, Exception -> 0x00e0, all -> 0x00d9 }
        r14.setRequestProperty(r2, r5)     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x00e8, Exception -> 0x00e0, all -> 0x00d9 }
        r1.f970n = r15     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x00e8, Exception -> 0x00e0, all -> 0x00d9 }
        goto L_0x010b
    L_0x00d9:
        r0 = move-exception
        r2 = r0
        r5 = r13
        r3 = r17
        goto L_0x0229
    L_0x00e0:
        r0 = move-exception
        r2 = r0
        r5 = r13
        r12 = r14
        r3 = r17
        goto L_0x0230
    L_0x00e8:
        r0 = move-exception
        r2 = r0
        r5 = r13
        r12 = r14
        r3 = r17
        goto L_0x027e
    L_0x00f0:
        r0 = move-exception
        r2 = r0
        r5 = r13
        r12 = r14
        r3 = r17
        goto L_0x02b2
    L_0x00f8:
        r0 = move-exception
        r2 = r0
        r5 = r13
        r12 = r14
        r3 = r17
        goto L_0x02e2
    L_0x0100:
        r0 = move-exception
        r2 = r0
        r5 = r13
        r12 = r14
        r3 = r17
        goto L_0x030c
    L_0x0108:
        r13 = r5
        r17 = r6
    L_0x010b:
        int r2 = r14.getResponseCode()     // Catch:{ SocketException -> 0x01fc, SocketTimeoutException -> 0x01f7, IOException -> 0x01f2, cs -> 0x01ed, Exception -> 0x01e8, all -> 0x01e3 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x01fc, SocketTimeoutException -> 0x01f7, IOException -> 0x01f2, cs -> 0x01ed, Exception -> 0x01e8, all -> 0x01e3 }
        r5.<init>()     // Catch:{ SocketException -> 0x01fc, SocketTimeoutException -> 0x01f7, IOException -> 0x01f2, cs -> 0x01ed, Exception -> 0x01e8, all -> 0x01e3 }
        java.lang.String r6 = "statusCode == "
        r5.append(r6)     // Catch:{ SocketException -> 0x01fc, SocketTimeoutException -> 0x01f7, IOException -> 0x01f2, cs -> 0x01ed, Exception -> 0x01e8, all -> 0x01e3 }
        r5.append(r2)     // Catch:{ SocketException -> 0x01fc, SocketTimeoutException -> 0x01f7, IOException -> 0x01f2, cs -> 0x01ed, Exception -> 0x01e8, all -> 0x01e3 }
        java.lang.String r5 = r5.toString()     // Catch:{ SocketException -> 0x01fc, SocketTimeoutException -> 0x01f7, IOException -> 0x01f2, cs -> 0x01ed, Exception -> 0x01e8, all -> 0x01e3 }
        btmsdkobf.C0848ff.m907i(r4, r5)     // Catch:{ SocketException -> 0x01fc, SocketTimeoutException -> 0x01f7, IOException -> 0x01f2, cs -> 0x01ed, Exception -> 0x01e8, all -> 0x01e3 }
        r5 = 200(0xc8, float:2.8E-43)
        if (r2 == r5) goto L_0x0131
        r5 = 206(0xce, float:2.89E-43)
        if (r2 == r5) goto L_0x0131
        r5 = -3000(0xfffffffffffff448, float:NaN)
        int r2 = -3000 - r2
        goto L_0x01a7
    L_0x0131:
        boolean r2 = r1.f967k     // Catch:{ SocketException -> 0x01fc, SocketTimeoutException -> 0x01f7, IOException -> 0x01f2, cs -> 0x01ed, Exception -> 0x01e8, all -> 0x01e3 }
        if (r2 == 0) goto L_0x0137
        goto L_0x0025
    L_0x0137:
        r2 = r21
        int r2 = r1.m882a(r14, r11, r2)     // Catch:{ SocketException -> 0x01fc, SocketTimeoutException -> 0x01f7, IOException -> 0x01f2, cs -> 0x01ed, Exception -> 0x01e8, all -> 0x01e3 }
        if (r2 == 0) goto L_0x0142
        r5 = -7
        goto L_0x01a7
    L_0x0142:
        if (r3 == 0) goto L_0x019f
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x0198, Exception -> 0x00e0, all -> 0x01d2 }
        r5.<init>()     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x0198, Exception -> 0x00e0, all -> 0x01d2 }
        java.lang.String r6 = r1.f962f     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x0198, Exception -> 0x00e0, all -> 0x01d2 }
        r5.append(r6)     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x0198, Exception -> 0x00e0, all -> 0x01d2 }
        java.lang.String r6 = java.io.File.separator     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x0198, Exception -> 0x00e0, all -> 0x01d2 }
        r5.append(r6)     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x0198, Exception -> 0x00e0, all -> 0x01d2 }
        java.lang.String r6 = r1.f964h     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x0198, Exception -> 0x00e0, all -> 0x01d2 }
        r5.append(r6)     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x0198, Exception -> 0x00e0, all -> 0x01d2 }
        java.lang.String r5 = r5.toString()     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x0198, Exception -> 0x00e0, all -> 0x01d2 }
        boolean r3 = r3.mo9537d(r5)     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x0198, Exception -> 0x00e0, all -> 0x01d2 }
        if (r3 != 0) goto L_0x019f
        r2 = -7000(0xffffffffffffe4a8, float:NaN)
        java.io.File r3 = new java.io.File     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x018e, Exception -> 0x00e0, all -> 0x0185 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x018e, Exception -> 0x00e0, all -> 0x0185 }
        r5.<init>()     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x018e, Exception -> 0x00e0, all -> 0x0185 }
        java.lang.String r6 = r1.f962f     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x018e, Exception -> 0x00e0, all -> 0x0185 }
        r5.append(r6)     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x018e, Exception -> 0x00e0, all -> 0x0185 }
        java.lang.String r6 = java.io.File.separator     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x018e, Exception -> 0x00e0, all -> 0x0185 }
        r5.append(r6)     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x018e, Exception -> 0x00e0, all -> 0x0185 }
        java.lang.String r6 = r1.f964h     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x018e, Exception -> 0x00e0, all -> 0x0185 }
        r5.append(r6)     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x018e, Exception -> 0x00e0, all -> 0x0185 }
        java.lang.String r5 = r5.toString()     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x018e, Exception -> 0x00e0, all -> 0x0185 }
        r3.<init>(r5)     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x018e, Exception -> 0x00e0, all -> 0x0185 }
        r3.delete()     // Catch:{ SocketException -> 0x0100, SocketTimeoutException -> 0x00f8, IOException -> 0x00f0, cs -> 0x018e, Exception -> 0x00e0, all -> 0x0185 }
        goto L_0x01a7
    L_0x0185:
        r0 = move-exception
        r2 = r0
        r5 = r13
        r3 = r17
        r13 = -7000(0xffffffffffffe4a8, float:NaN)
        goto L_0x0337
    L_0x018e:
        r0 = move-exception
        r2 = r0
        r5 = r13
        r12 = r14
        r3 = r17
        r13 = -7000(0xffffffffffffe4a8, float:NaN)
        goto L_0x0280
    L_0x0198:
        r0 = move-exception
        r5 = r13
        r12 = r14
        r3 = r17
        r13 = r2
        goto L_0x01e0
    L_0x019f:
        int r2 = r1.m883a(r15)     // Catch:{ SocketException -> 0x01fc, SocketTimeoutException -> 0x01f7, IOException -> 0x01f2, cs -> 0x01da, Exception -> 0x01e8, all -> 0x01d2 }
        if (r2 == 0) goto L_0x01a6
        goto L_0x01a7
    L_0x01a6:
        r2 = 0
    L_0x01a7:
        if (r14 == 0) goto L_0x01ac
        r14.disconnect()
    L_0x01ac:
        if (r2 == 0) goto L_0x01cf
        r3 = -7
        if (r2 == r3) goto L_0x01cf
        r11.putInt(r9, r2)
        r11.putString(r8, r10)
        long r3 = r1.f968l
        int r4 = (int) r3
        r11.putInt(r7, r4)
        long r3 = r1.f969m
        int r4 = (int) r3
        r3 = r17
        r11.putInt(r3, r4)
        boolean r3 = r1.f970n
        byte r3 = (byte) r3
        r5 = r13
        r11.putByte(r5, r3)
        r1.mo9186a(r15, r11)
    L_0x01cf:
        r13 = r2
        goto L_0x0333
    L_0x01d2:
        r0 = move-exception
        r5 = r13
        r3 = r17
        r13 = r2
        r2 = r0
        goto L_0x0337
    L_0x01da:
        r0 = move-exception
        r5 = r13
        r3 = r17
        r13 = r2
        r12 = r14
    L_0x01e0:
        r2 = r0
        goto L_0x0280
    L_0x01e3:
        r0 = move-exception
        r5 = r13
        r3 = r17
        goto L_0x0203
    L_0x01e8:
        r0 = move-exception
        r5 = r13
        r3 = r17
        goto L_0x0207
    L_0x01ed:
        r0 = move-exception
        r5 = r13
        r3 = r17
        goto L_0x020c
    L_0x01f2:
        r0 = move-exception
        r5 = r13
        r3 = r17
        goto L_0x0212
    L_0x01f7:
        r0 = move-exception
        r5 = r13
        r3 = r17
        goto L_0x0218
    L_0x01fc:
        r0 = move-exception
        r5 = r13
        r3 = r17
        goto L_0x021e
    L_0x0201:
        r0 = move-exception
        r3 = r6
    L_0x0203:
        r2 = r0
        goto L_0x0229
    L_0x0205:
        r0 = move-exception
        r3 = r6
    L_0x0207:
        r2 = r0
    L_0x0208:
        r12 = r14
        goto L_0x0230
    L_0x020a:
        r0 = move-exception
        r3 = r6
    L_0x020c:
        r2 = r0
    L_0x020d:
        r12 = r14
        goto L_0x027e
    L_0x0210:
        r0 = move-exception
        r3 = r6
    L_0x0212:
        r2 = r0
    L_0x0213:
        r12 = r14
        goto L_0x02b2
    L_0x0216:
        r0 = move-exception
        r3 = r6
    L_0x0218:
        r2 = r0
    L_0x0219:
        r12 = r14
        goto L_0x02e2
    L_0x021c:
        r0 = move-exception
        r3 = r6
    L_0x021e:
        r2 = r0
    L_0x021f:
        r12 = r14
        goto L_0x030c
    L_0x0222:
        r0 = move-exception
        r3 = r6
        goto L_0x027d
    L_0x0225:
        r0 = move-exception
        r3 = r6
    L_0x0227:
        r2 = r0
        r14 = r12
    L_0x0229:
        r13 = -3000(0xfffffffffffff448, float:NaN)
        goto L_0x0337
    L_0x022d:
        r0 = move-exception
        r3 = r6
        r2 = r0
    L_0x0230:
        java.lang.String r10 = r2.getMessage()     // Catch:{ all -> 0x0275 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0275 }
        r6.<init>()     // Catch:{ all -> 0x0275 }
        java.lang.String r13 = "get error:"
        r6.append(r13)     // Catch:{ all -> 0x0275 }
        java.lang.String r13 = r2.getMessage()     // Catch:{ all -> 0x0275 }
        r6.append(r13)     // Catch:{ all -> 0x0275 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0275 }
        btmsdkobf.C0848ff.m906e(r4, r6)     // Catch:{ all -> 0x0275 }
        r2.printStackTrace()     // Catch:{ all -> 0x0275 }
        if (r12 == 0) goto L_0x0254
        r12.disconnect()
    L_0x0254:
        r2 = -3000(0xfffffffffffff448, float:NaN)
        r11.putInt(r9, r2)
        r11.putString(r8, r10)
        long r8 = r1.f968l
        int r4 = (int) r8
        r11.putInt(r7, r4)
        long r6 = r1.f969m
        int r4 = (int) r6
        r11.putInt(r3, r4)
        boolean r3 = r1.f970n
        byte r3 = (byte) r3
        r11.putByte(r5, r3)
        r1.mo9186a(r15, r11)
        r13 = -3000(0xfffffffffffff448, float:NaN)
        goto L_0x0333
    L_0x0275:
        r0 = move-exception
        r2 = -3000(0xfffffffffffff448, float:NaN)
        goto L_0x0227
    L_0x0279:
        r0 = move-exception
        r3 = r6
        r2 = -3000(0xfffffffffffff448, float:NaN)
    L_0x027d:
        r2 = r0
    L_0x027e:
        r13 = -3000(0xfffffffffffff448, float:NaN)
    L_0x0280:
        int r13 = r2.mo9189U()     // Catch:{ all -> 0x0334 }
        java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0334 }
        if (r12 == 0) goto L_0x028d
        r12.disconnect()
    L_0x028d:
        if (r13 == 0) goto L_0x0333
        r4 = -7
        if (r13 == r4) goto L_0x0333
        r11.putInt(r9, r13)
        r11.putString(r8, r2)
    L_0x0298:
        long r8 = r1.f968l
        int r2 = (int) r8
        r11.putInt(r7, r2)
        long r6 = r1.f969m
        int r2 = (int) r6
        r11.putInt(r3, r2)
        boolean r2 = r1.f970n
        byte r2 = (byte) r2
        r11.putByte(r5, r2)
        r1.mo9186a(r15, r11)
        goto L_0x0333
    L_0x02af:
        r0 = move-exception
        r3 = r6
        r2 = r0
    L_0x02b2:
        r13 = -3056(0xfffffffffffff410, float:NaN)
        java.lang.String r10 = r2.getMessage()     // Catch:{ all -> 0x0334 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0334 }
        r6.<init>()     // Catch:{ all -> 0x0334 }
        java.lang.String r14 = "io error:"
        r6.append(r14)     // Catch:{ all -> 0x0334 }
        java.lang.String r14 = r2.getMessage()     // Catch:{ all -> 0x0334 }
        r6.append(r14)     // Catch:{ all -> 0x0334 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0334 }
        btmsdkobf.C0848ff.m906e(r4, r6)     // Catch:{ all -> 0x0334 }
        r2.printStackTrace()     // Catch:{ all -> 0x0334 }
        if (r12 == 0) goto L_0x02d8
        r12.disconnect()
    L_0x02d8:
        r11.putInt(r9, r13)
        r11.putString(r8, r10)
        goto L_0x0298
    L_0x02df:
        r0 = move-exception
        r3 = r6
        r2 = r0
    L_0x02e2:
        r13 = -3055(0xfffffffffffff411, float:NaN)
        java.lang.String r10 = r2.getMessage()     // Catch:{ all -> 0x0334 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0334 }
        r6.<init>()     // Catch:{ all -> 0x0334 }
        java.lang.String r14 = "socket timeout error:"
        r6.append(r14)     // Catch:{ all -> 0x0334 }
        java.lang.String r14 = r2.getMessage()     // Catch:{ all -> 0x0334 }
        r6.append(r14)     // Catch:{ all -> 0x0334 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0334 }
        btmsdkobf.C0848ff.m906e(r4, r6)     // Catch:{ all -> 0x0334 }
        r2.printStackTrace()     // Catch:{ all -> 0x0334 }
        if (r12 == 0) goto L_0x02d8
        r12.disconnect()
        goto L_0x02d8
    L_0x0309:
        r0 = move-exception
        r3 = r6
        r2 = r0
    L_0x030c:
        r13 = -3054(0xfffffffffffff412, float:NaN)
        java.lang.String r10 = r2.getMessage()     // Catch:{ all -> 0x0334 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0334 }
        r6.<init>()     // Catch:{ all -> 0x0334 }
        java.lang.String r14 = "socket error:"
        r6.append(r14)     // Catch:{ all -> 0x0334 }
        java.lang.String r14 = r2.getMessage()     // Catch:{ all -> 0x0334 }
        r6.append(r14)     // Catch:{ all -> 0x0334 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0334 }
        btmsdkobf.C0848ff.m906e(r4, r6)     // Catch:{ all -> 0x0334 }
        r2.printStackTrace()     // Catch:{ all -> 0x0334 }
        if (r12 == 0) goto L_0x02d8
        r12.disconnect()
        goto L_0x02d8
    L_0x0333:
        return r13
    L_0x0334:
        r0 = move-exception
        r2 = r0
        r14 = r12
    L_0x0337:
        if (r14 == 0) goto L_0x033c
        r14.disconnect()
    L_0x033c:
        if (r13 == 0) goto L_0x035c
        r4 = -7
        if (r13 == r4) goto L_0x035c
        r11.putInt(r9, r13)
        r11.putString(r8, r10)
        long r8 = r1.f968l
        int r4 = (int) r8
        r11.putInt(r7, r4)
        long r6 = r1.f969m
        int r4 = (int) r6
        r11.putInt(r3, r4)
        boolean r3 = r1.f970n
        byte r3 = (byte) r3
        r11.putByte(r5, r3)
        r1.mo9186a(r15, r11)
    L_0x035c:
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0837f.mo9534a(java.lang.String, java.lang.String, boolean, btmsdkobf.f$a):int");
    }

    /* renamed from: b */
    public void mo9535b(String str) {
        this.f963g = str;
    }

    /* renamed from: c */
    public void mo9536c(String str) {
        this.f965i = str;
    }
}
