package com.qiyukf.nimlib.sdk.msg.constant;

import com.tencent.p605ep.common.adapt.iservice.profile.ProfileID;

public enum SessionTypeEnum {
    None(-1),
    P2P(0),
    Team(1),
    Ysf(2),
    System(ProfileID.PID_KVProfile_ACCOUNT);
    
    private int value;

    private SessionTypeEnum(int i) {
        this.value = i;
    }

    public static SessionTypeEnum typeOfValue(int i) {
        SessionTypeEnum[] values;
        for (SessionTypeEnum sessionTypeEnum : values()) {
            if (sessionTypeEnum.getValue() == i) {
                return sessionTypeEnum;
            }
        }
        return P2P;
    }

    public final int getValue() {
        return this.value;
    }
}
