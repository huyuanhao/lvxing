package com.tencent.p607mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p607mm.opensdk.utils.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXImageObject */
public class WXImageObject implements IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 26214400;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXImageObject";
    public byte[] imageData;
    public String imagePath;

    public WXImageObject() {
    }

    public WXImageObject(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("WXImageObject <init>, exception:");
            sb.append(e.getMessage());
            Log.m31627e(TAG, sb.toString());
        }
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
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
        byte[] bArr = this.imageData;
        String str2 = TAG;
        if (bArr == null || bArr.length == 0) {
            String str3 = this.imagePath;
            if (str3 == null || str3.length() == 0) {
                str = "checkArgs fail, all arguments are null";
                Log.m31627e(str2, str);
                return false;
            }
        }
        byte[] bArr2 = this.imageData;
        if (bArr2 == null || bArr2.length <= CONTENT_LENGTH_LIMIT) {
            String str4 = this.imagePath;
            if (str4 == null || str4.length() <= PATH_LENGTH_LIMIT) {
                String str5 = this.imagePath;
                if (str5 == null || getFileSize(str5) <= CONTENT_LENGTH_LIMIT) {
                    return true;
                }
                str = "checkArgs fail, image content is too large";
                Log.m31627e(str2, str);
                return false;
            }
            str = "checkArgs fail, path is invalid";
            Log.m31627e(str2, str);
            return false;
        }
        str = "checkArgs fail, content is too large";
        Log.m31627e(str2, str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public int type() {
        return 2;
    }

    public void unserialize(Bundle bundle) {
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
    }
}
