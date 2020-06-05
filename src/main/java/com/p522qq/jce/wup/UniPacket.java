package com.p522qq.jce.wup;

import com.p522qq.taf.RequestPacket;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qq.jce.wup.UniPacket */
public class UniPacket extends UniAttribute {
    public static final int UniPacketHeadSize = 4;
    static HashMap<String, HashMap<String, byte[]>> cache__tempdata;
    static HashMap<String, byte[]> newCache__tempdata;
    protected RequestPacket _package;
    private int oldRespIret;

    public UniPacket() {
        this._package = new RequestPacket();
        this.oldRespIret = 0;
        this._package.iVersion = 2;
    }

    public UniPacket(boolean z) {
        this._package = new RequestPacket();
        this.oldRespIret = 0;
        if (z) {
            useVersion3();
        } else {
            this._package.iVersion = 2;
        }
    }

    private void parseBufferV2() {
        JceInputStream jceInputStream = new JceInputStream(this._package.sBuffer);
        jceInputStream.setServerEncoding(this.encodeName);
        if (cache__tempdata == null) {
            cache__tempdata = new HashMap<>();
            HashMap hashMap = new HashMap();
            String str = "";
            hashMap.put(str, new byte[0]);
            cache__tempdata.put(str, hashMap);
        }
        this._data = jceInputStream.readMap(cache__tempdata, 0, false);
        this.cachedClassName = new HashMap();
    }

    private void parseBufferV3() {
        JceInputStream jceInputStream = new JceInputStream(this._package.sBuffer);
        jceInputStream.setServerEncoding(this.encodeName);
        if (newCache__tempdata == null) {
            newCache__tempdata = new HashMap<>();
            newCache__tempdata.put("", new byte[0]);
        }
        this._newData = jceInputStream.readMap(newCache__tempdata, 0, false);
    }

    public byte[] createOldRespEncode() {
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.encodeName);
        jceOutputStream.write((Map<K, V>) this._data, 0);
        byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        JceOutputStream jceOutputStream2 = new JceOutputStream(0);
        jceOutputStream2.setServerEncoding(this.encodeName);
        jceOutputStream2.write(this._package.iVersion, 1);
        jceOutputStream2.write(this._package.cPacketType, 2);
        jceOutputStream2.write(this._package.iRequestId, 3);
        jceOutputStream2.write(this._package.iMessageType, 4);
        jceOutputStream2.write(this.oldRespIret, 5);
        jceOutputStream2.write(jceBufArray, 6);
        jceOutputStream2.write(this._package.status, 7);
        return JceUtil.getJceBufArray(jceOutputStream2.getByteBuffer());
    }

    public UniPacket createResponse() {
        UniPacket uniPacket = new UniPacket();
        uniPacket.setRequestId(getRequestId());
        uniPacket.setServantName(getServantName());
        uniPacket.setFuncName(getFuncName());
        uniPacket.setEncodeName(this.encodeName);
        uniPacket._package.iVersion = this._package.iVersion;
        return uniPacket;
    }

    public void decode(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr, 4);
                jceInputStream.setServerEncoding(this.encodeName);
                this._package.readFrom(jceInputStream);
                if (this._package.iVersion == 3) {
                    parseBufferV3();
                    return;
                }
                this._newData = null;
                parseBufferV2();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("decode package must include size head");
        }
    }

    public void decodeVersion2(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr, 4);
                jceInputStream.setServerEncoding(this.encodeName);
                this._package.readFrom(jceInputStream);
                parseBufferV2();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("decode package must include size head");
        }
    }

    public void decodeVersion3(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr, 4);
                jceInputStream.setServerEncoding(this.encodeName);
                this._package.readFrom(jceInputStream);
                parseBufferV3();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("decode package must include size head");
        }
    }

    public byte[] encode() {
        String str = "";
        if (this._package.iVersion != 2) {
            if (this._package.sServantName == null) {
                this._package.sServantName = str;
            }
            if (this._package.sFuncName == null) {
                this._package.sFuncName = str;
            }
        } else if (this._package.sServantName == null || this._package.sServantName.equals(str)) {
            throw new IllegalArgumentException("servantName can not is null");
        } else if (this._package.sFuncName == null || this._package.sFuncName.equals(str)) {
            throw new IllegalArgumentException("funcName can not is null");
        }
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.encodeName);
        jceOutputStream.write((Map<K, V>) this._package.iVersion == 2 ? this._data : this._newData, 0);
        this._package.sBuffer = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        JceOutputStream jceOutputStream2 = new JceOutputStream(0);
        jceOutputStream2.setServerEncoding(this.encodeName);
        this._package.writeTo(jceOutputStream2);
        byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream2.getByteBuffer());
        int length = jceBufArray.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(jceBufArray).flip();
        return allocate.array();
    }

    public String getFuncName() {
        return this._package.sFuncName;
    }

    public int getOldRespIret() {
        return this.oldRespIret;
    }

    public int getPackageVersion() {
        return this._package.iVersion;
    }

    public int getRequestId() {
        return this._package.iRequestId;
    }

    public String getServantName() {
        return this._package.sServantName;
    }

    public <T> void put(String str, T t) {
        if (!str.startsWith(".")) {
            super.put(str, t);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("put name can not startwith . , now is ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public void readFrom(JceInputStream jceInputStream) {
        this._package.readFrom(jceInputStream);
    }

    public void setFuncName(String str) {
        this._package.sFuncName = str;
    }

    public void setOldRespIret(int i) {
        this.oldRespIret = i;
    }

    public void setRequestId(int i) {
        this._package.iRequestId = i;
    }

    public void setServantName(String str) {
        this._package.sServantName = str;
    }

    public void useVersion3() {
        super.useVersion3();
        this._package.iVersion = 3;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        this._package.writeTo(jceOutputStream);
    }
}
