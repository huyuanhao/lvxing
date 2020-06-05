package com.airbnb.lottie;

import android.graphics.Bitmap;

/* renamed from: com.airbnb.lottie.f */
public class LottieImageAsset {
    /* renamed from: a */
    private final int f1518a;
    /* renamed from: b */
    private final int f1519b;
    /* renamed from: c */
    private final String f1520c;
    /* renamed from: d */
    private final String f1521d;
    /* renamed from: e */
    private final String f1522e;
    /* renamed from: f */
    private Bitmap f1523f;

    public LottieImageAsset(int i, int i2, String str, String str2, String str3) {
        this.f1518a = i;
        this.f1519b = i2;
        this.f1520c = str;
        this.f1521d = str2;
        this.f1522e = str3;
    }

    /* renamed from: a */
    public String mo9991a() {
        return this.f1520c;
    }

    /* renamed from: b */
    public String mo9993b() {
        return this.f1521d;
    }

    /* renamed from: c */
    public Bitmap mo9994c() {
        return this.f1523f;
    }

    /* renamed from: a */
    public void mo9992a(Bitmap bitmap) {
        this.f1523f = bitmap;
    }
}
