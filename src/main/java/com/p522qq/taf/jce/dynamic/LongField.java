package com.p522qq.taf.jce.dynamic;

/* renamed from: com.qq.taf.jce.dynamic.LongField */
public class LongField extends NumberField {
    private long data;

    LongField(long j, int i) {
        super(i);
        this.data = j;
    }

    public long get() {
        return this.data;
    }

    public Number getNumber() {
        return Long.valueOf(this.data);
    }

    public void set(long j) {
        this.data = j;
    }
}
