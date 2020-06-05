package com.p530ss.android.socialbase.downloader.p564i;

/* renamed from: com.ss.android.socialbase.downloader.i.b */
class ExponentialGeometricAverage {
    /* renamed from: a */
    private final double f22147a;
    /* renamed from: b */
    private final int f22148b;
    /* renamed from: c */
    private double f22149c = -1.0d;
    /* renamed from: d */
    private int f22150d;

    public ExponentialGeometricAverage(double d) {
        int i;
        this.f22147a = d;
        if (d == 0.0d) {
            i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        } else {
            i = (int) Math.ceil(1.0d / d);
        }
        this.f22148b = i;
    }

    /* renamed from: a */
    public void mo32467a(double d) {
        double d2 = 1.0d - this.f22147a;
        int i = this.f22150d;
        if (i > this.f22148b) {
            this.f22149c = Math.exp((d2 * Math.log(this.f22149c)) + (this.f22147a * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * ((double) i)) / (((double) i) + 1.0d);
            this.f22149c = Math.exp((d3 * Math.log(this.f22149c)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.f22149c = d;
        }
        this.f22150d++;
    }

    /* renamed from: a */
    public double mo32466a() {
        return this.f22149c;
    }
}
