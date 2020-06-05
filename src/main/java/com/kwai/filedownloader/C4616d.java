package com.kwai.filedownloader;

import com.kwai.filedownloader.C4583a.C4584a;
import com.kwai.filedownloader.C4583a.C4585b;
import com.kwai.filedownloader.C4583a.C4587d;
import com.kwai.filedownloader.C4725r.C4726a;
import com.kwai.filedownloader.C4725r.C4727b;
import com.kwai.filedownloader.C4743w.C4744a;
import com.kwai.filedownloader.C4743w.C4745b;
import com.kwai.filedownloader.message.C4701f;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.message.MessageSnapshot.C4681a;
import com.kwai.filedownloader.p356d.C4619b;
import com.kwai.filedownloader.p356d.C4623d;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4664f;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* renamed from: com.kwai.filedownloader.d */
public class C4616d implements C4587d, C4743w, C4744a, C4745b {
    /* renamed from: a */
    private C4728s f15015a;
    /* renamed from: b */
    private final Object f15016b;
    /* renamed from: c */
    private final C4617a f15017c;
    /* renamed from: d */
    private volatile byte f15018d = 0;
    /* renamed from: e */
    private volatile long f15019e;
    /* renamed from: f */
    private Throwable f15020f = null;
    /* renamed from: g */
    private final C4727b f15021g;
    /* renamed from: h */
    private final C4726a f15022h;
    /* renamed from: i */
    private long f15023i;
    /* renamed from: j */
    private long f15024j;
    /* renamed from: k */
    private int f15025k;
    /* renamed from: l */
    private boolean f15026l;
    /* renamed from: m */
    private boolean f15027m;
    /* renamed from: n */
    private String f15028n;
    /* renamed from: o */
    private boolean f15029o = false;

    /* renamed from: com.kwai.filedownloader.d$a */
    interface C4617a {
        /* renamed from: Q */
        C4619b mo25003Q();

        /* renamed from: R */
        C4585b mo25004R();

        /* renamed from: S */
        ArrayList<C4584a> mo25005S();

        /* renamed from: c */
        void mo25006c(String str);
    }

    C4616d(C4617a aVar, Object obj) {
        this.f15016b = obj;
        this.f15017c = aVar;
        C4595b bVar = new C4595b();
        this.f15021g = bVar;
        this.f15022h = bVar;
        this.f15015a = new C4674k(aVar.mo25004R(), this);
    }

