package com.p620ut.mini;

import android.app.Activity;
import android.net.Uri;
import com.tencent.android.tpush.common.Constants;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.ut.mini.e */
public class UTPageHitHelper {
    /* renamed from: b */
    private static UTPageHitHelper f26054b = new UTPageHitHelper();
    /* renamed from: a */
    private boolean f26055a = false;
    /* renamed from: c */
    private Map<String, String> f26056c = new HashMap();
    /* renamed from: d */
    private Map<String, C7718a> f26057d = new HashMap();
    /* renamed from: e */
    private String f26058e = null;
    /* renamed from: f */
    private Map<String, String> f26059f = new HashMap();
    /* renamed from: g */
    private String f26060g = null;
    /* renamed from: h */
    private Queue<C7718a> f26061h = new LinkedList();
    /* renamed from: i */
    private Map<Object, String> f26062i = new HashMap();

    /* compiled from: UTPageHitHelper */
    /* renamed from: com.ut.mini.e$a */
    public static class C7718a {
        /* renamed from: a */
        private Map<String, String> f26063a = new HashMap();
        /* renamed from: b */
        private long f26064b = 0;
        /* renamed from: c */
        private Uri f26065c = null;
        /* renamed from: d */
        private String f26066d = null;
        /* renamed from: e */
        private String f26067e = null;
        /* renamed from: f */
        private UTPageStatus f26068f = null;
        /* renamed from: g */
        private boolean f26069g = false;
        /* renamed from: h */
        private boolean f26070h = false;
        /* renamed from: i */
        private boolean f26071i = false;
        /* renamed from: j */
        private String f26072j = null;

        /* renamed from: a */
        public void mo37459a(String str) {
            this.f26072j = str;
        }

        /* renamed from: a */
        public String mo37456a() {
            return this.f26072j;
        }

        /* renamed from: b */
        public void mo37461b() {
            this.f26063a = new HashMap();
            this.f26064b = 0;
            this.f26065c = null;
            this.f26066d = null;
            this.f26067e = null;
            UTPageStatus uTPageStatus = this.f26068f;
            if (uTPageStatus == null || uTPageStatus != UTPageStatus.UT_H5_IN_WebView) {
                this.f26068f = null;
            }
            this.f26069g = false;
            this.f26071i = false;
        }

        /* renamed from: c */
        public boolean mo37464c() {
            return this.f26071i;
        }

        /* renamed from: d */
        public boolean mo37465d() {
            return this.f26070h;
        }

        /* renamed from: e */
        public void mo37466e() {
            this.f26069g = true;
        }

        /* renamed from: f */
        public boolean mo37467f() {
            return this.f26069g;
        }

        /* renamed from: g */
        public UTPageStatus mo37468g() {
            return this.f26068f;
        }

        /* renamed from: h */
        public Map<String, String> mo37469h() {
            return this.f26063a;
        }

        /* renamed from: a */
        public void mo37460a(Map<String, String> map) {
            this.f26063a = map;
        }

        /* renamed from: i */
        public long mo37470i() {
            return this.f26064b;
        }

        /* renamed from: a */
        public void mo37457a(long j) {
            this.f26064b = j;
        }

        /* renamed from: j */
        public Uri mo37471j() {
            return this.f26065c;
        }

        /* renamed from: a */
        public void mo37458a(Uri uri) {
            this.f26065c = uri;
        }

        /* renamed from: b */
        public void mo37462b(String str) {
            this.f26066d = str;
        }

        /* renamed from: k */
        public String mo37472k() {
            return this.f26066d;
        }

        /* renamed from: c */
        public void mo37463c(String str) {
            this.f26067e = str;
        }

        /* renamed from: l */
        public String mo37473l() {
            return this.f26067e;
        }
    }

