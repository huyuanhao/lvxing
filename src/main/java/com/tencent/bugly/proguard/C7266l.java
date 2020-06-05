package com.tencent.bugly.proguard;

import com.p522qq.taf.jce.JceStruct;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.l */
public class C7266l {
    /* renamed from: a */
    protected String f24586a;
    /* renamed from: b */
    private ByteBuffer f24587b;

    public C7266l(int i) {
        this.f24586a = "GBK";
        this.f24587b = ByteBuffer.allocate(i);
    }

    public C7266l() {
        this(128);
    }

    /* renamed from: a */
    public ByteBuffer mo34925a() {
        return this.f24587b;
    }

    /* renamed from: b */
    public byte[] mo34947b() {
        byte[] bArr = new byte[this.f24587b.position()];
        System.arraycopy(this.f24587b.array(), 0, bArr, 0, this.f24587b.position());
        return bArr;
    }

    /* renamed from: a */
    public void mo34929a(int i) {
        if (this.f24587b.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f24587b.capacity() + i) * 2);
            allocate.put(this.f24587b.array(), 0, this.f24587b.position());
            this.f24587b = allocate;
        }
    }

    /* renamed from: a */
    public void mo34926a(byte b, int i) {
        if (i < 15) {
            this.f24587b.put((byte) (b | (i << 4)));
        } else if (i < 256) {
            this.f24587b.put((byte) (b | -16));
            this.f24587b.put((byte) i);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("tag is too large: ");
            sb.append(i);
            throw new C7263j(sb.toString());
        }
    }

    /* renamed from: a */
    public void mo34938a(boolean z, int i) {
        mo34946b(z ? (byte) 1 : 0, i);
    }

    /* renamed from: b */
    public void mo34946b(byte b, int i) {
        mo34929a(3);
        if (b == 0) {
            mo34926a((byte) JceStruct.ZERO_TAG, i);
            return;
        }
        mo34926a(0, i);
        this.f24587b.put(b);
    }

    /* renamed from: a */
    public void mo34937a(short s, int i) {
        mo34929a(4);
        if (s < -128 || s > 127) {
            mo34926a(1, i);
            this.f24587b.putShort(s);
            return;
        }
        mo34946b((byte) s, i);
    }

    /* renamed from: a */
    public void mo34930a(int i, int i2) {
        mo34929a(6);
        if (i < -32768 || i > 32767) {
            mo34926a(2, i2);
            this.f24587b.putInt(i);
            return;
        }
        mo34937a((short) i, i2);
    }

    /* renamed from: a */
    public void mo34931a(long j, int i) {
        mo34929a(10);
        if (j < -2147483648L || j > 2147483647L) {
            mo34926a(3, i);
            this.f24587b.putLong(j);
            return;
        }
        mo34930a((int) j, i);
    }

    /* renamed from: a */
    public void mo34928a(float f, int i) {
        mo34929a(6);
        mo34926a(4, i);
        this.f24587b.putFloat(f);
    }

    /* renamed from: a */
    public void mo34927a(double d, int i) {
        mo34929a(10);
        mo34926a(5, i);
        this.f24587b.putDouble(d);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v1, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v3, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v4, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=null, for r3v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v5
  assigns: [byte[]]
  uses: [java.lang.String, ?[], byte[]]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: a */
    public void mo34934a(? r3, int r4) {
        /*
        r2 = this;
        java.lang.String r0 = r2.f24586a     // Catch:{ UnsupportedEncodingException -> 0x0007 }
        byte[] r3 = r3.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0007 }
        goto L_0x000b
    L_0x0007:
        byte[] r3 = r3.getBytes()
    L_0x000b:
        int r0 = r3.length
        int r0 = r0 + 10
        r2.mo34929a(r0)
        int r0 = r3.length
        r1 = 255(0xff, float:3.57E-43)
        if (r0 <= r1) goto L_0x0026
        r0 = 7
        r2.mo34926a(r0, r4)
        java.nio.ByteBuffer r4 = r2.f24587b
        int r0 = r3.length
        r4.putInt(r0)
        java.nio.ByteBuffer r4 = r2.f24587b
        r4.put(r3)
        goto L_0x0036
    L_0x0026:
        r0 = 6
        r2.mo34926a(r0, r4)
        java.nio.ByteBuffer r4 = r2.f24587b
        int r0 = r3.length
        byte r0 = (byte) r0
        r4.put(r0)
        java.nio.ByteBuffer r4 = r2.f24587b
        r4.put(r3)
    L_0x0036:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7266l.mo34934a(java.lang.String, int):void");
    }

    /* renamed from: a */
    public <K, V> void mo34936a(Map<K, V> map, int i) {
        int i2;
        mo34929a(8);
        mo34926a(8, i);
        if (map == null) {
            i2 = 0;
        } else {
            i2 = map.size();
        }
        mo34930a(i2, 0);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                mo34933a(entry.getKey(), 0);
                mo34933a(entry.getValue(), 1);
            }
        }
    }

    /* renamed from: a */
    public void mo34945a(boolean[] zArr, int i) {
        mo34929a(8);
        mo34926a(9, i);
        mo34930a(zArr.length, 0);
        for (boolean a : zArr) {
            mo34938a(a, 0);
        }
    }

    /* renamed from: a */
    public void mo34939a(byte[] bArr, int i) {
        mo34929a(bArr.length + 8);
        mo34926a((byte) JceStruct.SIMPLE_LIST, i);
        mo34926a(0, 0);
        mo34930a(bArr.length, 0);
        this.f24587b.put(bArr);
    }

    /* renamed from: a */
    public void mo34944a(short[] sArr, int i) {
        mo34929a(8);
        mo34926a(9, i);
        mo34930a(sArr.length, 0);
        for (short a : sArr) {
            mo34937a(a, 0);
        }
    }

    /* renamed from: a */
    public void mo34942a(int[] iArr, int i) {
        mo34929a(8);
        mo34926a(9, i);
        mo34930a(iArr.length, 0);
        for (int a : iArr) {
            mo34930a(a, 0);
        }
    }

    /* renamed from: a */
    public void mo34943a(long[] jArr, int i) {
        mo34929a(8);
        mo34926a(9, i);
        mo34930a(jArr.length, 0);
        for (long a : jArr) {
            mo34931a(a, 0);
        }
    }

    /* renamed from: a */
    public void mo34941a(float[] fArr, int i) {
        mo34929a(8);
        mo34926a(9, i);
        mo34930a(fArr.length, 0);
        for (float a : fArr) {
            mo34928a(a, 0);
        }
    }

    /* renamed from: a */
    public void mo34940a(double[] dArr, int i) {
        mo34929a(8);
        mo34926a(9, i);
        mo34930a(dArr.length, 0);
        for (double a : dArr) {
            mo34927a(a, 0);
        }
    }

    /* renamed from: a */
    private void m31372a(Object[] objArr, int i) {
        mo34929a(8);
        mo34926a(9, i);
        mo34930a(objArr.length, 0);
        for (Object a : objArr) {
            mo34933a(a, 0);
        }
    }

    /* renamed from: a */
    public <T> void mo34935a(Collection<T> collection, int i) {
        int i2;
        mo34929a(8);
        mo34926a(9, i);
        if (collection == null) {
            i2 = 0;
        } else {
            i2 = collection.size();
        }
        mo34930a(i2, 0);
        if (collection != null) {
            for (T a : collection) {
                mo34933a((Object) a, 0);
            }
        }
    }

    /* renamed from: a */
    public void mo34932a(C7267m mVar, int i) {
        mo34929a(2);
        mo34926a(10, i);
        mVar.mo34761a(this);
        mo34929a(2);
        mo34926a((byte) JceStruct.STRUCT_END, 0);
    }

    /* renamed from: a */
    public void mo34933a(Object obj, int i) {
        if (obj instanceof Byte) {
            mo34946b(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            mo34938a(((Boolean) obj).booleanValue(), i);
        } else if (obj instanceof Short) {
            mo34937a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            mo34930a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            mo34931a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            mo34928a(((Float) obj).floatValue(), i);
        } else if (obj instanceof Double) {
            mo34927a(((Double) obj).doubleValue(), i);
        } else if (obj instanceof String) {
            mo34934a((String) obj, i);
        } else if (obj instanceof Map) {
            mo34936a((Map) obj, i);
        } else if (obj instanceof List) {
            mo34935a((Collection<T>) (List) obj, i);
        } else if (obj instanceof C7267m) {
            mo34932a((C7267m) obj, i);
        } else if (obj instanceof byte[]) {
            mo34939a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            mo34945a((boolean[]) obj, i);
        } else if (obj instanceof short[]) {
            mo34944a((short[]) obj, i);
        } else if (obj instanceof int[]) {
            mo34942a((int[]) obj, i);
        } else if (obj instanceof long[]) {
            mo34943a((long[]) obj, i);
        } else if (obj instanceof float[]) {
            mo34941a((float[]) obj, i);
        } else if (obj instanceof double[]) {
            mo34940a((double[]) obj, i);
        } else if (obj.getClass().isArray()) {
            m31372a((Object[]) obj, i);
        } else if (obj instanceof Collection) {
            mo34935a((Collection) obj, i);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("write object error: unsupport type. ");
            sb.append(obj.getClass());
            throw new C7263j(sb.toString());
        }
    }

    /* renamed from: a */
    public int mo34924a(String str) {
        this.f24586a = str;
        return 0;
    }
}
