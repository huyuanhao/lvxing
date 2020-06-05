package com.p522qq.taf.jce;

import com.tencent.mid.sotrage.StorageInterface;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.qq.taf.jce.JceDisplayer */
public final class JceDisplayer {
    private int _level = 0;
    /* renamed from: sb */
    private StringBuilder f20325sb;

    /* renamed from: ps */
    private void m25270ps(String str) {
        for (int i = 0; i < this._level; i++) {
            this.f20325sb.append(9);
        }
        if (str != null) {
            StringBuilder sb = this.f20325sb;
            sb.append(str);
            sb.append(": ");
        }
    }

    public JceDisplayer(StringBuilder sb, int i) {
        this.f20325sb = sb;
        this._level = i;
    }

    public JceDisplayer(StringBuilder sb) {
        this.f20325sb = sb;
    }

    public JceDisplayer display(boolean z, String str) {
        m25270ps(str);
        StringBuilder sb = this.f20325sb;
        sb.append(z ? 'T' : 'F');
        sb.append(10);
        return this;
    }

    public JceDisplayer displaySimple(boolean z, boolean z2) {
        this.f20325sb.append(z ? 'T' : 'F');
        if (z2) {
            this.f20325sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(byte b, String str) {
        m25270ps(str);
        StringBuilder sb = this.f20325sb;
        sb.append(b);
        sb.append(10);
        return this;
    }

    public JceDisplayer displaySimple(byte b, boolean z) {
        this.f20325sb.append(b);
        if (z) {
            this.f20325sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(char c, String str) {
        m25270ps(str);
        StringBuilder sb = this.f20325sb;
        sb.append(c);
        sb.append(10);
        return this;
    }

    public JceDisplayer displaySimple(char c, boolean z) {
        this.f20325sb.append(c);
        if (z) {
            this.f20325sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(short s, String str) {
        m25270ps(str);
        StringBuilder sb = this.f20325sb;
        sb.append(s);
        sb.append(10);
        return this;
    }

    public JceDisplayer displaySimple(short s, boolean z) {
        this.f20325sb.append(s);
        if (z) {
            this.f20325sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(int i, String str) {
        m25270ps(str);
        StringBuilder sb = this.f20325sb;
        sb.append(i);
        sb.append(10);
        return this;
    }

    public JceDisplayer displaySimple(int i, boolean z) {
        this.f20325sb.append(i);
        if (z) {
            this.f20325sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(long j, String str) {
        m25270ps(str);
        StringBuilder sb = this.f20325sb;
        sb.append(j);
        sb.append(10);
        return this;
    }

    public JceDisplayer displaySimple(long j, boolean z) {
        this.f20325sb.append(j);
        if (z) {
            this.f20325sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(float f, String str) {
        m25270ps(str);
        StringBuilder sb = this.f20325sb;
        sb.append(f);
        sb.append(10);
        return this;
    }

    public JceDisplayer displaySimple(float f, boolean z) {
        this.f20325sb.append(f);
        if (z) {
            this.f20325sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(double d, String str) {
        m25270ps(str);
        StringBuilder sb = this.f20325sb;
        sb.append(d);
        sb.append(10);
        return this;
    }

    public JceDisplayer displaySimple(double d, boolean z) {
        this.f20325sb.append(d);
        if (z) {
            this.f20325sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(String str, String str2) {
        m25270ps(str2);
        if (str == null) {
            StringBuilder sb = this.f20325sb;
            sb.append("null");
            sb.append(10);
        } else {
            StringBuilder sb2 = this.f20325sb;
            sb2.append(str);
            sb2.append(10);
        }
        return this;
    }

    public JceDisplayer displaySimple(String str, boolean z) {
        if (str == null) {
            this.f20325sb.append("null");
        } else {
            this.f20325sb.append(str);
        }
        if (z) {
            this.f20325sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(byte[] bArr, String str) {
        m25270ps(str);
        if (bArr == null) {
            StringBuilder sb = this.f20325sb;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb2 = this.f20325sb;
            sb2.append(bArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f20325sb;
            sb3.append(bArr.length);
            sb3.append(", [");
            sb3.append(10);
            JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
            for (byte display : bArr) {
                jceDisplayer.display(display, (String) null);
            }
            display(']', (String) null);
            return this;
        }
    }

    public JceDisplayer displaySimple(byte[] bArr, boolean z) {
        String str = "|";
        if (bArr == null || bArr.length == 0) {
            if (z) {
                this.f20325sb.append(str);
            }
            return this;
        }
        this.f20325sb.append(HexUtil.bytes2HexStr(bArr));
        if (z) {
            this.f20325sb.append(str);
        }
        return this;
    }

    public JceDisplayer display(char[] cArr, String str) {
        m25270ps(str);
        if (cArr == null) {
            StringBuilder sb = this.f20325sb;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (cArr.length == 0) {
            StringBuilder sb2 = this.f20325sb;
            sb2.append(cArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f20325sb;
            sb3.append(cArr.length);
            sb3.append(", [");
            sb3.append(10);
            JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
            for (char display : cArr) {
                jceDisplayer.display(display, (String) null);
            }
            display(']', (String) null);
            return this;
        }
    }

    public JceDisplayer displaySimple(char[] cArr, boolean z) {
        String str = "|";
        if (cArr == null || cArr.length == 0) {
            if (z) {
                this.f20325sb.append(str);
            }
            return this;
        }
        this.f20325sb.append(new String(cArr));
        if (z) {
            this.f20325sb.append(str);
        }
        return this;
    }

    public JceDisplayer display(short[] sArr, String str) {
        m25270ps(str);
        if (sArr == null) {
            StringBuilder sb = this.f20325sb;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (sArr.length == 0) {
            StringBuilder sb2 = this.f20325sb;
            sb2.append(sArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f20325sb;
            sb3.append(sArr.length);
            sb3.append(", [");
            sb3.append(10);
            JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
            for (short display : sArr) {
                jceDisplayer.display(display, (String) null);
            }
            display(']', (String) null);
            return this;
        }
    }

    public JceDisplayer displaySimple(short[] sArr, boolean z) {
        String str = "|";
        if (sArr == null || sArr.length == 0) {
            this.f20325sb.append("[]");
            if (z) {
                this.f20325sb.append(str);
            }
            return this;
        }
        this.f20325sb.append("[");
        JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
        for (int i = 0; i < sArr.length; i++) {
            short s = sArr[i];
            if (i != 0) {
                this.f20325sb.append(str);
            }
            jceDisplayer.displaySimple(s, false);
        }
        this.f20325sb.append("]");
        if (z) {
            this.f20325sb.append(str);
        }
        return this;
    }

    public JceDisplayer display(int[] iArr, String str) {
        m25270ps(str);
        if (iArr == null) {
            StringBuilder sb = this.f20325sb;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (iArr.length == 0) {
            StringBuilder sb2 = this.f20325sb;
            sb2.append(iArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f20325sb;
            sb3.append(iArr.length);
            sb3.append(", [");
            sb3.append(10);
            JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
            for (int display : iArr) {
                jceDisplayer.display(display, (String) null);
            }
            display(']', (String) null);
            return this;
        }
    }

    public JceDisplayer displaySimple(int[] iArr, boolean z) {
        String str = "|";
        if (iArr == null || iArr.length == 0) {
            this.f20325sb.append("[]");
            if (z) {
                this.f20325sb.append(str);
            }
            return this;
        }
        this.f20325sb.append("[");
        JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
        for (int i = 0; i < iArr.length; i++) {
            int i2 = iArr[i];
            if (i != 0) {
                this.f20325sb.append(str);
            }
            jceDisplayer.displaySimple(i2, false);
        }
        this.f20325sb.append("]");
        if (z) {
            this.f20325sb.append(str);
        }
        return this;
    }

    public JceDisplayer display(long[] jArr, String str) {
        m25270ps(str);
        if (jArr == null) {
            StringBuilder sb = this.f20325sb;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (jArr.length == 0) {
            StringBuilder sb2 = this.f20325sb;
            sb2.append(jArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f20325sb;
            sb3.append(jArr.length);
            sb3.append(", [");
            sb3.append(10);
            JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
            for (long display : jArr) {
                jceDisplayer.display(display, (String) null);
            }
            display(']', (String) null);
            return this;
        }
    }

    public JceDisplayer displaySimple(long[] jArr, boolean z) {
        String str = "|";
        if (jArr == null || jArr.length == 0) {
            this.f20325sb.append("[]");
            if (z) {
                this.f20325sb.append(str);
            }
            return this;
        }
        this.f20325sb.append("[");
        JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
        for (int i = 0; i < jArr.length; i++) {
            long j = jArr[i];
            if (i != 0) {
                this.f20325sb.append(str);
            }
            jceDisplayer.displaySimple(j, false);
        }
        this.f20325sb.append("]");
        if (z) {
            this.f20325sb.append(str);
        }
        return this;
    }

    public JceDisplayer display(float[] fArr, String str) {
        m25270ps(str);
        if (fArr == null) {
            StringBuilder sb = this.f20325sb;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (fArr.length == 0) {
            StringBuilder sb2 = this.f20325sb;
            sb2.append(fArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f20325sb;
            sb3.append(fArr.length);
            sb3.append(", [");
            sb3.append(10);
            JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
            for (float display : fArr) {
                jceDisplayer.display(display, (String) null);
            }
            display(']', (String) null);
            return this;
        }
    }

    public JceDisplayer displaySimple(float[] fArr, boolean z) {
        String str = "|";
        if (fArr == null || fArr.length == 0) {
            this.f20325sb.append("[]");
            if (z) {
                this.f20325sb.append(str);
            }
            return this;
        }
        this.f20325sb.append("[");
        JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
        for (int i = 0; i < fArr.length; i++) {
            float f = fArr[i];
            if (i != 0) {
                this.f20325sb.append(str);
            }
            jceDisplayer.displaySimple(f, false);
        }
        this.f20325sb.append("]");
        if (z) {
            this.f20325sb.append(str);
        }
        return this;
    }

    public JceDisplayer display(double[] dArr, String str) {
        m25270ps(str);
        if (dArr == null) {
            StringBuilder sb = this.f20325sb;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (dArr.length == 0) {
            StringBuilder sb2 = this.f20325sb;
            sb2.append(dArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f20325sb;
            sb3.append(dArr.length);
            sb3.append(", [");
            sb3.append(10);
            JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
            for (double display : dArr) {
                jceDisplayer.display(display, (String) null);
            }
            display(']', (String) null);
            return this;
        }
    }

    public JceDisplayer displaySimple(double[] dArr, boolean z) {
        String str = "|";
        if (dArr == null || dArr.length == 0) {
            this.f20325sb.append("[]");
            if (z) {
                this.f20325sb.append(str);
            }
            return this;
        }
        String str2 = "[";
        this.f20325sb.append(str2);
        JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
        for (int i = 0; i < dArr.length; i++) {
            double d = dArr[i];
            if (i != 0) {
                this.f20325sb.append(str);
            }
            jceDisplayer.displaySimple(d, false);
        }
        this.f20325sb.append(str2);
        if (z) {
            this.f20325sb.append(str);
        }
        return this;
    }

    public <K, V> JceDisplayer display(Map<K, V> map, String str) {
        m25270ps(str);
        if (map == null) {
            StringBuilder sb = this.f20325sb;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb2 = this.f20325sb;
            sb2.append(map.size());
            sb2.append(", {}");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f20325sb;
            sb3.append(map.size());
            sb3.append(", {");
            sb3.append(10);
            JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
            JceDisplayer jceDisplayer2 = new JceDisplayer(this.f20325sb, this._level + 2);
            for (Entry entry : map.entrySet()) {
                jceDisplayer.display('(', (String) null);
                jceDisplayer2.display((T) entry.getKey(), (String) null);
                jceDisplayer2.display((T) entry.getValue(), (String) null);
                jceDisplayer.display(')', (String) null);
            }
            display('}', (String) null);
            return this;
        }
    }

    public <K, V> JceDisplayer displaySimple(Map<K, V> map, boolean z) {
        String str = "|";
        if (map == null || map.isEmpty()) {
            this.f20325sb.append("{}");
            if (z) {
                this.f20325sb.append(str);
            }
            return this;
        }
        this.f20325sb.append("{");
        JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 2);
        boolean z2 = true;
        for (Entry entry : map.entrySet()) {
            if (!z2) {
                this.f20325sb.append(StorageInterface.KEY_SPLITER);
            }
            jceDisplayer.displaySimple((T) entry.getKey(), true);
            jceDisplayer.displaySimple((T) entry.getValue(), false);
            z2 = false;
        }
        this.f20325sb.append("}");
        if (z) {
            this.f20325sb.append(str);
        }
        return this;
    }

    public <T> JceDisplayer display(T[] tArr, String str) {
        m25270ps(str);
        if (tArr == null) {
            StringBuilder sb = this.f20325sb;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb2 = this.f20325sb;
            sb2.append(tArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f20325sb;
            sb3.append(tArr.length);
            sb3.append(", [");
            sb3.append(10);
            JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
            for (T display : tArr) {
                jceDisplayer.display(display, (String) null);
            }
            display(']', (String) null);
            return this;
        }
    }

    public <T> JceDisplayer displaySimple(T[] tArr, boolean z) {
        String str = "|";
        if (tArr == null || tArr.length == 0) {
            this.f20325sb.append("[]");
            if (z) {
                this.f20325sb.append(str);
            }
            return this;
        }
        this.f20325sb.append("[");
        JceDisplayer jceDisplayer = new JceDisplayer(this.f20325sb, this._level + 1);
        for (int i = 0; i < tArr.length; i++) {
            T t = tArr[i];
            if (i != 0) {
                this.f20325sb.append(str);
            }
            jceDisplayer.displaySimple(t, false);
        }
        this.f20325sb.append("]");
        if (z) {
            this.f20325sb.append(str);
        }
        return this;
    }

    public <T> JceDisplayer display(Collection<T> collection, String str) {
        if (collection != null) {
            return display((T[]) collection.toArray(), str);
        }
        m25270ps(str);
        StringBuilder sb = this.f20325sb;
        sb.append("null");
        sb.append(9);
        return this;
    }

    public <T> JceDisplayer displaySimple(Collection<T> collection, boolean z) {
        if (collection != null) {
            return displaySimple((T[]) collection.toArray(), z);
        }
        this.f20325sb.append("[]");
        if (z) {
            this.f20325sb.append("|");
        }
        return this;
    }

    public <T> JceDisplayer display(T t, String str) {
        if (t == null) {
            StringBuilder sb = this.f20325sb;
            sb.append("null");
            sb.append(10);
        } else if (t instanceof Byte) {
            display(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            display(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            display(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            display(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            display(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            display(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            display(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            display((String) t, str);
        } else if (t instanceof Map) {
            display((Map) t, str);
        } else if (t instanceof List) {
            display((Collection<T>) (List) t, str);
        } else if (t instanceof JceStruct) {
            display((JceStruct) t, str);
        } else if (t instanceof byte[]) {
            display((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            display((T) (boolean[]) t, str);
        } else if (t instanceof short[]) {
            display((short[]) t, str);
        } else if (t instanceof int[]) {
            display((int[]) t, str);
        } else if (t instanceof long[]) {
            display((long[]) t, str);
        } else if (t instanceof float[]) {
            display((float[]) t, str);
        } else if (t instanceof double[]) {
            display((double[]) t, str);
        } else if (t.getClass().isArray()) {
            display((T[]) (Object[]) t, str);
        } else {
            throw new JceEncodeException("write object error: unsupport type.");
        }
        return this;
    }

    public <T> JceDisplayer displaySimple(T t, boolean z) {
        if (t == null) {
            StringBuilder sb = this.f20325sb;
            sb.append("null");
            sb.append(10);
        } else if (t instanceof Byte) {
            displaySimple(((Byte) t).byteValue(), z);
        } else if (t instanceof Boolean) {
            displaySimple(((Boolean) t).booleanValue(), z);
        } else if (t instanceof Short) {
            displaySimple(((Short) t).shortValue(), z);
        } else if (t instanceof Integer) {
            displaySimple(((Integer) t).intValue(), z);
        } else if (t instanceof Long) {
            displaySimple(((Long) t).longValue(), z);
        } else if (t instanceof Float) {
            displaySimple(((Float) t).floatValue(), z);
        } else if (t instanceof Double) {
            displaySimple(((Double) t).doubleValue(), z);
        } else if (t instanceof String) {
            displaySimple((String) t, z);
        } else if (t instanceof Map) {
            displaySimple((Map) t, z);
        } else if (t instanceof List) {
            displaySimple((Collection<T>) (List) t, z);
        } else if (t instanceof JceStruct) {
            displaySimple((JceStruct) t, z);
        } else if (t instanceof byte[]) {
            displaySimple((byte[]) t, z);
        } else if (t instanceof boolean[]) {
            displaySimple((T) (boolean[]) t, z);
        } else if (t instanceof short[]) {
            displaySimple((short[]) t, z);
        } else if (t instanceof int[]) {
            displaySimple((int[]) t, z);
        } else if (t instanceof long[]) {
            displaySimple((long[]) t, z);
        } else if (t instanceof float[]) {
            displaySimple((float[]) t, z);
        } else if (t instanceof double[]) {
            displaySimple((double[]) t, z);
        } else if (t.getClass().isArray()) {
            displaySimple((T[]) (Object[]) t, z);
        } else {
            throw new JceEncodeException("write object error: unsupport type.");
        }
        return this;
    }

    public JceDisplayer display(JceStruct jceStruct, String str) {
        display('{', str);
        if (jceStruct == null) {
            StringBuilder sb = this.f20325sb;
            sb.append(9);
            sb.append("null");
        } else {
            jceStruct.display(this.f20325sb, this._level + 1);
        }
        display('}', (String) null);
        return this;
    }

    public JceDisplayer displaySimple(JceStruct jceStruct, boolean z) {
        this.f20325sb.append("{");
        if (jceStruct == null) {
            StringBuilder sb = this.f20325sb;
            sb.append(9);
            sb.append("null");
        } else {
            jceStruct.displaySimple(this.f20325sb, this._level + 1);
        }
        this.f20325sb.append("}");
        if (z) {
            this.f20325sb.append("|");
        }
        return this;
    }

    public static void main(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(1.2d);
        System.out.println(sb.toString());
    }
}
