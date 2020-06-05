package com.bytedance.sdk.openadsdk.p190h.p196f;

import java.io.Serializable;

/* renamed from: com.bytedance.sdk.openadsdk.h.f.b */
public class VideoUrlModel implements Serializable {
    /* renamed from: a */
    public String f8890a;
    /* renamed from: b */
    public int f8891b = 204800;
    /* renamed from: c */
    public String f8892c;

    /* renamed from: a */
    public VideoUrlModel mo16772a(String str) {
        this.f8890a = str;
        return this;
    }

    /* renamed from: a */
    public VideoUrlModel mo16771a(int i) {
        if (i > 0) {
            this.f8891b = i;
        }
        return this;
    }

    /* renamed from: b */
    public VideoUrlModel mo16773b(String str) {
        this.f8892c = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoUrlModel{url='");
        sb.append(this.f8890a);
        sb.append('\'');
        sb.append(", maxPreloadSize=");
        sb.append(this.f8891b);
        sb.append(", fileNameKey='");
        sb.append(this.f8892c);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
