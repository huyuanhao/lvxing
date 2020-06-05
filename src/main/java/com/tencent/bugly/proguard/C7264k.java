package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.k */
public final class C7264k {
    /* renamed from: a */
    protected String f24582a = "GBK";
    /* renamed from: b */
    private ByteBuffer f24583b;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.k$a */
    public static class C7265a {
        /* renamed from: a */
        public byte f24584a;
        /* renamed from: b */
        public int f24585b;
    }

    public C7264k() {
    }

    public C7264k(byte[] bArr) {
        this.f24583b = ByteBuffer.wrap(bArr);
    }

    public C7264k(byte[] bArr, int i) {
        this.f24583b = ByteBuffer.wrap(bArr);
        this.f24583b.position(i);
    }

    /* renamed from: a */
    public void mo34913a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f24583b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f24583b = ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    public static int m31340a(C7265a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.f24584a = (byte) (b & 15);
        aVar.f24585b = (b & -16) >> 4;
        if (aVar.f24585b != 15) {
            return 1;
        }
        aVar.f24585b = byteBuffer.get();
        return 2;
    }

    /* renamed from: a */
    public void mo34912a(C7265a aVar) {
        m31340a(aVar, this.f24583b);
    }

    /* renamed from: b */
    private int m31343b(C7265a aVar) {
        return m31340a(aVar, this.f24583b.duplicate());
    }

    /* renamed from: b */
    private void m31345b(int i) {
        ByteBuffer byteBuffer = this.f24583b;
        byteBuffer.position(byteBuffer.position() + i);
    }

