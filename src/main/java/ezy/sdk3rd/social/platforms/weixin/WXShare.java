package ezy.sdk3rd.social.platforms.weixin;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.p607mm.opensdk.modelbase.BaseReq;
import com.tencent.p607mm.opensdk.modelbase.BaseResp;
import com.tencent.p607mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p607mm.opensdk.modelmsg.SendMessageToWX.Resp;
import com.tencent.p607mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p607mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p607mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.p607mm.opensdk.modelmsg.WXTextObject;
import com.tencent.p607mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.p607mm.opensdk.modelmsg.WXWebpageObject;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.sdk.Platform;
import ezy.sdk3rd.social.share.IShareable;
import ezy.sdk3rd.social.share.ShareData;
import ezy.sdk3rd.social.share.p652b.MoImage;
import ezy.sdk3rd.social.share.p652b.MoMusic;
import ezy.sdk3rd.social.share.p652b.MoVideo;
import ezy.sdk3rd.social.share.p652b.MoWeb;

public class WXShare extends WXBase implements IShareable {
    public /* bridge */ /* synthetic */ void onReq(BaseReq baseReq) {
        super.onReq(baseReq);
    }

    public /* bridge */ /* synthetic */ void onResp(BaseResp baseResp) {
        super.onResp(baseResp);
    }

    public /* bridge */ /* synthetic */ void onResult(int i, int i2, Intent intent) {
        super.onResult(i, i2, intent);
    }

    WXShare(Activity activity, Platform platform) {
        super(activity, platform);
    }

    public void share(ShareData aVar, OnCallback<String> fVar) {
        if (!this.mApi.isWXAppInstalled()) {
            fVar.mo20728a(this.mActivity, 3, "您未安装微信!");
            return;
        }
        this.mCallback = fVar;
        new AsyncTask<ShareData, Void, BaseReq>() {
            /* access modifiers changed from: protected|varargs */
            /* renamed from: a */
            public BaseReq doInBackground(ShareData... aVarArr) {
                return WXShare.this.makeReq(aVarArr[0]);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void onPostExecute(BaseReq baseReq) {
                WXShare.this.mCallback.mo20727a(WXShare.this.mActivity);
                WXShare.this.mApi.sendReq(baseReq);
            }
        }.execute(new ShareData[]{aVar});
    }

    /* access modifiers changed from: 0000 */
    public BaseReq makeReq(ShareData aVar) {
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        if (aVar.mo38632c()) {
            wXMediaMessage.title = aVar.f27308c;
        }
        if (aVar.mo38633d()) {
            wXMediaMessage.description = aVar.f27309d;
        }
        if (aVar.mo38634e()) {
            wXMediaMessage.thumbData = aVar.f27310e.mo38639c();
        }
        int f = aVar.mo38635f();
        if (f == 1) {
            wXMediaMessage.mediaObject = new WXTextObject(aVar.f27307b);
            wXMediaMessage.description = aVar.f27307b;
        } else if (f == 2 || f == 4) {
            MoImage bVar = (MoImage) aVar.f27311f;
            WXImageObject wXImageObject = new WXImageObject();
            wXImageObject.imagePath = bVar.mo38641b();
            if (TextUtils.isEmpty(wXImageObject.imagePath)) {
                wXImageObject.imageData = bVar.mo38642c();
            }
            wXMediaMessage.mediaObject = wXImageObject;
        } else if (f == 5) {
            MoMusic cVar = (MoMusic) aVar.f27311f;
            WXMusicObject wXMusicObject = new WXMusicObject();
            wXMusicObject.musicUrl = cVar.f27317a;
            wXMusicObject.musicDataUrl = cVar.f27318b;
            wXMusicObject.musicLowBandUrl = cVar.f27319c;
            wXMusicObject.musicLowBandDataUrl = cVar.f27320d;
            wXMediaMessage.mediaObject = wXMusicObject;
        } else if (f == 6) {
            MoVideo dVar = (MoVideo) aVar.f27311f;
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = dVar.f27321a;
            wXVideoObject.videoLowBandUrl = dVar.f27322b;
            wXMediaMessage.mediaObject = wXVideoObject;
        } else if (f == 7) {
            wXMediaMessage.mediaObject = new WXWebpageObject(((MoWeb) aVar.f27311f).f27323a);
        }
        Req req = new Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = wXMediaMessage;
        req.scene = toScene(this.mPlatform.getName());
        return req;
    }

    /* access modifiers changed from: protected */
    public void onResultOk(Resp resp) {
        this.mCallback.mo20729a(this.mActivity, "");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f A[RETURN] */
    public int toScene(java.lang.String r6) {
        /*
        r5 = this;
        int r0 = r6.hashCode()
        r1 = -1838124510(0xffffffff92707222, float:-7.5871326E-28)
        r2 = 0
        r3 = 2
        r4 = 1
        if (r0 == r1) goto L_0x002b
        r1 = 330114197(0x13ad2495, float:4.3707412E-27)
        if (r0 == r1) goto L_0x0021
        r1 = 1289316221(0x4cd9677d, float:1.1398244E8)
        if (r0 == r1) goto L_0x0017
        goto L_0x0035
    L_0x0017:
        java.lang.String r0 = "wxfavorite"
        boolean r6 = r6.equals(r0)
        if (r6 == 0) goto L_0x0035
        r6 = 2
        goto L_0x0036
    L_0x0021:
        java.lang.String r0 = "wxsession"
        boolean r6 = r6.equals(r0)
        if (r6 == 0) goto L_0x0035
        r6 = 0
        goto L_0x0036
    L_0x002b:
        java.lang.String r0 = "wxtimeline"
        boolean r6 = r6.equals(r0)
        if (r6 == 0) goto L_0x0035
        r6 = 1
        goto L_0x0036
    L_0x0035:
        r6 = -1
    L_0x0036:
        if (r6 == 0) goto L_0x003f
        if (r6 == r4) goto L_0x003e
        if (r6 == r3) goto L_0x003d
        return r2
    L_0x003d:
        return r3
    L_0x003e:
        return r4
    L_0x003f:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ezy.sdk3rd.social.platforms.weixin.WXShare.toScene(java.lang.String):int");
    }
}