    /* renamed from: e */
    private void m18869e(MessageSnapshot messageSnapshot) {
        C4728s sVar;
        C4583a F = this.f15017c.mo25004R().mo24935F();
        byte b = messageSnapshot.mo25286b();
        mo25031a(b);
        this.f15026l = messageSnapshot.mo25279n();
        if (b != -4) {
            if (b == -3) {
                this.f15029o = messageSnapshot.mo25271e();
                this.f15023i = messageSnapshot.mo25269d();
                this.f15024j = messageSnapshot.mo25269d();
            } else if (b == -2) {
                return;
            } else {
                if (b == -1) {
                    this.f15020f = messageSnapshot.mo25276j();
                    this.f15023i = messageSnapshot.mo25275i();
                } else if (b == 1) {
                    this.f15023i = messageSnapshot.mo25275i();
                    this.f15024j = messageSnapshot.mo25269d();
                    sVar = this.f15015a;
                } else if (b == 2) {
                    this.f15024j = messageSnapshot.mo25269d();
                    this.f15027m = messageSnapshot.mo25273g();
                    this.f15028n = messageSnapshot.mo25274h();
                    String f = messageSnapshot.mo25272f();
                    if (f != null) {
                        if (F.mo24921n() != null) {
                            C4660d.m19124d(this, "already has mFilename[%s], but assign mFilename[%s] again", F.mo24921n(), f);
                        }
                        this.f15017c.mo25006c(f);
                    }
                    this.f15021g.mo24956a(this.f15023i);
                    this.f15015a.mo25245c(messageSnapshot);
                    return;
                } else if (b == 3) {
                    this.f15023i = messageSnapshot.mo25275i();
                    this.f15021g.mo24959c(messageSnapshot.mo25275i());
                    this.f15015a.mo25247d(messageSnapshot);
                    return;
                } else if (b == 5) {
                    this.f15023i = messageSnapshot.mo25275i();
                    this.f15020f = messageSnapshot.mo25276j();
                    this.f15025k = messageSnapshot.mo25277k();
                    this.f15021g.mo24955a();
                    this.f15015a.mo25251f(messageSnapshot);
                    return;
                } else if (b == 6) {
                    this.f15015a.mo25244b(messageSnapshot);
                    return;
                } else {
                    return;
                }
            }
            C4666h.m19171a().mo25228a(this.f15017c.mo25004R(), messageSnapshot);
            return;
        }
        this.f15021g.mo24955a();
        int a = C4666h.m19171a().mo25225a(F.mo24915h());
        int a2 = (a > 1 || !F.mo24920m()) ? 0 : C4666h.m19171a().mo25225a(C4664f.m19144b(F.mo24916i(), F.mo24922o()));
        if (a + a2 <= 1) {
            byte b2 = C4677m.m19228a().mo25264b(F.mo24915h());
            C4660d.m19124d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(F.mo24915h()), Integer.valueOf(b2));
            if (C4623d.m18949b(b2)) {
                mo25031a(1);
                this.f15024j = messageSnapshot.mo25269d();
                this.f15023i = messageSnapshot.mo25275i();
                this.f15021g.mo24956a(this.f15023i);
                sVar = this.f15015a;
                messageSnapshot = ((C4681a) messageSnapshot).mo25285l();
            }
        }
        C4666h.m19171a().mo25228a(this.f15017c.mo25004R(), messageSnapshot);
        return;
        sVar.mo25241a(messageSnapshot);
    }

    /* renamed from: q */
    private void m18870q() {
        File file;
        C4583a F = this.f15017c.mo25004R().mo24935F();
        if (F.mo24919l() == null) {
            F.mo24903a(C4664f.m19147b(F.mo24916i()));
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "save Path is null to %s", F.mo24919l());
            }
        }
        if (F.mo24920m()) {
            file = new File(F.mo24919l());
        } else {
            String h = C4664f.m19159h(F.mo24919l());
            if (h != null) {
                file = new File(h);
            } else {
                throw new InvalidParameterException(C4664f.m19135a("the provided mPath[%s] is invalid, can't find its directory", F.mo24919l()));
            }
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(C4664f.m19135a("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    /* renamed from: r */
    private int m18871r() {
        return this.f15017c.mo25004R().mo24935F().mo24915h();
    }

    /* renamed from: a */
    public MessageSnapshot mo25030a(Throwable th) {
        mo25031a(-1);
        this.f15020f = th;
        return C4701f.m19287a(m18871r(), mo25042j(), th);
    }

    /* renamed from: a */
    public void mo24947a() {
        if (C4675l.m19223b()) {
            C4675l.m19222a().mo25258b(this.f15017c.mo25004R().mo24935F());
        }
        if (C4660d.f15179a) {
            C4660d.m19125e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(mo25039g()));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25031a(byte b) {
        this.f15018d = b;
        this.f15019e = System.currentTimeMillis();
    }

    /* renamed from: a */
    public boolean mo25032a(MessageSnapshot messageSnapshot) {
        if (!C4623d.m18947a(mo25039g(), messageSnapshot.mo25286b())) {
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f15018d), Byte.valueOf(mo25039g()), Integer.valueOf(m18871r()));
            }
            return false;
        }
        m18869e(messageSnapshot);
        return true;
    }

    /* renamed from: b */
    public int mo24957b() {
        return this.f15022h.mo24957b();
    }

    /* renamed from: b */
    public boolean mo25033b(MessageSnapshot messageSnapshot) {
        byte g = mo25039g();
        byte b = messageSnapshot.mo25286b();
        if (-2 == g && C4623d.m18949b(b)) {
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(m18871r()));
            }
            return true;
        } else if (!C4623d.m18950b(g, b)) {
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f15018d), Byte.valueOf(mo25039g()), Integer.valueOf(m18871r()));
            }
            return false;
        } else {
            m18869e(messageSnapshot);
            return true;
        }
    }

    /* renamed from: c */
    public void mo24948c() {
        C4583a F = this.f15017c.mo25004R().mo24935F();
        if (C4675l.m19223b()) {
            C4675l.m19222a().mo25260d(F);
        }
        if (C4660d.f15179a) {
            C4660d.m19125e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(mo25039g()));
        }
        this.f15021g.mo24958b(this.f15023i);
        if (this.f15017c.mo25005S() != null) {
            ArrayList arrayList = (ArrayList) this.f15017c.mo25005S().clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((C4584a) arrayList.get(i)).mo24934a(F);
            }
        }
        C4723q.m19348a().mo25319e().mo25362b(this.f15017c.mo25004R());
    }

    /* renamed from: c */
    public boolean mo25034c(MessageSnapshot messageSnapshot) {
        if (!C4623d.m18948a(this.f15017c.mo25004R().mo24935F())) {
            return false;
        }
        m18869e(messageSnapshot);
        return true;
    }

    /* renamed from: d */
    public C4728s mo25035d() {
        return this.f15015a;
    }

    /* renamed from: d */
    public boolean mo25036d(MessageSnapshot messageSnapshot) {
        if (!this.f15017c.mo25004R().mo24935F().mo24920m() || messageSnapshot.mo25286b() != -4 || mo25039g() != 2) {
            return false;
        }
        m18869e(messageSnapshot);
        return true;
    }

    /* JADX INFO: used method not loaded: com.kwai.filedownloader.h.b(com.kwai.filedownloader.a$b):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
            r0 = r7.f15017c.mo25004R();
            r1 = r0.mo24935F();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
            if (com.kwai.filedownloader.C4675l.m19223b() == false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
            com.kwai.filedownloader.C4675l.m19222a().mo25257a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
            if (com.kwai.filedownloader.p358f.C4660d.f15179a == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
            com.kwai.filedownloader.p358f.C4660d.m19125e(r7, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", r1.mo24916i(), r1.mo24919l(), r1.mo24923p(), r1.mo24933z());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            m18870q();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
            r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
            r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
            com.kwai.filedownloader.C4666h.m19171a().mo25231b(r0);
            com.kwai.filedownloader.C4666h.m19171a().mo25228a(r0, mo25030a(r1));
            r0 = false;
     */
    /* renamed from: e */
    public void mo25037e() {
        /*
        r7 = this;
        java.lang.Object r0 = r7.f15016b
        monitor-enter(r0)
        byte r1 = r7.f15018d     // Catch:{ all -> 0x009f }
        r2 = 2
        r3 = 1
        r4 = 0
        if (r1 == 0) goto L_0x0025
        java.lang.String r1 = "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d"
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x009f }
        int r5 = r7.m18871r()     // Catch:{ all -> 0x009f }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x009f }
        r2[r4] = r5     // Catch:{ all -> 0x009f }
        byte r4 = r7.f15018d     // Catch:{ all -> 0x009f }
        java.lang.Byte r4 = java.lang.Byte.valueOf(r4)     // Catch:{ all -> 0x009f }
        r2[r3] = r4     // Catch:{ all -> 0x009f }
        com.kwai.filedownloader.p358f.C4660d.m19124d(r7, r1, r2)     // Catch:{ all -> 0x009f }
        monitor-exit(r0)     // Catch:{ all -> 0x009f }
        return
    L_0x0025:
        r1 = 10
        r7.mo25031a(r1)     // Catch:{ all -> 0x009f }
        monitor-exit(r0)     // Catch:{ all -> 0x009f }
        com.kwai.filedownloader.d$a r0 = r7.f15017c
        com.kwai.filedownloader.a$b r0 = r0.mo25004R()
        com.kwai.filedownloader.a r1 = r0.mo24935F()
        boolean r5 = com.kwai.filedownloader.C4675l.m19223b()
        if (r5 == 0) goto L_0x0042
        com.kwai.filedownloader.l$a r5 = com.kwai.filedownloader.C4675l.m19222a()
        r5.mo25257a(r1)
    L_0x0042:
        boolean r5 = com.kwai.filedownloader.p358f.C4660d.f15179a
        if (r5 == 0) goto L_0x0067
        r5 = 4
        java.lang.Object[] r5 = new java.lang.Object[r5]
        java.lang.String r6 = r1.mo24916i()
        r5[r4] = r6
        java.lang.String r6 = r1.mo24919l()
        r5[r3] = r6
        com.kwai.filedownloader.i r6 = r1.mo24923p()
        r5[r2] = r6
        r2 = 3
        java.lang.Object r1 = r1.mo24933z()
        r5[r2] = r1
        java.lang.String r1 = "call start Url[%s], Path[%s] Listener[%s], Tag[%s]"
        com.kwai.filedownloader.p358f.C4660d.m19125e(r7, r1, r5)
    L_0x0067:
        r7.m18870q()     // Catch:{ all -> 0x006c }
        r0 = 1
        goto L_0x0080
    L_0x006c:
        r1 = move-exception
        com.kwai.filedownloader.h r2 = com.kwai.filedownloader.C4666h.m19171a()
        r2.mo25231b(r0)
        com.kwai.filedownloader.h r2 = com.kwai.filedownloader.C4666h.m19171a()
        com.kwai.filedownloader.message.MessageSnapshot r1 = r7.mo25030a(r1)
        r2.mo25228a(r0, r1)
        r0 = 0
    L_0x0080:
        if (r0 == 0) goto L_0x0089
        com.kwai.filedownloader.p r0 = com.kwai.filedownloader.C4719p.m19341a()
        r0.mo25306a(r7)
    L_0x0089:
        boolean r0 = com.kwai.filedownloader.p358f.C4660d.f15179a
        if (r0 == 0) goto L_0x009e
        java.lang.Object[] r0 = new java.lang.Object[r3]
        int r1 = r7.m18871r()
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        r0[r4] = r1
        java.lang.String r1 = "the task[%d] has been into the launch pool."
        com.kwai.filedownloader.p358f.C4660d.m19125e(r7, r1, r0)
    L_0x009e:
        return
    L_0x009f:
        r1 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x009f }
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.C4616d.mo25037e():void");
    }

    /* renamed from: e_ */
    public void mo24949e_() {
        if (C4675l.m19223b() && mo25039g() == 6) {
            C4675l.m19222a().mo25259c(this.f15017c.mo25004R().mo24935F());
        }
    }

    /* renamed from: f */
    public boolean mo25038f() {
        if (C4623d.m18946a((int) mo25039g())) {
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(mo25039g()), Integer.valueOf(this.f15017c.mo25004R().mo24935F().mo24915h()));
            }
            return false;
        }
        mo25031a(-2);
        C4585b R = this.f15017c.mo25004R();
        C4583a F = R.mo24935F();
        C4719p.m19341a().mo25307b(this);
        if (C4660d.f15179a) {
            C4660d.m19125e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(m18871r()));
        }
        if (C4723q.m19348a().mo25317c()) {
            C4677m.m19228a().mo25262a(F.mo24915h());
        } else if (C4660d.f15179a) {
            C4660d.m19123c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(F.mo24915h()));
        }
        C4666h.m19171a().mo25231b(R);
        C4666h.m19171a().mo25228a(R, C4701f.m19289a(F));
        C4723q.m19348a().mo25319e().mo25362b(R);
        return true;
    }

    /* renamed from: g */
    public byte mo25039g() {
        return this.f15018d;
    }

    /* renamed from: h */
    public long mo25040h() {
        return this.f15019e;
    }

    /* renamed from: i */
    public void mo25041i() {
        this.f15020f = null;
        this.f15028n = null;
        this.f15027m = false;
        this.f15025k = 0;
        this.f15029o = false;
        this.f15026l = false;
        this.f15023i = 0;
        this.f15024j = 0;
        this.f15021g.mo24955a();
        if (C4623d.m18946a((int) this.f15018d)) {
            this.f15015a.mo25249e();
            this.f15015a = new C4674k(this.f15017c.mo25004R(), this);
        } else {
            this.f15015a.mo25240a(this.f15017c.mo25004R(), this);
        }
        mo25031a(0);
    }

    /* renamed from: j */
    public long mo25042j() {
        return this.f15023i;
    }

    /* renamed from: k */
    public long mo25043k() {
        return this.f15024j;
    }

    /* renamed from: l */
    public Throwable mo25044l() {
        return this.f15020f;
    }

    /* renamed from: m */
    public int mo25045m() {
        return this.f15025k;
    }

    /* renamed from: n */
    public boolean mo25046n() {
        return this.f15026l;
    }

    /* renamed from: o */
    public void mo25047o() {
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "free the task %d, when the status is %d", Integer.valueOf(m18871r()), Byte.valueOf(this.f15018d));
        }
        mo25031a(0);
    }

    /* JADX INFO: used method not loaded: com.kwai.filedownloader.h.b(com.kwai.filedownloader.a$b):null, types can be incorrect */
    /* JADX INFO: used method not loaded: com.kwai.filedownloader.m.a(int):null, types can be incorrect */
    /* JADX INFO: used method not loaded: com.kwai.filedownloader.h.a(com.kwai.filedownloader.a$b):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            com.kwai.filedownloader.C4666h.m19171a().mo25231b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007d, code lost:
            if (com.kwai.filedownloader.p358f.C4654c.m19109a(r0.mo24915h(), r0.mo24922o(), r0.mo24931x(), true) == false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
            r0 = com.kwai.filedownloader.C4677m.m19228a().mo25263a(r0.mo24916i(), r0.mo24919l(), r0.mo24920m(), r0.mo24917j(), r0.mo24918k(), r0.mo24894A(), r0.mo24931x(), r1.f15017c.mo25003Q(), r0.mo24898E());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b1, code lost:
            if (r1.f15018d != -2) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b3, code lost:
            com.kwai.filedownloader.p358f.C4660d.m19124d(r1, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", java.lang.Integer.valueOf(m18871r()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c4, code lost:
            if (r0 == false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c6, code lost:
            com.kwai.filedownloader.C4677m.m19228a().mo25262a(m18871r());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d1, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d2, code lost:
            if (r0 != false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d8, code lost:
            if (r7.mo25363c(r6) != false) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00da, code lost:
            r0 = mo25030a((java.lang.Throwable) new java.lang.RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ed, code lost:
            if (com.kwai.filedownloader.C4666h.m19171a().mo25227a(r6) == false) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ef, code lost:
            r7.mo25362b(r6);
            com.kwai.filedownloader.C4666h.m19171a().mo25231b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f9, code lost:
            com.kwai.filedownloader.C4666h.m19171a().mo25228a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0101, code lost:
            r7.mo25362b(r6);
     */
    /* renamed from: p */
    public void mo25048p() {
        /*
        r18 = this;
        r1 = r18
        byte r0 = r1.f15018d
        r2 = 2
        r3 = 10
        r4 = 0
        r5 = 1
        if (r0 == r3) goto L_0x0025
        java.lang.Object[] r0 = new java.lang.Object[r2]
        int r2 = r18.m18871r()
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        r0[r4] = r2
        byte r2 = r1.f15018d
        java.lang.Byte r2 = java.lang.Byte.valueOf(r2)
        r0[r5] = r2
        java.lang.String r2 = "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d"
        com.kwai.filedownloader.p358f.C4660d.m19124d(r1, r2, r0)
        return
    L_0x0025:
        com.kwai.filedownloader.d$a r0 = r1.f15017c
        com.kwai.filedownloader.a$b r6 = r0.mo25004R()
        com.kwai.filedownloader.a r0 = r6.mo24935F()
        com.kwai.filedownloader.q r7 = com.kwai.filedownloader.C4723q.m19348a()
        com.kwai.filedownloader.u r7 = r7.mo25319e()
        boolean r8 = r7.mo25363c(r6)     // Catch:{ all -> 0x0108 }
        if (r8 == 0) goto L_0x003e
        return
    L_0x003e:
        java.lang.Object r8 = r1.f15016b     // Catch:{ all -> 0x0108 }
        monitor-enter(r8)     // Catch:{ all -> 0x0108 }
        byte r9 = r1.f15018d     // Catch:{ all -> 0x0105 }
        if (r9 == r3) goto L_0x0060
        java.lang.String r0 = "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d"
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0105 }
        int r3 = r18.m18871r()     // Catch:{ all -> 0x0105 }
        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0105 }
        r2[r4] = r3     // Catch:{ all -> 0x0105 }
        byte r3 = r1.f15018d     // Catch:{ all -> 0x0105 }
        java.lang.Byte r3 = java.lang.Byte.valueOf(r3)     // Catch:{ all -> 0x0105 }
        r2[r5] = r3     // Catch:{ all -> 0x0105 }
        com.kwai.filedownloader.p358f.C4660d.m19124d(r1, r0, r2)     // Catch:{ all -> 0x0105 }
        monitor-exit(r8)     // Catch:{ all -> 0x0105 }
        return
    L_0x0060:
        r2 = 11
        r1.mo25031a(r2)     // Catch:{ all -> 0x0105 }
        monitor-exit(r8)     // Catch:{ all -> 0x0105 }
        com.kwai.filedownloader.h r2 = com.kwai.filedownloader.C4666h.m19171a()     // Catch:{ all -> 0x0108 }
        r2.mo25231b(r6)     // Catch:{ all -> 0x0108 }
        int r2 = r0.mo24915h()     // Catch:{ all -> 0x0108 }
        java.lang.String r3 = r0.mo24922o()     // Catch:{ all -> 0x0108 }
        boolean r8 = r0.mo24931x()     // Catch:{ all -> 0x0108 }
        boolean r2 = com.kwai.filedownloader.p358f.C4654c.m19109a(r2, r3, r8, r5)     // Catch:{ all -> 0x0108 }
        if (r2 == 0) goto L_0x0080
        return
    L_0x0080:
        com.kwai.filedownloader.m r8 = com.kwai.filedownloader.C4677m.m19228a()     // Catch:{ all -> 0x0108 }
        java.lang.String r9 = r0.mo24916i()     // Catch:{ all -> 0x0108 }
        java.lang.String r10 = r0.mo24919l()     // Catch:{ all -> 0x0108 }
        boolean r11 = r0.mo24920m()     // Catch:{ all -> 0x0108 }
        int r12 = r0.mo24917j()     // Catch:{ all -> 0x0108 }
        int r13 = r0.mo24918k()     // Catch:{ all -> 0x0108 }
        int r14 = r0.mo24894A()     // Catch:{ all -> 0x0108 }
        boolean r15 = r0.mo24931x()     // Catch:{ all -> 0x0108 }
        com.kwai.filedownloader.d$a r2 = r1.f15017c     // Catch:{ all -> 0x0108 }
        com.kwai.filedownloader.d.b r16 = r2.mo25003Q()     // Catch:{ all -> 0x0108 }
        boolean r17 = r0.mo24898E()     // Catch:{ all -> 0x0108 }
        boolean r0 = r8.mo25263a(r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0108 }
        byte r2 = r1.f15018d     // Catch:{ all -> 0x0108 }
        r3 = -2
        if (r2 != r3) goto L_0x00d2
        java.lang.String r2 = "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied"
        java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x0108 }
        int r5 = r18.m18871r()     // Catch:{ all -> 0x0108 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0108 }
        r3[r4] = r5     // Catch:{ all -> 0x0108 }
        com.kwai.filedownloader.p358f.C4660d.m19124d(r1, r2, r3)     // Catch:{ all -> 0x0108 }
        if (r0 == 0) goto L_0x00d1
        com.kwai.filedownloader.m r0 = com.kwai.filedownloader.C4677m.m19228a()     // Catch:{ all -> 0x0108 }
        int r2 = r18.m18871r()     // Catch:{ all -> 0x0108 }
        r0.mo25262a(r2)     // Catch:{ all -> 0x0108 }
    L_0x00d1:
        return
    L_0x00d2:
        if (r0 != 0) goto L_0x0101
        boolean r0 = r7.mo25363c(r6)     // Catch:{ all -> 0x0108 }
        if (r0 != 0) goto L_0x0117
        java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0108 }
        java.lang.String r2 = "Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."
        r0.<init>(r2)     // Catch:{ all -> 0x0108 }
        com.kwai.filedownloader.message.MessageSnapshot r0 = r1.mo25030a(r0)     // Catch:{ all -> 0x0108 }
        com.kwai.filedownloader.h r2 = com.kwai.filedownloader.C4666h.m19171a()     // Catch:{ all -> 0x0108 }
        boolean r2 = r2.mo25227a(r6)     // Catch:{ all -> 0x0108 }
        if (r2 == 0) goto L_0x00f9
        r7.mo25362b(r6)     // Catch:{ all -> 0x0108 }
        com.kwai.filedownloader.h r2 = com.kwai.filedownloader.C4666h.m19171a()     // Catch:{ all -> 0x0108 }
        r2.mo25231b(r6)     // Catch:{ all -> 0x0108 }
    L_0x00f9:
        com.kwai.filedownloader.h r2 = com.kwai.filedownloader.C4666h.m19171a()     // Catch:{ all -> 0x0108 }
        r2.mo25228a(r6, r0)     // Catch:{ all -> 0x0108 }
        goto L_0x0117
    L_0x0101:
        r7.mo25362b(r6)     // Catch:{ all -> 0x0108 }
        goto L_0x0117
    L_0x0105:
        r0 = move-exception
        monitor-exit(r8)     // Catch:{ all -> 0x0105 }
        throw r0     // Catch:{ all -> 0x0108 }
    L_0x0108:
        r0 = move-exception
        r0.printStackTrace()
        com.kwai.filedownloader.h r2 = com.kwai.filedownloader.C4666h.m19171a()
        com.kwai.filedownloader.message.MessageSnapshot r0 = r1.mo25030a(r0)
        r2.mo25228a(r6, r0)
    L_0x0117:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.C4616d.mo25048p():void");
    }
}
