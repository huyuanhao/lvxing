package com.yanzhenjie.durban.model;

/* renamed from: com.yanzhenjie.durban.model.b */
public class ExifInfo {
    /* renamed from: a */
    private int f26505a;
    /* renamed from: b */
    private int f26506b;
    /* renamed from: c */
    private int f26507c;

    public ExifInfo(int i, int i2, int i3) {
        this.f26505a = i;
        this.f26506b = i2;
        this.f26507c = i3;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExifInfo bVar = (ExifInfo) obj;
        if (this.f26505a != bVar.f26505a || this.f26506b != bVar.f26506b) {
            return false;
        }
        if (this.f26507c != bVar.f26507c) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((this.f26505a * 31) + this.f26506b) * 31) + this.f26507c;
    }
}
