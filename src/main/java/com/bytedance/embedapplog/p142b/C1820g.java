package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.C1851c;
import com.bytedance.embedapplog.util.C1856h;
import com.tencent.stat.apkreader.ChannelReader;
import com.tencent.stat.common.DeviceInfo;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.g */
class C1820g extends C1816c {
    /* renamed from: e */
    private final Context f5101e;
    /* renamed from: f */
    private final C1821h f5102f;

    C1820g(Context context, C1821h hVar) {
        super(false, false);
        this.f5101e = context;
        this.f5102f = hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        jSONObject.put("sdk_version", 336);
        jSONObject.put("sdk_version_name", "3.4.0-rc.1-embed");
        jSONObject.put(ChannelReader.CHANNEL_KEY, this.f5102f.mo13411n());
        C1822i.m6381a(jSONObject, DeviceInfo.TAG_ANDROID_ID, this.f5102f.mo13410m());
        C1822i.m6381a(jSONObject, "release_build", this.f5102f.mo13369D());
        C1822i.m6381a(jSONObject, "app_region", this.f5102f.mo13414q());
        C1822i.m6381a(jSONObject, "app_language", this.f5102f.mo13413p());
        C1822i.m6381a(jSONObject, "user_agent", this.f5102f.mo13370E());
        C1822i.m6381a(jSONObject, "ab_sdk_version", this.f5102f.mo13416s());
        C1822i.m6381a(jSONObject, "ab_version", this.f5102f.mo13420w());
        C1822i.m6381a(jSONObject, "aliyun_uuid", this.f5102f.mo13386a());
        String o = this.f5102f.mo13412o();
        if (TextUtils.isEmpty(o)) {
            o = C1851c.m6562a(this.f5101e, this.f5102f);
        }
        if (!TextUtils.isEmpty(o)) {
            C1822i.m6381a(jSONObject, "google_aid", o);
        }
        String C = this.f5102f.mo13368C();
        if (!TextUtils.isEmpty(C)) {
            try {
                jSONObject.put("app_track", new JSONObject(C));
            } catch (Throwable th) {
                C1856h.m6582a(th);
            }
        }
        String r = this.f5102f.mo13415r();
        if (r != null && r.length() > 0) {
            jSONObject.put("custom", new JSONObject(r));
        }
        C1822i.m6381a(jSONObject, "user_unique_id", this.f5102f.mo13417t());
        return true;
    }
}
