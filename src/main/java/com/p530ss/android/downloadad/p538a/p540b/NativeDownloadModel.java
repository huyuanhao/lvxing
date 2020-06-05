package com.p530ss.android.downloadad.p538a.p540b;

import com.p530ss.android.downloadad.p538a.p539a.AdDownloadModel;
import com.p530ss.android.downloadad.p538a.p539a.AdDownloadModel.C6529a;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadController;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;
import com.p530ss.android.p531a.p532a.p537d.C6519a;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadad.a.b.a */
public class NativeDownloadModel {
    /* renamed from: a */
    public AtomicBoolean f21245a;
    /* renamed from: b */
    private long f21246b;
    /* renamed from: c */
    private long f21247c;
    /* renamed from: d */
    private String f21248d;
    /* renamed from: e */
    private int f21249e;
    /* renamed from: f */
    private String f21250f;
    /* renamed from: g */
    private String f21251g;
    /* renamed from: h */
    private int f21252h;
    /* renamed from: i */
    private String f21253i;
    /* renamed from: j */
    private boolean f21254j;
    /* renamed from: k */
    private long f21255k;
    /* renamed from: l */
    private JSONObject f21256l;
    /* renamed from: m */
    private int f21257m;
    /* renamed from: n */
    private boolean f21258n;
    /* renamed from: o */
    private String f21259o;
    /* renamed from: p */
    private String f21260p;
    /* renamed from: q */
    private boolean f21261q;
    /* renamed from: r */
    private int f21262r;

    private NativeDownloadModel() {
        this.f21249e = 1;
        this.f21254j = true;
        this.f21258n = false;
        this.f21245a = new AtomicBoolean(false);
    }

    public NativeDownloadModel(C6507c cVar, DownloadEventConfig bVar, DownloadController aVar) {
        this(cVar, bVar, aVar, 0);
    }

    public NativeDownloadModel(C6507c cVar, DownloadEventConfig bVar, DownloadController aVar, int i) {
        this.f21249e = 1;
        this.f21254j = true;
        this.f21258n = false;
        this.f21245a = new AtomicBoolean(false);
        this.f21246b = cVar.mo31064d();
        this.f21247c = cVar.mo31065e();
        this.f21248d = cVar.mo31079s();
        this.f21250f = cVar.mo31080t();
        this.f21256l = cVar.mo31083w();
        this.f21254j = cVar.mo31078r();
        this.f21252h = cVar.mo31076p();
        this.f21253i = cVar.mo31077q();
        this.f21251g = cVar.mo31061a();
        this.f21259o = bVar.mo31048b();
        this.f21260p = bVar.mo31047a();
        this.f21261q = bVar.mo31059m();
        this.f21258n = aVar.mo31045c();
        this.f21257m = i;
        this.f21255k = System.currentTimeMillis();
    }

    /* renamed from: a */
    public long mo31194a() {
        return this.f21246b;
    }

    /* renamed from: a */
    public void mo31196a(long j) {
        this.f21246b = j;
    }

    /* renamed from: b */
    public long mo31200b() {
        return this.f21247c;
    }

    /* renamed from: b */
    public void mo31202b(long j) {
        this.f21247c = j;
    }

    /* renamed from: c */
    public int mo31205c() {
        return this.f21249e;
    }

    /* renamed from: a */
    public void mo31195a(int i) {
        this.f21249e = i;
    }

    /* renamed from: d */
    public String mo31210d() {
        return this.f21250f;
    }

    /* renamed from: a */
    public void mo31197a(String str) {
        this.f21250f = str;
    }

    /* renamed from: e */
    public long mo31213e() {
        return this.f21255k;
    }

    /* renamed from: c */
    public void mo31207c(long j) {
        this.f21255k = j;
    }

    /* renamed from: f */
    public String mo31215f() {
        return this.f21248d;
    }

    /* renamed from: b */
    public void mo31203b(String str) {
        this.f21248d = str;
    }

    /* renamed from: g */
    public boolean mo31217g() {
        return this.f21254j;
    }

    /* renamed from: a */
    public void mo31199a(boolean z) {
        this.f21254j = z;
    }

    /* renamed from: h */
    public JSONObject mo31218h() {
        return this.f21256l;
    }

    /* renamed from: a */
    public void mo31198a(JSONObject jSONObject) {
        this.f21256l = jSONObject;
    }

    /* renamed from: b */
    public void mo31201b(int i) {
        this.f21252h = i;
    }

    /* renamed from: c */
    public void mo31208c(String str) {
        this.f21253i = str;
    }

    /* renamed from: i */
    public int mo31219i() {
        return this.f21252h;
    }

    /* renamed from: j */
    public String mo31220j() {
        return this.f21253i;
    }

