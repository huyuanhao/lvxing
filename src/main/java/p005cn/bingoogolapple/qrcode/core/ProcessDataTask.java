package p005cn.bingoogolapple.qrcode.core;

import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* renamed from: cn.bingoogolapple.qrcode.core.c */
class ProcessDataTask extends AsyncTask<Void, Void, ScanResult> {
    /* renamed from: g */
    private static long f1195g;
    /* renamed from: a */
    private Camera f1196a;
    /* renamed from: b */
    private byte[] f1197b;
    /* renamed from: c */
    private boolean f1198c;
    /* renamed from: d */
    private String f1199d;
    /* renamed from: e */
    private Bitmap f1200e;
    /* renamed from: f */
    private WeakReference<QRCodeView> f1201f;

    ProcessDataTask(Camera camera, byte[] bArr, QRCodeView qRCodeView, boolean z) {
        this.f1196a = camera;
        this.f1197b = bArr;
        this.f1201f = new WeakReference<>(qRCodeView);
        this.f1198c = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ProcessDataTask mo9720a() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
        this.f1201f.clear();
        this.f1200e = null;
        this.f1197b = null;
    }

    /* JADX WARNING: type inference failed for: r13v0, types: [cn.bingoogolapple.qrcode.core.QRCodeView] */
    /* JADX WARNING: type inference failed for: r13v1, types: [cn.bingoogolapple.qrcode.core.QRCodeView] */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r13v5, types: [cn.bingoogolapple.qrcode.core.d] */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: type inference failed for: r13v8 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=cn.bingoogolapple.qrcode.core.QRCodeView, code=null, for r13v0, types: [cn.bingoogolapple.qrcode.core.QRCodeView] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r13v4
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
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    private p005cn.bingoogolapple.qrcode.core.ScanResult m1047a(? r13) {
        /*
        r12 = this;
        byte[] r0 = r12.f1197b
        r1 = 0
        if (r0 != 0) goto L_0x0006
        return r1
    L_0x0006:
        r2 = 1
        r3 = 0
        android.hardware.Camera r4 = r12.f1196a     // Catch:{ Exception -> 0x004c }
        android.hardware.Camera$Parameters r4 = r4.getParameters()     // Catch:{ Exception -> 0x004c }
        android.hardware.Camera$Size r4 = r4.getPreviewSize()     // Catch:{ Exception -> 0x004c }
        int r5 = r4.width     // Catch:{ Exception -> 0x004c }
        int r4 = r4.height     // Catch:{ Exception -> 0x0048 }
        boolean r6 = r12.f1198c     // Catch:{ Exception -> 0x0046 }
        if (r6 == 0) goto L_0x0039
        byte[] r6 = r12.f1197b     // Catch:{ Exception -> 0x0046 }
        int r6 = r6.length     // Catch:{ Exception -> 0x0046 }
        byte[] r0 = new byte[r6]     // Catch:{ Exception -> 0x0046 }
        r6 = 0
    L_0x0020:
        if (r6 >= r4) goto L_0x003c
        r7 = 0
    L_0x0023:
        if (r7 >= r5) goto L_0x0036
        int r8 = r7 * r4
        int r8 = r8 + r4
        int r8 = r8 - r6
        int r8 = r8 - r2
        byte[] r9 = r12.f1197b     // Catch:{ Exception -> 0x0046 }
        int r10 = r6 * r5
        int r10 = r10 + r7
        byte r9 = r9[r10]     // Catch:{ Exception -> 0x0046 }
        r0[r8] = r9     // Catch:{ Exception -> 0x0046 }
        int r7 = r7 + 1
        goto L_0x0023
    L_0x0036:
        int r6 = r6 + 1
        goto L_0x0020
    L_0x0039:
        r11 = r5
        r5 = r4
        r4 = r11
    L_0x003c:
        cn.bingoogolapple.qrcode.core.d r13 = r13.mo9627a(r0, r4, r5, r3)     // Catch:{ Exception -> 0x0041 }
        return r13
    L_0x0041:
        r3 = move-exception
        r11 = r5
        r5 = r4
        r4 = r11
        goto L_0x0050
    L_0x0046:
        r3 = move-exception
        goto L_0x0050
    L_0x0048:
        r4 = move-exception
        r3 = r4
        r4 = 0
        goto L_0x0050
    L_0x004c:
        r4 = move-exception
        r3 = r4
        r4 = 0
        r5 = 0
    L_0x0050:
        r3.printStackTrace()
        if (r5 == 0) goto L_0x0065
        if (r4 == 0) goto L_0x0065
        java.lang.String r3 = "识别失败重试"
        p005cn.bingoogolapple.qrcode.core.BGAQRCodeUtil.m1028a(r3)     // Catch:{ Exception -> 0x0061 }
        cn.bingoogolapple.qrcode.core.d r13 = r13.mo9627a(r0, r5, r4, r2)     // Catch:{ Exception -> 0x0061 }
        return r13
    L_0x0061:
        r13 = move-exception
        r13.printStackTrace()
    L_0x0065:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cn.bingoogolapple.qrcode.core.ProcessDataTask.m1047a(cn.bingoogolapple.qrcode.core.QRCodeView):cn.bingoogolapple.qrcode.core.d");
    }

    /* access modifiers changed from: protected|varargs */
    /* renamed from: a */
    public ScanResult doInBackground(Void... voidArr) {
        QRCodeView qRCodeView = (QRCodeView) this.f1201f.get();
        if (qRCodeView == null) {
            return null;
        }
        String str = this.f1199d;
        if (str != null) {
            return qRCodeView.mo9626a(BGAQRCodeUtil.m1036c(str));
        }
        Bitmap bitmap = this.f1200e;
        if (bitmap != null) {
            ScanResult a = qRCodeView.mo9626a(bitmap);
            this.f1200e = null;
            return a;
        }
        if (BGAQRCodeUtil.m1029a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("两次任务执行的时间间隔：");
            sb.append(System.currentTimeMillis() - f1195g);
            BGAQRCodeUtil.m1028a(sb.toString());
            f1195g = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ScanResult a2 = m1047a(qRCodeView);
        if (BGAQRCodeUtil.m1029a()) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (a2 == null || TextUtils.isEmpty(a2.f1202a)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("识别失败时间为：");
                sb2.append(currentTimeMillis2);
                BGAQRCodeUtil.m1034b(sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("识别成功时间为：");
                sb3.append(currentTimeMillis2);
                BGAQRCodeUtil.m1028a(sb3.toString());
            }
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(ScanResult dVar) {
        QRCodeView qRCodeView = (QRCodeView) this.f1201f.get();
        if (qRCodeView != null) {
            if (this.f1199d == null && this.f1200e == null) {
                qRCodeView.mo9630a(dVar);
            } else {
                this.f1200e = null;
                qRCodeView.mo9632b(dVar);
            }
        }
    }
}
