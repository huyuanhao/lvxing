package com.bytedance.sdk.openadsdk;

public class TTLocation {
    /* renamed from: a */
    private double f6425a = 0.0d;
    /* renamed from: b */
    private double f6426b = 0.0d;

    public TTLocation(double d, double d2) {
        this.f6425a = d;
        this.f6426b = d2;
    }

    public double getLatitude() {
        return this.f6425a;
    }

    public void setLatitude(double d) {
        this.f6425a = d;
    }

    public double getLongitude() {
        return this.f6426b;
    }

    public void setLongitude(double d) {
        this.f6426b = d;
    }
}
