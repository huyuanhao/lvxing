package com.p522qq.taf.jce.dynamic;

/* renamed from: com.qq.taf.jce.dynamic.NumberField */
public abstract class NumberField extends JceField {
    NumberField(int i) {
        super(i);
    }

    public byte byteValue() {
        return getNumber().byteValue();
    }

    public double doubleValue() {
        return getNumber().doubleValue();
    }

    public float floatValue() {
        return getNumber().floatValue();
    }

    public abstract Number getNumber();

    public int intValue() {
        return getNumber().intValue();
    }

    public long longValue() {
        return getNumber().longValue();
    }

    public short shortValue() {
        return getNumber().shortValue();
    }
}
