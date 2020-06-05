package com.tencent.android.tpush.service.channel.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.encrypt.C6931a;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.p595e.C7053f;
import com.tencent.android.tpush.service.p595e.C7056i;
import java.io.File;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: ProGuard */
public class TpnsSecurity {
    private static final String DEVICE_ID_KEY_NAME = "deviceId_v1";
    private static final String DEVICE_ID_PREFIX = "deviceId_";
    private static final String DEVICE_ID_VERSION = "v1";
    private static final String SETTINGS_DEVICE_ID_KEY_NAME = ".com.tencent.tpush.cache.deviceId_v1";
    private static final String SETTINGS_DEVICE_ID_PREFIX = ".com.tencent.tpush.cache";
    private static final String SHAREPREFERENCE_FILE_NAME = "device_id";
    private static boolean loadedTpnsSecuritySo = false;
    public static C7044e tea = null;
    public static final String tpnsSecurityLibFullName = "libtpnsSecurity.so";
    private static final String tpnsSecurityLibName = "tpnsSecurity";
    protected byte[] encKey;
    protected long inc = 0;
    protected long incRemote;
    /* renamed from: iv */
    protected byte[] f23404iv;
    protected byte[] key;
    String modulusStr = "C0EF17C0E492C4D366E236902188EF567990289AF267DDC48134C78F3D5632BACB469E1961DD7D61EFEC6B045A138C4DC2E53CC850E796B20664B8F8F58B96F81C9827F7F0C3A15CC4B5BDB5DA2AED5D70E804765F6025613522779A381F5EF3A20A9B043ECA001DB50F873E1CDF335AD382AC66BE3E419CA8F67009BFF3253F";
    protected long random;

    public static native byte[] generateAESKey();

    public static native byte[] generateIV(long j);

    public static native String generateLocalSocketServieNameNative(Object obj);

    public static native String getBusinessDeviceIdNative(Object obj);

    public static native String getEncryptAPKSignatureNative(Object obj);

    public static native byte[] oiSymmetryDecrypt2Byte(byte[] bArr);

    public static native byte[] oiSymmetryEncrypt2Byte(String str);

    public native byte[] decryptByAES(byte[] bArr, long j);

    public native byte[] encryptByAES(byte[] bArr, long j);

    public native byte[] encryptByRSA(byte[] bArr);

    static {
        try {
            System.loadLibrary(tpnsSecurityLibName);
            loadedTpnsSecuritySo = true;
        } catch (Throwable th) {
            C6864a.m29302d(Constants.ServiceLogTag, "can not load library,error:", th);
            loadedTpnsSecuritySo = false;
        }
    }

