package ezy.sdk3rd.social.platforms.weixin;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.tencent.p607mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.p607mm.opensdk.modelbase.BaseReq;
import com.tencent.p607mm.opensdk.modelbase.BaseResp;
import com.tencent.p607mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.p607mm.opensdk.modelmsg.SendAuth.Resp;
import ezy.sdk3rd.social.authorize.IAuthorize;
import ezy.sdk3rd.social.sdk.IDisposable;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.sdk.Platform;

public class WXAuth extends WXBase implements IAuthorize, IDisposable {
    public /* bridge */ /* synthetic */ void onReq(BaseReq baseReq) {
        super.onReq(baseReq);
    }

    public /* bridge */ /* synthetic */ void onResp(BaseResp baseResp) {
        super.onResp(baseResp);
    }

    public /* bridge */ /* synthetic */ void onResult(int i, int i2, Intent intent) {
        super.onResult(i, i2, intent);
    }

    WXAuth(Activity activity, Platform platform) {
        super(activity, platform);
    }

    public void authorize(OnCallback<String> fVar) {
        this.mCallback = fVar;
        if (!this.mApi.isWXAppInstalled()) {
            this.mCallback.mo20728a(this.mActivity, 3, "您未安装微信!");
            return;
        }
        Req req = new Req();
        req.scope = "snsapi_userinfo";
        req.state = Token.WX_TOKEN_PLATFORMID_VALUE;
        String str = WXBase.TAG;
        Log.e(str, "send start");
        this.mCallback.mo20727a(this.mActivity);
        boolean sendReq = this.mApi.sendReq(req);
        StringBuilder sb = new StringBuilder();
        sb.append("send end ");
        sb.append(sendReq);
        Log.e(str, sb.toString());
    }

    /* access modifiers changed from: protected */
    public void onResultOk(Resp resp) {
        StringBuilder sb = new StringBuilder();
        sb.append("code = ");
        sb.append(resp.code);
        Log.e(WXBase.TAG, sb.toString());
        OnCallback fVar = this.mCallback;
        Activity activity = this.mActivity;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("code|");
        sb2.append(resp.code);
        fVar.mo20729a(activity, sb2.toString());
    }

    public void onDispose() {
        services.remove(this);
    }
}
