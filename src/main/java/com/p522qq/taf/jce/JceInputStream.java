package com.p522qq.taf.jce;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.qq.taf.jce.JceInputStream */
public final class JceInputStream {
    /* renamed from: bs */
    private ByteBuffer f20326bs;
    protected String sServerEncoding = "GBK";

    /* renamed from: com.qq.taf.jce.JceInputStream$HeadData */
    public static class HeadData {
        public int tag;
        public byte type;

        public void clear() {
            this.type = 0;
            this.tag = 0;
        }
    }

    public static void main(String[] strArr) {
    }

    public JceInputStream() {
    }

    public JceInputStream(ByteBuffer byteBuffer) {
        this.f20326bs = byteBuffer;
    }

    public JceInputStream(byte[] bArr) {
        this.f20326bs = ByteBuffer.wrap(bArr);
    }

    public JceInputStream(byte[] bArr, int i) {
        this.f20326bs = ByteBuffer.wrap(bArr);
        this.f20326bs.position(i);
    }

    public void warp(byte[] bArr) {
        wrap(bArr);
    }

    public void wrap(byte[] bArr) {
        this.f20326bs = ByteBuffer.wrap(bArr);
    }

    public static int readHead(HeadData headData, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        headData.type = (byte) (b & 15);
        headData.tag = (b & -16) >> 4;
        if (headData.tag != 15) {
            return 1;
        }
        headData.tag = byteBuffer.get() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
        return 2;
    }

    public void readHead(HeadData headData) {
        readHead(headData, this.f20326bs);
    }

    private int peakHead(HeadData headData) {
        return readHead(headData, this.f20326bs.duplicate());
    }

    private void skip(int i) {
        ByteBuffer byteBuffer = this.f20326bs;
        byteBuffer.position(byteBuffer.position() + i);
    }

    public boolean skipToTag(int i) {
        boolean z = false;
        try {
            HeadData headData = new HeadData();
            while (true) {
                int peakHead = peakHead(headData);
                if (headData.type == 11) {
                    return false;
                }
                if (i <= headData.tag) {
                    if (i == headData.tag) {
                        z = true;
                    }
                    return z;
                }
                skip(peakHead);
                skipField(headData.type);
            }
        } catch (JceDecodeException | BufferUnderflowException unused) {
            return false;
        }
    }

    public void skipToStructEnd() {
        HeadData headData = new HeadData();
        do {
            readHead(headData);
            skipField(headData.type);
        } while (headData.type != 11);
    }

    private void skipField() {
        HeadData headData = new HeadData();
        readHead(headData);
        skipField(headData.type);
    }

    private void skipField(byte b) {
        int i = 0;
        switch (b) {
            case 0:
                skip(1);
                return;
            case 1:
                skip(2);
                return;
            case 2:
                skip(4);
                return;
            case 3:
                skip(8);
                return;
            case 4:
                skip(4);
                return;
            case 5:
                skip(8);
                return;
            case 6:
                int i2 = this.f20326bs.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                skip(i2);
                return;
            case 7:
                skip(this.f20326bs.getInt());
                return;
            case 8:
                int read = read(0, 0, true);
                while (i < read * 2) {
                    skipField();
                    i++;
                }
                return;
            case 9:
                int read2 = read(0, 0, true);
                while (i < read2) {
                    skipField();
                    i++;
                }
                return;
            case 10:
                skipToStructEnd();
                return;
            case 11:
            case 12:
                return;
            case 13:
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type == 0) {
                    skip(read(0, 0, true));
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("skipField with invalid type, type value: ");
                sb.append(b);
                sb.append(", ");
                sb.append(headData.type);
                throw new JceDecodeException(sb.toString());
            default:
                throw new JceDecodeException("invalid type.");
        }
    }

    public boolean read(boolean z, int i, boolean z2) {
        return read(0, i, z2) != 0;
    }

