package com.kwad.sdk.core.p333g;

import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.response.p342b.C4325d;
import com.kwad.sdk.core.scene.C4331a;
import com.kwad.sdk.core.scene.PageScene;
import com.kwad.sdk.core.scene.PageScene.PageSource;
import com.kwad.sdk.entry.model.CacheTemplate;
import com.kwad.sdk.p306a.C3800e;
import discoveryAD.C7880W.C7881a;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.g.i */
public class C4156i implements C4321b {
    /* renamed from: A */
    private long f13842A;
    /* renamed from: B */
    private int f13843B = 0;
    /* renamed from: C */
    private long f13844C;
    /* renamed from: D */
    private long f13845D;
    /* renamed from: E */
    private String f13846E;
    /* renamed from: F */
    private C4157a f13847F;
    /* renamed from: a */
    public long f13848a;
    /* renamed from: b */
    public long f13849b;
    /* renamed from: c */
    public long f13850c;
    /* renamed from: d */
    public long f13851d;
    /* renamed from: e */
    public long f13852e;
    /* renamed from: f */
    public long f13853f;
    /* renamed from: g */
    public int f13854g = 0;
    /* renamed from: h */
    public int f13855h = 0;
    /* renamed from: i */
    public String f13856i = PageSource.UNKNOWN.mPageName;
    /* renamed from: j */
    public long f13857j = -1;
    /* renamed from: k */
    public int f13858k;
    /* renamed from: l */
    public int f13859l;
    /* renamed from: m */
    public int f13860m = 0;
    /* renamed from: n */
    public JSONArray f13861n;
    /* renamed from: o */
    public JSONArray f13862o;
    /* renamed from: p */
    public String f13863p;
    /* renamed from: q */
    public String f13864q;
    /* renamed from: r */
    public long f13865r;
    /* renamed from: s */
    public long f13866s;
    /* renamed from: t */
    private String f13867t;
    /* renamed from: u */
    private long f13868u;
    /* renamed from: v */
    private String f13869v;
    /* renamed from: w */
    private long f13870w;
    /* renamed from: x */
    private long f13871x;
    /* renamed from: y */
    private long f13872y;
    /* renamed from: z */
    private long f13873z;

    /* renamed from: com.kwad.sdk.core.g.i$a */
    public static final class C4157a implements C4321b {
        /* renamed from: a */
        private int f13874a;
        /* renamed from: b */
        private int f13875b;

        /* renamed from: a */
        public static C4157a m17210a() {
            C4157a aVar = new C4157a();
            aVar.f13874a = C4158b.f13876a;
            aVar.f13875b = C4158b.f13877b;
            return aVar;
        }

