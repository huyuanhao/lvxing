package com.kwai.filedownloader;

import android.text.TextUtils;
import com.kwai.filedownloader.C4583a.C4584a;
import com.kwai.filedownloader.C4583a.C4585b;
import com.kwai.filedownloader.C4583a.C4586c;
import com.kwai.filedownloader.C4743w.C4744a;
import com.kwai.filedownloader.p356d.C4619b;
import com.kwai.filedownloader.p356d.C4623d;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4664f;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.kwai.filedownloader.c */
public class C4607c implements C4583a, C4585b, C4617a {
    /* renamed from: a */
    volatile int f14990a = 0;
    /* renamed from: b */
    private final C4743w f14991b;
    /* renamed from: c */
    private final C4744a f14992c;
    /* renamed from: d */
    private int f14993d;
    /* renamed from: e */
    private ArrayList<C4584a> f14994e;
    /* renamed from: f */
    private final String f14995f;
    /* renamed from: g */
    private String f14996g;
    /* renamed from: h */
    private String f14997h;
    /* renamed from: i */
    private boolean f14998i;
    /* renamed from: j */
    private C4619b f14999j;
    /* renamed from: k */
    private C4669i f15000k;
    /* renamed from: l */
    private Object f15001l;
    /* renamed from: m */
    private int f15002m = 0;
    /* renamed from: n */
    private boolean f15003n = false;
    /* renamed from: o */
    private boolean f15004o = false;
    /* renamed from: p */
    private int f15005p = 100;
    /* renamed from: q */
    private int f15006q = 10;
    /* renamed from: r */
    private boolean f15007r = false;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public boolean f15008s = false;
    /* renamed from: t */
    private final Object f15009t;
    /* renamed from: u */
    private final Object f15010u = new Object();
    /* renamed from: v */
    private volatile boolean f15011v = false;

    /* renamed from: com.kwai.filedownloader.c$a */
    private static final class C4609a implements C4586c {
        /* renamed from: a */
        private final C4607c f15012a;

        private C4609a(C4607c cVar) {
            this.f15012a = cVar;
            this.f15012a.f15008s = true;
        }

