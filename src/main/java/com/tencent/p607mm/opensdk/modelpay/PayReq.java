package com.tencent.p607mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelbase.BaseReq;
import com.tencent.p607mm.opensdk.utils.C7334a;
import com.tencent.p607mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelpay.PayReq */
public class PayReq extends BaseReq {
    private static final int EXTDATA_MAX_LENGTH = 1024;
    private static final String TAG = "MicroMsg.PaySdk.PayReq";
    public String appId;
    public String extData;
    public String nonceStr;
    public Options options;
    public String packageValue;
    public String partnerId;
    public String prepayId;
    public String sign;
    public String signType;
    public String timeStamp;

    /* renamed from: com.tencent.mm.opensdk.modelpay.PayReq$Options */
    public static class Options {
        public static final int INVALID_FLAGS = -1;
        public String callbackClassName;
        public int callbackFlags = -1;

        public void fromBundle(Bundle bundle) {
            this.callbackClassName = C7334a.m31632b(bundle, "_wxapi_payoptions_callback_classname");
            this.callbackFlags = C7334a.m31631a(bundle, "_wxapi_payoptions_callback_flags");
        }

        public void toBundle(Bundle bundle) {
            bundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
            bundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
        }
    }

    public boolean checkArgs() {
        String str;
        String str2 = this.appId;
        String str3 = TAG;
        if (str2 == null || str2.length() == 0) {
            str = "checkArgs fail, invalid appId";
        } else {
            String str4 = this.partnerId;
            if (str4 == null || str4.length() == 0) {
                str = "checkArgs fail, invalid partnerId";
            } else {
                String str5 = this.prepayId;
                if (str5 == null || str5.length() == 0) {
                    str = "checkArgs fail, invalid prepayId";
                } else {
                    String str6 = this.nonceStr;
                    if (str6 == null || str6.length() == 0) {
                        str = "checkArgs fail, invalid nonceStr";
                    } else {
                        String str7 = this.timeStamp;
                        if (str7 == null || str7.length() == 0) {
                            str = "checkArgs fail, invalid timeStamp";
                        } else {
                            String str8 = this.packageValue;
                            if (str8 == null || str8.length() == 0) {
                                str = "checkArgs fail, invalid packageValue";
                            } else {
                                String str9 = this.sign;
                                if (str9 == null || str9.length() == 0) {
                                    str = "checkArgs fail, invalid sign";
                                } else {
                                    String str10 = this.extData;
                                    if (str10 == null || str10.length() <= 1024) {
                                        return true;
                                    }
                                    str = "checkArgs fail, extData length too long";
                                }
                            }
                        }
                    }
                }
            }
        }
        Log.m31627e(str3, str);
        return false;
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.appId = C7334a.m31632b(bundle, "_wxapi_payreq_appid");
        this.partnerId = C7334a.m31632b(bundle, "_wxapi_payreq_partnerid");
        this.prepayId = C7334a.m31632b(bundle, "_wxapi_payreq_prepayid");
        this.nonceStr = C7334a.m31632b(bundle, "_wxapi_payreq_noncestr");
        this.timeStamp = C7334a.m31632b(bundle, "_wxapi_payreq_timestamp");
        this.packageValue = C7334a.m31632b(bundle, "_wxapi_payreq_packagevalue");
        this.sign = C7334a.m31632b(bundle, "_wxapi_payreq_sign");
        this.extData = C7334a.m31632b(bundle, "_wxapi_payreq_extdata");
        this.signType = C7334a.m31632b(bundle, "_wxapi_payreq_sign_type");
        this.options = new Options();
        this.options.fromBundle(bundle);
    }

    public int getType() {
        return 5;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_payreq_appid", this.appId);
        bundle.putString("_wxapi_payreq_partnerid", this.partnerId);
        bundle.putString("_wxapi_payreq_prepayid", this.prepayId);
        bundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
        bundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
        bundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
        bundle.putString("_wxapi_payreq_sign", this.sign);
        bundle.putString("_wxapi_payreq_extdata", this.extData);
        bundle.putString("_wxapi_payreq_sign_type", this.signType);
        Options options2 = this.options;
        if (options2 != null) {
            options2.toBundle(bundle);
        }
    }
}