    /* renamed from: a */
    public static UTPageHitHelper m33190a() {
        return f26054b;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo37450a(C7718a aVar) {
        aVar.mo37461b();
        if (!this.f26061h.contains(aVar)) {
            this.f26061h.add(aVar);
        }
        if (this.f26061h.size() > 200) {
            for (int i = 0; i < 100; i++) {
                C7718a aVar2 = (C7718a) this.f26061h.poll();
                if (aVar2 != null && this.f26057d.containsKey(aVar2.mo37456a())) {
                    this.f26057d.remove(aVar2.mo37456a());
                }
            }
        }
    }

    @Deprecated
    /* renamed from: b */
    public synchronized void mo37453b() {
        this.f26055a = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37449a(Activity activity) {
        if (!this.f26055a) {
            mo37451a((Object) activity);
        }
    }

    /* renamed from: c */
    private String m33194c(Object obj) {
        String str;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = obj.getClass().getSimpleName();
        }
        int hashCode = obj.hashCode();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(hashCode);
        return sb.toString();
    }

    /* renamed from: d */
    private synchronized C7718a m33195d(Object obj) {
        String c = m33194c(obj);
        if (this.f26057d.containsKey(c)) {
            return (C7718a) this.f26057d.get(c);
        }
        C7718a aVar = new C7718a();
        this.f26057d.put(c, aVar);
        aVar.mo37459a(c);
        return aVar;
    }

    /* renamed from: a */
    private synchronized void m33192a(String str, C7718a aVar) {
        this.f26057d.put(str, aVar);
    }

    /* renamed from: b */
    private synchronized void m33193b(C7718a aVar) {
        if (this.f26057d.containsKey(aVar.mo37456a())) {
            this.f26057d.remove(aVar.mo37456a());
        }
    }

    /* renamed from: e */
    private synchronized void m33196e(Object obj) {
        String c = m33194c(obj);
        if (this.f26057d.containsKey(c)) {
            this.f26057d.remove(c);
        }
    }

    @Deprecated
    /* renamed from: a */
    public synchronized void mo37451a(Object obj) {
        mo37452a(obj, null, false);
    }

    /* access modifiers changed from: declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fd, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo37452a(java.lang.Object r5, java.lang.String r6, boolean r7) {
        /*
        r4 = this;
        monitor-enter(r4)
        if (r5 == 0) goto L_0x00f5
        java.lang.String r0 = r4.m33194c(r5)     // Catch:{ all -> 0x00fe }
        if (r0 == 0) goto L_0x0013
        java.lang.String r1 = r4.f26058e     // Catch:{ all -> 0x00fe }
        boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x00fe }
        if (r0 == 0) goto L_0x0013
        monitor-exit(r4)
        return
    L_0x0013:
        java.lang.String r0 = r4.f26058e     // Catch:{ all -> 0x00fe }
        if (r0 == 0) goto L_0x0034
        java.lang.String r0 = "lost 2001"
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
        r1.<init>()     // Catch:{ all -> 0x00fe }
        java.lang.String r2 = "Last page requires leave("
        r1.append(r2)     // Catch:{ all -> 0x00fe }
        java.lang.String r2 = r4.f26058e     // Catch:{ all -> 0x00fe }
        r1.append(r2)     // Catch:{ all -> 0x00fe }
        java.lang.String r2 = ")."
        r1.append(r2)     // Catch:{ all -> 0x00fe }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00fe }
        com.alibaba.mtl.log.p077d.Logger.m3831a(r0, r1)     // Catch:{ all -> 0x00fe }
    L_0x0034:
        com.ut.mini.e$a r0 = r4.m33195d(r5)     // Catch:{ all -> 0x00fe }
        if (r7 != 0) goto L_0x0066
        boolean r7 = r0.mo37465d()     // Catch:{ all -> 0x00fe }
        if (r7 == 0) goto L_0x0066
        java.lang.String r6 = "skip page[pageAppear]"
        r7 = 1
        java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ all -> 0x00fe }
        r0 = 0
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
        r1.<init>()     // Catch:{ all -> 0x00fe }
        java.lang.String r2 = "page name:"
        r1.append(r2)     // Catch:{ all -> 0x00fe }
        java.lang.Class r5 = r5.getClass()     // Catch:{ all -> 0x00fe }
        java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x00fe }
        r1.append(r5)     // Catch:{ all -> 0x00fe }
        java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x00fe }
        r7[r0] = r5     // Catch:{ all -> 0x00fe }
        com.alibaba.mtl.log.p077d.Logger.m3834a(r6, r7)     // Catch:{ all -> 0x00fe }
        monitor-exit(r4)
        return
    L_0x0066:
        com.ut.mini.a.a r7 = com.p620ut.mini.p621a.UTMIVariables.m33112b()     // Catch:{ all -> 0x00fe }
        java.lang.String r7 = r7.mo37395c()     // Catch:{ all -> 0x00fe }
        r1 = 0
        if (r7 == 0) goto L_0x008e
        android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ all -> 0x0083 }
        java.lang.String r2 = "spm"
        java.lang.String r7 = r7.getQueryParameter(r2)     // Catch:{ all -> 0x0083 }
        java.util.Map<java.lang.String, java.lang.String> r2 = r4.f26056c     // Catch:{ all -> 0x0083 }
        java.lang.String r3 = "spm"
        r2.put(r3, r7)     // Catch:{ all -> 0x0083 }
        goto L_0x0087
    L_0x0083:
        r7 = move-exception
        r7.printStackTrace()     // Catch:{ all -> 0x00fe }
    L_0x0087:
        com.ut.mini.a.a r7 = com.p620ut.mini.p621a.UTMIVariables.m33112b()     // Catch:{ all -> 0x00fe }
        r7.mo37392a(r1)     // Catch:{ all -> 0x00fe }
    L_0x008e:
        java.lang.String r7 = m33197f(r5)     // Catch:{ all -> 0x00fe }
        boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00fe }
        if (r2 != 0) goto L_0x0099
        goto L_0x009a
    L_0x0099:
        r6 = r7
    L_0x009a:
        java.lang.String r7 = r0.mo37472k()     // Catch:{ all -> 0x00fe }
        boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00fe }
        if (r7 != 0) goto L_0x00a8
        java.lang.String r6 = r0.mo37472k()     // Catch:{ all -> 0x00fe }
    L_0x00a8:
        r4.f26060g = r6     // Catch:{ all -> 0x00fe }
        r0.mo37462b(r6)     // Catch:{ all -> 0x00fe }
        long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00fe }
        r0.mo37457a(r6)     // Catch:{ all -> 0x00fe }
        com.ut.mini.a.a r6 = com.p620ut.mini.p621a.UTMIVariables.m33112b()     // Catch:{ all -> 0x00fe }
        java.lang.String r6 = r6.mo37396d()     // Catch:{ all -> 0x00fe }
        r0.mo37463c(r6)     // Catch:{ all -> 0x00fe }
        r0.mo37466e()     // Catch:{ all -> 0x00fe }
        java.util.Map<java.lang.String, java.lang.String> r6 = r4.f26059f     // Catch:{ all -> 0x00fe }
        if (r6 == 0) goto L_0x00e2
        java.util.Map r6 = r0.mo37469h()     // Catch:{ all -> 0x00fe }
        if (r6 != 0) goto L_0x00d2
        java.util.Map<java.lang.String, java.lang.String> r6 = r4.f26059f     // Catch:{ all -> 0x00fe }
        r0.mo37460a(r6)     // Catch:{ all -> 0x00fe }
        goto L_0x00e2
    L_0x00d2:
        java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x00fe }
        r7.<init>()     // Catch:{ all -> 0x00fe }
        r7.putAll(r6)     // Catch:{ all -> 0x00fe }
        java.util.Map<java.lang.String, java.lang.String> r6 = r4.f26059f     // Catch:{ all -> 0x00fe }
        r7.putAll(r6)     // Catch:{ all -> 0x00fe }
        r0.mo37460a(r7)     // Catch:{ all -> 0x00fe }
    L_0x00e2:
        r4.f26059f = r1     // Catch:{ all -> 0x00fe }
        java.lang.String r6 = r4.m33194c(r5)     // Catch:{ all -> 0x00fe }
        r4.f26058e = r6     // Catch:{ all -> 0x00fe }
        r4.m33193b(r0)     // Catch:{ all -> 0x00fe }
        java.lang.String r5 = r4.m33194c(r5)     // Catch:{ all -> 0x00fe }
        r4.m33192a(r5, r0)     // Catch:{ all -> 0x00fe }
        goto L_0x00fc
    L_0x00f5:
        java.lang.String r5 = "pageAppear"
        java.lang.String r6 = "The page object should not be null"
        com.alibaba.mtl.log.p077d.Logger.m3831a(r5, r6)     // Catch:{ all -> 0x00fe }
    L_0x00fc:
        monitor-exit(r4)
        return
    L_0x00fe:
        r5 = move-exception
        monitor-exit(r4)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p620ut.mini.UTPageHitHelper.mo37452a(java.lang.Object, java.lang.String, boolean):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37454b(Activity activity) {
        if (!this.f26055a) {
            mo37455b((Object) activity);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01ba, code lost:
            return;
     */
    @java.lang.Deprecated
    /* renamed from: b */
    public synchronized void mo37455b(java.lang.Object r12) {
        /*
        r11 = this;
        monitor-enter(r11)
        if (r12 == 0) goto L_0x01b2
        java.lang.String r0 = r11.f26058e     // Catch:{ all -> 0x01bb }
        if (r0 != 0) goto L_0x0009
        monitor-exit(r11)
        return
    L_0x0009:
        com.ut.mini.e$a r0 = r11.m33195d(r12)     // Catch:{ all -> 0x01bb }
        boolean r1 = r0.mo37467f()     // Catch:{ all -> 0x01bb }
        if (r1 == 0) goto L_0x0167
        com.ut.mini.UTPageStatus r1 = r0.mo37468g()     // Catch:{ all -> 0x01bb }
        if (r1 == 0) goto L_0x002c
        com.ut.mini.UTPageStatus r1 = com.p620ut.mini.UTPageStatus.UT_H5_IN_WebView     // Catch:{ all -> 0x01bb }
        com.ut.mini.UTPageStatus r2 = r0.mo37468g()     // Catch:{ all -> 0x01bb }
        if (r1 != r2) goto L_0x002c
        boolean r1 = r0.mo37464c()     // Catch:{ all -> 0x01bb }
        if (r1 == 0) goto L_0x002c
        r11.mo37450a(r0)     // Catch:{ all -> 0x01bb }
        monitor-exit(r11)
        return
    L_0x002c:
        long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x01bb }
        long r3 = r0.mo37470i()     // Catch:{ all -> 0x01bb }
        long r1 = r1 - r3
        android.net.Uri r3 = r0.mo37471j()     // Catch:{ all -> 0x01bb }
        if (r3 != 0) goto L_0x0056
        boolean r3 = r12 instanceof android.app.Activity     // Catch:{ all -> 0x01bb }
        if (r3 == 0) goto L_0x0056
        r3 = r12
        android.app.Activity r3 = (android.app.Activity) r3     // Catch:{ all -> 0x01bb }
        android.content.Intent r3 = r3.getIntent()     // Catch:{ all -> 0x01bb }
        if (r3 == 0) goto L_0x0056
        r3 = r12
        android.app.Activity r3 = (android.app.Activity) r3     // Catch:{ all -> 0x01bb }
        android.content.Intent r3 = r3.getIntent()     // Catch:{ all -> 0x01bb }
        android.net.Uri r3 = r3.getData()     // Catch:{ all -> 0x01bb }
        r0.mo37458a(r3)     // Catch:{ all -> 0x01bb }
    L_0x0056:
        java.lang.String r3 = r0.mo37472k()     // Catch:{ all -> 0x01bb }
        java.lang.String r4 = r0.mo37473l()     // Catch:{ all -> 0x01bb }
        if (r4 == 0) goto L_0x0066
        int r5 = r4.length()     // Catch:{ all -> 0x01bb }
        if (r5 != 0) goto L_0x0068
    L_0x0066:
        java.lang.String r4 = "-"
    L_0x0068:
        java.util.Map<java.lang.String, java.lang.String> r5 = r11.f26056c     // Catch:{ all -> 0x01bb }
        if (r5 != 0) goto L_0x0071
        java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x01bb }
        r5.<init>()     // Catch:{ all -> 0x01bb }
    L_0x0071:
        java.util.Map r6 = r0.mo37469h()     // Catch:{ all -> 0x01bb }
        if (r6 == 0) goto L_0x007e
        java.util.Map r6 = r0.mo37469h()     // Catch:{ all -> 0x01bb }
        r5.putAll(r6)     // Catch:{ all -> 0x01bb }
    L_0x007e:
        boolean r6 = r12 instanceof com.p620ut.mini.IUTPageTrack     // Catch:{ all -> 0x01bb }
        if (r6 == 0) goto L_0x00ae
        r6 = r12
        com.ut.mini.a r6 = (com.p620ut.mini.IUTPageTrack) r6     // Catch:{ all -> 0x01bb }
        java.lang.String r7 = r6.mo37388a()     // Catch:{ all -> 0x01bb }
        boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01bb }
        if (r8 != 0) goto L_0x0090
        r4 = r7
    L_0x0090:
        java.util.Map r7 = r6.mo37390c()     // Catch:{ all -> 0x01bb }
        if (r7 == 0) goto L_0x00a3
        int r8 = r7.size()     // Catch:{ all -> 0x01bb }
        if (r8 <= 0) goto L_0x00a3
        java.util.Map<java.lang.String, java.lang.String> r5 = r11.f26056c     // Catch:{ all -> 0x01bb }
        r5.putAll(r7)     // Catch:{ all -> 0x01bb }
        java.util.Map<java.lang.String, java.lang.String> r5 = r11.f26056c     // Catch:{ all -> 0x01bb }
    L_0x00a3:
        java.lang.String r6 = r6.mo37389b()     // Catch:{ all -> 0x01bb }
        boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01bb }
        if (r7 != 0) goto L_0x00ae
        r3 = r6
    L_0x00ae:
        android.net.Uri r6 = r0.mo37471j()     // Catch:{ all -> 0x01bb }
        if (r6 == 0) goto L_0x0136
        java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0132 }
        r7.<init>()     // Catch:{ all -> 0x0132 }
        java.lang.String r8 = "spm"
        java.lang.String r8 = r6.getQueryParameter(r8)     // Catch:{ all -> 0x0132 }
        boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0132 }
        if (r9 == 0) goto L_0x00de
        java.lang.String r9 = r6.toString()     // Catch:{ UnsupportedEncodingException -> 0x00da }
        java.lang.String r10 = "UTF-8"
        java.lang.String r9 = java.net.URLDecoder.decode(r9, r10)     // Catch:{ UnsupportedEncodingException -> 0x00da }
        android.net.Uri r6 = android.net.Uri.parse(r9)     // Catch:{ UnsupportedEncodingException -> 0x00da }
        java.lang.String r9 = "spm"
        java.lang.String r8 = r6.getQueryParameter(r9)     // Catch:{ UnsupportedEncodingException -> 0x00da }
        goto L_0x00de
    L_0x00da:
        r9 = move-exception
        r9.printStackTrace()     // Catch:{ all -> 0x0132 }
    L_0x00de:
        boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0132 }
        if (r9 != 0) goto L_0x0106
        r9 = 0
        java.util.Map<java.lang.Object, java.lang.String> r10 = r11.f26062i     // Catch:{ all -> 0x0132 }
        boolean r10 = r10.containsKey(r12)     // Catch:{ all -> 0x0132 }
        if (r10 == 0) goto L_0x00fa
        java.util.Map<java.lang.Object, java.lang.String> r10 = r11.f26062i     // Catch:{ all -> 0x0132 }
        java.lang.Object r10 = r10.get(r12)     // Catch:{ all -> 0x0132 }
        boolean r10 = r8.equals(r10)     // Catch:{ all -> 0x0132 }
        if (r10 == 0) goto L_0x00fa
        r9 = 1
    L_0x00fa:
        if (r9 != 0) goto L_0x0106
        java.lang.String r9 = "spm"
        r7.put(r9, r8)     // Catch:{ all -> 0x0132 }
        java.util.Map<java.lang.Object, java.lang.String> r9 = r11.f26062i     // Catch:{ all -> 0x0132 }
        r9.put(r12, r8)     // Catch:{ all -> 0x0132 }
    L_0x0106:
        java.lang.String r8 = "scm"
        java.lang.String r8 = r6.getQueryParameter(r8)     // Catch:{ all -> 0x0132 }
        boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0132 }
        if (r9 != 0) goto L_0x0117
        java.lang.String r9 = "scm"
        r7.put(r9, r8)     // Catch:{ all -> 0x0132 }
    L_0x0117:
        java.lang.String r6 = m33191a(r6)     // Catch:{ all -> 0x0132 }
        boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0132 }
        if (r8 != 0) goto L_0x0128
        com.alibaba.mtl.log.c r8 = com.alibaba.mtl.log.UTMCVariables.m3755a()     // Catch:{ all -> 0x0132 }
        r8.mo11774a(r6)     // Catch:{ all -> 0x0132 }
    L_0x0128:
        int r6 = r7.size()     // Catch:{ all -> 0x0132 }
        if (r6 <= 0) goto L_0x0136
        r5.putAll(r7)     // Catch:{ all -> 0x0132 }
        goto L_0x0136
    L_0x0132:
        r6 = move-exception
        r6.printStackTrace()     // Catch:{ all -> 0x01bb }
    L_0x0136:
        com.ut.mini.c$c r6 = new com.ut.mini.c$c     // Catch:{ all -> 0x01bb }
        r6.m53896init(r3)     // Catch:{ all -> 0x01bb }
        com.ut.mini.c$c r4 = r6.mo37430a(r4)     // Catch:{ all -> 0x01bb }
        com.ut.mini.c$c r1 = r4.mo37429a(r1)     // Catch:{ all -> 0x01bb }
        r1.mo37428a(r5)     // Catch:{ all -> 0x01bb }
        com.ut.mini.a.a r1 = com.p620ut.mini.p621a.UTMIVariables.m33112b()     // Catch:{ all -> 0x01bb }
        r1.mo37394b(r3)     // Catch:{ all -> 0x01bb }
        com.ut.mini.b r1 = com.p620ut.mini.UTAnalytics.m33119a()     // Catch:{ all -> 0x01bb }
        com.ut.mini.f r1 = r1.mo37401b()     // Catch:{ all -> 0x01bb }
        if (r1 == 0) goto L_0x015f
        java.util.Map r2 = r6.mo37426a()     // Catch:{ all -> 0x01bb }
        r1.mo37476a(r2)     // Catch:{ all -> 0x01bb }
        goto L_0x0186
    L_0x015f:
        java.lang.String r1 = "Record page event error"
        java.lang.String r2 = "Fatal Error,must call setRequestAuthentication method first."
        com.alibaba.mtl.log.p077d.Logger.m3831a(r1, r2)     // Catch:{ all -> 0x01bb }
        goto L_0x0186
    L_0x0167:
        java.lang.String r1 = "UT"
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bb }
        r2.<init>()     // Catch:{ all -> 0x01bb }
        java.lang.String r3 = "Please call pageAppear first("
        r2.append(r3)     // Catch:{ all -> 0x01bb }
        java.lang.String r3 = m33197f(r12)     // Catch:{ all -> 0x01bb }
        r2.append(r3)     // Catch:{ all -> 0x01bb }
        java.lang.String r3 = ")."
        r2.append(r3)     // Catch:{ all -> 0x01bb }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01bb }
        com.alibaba.mtl.log.p077d.Logger.m3831a(r1, r2)     // Catch:{ all -> 0x01bb }
    L_0x0186:
        java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x01bb }
        r1.<init>()     // Catch:{ all -> 0x01bb }
        r11.f26056c = r1     // Catch:{ all -> 0x01bb }
        boolean r1 = r0.mo37465d()     // Catch:{ all -> 0x01bb }
        if (r1 == 0) goto L_0x0197
        r11.mo37450a(r0)     // Catch:{ all -> 0x01bb }
        goto L_0x01ac
    L_0x0197:
        com.ut.mini.UTPageStatus r1 = r0.mo37468g()     // Catch:{ all -> 0x01bb }
        if (r1 == 0) goto L_0x01a9
        com.ut.mini.UTPageStatus r1 = com.p620ut.mini.UTPageStatus.UT_H5_IN_WebView     // Catch:{ all -> 0x01bb }
        com.ut.mini.UTPageStatus r2 = r0.mo37468g()     // Catch:{ all -> 0x01bb }
        if (r1 != r2) goto L_0x01a9
        r11.mo37450a(r0)     // Catch:{ all -> 0x01bb }
        goto L_0x01ac
    L_0x01a9:
        r11.m33196e(r12)     // Catch:{ all -> 0x01bb }
    L_0x01ac:
        r12 = 0
        r11.f26058e = r12     // Catch:{ all -> 0x01bb }
        r11.f26060g = r12     // Catch:{ all -> 0x01bb }
        goto L_0x01b9
    L_0x01b2:
        java.lang.String r12 = "pageDisAppear"
        java.lang.String r0 = "The page object should not be null"
        com.alibaba.mtl.log.p077d.Logger.m3831a(r12, r0)     // Catch:{ all -> 0x01bb }
    L_0x01b9:
        monitor-exit(r11)
        return
    L_0x01bb:
        r12 = move-exception
        monitor-exit(r11)
        throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p620ut.mini.UTPageHitHelper.mo37455b(java.lang.Object):void");
    }

    /* renamed from: a */
    private static String m33191a(Uri uri) {
        if (uri != null) {
            List<String> queryParameters = uri.getQueryParameters("ttid");
            if (queryParameters != null) {
                for (String str : queryParameters) {
                    if (!str.contains("@")) {
                        if (!str.contains("%40")) {
                            return str;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: f */
    private static String m33197f(Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        return (simpleName == null || !simpleName.toLowerCase().endsWith(Constants.FLAG_ACTIVITY_NAME)) ? simpleName : simpleName.substring(0, simpleName.length() - 8);
    }
}
