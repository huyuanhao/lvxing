package com.yanzhenjie.durban.model;

import android.graphics.Bitmap.CompressFormat;

/* renamed from: com.yanzhenjie.durban.model.a */
public class CropParameters {
    /* renamed from: a */
    private int f26498a;
    /* renamed from: b */
    private int f26499b;
    /* renamed from: c */
    private CompressFormat f26500c;
    /* renamed from: d */
    private int f26501d;
    /* renamed from: e */
    private String f26502e;
    /* renamed from: f */
    private String f26503f;
    /* renamed from: g */
    private ExifInfo f26504g;

    public CropParameters(int i, int i2, CompressFormat compressFormat, int i3, String str, String str2, ExifInfo bVar) {
        this.f26498a = i;
        this.f26499b = i2;
        this.f26500c = compressFormat;
        this.f26501d = i3;
        this.f26502e = str;
        this.f26503f = str2;
        this.f26504g = bVar;
    }

    /* renamed from: a */
    public int mo37854a() {
        return this.f26498a;
    }

    /* renamed from: b */
    public int mo37855b() {
        return this.f26499b;
    }

    /* renamed from: c */
    public CompressFormat mo37856c() {
        return this.f26500c;
    }

    /* renamed from: d */
    public int mo37857d() {
        return this.f26501d;
    }

    /* renamed from: e */
    public String mo37858e() {
        return this.f26502e;
    }

    /* renamed from: f */
    public String mo37859f() {
        return this.f26503f;
    }
}