        /* renamed from: a */
        public void mo23859a(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.f13874a = jSONObject.optInt("posIdWidth");
                    this.f13875b = jSONObject.optInt("posIdHeight");
                } catch (Exception e) {
                    C4065b.m16865a(e);
                }
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15749a(jSONObject, "posIdWidth", this.f13874a);
            C3800e.m15749a(jSONObject, "posIdHeight", this.f13875b);
            return jSONObject;
        }
    }

    /* renamed from: com.kwad.sdk.core.g.i$b */
    public static class C4158b {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static int f13876a;
        /* access modifiers changed from: private|static */
        /* renamed from: b */
        public static int f13877b;

        /* renamed from: a */
        public static void m17213a(int i) {
            f13876a = i;
        }

        /* renamed from: b */
        public static void m17215b(int i) {
            f13877b = i;
        }
    }

    C4156i() {
    }

    C4156i(C4142a aVar) {
        this.f13872y = aVar.f13809b;
        this.f13867t = UUID.randomUUID().toString();
        this.f13868u = System.currentTimeMillis();
        this.f13869v = C4160k.m17227b();
        this.f13870w = C4160k.m17228c();
        this.f13871x = C4160k.m17230e();
        this.f13848a = aVar.mo23843a();
        this.f13850c = aVar.f13810c;
        this.f13851d = aVar.f13811d;
        this.f13852e = aVar.f13812e;
        this.f13853f = aVar.f13813f;
        this.f13854g = aVar.f13814g;
        this.f13855h = aVar.f13815h;
        this.f13858k = aVar.f13816i;
        this.f13859l = aVar.f13817j;
        this.f13860m = aVar.f13818k;
        this.f13861n = aVar.f13819l;
        this.f13862o = aVar.f13820m;
        this.f13863p = aVar.f13821n;
        this.f13864q = aVar.f13822o;
        this.f13865r = aVar.f13823p;
        this.f13866s = aVar.f13824q;
        AdTemplate adTemplate = aVar.f13808a;
        if (adTemplate != null) {
            this.f13873z = C4324c.m17667d(adTemplate);
            this.f13842A = C4324c.m17665b(adTemplate);
            this.f13843B = C4324c.m17666c(adTemplate);
            int i = this.f13843B;
            if (i == 1) {
                this.f13844C = C4325d.m17680i(adTemplate.photoInfo);
                this.f13849b = C4325d.m17673b(adTemplate.photoInfo).longValue();
                this.f13845D = C4325d.m17684m(adTemplate.photoInfo);
                this.f13846E = C4325d.m17681j(adTemplate.photoInfo);
            } else if (i == 2) {
                this.f13844C = C4322a.m17641i(C4324c.m17668e(adTemplate));
                this.f13849b = (long) (C4322a.m17633b(C4324c.m17668e(adTemplate)) * 1000);
            }
            long j = this.f13842A;
            if (adTemplate instanceof CacheTemplate) {
                j = ((CacheTemplate) adTemplate).mMirroPosId;
            }
            PageScene a = C4331a.m17707a().mo24479a(j);
            if (a != null) {
                this.f13857j = a.f14235a.posId;
                this.f13856i = a.f14236b.mPageName;
            }
        }
        this.f13847F = C4157a.m17210a();
    }

    public C4156i(String str) {
        try {
            mo23857a(new JSONObject(str));
        } catch (JSONException e) {
            C4065b.m16865a(e);
        }
    }

    /* renamed from: a */
    public static C4156i m17208a(C4142a aVar) {
        return new C4156i(aVar);
    }

    /* renamed from: a */
    public void mo23857a(JSONObject jSONObject) {
        String str = "clientExt";
        String str2 = "coverUrl";
        String str3 = "appUninstalled";
        String str4 = "appInstalled";
        String str5 = "sessionId";
        String str6 = "actionId";
        if (jSONObject != null) {
            try {
                this.f13872y = jSONObject.optLong("actionType");
                if (jSONObject.has(str6)) {
                    this.f13867t = jSONObject.optString(str6);
                }
                this.f13868u = jSONObject.optLong(C7881a.TIMESTAMP);
                if (jSONObject.has(str5)) {
                    this.f13869v = jSONObject.optString(str5);
                }
                this.f13870w = jSONObject.optLong("seq");
                this.f13871x = jSONObject.optLong("listId");
                this.f13848a = jSONObject.optLong("position");
                this.f13864q = jSONObject.optString("entryId");
                this.f13850c = jSONObject.optLong("effectivePlayDuration");
                this.f13851d = jSONObject.optLong("playDuration");
                this.f13852e = jSONObject.optLong("startDuration");
                this.f13853f = jSONObject.optLong("stayDuration");
                this.f13854g = jSONObject.optInt("enterType");
                this.f13855h = jSONObject.optInt("leaveType");
                this.f13858k = jSONObject.optInt("likeStatus");
                this.f13859l = jSONObject.optInt("likeType");
                this.f13860m = jSONObject.optInt("shareResult");
                if (jSONObject.has(str4)) {
                    this.f13861n = jSONObject.optJSONArray(str4);
                }
                if (jSONObject.has(str3)) {
                    this.f13862o = jSONObject.optJSONArray(str3);
                }
                if (jSONObject.has(str2)) {
                    this.f13863p = jSONObject.optString(str2);
                }
                this.f13873z = jSONObject.optLong("llsid");
                this.f13842A = jSONObject.optLong("posId");
                this.f13843B = jSONObject.optInt("contentType");
                this.f13844C = jSONObject.optLong("photoId");
                this.f13849b = jSONObject.optLong("photoDuration");
                this.f13845D = jSONObject.optLong("authorId");
                this.f13857j = (long) jSONObject.optInt("referPosId");
                this.f13856i = jSONObject.optString("referPage");
                this.f13865r = jSONObject.optLong("commentId");
                this.f13866s = jSONObject.optLong("seenCount");
                if (jSONObject.has(str)) {
                    this.f13847F = new C4157a();
                    this.f13847F.mo23859a(jSONObject.optJSONObject(str));
                }
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15752a(jSONObject, "actionId", this.f13867t);
        C3800e.m15750a(jSONObject, C7881a.TIMESTAMP, this.f13868u);
        C3800e.m15752a(jSONObject, "sessionId", this.f13869v);
        C3800e.m15750a(jSONObject, "seq", this.f13870w);
        C3800e.m15750a(jSONObject, "listId", this.f13871x);
        C3800e.m15750a(jSONObject, "position", this.f13848a);
        C3800e.m15752a(jSONObject, "entryId", this.f13864q);
        C3800e.m15750a(jSONObject, "actionType", this.f13872y);
        C3800e.m15750a(jSONObject, "llsid", this.f13873z);
        C3800e.m15750a(jSONObject, "posId", this.f13842A);
        C3800e.m15749a(jSONObject, "contentType", this.f13843B);
        C3800e.m15750a(jSONObject, "photoId", this.f13844C);
        C3800e.m15750a(jSONObject, "photoDuration", this.f13849b);
        C3800e.m15750a(jSONObject, "startDuration", this.f13852e);
        C3800e.m15750a(jSONObject, "playDuration", this.f13851d);
        C3800e.m15750a(jSONObject, "stayDuration", this.f13853f);
        C3800e.m15750a(jSONObject, "effectivePlayDuration", this.f13850c);
        C3800e.m15749a(jSONObject, "enterType", this.f13854g);
        C3800e.m15749a(jSONObject, "leaveType", this.f13855h);
        C3800e.m15752a(jSONObject, "referPage", this.f13856i);
        C3800e.m15750a(jSONObject, "referPosId", this.f13857j);
        C3800e.m15750a(jSONObject, "authorId", this.f13845D);
        C3800e.m15749a(jSONObject, "likeStatus", this.f13858k);
        C3800e.m15749a(jSONObject, "likeType", this.f13859l);
        C3800e.m15749a(jSONObject, "shareResult", this.f13860m);
        JSONArray jSONArray = this.f13861n;
        if (jSONArray != null) {
            C3800e.m15754a(jSONObject, "appInstalled", jSONArray);
        }
        JSONArray jSONArray2 = this.f13862o;
        if (jSONArray2 != null) {
            C3800e.m15754a(jSONObject, "appUninstalled", jSONArray2);
        }
        C3800e.m15752a(jSONObject, "coverUrl", this.f13863p);
        C3800e.m15750a(jSONObject, "commentId", this.f13865r);
        C3800e.m15750a(jSONObject, "seenCount", this.f13866s);
        C3800e.m15752a(jSONObject, "recoExt", this.f13846E);
        C4157a aVar = this.f13847F;
        if (aVar != null) {
            C3800e.m15751a(jSONObject, "clientExt", (C4321b) aVar);
        }
        return jSONObject;
    }
}
