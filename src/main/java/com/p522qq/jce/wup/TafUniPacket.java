package com.p522qq.jce.wup;

import java.util.Map;

/* renamed from: com.qq.jce.wup.TafUniPacket */
public class TafUniPacket extends UniPacket {
    private static final long serialVersionUID = 1;

    public byte[] getTafBuffer() {
        return this._package.sBuffer;
    }

    public Map<String, String> getTafContext() {
        return this._package.context;
    }

    public int getTafMessageType() {
        return this._package.iMessageType;
    }

    public byte getTafPacketType() {
        return this._package.cPacketType;
    }

    public int getTafResultCode() {
        String str = (String) this._package.status.get("STATUS_RESULT_CODE");
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    public String getTafResultDesc() {
        String str = (String) this._package.status.get("STATUS_RESULT_DESC");
        return str != null ? str : "";
    }

    public Map<String, String> getTafStatus() {
        return this._package.status;
    }

    public int getTafTimeout() {
        return this._package.iTimeout;
    }

    public short getTafVersion() {
        return this._package.iVersion;
    }

    public void setTafBuffer(byte[] bArr) {
        this._package.sBuffer = bArr;
    }

    public void setTafContext(Map<String, String> map) {
        this._package.context = map;
    }

    public void setTafMessageType(int i) {
        this._package.iMessageType = i;
    }

    public void setTafPacketType(byte b) {
        this._package.cPacketType = b;
    }

    public void setTafStatus(Map<String, String> map) {
        this._package.status = map;
    }

    public void setTafTimeout(int i) {
        this._package.iTimeout = i;
    }

    public void setTafVersion(short s) {
        this._package.iVersion = s;
        if (s == 3) {
            useVersion3();
        }
    }
}
