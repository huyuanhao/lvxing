package iko.dmaz.lloq.p654a;

/* renamed from: iko.dmaz.lloq.a.b */
public class C8060b {
    /* renamed from: a */
    public static String m34878a(String str, String str2) {
        String str3 = "utf-8";
        try {
            return C8059a.m34874a(m34880a(str.getBytes(str3), str2.getBytes(str3)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static byte[] m34879a(byte[] bArr, byte b) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr[i] ^ b);
        }
        return bArr2;
    }

    /* renamed from: a */
    public static byte[] m34880a(byte[] bArr, byte[] bArr2) {
        for (byte a : bArr2) {
            bArr = m34879a(bArr, a);
        }
        return bArr;
    }
}