    /* renamed from: c */
    public void mo31206c(int i) {
        this.f21257m = i;
    }

    /* renamed from: k */
    public int mo31221k() {
        return this.f21257m;
    }

    /* renamed from: b */
    public void mo31204b(boolean z) {
        this.f21261q = z;
    }

    /* renamed from: l */
    public boolean mo31222l() {
        return this.f21261q;
    }

    /* renamed from: d */
    public void mo31211d(int i) {
        this.f21262r = i;
    }

    /* renamed from: m */
    public int mo31223m() {
        return this.f21262r;
    }

    /* renamed from: c */
    public void mo31209c(boolean z) {
        this.f21258n = z;
    }

    /* renamed from: n */
    public boolean mo31224n() {
        return this.f21258n;
    }

    /* renamed from: d */
    public void mo31212d(String str) {
        this.f21259o = str;
    }

    /* renamed from: o */
    public String mo31225o() {
        return this.f21259o;
    }

    /* renamed from: e */
    public void mo31214e(String str) {
        this.f21260p = str;
    }

    /* renamed from: p */
    public String mo31226p() {
        return this.f21260p;
    }

    /* renamed from: f */
    public void mo31216f(String str) {
        this.f21251g = str;
    }

    /* renamed from: q */
    public String mo31227q() {
        return this.f21251g;
    }

    /* renamed from: r */
    public JSONObject mo31228r() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.f21246b);
            jSONObject.put("mExtValue", this.f21247c);
            jSONObject.put("mLogExtra", this.f21248d);
            jSONObject.put("mDownloadStatus", this.f21249e);
            jSONObject.put("mPackageName", this.f21250f);
            jSONObject.put("mIsAd", this.f21254j);
            jSONObject.put("mTimeStamp", this.f21255k);
            jSONObject.put("mExtras", this.f21256l);
            jSONObject.put("mVersionCode", this.f21252h);
            jSONObject.put("mVersionName", this.f21253i);
            jSONObject.put("mDownloadId", this.f21257m);
            jSONObject.put("mIsV3Event", this.f21261q);
            jSONObject.put("mScene", this.f21262r);
            jSONObject.put("mEventTag", this.f21259o);
            jSONObject.put("mEventRefer", this.f21260p);
            jSONObject.put("mDownloadUrl", this.f21251g);
            jSONObject.put("mEnableBackDialog", this.f21258n);
            jSONObject.put("hasSendInstallFinish", this.f21245a.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: b */
    public static NativeDownloadModel m26068b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        NativeDownloadModel aVar = new NativeDownloadModel();
        try {
            aVar.mo31196a(C6519a.m25904a(jSONObject, "mId"));
            aVar.mo31202b(C6519a.m25904a(jSONObject, "mExtValue"));
            aVar.mo31203b(jSONObject.optString("mLogExtra"));
            aVar.mo31195a(jSONObject.optInt("mDownloadStatus"));
            aVar.mo31197a(jSONObject.optString("mPackageName"));
            aVar.mo31199a(jSONObject.optBoolean("mIsAd"));
            aVar.mo31207c(C6519a.m25904a(jSONObject, "mTimeStamp"));
            aVar.mo31201b(jSONObject.optInt("mVersionCode"));
            aVar.mo31208c(jSONObject.optString("mVersionName"));
            aVar.mo31206c(jSONObject.optInt("mDownloadId"));
            aVar.mo31204b(jSONObject.optBoolean("mIsV3Event"));
            aVar.mo31211d(jSONObject.optInt("mScene"));
            aVar.mo31212d(jSONObject.optString("mEventTag"));
            aVar.mo31214e(jSONObject.optString("mEventRefer"));
            aVar.mo31216f(jSONObject.optString("mDownloadUrl"));
            aVar.mo31209c(jSONObject.optBoolean("mEnableBackDialog"));
            aVar.f21245a = new AtomicBoolean(jSONObject.optBoolean("hasSendInstallFinish"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            aVar.mo31198a(jSONObject.optJSONObject("mExtras"));
        } catch (Exception unused) {
            aVar.mo31198a((JSONObject) null);
        }
        return aVar;
    }

    /* renamed from: a */
    public static JSONObject m26067a(NativeDownloadModel aVar) {
        if (aVar == null || aVar.mo31218h() == null) {
            return new JSONObject();
        }
        return aVar.mo31218h();
    }

    /* renamed from: s */
    public AdDownloadModel mo31229s() {
        return new C6529a().mo31177a(this.f21246b).mo31183b(this.f21247c).mo31179a(this.f21248d).mo31184b(this.f21250f).mo31180a(this.f21256l).mo31181a(this.f21254j).mo31176a(this.f21252h).mo31192g(this.f21253i).mo31188d(this.f21251g).mo31182a();
    }
}