    /* renamed from: a */
    public boolean mo34914a(int i) {
        try {
            C7265a aVar = new C7265a();
            while (true) {
                int b = m31343b(aVar);
                if (i <= aVar.f24585b) {
                    break;
                } else if (aVar.f24584a == 11) {
                    break;
                } else {
                    m31345b(b);
                    m31342a(aVar.f24584a);
                }
            }
            if (i == aVar.f24585b) {
                return true;
            }
            return false;
        } catch (C7261h | BufferUnderflowException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public void mo34911a() {
        C7265a aVar = new C7265a();
        do {
            mo34912a(aVar);
            m31342a(aVar.f24584a);
        } while (aVar.f24584a != 11);
    }

    /* renamed from: b */
    private void m31344b() {
        C7265a aVar = new C7265a();
        mo34912a(aVar);
        m31342a(aVar.f24584a);
    }

    /* renamed from: a */
    private void m31342a(byte b) {
        int i = 0;
        switch (b) {
            case 0:
                m31345b(1);
                return;
            case 1:
                m31345b(2);
                return;
            case 2:
                m31345b(4);
                return;
            case 3:
                m31345b(8);
                return;
            case 4:
                m31345b(4);
                return;
            case 5:
                m31345b(8);
                return;
            case 6:
                int i2 = this.f24583b.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                m31345b(i2);
                return;
            case 7:
                m31345b(this.f24583b.getInt());
                return;
            case 8:
                int a = mo34902a(0, 0, true);
                while (i < a * 2) {
                    m31344b();
                    i++;
                }
                return;
            case 9:
                int a2 = mo34902a(0, 0, true);
                while (i < a2) {
                    m31344b();
                    i++;
                }
                return;
            case 10:
                mo34911a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                C7265a aVar = new C7265a();
                mo34912a(aVar);
                if (aVar.f24584a == 0) {
                    m31345b(mo34902a(0, 0, true));
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("skipField with invalid type, type value: ");
                sb.append(b);
                sb.append(", ");
                sb.append(aVar.f24584a);
                throw new C7261h(sb.toString());
            default:
                throw new C7261h("invalid type.");
        }
    }

    /* renamed from: a */
    public boolean mo34915a(boolean z, int i, boolean z2) {
        return mo34899a(0, i, z2) != 0;
    }

    /* renamed from: a */
    public byte mo34899a(byte b, int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            byte b2 = aVar.f24584a;
            if (b2 == 0) {
                return this.f24583b.get();
            }
            if (b2 == 12) {
                return 0;
            }
            throw new C7261h("type mismatch.");
        } else if (!z) {
            return b;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public short mo34910a(short s, int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            byte b = aVar.f24584a;
            if (b == 0) {
                return (short) this.f24583b.get();
            }
            if (b == 1) {
                return this.f24583b.getShort();
            }
            if (b == 12) {
                return 0;
            }
            throw new C7261h("type mismatch.");
        } else if (!z) {
            return s;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public int mo34902a(int i, int i2, boolean z) {
        if (mo34914a(i2)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            byte b = aVar.f24584a;
            if (b == 0) {
                return this.f24583b.get();
            }
            if (b == 1) {
                return this.f24583b.getShort();
            }
            if (b == 2) {
                return this.f24583b.getInt();
            }
            if (b == 12) {
                return 0;
            }
            throw new C7261h("type mismatch.");
        } else if (!z) {
            return i;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public long mo34904a(long j, int i, boolean z) {
        int i2;
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            byte b = aVar.f24584a;
            if (b == 0) {
                i2 = this.f24583b.get();
            } else if (b == 1) {
                i2 = this.f24583b.getShort();
            } else if (b == 2) {
                i2 = this.f24583b.getInt();
            } else if (b == 3) {
                return this.f24583b.getLong();
            } else {
                if (b == 12) {
                    return 0;
                }
                throw new C7261h("type mismatch.");
            }
            return (long) i2;
        } else if (!z) {
            return j;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public float mo34901a(float f, int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            byte b = aVar.f24584a;
            if (b == 4) {
                return this.f24583b.getFloat();
            }
            if (b == 12) {
                return 0.0f;
            }
            throw new C7261h("type mismatch.");
        } else if (!z) {
            return f;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public double mo34900a(double d, int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            byte b = aVar.f24584a;
            if (b == 4) {
                return (double) this.f24583b.getFloat();
            }
            if (b == 5) {
                return this.f24583b.getDouble();
            }
            if (b == 12) {
                return 0.0d;
            }
            throw new C7261h("type mismatch.");
        } else if (!z) {
            return d;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public String mo34907a(int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            byte b = aVar.f24584a;
            if (b == 6) {
                int i2 = this.f24583b.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.f24583b.get(bArr);
                try {
                    return new String(bArr, this.f24582a);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr);
                }
            } else if (b == 7) {
                int i3 = this.f24583b.getInt();
                if (i3 > 104857600 || i3 < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("String too long: ");
                    sb.append(i3);
                    throw new C7261h(sb.toString());
                }
                byte[] bArr2 = new byte[i3];
                this.f24583b.get(bArr2);
                try {
                    return new String(bArr2, this.f24582a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            } else {
                throw new C7261h("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public <K, V> HashMap<K, V> mo34908a(Map<K, V> map, int i, boolean z) {
        return (HashMap) m31341a(new HashMap(), map, i, z);
    }

    /* renamed from: a */
    private <K, V> Map<K, V> m31341a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            if (aVar.f24584a == 8) {
                int a = mo34902a(0, 0, true);
                if (a >= 0) {
                    for (int i2 = 0; i2 < a; i2++) {
                        map.put(mo34906a((T) key, 0, true), mo34906a((T) value, 1, true));
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("size invalid: ");
                    sb.append(a);
                    throw new C7261h(sb.toString());
                }
            } else {
                throw new C7261h("type mismatch.");
            }
        } else if (z) {
            throw new C7261h("require field not exist.");
        }
        return map;
    }

    /* renamed from: a */
    public boolean[] mo34923a(boolean[] zArr, int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            if (aVar.f24584a == 9) {
                int a = mo34902a(0, 0, true);
                if (a >= 0) {
                    boolean[] zArr2 = new boolean[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        zArr2[i2] = mo34915a(zArr2[0], 0, true);
                    }
                    return zArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(a);
                throw new C7261h(sb.toString());
            }
            throw new C7261h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public byte[] mo34916a(byte[] bArr, int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            byte b = aVar.f24584a;
            if (b == 9) {
                int a = mo34902a(0, 0, true);
                if (a >= 0) {
                    byte[] bArr2 = new byte[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        bArr2[i2] = mo34899a(bArr2[0], 0, true);
                    }
                    return bArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(a);
                throw new C7261h(sb.toString());
            } else if (b == 13) {
                C7265a aVar2 = new C7265a();
                mo34912a(aVar2);
                String str = ", ";
                String str2 = ", type: ";
                if (aVar2.f24584a == 0) {
                    int a2 = mo34902a(0, 0, true);
                    if (a2 >= 0) {
                        byte[] bArr3 = new byte[a2];
                        this.f24583b.get(bArr3);
                        return bArr3;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("invalid size, tag: ");
                    sb2.append(i);
                    sb2.append(str2);
                    sb2.append(aVar.f24584a);
                    sb2.append(str);
                    sb2.append(aVar2.f24584a);
                    sb2.append(", size: ");
                    sb2.append(a2);
                    throw new C7261h(sb2.toString());
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("type mismatch, tag: ");
                sb3.append(i);
                sb3.append(str2);
                sb3.append(aVar.f24584a);
                sb3.append(str);
                sb3.append(aVar2.f24584a);
                throw new C7261h(sb3.toString());
            } else {
                throw new C7261h("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public short[] mo34922a(short[] sArr, int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            if (aVar.f24584a == 9) {
                int a = mo34902a(0, 0, true);
                if (a >= 0) {
                    short[] sArr2 = new short[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        sArr2[i2] = mo34910a(sArr2[0], 0, true);
                    }
                    return sArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(a);
                throw new C7261h(sb.toString());
            }
            throw new C7261h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public int[] mo34919a(int[] iArr, int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            if (aVar.f24584a == 9) {
                int a = mo34902a(0, 0, true);
                if (a >= 0) {
                    int[] iArr2 = new int[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        iArr2[i2] = mo34902a(iArr2[0], 0, true);
                    }
                    return iArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(a);
                throw new C7261h(sb.toString());
            }
            throw new C7261h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public long[] mo34920a(long[] jArr, int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            if (aVar.f24584a == 9) {
                int a = mo34902a(0, 0, true);
                if (a >= 0) {
                    long[] jArr2 = new long[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        jArr2[i2] = mo34904a(jArr2[0], 0, true);
                    }
                    return jArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(a);
                throw new C7261h(sb.toString());
            }
            throw new C7261h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public float[] mo34918a(float[] fArr, int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            if (aVar.f24584a == 9) {
                int a = mo34902a(0, 0, true);
                if (a >= 0) {
                    float[] fArr2 = new float[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        fArr2[i2] = mo34901a(fArr2[0], 0, true);
                    }
                    return fArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(a);
                throw new C7261h(sb.toString());
            }
            throw new C7261h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public double[] mo34917a(double[] dArr, int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            if (aVar.f24584a == 9) {
                int a = mo34902a(0, 0, true);
                if (a >= 0) {
                    double[] dArr2 = new double[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        dArr2[i2] = mo34900a(dArr2[0], 0, true);
                    }
                    return dArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(a);
                throw new C7261h(sb.toString());
            }
            throw new C7261h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public <T> T[] mo34921a(T[] tArr, int i, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return m31346b(tArr[0], i, z);
        }
        throw new C7261h("unable to get type of key and value.");
    }

    /* renamed from: a */
    public <T> List<T> mo34909a(List<T> list, int i, boolean z) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        Object[] b = m31346b(list.get(0), i, z);
        if (b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object add : b) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* renamed from: b */
    private <T> T[] m31346b(T t, int i, boolean z) {
        if (mo34914a(i)) {
            C7265a aVar = new C7265a();
            mo34912a(aVar);
            if (aVar.f24584a == 9) {
                int a = mo34902a(0, 0, true);
                if (a >= 0) {
                    T[] tArr = (Object[]) Array.newInstance(t.getClass(), a);
                    for (int i2 = 0; i2 < a; i2++) {
                        tArr[i2] = mo34906a(t, 0, true);
                    }
                    return tArr;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(a);
                throw new C7261h(sb.toString());
            }
            throw new C7261h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public C7267m mo34905a(C7267m mVar, int i, boolean z) {
        if (mo34914a(i)) {
            try {
                C7267m mVar2 = (C7267m) mVar.getClass().newInstance();
                C7265a aVar = new C7265a();
                mo34912a(aVar);
                if (aVar.f24584a == 10) {
                    mVar2.mo34760a(this);
                    mo34911a();
                    return mVar2;
                }
                throw new C7261h("type mismatch.");
            } catch (Exception e) {
                throw new C7261h(e.getMessage());
            }
        } else if (!z) {
            return null;
        } else {
            throw new C7261h("require field not exist.");
        }
    }

    /* renamed from: a */
    public <T> Object mo34906a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(mo34899a(0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(mo34915a(false, i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(mo34910a(0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(mo34902a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(mo34904a(0, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(mo34901a(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(mo34900a(0.0d, i, z));
        }
        if (t instanceof String) {
            return String.valueOf(mo34907a(i, z));
        }
        if (t instanceof Map) {
            return mo34908a((Map) t, i, z);
        }
        if (t instanceof List) {
            return mo34909a((List) t, i, z);
        }
        if (t instanceof C7267m) {
            return mo34905a((C7267m) t, i, z);
        }
        if (!t.getClass().isArray()) {
            throw new C7261h("read object error: unsupport type.");
        } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
            return mo34916a((byte[]) null, i, z);
        } else {
            if (t instanceof boolean[]) {
                return mo34923a((boolean[]) null, i, z);
            }
            if (t instanceof short[]) {
                return mo34922a((short[]) null, i, z);
            }
            if (t instanceof int[]) {
                return mo34919a((int[]) null, i, z);
            }
            if (t instanceof long[]) {
                return mo34920a((long[]) null, i, z);
            }
            if (t instanceof float[]) {
                return mo34918a((float[]) null, i, z);
            }
            if (t instanceof double[]) {
                return mo34917a((double[]) null, i, z);
            }
            return mo34921a((T[]) (Object[]) t, i, z);
        }
    }

    /* renamed from: a */
    public int mo34903a(String str) {
        this.f24582a = str;
        return 0;
    }
}
