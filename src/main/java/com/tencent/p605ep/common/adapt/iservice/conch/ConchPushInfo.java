package com.tencent.p605ep.common.adapt.iservice.conch;

import java.util.ArrayList;

/* renamed from: com.tencent.ep.common.adapt.iservice.conch.ConchPushInfo */
public class ConchPushInfo {
    public Conch mConch;
    public ArrayList<String> mConchArgs;
    public Object mConchData;
    public RevokeTaskInfo mRevokeInfo;
    public long mTaskId;
    public long mTaskSeqno;

    /* renamed from: com.tencent.ep.common.adapt.iservice.conch.ConchPushInfo$Conch */
    public static class Conch {
        public int cmdId = 0;
        public int conchSeqno = 0;
        public byte[] params = null;
        public TimeCtrl time = null;
        public TipsInfo tips = null;
    }

    /* renamed from: com.tencent.ep.common.adapt.iservice.conch.ConchPushInfo$RevokeTaskInfo */
    public static class RevokeTaskInfo {
        public int mRevokeCmdId;
        public int mRevokeConchSeqno;

        public RevokeTaskInfo(int i, int i2) {
            this.mRevokeCmdId = i;
            this.mRevokeConchSeqno = i2;
        }
    }

    /* renamed from: com.tencent.ep.common.adapt.iservice.conch.ConchPushInfo$TimeCtrl */
    public static class TimeCtrl {
        public int validEndTime = 0;
    }

    /* renamed from: com.tencent.ep.common.adapt.iservice.conch.ConchPushInfo$TipsInfo */
    public static class TipsInfo {
        public int askType = 0;
        public int bgColor = 0;
        public int iconType = 0;
        public String msg;
        public String title;
        public int type = 0;

        public TipsInfo() {
            String str = "";
            this.title = str;
            this.msg = str;
        }
    }
}
