package com.qiyukf.nimlib.sdk.msg.model;

import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.C6164f;
import java.io.Serializable;

public class CustomNotification implements Serializable {
    private String apnsText;
    private C6144e attachment;
    private String fromAccount;
    private boolean sendToOnlineUserOnly = true;
    private String sessionId;
    private SessionTypeEnum sessionType;
    private long time;

    public String getApnsText() {
        return this.apnsText;
    }

    public C6144e getAttachment() {
        return this.attachment;
    }

    public String getFromAccount() {
        return this.fromAccount;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public SessionTypeEnum getSessionType() {
        return this.sessionType;
    }

    public long getTime() {
        return this.time;
    }

    public boolean isSendToOnlineUserOnly() {
        return this.sendToOnlineUserOnly;
    }

    public void setApnsText(String str) {
        this.apnsText = str;
    }

    public void setAttachStr(String str) {
        this.attachment = (C6144e) C6164f.m24457a().parse(str);
    }

    public void setAttachment(C6144e eVar) {
        this.attachment = eVar;
    }

    public void setFromAccount(String str) {
        this.fromAccount = str;
    }

    public void setSendToOnlineUserOnly(boolean z) {
        this.sendToOnlineUserOnly = z;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSessionType(SessionTypeEnum sessionTypeEnum) {
        this.sessionType = sessionTypeEnum;
    }

    public void setTime(long j) {
        this.time = j;
    }
}
