package com.tencent.mid.util;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESHelper {
    private static final String CipherMode = "AES/CFB/NoPadding";
    private static final String KEY_ALGORITHM = "AES";
    public static final List<Integer> TWO_POWER_LIST = new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8), Integer.valueOf(16), Integer.valueOf(32), Integer.valueOf(64), Integer.valueOf(128), Integer.valueOf(256), Integer.valueOf(512), Integer.valueOf(1024), Integer.valueOf(2048)}));
    /* renamed from: iv */
    private IvParameterSpec f24792iv = null;
    private SecretKey key = null;

    public static String createSecretKeyString() {
        SecretKey createSecretKey = createSecretKey();
        if (createSecretKey != null) {
            return byte2hex(createSecretKey.getEncoded());
        }
        return null;
    }

    public static SecretKey createSecretKey() {
        String str = KEY_ALGORITHM;
        try {
            KeyGenerator instance = KeyGenerator.getInstance(str);
            instance.init(128);
            return new SecretKeySpec(instance.generateKey().getEncoded(), str);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public byte[] getKeyBytes() {
        SecretKey secretKey = this.key;
        if (secretKey != null) {
            return secretKey.getEncoded();
        }
        return null;
    }

    public String getKeyString() {
        SecretKey secretKey = this.key;
        if (secretKey != null) {
            return byte2hex(secretKey.getEncoded());
        }
        return null;
    }

    public byte[] getIvBytes() {
        IvParameterSpec ivParameterSpec = this.f24792iv;
        if (ivParameterSpec != null) {
            return ivParameterSpec.getIV();
        }
        return null;
    }

    public String getIvString() {
        IvParameterSpec ivParameterSpec = this.f24792iv;
        if (ivParameterSpec != null) {
            return byte2hex(ivParameterSpec.getIV());
        }
        return null;
    }

    public static String createIvParameterString() {
        IvParameterSpec createIvParameterSpec = createIvParameterSpec();
        if (createIvParameterSpec != null) {
            return byte2hex(createIvParameterSpec.getIV());
        }
        return null;
    }

    public static IvParameterSpec createIvParameterSpec() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return new IvParameterSpec(bArr);
    }

    public void initKeyAndIV() {
        this.key = createSecretKey();
        this.f24792iv = createIvParameterSpec();
    }

    private int searchTwoPowerLength(int i, int i2) {
        if (i < i2) {
            i = i2;
        }
        if (TWO_POWER_LIST.contains(Integer.valueOf(i))) {
            return i;
        }
        for (Integer num : TWO_POWER_LIST) {
            if (num.intValue() > i) {
                return num.intValue();
            }
        }
        return i;
    }

    private byte[] fillBytes(String str, int i) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        if (length >= i) {
            return bytes;
        }
        byte[] bArr = new byte[i];
        Arrays.fill(bArr, 0);
        System.arraycopy(bytes, 0, bArr, 0, length);
        return bArr;
    }

    public void setKeyAndIV(String str, String str2) {
        int searchTwoPowerLength = searchTwoPowerLength(str.length(), str2.length());
        byte[] fillBytes = fillBytes(str, searchTwoPowerLength);
        byte[] fillBytes2 = fillBytes(str2, searchTwoPowerLength);
        this.key = new SecretKeySpec(fillBytes, KEY_ALGORITHM);
        this.f24792iv = new IvParameterSpec(fillBytes2);
    }

    public byte[] encrypt(byte[] bArr) throws Exception {
        if (this.key != null) {
            try {
                Cipher instance = Cipher.getInstance(CipherMode);
                instance.init(1, this.key, this.f24792iv);
                return instance.doFinal(bArr);
            } catch (Exception unused) {
                return null;
            }
        } else {
            throw new Exception("密钥为空, 请设置");
        }
    }

    public String encrypt(String str) throws Exception {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
        }
        return byte2hex(encrypt(bArr));
    }

    public byte[] decrypt(byte[] bArr) throws Exception {
        if (this.key != null) {
            try {
                Cipher instance = Cipher.getInstance(CipherMode);
                instance.init(2, this.key, this.f24792iv);
                return instance.doFinal(bArr);
            } catch (Exception unused) {
                return null;
            }
        } else {
            throw new Exception("密钥为空, 请设置");
        }
    }

    public String decrypt(String str) throws Exception {
        byte[] bArr;
        String str2 = null;
        try {
            bArr = hex2byte(str);
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
        }
        byte[] decrypt = decrypt(bArr);
        if (decrypt == null) {
            return null;
        }
        try {
            str2 = new String(decrypt, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        return str2;
    }

    public static String byte2hex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static byte[] hex2byte(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Integer.parseInt(lowerCase.substring(i2, i2 + 2), 16) & 255);
        }
        return bArr;
    }
}
