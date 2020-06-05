package com.tencent.p605ep.commonbase.utils;

import android.util.Log;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: com.tencent.ep.commonbase.utils.JceStructUtil */
public class JceStructUtil {
    private static final String ENCODE_TYPE = "UTF-8";

    private static JceInputStream createUTF8InputStream(byte[] bArr) {
        JceInputStream jceInputStream = new JceInputStream(bArr);
        jceInputStream.setServerEncoding(ENCODE_TYPE);
        return jceInputStream;
    }

    public static <T extends JceStruct> T getJceStruct(byte[] bArr, T t, boolean z) {
        if (!(bArr == null || t == null)) {
            if (z) {
                try {
                    t = t.newInit();
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getJceStruct exception: ");
                    sb.append(e);
                    Log.e("JceStructUtil", sb.toString());
                }
            }
            t.recyle();
            t.readFrom(createUTF8InputStream(bArr));
            return t;
        }
        return null;
    }

    public static <T extends JceStruct> T getJceStructInner(byte[] bArr, T t, boolean z) {
        if (!(bArr == null || t == null)) {
            if (z) {
                try {
                    T newInit = t.newInit();
                    if (newInit != null) {
                        t = newInit;
                    }
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getJceStruct exception: ");
                    sb.append(e);
                    Log.e("JceStructUtil", sb.toString());
                }
            }
            t.recyle();
            t.readFrom(createUTF8InputStream(bArr));
            return t;
        }
        return null;
    }

    public static byte[] jceStructToUTF8ByteArray(JceStruct jceStruct) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding(ENCODE_TYPE);
        jceStruct.writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
    }
}
