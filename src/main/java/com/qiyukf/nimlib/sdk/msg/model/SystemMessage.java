package com.qiyukf.nimlib.sdk.msg.model;

import com.qiyukf.nimlib.sdk.msg.constant.SystemMessageStatus;
import com.qiyukf.nimlib.sdk.msg.constant.SystemMessageType;
import java.io.Serializable;

public class SystemMessage implements Serializable {
    private String attach;
    private Object attachObject;
    private String content;
    private String fromAccount;
    private long messageId;
    private SystemMessageStatus status;
    private String targetId;
    private long time;
    private SystemMessageType type;

    public String getAttach() {
        return this.attach;
    }

    public Object getAttachObject() {
        return this.attachObject;
    }

    public String getContent() {
        return this.content;
    }

    public String getFromAccount() {
        return this.fromAccount;
    }

    public long getMessageId() {
        return this.messageId;
    }

    public SystemMessageStatus getStatus() {
        return this.status;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public long getTime() {
        return this.time;
    }

    public SystemMessageType getType() {
        return this.type;
    }

    public void setAttach(String str) {
        this.attach = str;
    }

    public void setAttachObject(Object obj) {
        this.attachObject = obj;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFromAccount(String str) {
        this.fromAccount = str;
    }

    public void setMessageId(long j) {
        this.messageId = j;
    }

    public void setStatus(SystemMessageStatus systemMessageStatus) {
        this.status = systemMessageStatus;
    }

    public void setTargetId(String str) {
        this.targetId = str;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setType(int i) {
        this.type = SystemMessageType.typeOfValue(i);
    }
}
