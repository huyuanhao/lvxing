package com.yanzhenjie.permission.p638e;

/* compiled from: StringUtils */
/* renamed from: com.yanzhenjie.permission.e.a */
public class C7838a {
    /* renamed from: a */
    private static final char[] f26663a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m34068a(String str) {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(f26663a[(bytes[i] & -16) >> 4]);
            sb.append(f26663a[bytes[i] & 15]);
        }
        return sb.toString().trim();
    }

    /* renamed from: b */
    public static String m34069b(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            String str2 = "0123456789ABCDEF";
            bArr[i] = (byte) (((str2.indexOf(charArray[i2]) * 16) + str2.indexOf(charArray[i2 + 1])) & 255);
        }
        return new String(bArr);
    }
}
