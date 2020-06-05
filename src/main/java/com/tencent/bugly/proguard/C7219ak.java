package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.tencent.bugly.C7121b;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ak */
public class C7219ak {
    /* renamed from: c */
    private static C7219ak f24340c;
    /* renamed from: a */
    public C7218aj f24341a;
    /* renamed from: b */
    public boolean f24342b = true;
    /* renamed from: d */
    private final C7212ae f24343d;
    /* renamed from: e */
    private final Context f24344e;
    /* renamed from: f */
    private Map<Integer, Long> f24345f = new HashMap();
    /* renamed from: g */
    private long f24346g;
    /* renamed from: h */
    private long f24347h;
    /* renamed from: i */
    private LinkedBlockingQueue<Runnable> f24348i = new LinkedBlockingQueue<>();
    /* renamed from: j */
    private LinkedBlockingQueue<Runnable> f24349j = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private|final */
    /* renamed from: k */
    public final Object f24350k = new Object();
    /* renamed from: l */
    private String f24351l = null;
    /* renamed from: m */
    private byte[] f24352m = null;
    /* renamed from: n */
    private long f24353n = 0;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public byte[] f24354o = null;
    /* renamed from: p */
    private long f24355p = 0;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public String f24356q = null;
    /* renamed from: r */
    private long f24357r = 0;
    /* renamed from: s */
    private final Object f24358s = new Object();
    /* access modifiers changed from: private */
    /* renamed from: t */
    public boolean f24359t = false;
    /* access modifiers changed from: private|final */
    /* renamed from: u */
    public final Object f24360u = new Object();
    /* renamed from: v */
    private int f24361v = 0;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ak$a */
    class C7222a implements Runnable {
        /* renamed from: b */
        private final Context f24368b;
        /* renamed from: c */
        private final Runnable f24369c;
        /* renamed from: d */
        private final long f24370d;

        public C7222a(Context context) {
            this.f24368b = context;
            this.f24369c = null;
            this.f24370d = 0;
        }

        public C7222a(Context context, Runnable runnable, long j) {
            this.f24368b = context;
            this.f24369c = runnable;
            this.f24370d = j;
        }

