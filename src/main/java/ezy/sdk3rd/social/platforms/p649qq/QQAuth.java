package ezy.sdk3rd.social.platforms.p649qq;

import android.app.Activity;
import android.content.Intent;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import ezy.sdk3rd.social.authorize.IAuthorize;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.sdk.Platform;

/* renamed from: ezy.sdk3rd.social.platforms.qq.QQAuth */
public class QQAuth implements IAuthorize {
    public static final String TAG = "ezy.sdk3rd.qq.auth";
    Activity mActivity;
    Tencent mApi;
    IUiListener mListener;
    Platform mPlatform;

    QQAuth(Activity activity, Platform platform) {
        this.mActivity = activity;
        this.mPlatform = platform;
        this.mApi = Tencent.createInstance(platform.getAppId(), this.mActivity);
    }

    /* access modifiers changed from: 0000 */
    public String toMessage(UiError uiError) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(uiError.errorCode);
        sb.append("]");
        sb.append(uiError.errorMessage);
        return sb.toString();
    }

    public void authorize(final OnCallback<String> fVar) {
        this.mListener = new IUiListener() {
        };
        fVar.mo20727a(this.mActivity);
        this.mApi.login(this.mActivity, "get_simple_userinfo", this.mListener);
    }

    public void onResult(int i, int i2, Intent intent) {
        if (i == 11101) {
            Tencent.onActivityResultData(i, i2, intent, this.mListener);
        }
    }
}
