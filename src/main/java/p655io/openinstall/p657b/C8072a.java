package p655io.openinstall.p657b;

import android.util.Base64;
import java.nio.charset.Charset;

/* renamed from: io.openinstall.b.a */
public class C8072a {
    /* renamed from: a */
    public static String m34905a(String str, int i) {
        try {
            return new String(Base64.decode(str, i), Charset.forName("UTF-8"));
        } catch (Exception unused) {
            return str;
        }
    }
}
