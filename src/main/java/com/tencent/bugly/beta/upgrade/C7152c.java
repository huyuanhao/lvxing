package com.tencent.bugly.beta.upgrade;

import android.os.Parcelable;
import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.C7124a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C7127a;
import com.tencent.bugly.beta.global.C7130d;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.beta.global.C7132f;
import com.tencent.bugly.beta.p602ui.C7149h;
import com.tencent.bugly.beta.utils.C7159e;
import com.tencent.bugly.proguard.C7216ah;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import com.tencent.bugly.proguard.C7253bk;
import com.tencent.bugly.proguard.C7267m;
import com.tencent.bugly.proguard.C7270p;
import com.tencent.bugly.proguard.C7280w;
import com.tencent.bugly.proguard.C7282y;
import com.tencent.bugly.proguard.C7283z;
import java.io.File;
import java.util.HashMap;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.upgrade.c */
public class C7152c {
    /* renamed from: a */
    public static C7152c f23830a = new C7152c();
    /* renamed from: b */
    public BetaGrayStrategy f23831b;
    /* renamed from: c */
    public DownloadTask f23832c;
    /* renamed from: d */
    public DownloadListener f23833d;
    /* renamed from: e */
    public UpgradeListener f23834e;
    /* renamed from: f */
    public UpgradeStateListener f23835f;
    /* renamed from: g */
    public boolean f23836g;
    /* renamed from: h */
    public boolean f23837h;
    /* renamed from: i */
    public C7130d f23838i;
    /* renamed from: j */
    public C7130d f23839j;
    /* renamed from: k */
    public int f23840k;
    /* renamed from: l */
    private final Object f23841l = new Object();
    /* renamed from: m */
    private final Object f23842m = new Object();
    /* renamed from: n */
    private DownloadListener f23843n = new C7124a(3, this, Integer.valueOf(0));
    /* renamed from: o */
    private C7150a f23844o = null;
    /* renamed from: p */
    private C7130d f23845p;
    /* renamed from: q */
    private boolean f23846q;

