package com.p530ss.android.p531a.p532a.p536c;

import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.ss.android.a.a.c.d */
public class DownloadEventModel {
    /* renamed from: a */
    private String f21074a;
    /* renamed from: b */
    private final String f21075b;
    /* renamed from: c */
    private final String f21076c;
    /* renamed from: d */
    private final boolean f21077d;
    /* renamed from: e */
    private final long f21078e;
    /* renamed from: f */
    private final String f21079f;
    /* renamed from: g */
    private final long f21080g;
    /* renamed from: h */
    private final JSONObject f21081h;
    /* renamed from: i */
    private final List<String> f21082i;
    /* renamed from: j */
    private final int f21083j;
    /* renamed from: k */
    private final Object f21084k;
    /* renamed from: l */
    private final String f21085l;
    /* renamed from: m */
    private final boolean f21086m;
    /* renamed from: n */
    private final String f21087n;
    /* renamed from: o */
    private final JSONObject f21088o;

    /* compiled from: DownloadEventModel */
    /* renamed from: com.ss.android.a.a.c.d$a */
    public static class C6518a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public String f21089a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public String f21090b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public String f21091c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public boolean f21092d = false;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public long f21093e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public String f21094f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public long f21095g;
        /* access modifiers changed from: private */
        /* renamed from: h */
        public JSONObject f21096h;
        /* renamed from: i */
        private Map<String, Object> f21097i;
        /* access modifiers changed from: private */
        /* renamed from: j */
        public List<String> f21098j;
        /* access modifiers changed from: private */
        /* renamed from: k */
        public int f21099k;
        /* access modifiers changed from: private */
        /* renamed from: l */
        public Object f21100l;
        /* access modifiers changed from: private */
        /* renamed from: m */
        public String f21101m;
        /* access modifiers changed from: private */
        /* renamed from: n */
        public boolean f21102n = false;
        /* access modifiers changed from: private */
        /* renamed from: o */
        public String f21103o;
        /* access modifiers changed from: private */
        /* renamed from: p */
        public JSONObject f21104p;

        /* renamed from: a */
        public C6518a mo31131a(boolean z) {
            this.f21102n = z;
            return this;
        }

        /* renamed from: a */
        public C6518a mo31128a(String str) {
            this.f21090b = str;
            return this;
        }

        /* renamed from: b */
        public C6518a mo31134b(String str) {
            this.f21091c = str;
            return this;
        }

        /* renamed from: a */
        public C6518a mo31126a(long j) {
            this.f21093e = j;
            return this;
        }

        /* renamed from: b */
        public C6518a mo31133b(long j) {
            this.f21095g = j;
            return this;
        }

        /* renamed from: c */
        public C6518a mo31136c(String str) {
            this.f21094f = str;
            return this;
        }

        /* renamed from: b */
        public C6518a mo31135b(boolean z) {
            this.f21092d = z;
            return this;
        }

        /* renamed from: a */
        public C6518a mo31130a(JSONObject jSONObject) {
            this.f21096h = jSONObject;
            return this;
        }

        /* renamed from: a */
        public C6518a mo31129a(List<String> list) {
            this.f21098j = list;
            return this;
        }

        /* renamed from: a */
        public C6518a mo31125a(int i) {
            this.f21099k = i;
            return this;
        }

        /* renamed from: a */
        public C6518a mo31127a(Object obj) {
            this.f21100l = obj;
            return this;
        }

        /* renamed from: d */
        public C6518a mo31137d(String str) {
            this.f21101m = str;
            return this;
        }

