package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.C1505a;
import com.alipay.sdk.util.C1542e;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public final class PayResultActivity extends Activity {
    /* renamed from: a */
    public static final HashMap<String, Object> f3801a = new HashMap<>();

    /* renamed from: com.alipay.sdk.app.PayResultActivity$a */
    public static final class C1491a {
        /* renamed from: a */
        public static volatile String f3802a;
        /* renamed from: b */
        public static volatile String f3803b;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str = "orderSuffix";
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (!TextUtils.isEmpty(intent.getStringExtra(str))) {
                C1491a.f3802a = intent.getStringExtra("phonecashier.pay.hash");
                m4400a(this, C1491a.f3802a, intent.getStringExtra(str), intent.getStringExtra("externalPkgName"));
                m4399a((Activity) this, 300);
                return;
            }
            String stringExtra = intent.getStringExtra("phonecashier.pay.result");
            int intExtra = intent.getIntExtra("phonecashier.pay.resultOrderHash", 0);
            if (intExtra != 0) {
                if (TextUtils.equals(C1491a.f3802a, String.valueOf(intExtra))) {
                    if (!TextUtils.isEmpty(stringExtra)) {
                        m4402a(stringExtra, C1491a.f3802a);
                    } else {
                        m4401a(C1491a.f3802a);
                    }
                    C1491a.f3802a = "";
                    m4399a((Activity) this, 300);
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected ");
            sb.append(C1491a.f3802a);
            sb.append(", got ");
            sb.append(intExtra);
            C1505a.m4452a(KEYS.BIZ, "SchemePayWrongHashEx", sb.toString());
            m4401a(C1491a.f3802a);
            m4399a((Activity) this, 300);
        } catch (Throwable unused) {
            finish();
        }
    }

    /* renamed from: a */
    private static void m4400a(Activity activity, String str, String str2, String str3) {
        String str4 = "UTF-8";
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Intent intent = new Intent();
            try {
                intent.setPackage("hk.alipay.wallet");
                StringBuilder sb = new StringBuilder();
                sb.append("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=");
                sb.append(URLEncoder.encode(str, str4));
                sb.append("&orderSuffix=");
                sb.append(URLEncoder.encode(str2, str4));
                sb.append("&packageName=");
                sb.append(URLEncoder.encode(str3, str4));
                sb.append("&externalPkgName=");
                sb.append(URLEncoder.encode(str3, str4));
                intent.setData(Uri.parse(sb.toString()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("PayTask:payReuslt: UnsupportedEncodingException:");
                sb2.append(e);
                C1542e.m4631a("msp", sb2.toString());
            }
            if (activity != null) {
                try {
                    activity.startActivity(intent);
                } catch (Throwable unused) {
                    activity.finish();
                }
            }
        }
    }

    /* renamed from: a */
    private static void m4401a(String str) {
        C1491a.f3803b = C1503j.m4442c();
        m4403a(f3801a, str);
    }

    /* renamed from: a */
    private static void m4402a(String str, String str2) {
        C1491a.f3803b = str;
        m4403a(f3801a, str2);
    }

    /* renamed from: a */
    private static void m4399a(Activity activity, int i) {
        new Handler().postDelayed(new C1499f(activity), (long) i);
    }

    /* renamed from: a */
    private static boolean m4403a(HashMap<String, Object> hashMap, String str) {
        if (hashMap == null || str == null) {
            return false;
        }
        Object obj = hashMap.get(str);
        if (obj == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }
}
