package com.yanzhenjie.permission.p633a;

import android.content.Context;
import android.media.AudioRecord;

/* renamed from: com.yanzhenjie.permission.a.n */
class RecordAudioTest implements PermissionTest {
    /* renamed from: a */
    private static final int[] f26626a = {8000, 11025, 22050, 44100};
    /* renamed from: b */
    private Context f26627b;

    RecordAudioTest(Context context) {
        this.f26627b = context;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:41|40|46|47|48|(2:50|51)|(1:56)|(1:58)|59) */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ba, code lost:
            r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00bb, code lost:
            if (r0 != 0) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ca, code lost:
            r4.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00cd, code lost:
            if (r9 != 0) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00cf, code lost:
            r9.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00d2, code lost:
            throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x009b */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a4 A[SYNTHETIC, Splitter:B:50:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b6 A[DONT_GENERATE] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: a */
    public boolean mo38007a() throws java.lang.Throwable {
        /*
        r12 = this;
        r0 = 0
        r1 = 1
        int[] r2 = m33963b()     // Catch:{ all -> 0x0099 }
        if (r2 != 0) goto L_0x0010
        android.content.Context r2 = r12.f26627b     // Catch:{ all -> 0x0099 }
        boolean r0 = m33962a(r2)     // Catch:{ all -> 0x0099 }
        r0 = r0 ^ r1
        return r0
    L_0x0010:
        android.media.AudioRecord r9 = new android.media.AudioRecord     // Catch:{ all -> 0x0099 }
        r4 = 1
        r10 = 0
        r5 = r2[r10]     // Catch:{ all -> 0x0099 }
        r6 = r2[r1]     // Catch:{ all -> 0x0099 }
        r3 = 2
        r7 = r2[r3]     // Catch:{ all -> 0x0099 }
        r11 = 3
        r8 = r2[r11]     // Catch:{ all -> 0x0099 }
        r3 = r9
        r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0099 }
        int r3 = r9.getState()     // Catch:{ all -> 0x0097 }
        if (r3 == r1) goto L_0x0033
        android.content.Context r2 = r12.f26627b     // Catch:{ all -> 0x0097 }
        boolean r0 = m33962a(r2)     // Catch:{ all -> 0x0097 }
        r0 = r0 ^ r1
        r9.release()
        return r0
    L_0x0033:
        int r3 = r9.getRecordingState()     // Catch:{ all -> 0x0097 }
        if (r3 == r1) goto L_0x003d
        r9.release()
        return r1
    L_0x003d:
        r9.startRecording()     // Catch:{ all -> 0x0097 }
        int r3 = r9.getRecordingState()     // Catch:{ all -> 0x0097 }
        if (r3 == r11) goto L_0x004a
        r9.release()
        return r1
    L_0x004a:
        java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0097 }
        android.content.Context r4 = r12.f26627b     // Catch:{ all -> 0x0097 }
        java.io.File r4 = r4.getCacheDir()     // Catch:{ all -> 0x0097 }
        java.lang.String r5 = "_andpermission_audio_record_test_"
        r3.<init>(r4, r5)     // Catch:{ all -> 0x0097 }
        r3.mkdirs()     // Catch:{ all -> 0x0097 }
        java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0097 }
        long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0097 }
        java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ all -> 0x0097 }
        r4.<init>(r3, r5)     // Catch:{ all -> 0x0097 }
        boolean r3 = r4.exists()     // Catch:{ all -> 0x009b }
        if (r3 == 0) goto L_0x0070
        r4.createNewFile()     // Catch:{ all -> 0x009b }
    L_0x0070:
        java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x009b }
        r3.<init>(r4)     // Catch:{ all -> 0x009b }
        r0 = r2[r11]     // Catch:{ all -> 0x0095 }
        byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0095 }
        r2 = r2[r11]     // Catch:{ all -> 0x0095 }
        int r2 = r9.read(r0, r10, r2)     // Catch:{ all -> 0x0095 }
        r3.write(r0, r10, r2)     // Catch:{ all -> 0x0095 }
        r3.flush()     // Catch:{ all -> 0x0095 }
        r3.close()     // Catch:{ IOException -> 0x0088 }
    L_0x0088:
        boolean r0 = r4.exists()
        if (r0 == 0) goto L_0x0091
        r4.delete()
    L_0x0091:
        r9.release()
        return r1
    L_0x0095:
        r0 = r3
        goto L_0x009b
    L_0x0097:
        r4 = r0
        goto L_0x009b
    L_0x0099:
        r4 = r0
        r9 = r4
    L_0x009b:
        android.content.Context r2 = r12.f26627b     // Catch:{ all -> 0x00ba }
        boolean r2 = m33962a(r2)     // Catch:{ all -> 0x00ba }
        r1 = r1 ^ r2
        if (r0 == 0) goto L_0x00a9
        r0.close()     // Catch:{ IOException -> 0x00a8 }
        goto L_0x00a9
    L_0x00a9:
        if (r4 == 0) goto L_0x00b4
        boolean r0 = r4.exists()
        if (r0 == 0) goto L_0x00b4
        r4.delete()
    L_0x00b4:
        if (r9 == 0) goto L_0x00b9
        r9.release()
    L_0x00b9:
        return r1
    L_0x00ba:
        r1 = move-exception
        if (r0 == 0) goto L_0x00c2
        r0.close()     // Catch:{ IOException -> 0x00c1 }
        goto L_0x00c2
    L_0x00c2:
        if (r4 == 0) goto L_0x00cd
        boolean r0 = r4.exists()
        if (r0 == 0) goto L_0x00cd
        r4.delete()
    L_0x00cd:
        if (r9 == 0) goto L_0x00d2
        r9.release()
    L_0x00d2:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.permission.p633a.RecordAudioTest.mo38007a():boolean");
    }

    /* renamed from: a */
    public static boolean m33962a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.microphone");
    }

    /* renamed from: b */
    public static int[] m33963b() {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        for (int i : f26626a) {
            for (int i2 : new int[]{16, 12}) {
                for (int i3 : new int[]{3, 2}) {
                    int minBufferSize = AudioRecord.getMinBufferSize(i, i2, i3);
                    if (minBufferSize != -2) {
                        return new int[]{i, i2, i3, minBufferSize};
                    }
                }
            }
        }
        return null;
    }
}
