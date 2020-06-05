package btmsdkobf;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import tmsdk.common.tcc.C8708b;

/* renamed from: btmsdkobf.ew */
public class C0832ew {
    private static String TAG = "CryptorUtils";

    /* renamed from: x */
    public static String m866x(String str) {
        String str2;
        StringBuilder sb;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            byte[] encrypt = C8708b.encrypt(str.getBytes("gbk"), null);
            if (encrypt != null) {
                return C0828ev.encodeToString(encrypt, 0);
            }
        } catch (UnsupportedEncodingException e) {
            e = e;
            str3 = TAG;
            sb = new StringBuilder();
            str2 = "getEncodeString, UnsupportedEncodingException: ";
            sb.append(str2);
            sb.append(e);
            C0849fg.m912e(str3, sb.toString());
            return null;
        } catch (Exception e2) {
            e = e2;
            str3 = TAG;
            sb = new StringBuilder();
            str2 = "getEncodeString, Exception: ";
            sb.append(str2);
            sb.append(e);
            C0849fg.m912e(str3, sb.toString());
            return null;
        }
        return null;
    }

    /* renamed from: y */
    public static String m867y(String str) {
        String str2;
        StringBuilder sb;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            byte[] decrypt = C8708b.decrypt(C0828ev.decode(str, 0), null);
            if (decrypt != null) {
                return new String(decrypt, "gbk");
            }
        } catch (UnsupportedEncodingException e) {
            e = e;
            str3 = TAG;
            sb = new StringBuilder();
            str2 = "getDecodeString, UnsupportedEncodingException: ";
            sb.append(str2);
            sb.append(e);
            C0849fg.m912e(str3, sb.toString());
            return null;
        } catch (Exception e2) {
            e = e2;
            str3 = TAG;
            sb = new StringBuilder();
            str2 = "getDecodeString, Exception: ";
            sb.append(str2);
            sb.append(e);
            C0849fg.m912e(str3, sb.toString());
            return null;
        }
        return null;
    }
}
