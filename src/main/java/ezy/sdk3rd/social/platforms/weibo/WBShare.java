package ezy.sdk3rd.social.platforms.weibo;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.sina.weibo.sdk.utils.Utility;
import ezy.sdk3rd.social.sdk.IResult;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.sdk.Platform;
import ezy.sdk3rd.social.share.IShareable;
import ezy.sdk3rd.social.share.ShareData;
import ezy.sdk3rd.social.share.p650a.p651a.ImageResource;
import ezy.sdk3rd.social.share.p652b.MoImage;
import java.util.Map;
import java.util.WeakHashMap;

public class WBShare implements WbShareCallback, IShareable {
    public static int REQUEST_CODE = 1998;
    public static final String TAG = "ezy.sdk3rd.weibo.share";
    static Map<IResult, Boolean> services = new WeakHashMap();
    Activity mActivity;
    WbShareHandler mApi = new WbShareHandler(this.mActivity);
    OnCallback<String> mCallback;
    Platform mPlatform;

    WBShare(Activity activity, Platform platform) {
        WbSdk.install(activity, new AuthInfo(activity, platform.getAppId(), platform.extra("redirectUrl"), MsgService.MSG_CHATTING_ACCOUNT_ALL));
        this.mActivity = activity;
        this.mPlatform = platform;
        this.mApi.registerApp();
        services.put(this, Boolean.valueOf(true));
    }

    /* access modifiers changed from: 0000 */
    public TextObject toText(String str) {
        TextObject textObject = new TextObject();
        textObject.text = str;
        return textObject;
    }

    /* access modifiers changed from: 0000 */
    public ImageObject toImage(ImageResource cVar) {
        ImageObject imageObject = new ImageObject();
        imageObject.imagePath = cVar.mo38637a();
        if (TextUtils.isEmpty(imageObject.imagePath)) {
            imageObject.imageData = cVar.mo38639c();
        }
        return imageObject;
    }

    /* access modifiers changed from: 0000 */
    public WebpageObject toWeb(ShareData aVar) {
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = aVar.f27308c;
        webpageObject.description = aVar.f27309d;
        webpageObject.setThumbImage(aVar.f27310e.mo38638b());
        webpageObject.actionUrl = aVar.f27306a;
        webpageObject.defaultText = "Webpage 默认文案";
        return webpageObject;
    }

    public void share(ShareData aVar, OnCallback<String> fVar) {
        String str;
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (aVar.mo38631b()) {
            if (aVar.mo38630a()) {
                StringBuilder sb = new StringBuilder();
                sb.append(aVar.f27307b);
                sb.append(" ");
                sb.append(aVar.f27306a);
                str = sb.toString();
            } else {
                str = aVar.f27307b;
            }
            weiboMultiMessage.textObject = toText(str);
        }
        if (aVar.f27311f instanceof MoImage) {
            weiboMultiMessage.imageObject = toImage(((MoImage) aVar.f27311f).f27316a);
        }
        if (weiboMultiMessage.textObject == null && weiboMultiMessage.imageObject == null) {
            fVar.mo20728a(this.mActivity, 3, "不支持的分享类型");
            return;
        }
        this.mCallback = fVar;
        this.mCallback.mo20727a(this.mActivity);
        this.mApi.shareMessage(weiboMultiMessage, true);
    }

    public void onResult(int i, int i2, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("==> requestCode = ");
        sb.append(i);
        sb.append(", ");
        sb.append(intent);
        Log.e(TAG, sb.toString());
        WbShareHandler wbShareHandler = this.mApi;
        if (wbShareHandler != null && i == REQUEST_CODE) {
            wbShareHandler.doResultIntent(intent, this);
        }
    }

    public void onWbShareCancel() {
        this.mCallback.mo20728a(this.mActivity, 2, "");
        this.mCallback.mo20731b(this.mActivity);
    }

    public void onWbShareFail() {
        this.mCallback.mo20728a(this.mActivity, 3, "");
        this.mCallback.mo20731b(this.mActivity);
    }

    public void onWbShareSuccess() {
        this.mCallback.mo20729a(this.mActivity, "");
        this.mCallback.mo20731b(this.mActivity);
    }
}
