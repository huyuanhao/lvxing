package com.p368pw.inner;

import android.content.Context;
import android.text.TextUtils;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5205o;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.pw.inner.g */
public class C5238g {
    /* renamed from: a */
    public static int m21603a(int i, int i2) {
        return (int) (((double) i) + (Math.random() * ((double) (i2 - i))));
    }

    /* renamed from: a */
    public static String m21604a(Context context) {
        String str = "";
        String c = C5233e.m21558a().mo26928c();
        try {
            if (TextUtils.isEmpty(c)) {
                c = C5237f.m21568a(context);
            }
            return TextUtils.isEmpty(c) ? str : c;
        } catch (Throwable unused) {
            return str;
        }
    }

    /* renamed from: a */
    public static void m21605a(Context context, String str) {
        long j = 0;
        if (C5237f.m21590e(context) <= 0) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject optJSONObject = new JSONObject(C5162b.m21305a().mo26771b(str)).optJSONObject("res_status");
                    if (optJSONObject.optInt("resp_code") == 200) {
                        j = optJSONObject.optLong("req_id", 0);
                        C5237f.m21579b(context, j);
                    }
                }
            } catch (Exception e) {
                C5205o.m21464a((Throwable) e);
            }
        }
    }

    /* renamed from: a */
    public static boolean m21606a(String str) {
        try {
            Matcher matcher = Pattern.compile("(\\d{3,6}_\\d{3,6})").matcher(str);
            if (!matcher.find()) {
                return false;
            }
            String group = matcher.group(0);
            StringBuilder sb = new StringBuilder();
            sb.append("placement id = ");
            sb.append(group);
            C5205o.m21462a(sb.toString());
            return true;
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }
}
