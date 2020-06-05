package com.p522qq.taf.jce.dynamic;

/* renamed from: com.qq.taf.jce.dynamic.DoubleField */
public class DoubleField extends NumberField {
    private double data;

    DoubleField(double d, int i) {
        super(i);
        this.data = d;
    }

    public double get() {
        return this.data;
    }

    public Number getNumber() {
        return Double.valueOf(this.data);
    }

    public void set(double d) {
        this.data = d;
    }
}
