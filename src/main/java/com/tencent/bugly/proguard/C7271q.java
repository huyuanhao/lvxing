package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.C7124a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C7127a;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import java.io.File;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.q */
public class C7271q {
    /* renamed from: a */
    public static C7271q f24601a = new C7271q();
    /* renamed from: b */
    public BetaGrayStrategy f24602b;
    /* renamed from: c */
    public DownloadTask f24603c;
    /* renamed from: d */
    public final Handler f24604d = new Handler(Looper.getMainLooper());
    /* renamed from: e */
    private DownloadListener f24605e = new C7124a(4, this, Integer.valueOf(0));

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b5, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b7, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo34960a(int r3, com.tencent.bugly.proguard.C7282y r4, boolean r5) {
        /*
        r2 = this;
        monitor-enter(r2)
        r0 = 0
        r2.f24603c = r0     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r4 = r2.mo34959a(r4)     // Catch:{ all -> 0x00b8 }
        r2.f24602b = r4     // Catch:{ all -> 0x00b8 }
        if (r3 != 0) goto L_0x00b6
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r3 = r2.f24602b     // Catch:{ all -> 0x00b8 }
        if (r3 != 0) goto L_0x0012
        goto L_0x00b6
    L_0x0012:
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r3 = r2.f24602b     // Catch:{ all -> 0x00b8 }
        if (r3 == 0) goto L_0x00b4
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r3 = r2.f24602b     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.proguard.y r3 = r3.f23818a     // Catch:{ all -> 0x00b8 }
        if (r3 == 0) goto L_0x00b4
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r3 = r2.f24602b     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.proguard.y r3 = r3.f23818a     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.proguard.u r3 = r3.f24658f     // Catch:{ all -> 0x00b8 }
        if (r3 == 0) goto L_0x00b4
        com.tencent.bugly.beta.global.e r3 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x00b8 }
        java.io.File r3 = r3.f23705G     // Catch:{ all -> 0x00b8 }
        if (r3 == 0) goto L_0x0089
        boolean r4 = r3.exists()     // Catch:{ all -> 0x00b8 }
        if (r4 == 0) goto L_0x0089
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r4 = r2.f24602b     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.proguard.y r4 = r4.f23818a     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.proguard.u r4 = r4.f24658f     // Catch:{ all -> 0x00b8 }
        java.lang.String r4 = r4.f24617a     // Catch:{ all -> 0x00b8 }
        java.lang.String r0 = "SHA"
        boolean r4 = com.tencent.bugly.beta.global.C7127a.m30551a(r3, r4, r0)     // Catch:{ all -> 0x00b8 }
        if (r4 == 0) goto L_0x0089
        java.lang.String r4 = "patch has downloaded!"
        r5 = 0
        java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.proguard.C7226an.m31141a(r4, r0)     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x00b8 }
        boolean r4 = r4.f23712N     // Catch:{ all -> 0x00b8 }
        if (r4 != 0) goto L_0x0087
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x00b8 }
        int r4 = r4.f23713O     // Catch:{ all -> 0x00b8 }
        r0 = 3
        if (r4 > r0) goto L_0x0087
        java.lang.String r4 = "patch has downloaded but not patched execute patch!"
        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.proguard.C7226an.m31141a(r4, r5)     // Catch:{ all -> 0x00b8 }
        java.lang.String r4 = "PATCH_MAX_TIMES"
        com.tencent.bugly.beta.global.e r5 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x00b8 }
        int r0 = r5.f23713O     // Catch:{ all -> 0x00b8 }
        int r1 = r0 + 1
        r5.f23713O = r1     // Catch:{ all -> 0x00b8 }
        java.lang.String r5 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.beta.global.C7127a.m30547a(r4, r5)     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x00b8 }
        java.io.File r4 = r4.f23706H     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.beta.global.C7127a.m30550a(r3, r4)     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.beta.tinker.TinkerManager r3 = com.tencent.bugly.beta.tinker.TinkerManager.getInstance()     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x00b8 }
        java.io.File r4 = r4.f23706H     // Catch:{ all -> 0x00b8 }
        java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.beta.global.e r5 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x00b8 }
        boolean r5 = r5.f23720V     // Catch:{ all -> 0x00b8 }
        r3.onDownloadSuccess(r4, r5)     // Catch:{ all -> 0x00b8 }
    L_0x0087:
        monitor-exit(r2)
        return
    L_0x0089:
        com.tencent.bugly.beta.global.e r3 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.beta.interfaces.BetaPatchListener r3 = r3.f23721W     // Catch:{ all -> 0x00b8 }
        if (r3 == 0) goto L_0x00a3
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r3 = r2.f24602b     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.proguard.y r3 = r3.f23818a     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.proguard.u r3 = r3.mo34982b()     // Catch:{ all -> 0x00b8 }
        if (r3 == 0) goto L_0x00a3
        android.os.Handler r4 = r2.f24604d     // Catch:{ all -> 0x00b8 }
        com.tencent.bugly.proguard.q$1 r0 = new com.tencent.bugly.proguard.q$1     // Catch:{ all -> 0x00b8 }
        r0.m52614init(r3)     // Catch:{ all -> 0x00b8 }
        r4.post(r0)     // Catch:{ all -> 0x00b8 }
    L_0x00a3:
        com.tencent.bugly.beta.global.e r3 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x00b8 }
        boolean r3 = r3.f23723Y     // Catch:{ all -> 0x00b8 }
        if (r3 != 0) goto L_0x00ab
        if (r5 == 0) goto L_0x00b4
    L_0x00ab:
        com.tencent.bugly.beta.global.e r3 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x00b8 }
        boolean r3 = r3.f23724Z     // Catch:{ all -> 0x00b8 }
        if (r3 == 0) goto L_0x00b4
        r2.m31416a()     // Catch:{ all -> 0x00b8 }
    L_0x00b4:
        monitor-exit(r2)
        return
    L_0x00b6:
        monitor-exit(r2)
        return
    L_0x00b8:
        r3 = move-exception
        monitor-exit(r2)
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7271q.mo34960a(int, com.tencent.bugly.proguard.y, boolean):void");
    }

    /* renamed from: a */
    public BetaGrayStrategy mo34959a(C7282y yVar) {
        char c;
        boolean z;
        C7282y yVar2 = yVar;
        String str = "st.bch";
        BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) C7127a.m30544a(str, BetaGrayStrategy.CREATOR);
        if (betaGrayStrategy == null || betaGrayStrategy.f23818a == null) {
            C7127a.m30552a(str);
            betaGrayStrategy = null;
        }
        String str2 = "delete patchFile";
        String str3 = "delete tmpPatchFile";
        if (yVar2 != null) {
            if (yVar2.f24666n != 1 && betaGrayStrategy != null && !TextUtils.isEmpty(betaGrayStrategy.f23818a.f24665m) && TextUtils.equals(yVar2.f24665m, betaGrayStrategy.f23818a.f24665m)) {
                C7270p pVar = C7270p.f24600a;
                C7280w wVar = r9;
                C7280w wVar2 = new C7280w("recall", System.currentTimeMillis(), 0, 0, null, betaGrayStrategy.f23818a.f24665m, betaGrayStrategy.f23818a.f24668p, null);
                pVar.mo34953a(wVar);
                C7127a.m30552a(str);
                C7131e.f23698E.f23744p.mo34326a(betaGrayStrategy.f23818a.f24658f.f24618b, C7131e.f23698E.f23707I.getAbsolutePath(), null, betaGrayStrategy.f23818a.f24658f.f24617a).delete(true);
                File file = C7131e.f23698E.f23706H;
                if (file != null && file.exists() && file.delete()) {
                    C7226an.m31141a(str3, new Object[0]);
                }
                File file2 = C7131e.f23698E.f23705G;
                if (file2 == null || !file2.exists() || !file2.delete()) {
                    z = false;
                } else {
                    z = false;
                    C7226an.m31141a(str2, new Object[0]);
                }
                C7127a.m30548a("IS_PATCH_ROLL_BACK", true);
                C7226an.m31141a("patch rollback", new Object[z]);
                if (!C7232aq.m31213b(C7131e.f23698E.f23747s)) {
                    TinkerManager.getInstance().onPatchRollback(true);
                } else {
                    TinkerManager.getInstance().onPatchRollback(z);
                }
                betaGrayStrategy = null;
            }
            if (yVar2.f24666n != 1) {
                yVar2 = null;
            }
        }
        if (yVar2 != null) {
            BetaGrayStrategy betaGrayStrategy2 = new BetaGrayStrategy();
            betaGrayStrategy2.f23818a = yVar2;
            betaGrayStrategy2.f23822e = System.currentTimeMillis();
            if (betaGrayStrategy != null && (!TextUtils.equals(betaGrayStrategy.f23818a.f24658f.f24618b, yVar2.f24658f.f24618b) || (yVar2.f24664l != null && TextUtils.equals((CharSequence) yVar2.f24664l.get("H1"), "false")))) {
                C7131e.f23698E.f23711M = (String) yVar2.f24664l.get("H2");
                C7131e.f23698E.f23744p.mo34326a(betaGrayStrategy.f23818a.f24658f.f24618b, C7131e.f23698E.f23707I.getAbsolutePath(), null, null).delete(true);
                if (betaGrayStrategy.f23818a.f24668p == 3) {
                    File file3 = C7131e.f23698E.f23706H;
                    if (file3 != null && file3.exists() && file3.delete()) {
                        C7226an.m31141a(str3, new Object[0]);
                    }
                    File file4 = C7131e.f23698E.f23705G;
                    if (file4 != null && file4.exists() && file4.delete()) {
                        C7131e.f23698E.f23710L = "";
                        c = 0;
                        C7226an.m31141a(str2, new Object[0]);
                        C7127a.m30553a(str, betaGrayStrategy2);
                        Object[] objArr = new Object[2];
                        objArr[c] = yVar2;
                        objArr[1] = Integer.valueOf(yVar2.f24668p);
                        C7226an.m31141a("onUpgradeReceived: %s [type: %d]", objArr);
                        return betaGrayStrategy2;
                    }
                }
            }
            c = 0;
            C7127a.m30553a(str, betaGrayStrategy2);
            Object[] objArr2 = new Object[2];
            objArr2[c] = yVar2;
            objArr2[1] = Integer.valueOf(yVar2.f24668p);
            C7226an.m31141a("onUpgradeReceived: %s [type: %d]", objArr2);
            return betaGrayStrategy2;
        } else if (betaGrayStrategy == null || betaGrayStrategy.f23818a == null || betaGrayStrategy.f23818a.f24668p != 3) {
            return null;
        } else {
            return betaGrayStrategy;
        }
    }

    /* renamed from: a */
    private void m31416a() {
        if (this.f24602b != null) {
            if (this.f24603c == null) {
                this.f24603c = C7131e.f23698E.f23744p.mo34326a(this.f24602b.f23818a.f24658f.f24618b, C7131e.f23698E.f23707I.getAbsolutePath(), null, this.f24602b.f23818a.f24658f.f24617a);
            }
            DownloadTask downloadTask = this.f24603c;
            if (downloadTask != null) {
                downloadTask.addListener(this.f24605e);
                this.f24603c.setNeededNotify(false);
                this.f24603c.download();
            }
        }
    }
}
