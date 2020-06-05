package com.tencent.p607mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p607mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXVideoObject */
public class WXVideoObject implements IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXVideoObject";
    public String videoLowBandUrl;
    public String videoUrl;

    public boolean checkArgs() {
        String str;
        String str2 = this.videoUrl;
        String str3 = TAG;
        if (str2 == null || str2.length() == 0) {
            String str4 = this.videoLowBandUrl;
            if (str4 == null || str4.length() == 0) {
                str = "both arguments are null";
                Log.m31627e(str3, str);
                return false;
            }
        }
        String str5 = this.videoUrl;
        if (str5 == null || str5.length() <= LENGTH_LIMIT) {
            String str6 = this.videoLowBandUrl;
            if (str6 == null || str6.length() <= LENGTH_LIMIT) {
                return true;
            }
            str = "checkArgs fail, videoLowBandUrl is too long";
            Log.m31627e(str3, str);
            return false;
        }
        str = "checkArgs fail, videoUrl is too long";
        Log.m31627e(str3, str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxvideoobject_videoUrl", this.videoUrl);
        bundle.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
    }

    public int type() {
        return 4;
    }

    public void unserialize(Bundle bundle) {
        this.videoUrl = bundle.getString("_wxvideoobject_videoUrl");
        this.videoLowBandUrl = bundle.getString("_wxvideoobject_videoLowBandUrl");
    }
}
