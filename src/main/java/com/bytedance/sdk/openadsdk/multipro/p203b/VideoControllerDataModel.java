package com.bytedance.sdk.openadsdk.multipro.p203b;

import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.b.a */
public class VideoControllerDataModel {
    /* renamed from: a */
    public boolean f9080a;
    /* renamed from: b */
    public boolean f9081b;
    /* renamed from: c */
    public boolean f9082c;
    /* renamed from: d */
    public boolean f9083d;
    /* renamed from: e */
    public long f9084e;
    /* renamed from: f */
    public long f9085f;
    /* renamed from: g */
    public long f9086g;

    /* compiled from: VideoControllerDataModel */
    /* renamed from: com.bytedance.sdk.openadsdk.multipro.b.a$a */
    public interface C2523a {
        /* renamed from: a */
        VideoControllerDataModel mo15044a();
    }

    /* renamed from: a */
    public VideoControllerDataModel mo16887a(boolean z) {
        this.f9083d = z;
        return this;
    }

    /* renamed from: b */
    public VideoControllerDataModel mo16890b(boolean z) {
        this.f9080a = z;
        return this;
    }

    /* renamed from: c */
    public VideoControllerDataModel mo16892c(boolean z) {
        this.f9081b = z;
        return this;
    }

    /* renamed from: d */
    public VideoControllerDataModel mo16893d(boolean z) {
        this.f9082c = z;
        return this;
    }

    /* renamed from: a */
    public VideoControllerDataModel mo16886a(long j) {
        this.f9084e = j;
        return this;
    }

    /* renamed from: b */
    public VideoControllerDataModel mo16889b(long j) {
        this.f9085f = j;
        return this;
    }

    /* renamed from: c */
    public VideoControllerDataModel mo16891c(long j) {
        this.f9086g = j;
        return this;
    }

    /* renamed from: a */
    public JSONObject mo16888a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.f9080a);
            jSONObject.put("isFromVideoDetailPage", this.f9081b);
            jSONObject.put("isFromDetailPage", this.f9082c);
            jSONObject.put("duration", this.f9084e);
            jSONObject.put("totalPlayDuration", this.f9085f);
            jSONObject.put("currentPlayPosition", this.f9086g);
            jSONObject.put("isAutoPlay", this.f9083d);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static VideoControllerDataModel m11809a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        VideoControllerDataModel aVar = new VideoControllerDataModel();
        aVar.mo16890b(jSONObject.optBoolean("isCompleted"));
        aVar.mo16892c(jSONObject.optBoolean("isFromVideoDetailPage"));
        aVar.mo16893d(jSONObject.optBoolean("isFromDetailPage"));
        aVar.mo16886a(jSONObject.optLong("duration"));
        aVar.mo16889b(jSONObject.optLong("totalPlayDuration"));
        aVar.mo16891c(jSONObject.optLong("currentPlayPosition"));
        aVar.mo16887a(jSONObject.optBoolean("isAutoPlay"));
        return aVar;
    }
}
