package com.bytedance.sdk.openadsdk.core.p170d;

import com.tencent.p605ep.commonbase.software.AppEntity;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.d.r */
public class VideoInfo {
    /* renamed from: a */
    private int f7486a;
    /* renamed from: b */
    private int f7487b;
    /* renamed from: c */
    private long f7488c;
    /* renamed from: d */
    private double f7489d;
    /* renamed from: e */
    private String f7490e;
    /* renamed from: f */
    private String f7491f;
    /* renamed from: g */
    private String f7492g;
    /* renamed from: h */
    private String f7493h;
    /* renamed from: i */
    private String f7494i;
    /* renamed from: j */
    private String f7495j;
    /* renamed from: k */
    private int f7496k = 0;
    /* renamed from: l */
    private int f7497l = 0;

    /* renamed from: a */
    public int mo15585a() {
        return this.f7486a;
    }

    /* renamed from: a */
    public void mo15587a(int i) {
        this.f7486a = i;
    }

    /* renamed from: b */
    public int mo15590b() {
        return this.f7487b;
    }

    /* renamed from: b */
    public void mo15591b(int i) {
        this.f7487b = i;
    }

    /* renamed from: c */
    public long mo15593c() {
        return this.f7488c;
    }

    /* renamed from: a */
    public void mo15588a(long j) {
        this.f7488c = j;
    }

    /* renamed from: d */
    public double mo15596d() {
        return this.f7489d;
    }

    /* renamed from: a */
    public void mo15586a(double d) {
        this.f7489d = d;
    }

    /* renamed from: e */
    public String mo15599e() {
        return this.f7490e;
    }

    /* renamed from: a */
    public void mo15589a(String str) {
        this.f7490e = str;
    }

    /* renamed from: f */
    public String mo15601f() {
        return this.f7491f;
    }

    /* renamed from: b */
    public void mo15592b(String str) {
        this.f7491f = str;
    }

    /* renamed from: g */
    public String mo15603g() {
        return this.f7492g;
    }

    /* renamed from: c */
    public void mo15595c(String str) {
        this.f7492g = str;
    }

    /* renamed from: h */
    public String mo15604h() {
        return this.f7493h;
    }

    /* renamed from: d */
    public void mo15598d(String str) {
        this.f7493h = str;
    }

    /* renamed from: i */
    public String mo15605i() {
        return this.f7494i;
    }

    /* renamed from: e */
    public void mo15600e(String str) {
        this.f7494i = str;
    }

    /* renamed from: j */
    public String mo15606j() {
        return this.f7495j;
    }

    /* renamed from: f */
    public void mo15602f(String str) {
        this.f7495j = str;
    }

    /* renamed from: k */
    public JSONObject mo15607k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", mo15585a());
            jSONObject.put("cover_url", mo15601f());
            jSONObject.put("cover_width", mo15590b());
            jSONObject.put("endcard", mo15604h());
            jSONObject.put("file_hash", mo15606j());
            jSONObject.put("resolution", mo15599e());
            jSONObject.put(AppEntity.KEY_SIZE_LONG, mo15593c());
            jSONObject.put("video_duration", mo15596d());
            jSONObject.put("video_url", mo15603g());
            jSONObject.put("playable_download_url", mo15605i());
            jSONObject.put("if_playable_loading_show", mo15608l());
            jSONObject.put("remove_loading_page_type", mo15609m());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: l */
    public int mo15608l() {
        return this.f7496k;
    }

    /* renamed from: c */
    public void mo15594c(int i) {
        this.f7496k = i;
    }

    /* renamed from: m */
    public int mo15609m() {
        return this.f7497l;
    }

    /* renamed from: d */
    public void mo15597d(int i) {
        this.f7497l = i;
    }
}
