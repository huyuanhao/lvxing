package com.p522qq.taf.jce.dynamic;

import com.p522qq.taf.jce.JceInputStream.HeadData;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.qq.taf.jce.dynamic.DynamicInputStream */
public final class DynamicInputStream {
    /* renamed from: bs */
    private ByteBuffer f20328bs;
    private String sServerEncoding = "GBK";

    public DynamicInputStream(ByteBuffer byteBuffer) {
        this.f20328bs = byteBuffer;
    }

    public DynamicInputStream(byte[] bArr) {
        this.f20328bs = ByteBuffer.wrap(bArr);
    }

    private JceField readString(HeadData headData, int i) {
        String str;
        byte[] bArr = new byte[i];
        this.f20328bs.get(bArr);
        try {
            str = new String(bArr, this.sServerEncoding);
        } catch (UnsupportedEncodingException unused) {
            str = new String(bArr);
        }
        return JceField.create(str, headData.tag);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005b, code lost:
            return r0;
     */
    public com.p522qq.taf.jce.dynamic.JceField read() {
        /*
        r7 = this;
        r0 = 0
        com.qq.taf.jce.JceInputStream$HeadData r1 = new com.qq.taf.jce.JceInputStream$HeadData     // Catch:{ BufferUnderflowException -> 0x0125 }
        r1.m50951init()     // Catch:{ BufferUnderflowException -> 0x0125 }
        java.nio.ByteBuffer r2 = r7.f20328bs     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.p522qq.taf.jce.JceInputStream.readHead(r1, r2)     // Catch:{ BufferUnderflowException -> 0x0125 }
        byte r2 = r1.type     // Catch:{ BufferUnderflowException -> 0x0125 }
        r3 = 0
        switch(r2) {
            case 0: goto L_0x0119;
            case 1: goto L_0x010c;
            case 2: goto L_0x00ff;
            case 3: goto L_0x00f2;
            case 4: goto L_0x00e5;
            case 5: goto L_0x00d8;
            case 6: goto L_0x00c9;
            case 7: goto L_0x00be;
            case 8: goto L_0x0098;
            case 9: goto L_0x007a;
            case 10: goto L_0x005c;
            case 11: goto L_0x005b;
            case 12: goto L_0x0055;
            case 13: goto L_0x0013;
            default: goto L_0x0011;
        }     // Catch:{ BufferUnderflowException -> 0x0125 }
    L_0x0011:
        goto L_0x0125
    L_0x0013:
        int r2 = r1.tag     // Catch:{ BufferUnderflowException -> 0x0125 }
        java.nio.ByteBuffer r3 = r7.f20328bs     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.p522qq.taf.jce.JceInputStream.readHead(r1, r3)     // Catch:{ BufferUnderflowException -> 0x0125 }
        byte r3 = r1.type     // Catch:{ BufferUnderflowException -> 0x0125 }
        if (r3 != 0) goto L_0x0034
        com.qq.taf.jce.dynamic.JceField r1 = r7.read()     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.NumberField r1 = (com.p522qq.taf.jce.dynamic.NumberField) r1     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r1 = r1.intValue()     // Catch:{ BufferUnderflowException -> 0x0125 }
        byte[] r1 = new byte[r1]     // Catch:{ BufferUnderflowException -> 0x0125 }
        java.nio.ByteBuffer r3 = r7.f20328bs     // Catch:{ BufferUnderflowException -> 0x0125 }
        r3.get(r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r0 = com.p522qq.taf.jce.dynamic.JceField.create(r1, r2)     // Catch:{ BufferUnderflowException -> 0x0125 }
        return r0
    L_0x0034:
        com.qq.taf.jce.JceDecodeException r3 = new com.qq.taf.jce.JceDecodeException     // Catch:{ BufferUnderflowException -> 0x0125 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ BufferUnderflowException -> 0x0125 }
        r4.<init>()     // Catch:{ BufferUnderflowException -> 0x0125 }
        java.lang.String r5 = "type mismatch, simple_list only support byte, tag: "
        r4.append(r5)     // Catch:{ BufferUnderflowException -> 0x0125 }
        r4.append(r2)     // Catch:{ BufferUnderflowException -> 0x0125 }
        java.lang.String r2 = ", type: "
        r4.append(r2)     // Catch:{ BufferUnderflowException -> 0x0125 }
        byte r1 = r1.type     // Catch:{ BufferUnderflowException -> 0x0125 }
        r4.append(r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
        java.lang.String r1 = r4.toString()     // Catch:{ BufferUnderflowException -> 0x0125 }
        r3.m50943init(r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
        throw r3     // Catch:{ BufferUnderflowException -> 0x0125 }
    L_0x0055:
        int r1 = r1.tag     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r0 = com.p522qq.taf.jce.dynamic.JceField.createZero(r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
    L_0x005b:
        return r0
    L_0x005c:
        java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ BufferUnderflowException -> 0x0125 }
        r2.<init>()     // Catch:{ BufferUnderflowException -> 0x0125 }
    L_0x0061:
        com.qq.taf.jce.dynamic.JceField r4 = r7.read()     // Catch:{ BufferUnderflowException -> 0x0125 }
        if (r4 != 0) goto L_0x0076
        com.qq.taf.jce.dynamic.JceField[] r3 = new com.p522qq.taf.jce.dynamic.JceField[r3]     // Catch:{ BufferUnderflowException -> 0x0125 }
        java.lang.Object[] r2 = r2.toArray(r3)     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField[] r2 = (com.p522qq.taf.jce.dynamic.JceField[]) r2     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r1 = r1.tag     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r0 = com.p522qq.taf.jce.dynamic.JceField.createStruct(r2, r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
        return r0
    L_0x0076:
        r2.add(r4)     // Catch:{ BufferUnderflowException -> 0x0125 }
        goto L_0x0061
    L_0x007a:
        com.qq.taf.jce.dynamic.JceField r2 = r7.read()     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.NumberField r2 = (com.p522qq.taf.jce.dynamic.NumberField) r2     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r2 = r2.intValue()     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField[] r4 = new com.p522qq.taf.jce.dynamic.JceField[r2]     // Catch:{ BufferUnderflowException -> 0x0125 }
    L_0x0086:
        if (r3 >= r2) goto L_0x0091
        com.qq.taf.jce.dynamic.JceField r5 = r7.read()     // Catch:{ BufferUnderflowException -> 0x0125 }
        r4[r3] = r5     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r3 = r3 + 1
        goto L_0x0086
    L_0x0091:
        int r1 = r1.tag     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r0 = com.p522qq.taf.jce.dynamic.JceField.createList(r4, r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
        return r0
    L_0x0098:
        com.qq.taf.jce.dynamic.JceField r2 = r7.read()     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.NumberField r2 = (com.p522qq.taf.jce.dynamic.NumberField) r2     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r2 = r2.intValue()     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField[] r4 = new com.p522qq.taf.jce.dynamic.JceField[r2]     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField[] r5 = new com.p522qq.taf.jce.dynamic.JceField[r2]     // Catch:{ BufferUnderflowException -> 0x0125 }
    L_0x00a6:
        if (r3 >= r2) goto L_0x00b7
        com.qq.taf.jce.dynamic.JceField r6 = r7.read()     // Catch:{ BufferUnderflowException -> 0x0125 }
        r4[r3] = r6     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r6 = r7.read()     // Catch:{ BufferUnderflowException -> 0x0125 }
        r5[r3] = r6     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r3 = r3 + 1
        goto L_0x00a6
    L_0x00b7:
        int r1 = r1.tag     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r0 = com.p522qq.taf.jce.dynamic.JceField.createMap(r4, r5, r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
        return r0
    L_0x00be:
        java.nio.ByteBuffer r2 = r7.f20328bs     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r2 = r2.getInt()     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r0 = r7.readString(r1, r2)     // Catch:{ BufferUnderflowException -> 0x0125 }
        return r0
    L_0x00c9:
        java.nio.ByteBuffer r2 = r7.f20328bs     // Catch:{ BufferUnderflowException -> 0x0125 }
        byte r2 = r2.get()     // Catch:{ BufferUnderflowException -> 0x0125 }
        if (r2 >= 0) goto L_0x00d3
        int r2 = r2 + 256
    L_0x00d3:
        com.qq.taf.jce.dynamic.JceField r0 = r7.readString(r1, r2)     // Catch:{ BufferUnderflowException -> 0x0125 }
        return r0
    L_0x00d8:
        java.nio.ByteBuffer r2 = r7.f20328bs     // Catch:{ BufferUnderflowException -> 0x0125 }
        double r2 = r2.getDouble()     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r1 = r1.tag     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r0 = com.p522qq.taf.jce.dynamic.JceField.create(r2, r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
        return r0
    L_0x00e5:
        java.nio.ByteBuffer r2 = r7.f20328bs     // Catch:{ BufferUnderflowException -> 0x0125 }
        float r2 = r2.getFloat()     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r1 = r1.tag     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r0 = com.p522qq.taf.jce.dynamic.JceField.create(r2, r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
        return r0
    L_0x00f2:
        java.nio.ByteBuffer r2 = r7.f20328bs     // Catch:{ BufferUnderflowException -> 0x0125 }
        long r2 = r2.getLong()     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r1 = r1.tag     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r0 = com.p522qq.taf.jce.dynamic.JceField.create(r2, r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
        return r0
    L_0x00ff:
        java.nio.ByteBuffer r2 = r7.f20328bs     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r2 = r2.getInt()     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r1 = r1.tag     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r0 = com.p522qq.taf.jce.dynamic.JceField.create(r2, r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
        return r0
    L_0x010c:
        java.nio.ByteBuffer r2 = r7.f20328bs     // Catch:{ BufferUnderflowException -> 0x0125 }
        short r2 = r2.getShort()     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r1 = r1.tag     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r0 = com.p522qq.taf.jce.dynamic.JceField.create(r2, r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
        return r0
    L_0x0119:
        java.nio.ByteBuffer r2 = r7.f20328bs     // Catch:{ BufferUnderflowException -> 0x0125 }
        byte r2 = r2.get()     // Catch:{ BufferUnderflowException -> 0x0125 }
        int r1 = r1.tag     // Catch:{ BufferUnderflowException -> 0x0125 }
        com.qq.taf.jce.dynamic.JceField r0 = com.p522qq.taf.jce.dynamic.JceField.create(r2, r1)     // Catch:{ BufferUnderflowException -> 0x0125 }
    L_0x0125:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p522qq.taf.jce.dynamic.DynamicInputStream.read():com.qq.taf.jce.dynamic.JceField");
    }

    public int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }
}
