package com.tencent.p607mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelbase.BaseReq;
import com.tencent.p607mm.opensdk.modelbase.BaseResp;
import com.tencent.p607mm.opensdk.utils.C7339d;
import com.tencent.p607mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.WXNontaxPay */
public class WXNontaxPay {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXNontaxPay$Req */
    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXNontaxPay.Req";
        private static final int URL_LENGTH_LIMIT = 10240;
        public String url;

        public final boolean checkArgs() {
            boolean b = C7339d.m31636b(this.url);
            String str = TAG;
            if (b) {
                Log.m31628i(str, "url should not be empty");
                return false;
            } else if (this.url.length() <= URL_LENGTH_LIMIT) {
                return true;
            } else {
                Log.m31627e(str, "url must be in 10k");
                return false;
            }
        }

        public final void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.url = bundle.getString("_wxapi_nontax_pay_req_url");
        }

        public final int getType() {
            return 21;
        }

        public final void toBundle(Bundle bundle) {
            super.fromBundle(bundle);
            bundle.putString("_wxapi_nontax_pay_req_url", this.url);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXNontaxPay$Resp */
    public static final class Resp extends BaseResp {
        public String wxOrderId;

        public final boolean checkArgs() {
            return true;
        }

        public final void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.wxOrderId = bundle.getString("_wxapi_nontax_pay_order_id");
        }

        public final int getType() {
            return 21;
        }

        public final void toBundle(Bundle bundle) {
            super.fromBundle(bundle);
            bundle.putString("_wxapi_nontax_pay_order_id", this.wxOrderId);
        }
    }
}
