package com.tencent.p605ep.commonbase.utils;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.ep.commonbase.utils.ConvertUtil */
public class ConvertUtil {
    public static final String bytesToHexString(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static int bytesToInt(byte[] bArr) {
        if (bArr == null || bArr.length <= 0 || bArr.length != 4) {
            return 0;
        }
        return ((bArr[3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | (bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
    }

    public static long bytesToLong(byte[] bArr) {
        if (bArr.length != 8) {
            return 0;
        }
        return ((((long) bArr[1]) & 255) << 8) | (((long) bArr[0]) & 255) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[7]) & 255) << 54);
    }

    public static final String bytesToString(byte[] bArr) {
        return bytesToString(bArr, true);
    }

    public static final String bytesToString(byte[] bArr, boolean z) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            stringBuffer.append((char) b);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (z) {
            stringBuffer2 = stringBuffer2.toUpperCase();
        }
        return stringBuffer2;
    }

    public static byte[] hexStringToByte(String str) {
        if (str == null || str.trim().length() <= 0) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = upperCase.toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (toByte(charArray[i2 + 1]) | (toByte(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static byte[] inputStreamToBytes(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArray;
        } catch (IOException e2) {
            e2.printStackTrace();
            byte[] bArr2 = new byte[0];
            try {
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return bArr2;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    public static byte[] intToBytes(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static byte[] longToBytes(long j) {
        return new byte[]{(byte) ((int) (j & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 48) & 255)), (byte) ((int) ((j >> 54) & 255))};
    }

    public static byte stringToByte(String str) {
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    return Byte.valueOf(str).byteValue();
                }
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public static byte[] stringToBytes(String str) {
        byte[] bArr = new byte[str.length()];
        char[] charArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = (byte) charArray[i];
        }
        return bArr;
    }

    public static int stringToInt(String str) {
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    return Integer.valueOf(str).intValue();
                }
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    private static byte toByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