        /* renamed from: a */
        public DownloadEventModel mo31132a() {
            if (TextUtils.isEmpty(this.f21089a)) {
                this.f21089a = AppLog.UMENG_CATEGORY;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f21096h == null) {
                this.f21096h = new JSONObject();
            }
            try {
                if (this.f21097i != null && !this.f21097i.isEmpty()) {
                    for (Entry entry : this.f21097i.entrySet()) {
                        if (!this.f21096h.has((String) entry.getKey())) {
                            this.f21096h.putOpt((String) entry.getKey(), entry.getValue());
                        }
                    }
                }
                String str = "1";
                String str2 = "is_ad_event";
                String str3 = "refer";
                String str4 = "log_extra";
                if (this.f21102n) {
                    this.f21103o = this.f21091c;
                    this.f21104p = new JSONObject();
                    Iterator keys = this.f21096h.keys();
                    while (keys.hasNext()) {
                        String str5 = (String) keys.next();
                        this.f21104p.put(str5, this.f21096h.get(str5));
                    }
                    this.f21104p.put("category", this.f21089a);
                    this.f21104p.put("tag", this.f21090b);
                    this.f21104p.put(ArgKey.KEY_VALUE, this.f21093e);
                    this.f21104p.put("ext_value", this.f21095g);
                    if (!TextUtils.isEmpty(this.f21101m)) {
                        this.f21104p.put(str3, this.f21101m);
                    }
                    if (this.f21092d) {
                        if (!this.f21104p.has(str4) && !TextUtils.isEmpty(this.f21094f)) {
                            this.f21104p.put(str4, this.f21094f);
                        }
                        this.f21104p.put(str2, str);
                    }
                }
                if (this.f21092d) {
                    jSONObject.put("ad_extra_data", this.f21096h.toString());
                    if (!jSONObject.has(str4) && !TextUtils.isEmpty(this.f21094f)) {
                        jSONObject.put(str4, this.f21094f);
                    }
                    jSONObject.put(str2, str);
                } else {
                    jSONObject.put("extra", this.f21096h);
                }
                if (!TextUtils.isEmpty(this.f21101m)) {
                    jSONObject.putOpt(str3, this.f21101m);
                }
                this.f21096h = jSONObject;
            } catch (Exception unused) {
            }
            return new DownloadEventModel(this);
        }
    }

    DownloadEventModel(C6518a aVar) {
        this.f21074a = aVar.f21089a;
        this.f21075b = aVar.f21090b;
        this.f21076c = aVar.f21091c;
        this.f21077d = aVar.f21092d;
        this.f21078e = aVar.f21093e;
        this.f21079f = aVar.f21094f;
        this.f21080g = aVar.f21095g;
        this.f21081h = aVar.f21096h;
        this.f21082i = aVar.f21098j;
        this.f21083j = aVar.f21099k;
        this.f21084k = aVar.f21100l;
        this.f21086m = aVar.f21102n;
        this.f21087n = aVar.f21103o;
        this.f21088o = aVar.f21104p;
        this.f21085l = aVar.f21101m;
    }

    /* renamed from: a */
    public String mo31119a() {
        return this.f21075b;
    }

    /* renamed from: b */
    public String mo31120b() {
        return this.f21076c;
    }

    /* renamed from: c */
    public boolean mo31121c() {
        return this.f21077d;
    }

    /* renamed from: d */
    public JSONObject mo31122d() {
        return this.f21081h;
    }

    /* renamed from: e */
    public boolean mo31123e() {
        return this.f21086m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.f21074a);
        sb.append("\ttag: ");
        sb.append(this.f21075b);
        sb.append("\tlabel: ");
        sb.append(this.f21076c);
        sb.append("\nisAd: ");
        sb.append(this.f21077d);
        sb.append("\tadId: ");
        sb.append(this.f21078e);
        sb.append("\tlogExtra: ");
        sb.append(this.f21079f);
        sb.append("\textValue: ");
        sb.append(this.f21080g);
        sb.append("\nextJson: ");
        sb.append(this.f21081h);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.f21082i;
        String str = "";
        sb.append(list != null ? list.toString() : str);
        sb.append("\teventSource: ");
        sb.append(this.f21083j);
        sb.append("\textraObject: ");
        Object obj = this.f21084k;
        sb.append(obj != null ? obj.toString() : str);
        sb.append("\nisV3: ");
        sb.append(this.f21086m);
        sb.append("\tV3EventName: ");
        sb.append(this.f21087n);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.f21088o;
        if (jSONObject != null) {
            str = jSONObject.toString();
        }
        sb.append(str);
        return sb.toString();
    }
}
