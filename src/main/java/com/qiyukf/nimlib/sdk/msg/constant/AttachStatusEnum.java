package com.qiyukf.nimlib.sdk.msg.constant;

public enum AttachStatusEnum {
    def(0),
    transferring(1),
    transferred(2),
    fail(3);
    
    private int value;

    private AttachStatusEnum(int i) {
        this.value = i;
    }

    public static AttachStatusEnum statusOfValue(int i) {
        AttachStatusEnum[] values;
        for (AttachStatusEnum attachStatusEnum : values()) {
            if (attachStatusEnum.getValue() == i) {
                return attachStatusEnum;
            }
        }
        return def;
    }

    public final int getValue() {
        return this.value;
    }
}
