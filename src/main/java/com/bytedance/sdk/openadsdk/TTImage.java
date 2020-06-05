package com.bytedance.sdk.openadsdk;

public class TTImage {
    /* renamed from: a */
    private int f6422a;
    /* renamed from: b */
    private int f6423b;
    /* renamed from: c */
    private String f6424c;

    public TTImage(int i, int i2, String str) {
        this.f6422a = i;
        this.f6423b = i2;
        this.f6424c = str;
    }

    public int getHeight() {
        return this.f6422a;
    }

    public int getWidth() {
        return this.f6423b;
    }

    public String getImageUrl() {
        return this.f6424c;
    }

    public boolean isValid() {
        if (this.f6422a > 0 && this.f6423b > 0) {
            String str = this.f6424c;
            if (str != null && str.length() > 0) {
                return true;
            }
        }
        return false;
    }
}
