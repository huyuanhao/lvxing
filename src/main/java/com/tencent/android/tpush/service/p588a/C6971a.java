package com.tencent.android.tpush.service.p588a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.kwad.sdk.core.response.model.AdConfigData;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.a.a */
public class C6971a {
    /* renamed from: L */
    private static volatile C6971a f23129L;
    /* renamed from: A */
    public int f23130A = 60000;
    /* renamed from: B */
    public int f23131B = 1;
    /* renamed from: C */
    public int f23132C = 1;
    /* renamed from: D */
    public int f23133D = 1;
    /* renamed from: E */
    public int f23134E = -1;
    /* renamed from: F */
    public int f23135F = -1;
    /* renamed from: G */
    public int f23136G = -1;
    /* renamed from: H */
    public int f23137H = -1;
    /* renamed from: I */
    public String f23138I = "xiaomi";
    /* renamed from: J */
    public JSONArray f23139J = null;
    /* renamed from: K */
    public Map<String, String> f23140K;
    /* renamed from: M */
    private Context f23141M = null;
    /* renamed from: a */
    public long f23142a;
    /* renamed from: b */
    public int f23143b;
    /* renamed from: c */
    public int f23144c;
    /* renamed from: d */
    public int f23145d;
    /* renamed from: e */
    public int f23146e;
    /* renamed from: f */
    public int f23147f;
    /* renamed from: g */
    public int f23148g;
    /* renamed from: h */
    public int f23149h;
    /* renamed from: i */
    public int f23150i;
    /* renamed from: j */
    public int f23151j;
    /* renamed from: k */
    public int f23152k;
    /* renamed from: l */
    public int f23153l;
    /* renamed from: m */
    public int f23154m;
    /* renamed from: n */
    public int f23155n;
    /* renamed from: o */
    public int f23156o;
    /* renamed from: p */
    public int f23157p;
    /* renamed from: q */
    public int f23158q;
    /* renamed from: r */
    public int f23159r;
    /* renamed from: s */
    public int f23160s;
    /* renamed from: t */
    public int f23161t;
    /* renamed from: u */
    public String f23162u;
    /* renamed from: v */
    public int f23163v;
    /* renamed from: w */
    public int f23164w;
    /* renamed from: x */
    public String f23165x = null;
    /* renamed from: y */
    public int f23166y = 1;
    /* renamed from: z */
    public int f23167z = 1;

    private C6971a(Context context) {
        this.f23141M = context.getApplicationContext();
        mo33278a();
    }

