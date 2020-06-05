package epco;

import android.text.TextUtils;
import java.util.Locale;

/* renamed from: epco.s0 */
public class C7999s0 {
    /* renamed from: a */
    public static final Locale f27194a;

    static {
        String str = "";
        f27194a = new Locale(str, str);
    }

    /* renamed from: a */
    public static int m34607a(Locale locale, Locale locale2) {
        if (locale == null) {
            return -1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage())) {
            return (TextUtils.isEmpty(locale2.getCountry()) || TextUtils.isEmpty(locale2.getLanguage())) ? 1 : 0;
        }
        if (locale.getCountry().equals(locale2.getCountry())) {
            return 3;
        }
        return TextUtils.isEmpty(locale2.getCountry()) ? 2 : 0;
    }
}
