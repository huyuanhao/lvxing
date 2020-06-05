package com.bytedance.sdk.adnet.p161d;

import android.util.Log;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

@Deprecated
/* renamed from: com.bytedance.sdk.adnet.d.b */
public class HTTPSTrustManager {
    @Deprecated
    /* renamed from: a */
    public static void m7937a() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
            HttpsURLConnection.setDefaultSSLSocketFactory(new TLSSocketFactory());
        } catch (Throwable th) {
            Log.e("HTTPSTrustManager", "allowAllSSL error: ", th);
        }
    }
}
