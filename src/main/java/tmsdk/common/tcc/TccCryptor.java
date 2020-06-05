package tmsdk.common.tcc;

public class TccCryptor {
    public static int EndianSwap(int i) {
        return (i >>> 24) | (i << 24) | ((65280 & i) << 8) | ((16711680 & i) >>> 8);
    }

    /* renamed from: cC */
    public static native void m37726cC(int i);

    public static native byte[] decrypt(byte[] bArr, byte[] bArr2);

    public static native byte[] encrypt(byte[] bArr, byte[] bArr2);

    public static native int getProcBitStatus();

    public static native byte[] makePassword(byte[] bArr);
}
