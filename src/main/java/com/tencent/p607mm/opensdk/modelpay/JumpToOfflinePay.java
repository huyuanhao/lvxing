package com.tencent.p607mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelbase.BaseReq;
import com.tencent.p607mm.opensdk.modelbase.BaseResp;

/* renamed from: com.tencent.mm.opensdk.modelpay.JumpToOfflinePay */
public class JumpToOfflinePay {

    /* renamed from: com.tencent.mm.opensdk.modelpay.JumpToOfflinePay$Req */
    public static class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.JumpToOfflinePay.Req";

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        public int getType() {
            return 24;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelpay.JumpToOfflinePay$Resp */
    public static class Resp extends BaseResp {
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
        }

        public int getType() {
            return 24;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }
}
