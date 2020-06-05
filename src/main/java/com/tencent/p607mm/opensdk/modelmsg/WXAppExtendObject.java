package com.tencent.p607mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p607mm.opensdk.utils.Log;
import java.io.File;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXAppExtendObject */
public class WXAppExtendObject implements IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final int EXTINFO_LENGTH_LIMIT = 2048;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject() {
    }

    public WXAppExtendObject(String str, String str2) {
        this.extInfo = str;
        this.filePath = str2;
    }

    public WXAppExtendObject(String str, byte[] bArr) {
        this.extInfo = str;
        this.fileData = bArr;
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
        String str2 = this.extInfo;
        String str3 = TAG;
        if (str2 == null || str2.length() == 0) {
            String str4 = this.filePath;
            if (str4 == null || str4.length() == 0) {
                byte[] bArr = this.fileData;
                if (bArr == null || bArr.length == 0) {
                    str = "checkArgs fail, all arguments is null";
                    Log.m31627e(str3, str);
                    return false;
                }
            }
        }
        String str5 = this.extInfo;
        if (str5 == null || str5.length() <= 2048) {
            String str6 = this.filePath;
            if (str6 == null || str6.length() <= PATH_LENGTH_LIMIT) {
                String str7 = this.filePath;
                if (str7 == null || getFileSize(str7) <= CONTENT_LENGTH_LIMIT) {
                    byte[] bArr2 = this.fileData;
                    if (bArr2 == null || bArr2.length <= CONTENT_LENGTH_LIMIT) {
                        return true;
                    }
                    str = "checkArgs fail, fileData is too large";
                    Log.m31627e(str3, str);
                    return false;
                }
                str = "checkArgs fail, fileSize is too large";
                Log.m31627e(str3, str);
                return false;
            }
            str = "checkArgs fail, filePath is invalid";
            Log.m31627e(str3, str);
            return false;
        }
        str = "checkArgs fail, extInfo is invalid";
        Log.m31627e(str3, str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxappextendobject_extInfo", this.extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
        bundle.putString("_wxappextendobject_filePath", this.filePath);
    }

    public int type() {
        return 7;
    }

    public void unserialize(Bundle bundle) {
        this.extInfo = bundle.getString("_wxappextendobject_extInfo");
        this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
        this.filePath = bundle.getString("_wxappextendobject_filePath");
    }
}
