package com.tencent.p607mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p607mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXMusicObject */
public class WXMusicObject implements IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXMusicObject";
    public String musicDataUrl;
    public String musicLowBandDataUrl;
    public String musicLowBandUrl;
    public String musicUrl;

    public boolean checkArgs() {
        String str;
        String str2 = this.musicUrl;
        String str3 = TAG;
        if (str2 == null || str2.length() == 0) {
            String str4 = this.musicLowBandUrl;
            if (str4 == null || str4.length() == 0) {
                str = "both arguments are null";
                Log.m31627e(str3, str);
                return false;
            }
        }
        String str5 = this.musicUrl;
        if (str5 == null || str5.length() <= LENGTH_LIMIT) {
            String str6 = this.musicLowBandUrl;
            if (str6 == null || str6.length() <= LENGTH_LIMIT) {
                return true;
            }
            str = "checkArgs fail, musicLowBandUrl is too long";
            Log.m31627e(str3, str);
            return false;
        }
        str = "checkArgs fail, musicUrl is too long";
        Log.m31627e(str3, str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
        bundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
        bundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
    }

    public int type() {
        return 3;
    }

    public void unserialize(Bundle bundle) {
        this.musicUrl = bundle.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
        this.musicDataUrl = bundle.getString("_wxmusicobject_musicDataUrl");
        this.musicLowBandDataUrl = bundle.getString("_wxmusicobject_musicLowBandDataUrl");
    }
}
