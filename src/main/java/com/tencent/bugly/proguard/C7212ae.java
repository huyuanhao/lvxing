package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.C8712a;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ae */
public class C7212ae {
    /* renamed from: a */
    public static boolean f24305a = false;
    /* renamed from: b */
    private static C7212ae f24306b;
    /* renamed from: c */
    private static C7214af f24307c;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ae$a */
    class C7213a extends Thread {
        /* renamed from: b */
        private int f24309b;
        /* renamed from: c */
        private C7211ad f24310c;
        /* renamed from: d */
        private String f24311d;
        /* renamed from: e */
        private ContentValues f24312e;
        /* renamed from: f */
        private boolean f24313f;
        /* renamed from: g */
        private String[] f24314g;
        /* renamed from: h */
        private String f24315h;
        /* renamed from: i */
        private String[] f24316i;
        /* renamed from: j */
        private String f24317j;
        /* renamed from: k */
        private String f24318k;
        /* renamed from: l */
        private String f24319l;
        /* renamed from: m */
        private String f24320m;
        /* renamed from: n */
        private String f24321n;
        /* renamed from: o */
        private String[] f24322o;
        /* renamed from: p */
        private int f24323p;
        /* renamed from: q */
        private String f24324q;
        /* renamed from: r */
        private byte[] f24325r;

        public C7213a(int i, C7211ad adVar) {
            this.f24309b = i;
            this.f24310c = adVar;
        }

        /* renamed from: a */
        public void mo34791a(String str, ContentValues contentValues) {
            this.f24311d = str;
            this.f24312e = contentValues;
        }

        /* renamed from: a */
        public void mo34793a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f24313f = z;
            this.f24311d = str;
            this.f24314g = strArr;
            this.f24315h = str2;
            this.f24316i = strArr2;
            this.f24317j = str3;
            this.f24318k = str4;
            this.f24319l = str5;
            this.f24320m = str6;
        }

        /* renamed from: a */
        public void mo34792a(String str, String str2, String[] strArr) {
            this.f24311d = str;
            this.f24321n = str2;
            this.f24322o = strArr;
        }

        /* renamed from: a */
        public void mo34790a(int i, String str, byte[] bArr) {
            this.f24323p = i;
            this.f24324q = str;
            this.f24325r = bArr;
        }

        /* renamed from: a */
        public void mo34788a(int i) {
            this.f24323p = i;
        }

        /* renamed from: a */
        public void mo34789a(int i, String str) {
            this.f24323p = i;
            this.f24324q = str;
        }

