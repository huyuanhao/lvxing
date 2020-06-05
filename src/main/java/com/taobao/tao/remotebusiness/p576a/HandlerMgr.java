package com.taobao.tao.remotebusiness.p576a;

import android.os.Handler;
import android.os.Looper;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.MtopEvent;
import mtopsdk.mtop.common.MtopListener;

/* renamed from: com.taobao.tao.remotebusiness.a.a */
public class HandlerMgr extends Handler {
    /* renamed from: a */
    private static volatile Handler f22561a;

    private HandlerMgr(Looper looper) {
        super(looper);
    }

    /* renamed from: a */
    public static Handler m29123a() {
        if (f22561a == null) {
            synchronized (HandlerMgr.class) {
                if (f22561a == null) {
                    f22561a = new HandlerMgr(Looper.getMainLooper());
                }
            }
        }
        return f22561a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a1  */
    public void handleMessage(android.os.Message r16) {
        /*
        r15 = this;
        r1 = r16
        java.lang.Object r0 = r1.obj
        com.taobao.tao.remotebusiness.a.c r0 = (com.taobao.tao.remotebusiness.p576a.HandlerParam) r0
        java.lang.String r2 = "mtopsdk.HandlerMgr"
        java.lang.String r3 = ""
        if (r0 != 0) goto L_0x0012
        java.lang.String r0 = "HandlerMsg is null."
        mtopsdk.common.util.TBSdkLog.m35513d(r2, r3, r0)
        return
    L_0x0012:
        com.taobao.tao.remotebusiness.f r4 = r0.f22566d
        if (r4 == 0) goto L_0x002a
        com.taobao.tao.remotebusiness.f r3 = r0.f22566d
        java.lang.String r3 = r3.mo32736a()
        com.taobao.tao.remotebusiness.f r4 = r0.f22566d
        boolean r4 = r4.mo32750e()
        if (r4 == 0) goto L_0x002a
        java.lang.String r0 = "The request of MtopBusiness is cancelled."
        mtopsdk.common.util.TBSdkLog.m35507b(r2, r3, r0)
        return
    L_0x002a:
        com.taobao.tao.remotebusiness.f r4 = r0.f22566d
        java.lang.Object r4 = r4.mo39756h()
        int r5 = r1.what
        r7 = 1
        if (r5 == r7) goto L_0x01ca
        r8 = 2
        if (r5 == r8) goto L_0x01a9
        r8 = 3
        if (r5 == r8) goto L_0x00c6
        r8 = 4
        if (r5 == r8) goto L_0x0042
    L_0x003e:
        r2 = 0
        r14 = r15
        goto L_0x01eb
    L_0x0042:
        mtopsdk.common.util.TBSdkLog$LogEnable r5 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable
        boolean r5 = mtopsdk.common.util.TBSdkLog.m35509b(r5)
        if (r5 == 0) goto L_0x004f
        java.lang.String r5 = "onReceive: ON_CACHED"
        mtopsdk.common.util.TBSdkLog.m35507b(r2, r3, r5)
    L_0x004f:
        mtopsdk.mtop.common.d r5 = r0.f22564b
        mtopsdk.mtop.common.b r5 = (mtopsdk.mtop.common.MtopCacheEvent) r5
        if (r5 != 0) goto L_0x005b
        java.lang.String r0 = "HandlerMsg.event is null."
        mtopsdk.common.util.TBSdkLog.m35513d(r2, r3, r0)
        return
    L_0x005b:
        mtopsdk.mtop.domain.MtopResponse r8 = r5.mo39769a()
        if (r8 == 0) goto L_0x008c
        mtopsdk.mtop.domain.MtopResponse r8 = r5.mo39769a()
        mtopsdk.mtop.util.MtopStatistics r8 = r8.getMtopStat()
        if (r8 == 0) goto L_0x008c
        mtopsdk.mtop.util.MtopStatistics$a r9 = r8.mo39840d()
        long r10 = java.lang.System.currentTimeMillis()
        com.taobao.tao.remotebusiness.f r12 = r0.f22566d
        long r12 = r12.f22592h
        long r10 = r10 - r12
        r9.f28013i = r10
        mtopsdk.common.util.TBSdkLog$LogEnable r10 = mtopsdk.common.util.TBSdkLog.LogEnable.DebugEnable
        boolean r10 = mtopsdk.common.util.TBSdkLog.m35509b(r10)
        if (r10 == 0) goto L_0x0089
        java.lang.String r9 = r9.toString()
        mtopsdk.common.util.TBSdkLog.m35502a(r2, r3, r9)
    L_0x0089:
        r8.mo39836a(r7)
    L_0x008c:
        mtopsdk.mtop.common.g r7 = r0.f22563a     // Catch:{ all -> 0x00be }
        boolean r7 = r7 instanceof com.taobao.tao.remotebusiness.IRemoteCacheListener     // Catch:{ all -> 0x00be }
        if (r7 == 0) goto L_0x00a1
        java.lang.String r7 = "listener onCached callback"
        mtopsdk.common.util.TBSdkLog.m35507b(r2, r3, r7)     // Catch:{ all -> 0x00be }
        mtopsdk.mtop.common.g r7 = r0.f22563a     // Catch:{ all -> 0x00be }
        com.taobao.tao.remotebusiness.b r7 = (com.taobao.tao.remotebusiness.IRemoteCacheListener) r7     // Catch:{ all -> 0x00be }
        mtopsdk.mtop.domain.a r0 = r0.f22565c     // Catch:{ all -> 0x00be }
        r7.mo32723a(r5, r0, r4)     // Catch:{ all -> 0x00be }
        goto L_0x003e
    L_0x00a1:
        com.taobao.tao.remotebusiness.f r5 = r0.f22566d     // Catch:{ all -> 0x00be }
        java.lang.String r5 = r5.mo32736a()     // Catch:{ all -> 0x00be }
        java.lang.String r7 = "listener onCached transfer to onSuccess callback"
        mtopsdk.common.util.TBSdkLog.m35507b(r2, r5, r7)     // Catch:{ all -> 0x00be }
        mtopsdk.mtop.common.g r5 = r0.f22563a     // Catch:{ all -> 0x00be }
        com.taobao.tao.remotebusiness.c r5 = (com.taobao.tao.remotebusiness.IRemoteListener) r5     // Catch:{ all -> 0x00be }
        com.taobao.tao.remotebusiness.f r7 = r0.f22566d     // Catch:{ all -> 0x00be }
        int r7 = r7.mo32747d()     // Catch:{ all -> 0x00be }
        mtopsdk.mtop.domain.MtopResponse r8 = r0.f22567e     // Catch:{ all -> 0x00be }
        mtopsdk.mtop.domain.a r0 = r0.f22565c     // Catch:{ all -> 0x00be }
        r5.mo10878a(r7, r8, r0, r4)     // Catch:{ all -> 0x00be }
        goto L_0x003e
    L_0x00be:
        r0 = move-exception
        java.lang.String r4 = "listener onCached callback error."
        mtopsdk.common.util.TBSdkLog.m35508b(r2, r3, r4, r0)
        goto L_0x003e
    L_0x00c6:
        mtopsdk.common.util.TBSdkLog$LogEnable r4 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable
        boolean r4 = mtopsdk.common.util.TBSdkLog.m35509b(r4)
        if (r4 == 0) goto L_0x00d3
        java.lang.String r4 = "onReceive: ON_FINISHED."
        mtopsdk.common.util.TBSdkLog.m35507b(r2, r3, r4)
    L_0x00d3:
        long r4 = java.lang.System.currentTimeMillis()
        mtopsdk.mtop.domain.MtopResponse r8 = r0.f22567e
        r9 = 0
        if (r8 == 0) goto L_0x0106
        mtopsdk.mtop.domain.MtopResponse r8 = r0.f22567e
        mtopsdk.mtop.util.MtopStatistics r8 = r8.getMtopStat()
        if (r8 == 0) goto L_0x0104
        mtopsdk.mtop.util.MtopStatistics$a r11 = r8.mo39840d()
        com.taobao.tao.remotebusiness.f r12 = r0.f22566d
        long r12 = r12.f22592h
        long r12 = r4 - r12
        r11.f28013i = r12
        mtopsdk.mtop.domain.MtopResponse r12 = r0.f22567e
        byte[] r12 = r12.getBytedata()
        if (r12 == 0) goto L_0x0102
        mtopsdk.mtop.domain.MtopResponse r12 = r0.f22567e
        byte[] r12 = r12.getBytedata()
        int r12 = r12.length
        long r12 = (long) r12
        goto L_0x0109
    L_0x0102:
        r12 = r9
        goto L_0x0109
    L_0x0104:
        r12 = r9
        goto L_0x0108
    L_0x0106:
        r12 = r9
        r8 = 0
    L_0x0108:
        r11 = 0
    L_0x0109:
        com.taobao.tao.remotebusiness.f r14 = r0.f22566d
        mtopsdk.mtop.common.MtopNetworkProp r14 = r14.f27899k
        android.os.Handler r14 = r14.handler
        if (r14 == 0) goto L_0x0141
        if (r8 == 0) goto L_0x0131
        com.taobao.tao.remotebusiness.f r9 = r0.f22566d
        mtopsdk.mtop.common.MtopNetworkProp r9 = r9.f27899k
        android.os.Handler r9 = r9.handler
        android.os.Looper r9 = r9.getLooper()
        android.os.Looper r10 = android.os.Looper.getMainLooper()
        boolean r9 = r9.equals(r10)
        r8.f27952X = r9
        long r9 = java.lang.System.currentTimeMillis()
        r8.f27939K = r9
        long r9 = r8.f27939K
        r8.f27940L = r9
    L_0x0131:
        com.taobao.tao.remotebusiness.f r9 = r0.f22566d
        mtopsdk.mtop.common.MtopNetworkProp r9 = r9.f27899k
        android.os.Handler r9 = r9.handler
        com.taobao.tao.remotebusiness.a.b r10 = new com.taobao.tao.remotebusiness.a.b
        r14 = r15
        r10.m51757init(r15, r0)
        r9.post(r10)
        goto L_0x0166
    L_0x0141:
        r14 = r15
        if (r11 == 0) goto L_0x014e
        long r9 = r8.mo39835a()
        long r6 = java.lang.System.currentTimeMillis()
        r8.f27939K = r6
    L_0x014e:
        com.taobao.tao.remotebusiness.f r6 = r0.f22566d
        mtopsdk.mtop.domain.MtopResponse r7 = r0.f22567e
        mtopsdk.mtop.domain.a r0 = r0.f22565c
        r6.mo32738a(r7, r0)
        if (r11 == 0) goto L_0x0166
        long r6 = r8.mo39835a()
        long r6 = r6 - r9
        r11.f28015k = r6
        long r6 = java.lang.System.currentTimeMillis()
        r8.f27940L = r6
    L_0x0166:
        mtopsdk.common.util.TBSdkLog$LogEnable r0 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable
        boolean r0 = mtopsdk.common.util.TBSdkLog.m35509b(r0)
        if (r0 == 0) goto L_0x019f
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r6 = 128(0x80, float:1.794E-43)
        r0.<init>(r6)
        java.lang.String r6 = "onReceive: ON_FINISHED. doFinishTime="
        r0.append(r6)
        long r6 = java.lang.System.currentTimeMillis()
        long r6 = r6 - r4
        r0.append(r6)
        java.lang.String r4 = "; dataSize="
        r0.append(r4)
        r0.append(r12)
        java.lang.String r4 = "; "
        r0.append(r4)
        if (r11 == 0) goto L_0x0198
        java.lang.String r4 = r11.toString()
        r0.append(r4)
    L_0x0198:
        java.lang.String r0 = r0.toString()
        mtopsdk.common.util.TBSdkLog.m35507b(r2, r3, r0)
    L_0x019f:
        if (r8 == 0) goto L_0x01ea
        r0 = 1
        r8.mo39836a(r0)
        r8.mo39843g()
        goto L_0x01ea
    L_0x01a9:
        r14 = r15
        mtopsdk.common.util.TBSdkLog$LogEnable r5 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable
        boolean r5 = mtopsdk.common.util.TBSdkLog.m35509b(r5)
        if (r5 == 0) goto L_0x01b7
        java.lang.String r5 = "onReceive: ON_HEADER."
        mtopsdk.common.util.TBSdkLog.m35507b(r2, r3, r5)
    L_0x01b7:
        mtopsdk.mtop.common.g r5 = r0.f22563a     // Catch:{ all -> 0x01c3 }
        com.taobao.tao.remotebusiness.e r5 = (com.taobao.tao.remotebusiness.IRemoteProcessListener) r5     // Catch:{ all -> 0x01c3 }
        mtopsdk.mtop.common.d r0 = r0.f22564b     // Catch:{ all -> 0x01c3 }
        mtopsdk.mtop.common.f r0 = (mtopsdk.mtop.common.MtopHeaderEvent) r0     // Catch:{ all -> 0x01c3 }
        r5.mo32727a(r0, r4)     // Catch:{ all -> 0x01c3 }
        goto L_0x01ea
    L_0x01c3:
        r0 = move-exception
        java.lang.String r4 = "listener onHeader callback error."
        mtopsdk.common.util.TBSdkLog.m35508b(r2, r3, r4, r0)
        goto L_0x01ea
    L_0x01ca:
        r14 = r15
        mtopsdk.common.util.TBSdkLog$LogEnable r5 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable
        boolean r5 = mtopsdk.common.util.TBSdkLog.m35509b(r5)
        if (r5 == 0) goto L_0x01d8
        java.lang.String r5 = "onReceive: ON_DATA_RECEIVED."
        mtopsdk.common.util.TBSdkLog.m35507b(r2, r3, r5)
    L_0x01d8:
        mtopsdk.mtop.common.g r5 = r0.f22563a     // Catch:{ all -> 0x01e4 }
        com.taobao.tao.remotebusiness.e r5 = (com.taobao.tao.remotebusiness.IRemoteProcessListener) r5     // Catch:{ all -> 0x01e4 }
        mtopsdk.mtop.common.d r0 = r0.f22564b     // Catch:{ all -> 0x01e4 }
        mtopsdk.mtop.common.h r0 = (mtopsdk.mtop.common.MtopProgressEvent) r0     // Catch:{ all -> 0x01e4 }
        r5.mo32728a(r0, r4)     // Catch:{ all -> 0x01e4 }
        goto L_0x01ea
    L_0x01e4:
        r0 = move-exception
        java.lang.String r4 = "listener onDataReceived callback error."
        mtopsdk.common.util.TBSdkLog.m35508b(r2, r3, r4, r0)
    L_0x01ea:
        r2 = 0
    L_0x01eb:
        r1.obj = r2
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.p576a.HandlerMgr.handleMessage(android.os.Message):void");
    }

    /* renamed from: a */
    public static HandlerParam m29124a(MtopListener gVar, MtopEvent dVar, MtopBusiness fVar) {
        return new HandlerParam(gVar, dVar, fVar);
    }
}
