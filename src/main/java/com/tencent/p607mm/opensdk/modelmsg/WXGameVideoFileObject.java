package com.tencent.p607mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p607mm.opensdk.utils.Log;
import java.io.File;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject */
public class WXGameVideoFileObject implements IMediaObject {
    private static final int FILE_SIZE_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXGameVideoFileObject";
    private static final int URL_LENGTH_LIMIT = 10240;
    public String filePath;
    public String thumbUrl;
    public String videoUrl;

    public WXGameVideoFileObject() {
        this.filePath = null;
        this.videoUrl = null;
        this.thumbUrl = null;
    }

    public WXGameVideoFileObject(String str, String str2, String str3) {
        this.filePath = str;
        this.videoUrl = str2;
        this.thumbUrl = str3;
    }

    private int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        return (int) file.length();
    }

    public boolean checkArgs() {
        String str;
        String str2 = this.filePath;
        String str3 = TAG;
        if (str2 == null || str2.length() == 0) {
            str = "checkArgs fail, filePath is null";
        } else if (getFileSize(this.filePath) > FILE_SIZE_LIMIT) {
            str = "checkArgs fail, video file size is too large";
        } else {
            String str4 = this.videoUrl;
            if (str4 == null || str4.length() <= URL_LENGTH_LIMIT) {
                String str5 = this.thumbUrl;
                if (str5 == null || str5.length() <= URL_LENGTH_LIMIT) {
                    return true;
                }
                str = "checkArgs fail, thumbUrl is too long";
            } else {
                str = "checkArgs fail, videoUrl is too long";
            }
        }
        Log.m31627e(str3, str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxvideofileobject_filePath", this.filePath);
        bundle.putString("_wxvideofileobject_cdnUrl", this.videoUrl);
        bundle.putString("_wxvideofileobject_thumbUrl", this.thumbUrl);
    }

    public int type() {
        return 39;
    }

    public void unserialize(Bundle bundle) {
        this.filePath = bundle.getString("_wxvideofileobject_filePath");
        this.videoUrl = bundle.getString("_wxvideofileobject_cdnUrl");
        this.thumbUrl = bundle.getString("_wxvideofileobject_thumbUrl");
    }
}
