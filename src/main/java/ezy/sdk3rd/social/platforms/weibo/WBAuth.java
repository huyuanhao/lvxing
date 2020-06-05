package ezy.sdk3rd.social.platforms.weibo;

import android.app.Activity;
import android.content.Intent;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import ezy.sdk3rd.social.authorize.IAuthorize;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.sdk.Platform;

public class WBAuth implements IAuthorize {
    public static final String TAG = "ezy.sdk3rd.weibo.auth";
    Activity mActivity;
    SsoHandler mApi = new SsoHandler(this.mActivity);
    Platform mPlatform;

    WBAuth(Activity activity, Platform platform) {
        WbSdk.install(activity, new AuthInfo(activity, platform.getAppId(), platform.extra("redirectUrl"), MsgService.MSG_CHATTING_ACCOUNT_ALL));
        this.mActivity = activity;
        this.mPlatform = platform;
    }

    public void authorize(final OnCallback<String> fVar) {
        fVar.mo20727a(this.mActivity);
        this.mApi.authorize(new WbAuthListener() {
        });
    }

    public void onResult(int i, int i2, Intent intent) {
        SsoHandler ssoHandler = this.mApi;
        if (ssoHandler != null) {
            ssoHandler.authorizeCallBack(i, i2, intent);
        }
    }
}
