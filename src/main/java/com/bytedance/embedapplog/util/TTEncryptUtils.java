package com.bytedance.embedapplog.util;

public class TTEncryptUtils {
    private static native byte[] ttDecrypt(byte[] bArr, int i);

    private static native byte[] ttEncrypt(byte[] bArr, int i);

    static {
        try {
            System.loadLibrary("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e) {
            C1856h.m6582a(e);
        }
    }

    /* renamed from: a */
    public static byte[] m6552a(byte[] bArr, int i) {
        try {
            return ttEncrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m6553b(byte[] bArr, int i) {
        try {
            return ttDecrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }
}