        public void run() {
            if (!C7232aq.m31193a(this.f24368b, "security_info", 30000)) {
                C7226an.m31147c("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", Integer.valueOf(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                C7232aq.m31209b(5000);
                if (C7232aq.m31186a((Runnable) this, "BUGLY_ASYNC_UPLOAD") == null) {
                    C7226an.m31148d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
                    C7224am a = C7224am.m31132a();
                    if (a != null) {
                        a.mo34832a(this);
                    } else {
                        C7226an.m31149e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
                    }
                }
                return;
            }
            if (!C7219ak.this.m31107e()) {
                C7226an.m31148d("[UploadManager] Failed to load security info from database", new Object[0]);
                C7219ak.this.mo34818b(false);
            }
            if (C7219ak.this.f24356q != null) {
                if (C7219ak.this.mo34819b()) {
                    C7226an.m31147c("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    Runnable runnable = this.f24369c;
                    if (runnable != null) {
                        C7219ak.this.m31094a(runnable, this.f24370d);
                    }
                    C7219ak.this.m31101c(0);
                    C7232aq.m31220c(this.f24368b, "security_info");
                    synchronized (C7219ak.this.f24360u) {
                        C7219ak.this.f24359t = false;
                    }
                    return;
                }
                C7226an.m31141a("[UploadManager] Session ID is expired, drop it.", new Object[0]);
                C7219ak.this.mo34818b(true);
            }
            byte[] a2 = C7232aq.m31197a(128);
            if (a2 == null || a2.length * 8 != 128) {
                C7226an.m31148d("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                C7219ak.this.mo34818b(false);
                C7232aq.m31220c(this.f24368b, "security_info");
                synchronized (C7219ak.this.f24360u) {
                    C7219ak.this.f24359t = false;
                }
                return;
            }
            C7219ak.this.f24354o = a2;
            C7226an.m31147c("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            Runnable runnable2 = this.f24369c;
            if (runnable2 != null) {
                C7219ak.this.m31094a(runnable2, this.f24370d);
            } else {
                C7219ak.this.m31101c(1);
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m31099b(C7219ak akVar) {
        int i = akVar.f24361v - 1;
        akVar.f24361v = i;
        return i;
    }

    protected C7219ak(Context context) {
        this.f24344e = context;
        this.f24343d = C7212ae.m31041a();
        try {
            Class.forName("android.util.Base64");
        } catch (ClassNotFoundException unused) {
            C7226an.m31141a("[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload", new Object[0]);
            this.f24342b = false;
        }
        if (this.f24342b) {
            StringBuilder sb = new StringBuilder();
            sb.append("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/");
            sb.append("sbTvVO2+RvW0PH01IdaBxc/");
            sb.append("fB6fbHZocC9T3nl1+");
            sb.append("J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB");
            this.f24351l = sb.toString();
        }
    }

    /* renamed from: a */
    public static synchronized C7219ak m31090a(Context context) {
        C7219ak akVar;
        synchronized (C7219ak.class) {
            if (f24340c == null) {
                f24340c = new C7219ak(context);
            }
            akVar = f24340c;
        }
        return akVar;
    }

    /* renamed from: a */
    public static synchronized C7219ak m31089a() {
        C7219ak akVar;
        synchronized (C7219ak.class) {
            akVar = f24340c;
        }
        return akVar;
    }

    /* renamed from: a */
    public void mo34809a(int i, int i2, byte[] bArr, String str, String str2, C7218aj ajVar, long j, boolean z) {
        try {
            C7223al alVar = new C7223al(this.f24344e, i, i2, bArr, str, str2, ajVar, this.f24342b, z);
            m31100b(alVar, true, true, j);
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo34812a(int i, C7250bh bhVar, String str, String str2, C7218aj ajVar, long j, boolean z) {
        mo34809a(i, bhVar.f24492g, C7216ah.m31079a((Object) bhVar), str, str2, ajVar, j, z);
    }

    /* renamed from: a */
    public void mo34808a(int i, int i2, byte[] bArr, String str, String str2, C7218aj ajVar, int i3, int i4, boolean z, Map<String, String> map) {
        try {
            C7223al alVar = new C7223al(this.f24344e, i, i2, bArr, str, str2, ajVar, this.f24342b, i3, i4, false, map);
            m31100b(alVar, z, false, 0);
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo34810a(int i, int i2, byte[] bArr, String str, String str2, C7218aj ajVar, boolean z, Map<String, String> map) {
        mo34808a(i, i2, bArr, str, str2, ajVar, 0, 0, z, map);
    }

    /* renamed from: a */
    public void mo34813a(int i, C7250bh bhVar, String str, String str2, C7218aj ajVar, boolean z) {
        mo34808a(i, bhVar.f24492g, C7216ah.m31079a((Object) bhVar), str, str2, ajVar, 0, 0, z, null);
    }

    /* renamed from: a */
    public long mo34807a(boolean z) {
        long j;
        long b = C7232aq.m31204b();
        int i = z ? 5 : 3;
        List a = this.f24343d.mo34778a(i);
        if (a == null || a.size() <= 0) {
            j = z ? this.f24347h : this.f24346g;
        } else {
            j = 0;
            try {
                C7215ag agVar = (C7215ag) a.get(0);
                if (agVar.f24334e >= b) {
                    j = C7232aq.m31218c(agVar.f24336g);
                    if (i == 3) {
                        this.f24346g = j;
                    } else {
                        this.f24347h = j;
                    }
                    a.remove(agVar);
                }
            } catch (Throwable th) {
                C7226an.m31142a(th);
            }
            if (a.size() > 0) {
                this.f24343d.mo34780a(a);
            }
        }
        C7226an.m31147c("[UploadManager] Local network consume: %d KB", Long.valueOf(j / 1024));
        return j;
    }

    /* access modifiers changed from: protected|declared_synchronized */
    /* renamed from: a */
    public synchronized void mo34815a(long j, boolean z) {
        int i = z ? 5 : 3;
        C7215ag agVar = new C7215ag();
        agVar.f24331b = i;
        agVar.f24334e = C7232aq.m31204b();
        agVar.f24332c = "";
        agVar.f24333d = "";
        agVar.f24336g = C7232aq.m31222c(j);
        this.f24343d.mo34786b(i);
        this.f24343d.mo34783a(agVar);
        if (z) {
            this.f24347h = j;
        } else {
            this.f24346g = j;
        }
        C7226an.m31147c("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
    }

    /* renamed from: a */
    public synchronized void mo34811a(int i, long j) {
        if (i >= 0) {
            this.f24345f.put(Integer.valueOf(i), Long.valueOf(j));
            C7215ag agVar = new C7215ag();
            agVar.f24331b = i;
            agVar.f24334e = j;
            agVar.f24332c = "";
            agVar.f24333d = "";
            agVar.f24336g = new byte[0];
            this.f24343d.mo34786b(i);
            this.f24343d.mo34783a(agVar);
            C7226an.m31147c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i), C7232aq.m31179a(j));
        } else {
            C7226an.m31149e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    public synchronized long mo34806a(int i) {
        long j;
        j = 0;
        if (i >= 0) {
            Long l = (Long) this.f24345f.get(Integer.valueOf(i));
            if (l != null) {
                return l.longValue();
            }
            List<C7215ag> a = this.f24343d.mo34778a(i);
            if (a != null && a.size() > 0) {
                if (a.size() > 1) {
                    for (C7215ag agVar : a) {
                        if (agVar.f24334e > j) {
                            j = agVar.f24334e;
                        }
                    }
                    this.f24343d.mo34786b(i);
                } else {
                    try {
                        j = ((C7215ag) a.get(0)).f24334e;
                    } catch (Throwable th) {
                        C7226an.m31142a(th);
                    }
                }
            }
        } else {
            C7226an.m31149e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i));
        }
        return j;
    }

    /* renamed from: b */
    public boolean mo34820b(int i) {
        if (C7121b.f23665c) {
            C7226an.m31147c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - mo34806a(i);
        C7226an.m31147c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i));
        if (currentTimeMillis >= 30000) {
            return true;
        }
        C7226an.m31141a("[UploadManager] Data only be uploaded once in %d seconds.", Long.valueOf(30));
        return false;
    }

    /* renamed from: c */
    private boolean m31102c() {
        C7226an.m31147c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            C7212ae a = C7212ae.m31041a();
            if (a != null) {
                return a.mo34781a(555, "security_info", (C7211ad) null, true);
            }
            C7226an.m31148d("[UploadManager] Failed to get Database", new Object[0]);
            return false;
        } catch (Throwable th) {
            C7226an.m31142a(th);
            return false;
        }
    }

    /* renamed from: d */
    private boolean m31105d() {
        String str = "#";
        C7226an.m31147c("[UploadManager] Record security info to database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            C7212ae a = C7212ae.m31041a();
            if (a == null) {
                C7226an.m31148d("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            StringBuilder sb = new StringBuilder();
            if (this.f24354o != null) {
                sb.append(Base64.encodeToString(this.f24354o, 0));
                sb.append(str);
                String str2 = "null";
                if (this.f24355p != 0) {
                    sb.append(Long.toString(this.f24355p));
                } else {
                    sb.append(str2);
                }
                sb.append(str);
                if (this.f24356q != null) {
                    sb.append(this.f24356q);
                } else {
                    sb.append(str2);
                }
                sb.append(str);
                if (this.f24357r != 0) {
                    sb.append(Long.toString(this.f24357r));
                } else {
                    sb.append(str2);
                }
                a.mo34782a(555, "security_info", sb.toString().getBytes(), (C7211ad) null, true);
                return true;
            }
            C7226an.m31147c("[UploadManager] AES key is null, will not record", new Object[0]);
            return false;
        } catch (Throwable th) {
            C7226an.m31142a(th);
            m31102c();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m31107e() {
        boolean z;
        String str = "security_info";
        C7226an.m31147c("[UploadManager] Load security info from database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            C7212ae a = C7212ae.m31041a();
            if (a == null) {
                C7226an.m31148d("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            Map a2 = a.mo34779a(555, (C7211ad) null, true);
            if (a2 != null && a2.containsKey(str)) {
                String str2 = new String((byte[]) a2.get(str));
                String[] split = str2.split("#");
                if (split.length == 4) {
                    String str3 = "null";
                    if (!split[0].isEmpty()) {
                        if (!split[0].equals(str3)) {
                            this.f24354o = Base64.decode(split[0], 0);
                        }
                    }
                    z = false;
                    if (!z && !split[1].isEmpty() && !split[1].equals(str3)) {
                        try {
                            this.f24355p = Long.parseLong(split[1]);
                        } catch (Throwable th) {
                            C7226an.m31142a(th);
                            z = true;
                        }
                    }
                    if (!z && !split[2].isEmpty() && !split[2].equals(str3)) {
                        this.f24356q = split[2];
                    }
                    if (!z && !split[3].isEmpty() && !split[3].equals(str3)) {
                        try {
                            this.f24357r = Long.parseLong(split[3]);
                        } catch (Throwable th2) {
                            C7226an.m31142a(th2);
                        }
                    }
                } else {
                    C7226an.m31141a("SecurityInfo = %s, Strings.length = %d", str2, Integer.valueOf(split.length));
                    z = true;
                }
                if (z) {
                    m31102c();
                }
            }
            return true;
        } catch (Throwable th3) {
            C7226an.m31142a(th3);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo34819b() {
        if (this.f24356q == null || this.f24357r == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() + this.f24353n;
        long j = this.f24357r;
        if (j >= currentTimeMillis) {
            return true;
        }
        C7226an.m31147c("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", Long.valueOf(j), new Date(this.f24357r).toString(), Long.valueOf(currentTimeMillis), new Date(currentTimeMillis).toString());
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo34818b(boolean z) {
        synchronized (this.f24358s) {
            C7226an.m31147c("[UploadManager] Clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            this.f24354o = null;
            this.f24356q = null;
            this.f24357r = 0;
        }
        if (z) {
            m31102c();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00bc, code lost:
            if (r5 <= 0) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00be, code lost:
            com.tencent.bugly.proguard.C7226an.m31147c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", java.lang.Integer.valueOf(r5), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00df, code lost:
            r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e0, code lost:
            if (r7 >= r5) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e2, code lost:
            r8 = (java.lang.Runnable) r2.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e8, code lost:
            if (r8 != null) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00eb, code lost:
            r10 = r12.f24350k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ed, code lost:
            monitor-enter(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f0, code lost:
            if (r12.f24361v < 2) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f2, code lost:
            if (r1 == null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00f4, code lost:
            r1.mo34832a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f7, code lost:
            monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f9, code lost:
            monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00fa, code lost:
            com.tencent.bugly.proguard.C7226an.m31141a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0110, code lost:
            if (com.tencent.bugly.proguard.C7232aq.m31186a((java.lang.Runnable) new com.tencent.bugly.proguard.C7219ak.C72201(r12), "BUGLY_ASYNC_UPLOAD") == null) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0112, code lost:
            r10 = r12.f24350k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0114, code lost:
            monitor-enter(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
            r12.f24361v++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x011a, code lost:
            monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x011f, code lost:
            com.tencent.bugly.proguard.C7226an.m31148d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new java.lang.Object[0]);
            m31097a(r8, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0129, code lost:
            r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x012f, code lost:
            if (r13 <= 0) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0131, code lost:
            com.tencent.bugly.proguard.C7226an.m31147c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", java.lang.Integer.valueOf(r13), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0152, code lost:
            if (r1 == null) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0154, code lost:
            r1.mo34832a(new com.tencent.bugly.proguard.C7219ak.C72212(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x015c, code lost:
            return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d A[Catch:{ all -> 0x0081 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0095 A[Catch:{ all -> 0x0081 }] */
    /* renamed from: c */
    public void m31101c(int r13) {
        /*
        r12 = this;
        r0 = 0
        if (r13 >= 0) goto L_0x000b
        java.lang.Object[] r13 = new java.lang.Object[r0]
        java.lang.String r0 = "[UploadManager] Number of task to execute should >= 0"
        com.tencent.bugly.proguard.C7226an.m31141a(r0, r13)
        return
    L_0x000b:
        com.tencent.bugly.proguard.am r1 = com.tencent.bugly.proguard.C7224am.m31132a()
        java.util.concurrent.LinkedBlockingQueue r2 = new java.util.concurrent.LinkedBlockingQueue
        r2.<init>()
        java.util.concurrent.LinkedBlockingQueue r3 = new java.util.concurrent.LinkedBlockingQueue
        r3.<init>()
        java.lang.Object r4 = r12.f24350k
        monitor-enter(r4)
        java.lang.String r5 = "[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)"
        r6 = 2
        java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x015d }
        int r8 = android.os.Process.myPid()     // Catch:{ all -> 0x015d }
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x015d }
        r7[r0] = r8     // Catch:{ all -> 0x015d }
        int r8 = android.os.Process.myTid()     // Catch:{ all -> 0x015d }
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x015d }
        r9 = 1
        r7[r9] = r8     // Catch:{ all -> 0x015d }
        com.tencent.bugly.proguard.C7226an.m31147c(r5, r7)     // Catch:{ all -> 0x015d }
        java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> r5 = r12.f24348i     // Catch:{ all -> 0x015d }
        int r5 = r5.size()     // Catch:{ all -> 0x015d }
        java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> r7 = r12.f24349j     // Catch:{ all -> 0x015d }
        int r7 = r7.size()     // Catch:{ all -> 0x015d }
        if (r5 != 0) goto L_0x0052
        if (r7 != 0) goto L_0x0052
        java.lang.String r13 = "[UploadManager] There is no upload task in queue."
        java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x015d }
        com.tencent.bugly.proguard.C7226an.m31147c(r13, r0)     // Catch:{ all -> 0x015d }
        monitor-exit(r4)     // Catch:{ all -> 0x015d }
        return
    L_0x0052:
        if (r13 != 0) goto L_0x0055
        goto L_0x0060
    L_0x0055:
        if (r13 >= r5) goto L_0x005a
        r5 = r13
        r13 = 0
        goto L_0x0061
    L_0x005a:
        int r8 = r5 + r7
        if (r13 >= r8) goto L_0x0060
        int r13 = r13 - r5
        goto L_0x0061
    L_0x0060:
        r13 = r7
    L_0x0061:
        if (r1 == 0) goto L_0x0069
        boolean r7 = r1.mo34835c()     // Catch:{ all -> 0x015d }
        if (r7 != 0) goto L_0x006a
    L_0x0069:
        r13 = 0
    L_0x006a:
        r7 = 0
    L_0x006b:
        if (r7 >= r5) goto L_0x0092
        java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> r8 = r12.f24348i     // Catch:{ all -> 0x015d }
        java.lang.Object r8 = r8.peek()     // Catch:{ all -> 0x015d }
        java.lang.Runnable r8 = (java.lang.Runnable) r8     // Catch:{ all -> 0x015d }
        if (r8 != 0) goto L_0x0078
        goto L_0x0092
    L_0x0078:
        r2.put(r8)     // Catch:{ all -> 0x0081 }
        java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> r8 = r12.f24348i     // Catch:{ all -> 0x0081 }
        r8.poll()     // Catch:{ all -> 0x0081 }
        goto L_0x008f
    L_0x0081:
        r8 = move-exception
        java.lang.String r10 = "[UploadManager] Failed to add upload task to temp urgent queue: %s"
        java.lang.Object[] r11 = new java.lang.Object[r9]     // Catch:{ all -> 0x015d }
        java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x015d }
        r11[r0] = r8     // Catch:{ all -> 0x015d }
        com.tencent.bugly.proguard.C7226an.m31149e(r10, r11)     // Catch:{ all -> 0x015d }
    L_0x008f:
        int r7 = r7 + 1
        goto L_0x006b
    L_0x0092:
        r7 = 0
    L_0x0093:
        if (r7 >= r13) goto L_0x00ba
        java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> r8 = r12.f24349j     // Catch:{ all -> 0x015d }
        java.lang.Object r8 = r8.peek()     // Catch:{ all -> 0x015d }
        java.lang.Runnable r8 = (java.lang.Runnable) r8     // Catch:{ all -> 0x015d }
        if (r8 != 0) goto L_0x00a0
        goto L_0x00ba
    L_0x00a0:
        r3.put(r8)     // Catch:{ all -> 0x00a9 }
        java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> r8 = r12.f24349j     // Catch:{ all -> 0x00a9 }
        r8.poll()     // Catch:{ all -> 0x00a9 }
        goto L_0x00b7
    L_0x00a9:
        r8 = move-exception
        java.lang.String r10 = "[UploadManager] Failed to add upload task to temp urgent queue: %s"
        java.lang.Object[] r11 = new java.lang.Object[r9]     // Catch:{ all -> 0x015d }
        java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x015d }
        r11[r0] = r8     // Catch:{ all -> 0x015d }
        com.tencent.bugly.proguard.C7226an.m31149e(r10, r11)     // Catch:{ all -> 0x015d }
    L_0x00b7:
        int r7 = r7 + 1
        goto L_0x0093
    L_0x00ba:
        monitor-exit(r4)     // Catch:{ all -> 0x015d }
        r4 = 3
        if (r5 <= 0) goto L_0x00df
        java.lang.Object[] r7 = new java.lang.Object[r4]
        java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
        r7[r0] = r8
        int r8 = android.os.Process.myPid()
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
        r7[r9] = r8
        int r8 = android.os.Process.myTid()
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
        r7[r6] = r8
        java.lang.String r8 = "[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)"
        com.tencent.bugly.proguard.C7226an.m31147c(r8, r7)
    L_0x00df:
        r7 = 0
    L_0x00e0:
        if (r7 >= r5) goto L_0x012f
        java.lang.Object r8 = r2.poll()
        java.lang.Runnable r8 = (java.lang.Runnable) r8
        if (r8 != 0) goto L_0x00eb
        goto L_0x012f
    L_0x00eb:
        java.lang.Object r10 = r12.f24350k
        monitor-enter(r10)
        int r11 = r12.f24361v     // Catch:{ all -> 0x012c }
        if (r11 < r6) goto L_0x00f9
        if (r1 == 0) goto L_0x00f9
        r1.mo34832a(r8)     // Catch:{ all -> 0x012c }
        monitor-exit(r10)     // Catch:{ all -> 0x012c }
        goto L_0x0129
    L_0x00f9:
        monitor-exit(r10)     // Catch:{ all -> 0x012c }
        java.lang.Object[] r10 = new java.lang.Object[r9]
        java.lang.String r11 = "BUGLY_ASYNC_UPLOAD"
        r10[r0] = r11
        java.lang.String r11 = "[UploadManager] Create and start a new thread to execute a upload task: %s"
        com.tencent.bugly.proguard.C7226an.m31141a(r11, r10)
        com.tencent.bugly.proguard.ak$1 r10 = new com.tencent.bugly.proguard.ak$1
        r10.m52549init(r8)
        java.lang.String r11 = "BUGLY_ASYNC_UPLOAD"
        java.lang.Thread r10 = com.tencent.bugly.proguard.C7232aq.m31186a(r10, r11)
        if (r10 == 0) goto L_0x011f
        java.lang.Object r10 = r12.f24350k
        monitor-enter(r10)
        int r8 = r12.f24361v     // Catch:{ all -> 0x011c }
        int r8 = r8 + r9
        r12.f24361v = r8     // Catch:{ all -> 0x011c }
        monitor-exit(r10)     // Catch:{ all -> 0x011c }
        goto L_0x0129
    L_0x011c:
        r13 = move-exception
        monitor-exit(r10)     // Catch:{ all -> 0x011c }
        throw r13
    L_0x011f:
        java.lang.Object[] r10 = new java.lang.Object[r0]
        java.lang.String r11 = "[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time."
        com.tencent.bugly.proguard.C7226an.m31148d(r11, r10)
        r12.m31097a(r8, r9)
    L_0x0129:
        int r7 = r7 + 1
        goto L_0x00e0
    L_0x012c:
        r13 = move-exception
        monitor-exit(r10)     // Catch:{ all -> 0x012c }
        throw r13
    L_0x012f:
        if (r13 <= 0) goto L_0x0152
        java.lang.Object[] r2 = new java.lang.Object[r4]
        java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
        r2[r0] = r4
        int r0 = android.os.Process.myPid()
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r2[r9] = r0
        int r0 = android.os.Process.myTid()
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r2[r6] = r0
        java.lang.String r0 = "[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)"
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r2)
    L_0x0152:
        if (r1 == 0) goto L_0x015c
        com.tencent.bugly.proguard.ak$2 r0 = new com.tencent.bugly.proguard.ak$2
        r0.m52550init(r13, r3)
        r1.mo34832a(r0)
    L_0x015c:
        return
    L_0x015d:
        r13 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x015d }
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7219ak.m31101c(int):void");
    }

    /* renamed from: a */
    private boolean m31097a(Runnable runnable, boolean z) {
        if (runnable == null) {
            C7226an.m31141a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            C7226an.m31147c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f24350k) {
                if (z) {
                    this.f24348i.put(runnable);
                } else {
                    this.f24349j.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            C7226an.m31149e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31094a(Runnable runnable, long j) {
        if (runnable == null) {
            C7226an.m31148d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        C7226an.m31147c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a = C7232aq.m31186a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a == null) {
            C7226an.m31149e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            m31097a(runnable, true);
            return;
        }
        try {
            a.join(j);
        } catch (Throwable th) {
            C7226an.m31149e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            m31097a(runnable, true);
            m31101c(0);
        }
    }

    /* renamed from: a */
    private void m31095a(Runnable runnable, boolean z, boolean z2, long j) {
        C7226an.m31147c("[UploadManager] Initialize security context now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z2) {
            C7222a aVar = new C7222a(this.f24344e, runnable, j);
            m31094a((Runnable) aVar, 0);
            return;
        }
        m31097a(runnable, z);
        C7222a aVar2 = new C7222a(this.f24344e);
        C7226an.m31141a("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", "BUGLY_ASYNC_UPLOAD");
        if (C7232aq.m31186a((Runnable) aVar2, "BUGLY_ASYNC_UPLOAD") == null) {
            C7226an.m31148d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
            C7224am a = C7224am.m31132a();
            if (a != null) {
                a.mo34832a(aVar2);
                return;
            }
            C7226an.m31149e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
            synchronized (this.f24360u) {
                this.f24359t = false;
            }
        }
    }

    /* renamed from: b */
    private void m31100b(Runnable runnable, boolean z, boolean z2, long j) {
        if (runnable == null) {
            C7226an.m31148d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        C7226an.m31147c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.f24356q != null) {
            if (mo34819b()) {
                C7226an.m31147c("[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (z2) {
                    m31094a(runnable, j);
                } else {
                    m31097a(runnable, z);
                    m31101c(0);
                }
                return;
            }
            C7226an.m31141a("[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            mo34818b(false);
        }
        synchronized (this.f24360u) {
            if (this.f24359t) {
                m31097a(runnable, z);
                return;
            }
            this.f24359t = true;
            m31095a(runnable, z, z2, j);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
            if (r9 == null) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
            com.tencent.bugly.proguard.C7226an.m31147c("[UploadManager] Record security context (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r8 = r9.f24519h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
            if (r8 == null) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
            if (r8.containsKey("S1") == false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
            if (r8.containsKey("S2") == false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
            r7.f24353n = r9.f24516e - java.lang.System.currentTimeMillis();
            com.tencent.bugly.proguard.C7226an.m31147c("[UploadManager] Time lag of server is: %d", java.lang.Long.valueOf(r7.f24353n));
            r7.f24356q = (java.lang.String) r8.get("S1");
            com.tencent.bugly.proguard.C7226an.m31147c("[UploadManager] Session ID from server is: %s", r7.f24356q);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0098, code lost:
            if (r7.f24356q.length() <= 0) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r7.f24357r = java.lang.Long.parseLong((java.lang.String) r8.get("S2"));
            com.tencent.bugly.proguard.C7226an.m31147c("[UploadManager] Session expired time from server is: %d(%s)", java.lang.Long.valueOf(r7.f24357r), new java.util.Date(r7.f24357r).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cd, code lost:
            if (r7.f24357r >= 1000) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cf, code lost:
            com.tencent.bugly.proguard.C7226an.m31148d("[UploadManager] Session expired time from server is less than 1 second, will set to default value", new java.lang.Object[0]);
            r7.f24357r = 259200000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            com.tencent.bugly.proguard.C7226an.m31148d("[UploadManager] Session expired time is invalid, will set to default value", new java.lang.Object[0]);
            r7.f24357r = 259200000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f5, code lost:
            com.tencent.bugly.proguard.C7226an.m31147c("[UploadManager] Session ID from server is invalid, try next time", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fd, code lost:
            r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fe, code lost:
            com.tencent.bugly.proguard.C7226an.m31142a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0107, code lost:
            com.tencent.bugly.proguard.C7226an.m31147c("[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            mo34818b(false);
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0128 A[SYNTHETIC] */
    /* renamed from: a */
    public void mo34814a(int r8, com.tencent.bugly.proguard.C7251bi r9) {
        /*
        r7 = this;
        boolean r0 = r7.f24342b
        if (r0 != 0) goto L_0x0005
        return
    L_0x0005:
        r0 = 2
        r1 = 1
        r2 = 0
        if (r8 != r0) goto L_0x002a
        java.lang.Object[] r8 = new java.lang.Object[r0]
        int r9 = android.os.Process.myPid()
        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
        r8[r2] = r9
        int r9 = android.os.Process.myTid()
        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
        r8[r1] = r9
        java.lang.String r9 = "[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)"
        com.tencent.bugly.proguard.C7226an.m31147c(r9, r8)
        r7.mo34818b(r1)
        goto L_0x0125
    L_0x002a:
        java.lang.Object r8 = r7.f24360u
        monitor-enter(r8)
        boolean r3 = r7.f24359t     // Catch:{ all -> 0x013a }
        if (r3 != 0) goto L_0x0033
        monitor-exit(r8)     // Catch:{ all -> 0x013a }
        return
    L_0x0033:
        monitor-exit(r8)     // Catch:{ all -> 0x013a }
        if (r9 == 0) goto L_0x0107
        java.lang.Object[] r8 = new java.lang.Object[r0]
        int r3 = android.os.Process.myPid()
        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        r8[r2] = r3
        int r3 = android.os.Process.myTid()
        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        r8[r1] = r3
        java.lang.String r3 = "[UploadManager] Record security context (pid=%d | tid=%d)"
        com.tencent.bugly.proguard.C7226an.m31147c(r3, r8)
        java.util.Map<java.lang.String, java.lang.String> r8 = r9.f24519h     // Catch:{ all -> 0x00fd }
        if (r8 == 0) goto L_0x0101
        java.lang.String r3 = "S1"
        boolean r3 = r8.containsKey(r3)     // Catch:{ all -> 0x00fd }
        if (r3 == 0) goto L_0x0101
        java.lang.String r3 = "S2"
        boolean r3 = r8.containsKey(r3)     // Catch:{ all -> 0x00fd }
        if (r3 == 0) goto L_0x0101
        long r3 = r9.f24516e     // Catch:{ all -> 0x00fd }
        long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00fd }
        long r3 = r3 - r5
        r7.f24353n = r3     // Catch:{ all -> 0x00fd }
        java.lang.String r9 = "[UploadManager] Time lag of server is: %d"
        java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x00fd }
        long r4 = r7.f24353n     // Catch:{ all -> 0x00fd }
        java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x00fd }
        r3[r2] = r4     // Catch:{ all -> 0x00fd }
        com.tencent.bugly.proguard.C7226an.m31147c(r9, r3)     // Catch:{ all -> 0x00fd }
        java.lang.String r9 = "S1"
        java.lang.Object r9 = r8.get(r9)     // Catch:{ all -> 0x00fd }
        java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x00fd }
        r7.f24356q = r9     // Catch:{ all -> 0x00fd }
        java.lang.String r9 = "[UploadManager] Session ID from server is: %s"
        java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x00fd }
        java.lang.String r4 = r7.f24356q     // Catch:{ all -> 0x00fd }
        r3[r2] = r4     // Catch:{ all -> 0x00fd }
        com.tencent.bugly.proguard.C7226an.m31147c(r9, r3)     // Catch:{ all -> 0x00fd }
        java.lang.String r9 = r7.f24356q     // Catch:{ all -> 0x00fd }
        int r9 = r9.length()     // Catch:{ all -> 0x00fd }
        if (r9 <= 0) goto L_0x00f5
        r3 = 259200000(0xf731400, double:1.280618154E-315)
        java.lang.String r9 = "S2"
        java.lang.Object r8 = r8.get(r9)     // Catch:{ NumberFormatException -> 0x00d9 }
        java.lang.String r8 = (java.lang.String) r8     // Catch:{ NumberFormatException -> 0x00d9 }
        long r8 = java.lang.Long.parseLong(r8)     // Catch:{ NumberFormatException -> 0x00d9 }
        r7.f24357r = r8     // Catch:{ NumberFormatException -> 0x00d9 }
        java.lang.String r8 = "[UploadManager] Session expired time from server is: %d(%s)"
        java.lang.Object[] r9 = new java.lang.Object[r0]     // Catch:{ NumberFormatException -> 0x00d9 }
        long r5 = r7.f24357r     // Catch:{ NumberFormatException -> 0x00d9 }
        java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ NumberFormatException -> 0x00d9 }
        r9[r2] = r0     // Catch:{ NumberFormatException -> 0x00d9 }
        java.util.Date r0 = new java.util.Date     // Catch:{ NumberFormatException -> 0x00d9 }
        long r5 = r7.f24357r     // Catch:{ NumberFormatException -> 0x00d9 }
        r0.<init>(r5)     // Catch:{ NumberFormatException -> 0x00d9 }
        java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x00d9 }
        r9[r1] = r0     // Catch:{ NumberFormatException -> 0x00d9 }
        com.tencent.bugly.proguard.C7226an.m31147c(r8, r9)     // Catch:{ NumberFormatException -> 0x00d9 }
        long r8 = r7.f24357r     // Catch:{ NumberFormatException -> 0x00d9 }
        r5 = 1000(0x3e8, double:4.94E-321)
        int r0 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
        if (r0 >= 0) goto L_0x00e2
        java.lang.String r8 = "[UploadManager] Session expired time from server is less than 1 second, will set to default value"
        java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ NumberFormatException -> 0x00d9 }
        com.tencent.bugly.proguard.C7226an.m31148d(r8, r9)     // Catch:{ NumberFormatException -> 0x00d9 }
        r7.f24357r = r3     // Catch:{ NumberFormatException -> 0x00d9 }
        goto L_0x00e2
    L_0x00d9:
        java.lang.String r8 = "[UploadManager] Session expired time is invalid, will set to default value"
        java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x00fd }
        com.tencent.bugly.proguard.C7226an.m31148d(r8, r9)     // Catch:{ all -> 0x00fd }
        r7.f24357r = r3     // Catch:{ all -> 0x00fd }
    L_0x00e2:
        boolean r8 = r7.m31105d()     // Catch:{ all -> 0x00fd }
        if (r8 == 0) goto L_0x00ea
        r1 = 0
        goto L_0x00f1
    L_0x00ea:
        java.lang.String r8 = "[UploadManager] Failed to record database"
        java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x00fd }
        com.tencent.bugly.proguard.C7226an.m31147c(r8, r9)     // Catch:{ all -> 0x00fd }
    L_0x00f1:
        r7.m31101c(r2)     // Catch:{ all -> 0x00fd }
        goto L_0x0101
    L_0x00f5:
        java.lang.String r8 = "[UploadManager] Session ID from server is invalid, try next time"
        java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x00fd }
        com.tencent.bugly.proguard.C7226an.m31147c(r8, r9)     // Catch:{ all -> 0x00fd }
        goto L_0x0101
    L_0x00fd:
        r8 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r8)
    L_0x0101:
        if (r1 == 0) goto L_0x0125
        r7.mo34818b(r2)
        goto L_0x0125
    L_0x0107:
        java.lang.Object[] r8 = new java.lang.Object[r0]
        int r9 = android.os.Process.myPid()
        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
        r8[r2] = r9
        int r9 = android.os.Process.myTid()
        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
        r8[r1] = r9
        java.lang.String r9 = "[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)"
        com.tencent.bugly.proguard.C7226an.m31147c(r9, r8)
        r7.mo34818b(r2)
    L_0x0125:
        java.lang.Object r9 = r7.f24360u
        monitor-enter(r9)
        boolean r8 = r7.f24359t     // Catch:{ all -> 0x0137 }
        if (r8 == 0) goto L_0x0135
        r7.f24359t = r2     // Catch:{ all -> 0x0137 }
        android.content.Context r8 = r7.f24344e     // Catch:{ all -> 0x0137 }
        java.lang.String r0 = "security_info"
        com.tencent.bugly.proguard.C7232aq.m31220c(r8, r0)     // Catch:{ all -> 0x0137 }
    L_0x0135:
        monitor-exit(r9)     // Catch:{ all -> 0x0137 }
        return
    L_0x0137:
        r8 = move-exception
        monitor-exit(r9)     // Catch:{ all -> 0x0137 }
        throw r8
    L_0x013a:
        r9 = move-exception
        monitor-exit(r8)     // Catch:{ all -> 0x013a }
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7219ak.mo34814a(int, com.tencent.bugly.proguard.bi):void");
    }

    /* renamed from: a */
    public byte[] mo34817a(byte[] bArr) {
        byte[] bArr2 = this.f24354o;
        if (bArr2 != null && bArr2.length * 8 == 128) {
            return C7232aq.m31198a(1, bArr, bArr2);
        }
        C7226an.m31148d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    /* renamed from: b */
    public byte[] mo34821b(byte[] bArr) {
        byte[] bArr2 = this.f24354o;
        if (bArr2 != null && bArr2.length * 8 == 128) {
            return C7232aq.m31198a(2, bArr, bArr2);
        }
        C7226an.m31148d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    /* renamed from: a */
    public boolean mo34816a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        C7226an.m31147c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        String str = this.f24356q;
        if (str != null) {
            map.put("secureSessionId", str);
            return true;
        }
        byte[] bArr = this.f24354o;
        if (bArr == null || bArr.length * 8 != 128) {
            C7226an.m31148d("[UploadManager] AES key is invalid", new Object[0]);
            return false;
        }
        if (this.f24352m == null) {
            this.f24352m = Base64.decode(this.f24351l, 0);
            if (this.f24352m == null) {
                C7226an.m31148d("[UploadManager] Failed to decode RSA public key", new Object[0]);
                return false;
            }
        }
        byte[] b = C7232aq.m31214b(1, this.f24354o, this.f24352m);
        if (b == null) {
            C7226an.m31148d("[UploadManager] Failed to encrypt AES key", new Object[0]);
            return false;
        }
        String encodeToString = Base64.encodeToString(b, 0);
        if (encodeToString == null) {
            C7226an.m31148d("[UploadManager] Failed to encode AES key", new Object[0]);
            return false;
        }
        map.put("raKey", encodeToString);
        return true;
    }
}
