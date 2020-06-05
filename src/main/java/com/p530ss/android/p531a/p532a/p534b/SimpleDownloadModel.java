package com.p530ss.android.p531a.p532a.p534b;

import com.p530ss.android.p531a.p532a.p536c.C6514b;
import com.p530ss.android.p531a.p532a.p536c.QuickAppModel;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadFileUriProvider;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@Deprecated
/* renamed from: com.ss.android.a.a.b.f */
public class SimpleDownloadModel implements C6507c {
    /* renamed from: a */
    private String f20995a;
    /* renamed from: b */
    private long f20996b;
    /* renamed from: c */
    private long f20997c;
    /* renamed from: d */
    private String f20998d;
    /* renamed from: e */
    private String f20999e;
    /* renamed from: f */
    private Map<String, String> f21000f;
    /* renamed from: g */
    private boolean f21001g;
    /* renamed from: h */
    private boolean f21002h;
    /* renamed from: i */
    private boolean f21003i;
    /* renamed from: j */
    private JSONObject f21004j;
    /* renamed from: k */
    private boolean f21005k;
    /* renamed from: l */
    private boolean f21006l;
    /* renamed from: m */
    private String f21007m;
    /* renamed from: n */
    private String f21008n;
    /* renamed from: o */
    private String f21009o;
    /* renamed from: p */
    private boolean f21010p;
    /* renamed from: q */
    private int f21011q;
    /* renamed from: r */
    private String f21012r;
    /* renamed from: s */
    private QuickAppModel f21013s;
    /* renamed from: t */
    private List<String> f21014t;
    /* renamed from: u */
    private String f21015u;
    /* renamed from: v */
    private boolean f21016v;
    /* renamed from: w */
    private IDownloadFileUriProvider f21017w;

    /* compiled from: SimpleDownloadModel */
    /* renamed from: com.ss.android.a.a.b.f$a */
    public static class C6511a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public long f21018a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public long f21019b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public String f21020c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public String f21021d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public String f21022e = "application/vnd.android.package-archive";
        /* access modifiers changed from: private */
        /* renamed from: f */
        public Map<String, String> f21023f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public boolean f21024g = true;
        /* access modifiers changed from: private */
        /* renamed from: h */
        public boolean f21025h = true;
        /* access modifiers changed from: private */
        /* renamed from: i */
        public boolean f21026i = false;
        /* access modifiers changed from: private */
        /* renamed from: j */
        public JSONObject f21027j;
        /* access modifiers changed from: private */
        /* renamed from: k */
        public boolean f21028k = true;
        /* access modifiers changed from: private */
        /* renamed from: l */
        public boolean f21029l = true;
        /* access modifiers changed from: private */
        /* renamed from: m */
        public String f21030m;
        /* access modifiers changed from: private */
        /* renamed from: n */
        public String f21031n;
        /* access modifiers changed from: private */
        /* renamed from: o */
        public String f21032o;
        /* access modifiers changed from: private */
        /* renamed from: p */
        public boolean f21033p;
        /* access modifiers changed from: private */
        /* renamed from: q */
        public int f21034q;
        /* access modifiers changed from: private */
        /* renamed from: r */
        public String f21035r;
        /* access modifiers changed from: private */
        /* renamed from: s */
        public QuickAppModel f21036s;
        /* access modifiers changed from: private */
        /* renamed from: t */
        public boolean f21037t;
        /* access modifiers changed from: private */
        /* renamed from: u */
        public IDownloadFileUriProvider f21038u;

        /* renamed from: a */
        public C6511a mo31088a(String str) {
            this.f21020c = str;
            return this;
        }

        /* renamed from: a */
        public C6511a mo31089a(boolean z) {
            this.f21024g = z;
            return this;
        }

        /* renamed from: b */
        public C6511a mo31092b(boolean z) {
            this.f21025h = z;
            return this;
        }

