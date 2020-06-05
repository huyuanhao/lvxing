package com.p530ss.android.socialbase.downloader.p563h;

import android.text.TextUtils;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.IMonitorConfig;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadMonitorDepend;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.h.a */
public class DownloadMonitorHelper {
    /* renamed from: a */
    public static void m28177a(IDownloadMonitorDepend aeVar, DownloadInfo cVar, BaseException aVar, int i) {
        if (aeVar != null) {
            try {
                JSONObject a = m28176a(aeVar.mo31738b(), cVar, aVar, i);
                if (a == null) {
                    a = new JSONObject();
                }
                aeVar.mo31737a(a);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    private static JSONObject m28176a(String str, DownloadInfo cVar, BaseException aVar, int i) {
        JSONObject jSONObject;
        String str2;
        String str3;
        String str4;
        int i2;
        try {
            jSONObject = new JSONObject();
            try {
                IMonitorConfig i3 = C6694b.m27377i();
                String str5 = "";
                if (i3 != null) {
                    str4 = i3.mo32070b();
                    try {
                        if (TextUtils.isDigitsOnly(str4)) {
                            str3 = String.valueOf(Long.valueOf(str4).longValue() % 100);
                            str2 = i3.mo32069a();
                            i2 = i3.mo32071c();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    str3 = str5;
                    str2 = i3.mo32069a();
                    i2 = i3.mo32071c();
                } else {
                    str4 = str5;
                    str3 = str4;
                    str2 = str3;
                    i2 = 0;
                }
                jSONObject.put("event_page", str);
                jSONObject.put(ArgKey.KEY_APP_ID, str2);
                jSONObject.put("device_id", str4);
                jSONObject.put("device_id_postfix", str3);
                jSONObject.put("update_version", i2);
                jSONObject.put("download_status", i);
                if (cVar != null) {
                    jSONObject.put("download_id", cVar.mo32283g());
                    jSONObject.put(ArgKey.KEY_NAME, cVar.mo32287h());
                    jSONObject.put("url", cVar.mo32295j());
                    jSONObject.put("download_time", cVar.mo32246aw());
                    jSONObject.put("cur_bytes", cVar.mo32180Z());
                    jSONObject.put("total_bytes", cVar.mo32225ab());
                    jSONObject.put("network_quality", cVar.mo32227ad());
                    int i4 = 1;
                    jSONObject.put("only_wifi", cVar.mo32317x() ? 1 : 0);
                    jSONObject.put("need_https_degrade", cVar.mo32232ai() ? 1 : 0);
                    jSONObject.put("https_degrade_retry_used", cVar.mo32311t() ? 1 : 0);
                    jSONObject.put("md5", cVar.mo32155A());
                    jSONObject.put("chunk_count", cVar.mo32219aV());
                    jSONObject.put("is_force", cVar.mo32179Y() ? 1 : 0);
                    jSONObject.put("retry_count", cVar.mo32158D());
                    jSONObject.put("cur_retry_time", cVar.mo32235al());
                    jSONObject.put("need_retry_delay", cVar.mo32233aj() ? 1 : 0);
                    jSONObject.put("need_reuse_first_connection", cVar.mo32173S() ? 1 : 0);
                    jSONObject.put("default_http_service_backup", cVar.mo32306o() ? 1 : 0);
                    jSONObject.put("retry_delay_status", cVar.mo32240aq().ordinal());
                    jSONObject.put("backup_url_used", cVar.mo32164J() ? 1 : 0);
                    jSONObject.put("download_byte_error_retry_status", cVar.mo32224aa().ordinal());
                    jSONObject.put("forbidden_handler_status", cVar.mo32241ar().ordinal());
                    jSONObject.put("need_independent_process", cVar.mo32174T() ? 1 : 0);
                    jSONObject.put("head_connection_error_msg", cVar.mo32262c() != null ? cVar.mo32262c() : str5);
                    String str6 = "extra";
                    if (cVar.mo32318y() != null) {
                        str5 = cVar.mo32318y();
                    }
                    jSONObject.put(str6, str5);
                    String str7 = "add_listener_to_same_task";
                    if (!cVar.mo32178X()) {
                        i4 = 0;
                    }
                    jSONObject.put(str7, i4);
                    if (cVar.mo32200aC() != null) {
                        jSONObject.put("backup_url_count", cVar.mo32200aC().size());
                        jSONObject.put("cur_backup_url_index", cVar.mo32310s());
                    }
                    if (cVar.mo32162H() != null) {
                        jSONObject.put("forbidden_urls", cVar.mo32162H().toString());
                    }
                }
                if (aVar != null) {
                    jSONObject.put("error_code", aVar.mo32073a());
                    jSONObject.put("error_msg", aVar.mo32076b());
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e3) {
            e = e3;
            jSONObject = null;
            e.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }
}