        public void run() {
            switch (this.f24309b) {
                case 1:
                    C7212ae.this.m31038a(this.f24311d, this.f24312e, this.f24310c);
                    return;
                case 2:
                    C7212ae.this.m31036a(this.f24311d, this.f24321n, this.f24322o, this.f24310c);
                    return;
                case 3:
                    Cursor a = C7212ae.this.m31040a(this.f24313f, this.f24311d, this.f24314g, this.f24315h, this.f24316i, this.f24317j, this.f24318k, this.f24319l, this.f24320m, this.f24310c);
                    if (a != null) {
                        a.close();
                        return;
                    }
                    return;
                case 4:
                    C7212ae.this.m31046a(this.f24323p, this.f24324q, this.f24325r, this.f24310c);
                    return;
                case 5:
                    C7212ae.this.m31043a(this.f24323p, this.f24310c);
                    return;
                case 6:
                    C7212ae.this.m31045a(this.f24323p, this.f24324q, this.f24310c);
                    return;
                default:
                    return;
            }
        }
    }

    private C7212ae(Context context, List<C8712a> list) {
        f24307c = new C7214af(context, list);
    }

    /* renamed from: a */
    public static synchronized C7212ae m31042a(Context context, List<C8712a> list) {
        C7212ae aeVar;
        synchronized (C7212ae.class) {
            if (f24306b == null) {
                f24306b = new C7212ae(context, list);
            }
            aeVar = f24306b;
        }
        return aeVar;
    }

    /* renamed from: a */
    public static synchronized C7212ae m31041a() {
        C7212ae aeVar;
        synchronized (C7212ae.class) {
            aeVar = f24306b;
        }
        return aeVar;
    }

    /* renamed from: a */
    public long mo34774a(String str, ContentValues contentValues, C7211ad adVar, boolean z) {
        if (z) {
            return m31038a(str, contentValues, adVar);
        }
        C7213a aVar = new C7213a(1, adVar);
        aVar.mo34791a(str, contentValues);
        C7224am.m31132a().mo34832a(aVar);
        return 0;
    }

    /* renamed from: a */
    public Cursor mo34775a(String str, String[] strArr, String str2, String[] strArr2, C7211ad adVar, boolean z) {
        return mo34776a(false, str, strArr, str2, strArr2, (String) null, (String) null, (String) null, (String) null, adVar, z);
    }

    /* renamed from: a */
    public Cursor mo34776a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, C7211ad adVar, boolean z2) {
        if (!z2) {
            C7213a aVar = new C7213a(3, adVar);
            aVar.mo34793a(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            C7224am.m31132a().mo34832a(aVar);
            return null;
        }
        C7211ad adVar2 = adVar;
        return m31040a(z, str, strArr, str2, strArr2, str3, str4, str5, str6, adVar);
    }

    /* renamed from: a */
    public int mo34773a(String str, String str2, String[] strArr, C7211ad adVar, boolean z) {
        if (z) {
            return m31036a(str, str2, strArr, adVar);
        }
        C7213a aVar = new C7213a(2, adVar);
        aVar.mo34792a(str, str2, strArr);
        C7224am.m31132a().mo34832a(aVar);
        return 0;
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
            if (r0 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
            r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
            if (r0 != null) goto L_0x003d;
     */
    /* renamed from: a */
    public synchronized long m31038a(java.lang.String r8, android.content.ContentValues r9, com.tencent.bugly.proguard.C7211ad r10) {
        /*
        r7 = this;
        monitor-enter(r7)
        r0 = 0
        r1 = 0
        com.tencent.bugly.proguard.af r3 = f24307c     // Catch:{ all -> 0x0043 }
        android.database.sqlite.SQLiteDatabase r0 = r3.getWritableDatabase()     // Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x002e
        if (r9 == 0) goto L_0x002e
        java.lang.String r3 = "_id"
        long r3 = r0.replace(r8, r3, r9)     // Catch:{ all -> 0x0043 }
        r9 = 0
        r5 = 1
        int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
        if (r6 < 0) goto L_0x0024
        java.lang.String r6 = "[Database] insert %s success."
        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0043 }
        r5[r9] = r8     // Catch:{ all -> 0x0043 }
        com.tencent.bugly.proguard.C7226an.m31147c(r6, r5)     // Catch:{ all -> 0x0043 }
        goto L_0x002d
    L_0x0024:
        java.lang.String r6 = "[Database] replace %s error."
        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0043 }
        r5[r9] = r8     // Catch:{ all -> 0x0043 }
        com.tencent.bugly.proguard.C7226an.m31148d(r6, r5)     // Catch:{ all -> 0x0043 }
    L_0x002d:
        r1 = r3
    L_0x002e:
        if (r10 == 0) goto L_0x0037
        java.lang.Long r8 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0041 }
        r10.mo34772a(r8)     // Catch:{ all -> 0x0041 }
    L_0x0037:
        boolean r8 = f24305a     // Catch:{ all -> 0x0041 }
        if (r8 == 0) goto L_0x005d
        if (r0 == 0) goto L_0x005d
    L_0x003d:
        r0.close()     // Catch:{ all -> 0x0041 }
        goto L_0x005d
    L_0x0041:
        r8 = move-exception
        goto L_0x0073
    L_0x0043:
        r8 = move-exception
        boolean r9 = com.tencent.bugly.proguard.C7226an.m31142a(r8)     // Catch:{ all -> 0x005f }
        if (r9 != 0) goto L_0x004d
        r8.printStackTrace()     // Catch:{ all -> 0x005f }
    L_0x004d:
        if (r10 == 0) goto L_0x0056
        java.lang.Long r8 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0041 }
        r10.mo34772a(r8)     // Catch:{ all -> 0x0041 }
    L_0x0056:
        boolean r8 = f24305a     // Catch:{ all -> 0x0041 }
        if (r8 == 0) goto L_0x005d
        if (r0 == 0) goto L_0x005d
        goto L_0x003d
    L_0x005d:
        monitor-exit(r7)
        return r1
    L_0x005f:
        r8 = move-exception
        if (r10 == 0) goto L_0x0069
        java.lang.Long r9 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0041 }
        r10.mo34772a(r9)     // Catch:{ all -> 0x0041 }
    L_0x0069:
        boolean r9 = f24305a     // Catch:{ all -> 0x0041 }
        if (r9 == 0) goto L_0x0072
        if (r0 == 0) goto L_0x0072
        r0.close()     // Catch:{ all -> 0x0041 }
    L_0x0072:
        throw r8     // Catch:{ all -> 0x0041 }
    L_0x0073:
        monitor-exit(r7)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7212ae.m31038a(java.lang.String, android.content.ContentValues, com.tencent.bugly.proguard.ad):long");
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (r1 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            r1.mo34772a(r2);
     */
    /* renamed from: a */
    public synchronized android.database.Cursor m31040a(boolean r14, java.lang.String r15, java.lang.String[] r16, java.lang.String r17, java.lang.String[] r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, com.tencent.bugly.proguard.C7211ad r23) {
        /*
        r13 = this;
        r1 = r23
        monitor-enter(r13)
        r2 = 0
        com.tencent.bugly.proguard.af r0 = f24307c     // Catch:{ all -> 0x0028 }
        android.database.sqlite.SQLiteDatabase r3 = r0.getWritableDatabase()     // Catch:{ all -> 0x0028 }
        if (r3 == 0) goto L_0x0020
        r4 = r14
        r5 = r15
        r6 = r16
        r7 = r17
        r8 = r18
        r9 = r19
        r10 = r20
        r11 = r21
        r12 = r22
        android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0028 }
    L_0x0020:
        if (r1 == 0) goto L_0x0035
    L_0x0022:
        r1.mo34772a(r2)     // Catch:{ all -> 0x0026 }
        goto L_0x0035
    L_0x0026:
        r0 = move-exception
        goto L_0x003e
    L_0x0028:
        r0 = move-exception
        boolean r3 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x0037 }
        if (r3 != 0) goto L_0x0032
        r0.printStackTrace()     // Catch:{ all -> 0x0037 }
    L_0x0032:
        if (r1 == 0) goto L_0x0035
        goto L_0x0022
    L_0x0035:
        monitor-exit(r13)
        return r2
    L_0x0037:
        r0 = move-exception
        if (r1 == 0) goto L_0x003d
        r1.mo34772a(r2)     // Catch:{ all -> 0x0026 }
    L_0x003d:
        throw r0     // Catch:{ all -> 0x0026 }
    L_0x003e:
        monitor-exit(r13)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7212ae.m31040a(boolean, java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.bugly.proguard.ad):android.database.Cursor");
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            if (r1 != null) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
            if (r1 != null) goto L_0x001e;
     */
    /* renamed from: a */
    public synchronized int m31036a(java.lang.String r4, java.lang.String r5, java.lang.String[] r6, com.tencent.bugly.proguard.C7211ad r7) {
        /*
        r3 = this;
        monitor-enter(r3)
        r0 = 0
        r1 = 0
        com.tencent.bugly.proguard.af r2 = f24307c     // Catch:{ all -> 0x0024 }
        android.database.sqlite.SQLiteDatabase r1 = r2.getWritableDatabase()     // Catch:{ all -> 0x0024 }
        if (r1 == 0) goto L_0x000f
        int r0 = r1.delete(r4, r5, r6)     // Catch:{ all -> 0x0024 }
    L_0x000f:
        if (r7 == 0) goto L_0x0018
        java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0022 }
        r7.mo34772a(r4)     // Catch:{ all -> 0x0022 }
    L_0x0018:
        boolean r4 = f24305a     // Catch:{ all -> 0x0022 }
        if (r4 == 0) goto L_0x003e
        if (r1 == 0) goto L_0x003e
    L_0x001e:
        r1.close()     // Catch:{ all -> 0x0022 }
        goto L_0x003e
    L_0x0022:
        r4 = move-exception
        goto L_0x0054
    L_0x0024:
        r4 = move-exception
        boolean r5 = com.tencent.bugly.proguard.C7226an.m31142a(r4)     // Catch:{ all -> 0x0040 }
        if (r5 != 0) goto L_0x002e
        r4.printStackTrace()     // Catch:{ all -> 0x0040 }
    L_0x002e:
        if (r7 == 0) goto L_0x0037
        java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0022 }
        r7.mo34772a(r4)     // Catch:{ all -> 0x0022 }
    L_0x0037:
        boolean r4 = f24305a     // Catch:{ all -> 0x0022 }
        if (r4 == 0) goto L_0x003e
        if (r1 == 0) goto L_0x003e
        goto L_0x001e
    L_0x003e:
        monitor-exit(r3)
        return r0
    L_0x0040:
        r4 = move-exception
        if (r7 == 0) goto L_0x004a
        java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0022 }
        r7.mo34772a(r5)     // Catch:{ all -> 0x0022 }
    L_0x004a:
        boolean r5 = f24305a     // Catch:{ all -> 0x0022 }
        if (r5 == 0) goto L_0x0053
        if (r1 == 0) goto L_0x0053
        r1.close()     // Catch:{ all -> 0x0022 }
    L_0x0053:
        throw r4     // Catch:{ all -> 0x0022 }
    L_0x0054:
        monitor-exit(r3)
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7212ae.m31036a(java.lang.String, java.lang.String, java.lang.String[], com.tencent.bugly.proguard.ad):int");
    }

    /* renamed from: a */
    public boolean mo34782a(int i, String str, byte[] bArr, C7211ad adVar, boolean z) {
        if (z) {
            return m31046a(i, str, bArr, adVar);
        }
        C7213a aVar = new C7213a(4, adVar);
        aVar.mo34790a(i, str, bArr);
        C7224am.m31132a().mo34832a(aVar);
        return true;
    }

    /* renamed from: a */
    public Map<String, byte[]> mo34779a(int i, C7211ad adVar, boolean z) {
        if (z) {
            return m31043a(i, adVar);
        }
        C7213a aVar = new C7213a(5, adVar);
        aVar.mo34788a(i);
        C7224am.m31132a().mo34832a(aVar);
        return null;
    }

    /* renamed from: a */
    public boolean mo34781a(int i, String str, C7211ad adVar, boolean z) {
        if (z) {
            return m31045a(i, str, adVar);
        }
        C7213a aVar = new C7213a(6, adVar);
        aVar.mo34789a(i, str);
        C7224am.m31132a().mo34832a(aVar);
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
            if (r8 != null) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
            return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
            if (r8 != null) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
            r8.mo34772a(java.lang.Boolean.valueOf(r0));
     */
    /* renamed from: a */
    public boolean m31046a(int r5, java.lang.String r6, byte[] r7, com.tencent.bugly.proguard.C7211ad r8) {
        /*
        r4 = this;
        r0 = 0
        com.tencent.bugly.proguard.ag r1 = new com.tencent.bugly.proguard.ag     // Catch:{ all -> 0x0021 }
        r1.m52545init()     // Catch:{ all -> 0x0021 }
        long r2 = (long) r5     // Catch:{ all -> 0x0021 }
        r1.f24330a = r2     // Catch:{ all -> 0x0021 }
        r1.f24335f = r6     // Catch:{ all -> 0x0021 }
        long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0021 }
        r1.f24334e = r5     // Catch:{ all -> 0x0021 }
        r1.f24336g = r7     // Catch:{ all -> 0x0021 }
        boolean r0 = r4.m31050d(r1)     // Catch:{ all -> 0x0021 }
        if (r8 == 0) goto L_0x002e
    L_0x0019:
        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r0)
        r8.mo34772a(r5)
        goto L_0x002e
    L_0x0021:
        r5 = move-exception
        boolean r6 = com.tencent.bugly.proguard.C7226an.m31142a(r5)     // Catch:{ all -> 0x002f }
        if (r6 != 0) goto L_0x002b
        r5.printStackTrace()     // Catch:{ all -> 0x002f }
    L_0x002b:
        if (r8 == 0) goto L_0x002e
        goto L_0x0019
    L_0x002e:
        return r0
    L_0x002f:
        r5 = move-exception
        if (r8 == 0) goto L_0x0039
        java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)
        r8.mo34772a(r6)
    L_0x0039:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7212ae.m31046a(int, java.lang.String, byte[], com.tencent.bugly.proguard.ad):boolean");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            if (r5 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
            r5.mo34772a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
            if (r5 == null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
            return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0038 A[Catch:{ all -> 0x003f }] */
    /* renamed from: a */
    public java.util.Map<java.lang.String, byte[]> m31043a(int r4, com.tencent.bugly.proguard.C7211ad r5) {
        /*
        r3 = this;
        r0 = 0
        java.util.List r4 = r3.m31049c(r4)     // Catch:{ all -> 0x0031 }
        if (r4 == 0) goto L_0x002b
        java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0031 }
        r1.<init>()     // Catch:{ all -> 0x0031 }
        java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0028 }
    L_0x0010:
        boolean r0 = r4.hasNext()     // Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x0026
        java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x0028 }
        com.tencent.bugly.proguard.ag r0 = (com.tencent.bugly.proguard.C7215ag) r0     // Catch:{ all -> 0x0028 }
        byte[] r2 = r0.f24336g     // Catch:{ all -> 0x0028 }
        if (r2 == 0) goto L_0x0010
        java.lang.String r0 = r0.f24335f     // Catch:{ all -> 0x0028 }
        r1.put(r0, r2)     // Catch:{ all -> 0x0028 }
        goto L_0x0010
    L_0x0026:
        r0 = r1
        goto L_0x002b
    L_0x0028:
        r4 = move-exception
        r0 = r1
        goto L_0x0032
    L_0x002b:
        if (r5 == 0) goto L_0x003e
    L_0x002d:
        r5.mo34772a(r0)
        goto L_0x003e
    L_0x0031:
        r4 = move-exception
    L_0x0032:
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r4)     // Catch:{ all -> 0x003f }
        if (r1 != 0) goto L_0x003b
        r4.printStackTrace()     // Catch:{ all -> 0x003f }
    L_0x003b:
        if (r5 == 0) goto L_0x003e
        goto L_0x002d
    L_0x003e:
        return r0
    L_0x003f:
        r4 = move-exception
        if (r5 == 0) goto L_0x0045
        r5.mo34772a(r0)
    L_0x0045:
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7212ae.m31043a(int, com.tencent.bugly.proguard.ad):java.util.Map");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
            return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0046, code lost:
            return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0051, code lost:
            return false;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0047=Splitter:B:28:0x0047, B:41:0x005e=Splitter:B:41:0x005e} */
    /* renamed from: a */
    public synchronized boolean mo34783a(com.tencent.bugly.proguard.C7215ag r9) {
        /*
        r8 = this;
        monitor-enter(r8)
        r0 = 0
        if (r9 != 0) goto L_0x0006
        monitor-exit(r8)
        return r0
    L_0x0006:
        r1 = 0
        com.tencent.bugly.proguard.af r2 = f24307c     // Catch:{ all -> 0x0054 }
        android.database.sqlite.SQLiteDatabase r1 = r2.getWritableDatabase()     // Catch:{ all -> 0x0054 }
        if (r1 == 0) goto L_0x0047
        android.content.ContentValues r2 = r8.mo34784b(r9)     // Catch:{ all -> 0x0054 }
        if (r2 == 0) goto L_0x0047
        java.lang.String r3 = "t_lr"
        java.lang.String r4 = "_id"
        long r2 = r1.replace(r3, r4, r2)     // Catch:{ all -> 0x0054 }
        r4 = 0
        int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r6 < 0) goto L_0x003c
        java.lang.String r4 = "[Database] insert %s success."
        r5 = 1
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x0054 }
        java.lang.String r7 = "t_lr"
        r6[r0] = r7     // Catch:{ all -> 0x0054 }
        com.tencent.bugly.proguard.C7226an.m31147c(r4, r6)     // Catch:{ all -> 0x0054 }
        r9.f24330a = r2     // Catch:{ all -> 0x0054 }
        boolean r9 = f24305a     // Catch:{ all -> 0x0052 }
        if (r9 == 0) goto L_0x003a
        if (r1 == 0) goto L_0x003a
        r1.close()     // Catch:{ all -> 0x0052 }
    L_0x003a:
        monitor-exit(r8)
        return r5
    L_0x003c:
        boolean r9 = f24305a     // Catch:{ all -> 0x0052 }
        if (r9 == 0) goto L_0x0045
        if (r1 == 0) goto L_0x0045
        r1.close()     // Catch:{ all -> 0x0052 }
    L_0x0045:
        monitor-exit(r8)
        return r0
    L_0x0047:
        boolean r9 = f24305a     // Catch:{ all -> 0x0052 }
        if (r9 == 0) goto L_0x0050
        if (r1 == 0) goto L_0x0050
        r1.close()     // Catch:{ all -> 0x0052 }
    L_0x0050:
        monitor-exit(r8)
        return r0
    L_0x0052:
        r9 = move-exception
        goto L_0x0074
    L_0x0054:
        r9 = move-exception
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r9)     // Catch:{ all -> 0x0069 }
        if (r2 != 0) goto L_0x005e
        r9.printStackTrace()     // Catch:{ all -> 0x0069 }
    L_0x005e:
        boolean r9 = f24305a     // Catch:{ all -> 0x0052 }
        if (r9 == 0) goto L_0x0067
        if (r1 == 0) goto L_0x0067
        r1.close()     // Catch:{ all -> 0x0052 }
    L_0x0067:
        monitor-exit(r8)
        return r0
    L_0x0069:
        r9 = move-exception
        boolean r0 = f24305a     // Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0073
        if (r1 == 0) goto L_0x0073
        r1.close()     // Catch:{ all -> 0x0052 }
    L_0x0073:
        throw r9     // Catch:{ all -> 0x0052 }
    L_0x0074:
        monitor-exit(r8)
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7212ae.mo34783a(com.tencent.bugly.proguard.ag):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
            return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0046, code lost:
            return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0051, code lost:
            return false;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0047=Splitter:B:28:0x0047, B:41:0x005e=Splitter:B:41:0x005e} */
    /* renamed from: d */
    private synchronized boolean m31050d(com.tencent.bugly.proguard.C7215ag r9) {
        /*
        r8 = this;
        monitor-enter(r8)
        r0 = 0
        if (r9 != 0) goto L_0x0006
        monitor-exit(r8)
        return r0
    L_0x0006:
        r1 = 0
        com.tencent.bugly.proguard.af r2 = f24307c     // Catch:{ all -> 0x0054 }
        android.database.sqlite.SQLiteDatabase r1 = r2.getWritableDatabase()     // Catch:{ all -> 0x0054 }
        if (r1 == 0) goto L_0x0047
        android.content.ContentValues r2 = r8.mo34787c(r9)     // Catch:{ all -> 0x0054 }
        if (r2 == 0) goto L_0x0047
        java.lang.String r3 = "t_pf"
        java.lang.String r4 = "_id"
        long r2 = r1.replace(r3, r4, r2)     // Catch:{ all -> 0x0054 }
        r4 = 0
        int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r6 < 0) goto L_0x003c
        java.lang.String r4 = "[Database] insert %s success."
        r5 = 1
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x0054 }
        java.lang.String r7 = "t_pf"
        r6[r0] = r7     // Catch:{ all -> 0x0054 }
        com.tencent.bugly.proguard.C7226an.m31147c(r4, r6)     // Catch:{ all -> 0x0054 }
        r9.f24330a = r2     // Catch:{ all -> 0x0054 }
        boolean r9 = f24305a     // Catch:{ all -> 0x0052 }
        if (r9 == 0) goto L_0x003a
        if (r1 == 0) goto L_0x003a
        r1.close()     // Catch:{ all -> 0x0052 }
    L_0x003a:
        monitor-exit(r8)
        return r5
    L_0x003c:
        boolean r9 = f24305a     // Catch:{ all -> 0x0052 }
        if (r9 == 0) goto L_0x0045
        if (r1 == 0) goto L_0x0045
        r1.close()     // Catch:{ all -> 0x0052 }
    L_0x0045:
        monitor-exit(r8)
        return r0
    L_0x0047:
        boolean r9 = f24305a     // Catch:{ all -> 0x0052 }
        if (r9 == 0) goto L_0x0050
        if (r1 == 0) goto L_0x0050
        r1.close()     // Catch:{ all -> 0x0052 }
    L_0x0050:
        monitor-exit(r8)
        return r0
    L_0x0052:
        r9 = move-exception
        goto L_0x0074
    L_0x0054:
        r9 = move-exception
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r9)     // Catch:{ all -> 0x0069 }
        if (r2 != 0) goto L_0x005e
        r9.printStackTrace()     // Catch:{ all -> 0x0069 }
    L_0x005e:
        boolean r9 = f24305a     // Catch:{ all -> 0x0052 }
        if (r9 == 0) goto L_0x0067
        if (r1 == 0) goto L_0x0067
        r1.close()     // Catch:{ all -> 0x0052 }
    L_0x0067:
        monitor-exit(r8)
        return r0
    L_0x0069:
        r9 = move-exception
        boolean r0 = f24305a     // Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0073
        if (r1 == 0) goto L_0x0073
        r1.close()     // Catch:{ all -> 0x0052 }
    L_0x0073:
        throw r9     // Catch:{ all -> 0x0052 }
    L_0x0074:
        monitor-exit(r8)
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7212ae.m31050d(com.tencent.bugly.proguard.ag):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
            return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ba, code lost:
            return r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c2 A[Catch:{ all -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c7 A[SYNTHETIC, Splitter:B:56:0x00c7] */
    /* renamed from: a */
    public synchronized java.util.List<com.tencent.bugly.proguard.C7215ag> mo34778a(int r11) {
        /*
        r10 = this;
        monitor-enter(r10)
        com.tencent.bugly.proguard.af r0 = f24307c     // Catch:{ all -> 0x00e6 }
        android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x00e6 }
        r9 = 0
        if (r0 == 0) goto L_0x00e4
        if (r11 < 0) goto L_0x0024
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x001f }
        r1.<init>()     // Catch:{ all -> 0x001f }
        java.lang.String r2 = "_tp = "
        r1.append(r2)     // Catch:{ all -> 0x001f }
        r1.append(r11)     // Catch:{ all -> 0x001f }
        java.lang.String r11 = r1.toString()     // Catch:{ all -> 0x001f }
        r4 = r11
        goto L_0x0025
    L_0x001f:
        r11 = move-exception
        r1 = r11
        r11 = r9
        goto L_0x00bc
    L_0x0024:
        r4 = r9
    L_0x0025:
        java.lang.String r2 = "t_lr"
        r3 = 0
        r5 = 0
        r6 = 0
        r7 = 0
        r8 = 0
        r1 = r0
        android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x001f }
        if (r11 != 0) goto L_0x0043
        if (r11 == 0) goto L_0x0038
        r11.close()     // Catch:{ all -> 0x00e6 }
    L_0x0038:
        boolean r11 = f24305a     // Catch:{ all -> 0x00e6 }
        if (r11 == 0) goto L_0x0041
        if (r0 == 0) goto L_0x0041
        r0.close()     // Catch:{ all -> 0x00e6 }
    L_0x0041:
        monitor-exit(r10)
        return r9
    L_0x0043:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
        r1.<init>()     // Catch:{ all -> 0x00bb }
        java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00bb }
        r2.<init>()     // Catch:{ all -> 0x00bb }
    L_0x004d:
        boolean r3 = r11.moveToNext()     // Catch:{ all -> 0x00bb }
        r4 = 0
        if (r3 == 0) goto L_0x0083
        com.tencent.bugly.proguard.ag r3 = r10.mo34777a(r11)     // Catch:{ all -> 0x00bb }
        if (r3 == 0) goto L_0x005e
        r2.add(r3)     // Catch:{ all -> 0x00bb }
        goto L_0x004d
    L_0x005e:
        java.lang.String r3 = "_id"
        int r3 = r11.getColumnIndex(r3)     // Catch:{ all -> 0x007b }
        long r5 = r11.getLong(r3)     // Catch:{ all -> 0x007b }
        java.lang.String r3 = " or "
        r1.append(r3)     // Catch:{ all -> 0x007b }
        java.lang.String r3 = "_id"
        r1.append(r3)     // Catch:{ all -> 0x007b }
        java.lang.String r3 = " = "
        r1.append(r3)     // Catch:{ all -> 0x007b }
        r1.append(r5)     // Catch:{ all -> 0x007b }
        goto L_0x004d
    L_0x007b:
        java.lang.String r3 = "[Database] unknown id."
        java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00bb }
        com.tencent.bugly.proguard.C7226an.m31148d(r3, r4)     // Catch:{ all -> 0x00bb }
        goto L_0x004d
    L_0x0083:
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00bb }
        int r3 = r1.length()     // Catch:{ all -> 0x00bb }
        if (r3 <= 0) goto L_0x00ab
        r3 = 4
        java.lang.String r1 = r1.substring(r3)     // Catch:{ all -> 0x00bb }
        java.lang.String r3 = "t_lr"
        int r1 = r0.delete(r3, r1, r9)     // Catch:{ all -> 0x00bb }
        java.lang.String r3 = "[Database] deleted %s illegal data %d"
        r5 = 2
        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00bb }
        java.lang.String r6 = "t_lr"
        r5[r4] = r6     // Catch:{ all -> 0x00bb }
        r4 = 1
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x00bb }
        r5[r4] = r1     // Catch:{ all -> 0x00bb }
        com.tencent.bugly.proguard.C7226an.m31148d(r3, r5)     // Catch:{ all -> 0x00bb }
    L_0x00ab:
        if (r11 == 0) goto L_0x00b0
        r11.close()     // Catch:{ all -> 0x00e6 }
    L_0x00b0:
        boolean r11 = f24305a     // Catch:{ all -> 0x00e6 }
        if (r11 == 0) goto L_0x00b9
        if (r0 == 0) goto L_0x00b9
        r0.close()     // Catch:{ all -> 0x00e6 }
    L_0x00b9:
        monitor-exit(r10)
        return r2
    L_0x00bb:
        r1 = move-exception
    L_0x00bc:
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r1)     // Catch:{ all -> 0x00d4 }
        if (r2 != 0) goto L_0x00c5
        r1.printStackTrace()     // Catch:{ all -> 0x00d4 }
    L_0x00c5:
        if (r11 == 0) goto L_0x00ca
        r11.close()     // Catch:{ all -> 0x00e6 }
    L_0x00ca:
        boolean r11 = f24305a     // Catch:{ all -> 0x00e6 }
        if (r11 == 0) goto L_0x00e4
        if (r0 == 0) goto L_0x00e4
        r0.close()     // Catch:{ all -> 0x00e6 }
        goto L_0x00e4
    L_0x00d4:
        r1 = move-exception
        if (r11 == 0) goto L_0x00da
        r11.close()     // Catch:{ all -> 0x00e6 }
    L_0x00da:
        boolean r11 = f24305a     // Catch:{ all -> 0x00e6 }
        if (r11 == 0) goto L_0x00e3
        if (r0 == 0) goto L_0x00e3
        r0.close()     // Catch:{ all -> 0x00e6 }
    L_0x00e3:
        throw r1     // Catch:{ all -> 0x00e6 }
    L_0x00e4:
        monitor-exit(r10)
        return r9
    L_0x00e6:
        r11 = move-exception
        monitor-exit(r10)
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7212ae.mo34778a(int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
            if (f24305a != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0090, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo34780a(java.util.List<com.tencent.bugly.proguard.C7215ag> r6) {
        /*
        r5 = this;
        monitor-enter(r5)
        if (r6 == 0) goto L_0x008f
        int r0 = r6.size()     // Catch:{ all -> 0x008c }
        if (r0 != 0) goto L_0x000b
        goto L_0x008f
    L_0x000b:
        com.tencent.bugly.proguard.af r0 = f24307c     // Catch:{ all -> 0x008c }
        android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x008c }
        if (r0 == 0) goto L_0x008a
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
        r1.<init>()     // Catch:{ all -> 0x008c }
        java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x008c }
    L_0x001c:
        boolean r2 = r6.hasNext()     // Catch:{ all -> 0x008c }
        if (r2 == 0) goto L_0x003d
        java.lang.Object r2 = r6.next()     // Catch:{ all -> 0x008c }
        com.tencent.bugly.proguard.ag r2 = (com.tencent.bugly.proguard.C7215ag) r2     // Catch:{ all -> 0x008c }
        java.lang.String r3 = " or "
        r1.append(r3)     // Catch:{ all -> 0x008c }
        java.lang.String r3 = "_id"
        r1.append(r3)     // Catch:{ all -> 0x008c }
        java.lang.String r3 = " = "
        r1.append(r3)     // Catch:{ all -> 0x008c }
        long r2 = r2.f24330a     // Catch:{ all -> 0x008c }
        r1.append(r2)     // Catch:{ all -> 0x008c }
        goto L_0x001c
    L_0x003d:
        java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x008c }
        int r2 = r6.length()     // Catch:{ all -> 0x008c }
        if (r2 <= 0) goto L_0x004c
        r2 = 4
        java.lang.String r6 = r6.substring(r2)     // Catch:{ all -> 0x008c }
    L_0x004c:
        r2 = 0
        r1.setLength(r2)     // Catch:{ all -> 0x008c }
        java.lang.String r1 = "t_lr"
        r3 = 0
        int r6 = r0.delete(r1, r6, r3)     // Catch:{ all -> 0x0072 }
        java.lang.String r1 = "[Database] deleted %s data %d"
        r3 = 2
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0072 }
        java.lang.String r4 = "t_lr"
        r3[r2] = r4     // Catch:{ all -> 0x0072 }
        r2 = 1
        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0072 }
        r3[r2] = r6     // Catch:{ all -> 0x0072 }
        com.tencent.bugly.proguard.C7226an.m31147c(r1, r3)     // Catch:{ all -> 0x0072 }
        boolean r6 = f24305a     // Catch:{ all -> 0x008c }
        if (r6 == 0) goto L_0x008a
    L_0x006e:
        r0.close()     // Catch:{ all -> 0x008c }
        goto L_0x008a
    L_0x0072:
        r6 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r6)     // Catch:{ all -> 0x0081 }
        if (r1 != 0) goto L_0x007c
        r6.printStackTrace()     // Catch:{ all -> 0x0081 }
    L_0x007c:
        boolean r6 = f24305a     // Catch:{ all -> 0x008c }
        if (r6 == 0) goto L_0x008a
        goto L_0x006e
    L_0x0081:
        r6 = move-exception
        boolean r1 = f24305a     // Catch:{ all -> 0x008c }
        if (r1 == 0) goto L_0x0089
        r0.close()     // Catch:{ all -> 0x008c }
    L_0x0089:
        throw r6     // Catch:{ all -> 0x008c }
    L_0x008a:
        monitor-exit(r5)
        return
    L_0x008c:
        r6 = move-exception
        monitor-exit(r5)
        throw r6
    L_0x008f:
        monitor-exit(r5)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7212ae.mo34780a(java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
            if (r0 != null) goto L_0x0041;
     */
    /* renamed from: b */
    public synchronized void mo34786b(int r6) {
        /*
        r5 = this;
        monitor-enter(r5)
        com.tencent.bugly.proguard.af r0 = f24307c     // Catch:{ all -> 0x0062 }
        android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x0060
        r1 = 0
        if (r6 < 0) goto L_0x0020
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x001e }
        r2.<init>()     // Catch:{ all -> 0x001e }
        java.lang.String r3 = "_tp = "
        r2.append(r3)     // Catch:{ all -> 0x001e }
        r2.append(r6)     // Catch:{ all -> 0x001e }
        java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x001e }
        goto L_0x0021
    L_0x001e:
        r6 = move-exception
        goto L_0x0045
    L_0x0020:
        r6 = r1
    L_0x0021:
        java.lang.String r2 = "t_lr"
        int r6 = r0.delete(r2, r6, r1)     // Catch:{ all -> 0x001e }
        java.lang.String r1 = "[Database] deleted %s data %d"
        r2 = 2
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x001e }
        r3 = 0
        java.lang.String r4 = "t_lr"
        r2[r3] = r4     // Catch:{ all -> 0x001e }
        r3 = 1
        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x001e }
        r2[r3] = r6     // Catch:{ all -> 0x001e }
        com.tencent.bugly.proguard.C7226an.m31147c(r1, r2)     // Catch:{ all -> 0x001e }
        boolean r6 = f24305a     // Catch:{ all -> 0x0062 }
        if (r6 == 0) goto L_0x0060
        if (r0 == 0) goto L_0x0060
    L_0x0041:
        r0.close()     // Catch:{ all -> 0x0062 }
        goto L_0x0060
    L_0x0045:
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r6)     // Catch:{ all -> 0x0055 }
        if (r1 != 0) goto L_0x004e
        r6.printStackTrace()     // Catch:{ all -> 0x0055 }
    L_0x004e:
        boolean r6 = f24305a     // Catch:{ all -> 0x0062 }
        if (r6 == 0) goto L_0x0060
        if (r0 == 0) goto L_0x0060
        goto L_0x0041
    L_0x0055:
        r6 = move-exception
        boolean r1 = f24305a     // Catch:{ all -> 0x0062 }
        if (r1 == 0) goto L_0x005f
        if (r0 == 0) goto L_0x005f
        r0.close()     // Catch:{ all -> 0x0062 }
    L_0x005f:
        throw r6     // Catch:{ all -> 0x0062 }
    L_0x0060:
        monitor-exit(r5)
        return
    L_0x0062:
        r6 = move-exception
        monitor-exit(r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7212ae.mo34786b(int):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ContentValues mo34784b(C7215ag agVar) {
        if (agVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (agVar.f24330a > 0) {
                contentValues.put(C7887a.f26833ID, Long.valueOf(agVar.f24330a));
            }
            contentValues.put("_tp", Integer.valueOf(agVar.f24331b));
            contentValues.put("_pc", agVar.f24332c);
            contentValues.put("_th", agVar.f24333d);
            contentValues.put("_tm", Long.valueOf(agVar.f24334e));
            if (agVar.f24336g != null) {
                contentValues.put("_dt", agVar.f24336g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C7215ag mo34777a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C7215ag agVar = new C7215ag();
            agVar.f24330a = cursor.getLong(cursor.getColumnIndex(C7887a.f26833ID));
            agVar.f24331b = cursor.getInt(cursor.getColumnIndex("_tp"));
            agVar.f24332c = cursor.getString(cursor.getColumnIndex("_pc"));
            agVar.f24333d = cursor.getString(cursor.getColumnIndex("_th"));
            agVar.f24334e = cursor.getLong(cursor.getColumnIndex("_tm"));
            agVar.f24336g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return agVar;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
            return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bf, code lost:
            return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c9, code lost:
            if (r1 != null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00cb, code lost:
            r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e6, code lost:
            if (r1 != null) goto L_0x00cb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00da A[Catch:{ all -> 0x00eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00df A[SYNTHETIC, Splitter:B:61:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e6  */
    /* renamed from: c */
    private synchronized java.util.List<com.tencent.bugly.proguard.C7215ag> m31049c(int r12) {
        /*
        r11 = this;
        monitor-enter(r11)
        r0 = 0
        com.tencent.bugly.proguard.af r1 = f24307c     // Catch:{ all -> 0x00d1 }
        android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x00d1 }
        if (r1 == 0) goto L_0x00c5
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c2 }
        r2.<init>()     // Catch:{ all -> 0x00c2 }
        java.lang.String r3 = "_id = "
        r2.append(r3)     // Catch:{ all -> 0x00c2 }
        r2.append(r12)     // Catch:{ all -> 0x00c2 }
        java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x00c2 }
        java.lang.String r3 = "t_pf"
        r4 = 0
        r6 = 0
        r7 = 0
        r8 = 0
        r9 = 0
        r2 = r1
        r5 = r10
        android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00c2 }
        if (r2 != 0) goto L_0x003a
        if (r2 == 0) goto L_0x002f
        r2.close()     // Catch:{ all -> 0x00cf }
    L_0x002f:
        boolean r12 = f24305a     // Catch:{ all -> 0x00cf }
        if (r12 == 0) goto L_0x0038
        if (r1 == 0) goto L_0x0038
        r1.close()     // Catch:{ all -> 0x00cf }
    L_0x0038:
        monitor-exit(r11)
        return r0
    L_0x003a:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
        r3.<init>()     // Catch:{ all -> 0x00c0 }
        java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00c0 }
        r4.<init>()     // Catch:{ all -> 0x00c0 }
    L_0x0044:
        boolean r5 = r2.moveToNext()     // Catch:{ all -> 0x00c0 }
        r6 = 0
        if (r5 == 0) goto L_0x007a
        com.tencent.bugly.proguard.ag r5 = r11.mo34785b(r2)     // Catch:{ all -> 0x00c0 }
        if (r5 == 0) goto L_0x0055
        r4.add(r5)     // Catch:{ all -> 0x00c0 }
        goto L_0x0044
    L_0x0055:
        java.lang.String r5 = "_tp"
        int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x0072 }
        java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x0072 }
        java.lang.String r7 = " or "
        r3.append(r7)     // Catch:{ all -> 0x0072 }
        java.lang.String r7 = "_tp"
        r3.append(r7)     // Catch:{ all -> 0x0072 }
        java.lang.String r7 = " = "
        r3.append(r7)     // Catch:{ all -> 0x0072 }
        r3.append(r5)     // Catch:{ all -> 0x0072 }
        goto L_0x0044
    L_0x0072:
        java.lang.String r5 = "[Database] unknown id."
        java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00c0 }
        com.tencent.bugly.proguard.C7226an.m31148d(r5, r6)     // Catch:{ all -> 0x00c0 }
        goto L_0x0044
    L_0x007a:
        int r5 = r3.length()     // Catch:{ all -> 0x00c0 }
        if (r5 <= 0) goto L_0x00b0
        java.lang.String r5 = " and "
        r3.append(r5)     // Catch:{ all -> 0x00c0 }
        java.lang.String r5 = "_id"
        r3.append(r5)     // Catch:{ all -> 0x00c0 }
        java.lang.String r5 = " = "
        r3.append(r5)     // Catch:{ all -> 0x00c0 }
        r3.append(r12)     // Catch:{ all -> 0x00c0 }
        r12 = 4
        java.lang.String r12 = r10.substring(r12)     // Catch:{ all -> 0x00c0 }
        java.lang.String r3 = "t_pf"
        int r12 = r1.delete(r3, r12, r0)     // Catch:{ all -> 0x00c0 }
        java.lang.String r3 = "[Database] deleted %s illegal data %d."
        r5 = 2
        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00c0 }
        java.lang.String r7 = "t_pf"
        r5[r6] = r7     // Catch:{ all -> 0x00c0 }
        r6 = 1
        java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x00c0 }
        r5[r6] = r12     // Catch:{ all -> 0x00c0 }
        com.tencent.bugly.proguard.C7226an.m31148d(r3, r5)     // Catch:{ all -> 0x00c0 }
    L_0x00b0:
        if (r2 == 0) goto L_0x00b5
        r2.close()     // Catch:{ all -> 0x00cf }
    L_0x00b5:
        boolean r12 = f24305a     // Catch:{ all -> 0x00cf }
        if (r12 == 0) goto L_0x00be
        if (r1 == 0) goto L_0x00be
        r1.close()     // Catch:{ all -> 0x00cf }
    L_0x00be:
        monitor-exit(r11)
        return r4
    L_0x00c0:
        r12 = move-exception
        goto L_0x00d4
    L_0x00c2:
        r12 = move-exception
        r2 = r0
        goto L_0x00d4
    L_0x00c5:
        boolean r12 = f24305a     // Catch:{ all -> 0x00cf }
        if (r12 == 0) goto L_0x00e9
        if (r1 == 0) goto L_0x00e9
    L_0x00cb:
        r1.close()     // Catch:{ all -> 0x00cf }
        goto L_0x00e9
    L_0x00cf:
        r12 = move-exception
        goto L_0x00fb
    L_0x00d1:
        r12 = move-exception
        r1 = r0
        r2 = r1
    L_0x00d4:
        boolean r3 = com.tencent.bugly.proguard.C7226an.m31142a(r12)     // Catch:{ all -> 0x00eb }
        if (r3 != 0) goto L_0x00dd
        r12.printStackTrace()     // Catch:{ all -> 0x00eb }
    L_0x00dd:
        if (r2 == 0) goto L_0x00e2
        r2.close()     // Catch:{ all -> 0x00cf }
    L_0x00e2:
        boolean r12 = f24305a     // Catch:{ all -> 0x00cf }
        if (r12 == 0) goto L_0x00e9
        if (r1 == 0) goto L_0x00e9
        goto L_0x00cb
    L_0x00e9:
        monitor-exit(r11)
        return r0
    L_0x00eb:
        r12 = move-exception
        if (r2 == 0) goto L_0x00f1
        r2.close()     // Catch:{ all -> 0x00cf }
    L_0x00f1:
        boolean r0 = f24305a     // Catch:{ all -> 0x00cf }
        if (r0 == 0) goto L_0x00fa
        if (r1 == 0) goto L_0x00fa
        r1.close()     // Catch:{ all -> 0x00cf }
    L_0x00fa:
        throw r12     // Catch:{ all -> 0x00cf }
    L_0x00fb:
        monitor-exit(r11)
        throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7212ae.m31049c(int):java.util.List");
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0077, code lost:
            if (r2 != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
            r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0097, code lost:
            if (r2 != null) goto L_0x0079;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0087 A[Catch:{ all -> 0x009c }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c A[SYNTHETIC, Splitter:B:29:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* renamed from: a */
    public synchronized boolean m31045a(int r6, java.lang.String r7, com.tencent.bugly.proguard.C7211ad r8) {
        /*
        r5 = this;
        monitor-enter(r5)
        r0 = 0
        r1 = 0
        com.tencent.bugly.proguard.af r2 = f24307c     // Catch:{ all -> 0x007f }
        android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ all -> 0x007f }
        if (r2 == 0) goto L_0x006a
        boolean r3 = com.tencent.bugly.proguard.C7232aq.m31196a(r7)     // Catch:{ all -> 0x0068 }
        if (r3 == 0) goto L_0x0023
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
        r7.<init>()     // Catch:{ all -> 0x0068 }
        java.lang.String r3 = "_id = "
        r7.append(r3)     // Catch:{ all -> 0x0068 }
        r7.append(r6)     // Catch:{ all -> 0x0068 }
        java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0068 }
        goto L_0x004b
    L_0x0023:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
        r3.<init>()     // Catch:{ all -> 0x0068 }
        java.lang.String r4 = "_id = "
        r3.append(r4)     // Catch:{ all -> 0x0068 }
        r3.append(r6)     // Catch:{ all -> 0x0068 }
        java.lang.String r6 = " and "
        r3.append(r6)     // Catch:{ all -> 0x0068 }
        java.lang.String r6 = "_tp"
        r3.append(r6)     // Catch:{ all -> 0x0068 }
        java.lang.String r6 = " = \""
        r3.append(r6)     // Catch:{ all -> 0x0068 }
        r3.append(r7)     // Catch:{ all -> 0x0068 }
        java.lang.String r6 = "\""
        r3.append(r6)     // Catch:{ all -> 0x0068 }
        java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0068 }
    L_0x004b:
        java.lang.String r7 = "t_pf"
        int r6 = r2.delete(r7, r6, r0)     // Catch:{ all -> 0x0068 }
        java.lang.String r7 = "[Database] deleted %s data %d"
        r0 = 2
        java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0068 }
        java.lang.String r3 = "t_pf"
        r0[r1] = r3     // Catch:{ all -> 0x0068 }
        java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0068 }
        r4 = 1
        r0[r4] = r3     // Catch:{ all -> 0x0068 }
        com.tencent.bugly.proguard.C7226an.m31147c(r7, r0)     // Catch:{ all -> 0x0068 }
        if (r6 <= 0) goto L_0x006a
        r1 = 1
        goto L_0x006a
    L_0x0068:
        r6 = move-exception
        goto L_0x0081
    L_0x006a:
        if (r8 == 0) goto L_0x0073
        java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x007d }
        r8.mo34772a(r6)     // Catch:{ all -> 0x007d }
    L_0x0073:
        boolean r6 = f24305a     // Catch:{ all -> 0x007d }
        if (r6 == 0) goto L_0x009a
        if (r2 == 0) goto L_0x009a
    L_0x0079:
        r2.close()     // Catch:{ all -> 0x007d }
        goto L_0x009a
    L_0x007d:
        r6 = move-exception
        goto L_0x00b0
    L_0x007f:
        r6 = move-exception
        r2 = r0
    L_0x0081:
        boolean r7 = com.tencent.bugly.proguard.C7226an.m31142a(r6)     // Catch:{ all -> 0x009c }
        if (r7 != 0) goto L_0x008a
        r6.printStackTrace()     // Catch:{ all -> 0x009c }
    L_0x008a:
        if (r8 == 0) goto L_0x0093
        java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x007d }
        r8.mo34772a(r6)     // Catch:{ all -> 0x007d }
    L_0x0093:
        boolean r6 = f24305a     // Catch:{ all -> 0x007d }
        if (r6 == 0) goto L_0x009a
        if (r2 == 0) goto L_0x009a
        goto L_0x0079
    L_0x009a:
        monitor-exit(r5)
        return r1
    L_0x009c:
        r6 = move-exception
        if (r8 == 0) goto L_0x00a6
        java.lang.Boolean r7 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x007d }
        r8.mo34772a(r7)     // Catch:{ all -> 0x007d }
    L_0x00a6:
        boolean r7 = f24305a     // Catch:{ all -> 0x007d }
        if (r7 == 0) goto L_0x00af
        if (r2 == 0) goto L_0x00af
        r2.close()     // Catch:{ all -> 0x007d }
    L_0x00af:
        throw r6     // Catch:{ all -> 0x007d }
    L_0x00b0:
        monitor-exit(r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7212ae.m31045a(int, java.lang.String, com.tencent.bugly.proguard.ad):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public ContentValues mo34787c(C7215ag agVar) {
        if (agVar != null && !C7232aq.m31196a(agVar.f24335f)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (agVar.f24330a > 0) {
                    contentValues.put(C7887a.f26833ID, Long.valueOf(agVar.f24330a));
                }
                contentValues.put("_tp", agVar.f24335f);
                contentValues.put("_tm", Long.valueOf(agVar.f24334e));
                if (agVar.f24336g != null) {
                    contentValues.put("_dt", agVar.f24336g);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C7215ag mo34785b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C7215ag agVar = new C7215ag();
            agVar.f24330a = cursor.getLong(cursor.getColumnIndex(C7887a.f26833ID));
            agVar.f24334e = cursor.getLong(cursor.getColumnIndex("_tm"));
            agVar.f24335f = cursor.getString(cursor.getColumnIndex("_tp"));
            agVar.f24336g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return agVar;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
