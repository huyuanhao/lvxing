package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.Secure;
import com.bytedance.embedapplog.util.C1856h;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.o */
class C1828o extends C1816c {
    /* renamed from: e */
    private final Context f5126e;

    C1828o(Context context) {
        super(false, false);
        this.f5126e = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        String str;
        String str2;
        try {
            str = Secure.getString(this.f5126e.getContentResolver(), "android_id");
        } catch (Exception e) {
            C1856h.m6584c("", e);
            str = null;
        }
        String str3 = "openudid";
        if (!C1822i.m6385d(str) || "9774d56d682e549c".equals(str)) {
            SharedPreferences sharedPreferences = this.f5126e.getSharedPreferences("snssdk_openudid", 0);
            str2 = sharedPreferences.getString(str3, null);
            if (!C1822i.m6385d(str2)) {
                String bigInteger = new BigInteger(64, new SecureRandom()).toString(16);
                if (bigInteger.charAt(0) == '-') {
                    bigInteger = bigInteger.substring(1);
                }
                int length = 13 - bigInteger.length();
                if (length > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (length > 0) {
                        sb.append('F');
                        length--;
                    }
                    sb.append(bigInteger);
                    bigInteger = sb.toString();
                }
                str2 = mo13365a("openudid.dat", bigInteger);
                Editor edit = sharedPreferences.edit();
                edit.putString(str3, str2);
                edit.apply();
            }
        } else {
            str2 = str;
        }
        jSONObject.put(str3, str2);
        return true;
    }
}
