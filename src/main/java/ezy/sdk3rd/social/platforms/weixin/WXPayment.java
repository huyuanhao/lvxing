package ezy.sdk3rd.social.platforms.weixin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.p522qq.p523e.comm.p525pi.ACTD;
import com.tencent.p607mm.opensdk.modelbase.BaseReq;
import com.tencent.p607mm.opensdk.modelbase.BaseResp;
import com.tencent.p607mm.opensdk.modelpay.PayReq;
import com.tencent.p607mm.opensdk.modelpay.PayResp;
import com.tencent.p607mm.opensdk.openapi.WXAPIFactory;
import discoveryAD.C7880W.C7881a;
import ezy.sdk3rd.social.payment.IPayable;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.sdk.Platform;
import org.json.JSONObject;

public class WXPayment extends WXBase implements IPayable {
    public /* bridge */ /* synthetic */ void onReq(BaseReq baseReq) {
        super.onReq(baseReq);
    }

    public /* bridge */ /* synthetic */ void onResp(BaseResp baseResp) {
        super.onResp(baseResp);
    }

    public /* bridge */ /* synthetic */ void onResult(int i, int i2, Intent intent) {
        super.onResult(i, i2, intent);
    }

    WXPayment(Activity activity, Platform platform) {
        super(activity, platform);
    }

    public void pay(String str, OnCallback<String> fVar) {
        PayReq payReq = new PayReq();
        StringBuilder sb = new StringBuilder();
        sb.append("data ==> ");
        sb.append(str);
        String sb2 = sb.toString();
        String str2 = WXBase.TAG;
        Log.e(str2, sb2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            payReq.appId = jSONObject.getString(ACTD.APPID_KEY);
            payReq.partnerId = jSONObject.getString("partnerid");
            payReq.prepayId = jSONObject.getString("prepayid");
            payReq.packageValue = jSONObject.getString("package");
            payReq.nonceStr = jSONObject.getString("noncestr");
            payReq.timeStamp = jSONObject.getString(C7881a.TIMESTAMP);
            payReq.sign = jSONObject.getString("sign");
            payReq.transaction = payReq.nonceStr;
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("parse error ==> ");
            sb3.append(e.toString());
            Log.e(str2, sb3.toString());
        }
        if (!TextUtils.isEmpty(payReq.appId)) {
            this.mApi = WXAPIFactory.createWXAPI(this.mActivity.getApplicationContext(), payReq.appId, true);
            this.mApi.registerApp(payReq.appId);
        }
        this.mCallback = fVar;
        if (!this.mApi.isWXAppInstalled()) {
            this.mCallback.mo20728a(this.mActivity, 3, "您未安装微信!");
            return;
        }
        this.mCallback.mo20727a(this.mActivity);
        boolean sendReq = this.mApi.sendReq(payReq);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("send end, pay request  ==> ");
        sb4.append(sendReq);
        Log.e(str2, sb4.toString());
    }

    /* access modifiers changed from: protected */
    public void onResultOk(PayResp payResp) {
        StringBuilder sb = new StringBuilder();
        sb.append("prepayId = ");
        sb.append(payResp.prepayId);
        Log.e(WXBase.TAG, sb.toString());
        this.mCallback.mo20729a(this.mActivity, payResp.prepayId);
    }
}
