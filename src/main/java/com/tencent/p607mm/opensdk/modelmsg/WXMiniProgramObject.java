package com.tencent.p607mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p607mm.opensdk.utils.C7339d;
import com.tencent.p607mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject */
public class WXMiniProgramObject implements IMediaObject {
    public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
    public static final int MINIPROGRAM_TYPE_TEST = 1;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    private static final String TAG = "MicroMsg.SDK.WXMiniProgramObject";
    public int miniprogramType = 0;
    public String path;
    public String userName;
    public String webpageUrl;
    public boolean withShareTicket;

    public boolean checkArgs() {
        String str;
        boolean b = C7339d.m31636b(this.webpageUrl);
        String str2 = TAG;
        if (b) {
            str = "webPageUrl is null";
        } else if (C7339d.m31636b(this.userName)) {
            str = "userName is null";
        } else {
            int i = this.miniprogramType;
            if (i >= 0 && i <= 2) {
                return true;
            }
            str = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
        }
        Log.m31627e(str2, str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        bundle.putString("_wxminiprogram_username", this.userName);
        bundle.putString("_wxminiprogram_path", this.path);
        bundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
        bundle.putInt("_wxminiprogram_type", this.miniprogramType);
    }

    public int type() {
        return 36;
    }

    public void unserialize(Bundle bundle) {
        this.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
        this.userName = bundle.getString("_wxminiprogram_username");
        this.path = bundle.getString("_wxminiprogram_path");
        this.withShareTicket = bundle.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = bundle.getInt("_wxminiprogram_type");
    }
}