    /* renamed from: a */
    public BetaGrayStrategy mo34472a(C7282y yVar) {
        BetaGrayStrategy betaGrayStrategy;
        BetaGrayStrategy betaGrayStrategy2;
        File[] listFiles;
        C7282y yVar2 = yVar;
        synchronized (this.f23841l) {
            betaGrayStrategy = null;
            this.f23832c = null;
            BetaGrayStrategy betaGrayStrategy3 = (BetaGrayStrategy) C7127a.m30544a("st.bch", BetaGrayStrategy.CREATOR);
            if (betaGrayStrategy3 != null && betaGrayStrategy3.f23818a == null) {
                C7127a.m30552a("st.bch");
                betaGrayStrategy3 = null;
            }
            if (!(betaGrayStrategy3 == null || betaGrayStrategy3.f23818a == null || (betaGrayStrategy3.f23818a.f24657e.f24625c > C7131e.f23698E.f23751w && betaGrayStrategy3.f23818a.f24666n == 1 && ((betaGrayStrategy3.f23818a.f24658f == null || !TextUtils.equals(C7131e.f23698E.f23750v, betaGrayStrategy3.f23818a.f24658f.f24617a)) && betaGrayStrategy3.f23818a.f24668p != 3)))) {
                C7127a.m30552a("st.bch");
                this.f23832c = null;
                betaGrayStrategy3 = null;
            }
            if (yVar2 != null && yVar2.f24657e.f24625c < C7131e.f23698E.f23751w) {
                C7226an.m31141a("versionCode is too small, discard remote strategy: [new: %d] [current: %d]", Integer.valueOf(yVar2.f24657e.f24625c), Integer.valueOf(C7131e.f23698E.f23751w));
                yVar2 = null;
            }
            if (yVar2 != null) {
                if (yVar2.f24666n == 2 && betaGrayStrategy3 != null && betaGrayStrategy3.f23818a != null && !TextUtils.isEmpty(yVar2.f24665m) && !TextUtils.isEmpty(betaGrayStrategy3.f23818a.f24665m) && TextUtils.equals(yVar2.f24665m, betaGrayStrategy3.f23818a.f24665m)) {
                    C7226an.m31141a("callback strategy: %s", yVar2.f24665m);
                    C7127a.m30552a("st.bch");
                    C7131e.f23698E.f23744p.mo34326a(betaGrayStrategy3.f23818a.f24658f.f24618b, C7131e.f23698E.f23748t.getAbsolutePath(), null, null).delete(true);
                    betaGrayStrategy3 = null;
                }
                if (yVar2.f24666n != 1) {
                    C7226an.m31141a("invalid strategy: %s", yVar2.f24665m);
                    yVar2 = null;
                }
            }
            if (yVar2 != null) {
                if (betaGrayStrategy3 == null || betaGrayStrategy3.f23818a == null || TextUtils.isEmpty(yVar2.f24665m) || TextUtils.isEmpty(betaGrayStrategy3.f23818a.f24665m) || !TextUtils.equals(yVar2.f24665m, betaGrayStrategy3.f23818a.f24665m)) {
                    betaGrayStrategy2 = new BetaGrayStrategy();
                } else {
                    betaGrayStrategy2 = new BetaGrayStrategy(C7232aq.m31223d(C7232aq.m31199a((Parcelable) betaGrayStrategy3)));
                    C7226an.m31141a("same strategyId:[new: %s] [current: %s] keep has popup times: %d, interval: %d", yVar2.f24665m, betaGrayStrategy3.f23818a.f24665m, Integer.valueOf(betaGrayStrategy2.f23819b), Long.valueOf(yVar2.f24661i));
                }
                betaGrayStrategy2.f23818a = yVar2;
                betaGrayStrategy2.f23822e = System.currentTimeMillis();
                if (betaGrayStrategy3 != null) {
                    if (!betaGrayStrategy3.f23818a.f24658f.f24618b.equals(yVar2.f24658f.f24618b)) {
                        if (this.f23832c == null) {
                            C7131e.f23698E.f23744p.mo34326a(betaGrayStrategy3.f23818a.f24658f.f24618b, C7131e.f23698E.f23748t.getAbsolutePath(), null, null).delete(true);
                            for (File file : C7131e.f23698E.f23748t.listFiles()) {
                                if (!file.delete()) {
                                    C7226an.m31149e("cannot deleteCache file:%s", file.getAbsolutePath());
                                }
                            }
                            this.f23832c = null;
                        } else {
                            BetaReceiver.netListeners.remove(this.f23832c.getDownloadUrl());
                            this.f23832c.delete(true);
                            this.f23832c = null;
                        }
                    }
                    if (betaGrayStrategy3.f23818a.f24668p == 3) {
                        File file2 = C7131e.f23698E.f23706H;
                        if (file2 != null && file2.exists() && file2.delete()) {
                            C7226an.m31141a("delete tmpPatchFile", new Object[0]);
                        }
                        File file3 = C7131e.f23698E.f23705G;
                        if (file3 != null && file3.exists() && file3.delete()) {
                            C7131e.f23698E.f23710L = "";
                            C7226an.m31141a("delete patchFile", new Object[0]);
                        }
                    }
                }
                C7127a.m30553a("st.bch", betaGrayStrategy2);
                C7226an.m31141a("onUpgradeReceived: %s [type: %d]", yVar2, Integer.valueOf(yVar2.f24659g));
                C7270p pVar = C7270p.f24600a;
                C7280w wVar = new C7280w("rcv", System.currentTimeMillis(), 0, 0, yVar2.f24657e, yVar2.f24665m, yVar2.f24668p, null);
                pVar.mo34953a(wVar);
                betaGrayStrategy = betaGrayStrategy2;
            } else if (!(betaGrayStrategy3 == null || betaGrayStrategy3.f23818a == null || betaGrayStrategy3.f23818a.f24668p == 3)) {
                C7127a.m30552a("st.bch");
            }
        }
        return betaGrayStrategy;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d5, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0156, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0180, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e0, code lost:
            return;
     */
    /* renamed from: a */
    public void mo34475a(boolean r11, boolean r12, int r13, com.tencent.bugly.proguard.C7282y r14, java.lang.String r15) {
        /*
        r10 = this;
        java.lang.Object r15 = r10.f23841l
        monitor-enter(r15)
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r14 = r10.mo34472a(r14)     // Catch:{ all -> 0x01e1 }
        r10.f23831b = r14     // Catch:{ all -> 0x01e1 }
        r10.f23836g = r11     // Catch:{ all -> 0x01e1 }
        r10.f23837h = r12     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.UpgradeListener r14 = r10.f23834e     // Catch:{ all -> 0x01e1 }
        r0 = 4
        r1 = 5
        r2 = 2
        r3 = 3
        r4 = 1
        r5 = 0
        if (r14 == 0) goto L_0x009a
        java.lang.String r14 = "你已放弃让SDK来处理策略"
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.proguard.C7226an.m31141a(r14, r6)     // Catch:{ all -> 0x01e1 }
        r10.f23840k = r3     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r14 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        if (r14 != 0) goto L_0x002b
        java.lang.String r14 = "betaStrategy is null"
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.proguard.C7226an.m31141a(r14, r6)     // Catch:{ all -> 0x01e1 }
    L_0x002b:
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r14 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        r6 = 0
        if (r14 == 0) goto L_0x0056
        com.tencent.bugly.beta.download.DownloadTask r14 = r10.f23832c     // Catch:{ all -> 0x01e1 }
        if (r14 != 0) goto L_0x0056
        com.tencent.bugly.beta.global.e r14 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.download.b r14 = r14.f23744p     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r7 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.proguard.y r7 = r7.f23818a     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.proguard.u r7 = r7.f24658f     // Catch:{ all -> 0x01e1 }
        java.lang.String r7 = r7.f24618b     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.global.e r8 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x01e1 }
        java.io.File r8 = r8.f23748t     // Catch:{ all -> 0x01e1 }
        java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r9 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.proguard.y r9 = r9.f23818a     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.proguard.u r9 = r9.f24658f     // Catch:{ all -> 0x01e1 }
        java.lang.String r9 = r9.f24617a     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.download.DownloadTask r14 = r14.mo34326a(r7, r8, r6, r9)     // Catch:{ all -> 0x01e1 }
        r10.f23832c = r14     // Catch:{ all -> 0x01e1 }
    L_0x0056:
        com.tencent.bugly.beta.download.DownloadTask r14 = r10.f23832c     // Catch:{ all -> 0x01e1 }
        if (r14 != 0) goto L_0x006d
        java.lang.String r14 = "用户自定义activity，创建task失败 [strategy:%s]"
        java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r8 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        r7[r5] = r8     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.proguard.C7226an.m31141a(r14, r7)     // Catch:{ all -> 0x01e1 }
        r10.f23831b = r6     // Catch:{ all -> 0x01e1 }
        java.lang.String r14 = "st.bch"
        com.tencent.bugly.beta.global.C7127a.m30552a(r14)     // Catch:{ all -> 0x01e1 }
        goto L_0x0074
    L_0x006d:
        com.tencent.bugly.beta.download.DownloadTask r14 = r10.f23832c     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.download.DownloadListener r6 = r10.f23843n     // Catch:{ all -> 0x01e1 }
        r14.addListener(r6)     // Catch:{ all -> 0x01e1 }
    L_0x0074:
        com.tencent.bugly.beta.global.d r14 = new com.tencent.bugly.beta.global.d     // Catch:{ all -> 0x01e1 }
        r6 = 16
        java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.UpgradeListener r8 = r10.f23834e     // Catch:{ all -> 0x01e1 }
        r7[r5] = r8     // Catch:{ all -> 0x01e1 }
        java.lang.Integer r8 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x01e1 }
        r7[r4] = r8     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r8 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        r7[r2] = r8     // Catch:{ all -> 0x01e1 }
        java.lang.Boolean r8 = java.lang.Boolean.valueOf(r11)     // Catch:{ all -> 0x01e1 }
        r7[r3] = r8     // Catch:{ all -> 0x01e1 }
        java.lang.Boolean r8 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x01e1 }
        r7[r0] = r8     // Catch:{ all -> 0x01e1 }
        r14.m52393init(r6, r7)     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.utils.C7159e.m30681a(r14)     // Catch:{ all -> 0x01e1 }
    L_0x009a:
        r14 = 18
        if (r13 == 0) goto L_0x00d6
        if (r11 == 0) goto L_0x00d6
        if (r12 != 0) goto L_0x00d6
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r13 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        if (r13 != 0) goto L_0x00d6
        com.tencent.bugly.beta.upgrade.UpgradeStateListener r12 = r10.f23835f     // Catch:{ all -> 0x01e1 }
        if (r12 == 0) goto L_0x00c6
        com.tencent.bugly.beta.global.d r12 = new com.tencent.bugly.beta.global.d     // Catch:{ all -> 0x01e1 }
        java.lang.Object[] r13 = new java.lang.Object[r3]     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.UpgradeStateListener r0 = r10.f23835f     // Catch:{ all -> 0x01e1 }
        r13[r5] = r0     // Catch:{ all -> 0x01e1 }
        r0 = -1
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x01e1 }
        r13[r4] = r0     // Catch:{ all -> 0x01e1 }
        java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ all -> 0x01e1 }
        r13[r2] = r11     // Catch:{ all -> 0x01e1 }
        r12.m52393init(r14, r13)     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.utils.C7159e.m30681a(r12)     // Catch:{ all -> 0x01e1 }
        goto L_0x00d4
    L_0x00c6:
        com.tencent.bugly.beta.global.d r11 = new com.tencent.bugly.beta.global.d     // Catch:{ all -> 0x01e1 }
        java.lang.Object[] r12 = new java.lang.Object[r4]     // Catch:{ all -> 0x01e1 }
        java.lang.String r13 = com.tencent.bugly.beta.Beta.strToastCheckUpgradeError     // Catch:{ all -> 0x01e1 }
        r12[r5] = r13     // Catch:{ all -> 0x01e1 }
        r11.m52393init(r1, r12)     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.utils.C7159e.m30681a(r11)     // Catch:{ all -> 0x01e1 }
    L_0x00d4:
        monitor-exit(r15)     // Catch:{ all -> 0x01e1 }
        return
    L_0x00d6:
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r13 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        if (r13 == 0) goto L_0x01ae
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r13 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.proguard.y r13 = r13.f23818a     // Catch:{ all -> 0x01e1 }
        if (r13 == 0) goto L_0x01ae
        com.tencent.bugly.beta.download.DownloadTask r13 = r10.f23832c     // Catch:{ all -> 0x01e1 }
        if (r13 != 0) goto L_0x00ea
        com.tencent.bugly.beta.download.DownloadTask r13 = r10.m30598b()     // Catch:{ all -> 0x01e1 }
        r10.f23832c = r13     // Catch:{ all -> 0x01e1 }
    L_0x00ea:
        com.tencent.bugly.beta.download.DownloadTask r13 = r10.f23832c     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.download.DownloadListener r1 = r10.f23843n     // Catch:{ all -> 0x01e1 }
        r13.addListener(r1)     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.UpgradeStateListener r13 = r10.f23835f     // Catch:{ all -> 0x01e1 }
        if (r13 == 0) goto L_0x010f
        com.tencent.bugly.beta.global.d r13 = new com.tencent.bugly.beta.global.d     // Catch:{ all -> 0x01e1 }
        java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.UpgradeStateListener r6 = r10.f23835f     // Catch:{ all -> 0x01e1 }
        r1[r5] = r6     // Catch:{ all -> 0x01e1 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x01e1 }
        r1[r4] = r5     // Catch:{ all -> 0x01e1 }
        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r11)     // Catch:{ all -> 0x01e1 }
        r1[r2] = r5     // Catch:{ all -> 0x01e1 }
        r13.m52393init(r14, r1)     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.utils.C7159e.m30681a(r13)     // Catch:{ all -> 0x01e1 }
    L_0x010f:
        com.tencent.bugly.beta.upgrade.UpgradeListener r13 = r10.f23834e     // Catch:{ all -> 0x01e1 }
        if (r13 == 0) goto L_0x0115
        monitor-exit(r15)     // Catch:{ all -> 0x01e1 }
        return
    L_0x0115:
        if (r11 != 0) goto L_0x0181
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r13 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.proguard.y r13 = r13.f23818a     // Catch:{ all -> 0x01e1 }
        byte r13 = r13.f24659g     // Catch:{ all -> 0x01e1 }
        if (r13 == r2) goto L_0x0181
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r13 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        boolean r13 = r13.f23821d     // Catch:{ all -> 0x01e1 }
        if (r13 == 0) goto L_0x0157
        com.tencent.bugly.beta.global.e r13 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x01e1 }
        boolean r13 = r13.f23733e     // Catch:{ all -> 0x01e1 }
        if (r13 == 0) goto L_0x0157
        com.tencent.bugly.beta.global.e r13 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x01e1 }
        android.content.Context r13 = r13.f23747s     // Catch:{ all -> 0x01e1 }
        int r13 = com.tencent.bugly.beta.global.C7127a.m30539a(r13)     // Catch:{ all -> 0x01e1 }
        if (r13 != r4) goto L_0x013b
        com.tencent.bugly.beta.global.e r13 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x01e1 }
        boolean r13 = r13.f23717S     // Catch:{ all -> 0x01e1 }
        if (r13 != 0) goto L_0x014b
    L_0x013b:
        com.tencent.bugly.beta.global.e r13 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x01e1 }
        android.content.Context r13 = r13.f23747s     // Catch:{ all -> 0x01e1 }
        int r13 = com.tencent.bugly.beta.global.C7127a.m30539a(r13)     // Catch:{ all -> 0x01e1 }
        if (r13 != r0) goto L_0x0150
        com.tencent.bugly.beta.global.e r13 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x01e1 }
        boolean r13 = r13.f23718T     // Catch:{ all -> 0x01e1 }
        if (r13 == 0) goto L_0x0150
    L_0x014b:
        r10.m30599c()     // Catch:{ all -> 0x01e1 }
        monitor-exit(r15)     // Catch:{ all -> 0x01e1 }
        return
    L_0x0150:
        if (r12 != 0) goto L_0x0155
        r10.m30597a(r11)     // Catch:{ all -> 0x01e1 }
    L_0x0155:
        monitor-exit(r15)     // Catch:{ all -> 0x01e1 }
        return
    L_0x0157:
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r13 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        long r13 = r13.f23820c     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r1 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.proguard.y r1 = r1.f23818a     // Catch:{ all -> 0x01e1 }
        long r1 = r1.f24661i     // Catch:{ all -> 0x01e1 }
        long r13 = r13 + r1
        long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01e1 }
        int r5 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
        if (r5 > 0) goto L_0x017f
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r13 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.proguard.y r13 = r13.f23818a     // Catch:{ all -> 0x01e1 }
        int r13 = r13.f24660h     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r14 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        int r14 = r14.f23819b     // Catch:{ all -> 0x01e1 }
        int r13 = r13 - r14
        if (r13 <= 0) goto L_0x017f
        com.tencent.bugly.beta.upgrade.BetaGrayStrategy r13 = r10.f23831b     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.proguard.y r13 = r13.f23818a     // Catch:{ all -> 0x01e1 }
        byte r13 = r13.f24659g     // Catch:{ all -> 0x01e1 }
        if (r13 != r3) goto L_0x0181
    L_0x017f:
        monitor-exit(r15)     // Catch:{ all -> 0x01e1 }
        return
    L_0x0181:
        com.tencent.bugly.beta.global.e r13 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x01e1 }
        android.content.Context r13 = r13.f23747s     // Catch:{ all -> 0x01e1 }
        int r13 = com.tencent.bugly.beta.global.C7127a.m30539a(r13)     // Catch:{ all -> 0x01e1 }
        if (r13 != r4) goto L_0x0191
        com.tencent.bugly.beta.global.e r13 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x01e1 }
        boolean r13 = r13.f23717S     // Catch:{ all -> 0x01e1 }
        if (r13 != 0) goto L_0x01a1
    L_0x0191:
        com.tencent.bugly.beta.global.e r13 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x01e1 }
        android.content.Context r13 = r13.f23747s     // Catch:{ all -> 0x01e1 }
        int r13 = com.tencent.bugly.beta.global.C7127a.m30539a(r13)     // Catch:{ all -> 0x01e1 }
        if (r13 != r0) goto L_0x01a8
        com.tencent.bugly.beta.global.e r13 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ all -> 0x01e1 }
        boolean r13 = r13.f23718T     // Catch:{ all -> 0x01e1 }
        if (r13 == 0) goto L_0x01a8
    L_0x01a1:
        if (r11 != 0) goto L_0x01a8
        r10.m30599c()     // Catch:{ all -> 0x01e1 }
        monitor-exit(r15)     // Catch:{ all -> 0x01e1 }
        return
    L_0x01a8:
        if (r12 != 0) goto L_0x01df
        r10.m30597a(r11)     // Catch:{ all -> 0x01e1 }
        goto L_0x01df
    L_0x01ae:
        com.tencent.bugly.beta.upgrade.UpgradeStateListener r13 = r10.f23835f     // Catch:{ all -> 0x01e1 }
        if (r13 == 0) goto L_0x01cd
        com.tencent.bugly.beta.global.d r12 = new com.tencent.bugly.beta.global.d     // Catch:{ all -> 0x01e1 }
        java.lang.Object[] r13 = new java.lang.Object[r3]     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.upgrade.UpgradeStateListener r0 = r10.f23835f     // Catch:{ all -> 0x01e1 }
        r13[r5] = r0     // Catch:{ all -> 0x01e1 }
        java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x01e1 }
        r13[r4] = r0     // Catch:{ all -> 0x01e1 }
        java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ all -> 0x01e1 }
        r13[r2] = r11     // Catch:{ all -> 0x01e1 }
        r12.m52393init(r14, r13)     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.utils.C7159e.m30681a(r12)     // Catch:{ all -> 0x01e1 }
        goto L_0x01df
    L_0x01cd:
        if (r11 == 0) goto L_0x01df
        if (r12 != 0) goto L_0x01df
        com.tencent.bugly.beta.global.d r11 = new com.tencent.bugly.beta.global.d     // Catch:{ all -> 0x01e1 }
        java.lang.Object[] r12 = new java.lang.Object[r4]     // Catch:{ all -> 0x01e1 }
        java.lang.String r13 = com.tencent.bugly.beta.Beta.strToastYourAreTheLatestVersion     // Catch:{ all -> 0x01e1 }
        r12[r5] = r13     // Catch:{ all -> 0x01e1 }
        r11.m52393init(r1, r12)     // Catch:{ all -> 0x01e1 }
        com.tencent.bugly.beta.utils.C7159e.m30681a(r11)     // Catch:{ all -> 0x01e1 }
    L_0x01df:
        monitor-exit(r15)     // Catch:{ all -> 0x01e1 }
        return
    L_0x01e1:
        r11 = move-exception
        monitor-exit(r15)     // Catch:{ all -> 0x01e1 }
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.C7152c.mo34475a(boolean, boolean, int, com.tencent.bugly.proguard.y, java.lang.String):void");
    }

    /* renamed from: a */
    private C7282y m30596a() {
        BetaGrayStrategy betaGrayStrategy = this.f23831b;
        if (betaGrayStrategy == null) {
            return null;
        }
        return betaGrayStrategy.f23818a;
    }

    /* renamed from: b */
    private DownloadTask m30598b() {
        C7282y a = m30596a();
        if (a == null) {
            return null;
        }
        if (this.f23832c == null) {
            this.f23832c = C7131e.f23698E.f23744p.mo34326a(a.f24658f.f24618b, C7131e.f23698E.f23748t.getAbsolutePath(), null, this.f23831b.f23818a.f24658f.f24617a);
        }
        return this.f23832c;
    }

    /* renamed from: c */
    private void m30599c() {
        C7282y a = m30596a();
        if (a != null) {
            if (this.f23832c == null) {
                this.f23832c = m30598b();
            }
            if (this.f23832c != null) {
                C7127a.m30553a("st.bch", this.f23831b);
                BetaReceiver.addTask(this.f23832c);
                if (this.f23832c.getStatus() != 1 || this.f23837h) {
                    this.f23832c.download();
                } else if (!this.f23836g || !C7127a.m30549a(C7131e.f23698E.f23747s, this.f23832c.getSaveFile(), a.f24658f.f24617a)) {
                    m30597a(this.f23836g);
                } else {
                    C7270p pVar = C7270p.f24600a;
                    C7280w wVar = new C7280w("install", System.currentTimeMillis(), 0, 0, a.f24657e, a.f24665m, a.f24668p, null);
                    pVar.mo34953a(wVar);
                }
            }
        }
    }

    /* renamed from: a */
    private void m30597a(boolean z) {
        C7282y a = m30596a();
        if (a != null) {
            boolean z2 = false;
            if (System.currentTimeMillis() <= a.mo34981a() - 86400000) {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                sb.append("ms");
                C7226an.m31149e(sb.toString(), new Object[0]);
                return;
            }
            C7132f.f23755a.mo34341a(C7131e.f23698E.f23744p, a.f24664l);
            if (this.f23832c == null) {
                this.f23832c = m30598b();
            }
            DownloadTask downloadTask = this.f23832c;
            if (downloadTask != null) {
                if (z || downloadTask.getStatus() != 2) {
                    this.f23832c.addListener(this.f23843n);
                    DownloadListener downloadListener = this.f23833d;
                    if (downloadListener != null) {
                        this.f23832c.addListener(downloadListener);
                    }
                    C7149h hVar = C7149h.f23802v;
                    hVar.mo34448a(a, this.f23832c);
                    hVar.f23810r = new C7130d(3, this.f23831b, this.f23832c);
                    hVar.f23811s = new C7130d(4, this.f23831b, this.f23832c, Boolean.valueOf(z));
                    this.f23831b.f23820c = System.currentTimeMillis();
                    C7127a.m30553a("st.bch", this.f23831b);
                    if (z) {
                        C7132f.f23755a.mo34343a((Runnable) new C7130d(2, hVar, Boolean.valueOf(z)), (int) PathInterpolatorCompat.MAX_NUM_POINTS);
                    } else {
                        C7132f fVar = C7132f.f23755a;
                        Object[] objArr = new Object[2];
                        objArr[0] = hVar;
                        if (z || a.f24659g == 2) {
                            z2 = true;
                        }
                        objArr[1] = Boolean.valueOf(z2);
                        fVar.mo34342a(new C7130d(2, objArr));
                    }
                    return;
                }
                C7226an.m31141a("Task is downloading %s %s", a.f24665m, this.f23832c.getDownloadUrl());
            }
        }
    }

    /* renamed from: a */
    public void mo34474a(boolean z, boolean z2, int i) {
        boolean z3 = z;
        synchronized (this.f23842m) {
            BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) C7127a.m30544a("st.bch", BetaGrayStrategy.CREATOR);
            if (z3 && betaGrayStrategy != null && betaGrayStrategy.f23818a != null && betaGrayStrategy.f23818a.f24668p == 3) {
                betaGrayStrategy = null;
            }
            BetaGrayStrategy betaGrayStrategy2 = betaGrayStrategy;
            if (this.f23844o != null && !this.f23844o.f23828d) {
                if (this.f23846q == z3) {
                    synchronized (this.f23844o) {
                        this.f23844o.f23827c[0] = Boolean.valueOf(z);
                        this.f23844o.f23827c[1] = Boolean.valueOf(z2);
                    }
                    this.f23845p.f23697b[0] = Boolean.valueOf(false);
                    if ((z3 && !z2) || !(betaGrayStrategy2 == null || betaGrayStrategy2.f23818a == null || betaGrayStrategy2.f23818a.f24668p != 2)) {
                        C7159e.m30683b(this.f23845p);
                        C7159e.m30682a(this.f23845p, 6000);
                    }
                }
            }
            this.f23846q = z3;
            if (this.f23844o != null) {
                this.f23844o.f23828d = true;
            }
            this.f23844o = new C7150a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy2);
            this.f23845p = new C7130d(12, Boolean.valueOf(false), this.f23844o);
            String str = "";
            long j = 0;
            if (betaGrayStrategy2 != null) {
                try {
                    if (betaGrayStrategy2.f23818a != null) {
                        str = betaGrayStrategy2.f23818a.f24665m;
                        j = betaGrayStrategy2.f23818a.f24667o;
                    }
                } catch (Throwable th) {
                    if (!C7226an.m31145b(th)) {
                        th.printStackTrace();
                    }
                }
            }
            String str2 = str;
            long j2 = j;
            HashMap hashMap = new HashMap();
            hashMap.put("G16", C7131e.f23698E.f23710L);
            C7283z zVar = new C7283z(z3 ? 1 : 0, str2, j2, hashMap);
            C7151b.f23829a.mo34470a(804, C7216ah.m31078a((C7267m) zVar), this.f23844o, z, C7131e.f23698E.f23704F.f23823a.f24529e);
            C7159e.m30683b(this.f23845p);
            C7159e.m30682a(this.f23845p, 6000);
        }
    }