        /* renamed from: b */
        public C6511a mo31091b(String str) {
            this.f21030m = str;
            return this;
        }

        /* renamed from: c */
        public C6511a mo31093c(boolean z) {
            this.f21033p = z;
            return this;
        }

        /* renamed from: d */
        public C6511a mo31094d(boolean z) {
            this.f21037t = z;
            return this;
        }

        /* renamed from: a */
        public SimpleDownloadModel mo31090a() {
            return new SimpleDownloadModel(this);
        }
    }

    /* renamed from: r */
    public boolean mo31078r() {
        return false;
    }

    /* renamed from: s */
    public String mo31079s() {
        return null;
    }

    /* renamed from: u */
    public C6514b mo31081u() {
        return null;
    }

    /* renamed from: v */
    public List<String> mo31082v() {
        return null;
    }

    /* renamed from: w */
    public JSONObject mo31083w() {
        return null;
    }

    /* renamed from: x */
    public int mo31084x() {
        return 0;
    }

    private SimpleDownloadModel(C6511a aVar) {
        this.f20996b = aVar.f21018a;
        this.f20997c = aVar.f21019b;
        this.f20995a = aVar.f21020c;
        this.f20998d = aVar.f21021d;
        this.f20999e = aVar.f21022e;
        this.f21000f = aVar.f21023f;
        this.f21001g = aVar.f21024g;
        this.f21002h = aVar.f21025h;
        this.f21003i = aVar.f21026i;
        this.f21004j = aVar.f21027j;
        this.f21005k = aVar.f21028k;
        this.f21006l = aVar.f21029l;
        this.f21007m = aVar.f21030m;
        this.f21008n = aVar.f21031n;
        this.f21009o = aVar.f21032o;
        this.f21010p = aVar.f21033p;
        this.f21011q = aVar.f21034q;
        this.f21012r = aVar.f21035r;
        this.f21013s = aVar.f21036s;
        this.f21016v = aVar.f21037t;
        this.f21017w = aVar.f21038u;
    }

    /* renamed from: d */
    public long mo31064d() {
        return this.f20996b;
    }

    /* renamed from: e */
    public long mo31065e() {
        return this.f20997c;
    }

    /* renamed from: a */
    public String mo31061a() {
        return this.f20995a;
    }

    /* renamed from: b */
    public List<String> mo31062b() {
        return this.f21014t;
    }

    /* renamed from: c */
    public String mo31063c() {
        return this.f21015u;
    }

    /* renamed from: f */
    public String mo31066f() {
        return this.f20998d;
    }

    /* renamed from: g */
    public String mo31067g() {
        return this.f20999e;
    }

    /* renamed from: h */
    public Map<String, String> mo31068h() {
        return this.f21000f;
    }

    /* renamed from: i */
    public boolean mo31069i() {
        return this.f21001g;
    }

    /* renamed from: j */
    public boolean mo31070j() {
        return this.f21002h;
    }

    /* renamed from: k */
    public boolean mo31071k() {
        return this.f21003i;
    }

    /* renamed from: l */
    public String mo31072l() {
        return this.f21007m;
    }

    /* renamed from: m */
    public String mo31073m() {
        return this.f21008n;
    }

    /* renamed from: n */
    public JSONObject mo31074n() {
        return this.f21004j;
    }

    /* renamed from: o */
    public boolean mo31075o() {
        return this.f21010p;
    }

    /* renamed from: p */
    public int mo31076p() {
        return this.f21011q;
    }

    /* renamed from: q */
    public String mo31077q() {
        return this.f21012r;
    }

    /* renamed from: t */
    public String mo31080t() {
        return this.f21009o;
    }

    /* renamed from: y */
    public QuickAppModel mo31085y() {
        return this.f21013s;
    }

    /* renamed from: z */
    public boolean mo31086z() {
        return this.f21016v;
    }

    /* renamed from: A */
    public IDownloadFileUriProvider mo31060A() {
        return this.f21017w;
    }
}
