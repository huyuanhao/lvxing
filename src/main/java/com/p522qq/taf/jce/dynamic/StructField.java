package com.p522qq.taf.jce.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.qq.taf.jce.dynamic.StructField */
public class StructField extends JceField {
    private static final Comparator<JceField> tagComp = new Comparator<JceField>() {
        public int compare(JceField jceField, JceField jceField2) {
            return jceField.getTag() - jceField2.getTag();
        }
    };
    private JceField[] data;

    StructField(JceField[] jceFieldArr, int i) {
        super(i);
        this.data = jceFieldArr;
    }

    public JceField[] get() {
        return this.data;
    }

    public JceField getFieldByTag(int i) {
        int binarySearch = Arrays.binarySearch(this.data, JceField.createZero(i), tagComp);
        if (binarySearch >= 0) {
            return this.data[binarySearch];
        }
        return null;
    }

    public boolean setByTag(int i, JceField jceField) {
        int binarySearch = Arrays.binarySearch(this.data, JceField.createZero(i), tagComp);
        if (binarySearch >= 0) {
            this.data[binarySearch] = jceField;
            return true;
        }
        int i2 = (-binarySearch) - 1;
        JceField[] jceFieldArr = new JceField[(this.data.length + 1)];
        for (int i3 = 0; i3 < i2; i3++) {
            jceFieldArr[i3] = this.data[i3];
        }
        jceFieldArr[i2] = jceField;
        while (true) {
            JceField[] jceFieldArr2 = this.data;
            if (i2 >= jceFieldArr2.length) {
                return false;
            }
            int i4 = i2 + 1;
            jceFieldArr[i4] = jceFieldArr2[i2];
            i2 = i4;
        }
    }
}
