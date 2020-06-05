package com.tencent.mid.util;

import android.util.Base64;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAHelper {
    private static final String CipherMode = "RSA/NONE/PKCS1PADDING";
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static RSAPublicKey key;

    public static void createPublicKey(String str) throws Exception {
        try {
            key = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("公钥数据为空");
        }
    }

    public static byte[] encrypt(byte[] bArr) throws Exception {
        byte[] bArr2;
        if (key != null) {
            Cipher instance = Cipher.getInstance(CipherMode);
            instance.init(1, key);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length - i;
                if (i3 > 0) {
                    if (i3 > 117) {
                        bArr2 = instance.doFinal(bArr, i, 117);
                    } else {
                        bArr2 = instance.doFinal(bArr, i, i3);
                    }
                    byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                    i2++;
                    i = i2 * 117;
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } else {
            throw new Exception("加密公钥为空, 请设置");
        }
    }

    public static byte[] encrypt(String str) throws Exception {
        if (key != null) {
            try {
                Cipher instance = Cipher.getInstance(CipherMode);
                instance.init(1, key);
                String[] splitString = splitString(str, (key.getModulus().bitLength() / 8) - 11);
                byte[] bArr = new byte[0];
                int length = splitString.length;
                byte[] bArr2 = bArr;
                int i = 0;
                while (i < length) {
                    byte[] bArr3 = new byte[(bArr2.length + 256)];
                    System.arraycopy(instance.doFinal(splitString[i].getBytes()), 0, bArr3, bArr2.length, 256);
                    i++;
                    bArr2 = bArr3;
                }
                return bArr2;
            } catch (NoSuchAlgorithmException unused) {
                throw new Exception("无此加密算法");
            } catch (NoSuchPaddingException unused2) {
                throw new Exception("Padding错误");
            } catch (InvalidKeyException unused3) {
                throw new Exception("加密公钥非法,请检查");
            } catch (IllegalBlockSizeException unused4) {
                throw new Exception("明文长度非法");
            } catch (BadPaddingException unused5) {
                throw new Exception("明文数据已损坏");
            }
        } else {
            throw new Exception("加密公钥为空, 请设置");
        }
    }

    public static String decrypt(byte[] bArr) throws Exception {
        byte[][] splitArray;
        if (key != null) {
            try {
                Cipher instance = Cipher.getInstance(CipherMode);
                instance.init(2, key);
                int bitLength = key.getModulus().bitLength() / 8;
                String str = "";
                if (bitLength > 0) {
                    for (byte[] bArr2 : splitArray(bArr, bitLength)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(new String(instance.doFinal(bArr2), "UTF-8"));
                        str = sb.toString();
                    }
                }
                return str;
            } catch (NoSuchAlgorithmException unused) {
                throw new Exception("无此解密算法");
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
                return null;
            } catch (InvalidKeyException unused2) {
                throw new Exception("解密私钥非法,请检查");
            } catch (IllegalBlockSizeException unused3) {
                throw new Exception("密文长度非法");
            } catch (BadPaddingException unused4) {
                throw new Exception("密文数据已损坏");
            } catch (Exception unused5) {
                throw new Exception("发生未知异常");
            }
        } else {
            throw new Exception("解密公钥为空, 请设置");
        }
    }

    private static String byte2hex(byte[] bArr) {
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

    private static byte[] hex2byte(String str) {
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

    public static String[] splitString(String str, int i) {
        String str2;
        int length = str.length() % i;
        int length2 = (str.length() / i) + (length != 0 ? 1 : 0);
        String[] strArr = new String[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            if (i2 != length2 - 1 || length == 0) {
                int i3 = i2 * i;
                str2 = str.substring(i3, i3 + i);
            } else {
                int i4 = i2 * i;
                str2 = str.substring(i4, i4 + length);
            }
            strArr[i2] = str2;
        }
        return strArr;
    }

    public static byte[][] splitArray(byte[] bArr, int i) {
        int length = bArr.length % i;
        int length2 = (bArr.length / i) + (length != 0 ? 1 : 0);
        byte[][] bArr2 = new byte[length2][];
        for (int i2 = 0; i2 < length2; i2++) {
            byte[] bArr3 = new byte[i];
            if (i2 != length2 - 1 || length == 0) {
                System.arraycopy(bArr, i2 * i, bArr3, 0, i);
            } else {
                System.arraycopy(bArr, i2 * i, bArr3, 0, length);
            }
            bArr2[i2] = bArr3;
        }
        return bArr2;
    }
}
