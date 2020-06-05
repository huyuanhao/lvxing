package com.tencent.p607mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelbase.BaseReq;
import com.tencent.p607mm.opensdk.modelbase.BaseResp;
import com.tencent.p607mm.opensdk.utils.C7339d;

/* renamed from: com.tencent.mm.opensdk.modelbiz.JoinChatroom */
public class JoinChatroom {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.JoinChatroom$Req */
    public static class Req extends BaseReq {
        public String chatroomNickName;
        public String extMsg;
        public String groupId = "";

        public boolean checkArgs() {
            return !C7339d.m31636b(this.groupId);
        }

        public int getType() {
            return 15;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_join_chatroom_group_id", this.groupId);
            bundle.putString("_wxapi_join_chatroom_chatroom_nickname", this.chatroomNickName);
            bundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
            bundle.putString("_wxapi_basereq_openid", this.openId);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.JoinChatroom$Resp */
    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_join_chatroom_ext_msg");
        }

        public int getType() {
            return 15;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
        }
    }

    private JoinChatroom() {
    }
}
