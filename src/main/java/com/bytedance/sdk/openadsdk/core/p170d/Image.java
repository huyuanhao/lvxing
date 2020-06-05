package com.bytedance.sdk.openadsdk.core.p170d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;

/* renamed from: com.bytedance.sdk.openadsdk.core.d.j */
public class Image {
    /* renamed from: a */
    private String f7398a;
    /* renamed from: b */
    private int f7399b;
    /* renamed from: c */
    private int f7400c;

    /* renamed from: a */
    public String mo15406a() {
        return this.f7398a;
    }

    /* renamed from: a */
    public void mo15408a(String str) {
        this.f7398a = str;
    }

    /* renamed from: b */
    public int mo15409b() {
        return this.f7399b;
    }

    /* renamed from: a */
    public void mo15407a(int i) {
        this.f7399b = i;
    }

    /* renamed from: c */
    public int mo15411c() {
        return this.f7400c;
    }

    /* renamed from: b */
    public void mo15410b(int i) {
        this.f7400c = i;
    }

    /* renamed from: d */
    public boolean mo15412d() {
        return !TextUtils.isEmpty(this.f7398a) && this.f7399b > 0 && this.f7400c > 0;
    }

    /* renamed from: a */
    public static TTImage m9324a(Image jVar) {
        if (jVar == null || !jVar.mo15412d()) {
            return null;
        }
        return new TTImage(jVar.mo15411c(), jVar.mo15409b(), jVar.mo15406a());
    }
}
