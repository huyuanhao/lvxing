package com.tencent.p607mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelbase.BaseReq;

/* renamed from: com.tencent.mm.opensdk.modelbiz.OpenBusiLuckyMoney */
public class OpenBusiLuckyMoney {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.OpenBusiLuckyMoney$Req */
    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String appId;
        public String nonceStr;
        public String packageExt;
        public String signType;
        public String signature;
        public String timeStamp;

        public boolean checkArgs() {
            String str = this.appId;
            if (str != null && str.length() > 0) {
                String str2 = this.timeStamp;
                if (str2 != null && str2.length() > 0) {
                    String str3 = this.nonceStr;
                    if (str3 != null && str3.length() > 0) {
                        String str4 = this.signType;
                        if (str4 != null && str4.length() > 0) {
                            String str5 = this.signature;
                            if (str5 != null && str5.length() > 0) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

        public int getType() {
            return 13;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_busi_lucky_money_appid", this.appId);
            bundle.putString("_wxapi_open_busi_lucky_money_timeStamp", this.timeStamp);
            bundle.putString("_wxapi_open_busi_lucky_money_nonceStr", this.nonceStr);
            bundle.putString("_wxapi_open_busi_lucky_money_signType", this.signType);
            bundle.putString("_wxapi_open_busi_lucky_money_signature", this.signature);
            bundle.putString("_wxapi_open_busi_lucky_money_package", this.packageExt);
        }
    }
}
