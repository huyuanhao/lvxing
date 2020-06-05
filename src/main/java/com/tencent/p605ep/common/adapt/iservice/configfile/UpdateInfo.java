package com.tencent.p605ep.common.adapt.iservice.configfile;

/* renamed from: com.tencent.ep.common.adapt.iservice.configfile.UpdateInfo */
public class UpdateInfo {
    public String checkSum;
    public Object data1;
    public Object data2;
    public String downNetName;
    public int downSize = -1;
    public byte downType;
    public int downloadFlag;
    public int downnetType = 0;
    public int errorCode = 0;
    public String errorMsg;
    public int fileId;
    public String fileName;
    public int fileSize;
    public Object mUpdateInfoData;
    public int rssi;
    public int sdcardStatus;
    public byte success = 1;
    public long taskId;
    public int timestamp = -1;
    public String url;
    public String wrapKey;
    public int wrapType;

    public UpdateInfo() {
        String str = "";
        this.checkSum = str;
        this.downNetName = str;
        this.errorMsg = str;
        this.rssi = -1;
        this.sdcardStatus = -1;
        this.fileSize = 0;
        this.taskId = 0;
        this.downloadFlag = 0;
        this.wrapType = 0;
        this.wrapKey = str;
    }
}
