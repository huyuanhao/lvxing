package com.p522qq.taf.jce.dynamic;

/* renamed from: com.qq.taf.jce.dynamic.ListField */
public final class ListField extends JceField {
    private JceField[] data;

    ListField(JceField[] jceFieldArr, int i) {
        super(i);
        this.data = jceFieldArr;
    }

    public JceField get(int i) {
        return this.data[i];
    }

    public JceField[] get() {
        return this.data;
    }

    public void set(int i, JceField jceField) {
        this.data[i] = jceField;
    }

    public void set(JceField[] jceFieldArr) {
        this.data = jceFieldArr;
    }

    public int size() {
        return this.data.length;
    }
}
