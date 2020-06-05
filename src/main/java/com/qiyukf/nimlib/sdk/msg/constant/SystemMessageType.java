package com.qiyukf.nimlib.sdk.msg.constant;

public enum SystemMessageType {
    undefined(-1),
    ApplyJoinTeam(0),
    RejectTeamApply(1),
    TeamInvite(2),
    DeclineTeamInvite(3),
    AddFriend(5),
    DeleteFriend(6);
    
    private int value;

    private SystemMessageType(int i) {
        this.value = i;
    }

    public static SystemMessageType typeOfValue(int i) {
        SystemMessageType[] values;
        for (SystemMessageType systemMessageType : values()) {
            if (systemMessageType.getValue() == i) {
                return systemMessageType;
            }
        }
        return undefined;
    }

    public final int getValue() {
        return this.value;
    }
}
