package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.i */
public final class C7262i {
    /* renamed from: a */
    private StringBuilder f24580a;
    /* renamed from: b */
    private int f24581b = 0;

    /* renamed from: a */
    private void m31319a(String str) {
        for (int i = 0; i < this.f24581b; i++) {
            this.f24580a.append(9);
        }
        if (str != null) {
            StringBuilder sb = this.f24580a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public C7262i(StringBuilder sb, int i) {
        this.f24580a = sb;
        this.f24581b = i;
    }

    /* renamed from: a */
    public C7262i mo34891a(boolean z, String str) {
        m31319a(str);
        StringBuilder sb = this.f24580a;
        sb.append(z ? 'T' : 'F');
        sb.append(10);
        return this;
    }

    /* renamed from: a */
    public C7262i mo34879a(byte b, String str) {
        m31319a(str);
        StringBuilder sb = this.f24580a;
        sb.append(b);
        sb.append(10);
        return this;
    }

    /* renamed from: a */
    public C7262i mo34880a(char c, String str) {
        m31319a(str);
        StringBuilder sb = this.f24580a;
        sb.append(c);
        sb.append(10);
        return this;
    }

    /* renamed from: a */
    public C7262i mo34890a(short s, String str) {
        m31319a(str);
        StringBuilder sb = this.f24580a;
        sb.append(s);
        sb.append(10);
        return this;
    }

    /* renamed from: a */
    public C7262i mo34883a(int i, String str) {
        m31319a(str);
        StringBuilder sb = this.f24580a;
        sb.append(i);
        sb.append(10);
        return this;
    }

    /* renamed from: a */
    public C7262i mo34884a(long j, String str) {
        m31319a(str);
        StringBuilder sb = this.f24580a;
        sb.append(j);
        sb.append(10);
        return this;
    }

    /* renamed from: a */
    public C7262i mo34882a(float f, String str) {
        m31319a(str);
        StringBuilder sb = this.f24580a;
        sb.append(f);
        sb.append(10);
        return this;
    }

    /* renamed from: a */
    public C7262i mo34881a(double d, String str) {
        m31319a(str);
        StringBuilder sb = this.f24580a;
        sb.append(d);
        sb.append(10);
        return this;
    }

    /* renamed from: a */
    public C7262i mo34887a(String str, String str2) {
        m31319a(str2);
        if (str == null) {
            StringBuilder sb = this.f24580a;
            sb.append("null");
            sb.append(10);
        } else {
            StringBuilder sb2 = this.f24580a;
            sb2.append(str);
            sb2.append(10);
        }
        return this;
    }

    /* renamed from: a */
    public C7262i mo34892a(byte[] bArr, String str) {
        m31319a(str);
        if (bArr == null) {
            StringBuilder sb = this.f24580a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb2 = this.f24580a;
            sb2.append(bArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f24580a;
            sb3.append(bArr.length);
            sb3.append(", [");
            sb3.append(10);
            C7262i iVar = new C7262i(this.f24580a, this.f24581b + 1);
            for (byte a : bArr) {
                iVar.mo34879a(a, (String) null);
            }
            mo34880a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public C7262i mo34898a(short[] sArr, String str) {
        m31319a(str);
        if (sArr == null) {
            StringBuilder sb = this.f24580a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (sArr.length == 0) {
            StringBuilder sb2 = this.f24580a;
            sb2.append(sArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f24580a;
            sb3.append(sArr.length);
            sb3.append(", [");
            sb3.append(10);
            C7262i iVar = new C7262i(this.f24580a, this.f24581b + 1);
            for (short a : sArr) {
                iVar.mo34890a(a, (String) null);
            }
            mo34880a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public C7262i mo34895a(int[] iArr, String str) {
        m31319a(str);
        if (iArr == null) {
            StringBuilder sb = this.f24580a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (iArr.length == 0) {
            StringBuilder sb2 = this.f24580a;
            sb2.append(iArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f24580a;
            sb3.append(iArr.length);
            sb3.append(", [");
            sb3.append(10);
            C7262i iVar = new C7262i(this.f24580a, this.f24581b + 1);
            for (int a : iArr) {
                iVar.mo34883a(a, (String) null);
            }
            mo34880a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public C7262i mo34896a(long[] jArr, String str) {
        m31319a(str);
        if (jArr == null) {
            StringBuilder sb = this.f24580a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (jArr.length == 0) {
            StringBuilder sb2 = this.f24580a;
            sb2.append(jArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f24580a;
            sb3.append(jArr.length);
            sb3.append(", [");
            sb3.append(10);
            C7262i iVar = new C7262i(this.f24580a, this.f24581b + 1);
            for (long a : jArr) {
                iVar.mo34884a(a, (String) null);
            }
            mo34880a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public C7262i mo34894a(float[] fArr, String str) {
        m31319a(str);
        if (fArr == null) {
            StringBuilder sb = this.f24580a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (fArr.length == 0) {
            StringBuilder sb2 = this.f24580a;
            sb2.append(fArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f24580a;
            sb3.append(fArr.length);
            sb3.append(", [");
            sb3.append(10);
            C7262i iVar = new C7262i(this.f24580a, this.f24581b + 1);
            for (float a : fArr) {
                iVar.mo34882a(a, (String) null);
            }
            mo34880a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public C7262i mo34893a(double[] dArr, String str) {
        m31319a(str);
        if (dArr == null) {
            StringBuilder sb = this.f24580a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (dArr.length == 0) {
            StringBuilder sb2 = this.f24580a;
            sb2.append(dArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f24580a;
            sb3.append(dArr.length);
            sb3.append(", [");
            sb3.append(10);
            C7262i iVar = new C7262i(this.f24580a, this.f24581b + 1);
            for (double a : dArr) {
                iVar.mo34881a(a, (String) null);
            }
            mo34880a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public <K, V> C7262i mo34889a(Map<K, V> map, String str) {
        m31319a(str);
        if (map == null) {
            StringBuilder sb = this.f24580a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb2 = this.f24580a;
            sb2.append(map.size());
            sb2.append(", {}");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f24580a;
            sb3.append(map.size());
            sb3.append(", {");
            sb3.append(10);
            C7262i iVar = new C7262i(this.f24580a, this.f24581b + 1);
            C7262i iVar2 = new C7262i(this.f24580a, this.f24581b + 2);
            for (Entry entry : map.entrySet()) {
                iVar.mo34880a('(', (String) null);
                iVar2.mo34886a((T) entry.getKey(), (String) null);
                iVar2.mo34886a((T) entry.getValue(), (String) null);
                iVar.mo34880a(')', (String) null);
            }
            mo34880a('}', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public <T> C7262i mo34897a(T[] tArr, String str) {
        m31319a(str);
        if (tArr == null) {
            StringBuilder sb = this.f24580a;
            sb.append("null");
            sb.append(10);
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb2 = this.f24580a;
            sb2.append(tArr.length);
            sb2.append(", []");
            sb2.append(10);
            return this;
        } else {
            StringBuilder sb3 = this.f24580a;
            sb3.append(tArr.length);
            sb3.append(", [");
            sb3.append(10);
            C7262i iVar = new C7262i(this.f24580a, this.f24581b + 1);
            for (T a : tArr) {
                iVar.mo34886a(a, (String) null);
            }
            mo34880a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public <T> C7262i mo34888a(Collection<T> collection, String str) {
        if (collection != null) {
            return mo34897a((T[]) collection.toArray(), str);
        }
        m31319a(str);
        StringBuilder sb = this.f24580a;
        sb.append("null");
        sb.append(9);
        return this;
    }

    /* renamed from: a */
    public <T> C7262i mo34886a(T t, String str) {
        if (t == null) {
            StringBuilder sb = this.f24580a;
            sb.append("null");
            sb.append(10);
        } else if (t instanceof Byte) {
            mo34879a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            mo34891a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            mo34890a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            mo34883a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            mo34884a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            mo34882a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            mo34881a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            mo34887a((String) t, str);
        } else if (t instanceof Map) {
            mo34889a((Map) t, str);
        } else if (t instanceof List) {
            mo34888a((Collection<T>) (List) t, str);
        } else if (t instanceof C7267m) {
            mo34885a((C7267m) t, str);
        } else if (t instanceof byte[]) {
            mo34892a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            mo34886a((T) (boolean[]) t, str);
        } else if (t instanceof short[]) {
            mo34898a((short[]) t, str);
        } else if (t instanceof int[]) {
            mo34895a((int[]) t, str);
        } else if (t instanceof long[]) {
            mo34896a((long[]) t, str);
        } else if (t instanceof float[]) {
            mo34894a((float[]) t, str);
        } else if (t instanceof double[]) {
            mo34893a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            mo34897a((T[]) (Object[]) t, str);
        } else {
            throw new C7263j("write object error: unsupport type.");
        }
        return this;
    }

    /* renamed from: a */
    public C7262i mo34885a(C7267m mVar, String str) {
        mo34880a('{', str);
        if (mVar == null) {
            StringBuilder sb = this.f24580a;
            sb.append(9);
            sb.append("null");
        } else {
            mVar.mo34762a(this.f24580a, this.f24581b + 1);
        }
        mo34880a('}', (String) null);
        return this;
    }
}
