package com.p522qq.taf;

import com.p522qq.jce.wup.WupHexUtil;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qq.taf.RequestPacket */
public final class RequestPacket extends JceStruct {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static Map<String, String> cache_context;
    static byte[] cache_sBuffer;
    public byte cPacketType = 0;
    public Map<String, String> context = new HashMap();
    public int iMessageType = 0;
    public int iRequestId = 0;
    public int iTimeout = 0;
    public short iVersion = 0;
    public byte[] sBuffer = new byte[0];
    public String sFuncName = null;
    public String sServantName = null;
    public Map<String, String> status = new HashMap();

    public RequestPacket() {
    }

    public RequestPacket(short s, byte b, int i, int i2, String str, String str2, byte[] bArr, int i3, Map<String, String> map, Map<String, String> map2) {
        this.iVersion = s;
        this.cPacketType = b;
        this.iMessageType = i;
        this.iRequestId = i2;
        this.sServantName = str;
        this.sFuncName = str2;
        this.sBuffer = bArr;
        this.iTimeout = i3;
        this.context = map;
        this.status = map2;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        RequestPacket requestPacket = (RequestPacket) obj;
        short s = requestPacket.iVersion;
        Integer valueOf = Integer.valueOf(1);
        return JceUtil.equals(1, (int) s) && JceUtil.equals(1, (int) requestPacket.cPacketType) && JceUtil.equals(1, requestPacket.iMessageType) && JceUtil.equals(1, requestPacket.iRequestId) && JceUtil.equals((Object) valueOf, (Object) requestPacket.sServantName) && JceUtil.equals((Object) valueOf, (Object) requestPacket.sFuncName) && JceUtil.equals((Object) valueOf, (Object) requestPacket.sBuffer) && JceUtil.equals(1, requestPacket.iTimeout) && JceUtil.equals((Object) valueOf, (Object) requestPacket.context) && JceUtil.equals((Object) valueOf, (Object) requestPacket.status);
    }

    public void readFrom(JceInputStream jceInputStream) {
        try {
            this.iVersion = jceInputStream.read(this.iVersion, 1, true);
            this.cPacketType = jceInputStream.read(this.cPacketType, 2, true);
            this.iMessageType = jceInputStream.read(this.iMessageType, 3, true);
            this.iRequestId = jceInputStream.read(this.iRequestId, 4, true);
            this.sServantName = jceInputStream.readString(5, true);
            this.sFuncName = jceInputStream.readString(6, true);
            if (cache_sBuffer == null) {
                cache_sBuffer = new byte[]{0};
            }
            this.sBuffer = jceInputStream.read(cache_sBuffer, 7, true);
            this.iTimeout = jceInputStream.read(this.iTimeout, 8, true);
            String str = "";
            if (cache_context == null) {
                cache_context = new HashMap();
                cache_context.put(str, str);
            }
            this.context = (Map) jceInputStream.read(cache_context, 9, true);
            if (cache_context == null) {
                cache_context = new HashMap();
                cache_context.put(str, str);
            }
            this.status = (Map) jceInputStream.read(cache_context, 10, true);
        } catch (Exception e) {
            e.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("RequestPacket decode error ");
            sb.append(WupHexUtil.bytes2HexStr(this.sBuffer));
            printStream.println(sb.toString());
            throw new RuntimeException(e);
        }
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iVersion, 1);
        jceOutputStream.write(this.cPacketType, 2);
        jceOutputStream.write(this.iMessageType, 3);
        jceOutputStream.write(this.iRequestId, 4);
        jceOutputStream.write(this.sServantName, 5);
        jceOutputStream.write(this.sFuncName, 6);
        jceOutputStream.write(this.sBuffer, 7);
        jceOutputStream.write(this.iTimeout, 8);
        jceOutputStream.write(this.context, 9);
        jceOutputStream.write(this.status, 10);
    }
}