        /* renamed from: a */
        public int mo24946a() {
            int h = this.f15012a.mo24915h();
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "add the task[%d] to the queue", Integer.valueOf(h));
            }
            C4666h.m19171a().mo25233c((C4585b) this.f15012a);
            return h;
        }
    }

    C4607c(String str) {
        this.f14995f = str;
        this.f15009t = new Object();
        C4616d dVar = new C4616d(this, this.f15009t);
        this.f14991b = dVar;
        this.f14992c = dVar;
    }

    /* renamed from: T */
    private int m18775T() {
        if (!mo25002P()) {
            if (!mo24911d()) {
                mo24939J();
            }
            this.f14991b.mo25037e();
            return mo24915h();
        } else if (mo24910c()) {
            throw new IllegalStateException(C4664f.m19135a("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(mo24915h())));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again.");
            sb.append(this.f14991b.toString());
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: U */
    private void m18776U() {
        if (this.f14999j == null) {
            synchronized (this.f15010u) {
                if (this.f14999j == null) {
                    this.f14999j = new C4619b();
                }
            }
        }
    }

    /* renamed from: A */
    public int mo24894A() {
        return this.f15002m;
    }

    /* renamed from: B */
    public int mo24895B() {
        return this.f14991b.mo25045m();
    }

    /* renamed from: C */
    public boolean mo24896C() {
        return this.f15003n;
    }

    /* renamed from: D */
    public boolean mo24897D() {
        return this.f14991b.mo25046n();
    }

    /* renamed from: E */
    public boolean mo24898E() {
        return this.f15004o;
    }

    /* renamed from: F */
    public C4583a mo24935F() {
        return this;
    }

    /* renamed from: G */
    public C4744a mo24936G() {
        return this.f14992c;
    }

    /* renamed from: H */
    public boolean mo24937H() {
        return C4623d.m18946a((int) mo24929v());
    }

    /* renamed from: I */
    public int mo24938I() {
        return this.f14990a;
    }

    /* renamed from: J */
    public void mo24939J() {
        this.f14990a = mo24923p() != null ? mo24923p().hashCode() : hashCode();
    }

    /* renamed from: K */
    public boolean mo24940K() {
        return this.f15011v;
    }

    /* renamed from: L */
    public void mo24941L() {
        this.f15011v = true;
    }

    /* renamed from: M */
    public void mo24942M() {
        this.f14991b.mo25047o();
        if (C4666h.m19171a().mo25227a((C4585b) this)) {
            this.f15011v = false;
        }
    }

    /* renamed from: N */
    public void mo24943N() {
        m18775T();
    }

    /* renamed from: O */
    public boolean mo24944O() {
        ArrayList<C4584a> arrayList = this.f14994e;
        return arrayList != null && arrayList.size() > 0;
    }

    /* renamed from: P */
    public boolean mo25002P() {
        return this.f14991b.mo25039g() != 0;
    }

    /* renamed from: Q */
    public C4619b mo25003Q() {
        return this.f14999j;
    }

    /* renamed from: R */
    public C4585b mo25004R() {
        return this;
    }

    /* renamed from: S */
    public ArrayList<C4584a> mo25005S() {
        return this.f14994e;
    }

    /* renamed from: a */
    public C4586c mo24899a() {
        return new C4609a();
    }

    /* renamed from: a */
    public C4583a mo24900a(int i) {
        this.f15002m = i;
        return this;
    }

    /* renamed from: a */
    public C4583a mo24901a(C4669i iVar) {
        this.f15000k = iVar;
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "setListener %s", iVar);
        }
        return this;
    }

    /* renamed from: a */
    public C4583a mo24902a(Object obj) {
        this.f15001l = obj;
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "setTag %s", obj);
        }
        return this;
    }

    /* renamed from: a */
    public C4583a mo24903a(String str) {
        return mo24905a(str, false);
    }

    /* renamed from: a */
    public C4583a mo24904a(String str, String str2) {
        m18776U();
        this.f14999j.mo25063a(str, str2);
        return this;
    }

    /* renamed from: a */
    public C4583a mo24905a(String str, boolean z) {
        this.f14996g = str;
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "setPath %s", str);
        }
        this.f14998i = z;
        this.f14997h = z ? null : new File(str).getName();
        return this;
    }

    /* renamed from: a */
    public C4583a mo24906a(boolean z) {
        this.f15007r = z;
        return this;
    }

    /* renamed from: b */
    public C4583a mo24907b(String str) {
        if (this.f14999j == null) {
            synchronized (this.f15010u) {
                if (this.f14999j == null) {
                    return this;
                }
            }
        }
        this.f14999j.mo25062a(str);
        return this;
    }

    /* renamed from: b */
    public C4583a mo24908b(boolean z) {
        this.f15004o = z;
        return this;
    }

    /* renamed from: b */
    public boolean mo24909b() {
        if (mo24910c()) {
            C4660d.m19124d(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(mo24915h()));
            return false;
        }
        this.f14990a = 0;
        this.f15008s = false;
        this.f15011v = false;
        this.f14991b.mo25041i();
        return true;
    }

    /* renamed from: b */
    public boolean mo24945b(int i) {
        return mo24915h() == i;
    }

    /* renamed from: c */
    public void mo25006c(String str) {
        this.f14997h = str;
    }

    /* renamed from: c */
    public boolean mo24910c() {
        if (C4723q.m19348a().mo25319e().mo25361a(this)) {
            return true;
        }
        return C4623d.m18949b(mo24929v());
    }

    /* renamed from: d */
    public boolean mo24911d() {
        return this.f14990a != 0;
    }

    /* renamed from: e */
    public int mo24912e() {
        if (!this.f15008s) {
            return m18775T();
        }
        throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
    }

    /* renamed from: f */
    public boolean mo24913f() {
        boolean f;
        synchronized (this.f15009t) {
            f = this.f14991b.mo25038f();
        }
        return f;
    }

    /* renamed from: g */
    public boolean mo24914g() {
        return mo24913f();
    }

    /* renamed from: h */
    public int mo24915h() {
        int i = this.f14993d;
        if (i != 0) {
            return i;
        }
        if (TextUtils.isEmpty(this.f14996g) || TextUtils.isEmpty(this.f14995f)) {
            return 0;
        }
        int a = C4664f.m19130a(this.f14995f, this.f14996g, this.f14998i);
        this.f14993d = a;
        return a;
    }

    /* renamed from: i */
    public String mo24916i() {
        return this.f14995f;
    }

    /* renamed from: j */
    public int mo24917j() {
        return this.f15005p;
    }

    /* renamed from: k */
    public int mo24918k() {
        return this.f15006q;
    }

    /* renamed from: l */
    public String mo24919l() {
        return this.f14996g;
    }

    /* renamed from: m */
    public boolean mo24920m() {
        return this.f14998i;
    }

    /* renamed from: n */
    public String mo24921n() {
        return this.f14997h;
    }

    /* renamed from: o */
    public String mo24922o() {
        return C4664f.m19134a(mo24919l(), mo24920m(), mo24921n());
    }

    /* renamed from: p */
    public C4669i mo24923p() {
        return this.f15000k;
    }

    /* renamed from: q */
    public int mo24924q() {
        return this.f14991b.mo25042j() > 2147483647L ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) this.f14991b.mo25042j();
    }

    /* renamed from: r */
    public long mo24925r() {
        return this.f14991b.mo25042j();
    }

    /* renamed from: s */
    public int mo24926s() {
        return this.f14991b.mo25043k() > 2147483647L ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) this.f14991b.mo25043k();
    }

    /* renamed from: t */
    public long mo24927t() {
        return this.f14991b.mo25043k();
    }

    public String toString() {
        return C4664f.m19135a("%d@%s", Integer.valueOf(mo24915h()), super.toString());
    }

    /* renamed from: u */
    public int mo24928u() {
        return this.f14991b.mo24957b();
    }

    /* renamed from: v */
    public byte mo24929v() {
        return this.f14991b.mo25039g();
    }

    /* renamed from: w */
    public long mo24930w() {
        return this.f14991b.mo25040h();
    }

    /* renamed from: x */
    public boolean mo24931x() {
        return this.f15007r;
    }

    /* renamed from: y */
    public Throwable mo24932y() {
        return this.f14991b.mo25044l();
    }

    /* renamed from: z */
    public Object mo24933z() {
        return this.f15001l;
    }
}
