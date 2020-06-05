package com.qiyukf.nimlib.sdk.msg.constant;

public enum NotificationType {
    undefined(-1),
    InviteMember(0),
    KickMember(1),
    LeaveTeam(2),
    UpdateTeam(3),
    DismissTeam(4),
    PassTeamApply(5),
    TransferOwner(6),
    AddTeamManager(7),
    RemoveTeamManager(8),
    AcceptInvite(9),
    AVChatMissedCall(10),
    AVChatRecord(11);
    
    private int value;

    private NotificationType(int i) {
        this.value = i;
    }

    public static NotificationType typeOfValue(int i) {
        NotificationType[] values;
        for (NotificationType notificationType : values()) {
            if (notificationType.getValue() == i) {
                return notificationType;
            }
        }
        return undefined;
    }

    public final int getValue() {
        return this.value;
    }
}
