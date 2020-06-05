package com.tencent.mta.track.thrift;

/* compiled from: ProGuard */
public enum CommonCmdType {
    ScreenShotReq(0),
    ScreenShotRsp(1),
    DeviceInfoReq(2),
    DeviceInfoRsp(3),
    EventBindReq(4),
    EventBindRsp(5),
    DeployReq(6),
    DeployRsp(7),
    CancelReq(8),
    CancelRsp(9),
    TrackReq(10),
    TrackRsp(11),
    DisConnectReq(12),
    DisConnectRsp(13);
    
    private final int value;

    private CommonCmdType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    /* renamed from: a */
    public static CommonCmdType m31822a(int i) {
        switch (i) {
            case 0:
                return ScreenShotReq;
            case 1:
                return ScreenShotRsp;
            case 2:
                return DeviceInfoReq;
            case 3:
                return DeviceInfoRsp;
            case 4:
                return EventBindReq;
            case 5:
                return EventBindRsp;
            case 6:
                return DeployReq;
            case 7:
                return DeployRsp;
            case 8:
                return CancelReq;
            case 9:
                return CancelRsp;
            case 10:
                return TrackReq;
            case 11:
                return TrackRsp;
            case 12:
                return DisConnectReq;
            case 13:
                return DisConnectRsp;
            default:
                return null;
        }
    }
}