    public static boolean checkTpnsSecurityLibSo(Context context) {
        String str = "lib";
        if (loadedTpnsSecuritySo) {
            return true;
        }
        if (context != null) {
            String str2 = "";
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getDir(str, 0).getParentFile().getAbsolutePath());
                sb.append(File.separator);
                sb.append(str);
                sb.append(File.separator);
                sb.append(tpnsSecurityLibFullName);
                str2 = sb.toString();
                System.load(str2);
                loadedTpnsSecuritySo = true;
            } catch (Throwable th) {
                loadedTpnsSecuritySo = false;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("can not load library from ");
                sb2.append(str2);
                sb2.append(",error:");
                sb2.append(th);
                C6864a.m29308i(Constants.ServiceLogTag, sb2.toString());
            }
        }
        return loadedTpnsSecuritySo;
    }

    public long getRandom() {
        return this.random;
    }

    public byte[] getEncKey() {
        return this.encKey;
    }

    public long getInc() {
        long j = this.inc + 1;
        this.inc = j;
        return j;
    }

    public void checkRemoteInc(long j) {
        if (j > this.incRemote) {
            this.incRemote = j;
            return;
        }
        throw new SecurityException("检查的inc小于等于当前记录的远端inc");
    }

    public void reset() {
        this.random = 0;
    }

    public boolean needsUpdate() {
        return this.random == 0;
    }

    public void update() {
        this.random = 0;
        while (true) {
            long j = this.random;
            if (j == 0) {
                this.random = (long) (Math.random() * 2.147483647E9d);
            } else {
                this.f23404iv = generateIV(j);
                try {
                    this.key = generateAESKey();
                    this.encKey = encryptByRSA(this.key);
                    return;
                } catch (Throwable th) {
                    C6864a.m29302d(Constants.ServiceLogTag, "update error:", th);
                    return;
                }
            }
        }
    }

    public byte[] decryptData(byte[] bArr) {
        try {
            bArr = decryptByAES(bArr, this.random);
            return bArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr;
        }
    }

    public byte[] encryptData(byte[] bArr) {
        try {
            bArr = encryptByAES(bArr, this.random);
            return bArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr;
        }
    }

    private static String toCharsString(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = (b >> 4) & 15;
            int i3 = i * 2;
            cArr[i3] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            byte b2 = b & 15;
            cArr[i3 + 1] = (char) (b2 >= 10 ? (b2 + 97) - 10 : b2 + 48);
        }
        return new String(cArr);
    }

    public static String oiSymmetryEncrypt2(String str) {
        String str2 = "failed";
        String str3 = Constants.ServiceLogTag;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    byte[] oiSymmetryEncrypt2Byte = oiSymmetryEncrypt2Byte(str);
                    if (oiSymmetryEncrypt2Byte == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(">> oiSymmetryEncrypt2 加密失败，返回空字符串 inBuff:");
                        sb.append(str);
                        C6864a.m29308i(str3, sb.toString());
                        return str2;
                    }
                    String a = C7042c.m30106a(oiSymmetryEncrypt2Byte);
                    if (a != null) {
                        return a;
                    }
                    C6864a.m29308i(str3, ">> oiSymmetryEncrypt2 Base64编码失败，返回空字符串");
                    return str2;
                }
            } catch (Throwable th) {
                C6864a.m29302d(str3, ">> oiSymmetryEncrypt2 未知错误", th);
                return str2;
            }
        }
        C6864a.m29308i(str3, ">> oiSymmetryEncrypt2 加密内容输入为空");
        return "";
    }

    public static String oiSymmetryDecrypt2(String str) {
        String str2 = "";
        str2.getBytes();
        String str3 = "failed";
        String str4 = Constants.ServiceLogTag;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    byte[] a = C7041b.m30105a(str);
                    if (a != null) {
                        if (a.length > 0) {
                            byte[] oiSymmetryDecrypt2Byte = oiSymmetryDecrypt2Byte(a);
                            if (oiSymmetryDecrypt2Byte != null && oiSymmetryDecrypt2Byte.length > 0) {
                                return new String(oiSymmetryDecrypt2Byte);
                            }
                            C6864a.m29308i(str4, ">> oiSymmetryDecrypt2 解密失败，返回空字符串");
                            return str3;
                        }
                    }
                    C6864a.m29308i(str4, ">> oiSymmetryDecrypt2 解码失败，返回空字符串");
                    return str3;
                }
            } catch (Throwable th) {
                C6864a.m29302d(str4, ">> oiSymmetryEncrypt2 未知错误", th);
                return str3;
            }
        }
        C6864a.m29308i(str4, ">> oiSymmetryDecrypt2 解密内容输入为空");
        return str2;
    }

    public static String generateLocalSocketServieName(Context context) {
        if (context != null) {
            try {
                return generateLocalSocketServieNameNative(context);
            } catch (Throwable th) {
                C6864a.m29302d(Constants.ServiceLogTag, "generateLocalSocketServieName 未知错误", th);
            }
        }
        throw new SecurityException("generate local socket server name error");
    }

    public static String getBusinessDeviceId(Context context) {
        if (context != null) {
            String settingsLocalDeviceId = getSettingsLocalDeviceId(context);
            if (settingsLocalDeviceId != null) {
                return settingsLocalDeviceId;
            }
            String preferenceLocalDeviceId = getPreferenceLocalDeviceId(context);
            if (preferenceLocalDeviceId != null) {
                setSettingsLocalDeviceId(context, preferenceLocalDeviceId);
                return preferenceLocalDeviceId;
            }
            String businessDeviceIdNative = getBusinessDeviceIdNative(context);
            setPreferenceLocalDeviceId(context, businessDeviceIdNative);
            setSettingsLocalDeviceId(context, businessDeviceIdNative);
            return businessDeviceIdNative;
        }
        throw new SecurityException("get device id error cause context is null");
    }

    private static String getPreferenceLocalDeviceId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREPREFERENCE_FILE_NAME, 0);
        String str = DEVICE_ID_KEY_NAME;
        if (!sharedPreferences.contains(C6931a.m29598a(str))) {
            return null;
        }
        String string = sharedPreferences.getString(C6931a.m29598a(str), null);
        if (string == null || string.trim().equals("")) {
            return null;
        }
        String decrypt = Rijndael.decrypt(string);
        if (C7056i.m30194b(decrypt)) {
            return null;
        }
        return decrypt;
    }

    private static void setPreferenceLocalDeviceId(Context context, String str) {
        Editor edit = context.getSharedPreferences(SHAREPREFERENCE_FILE_NAME, 0).edit();
        edit.putString(C6931a.m29598a(DEVICE_ID_KEY_NAME), Rijndael.encrypt(str));
        edit.commit();
    }

    private static String getSettingsLocalDeviceId(Context context) {
        String a = C7053f.m30151a(context, SETTINGS_DEVICE_ID_KEY_NAME);
        if (a == null) {
            return null;
        }
        String decrypt = Rijndael.decrypt(a);
        if (C7056i.m30194b(decrypt)) {
            return null;
        }
        return decrypt;
    }

    private static void setSettingsLocalDeviceId(Context context, String str) {
        C7053f.m30155a(context, SETTINGS_DEVICE_ID_KEY_NAME, Rijndael.encrypt(str));
    }

    public static String getEncryptAPKSignature(Context context) {
        if (context != null) {
            return getEncryptAPKSignatureNative(context);
        }
        throw new SecurityException("get encrypt apk signature error");
    }

    public static byte[] java_generateAESKey() {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(128);
        return instance.generateKey().getEncoded();
    }

    public static byte[] java_generateIV(long j) {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 4; i++) {
            int i2 = i * 4;
            byte b = (byte) ((int) ((j >> (i * 8)) & 255));
            bArr[i2] = b;
            bArr[i2 + 1] = b;
            bArr[i2 + 2] = b;
            bArr[i2 + 3] = b;
        }
        return bArr;
    }

    public byte[] java_encryptByRSA(byte[] bArr) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(this.modulusStr, 16), new BigInteger("010001", 16)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
        instance.init(1, generatePublic);
        return instance.doFinal(bArr);
    }

    public byte[] java_encryptByAES(byte[] bArr, long j) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.key, "AES");
        Cipher instance = Cipher.getInstance("AES/CFB8/NoPadding");
        instance.init(1, secretKeySpec, new IvParameterSpec(this.f23404iv));
        return instance.doFinal(bArr);
    }

    public byte[] java_decryptByAES(byte[] bArr, long j) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.key, "AES");
        Cipher instance = Cipher.getInstance("AES/CFB8/NoPadding");
        instance.init(2, secretKeySpec, new IvParameterSpec(this.f23404iv));
        return instance.doFinal(bArr);
    }

    public static C7044e getTEA() {
        if (tea == null) {
            tea = new C7044e("0123456789abcdef".getBytes());
        }
        return tea;
    }

    public static byte[] java_oiSymmetryEncrypt2Byte(String str) {
        return getTEA().mo34145a(str.getBytes());
    }

    public static byte[] java_oiSymmetryDecrypt2Byte(byte[] bArr) {
        return getTEA().mo34148b(bArr);
    }
}
