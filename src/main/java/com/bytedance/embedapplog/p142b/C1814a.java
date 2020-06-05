package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.C1856h;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.a */
class C1814a extends C1816c {
    /* renamed from: e */
    private final Context f5091e;
    /* renamed from: f */
    private final C1821h f5092f;

    C1814a(Context context, C1821h hVar) {
        super(true, false);
        this.f5091e = context;
        this.f5092f = hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f5092f.mo13378M())) {
            jSONObject.put("ab_client", this.f5092f.mo13378M());
        }
        if (!TextUtils.isEmpty(this.f5092f.mo13420w())) {
            if (C1856h.f5226b) {
                StringBuilder sb = new StringBuilder();
                sb.append("init config has abversion:");
                sb.append(this.f5092f.mo13420w());
                C1856h.m6581a(sb.toString(), null);
            }
            jSONObject.put("ab_version", this.f5092f.mo13420w());
        }
        if (!TextUtils.isEmpty(this.f5092f.mo13379N())) {
            jSONObject.put("ab_group", this.f5092f.mo13379N());
        }
        if (!TextUtils.isEmpty(this.f5092f.mo13380O())) {
            jSONObject.put("ab_feature", this.f5092f.mo13380O());
        }
        return true;
    }
}
