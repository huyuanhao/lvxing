package com.p522qq.taf.jce.dynamic;

/* renamed from: com.qq.taf.jce.dynamic.FloatField */
public class FloatField extends NumberField {
    private float data;

    FloatField(float f, int i) {
        super(i);
        this.data = f;
    }

    public float get() {
        return this.data;
    }

    public Number getNumber() {
        return Float.valueOf(this.data);
    }

    public void set(float f) {
        this.data = f;
    }
}
