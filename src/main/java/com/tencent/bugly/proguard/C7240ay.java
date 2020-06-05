package com.tencent.bugly.proguard;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ay */
public class C7240ay implements C7244bb {
    /* renamed from: a */
    private String f24439a = null;

    /* renamed from: a */
    public byte[] mo34861a(byte[] bArr) throws Exception {
        String str;
        if (this.f24439a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            str = " ";
            if (i >= length) {
                break;
            }
            byte b = bArr[i];
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            sb.append(str);
            stringBuffer.append(sb.toString());
            i++;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.f24439a.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(this.f24439a.getBytes()));
        byte[] doFinal = instance.doFinal(bArr);
        StringBuffer stringBuffer2 = new StringBuffer();
        for (byte b2 : doFinal) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b2);
            sb2.append(str);
            stringBuffer2.append(sb2.toString());
        }
        return doFinal;
    }

    /* renamed from: b */
    public byte[] mo34862b(byte[] bArr) throws Exception, NoSuchAlgorithmException {
        String str;
        if (this.f24439a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            str = " ";
            if (i >= length) {
                break;
            }
            byte b = bArr[i];
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            sb.append(str);
            stringBuffer.append(sb.toString());
            i++;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.f24439a.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(this.f24439a.getBytes()));
        byte[] doFinal = instance.doFinal(bArr);
        StringBuffer stringBuffer2 = new StringBuffer();
        for (byte b2 : doFinal) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b2);
            sb2.append(str);
            stringBuffer2.append(sb2.toString());
        }
        return doFinal;
    }

    /* renamed from: a */
    public void mo34860a(String str) {
        if (str != null) {
            for (int length = str.length(); length < 16; length++) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("0");
                str = sb.toString();
            }
            this.f24439a = str.substring(0, 16);
        }
    }
}
