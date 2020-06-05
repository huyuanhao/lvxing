package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.apmobilesecuritysdk.p103a.C1436a;
import com.alipay.apmobilesecuritysdk.p104b.C1437a;
import com.alipay.apmobilesecuritysdk.p107e.C1446a;
import com.alipay.apmobilesecuritysdk.p107e.C1449d;
import com.alipay.apmobilesecuritysdk.p107e.C1452g;
import com.alipay.apmobilesecuritysdk.p107e.C1453h;
import com.alipay.apmobilesecuritysdk.p107e.C1454i;
import com.alipay.apmobilesecuritysdk.p108f.C1456b;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.HashMap;
import java.util.Map;

public class APSecuritySdk {
    /* renamed from: a */
    private static APSecuritySdk f3723a;
    /* renamed from: c */
    private static Object f3724c = new Object();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Context f3725b;

    /* renamed from: com.alipay.apmobilesecuritysdk.face.APSecuritySdk$InitResultListener */
    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    /* renamed from: com.alipay.apmobilesecuritysdk.face.APSecuritySdk$TokenResult */
    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }

    private APSecuritySdk(Context context) {
        this.f3725b = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (f3723a == null) {
            synchronized (f3724c) {
                if (f3723a == null) {
                    f3723a = new APSecuritySdk(context);
                }
            }
        }
        return f3723a;
    }

    public static String getUtdid(Context context) {
        return UtdidWrapper.getUtdid(context);
    }

    public String getApdidToken() {
        String a = C1436a.m4157a(this.f3725b, "");
        if (C1460a.m4260a(a)) {
            initToken(0, new HashMap(), null);
        }
        return a;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public String getSdkVersion() {
        return "3.3.0.1905151001";
    }

    public synchronized TokenResult getTokenResult() {
        TokenResult tokenResult;
        tokenResult = new TokenResult();
        try {
            tokenResult.apdidToken = C1436a.m4157a(this.f3725b, "");
            tokenResult.clientKey = C1453h.m4225f(this.f3725b);
            tokenResult.apdid = C1436a.m4156a(this.f3725b);
            tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.f3725b);
            if (C1460a.m4260a(tokenResult.apdid) || C1460a.m4260a(tokenResult.apdidToken) || C1460a.m4260a(tokenResult.clientKey)) {
                initToken(0, new HashMap(), null);
            }
        } catch (Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i, Map<String, String> map, final InitResultListener initResultListener) {
        C1437a.m4163a().mo12004a(i);
        String b = C1453h.m4217b(this.f3725b);
        String c = C1437a.m4163a().mo12006c();
        if (C1460a.m4263b(b) && !C1460a.m4261a(b, c)) {
            C1446a.m4185a(this.f3725b);
            C1449d.m4192a(this.f3725b);
            C1452g.m4210a(this.f3725b);
            C1454i.m4246h();
        }
        if (!C1460a.m4261a(b, c)) {
            C1453h.m4219c(this.f3725b, c);
        }
        String str = "utdid";
        String str2 = "";
        String a = C1460a.m4259a(map, str, str2);
        String str3 = "tid";
        String a2 = C1460a.m4259a(map, str3, str2);
        String str4 = "userId";
        String a3 = C1460a.m4259a(map, str4, str2);
        if (C1460a.m4260a(a)) {
            a = UtdidWrapper.getUtdid(this.f3725b);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(str, a);
        hashMap.put(str3, a2);
        hashMap.put(str4, a3);
        hashMap.put(AppEntity.KEY_APP_NAME_STR, str2);
        hashMap.put("appKeyClient", str2);
        hashMap.put("appchannel", str2);
        hashMap.put("rpcVersion", "8");
        C1456b.m4251a().mo12017a((Runnable) new Runnable() {
            public void run() {
                new C1436a(APSecuritySdk.this.f3725b).mo12003a(hashMap);
                InitResultListener initResultListener = initResultListener;
                if (initResultListener != null) {
                    initResultListener.onResult(APSecuritySdk.this.getTokenResult());
                }
            }
        });
    }
}
