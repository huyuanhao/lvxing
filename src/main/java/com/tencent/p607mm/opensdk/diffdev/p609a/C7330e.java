package com.tencent.p607mm.opensdk.diffdev.p609a;

import com.tencent.p607mm.opensdk.utils.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.e */
public final class C7330e {
    /* renamed from: a */
    public static byte[] m31619a(String str) {
        String str2;
        StringBuilder sb;
        String message;
        String str3 = "MicroMsg.SDK.NetUtil";
        if (str == null || str.length() == 0) {
            str2 = "httpGet, url is null";
        } else {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(str);
            try {
                HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), 60000);
                HttpResponse execute = defaultHttpClient.execute(httpGet);
                if (execute.getStatusLine().getStatusCode() == 200) {
                    return EntityUtils.toByteArray(execute.getEntity());
                }
                StringBuilder sb2 = new StringBuilder("httpGet fail, status code = ");
                sb2.append(execute.getStatusLine().getStatusCode());
                Log.m31627e(str3, sb2.toString());
                return null;
            } catch (Exception e) {
                sb = new StringBuilder("httpGet, Exception ex = ");
                message = e.getMessage();
                sb.append(message);
                str2 = sb.toString();
                Log.m31627e(str3, str2);
                return null;
            } catch (IncompatibleClassChangeError e2) {
                sb = new StringBuilder("httpGet, IncompatibleClassChangeError ex = ");
                message = e2.getMessage();
                sb.append(message);
                str2 = sb.toString();
                Log.m31627e(str3, str2);
                return null;
            } catch (Throwable th) {
                sb = new StringBuilder("httpGet, Throwable ex = ");
                message = th.getMessage();
                sb.append(message);
                str2 = sb.toString();
                Log.m31627e(str3, str2);
                return null;
            }
        }
        Log.m31627e(str3, str2);
        return null;
    }
}
