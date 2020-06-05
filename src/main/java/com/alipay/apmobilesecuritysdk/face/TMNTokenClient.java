package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.apmobilesecuritysdk.p103a.C1436a;
import com.alipay.apmobilesecuritysdk.p108f.C1456b;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.HashMap;

public class TMNTokenClient {
    /* renamed from: a */
    private static TMNTokenClient f3730a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Context f3731b = null;

    /* renamed from: com.alipay.apmobilesecuritysdk.face.TMNTokenClient$InitResultListener */
    public interface InitResultListener {
        void onResult(String str, int i);
    }

    private TMNTokenClient(Context context) {
        if (context != null) {
            this.f3731b = context;
            return;
        }
        throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
    }

    public static TMNTokenClient getInstance(Context context) {
        if (f3730a == null) {
            synchronized (TMNTokenClient.class) {
                if (f3730a == null) {
                    f3730a = new TMNTokenClient(context);
                }
            }
        }
        return f3730a;
    }

    public void intiToken(final String str, String str2, String str3, final InitResultListener initResultListener) {
        String str4 = "";
        if (C1460a.m4260a(str) && initResultListener != null) {
            initResultListener.onResult(str4, 2);
        }
        if (C1460a.m4260a(str2) && initResultListener != null) {
            initResultListener.onResult(str4, 3);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("utdid", UtdidWrapper.getUtdid(this.f3731b));
        hashMap.put("tid", str4);
        hashMap.put("userId", str4);
        hashMap.put(AppEntity.KEY_APP_NAME_STR, str);
        hashMap.put("appKeyClient", str2);
        hashMap.put("appchannel", "openapi");
        hashMap.put("sessionId", str3);
        hashMap.put("rpcVersion", "8");
        C1456b.m4251a().mo12017a((Runnable) new Runnable() {
            public void run() {
                int a = new C1436a(TMNTokenClient.this.f3731b).mo12003a(hashMap);
                InitResultListener initResultListener = initResultListener;
                if (initResultListener != null) {
                    if (a == 0) {
                        initResultListener.onResult(C1436a.m4157a(TMNTokenClient.this.f3731b, str), 0);
                        return;
                    }
                    initResultListener.onResult("", a);
                }
            }
        });
    }
}
