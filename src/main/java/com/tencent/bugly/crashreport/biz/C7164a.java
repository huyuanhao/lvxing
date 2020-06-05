package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import com.tencent.bugly.proguard.C7211ad;
import com.tencent.bugly.proguard.C7212ae;
import com.tencent.bugly.proguard.C7224am;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.biz.a */
public class C7164a {
    /* renamed from: a */
    private Context f23928a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public long f23929b;
    /* renamed from: c */
    private int f23930c;
    /* renamed from: d */
    private boolean f23931d = true;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$a */
    class C7167a implements Runnable {
        /* renamed from: b */
        private boolean f23936b;
        /* renamed from: c */
        private UserInfoBean f23937c;

        public C7167a(UserInfoBean userInfoBean, boolean z) {
            this.f23937c = userInfoBean;
            this.f23936b = z;
        }

        /* renamed from: a */
        private void m30710a(UserInfoBean userInfoBean) {
            if (userInfoBean != null) {
                C7174a b = C7174a.m30754b();
                if (b != null) {
                    userInfoBean.f23918j = b.mo34589e();
                }
            }
        }

        public void run() {
            try {
                if (this.f23937c != null) {
                    m30710a(this.f23937c);
                    C7226an.m31147c("[UserInfo] Record user info.", new Object[0]);
                    C7164a.this.m30694a(this.f23937c, false);
                }
                if (this.f23936b) {
                    C7164a.this.mo34534b();
                }
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$b */
    class C7168b implements Runnable {
        C7168b() {
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < C7164a.this.f23929b) {
                C7224am.m31132a().mo34833a(new C7168b(), (C7164a.this.f23929b - currentTimeMillis) + 5000);
                return;
            }
            C7164a.this.mo34531a(3, false, 0);
            C7164a.this.mo34530a();
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$c */
    class C7169c implements Runnable {
        /* renamed from: b */
        private long f23940b = 21600000;

        public C7169c(long j) {
            this.f23940b = j;
        }

        public void run() {
            C7164a.this.mo34534b();
            C7164a.this.mo34535b(this.f23940b);
        }
    }

    public C7164a(Context context, boolean z) {
        this.f23928a = context;
        this.f23931d = z;
    }

    /* renamed from: a */
    private static UserInfoBean m30693a(Context context, int i) {
        C7174a a = C7174a.m30753a(context);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f23910b = i;
        userInfoBean.f23911c = a.f24024e;
        userInfoBean.f23912d = a.mo34593g();
        userInfoBean.f23913e = System.currentTimeMillis();
        userInfoBean.f23914f = -1;
        userInfoBean.f23922n = a.f24035p;
        int i2 = 1;
        if (i != 1) {
            i2 = 0;
        }
        userInfoBean.f23923o = i2;
        userInfoBean.f23920l = a.mo34579a();
        userInfoBean.f23921m = a.f24041v;
        userInfoBean.f23915g = a.f24042w;
        userInfoBean.f23916h = a.f24043x;
        userInfoBean.f23917i = a.f24044y;
        userInfoBean.f23919k = a.f24045z;
        userInfoBean.f23926r = a.mo34556B();
        userInfoBean.f23927s = a.mo34561G();
        userInfoBean.f23924p = a.mo34562H();
        userInfoBean.f23925q = a.mo34563I();
        return userInfoBean;
    }

    /* renamed from: a */
    public void mo34531a(int i, boolean z, long j) {
        C7177a a = C7177a.m30857a();
        if (a == null || a.mo34624c().f24058h || i == 1 || i == 3) {
            if (i == 1 || i == 3) {
                this.f23930c++;
            }
            C7224am.m31132a().mo34833a(new C7167a(m30693a(this.f23928a, i), z), j);
            return;
        }
        C7226an.m31149e("UserInfo is disable", new Object[0]);
    }

    /* renamed from: a */
    public void mo34532a(long j) {
        C7224am.m31132a().mo34833a(new C7167a(null, true), j);
    }

    /* renamed from: b */
    public void mo34535b(long j) {
        C7224am.m31132a().mo34833a(new C7169c(j), j);
    }

    /* renamed from: a */
    public void mo34530a() {
        this.f23929b = C7232aq.m31204b() + 86400000;
        C7224am.m31132a().mo34833a(new C7168b(), (this.f23929b - System.currentTimeMillis()) + 5000);
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f7  */
    /* renamed from: c */
    public synchronized void m30698c() {
        /*
        r14 = this;
        monitor-enter(r14)
        boolean r0 = r14.f23931d     // Catch:{ all -> 0x018b }
        if (r0 != 0) goto L_0x0007
        monitor-exit(r14)
        return
    L_0x0007:
        com.tencent.bugly.proguard.ak r0 = com.tencent.bugly.proguard.C7219ak.m31089a()     // Catch:{ all -> 0x018b }
        if (r0 != 0) goto L_0x000f
        monitor-exit(r14)
        return
    L_0x000f:
        com.tencent.bugly.crashreport.common.strategy.a r1 = com.tencent.bugly.crashreport.common.strategy.C7177a.m30857a()     // Catch:{ all -> 0x018b }
        if (r1 != 0) goto L_0x0017
        monitor-exit(r14)
        return
    L_0x0017:
        boolean r1 = r1.mo34623b()     // Catch:{ all -> 0x018b }
        if (r1 == 0) goto L_0x0027
        r1 = 1001(0x3e9, float:1.403E-42)
        boolean r1 = r0.mo34820b(r1)     // Catch:{ all -> 0x018b }
        if (r1 != 0) goto L_0x0027
        monitor-exit(r14)
        return
    L_0x0027:
        android.content.Context r1 = r14.f23928a     // Catch:{ all -> 0x018b }
        com.tencent.bugly.crashreport.common.info.a r1 = com.tencent.bugly.crashreport.common.info.C7174a.m30753a(r1)     // Catch:{ all -> 0x018b }
        java.lang.String r1 = r1.f24024e     // Catch:{ all -> 0x018b }
        java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x018b }
        r2.<init>()     // Catch:{ all -> 0x018b }
        java.util.List r1 = r14.mo34529a(r1)     // Catch:{ all -> 0x018b }
        r3 = 0
        r4 = 1
        if (r1 == 0) goto L_0x00e6
        int r5 = r1.size()     // Catch:{ all -> 0x018b }
        int r5 = r5 + -20
        if (r5 <= 0) goto L_0x008b
        r6 = 0
    L_0x0045:
        int r7 = r1.size()     // Catch:{ all -> 0x018b }
        int r7 = r7 - r4
        if (r6 >= r7) goto L_0x007e
        int r7 = r6 + 1
        r8 = r7
    L_0x004f:
        int r9 = r1.size()     // Catch:{ all -> 0x018b }
        if (r8 >= r9) goto L_0x007c
        java.lang.Object r9 = r1.get(r6)     // Catch:{ all -> 0x018b }
        com.tencent.bugly.crashreport.biz.UserInfoBean r9 = (com.tencent.bugly.crashreport.biz.UserInfoBean) r9     // Catch:{ all -> 0x018b }
        long r9 = r9.f23913e     // Catch:{ all -> 0x018b }
        java.lang.Object r11 = r1.get(r8)     // Catch:{ all -> 0x018b }
        com.tencent.bugly.crashreport.biz.UserInfoBean r11 = (com.tencent.bugly.crashreport.biz.UserInfoBean) r11     // Catch:{ all -> 0x018b }
        long r11 = r11.f23913e     // Catch:{ all -> 0x018b }
        int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
        if (r13 <= 0) goto L_0x0079
        java.lang.Object r9 = r1.get(r6)     // Catch:{ all -> 0x018b }
        com.tencent.bugly.crashreport.biz.UserInfoBean r9 = (com.tencent.bugly.crashreport.biz.UserInfoBean) r9     // Catch:{ all -> 0x018b }
        java.lang.Object r10 = r1.get(r8)     // Catch:{ all -> 0x018b }
        r1.set(r6, r10)     // Catch:{ all -> 0x018b }
        r1.set(r8, r9)     // Catch:{ all -> 0x018b }
    L_0x0079:
        int r8 = r8 + 1
        goto L_0x004f
    L_0x007c:
        r6 = r7
        goto L_0x0045
    L_0x007e:
        r6 = 0
    L_0x007f:
        if (r6 >= r5) goto L_0x008b
        java.lang.Object r7 = r1.get(r6)     // Catch:{ all -> 0x018b }
        r2.add(r7)     // Catch:{ all -> 0x018b }
        int r6 = r6 + 1
        goto L_0x007f
    L_0x008b:
        java.util.Iterator r5 = r1.iterator()     // Catch:{ all -> 0x018b }
        r6 = 0
    L_0x0090:
        boolean r7 = r5.hasNext()     // Catch:{ all -> 0x018b }
        if (r7 == 0) goto L_0x00d3
        java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x018b }
        com.tencent.bugly.crashreport.biz.UserInfoBean r7 = (com.tencent.bugly.crashreport.biz.UserInfoBean) r7     // Catch:{ all -> 0x018b }
        long r8 = r7.f23914f     // Catch:{ all -> 0x018b }
        r10 = -1
        int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
        if (r12 == 0) goto L_0x00b4
        r5.remove()     // Catch:{ all -> 0x018b }
        long r8 = r7.f23913e     // Catch:{ all -> 0x018b }
        long r10 = com.tencent.bugly.proguard.C7232aq.m31204b()     // Catch:{ all -> 0x018b }
        int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
        if (r12 >= 0) goto L_0x00b4
        r2.add(r7)     // Catch:{ all -> 0x018b }
    L_0x00b4:
        long r8 = r7.f23913e     // Catch:{ all -> 0x018b }
        long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x018b }
        r12 = 600000(0x927c0, double:2.964394E-318)
        long r10 = r10 - r12
        int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
        if (r12 <= 0) goto L_0x0090
        int r8 = r7.f23910b     // Catch:{ all -> 0x018b }
        if (r8 == r4) goto L_0x00d0
        int r8 = r7.f23910b     // Catch:{ all -> 0x018b }
        r9 = 4
        if (r8 == r9) goto L_0x00d0
        int r7 = r7.f23910b     // Catch:{ all -> 0x018b }
        r8 = 3
        if (r7 != r8) goto L_0x0090
    L_0x00d0:
        int r6 = r6 + 1
        goto L_0x0090
    L_0x00d3:
        r5 = 15
        if (r6 <= r5) goto L_0x00eb
        java.lang.String r5 = "[UserInfo] Upload user info too many times in 10 min: %d"
        java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x018b }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x018b }
        r7[r3] = r6     // Catch:{ all -> 0x018b }
        com.tencent.bugly.proguard.C7226an.m31148d(r5, r7)     // Catch:{ all -> 0x018b }
        r5 = 0
        goto L_0x00ec
    L_0x00e6:
        java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x018b }
        r1.<init>()     // Catch:{ all -> 0x018b }
    L_0x00eb:
        r5 = 1
    L_0x00ec:
        int r6 = r2.size()     // Catch:{ all -> 0x018b }
        if (r6 <= 0) goto L_0x00f5
        r14.mo34533a(r2)     // Catch:{ all -> 0x018b }
    L_0x00f5:
        if (r5 == 0) goto L_0x0182
        int r2 = r1.size()     // Catch:{ all -> 0x018b }
        if (r2 != 0) goto L_0x00ff
        goto L_0x0182
    L_0x00ff:
        java.lang.String r2 = "[UserInfo] Upload user info(size: %d)"
        java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x018b }
        int r6 = r1.size()     // Catch:{ all -> 0x018b }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x018b }
        r5[r3] = r6     // Catch:{ all -> 0x018b }
        com.tencent.bugly.proguard.C7226an.m31147c(r2, r5)     // Catch:{ all -> 0x018b }
        int r2 = r14.f23930c     // Catch:{ all -> 0x018b }
        if (r2 != r4) goto L_0x0116
        r2 = 1
        goto L_0x0117
    L_0x0116:
        r2 = 2
    L_0x0117:
        com.tencent.bugly.proguard.bm r2 = com.tencent.bugly.proguard.C7216ah.m31076a(r1, r2)     // Catch:{ all -> 0x018b }
        if (r2 != 0) goto L_0x0126
        java.lang.String r0 = "[UserInfo] Failed to create UserInfoPackage."
        java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x018b }
        com.tencent.bugly.proguard.C7226an.m31148d(r0, r1)     // Catch:{ all -> 0x018b }
        monitor-exit(r14)
        return
    L_0x0126:
        byte[] r2 = com.tencent.bugly.proguard.C7216ah.m31078a(r2)     // Catch:{ all -> 0x018b }
        if (r2 != 0) goto L_0x0135
        java.lang.String r0 = "[UserInfo] Failed to encode data."
        java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x018b }
        com.tencent.bugly.proguard.C7226an.m31148d(r0, r1)     // Catch:{ all -> 0x018b }
        monitor-exit(r14)
        return
    L_0x0135:
        boolean r5 = r0.f24342b     // Catch:{ all -> 0x018b }
        if (r5 == 0) goto L_0x013c
        r5 = 840(0x348, float:1.177E-42)
        goto L_0x013e
    L_0x013c:
        r5 = 640(0x280, float:8.97E-43)
    L_0x013e:
        android.content.Context r6 = r14.f23928a     // Catch:{ all -> 0x018b }
        com.tencent.bugly.proguard.bh r9 = com.tencent.bugly.proguard.C7216ah.m31073a(r6, r5, r2)     // Catch:{ all -> 0x018b }
        if (r9 != 0) goto L_0x014f
        java.lang.String r0 = "[UserInfo] Request package is null."
        java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x018b }
        com.tencent.bugly.proguard.C7226an.m31148d(r0, r1)     // Catch:{ all -> 0x018b }
        monitor-exit(r14)
        return
    L_0x014f:
        com.tencent.bugly.crashreport.biz.a$1 r12 = new com.tencent.bugly.crashreport.biz.a$1     // Catch:{ all -> 0x018b }
        r12.m52468init(r1)     // Catch:{ all -> 0x018b }
        com.tencent.bugly.crashreport.common.strategy.a r1 = com.tencent.bugly.crashreport.common.strategy.C7177a.m30857a()     // Catch:{ all -> 0x018b }
        com.tencent.bugly.crashreport.common.strategy.StrategyBean r1 = r1.mo34624c()     // Catch:{ all -> 0x018b }
        boolean r2 = r0.f24342b     // Catch:{ all -> 0x018b }
        if (r2 == 0) goto L_0x0163
        java.lang.String r1 = r1.f24068r     // Catch:{ all -> 0x018b }
        goto L_0x0165
    L_0x0163:
        java.lang.String r1 = r1.f24070t     // Catch:{ all -> 0x018b }
    L_0x0165:
        r10 = r1
        boolean r0 = r0.f24342b     // Catch:{ all -> 0x018b }
        if (r0 == 0) goto L_0x016d
        java.lang.String r0 = com.tencent.bugly.crashreport.common.strategy.StrategyBean.f24052b     // Catch:{ all -> 0x018b }
        goto L_0x016f
    L_0x016d:
        java.lang.String r0 = com.tencent.bugly.crashreport.common.strategy.StrategyBean.f24051a     // Catch:{ all -> 0x018b }
    L_0x016f:
        r11 = r0
        com.tencent.bugly.proguard.ak r7 = com.tencent.bugly.proguard.C7219ak.m31089a()     // Catch:{ all -> 0x018b }
        r8 = 1001(0x3e9, float:1.403E-42)
        int r0 = r14.f23930c     // Catch:{ all -> 0x018b }
        if (r0 != r4) goto L_0x017c
        r13 = 1
        goto L_0x017d
    L_0x017c:
        r13 = 0
    L_0x017d:
        r7.mo34813a(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x018b }
        monitor-exit(r14)
        return
    L_0x0182:
        java.lang.String r0 = "[UserInfo] There is no user info in local database."
        java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x018b }
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r1)     // Catch:{ all -> 0x018b }
        monitor-exit(r14)
        return
    L_0x018b:
        r0 = move-exception
        monitor-exit(r14)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.C7164a.m30698c():void");
    }

    /* renamed from: b */
    public void mo34534b() {
        C7224am a = C7224am.m31132a();
        if (a != null) {
            a.mo34832a(new Runnable() {
                public void run() {
                    try {
                        C7164a.this.m30698c();
                    } catch (Throwable th) {
                        C7226an.m31142a(th);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30694a(UserInfoBean userInfoBean, boolean z) {
        if (userInfoBean != null) {
            if (!z && userInfoBean.f23910b != 1) {
                List a = mo34529a(C7174a.m30753a(this.f23928a).f24024e);
                if (a != null && a.size() >= 20) {
                    C7226an.m31141a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a.size()));
                    return;
                }
            }
            String str = "t_ui";
            long a2 = C7212ae.m31041a().mo34774a(str, mo34527a(userInfoBean), (C7211ad) null, true);
            if (a2 >= 0) {
                C7226an.m31147c("[Database] insert %s success with ID: %d", str, Long.valueOf(a2));
                userInfoBean.f23909a = a2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3 A[Catch:{ all -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b8 A[DONT_GENERATE] */
    /* renamed from: a */
    public java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean> mo34529a(java.lang.String r13) {
        /*
        r12 = this;
        java.lang.String r0 = "_id"
        r1 = 0
        boolean r2 = com.tencent.bugly.proguard.C7232aq.m31196a(r13)     // Catch:{ all -> 0x00ab }
        if (r2 == 0) goto L_0x000b
        r5 = r1
        goto L_0x0022
    L_0x000b:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ab }
        r2.<init>()     // Catch:{ all -> 0x00ab }
        java.lang.String r3 = "_pc = '"
        r2.append(r3)     // Catch:{ all -> 0x00ab }
        r2.append(r13)     // Catch:{ all -> 0x00ab }
        java.lang.String r13 = "'"
        r2.append(r13)     // Catch:{ all -> 0x00ab }
        java.lang.String r13 = r2.toString()     // Catch:{ all -> 0x00ab }
        r5 = r13
    L_0x0022:
        com.tencent.bugly.proguard.ae r2 = com.tencent.bugly.proguard.C7212ae.m31041a()     // Catch:{ all -> 0x00ab }
        java.lang.String r3 = "t_ui"
        r4 = 0
        r6 = 0
        r7 = 0
        r8 = 1
        android.database.Cursor r13 = r2.mo34775a(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00ab }
        if (r13 != 0) goto L_0x0038
        if (r13 == 0) goto L_0x0037
        r13.close()
    L_0x0037:
        return r1
    L_0x0038:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
        r2.<init>()     // Catch:{ all -> 0x00a9 }
        java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00a9 }
        r3.<init>()     // Catch:{ all -> 0x00a9 }
    L_0x0042:
        boolean r4 = r13.moveToNext()     // Catch:{ all -> 0x00a9 }
        r5 = 0
        if (r4 == 0) goto L_0x0074
        com.tencent.bugly.crashreport.biz.UserInfoBean r4 = r12.mo34528a(r13)     // Catch:{ all -> 0x00a9 }
        if (r4 == 0) goto L_0x0053
        r3.add(r4)     // Catch:{ all -> 0x00a9 }
        goto L_0x0042
    L_0x0053:
        int r4 = r13.getColumnIndex(r0)     // Catch:{ all -> 0x006c }
        long r6 = r13.getLong(r4)     // Catch:{ all -> 0x006c }
        java.lang.String r4 = " or "
        r2.append(r4)     // Catch:{ all -> 0x006c }
        r2.append(r0)     // Catch:{ all -> 0x006c }
        java.lang.String r4 = " = "
        r2.append(r4)     // Catch:{ all -> 0x006c }
        r2.append(r6)     // Catch:{ all -> 0x006c }
        goto L_0x0042
    L_0x006c:
        java.lang.String r4 = "[Database] unknown id."
        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00a9 }
        com.tencent.bugly.proguard.C7226an.m31148d(r4, r5)     // Catch:{ all -> 0x00a9 }
        goto L_0x0042
    L_0x0074:
        java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00a9 }
        int r2 = r0.length()     // Catch:{ all -> 0x00a9 }
        if (r2 <= 0) goto L_0x00a3
        r2 = 4
        java.lang.String r8 = r0.substring(r2)     // Catch:{ all -> 0x00a9 }
        com.tencent.bugly.proguard.ae r6 = com.tencent.bugly.proguard.C7212ae.m31041a()     // Catch:{ all -> 0x00a9 }
        java.lang.String r7 = "t_ui"
        r9 = 0
        r10 = 0
        r11 = 1
        int r0 = r6.mo34773a(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00a9 }
        java.lang.String r2 = "[Database] deleted %s error data %d"
        r4 = 2
        java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00a9 }
        java.lang.String r6 = "t_ui"
        r4[r5] = r6     // Catch:{ all -> 0x00a9 }
        r5 = 1
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00a9 }
        r4[r5] = r0     // Catch:{ all -> 0x00a9 }
        com.tencent.bugly.proguard.C7226an.m31148d(r2, r4)     // Catch:{ all -> 0x00a9 }
    L_0x00a3:
        if (r13 == 0) goto L_0x00a8
        r13.close()
    L_0x00a8:
        return r3
    L_0x00a9:
        r0 = move-exception
        goto L_0x00ad
    L_0x00ab:
        r0 = move-exception
        r13 = r1
    L_0x00ad:
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x00bc }
        if (r2 != 0) goto L_0x00b6
        r0.printStackTrace()     // Catch:{ all -> 0x00bc }
    L_0x00b6:
        if (r13 == 0) goto L_0x00bb
        r13.close()
    L_0x00bb:
        return r1
    L_0x00bc:
        r0 = move-exception
        if (r13 == 0) goto L_0x00c2
        r13.close()
    L_0x00c2:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.C7164a.mo34529a(java.lang.String):java.util.List");
    }

    /* renamed from: a */
    public void mo34533a(List<UserInfoBean> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < list.size() && i < 50) {
                UserInfoBean userInfoBean = (UserInfoBean) list.get(i);
                sb.append(" or ");
                sb.append(C7887a.f26833ID);
                sb.append(" = ");
                sb.append(userInfoBean.f23909a);
                i++;
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                sb2 = sb2.substring(4);
            }
            String str = sb2;
            sb.setLength(0);
            try {
                C7226an.m31147c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(C7212ae.m31041a().mo34773a("t_ui", str, (String[]) null, (C7211ad) null, true)));
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ContentValues mo34527a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f23909a > 0) {
                contentValues.put(C7887a.f26833ID, Long.valueOf(userInfoBean.f23909a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f23913e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f23914f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f23910b));
            contentValues.put("_pc", userInfoBean.f23911c);
            contentValues.put("_dt", C7232aq.m31199a((Parcelable) userInfoBean));
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
    public UserInfoBean mo34528a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex(C7887a.f26833ID));
            UserInfoBean userInfoBean = (UserInfoBean) C7232aq.m31177a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f23909a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
