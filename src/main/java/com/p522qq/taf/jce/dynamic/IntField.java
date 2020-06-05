package com.p522qq.taf.jce.dynamic;

/* renamed from: com.qq.taf.jce.dynamic.IntField */
public class IntField extends NumberField {
    private int data;

    IntField(int i, int i2) {
        super(i2);
        this.data = i;
    }

    public int get() {
        return this.data;
    }

    public Number getNumber() {
        return Integer.valueOf(this.data);
    }

    public void set(int i) {
        this.data = i;
    }
}
