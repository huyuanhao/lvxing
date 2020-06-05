package com.qiyukf.nimlib.sdk.msg.constant;

public enum SystemMessageStatus {
    init(0),
    passed(1),
    declined(2),
    ignored(3),
    expired(4),
    extension1(100),
    extension2(101),
    extension3(102),
    extension4(103),
    extension5(104);
    
    private int value;

    private SystemMessageStatus(int i) {
        this.value = i;
    }

    public static SystemMessageStatus statusOfValue(int i) {
        SystemMessageStatus[] values;
        for (SystemMessageStatus systemMessageStatus : values()) {
            if (systemMessageStatus.getValue() == i) {
                return systemMessageStatus;
            }
        }
        return init;
    }

    public final int getValue() {
        return this.value;
    }
}
