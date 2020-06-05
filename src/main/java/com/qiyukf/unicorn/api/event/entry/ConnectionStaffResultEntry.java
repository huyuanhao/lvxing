package com.qiyukf.unicorn.api.event.entry;

public class ConnectionStaffResultEntry {
    private String VIPStaffAvatarUrl;
    private int code;
    private int connectResult;
    private int errorType;
    private long groupId;
    private String staffIconUrl;
    private String staffId;
    private String staffName;
    private int staffType;
    private String vipStaffName;
    private String vipStaffid;

    public int getCode() {
        return this.code;
    }

    public int getConnectResult() {
        return this.connectResult;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public String getStaffIconUrl() {
        return this.staffIconUrl;
    }

    public String getStaffId() {
        return this.staffId;
    }

    public String getStaffName() {
        return this.staffName;
    }

    public int getStaffType() {
        return this.staffType;
    }

    public String getVIPStaffAvatarUrl() {
        return this.VIPStaffAvatarUrl;
    }

    public String getVipStaffName() {
        return this.vipStaffName;
    }

    public String getVipStaffid() {
        return this.vipStaffid;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setConnectResult(int i) {
        this.connectResult = i;
    }

    public void setErrorType(int i) {
        this.errorType = i;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setStaffIconUrl(String str) {
        this.staffIconUrl = str;
    }

    public void setStaffId(String str) {
        this.staffId = str;
    }

    public void setStaffName(String str) {
        this.staffName = str;
    }

    public void setStaffType(int i) {
        this.staffType = i;
    }

    public void setVIPStaffAvatarUrl(String str) {
        this.VIPStaffAvatarUrl = str;
    }

    public void setVipStaffName(String str) {
        this.vipStaffName = str;
    }

    public void setVipStaffid(String str) {
        this.vipStaffid = str;
    }
}
