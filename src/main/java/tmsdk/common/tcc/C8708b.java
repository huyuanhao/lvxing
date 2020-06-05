package tmsdk.common.tcc;

import android.text.TextUtils;
import btmsdkobf.C0652cl;
import btmsdkobf.C0848ff;

/* renamed from: tmsdk.common.tcc.b */
public class C8708b {
    /* renamed from: nw */
    private static volatile boolean f29578nw = false;

    /* renamed from: cJ */
    public static boolean m37729cJ() {
        String str = "]";
        String str2 = "TccUtil";
        if (f29578nw) {
            return true;
        }
        try {
            String e = C0652cl.m86E().mo9081e();
            StringBuilder sb = new StringBuilder();
            sb.append("loadLibraryIfNot libraryName:[");
            sb.append(e);
            sb.append(str);
            C0848ff.m905d(str2, sb.toString());
            if (TextUtils.isEmpty(e)) {
                return false;
            }
            System.loadLibrary(e);
            f29578nw = true;
            return f29578nw;
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("loadLibraryIfNot e:[");
            sb2.append(th.getMessage());
            sb2.append(str);
            C0848ff.m906e(str2, sb2.toString());
            th.printStackTrace();
            f29578nw = false;
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return isJavaTCC() ? C8707a.decrypt(bArr, bArr2) : TccCryptor.decrypt(bArr, bArr2);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        return isJavaTCC() ? C8707a.encrypt(bArr, bArr2) : TccCryptor.encrypt(bArr, bArr2);
    }

    public static boolean isJavaTCC() {
        return C0652cl.m86E() == null || C0652cl.m86E().isJavaTCC();
    }
}