    /* renamed from: a */
    public static C6971a m29749a(Context context) {
        if (f23129L == null) {
            synchronized (C6971a.class) {
                if (f23129L == null) {
                    f23129L = new C6971a(context);
                }
            }
        }
        return f23129L;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConfigurationManager [context=");
        sb.append(this.f23141M);
        sb.append(", configurationVersion=");
        sb.append(this.f23142a);
        sb.append(", receiveTimeout=");
        sb.append(this.f23143b);
        sb.append(", heartbeatInterval=");
        sb.append(this.f23144c);
        sb.append(", httpHeartbeatInterval=");
        sb.append(this.f23145d);
        sb.append(", speedTestInterval=");
        sb.append(this.f23146e);
        sb.append(", channelMessageExpires=");
        sb.append(this.f23147f);
        sb.append(", freqencySuccess=");
        sb.append(this.f23148g);
        sb.append(", freqencyFailed=");
        sb.append(this.f23149h);
        sb.append(", reportInterval=");
        sb.append(this.f23150i);
        sb.append(", reportMaxCount=");
        sb.append(this.f23151j);
        sb.append(", httpRetryCount=");
        sb.append(this.f23152k);
        sb.append(", ackMaxCount=");
        sb.append(this.f23153l);
        sb.append(", ackDuration=");
        sb.append(this.f23154m);
        sb.append(", loadIpInerval=");
        sb.append(this.f23155n);
        sb.append(", redirectConnectTimeOut=");
        sb.append(this.f23156o);
        sb.append(", redirectSoTimeOut=");
        sb.append(this.f23157p);
        sb.append(", strategyExpiredTime=");
        sb.append(this.f23158q);
        sb.append(", logLevel=");
        sb.append(this.f23159r);
        sb.append(", logFileSizeLimit=");
        sb.append(this.f23160s);
        sb.append(", errCount=");
        sb.append(this.f23161t);
        sb.append(", logUploadDomain=");
        sb.append(this.f23162u);
        sb.append(", rptLive=");
        sb.append(this.f23163v);
        sb.append(", rptLiveIntvl=");
        sb.append(this.f23164w);
        sb.append(", disableXG=");
        sb.append(this.f23165x);
        sb.append(", enableNewWd=");
        sb.append(this.f23166y);
        sb.append(", enableMonitor=");
        sb.append(this.f23167z);
        sb.append(", monitorFreg=");
        sb.append(this.f23130A);
        sb.append(", enableReport=");
        sb.append(this.f23131B);
        sb.append(", abTestVersion=");
        sb.append(this.f23132C);
        sb.append(", isHttpDNSEnable=");
        sb.append(this.f23133D);
        sb.append(", isLBSEnable=");
        sb.append(this.f23134E);
        sb.append(", isAPPListEnable=");
        sb.append(this.f23135F);
        sb.append(", isNotificatiobStatusEnable=");
        sb.append(this.f23136G);
        sb.append(", isQgameEnable=");
        sb.append(this.f23137H);
        sb.append(", pullup_Arr_ProviderAndActivty=");
        sb.append(this.f23139J);
        sb.append(", pullup_packges_map=");
        sb.append(this.f23140K);
        sb.append(", wakeupCtrl=");
        sb.append(this.f23138I);
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo33278a() {
        if (this.f23142a == 0) {
            this.f23142a = mo33281b();
            this.f23143b = mo33275a("recTo", (int) C7120a.MAX_USERDATA_VALUE_LENGTH);
            this.f23144c = mo33275a("hbIntvl", 299980);
            this.f23145d = mo33275a("httpHbIntvl", 600000);
            this.f23146e = mo33275a("stIntvl", 54000000);
            this.f23147f = mo33275a("cnMsgExp", 60000);
            this.f23148g = mo33275a("fqcSuc", 10);
            this.f23149h = mo33275a("fqcFal", 100);
            this.f23150i = mo33275a("rptIntvl", 1200);
            this.f23151j = mo33275a("rptMaxCnt", 5);
            this.f23152k = mo33275a("httpRtCnt", 3);
            this.f23153l = mo33275a("ackMaxCnt", 3);
            this.f23154m = mo33275a("ackDuration", 180000);
            this.f23155n = mo33275a("loadIpIntvl", 72000000);
            this.f23135F = mo33275a("conf_applist", -1);
            this.f23134E = mo33275a("conf_lbs", -1);
            this.f23136G = mo33275a("conf_nt_status", -1);
            this.f23156o = mo33275a("redirectConnectTime", (int) C7120a.MAX_USERDATA_VALUE_LENGTH);
            this.f23157p = mo33275a("redirectSoTime", (int) BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
            this.f23158q = mo33275a("strategyExpiredTime", 1440);
            this.f23163v = mo33275a("rptLive", 0);
            this.f23164w = mo33275a("rptLiveIntvl", (int) AdConfigData.DEFAULT_REQUEST_INTERVAL);
            this.f23160s = mo33275a("logFileSizeLimit", 262144);
            this.f23161t = mo33275a("errCount", 5);
            this.f23162u = mo33277a("logUploadDomain", "183.61.46.193");
            String str = "";
            this.f23165x = mo33277a("stopXG", str);
            String a = mo33277a("pullup_packges", str);
            if (!C6914l.m29521c(a)) {
                String decrypt = Rijndael.decrypt(a);
                if (!C6914l.m29521c(decrypt)) {
                    this.f23140K = mo33283b(decrypt);
                }
            }
            this.f23166y = mo33275a("enableNewWd", 1);
            this.f23131B = mo33275a("report", 1);
            this.f23132C = mo33275a("ABT", 1);
            this.f23167z = mo33275a("enable.monitor", 1);
            this.f23130A = mo33275a("m.freq", 60000);
            this.f23133D = mo33275a("httpdns", 1);
            this.f23137H = mo33275a("conf_qgame", -1);
            this.f23138I = mo33277a("wakeupCtr", "xiaomi");
            try {
                String a2 = mo33277a("conf_pull_arr", str);
                if (!C6914l.m29521c(a2)) {
                    String decrypt2 = Rijndael.decrypt(a2);
                    if (!C6914l.m29521c(decrypt2)) {
                        this.f23139J = new JSONArray(decrypt2);
                    }
                }
            } catch (Throwable th) {
                C6864a.m29302d(Constants.ServiceLogTag, "pullup_Arr_ProviderAndActivty.", th);
            }
        }
    }

    private C6971a() {
    }

    /* renamed from: a */
    public void mo33280a(String str) {
        String str2 = "cnMsgExp";
        String str3 = "stIntvl";
        String str4 = "httpHbIntvl";
        String str5 = "hbIntvl";
        String str6 = "recTo";
        String str7 = "confVer";
        String str8 = Constants.ServiceLogTag;
        String str9 = "conf_pull_arr";
        String str10 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f23142a = (long) mo33276a(str7, jSONObject);
            this.f23142a = this.f23142a == 0 ? 1 : this.f23142a;
            this.f23143b = mo33276a(str6, jSONObject) * 1000;
            int i = this.f23143b;
            int i2 = C7120a.MAX_USERDATA_VALUE_LENGTH;
            this.f23143b = i == 0 ? C7120a.MAX_USERDATA_VALUE_LENGTH : this.f23143b;
            this.f23144c = mo33276a(str5, jSONObject) * 60 * 1000;
            this.f23144c = this.f23144c == 0 ? 299980 : this.f23144c;
            this.f23145d = mo33276a(str4, jSONObject) * 60 * 1000;
            this.f23145d = this.f23145d == 0 ? 600000 : this.f23145d;
            this.f23146e = mo33276a(str3, jSONObject) * 60 * 1000;
            this.f23146e = this.f23146e == 0 ? 54000000 : this.f23146e;
            this.f23147f = mo33276a(str2, jSONObject) * 1000;
            this.f23147f = this.f23147f == 0 ? 60000 : this.f23147f;
            this.f23148g = mo33276a("fqcSuc", jSONObject);
            this.f23148g = this.f23148g == 0 ? 10 : this.f23148g;
            this.f23149h = mo33276a("fqcFal", jSONObject);
            this.f23149h = this.f23149h == 0 ? 100 : this.f23149h;
            this.f23150i = mo33276a("rptIntvl", jSONObject);
            this.f23150i = this.f23150i == 0 ? 1200 : this.f23150i;
            this.f23151j = mo33276a("rptMaxCnt", jSONObject);
            this.f23151j = this.f23151j == 0 ? 5 : this.f23151j;
            this.f23152k = mo33276a("httpRtCnt", jSONObject);
            this.f23152k = this.f23152k == 0 ? 3 : this.f23152k;
            this.f23153l = mo33276a("ackMaxCnt", jSONObject);
            this.f23153l = this.f23153l == 0 ? 3 : this.f23153l;
            this.f23154m = mo33276a("ackDuration", jSONObject) * 1000;
            this.f23154m = this.f23154m == 0 ? 180000 : this.f23154m;
            this.f23155n = mo33276a("loadIpIntvl", jSONObject) * 60 * 60 * 1000;
            this.f23155n = this.f23155n == 0 ? 72000000 : this.f23155n;
            this.f23156o = mo33276a("redirectConnectTime", jSONObject);
            if (this.f23156o != 0) {
                i2 = this.f23156o;
            }
            this.f23156o = i2;
            this.f23157p = mo33276a("redirectSoTime", jSONObject);
            this.f23157p = this.f23157p == 0 ? BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT : this.f23157p;
            this.f23158q = mo33276a("strategyExpiredTime", jSONObject);
            this.f23158q = this.f23158q == 0 ? 1440 : this.f23158q;
            this.f23163v = mo33276a("rptLive", jSONObject);
            this.f23163v = this.f23163v == 0 ? 0 : this.f23163v;
            this.f23164w = mo33276a("rptLiveIntvl", jSONObject);
            this.f23164w = this.f23164w == 3600 ? AdConfigData.DEFAULT_REQUEST_INTERVAL : this.f23164w;
            this.f23159r = mo33276a("logLevel", jSONObject);
            this.f23160s = mo33276a("logFileSizeLimit", jSONObject) * 1024;
            this.f23160s = this.f23160s == 0 ? 262144 : this.f23160s;
            this.f23161t = mo33276a("errCount", jSONObject);
            this.f23161t = this.f23161t == 0 ? 5 : this.f23161t;
            this.f23162u = mo33282b("logUploadDomain", jSONObject);
            this.f23162u = TextUtils.isEmpty(this.f23162u) ? "183.61.46.193" : this.f23162u;
            this.f23166y = jSONObject.optInt("enableNewWd", 1);
            this.f23131B = jSONObject.optInt("report", 1);
            this.f23165x = jSONObject.optString("stopXG", null);
            this.f23132C = jSONObject.optInt("ABT", 1);
            this.f23167z = jSONObject.optInt("enable.monitor", 1);
            this.f23130A = jSONObject.optInt("m.freq", 60000);
            this.f23133D = jSONObject.optInt("httpdns", 1);
            this.f23135F = jSONObject.optInt("conf_applist", -1);
            this.f23134E = jSONObject.optInt("conf_lbs", -1);
            this.f23136G = jSONObject.optInt("conf_nt_status", -1);
            this.f23137H = jSONObject.optInt("conf_qgame", -1);
            this.f23138I = jSONObject.optString("wakeupCtr", "xiaomi");
            String optString = jSONObject.optString("st.kv", str10);
            String optString2 = jSONObject.optString("sp.kv", str10);
            String optString3 = jSONObject.optString("pullup_packges", str10);
            if (!C6914l.m29521c(optString3)) {
                this.f23140K = mo33283b(optString3);
                C6908h.m29487b(m29750c(), mo33284c("pullup_packges"), Rijndael.encrypt(optString3));
            }
            C6908h.m29486b(m29750c(), mo33284c(str7), this.f23142a);
            C6908h.m29485b(m29750c(), mo33284c(str6), this.f23143b);
            C6908h.m29485b(m29750c(), mo33284c(str5), this.f23144c);
            C6908h.m29485b(m29750c(), mo33284c(str4), this.f23145d);
            C6908h.m29485b(m29750c(), mo33284c(str3), this.f23146e);
            C6908h.m29485b(m29750c(), mo33284c(str2), this.f23147f);
            C6908h.m29485b(m29750c(), mo33284c("fqcSuc"), this.f23148g);
            C6908h.m29485b(m29750c(), mo33284c("fqcFal"), this.f23149h);
            C6908h.m29485b(m29750c(), mo33284c("rptIntvl"), this.f23150i);
            C6908h.m29485b(m29750c(), mo33284c("rptMaxCnt"), this.f23151j);
            C6908h.m29485b(m29750c(), mo33284c("httpRtCnt"), this.f23152k);
            C6908h.m29485b(m29750c(), mo33284c("ackMaxCnt"), this.f23153l);
            C6908h.m29485b(m29750c(), mo33284c("ackDuration"), this.f23154m);
            C6908h.m29485b(m29750c(), mo33284c("loadIpIntvl"), this.f23155n);
            C6908h.m29485b(m29750c(), mo33284c("redirectConnectTime"), this.f23156o);
            C6908h.m29485b(m29750c(), mo33284c("redirectSoTime"), this.f23157p);
            C6908h.m29485b(m29750c(), mo33284c("strategyExpiredTime"), this.f23158q);
            C6908h.m29485b(m29750c(), mo33284c("rptLive"), this.f23163v);
            C6908h.m29485b(m29750c(), mo33284c("rptLiveIntvl"), this.f23164w);
            C6908h.m29485b(m29750c(), mo33284c("logLevel"), this.f23159r);
            C6908h.m29485b(m29750c(), mo33284c("logFileSizeLimit"), this.f23160s);
            C6908h.m29485b(m29750c(), mo33284c("errCount"), this.f23161t);
            C6908h.m29485b(m29750c(), mo33284c("conf_applist"), this.f23135F);
            C6908h.m29485b(m29750c(), mo33284c("conf_lbs"), this.f23134E);
            C6908h.m29485b(m29750c(), mo33284c("conf_nt_status"), this.f23136G);
            C6908h.m29485b(m29750c(), mo33284c("conf_qgame"), this.f23137H);
            if (!C7056i.m30194b(this.f23165x)) {
                C6908h.m29487b(m29750c(), mo33284c("stopXG"), Rijndael.encrypt(this.f23165x));
            }
            C6908h.m29485b(m29750c(), mo33284c("enableNewWd"), this.f23166y);
            C6908h.m29485b(m29750c(), mo33284c("report"), this.f23131B);
            C6908h.m29485b(m29750c(), mo33284c("enable.monitor"), this.f23167z);
            C6908h.m29485b(m29750c(), mo33284c("m.freq"), this.f23130A);
            C6908h.m29485b(m29750c(), mo33284c("httpdns"), this.f23133D);
            C6908h.m29487b(m29750c(), mo33284c("wakeupCtr"), this.f23138I);
            if (!TextUtils.isEmpty(optString)) {
                C6972b.m29762b(m29750c(), optString);
            }
            if (!TextUtils.isEmpty(optString2)) {
                C6972b.m29761a(m29750c(), optString2);
            }
            this.f23139J = jSONObject.optJSONArray(str9);
            if (this.f23139J != null && this.f23139J.length() > 0) {
                C6908h.m29487b(m29750c(), mo33284c(str9), Rijndael.encrypt(this.f23139J.toString()));
            } else if (this.f23139J != null && this.f23139J.length() == 0) {
                System.err.println("pullup_Arr_ProviderAndActivty length is 0 remove the old arr");
                this.f23139J = null;
                C6908h.m29484a(m29750c(), mo33284c(str9));
            }
        } catch (Throwable th) {
            C6864a.m29302d(str8, "parseValue failed.", th);
        }
    }

    /* renamed from: b */
    public long mo33281b() {
        Context context = this.f23141M;
        if (context != null) {
            return C6908h.m29481a(context, mo33284c("confVer"), 1);
        }
        return 1;
    }

    /* renamed from: a */
    public void mo33279a(long j) {
        if (this.f23141M != null && mo33281b() != j) {
            C6908h.m29486b(this.f23141M, mo33284c("confVer"), j);
        }
    }

    /* renamed from: b */
    public Map<String, String> mo33283b(String str) {
        try {
            if (C6914l.m29521c(str)) {
                return null;
            }
            String[] split = str.split(StorageInterface.KEY_SPLITER);
            if (split != null && split.length > 0) {
                HashMap hashMap = new HashMap();
                for (String split2 : split) {
                    String[] split3 = split2.split("/");
                    if (split3 != null && split3.length >= 2) {
                        hashMap.put(split3[0], split3[1]);
                    }
                }
                return hashMap;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private Context m29750c() {
        Context context = this.f23141M;
        if (context != null) {
            return context;
        }
        if (C6973b.m29776f() != null) {
            this.f23141M = C6973b.m29776f();
            return this.f23141M;
        }
        if (this.f23141M == null && XGPushManager.getContext() != null) {
            this.f23141M = XGPushManager.getContext();
        }
        return this.f23141M;
    }

    /* renamed from: a */
    public int mo33275a(String str, int i) {
        return C6908h.m29480a(m29750c(), mo33284c(str), i);
    }

    /* renamed from: a */
    public String mo33277a(String str, String str2) {
        String a = C6908h.m29483a(m29750c(), mo33284c(str), str2);
        return TextUtils.isEmpty(a) ? str2 : a;
    }

    /* renamed from: a */
    public int mo33276a(String str, JSONObject jSONObject) {
        if (jSONObject != null && !C7056i.m30194b(str)) {
            try {
                return jSONObject.getInt(str);
            } catch (Exception e) {
                C6864a.m29302d(Constants.ServiceLogTag, "getJsonInt", e);
            }
        }
        return 0;
    }

    /* renamed from: b */
    public String mo33282b(String str, JSONObject jSONObject) {
        if (jSONObject != null && !C7056i.m30194b(str)) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException e) {
                C6864a.m29302d(Constants.ServiceLogTag, "getJsonStr", e);
            }
        }
        return "";
    }

    /* renamed from: c */
    public String mo33284c(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("com.tencent.tpus.");
        sb.append(str);
        return sb.toString();
    }
}
