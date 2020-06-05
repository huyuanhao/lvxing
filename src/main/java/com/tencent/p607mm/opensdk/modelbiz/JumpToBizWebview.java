package com.tencent.p607mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelbase.BaseReq;
import com.tencent.p607mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.JumpToBizWebview */
public final class JumpToBizWebview {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.JumpToBizWebview$Req */
    public static class Req extends BaseReq {
        private static final int EXT_MSG_LENGTH = 1024;
        private static final String TAG = "MicroMsg.SDK.JumpToBizWebview.Req";
        public String extMsg;
        public int scene = 1;
        public String toUserName;
        public int webType;

        public boolean checkArgs() {
            String str;
            String str2 = this.toUserName;
            String str3 = TAG;
            if (str2 == null || str2.length() <= 0) {
                str = "checkArgs fail, toUserName is invalid";
            } else {
                String str4 = this.extMsg;
                if (str4 == null || str4.length() <= 1024) {
                    return true;
                }
                str = "ext msg is not null, while the length exceed 1024 bytes";
            }
            Log.m31627e(str3, str);
            return false;
        }

        public int getType() {
            return 8;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_web_type", this.webType);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_scene", this.scene);
        }
    }
}
