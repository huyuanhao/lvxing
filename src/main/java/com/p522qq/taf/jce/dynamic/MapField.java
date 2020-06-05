package com.p522qq.taf.jce.dynamic;

/* renamed from: com.qq.taf.jce.dynamic.MapField */
public final class MapField extends JceField {
    private JceField[] keys;
    private JceField[] values;

    MapField(JceField[] jceFieldArr, JceField[] jceFieldArr2, int i) {
        super(i);
        this.keys = jceFieldArr;
        this.values = jceFieldArr2;
    }

    public JceField getKey(int i) {
        return this.keys[i];
    }

    public JceField[] getKeys() {
        return this.keys;
    }

    public JceField getValue(int i) {
        return this.values[i];
    }

    public JceField[] getValues() {
        return this.values;
    }

    public void setKey(int i, JceField jceField) {
        this.keys[i] = jceField;
    }

    public void setValue(int i, JceField jceField) {
        this.values[i] = jceField;
    }

    public int size() {
        return this.keys.length;
    }
}
