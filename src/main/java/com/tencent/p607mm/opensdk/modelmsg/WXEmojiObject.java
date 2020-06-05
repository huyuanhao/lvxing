package com.tencent.p607mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p607mm.opensdk.utils.Log;
import java.io.File;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXEmojiObject */
public class WXEmojiObject implements IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXEmojiObject";
    public byte[] emojiData;
    public String emojiPath;

    public WXEmojiObject() {
        this.emojiData = null;
        this.emojiPath = null;
    }

    public WXEmojiObject(String str) {
        this.emojiPath = str;
    }

    public WXEmojiObject(byte[] bArr) {
        this.emojiData = bArr;
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
        byte[] bArr = this.emojiData;
        String str2 = TAG;
        if (bArr == null || bArr.length == 0) {
            String str3 = this.emojiPath;
            if (str3 == null || str3.length() == 0) {
                str = "checkArgs fail, both arguments is null";
                Log.m31627e(str2, str);
                return false;
            }
        }
        byte[] bArr2 = this.emojiData;
        if (bArr2 == null || bArr2.length <= CONTENT_LENGTH_LIMIT) {
            String str4 = this.emojiPath;
            if (str4 == null || getFileSize(str4) <= CONTENT_LENGTH_LIMIT) {
                return true;
            }
            str = "checkArgs fail, emojiSize is too large";
            Log.m31627e(str2, str);
            return false;
        }
        str = "checkArgs fail, emojiData is too large";
        Log.m31627e(str2, str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
        bundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
    }

    public void setEmojiData(byte[] bArr) {
        this.emojiData = bArr;
    }

    public void setEmojiPath(String str) {
        this.emojiPath = str;
    }

    public int type() {
        return 8;
    }

    public void unserialize(Bundle bundle) {
        this.emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
        this.emojiPath = bundle.getString("_wxemojiobject_emojiPath");
    }
}
