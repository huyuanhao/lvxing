package com.tencent.android.tpush.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.common.e */
public class C6905e {
    /* renamed from: a */
    public static String m29468a(Serializable serializable) {
        if (serializable == null) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return m29469a(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: a */
    public static Object m29467a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return new ObjectInputStream(new ByteArrayInputStream(m29470b(str))).readObject();
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: a */
    public static String m29469a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append((char) (((bArr[i] >> 4) & 15) + 97));
            stringBuffer.append((char) ((bArr[i] & 15) + 97));
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static byte[] m29470b(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length(); i += 2) {
            char charAt = str.charAt(i);
            int i2 = i / 2;
            if (i2 < bArr.length) {
                bArr[i2] = (byte) ((charAt - 'a') << 4);
                bArr[i2] = (byte) (bArr[i2] + (str.charAt(i + 1) - 'a'));
            }
        }
        return bArr;
    }
}
