package com.qiyukf.unicorn.api.msg;

public enum MsgStatusEnum {
    draft(-1),
    sending(0),
    success(1),
    fail(2),
    read(3),
    unread(4);
    
    private int value;

    private MsgStatusEnum(int i) {
        this.value = i;
    }

    public static MsgStatusEnum statusOfValue(int i) {
        MsgStatusEnum[] values;
        for (MsgStatusEnum msgStatusEnum : values()) {
            if (msgStatusEnum.getValue() == i) {
                return msgStatusEnum;
            }
        }
        return sending;
    }

    public final int getValue() {
        return this.value;
    }
}
