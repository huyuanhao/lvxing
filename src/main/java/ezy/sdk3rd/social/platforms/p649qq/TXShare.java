package ezy.sdk3rd.social.platforms.p649qq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.p605ep.commonbase.software.AppEntity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.sdk.Platform;
import ezy.sdk3rd.social.share.IShareable;
import ezy.sdk3rd.social.share.ShareData;
import ezy.sdk3rd.social.share.p652b.MoImage;
import ezy.sdk3rd.social.share.p652b.MoMusic;
import ezy.sdk3rd.social.share.p652b.MoVideo;
import ezy.sdk3rd.social.share.p652b.MoWeb;
import java.util.ArrayList;

/* renamed from: ezy.sdk3rd.social.platforms.qq.TXShare */
public class TXShare implements IShareable {
    private static final String KEY_AUDIO_URL = "audio_url";
    private static final String KEY_AUDIO_VIDEO_PATH = "videoPath";
    private static final String KEY_IMAGE_LOCAL_URL = "imageLocalUrl";
    private static final String KEY_IMAGE_URL = "imageUrl";
    private static final String KEY_REQ_TYPE = "req_type";
    private static final String KEY_TARGET_URL = "targetUrl";
    private static final int REQ_TYPE_AUDIO = 2;
    private static final int REQ_TYPE_DEFAULT = 1;
    private static final int REQ_TYPE_IMAGE = 5;
    private static final int REQ_TYPE_MOOD = 3;
    private static final int REQ_TYPE_VIDEO = 4;
    public static final String TAG = "ezy.sdk3rd.qq.share";
    Activity mActivity;
    Tencent mApi;
    IUiListener mListener;
    Platform mPlatform;

    TXShare(Activity activity, Platform platform) {
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

    public void share(ShareData aVar, final OnCallback<String> fVar) {
        boolean equals = this.mPlatform.getName().equals("qq");
        this.mListener = new IUiListener() {
        };
        Bundle bundle = new Bundle();
        String str = "title";
        if (aVar.mo38631b()) {
            bundle.putString(str, aVar.f27307b);
        } else if (aVar.mo38632c()) {
            bundle.putString(str, aVar.f27308c);
        }
        if (aVar.mo38633d()) {
            bundle.putString("summary", aVar.f27309d);
        }
        boolean a = aVar.mo38630a();
        String str2 = KEY_TARGET_URL;
        if (a) {
            bundle.putString(str2, aVar.f27306a);
        }
        bundle.putString(AppEntity.KEY_APP_NAME_STR, this.mActivity.getPackageManager().getApplicationLabel(this.mActivity.getApplicationInfo()).toString());
        putImageUrl(aVar, bundle, equals);
        int f = aVar.mo38635f();
        String str3 = KEY_REQ_TYPE;
        if (f != 1) {
            if (f == 2 || f == 4) {
                if (equals) {
                    bundle.putInt(str3, 5);
                    bundle.putString(KEY_IMAGE_LOCAL_URL, ((MoImage) aVar.f27311f).mo38641b());
                } else {
                    bundle.putInt(str3, 3);
                }
                shareTo(bundle, equals, true, fVar);
            } else if (f == 5) {
                equals = !equals;
                bundle.putInt(str3, 2);
                bundle.putString(KEY_AUDIO_URL, ((MoMusic) aVar.f27311f).f27317a);
                shareTo(bundle, true, false, fVar);
            } else if (f == 6) {
                bundle.putInt(str3, 2);
                bundle.putString(KEY_AUDIO_VIDEO_PATH, ((MoVideo) aVar.f27311f).f27321a);
                shareTo(bundle, false, true, fVar);
            } else if (f != 7) {
                equals = true;
            } else {
                bundle.putInt(str3, 1);
                bundle.putString(str2, ((MoWeb) aVar.f27311f).f27323a);
                shareTo(bundle, equals, false, fVar);
            }
            equals = false;
        } else {
            bundle.putInt(str3, 3);
            shareTo(bundle, equals, true, fVar);
        }
        if (equals) {
            fVar.mo20728a(this.mActivity, 3, "不支持的分享类型");
        }
    }

    /* access modifiers changed from: 0000 */
    public void putImageUrl(ShareData aVar, Bundle bundle, boolean z) {
        boolean z2 = aVar.f27311f instanceof MoImage;
        String str = KEY_IMAGE_URL;
        if (z2) {
            if (z) {
                bundle.putString(str, ((MoImage) aVar.f27311f).mo38641b());
            } else {
                bundle.putStringArrayList(str, imageList(((MoImage) aVar.f27311f).mo38641b()));
            }
        } else if (!aVar.mo38634e()) {
        } else {
            if (z) {
                bundle.putString(str, aVar.f27310e.mo38637a());
            } else {
                bundle.putStringArrayList(str, imageList(aVar.f27310e.mo38637a()));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void shareTo(Bundle bundle, boolean z, boolean z2, OnCallback<String> fVar) {
        if (z) {
            fVar.mo20727a(this.mActivity);
            this.mApi.shareToQQ(this.mActivity, bundle, this.mListener);
        } else if (z2) {
            fVar.mo20727a(this.mActivity);
            this.mApi.publishToQzone(this.mActivity, bundle, this.mListener);
        } else {
            fVar.mo20727a(this.mActivity);
            this.mApi.shareToQzone(this.mActivity, bundle, this.mListener);
        }
        Log.e("ezy.sdk3rd.qq.share", bundle.toString());
    }

    /* access modifiers changed from: 0000 */
    public ArrayList<String> imageList(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        return arrayList;
    }

    public void onResult(int i, int i2, Intent intent) {
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, this.mListener);
        }
    }
}
