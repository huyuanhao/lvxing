package com.p522qq.taf.jce;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.qq.taf.jce.JceOutputStream */
public class JceOutputStream {
    /* renamed from: bs */
    private ByteBuffer f20327bs;
    protected String sServerEncoding;

    public JceOutputStream(ByteBuffer byteBuffer) {
        this.sServerEncoding = "GBK";
        this.f20327bs = byteBuffer;
    }

    public JceOutputStream(int i) {
        this.sServerEncoding = "GBK";
        this.f20327bs = ByteBuffer.allocate(i);
    }

    public JceOutputStream() {
        this(128);
    }

    public ByteBuffer getByteBuffer() {
        return this.f20327bs;
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[this.f20327bs.position()];
        System.arraycopy(this.f20327bs.array(), 0, bArr, 0, this.f20327bs.position());
        return bArr;
    }

    public void reserve(int i) {
        if (this.f20327bs.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f20327bs.capacity() + i) * 2);
            allocate.put(this.f20327bs.array(), 0, this.f20327bs.position());
            this.f20327bs = allocate;
        }
    }

    public void writeHead(byte b, int i) {
        if (i < 15) {
            this.f20327bs.put((byte) (b | (i << 4)));
        } else if (i < 256) {
            this.f20327bs.put((byte) (b | -16));
            this.f20327bs.put((byte) i);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("tag is too large: ");
            sb.append(i);
            throw new JceEncodeException(sb.toString());
        }
    }

    public void write(boolean z, int i) {
        write(z ? (byte) 1 : 0, i);
    }

    public void write(byte b, int i) {
        reserve(3);
        if (b == 0) {
            writeHead(JceStruct.ZERO_TAG, i);
            return;
        }
        writeHead(0, i);
        this.f20327bs.put(b);
    }

    public void write(short s, int i) {
        reserve(4);
        if (s < -128 || s > 127) {
            writeHead(1, i);
            this.f20327bs.putShort(s);
            return;
        }
        write((byte) s, i);
    }

    public void write(int i, int i2) {
        reserve(6);
        if (i < -32768 || i > 32767) {
            writeHead(2, i2);
            this.f20327bs.putInt(i);
            return;
        }
        write((short) i, i2);
    }

    public void write(long j, int i) {
        reserve(10);
        if (j < -2147483648L || j > 2147483647L) {
            writeHead(3, i);
            this.f20327bs.putLong(j);
            return;
        }
        write((int) j, i);
    }

    public void write(float f, int i) {
        reserve(6);
        writeHead(4, i);
        this.f20327bs.putFloat(f);
    }

    public void write(double d, int i) {
        reserve(10);
        writeHead(5, i);
        this.f20327bs.putDouble(d);
    }

    public void writeStringByte(String str, int i) {
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str);
        reserve(hexStr2Bytes.length + 10);
        if (hexStr2Bytes.length > 255) {
            writeHead(7, i);
            this.f20327bs.putInt(hexStr2Bytes.length);
            this.f20327bs.put(hexStr2Bytes);
            return;
        }
        writeHead(6, i);
        this.f20327bs.put((byte) hexStr2Bytes.length);
        this.f20327bs.put(hexStr2Bytes);
    }

    public void writeByteString(String str, int i) {
        reserve(str.length() + 10);
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str);
        if (hexStr2Bytes.length > 255) {
            writeHead(7, i);
            this.f20327bs.putInt(hexStr2Bytes.length);
            this.f20327bs.put(hexStr2Bytes);
            return;
        }
        writeHead(6, i);
        this.f20327bs.put((byte) hexStr2Bytes.length);
        this.f20327bs.put(hexStr2Bytes);
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
    public void write(? r3, int r4) {
        /*
        r2 = this;
        java.lang.String r0 = r2.sServerEncoding     // Catch:{ UnsupportedEncodingException -> 0x0007 }
        byte[] r3 = r3.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0007 }
        goto L_0x000b
    L_0x0007:
        byte[] r3 = r3.getBytes()
    L_0x000b:
        int r0 = r3.length
        int r0 = r0 + 10
        r2.reserve(r0)
        int r0 = r3.length
        r1 = 255(0xff, float:3.57E-43)
        if (r0 <= r1) goto L_0x0026
        r0 = 7
        r2.writeHead(r0, r4)
        java.nio.ByteBuffer r4 = r2.f20327bs
        int r0 = r3.length
        r4.putInt(r0)
        java.nio.ByteBuffer r4 = r2.f20327bs
        r4.put(r3)
        goto L_0x0036
    L_0x0026:
        r0 = 6
        r2.writeHead(r0, r4)
        java.nio.ByteBuffer r4 = r2.f20327bs
        int r0 = r3.length
        byte r0 = (byte) r0
        r4.put(r0)
        java.nio.ByteBuffer r4 = r2.f20327bs
        r4.put(r3)
    L_0x0036:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p522qq.taf.jce.JceOutputStream.write(java.lang.String, int):void");
    }

    public <K, V> void write(Map<K, V> map, int i) {
        int i2;
        reserve(8);
        writeHead(8, i);
        if (map == null) {
            i2 = 0;
        } else {
            i2 = map.size();
        }
        write(i2, 0);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                write(entry.getKey(), 0);
                write(entry.getValue(), 1);
            }
        }
    }

    public void write(boolean[] zArr, int i) {
        reserve(8);
        writeHead(9, i);
        write(zArr.length, 0);
        for (boolean write : zArr) {
            write(write, 0);
        }
    }

    public void write(byte[] bArr, int i) {
        reserve(bArr.length + 8);
        writeHead(JceStruct.SIMPLE_LIST, i);
        writeHead(0, 0);
        write(bArr.length, 0);
        this.f20327bs.put(bArr);
    }

    public void write(short[] sArr, int i) {
        reserve(8);
        writeHead(9, i);
        write(sArr.length, 0);
        for (short write : sArr) {
            write(write, 0);
        }
    }

    public void write(int[] iArr, int i) {
        reserve(8);
        writeHead(9, i);
        write(iArr.length, 0);
        for (int write : iArr) {
            write(write, 0);
        }
    }

    public void write(long[] jArr, int i) {
        reserve(8);
        writeHead(9, i);
        write(jArr.length, 0);
        for (long write : jArr) {
            write(write, 0);
        }
    }

    public void write(float[] fArr, int i) {
        reserve(8);
        writeHead(9, i);
        write(fArr.length, 0);
        for (float write : fArr) {
            write(write, 0);
        }
    }

    public void write(double[] dArr, int i) {
        reserve(8);
        writeHead(9, i);
        write(dArr.length, 0);
        for (double write : dArr) {
            write(write, 0);
        }
    }

    public <T> void write(T[] tArr, int i) {
        writeArray(tArr, i);
    }

    private void writeArray(Object[] objArr, int i) {
        reserve(8);
        writeHead(9, i);
        write(objArr.length, 0);
        for (Object write : objArr) {
            write(write, 0);
        }
    }

    public <T> void write(Collection<T> collection, int i) {
        int i2;
        reserve(8);
        writeHead(9, i);
        if (collection == null) {
            i2 = 0;
        } else {
            i2 = collection.size();
        }
        write(i2, 0);
        if (collection != null) {
            for (T write : collection) {
                write((Object) write, 0);
            }
        }
    }

    public void write(JceStruct jceStruct, int i) {
        reserve(2);
        writeHead(10, i);
        jceStruct.writeTo(this);
        reserve(2);
        writeHead(JceStruct.STRUCT_END, 0);
    }

    public void write(Byte b, int i) {
        write(b.byteValue(), i);
    }

    public void write(Boolean bool, int i) {
        write(bool.booleanValue(), i);
    }

    public void write(Short sh, int i) {
        write(sh.shortValue(), i);
    }

    public void write(Integer num, int i) {
        write(num.intValue(), i);
    }

    public void write(Long l, int i) {
        write(l.longValue(), i);
    }

    public void write(Float f, int i) {
        write(f.floatValue(), i);
    }

    public void write(Double d, int i) {
        write(d.doubleValue(), i);
    }

    public void write(Object obj, int i) {
        if (obj instanceof Byte) {
            write(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            write(((Boolean) obj).booleanValue(), i);
        } else if (obj instanceof Short) {
            write(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            write(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            write(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            write(((Float) obj).floatValue(), i);
        } else if (obj instanceof Double) {
            write(((Double) obj).doubleValue(), i);
        } else if (obj instanceof String) {
            write((String) obj, i);
        } else if (obj instanceof Map) {
            write((Map) obj, i);
        } else if (obj instanceof List) {
            write((Collection<T>) (List) obj, i);
        } else if (obj instanceof JceStruct) {
            write((JceStruct) obj, i);
        } else if (obj instanceof byte[]) {
            write((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            write((boolean[]) obj, i);
        } else if (obj instanceof short[]) {
            write((short[]) obj, i);
        } else if (obj instanceof int[]) {
            write((int[]) obj, i);
        } else if (obj instanceof long[]) {
            write((long[]) obj, i);
        } else if (obj instanceof float[]) {
            write((float[]) obj, i);
        } else if (obj instanceof double[]) {
            write((double[]) obj, i);
        } else if (obj.getClass().isArray()) {
            writeArray((Object[]) obj, i);
        } else if (obj instanceof Collection) {
            write((Collection) obj, i);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("write object error: unsupport type. ");
            sb.append(obj.getClass());
            throw new JceEncodeException(sb.toString());
        }
    }

    public int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public static void main(String[] strArr) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.write(1311768467283714885L, 0);
        System.out.println(HexUtil.bytes2HexStr(jceOutputStream.getByteBuffer().array()));
        System.out.println(Arrays.toString(jceOutputStream.toByteArray()));
    }
}
