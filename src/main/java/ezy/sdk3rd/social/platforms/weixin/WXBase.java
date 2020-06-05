package ezy.sdk3rd.social.platforms.weixin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.p607mm.opensdk.modelbase.BaseReq;
import com.tencent.p607mm.opensdk.modelbase.BaseResp;
import com.tencent.p607mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.p607mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.p607mm.opensdk.modelpay.PayResp;
import com.tencent.p607mm.opensdk.openapi.IWXAPI;
import com.tencent.p607mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.p607mm.opensdk.openapi.WXAPIFactory;
import ezy.sdk3rd.social.sdk.IResult;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.sdk.Platform;
import java.util.WeakHashMap;

abstract class WXBase implements IWXAPIEventHandler, IResult {
    public static int REQUEST_CODE = 1999;
    public static final String TAG = "ezy.sdk3rd.wx";
    static WeakHashMap<IResult, Boolean> services = new WeakHashMap<>();
    protected final Activity mActivity;
    IWXAPI mApi;
    protected OnCallback mCallback;
    protected final Platform mPlatform;

    /* access modifiers changed from: protected */
    public void onResultOk(Resp resp) {
    }

    /* access modifiers changed from: protected */
    public void onResultOk(SendMessageToWX.Resp resp) {
    }

    /* access modifiers changed from: protected */
    public void onResultOk(PayResp payResp) {
    }

    protected WXBase(Activity activity, Platform platform) {
        this.mActivity = activity;
        this.mPlatform = platform;
        if (!TextUtils.isEmpty(platform.getAppId())) {
            this.mApi = WXAPIFactory.createWXAPI(activity.getApplicationContext(), platform.getAppId(), true);
            this.mApi.registerApp(platform.getAppId());
        }
        services.put(this, Boolean.valueOf(true));
    }

    public void onResult(int i, int i2, Intent intent) {
        IWXAPI iwxapi = this.mApi;
        if (iwxapi != null && i == REQUEST_CODE) {
            iwxapi.handleIntent(intent, this);
        }
    }

    public void onReq(BaseReq baseReq) {
        StringBuilder sb = new StringBuilder();
        sb.append("transaction = ");
        sb.append(baseReq.transaction);
        sb.append(", type = ");
        sb.append(baseReq.getType());
        sb.append(", openId = ");
        sb.append(baseReq.openId);
        Log.e(TAG, sb.toString());
    }

    public void onResp(BaseResp baseResp) {
        StringBuilder sb = new StringBuilder();
        sb.append("transaction = ");
        sb.append(baseResp.transaction);
        sb.append(", type = ");
        sb.append(baseResp.getType());
        sb.append(", errCode = ");
        sb.append(baseResp.errCode);
        sb.append(", err = ");
        sb.append(baseResp.errStr);
        Log.e(TAG, sb.toString());
        if (baseResp.errCode == 0) {
            int type = baseResp.getType();
            if (type == 1) {
                onResultOk((Resp) baseResp);
            } else if (type == 2) {
                onResultOk((SendMessageToWX.Resp) baseResp);
            } else if (type == 5) {
                onResultOk((PayResp) baseResp);
            }
        } else if (baseResp.errCode == -2) {
            this.mCallback.mo20728a(this.mActivity, 2, toMessage(baseResp));
        } else {
            this.mCallback.mo20728a(this.mActivity, 3, toMessage(baseResp));
        }
        this.mCallback.mo20731b(this.mActivity);
    }

    /* access modifiers changed from: 0000 */
    public String toMessage(BaseResp baseResp) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(baseResp.errCode);
        sb.append("]");
        sb.append(baseResp.errStr == null ? "" : baseResp.errStr);
        return sb.toString();
    }
}
