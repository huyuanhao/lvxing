package com.tencent.bugly.proguard;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.az */
public class C7241az implements C7244bb {
    /* renamed from: a */
    private String f24440a = null;

    /* renamed from: a */
    public byte[] mo34861a(byte[] bArr) throws Exception {
        if (this.f24440a == null || bArr == null) {
            return null;
        }
        Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
        String str = "UTF-8";
        instance.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f24440a.getBytes(str))), new IvParameterSpec(this.f24440a.getBytes(str)));
        return instance.doFinal(bArr);
    }

    /* renamed from: b */
    public byte[] mo34862b(byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (this.f24440a == null || bArr == null) {
            return null;
        }
        Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
        String str = "UTF-8";
        instance.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f24440a.getBytes(str))), new IvParameterSpec(this.f24440a.getBytes(str)));
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    public void mo34860a(String str) {
        if (str != null) {
            this.f24440a = str;
        }
    }
}