    public byte read(byte b, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            byte b2 = headData.type;
            if (b2 == 0) {
                return this.f20326bs.get();
            }
            if (b2 == 12) {
                return 0;
            }
            throw new JceDecodeException("type mismatch.");
        } else if (!z) {
            return b;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public short read(short s, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            byte b = headData.type;
            if (b == 0) {
                return (short) this.f20326bs.get();
            }
            if (b == 1) {
                return this.f20326bs.getShort();
            }
            if (b == 12) {
                return 0;
            }
            throw new JceDecodeException("type mismatch.");
        } else if (!z) {
            return s;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public int read(int i, int i2, boolean z) {
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            byte b = headData.type;
            if (b == 0) {
                return this.f20326bs.get();
            }
            if (b == 1) {
                return this.f20326bs.getShort();
            }
            if (b == 2) {
                return this.f20326bs.getInt();
            }
            if (b == 12) {
                return 0;
            }
            throw new JceDecodeException("type mismatch.");
        } else if (!z) {
            return i;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public long read(long j, int i, boolean z) {
        int i2;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            byte b = headData.type;
            if (b == 0) {
                i2 = this.f20326bs.get();
            } else if (b == 1) {
                i2 = this.f20326bs.getShort();
            } else if (b == 2) {
                i2 = this.f20326bs.getInt();
            } else if (b == 3) {
                return this.f20326bs.getLong();
            } else {
                if (b == 12) {
                    return 0;
                }
                throw new JceDecodeException("type mismatch.");
            }
            return (long) i2;
        } else if (!z) {
            return j;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public float read(float f, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            byte b = headData.type;
            if (b == 4) {
                return this.f20326bs.getFloat();
            }
            if (b == 12) {
                return 0.0f;
            }
            throw new JceDecodeException("type mismatch.");
        } else if (!z) {
            return f;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public double read(double d, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            byte b = headData.type;
            if (b == 4) {
                return (double) this.f20326bs.getFloat();
            }
            if (b == 5) {
                return this.f20326bs.getDouble();
            }
            if (b == 12) {
                return 0.0d;
            }
            throw new JceDecodeException("type mismatch.");
        } else if (!z) {
            return d;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public String readByteString(String str, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            byte b = headData.type;
            if (b == 6) {
                int i2 = this.f20326bs.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.f20326bs.get(bArr);
                return HexUtil.bytes2HexStr(bArr);
            } else if (b == 7) {
                int i3 = this.f20326bs.getInt();
                if (i3 > 104857600 || i3 < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("String too long: ");
                    sb.append(i3);
                    throw new JceDecodeException(sb.toString());
                }
                byte[] bArr2 = new byte[i3];
                this.f20326bs.get(bArr2);
                return HexUtil.bytes2HexStr(bArr2);
            } else {
                throw new JceDecodeException("type mismatch.");
            }
        } else if (!z) {
            return str;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public String read(String str, int i, boolean z) {
        String str2;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            byte b = headData.type;
            if (b == 6) {
                int i2 = this.f20326bs.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.f20326bs.get(bArr);
                try {
                    str2 = new String(bArr, this.sServerEncoding);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(bArr);
                }
            } else if (b == 7) {
                int i3 = this.f20326bs.getInt();
                if (i3 > 104857600 || i3 < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("String too long: ");
                    sb.append(i3);
                    throw new JceDecodeException(sb.toString());
                }
                byte[] bArr2 = new byte[i3];
                this.f20326bs.get(bArr2);
                try {
                    str2 = new String(bArr2, this.sServerEncoding);
                } catch (UnsupportedEncodingException unused2) {
                    str2 = new String(bArr2);
                }
            } else {
                throw new JceDecodeException("type mismatch.");
            }
            return str2;
        } else if (!z) {
            return str;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public String readString(int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            byte b = headData.type;
            if (b == 6) {
                int i2 = this.f20326bs.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.f20326bs.get(bArr);
                try {
                    return new String(bArr, this.sServerEncoding);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr);
                }
            } else if (b == 7) {
                int i3 = this.f20326bs.getInt();
                if (i3 > 104857600 || i3 < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("String too long: ");
                    sb.append(i3);
                    throw new JceDecodeException(sb.toString());
                }
                byte[] bArr2 = new byte[i3];
                this.f20326bs.get(bArr2);
                try {
                    return new String(bArr2, this.sServerEncoding);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            } else {
                throw new JceDecodeException("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public String[] read(String[] strArr, int i, boolean z) {
        return (String[]) readArray((T[]) strArr, i, z);
    }

    public Map<String, String> readStringMap(int i, boolean z) {
        HashMap hashMap = new HashMap();
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 8) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    for (int i2 = 0; i2 < read; i2++) {
                        hashMap.put(readString(0, true), readString(1, true));
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("size invalid: ");
                    sb.append(read);
                    throw new JceDecodeException(sb.toString());
                }
            } else {
                throw new JceDecodeException("type mismatch.");
            }
        } else if (z) {
            throw new JceDecodeException("require field not exist.");
        }
        return hashMap;
    }

    public <K, V> HashMap<K, V> readMap(Map<K, V> map, int i, boolean z) {
        return (HashMap) readMap(new HashMap(), map, i, z);
    }

    private <K, V> Map<K, V> readMap(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 8) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    for (int i2 = 0; i2 < read; i2++) {
                        map.put(read((T) key, 0, true), read((T) value, 1, true));
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("size invalid: ");
                    sb.append(read);
                    throw new JceDecodeException(sb.toString());
                }
            } else {
                throw new JceDecodeException("type mismatch.");
            }
        } else if (z) {
            throw new JceDecodeException("require field not exist.");
        }
        return map;
    }

    public List readList(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            String str = "type mismatch.";
            if (headData.type == 9) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    for (int i2 = 0; i2 < read; i2++) {
                        HeadData headData2 = new HeadData();
                        readHead(headData2);
                        switch (headData2.type) {
                            case 0:
                                skip(1);
                                break;
                            case 1:
                                skip(2);
                                break;
                            case 2:
                                skip(4);
                                break;
                            case 3:
                                skip(8);
                                break;
                            case 4:
                                skip(4);
                                break;
                            case 5:
                                skip(8);
                                break;
                            case 6:
                                int i3 = this.f20326bs.get();
                                if (i3 < 0) {
                                    i3 += 256;
                                }
                                skip(i3);
                                break;
                            case 7:
                                skip(this.f20326bs.getInt());
                                break;
                            case 8:
                            case 9:
                                break;
                            case 10:
                                try {
                                    JceStruct jceStruct = (JceStruct) Class.forName(JceStruct.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);
                                    jceStruct.readFrom(this);
                                    skipToStructEnd();
                                    arrayList.add(jceStruct);
                                    break;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append(e);
                                    throw new JceDecodeException(sb.toString());
                                }
                            case 12:
                                arrayList.add(new Integer(0));
                                break;
                            default:
                                throw new JceDecodeException(str);
                        }
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("size invalid: ");
                    sb2.append(read);
                    throw new JceDecodeException(sb2.toString());
                }
            } else {
                throw new JceDecodeException(str);
            }
        } else if (z) {
            throw new JceDecodeException("require field not exist.");
        }
        return arrayList;
    }

    public boolean[] read(boolean[] zArr, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 9) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    boolean[] zArr2 = new boolean[read];
                    for (int i2 = 0; i2 < read; i2++) {
                        zArr2[i2] = read(zArr2[0], 0, true);
                    }
                    return zArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(read);
                throw new JceDecodeException(sb.toString());
            }
            throw new JceDecodeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public byte[] read(byte[] bArr, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            byte b = headData.type;
            if (b == 9) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    byte[] bArr2 = new byte[read];
                    for (int i2 = 0; i2 < read; i2++) {
                        bArr2[i2] = read(bArr2[0], 0, true);
                    }
                    return bArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(read);
                throw new JceDecodeException(sb.toString());
            } else if (b == 13) {
                HeadData headData2 = new HeadData();
                readHead(headData2);
                String str = ", ";
                String str2 = ", type: ";
                if (headData2.type == 0) {
                    int read2 = read(0, 0, true);
                    if (read2 >= 0) {
                        byte[] bArr3 = new byte[read2];
                        this.f20326bs.get(bArr3);
                        return bArr3;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("invalid size, tag: ");
                    sb2.append(i);
                    sb2.append(str2);
                    sb2.append(headData.type);
                    sb2.append(str);
                    sb2.append(headData2.type);
                    sb2.append(", size: ");
                    sb2.append(read2);
                    throw new JceDecodeException(sb2.toString());
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("type mismatch, tag: ");
                sb3.append(i);
                sb3.append(str2);
                sb3.append(headData.type);
                sb3.append(str);
                sb3.append(headData2.type);
                throw new JceDecodeException(sb3.toString());
            } else {
                throw new JceDecodeException("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public short[] read(short[] sArr, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 9) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    short[] sArr2 = new short[read];
                    for (int i2 = 0; i2 < read; i2++) {
                        sArr2[i2] = read(sArr2[0], 0, true);
                    }
                    return sArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(read);
                throw new JceDecodeException(sb.toString());
            }
            throw new JceDecodeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public int[] read(int[] iArr, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 9) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    int[] iArr2 = new int[read];
                    for (int i2 = 0; i2 < read; i2++) {
                        iArr2[i2] = read(iArr2[0], 0, true);
                    }
                    return iArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(read);
                throw new JceDecodeException(sb.toString());
            }
            throw new JceDecodeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public long[] read(long[] jArr, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 9) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    long[] jArr2 = new long[read];
                    for (int i2 = 0; i2 < read; i2++) {
                        jArr2[i2] = read(jArr2[0], 0, true);
                    }
                    return jArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(read);
                throw new JceDecodeException(sb.toString());
            }
            throw new JceDecodeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public float[] read(float[] fArr, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 9) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    float[] fArr2 = new float[read];
                    for (int i2 = 0; i2 < read; i2++) {
                        fArr2[i2] = read(fArr2[0], 0, true);
                    }
                    return fArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(read);
                throw new JceDecodeException(sb.toString());
            }
            throw new JceDecodeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public double[] read(double[] dArr, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 9) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    double[] dArr2 = new double[read];
                    for (int i2 = 0; i2 < read; i2++) {
                        dArr2[i2] = read(dArr2[0], 0, true);
                    }
                    return dArr2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(read);
                throw new JceDecodeException(sb.toString());
            }
            throw new JceDecodeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public <T> T[] readArray(T[] tArr, int i, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return readArrayImpl(tArr[0], i, z);
        }
        throw new JceDecodeException("unable to get type of key and value.");
    }

    public <T> List<T> readArray(List<T> list, int i, boolean z) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        Object[] readArrayImpl = readArrayImpl(list.get(0), i, z);
        if (readArrayImpl == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object add : readArrayImpl) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private <T> T[] readArrayImpl(T t, int i, boolean z) {
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 9) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    T[] tArr = (Object[]) Array.newInstance(t.getClass(), read);
                    for (int i2 = 0; i2 < read; i2++) {
                        tArr[i2] = read(t, 0, true);
                    }
                    return tArr;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("size invalid: ");
                sb.append(read);
                throw new JceDecodeException(sb.toString());
            }
            throw new JceDecodeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public JceStruct directRead(JceStruct jceStruct, int i, boolean z) {
        if (skipToTag(i)) {
            try {
                JceStruct newInit = jceStruct.newInit();
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type == 10) {
                    newInit.readFrom(this);
                    skipToStructEnd();
                    return newInit;
                }
                throw new JceDecodeException("type mismatch.");
            } catch (Exception e) {
                throw new JceDecodeException(e.getMessage());
            }
        } else if (!z) {
            return null;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public JceStruct read(JceStruct jceStruct, int i, boolean z) {
        if (skipToTag(i)) {
            try {
                JceStruct jceStruct2 = (JceStruct) jceStruct.getClass().newInstance();
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type == 10) {
                    jceStruct2.readFrom(this);
                    skipToStructEnd();
                    return jceStruct2;
                }
                throw new JceDecodeException("type mismatch.");
            } catch (Exception e) {
                throw new JceDecodeException(e.getMessage());
            }
        } else if (!z) {
            return null;
        } else {
            throw new JceDecodeException("require field not exist.");
        }
    }

    public JceStruct[] read(JceStruct[] jceStructArr, int i, boolean z) {
        return (JceStruct[]) readArray((T[]) jceStructArr, i, z);
    }

    public <T> Object read(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(read(0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(read(false, i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(read(0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(read(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(read(0, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(read(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(read(0.0d, i, z));
        }
        if (t instanceof String) {
            return readString(i, z);
        }
        if (t instanceof Map) {
            return readMap((Map) t, i, z);
        }
        if (t instanceof List) {
            return readArray((List) t, i, z);
        }
        if (t instanceof JceStruct) {
            return read((JceStruct) t, i, z);
        }
        if (!t.getClass().isArray()) {
            throw new JceDecodeException("read object error: unsupport type.");
        } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
            return read((byte[]) null, i, z);
        } else {
            if (t instanceof boolean[]) {
                return read((boolean[]) null, i, z);
            }
            if (t instanceof short[]) {
                return read((short[]) null, i, z);
            }
            if (t instanceof int[]) {
                return read((int[]) null, i, z);
            }
            if (t instanceof long[]) {
                return read((long[]) null, i, z);
            }
            if (t instanceof float[]) {
                return read((float[]) null, i, z);
            }
            if (t instanceof double[]) {
                return read((double[]) null, i, z);
            }
            return readArray((T[]) (Object[]) t, i, z);
        }
    }

    public int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public ByteBuffer getBs() {
        return this.f20326bs;
    }
}
