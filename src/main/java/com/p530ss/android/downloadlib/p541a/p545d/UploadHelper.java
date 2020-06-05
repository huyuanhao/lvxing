package com.p530ss.android.downloadlib.p541a.p545d;

import android.text.TextUtils;
import android.util.Base64;
import com.p530ss.android.downloadlib.DownloadComponentManager;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import discoveryAD.C7880W.C7881a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a.d.a */
public class UploadHelper {
    /* renamed from: a */
    public static void m26228a(DownloadInfo cVar, long j, String str, String str2) {
        String str3 = "User-Agent";
        if (cVar != null && C6565j.m26371e() != null) {
            try {
                final HashMap hashMap = new HashMap();
                String str4 = C6565j.m26376j().f21040b;
                hashMap.put("from", str4);
                String valueOf = String.valueOf(System.currentTimeMillis());
                hashMap.put(C7881a.TIMESTAMP, valueOf);
                hashMap.put("signature", m26227a(str4, valueOf));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_id", j);
                jSONObject.put("log_extra", str);
                jSONObject.put("download_url", cVar.mo32295j());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_name", cVar.mo32291i());
                jSONObject2.put("package_name", str2);
                jSONObject2.put("package_size", cVar.mo32225ab());
                List B = cVar.mo32156B();
                if (B != null && !B.isEmpty()) {
                    Iterator it = B.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        HttpHeader eVar = (HttpHeader) it.next();
                        if (TextUtils.equals(eVar.mo32429a(), str3)) {
                            jSONObject2.put(str3, eVar.mo32430b());
                            break;
                        }
                    }
                }
                jSONObject.put("request_info", jSONObject2.toString());
                hashMap.put("info", jSONObject.toString());
                DownloadComponentManager.m26440a().mo31386a(new Runnable() {
                    public void run() {
                        C6565j.m26371e().mo16479a("POST", "https://i.snssdk.com/inspect/aegis/client/app/resend/", hashMap, null);
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private static String m26227a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("|");
        sb.append(str2);
        try {
            return Base64.encodeToString(C6587g.m26529a(sb.toString().getBytes(), "596f823f283d4af73ead3ea6".getBytes(), "HmacSHA1"), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
