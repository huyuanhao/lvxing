package com.tencent.p607mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p607mm.opensdk.utils.Log;
import java.io.File;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXFileObject */
public class WXFileObject implements IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXFileObject";
    private int contentLengthLimit;
    public byte[] fileData;
    public String filePath;

    public WXFileObject() {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.fileData = null;
        this.filePath = null;
    }

    public WXFileObject(String str) {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.filePath = str;
    }

    public WXFileObject(byte[] bArr) {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
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
        byte[] bArr = this.fileData;
        String str2 = TAG;
        if (bArr == null || bArr.length == 0) {
            String str3 = this.filePath;
            if (str3 == null || str3.length() == 0) {
                str = "checkArgs fail, both arguments is null";
                Log.m31627e(str2, str);
                return false;
            }
        }
        byte[] bArr2 = this.fileData;
        if (bArr2 == null || bArr2.length <= this.contentLengthLimit) {
            String str4 = this.filePath;
            if (str4 == null || getFileSize(str4) <= this.contentLengthLimit) {
                return true;
            }
            str = "checkArgs fail, fileSize is too large";
            Log.m31627e(str2, str);
            return false;
        }
        str = "checkArgs fail, fileData is too large";
        Log.m31627e(str2, str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxfileobject_fileData", this.fileData);
        bundle.putString("_wxfileobject_filePath", this.filePath);
    }

    public void setContentLengthLimit(int i) {
        this.contentLengthLimit = i;
    }

    public void setFileData(byte[] bArr) {
        this.fileData = bArr;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public int type() {
        return 6;
    }

    public void unserialize(Bundle bundle) {
        this.fileData = bundle.getByteArray("_wxfileobject_fileData");
        this.filePath = bundle.getString("_wxfileobject_filePath");
    }
}