    /* renamed from: a */
    public void mo34473a(C7253bk bkVar) {
        if (C7131e.f23698E.f23704F == null) {
            C7131e.f23698E.f23704F = new BetaUploadStrategy();
        }
        if (bkVar != null && C7131e.f23698E.f23704F.f23824b != bkVar.f24532h) {
            C7131e.f23698E.f23704F.f23824b = bkVar.f24532h;
            C7131e.f23698E.f23704F.f23823a.f24526b = bkVar.f24526b;
            C7131e.f23698E.f23704F.f23823a.f24527c = bkVar.f24527c;
            C7131e.f23698E.f23704F.f23823a.f24532h = bkVar.f24532h;
            if (C7232aq.m31221c(bkVar.f24528d)) {
                C7131e.f23698E.f23704F.f23823a.f24528d = bkVar.f24528d;
            }
            if (C7232aq.m31221c(bkVar.f24529e)) {
                C7131e.f23698E.f23704F.f23823a.f24529e = bkVar.f24529e;
            }
            if (bkVar.f24530f != null && !TextUtils.isEmpty(bkVar.f24530f.f24520a)) {
                C7131e.f23698E.f23704F.f23823a.f24530f.f24520a = bkVar.f24530f.f24520a;
            }
            if (bkVar.f24531g != null && bkVar.f24531g.size() > 0) {
                C7131e.f23698E.f23704F.f23823a.f24531g = bkVar.f24531g;
            }
            if (C7232aq.m31221c(bkVar.f24533i)) {
                C7131e.f23698E.f23704F.f23823a.f24533i = bkVar.f24533i;
            }
            if (C7232aq.m31221c(bkVar.f24534j)) {
                C7131e.f23698E.f23704F.f23823a.f24534j = bkVar.f24534j;
            }
            C7127a.m30553a("us.bch", C7131e.f23698E.f23704F);
        }
    }
}
