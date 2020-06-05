package com.qiyukf.unicorn.api.msg;

public enum MsgTypeEnum {
    undef(-1),
    text(0),
    image(1),
    audio(2),
    video(3),
    location(4),
    file(6),
    notification(5),
    tips(10),
    custom(100),
    appCustom(101);
    
    private final int value;

    private MsgTypeEnum(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
