package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.bugly.beta.download.DownloadTask;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.p */
public class C7270p {
    /* renamed from: a */
    public static C7270p f24600a = new C7270p();

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0098, code lost:
            return r1;
     */
    /* renamed from: a */
    public synchronized android.content.ContentValues mo34949a(java.lang.String r10) {
        /*
        r9 = this;
        monitor-enter(r9)
        boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0099 }
        r1 = 0
        if (r0 == 0) goto L_0x000a
        monitor-exit(r9)
        return r1
    L_0x000a:
        com.tencent.bugly.proguard.ae r2 = com.tencent.bugly.proguard.C7212ae.m31041a()     // Catch:{ all -> 0x0099 }
        java.lang.String r3 = "dl_1002"
        r4 = 0
        java.lang.String r5 = "_dUrl=?"
        r0 = 1
        java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ all -> 0x0099 }
        r0 = 0
        r6[r0] = r10     // Catch:{ all -> 0x0099 }
        r7 = 0
        r8 = 1
        android.database.Cursor r10 = r2.mo34775a(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0099 }
        if (r10 == 0) goto L_0x0092
        boolean r0 = r10.moveToFirst()     // Catch:{ all -> 0x0099 }
        if (r0 == 0) goto L_0x0092
        android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ all -> 0x0099 }
        r1.<init>()     // Catch:{ all -> 0x0099 }
        java.lang.String r0 = "_dUrl"
        java.lang.String r2 = "_dUrl"
        int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x0099 }
        java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x0099 }
        r1.put(r0, r2)     // Catch:{ all -> 0x0099 }
        java.lang.String r0 = "_sFile"
        java.lang.String r2 = "_sFile"
        int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x0099 }
        java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x0099 }
        r1.put(r0, r2)     // Catch:{ all -> 0x0099 }
        java.lang.String r0 = "_sLen"
        java.lang.String r2 = "_sLen"
        int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x0099 }
        long r2 = r10.getLong(r2)     // Catch:{ all -> 0x0099 }
        java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0099 }
        r1.put(r0, r2)     // Catch:{ all -> 0x0099 }
        java.lang.String r0 = "_tLen"
        java.lang.String r2 = "_tLen"
        int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x0099 }
        long r2 = r10.getLong(r2)     // Catch:{ all -> 0x0099 }
        java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0099 }
        r1.put(r0, r2)     // Catch:{ all -> 0x0099 }
        java.lang.String r0 = "_MD5"
        java.lang.String r2 = "_MD5"
        int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x0099 }
        java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x0099 }
        r1.put(r0, r2)     // Catch:{ all -> 0x0099 }
        java.lang.String r0 = "_DLTIME"
        java.lang.String r2 = "_DLTIME"
        int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x0099 }
        long r2 = r10.getLong(r2)     // Catch:{ all -> 0x0099 }
        java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0099 }
        r1.put(r0, r2)     // Catch:{ all -> 0x0099 }
    L_0x0092:
        if (r10 == 0) goto L_0x0097
        r10.close()     // Catch:{ all -> 0x0099 }
    L_0x0097:
        monitor-exit(r9)
        return r1
    L_0x0099:
        r10 = move-exception
        monitor-exit(r9)
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7270p.mo34949a(java.lang.String):android.content.ContentValues");
    }

    /* renamed from: a */
    public synchronized boolean mo34952a(DownloadTask downloadTask) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_dUrl", downloadTask.getDownloadUrl());
        contentValues.put("_sFile", downloadTask.getSaveFile().getAbsolutePath());
        contentValues.put("_sLen", Long.valueOf(downloadTask.getSavedLength()));
        contentValues.put("_tLen", Long.valueOf(downloadTask.getTotalLength()));
        contentValues.put("_MD5", downloadTask.getMD5());
        contentValues.put("_DLTIME", Long.valueOf(downloadTask.getCostTime()));
        z = true;
        if (C7212ae.m31041a().mo34774a("dl_1002", contentValues, (C7211ad) null, true) < 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public synchronized int mo34955b(DownloadTask downloadTask) {
        return C7212ae.m31041a().mo34773a("dl_1002", "_dUrl = ?", new String[]{downloadTask.getDownloadUrl()}, (C7211ad) null, true);
    }

    /* renamed from: b */
    public synchronized int mo34956b(String str) {
        return C7212ae.m31041a().mo34773a("dl_1002", "_sFile = ?", new String[]{str}, (C7211ad) null, true);
    }

    /* renamed from: a */
    public synchronized List<C7280w> mo34950a() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor a = C7212ae.m31041a().mo34775a("ge_1002", null, null, null, null, true);
        while (a != null && a.moveToNext()) {
            C7280w wVar = (C7280w) C7216ah.m31077a(a.getBlob(a.getColumnIndex("_datas")), C7280w.class);
            if (wVar != null) {
                arrayList.add(wVar);
            }
        }
        if (a != null) {
            a.close();
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
            return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
            return false;
     */
    /* renamed from: a */
    public synchronized boolean mo34953a(com.tencent.bugly.proguard.C7280w r8) {
        /*
        r7 = this;
        monitor-enter(r7)
        r0 = 0
        if (r8 != 0) goto L_0x0006
        monitor-exit(r7)
        return r0
    L_0x0006:
        byte[] r1 = com.tencent.bugly.proguard.C7216ah.m31078a(r8)     // Catch:{ all -> 0x003c }
        if (r1 == 0) goto L_0x003a
        int r2 = r1.length     // Catch:{ all -> 0x003c }
        if (r2 > 0) goto L_0x0010
        goto L_0x003a
    L_0x0010:
        android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ all -> 0x003c }
        r2.<init>()     // Catch:{ all -> 0x003c }
        java.lang.String r3 = "_time"
        long r4 = r8.f24638b     // Catch:{ all -> 0x003c }
        java.lang.Long r8 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x003c }
        r2.put(r3, r8)     // Catch:{ all -> 0x003c }
        java.lang.String r8 = "_datas"
        r2.put(r8, r1)     // Catch:{ all -> 0x003c }
        com.tencent.bugly.proguard.ae r8 = com.tencent.bugly.proguard.C7212ae.m31041a()     // Catch:{ all -> 0x003c }
        java.lang.String r1 = "ge_1002"
        r3 = 0
        r4 = 1
        long r1 = r8.mo34774a(r1, r2, r3, r4)     // Catch:{ all -> 0x003c }
        r5 = 0
        int r8 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
        if (r8 < 0) goto L_0x0038
        r0 = 1
    L_0x0038:
        monitor-exit(r7)
        return r0
    L_0x003a:
        monitor-exit(r7)
        return r0
    L_0x003c:
        r8 = move-exception
        monitor-exit(r7)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7270p.mo34953a(com.tencent.bugly.proguard.w):boolean");
    }

    /* renamed from: b */
    public synchronized int mo34954b() {
        return C7212ae.m31041a().mo34773a("ge_1002", (String) null, (String[]) null, (C7211ad) null, true);
    }

    /* renamed from: a */
    public synchronized boolean mo34951a(int i, String str, byte[] bArr) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put(C7887a.f26833ID, Integer.valueOf(i));
        contentValues.put("_tm", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("_tp", str);
        contentValues.put("_dt", bArr);
        z = true;
        if (C7212ae.m31041a().mo34774a("st_1002", contentValues, (C7211ad) null, true) < 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    public synchronized boolean mo34958c(String str) {
        boolean z;
        z = false;
        if (C7212ae.m31041a().mo34773a("st_1002", "_id = ? and _tp = ? ", new String[]{"1002", str}, (C7211ad) null, true) > 0) {
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
            return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
            return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004f A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0054 A[SYNTHETIC, Splitter:B:29:0x0054] */
    /* renamed from: c */
    public synchronized java.util.Map<java.lang.String, byte[]> mo34957c() {
        /*
        r8 = this;
        monitor-enter(r8)
        r0 = 0
        java.lang.String r4 = "_id = 1002"
        com.tencent.bugly.proguard.ae r1 = com.tencent.bugly.proguard.C7212ae.m31041a()     // Catch:{ all -> 0x0047 }
        java.lang.String r2 = "st_1002"
        r3 = 0
        r5 = 0
        r6 = 0
        r7 = 1
        android.database.Cursor r1 = r1.mo34775a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0047 }
        if (r1 != 0) goto L_0x001b
        if (r1 == 0) goto L_0x0019
        r1.close()     // Catch:{ all -> 0x0060 }
    L_0x0019:
        monitor-exit(r8)
        return r0
    L_0x001b:
        java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0045 }
        r2.<init>()     // Catch:{ all -> 0x0045 }
    L_0x0020:
        boolean r3 = r1.moveToNext()     // Catch:{ all -> 0x0045 }
        if (r3 == 0) goto L_0x003e
        java.lang.String r3 = "_tp"
        int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0045 }
        java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0045 }
        java.lang.String r4 = "_dt"
        int r4 = r1.getColumnIndex(r4)     // Catch:{ all -> 0x0045 }
        byte[] r4 = r1.getBlob(r4)     // Catch:{ all -> 0x0045 }
        r2.put(r3, r4)     // Catch:{ all -> 0x0045 }
        goto L_0x0020
    L_0x003e:
        if (r1 == 0) goto L_0x0043
        r1.close()     // Catch:{ all -> 0x0060 }
    L_0x0043:
        monitor-exit(r8)
        return r2
    L_0x0045:
        r2 = move-exception
        goto L_0x0049
    L_0x0047:
        r2 = move-exception
        r1 = r0
    L_0x0049:
        boolean r3 = com.tencent.bugly.proguard.C7226an.m31142a(r2)     // Catch:{ all -> 0x0059 }
        if (r3 != 0) goto L_0x0052
        r2.printStackTrace()     // Catch:{ all -> 0x0059 }
    L_0x0052:
        if (r1 == 0) goto L_0x0057
        r1.close()     // Catch:{ all -> 0x0060 }
    L_0x0057:
        monitor-exit(r8)
        return r0
    L_0x0059:
        r0 = move-exception
        if (r1 == 0) goto L_0x005f
        r1.close()     // Catch:{ all -> 0x0060 }
    L_0x005f:
        throw r0     // Catch:{ all -> 0x0060 }
    L_0x0060:
        r0 = move-exception
        monitor-exit(r8)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7270p.mo34957c():java.util.Map");
    }
}
