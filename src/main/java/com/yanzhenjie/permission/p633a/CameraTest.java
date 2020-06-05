package com.yanzhenjie.permission.p633a;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

/* renamed from: com.yanzhenjie.permission.a.e */
class CameraTest implements PermissionTest {
    /* renamed from: b */
    private static final PreviewCallback f26617b = new PreviewCallback() {
        public void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    };
    /* renamed from: a */
    private Context f26618a;

    CameraTest(Context context) {
        this.f26618a = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|15|(1:17)|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
            return true ^ r5.f26618a.getPackageManager().hasSystemFeature("android.hardware.camera");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
            if (r2 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
            r2.stopPreview();
            r2.setPreviewCallback(null);
            r2.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
            throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002a */
    /* renamed from: a */
    public boolean mo38007a() throws java.lang.Throwable {
        /*
        r5 = this;
        r0 = 1
        r1 = 0
        int r2 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ all -> 0x0029 }
        if (r2 > 0) goto L_0x0009
        return r0
    L_0x0009:
        int r2 = r2 - r0
        android.hardware.Camera r2 = android.hardware.Camera.open(r2)     // Catch:{ all -> 0x0029 }
        android.hardware.Camera$Parameters r3 = r2.getParameters()     // Catch:{ all -> 0x002a }
        r2.setParameters(r3)     // Catch:{ all -> 0x002a }
        android.hardware.Camera$PreviewCallback r3 = f26617b     // Catch:{ all -> 0x002a }
        r2.setPreviewCallback(r3)     // Catch:{ all -> 0x002a }
        r2.startPreview()     // Catch:{ all -> 0x002a }
        if (r2 == 0) goto L_0x0028
        r2.stopPreview()
        r2.setPreviewCallback(r1)
        r2.release()
    L_0x0028:
        return r0
    L_0x0029:
        r2 = r1
    L_0x002a:
        android.content.Context r3 = r5.f26618a     // Catch:{ all -> 0x0043 }
        android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ all -> 0x0043 }
        java.lang.String r4 = "android.hardware.camera"
        boolean r3 = r3.hasSystemFeature(r4)     // Catch:{ all -> 0x0043 }
        r0 = r0 ^ r3
        if (r2 == 0) goto L_0x0042
        r2.stopPreview()
        r2.setPreviewCallback(r1)
        r2.release()
    L_0x0042:
        return r0
    L_0x0043:
        r0 = move-exception
        if (r2 == 0) goto L_0x004f
        r2.stopPreview()
        r2.setPreviewCallback(r1)
        r2.release()
    L_0x004f:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.permission.p633a.CameraTest.mo38007a():boolean");
    }
}
