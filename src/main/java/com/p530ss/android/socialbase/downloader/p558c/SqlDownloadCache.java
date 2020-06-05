package com.p530ss.android.socialbase.downloader.p558c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.p530ss.android.socialbase.downloader.p557b.DBDefinition;
import com.p530ss.android.socialbase.downloader.p558c.ISqlDownloadCacheAidl.C6642a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* renamed from: com.ss.android.socialbase.downloader.c.e */
public class SqlDownloadCache extends C6642a implements ISqlDownloadCache {
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: b */
    public static volatile SQLiteDatabase f21728b;
    /* renamed from: a */
    ISqlCacheLoadCompleteCallbackAidl f21729a;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public TableStatements f21730c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public TableStatements f21731d;
    /* access modifiers changed from: private|volatile */
    /* renamed from: e */
    public volatile boolean f21732e;

    /* renamed from: a */
    public void mo31672a(int i, List<DownloadChunk> list) {
    }

    /* renamed from: b */
    public List<DownloadInfo> mo31679b(String str) {
        return null;
    }

    /* renamed from: b */
    public void mo31683b(DownloadInfo cVar) {
    }

    /* renamed from: c */
    public List<DownloadInfo> mo31686c(String str) {
        return null;
    }

    /* renamed from: d */
    public List<DownloadInfo> mo31689d(String str) {
        return null;
    }

    /* renamed from: d */
    public boolean mo31691d() {
        return false;
    }

    /* renamed from: g */
    public DownloadInfo mo31695g(int i) {
        return null;
    }

    public SqlDownloadCache() {
        this(false);
    }

    public SqlDownloadCache(boolean z) {
        this.f21729a = null;
        if (z) {
            this.f21732e = false;
            mo31668a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m27093f() {
        if (f21728b == null) {
            synchronized (SqlDownloadCache.class) {
                if (f21728b == null) {
                    try {
                        f21728b = DownloadDBHelper.m26988a().getWritableDatabase();
                        this.f21730c = new TableStatements(f21728b, "downloader", DBDefinition.f21685a, DBDefinition.f21686b);
                        this.f21731d = new TableStatements(f21728b, "downloadChunk", DBDefinition.f21687c, DBDefinition.f21688d);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo31668a() {
        mo31704a(null, null, (SqlCacheLoadCompleteCallback) null);
    }

    /* renamed from: a */
    public void mo31704a(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<DownloadChunk>> sparseArray2, final SqlCacheLoadCompleteCallback dVar) {
        try {
            C66441 r0 = new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:111:0x01ad, code lost:
            if (r0 == null) goto L_0x01d0;
     */
                /* JADX WARNING: Code restructure failed: missing block: B:119:0x01c6, code lost:
            if (r0 != null) goto L_0x01c8;
     */
                /* JADX WARNING: Code restructure failed: missing block: B:120:0x01c8, code lost:
            r0.mo31702a();
            com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.m27084a(r1.f21736d, true);
     */
                /* JADX WARNING: Code restructure failed: missing block: B:121:0x01d0, code lost:
            r1.f21736d.mo31703a(r8, r9);
     */
                /* JADX WARNING: Code restructure failed: missing block: B:167:0x0273, code lost:
            if (r0 == null) goto L_0x01d0;
     */
                /* JADX WARNING: Code restructure failed: missing block: B:175:0x028d, code lost:
            if (r0 == null) goto L_0x01d0;
     */
                /* JADX WARNING: Code restructure failed: missing block: B:176:0x0291, code lost:
            return;
     */
                /* JADX WARNING: Code restructure failed: missing block: B:221:0x032c, code lost:
            if (r0 == null) goto L_0x034f;
     */
                /* JADX WARNING: Code restructure failed: missing block: B:229:0x0345, code lost:
            if (r0 == null) goto L_0x034f;
     */
                /* JADX WARNING: Code restructure failed: missing block: B:230:0x0347, code lost:
            r0.mo31702a();
            com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.m27084a(r1.f21736d, true);
     */
                /* JADX WARNING: Code restructure failed: missing block: B:231:0x034f, code lost:
            r1.f21736d.mo31703a(r8, r9);
     */
                /* JADX WARNING: Code restructure failed: missing block: B:232:0x0354, code lost:
            throw r14;
     */
                /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b1, code lost:
            if (r6.mo32180Z() <= 0) goto L_0x00bf;
     */
                /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bd, code lost:
            if (r6.mo32211aN() == false) goto L_0x00bf;
     */
                /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d4, code lost:
            if (r7.exists() == false) goto L_0x00d6;
     */
                /* JADX WARNING: Removed duplicated region for block: B:46:0x00ca A[Catch:{ all -> 0x01d7 }] */
                /* JADX WARNING: Removed duplicated region for block: B:52:0x00d9 A[Catch:{ all -> 0x01d7 }] */
                /* JADX WARNING: Removed duplicated region for block: B:53:0x00e9 A[Catch:{ all -> 0x01d7 }] */
                public void run() {
                    /*
                    r19 = this;
                    r1 = r19
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.m27093f()
                    android.database.sqlite.SQLiteDatabase r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.f21728b
                    if (r0 != 0) goto L_0x000e
                    return
                L_0x000e:
                    android.util.SparseArray r0 = r2
                    if (r0 != 0) goto L_0x0017
                    android.util.SparseArray r0 = new android.util.SparseArray
                    r0.<init>()
                L_0x0017:
                    r8 = r0
                    android.util.SparseArray r0 = r3
                    if (r0 != 0) goto L_0x0021
                    android.util.SparseArray r0 = new android.util.SparseArray
                    r0.<init>()
                L_0x0021:
                    r9 = r0
                    com.ss.android.socialbase.downloader.downloader.l r0 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27387s()
                    android.util.SparseArray r5 = new android.util.SparseArray
                    r5.<init>()
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.ArrayList r3 = new java.util.ArrayList
                    r3.<init>()
                    r2 = 0
                    r10 = 8192(0x2000, float:1.14794E-41)
                    r11 = 0
                    r12 = -3
                    r13 = 1
                    android.database.sqlite.SQLiteDatabase r6 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.f21728b     // Catch:{ all -> 0x01d7 }
                    java.lang.String r7 = "SELECT * FROM downloader"
                    android.database.Cursor r2 = r6.rawQuery(r7, r2)     // Catch:{ all -> 0x01d7 }
                L_0x0045:
                    boolean r6 = r2.moveToNext()     // Catch:{ all -> 0x01d7 }
                    if (r6 == 0) goto L_0x0115
                    com.ss.android.socialbase.downloader.g.c r6 = new com.ss.android.socialbase.downloader.g.c     // Catch:{ all -> 0x01d7 }
                    r6.m51566init(r2)     // Catch:{ all -> 0x01d7 }
                    boolean r7 = r6.mo32217aT()     // Catch:{ all -> 0x01d7 }
                    if (r7 == 0) goto L_0x005a
                    r7 = -5
                    r6.mo32251b(r7)     // Catch:{ all -> 0x01d7 }
                L_0x005a:
                    java.lang.String r7 = r6.mo32297k()     // Catch:{ all -> 0x01d7 }
                    boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01d7 }
                    if (r7 != 0) goto L_0x00d6
                    java.lang.String r7 = r6.mo32287h()     // Catch:{ all -> 0x01d7 }
                    boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01d7 }
                    if (r7 == 0) goto L_0x006f
                    goto L_0x00d6
                L_0x006f:
                    java.io.File r7 = new java.io.File     // Catch:{ all -> 0x01d7 }
                    java.lang.String r14 = r6.mo32297k()     // Catch:{ all -> 0x01d7 }
                    java.lang.String r15 = r6.mo32287h()     // Catch:{ all -> 0x01d7 }
                    r7.<init>(r14, r15)     // Catch:{ all -> 0x01d7 }
                    r14 = 131072(0x20000, float:1.83671E-40)
                    boolean r14 = com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode.m28744a(r14)     // Catch:{ all -> 0x01d7 }
                    r15 = 0
                    if (r14 == 0) goto L_0x00a5
                    int r14 = r6.mo32308q()     // Catch:{ all -> 0x01d7 }
                    if (r14 != r13) goto L_0x0095
                    long r17 = r6.mo32180Z()     // Catch:{ all -> 0x01d7 }
                    int r14 = (r17 > r15 ? 1 : (r17 == r15 ? 0 : -1))
                    if (r14 > 0) goto L_0x0095
                    goto L_0x00bf
                L_0x0095:
                    int r14 = r6.mo32308q()     // Catch:{ all -> 0x01d7 }
                    if (r14 == r12) goto L_0x00c1
                    boolean r14 = r6.mo32211aN()     // Catch:{ all -> 0x01d7 }
                    if (r14 != 0) goto L_0x00c1
                    r6.mo32210aM()     // Catch:{ all -> 0x01d7 }
                    goto L_0x00c1
                L_0x00a5:
                    int r14 = r6.mo32308q()     // Catch:{ all -> 0x01d7 }
                    if (r14 != r13) goto L_0x00b3
                    long r17 = r6.mo32180Z()     // Catch:{ all -> 0x01d7 }
                    int r14 = (r17 > r15 ? 1 : (r17 == r15 ? 0 : -1))
                    if (r14 <= 0) goto L_0x00bf
                L_0x00b3:
                    int r14 = r6.mo32308q()     // Catch:{ all -> 0x01d7 }
                    if (r14 == r12) goto L_0x00c1
                    boolean r14 = r6.mo32211aN()     // Catch:{ all -> 0x01d7 }
                    if (r14 != 0) goto L_0x00c1
                L_0x00bf:
                    r14 = 1
                    goto L_0x00c2
                L_0x00c1:
                    r14 = 0
                L_0x00c2:
                    r15 = 33554432(0x2000000, float:9.403955E-38)
                    boolean r15 = com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode.m28744a(r15)     // Catch:{ all -> 0x01d7 }
                    if (r15 == 0) goto L_0x00d7
                    int r15 = r6.mo32308q()     // Catch:{ all -> 0x01d7 }
                    if (r15 != r12) goto L_0x00d7
                    boolean r7 = r7.exists()     // Catch:{ all -> 0x01d7 }
                    if (r7 != 0) goto L_0x00d7
                L_0x00d6:
                    r14 = 1
                L_0x00d7:
                    if (r14 == 0) goto L_0x00e9
                    int r7 = r6.mo32283g()     // Catch:{ all -> 0x01d7 }
                    java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x01d7 }
                    r4.add(r7)     // Catch:{ all -> 0x01d7 }
                    r3.add(r6)     // Catch:{ all -> 0x01d7 }
                    goto L_0x0045
                L_0x00e9:
                    int r7 = r6.mo32283g()     // Catch:{ all -> 0x01d7 }
                    if (r0 == 0) goto L_0x00fc
                    java.lang.String r14 = r6.mo32295j()     // Catch:{ all -> 0x01d7 }
                    java.lang.String r15 = r6.mo32297k()     // Catch:{ all -> 0x01d7 }
                    int r14 = r0.mo32011a(r14, r15)     // Catch:{ all -> 0x01d7 }
                    goto L_0x00fd
                L_0x00fc:
                    r14 = 0
                L_0x00fd:
                    if (r14 == r7) goto L_0x0105
                    r6.mo32284g(r14)     // Catch:{ all -> 0x01d7 }
                    r5.put(r7, r6)     // Catch:{ all -> 0x01d7 }
                L_0x0105:
                    if (r8 == 0) goto L_0x0045
                    monitor-enter(r8)     // Catch:{ all -> 0x01d7 }
                    int r7 = r6.mo32283g()     // Catch:{ all -> 0x0112 }
                    r8.put(r7, r6)     // Catch:{ all -> 0x0112 }
                    monitor-exit(r8)     // Catch:{ all -> 0x0112 }
                    goto L_0x0045
                L_0x0112:
                    r0 = move-exception
                    monitor-exit(r8)     // Catch:{ all -> 0x0112 }
                    throw r0     // Catch:{ all -> 0x01d7 }
                L_0x0115:
                    if (r2 == 0) goto L_0x0120
                    r2.close()     // Catch:{ all -> 0x011b }
                    goto L_0x0120
                L_0x011b:
                    r0 = move-exception
                    r2 = r0
                    r2.printStackTrace()
                L_0x0120:
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.m27082a(r3)
                    com.ss.android.socialbase.downloader.c.e r2 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r6 = r8
                    r7 = r9
                    r2.m27083a(r3, r4, r5, r6, r7)
                    if (r8 == 0) goto L_0x01c4
                    monitor-enter(r8)     // Catch:{ all -> 0x01a7 }
                    java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x01a4 }
                    r0.<init>()     // Catch:{ all -> 0x01a4 }
                L_0x0134:
                    int r2 = r8.size()     // Catch:{ all -> 0x01a4 }
                    if (r11 >= r2) goto L_0x018a
                    int r2 = r8.keyAt(r11)     // Catch:{ all -> 0x01a4 }
                    if (r2 == 0) goto L_0x0187
                    java.lang.Object r2 = r8.get(r2)     // Catch:{ all -> 0x01a4 }
                    com.ss.android.socialbase.downloader.g.c r2 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r2     // Catch:{ all -> 0x01a4 }
                    boolean r3 = com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode.m28744a(r10)     // Catch:{ all -> 0x01a4 }
                    if (r3 == 0) goto L_0x016d
                    if (r2 == 0) goto L_0x0187
                    boolean r3 = r2.mo32212aO()     // Catch:{ all -> 0x01a4 }
                    if (r3 != 0) goto L_0x0187
                    int r3 = r2.mo32308q()     // Catch:{ all -> 0x01a4 }
                    if (r3 == r12) goto L_0x0187
                    int r3 = r2.mo32283g()     // Catch:{ all -> 0x01a4 }
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01a4 }
                    r0.add(r3)     // Catch:{ all -> 0x01a4 }
                    int r2 = r2.mo32283g()     // Catch:{ all -> 0x01a4 }
                    r9.remove(r2)     // Catch:{ all -> 0x01a4 }
                    goto L_0x0187
                L_0x016d:
                    if (r2 == 0) goto L_0x0187
                    boolean r3 = r2.mo32212aO()     // Catch:{ all -> 0x01a4 }
                    if (r3 != 0) goto L_0x0187
                    int r3 = r2.mo32283g()     // Catch:{ all -> 0x01a4 }
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01a4 }
                    r0.add(r3)     // Catch:{ all -> 0x01a4 }
                    int r2 = r2.mo32283g()     // Catch:{ all -> 0x01a4 }
                    r9.remove(r2)     // Catch:{ all -> 0x01a4 }
                L_0x0187:
                    int r11 = r11 + 1
                    goto L_0x0134
                L_0x018a:
                    java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x01a4 }
                L_0x018e:
                    boolean r2 = r0.hasNext()     // Catch:{ all -> 0x01a4 }
                    if (r2 == 0) goto L_0x01a2
                    java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x01a4 }
                    java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x01a4 }
                    int r2 = r2.intValue()     // Catch:{ all -> 0x01a4 }
                    r8.remove(r2)     // Catch:{ all -> 0x01a4 }
                    goto L_0x018e
                L_0x01a2:
                    monitor-exit(r8)     // Catch:{ all -> 0x01a4 }
                    goto L_0x01c4
                L_0x01a4:
                    r0 = move-exception
                    monitor-exit(r8)     // Catch:{ all -> 0x01a4 }
                    throw r0     // Catch:{ all -> 0x01a7 }
                L_0x01a7:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch:{ all -> 0x01b0 }
                    com.ss.android.socialbase.downloader.c.d r0 = r4
                    if (r0 == 0) goto L_0x01d0
                    goto L_0x01c8
                L_0x01b0:
                    r0 = move-exception
                    r2 = r0
                    com.ss.android.socialbase.downloader.c.d r0 = r4
                    if (r0 == 0) goto L_0x01be
                    r0.mo31702a()
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.f21732e = r13
                L_0x01be:
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.mo31703a(r8, r9)
                    throw r2
                L_0x01c4:
                    com.ss.android.socialbase.downloader.c.d r0 = r4
                    if (r0 == 0) goto L_0x01d0
                L_0x01c8:
                    r0.mo31702a()
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.f21732e = r13
                L_0x01d0:
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.mo31703a(r8, r9)
                    goto L_0x0291
                L_0x01d7:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch:{ all -> 0x0292 }
                    if (r2 == 0) goto L_0x01e6
                    r2.close()     // Catch:{ all -> 0x01e1 }
                    goto L_0x01e6
                L_0x01e1:
                    r0 = move-exception
                    r2 = r0
                    r2.printStackTrace()
                L_0x01e6:
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.m27082a(r3)
                    com.ss.android.socialbase.downloader.c.e r2 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r6 = r8
                    r7 = r9
                    r2.m27083a(r3, r4, r5, r6, r7)
                    if (r8 == 0) goto L_0x028b
                    monitor-enter(r8)     // Catch:{ all -> 0x026d }
                    java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x026a }
                    r0.<init>()     // Catch:{ all -> 0x026a }
                L_0x01fa:
                    int r2 = r8.size()     // Catch:{ all -> 0x026a }
                    if (r11 >= r2) goto L_0x0250
                    int r2 = r8.keyAt(r11)     // Catch:{ all -> 0x026a }
                    if (r2 == 0) goto L_0x024d
                    java.lang.Object r2 = r8.get(r2)     // Catch:{ all -> 0x026a }
                    com.ss.android.socialbase.downloader.g.c r2 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r2     // Catch:{ all -> 0x026a }
                    boolean r3 = com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode.m28744a(r10)     // Catch:{ all -> 0x026a }
                    if (r3 == 0) goto L_0x0233
                    if (r2 == 0) goto L_0x024d
                    boolean r3 = r2.mo32212aO()     // Catch:{ all -> 0x026a }
                    if (r3 != 0) goto L_0x024d
                    int r3 = r2.mo32308q()     // Catch:{ all -> 0x026a }
                    if (r3 == r12) goto L_0x024d
                    int r3 = r2.mo32283g()     // Catch:{ all -> 0x026a }
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x026a }
                    r0.add(r3)     // Catch:{ all -> 0x026a }
                    int r2 = r2.mo32283g()     // Catch:{ all -> 0x026a }
                    r9.remove(r2)     // Catch:{ all -> 0x026a }
                    goto L_0x024d
                L_0x0233:
                    if (r2 == 0) goto L_0x024d
                    boolean r3 = r2.mo32212aO()     // Catch:{ all -> 0x026a }
                    if (r3 != 0) goto L_0x024d
                    int r3 = r2.mo32283g()     // Catch:{ all -> 0x026a }
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x026a }
                    r0.add(r3)     // Catch:{ all -> 0x026a }
                    int r2 = r2.mo32283g()     // Catch:{ all -> 0x026a }
                    r9.remove(r2)     // Catch:{ all -> 0x026a }
                L_0x024d:
                    int r11 = r11 + 1
                    goto L_0x01fa
                L_0x0250:
                    java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x026a }
                L_0x0254:
                    boolean r2 = r0.hasNext()     // Catch:{ all -> 0x026a }
                    if (r2 == 0) goto L_0x0268
                    java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x026a }
                    java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x026a }
                    int r2 = r2.intValue()     // Catch:{ all -> 0x026a }
                    r8.remove(r2)     // Catch:{ all -> 0x026a }
                    goto L_0x0254
                L_0x0268:
                    monitor-exit(r8)     // Catch:{ all -> 0x026a }
                    goto L_0x028b
                L_0x026a:
                    r0 = move-exception
                    monitor-exit(r8)     // Catch:{ all -> 0x026a }
                    throw r0     // Catch:{ all -> 0x026d }
                L_0x026d:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch:{ all -> 0x0277 }
                    com.ss.android.socialbase.downloader.c.d r0 = r4
                    if (r0 == 0) goto L_0x01d0
                    goto L_0x01c8
                L_0x0277:
                    r0 = move-exception
                    r2 = r0
                    com.ss.android.socialbase.downloader.c.d r0 = r4
                    if (r0 == 0) goto L_0x0285
                    r0.mo31702a()
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.f21732e = r13
                L_0x0285:
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.mo31703a(r8, r9)
                    throw r2
                L_0x028b:
                    com.ss.android.socialbase.downloader.c.d r0 = r4
                    if (r0 == 0) goto L_0x01d0
                    goto L_0x01c8
                L_0x0291:
                    return
                L_0x0292:
                    r0 = move-exception
                    r14 = r0
                    if (r2 == 0) goto L_0x029f
                    r2.close()     // Catch:{ all -> 0x029a }
                    goto L_0x029f
                L_0x029a:
                    r0 = move-exception
                    r2 = r0
                    r2.printStackTrace()
                L_0x029f:
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.m27082a(r3)
                    com.ss.android.socialbase.downloader.c.e r2 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r6 = r8
                    r7 = r9
                    r2.m27083a(r3, r4, r5, r6, r7)
                    if (r8 == 0) goto L_0x0343
                    monitor-enter(r8)     // Catch:{ all -> 0x0326 }
                    java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0323 }
                    r0.<init>()     // Catch:{ all -> 0x0323 }
                L_0x02b3:
                    int r2 = r8.size()     // Catch:{ all -> 0x0323 }
                    if (r11 >= r2) goto L_0x0309
                    int r2 = r8.keyAt(r11)     // Catch:{ all -> 0x0323 }
                    if (r2 == 0) goto L_0x0306
                    java.lang.Object r2 = r8.get(r2)     // Catch:{ all -> 0x0323 }
                    com.ss.android.socialbase.downloader.g.c r2 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r2     // Catch:{ all -> 0x0323 }
                    boolean r3 = com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode.m28744a(r10)     // Catch:{ all -> 0x0323 }
                    if (r3 == 0) goto L_0x02ec
                    if (r2 == 0) goto L_0x0306
                    boolean r3 = r2.mo32212aO()     // Catch:{ all -> 0x0323 }
                    if (r3 != 0) goto L_0x0306
                    int r3 = r2.mo32308q()     // Catch:{ all -> 0x0323 }
                    if (r3 == r12) goto L_0x0306
                    int r3 = r2.mo32283g()     // Catch:{ all -> 0x0323 }
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0323 }
                    r0.add(r3)     // Catch:{ all -> 0x0323 }
                    int r2 = r2.mo32283g()     // Catch:{ all -> 0x0323 }
                    r9.remove(r2)     // Catch:{ all -> 0x0323 }
                    goto L_0x0306
                L_0x02ec:
                    if (r2 == 0) goto L_0x0306
                    boolean r3 = r2.mo32212aO()     // Catch:{ all -> 0x0323 }
                    if (r3 != 0) goto L_0x0306
                    int r3 = r2.mo32283g()     // Catch:{ all -> 0x0323 }
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0323 }
                    r0.add(r3)     // Catch:{ all -> 0x0323 }
                    int r2 = r2.mo32283g()     // Catch:{ all -> 0x0323 }
                    r9.remove(r2)     // Catch:{ all -> 0x0323 }
                L_0x0306:
                    int r11 = r11 + 1
                    goto L_0x02b3
                L_0x0309:
                    java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0323 }
                L_0x030d:
                    boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0323 }
                    if (r2 == 0) goto L_0x0321
                    java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0323 }
                    java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0323 }
                    int r2 = r2.intValue()     // Catch:{ all -> 0x0323 }
                    r8.remove(r2)     // Catch:{ all -> 0x0323 }
                    goto L_0x030d
                L_0x0321:
                    monitor-exit(r8)     // Catch:{ all -> 0x0323 }
                    goto L_0x0343
                L_0x0323:
                    r0 = move-exception
                    monitor-exit(r8)     // Catch:{ all -> 0x0323 }
                    throw r0     // Catch:{ all -> 0x0326 }
                L_0x0326:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch:{ all -> 0x032f }
                    com.ss.android.socialbase.downloader.c.d r0 = r4
                    if (r0 == 0) goto L_0x034f
                    goto L_0x0347
                L_0x032f:
                    r0 = move-exception
                    r2 = r0
                    com.ss.android.socialbase.downloader.c.d r0 = r4
                    if (r0 == 0) goto L_0x033d
                    r0.mo31702a()
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.f21732e = r13
                L_0x033d:
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.mo31703a(r8, r9)
                    throw r2
                L_0x0343:
                    com.ss.android.socialbase.downloader.c.d r0 = r4
                    if (r0 == 0) goto L_0x034f
                L_0x0347:
                    r0.mo31702a()
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.f21732e = r13
                L_0x034f:
                    com.ss.android.socialbase.downloader.c.e r0 = com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.this
                    r0.mo31703a(r8, r9)
                    throw r14
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.C66441.run():void");
                }
            };
            ExecutorService m = C6694b.m27381m();
            if (m != null) {
                m.execute(r0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27082a(List<DownloadInfo> list) {
        if (list != null) {
            try {
                for (DownloadInfo cVar : list) {
                    if (cVar != null && cVar.mo32259be()) {
                        DownloadUtils.m28787b(cVar);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: g */
    private void m27094g() {
        f21728b.beginTransaction();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27083a(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<DownloadChunk>> sparseArray3) {
        SparseArray<DownloadInfo> sparseArray4 = sparseArray;
        SparseArray<DownloadInfo> sparseArray5 = sparseArray2;
        SparseArray<List<DownloadChunk>> sparseArray6 = sparseArray3;
        int size = sparseArray.size();
        if (size >= 0 && f21728b != null) {
            synchronized (f21728b) {
                try {
                    m27094g();
                    if (!list.isEmpty()) {
                        if (DownloadSetting.m28617b().mo32550a("clear_invalid_task_error")) {
                            String[] strArr = new String[list.size()];
                            for (int i = 0; i < list.size(); i++) {
                                strArr[i] = String.valueOf(list.get(i));
                            }
                            List<DownloadInfo> list3 = list;
                            StringBuilder sb = new StringBuilder();
                            sb.append("CAST(_id AS TEXT) IN (");
                            sb.append(new String(new char[(list.size() - 1)]).replace("\u0000", "?,"));
                            sb.append("?)");
                            String sb2 = sb.toString();
                            f21728b.delete("downloader", sb2, strArr);
                            f21728b.delete("downloadChunk", sb2, strArr);
                        } else {
                            String join = TextUtils.join(", ", list2);
                            f21728b.delete("downloader", "_id IN (?)", new String[]{join});
                            f21728b.delete("downloadChunk", "_id IN (?)", new String[]{join});
                        }
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        int keyAt = sparseArray4.keyAt(i2);
                        DownloadInfo cVar = (DownloadInfo) sparseArray4.get(keyAt);
                        f21728b.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                        f21728b.insert("downloader", null, cVar.mo32273e());
                        if (cVar.mo32219aV() > 1) {
                            List<DownloadChunk> c = mo31685c(keyAt);
                            if (c.size() > 0) {
                                f21728b.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                                for (DownloadChunk bVar : c) {
                                    bVar.mo32119b(cVar.mo32283g());
                                    f21728b.insert("downloadChunk", null, bVar.mo32109a());
                                }
                            }
                        }
                    }
                    if (!(sparseArray5 == null || sparseArray6 == null)) {
                        synchronized (sparseArray2) {
                            int size2 = sparseArray2.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                int g = ((DownloadInfo) sparseArray5.valueAt(i3)).mo32283g();
                                List a = DownloadUtils.m28758a(mo31685c(g));
                                if (a != null && a.size() > 0) {
                                    sparseArray6.put(g, a);
                                }
                            }
                        }
                    }
                    f21728b.setTransactionSuccessful();
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        m27095h();
                        throw th3;
                    }
                }
                try {
                    m27095h();
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo31675a(int i) {
        boolean z = false;
        try {
            if (mo31677b(i) != null) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e A[SYNTHETIC, Splitter:B:23:0x004e] */
    /* renamed from: b */
    public com.p530ss.android.socialbase.downloader.p562g.DownloadInfo mo31677b(int r8) {
        /*
        r7 = this;
        r7.m27093f()
        android.database.sqlite.SQLiteDatabase r0 = f21728b
        r1 = 0
        if (r0 == 0) goto L_0x0063
        android.database.sqlite.SQLiteDatabase r0 = f21728b     // Catch:{ all -> 0x0047 }
        java.lang.String r2 = "SELECT * FROM %s WHERE %s = ?"
        r3 = 2
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0047 }
        java.lang.String r4 = "downloader"
        r5 = 0
        r3[r5] = r4     // Catch:{ all -> 0x0047 }
        java.lang.String r4 = "_id"
        r6 = 1
        r3[r6] = r4     // Catch:{ all -> 0x0047 }
        java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ all -> 0x0047 }
        java.lang.String[] r3 = new java.lang.String[r6]     // Catch:{ all -> 0x0047 }
        java.lang.String r8 = java.lang.Integer.toString(r8)     // Catch:{ all -> 0x0047 }
        r3[r5] = r8     // Catch:{ all -> 0x0047 }
        android.database.Cursor r8 = r0.rawQuery(r2, r3)     // Catch:{ all -> 0x0047 }
        boolean r0 = r8.moveToNext()     // Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x003f
        com.ss.android.socialbase.downloader.g.c r0 = new com.ss.android.socialbase.downloader.g.c     // Catch:{ all -> 0x0045 }
        r0.m51566init(r8)     // Catch:{ all -> 0x0045 }
        if (r8 == 0) goto L_0x003e
        r8.close()     // Catch:{ all -> 0x003a }
        goto L_0x003e
    L_0x003a:
        r8 = move-exception
        r8.printStackTrace()
    L_0x003e:
        return r0
    L_0x003f:
        if (r8 == 0) goto L_0x0063
        r8.close()     // Catch:{ all -> 0x0052 }
        goto L_0x0063
    L_0x0045:
        r0 = move-exception
        goto L_0x0049
    L_0x0047:
        r0 = move-exception
        r8 = r1
    L_0x0049:
        r0.printStackTrace()     // Catch:{ all -> 0x0057 }
        if (r8 == 0) goto L_0x0063
        r8.close()     // Catch:{ all -> 0x0052 }
        goto L_0x0063
    L_0x0052:
        r8 = move-exception
        r8.printStackTrace()
        goto L_0x0063
    L_0x0057:
        r0 = move-exception
        if (r8 == 0) goto L_0x0062
        r8.close()     // Catch:{ all -> 0x005e }
        goto L_0x0062
    L_0x005e:
        r8 = move-exception
        r8.printStackTrace()
    L_0x0062:
        throw r0
    L_0x0063:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache.mo31677b(int):com.ss.android.socialbase.downloader.g.c");
    }

    /* renamed from: a */
    public List<DownloadInfo> mo31667a(String str) {
        m27093f();
        ArrayList arrayList = new ArrayList();
        if (f21728b != null) {
            Cursor cursor = null;
            try {
                Cursor rawQuery = f21728b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{"downloader", "url"}), new String[]{str});
                if (rawQuery.moveToNext()) {
                    arrayList.add(new DownloadInfo(rawQuery));
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public List<DownloadChunk> mo31685c(int i) {
        ArrayList arrayList = new ArrayList();
        m27093f();
        if (f21728b != null) {
            Cursor cursor = null;
            try {
                Cursor rawQuery = f21728b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{"downloadChunk", C7887a.f26833ID}), new String[]{Integer.toString(i)});
                while (rawQuery.moveToNext()) {
                    arrayList.add(new DownloadChunk(rawQuery));
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public void mo31690d(final int i) {
        m27093f();
        if (!(f21728b == null || this.f21731d == null)) {
            if (DownloadUtils.m28807d()) {
                ExecutorService m = C6694b.m27381m();
                if (m != null) {
                    m.execute(new Runnable() {
                        public void run() {
                            try {
                                SqlDownloadCache.this.m27068a(i, SqlDownloadCache.this.f21731d.mo31727b());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            } else {
                try {
                    m27068a(i, this.f21731d.mo31727b());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27068a(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    sQLiteStatement.bindLong(1, (long) i);
                    sQLiteStatement.execute();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo31674a(final DownloadChunk bVar) {
        m27093f();
        if (!(f21728b == null || this.f21731d == null)) {
            if (DownloadUtils.m28807d()) {
                ExecutorService m = C6694b.m27381m();
                if (m != null) {
                    m.execute(new Runnable() {
                        public void run() {
                            try {
                                SqlDownloadCache.this.m27080a(bVar, SqlDownloadCache.this.f21731d.mo31726a());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            } else {
                try {
                    m27080a(bVar, this.f21731d.mo31726a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo31682b(DownloadChunk bVar) {
        mo31674a(bVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27081a(DownloadInfo cVar, SQLiteStatement sQLiteStatement) {
        if (cVar != null && sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    cVar.mo32184a(sQLiteStatement);
                    sQLiteStatement.executeInsert();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27080a(DownloadChunk bVar, SQLiteStatement sQLiteStatement) {
        if (bVar != null && sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    bVar.mo32113a(sQLiteStatement);
                    sQLiteStatement.executeInsert();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo31671a(int i, int i2, long j) {
        m27093f();
        if (!(i == 0 || i2 < 0 || j < 0 || f21728b == null || this.f21731d == null)) {
            if (DownloadUtils.m28807d()) {
                ExecutorService m = C6694b.m27381m();
                if (m != null) {
                    final int i3 = i;
                    final int i4 = i2;
                    final long j2 = j;
                    C66538 r1 = new Runnable() {
                        public void run() {
                            try {
                                SqlDownloadCache.this.m27066a(i3, i4, j2, SqlDownloadCache.this.f21731d.mo31728c());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    };
                    m.execute(r1);
                }
            } else {
                try {
                    m27066a(i, i2, j, this.f21731d.mo31728c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo31670a(int i, int i2, int i3, long j) {
        m27093f();
        if (i != 0 && i2 >= 0 && i3 >= 0 && j >= 0 && f21728b != null && this.f21731d != null) {
            if (DownloadUtils.m28807d()) {
                ExecutorService m = C6694b.m27381m();
                if (m != null) {
                    final int i4 = i;
                    final int i5 = i2;
                    final int i6 = i3;
                    final long j2 = j;
                    C66549 r1 = new Runnable() {
                        public void run() {
                            try {
                                SqlDownloadCache.this.m27065a(i4, i5, i6, j2, SqlDownloadCache.this.f21731d.mo31728c());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    };
                    m.execute(r1);
                }
            } else {
                try {
                    m27065a(i, i2, i3, j, this.f21731d.mo31728c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo31669a(int i, int i2, int i3, int i4) {
        m27093f();
        if (!(i == 0 || i3 < 0 || i4 == i2 || i4 < 0 || f21728b == null || this.f21731d == null)) {
            if (DownloadUtils.m28807d()) {
                ExecutorService m = C6694b.m27381m();
                if (m != null) {
                    final int i5 = i;
                    final int i6 = i2;
                    final int i7 = i3;
                    final int i8 = i4;
                    C664510 r1 = new Runnable() {
                        public void run() {
                            try {
                                SqlDownloadCache.this.m27064a(i5, i6, i7, i8, SqlDownloadCache.this.f21731d.mo31728c());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    };
                    m.execute(r1);
                }
            } else {
                try {
                    m27064a(i, i2, i3, i4, this.f21731d.mo31728c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27064a(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                f21728b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27066a(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                f21728b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27065a(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                f21728b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m27087b(DownloadInfo cVar, SQLiteStatement sQLiteStatement) {
        if (cVar != null && sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    cVar.mo32184a(sQLiteStatement);
                    sQLiteStatement.bindLong(cVar.mo32278f() + 1, (long) cVar.mo32283g());
                    sQLiteStatement.execute();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public DownloadInfo mo31664a(int i, int i2) {
        m27093f();
        if (f21728b == null) {
            return null;
        }
        int i3 = 10;
        while (f21728b.isDbLockedByCurrentThread()) {
            try {
                i3--;
                if (i3 < 0) {
                    break;
                }
                Thread.sleep(5);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i2));
        f21728b.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    /* renamed from: c */
    private void m27089c(final DownloadInfo cVar) {
        m27093f();
        if (!(f21728b == null || this.f21730c == null)) {
            if (DownloadUtils.m28807d()) {
                ExecutorService m = C6694b.m27381m();
                if (m != null) {
                    m.execute(new Runnable() {
                        public void run() {
                            try {
                                SqlDownloadCache.this.m27081a(cVar, SqlDownloadCache.this.f21730c.mo31726a());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            } else {
                try {
                    m27081a(cVar, this.f21730c.mo31726a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo31676a(final DownloadInfo cVar) {
        m27093f();
        if (cVar == null || f21728b == null) {
            return false;
        }
        if (DownloadUtils.m28807d()) {
            ExecutorService m = C6694b.m27381m();
            if (m == null) {
                return false;
            }
            m.execute(new Runnable() {
                public void run() {
                    SqlDownloadCache.this.m27091d(cVar);
                }
            });
        } else {
            m27091d(cVar);
        }
        return true;
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: d */
    public synchronized void m27091d(DownloadInfo cVar) {
        if (cVar != null) {
            try {
                if (!mo31675a(cVar.mo32283g())) {
                    m27089c(cVar);
                } else if (this.f21730c != null) {
                    m27087b(cVar, this.f21730c.mo31728c());
                } else {
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            return;
        }
        return;
    }

    /* renamed from: h */
    private void m27095h() {
        try {
            if (f21728b != null && f21728b.inTransaction()) {
                f21728b.endTransaction();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    public boolean mo31693e(int i) {
        m27093f();
        if (f21728b != null) {
            TableStatements gVar = this.f21730c;
            if (gVar != null) {
                try {
                    m27068a(i, gVar.mo31727b());
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo31694f(final int i) {
        if (DownloadUtils.m28807d()) {
            ExecutorService m = C6694b.m27381m();
            if (m == null) {
                return false;
            }
            m.execute(new Runnable() {
                public void run() {
                    SqlDownloadCache.this.mo31693e(i);
                    SqlDownloadCache.this.mo31690d(i);
                }
            });
        } else {
            mo31693e(i);
            mo31690d(i);
        }
        return true;
    }

    /* renamed from: b */
    public void mo31680b() {
        m27093f();
        if (f21728b != null) {
            if (DownloadUtils.m28807d()) {
                ExecutorService m = C6694b.m27381m();
                if (m != null) {
                    m.execute(new Runnable() {
                        public void run() {
                            SqlDownloadCache.this.m27096i();
                        }
                    });
                }
            } else {
                m27096i();
            }
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: i */
    public synchronized void m27096i() {
        try {
            m27094g();
            f21728b.delete("downloader", null, null);
            f21728b.delete("downloadChunk", null, null);
            f21728b.setTransactionSuccessful();
        } catch (Throwable th) {
            m27095h();
            throw th;
        }
        m27095h();
    }

    /* renamed from: a */
    public DownloadInfo mo31666a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(3));
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put(ArgKey.KEY_NAME, str2);
        }
        m27067a(i, contentValues);
        return null;
    }

    /* renamed from: a */
    public DownloadInfo mo31665a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(4));
        contentValues.put("curBytes", Long.valueOf(j));
        m27067a(i, contentValues);
        return null;
    }

    /* renamed from: b */
    public DownloadInfo mo31678b(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", Integer.valueOf(0));
        }
        m27067a(i, contentValues);
        return null;
    }

    /* renamed from: h */
    public DownloadInfo mo31696h(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(5));
        contentValues.put("isFirstDownload", Integer.valueOf(0));
        m27067a(i, contentValues);
        return null;
    }

    /* renamed from: c */
    public DownloadInfo mo31684c(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(-3));
        contentValues.put("curBytes", Long.valueOf(j));
        Integer valueOf = Integer.valueOf(0);
        contentValues.put("isFirstDownload", valueOf);
        contentValues.put("isFirstSuccess", valueOf);
        m27067a(i, contentValues);
        return null;
    }

    /* renamed from: d */
    public DownloadInfo mo31688d(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(-2));
        contentValues.put("curBytes", Long.valueOf(j));
        m27067a(i, contentValues);
        return null;
    }

    /* renamed from: e */
    public DownloadInfo mo31692e(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(-4));
        contentValues.put("curBytes", Long.valueOf(j));
        m27067a(i, contentValues);
        return null;
    }

    /* renamed from: i */
    public DownloadInfo mo31697i(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(1));
        m27067a(i, contentValues);
        return null;
    }

    /* renamed from: j */
    public DownloadInfo mo31698j(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(-7));
        m27067a(i, contentValues);
        return null;
    }

    /* renamed from: c */
    public boolean mo31687c() {
        return this.f21732e;
    }

    /* renamed from: b */
    public void mo31681b(int i, List<DownloadChunk> list) {
        try {
            mo31690d(i);
            if (list != null) {
                for (DownloadChunk bVar : list) {
                    if (bVar != null) {
                        mo31674a(bVar);
                        if (bVar.mo32128f()) {
                            for (DownloadChunk a : bVar.mo32129g()) {
                                mo31674a(a);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m27067a(final int i, final ContentValues contentValues) {
        m27093f();
        if (f21728b != null) {
            if (DownloadUtils.m28807d()) {
                ExecutorService m = C6694b.m27381m();
                if (m != null) {
                    m.execute(new Runnable() {
                        public void run() {
                            SqlDownloadCache.this.m27086b(i, contentValues);
                        }
                    });
                }
            } else {
                m27086b(i, contentValues);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27086b(int i, ContentValues contentValues) {
        int i2 = 10;
        while (f21728b.isDbLockedByCurrentThread()) {
            try {
                i2--;
                if (i2 >= 0) {
                    Thread.sleep(5);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        try {
            f21728b.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo31673a(ISqlCacheLoadCompleteCallbackAidl bVar) {
        this.f21729a = bVar;
    }

    /* renamed from: a */
    public void mo31703a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<DownloadChunk>> sparseArray2) {
        try {
            HashMap a = DownloadUtils.m28757a(sparseArray);
            HashMap a2 = DownloadUtils.m28757a(sparseArray2);
            if (this.f21729a != null) {
                this.f21729a.mo31660a(a, a2);
            }
        } catch (Throwable unused) {
        }
    }
}
